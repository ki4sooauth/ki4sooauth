package com.gooagoo.query.business.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.RecordStatisticQueryService;
import com.gooagoo.api.business.query.statistics.StatisticAnalysisService;
import com.gooagoo.constants.AnalysisTypeConstants;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.entity.business.statistics.ChartVo;
import com.gooagoo.entity.business.statistics.ColumnVO;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.utils.AnalysisUtils;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

@Service
public class RecordStatisticQueryServiceImpl implements RecordStatisticQueryService
{

    private final DB db = MongoDBUtils.getDB(MongoConstants.MONGO_URL, MongoConstants.analysisDB);

    @Autowired
    private StatisticAnalysisService statisticAnalysisService;

    @Override
    public ChartVo memberFeatureStatistic(String copId, List<Account> userList, String featureCode)
    {
        ChartVo cvo = null;
        cvo = this.analysisByFeature(copId, userList, featureCode);
        return cvo;
    }

    @Override
    public ChartVo memberStatisticService(String shopId, List<Account> people, String statistics)
    {
        ChartVo cvo = null;
        if (AnalysisTypeConstants.AGE == statistics || AnalysisTypeConstants.AGE.equals(statistics))
        {
            cvo = this.analysisByAge(shopId, people);
        }
        else if (AnalysisTypeConstants.PHONE_BRAND == statistics || AnalysisTypeConstants.PHONE_BRAND.equals(statistics))
        {
            cvo = this.analysisByPhoneBrand(shopId, people);
        }

        return cvo;
    }

    @Override
    public ChartVo memberStatisticService(String shopId, List<Account> people, String statistics, String startDate, String endDate, String uuid)
    {
        ChartVo cvo = null;
        if (AnalysisTypeConstants.SHOPPING_PERIOD == statistics || AnalysisTypeConstants.SHOPPING_PERIOD.equals(statistics))
        {
            cvo = this.analysisOthers(statisticAnalysisService.getShoppingPeriod(shopId, startDate, endDate, people, uuid));
        }
        else if (AnalysisTypeConstants.SHOPPING_CONVERTION_RATE == statistics || AnalysisTypeConstants.SHOPPING_CONVERTION_RATE.equals(statistics))
        {
            cvo = this.analysisOthers(statisticAnalysisService.getRateOfPurchase(shopId, startDate, endDate, people, uuid));
        }
        else if (AnalysisTypeConstants.ARRIVAL_SHOP_TIMES == statistics || AnalysisTypeConstants.ARRIVAL_SHOP_TIMES.equals(statistics))
        {
            cvo = this.analysisOthers(statisticAnalysisService.getNumberOfArriveShop(shopId, startDate, endDate, people, uuid));
        }
        else if (AnalysisTypeConstants.AVERAGE_PAY_PRICE == statistics || AnalysisTypeConstants.AVERAGE_PAY_PRICE.equals(statistics))
        {
            cvo = this.analysisOthers(statisticAnalysisService.getAveragePriceRange(shopId, startDate, endDate, people, uuid));
        }
        else if (AnalysisTypeConstants.BROWSE_COUPON_TIMES == statistics || AnalysisTypeConstants.BROWSE_COUPON_TIMES.equals(statistics))
        {
            cvo = this.analysisOthers(statisticAnalysisService.getBrowseCouponsFrequency(shopId, startDate, endDate, people, uuid));
        }
        else if (AnalysisTypeConstants.PHONE_INTERATE_TIMES == statistics || AnalysisTypeConstants.PHONE_INTERATE_TIMES.equals(statistics))
        {
            cvo = this.analysisOthers(statisticAnalysisService.getPhoneInteractionFrequency(shopId, startDate, endDate, people, uuid));
        }
        else if (AnalysisTypeConstants.CRYOUT_OPEN_TIMES == statistics || AnalysisTypeConstants.CRYOUT_OPEN_TIMES.equals(statistics))
        {
            cvo = this.analysisOthers(statisticAnalysisService.getOpenCryoutFrequency(shopId, startDate, endDate, people, uuid));
        }
        else if (AnalysisTypeConstants.COLLECT_COUPON_TIMES == statistics || AnalysisTypeConstants.COLLECT_COUPON_TIMES.equals(statistics))
        {
            cvo = this.analysisOthers(statisticAnalysisService.getCollectionCouponsFrequency(shopId, startDate, endDate, people, uuid));
        }
        else if (AnalysisTypeConstants.CRYOUT_RESPONSE_TIME == statistics || AnalysisTypeConstants.CRYOUT_RESPONSE_TIME.equals(statistics))
        {
            cvo = this.analysisOthers(statisticAnalysisService.getCryoutResponseTime(shopId, startDate, endDate, people, uuid));
        }
        else if (AnalysisTypeConstants.NOTICE_RESPONSE_TIME == statistics || AnalysisTypeConstants.NOTICE_RESPONSE_TIME.equals(statistics))
        {
            cvo = this.analysisOthers(statisticAnalysisService.getNoticeResponseTime(shopId, startDate, endDate, people, uuid));
        }
        else if (AnalysisTypeConstants.COLLECT_ITEM_CATEGORY == statistics || AnalysisTypeConstants.COLLECT_ITEM_CATEGORY.equals(statistics))
        {
            cvo = this.analysisOthers(statisticAnalysisService.getFavoritesCategory(shopId, startDate, endDate, people, uuid));
        }
        else if (AnalysisTypeConstants.CONSUME_ITEM_CATEGORY == statistics || AnalysisTypeConstants.CONSUME_ITEM_CATEGORY.equals(statistics))
        {
            cvo = this.analysisOthers(statisticAnalysisService.getConsumeCategory(shopId, startDate, endDate, people, uuid));
        }

        return cvo;
    }

