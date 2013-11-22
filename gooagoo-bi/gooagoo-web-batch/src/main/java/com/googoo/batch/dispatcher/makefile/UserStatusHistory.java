package com.googoo.batch.dispatcher.makefile;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.gooagoo.api.business.query.statistics.InteractiveQueryService;
import com.gooagoo.api.business.query.statistics.ShopEntityPeopleStatisticsQueryService;
import com.gooagoo.api.business.query.statistics.ShopPeopleStatisticsQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfoExample.Criteria;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.vo.hightChartVo.chartVo.StockChartVo;
import com.googoo.batch.constants.BatchConsants;
import com.googoo.batch.utils.FileUtils;

//@Engine(BatchTimeCnstants.onMidnight)
public class UserStatusHistory implements Tyre
{
    private final ShopInfoGeneratorQueryService shopInfoGeneratorQueryService = SpringBeanUtils.getBean(ShopInfoGeneratorQueryService.class);
    private final ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService = SpringBeanUtils.getBean(ShopEntityInfoGeneratorQueryService.class);
    private final ShopPeopleStatisticsQueryService shopPeopleStatisticsService = SpringBeanUtils.getBean(ShopPeopleStatisticsQueryService.class);
    private final ShopEntityPeopleStatisticsQueryService shopEntityPeopleStatisticsService = SpringBeanUtils.getBean(ShopEntityPeopleStatisticsQueryService.class);
    private final InteractiveQueryService interactiveService = SpringBeanUtils.getBean(InteractiveQueryService.class);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 UserStatusHistory");
        this.inStroeNoMember();
        this.inStroeMember();
        this.phoneInteractionUser();
        this.phoneInteractionMember();
        this.webInteractionUser();
        this.webInteractionMember();
    }

    /**
     * 店内非会员
     */
    private void inStroeNoMember()
    {
        List<ShopInfo> shopList = this.findShopInfo();
        List<ShopEntityInfo> shopEntityInfoList = this.findShopEntityList();
        Map<String, List<List<Object>>> dataMap = new HashMap<String, List<List<Object>>>();
        List<List<Object>> dataList = new ArrayList<List<Object>>();
        List<Object> objects = null;
        for (ShopInfo shopInfo : shopList)
        {
            for (int i = 1; i < BatchConsants.USER_RECORD_COUNT; i++)
            {
                objects = new ArrayList<Object>(0);
                Date dateTime = this.getDate(-i);
                long time = dateTime.getTime();
                int num = this.shopPeopleStatisticsService.findArriveShopPeopleNum(shopInfo.getShopId(), "D", "N", dateTime);
                objects.add(time);
                objects.add(num);
                dataList.add(objects);
            }
            dataMap.put("店内非会员用户", dataList);
            StockChartVo chartVo = new StockChartVo();
            String create = chartVo.create("店内非会员统计", dataMap);
            //String fileName = this.getFileName(shopInfo.getShopId(), "M", "inStroeNoMember");
            String fileName = FileUtils.getfileName(shopInfo.getShopId(), "D", "N", null, null);
            FileUtils.createAndWriteFile(BatchConsants.USER_RECORD, create, fileName);
        }

        for (ShopEntityInfo entity : shopEntityInfoList)
        {
            for (int i = 1; i < BatchConsants.USER_RECORD_COUNT; i++)
            {
                objects = new ArrayList<Object>(0);
                Date dateTime = this.getDate(-i);
                long time = dateTime.getTime();
                int num = this.shopEntityPeopleStatisticsService.findEntityPeopleNum(entity.getShopEntityId(), "N");
                objects.add(time);
                objects.add(num);
                dataList.add(objects);
            }
            dataMap.put("店内非会员用户", dataList);
            StockChartVo chartVo = new StockChartVo();
            String create = chartVo.create("店内非会员统计", dataMap);
            //String fileName = this.getFileName(entity.getShopEntityId(), "N", "inStroeNoMember");
            String fileName = FileUtils.getfileName(entity.getShopEntityId(), "D", "N", null, null);
            FileUtils.createAndWriteFile(BatchConsants.USER_RECORD, create, fileName);
        }

    }

    /**
     * 店内会员
     */
    private void inStroeMember()
    {
        List<ShopInfo> shopList = this.findShopInfo();
        List<ShopEntityInfo> shopEntityInfoList = this.findShopEntityList();
        Map<String, List<List<Object>>> dataMap = new HashMap<String, List<List<Object>>>();
        List<List<Object>> dataList = new ArrayList<List<Object>>();
        List<Object> objects = null;
        for (ShopInfo shopInfo : shopList)
        {
            for (int i = 1; i < BatchConsants.USER_RECORD_COUNT; i++)
            {
                objects = new ArrayList<Object>(0);
                Date dateTime = this.getDate(-i);
                long time = dateTime.getTime();
                int num = this.shopPeopleStatisticsService.findArriveShopPeopleNum(shopInfo.getShopId(), "D", "M", dateTime);
                objects.add(time);
                objects.add(num);
                dataList.add(objects);
            }
            dataMap.put("店内会员用户", dataList);
            StockChartVo chartVo = new StockChartVo();
            String create = chartVo.create("店内会员统计", dataMap);
            //String fileName = this.getFileName(shopInfo.getShopId(), "M", "inStroeMember");
            String fileName = FileUtils.getfileName(shopInfo.getShopId(), "D", "M", null, null);
            FileUtils.createAndWriteFile(BatchConsants.USER_RECORD, create, fileName);
        }

        for (ShopEntityInfo entity : shopEntityInfoList)
        {
            for (int i = 1; i < BatchConsants.USER_RECORD_COUNT; i++)
            {
                objects = new ArrayList<Object>(0);
                Date dateTime = this.getDate(-i);
                long time = dateTime.getTime();
                int num = this.shopEntityPeopleStatisticsService.findEntityPeopleNum(entity.getShopEntityId(), "M");
                objects.add(time);
                objects.add(num);
                dataList.add(objects);
            }
            dataMap.put("店内会员用户", dataList);
            StockChartVo chartVo = new StockChartVo();
            String create = chartVo.create("店内会员统计", dataMap);
            //String fileName = this.getFileName(entity.getShopEntityId(), "M", "inStroeMember");
            String fileName = FileUtils.getfileName(entity.getShopEntityId(), "D", "M", null, null);
            FileUtils.createAndWriteFile(BatchConsants.USER_RECORD, create, fileName);
        }
    }

    /**
     * 手机互动用户
     */
    private void phoneInteractionUser()
    {
        List<ShopInfo> shopList = this.findShopInfo();
        List<ShopEntityInfo> shopEntityInfoList = this.findShopEntityList();
        Map<String, List<List<Object>>> dataMap = new HashMap<String, List<List<Object>>>();
        List<List<Object>> dataList = new ArrayList<List<Object>>();
        List<Object> objects = null;
        for (ShopInfo shopInfo : shopList)
        {
            for (int i = 1; i < BatchConsants.USER_RECORD_COUNT; i++)
            {
                objects = new ArrayList<Object>(0);
                Date dateTime = this.getDate(-i);
                long time = dateTime.getTime();
                int num = this.interactiveService.findPhoneInterPeopleNum(shopInfo.getShopId(), "D", "A", dateTime);
                objects.add(time);
                objects.add(num);
                dataList.add(objects);
            }
            dataMap.put("手机互动用户统计", dataList);
            StockChartVo chartVo = new StockChartVo();
            String create = chartVo.create("手机互动用户", dataMap);
            //String fileName = this.getFileName(shopInfo.getShopId(), "A", "phoneInteractionUser");
            String fileName = FileUtils.getfileName(shopInfo.getShopId(), "D", "A", null, "M");
            FileUtils.createAndWriteFile(BatchConsants.USER_RECORD, create, fileName);
        }

        for (ShopEntityInfo entity : shopEntityInfoList)
        {
            for (int i = 1; i < BatchConsants.USER_RECORD_COUNT; i++)
            {
                objects = new ArrayList<Object>(0);
                Date dateTime = this.getDate(-i);
                long time = dateTime.getTime();
                int num = this.interactiveService.findPhoneInterPeopleNum(entity.getShopEntityId(), "D", "A", dateTime);
                objects.add(time);
                objects.add(num);
                dataList.add(objects);
            }
            dataMap.put("手机互动用户统计", dataList);
            StockChartVo chartVo = new StockChartVo();
            String create = chartVo.create("手机互动用户", dataMap);
            //String fileName = this.getFileName(entity.getShopEntityId(), "A", "phoneInteractionUser");
            String fileName = FileUtils.getfileName(entity.getShopEntityId(), "D", "A", null, "M");
            FileUtils.createAndWriteFile(BatchConsants.USER_RECORD, create, fileName);
        }
    }

    /**
     * 手机互动会员
     */
    private void phoneInteractionMember()
    {
        List<ShopInfo> shopList = this.findShopInfo();
        List<ShopEntityInfo> shopEntityInfoList = this.findShopEntityList();
        Map<String, List<List<Object>>> dataMap = new HashMap<String, List<List<Object>>>();
        List<List<Object>> dataList = new ArrayList<List<Object>>();
        List<Object> objects = null;
        for (ShopInfo shopInfo : shopList)
        {
            for (int i = 1; i < BatchConsants.USER_RECORD_COUNT; i++)
            {
                objects = new ArrayList<Object>(0);
                Date dateTime = this.getDate(-i);
                long time = dateTime.getTime();
                int num = this.interactiveService.findPhoneInterPeopleNum(shopInfo.getShopId(), "D", "M", dateTime);
                objects.add(time);
                objects.add(num);
                dataList.add(objects);
            }
            dataMap.put("手机互动会员统计", dataList);
            StockChartVo chartVo = new StockChartVo();
            String create = chartVo.create("手机互动会员", dataMap);
            //String fileName = this.getFileName(shopInfo.getShopId(), "M", "phoneInteractionMember");
            String fileName = FileUtils.getfileName(shopInfo.getShopId(), "D", "M", null, "M");
            FileUtils.createAndWriteFile(BatchConsants.USER_RECORD, create, fileName);
        }

        for (ShopEntityInfo entity : shopEntityInfoList)
        {
            for (int i = 1; i < BatchConsants.USER_RECORD_COUNT; i++)
            {
                objects = new ArrayList<Object>(0);
                Date dateTime = this.getDate(-i);
                long time = dateTime.getTime();
                int num = this.interactiveService.findPhoneInterPeopleNum(entity.getShopEntityId(), "D", "M", dateTime);
                objects.add(time);
                objects.add(num);
                dataList.add(objects);
            }
            dataMap.put("手机互动会员统计", dataList);
            StockChartVo chartVo = new StockChartVo();
            String create = chartVo.create("手机互动会员", dataMap);
            //String fileName = this.getFileName(entity.getShopEntityId(), "M", "phoneInteractionMember");
            String fileName = FileUtils.getfileName(entity.getShopEntityId(), "D", "M", null, "M");
            FileUtils.createAndWriteFile(BatchConsants.USER_RECORD, create, fileName);
        }
    }

    /**
     * 店外Web互动用户
     */
    private void webInteractionUser()
    {
        List<ShopInfo> shopList = this.findShopInfo();
        List<ShopEntityInfo> shopEntityInfoList = this.findShopEntityList();
        Map<String, List<List<Object>>> dataMap = new HashMap<String, List<List<Object>>>();
        List<List<Object>> dataList = new ArrayList<List<Object>>();
        List<Object> objects = null;
        for (ShopInfo shopInfo : shopList)
        {
            for (int i = 1; i < BatchConsants.USER_RECORD_COUNT; i++)
            {
                objects = new ArrayList<Object>(0);
                Date dateTime = this.getDate(-i);
                long time = dateTime.getTime();
                int num = this.interactiveService.findWebInterPeopleNum(shopInfo.getShopId(), "D", "A", dateTime);
                objects.add(time);
                objects.add(num);
                dataList.add(objects);
            }
            dataMap.put("网店互动用户统计", dataList);
            StockChartVo chartVo = new StockChartVo();
            String create = chartVo.create("网店互动用户", dataMap);
            //String fileName = this.getFileName(shopInfo.getShopId(), "A", "webInteractionUser");
            String fileName = FileUtils.getfileName(shopInfo.getShopId(), "D", "A", null, "W");
            FileUtils.createAndWriteFile(BatchConsants.USER_RECORD, create, fileName);
        }

        for (ShopEntityInfo entity : shopEntityInfoList)
        {
            for (int i = 1; i < BatchConsants.USER_RECORD_COUNT; i++)
            {
                objects = new ArrayList<Object>(0);
                Date dateTime = this.getDate(-i);
                long time = dateTime.getTime();
                int num = this.interactiveService.findWebInterPeopleNum(entity.getShopEntityId(), "D", "A", dateTime);
                objects.add(time);
                objects.add(num);
                dataList.add(objects);
            }
            dataMap.put("网店互动用户统计", dataList);
            StockChartVo chartVo = new StockChartVo();
            String create = chartVo.create("网店互动用户", dataMap);
            //String fileName = this.getFileName(entity.getShopEntityId(), "A", "webInteractionUser");
            String fileName = FileUtils.getfileName(entity.getShopEntityId(), "D", "A", null, "W");
            FileUtils.createAndWriteFile(BatchConsants.USER_RECORD, create, fileName);
        }
    }

    /**
     * 店外Web互动会员
     */
    private void webInteractionMember()
    {
        List<ShopInfo> shopList = this.findShopInfo();
        List<ShopEntityInfo> shopEntityInfoList = this.findShopEntityList();
        Map<String, List<List<Object>>> dataMap = new HashMap<String, List<List<Object>>>();
        List<List<Object>> dataList = new ArrayList<List<Object>>();
        List<Object> objects = null;
        for (ShopInfo shopInfo : shopList)
        {
            for (int i = 1; i < BatchConsants.USER_RECORD_COUNT; i++)
            {
                objects = new ArrayList<Object>(0);
                Date dateTime = this.getDate(-i);
                long time = dateTime.getTime();
                int num = this.interactiveService.findWebInterPeopleNum(shopInfo.getShopId(), "D", "M", dateTime);
                objects.add(time);
                objects.add(num);
                dataList.add(objects);
            }
            dataMap.put("网店互动会员统计", dataList);
            StockChartVo chartVo = new StockChartVo();
            String create = chartVo.create("网店互动会员", dataMap);
            //String fileName = this.getFileName(shopInfo.getShopId(), "M", "webInteractionMember");
            String fileName = FileUtils.getfileName(shopInfo.getShopId(), "D", "M", null, "W");
            FileUtils.createAndWriteFile(BatchConsants.USER_RECORD, create, fileName);
        }

        for (ShopEntityInfo entity : shopEntityInfoList)
        {
            for (int i = 1; i < BatchConsants.USER_RECORD_COUNT; i++)
            {
                objects = new ArrayList<Object>(0);
                Date dateTime = this.getDate(-i);
                long time = dateTime.getTime();
                int num = this.interactiveService.findWebInterPeopleNum(entity.getShopEntityId(), "D", "M", dateTime);
                objects.add(time);
                objects.add(num);
                dataList.add(objects);
            }
            dataMap.put("网店互动会员统计", dataList);
            StockChartVo chartVo = new StockChartVo();
            String create = chartVo.create("网店互动会员", dataMap);
            //String fileName = this.getFileName(entity.getShopEntityId(), "M", "webInteractionMember");
            String fileName = FileUtils.getfileName(entity.getShopEntityId(), "D", "M", null, "W");
            FileUtils.createAndWriteFile(BatchConsants.USER_RECORD, create, fileName);
        }
    }

    /**
     * 查询所有商家信息
     */
    private List<ShopInfo> findShopInfo()
    {
        ShopInfoExample shopInfoExample = new ShopInfoExample();
        Criteria createCriteria = shopInfoExample.createCriteria();
        createCriteria.andIsDelEqualTo("N");
        createCriteria.andShopStatusEqualTo("U");
        List<ShopInfo> shopInfoList = this.shopInfoGeneratorQueryService.selectByExample(shopInfoExample);
        return shopInfoList;
    }

    private List<ShopEntityInfo> findShopEntityList()
    {
        List<ShopEntityInfo> allList = new ArrayList<ShopEntityInfo>();
        ShopInfoExample shopInfoExample = new ShopInfoExample();
        Criteria createCriteria = shopInfoExample.createCriteria();
        createCriteria.andIsDelEqualTo("N");
        createCriteria.andShopStatusEqualTo("U");
        List<ShopInfo> shopInfoList = this.shopInfoGeneratorQueryService.selectByExample(shopInfoExample);
        for (ShopInfo shopInfo : shopInfoList)
        {
            ShopEntityInfoExample shopEntityInfoExample = new ShopEntityInfoExample();
            shopEntityInfoExample.createCriteria().andIsDelEqualTo("N");
            shopEntityInfoExample.createCriteria().andShopEntityIdEqualTo(shopInfo.getShopId());
            List<ShopEntityInfo> selectByExample = this.shopEntityInfoGeneratorQueryService.selectByExample(shopEntityInfoExample);
            allList.addAll(selectByExample);
        }
        return allList;
    }

    /**
     * 获取时间
     * @param amount
     * @return
     */
    private Date getDate(int amount)
    {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.add(Calendar.DAY_OF_MONTH, 500);
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        return calendar.getTime();
    }

}