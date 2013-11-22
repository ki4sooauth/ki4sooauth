package com.gooagoo.entity.generator.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 商家竞拍信息表
 */

public class ShopBidExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopBidExample()
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

         public Criteria andBidIdIsNull()
         {
              addCriterion("bid_id is null");
              return (Criteria) this;
         }

         public Criteria andBidIdIsNotNull()
         {
              addCriterion("bid_id is not null");
              return (Criteria) this;
         }

         public Criteria andBidIdEqualTo(String value)
         {
              addCriterion("bid_id = ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdNotEqualTo(String value)
         {
              addCriterion("bid_id <> ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdGreaterThan(String value)
         {
              addCriterion("bid_id > ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("bid_id >= ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdLessThan(String value)
         {
              addCriterion("bid_id < ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdLessThanOrEqualTo(String value)
         {
              addCriterion("bid_id <= ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdLike(String value)
         {
              addCriterion("bid_id like ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdNotLike(String value)
         {
              addCriterion("bid_id not like ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdIn(List<String> values)
         {
              addCriterion("bid_id in ", values, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdNotIn(List<String> values)
         {
              addCriterion("bid_id not in ", values, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdBetween(String value1, String value2)
         {
              addCriterion("bid_id between ", value1,value2, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdNotBetween(String value1, String value2)
         {
              addCriterion("bid_id not between ", value1,value2, "bid_id");
              return (Criteria) this;
         }

         public Criteria andAdCodeIsNull()
         {
              addCriterion("ad_code is null");
              return (Criteria) this;
         }

         public Criteria andAdCodeIsNotNull()
         {
              addCriterion("ad_code is not null");
              return (Criteria) this;
         }

         public Criteria andAdCodeEqualTo(String value)
         {
              addCriterion("ad_code = ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeNotEqualTo(String value)
         {
              addCriterion("ad_code <> ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeGreaterThan(String value)
         {
              addCriterion("ad_code > ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("ad_code >= ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeLessThan(String value)
         {
              addCriterion("ad_code < ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeLessThanOrEqualTo(String value)
         {
              addCriterion("ad_code <= ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeLike(String value)
         {
              addCriterion("ad_code like ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeNotLike(String value)
         {
              addCriterion("ad_code not like ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeIn(List<String> values)
         {
              addCriterion("ad_code in ", values, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeNotIn(List<String> values)
         {
              addCriterion("ad_code not in ", values, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeBetween(String value1, String value2)
         {
              addCriterion("ad_code between ", value1,value2, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeNotBetween(String value1, String value2)
         {
              addCriterion("ad_code not between ", value1,value2, "ad_code");
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

         public Criteria andShopNameIsNull()
         {
              addCriterion("shop_name is null");
              return (Criteria) this;
         }

         public Criteria andShopNameIsNotNull()
         {
              addCriterion("shop_name is not null");
              return (Criteria) this;
         }

         public Criteria andShopNameEqualTo(String value)
         {
              addCriterion("shop_name = ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameNotEqualTo(String value)
         {
              addCriterion("shop_name <> ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameGreaterThan(String value)
         {
              addCriterion("shop_name > ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_name >= ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameLessThan(String value)
         {
              addCriterion("shop_name < ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameLessThanOrEqualTo(String value)
         {
              addCriterion("shop_name <= ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameLike(String value)
         {
              addCriterion("shop_name like ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameNotLike(String value)
         {
              addCriterion("shop_name not like ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameIn(List<String> values)
         {
              addCriterion("shop_name in ", values, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameNotIn(List<String> values)
         {
              addCriterion("shop_name not in ", values, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameBetween(String value1, String value2)
         {
              addCriterion("shop_name between ", value1,value2, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameNotBetween(String value1, String value2)
         {
              addCriterion("shop_name not between ", value1,value2, "shop_name");
              return (Criteria) this;
         }

         public Criteria andBidAmountIsNull()
         {
              addCriterion("bid_amount is null");
              return (Criteria) this;
         }

         public Criteria andBidAmountIsNotNull()
         {
              addCriterion("bid_amount is not null");
              return (Criteria) this;
         }

         public Criteria andBidAmountEqualTo(String value)
         {
              addCriterion("bid_amount = ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountNotEqualTo(String value)
         {
              addCriterion("bid_amount <> ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountGreaterThan(String value)
         {
              addCriterion("bid_amount > ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountGreaterThanOrEqualTo(String value)
         {
              addCriterion("bid_amount >= ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountLessThan(String value)
         {
              addCriterion("bid_amount < ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountLessThanOrEqualTo(String value)
         {
              addCriterion("bid_amount <= ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountLike(String value)
         {
              addCriterion("bid_amount like ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountNotLike(String value)
         {
              addCriterion("bid_amount not like ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountIn(List<String> values)
         {
              addCriterion("bid_amount in ", values, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountNotIn(List<String> values)
         {
              addCriterion("bid_amount not in ", values, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountBetween(String value1, String value2)
         {
              addCriterion("bid_amount between ", value1,value2, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountNotBetween(String value1, String value2)
         {
              addCriterion("bid_amount not between ", value1,value2, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andOperatorIsNull()
         {
              addCriterion("operator is null");
              return (Criteria) this;
         }

         public Criteria andOperatorIsNotNull()
         {
              addCriterion("operator is not null");
              return (Criteria) this;
         }

         public Criteria andOperatorEqualTo(String value)
         {
              addCriterion("operator = ", value, "operator");
              return (Criteria) this;
         }

         public Criteria andOperatorNotEqualTo(String value)
         {
              addCriterion("operator <> ", value, "operator");
              return (Criteria) this;
         }

         public Criteria andOperatorGreaterThan(String value)
         {
              addCriterion("operator > ", value, "operator");
              return (Criteria) this;
         }

         public Criteria andOperatorGreaterThanOrEqualTo(String value)
         {
              addCriterion("operator >= ", value, "operator");
              return (Criteria) this;
         }

         public Criteria andOperatorLessThan(String value)
         {
              addCriterion("operator < ", value, "operator");
              return (Criteria) this;
         }

         public Criteria andOperatorLessThanOrEqualTo(String value)
         {
              addCriterion("operator <= ", value, "operator");
              return (Criteria) this;
         }

         public Criteria andOperatorLike(String value)
         {
              addCriterion("operator like ", value, "operator");
              return (Criteria) this;
         }

         public Criteria andOperatorNotLike(String value)
         {
              addCriterion("operator not like ", value, "operator");
              return (Criteria) this;
         }

         public Criteria andOperatorIn(List<String> values)
         {
              addCriterion("operator in ", values, "operator");
              return (Criteria) this;
         }

         public Criteria andOperatorNotIn(List<String> values)
         {
              addCriterion("operator not in ", values, "operator");
              return (Criteria) this;
         }

         public Criteria andOperatorBetween(String value1, String value2)
         {
              addCriterion("operator between ", value1,value2, "operator");
              return (Criteria) this;
         }

         public Criteria andOperatorNotBetween(String value1, String value2)
         {
              addCriterion("operator not between ", value1,value2, "operator");
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