    private ChartVo analysisByPhoneBrand(String shopId, List<Account> userList)
    {
        DBCollection coll = this.db.getCollection(CollectionConstants.ANLS_USER_BY_BASIC);
        BasicDBObject query = new BasicDBObject();
        BasicDBList queryUsers = new BasicDBList();
        if (userList != null)
        {
            for (Account user : userList)
            {
                queryUsers.add(user.getUserId());
            }
        }
        query.append("_id", new BasicDBObject("$in", queryUsers));

        String reduce = "function(curr, result){result.count += 1;}";
        BasicDBObject key = new BasicDBObject("brand", true);
        BasicDBObject initial = new BasicDBObject("count", 0);
        BasicDBList result = (BasicDBList) coll.group(key, query, initial, reduce);

        return AnalysisUtils.converToChartVo(result, "brand", "count", 9, "其它品牌");
    }

    private ChartVo analysisByAge(String shopId, List<Account> userList)
    {
        DBCollection coll = this.db.getCollection(CollectionConstants.ANLS_USER_BY_BASIC);
        BasicDBObject query = new BasicDBObject();
        BasicDBList queryUsers = new BasicDBList();
        if (userList != null)
        {
            for (Account user : userList)
            {
                queryUsers.add(user.getUserId());
            }
        }
        query.append("_id", new BasicDBObject("$in", queryUsers));

        String reduce = "function(curr, result){result.count += 1;}";
        BasicDBObject key = new BasicDBObject("age_range", true);
        BasicDBObject initial = new BasicDBObject("count", 0);
        BasicDBList result = (BasicDBList) coll.group(key, query, initial, reduce);

        return AnalysisUtils.converToChartVo(result, "age_range", "count");
    }

    /**
     * 根据用户特征分析
     * @param corpId 商家标识
     * @param userList 分析群体
     * @param featureCode 特征编码
     * @return
     */
    private ChartVo analysisByFeature(String corpId, List<Account> userList, String featureCode)
    {
        DBCollection coll = this.db.getCollection(CollectionConstants.ANLS_USER_BY_FEATURE);
        BasicDBObject query = new BasicDBObject();
        BasicDBList idList = new BasicDBList();
        if (userList != null)
        {
            for (Account user : userList)
            {
                idList.add(user.getUserId());
            }
        }
        query.append("shop_id", corpId);
        query.append("user_id", new BasicDBObject("$in", idList));
        query.append("feature." + AnalysisUtils.generateFeatureCode(featureCode), new BasicDBObject("$exists", true));

        String reduce = "function(curr, result){result.count += 1;}";
        BasicDBObject key = new BasicDBObject("feature." + AnalysisUtils.generateFeatureCode(featureCode), true);
        BasicDBObject initial = new BasicDBObject("count", 0);
        BasicDBList result = (BasicDBList) coll.group(key, query, initial, reduce);

        return AnalysisUtils.converToChartVo(result, "feature." + AnalysisUtils.generateFeatureCode(featureCode), "count");
    }

    private ChartVo analysisOthers(List<ColumnVO> dataList)
    {
        ChartVo cvo = null;

        if (dataList != null && dataList.size() > 0)
        {
            List<String> xlabel = new ArrayList<String>();
            List<Long> yvalue = new ArrayList<Long>();
            Map<String, List<Long>> yData = new HashMap<String, List<Long>>();

            for (ColumnVO obj : dataList)
            {
                xlabel.add(obj.getLable());
                yvalue.add(obj.getValue());
            }

            cvo = new ChartVo();
            cvo.setxData(xlabel);
            yData.put("column", yvalue);
            cvo.setyData(yData);
        }

        return cvo;
    }
}
