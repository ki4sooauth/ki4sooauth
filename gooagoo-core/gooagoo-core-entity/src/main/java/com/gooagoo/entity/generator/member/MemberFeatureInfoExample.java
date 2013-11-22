package com.gooagoo.entity.generator.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 会员特征信息
 */

public class MemberFeatureInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public MemberFeatureInfoExample()
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

         public Criteria andPhyNoIsNull()
         {
              addCriterion("phy_no is null");
              return (Criteria) this;
         }

         public Criteria andPhyNoIsNotNull()
         {
              addCriterion("phy_no is not null");
              return (Criteria) this;
         }

         public Criteria andPhyNoEqualTo(String value)
         {
              addCriterion("phy_no = ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoNotEqualTo(String value)
         {
              addCriterion("phy_no <> ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoGreaterThan(String value)
         {
              addCriterion("phy_no > ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoGreaterThanOrEqualTo(String value)
         {
              addCriterion("phy_no >= ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoLessThan(String value)
         {
              addCriterion("phy_no < ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoLessThanOrEqualTo(String value)
         {
              addCriterion("phy_no <= ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoLike(String value)
         {
              addCriterion("phy_no like ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoNotLike(String value)
         {
              addCriterion("phy_no not like ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoIn(List<String> values)
         {
              addCriterion("phy_no in ", values, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoNotIn(List<String> values)
         {
              addCriterion("phy_no not in ", values, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoBetween(String value1, String value2)
         {
              addCriterion("phy_no between ", value1,value2, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoNotBetween(String value1, String value2)
         {
              addCriterion("phy_no not between ", value1,value2, "phy_no");
              return (Criteria) this;
         }

         public Criteria andUserIdIsNull()
         {
              addCriterion("user_id is null");
              return (Criteria) this;
         }

         public Criteria andUserIdIsNotNull()
         {
              addCriterion("user_id is not null");
              return (Criteria) this;
         }

         public Criteria andUserIdEqualTo(String value)
         {
              addCriterion("user_id = ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdNotEqualTo(String value)
         {
              addCriterion("user_id <> ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdGreaterThan(String value)
         {
              addCriterion("user_id > ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("user_id >= ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdLessThan(String value)
         {
              addCriterion("user_id < ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdLessThanOrEqualTo(String value)
         {
              addCriterion("user_id <= ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdLike(String value)
         {
              addCriterion("user_id like ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdNotLike(String value)
         {
              addCriterion("user_id not like ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdIn(List<String> values)
         {
              addCriterion("user_id in ", values, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdNotIn(List<String> values)
         {
              addCriterion("user_id not in ", values, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdBetween(String value1, String value2)
         {
              addCriterion("user_id between ", value1,value2, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdNotBetween(String value1, String value2)
         {
              addCriterion("user_id not between ", value1,value2, "user_id");
              return (Criteria) this;
         }

         public Criteria andScardNoIsNull()
         {
              addCriterion("scard_no is null");
              return (Criteria) this;
         }

         public Criteria andScardNoIsNotNull()
         {
              addCriterion("scard_no is not null");
              return (Criteria) this;
         }

         public Criteria andScardNoEqualTo(String value)
         {
              addCriterion("scard_no = ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoNotEqualTo(String value)
         {
              addCriterion("scard_no <> ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoGreaterThan(String value)
         {
              addCriterion("scard_no > ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoGreaterThanOrEqualTo(String value)
         {
              addCriterion("scard_no >= ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoLessThan(String value)
         {
              addCriterion("scard_no < ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoLessThanOrEqualTo(String value)
         {
              addCriterion("scard_no <= ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoLike(String value)
         {
              addCriterion("scard_no like ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoNotLike(String value)
         {
              addCriterion("scard_no not like ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoIn(List<String> values)
         {
              addCriterion("scard_no in ", values, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoNotIn(List<String> values)
         {
              addCriterion("scard_no not in ", values, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoBetween(String value1, String value2)
         {
              addCriterion("scard_no between ", value1,value2, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoNotBetween(String value1, String value2)
         {
              addCriterion("scard_no not between ", value1,value2, "scard_no");
              return (Criteria) this;
         }

         public Criteria andFeatureCodeIsNull()
         {
              addCriterion("feature_code is null");
              return (Criteria) this;
         }

         public Criteria andFeatureCodeIsNotNull()
         {
              addCriterion("feature_code is not null");
              return (Criteria) this;
         }

         public Criteria andFeatureCodeEqualTo(String value)
         {
              addCriterion("feature_code = ", value, "feature_code");
              return (Criteria) this;
         }

         public Criteria andFeatureCodeNotEqualTo(String value)
         {
              addCriterion("feature_code <> ", value, "feature_code");
              return (Criteria) this;
         }

         public Criteria andFeatureCodeGreaterThan(String value)
         {
              addCriterion("feature_code > ", value, "feature_code");
              return (Criteria) this;
         }

         public Criteria andFeatureCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("feature_code >= ", value, "feature_code");
              return (Criteria) this;
         }

         public Criteria andFeatureCodeLessThan(String value)
         {
              addCriterion("feature_code < ", value, "feature_code");
              return (Criteria) this;
         }

         public Criteria andFeatureCodeLessThanOrEqualTo(String value)
         {
              addCriterion("feature_code <= ", value, "feature_code");
              return (Criteria) this;
         }

         public Criteria andFeatureCodeLike(String value)
         {
              addCriterion("feature_code like ", value, "feature_code");
              return (Criteria) this;
         }

         public Criteria andFeatureCodeNotLike(String value)
         {
              addCriterion("feature_code not like ", value, "feature_code");
              return (Criteria) this;
         }

         public Criteria andFeatureCodeIn(List<String> values)
         {
              addCriterion("feature_code in ", values, "feature_code");
              return (Criteria) this;
         }

         public Criteria andFeatureCodeNotIn(List<String> values)
         {
              addCriterion("feature_code not in ", values, "feature_code");
              return (Criteria) this;
         }

         public Criteria andFeatureCodeBetween(String value1, String value2)
         {
              addCriterion("feature_code between ", value1,value2, "feature_code");
              return (Criteria) this;
         }

         public Criteria andFeatureCodeNotBetween(String value1, String value2)
         {
              addCriterion("feature_code not between ", value1,value2, "feature_code");
              return (Criteria) this;
         }

         public Criteria andFeatureValueIsNull()
         {
              addCriterion("feature_value is null");
              return (Criteria) this;
         }

         public Criteria andFeatureValueIsNotNull()
         {
              addCriterion("feature_value is not null");
              return (Criteria) this;
         }

         public Criteria andFeatureValueEqualTo(String value)
         {
              addCriterion("feature_value = ", value, "feature_value");
              return (Criteria) this;
         }

         public Criteria andFeatureValueNotEqualTo(String value)
         {
              addCriterion("feature_value <> ", value, "feature_value");
              return (Criteria) this;
         }

         public Criteria andFeatureValueGreaterThan(String value)
         {
              addCriterion("feature_value > ", value, "feature_value");
              return (Criteria) this;
         }

         public Criteria andFeatureValueGreaterThanOrEqualTo(String value)
         {
              addCriterion("feature_value >= ", value, "feature_value");
              return (Criteria) this;
         }

         public Criteria andFeatureValueLessThan(String value)
         {
              addCriterion("feature_value < ", value, "feature_value");
              return (Criteria) this;
         }

         public Criteria andFeatureValueLessThanOrEqualTo(String value)
         {
              addCriterion("feature_value <= ", value, "feature_value");
              return (Criteria) this;
         }

         public Criteria andFeatureValueLike(String value)
         {
              addCriterion("feature_value like ", value, "feature_value");
              return (Criteria) this;
         }

         public Criteria andFeatureValueNotLike(String value)
         {
              addCriterion("feature_value not like ", value, "feature_value");
              return (Criteria) this;
         }

         public Criteria andFeatureValueIn(List<String> values)
         {
              addCriterion("feature_value in ", values, "feature_value");
              return (Criteria) this;
         }

         public Criteria andFeatureValueNotIn(List<String> values)
         {
              addCriterion("feature_value not in ", values, "feature_value");
              return (Criteria) this;
         }

         public Criteria andFeatureValueBetween(String value1, String value2)
         {
              addCriterion("feature_value between ", value1,value2, "feature_value");
              return (Criteria) this;
         }

         public Criteria andFeatureValueNotBetween(String value1, String value2)
         {
              addCriterion("feature_value not between ", value1,value2, "feature_value");
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
