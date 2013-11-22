package com.gooagoo.query.business.user.cache.subTask;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.entity.business.marketing.rule.NaturalAttribute;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.member.MemberFeature;
import com.gooagoo.gmongo.MongoDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.QueryOperators;

public class NaturalTask
{

    public Set<Account> query(String shopId, NaturalAttribute naturalAttribute)
    {
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_ACCOUNT);
        DBObject dbObject = new BasicDBObject();
        dbObject.put("shopId", shopId);
        if (InnerTools.hasText(naturalAttribute.getAccountType(), naturalAttribute.getAccount()))
        {
            dbObject.put("_id", shopId + "_" + naturalAttribute.getAccountType() + "_" + naturalAttribute.getAccount());
        }
        if (InnerTools.hasText(naturalAttribute.getSex()))
        {
            dbObject.put("sex", naturalAttribute.getSex());
        }
        if (InnerTools.hasText(naturalAttribute.getBirthdayStart()) || InnerTools.hasText(naturalAttribute.getBirthdayEnd()))
        {
            DBObject month = new BasicDBObject();
            if (InnerTools.hasText(naturalAttribute.getBirthdayStart()))
            {
                int monthStart = getMonth(naturalAttribute.getBirthdayStart());
                month.put(QueryOperators.GTE, monthStart);
            }
            if (InnerTools.hasText(naturalAttribute.getBirthdayStart()))
            {
                int monthEnd = getMonth(naturalAttribute.getBirthdayEnd());
                month.put(QueryOperators.LTE, monthEnd);
            }
            dbObject.put("birthMonth", month);

            DBObject day = new BasicDBObject();
            if (InnerTools.hasText(naturalAttribute.getBirthdayStart()))
            {
                int dayStart = getDay(naturalAttribute.getBirthdayStart());
                day.put(QueryOperators.GTE, dayStart);
            }
            if (InnerTools.hasText(naturalAttribute.getBirthdayStart()))
            {
                int dayEnd = getDay(naturalAttribute.getBirthdayEnd());
                day.put(QueryOperators.LTE, dayEnd);
            }
            dbObject.put("birthDay", day);
        }
        if (naturalAttribute.getAgeStart() != null || naturalAttribute.getAgeEnd() != null)
        {
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            DBObject birthYear = new BasicDBObject();
            if (naturalAttribute.getAgeStart() != null)
            {
                birthYear.put(QueryOperators.LTE, year - naturalAttribute.getAgeStart());
            }
            if (naturalAttribute.getAgeEnd() != null)
            {
                birthYear.put(QueryOperators.GTE, year - naturalAttribute.getAgeEnd());
            }
            dbObject.put("birthYear", birthYear);
        }
        if (InnerTools.hasText(naturalAttribute.getGrade()))
        {
            DBObject card = new BasicDBObject();
            card.put(QueryOperators.IN, naturalAttribute.getGrade().split(","));
            dbObject.put("cardId", card);
        }
        if (naturalAttribute.getMemberFeatureList() != null && naturalAttribute.getMemberFeatureList().size() != 0)
        {
            for (MemberFeature feature : naturalAttribute.getMemberFeatureList())
            {
                dbObject.put("feature." + feature.getTypeCode(), feature.getEnumValue());
            }
        }
        List<Account> accounts = mongoDao.findByCondition(dbObject, Account.class);
        return new HashSet<Account>(accounts);
    }

    private int getMonth(String birthday)
    {
        String month = birthday.split("-")[0];
        return Integer.valueOf(month);
    }

    private int getDay(String birthday)
    {
        String day = birthday.split("-")[1];
        return Integer.valueOf(day);
    }

}
