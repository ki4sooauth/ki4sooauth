package com.gooagoo.entity.generator.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 手机验证码
 */

public class UserMobileCodeExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public UserMobileCodeExample()
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

         public Criteria andMobileIsNull()
         {
              addCriterion("mobile is null");
              return (Criteria) this;
         }

         public Criteria andMobileIsNotNull()
         {
              addCriterion("mobile is not null");
              return (Criteria) this;
         }

         public Criteria andMobileEqualTo(String value)
         {
              addCriterion("mobile = ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileNotEqualTo(String value)
         {
              addCriterion("mobile <> ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileGreaterThan(String value)
         {
              addCriterion("mobile > ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileGreaterThanOrEqualTo(String value)
         {
              addCriterion("mobile >= ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileLessThan(String value)
         {
              addCriterion("mobile < ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileLessThanOrEqualTo(String value)
         {
              addCriterion("mobile <= ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileLike(String value)
         {
              addCriterion("mobile like ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileNotLike(String value)
         {
              addCriterion("mobile not like ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileIn(List<String> values)
         {
              addCriterion("mobile in ", values, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileNotIn(List<String> values)
         {
              addCriterion("mobile not in ", values, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileBetween(String value1, String value2)
         {
              addCriterion("mobile between ", value1,value2, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileNotBetween(String value1, String value2)
         {
              addCriterion("mobile not between ", value1,value2, "mobile");
              return (Criteria) this;
         }

         public Criteria andCaptchaCodeIsNull()
         {
              addCriterion("captcha_code is null");
              return (Criteria) this;
         }

         public Criteria andCaptchaCodeIsNotNull()
         {
              addCriterion("captcha_code is not null");
              return (Criteria) this;
         }

         public Criteria andCaptchaCodeEqualTo(String value)
         {
              addCriterion("captcha_code = ", value, "captcha_code");
              return (Criteria) this;
         }

         public Criteria andCaptchaCodeNotEqualTo(String value)
         {
              addCriterion("captcha_code <> ", value, "captcha_code");
              return (Criteria) this;
         }

         public Criteria andCaptchaCodeGreaterThan(String value)
         {
              addCriterion("captcha_code > ", value, "captcha_code");
              return (Criteria) this;
         }

         public Criteria andCaptchaCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("captcha_code >= ", value, "captcha_code");
              return (Criteria) this;
         }

         public Criteria andCaptchaCodeLessThan(String value)
         {
              addCriterion("captcha_code < ", value, "captcha_code");
              return (Criteria) this;
         }

         public Criteria andCaptchaCodeLessThanOrEqualTo(String value)
         {
              addCriterion("captcha_code <= ", value, "captcha_code");
              return (Criteria) this;
         }

         public Criteria andCaptchaCodeLike(String value)
         {
              addCriterion("captcha_code like ", value, "captcha_code");
              return (Criteria) this;
         }

         public Criteria andCaptchaCodeNotLike(String value)
         {
              addCriterion("captcha_code not like ", value, "captcha_code");
              return (Criteria) this;
         }

         public Criteria andCaptchaCodeIn(List<String> values)
         {
              addCriterion("captcha_code in ", values, "captcha_code");
              return (Criteria) this;
         }

         public Criteria andCaptchaCodeNotIn(List<String> values)
         {
              addCriterion("captcha_code not in ", values, "captcha_code");
              return (Criteria) this;
         }

         public Criteria andCaptchaCodeBetween(String value1, String value2)
         {
              addCriterion("captcha_code between ", value1,value2, "captcha_code");
              return (Criteria) this;
         }

         public Criteria andCaptchaCodeNotBetween(String value1, String value2)
         {
              addCriterion("captcha_code not between ", value1,value2, "captcha_code");
              return (Criteria) this;
         }

         public Criteria andExpDateIsNull()
         {
              addCriterion("exp_date is null");
              return (Criteria) this;
         }

         public Criteria andExpDateIsNotNull()
         {
              addCriterion("exp_date is not null");
              return (Criteria) this;
         }

         public Criteria andExpDateEqualTo(Date value)
         {
              addCriterion("exp_date = ", value, "exp_date");
              return (Criteria) this;
         }

         public Criteria andExpDateNotEqualTo(Date value)
         {
              addCriterion("exp_date <> ", value, "exp_date");
              return (Criteria) this;
         }

         public Criteria andExpDateGreaterThan(Date value)
         {
              addCriterion("exp_date > ", value, "exp_date");
              return (Criteria) this;
         }

         public Criteria andExpDateGreaterThanOrEqualTo(Date value)
         {
              addCriterion("exp_date >= ", value, "exp_date");
              return (Criteria) this;
         }

         public Criteria andExpDateLessThan(Date value)
         {
              addCriterion("exp_date < ", value, "exp_date");
              return (Criteria) this;
         }

         public Criteria andExpDateLessThanOrEqualTo(Date value)
         {
              addCriterion("exp_date <= ", value, "exp_date");
              return (Criteria) this;
         }

         public Criteria andExpDateIn(List<Date> values)
         {
              addCriterion("exp_date in ", values, "exp_date");
              return (Criteria) this;
         }

         public Criteria andExpDateNotIn(List<Date> values)
         {
              addCriterion("exp_date not in ", values, "exp_date");
              return (Criteria) this;
         }

         public Criteria andExpDateBetween(Date value1, Date value2)
         {
              addCriterion("exp_date between ", value1,value2, "exp_date");
              return (Criteria) this;
         }

         public Criteria andExpDateNotBetween(Date value1, Date value2)
         {
              addCriterion("exp_date not between ", value1,value2, "exp_date");
              return (Criteria) this;
         }

         public Criteria andIsUsedIsNull()
         {
              addCriterion("is_used is null");
              return (Criteria) this;
         }

         public Criteria andIsUsedIsNotNull()
         {
              addCriterion("is_used is not null");
              return (Criteria) this;
         }

         public Criteria andIsUsedEqualTo(String value)
         {
              addCriterion("is_used = ", value, "is_used");
              return (Criteria) this;
         }

         public Criteria andIsUsedNotEqualTo(String value)
         {
              addCriterion("is_used <> ", value, "is_used");
              return (Criteria) this;
         }

         public Criteria andIsUsedGreaterThan(String value)
         {
              addCriterion("is_used > ", value, "is_used");
              return (Criteria) this;
         }

         public Criteria andIsUsedGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_used >= ", value, "is_used");
              return (Criteria) this;
         }

         public Criteria andIsUsedLessThan(String value)
         {
              addCriterion("is_used < ", value, "is_used");
              return (Criteria) this;
         }

         public Criteria andIsUsedLessThanOrEqualTo(String value)
         {
              addCriterion("is_used <= ", value, "is_used");
              return (Criteria) this;
         }

         public Criteria andIsUsedLike(String value)
         {
              addCriterion("is_used like ", value, "is_used");
              return (Criteria) this;
         }

         public Criteria andIsUsedNotLike(String value)
         {
              addCriterion("is_used not like ", value, "is_used");
              return (Criteria) this;
         }

         public Criteria andIsUsedIn(List<String> values)
         {
              addCriterion("is_used in ", values, "is_used");
              return (Criteria) this;
         }

         public Criteria andIsUsedNotIn(List<String> values)
         {
              addCriterion("is_used not in ", values, "is_used");
              return (Criteria) this;
         }

         public Criteria andIsUsedBetween(String value1, String value2)
         {
              addCriterion("is_used between ", value1,value2, "is_used");
              return (Criteria) this;
         }

         public Criteria andIsUsedNotBetween(String value1, String value2)
         {
              addCriterion("is_used not between ", value1,value2, "is_used");
              return (Criteria) this;
         }

         public Criteria andUseDateIsNull()
         {
              addCriterion("use_date is null");
              return (Criteria) this;
         }

         public Criteria andUseDateIsNotNull()
         {
              addCriterion("use_date is not null");
              return (Criteria) this;
         }

         public Criteria andUseDateEqualTo(Date value)
         {
              addCriterion("use_date = ", value, "use_date");
              return (Criteria) this;
         }

         public Criteria andUseDateNotEqualTo(Date value)
         {
              addCriterion("use_date <> ", value, "use_date");
              return (Criteria) this;
         }

         public Criteria andUseDateGreaterThan(Date value)
         {
              addCriterion("use_date > ", value, "use_date");
              return (Criteria) this;
         }

         public Criteria andUseDateGreaterThanOrEqualTo(Date value)
         {
              addCriterion("use_date >= ", value, "use_date");
              return (Criteria) this;
         }

         public Criteria andUseDateLessThan(Date value)
         {
              addCriterion("use_date < ", value, "use_date");
              return (Criteria) this;
         }

         public Criteria andUseDateLessThanOrEqualTo(Date value)
         {
              addCriterion("use_date <= ", value, "use_date");
              return (Criteria) this;
         }

         public Criteria andUseDateIn(List<Date> values)
         {
              addCriterion("use_date in ", values, "use_date");
              return (Criteria) this;
         }

         public Criteria andUseDateNotIn(List<Date> values)
         {
              addCriterion("use_date not in ", values, "use_date");
              return (Criteria) this;
         }

         public Criteria andUseDateBetween(Date value1, Date value2)
         {
              addCriterion("use_date between ", value1,value2, "use_date");
              return (Criteria) this;
         }

         public Criteria andUseDateNotBetween(Date value1, Date value2)
         {
              addCriterion("use_date not between ", value1,value2, "use_date");
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
