package com.gooagoo.current.sub.tidy;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisHashDao;

public class AnalysisUserBrowseTest
{
    AnalysisUserBrowse analysisUserBrowse = new AnalysisUserBrowse();

    @Before
    public void setUp() throws Exception
    {
    }

    public void watchGoods()
    {
        RedisHashDao dao = new RedisHashDao(RedisServerConstants.business_goods);
        RedisDatabase base = new RedisDatabase(RedisServerConstants.business_goods);
        Set<String> keys = base.keys("*");
        for (String key : keys)
        {
            Map<String, String> map = dao.get(key);
            System.out.println("key : " + key + " map : " + map);
        }
    }

    public void watchCoupon()
    {
        RedisHashDao dao = new RedisHashDao(RedisServerConstants.business_coupon);
        RedisDatabase base = new RedisDatabase(RedisServerConstants.business_coupon);
        Set<String> keys = base.keys("*");
        for (String key : keys)
        {
            Map<String, String> map = dao.get(key);
            System.out.println(key + " : " + map);
        }
    }

    @Test
    public void test()
    {
        //测试使用userId  01822N0IJLPA8N700C5V4PBJ43P1R5JO
        BehaveLog behaveLog = new BehaveLog();
        behaveLog.setUserId("00017UHS0Q27OSCS80000EJ5IGBSC00J");
        behaveLog.setCreateTime(new Date());
        behaveLog.setSource("W");
        //this.goods(behaveLog);
        this.acitve(behaveLog);
        //this.getCoupon(behaveLog);
        //this.goods(behaveLog);
        //this.getGoods(behaveLog);
        this.analysisUserBrowse.message(behaveLog);
    }

    private void getCoupon(BehaveLog behaveLog)
    {
        this.coupon1(behaveLog);
    }

    private void coupon1(BehaveLog behaveLog)
    {
        //BehaveLog behaveLog = new BehaveLog();
        behaveLog.setObjectType("C");
        behaveLog.setRemoteCode("gusm04");
        behaveLog.setObjectValue("0182AUR03BA4QRG0SR22DEEIISWR2K1N");
        behaveLog.setShopId("01822MAPVKNP054085QBQVEIISWR0JGT");
    }

    private void coupon2(BehaveLog behaveLog)
    {
        behaveLog.setRemoteCode("gusm04");
        behaveLog.setObjectValue("00017Q9QHK01H1NCL00002SXUXJ1T001");
        behaveLog.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
    }

    private void coupon3(BehaveLog behaveLog)
    {
        behaveLog.setRemoteCode("gusm04");
        behaveLog.setObjectValue("00017R5VL2O3DO2JL0049AEIISX8Q016");
        behaveLog.setShopId("00017R5UOT5LHB4EO000LOEIISX8401B");
    }

    private void acitve(BehaveLog behaveLog)
    {
        behaveLog.setRemoteCode("gusm02");
        behaveLog.setObjectType("A");
        behaveLog.setObjectValue("0182IIRCA72VPJE0584F37EIISWR2647");
        behaveLog.setShopId("01822IE57DH111M085QBPFEIISWR0JGT");
    }

    private void getGoods(BehaveLog behaveLog)
    {

        this.goods1(behaveLog);

    }

    private void goods1(BehaveLog behaveLog)
    {
        behaveLog.setRemoteCode("gusm07");
        behaveLog.setObjectType("G");
        behaveLog.setObjectValue("018238QC4F1FIUS02VLL3QEIISWR2TKG");
        behaveLog.setShopId("01822MAPVKNP054085QBQVEIISWR0JGT");
    }

    private void goods2(BehaveLog behaveLog)
    {
        behaveLog.setRemoteCode("gusm07");
        behaveLog.setObjectValue("018237A6NN9JUJN02VLL3JEIISWR2TKG");
        behaveLog.setShopId("01822MAPVKNP054085QBQVEIISWR0JGT");
    }

    private void goods3(BehaveLog behaveLog)
    {
        behaveLog.setRemoteCode("gusm07");
        behaveLog.setObjectValue("00018236KHL8HCRP1000I6EIISWR40R0");
        behaveLog.setShopId("01822MAPVKNP054085QBQVEIISWR0JGT");
    }

    //@Autowired
    //GoodsBaseInfoMapper goodsBaseInfoMapper;

    @Test
    public void del()
    {

    }

}
