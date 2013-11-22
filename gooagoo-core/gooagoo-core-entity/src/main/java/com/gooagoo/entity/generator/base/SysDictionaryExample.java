package com.gooagoo.entity.generator.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 通用字典表，包括性别、证件类型、转发器型号、信息来源、行为类型
 */

public class SysDictionaryExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public SysDictionaryExample()
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

         public Criteria andSysDictionaryIdIsNull()
         {
              addCriterion("sys_dictionary_id is null");
              return (Criteria) this;
         }

         public Criteria andSysDictionaryIdIsNotNull()
         {
              addCriterion("sys_dictionary_id is not null");
              return (Criteria) this;
         }

         public Criteria andSysDictionaryIdEqualTo(String value)
         {
              addCriterion("sys_dictionary_id = ", value, "sys_dictionary_id");
              return (Criteria) this;
         }

         public Criteria andSysDictionaryIdNotEqualTo(String value)
         {
              addCriterion("sys_dictionary_id <> ", value, "sys_dictionary_id");
              return (Criteria) this;
         }

         public Criteria andSysDictionaryIdGreaterThan(String value)
         {
              addCriterion("sys_dictionary_id > ", value, "sys_dictionary_id");
              return (Criteria) this;
         }

         public Criteria andSysDictionaryIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("sys_dictionary_id >= ", value, "sys_dictionary_id");
              return (Criteria) this;
         }

         public Criteria andSysDictionaryIdLessThan(String value)
         {
              addCriterion("sys_dictionary_id < ", value, "sys_dictionary_id");
              return (Criteria) this;
         }

         public Criteria andSysDictionaryIdLessThanOrEqualTo(String value)
         {
              addCriterion("sys_dictionary_id <= ", value, "sys_dictionary_id");
              return (Criteria) this;
         }

         public Criteria andSysDictionaryIdLike(String value)
         {
              addCriterion("sys_dictionary_id like ", value, "sys_dictionary_id");
              return (Criteria) this;
         }

         public Criteria andSysDictionaryIdNotLike(String value)
         {
              addCriterion("sys_dictionary_id not like ", value, "sys_dictionary_id");
              return (Criteria) this;
         }

         public Criteria andSysDictionaryIdIn(List<String> values)
         {
              addCriterion("sys_dictionary_id in ", values, "sys_dictionary_id");
              return (Criteria) this;
         }

         public Criteria andSysDictionaryIdNotIn(List<String> values)
         {
              addCriterion("sys_dictionary_id not in ", values, "sys_dictionary_id");
              return (Criteria) this;
         }

         public Criteria andSysDictionaryIdBetween(String value1, String value2)
         {
              addCriterion("sys_dictionary_id between ", value1,value2, "sys_dictionary_id");
              return (Criteria) this;
         }

         public Criteria andSysDictionaryIdNotBetween(String value1, String value2)
         {
              addCriterion("sys_dictionary_id not between ", value1,value2, "sys_dictionary_id");
              return (Criteria) this;
         }

         public Criteria andDictionaryTypeIsNull()
         {
              addCriterion("dictionary_type is null");
              return (Criteria) this;
         }

         public Criteria andDictionaryTypeIsNotNull()
         {
              addCriterion("dictionary_type is not null");
              return (Criteria) this;
         }

         public Criteria andDictionaryTypeEqualTo(String value)
         {
              addCriterion("dictionary_type = ", value, "dictionary_type");
              return (Criteria) this;
         }

         public Criteria andDictionaryTypeNotEqualTo(String value)
         {
              addCriterion("dictionary_type <> ", value, "dictionary_type");
              return (Criteria) this;
         }

         public Criteria andDictionaryTypeGreaterThan(String value)
         {
              addCriterion("dictionary_type > ", value, "dictionary_type");
              return (Criteria) this;
         }

         public Criteria andDictionaryTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("dictionary_type >= ", value, "dictionary_type");
              return (Criteria) this;
         }

         public Criteria andDictionaryTypeLessThan(String value)
         {
              addCriterion("dictionary_type < ", value, "dictionary_type");
              return (Criteria) this;
         }

         public Criteria andDictionaryTypeLessThanOrEqualTo(String value)
         {
              addCriterion("dictionary_type <= ", value, "dictionary_type");
              return (Criteria) this;
         }

         public Criteria andDictionaryTypeLike(String value)
         {
              addCriterion("dictionary_type like ", value, "dictionary_type");
              return (Criteria) this;
         }

         public Criteria andDictionaryTypeNotLike(String value)
         {
              addCriterion("dictionary_type not like ", value, "dictionary_type");
              return (Criteria) this;
         }

         public Criteria andDictionaryTypeIn(List<String> values)
         {
              addCriterion("dictionary_type in ", values, "dictionary_type");
              return (Criteria) this;
         }

         public Criteria andDictionaryTypeNotIn(List<String> values)
         {
              addCriterion("dictionary_type not in ", values, "dictionary_type");
              return (Criteria) this;
         }

         public Criteria andDictionaryTypeBetween(String value1, String value2)
         {
              addCriterion("dictionary_type between ", value1,value2, "dictionary_type");
              return (Criteria) this;
         }

         public Criteria andDictionaryTypeNotBetween(String value1, String value2)
         {
              addCriterion("dictionary_type not between ", value1,value2, "dictionary_type");
              return (Criteria) this;
         }

         public Criteria andDictionaryNameIsNull()
         {
              addCriterion("dictionary_name is null");
              return (Criteria) this;
         }

         public Criteria andDictionaryNameIsNotNull()
         {
              addCriterion("dictionary_name is not null");
              return (Criteria) this;
         }

         public Criteria andDictionaryNameEqualTo(String value)
         {
              addCriterion("dictionary_name = ", value, "dictionary_name");
              return (Criteria) this;
         }

         public Criteria andDictionaryNameNotEqualTo(String value)
         {
              addCriterion("dictionary_name <> ", value, "dictionary_name");
              return (Criteria) this;
         }

         public Criteria andDictionaryNameGreaterThan(String value)
         {
              addCriterion("dictionary_name > ", value, "dictionary_name");
              return (Criteria) this;
         }

         public Criteria andDictionaryNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("dictionary_name >= ", value, "dictionary_name");
              return (Criteria) this;
         }

         public Criteria andDictionaryNameLessThan(String value)
         {
              addCriterion("dictionary_name < ", value, "dictionary_name");
              return (Criteria) this;
         }

         public Criteria andDictionaryNameLessThanOrEqualTo(String value)
         {
              addCriterion("dictionary_name <= ", value, "dictionary_name");
              return (Criteria) this;
         }

         public Criteria andDictionaryNameLike(String value)
         {
              addCriterion("dictionary_name like ", value, "dictionary_name");
              return (Criteria) this;
         }

         public Criteria andDictionaryNameNotLike(String value)
         {
              addCriterion("dictionary_name not like ", value, "dictionary_name");
              return (Criteria) this;
         }

         public Criteria andDictionaryNameIn(List<String> values)
         {
              addCriterion("dictionary_name in ", values, "dictionary_name");
              return (Criteria) this;
         }

         public Criteria andDictionaryNameNotIn(List<String> values)
         {
              addCriterion("dictionary_name not in ", values, "dictionary_name");
              return (Criteria) this;
         }

         public Criteria andDictionaryNameBetween(String value1, String value2)
         {
              addCriterion("dictionary_name between ", value1,value2, "dictionary_name");
              return (Criteria) this;
         }

         public Criteria andDictionaryNameNotBetween(String value1, String value2)
         {
              addCriterion("dictionary_name not between ", value1,value2, "dictionary_name");
              return (Criteria) this;
         }

         public Criteria andEnglishNameIsNull()
         {
              addCriterion("english_name is null");
              return (Criteria) this;
         }

         public Criteria andEnglishNameIsNotNull()
         {
              addCriterion("english_name is not null");
              return (Criteria) this;
         }

         public Criteria andEnglishNameEqualTo(String value)
         {
              addCriterion("english_name = ", value, "english_name");
              return (Criteria) this;
         }

         public Criteria andEnglishNameNotEqualTo(String value)
         {
              addCriterion("english_name <> ", value, "english_name");
              return (Criteria) this;
         }

         public Criteria andEnglishNameGreaterThan(String value)
         {
              addCriterion("english_name > ", value, "english_name");
              return (Criteria) this;
         }

         public Criteria andEnglishNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("english_name >= ", value, "english_name");
              return (Criteria) this;
         }

         public Criteria andEnglishNameLessThan(String value)
         {
              addCriterion("english_name < ", value, "english_name");
              return (Criteria) this;
         }

         public Criteria andEnglishNameLessThanOrEqualTo(String value)
         {
              addCriterion("english_name <= ", value, "english_name");
              return (Criteria) this;
         }

         public Criteria andEnglishNameLike(String value)
         {
              addCriterion("english_name like ", value, "english_name");
              return (Criteria) this;
         }

         public Criteria andEnglishNameNotLike(String value)
         {
              addCriterion("english_name not like ", value, "english_name");
              return (Criteria) this;
         }

         public Criteria andEnglishNameIn(List<String> values)
         {
              addCriterion("english_name in ", values, "english_name");
              return (Criteria) this;
         }

         public Criteria andEnglishNameNotIn(List<String> values)
         {
              addCriterion("english_name not in ", values, "english_name");
              return (Criteria) this;
         }

         public Criteria andEnglishNameBetween(String value1, String value2)
         {
              addCriterion("english_name between ", value1,value2, "english_name");
              return (Criteria) this;
         }

         public Criteria andEnglishNameNotBetween(String value1, String value2)
         {
              addCriterion("english_name not between ", value1,value2, "english_name");
              return (Criteria) this;
         }

         public Criteria andChineseNameIsNull()
         {
              addCriterion("chinese_name is null");
              return (Criteria) this;
         }

         public Criteria andChineseNameIsNotNull()
         {
              addCriterion("chinese_name is not null");
              return (Criteria) this;
         }

         public Criteria andChineseNameEqualTo(String value)
         {
              addCriterion("chinese_name = ", value, "chinese_name");
              return (Criteria) this;
         }

         public Criteria andChineseNameNotEqualTo(String value)
         {
              addCriterion("chinese_name <> ", value, "chinese_name");
              return (Criteria) this;
         }

         public Criteria andChineseNameGreaterThan(String value)
         {
              addCriterion("chinese_name > ", value, "chinese_name");
              return (Criteria) this;
         }

         public Criteria andChineseNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("chinese_name >= ", value, "chinese_name");
              return (Criteria) this;
         }

         public Criteria andChineseNameLessThan(String value)
         {
              addCriterion("chinese_name < ", value, "chinese_name");
              return (Criteria) this;
         }

         public Criteria andChineseNameLessThanOrEqualTo(String value)
         {
              addCriterion("chinese_name <= ", value, "chinese_name");
              return (Criteria) this;
         }

         public Criteria andChineseNameLike(String value)
         {
              addCriterion("chinese_name like ", value, "chinese_name");
              return (Criteria) this;
         }

         public Criteria andChineseNameNotLike(String value)
         {
              addCriterion("chinese_name not like ", value, "chinese_name");
              return (Criteria) this;
         }

         public Criteria andChineseNameIn(List<String> values)
         {
              addCriterion("chinese_name in ", values, "chinese_name");
              return (Criteria) this;
         }

         public Criteria andChineseNameNotIn(List<String> values)
         {
              addCriterion("chinese_name not in ", values, "chinese_name");
              return (Criteria) this;
         }

         public Criteria andChineseNameBetween(String value1, String value2)
         {
              addCriterion("chinese_name between ", value1,value2, "chinese_name");
              return (Criteria) this;
         }

         public Criteria andChineseNameNotBetween(String value1, String value2)
         {
              addCriterion("chinese_name not between ", value1,value2, "chinese_name");
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
