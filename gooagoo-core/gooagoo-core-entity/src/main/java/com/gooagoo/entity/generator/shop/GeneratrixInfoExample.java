package com.gooagoo.entity.generator.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 动线信息
 */

public class GeneratrixInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public GeneratrixInfoExample()
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

         public Criteria andGeneratrixIdIsNull()
         {
              addCriterion("generatrix_id is null");
              return (Criteria) this;
         }

         public Criteria andGeneratrixIdIsNotNull()
         {
              addCriterion("generatrix_id is not null");
              return (Criteria) this;
         }

         public Criteria andGeneratrixIdEqualTo(String value)
         {
              addCriterion("generatrix_id = ", value, "generatrix_id");
              return (Criteria) this;
         }

         public Criteria andGeneratrixIdNotEqualTo(String value)
         {
              addCriterion("generatrix_id <> ", value, "generatrix_id");
              return (Criteria) this;
         }

         public Criteria andGeneratrixIdGreaterThan(String value)
         {
              addCriterion("generatrix_id > ", value, "generatrix_id");
              return (Criteria) this;
         }

         public Criteria andGeneratrixIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("generatrix_id >= ", value, "generatrix_id");
              return (Criteria) this;
         }

         public Criteria andGeneratrixIdLessThan(String value)
         {
              addCriterion("generatrix_id < ", value, "generatrix_id");
              return (Criteria) this;
         }

         public Criteria andGeneratrixIdLessThanOrEqualTo(String value)
         {
              addCriterion("generatrix_id <= ", value, "generatrix_id");
              return (Criteria) this;
         }

         public Criteria andGeneratrixIdLike(String value)
         {
              addCriterion("generatrix_id like ", value, "generatrix_id");
              return (Criteria) this;
         }

         public Criteria andGeneratrixIdNotLike(String value)
         {
              addCriterion("generatrix_id not like ", value, "generatrix_id");
              return (Criteria) this;
         }

         public Criteria andGeneratrixIdIn(List<String> values)
         {
              addCriterion("generatrix_id in ", values, "generatrix_id");
              return (Criteria) this;
         }

         public Criteria andGeneratrixIdNotIn(List<String> values)
         {
              addCriterion("generatrix_id not in ", values, "generatrix_id");
              return (Criteria) this;
         }

         public Criteria andGeneratrixIdBetween(String value1, String value2)
         {
              addCriterion("generatrix_id between ", value1,value2, "generatrix_id");
              return (Criteria) this;
         }

         public Criteria andGeneratrixIdNotBetween(String value1, String value2)
         {
              addCriterion("generatrix_id not between ", value1,value2, "generatrix_id");
              return (Criteria) this;
         }

         public Criteria andMapIdIsNull()
         {
              addCriterion("map_id is null");
              return (Criteria) this;
         }

         public Criteria andMapIdIsNotNull()
         {
              addCriterion("map_id is not null");
              return (Criteria) this;
         }

         public Criteria andMapIdEqualTo(String value)
         {
              addCriterion("map_id = ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdNotEqualTo(String value)
         {
              addCriterion("map_id <> ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdGreaterThan(String value)
         {
              addCriterion("map_id > ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("map_id >= ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdLessThan(String value)
         {
              addCriterion("map_id < ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdLessThanOrEqualTo(String value)
         {
              addCriterion("map_id <= ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdLike(String value)
         {
              addCriterion("map_id like ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdNotLike(String value)
         {
              addCriterion("map_id not like ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdIn(List<String> values)
         {
              addCriterion("map_id in ", values, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdNotIn(List<String> values)
         {
              addCriterion("map_id not in ", values, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdBetween(String value1, String value2)
         {
              addCriterion("map_id between ", value1,value2, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdNotBetween(String value1, String value2)
         {
              addCriterion("map_id not between ", value1,value2, "map_id");
              return (Criteria) this;
         }

         public Criteria andGeneratrixTypeIsNull()
         {
              addCriterion("generatrix_type is null");
              return (Criteria) this;
         }

         public Criteria andGeneratrixTypeIsNotNull()
         {
              addCriterion("generatrix_type is not null");
              return (Criteria) this;
         }

         public Criteria andGeneratrixTypeEqualTo(String value)
         {
              addCriterion("generatrix_type = ", value, "generatrix_type");
              return (Criteria) this;
         }

         public Criteria andGeneratrixTypeNotEqualTo(String value)
         {
              addCriterion("generatrix_type <> ", value, "generatrix_type");
              return (Criteria) this;
         }

         public Criteria andGeneratrixTypeGreaterThan(String value)
         {
              addCriterion("generatrix_type > ", value, "generatrix_type");
              return (Criteria) this;
         }

         public Criteria andGeneratrixTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("generatrix_type >= ", value, "generatrix_type");
              return (Criteria) this;
         }

         public Criteria andGeneratrixTypeLessThan(String value)
         {
              addCriterion("generatrix_type < ", value, "generatrix_type");
              return (Criteria) this;
         }

         public Criteria andGeneratrixTypeLessThanOrEqualTo(String value)
         {
              addCriterion("generatrix_type <= ", value, "generatrix_type");
              return (Criteria) this;
         }

         public Criteria andGeneratrixTypeLike(String value)
         {
              addCriterion("generatrix_type like ", value, "generatrix_type");
              return (Criteria) this;
         }

         public Criteria andGeneratrixTypeNotLike(String value)
         {
              addCriterion("generatrix_type not like ", value, "generatrix_type");
              return (Criteria) this;
         }

         public Criteria andGeneratrixTypeIn(List<String> values)
         {
              addCriterion("generatrix_type in ", values, "generatrix_type");
              return (Criteria) this;
         }

         public Criteria andGeneratrixTypeNotIn(List<String> values)
         {
              addCriterion("generatrix_type not in ", values, "generatrix_type");
              return (Criteria) this;
         }

         public Criteria andGeneratrixTypeBetween(String value1, String value2)
         {
              addCriterion("generatrix_type between ", value1,value2, "generatrix_type");
              return (Criteria) this;
         }

         public Criteria andGeneratrixTypeNotBetween(String value1, String value2)
         {
              addCriterion("generatrix_type not between ", value1,value2, "generatrix_type");
              return (Criteria) this;
         }

         public Criteria andSvgTagIdIsNull()
         {
              addCriterion("svg_tag_id is null");
              return (Criteria) this;
         }

         public Criteria andSvgTagIdIsNotNull()
         {
              addCriterion("svg_tag_id is not null");
              return (Criteria) this;
         }

         public Criteria andSvgTagIdEqualTo(String value)
         {
              addCriterion("svg_tag_id = ", value, "svg_tag_id");
              return (Criteria) this;
         }

         public Criteria andSvgTagIdNotEqualTo(String value)
         {
              addCriterion("svg_tag_id <> ", value, "svg_tag_id");
              return (Criteria) this;
         }

         public Criteria andSvgTagIdGreaterThan(String value)
         {
              addCriterion("svg_tag_id > ", value, "svg_tag_id");
              return (Criteria) this;
         }

         public Criteria andSvgTagIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("svg_tag_id >= ", value, "svg_tag_id");
              return (Criteria) this;
         }

         public Criteria andSvgTagIdLessThan(String value)
         {
              addCriterion("svg_tag_id < ", value, "svg_tag_id");
              return (Criteria) this;
         }

         public Criteria andSvgTagIdLessThanOrEqualTo(String value)
         {
              addCriterion("svg_tag_id <= ", value, "svg_tag_id");
              return (Criteria) this;
         }

         public Criteria andSvgTagIdLike(String value)
         {
              addCriterion("svg_tag_id like ", value, "svg_tag_id");
              return (Criteria) this;
         }

         public Criteria andSvgTagIdNotLike(String value)
         {
              addCriterion("svg_tag_id not like ", value, "svg_tag_id");
              return (Criteria) this;
         }

         public Criteria andSvgTagIdIn(List<String> values)
         {
              addCriterion("svg_tag_id in ", values, "svg_tag_id");
              return (Criteria) this;
         }

         public Criteria andSvgTagIdNotIn(List<String> values)
         {
              addCriterion("svg_tag_id not in ", values, "svg_tag_id");
              return (Criteria) this;
         }

         public Criteria andSvgTagIdBetween(String value1, String value2)
         {
              addCriterion("svg_tag_id between ", value1,value2, "svg_tag_id");
              return (Criteria) this;
         }

         public Criteria andSvgTagIdNotBetween(String value1, String value2)
         {
              addCriterion("svg_tag_id not between ", value1,value2, "svg_tag_id");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeIsNull()
         {
              addCriterion("svg_tag_code is null");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeIsNotNull()
         {
              addCriterion("svg_tag_code is not null");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeEqualTo(String value)
         {
              addCriterion("svg_tag_code = ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeNotEqualTo(String value)
         {
              addCriterion("svg_tag_code <> ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeGreaterThan(String value)
         {
              addCriterion("svg_tag_code > ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("svg_tag_code >= ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeLessThan(String value)
         {
              addCriterion("svg_tag_code < ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeLessThanOrEqualTo(String value)
         {
              addCriterion("svg_tag_code <= ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeLike(String value)
         {
              addCriterion("svg_tag_code like ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeNotLike(String value)
         {
              addCriterion("svg_tag_code not like ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeIn(List<String> values)
         {
              addCriterion("svg_tag_code in ", values, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeNotIn(List<String> values)
         {
              addCriterion("svg_tag_code not in ", values, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeBetween(String value1, String value2)
         {
              addCriterion("svg_tag_code between ", value1,value2, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeNotBetween(String value1, String value2)
         {
              addCriterion("svg_tag_code not between ", value1,value2, "svg_tag_code");
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
