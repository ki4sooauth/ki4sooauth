package com.gooagoo.entity.generator.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 发票信息管理
 */

public class ReceiptInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ReceiptInfoExample()
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

         public Criteria andReceiptIdIsNull()
         {
              addCriterion("receipt_id is null");
              return (Criteria) this;
         }

         public Criteria andReceiptIdIsNotNull()
         {
              addCriterion("receipt_id is not null");
              return (Criteria) this;
         }

         public Criteria andReceiptIdEqualTo(String value)
         {
              addCriterion("receipt_id = ", value, "receipt_id");
              return (Criteria) this;
         }

         public Criteria andReceiptIdNotEqualTo(String value)
         {
              addCriterion("receipt_id <> ", value, "receipt_id");
              return (Criteria) this;
         }

         public Criteria andReceiptIdGreaterThan(String value)
         {
              addCriterion("receipt_id > ", value, "receipt_id");
              return (Criteria) this;
         }

         public Criteria andReceiptIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("receipt_id >= ", value, "receipt_id");
              return (Criteria) this;
         }

         public Criteria andReceiptIdLessThan(String value)
         {
              addCriterion("receipt_id < ", value, "receipt_id");
              return (Criteria) this;
         }

         public Criteria andReceiptIdLessThanOrEqualTo(String value)
         {
              addCriterion("receipt_id <= ", value, "receipt_id");
              return (Criteria) this;
         }

         public Criteria andReceiptIdLike(String value)
         {
              addCriterion("receipt_id like ", value, "receipt_id");
              return (Criteria) this;
         }

         public Criteria andReceiptIdNotLike(String value)
         {
              addCriterion("receipt_id not like ", value, "receipt_id");
              return (Criteria) this;
         }

         public Criteria andReceiptIdIn(List<String> values)
         {
              addCriterion("receipt_id in ", values, "receipt_id");
              return (Criteria) this;
         }

         public Criteria andReceiptIdNotIn(List<String> values)
         {
              addCriterion("receipt_id not in ", values, "receipt_id");
              return (Criteria) this;
         }

         public Criteria andReceiptIdBetween(String value1, String value2)
         {
              addCriterion("receipt_id between ", value1,value2, "receipt_id");
              return (Criteria) this;
         }

         public Criteria andReceiptIdNotBetween(String value1, String value2)
         {
              addCriterion("receipt_id not between ", value1,value2, "receipt_id");
              return (Criteria) this;
         }

         public Criteria andUserIdIsNull()
         {
              addCriterion("user_id is null");
              return (Criteria) this;
         }

         public Criteria andUserIdIsNotNull()
         {
              addCriterion("user_id is not null");
              return (Criteria) this;
         }

         public Criteria andUserIdEqualTo(String value)
         {
              addCriterion("user_id = ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdNotEqualTo(String value)
         {
              addCriterion("user_id <> ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdGreaterThan(String value)
         {
              addCriterion("user_id > ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("user_id >= ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdLessThan(String value)
         {
              addCriterion("user_id < ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdLessThanOrEqualTo(String value)
         {
              addCriterion("user_id <= ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdLike(String value)
         {
              addCriterion("user_id like ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdNotLike(String value)
         {
              addCriterion("user_id not like ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdIn(List<String> values)
         {
              addCriterion("user_id in ", values, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdNotIn(List<String> values)
         {
              addCriterion("user_id not in ", values, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdBetween(String value1, String value2)
         {
              addCriterion("user_id between ", value1,value2, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdNotBetween(String value1, String value2)
         {
              addCriterion("user_id not between ", value1,value2, "user_id");
              return (Criteria) this;
         }

         public Criteria andCompanyNameIsNull()
         {
              addCriterion("company_name is null");
              return (Criteria) this;
         }

         public Criteria andCompanyNameIsNotNull()
         {
              addCriterion("company_name is not null");
              return (Criteria) this;
         }

         public Criteria andCompanyNameEqualTo(String value)
         {
              addCriterion("company_name = ", value, "company_name");
              return (Criteria) this;
         }

         public Criteria andCompanyNameNotEqualTo(String value)
         {
              addCriterion("company_name <> ", value, "company_name");
              return (Criteria) this;
         }

         public Criteria andCompanyNameGreaterThan(String value)
         {
              addCriterion("company_name > ", value, "company_name");
              return (Criteria) this;
         }

         public Criteria andCompanyNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("company_name >= ", value, "company_name");
              return (Criteria) this;
         }

         public Criteria andCompanyNameLessThan(String value)
         {
              addCriterion("company_name < ", value, "company_name");
              return (Criteria) this;
         }

         public Criteria andCompanyNameLessThanOrEqualTo(String value)
         {
              addCriterion("company_name <= ", value, "company_name");
              return (Criteria) this;
         }

         public Criteria andCompanyNameLike(String value)
         {
              addCriterion("company_name like ", value, "company_name");
              return (Criteria) this;
         }

         public Criteria andCompanyNameNotLike(String value)
         {
              addCriterion("company_name not like ", value, "company_name");
              return (Criteria) this;
         }

         public Criteria andCompanyNameIn(List<String> values)
         {
              addCriterion("company_name in ", values, "company_name");
              return (Criteria) this;
         }

         public Criteria andCompanyNameNotIn(List<String> values)
         {
              addCriterion("company_name not in ", values, "company_name");
              return (Criteria) this;
         }

         public Criteria andCompanyNameBetween(String value1, String value2)
         {
              addCriterion("company_name between ", value1,value2, "company_name");
              return (Criteria) this;
         }

         public Criteria andCompanyNameNotBetween(String value1, String value2)
         {
              addCriterion("company_name not between ", value1,value2, "company_name");
              return (Criteria) this;
         }

         public Criteria andIsDefaultIsNull()
         {
              addCriterion("is_default is null");
              return (Criteria) this;
         }

         public Criteria andIsDefaultIsNotNull()
         {
              addCriterion("is_default is not null");
              return (Criteria) this;
         }

         public Criteria andIsDefaultEqualTo(String value)
         {
              addCriterion("is_default = ", value, "is_default");
              return (Criteria) this;
         }

         public Criteria andIsDefaultNotEqualTo(String value)
         {
              addCriterion("is_default <> ", value, "is_default");
              return (Criteria) this;
         }

         public Criteria andIsDefaultGreaterThan(String value)
         {
              addCriterion("is_default > ", value, "is_default");
              return (Criteria) this;
         }

         public Criteria andIsDefaultGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_default >= ", value, "is_default");
              return (Criteria) this;
         }

         public Criteria andIsDefaultLessThan(String value)
         {
              addCriterion("is_default < ", value, "is_default");
              return (Criteria) this;
         }

         public Criteria andIsDefaultLessThanOrEqualTo(String value)
         {
              addCriterion("is_default <= ", value, "is_default");
              return (Criteria) this;
         }

         public Criteria andIsDefaultLike(String value)
         {
              addCriterion("is_default like ", value, "is_default");
              return (Criteria) this;
         }

         public Criteria andIsDefaultNotLike(String value)
         {
              addCriterion("is_default not like ", value, "is_default");
              return (Criteria) this;
         }

         public Criteria andIsDefaultIn(List<String> values)
         {
              addCriterion("is_default in ", values, "is_default");
              return (Criteria) this;
         }

         public Criteria andIsDefaultNotIn(List<String> values)
         {
              addCriterion("is_default not in ", values, "is_default");
              return (Criteria) this;
         }

         public Criteria andIsDefaultBetween(String value1, String value2)
         {
              addCriterion("is_default between ", value1,value2, "is_default");
              return (Criteria) this;
         }

         public Criteria andIsDefaultNotBetween(String value1, String value2)
         {
              addCriterion("is_default not between ", value1,value2, "is_default");
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