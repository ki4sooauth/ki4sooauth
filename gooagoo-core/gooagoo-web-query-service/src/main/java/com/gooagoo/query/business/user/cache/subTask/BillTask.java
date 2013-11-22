package com.gooagoo.query.business.user.cache.subTask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.dao.generator.bill.OrderInfoMapper;
import com.gooagoo.entity.business.marketing.rule.ActionAttribute;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.gmongo.MongoDao;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.QueryOperators;

public class BillTask implements Callable<Set<Account>>
{
    @Autowired
    OrderInfoMapper orderInfoMapper;

    private String shopId;
    private ActionAttribute actionAttribute;
    private String[] userIds;

    public BillTask(String shopId, ActionAttribute actionAttribute, String[] userIds)
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
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BILL);
        DBObject dbObject = new BasicDBObject();
        dbObject.put("shopId", shopId);
        try
        {
            if (InnerTools.hasText(actionAttribute.getDateStart()) || InnerTools.hasText(actionAttribute.getDateEnd()))
            {
                DBObject timeRange = new BasicDBObject();
                if (InnerTools.hasText(actionAttribute.getDateStart()))
                {
                    timeRange.put(QueryOperators.GTE, format(actionAttribute.getDateStart()));
                }
                if (InnerTools.hasText(actionAttribute.getDateEnd()))
                {
                    timeRange.put(QueryOperators.LTE, format(actionAttribute.getDateEnd()));
                }
                dbObject.put("timestamp", timeRange);
            }
        }
        catch (ParseException e)
        {
            GooagooLog.error("日期转换异常", e);
        }

        if (InnerTools.hasText(userIds))
        {
            dbObject.put("userId", new BasicDBObject().append(QueryOperators.IN, userIds));
        }
        if (InnerTools.hasText(actionAttribute.getActionSource()))
        {
            dbObject.put("source", actionAttribute.getActionSource());
        }
        if (actionAttribute.getConsumeMoneyMin() != null || actionAttribute.getConsumeMoneyMax() != null)
        {
            DBObject money = new BasicDBObject();
            if (actionAttribute.getConsumeMoneyMin() != null)
            {
                money.put(QueryOperators.GTE, actionAttribute.getConsumeMoneyMin());
            }
            if (actionAttribute.getConsumeMoneyMax() != null)
            {
                money.put(QueryOperators.LTE, actionAttribute.getConsumeMoneyMax());
            }
            dbObject.put("payPrice", money);
        }
        String relation = "Y".equals(actionAttribute.getRelation()) ? QueryOperators.ALL : QueryOperators.IN;
        if (InnerTools.hasText(actionAttribute.getMarketingGoodsBrand()))
        {
            DBObject brand = new BasicDBObject();
            brand.put(relation, actionAttribute.getMarketingGoodsBrand().split(","));
            dbObject.put("goodsBrand", brand);
        }
        if (InnerTools.hasText(actionAttribute.getMarketingGoodsCategory()))
        {
            DBObject category = new BasicDBObject();
            category.put(relation, actionAttribute.getMarketingGoodsCategory().split(","));
            dbObject.put("category", category);
        }
        if (InnerTools.hasText(actionAttribute.getMarketingGoods()))
        {
            DBObject goods = new BasicDBObject();
            goods.put(relation, actionAttribute.getMarketingGoods().split(","));
            dbObject.put("itemSerial", goods);
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
            List<Account> result = mongoDao.findByCondition(dbObject, Account.class);
            accounts.addAll(result);
        }
        InnerTools.putCache(accounts, shopId, actionAttribute, userIds); //写缓存
        return accounts;
    }

    private Date format(String date) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(date);
    }
}
