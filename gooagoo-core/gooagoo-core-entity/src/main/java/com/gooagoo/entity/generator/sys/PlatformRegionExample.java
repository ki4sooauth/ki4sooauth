package com.gooagoo.entity.generator.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 区域性小平台
 */

public class PlatformRegionExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public PlatformRegionExample()
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

         public Criteria andPlatformIdIsNull()
         {
              addCriterion("platform_id is null");
              return (Criteria) this;
         }

         public Criteria andPlatformIdIsNotNull()
         {
              addCriterion("platform_id is not null");
              return (Criteria) this;
         }

         public Criteria andPlatformIdEqualTo(String value)
         {
              addCriterion("platform_id = ", value, "platform_id");
              return (Criteria) this;
         }

         public Criteria andPlatformIdNotEqualTo(String value)
         {
              addCriterion("platform_id <> ", value, "platform_id");
              return (Criteria) this;
         }

         public Criteria andPlatformIdGreaterThan(String value)
         {
              addCriterion("platform_id > ", value, "platform_id");
              return (Criteria) this;
         }

         public Criteria andPlatformIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("platform_id >= ", value, "platform_id");
              return (Criteria) this;
         }

         public Criteria andPlatformIdLessThan(String value)
         {
              addCriterion("platform_id < ", value, "platform_id");
              return (Criteria) this;
         }

         public Criteria andPlatformIdLessThanOrEqualTo(String value)
         {
              addCriterion("platform_id <= ", value, "platform_id");
              return (Criteria) this;
         }

         public Criteria andPlatformIdLike(String value)
         {
              addCriterion("platform_id like ", value, "platform_id");
              return (Criteria) this;
         }

         public Criteria andPlatformIdNotLike(String value)
         {
              addCriterion("platform_id not like ", value, "platform_id");
              return (Criteria) this;
         }

         public Criteria andPlatformIdIn(List<String> values)
         {
              addCriterion("platform_id in ", values, "platform_id");
              return (Criteria) this;
         }

         public Criteria andPlatformIdNotIn(List<String> values)
         {
              addCriterion("platform_id not in ", values, "platform_id");
              return (Criteria) this;
         }

         public Criteria andPlatformIdBetween(String value1, String value2)
         {
              addCriterion("platform_id between ", value1,value2, "platform_id");
              return (Criteria) this;
         }

         public Criteria andPlatformIdNotBetween(String value1, String value2)
         {
              addCriterion("platform_id not between ", value1,value2, "platform_id");
              return (Criteria) this;
         }

         public Criteria andPlatformNameIsNull()
         {
              addCriterion("platform_name is null");
              return (Criteria) this;
         }

         public Criteria andPlatformNameIsNotNull()
         {
              addCriterion("platform_name is not null");
              return (Criteria) this;
         }

         public Criteria andPlatformNameEqualTo(String value)
         {
              addCriterion("platform_name = ", value, "platform_name");
              return (Criteria) this;
         }

         public Criteria andPlatformNameNotEqualTo(String value)
         {
              addCriterion("platform_name <> ", value, "platform_name");
              return (Criteria) this;
         }

         public Criteria andPlatformNameGreaterThan(String value)
         {
              addCriterion("platform_name > ", value, "platform_name");
              return (Criteria) this;
         }

         public Criteria andPlatformNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("platform_name >= ", value, "platform_name");
              return (Criteria) this;
         }

         public Criteria andPlatformNameLessThan(String value)
         {
              addCriterion("platform_name < ", value, "platform_name");
              return (Criteria) this;
         }

         public Criteria andPlatformNameLessThanOrEqualTo(String value)
         {
              addCriterion("platform_name <= ", value, "platform_name");
              return (Criteria) this;
         }

         public Criteria andPlatformNameLike(String value)
         {
              addCriterion("platform_name like ", value, "platform_name");
              return (Criteria) this;
         }

         public Criteria andPlatformNameNotLike(String value)
         {
              addCriterion("platform_name not like ", value, "platform_name");
              return (Criteria) this;
         }

         public Criteria andPlatformNameIn(List<String> values)
         {
              addCriterion("platform_name in ", values, "platform_name");
              return (Criteria) this;
         }

         public Criteria andPlatformNameNotIn(List<String> values)
         {
              addCriterion("platform_name not in ", values, "platform_name");
              return (Criteria) this;
         }

         public Criteria andPlatformNameBetween(String value1, String value2)
         {
              addCriterion("platform_name between ", value1,value2, "platform_name");
              return (Criteria) this;
         }

         public Criteria andPlatformNameNotBetween(String value1, String value2)
         {
              addCriterion("platform_name not between ", value1,value2, "platform_name");
              return (Criteria) this;
         }

         public Criteria andDescriptionIsNull()
         {
              addCriterion("description is null");
              return (Criteria) this;
         }

         public Criteria andDescriptionIsNotNull()
         {
              addCriterion("description is not null");
              return (Criteria) this;
         }

         public Criteria andDescriptionEqualTo(String value)
         {
              addCriterion("description = ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionNotEqualTo(String value)
         {
              addCriterion("description <> ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionGreaterThan(String value)
         {
              addCriterion("description > ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionGreaterThanOrEqualTo(String value)
         {
              addCriterion("description >= ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionLessThan(String value)
         {
              addCriterion("description < ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionLessThanOrEqualTo(String value)
         {
              addCriterion("description <= ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionLike(String value)
         {
              addCriterion("description like ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionNotLike(String value)
         {
              addCriterion("description not like ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionIn(List<String> values)
         {
              addCriterion("description in ", values, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionNotIn(List<String> values)
         {
              addCriterion("description not in ", values, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionBetween(String value1, String value2)
         {
              addCriterion("description between ", value1,value2, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionNotBetween(String value1, String value2)
         {
              addCriterion("description not between ", value1,value2, "description");
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
