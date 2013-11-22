package com.gooagoo.igms.shopinfo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.statistics.ConsumeStatisticQueryService;
import com.gooagoo.api.business.query.statistics.InteractiveQueryService;
import com.gooagoo.api.business.query.statistics.ShopEntityPeopleStatisticsQueryService;
import com.gooagoo.api.business.query.statistics.ShopPeopleStatisticsQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.igms.member.service.MemberService;
import com.gooagoo.igms.shopinfo.service.MenuDataService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;

@Service("menuDataService")
public class MenuDataServiceImpl implements MenuDataService
{
    @Autowired
    private ConsumeStatisticQueryService consumeStatisticService;

    @Autowired
    private ShopPeopleStatisticsQueryService shopPeopleStatisticsService;
    @Autowired
    private ShopEntityPeopleStatisticsQueryService shopEntityPeopleStatisticsService;

    @Autowired
    private InteractiveQueryService interactiveService;

    @Autowired
    private ShopLoginService shopLoginService;

    @Autowired
    private MemberService memberService;

    @Override
    public TransData<List<Long>> getLeftMenuData(HttpServletRequest request) throws Exception
    {
        // 0-总消费人数,1-总会员人数,2-总非会员消费次数,3-总会员消费次数
        String shopIdOrEntityId = null;
        List<Long> list = new ArrayList<Long>();
        ShopLoginInfo gmsLoginInfo = this.shopLoginService.getShopLoginInfo(request);
        if (StringUtils.hasText(gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId()))
        {
            shopIdOrEntityId = gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId();
        }
        else
        {
            shopIdOrEntityId = gmsLoginInfo.getShopAndUserInfo().getShopId();
        }
       
        Date date = null;
        //获取总消费人数
        int consumeNums = this.consumeStatisticService.consumeNums(shopIdOrEntityId, "", "A", date);
        this.printLog("consumeTimes = this.consumeStatisticService.consumeNums(shopIdOrEntityId, '', userType, date)", shopIdOrEntityId + "," + "A" + "," + date, consumeNums);
        list.add((long)consumeNums);
        
        // 获取会员总人数
        TransData<Integer> memberCount = this.memberService.memberCount(request);
        list.add((long) memberCount.getData());
        this.printLog("memberCount = this.memberService.memberCount(request)", gmsLoginInfo.getShopAndUserInfo().getShopId(), (long) memberCount.getData());
        
        //获取会员和非会员消费次数
        String[] userTypeArray = {"M", "N" };
        for (String userType : userTypeArray)
        {
            int consumeTimes = this.consumeStatisticService.consumeTimes(shopIdOrEntityId, "", userType, date);
            list.add((long) consumeTimes);

            this.printLog("consumeTimes = this.consumeStatisticService.consumeTimes(shopIdOrEntityId, '', userType, date)", shopIdOrEntityId + "," + userType + "," + date, consumeTimes);
        }
       

        return GMSUtil.toTransData(true, null, list);
    }

