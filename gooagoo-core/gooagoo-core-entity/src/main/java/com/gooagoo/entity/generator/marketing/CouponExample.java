package com.gooagoo.entity.generator.marketing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 优惠凭证
 */

public class CouponExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public CouponExample()
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

         public Criteria andCouponIdIsNull()
         {
              addCriterion("coupon_id is null");
              return (Criteria) this;
         }

         public Criteria andCouponIdIsNotNull()
         {
              addCriterion("coupon_id is not null");
              return (Criteria) this;
         }

         public Criteria andCouponIdEqualTo(String value)
         {
              addCriterion("coupon_id = ", value, "coupon_id");
              return (Criteria) this;
         }

         public Criteria andCouponIdNotEqualTo(String value)
         {
              addCriterion("coupon_id <> ", value, "coupon_id");
              return (Criteria) this;
         }

         public Criteria andCouponIdGreaterThan(String value)
         {
              addCriterion("coupon_id > ", value, "coupon_id");
              return (Criteria) this;
         }

         public Criteria andCouponIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("coupon_id >= ", value, "coupon_id");
              return (Criteria) this;
         }

         public Criteria andCouponIdLessThan(String value)
         {
              addCriterion("coupon_id < ", value, "coupon_id");
              return (Criteria) this;
         }

         public Criteria andCouponIdLessThanOrEqualTo(String value)
         {
              addCriterion("coupon_id <= ", value, "coupon_id");
              return (Criteria) this;
         }

         public Criteria andCouponIdLike(String value)
         {
              addCriterion("coupon_id like ", value, "coupon_id");
              return (Criteria) this;
         }

         public Criteria andCouponIdNotLike(String value)
         {
              addCriterion("coupon_id not like ", value, "coupon_id");
              return (Criteria) this;
         }

         public Criteria andCouponIdIn(List<String> values)
         {
              addCriterion("coupon_id in ", values, "coupon_id");
              return (Criteria) this;
         }

         public Criteria andCouponIdNotIn(List<String> values)
         {
              addCriterion("coupon_id not in ", values, "coupon_id");
              return (Criteria) this;
         }

         public Criteria andCouponIdBetween(String value1, String value2)
         {
              addCriterion("coupon_id between ", value1,value2, "coupon_id");
              return (Criteria) this;
         }

         public Criteria andCouponIdNotBetween(String value1, String value2)
         {
              addCriterion("coupon_id not between ", value1,value2, "coupon_id");
              return (Criteria) this;
         }

         public Criteria andCouponNameIsNull()
         {
              addCriterion("coupon_name is null");
              return (Criteria) this;
         }

         public Criteria andCouponNameIsNotNull()
         {
              addCriterion("coupon_name is not null");
              return (Criteria) this;
         }

         public Criteria andCouponNameEqualTo(String value)
         {
              addCriterion("coupon_name = ", value, "coupon_name");
              return (Criteria) this;
         }

         public Criteria andCouponNameNotEqualTo(String value)
         {
              addCriterion("coupon_name <> ", value, "coupon_name");
              return (Criteria) this;
         }

         public Criteria andCouponNameGreaterThan(String value)
         {
              addCriterion("coupon_name > ", value, "coupon_name");
              return (Criteria) this;
         }

         public Criteria andCouponNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("coupon_name >= ", value, "coupon_name");
              return (Criteria) this;
         }

         public Criteria andCouponNameLessThan(String value)
         {
              addCriterion("coupon_name < ", value, "coupon_name");
              return (Criteria) this;
         }

         public Criteria andCouponNameLessThanOrEqualTo(String value)
         {
              addCriterion("coupon_name <= ", value, "coupon_name");
              return (Criteria) this;
         }

         public Criteria andCouponNameLike(String value)
         {
              addCriterion("coupon_name like ", value, "coupon_name");
              return (Criteria) this;
         }

         public Criteria andCouponNameNotLike(String value)
         {
              addCriterion("coupon_name not like ", value, "coupon_name");
              return (Criteria) this;
         }

         public Criteria andCouponNameIn(List<String> values)
         {
              addCriterion("coupon_name in ", values, "coupon_name");
              return (Criteria) this;
         }

         public Criteria andCouponNameNotIn(List<String> values)
         {
              addCriterion("coupon_name not in ", values, "coupon_name");
              return (Criteria) this;
         }

         public Criteria andCouponNameBetween(String value1, String value2)
         {
              addCriterion("coupon_name between ", value1,value2, "coupon_name");
              return (Criteria) this;
         }

         public Criteria andCouponNameNotBetween(String value1, String value2)
         {
              addCriterion("coupon_name not between ", value1,value2, "coupon_name");
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

         public Criteria andPublishStartTimeIsNull()
         {
              addCriterion("publish_start_time is null");
              return (Criteria) this;
         }

         public Criteria andPublishStartTimeIsNotNull()
         {
              addCriterion("publish_start_time is not null");
              return (Criteria) this;
         }

         public Criteria andPublishStartTimeEqualTo(Date value)
         {
              addCriterion("publish_start_time = ", value, "publish_start_time");
              return (Criteria) this;
         }

         public Criteria andPublishStartTimeNotEqualTo(Date value)
         {
              addCriterion("publish_start_time <> ", value, "publish_start_time");
              return (Criteria) this;
         }

         public Criteria andPublishStartTimeGreaterThan(Date value)
         {
              addCriterion("publish_start_time > ", value, "publish_start_time");
              return (Criteria) this;
         }

         public Criteria andPublishStartTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("publish_start_time >= ", value, "publish_start_time");
              return (Criteria) this;
         }

         public Criteria andPublishStartTimeLessThan(Date value)
         {
              addCriterion("publish_start_time < ", value, "publish_start_time");
              return (Criteria) this;
         }

         public Criteria andPublishStartTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("publish_start_time <= ", value, "publish_start_time");
              return (Criteria) this;
         }

         public Criteria andPublishStartTimeIn(List<Date> values)
         {
              addCriterion("publish_start_time in ", values, "publish_start_time");
              return (Criteria) this;
         }

         public Criteria andPublishStartTimeNotIn(List<Date> values)
         {
              addCriterion("publish_start_time not in ", values, "publish_start_time");
              return (Criteria) this;
         }

         public Criteria andPublishStartTimeBetween(Date value1, Date value2)
         {
              addCriterion("publish_start_time between ", value1,value2, "publish_start_time");
              return (Criteria) this;
         }

         public Criteria andPublishStartTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("publish_start_time not between ", value1,value2, "publish_start_time");
              return (Criteria) this;
         }

         public Criteria andPublishEndTimeIsNull()
         {
              addCriterion("publish_end_time is null");
              return (Criteria) this;
         }

         public Criteria andPublishEndTimeIsNotNull()
         {
              addCriterion("publish_end_time is not null");
              return (Criteria) this;
         }

         public Criteria andPublishEndTimeEqualTo(Date value)
         {
              addCriterion("publish_end_time = ", value, "publish_end_time");
              return (Criteria) this;
         }

         public Criteria andPublishEndTimeNotEqualTo(Date value)
         {
              addCriterion("publish_end_time <> ", value, "publish_end_time");
              return (Criteria) this;
         }

         public Criteria andPublishEndTimeGreaterThan(Date value)
         {
              addCriterion("publish_end_time > ", value, "publish_end_time");
              return (Criteria) this;
         }

         public Criteria andPublishEndTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("publish_end_time >= ", value, "publish_end_time");
              return (Criteria) this;
         }

         public Criteria andPublishEndTimeLessThan(Date value)
         {
              addCriterion("publish_end_time < ", value, "publish_end_time");
              return (Criteria) this;
         }

         public Criteria andPublishEndTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("publish_end_time <= ", value, "publish_end_time");
              return (Criteria) this;
         }

         public Criteria andPublishEndTimeIn(List<Date> values)
         {
              addCriterion("publish_end_time in ", values, "publish_end_time");
              return (Criteria) this;
         }

         public Criteria andPublishEndTimeNotIn(List<Date> values)
         {
              addCriterion("publish_end_time not in ", values, "publish_end_time");
              return (Criteria) this;
         }

         public Criteria andPublishEndTimeBetween(Date value1, Date value2)
         {
              addCriterion("publish_end_time between ", value1,value2, "publish_end_time");
              return (Criteria) this;
         }

         public Criteria andPublishEndTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("publish_end_time not between ", value1,value2, "publish_end_time");
              return (Criteria) this;
         }

         public Criteria andUseStartTimeIsNull()
         {
              addCriterion("use_start_time is null");
              return (Criteria) this;
         }

         public Criteria andUseStartTimeIsNotNull()
         {
              addCriterion("use_start_time is not null");
              return (Criteria) this;
         }

         public Criteria andUseStartTimeEqualTo(Date value)
         {
              addCriterion("use_start_time = ", value, "use_start_time");
              return (Criteria) this;
         }

         public Criteria andUseStartTimeNotEqualTo(Date value)
         {
              addCriterion("use_start_time <> ", value, "use_start_time");
              return (Criteria) this;
         }

         public Criteria andUseStartTimeGreaterThan(Date value)
         {
              addCriterion("use_start_time > ", value, "use_start_time");
              return (Criteria) this;
         }

         public Criteria andUseStartTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("use_start_time >= ", value, "use_start_time");
              return (Criteria) this;
         }

         public Criteria andUseStartTimeLessThan(Date value)
         {
              addCriterion("use_start_time < ", value, "use_start_time");
              return (Criteria) this;
         }

         public Criteria andUseStartTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("use_start_time <= ", value, "use_start_time");
              return (Criteria) this;
         }

         public Criteria andUseStartTimeIn(List<Date> values)
         {
              addCriterion("use_start_time in ", values, "use_start_time");
              return (Criteria) this;
         }

         public Criteria andUseStartTimeNotIn(List<Date> values)
         {
              addCriterion("use_start_time not in ", values, "use_start_time");
              return (Criteria) this;
         }

         public Criteria andUseStartTimeBetween(Date value1, Date value2)
         {
              addCriterion("use_start_time between ", value1,value2, "use_start_time");
              return (Criteria) this;
         }

         public Criteria andUseStartTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("use_start_time not between ", value1,value2, "use_start_time");
              return (Criteria) this;
         }

         public Criteria andUseEndTimeIsNull()
         {
              addCriterion("use_end_time is null");
              return (Criteria) this;
         }

         public Criteria andUseEndTimeIsNotNull()
         {
              addCriterion("use_end_time is not null");
              return (Criteria) this;
         }

         public Criteria andUseEndTimeEqualTo(Date value)
         {
              addCriterion("use_end_time = ", value, "use_end_time");
              return (Criteria) this;
         }

         public Criteria andUseEndTimeNotEqualTo(Date value)
         {
              addCriterion("use_end_time <> ", value, "use_end_time");
              return (Criteria) this;
         }

         public Criteria andUseEndTimeGreaterThan(Date value)
         {
              addCriterion("use_end_time > ", value, "use_end_time");
              return (Criteria) this;
         }

         public Criteria andUseEndTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("use_end_time >= ", value, "use_end_time");
              return (Criteria) this;
         }

         public Criteria andUseEndTimeLessThan(Date value)
         {
              addCriterion("use_end_time < ", value, "use_end_time");
              return (Criteria) this;
         }

         public Criteria andUseEndTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("use_end_time <= ", value, "use_end_time");
              return (Criteria) this;
         }

         public Criteria andUseEndTimeIn(List<Date> values)
         {
              addCriterion("use_end_time in ", values, "use_end_time");
              return (Criteria) this;
         }

         public Criteria andUseEndTimeNotIn(List<Date> values)
         {
              addCriterion("use_end_time not in ", values, "use_end_time");
              return (Criteria) this;
         }

         public Criteria andUseEndTimeBetween(Date value1, Date value2)
         {
              addCriterion("use_end_time between ", value1,value2, "use_end_time");
              return (Criteria) this;
         }

         public Criteria andUseEndTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("use_end_time not between ", value1,value2, "use_end_time");
              return (Criteria) this;
         }

         public Criteria andCouponModeIsNull()
         {
              addCriterion("coupon_mode is null");
              return (Criteria) this;
         }

         public Criteria andCouponModeIsNotNull()
         {
              addCriterion("coupon_mode is not null");
              return (Criteria) this;
         }

         public Criteria andCouponModeEqualTo(String value)
         {
              addCriterion("coupon_mode = ", value, "coupon_mode");
              return (Criteria) this;
         }

         public Criteria andCouponModeNotEqualTo(String value)
         {
              addCriterion("coupon_mode <> ", value, "coupon_mode");
              return (Criteria) this;
         }

         public Criteria andCouponModeGreaterThan(String value)
         {
              addCriterion("coupon_mode > ", value, "coupon_mode");
              return (Criteria) this;
         }

         public Criteria andCouponModeGreaterThanOrEqualTo(String value)
         {
              addCriterion("coupon_mode >= ", value, "coupon_mode");
              return (Criteria) this;
         }

         public Criteria andCouponModeLessThan(String value)
         {
              addCriterion("coupon_mode < ", value, "coupon_mode");
              return (Criteria) this;
         }

         public Criteria andCouponModeLessThanOrEqualTo(String value)
         {
              addCriterion("coupon_mode <= ", value, "coupon_mode");
              return (Criteria) this;
         }

         public Criteria andCouponModeLike(String value)
         {
              addCriterion("coupon_mode like ", value, "coupon_mode");
              return (Criteria) this;
         }

         public Criteria andCouponModeNotLike(String value)
         {
              addCriterion("coupon_mode not like ", value, "coupon_mode");
              return (Criteria) this;
         }

         public Criteria andCouponModeIn(List<String> values)
         {
              addCriterion("coupon_mode in ", values, "coupon_mode");
              return (Criteria) this;
         }

         public Criteria andCouponModeNotIn(List<String> values)
         {
              addCriterion("coupon_mode not in ", values, "coupon_mode");
              return (Criteria) this;
         }

         public Criteria andCouponModeBetween(String value1, String value2)
         {
              addCriterion("coupon_mode between ", value1,value2, "coupon_mode");
              return (Criteria) this;
         }

         public Criteria andCouponModeNotBetween(String value1, String value2)
         {
              addCriterion("coupon_mode not between ", value1,value2, "coupon_mode");
              return (Criteria) this;
         }

         public Criteria andCouponTypeIsNull()
         {
              addCriterion("coupon_type is null");
              return (Criteria) this;
         }

         public Criteria andCouponTypeIsNotNull()
         {
              addCriterion("coupon_type is not null");
              return (Criteria) this;
         }

         public Criteria andCouponTypeEqualTo(String value)
         {
              addCriterion("coupon_type = ", value, "coupon_type");
              return (Criteria) this;
         }

         public Criteria andCouponTypeNotEqualTo(String value)
         {
              addCriterion("coupon_type <> ", value, "coupon_type");
              return (Criteria) this;
         }

         public Criteria andCouponTypeGreaterThan(String value)
         {
              addCriterion("coupon_type > ", value, "coupon_type");
              return (Criteria) this;
         }

         public Criteria andCouponTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("coupon_type >= ", value, "coupon_type");
              return (Criteria) this;
         }

         public Criteria andCouponTypeLessThan(String value)
         {
              addCriterion("coupon_type < ", value, "coupon_type");
              return (Criteria) this;
         }

         public Criteria andCouponTypeLessThanOrEqualTo(String value)
         {
              addCriterion("coupon_type <= ", value, "coupon_type");
              return (Criteria) this;
         }

         public Criteria andCouponTypeLike(String value)
         {
              addCriterion("coupon_type like ", value, "coupon_type");
              return (Criteria) this;
         }

         public Criteria andCouponTypeNotLike(String value)
         {
              addCriterion("coupon_type not like ", value, "coupon_type");
              return (Criteria) this;
         }

         public Criteria andCouponTypeIn(List<String> values)
         {
              addCriterion("coupon_type in ", values, "coupon_type");
              return (Criteria) this;
         }

         public Criteria andCouponTypeNotIn(List<String> values)
         {
              addCriterion("coupon_type not in ", values, "coupon_type");
              return (Criteria) this;
         }

         public Criteria andCouponTypeBetween(String value1, String value2)
         {
              addCriterion("coupon_type between ", value1,value2, "coupon_type");
              return (Criteria) this;
         }

         public Criteria andCouponTypeNotBetween(String value1, String value2)
         {
              addCriterion("coupon_type not between ", value1,value2, "coupon_type");
              return (Criteria) this;
         }

         public Criteria andCouponValueIsNull()
         {
              addCriterion("coupon_value is null");
              return (Criteria) this;
         }

         public Criteria andCouponValueIsNotNull()
         {
              addCriterion("coupon_value is not null");
              return (Criteria) this;
         }

         public Criteria andCouponValueEqualTo(String value)
         {
              addCriterion("coupon_value = ", value, "coupon_value");
              return (Criteria) this;
         }

         public Criteria andCouponValueNotEqualTo(String value)
         {
              addCriterion("coupon_value <> ", value, "coupon_value");
              return (Criteria) this;
         }

         public Criteria andCouponValueGreaterThan(String value)
         {
              addCriterion("coupon_value > ", value, "coupon_value");
              return (Criteria) this;
         }

         public Criteria andCouponValueGreaterThanOrEqualTo(String value)
         {
              addCriterion("coupon_value >= ", value, "coupon_value");
              return (Criteria) this;
         }

         public Criteria andCouponValueLessThan(String value)
         {
              addCriterion("coupon_value < ", value, "coupon_value");
              return (Criteria) this;
         }

         public Criteria andCouponValueLessThanOrEqualTo(String value)
         {
              addCriterion("coupon_value <= ", value, "coupon_value");
              return (Criteria) this;
         }

         public Criteria andCouponValueLike(String value)
         {
              addCriterion("coupon_value like ", value, "coupon_value");
              return (Criteria) this;
         }

         public Criteria andCouponValueNotLike(String value)
         {
              addCriterion("coupon_value not like ", value, "coupon_value");
              return (Criteria) this;
         }

         public Criteria andCouponValueIn(List<String> values)
         {
              addCriterion("coupon_value in ", values, "coupon_value");
              return (Criteria) this;
         }

         public Criteria andCouponValueNotIn(List<String> values)
         {
              addCriterion("coupon_value not in ", values, "coupon_value");
              return (Criteria) this;
         }

         public Criteria andCouponValueBetween(String value1, String value2)
         {
              addCriterion("coupon_value between ", value1,value2, "coupon_value");
              return (Criteria) this;
         }

         public Criteria andCouponValueNotBetween(String value1, String value2)
         {
              addCriterion("coupon_value not between ", value1,value2, "coupon_value");
              return (Criteria) this;
         }

         public Criteria andAmountIsNull()
         {
              addCriterion("amount is null");
              return (Criteria) this;
         }

         public Criteria andAmountIsNotNull()
         {
              addCriterion("amount is not null");
              return (Criteria) this;
         }

         public Criteria andAmountEqualTo(String value)
         {
              addCriterion("amount = ", value, "amount");
              return (Criteria) this;
         }

         public Criteria andAmountNotEqualTo(String value)
         {
              addCriterion("amount <> ", value, "amount");
              return (Criteria) this;
         }

         public Criteria andAmountGreaterThan(String value)
         {
              addCriterion("amount > ", value, "amount");
              return (Criteria) this;
         }

         public Criteria andAmountGreaterThanOrEqualTo(String value)
         {
              addCriterion("amount >= ", value, "amount");
              return (Criteria) this;
         }

         public Criteria andAmountLessThan(String value)
         {
              addCriterion("amount < ", value, "amount");
              return (Criteria) this;
         }

         public Criteria andAmountLessThanOrEqualTo(String value)
         {
              addCriterion("amount <= ", value, "amount");
              return (Criteria) this;
         }

         public Criteria andAmountLike(String value)
         {
              addCriterion("amount like ", value, "amount");
              return (Criteria) this;
         }

         public Criteria andAmountNotLike(String value)
         {
              addCriterion("amount not like ", value, "amount");
              return (Criteria) this;
         }

         public Criteria andAmountIn(List<String> values)
         {
              addCriterion("amount in ", values, "amount");
              return (Criteria) this;
         }

         public Criteria andAmountNotIn(List<String> values)
         {
              addCriterion("amount not in ", values, "amount");
              return (Criteria) this;
         }

         public Criteria andAmountBetween(String value1, String value2)
         {
              addCriterion("amount between ", value1,value2, "amount");
              return (Criteria) this;
         }

         public Criteria andAmountNotBetween(String value1, String value2)
         {
              addCriterion("amount not between ", value1,value2, "amount");
              return (Criteria) this;
         }

         public Criteria andMaxNumOwnerIsNull()
         {
              addCriterion("max_num_owner is null");
              return (Criteria) this;
         }

         public Criteria andMaxNumOwnerIsNotNull()
         {
              addCriterion("max_num_owner is not null");
              return (Criteria) this;
         }

         public Criteria andMaxNumOwnerEqualTo(String value)
         {
              addCriterion("max_num_owner = ", value, "max_num_owner");
              return (Criteria) this;
         }

         public Criteria andMaxNumOwnerNotEqualTo(String value)
         {
              addCriterion("max_num_owner <> ", value, "max_num_owner");
              return (Criteria) this;
         }

         public Criteria andMaxNumOwnerGreaterThan(String value)
         {
              addCriterion("max_num_owner > ", value, "max_num_owner");
              return (Criteria) this;
         }

         public Criteria andMaxNumOwnerGreaterThanOrEqualTo(String value)
         {
              addCriterion("max_num_owner >= ", value, "max_num_owner");
              return (Criteria) this;
         }

         public Criteria andMaxNumOwnerLessThan(String value)
         {
              addCriterion("max_num_owner < ", value, "max_num_owner");
              return (Criteria) this;
         }

         public Criteria andMaxNumOwnerLessThanOrEqualTo(String value)
         {
              addCriterion("max_num_owner <= ", value, "max_num_owner");
              return (Criteria) this;
         }

         public Criteria andMaxNumOwnerLike(String value)
         {
              addCriterion("max_num_owner like ", value, "max_num_owner");
              return (Criteria) this;
         }

         public Criteria andMaxNumOwnerNotLike(String value)
         {
              addCriterion("max_num_owner not like ", value, "max_num_owner");
              return (Criteria) this;
         }

         public Criteria andMaxNumOwnerIn(List<String> values)
         {
              addCriterion("max_num_owner in ", values, "max_num_owner");
              return (Criteria) this;
         }

         public Criteria andMaxNumOwnerNotIn(List<String> values)
         {
              addCriterion("max_num_owner not in ", values, "max_num_owner");
              return (Criteria) this;
         }

         public Criteria andMaxNumOwnerBetween(String value1, String value2)
         {
              addCriterion("max_num_owner between ", value1,value2, "max_num_owner");
              return (Criteria) this;
         }

         public Criteria andMaxNumOwnerNotBetween(String value1, String value2)
         {
              addCriterion("max_num_owner not between ", value1,value2, "max_num_owner");
              return (Criteria) this;
         }

         public Criteria andCouponUrlIsNull()
         {
              addCriterion("coupon_url is null");
              return (Criteria) this;
         }

         public Criteria andCouponUrlIsNotNull()
         {
              addCriterion("coupon_url is not null");
              return (Criteria) this;
         }

         public Criteria andCouponUrlEqualTo(String value)
         {
              addCriterion("coupon_url = ", value, "coupon_url");
              return (Criteria) this;
         }

         public Criteria andCouponUrlNotEqualTo(String value)
         {
              addCriterion("coupon_url <> ", value, "coupon_url");
              return (Criteria) this;
         }

         public Criteria andCouponUrlGreaterThan(String value)
         {
              addCriterion("coupon_url > ", value, "coupon_url");
              return (Criteria) this;
         }

         public Criteria andCouponUrlGreaterThanOrEqualTo(String value)
         {
              addCriterion("coupon_url >= ", value, "coupon_url");
              return (Criteria) this;
         }

         public Criteria andCouponUrlLessThan(String value)
         {
              addCriterion("coupon_url < ", value, "coupon_url");
              return (Criteria) this;
         }

         public Criteria andCouponUrlLessThanOrEqualTo(String value)
         {
              addCriterion("coupon_url <= ", value, "coupon_url");
              return (Criteria) this;
         }

         public Criteria andCouponUrlLike(String value)
         {
              addCriterion("coupon_url like ", value, "coupon_url");
              return (Criteria) this;
         }

         public Criteria andCouponUrlNotLike(String value)
         {
              addCriterion("coupon_url not like ", value, "coupon_url");
              return (Criteria) this;
         }

         public Criteria andCouponUrlIn(List<String> values)
         {
              addCriterion("coupon_url in ", values, "coupon_url");
              return (Criteria) this;
         }

         public Criteria andCouponUrlNotIn(List<String> values)
         {
              addCriterion("coupon_url not in ", values, "coupon_url");
              return (Criteria) this;
         }

         public Criteria andCouponUrlBetween(String value1, String value2)
         {
              addCriterion("coupon_url between ", value1,value2, "coupon_url");
              return (Criteria) this;
         }

         public Criteria andCouponUrlNotBetween(String value1, String value2)
         {
              addCriterion("coupon_url not between ", value1,value2, "coupon_url");
              return (Criteria) this;
         }

         public Criteria andCouponContentIsNull()
         {
              addCriterion("coupon_content is null");
              return (Criteria) this;
         }

         public Criteria andCouponContentIsNotNull()
         {
              addCriterion("coupon_content is not null");
              return (Criteria) this;
         }

         public Criteria andCouponContentEqualTo(String value)
         {
              addCriterion("coupon_content = ", value, "coupon_content");
              return (Criteria) this;
         }

         public Criteria andCouponContentNotEqualTo(String value)
         {
              addCriterion("coupon_content <> ", value, "coupon_content");
              return (Criteria) this;
         }

         public Criteria andCouponContentGreaterThan(String value)
         {
              addCriterion("coupon_content > ", value, "coupon_content");
              return (Criteria) this;
         }

         public Criteria andCouponContentGreaterThanOrEqualTo(String value)
         {
              addCriterion("coupon_content >= ", value, "coupon_content");
              return (Criteria) this;
         }

         public Criteria andCouponContentLessThan(String value)
         {
              addCriterion("coupon_content < ", value, "coupon_content");
              return (Criteria) this;
         }

         public Criteria andCouponContentLessThanOrEqualTo(String value)
         {
              addCriterion("coupon_content <= ", value, "coupon_content");
              return (Criteria) this;
         }

         public Criteria andCouponContentLike(String value)
         {
              addCriterion("coupon_content like ", value, "coupon_content");
              return (Criteria) this;
         }

         public Criteria andCouponContentNotLike(String value)
         {
              addCriterion("coupon_content not like ", value, "coupon_content");
              return (Criteria) this;
         }

         public Criteria andCouponContentIn(List<String> values)
         {
              addCriterion("coupon_content in ", values, "coupon_content");
              return (Criteria) this;
         }

         public Criteria andCouponContentNotIn(List<String> values)
         {
              addCriterion("coupon_content not in ", values, "coupon_content");
              return (Criteria) this;
         }

         public Criteria andCouponContentBetween(String value1, String value2)
         {
              addCriterion("coupon_content between ", value1,value2, "coupon_content");
              return (Criteria) this;
         }

         public Criteria andCouponContentNotBetween(String value1, String value2)
         {
              addCriterion("coupon_content not between ", value1,value2, "coupon_content");
              return (Criteria) this;
         }

         public Criteria andCouponChannleIsNull()
         {
              addCriterion("coupon_channle is null");
              return (Criteria) this;
         }

         public Criteria andCouponChannleIsNotNull()
         {
              addCriterion("coupon_channle is not null");
              return (Criteria) this;
         }

         public Criteria andCouponChannleEqualTo(String value)
         {
              addCriterion("coupon_channle = ", value, "coupon_channle");
              return (Criteria) this;
         }

         public Criteria andCouponChannleNotEqualTo(String value)
         {
              addCriterion("coupon_channle <> ", value, "coupon_channle");
              return (Criteria) this;
         }

         public Criteria andCouponChannleGreaterThan(String value)
         {
              addCriterion("coupon_channle > ", value, "coupon_channle");
              return (Criteria) this;
         }

         public Criteria andCouponChannleGreaterThanOrEqualTo(String value)
         {
              addCriterion("coupon_channle >= ", value, "coupon_channle");
              return (Criteria) this;
         }

         public Criteria andCouponChannleLessThan(String value)
         {
              addCriterion("coupon_channle < ", value, "coupon_channle");
              return (Criteria) this;
         }

         public Criteria andCouponChannleLessThanOrEqualTo(String value)
         {
              addCriterion("coupon_channle <= ", value, "coupon_channle");
              return (Criteria) this;
         }

         public Criteria andCouponChannleLike(String value)
         {
              addCriterion("coupon_channle like ", value, "coupon_channle");
              return (Criteria) this;
         }

         public Criteria andCouponChannleNotLike(String value)
         {
              addCriterion("coupon_channle not like ", value, "coupon_channle");
              return (Criteria) this;
         }

         public Criteria andCouponChannleIn(List<String> values)
         {
              addCriterion("coupon_channle in ", values, "coupon_channle");
              return (Criteria) this;
         }

         public Criteria andCouponChannleNotIn(List<String> values)
         {
              addCriterion("coupon_channle not in ", values, "coupon_channle");
              return (Criteria) this;
         }

         public Criteria andCouponChannleBetween(String value1, String value2)
         {
              addCriterion("coupon_channle between ", value1,value2, "coupon_channle");
              return (Criteria) this;
         }

         public Criteria andCouponChannleNotBetween(String value1, String value2)
         {
              addCriterion("coupon_channle not between ", value1,value2, "coupon_channle");
              return (Criteria) this;
         }

         public Criteria andCouponSourceIsNull()
         {
              addCriterion("coupon_source is null");
              return (Criteria) this;
         }

         public Criteria andCouponSourceIsNotNull()
         {
              addCriterion("coupon_source is not null");
              return (Criteria) this;
         }

         public Criteria andCouponSourceEqualTo(String value)
         {
              addCriterion("coupon_source = ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceNotEqualTo(String value)
         {
              addCriterion("coupon_source <> ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceGreaterThan(String value)
         {
              addCriterion("coupon_source > ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceGreaterThanOrEqualTo(String value)
         {
              addCriterion("coupon_source >= ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceLessThan(String value)
         {
              addCriterion("coupon_source < ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceLessThanOrEqualTo(String value)
         {
              addCriterion("coupon_source <= ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceLike(String value)
         {
              addCriterion("coupon_source like ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceNotLike(String value)
         {
              addCriterion("coupon_source not like ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceIn(List<String> values)
         {
              addCriterion("coupon_source in ", values, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceNotIn(List<String> values)
         {
              addCriterion("coupon_source not in ", values, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceBetween(String value1, String value2)
         {
              addCriterion("coupon_source between ", value1,value2, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceNotBetween(String value1, String value2)
         {
              addCriterion("coupon_source not between ", value1,value2, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCheckJsonIsNull()
         {
              addCriterion("check_json is null");
              return (Criteria) this;
         }

         public Criteria andCheckJsonIsNotNull()
         {
              addCriterion("check_json is not null");
              return (Criteria) this;
         }

         public Criteria andCheckJsonEqualTo(String value)
         {
              addCriterion("check_json = ", value, "check_json");
              return (Criteria) this;
         }

         public Criteria andCheckJsonNotEqualTo(String value)
         {
              addCriterion("check_json <> ", value, "check_json");
              return (Criteria) this;
         }

         public Criteria andCheckJsonGreaterThan(String value)
         {
              addCriterion("check_json > ", value, "check_json");
              return (Criteria) this;
         }

         public Criteria andCheckJsonGreaterThanOrEqualTo(String value)
         {
              addCriterion("check_json >= ", value, "check_json");
              return (Criteria) this;
         }

         public Criteria andCheckJsonLessThan(String value)
         {
              addCriterion("check_json < ", value, "check_json");
              return (Criteria) this;
         }

         public Criteria andCheckJsonLessThanOrEqualTo(String value)
         {
              addCriterion("check_json <= ", value, "check_json");
              return (Criteria) this;
         }

         public Criteria andCheckJsonLike(String value)
         {
              addCriterion("check_json like ", value, "check_json");
              return (Criteria) this;
         }

         public Criteria andCheckJsonNotLike(String value)
         {
              addCriterion("check_json not like ", value, "check_json");
              return (Criteria) this;
         }

         public Criteria andCheckJsonIn(List<String> values)
         {
              addCriterion("check_json in ", values, "check_json");
              return (Criteria) this;
         }

         public Criteria andCheckJsonNotIn(List<String> values)
         {
              addCriterion("check_json not in ", values, "check_json");
              return (Criteria) this;
         }

         public Criteria andCheckJsonBetween(String value1, String value2)
         {
              addCriterion("check_json between ", value1,value2, "check_json");
              return (Criteria) this;
         }

         public Criteria andCheckJsonNotBetween(String value1, String value2)
         {
              addCriterion("check_json not between ", value1,value2, "check_json");
              return (Criteria) this;
         }

         public Criteria andTemplateIdIsNull()
         {
              addCriterion("template_id is null");
              return (Criteria) this;
         }

         public Criteria andTemplateIdIsNotNull()
         {
              addCriterion("template_id is not null");
              return (Criteria) this;
         }

         public Criteria andTemplateIdEqualTo(String value)
         {
              addCriterion("template_id = ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdNotEqualTo(String value)
         {
              addCriterion("template_id <> ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdGreaterThan(String value)
         {
              addCriterion("template_id > ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("template_id >= ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdLessThan(String value)
         {
              addCriterion("template_id < ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdLessThanOrEqualTo(String value)
         {
              addCriterion("template_id <= ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdLike(String value)
         {
              addCriterion("template_id like ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdNotLike(String value)
         {
              addCriterion("template_id not like ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdIn(List<String> values)
         {
              addCriterion("template_id in ", values, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdNotIn(List<String> values)
         {
              addCriterion("template_id not in ", values, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdBetween(String value1, String value2)
         {
              addCriterion("template_id between ", value1,value2, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdNotBetween(String value1, String value2)
         {
              addCriterion("template_id not between ", value1,value2, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateDataIsNull()
         {
              addCriterion("template_data is null");
              return (Criteria) this;
         }

         public Criteria andTemplateDataIsNotNull()
         {
              addCriterion("template_data is not null");
              return (Criteria) this;
         }

         public Criteria andTemplateDataEqualTo(String value)
         {
              addCriterion("template_data = ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataNotEqualTo(String value)
         {
              addCriterion("template_data <> ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataGreaterThan(String value)
         {
              addCriterion("template_data > ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataGreaterThanOrEqualTo(String value)
         {
              addCriterion("template_data >= ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataLessThan(String value)
         {
              addCriterion("template_data < ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataLessThanOrEqualTo(String value)
         {
              addCriterion("template_data <= ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataLike(String value)
         {
              addCriterion("template_data like ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataNotLike(String value)
         {
              addCriterion("template_data not like ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataIn(List<String> values)
         {
              addCriterion("template_data in ", values, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataNotIn(List<String> values)
         {
              addCriterion("template_data not in ", values, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataBetween(String value1, String value2)
         {
              addCriterion("template_data between ", value1,value2, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataNotBetween(String value1, String value2)
         {
              addCriterion("template_data not between ", value1,value2, "template_data");
              return (Criteria) this;
         }

         public Criteria andPublishStatusIsNull()
         {
              addCriterion("publish_status is null");
              return (Criteria) this;
         }

         public Criteria andPublishStatusIsNotNull()
         {
              addCriterion("publish_status is not null");
              return (Criteria) this;
         }

         public Criteria andPublishStatusEqualTo(String value)
         {
              addCriterion("publish_status = ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusNotEqualTo(String value)
         {
              addCriterion("publish_status <> ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusGreaterThan(String value)
         {
              addCriterion("publish_status > ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusGreaterThanOrEqualTo(String value)
         {
              addCriterion("publish_status >= ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusLessThan(String value)
         {
              addCriterion("publish_status < ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusLessThanOrEqualTo(String value)
         {
              addCriterion("publish_status <= ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusLike(String value)
         {
              addCriterion("publish_status like ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusNotLike(String value)
         {
              addCriterion("publish_status not like ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusIn(List<String> values)
         {
              addCriterion("publish_status in ", values, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusNotIn(List<String> values)
         {
              addCriterion("publish_status not in ", values, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusBetween(String value1, String value2)
         {
              addCriterion("publish_status between ", value1,value2, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusNotBetween(String value1, String value2)
         {
              addCriterion("publish_status not between ", value1,value2, "publish_status");
              return (Criteria) this;
         }

         public Criteria andAuditNoteIsNull()
         {
              addCriterion("audit_note is null");
              return (Criteria) this;
         }

         public Criteria andAuditNoteIsNotNull()
         {
              addCriterion("audit_note is not null");
              return (Criteria) this;
         }

         public Criteria andAuditNoteEqualTo(String value)
         {
              addCriterion("audit_note = ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteNotEqualTo(String value)
         {
              addCriterion("audit_note <> ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteGreaterThan(String value)
         {
              addCriterion("audit_note > ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteGreaterThanOrEqualTo(String value)
         {
              addCriterion("audit_note >= ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteLessThan(String value)
         {
              addCriterion("audit_note < ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteLessThanOrEqualTo(String value)
         {
              addCriterion("audit_note <= ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteLike(String value)
         {
              addCriterion("audit_note like ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteNotLike(String value)
         {
              addCriterion("audit_note not like ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteIn(List<String> values)
         {
              addCriterion("audit_note in ", values, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteNotIn(List<String> values)
         {
              addCriterion("audit_note not in ", values, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteBetween(String value1, String value2)
         {
              addCriterion("audit_note between ", value1,value2, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteNotBetween(String value1, String value2)
         {
              addCriterion("audit_note not between ", value1,value2, "audit_note");
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
