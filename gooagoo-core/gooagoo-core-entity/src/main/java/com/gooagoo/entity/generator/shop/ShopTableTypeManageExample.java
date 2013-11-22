package com.gooagoo.entity.generator.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 餐桌类型管理
 */

public class ShopTableTypeManageExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopTableTypeManageExample()
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

         public Criteria andTableTypeCodeIsNull()
         {
              addCriterion("table_type_code is null");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeIsNotNull()
         {
              addCriterion("table_type_code is not null");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeEqualTo(String value)
         {
              addCriterion("table_type_code = ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeNotEqualTo(String value)
         {
              addCriterion("table_type_code <> ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeGreaterThan(String value)
         {
              addCriterion("table_type_code > ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("table_type_code >= ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeLessThan(String value)
         {
              addCriterion("table_type_code < ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeLessThanOrEqualTo(String value)
         {
              addCriterion("table_type_code <= ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeLike(String value)
         {
              addCriterion("table_type_code like ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeNotLike(String value)
         {
              addCriterion("table_type_code not like ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeIn(List<String> values)
         {
              addCriterion("table_type_code in ", values, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeNotIn(List<String> values)
         {
              addCriterion("table_type_code not in ", values, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeBetween(String value1, String value2)
         {
              addCriterion("table_type_code between ", value1,value2, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeNotBetween(String value1, String value2)
         {
              addCriterion("table_type_code not between ", value1,value2, "table_type_code");
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

         public Criteria andShopEntityIdIsNull()
         {
              addCriterion("shop_entity_id is null");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdIsNotNull()
         {
              addCriterion("shop_entity_id is not null");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdEqualTo(String value)
         {
              addCriterion("shop_entity_id = ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdNotEqualTo(String value)
         {
              addCriterion("shop_entity_id <> ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdGreaterThan(String value)
         {
              addCriterion("shop_entity_id > ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_entity_id >= ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdLessThan(String value)
         {
              addCriterion("shop_entity_id < ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdLessThanOrEqualTo(String value)
         {
              addCriterion("shop_entity_id <= ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdLike(String value)
         {
              addCriterion("shop_entity_id like ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdNotLike(String value)
         {
              addCriterion("shop_entity_id not like ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdIn(List<String> values)
         {
              addCriterion("shop_entity_id in ", values, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdNotIn(List<String> values)
         {
              addCriterion("shop_entity_id not in ", values, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdBetween(String value1, String value2)
         {
              addCriterion("shop_entity_id between ", value1,value2, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdNotBetween(String value1, String value2)
         {
              addCriterion("shop_entity_id not between ", value1,value2, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andMinNumsIsNull()
         {
              addCriterion("min_nums is null");
              return (Criteria) this;
         }

         public Criteria andMinNumsIsNotNull()
         {
              addCriterion("min_nums is not null");
              return (Criteria) this;
         }

         public Criteria andMinNumsEqualTo(String value)
         {
              addCriterion("min_nums = ", value, "min_nums");
              return (Criteria) this;
         }

         public Criteria andMinNumsNotEqualTo(String value)
         {
              addCriterion("min_nums <> ", value, "min_nums");
              return (Criteria) this;
         }

         public Criteria andMinNumsGreaterThan(String value)
         {
              addCriterion("min_nums > ", value, "min_nums");
              return (Criteria) this;
         }

         public Criteria andMinNumsGreaterThanOrEqualTo(String value)
         {
              addCriterion("min_nums >= ", value, "min_nums");
              return (Criteria) this;
         }

         public Criteria andMinNumsLessThan(String value)
         {
              addCriterion("min_nums < ", value, "min_nums");
              return (Criteria) this;
         }

         public Criteria andMinNumsLessThanOrEqualTo(String value)
         {
              addCriterion("min_nums <= ", value, "min_nums");
              return (Criteria) this;
         }

         public Criteria andMinNumsLike(String value)
         {
              addCriterion("min_nums like ", value, "min_nums");
              return (Criteria) this;
         }

         public Criteria andMinNumsNotLike(String value)
         {
              addCriterion("min_nums not like ", value, "min_nums");
              return (Criteria) this;
         }

         public Criteria andMinNumsIn(List<String> values)
         {
              addCriterion("min_nums in ", values, "min_nums");
              return (Criteria) this;
         }

         public Criteria andMinNumsNotIn(List<String> values)
         {
              addCriterion("min_nums not in ", values, "min_nums");
              return (Criteria) this;
         }

         public Criteria andMinNumsBetween(String value1, String value2)
         {
              addCriterion("min_nums between ", value1,value2, "min_nums");
              return (Criteria) this;
         }

         public Criteria andMinNumsNotBetween(String value1, String value2)
         {
              addCriterion("min_nums not between ", value1,value2, "min_nums");
              return (Criteria) this;
         }

         public Criteria andMaxNumsIsNull()
         {
              addCriterion("max_nums is null");
              return (Criteria) this;
         }

         public Criteria andMaxNumsIsNotNull()
         {
              addCriterion("max_nums is not null");
              return (Criteria) this;
         }

         public Criteria andMaxNumsEqualTo(String value)
         {
              addCriterion("max_nums = ", value, "max_nums");
              return (Criteria) this;
         }

         public Criteria andMaxNumsNotEqualTo(String value)
         {
              addCriterion("max_nums <> ", value, "max_nums");
              return (Criteria) this;
         }

         public Criteria andMaxNumsGreaterThan(String value)
         {
              addCriterion("max_nums > ", value, "max_nums");
              return (Criteria) this;
         }

         public Criteria andMaxNumsGreaterThanOrEqualTo(String value)
         {
              addCriterion("max_nums >= ", value, "max_nums");
              return (Criteria) this;
         }

         public Criteria andMaxNumsLessThan(String value)
         {
              addCriterion("max_nums < ", value, "max_nums");
              return (Criteria) this;
         }

         public Criteria andMaxNumsLessThanOrEqualTo(String value)
         {
              addCriterion("max_nums <= ", value, "max_nums");
              return (Criteria) this;
         }

         public Criteria andMaxNumsLike(String value)
         {
              addCriterion("max_nums like ", value, "max_nums");
              return (Criteria) this;
         }

         public Criteria andMaxNumsNotLike(String value)
         {
              addCriterion("max_nums not like ", value, "max_nums");
              return (Criteria) this;
         }

         public Criteria andMaxNumsIn(List<String> values)
         {
              addCriterion("max_nums in ", values, "max_nums");
              return (Criteria) this;
         }

         public Criteria andMaxNumsNotIn(List<String> values)
         {
              addCriterion("max_nums not in ", values, "max_nums");
              return (Criteria) this;
         }

         public Criteria andMaxNumsBetween(String value1, String value2)
         {
              addCriterion("max_nums between ", value1,value2, "max_nums");
              return (Criteria) this;
         }

         public Criteria andMaxNumsNotBetween(String value1, String value2)
         {
              addCriterion("max_nums not between ", value1,value2, "max_nums");
              return (Criteria) this;
         }

         public Criteria andTableTypeNameIsNull()
         {
              addCriterion("table_type_name is null");
              return (Criteria) this;
         }

         public Criteria andTableTypeNameIsNotNull()
         {
              addCriterion("table_type_name is not null");
              return (Criteria) this;
         }

         public Criteria andTableTypeNameEqualTo(String value)
         {
              addCriterion("table_type_name = ", value, "table_type_name");
              return (Criteria) this;
         }

         public Criteria andTableTypeNameNotEqualTo(String value)
         {
              addCriterion("table_type_name <> ", value, "table_type_name");
              return (Criteria) this;
         }

         public Criteria andTableTypeNameGreaterThan(String value)
         {
              addCriterion("table_type_name > ", value, "table_type_name");
              return (Criteria) this;
         }

         public Criteria andTableTypeNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("table_type_name >= ", value, "table_type_name");
              return (Criteria) this;
         }

         public Criteria andTableTypeNameLessThan(String value)
         {
              addCriterion("table_type_name < ", value, "table_type_name");
              return (Criteria) this;
         }

         public Criteria andTableTypeNameLessThanOrEqualTo(String value)
         {
              addCriterion("table_type_name <= ", value, "table_type_name");
              return (Criteria) this;
         }

         public Criteria andTableTypeNameLike(String value)
         {
              addCriterion("table_type_name like ", value, "table_type_name");
              return (Criteria) this;
         }

         public Criteria andTableTypeNameNotLike(String value)
         {
              addCriterion("table_type_name not like ", value, "table_type_name");
              return (Criteria) this;
         }

         public Criteria andTableTypeNameIn(List<String> values)
         {
              addCriterion("table_type_name in ", values, "table_type_name");
              return (Criteria) this;
         }

         public Criteria andTableTypeNameNotIn(List<String> values)
         {
              addCriterion("table_type_name not in ", values, "table_type_name");
              return (Criteria) this;
         }

         public Criteria andTableTypeNameBetween(String value1, String value2)
         {
              addCriterion("table_type_name between ", value1,value2, "table_type_name");
              return (Criteria) this;
         }

         public Criteria andTableTypeNameNotBetween(String value1, String value2)
         {
              addCriterion("table_type_name not between ", value1,value2, "table_type_name");
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