    @Override
    public TransData<List<Long>> getRightMenuData(HttpServletRequest request) throws Exception
    {
        List<Long> dataList = new ArrayList<Long>(0);
        ShopLoginInfo shopLoginInfo = this.shopLoginService.getShopLoginInfo(request);
        boolean flag = shopLoginInfo != null && shopLoginInfo.getShopAndUserInfo() != null;
        int inStoreUser = 0;
        int inStoreMember = 0;
        int phonePotentialMember = 0;
        int webPotentialMember = 0;
        int addMember = 0;
        int inStorePotentialMember = 0;
        int webInterMember = 0;
        int phoneInterMember = 0;
        Date date = null;
        String shopId = shopLoginInfo.getShopAndUserInfo().getShopId();
        String shopEntityId = shopLoginInfo.getShopAndUserInfo().getUserShopEntityId();
        if (flag && StringUtils.hasText(shopEntityId))
        {
            inStoreUser = this.shopEntityPeopleStatisticsService.findEntityPeopleNum(shopEntityId, "A");
            inStoreMember = this.shopEntityPeopleStatisticsService.findEntityPeopleNum(shopEntityId, "M");
            phonePotentialMember = this.interactiveService.findPhoneInterPeopleNum(shopEntityId, "", "N", date);
            webPotentialMember = this.interactiveService.findWebInterPeopleNum(shopEntityId, "", "N", date);
            addMember = this.shopPeopleStatisticsService.findShopAddPeopleNum(shopEntityId, "M", TimeUtils.getZeroHourOfDate(new Date()),new Date());
            inStorePotentialMember = this.shopEntityPeopleStatisticsService.findEntityPeopleNum(shopEntityId, "N");
            webInterMember = this.interactiveService.findWebInterPeopleNum(shopEntityId, "", "M", date);
            phoneInterMember = this.interactiveService.findPhoneInterPeopleNum(shopEntityId, "", "M", date);

            this.printLog("inStoreUser=this.shopEntityPeopleStatisticsService.findEntityPeopleNum(shopEntityId, 'A')", shopEntityId, inStoreUser);
            this.printLog("inStoreMember = this.shopEntityPeopleStatisticsService.findEntityPeopleNum(shopEntityId, 'M')", shopEntityId, inStoreMember);
            this.printLog("phonePotentialMember = this.interactiveService.findPhoneInterPeopleNum(shopEntityId, '', 'N', date)", shopEntityId + "," + date, phonePotentialMember);
            this.printLog("webPotentialMember = this.interactiveService.findWebInterPeopleNum(shopEntityId, '', 'N', date)", shopEntityId + "," + date, webPotentialMember);
            this.printLog("addMember = this.shopPeopleStatisticsService.findShopAddPeopleNum(shopEntityId, '', 'M', date, date)", shopEntityId + ","+TimeUtils.getZeroHourOfDate(new Date())+ "," + date, addMember);
            this.printLog("inStorePotentialMember = this.shopEntityPeopleStatisticsService.findEntityPeopleNum(shopEntityId, 'N')", shopEntityId, inStorePotentialMember);
            this.printLog("webInterMember = this.interactiveService.findWebInterPeopleNum(shopEntityId, '', 'M', date)", shopEntityId + "," + date, webInterMember);
            this.printLog("phoneInterMember = this.interactiveService.findPhoneInterPeopleNum(shopEntityId, '', 'M', date)", shopEntityId + "," + date, phoneInterMember);
        }
        else
        {
            inStoreUser = this.shopPeopleStatisticsService.findAllEntityPeopleNum(shopId, "A");
            inStoreMember = this.shopPeopleStatisticsService.findAllEntityPeopleNum(shopId, "M");
            phonePotentialMember = this.interactiveService.findPhoneInterPeopleNum(shopId, "", "A", date);
            webPotentialMember = this.interactiveService.findWebInterPeopleNum(shopId, "", "A", date);
            addMember = this.shopPeopleStatisticsService.findShopAddPeopleNum(shopId, "M", TimeUtils.getZeroHourOfDate(new Date()),new Date());
            inStorePotentialMember = this.shopEntityPeopleStatisticsService.findEntityPeopleNum(shopId, "N");
            webInterMember = this.interactiveService.findWebInterPeopleNum(shopId, "", "M", date);
            phoneInterMember = this.interactiveService.findPhoneInterPeopleNum(shopId, "", "M", date);

            this.printLog("inStoreUser=this.shopEntityPeopleStatisticsService.findAllEntityPeopleNum(shopId, 'A')", shopId, inStoreUser);
            this.printLog("inStoreMember = this.shopEntityPeopleStatisticsService.findAllEntityPeopleNum(shopId, 'M')", shopId, inStoreMember);
            this.printLog("phonePotentialMember = this.interactiveService.findPhoneInterPeopleNum(shopId, '', 'A', date)", shopId + "," + date, phonePotentialMember);
            this.printLog("webPotentialMember = this.interactiveService.findWebInterPeopleNum(shopId, '', 'A', date)", shopId + "," + date, webPotentialMember);
            this.printLog("addMember = this.shopPeopleStatisticsService.findShopAddPeopleNum(shopId, '', 'M', date, date)", shopId + "," +TimeUtils.getZeroHourOfDate(new Date())+"," +date, addMember);
            this.printLog("inStorePotentialMember = this.shopEntityPeopleStatisticsService.findEntityPeopleNum(shopId, 'N')", shopId, inStorePotentialMember);
            this.printLog("webInterMember = this.interactiveService.findWebInterPeopleNum(shopId, '', 'M', date)", shopId + "," + date, webInterMember);
            this.printLog("phoneInterMember = this.interactiveService.findPhoneInterPeopleNum(shopId, '', 'M', date)", shopId + "," + date, phoneInterMember);
        }
        dataList.add((long) inStoreUser);
        dataList.add((long) inStoreMember);
        dataList.add((long) phonePotentialMember);
        dataList.add((long) webPotentialMember);
        dataList.add((long) addMember);
        dataList.add((long) inStorePotentialMember);
        dataList.add((long) webInterMember);
        dataList.add((long) phoneInterMember);
        return GMSUtil.toTransData(true, null, dataList);
    }

    private void printLog(String name, String paras, Object result)
    {
        GooagooLog.info("name:[" + name + "],paras:[" + paras + "],result:[" + result + "]");
    }
}
