package com.gooagoo.entity.generator.marketing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 营销内容与用户关联表
 */

public class MarketingUserLinkExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public MarketingUserLinkExample()
    {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause()
    {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause)
    {
        this.orderByClause = orderByClause;
    }

    public boolean getDistinct()
    {
        return distinct;
    }

    public void setDistinct(boolean distinct)
    {
        this.distinct = distinct;
    }

    public List<Criteria> getOredCriteria()
    {
        return oredCriteria;
    }

    private void setLimitStart(Integer limitStart)
    {
        this.limitStart = limitStart;
    }

    private void setLimitEnd(Integer limitEnd)
    {
        this.limitEnd = limitEnd;
    }

    public void or(Criteria criteria)
    {
        oredCriteria.add(criteria);
    }

    public Criteria or()
    {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria()
    {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0)
        {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal()
    {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear()
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        limitStart = -1;
        limitEnd = -1;
    }

    public void setPage(int pageIndex, int pageSize)
    {
        this.setLimitStart((pageIndex - 1) * pageSize);
        this.setLimitEnd(pageSize);
    }

    protected abstract static class GeneratedCriteria  implements Serializable
    {

        private static final long serialVersionUID = 1L;


        protected List<Criterion> criteria;

         protected GeneratedCriteria()
         {
             super();
             this.criteria = new ArrayList<Criterion>();
         }

         public boolean isValid()
         {
             return this.criteria.size() > 0;
         }

         public List<Criterion> getAllCriteria()
         {
             return this.criteria;
         }

         public List<Criterion> getCriteria()
         {
             return this.criteria;
         }

         protected void addCriterion(String condition)
         {
             if (condition == null)
             {
                 throw new RuntimeException("Value for condition cannot be null");
             }
             this.criteria.add(new Criterion(condition));
         }

         protected void addCriterion(String condition, Object value, String property)
         {
             if (value == null)
             {
                 throw new RuntimeException("Value for " + property + " cannot be null");
             }
             this.criteria.add(new Criterion(condition, value));
         }

         protected void addCriterion(String condition, Object value1, Object value2, String property)
         {
             if (value1 == null|| value2 == null)
             {
                 throw new RuntimeException("Between values for " + property + " cannot be null");
             }
             this.criteria.add(new Criterion(condition, value1, value2));
         }

         public Criteria andIdIsNull()
         {
              addCriterion("id is null");
              return (Criteria) this;
         }

         public Criteria andIdIsNotNull()
         {
              addCriterion("id is not null");
              return (Criteria) this;
         }

         public Criteria andIdEqualTo(String value)
         {
              addCriterion("id = ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdNotEqualTo(String value)
         {
              addCriterion("id <> ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdGreaterThan(String value)
         {
              addCriterion("id > ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("id >= ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdLessThan(String value)
         {
              addCriterion("id < ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdLessThanOrEqualTo(String value)
         {
              addCriterion("id <= ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdLike(String value)
         {
              addCriterion("id like ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdNotLike(String value)
         {
              addCriterion("id not like ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdIn(List<String> values)
         {
              addCriterion("id in ", values, "id");
              return (Criteria) this;
         }

         public Criteria andIdNotIn(List<String> values)
         {
              addCriterion("id not in ", values, "id");
              return (Criteria) this;
         }

         public Criteria andIdBetween(String value1, String value2)
         {
              addCriterion("id between ", value1,value2, "id");
              return (Criteria) this;
         }

         public Criteria andIdNotBetween(String value1, String value2)
         {
              addCriterion("id not between ", value1,value2, "id");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeIsNull()
         {
              addCriterion("marketing_type is null");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeIsNotNull()
         {
              addCriterion("marketing_type is not null");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeEqualTo(String value)
         {
              addCriterion("marketing_type = ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeNotEqualTo(String value)
         {
              addCriterion("marketing_type <> ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeGreaterThan(String value)
         {
              addCriterion("marketing_type > ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("marketing_type >= ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeLessThan(String value)
         {
              addCriterion("marketing_type < ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeLessThanOrEqualTo(String value)
         {
              addCriterion("marketing_type <= ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeLike(String value)
         {
              addCriterion("marketing_type like ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeNotLike(String value)
         {
              addCriterion("marketing_type not like ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeIn(List<String> values)
         {
              addCriterion("marketing_type in ", values, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeNotIn(List<String> values)
         {
              addCriterion("marketing_type not in ", values, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeBetween(String value1, String value2)
         {
              addCriterion("marketing_type between ", value1,value2, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeNotBetween(String value1, String value2)
         {
              addCriterion("marketing_type not between ", value1,value2, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingIdIsNull()
         {
              addCriterion("marketing_id is null");
              return (Criteria) this;
         }

         public Criteria andMarketingIdIsNotNull()
         {
              addCriterion("marketing_id is not null");
              return (Criteria) this;
         }

         public Criteria andMarketingIdEqualTo(String value)
         {
              addCriterion("marketing_id = ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdNotEqualTo(String value)
         {
              addCriterion("marketing_id <> ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdGreaterThan(String value)
         {
              addCriterion("marketing_id > ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("marketing_id >= ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdLessThan(String value)
         {
              addCriterion("marketing_id < ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdLessThanOrEqualTo(String value)
         {
              addCriterion("marketing_id <= ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdLike(String value)
         {
              addCriterion("marketing_id like ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdNotLike(String value)
         {
              addCriterion("marketing_id not like ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdIn(List<String> values)
         {
              addCriterion("marketing_id in ", values, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdNotIn(List<String> values)
         {
              addCriterion("marketing_id not in ", values, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdBetween(String value1, String value2)
         {
              addCriterion("marketing_id between ", value1,value2, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdNotBetween(String value1, String value2)
         {
              addCriterion("marketing_id not between ", value1,value2, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andShopIdIsNull()
         {
              addCriterion("shop_id is null");
              return (Criteria) this;
         }

         public Criteria andShopIdIsNotNull()
         {
              addCriterion("shop_id is not null");
              return (Criteria) this;
         }

         public Criteria andShopIdEqualTo(String value)
         {
              addCriterion("shop_id = ", value, "shop_id");
              return (Criteria) this;
         }

         public Criteria andShopIdNotEqualTo(String value)
         {
              addCriterion("shop_id <> ", value, "shop_id");
              return (Criteria) this;
         }

         public Criteria andShopIdGreaterThan(String value)
         {
              addCriterion("shop_id > ", value, "shop_id");
              return (Criteria) this;
         }

         public Criteria andShopIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_id >= ", value, "shop_id");
              return (Criteria) this;
         }

         public Criteria andShopIdLessThan(String value)
         {
              addCriterion("shop_id < ", value, "shop_id");
              return (Criteria) this;
         }

         public Criteria andShopIdLessThanOrEqualTo(String value)
         {
              addCriterion("shop_id <= ", value, "shop_id");
              return (Criteria) this;
         }

         public Criteria andShopIdLike(String value)
         {
              addCriterion("shop_id like ", value, "shop_id");
              return (Criteria) this;
         }

         public Criteria andShopIdNotLike(String value)
         {
              addCriterion("shop_id not like ", value, "shop_id");
              return (Criteria) this;
         }

         public Criteria andShopIdIn(List<String> values)
         {
              addCriterion("shop_id in ", values, "shop_id");
              return (Criteria) this;
         }

         public Criteria andShopIdNotIn(List<String> values)
         {
              addCriterion("shop_id not in ", values, "shop_id");
              return (Criteria) this;
         }

         public Criteria andShopIdBetween(String value1, String value2)
         {
              addCriterion("shop_id between ", value1,value2, "shop_id");
              return (Criteria) this;
         }

         public Criteria andShopIdNotBetween(String value1, String value2)
         {
              addCriterion("shop_id not between ", value1,value2, "shop_id");
              return (Criteria) this;
         }

         public Criteria andAccountTypeIsNull()
         {
              addCriterion("account_type is null");
              return (Criteria) this;
         }

         public Criteria andAccountTypeIsNotNull()
         {
              addCriterion("account_type is not null");
              return (Criteria) this;
         }

         public Criteria andAccountTypeEqualTo(String value)
         {
              addCriterion("account_type = ", value, "account_type");
              return (Criteria) this;
         }

         public Criteria andAccountTypeNotEqualTo(String value)
         {
              addCriterion("account_type <> ", value, "account_type");
              return (Criteria) this;
         }

         public Criteria andAccountTypeGreaterThan(String value)
         {
              addCriterion("account_type > ", value, "account_type");
              return (Criteria) this;
         }

         public Criteria andAccountTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("account_type >= ", value, "account_type");
              return (Criteria) this;
         }

         public Criteria andAccountTypeLessThan(String value)
         {
              addCriterion("account_type < ", value, "account_type");
              return (Criteria) this;
         }

         public Criteria andAccountTypeLessThanOrEqualTo(String value)
         {
              addCriterion("account_type <= ", value, "account_type");
              return (Criteria) this;
         }

         public Criteria andAccountTypeLike(String value)
         {
              addCriterion("account_type like ", value, "account_type");
              return (Criteria) this;
         }

         public Criteria andAccountTypeNotLike(String value)
         {
              addCriterion("account_type not like ", value, "account_type");
              return (Criteria) this;
         }

         public Criteria andAccountTypeIn(List<String> values)
         {
              addCriterion("account_type in ", values, "account_type");
              return (Criteria) this;
         }

         public Criteria andAccountTypeNotIn(List<String> values)
         {
              addCriterion("account_type not in ", values, "account_type");
              return (Criteria) this;
         }

         public Criteria andAccountTypeBetween(String value1, String value2)
         {
              addCriterion("account_type between ", value1,value2, "account_type");
              return (Criteria) this;
         }

         public Criteria andAccountTypeNotBetween(String value1, String value2)
         {
              addCriterion("account_type not between ", value1,value2, "account_type");
              return (Criteria) this;
         }

         public Criteria andAccountIsNull()
         {
              addCriterion("account is null");
              return (Criteria) this;
         }

         public Criteria andAccountIsNotNull()
         {
              addCriterion("account is not null");
              return (Criteria) this;
         }

         public Criteria andAccountEqualTo(String value)
         {
              addCriterion("account = ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountNotEqualTo(String value)
         {
              addCriterion("account <> ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountGreaterThan(String value)
         {
              addCriterion("account > ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountGreaterThanOrEqualTo(String value)
         {
              addCriterion("account >= ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountLessThan(String value)
         {
              addCriterion("account < ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountLessThanOrEqualTo(String value)
         {
              addCriterion("account <= ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountLike(String value)
         {
              addCriterion("account like ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountNotLike(String value)
         {
              addCriterion("account not like ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountIn(List<String> values)
         {
              addCriterion("account in ", values, "account");
              return (Criteria) this;
         }

         public Criteria andAccountNotIn(List<String> values)
         {
              addCriterion("account not in ", values, "account");
              return (Criteria) this;
         }

         public Criteria andAccountBetween(String value1, String value2)
         {
              addCriterion("account between ", value1,value2, "account");
              return (Criteria) this;
         }

         public Criteria andAccountNotBetween(String value1, String value2)
         {
              addCriterion("account not between ", value1,value2, "account");
              return (Criteria) this;
         }

         public Criteria andActivityIdIsNull()
         {
              addCriterion("activity_id is null");
              return (Criteria) this;
         }

         public Criteria andActivityIdIsNotNull()
         {
              addCriterion("activity_id is not null");
              return (Criteria) this;
         }

         public Criteria andActivityIdEqualTo(String value)
         {
              addCriterion("activity_id = ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdNotEqualTo(String value)
         {
              addCriterion("activity_id <> ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdGreaterThan(String value)
         {
              addCriterion("activity_id > ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("activity_id >= ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdLessThan(String value)
         {
              addCriterion("activity_id < ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdLessThanOrEqualTo(String value)
         {
              addCriterion("activity_id <= ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdLike(String value)
         {
              addCriterion("activity_id like ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdNotLike(String value)
         {
              addCriterion("activity_id not like ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdIn(List<String> values)
         {
              addCriterion("activity_id in ", values, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdNotIn(List<String> values)
         {
              addCriterion("activity_id not in ", values, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdBetween(String value1, String value2)
         {
              addCriterion("activity_id between ", value1,value2, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdNotBetween(String value1, String value2)
         {
              addCriterion("activity_id not between ", value1,value2, "activity_id");
              return (Criteria) this;
         }

         public Criteria andIsPushedIsNull()
         {
              addCriterion("is_pushed is null");
              return (Criteria) this;
         }

         public Criteria andIsPushedIsNotNull()
         {
              addCriterion("is_pushed is not null");
              return (Criteria) this;
         }

         public Criteria andIsPushedEqualTo(String value)
         {
              addCriterion("is_pushed = ", value, "is_pushed");
              return (Criteria) this;
         }

         public Criteria andIsPushedNotEqualTo(String value)
         {
              addCriterion("is_pushed <> ", value, "is_pushed");
              return (Criteria) this;
         }

         public Criteria andIsPushedGreaterThan(String value)
         {
              addCriterion("is_pushed > ", value, "is_pushed");
              return (Criteria) this;
         }

         public Criteria andIsPushedGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_pushed >= ", value, "is_pushed");
              return (Criteria) this;
         }

         public Criteria andIsPushedLessThan(String value)
         {
              addCriterion("is_pushed < ", value, "is_pushed");
              return (Criteria) this;
         }

         public Criteria andIsPushedLessThanOrEqualTo(String value)
         {
              addCriterion("is_pushed <= ", value, "is_pushed");
              return (Criteria) this;
         }

         public Criteria andIsPushedLike(String value)
         {
              addCriterion("is_pushed like ", value, "is_pushed");
              return (Criteria) this;
         }

         public Criteria andIsPushedNotLike(String value)
         {
              addCriterion("is_pushed not like ", value, "is_pushed");
              return (Criteria) this;
         }

         public Criteria andIsPushedIn(List<String> values)
         {
              addCriterion("is_pushed in ", values, "is_pushed");
              return (Criteria) this;
         }

         public Criteria andIsPushedNotIn(List<String> values)
         {
              addCriterion("is_pushed not in ", values, "is_pushed");
              return (Criteria) this;
         }

         public Criteria andIsPushedBetween(String value1, String value2)
         {
              addCriterion("is_pushed between ", value1,value2, "is_pushed");
              return (Criteria) this;
         }

         public Criteria andIsPushedNotBetween(String value1, String value2)
         {
              addCriterion("is_pushed not between ", value1,value2, "is_pushed");
              return (Criteria) this;
         }

         public Criteria andPushTimeIsNull()
         {
              addCriterion("push_time is null");
              return (Criteria) this;
         }

         public Criteria andPushTimeIsNotNull()
         {
              addCriterion("push_time is not null");
              return (Criteria) this;
         }

         public Criteria andPushTimeEqualTo(Date value)
         {
              addCriterion("push_time = ", value, "push_time");
              return (Criteria) this;
         }

         public Criteria andPushTimeNotEqualTo(Date value)
         {
              addCriterion("push_time <> ", value, "push_time");
              return (Criteria) this;
         }

         public Criteria andPushTimeGreaterThan(Date value)
         {
              addCriterion("push_time > ", value, "push_time");
              return (Criteria) this;
         }

         public Criteria andPushTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("push_time >= ", value, "push_time");
              return (Criteria) this;
         }

         public Criteria andPushTimeLessThan(Date value)
         {
              addCriterion("push_time < ", value, "push_time");
              return (Criteria) this;
         }

         public Criteria andPushTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("push_time <= ", value, "push_time");
              return (Criteria) this;
         }

         public Criteria andPushTimeIn(List<Date> values)
         {
              addCriterion("push_time in ", values, "push_time");
              return (Criteria) this;
         }

         public Criteria andPushTimeNotIn(List<Date> values)
         {
              addCriterion("push_time not in ", values, "push_time");
              return (Criteria) this;
         }

         public Criteria andPushTimeBetween(Date value1, Date value2)
         {
              addCriterion("push_time between ", value1,value2, "push_time");
              return (Criteria) this;
         }

         public Criteria andPushTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("push_time not between ", value1,value2, "push_time");
              return (Criteria) this;
         }

         public Criteria andIsReadIsNull()
         {
              addCriterion("is_read is null");
              return (Criteria) this;
         }

         public Criteria andIsReadIsNotNull()
         {
              addCriterion("is_read is not null");
              return (Criteria) this;
         }

         public Criteria andIsReadEqualTo(String value)
         {
              addCriterion("is_read = ", value, "is_read");
              return (Criteria) this;
         }

         public Criteria andIsReadNotEqualTo(String value)
         {
              addCriterion("is_read <> ", value, "is_read");
              return (Criteria) this;
         }

         public Criteria andIsReadGreaterThan(String value)
         {
              addCriterion("is_read > ", value, "is_read");
              return (Criteria) this;
         }

         public Criteria andIsReadGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_read >= ", value, "is_read");
              return (Criteria) this;
         }

         public Criteria andIsReadLessThan(String value)
         {
              addCriterion("is_read < ", value, "is_read");
              return (Criteria) this;
         }

         public Criteria andIsReadLessThanOrEqualTo(String value)
         {
              addCriterion("is_read <= ", value, "is_read");
              return (Criteria) this;
         }

         public Criteria andIsReadLike(String value)
         {
              addCriterion("is_read like ", value, "is_read");
              return (Criteria) this;
         }

         public Criteria andIsReadNotLike(String value)
         {
              addCriterion("is_read not like ", value, "is_read");
              return (Criteria) this;
         }

         public Criteria andIsReadIn(List<String> values)
         {
              addCriterion("is_read in ", values, "is_read");
              return (Criteria) this;
         }

         public Criteria andIsReadNotIn(List<String> values)
         {
              addCriterion("is_read not in ", values, "is_read");
              return (Criteria) this;
         }

         public Criteria andIsReadBetween(String value1, String value2)
         {
              addCriterion("is_read between ", value1,value2, "is_read");
              return (Criteria) this;
         }

         public Criteria andIsReadNotBetween(String value1, String value2)
         {
              addCriterion("is_read not between ", value1,value2, "is_read");
              return (Criteria) this;
         }

         public Criteria andIsDelIsNull()
         {
              addCriterion("is_del is null");
              return (Criteria) this;
         }

         public Criteria andIsDelIsNotNull()
         {
              addCriterion("is_del is not null");
              return (Criteria) this;
         }

         public Criteria andIsDelEqualTo(String value)
         {
              addCriterion("is_del = ", value, "is_del");
              return (Criteria) this;
         }

         public Criteria andIsDelNotEqualTo(String value)
         {
              addCriterion("is_del <> ", value, "is_del");
              return (Criteria) this;
         }

         public Criteria andIsDelGreaterThan(String value)
         {
              addCriterion("is_del > ", value, "is_del");
              return (Criteria) this;
         }

         public Criteria andIsDelGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_del >= ", value, "is_del");
              return (Criteria) this;
         }

         public Criteria andIsDelLessThan(String value)
         {
              addCriterion("is_del < ", value, "is_del");
              return (Criteria) this;
         }

         public Criteria andIsDelLessThanOrEqualTo(String value)
         {
              addCriterion("is_del <= ", value, "is_del");
              return (Criteria) this;
         }

         public Criteria andIsDelLike(String value)
         {
              addCriterion("is_del like ", value, "is_del");
              return (Criteria) this;
         }

         public Criteria andIsDelNotLike(String value)
         {
              addCriterion("is_del not like ", value, "is_del");
              return (Criteria) this;
         }

         public Criteria andIsDelIn(List<String> values)
         {
              addCriterion("is_del in ", values, "is_del");
              return (Criteria) this;
         }

         public Criteria andIsDelNotIn(List<String> values)
         {
              addCriterion("is_del not in ", values, "is_del");
              return (Criteria) this;
         }

         public Criteria andIsDelBetween(String value1, String value2)
         {
              addCriterion("is_del between ", value1,value2, "is_del");
              return (Criteria) this;
         }

         public Criteria andIsDelNotBetween(String value1, String value2)
         {
              addCriterion("is_del not between ", value1,value2, "is_del");
              return (Criteria) this;
         }

         public Criteria andCreateTimeIsNull()
         {
              addCriterion("create_time is null");
              return (Criteria) this;
         }

         public Criteria andCreateTimeIsNotNull()
         {
              addCriterion("create_time is not null");
              return (Criteria) this;
         }

         public Criteria andCreateTimeEqualTo(Date value)
         {
              addCriterion("create_time = ", value, "create_time");
              return (Criteria) this;
         }

         public Criteria andCreateTimeNotEqualTo(Date value)
         {
              addCriterion("create_time <> ", value, "create_time");
              return (Criteria) this;
         }

         public Criteria andCreateTimeGreaterThan(Date value)
         {
              addCriterion("create_time > ", value, "create_time");
              return (Criteria) this;
         }

         public Criteria andCreateTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("create_time >= ", value, "create_time");
              return (Criteria) this;
         }

         public Criteria andCreateTimeLessThan(Date value)
         {
              addCriterion("create_time < ", value, "create_time");
              return (Criteria) this;
         }

         public Criteria andCreateTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("create_time <= ", value, "create_time");
              return (Criteria) this;
         }

         public Criteria andCreateTimeIn(List<Date> values)
         {
              addCriterion("create_time in ", values, "create_time");
              return (Criteria) this;
         }

         public Criteria andCreateTimeNotIn(List<Date> values)
         {
              addCriterion("create_time not in ", values, "create_time");
              return (Criteria) this;
         }

         public Criteria andCreateTimeBetween(Date value1, Date value2)
         {
              addCriterion("create_time between ", value1,value2, "create_time");
              return (Criteria) this;
         }

         public Criteria andCreateTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("create_time not between ", value1,value2, "create_time");
              return (Criteria) this;
         }

         public Criteria andCTimeStampIsNull()
         {
              addCriterion("c_time_stamp is null");
              return (Criteria) this;
         }

         public Criteria andCTimeStampIsNotNull()
         {
              addCriterion("c_time_stamp is not null");
              return (Criteria) this;
         }

         public Criteria andCTimeStampEqualTo(Date value)
         {
              addCriterion("c_time_stamp = ", value, "c_time_stamp");
              return (Criteria) this;
         }

         public Criteria andCTimeStampNotEqualTo(Date value)
         {
              addCriterion("c_time_stamp <> ", value, "c_time_stamp");
              return (Criteria) this;
         }

         public Criteria andCTimeStampGreaterThan(Date value)
         {
              addCriterion("c_time_stamp > ", value, "c_time_stamp");
              return (Criteria) this;
         }

         public Criteria andCTimeStampGreaterThanOrEqualTo(Date value)
         {
              addCriterion("c_time_stamp >= ", value, "c_time_stamp");
              return (Criteria) this;
         }

         public Criteria andCTimeStampLessThan(Date value)
         {
              addCriterion("c_time_stamp < ", value, "c_time_stamp");
              return (Criteria) this;
         }

         public Criteria andCTimeStampLessThanOrEqualTo(Date value)
         {
              addCriterion("c_time_stamp <= ", value, "c_time_stamp");
              return (Criteria) this;
         }

         public Criteria andCTimeStampIn(List<Date> values)
         {
              addCriterion("c_time_stamp in ", values, "c_time_stamp");
              return (Criteria) this;
         }

         public Criteria andCTimeStampNotIn(List<Date> values)
         {
              addCriterion("c_time_stamp not in ", values, "c_time_stamp");
              return (Criteria) this;
         }

         public Criteria andCTimeStampBetween(Date value1, Date value2)
         {
              addCriterion("c_time_stamp between ", value1,value2, "c_time_stamp");
              return (Criteria) this;
         }

         public Criteria andCTimeStampNotBetween(Date value1, Date value2)
         {
              addCriterion("c_time_stamp not between ", value1,value2, "c_time_stamp");
              return (Criteria) this;
         }

    }

    public static class Criteria extends GeneratedCriteria implements Serializable
    {

        private static final long serialVersionUID = 1L;

        protected Criteria()
        {
            super();
        }
    }
    public static class Criterion implements Serializable
    {

        private static final long serialVersionUID = 1L;

        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition()
        {
            return this.condition;
        }

        public Object getValue()
        {
            return this.value;
        }

        public Object getSecondValue()
        {
            return this.secondValue;
        }

        public boolean isNoValue()
        {
            return this.noValue;
        }

        public boolean isSingleValue()
        {
            return this.singleValue;
        }

        public boolean isBetweenValue()
        {
            return this.betweenValue;
        }

        public boolean isListValue()
        {
            return this.listValue;
        }

        public String getTypeHandler()
        {
            return this.typeHandler;
        }

        protected Criterion(String condition)
        {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler)
        {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>)
            {
                this.listValue = true;
            }
            else
            {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value)
        {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
        {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue)
        {
            this(condition, value, secondValue, null);
        }
    }
}
