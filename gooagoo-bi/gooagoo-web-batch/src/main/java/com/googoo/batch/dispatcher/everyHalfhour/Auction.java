package com.googoo.batch.dispatcher.everyHalfhour;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.gooagoo.api.business.core.system.SystemBusinessCoreService;
import com.gooagoo.api.business.core.system.bid.SysShopBidCoreService;
import com.gooagoo.api.generator.query.sys.AdsManageGeneratorQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.entity.generator.sys.AdsManageExample;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.googoo.batch.constants.BatchTimeCnstants;

@Engine(BatchTimeCnstants.everyHalfhour)
public class Auction implements Tyre
{
    private final AdsManageGeneratorQueryService adsQueryService = SpringBeanUtils.getBean(AdsManageGeneratorQueryService.class);

    public static List<String> queue = new ArrayList<String>(); //任务队列

    public static synchronized boolean addQueue(String id)
    {
        if (!queue.contains(id))
        {
            queue.add(id);
            return true;
        }
        else
        {
            return false;
        }
    }

    private void removePublishEd()
    {
        for (String id : queue)
        {
            AdsManage adsManage = this.adsQueryService.selectByPrimaryKey(id);
            if (!"0".equals(adsManage.getState()) && !"1".equals(adsManage.getState()))
            {
                queue.remove(id);
            }
        }
    }

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 Auction");
        this.removePublishEd();

        SystemBusinessCoreService service = SpringBeanUtils.getBean(SystemBusinessCoreService.class);
        Date sysTime = service.getCoreSysCurrentTime();
        GooagooLog.debug("数据库服务器时间:" + TimeUtils.convertDateToString(sysTime, TimeUtils.FORMAT1));
        Timer timer = new Timer();
        Calendar cal = Calendar.getInstance();
        cal.setTime(sysTime);
        cal.add(Calendar.HOUR_OF_DAY, 1);//加时
        Date after = cal.getTime();

        AdsManageExample adsManageExample = new AdsManageExample();
        adsManageExample.createCriteria().andStateEqualTo("1").andBidEndTimeBetween(new Date(), after).andIsDelEqualTo("N");
        List<AdsManage> adsManages = this.adsQueryService.selectByExample(adsManageExample);
        GooagooLog.debug("AdsManage查出 " + adsManages.size() + "条数据");
        for (AdsManage adsManage : adsManages)
        {
            AuctionJob publishJob = new AuctionJob(adsManage);
            if (addQueue(adsManage.getBidId()))
            {
                Calendar endTime = Calendar.getInstance();
                endTime.setTime(adsManage.getBidEndTime());
                endTime.add(Calendar.MINUTE, 1);//+3分钟
                timer.schedule(publishJob, endTime.getTime());
            }
        }
    }
}

class AuctionJob extends TimerTask
{

    private final AdsManage adsManage;

    public AuctionJob(AdsManage adsManage)
    {
        this.adsManage = adsManage;
    }

    @Override
    public void run()
    {
        try
        {
            GooagooLog.debug("广告位:" + adsManage.getBidId());
            SysShopBidCoreService bidCoreService = SpringBeanUtils.getBean(SysShopBidCoreService.class);
            boolean result = bidCoreService.batchShopBid(this.adsManage);
            GooagooLog.debug("返回结果" + result);
        }
        catch (Exception e)
        {
            GooagooLog.error("竞拍跑批", e);
        }
    }
}
