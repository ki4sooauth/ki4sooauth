package com.gooagoo.entity.generator.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 服务工具排序
 */

public class ServiceToolSortExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ServiceToolSortExample()
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

         public Criteria andToolIdIsNull()
         {
              addCriterion("tool_id is null");
              return (Criteria) this;
         }

         public Criteria andToolIdIsNotNull()
         {
              addCriterion("tool_id is not null");
              return (Criteria) this;
         }

         public Criteria andToolIdEqualTo(String value)
         {
              addCriterion("tool_id = ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdNotEqualTo(String value)
         {
              addCriterion("tool_id <> ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdGreaterThan(String value)
         {
              addCriterion("tool_id > ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("tool_id >= ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdLessThan(String value)
         {
              addCriterion("tool_id < ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdLessThanOrEqualTo(String value)
         {
              addCriterion("tool_id <= ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdLike(String value)
         {
              addCriterion("tool_id like ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdNotLike(String value)
         {
              addCriterion("tool_id not like ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdIn(List<String> values)
         {
              addCriterion("tool_id in ", values, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdNotIn(List<String> values)
         {
              addCriterion("tool_id not in ", values, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdBetween(String value1, String value2)
         {
              addCriterion("tool_id between ", value1,value2, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdNotBetween(String value1, String value2)
         {
              addCriterion("tool_id not between ", value1,value2, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolTypeIsNull()
         {
              addCriterion("tool_type is null");
              return (Criteria) this;
         }

         public Criteria andToolTypeIsNotNull()
         {
              addCriterion("tool_type is not null");
              return (Criteria) this;
         }

         public Criteria andToolTypeEqualTo(String value)
         {
              addCriterion("tool_type = ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeNotEqualTo(String value)
         {
              addCriterion("tool_type <> ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeGreaterThan(String value)
         {
              addCriterion("tool_type > ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("tool_type >= ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeLessThan(String value)
         {
              addCriterion("tool_type < ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeLessThanOrEqualTo(String value)
         {
              addCriterion("tool_type <= ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeLike(String value)
         {
              addCriterion("tool_type like ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeNotLike(String value)
         {
              addCriterion("tool_type not like ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeIn(List<String> values)
         {
              addCriterion("tool_type in ", values, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeNotIn(List<String> values)
         {
              addCriterion("tool_type not in ", values, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeBetween(String value1, String value2)
         {
              addCriterion("tool_type between ", value1,value2, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeNotBetween(String value1, String value2)
         {
              addCriterion("tool_type not between ", value1,value2, "tool_type");
              return (Criteria) this;
         }

         public Criteria andOrderNoIsNull()
         {
              addCriterion("order_no is null");
              return (Criteria) this;
         }

         public Criteria andOrderNoIsNotNull()
         {
              addCriterion("order_no is not null");
              return (Criteria) this;
         }

         public Criteria andOrderNoEqualTo(String value)
         {
              addCriterion("order_no = ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoNotEqualTo(String value)
         {
              addCriterion("order_no <> ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoGreaterThan(String value)
         {
              addCriterion("order_no > ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoGreaterThanOrEqualTo(String value)
         {
              addCriterion("order_no >= ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoLessThan(String value)
         {
              addCriterion("order_no < ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoLessThanOrEqualTo(String value)
         {
              addCriterion("order_no <= ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoLike(String value)
         {
              addCriterion("order_no like ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoNotLike(String value)
         {
              addCriterion("order_no not like ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoIn(List<String> values)
         {
              addCriterion("order_no in ", values, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoNotIn(List<String> values)
         {
              addCriterion("order_no not in ", values, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoBetween(String value1, String value2)
         {
              addCriterion("order_no between ", value1,value2, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoNotBetween(String value1, String value2)
         {
              addCriterion("order_no not between ", value1,value2, "order_no");
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
