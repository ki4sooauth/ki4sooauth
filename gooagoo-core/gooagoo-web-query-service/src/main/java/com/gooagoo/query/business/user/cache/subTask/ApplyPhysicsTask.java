package com.gooagoo.query.business.user.cache.subTask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.entity.business.marketing.rule.ActionAttribute;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.gmongo.MongoDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.QueryOperators;

public class ApplyPhysicsTask implements Callable<Set<Account>>
{
    private final String shopId;
    private final ActionAttribute actionAttribute;
    private String[] userIds;

    public ApplyPhysicsTask(String shopId, ActionAttribute actionAttribute, String[] userIds)
    {
        this.shopId = shopId;
        this.actionAttribute = actionAttribute;
    }

    @Override
    public Set<Account> call()
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
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_APPLYMEMBER);
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
        if (InnerTools.hasText(actionAttribute.getVipGrade()))
        {
            DBObject card = new BasicDBObject();
            card.put(QueryOperators.IN, actionAttribute.getVipGrade().split(","));
            dbObject.put("cardId", card);
        }
        if (InnerTools.hasText(userIds))
        {
            dbObject.put("userId", new BasicDBObject().append(QueryOperators.IN, userIds));
        }
        accounts.addAll(mongoDao.findByCondition(dbObject, Account.class));
        InnerTools.putCache(accounts, shopId, actionAttribute, userIds); //写缓存
        return accounts;
    }

    private Date format(String date) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(date);
    }
}
