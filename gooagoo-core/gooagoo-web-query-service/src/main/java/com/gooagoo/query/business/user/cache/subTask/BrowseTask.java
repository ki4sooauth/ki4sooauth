package com.gooagoo.query.business.user.cache.subTask;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.entity.business.marketing.rule.ActionAttribute;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.gmongo.MongoDao;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.QueryOperators;

public class BrowseTask implements Callable<Set<Account>>
{
    private String shopId;
    private ActionAttribute actionAttribute;
    private String[] userIds;

    public BrowseTask(String shopId, ActionAttribute actionAttribute, String[] userIds)
    {
        super();
        this.shopId = shopId;
        this.actionAttribute = actionAttribute;
        this.userIds = userIds;
    }

    @Override
    public Set<Account> call() throws Exception
    {
        return query();
    }

    public Set<Account> query()
    {
        Set<Account> cacheAccount = InnerTools.getCache(shopId, actionAttribute, userIds); //读缓存
        if (cacheAccount != null && cacheAccount.size() != 0)
        {
            return cacheAccount;
        }
        Set<Account> accounts = new HashSet<Account>();
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BROWSE);

        DBObject dbObject = new BasicDBObject();
        dbObject.put("shopId", shopId);

        if (InnerTools.hasText(userIds))
        {
            dbObject.put("userId", new BasicDBObject().append(QueryOperators.IN, userIds));
        }
        try
        {
            if (InnerTools.hasText(actionAttribute.getDateStart()) || InnerTools.hasText(actionAttribute.getDateEnd()))
            {
                DBObject timeRange = new BasicDBObject();
                if (InnerTools.hasText(actionAttribute.getDateStart()))
                {
                    timeRange.put(QueryOperators.GTE, TimeUtils.convertStringToDate(actionAttribute.getDateStart()));
                }
                if (InnerTools.hasText(actionAttribute.getDateEnd()))
                {
                    timeRange.put(QueryOperators.LTE, TimeUtils.convertStringToDate(actionAttribute.getDateEnd()));
                }
                dbObject.put("timestamp", timeRange);
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("日期转换异常", e);
        }
        String relation = "Y".equals(actionAttribute.getRelation()) ? QueryOperators.ALL : QueryOperators.IN;
        if (InnerTools.hasText(actionAttribute.getActionSource()))
        {
            dbObject.put("source", actionAttribute.getActionSource());
        }
        if (InnerTools.hasText(actionAttribute.getMarketingGoodsCategory()))
        {
            DBObject category = new BasicDBObject();
            category.put(relation, actionAttribute.getMarketingGoodsCategory().split(","));
            dbObject.put("category", category);
        }
        if (InnerTools.hasText(actionAttribute.getMarketingGoodsBrand()))
        {
            DBObject brand = new BasicDBObject();
            brand.put(relation, actionAttribute.getMarketingGoodsBrand().split(","));
            dbObject.put("goodsBrand", brand);
        }
        if (InnerTools.hasText(actionAttribute.getMarketingGoods()))
        {
            DBObject goods = new BasicDBObject();
            goods.put(relation, actionAttribute.getMarketingGoods().split(","));
            dbObject.put("itemSerial", goods);
        }
        if (InnerTools.hasText(actionAttribute.getMarketingActivity()))
        {
            DBObject condition = new BasicDBObject();
            condition.put(relation, actionAttribute.getMarketingActivity().split(","));
            dbObject.put("activity", condition);
        }
        if (InnerTools.hasText(actionAttribute.getMarketingCoupon()))
        {
            DBObject condition = new BasicDBObject();
            condition.put(relation, actionAttribute.getMarketingCoupon().split(","));
            dbObject.put("coupon", condition);
        }
        if (InnerTools.hasText(actionAttribute.getMarketingEvent()))
        {
            DBObject condition = new BasicDBObject();
            condition.put(relation, actionAttribute.getMarketingEvent().split(","));
            dbObject.put("event", condition);
        }
        if (actionAttribute.getTotalTimeMin() != null || actionAttribute.getTotalTimeMax() != null)
        {
            String reduce = "function(doc, aggr){aggr.count += 1;}";
            BasicDBObject key = new BasicDBObject();
            key.put("userId", true);

            BasicDBObject initial = new BasicDBObject();
            initial.append("count", 0);
            BasicDBList list = mongoDao.group(key, dbObject, initial, reduce);

            for (int i = 0; i < list.size(); i++)
            {
                BasicDBObject dbo = (BasicDBObject) list.get(i);
                int num = dbo.getInt("count");
                boolean min = actionAttribute.getTotalTimeMin() == null ? true : num >= actionAttribute.getTotalTimeMin();
                boolean max = actionAttribute.getTotalTimeMax() == null ? true : num <= actionAttribute.getTotalTimeMax();
                if (min && max)
                {
                    accounts.add(new Account(dbo.getString("userId")));
                }
            }
        }
        else
        {
            accounts.addAll(mongoDao.findByCondition(dbObject, Account.class));
        }
        InnerTools.putCache(accounts, shopId, actionAttribute, userIds); //写缓存
        return accounts;
    }
}
