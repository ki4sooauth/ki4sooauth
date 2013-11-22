package com.gooagoo.entity.generator.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 系统配置信息
 */

public class SysConfigExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public SysConfigExample()
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

         public Criteria andConfigKeyIsNull()
         {
              addCriterion("config_key is null");
              return (Criteria) this;
         }

         public Criteria andConfigKeyIsNotNull()
         {
              addCriterion("config_key is not null");
              return (Criteria) this;
         }

         public Criteria andConfigKeyEqualTo(String value)
         {
              addCriterion("config_key = ", value, "config_key");
              return (Criteria) this;
         }

         public Criteria andConfigKeyNotEqualTo(String value)
         {
              addCriterion("config_key <> ", value, "config_key");
              return (Criteria) this;
         }

         public Criteria andConfigKeyGreaterThan(String value)
         {
              addCriterion("config_key > ", value, "config_key");
              return (Criteria) this;
         }

         public Criteria andConfigKeyGreaterThanOrEqualTo(String value)
         {
              addCriterion("config_key >= ", value, "config_key");
              return (Criteria) this;
         }

         public Criteria andConfigKeyLessThan(String value)
         {
              addCriterion("config_key < ", value, "config_key");
              return (Criteria) this;
         }

         public Criteria andConfigKeyLessThanOrEqualTo(String value)
         {
              addCriterion("config_key <= ", value, "config_key");
              return (Criteria) this;
         }

         public Criteria andConfigKeyLike(String value)
         {
              addCriterion("config_key like ", value, "config_key");
              return (Criteria) this;
         }

         public Criteria andConfigKeyNotLike(String value)
         {
              addCriterion("config_key not like ", value, "config_key");
              return (Criteria) this;
         }

         public Criteria andConfigKeyIn(List<String> values)
         {
              addCriterion("config_key in ", values, "config_key");
              return (Criteria) this;
         }

         public Criteria andConfigKeyNotIn(List<String> values)
         {
              addCriterion("config_key not in ", values, "config_key");
              return (Criteria) this;
         }

         public Criteria andConfigKeyBetween(String value1, String value2)
         {
              addCriterion("config_key between ", value1,value2, "config_key");
              return (Criteria) this;
         }

         public Criteria andConfigKeyNotBetween(String value1, String value2)
         {
              addCriterion("config_key not between ", value1,value2, "config_key");
              return (Criteria) this;
         }

         public Criteria andConfigValueIsNull()
         {
              addCriterion("config_value is null");
              return (Criteria) this;
         }

         public Criteria andConfigValueIsNotNull()
         {
              addCriterion("config_value is not null");
              return (Criteria) this;
         }

         public Criteria andConfigValueEqualTo(String value)
         {
              addCriterion("config_value = ", value, "config_value");
              return (Criteria) this;
         }

         public Criteria andConfigValueNotEqualTo(String value)
         {
              addCriterion("config_value <> ", value, "config_value");
              return (Criteria) this;
         }

         public Criteria andConfigValueGreaterThan(String value)
         {
              addCriterion("config_value > ", value, "config_value");
              return (Criteria) this;
         }

         public Criteria andConfigValueGreaterThanOrEqualTo(String value)
         {
              addCriterion("config_value >= ", value, "config_value");
              return (Criteria) this;
         }

         public Criteria andConfigValueLessThan(String value)
         {
              addCriterion("config_value < ", value, "config_value");
              return (Criteria) this;
         }

         public Criteria andConfigValueLessThanOrEqualTo(String value)
         {
              addCriterion("config_value <= ", value, "config_value");
              return (Criteria) this;
         }

         public Criteria andConfigValueLike(String value)
         {
              addCriterion("config_value like ", value, "config_value");
              return (Criteria) this;
         }

         public Criteria andConfigValueNotLike(String value)
         {
              addCriterion("config_value not like ", value, "config_value");
              return (Criteria) this;
         }

         public Criteria andConfigValueIn(List<String> values)
         {
              addCriterion("config_value in ", values, "config_value");
              return (Criteria) this;
         }

         public Criteria andConfigValueNotIn(List<String> values)
         {
              addCriterion("config_value not in ", values, "config_value");
              return (Criteria) this;
         }

         public Criteria andConfigValueBetween(String value1, String value2)
         {
              addCriterion("config_value between ", value1,value2, "config_value");
              return (Criteria) this;
         }

         public Criteria andConfigValueNotBetween(String value1, String value2)
         {
              addCriterion("config_value not between ", value1,value2, "config_value");
              return (Criteria) this;
         }

         public Criteria andNoteIsNull()
         {
              addCriterion("note is null");
              return (Criteria) this;
         }

         public Criteria andNoteIsNotNull()
         {
              addCriterion("note is not null");
              return (Criteria) this;
         }

         public Criteria andNoteEqualTo(String value)
         {
              addCriterion("note = ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteNotEqualTo(String value)
         {
              addCriterion("note <> ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteGreaterThan(String value)
         {
              addCriterion("note > ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteGreaterThanOrEqualTo(String value)
         {
              addCriterion("note >= ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteLessThan(String value)
         {
              addCriterion("note < ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteLessThanOrEqualTo(String value)
         {
              addCriterion("note <= ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteLike(String value)
         {
              addCriterion("note like ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteNotLike(String value)
         {
              addCriterion("note not like ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteIn(List<String> values)
         {
              addCriterion("note in ", values, "note");
              return (Criteria) this;
         }

         public Criteria andNoteNotIn(List<String> values)
         {
              addCriterion("note not in ", values, "note");
              return (Criteria) this;
         }

         public Criteria andNoteBetween(String value1, String value2)
         {
              addCriterion("note between ", value1,value2, "note");
              return (Criteria) this;
         }

         public Criteria andNoteNotBetween(String value1, String value2)
         {
              addCriterion("note not between ", value1,value2, "note");
              return (Criteria) this;
         }

         public Criteria andSysTypeIsNull()
         {
              addCriterion("sys_type is null");
              return (Criteria) this;
         }

         public Criteria andSysTypeIsNotNull()
         {
              addCriterion("sys_type is not null");
              return (Criteria) this;
         }

         public Criteria andSysTypeEqualTo(String value)
         {
              addCriterion("sys_type = ", value, "sys_type");
              return (Criteria) this;
         }

         public Criteria andSysTypeNotEqualTo(String value)
         {
              addCriterion("sys_type <> ", value, "sys_type");
              return (Criteria) this;
         }

         public Criteria andSysTypeGreaterThan(String value)
         {
              addCriterion("sys_type > ", value, "sys_type");
              return (Criteria) this;
         }

         public Criteria andSysTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("sys_type >= ", value, "sys_type");
              return (Criteria) this;
         }

         public Criteria andSysTypeLessThan(String value)
         {
              addCriterion("sys_type < ", value, "sys_type");
              return (Criteria) this;
         }

         public Criteria andSysTypeLessThanOrEqualTo(String value)
         {
              addCriterion("sys_type <= ", value, "sys_type");
              return (Criteria) this;
         }

         public Criteria andSysTypeLike(String value)
         {
              addCriterion("sys_type like ", value, "sys_type");
              return (Criteria) this;
         }

         public Criteria andSysTypeNotLike(String value)
         {
              addCriterion("sys_type not like ", value, "sys_type");
              return (Criteria) this;
         }

         public Criteria andSysTypeIn(List<String> values)
         {
              addCriterion("sys_type in ", values, "sys_type");
              return (Criteria) this;
         }

         public Criteria andSysTypeNotIn(List<String> values)
         {
              addCriterion("sys_type not in ", values, "sys_type");
              return (Criteria) this;
         }

         public Criteria andSysTypeBetween(String value1, String value2)
         {
              addCriterion("sys_type between ", value1,value2, "sys_type");
              return (Criteria) this;
         }

         public Criteria andSysTypeNotBetween(String value1, String value2)
         {
              addCriterion("sys_type not between ", value1,value2, "sys_type");
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
