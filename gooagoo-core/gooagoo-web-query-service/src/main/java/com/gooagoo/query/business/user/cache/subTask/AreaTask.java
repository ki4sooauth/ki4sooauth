package com.gooagoo.query.business.user.cache.subTask;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

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

public class AreaTask implements Callable<Set<Account>>
{
    private String shopId;
    private ActionAttribute actionAttribute;
    private String[] userIds;

    public AreaTask(String shopId, ActionAttribute actionAttribute, String[] userIds)
    {
        this.shopId = shopId;
        this.actionAttribute = actionAttribute;
        this.userIds = userIds;
    }

    @Override
    public Set<Account> call() throws Exception
    {
        return query();
    }

    public Set<Account> query() throws Exception
    {
        Set<Account> cacheAccount = InnerTools.getCache(shopId, actionAttribute, userIds); //读缓存
        if (cacheAccount != null && cacheAccount.size() != 0)
        {
            return cacheAccount;
        }
        Set<Account> accounts = new HashSet<Account>();
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_ARRIVAL_AREA);
        DBObject dbObject = new BasicDBObject();
        dbObject.put("positionId", new BasicDBObject().append(QueryOperators.IN, actionAttribute.getPosition().split(",")));

        if (InnerTools.hasText(actionAttribute.getDateStart()))
        {
            DBObject date = new BasicDBObject();
            date.put(QueryOperators.GTE, TimeUtils.convertStringToDate(actionAttribute.getDateStart()));
            dbObject.put("end", date); //查询的开始时间 小于记录的结束时间
        }
        if (InnerTools.hasText(actionAttribute.getDateEnd()))
        {
            DBObject date = new BasicDBObject();
            date.put(QueryOperators.LTE, TimeUtils.convertStringToDate(actionAttribute.getDateEnd()));
            dbObject.put("start", date); //查询的 结束时间 大于记录的开始时间
        }

        if (InnerTools.hasText(userIds))
        {
            dbObject.put("userId", new BasicDBObject().append(QueryOperators.IN, userIds));
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
