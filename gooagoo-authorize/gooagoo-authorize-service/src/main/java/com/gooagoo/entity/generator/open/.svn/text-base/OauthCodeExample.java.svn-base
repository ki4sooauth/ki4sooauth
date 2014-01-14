package com.gooagoo.entity.generator.open;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 授权code
 */

public class OauthCodeExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public OauthCodeExample()
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

         public Criteria andAppKeyIsNull()
         {
              addCriterion("app_key is null");
              return (Criteria) this;
         }

         public Criteria andAppKeyIsNotNull()
         {
              addCriterion("app_key is not null");
              return (Criteria) this;
         }

         public Criteria andAppKeyEqualTo(String value)
         {
              addCriterion("app_key = ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyNotEqualTo(String value)
         {
              addCriterion("app_key <> ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyGreaterThan(String value)
         {
              addCriterion("app_key > ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyGreaterThanOrEqualTo(String value)
         {
              addCriterion("app_key >= ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyLessThan(String value)
         {
              addCriterion("app_key < ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyLessThanOrEqualTo(String value)
         {
              addCriterion("app_key <= ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyLike(String value)
         {
              addCriterion("app_key like ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyNotLike(String value)
         {
              addCriterion("app_key not like ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyIn(List<String> values)
         {
              addCriterion("app_key in ", values, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyNotIn(List<String> values)
         {
              addCriterion("app_key not in ", values, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyBetween(String value1, String value2)
         {
              addCriterion("app_key between ", value1,value2, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyNotBetween(String value1, String value2)
         {
              addCriterion("app_key not between ", value1,value2, "app_key");
              return (Criteria) this;
         }

         public Criteria andCodeIsNull()
         {
              addCriterion("code is null");
              return (Criteria) this;
         }

         public Criteria andCodeIsNotNull()
         {
              addCriterion("code is not null");
              return (Criteria) this;
         }

         public Criteria andCodeEqualTo(String value)
         {
              addCriterion("code = ", value, "code");
              return (Criteria) this;
         }

         public Criteria andCodeNotEqualTo(String value)
         {
              addCriterion("code <> ", value, "code");
              return (Criteria) this;
         }

         public Criteria andCodeGreaterThan(String value)
         {
              addCriterion("code > ", value, "code");
              return (Criteria) this;
         }

         public Criteria andCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("code >= ", value, "code");
              return (Criteria) this;
         }

         public Criteria andCodeLessThan(String value)
         {
              addCriterion("code < ", value, "code");
              return (Criteria) this;
         }

         public Criteria andCodeLessThanOrEqualTo(String value)
         {
              addCriterion("code <= ", value, "code");
              return (Criteria) this;
         }

         public Criteria andCodeLike(String value)
         {
              addCriterion("code like ", value, "code");
              return (Criteria) this;
         }

         public Criteria andCodeNotLike(String value)
         {
              addCriterion("code not like ", value, "code");
              return (Criteria) this;
         }

         public Criteria andCodeIn(List<String> values)
         {
              addCriterion("code in ", values, "code");
              return (Criteria) this;
         }

         public Criteria andCodeNotIn(List<String> values)
         {
              addCriterion("code not in ", values, "code");
              return (Criteria) this;
         }

         public Criteria andCodeBetween(String value1, String value2)
         {
              addCriterion("code between ", value1,value2, "code");
              return (Criteria) this;
         }

         public Criteria andCodeNotBetween(String value1, String value2)
         {
              addCriterion("code not between ", value1,value2, "code");
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

         public Criteria andExpireTimeIsNull()
         {
              addCriterion("expire_time is null");
              return (Criteria) this;
         }

         public Criteria andExpireTimeIsNotNull()
         {
              addCriterion("expire_time is not null");
              return (Criteria) this;
         }

         public Criteria andExpireTimeEqualTo(Date value)
         {
              addCriterion("expire_time = ", value, "expire_time");
              return (Criteria) this;
         }

         public Criteria andExpireTimeNotEqualTo(Date value)
         {
              addCriterion("expire_time <> ", value, "expire_time");
              return (Criteria) this;
         }

         public Criteria andExpireTimeGreaterThan(Date value)
         {
              addCriterion("expire_time > ", value, "expire_time");
              return (Criteria) this;
         }

         public Criteria andExpireTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("expire_time >= ", value, "expire_time");
              return (Criteria) this;
         }

         public Criteria andExpireTimeLessThan(Date value)
         {
              addCriterion("expire_time < ", value, "expire_time");
              return (Criteria) this;
         }

         public Criteria andExpireTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("expire_time <= ", value, "expire_time");
              return (Criteria) this;
         }

         public Criteria andExpireTimeIn(List<Date> values)
         {
              addCriterion("expire_time in ", values, "expire_time");
              return (Criteria) this;
         }

         public Criteria andExpireTimeNotIn(List<Date> values)
         {
              addCriterion("expire_time not in ", values, "expire_time");
              return (Criteria) this;
         }

         public Criteria andExpireTimeBetween(Date value1, Date value2)
         {
              addCriterion("expire_time between ", value1,value2, "expire_time");
              return (Criteria) this;
         }

         public Criteria andExpireTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("expire_time not between ", value1,value2, "expire_time");
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
