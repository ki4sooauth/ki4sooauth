package com.gooagoo.entity.generator.marketing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 优惠凭证发放号段对应表
 */

public class CouponGrantInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public CouponGrantInfoExample()
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

         public Criteria andCouponNoIsNull()
         {
              addCriterion("coupon_no is null");
              return (Criteria) this;
         }

         public Criteria andCouponNoIsNotNull()
         {
              addCriterion("coupon_no is not null");
              return (Criteria) this;
         }

         public Criteria andCouponNoEqualTo(String value)
         {
              addCriterion("coupon_no = ", value, "coupon_no");
              return (Criteria) this;
         }

         public Criteria andCouponNoNotEqualTo(String value)
         {
              addCriterion("coupon_no <> ", value, "coupon_no");
              return (Criteria) this;
         }

         public Criteria andCouponNoGreaterThan(String value)
         {
              addCriterion("coupon_no > ", value, "coupon_no");
              return (Criteria) this;
         }

         public Criteria andCouponNoGreaterThanOrEqualTo(String value)
         {
              addCriterion("coupon_no >= ", value, "coupon_no");
              return (Criteria) this;
         }

         public Criteria andCouponNoLessThan(String value)
         {
              addCriterion("coupon_no < ", value, "coupon_no");
              return (Criteria) this;
         }

         public Criteria andCouponNoLessThanOrEqualTo(String value)
         {
              addCriterion("coupon_no <= ", value, "coupon_no");
              return (Criteria) this;
         }

         public Criteria andCouponNoLike(String value)
         {
              addCriterion("coupon_no like ", value, "coupon_no");
              return (Criteria) this;
         }

         public Criteria andCouponNoNotLike(String value)
         {
              addCriterion("coupon_no not like ", value, "coupon_no");
              return (Criteria) this;
         }

         public Criteria andCouponNoIn(List<String> values)
         {
              addCriterion("coupon_no in ", values, "coupon_no");
              return (Criteria) this;
         }

         public Criteria andCouponNoNotIn(List<String> values)
         {
              addCriterion("coupon_no not in ", values, "coupon_no");
              return (Criteria) this;
         }

         public Criteria andCouponNoBetween(String value1, String value2)
         {
              addCriterion("coupon_no between ", value1,value2, "coupon_no");
              return (Criteria) this;
         }

         public Criteria andCouponNoNotBetween(String value1, String value2)
         {
              addCriterion("coupon_no not between ", value1,value2, "coupon_no");
              return (Criteria) this;
         }

         public Criteria andCouponAudioIdIsNull()
         {
              addCriterion("coupon_audio_id is null");
              return (Criteria) this;
         }

         public Criteria andCouponAudioIdIsNotNull()
         {
              addCriterion("coupon_audio_id is not null");
              return (Criteria) this;
         }

         public Criteria andCouponAudioIdEqualTo(String value)
         {
              addCriterion("coupon_audio_id = ", value, "coupon_audio_id");
              return (Criteria) this;
         }

         public Criteria andCouponAudioIdNotEqualTo(String value)
         {
              addCriterion("coupon_audio_id <> ", value, "coupon_audio_id");
              return (Criteria) this;
         }

         public Criteria andCouponAudioIdGreaterThan(String value)
         {
              addCriterion("coupon_audio_id > ", value, "coupon_audio_id");
              return (Criteria) this;
         }

         public Criteria andCouponAudioIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("coupon_audio_id >= ", value, "coupon_audio_id");
              return (Criteria) this;
         }

         public Criteria andCouponAudioIdLessThan(String value)
         {
              addCriterion("coupon_audio_id < ", value, "coupon_audio_id");
              return (Criteria) this;
         }

         public Criteria andCouponAudioIdLessThanOrEqualTo(String value)
         {
              addCriterion("coupon_audio_id <= ", value, "coupon_audio_id");
              return (Criteria) this;
         }

         public Criteria andCouponAudioIdLike(String value)
         {
              addCriterion("coupon_audio_id like ", value, "coupon_audio_id");
              return (Criteria) this;
         }

         public Criteria andCouponAudioIdNotLike(String value)
         {
              addCriterion("coupon_audio_id not like ", value, "coupon_audio_id");
              return (Criteria) this;
         }

         public Criteria andCouponAudioIdIn(List<String> values)
         {
              addCriterion("coupon_audio_id in ", values, "coupon_audio_id");
              return (Criteria) this;
         }

         public Criteria andCouponAudioIdNotIn(List<String> values)
         {
              addCriterion("coupon_audio_id not in ", values, "coupon_audio_id");
              return (Criteria) this;
         }

         public Criteria andCouponAudioIdBetween(String value1, String value2)
         {
              addCriterion("coupon_audio_id between ", value1,value2, "coupon_audio_id");
              return (Criteria) this;
         }

         public Criteria andCouponAudioIdNotBetween(String value1, String value2)
         {
              addCriterion("coupon_audio_id not between ", value1,value2, "coupon_audio_id");
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
