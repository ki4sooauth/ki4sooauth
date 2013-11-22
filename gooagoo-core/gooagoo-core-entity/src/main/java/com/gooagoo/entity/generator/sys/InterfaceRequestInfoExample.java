package com.gooagoo.entity.generator.sys;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * 接口请求参数信息表
 */

public class InterfaceRequestInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public InterfaceRequestInfoExample()
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

         public Criteria andICodeIsNull()
         {
              addCriterion("i_code is null");
              return (Criteria) this;
         }

         public Criteria andICodeIsNotNull()
         {
              addCriterion("i_code is not null");
              return (Criteria) this;
         }

         public Criteria andICodeEqualTo(String value)
         {
              addCriterion("i_code = ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeNotEqualTo(String value)
         {
              addCriterion("i_code <> ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeGreaterThan(String value)
         {
              addCriterion("i_code > ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("i_code >= ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeLessThan(String value)
         {
              addCriterion("i_code < ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeLessThanOrEqualTo(String value)
         {
              addCriterion("i_code <= ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeLike(String value)
         {
              addCriterion("i_code like ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeNotLike(String value)
         {
              addCriterion("i_code not like ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeIn(List<String> values)
         {
              addCriterion("i_code in ", values, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeNotIn(List<String> values)
         {
              addCriterion("i_code not in ", values, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeBetween(String value1, String value2)
         {
              addCriterion("i_code between ", value1,value2, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeNotBetween(String value1, String value2)
         {
              addCriterion("i_code not between ", value1,value2, "i_code");
              return (Criteria) this;
         }

         public Criteria andNameEnIsNull()
         {
              addCriterion("name_en is null");
              return (Criteria) this;
         }

         public Criteria andNameEnIsNotNull()
         {
              addCriterion("name_en is not null");
              return (Criteria) this;
         }

         public Criteria andNameEnEqualTo(String value)
         {
              addCriterion("name_en = ", value, "name_en");
              return (Criteria) this;
         }

         public Criteria andNameEnNotEqualTo(String value)
         {
              addCriterion("name_en <> ", value, "name_en");
              return (Criteria) this;
         }

         public Criteria andNameEnGreaterThan(String value)
         {
              addCriterion("name_en > ", value, "name_en");
              return (Criteria) this;
         }

         public Criteria andNameEnGreaterThanOrEqualTo(String value)
         {
              addCriterion("name_en >= ", value, "name_en");
              return (Criteria) this;
         }

         public Criteria andNameEnLessThan(String value)
         {
              addCriterion("name_en < ", value, "name_en");
              return (Criteria) this;
         }

         public Criteria andNameEnLessThanOrEqualTo(String value)
         {
              addCriterion("name_en <= ", value, "name_en");
              return (Criteria) this;
         }

         public Criteria andNameEnLike(String value)
         {
              addCriterion("name_en like ", value, "name_en");
              return (Criteria) this;
         }

         public Criteria andNameEnNotLike(String value)
         {
              addCriterion("name_en not like ", value, "name_en");
              return (Criteria) this;
         }

         public Criteria andNameEnIn(List<String> values)
         {
              addCriterion("name_en in ", values, "name_en");
              return (Criteria) this;
         }

         public Criteria andNameEnNotIn(List<String> values)
         {
              addCriterion("name_en not in ", values, "name_en");
              return (Criteria) this;
         }

         public Criteria andNameEnBetween(String value1, String value2)
         {
              addCriterion("name_en between ", value1,value2, "name_en");
              return (Criteria) this;
         }

         public Criteria andNameEnNotBetween(String value1, String value2)
         {
              addCriterion("name_en not between ", value1,value2, "name_en");
              return (Criteria) this;
         }

         public Criteria andNameCnIsNull()
         {
              addCriterion("name_cn is null");
              return (Criteria) this;
         }

         public Criteria andNameCnIsNotNull()
         {
              addCriterion("name_cn is not null");
              return (Criteria) this;
         }

         public Criteria andNameCnEqualTo(String value)
         {
              addCriterion("name_cn = ", value, "name_cn");
              return (Criteria) this;
         }

         public Criteria andNameCnNotEqualTo(String value)
         {
              addCriterion("name_cn <> ", value, "name_cn");
              return (Criteria) this;
         }

         public Criteria andNameCnGreaterThan(String value)
         {
              addCriterion("name_cn > ", value, "name_cn");
              return (Criteria) this;
         }

         public Criteria andNameCnGreaterThanOrEqualTo(String value)
         {
              addCriterion("name_cn >= ", value, "name_cn");
              return (Criteria) this;
         }

         public Criteria andNameCnLessThan(String value)
         {
              addCriterion("name_cn < ", value, "name_cn");
              return (Criteria) this;
         }

         public Criteria andNameCnLessThanOrEqualTo(String value)
         {
              addCriterion("name_cn <= ", value, "name_cn");
              return (Criteria) this;
         }

         public Criteria andNameCnLike(String value)
         {
              addCriterion("name_cn like ", value, "name_cn");
              return (Criteria) this;
         }

         public Criteria andNameCnNotLike(String value)
         {
              addCriterion("name_cn not like ", value, "name_cn");
              return (Criteria) this;
         }

         public Criteria andNameCnIn(List<String> values)
         {
              addCriterion("name_cn in ", values, "name_cn");
              return (Criteria) this;
         }

         public Criteria andNameCnNotIn(List<String> values)
         {
              addCriterion("name_cn not in ", values, "name_cn");
              return (Criteria) this;
         }

         public Criteria andNameCnBetween(String value1, String value2)
         {
              addCriterion("name_cn between ", value1,value2, "name_cn");
              return (Criteria) this;
         }

         public Criteria andNameCnNotBetween(String value1, String value2)
         {
              addCriterion("name_cn not between ", value1,value2, "name_cn");
              return (Criteria) this;
         }

         public Criteria andIsRequiredIsNull()
         {
              addCriterion("is_required is null");
              return (Criteria) this;
         }

         public Criteria andIsRequiredIsNotNull()
         {
              addCriterion("is_required is not null");
              return (Criteria) this;
         }

         public Criteria andIsRequiredEqualTo(String value)
         {
              addCriterion("is_required = ", value, "is_required");
              return (Criteria) this;
         }

         public Criteria andIsRequiredNotEqualTo(String value)
         {
              addCriterion("is_required <> ", value, "is_required");
              return (Criteria) this;
         }

         public Criteria andIsRequiredGreaterThan(String value)
         {
              addCriterion("is_required > ", value, "is_required");
              return (Criteria) this;
         }

         public Criteria andIsRequiredGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_required >= ", value, "is_required");
              return (Criteria) this;
         }

         public Criteria andIsRequiredLessThan(String value)
         {
              addCriterion("is_required < ", value, "is_required");
              return (Criteria) this;
         }

         public Criteria andIsRequiredLessThanOrEqualTo(String value)
         {
              addCriterion("is_required <= ", value, "is_required");
              return (Criteria) this;
         }

         public Criteria andIsRequiredLike(String value)
         {
              addCriterion("is_required like ", value, "is_required");
              return (Criteria) this;
         }

         public Criteria andIsRequiredNotLike(String value)
         {
              addCriterion("is_required not like ", value, "is_required");
              return (Criteria) this;
         }

         public Criteria andIsRequiredIn(List<String> values)
         {
              addCriterion("is_required in ", values, "is_required");
              return (Criteria) this;
         }

         public Criteria andIsRequiredNotIn(List<String> values)
         {
              addCriterion("is_required not in ", values, "is_required");
              return (Criteria) this;
         }

         public Criteria andIsRequiredBetween(String value1, String value2)
         {
              addCriterion("is_required between ", value1,value2, "is_required");
              return (Criteria) this;
         }

         public Criteria andIsRequiredNotBetween(String value1, String value2)
         {
              addCriterion("is_required not between ", value1,value2, "is_required");
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
