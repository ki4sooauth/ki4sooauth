package com.gooagoo.entity.generator.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 产品序列号信息
 */

public class ProductSerialNumberExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ProductSerialNumberExample()
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

         public Criteria andGooagooIdIsNull()
         {
              addCriterion("gooagoo_id is null");
              return (Criteria) this;
         }

         public Criteria andGooagooIdIsNotNull()
         {
              addCriterion("gooagoo_id is not null");
              return (Criteria) this;
         }

         public Criteria andGooagooIdEqualTo(String value)
         {
              addCriterion("gooagoo_id = ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdNotEqualTo(String value)
         {
              addCriterion("gooagoo_id <> ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdGreaterThan(String value)
         {
              addCriterion("gooagoo_id > ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("gooagoo_id >= ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdLessThan(String value)
         {
              addCriterion("gooagoo_id < ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdLessThanOrEqualTo(String value)
         {
              addCriterion("gooagoo_id <= ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdLike(String value)
         {
              addCriterion("gooagoo_id like ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdNotLike(String value)
         {
              addCriterion("gooagoo_id not like ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdIn(List<String> values)
         {
              addCriterion("gooagoo_id in ", values, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdNotIn(List<String> values)
         {
              addCriterion("gooagoo_id not in ", values, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdBetween(String value1, String value2)
         {
              addCriterion("gooagoo_id between ", value1,value2, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdNotBetween(String value1, String value2)
         {
              addCriterion("gooagoo_id not between ", value1,value2, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andMacAddressIsNull()
         {
              addCriterion("mac_address is null");
              return (Criteria) this;
         }

         public Criteria andMacAddressIsNotNull()
         {
              addCriterion("mac_address is not null");
              return (Criteria) this;
         }

         public Criteria andMacAddressEqualTo(String value)
         {
              addCriterion("mac_address = ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressNotEqualTo(String value)
         {
              addCriterion("mac_address <> ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressGreaterThan(String value)
         {
              addCriterion("mac_address > ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressGreaterThanOrEqualTo(String value)
         {
              addCriterion("mac_address >= ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressLessThan(String value)
         {
              addCriterion("mac_address < ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressLessThanOrEqualTo(String value)
         {
              addCriterion("mac_address <= ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressLike(String value)
         {
              addCriterion("mac_address like ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressNotLike(String value)
         {
              addCriterion("mac_address not like ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressIn(List<String> values)
         {
              addCriterion("mac_address in ", values, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressNotIn(List<String> values)
         {
              addCriterion("mac_address not in ", values, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressBetween(String value1, String value2)
         {
              addCriterion("mac_address between ", value1,value2, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressNotBetween(String value1, String value2)
         {
              addCriterion("mac_address not between ", value1,value2, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMIdIsNull()
         {
              addCriterion("m_id is null");
              return (Criteria) this;
         }

         public Criteria andMIdIsNotNull()
         {
              addCriterion("m_id is not null");
              return (Criteria) this;
         }

         public Criteria andMIdEqualTo(String value)
         {
              addCriterion("m_id = ", value, "m_id");
              return (Criteria) this;
         }

         public Criteria andMIdNotEqualTo(String value)
         {
              addCriterion("m_id <> ", value, "m_id");
              return (Criteria) this;
         }

         public Criteria andMIdGreaterThan(String value)
         {
              addCriterion("m_id > ", value, "m_id");
              return (Criteria) this;
         }

         public Criteria andMIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("m_id >= ", value, "m_id");
              return (Criteria) this;
         }

         public Criteria andMIdLessThan(String value)
         {
              addCriterion("m_id < ", value, "m_id");
              return (Criteria) this;
         }

         public Criteria andMIdLessThanOrEqualTo(String value)
         {
              addCriterion("m_id <= ", value, "m_id");
              return (Criteria) this;
         }

         public Criteria andMIdLike(String value)
         {
              addCriterion("m_id like ", value, "m_id");
              return (Criteria) this;
         }

         public Criteria andMIdNotLike(String value)
         {
              addCriterion("m_id not like ", value, "m_id");
              return (Criteria) this;
         }

         public Criteria andMIdIn(List<String> values)
         {
              addCriterion("m_id in ", values, "m_id");
              return (Criteria) this;
         }

         public Criteria andMIdNotIn(List<String> values)
         {
              addCriterion("m_id not in ", values, "m_id");
              return (Criteria) this;
         }

         public Criteria andMIdBetween(String value1, String value2)
         {
              addCriterion("m_id between ", value1,value2, "m_id");
              return (Criteria) this;
         }

         public Criteria andMIdNotBetween(String value1, String value2)
         {
              addCriterion("m_id not between ", value1,value2, "m_id");
              return (Criteria) this;
         }

         public Criteria andMVerIsNull()
         {
              addCriterion("m_ver is null");
              return (Criteria) this;
         }

         public Criteria andMVerIsNotNull()
         {
              addCriterion("m_ver is not null");
              return (Criteria) this;
         }

         public Criteria andMVerEqualTo(String value)
         {
              addCriterion("m_ver = ", value, "m_ver");
              return (Criteria) this;
         }

         public Criteria andMVerNotEqualTo(String value)
         {
              addCriterion("m_ver <> ", value, "m_ver");
              return (Criteria) this;
         }

         public Criteria andMVerGreaterThan(String value)
         {
              addCriterion("m_ver > ", value, "m_ver");
              return (Criteria) this;
         }

         public Criteria andMVerGreaterThanOrEqualTo(String value)
         {
              addCriterion("m_ver >= ", value, "m_ver");
              return (Criteria) this;
         }

         public Criteria andMVerLessThan(String value)
         {
              addCriterion("m_ver < ", value, "m_ver");
              return (Criteria) this;
         }

         public Criteria andMVerLessThanOrEqualTo(String value)
         {
              addCriterion("m_ver <= ", value, "m_ver");
              return (Criteria) this;
         }

         public Criteria andMVerLike(String value)
         {
              addCriterion("m_ver like ", value, "m_ver");
              return (Criteria) this;
         }

         public Criteria andMVerNotLike(String value)
         {
              addCriterion("m_ver not like ", value, "m_ver");
              return (Criteria) this;
         }

         public Criteria andMVerIn(List<String> values)
         {
              addCriterion("m_ver in ", values, "m_ver");
              return (Criteria) this;
         }

         public Criteria andMVerNotIn(List<String> values)
         {
              addCriterion("m_ver not in ", values, "m_ver");
              return (Criteria) this;
         }

         public Criteria andMVerBetween(String value1, String value2)
         {
              addCriterion("m_ver between ", value1,value2, "m_ver");
              return (Criteria) this;
         }

         public Criteria andMVerNotBetween(String value1, String value2)
         {
              addCriterion("m_ver not between ", value1,value2, "m_ver");
              return (Criteria) this;
         }

         public Criteria andMTypeIsNull()
         {
              addCriterion("m_type is null");
              return (Criteria) this;
         }

         public Criteria andMTypeIsNotNull()
         {
              addCriterion("m_type is not null");
              return (Criteria) this;
         }

         public Criteria andMTypeEqualTo(String value)
         {
              addCriterion("m_type = ", value, "m_type");
              return (Criteria) this;
         }

         public Criteria andMTypeNotEqualTo(String value)
         {
              addCriterion("m_type <> ", value, "m_type");
              return (Criteria) this;
         }

         public Criteria andMTypeGreaterThan(String value)
         {
              addCriterion("m_type > ", value, "m_type");
              return (Criteria) this;
         }

         public Criteria andMTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("m_type >= ", value, "m_type");
              return (Criteria) this;
         }

         public Criteria andMTypeLessThan(String value)
         {
              addCriterion("m_type < ", value, "m_type");
              return (Criteria) this;
         }

         public Criteria andMTypeLessThanOrEqualTo(String value)
         {
              addCriterion("m_type <= ", value, "m_type");
              return (Criteria) this;
         }

         public Criteria andMTypeLike(String value)
         {
              addCriterion("m_type like ", value, "m_type");
              return (Criteria) this;
         }

         public Criteria andMTypeNotLike(String value)
         {
              addCriterion("m_type not like ", value, "m_type");
              return (Criteria) this;
         }

         public Criteria andMTypeIn(List<String> values)
         {
              addCriterion("m_type in ", values, "m_type");
              return (Criteria) this;
         }

         public Criteria andMTypeNotIn(List<String> values)
         {
              addCriterion("m_type not in ", values, "m_type");
              return (Criteria) this;
         }

         public Criteria andMTypeBetween(String value1, String value2)
         {
              addCriterion("m_type between ", value1,value2, "m_type");
              return (Criteria) this;
         }

         public Criteria andMTypeNotBetween(String value1, String value2)
         {
              addCriterion("m_type not between ", value1,value2, "m_type");
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
