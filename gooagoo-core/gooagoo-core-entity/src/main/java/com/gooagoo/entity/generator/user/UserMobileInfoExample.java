package com.gooagoo.entity.generator.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 用户移动终端信息
 */

public class UserMobileInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public UserMobileInfoExample()
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

         public Criteria andSessionidIsNull()
         {
              addCriterion("sessionid is null");
              return (Criteria) this;
         }

         public Criteria andSessionidIsNotNull()
         {
              addCriterion("sessionid is not null");
              return (Criteria) this;
         }

         public Criteria andSessionidEqualTo(String value)
         {
              addCriterion("sessionid = ", value, "sessionid");
              return (Criteria) this;
         }

         public Criteria andSessionidNotEqualTo(String value)
         {
              addCriterion("sessionid <> ", value, "sessionid");
              return (Criteria) this;
         }

         public Criteria andSessionidGreaterThan(String value)
         {
              addCriterion("sessionid > ", value, "sessionid");
              return (Criteria) this;
         }

         public Criteria andSessionidGreaterThanOrEqualTo(String value)
         {
              addCriterion("sessionid >= ", value, "sessionid");
              return (Criteria) this;
         }

         public Criteria andSessionidLessThan(String value)
         {
              addCriterion("sessionid < ", value, "sessionid");
              return (Criteria) this;
         }

         public Criteria andSessionidLessThanOrEqualTo(String value)
         {
              addCriterion("sessionid <= ", value, "sessionid");
              return (Criteria) this;
         }

         public Criteria andSessionidLike(String value)
         {
              addCriterion("sessionid like ", value, "sessionid");
              return (Criteria) this;
         }

         public Criteria andSessionidNotLike(String value)
         {
              addCriterion("sessionid not like ", value, "sessionid");
              return (Criteria) this;
         }

         public Criteria andSessionidIn(List<String> values)
         {
              addCriterion("sessionid in ", values, "sessionid");
              return (Criteria) this;
         }

         public Criteria andSessionidNotIn(List<String> values)
         {
              addCriterion("sessionid not in ", values, "sessionid");
              return (Criteria) this;
         }

         public Criteria andSessionidBetween(String value1, String value2)
         {
              addCriterion("sessionid between ", value1,value2, "sessionid");
              return (Criteria) this;
         }

         public Criteria andSessionidNotBetween(String value1, String value2)
         {
              addCriterion("sessionid not between ", value1,value2, "sessionid");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenIsNull()
         {
              addCriterion("iphone_token is null");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenIsNotNull()
         {
              addCriterion("iphone_token is not null");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenEqualTo(String value)
         {
              addCriterion("iphone_token = ", value, "iphone_token");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenNotEqualTo(String value)
         {
              addCriterion("iphone_token <> ", value, "iphone_token");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenGreaterThan(String value)
         {
              addCriterion("iphone_token > ", value, "iphone_token");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenGreaterThanOrEqualTo(String value)
         {
              addCriterion("iphone_token >= ", value, "iphone_token");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenLessThan(String value)
         {
              addCriterion("iphone_token < ", value, "iphone_token");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenLessThanOrEqualTo(String value)
         {
              addCriterion("iphone_token <= ", value, "iphone_token");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenLike(String value)
         {
              addCriterion("iphone_token like ", value, "iphone_token");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenNotLike(String value)
         {
              addCriterion("iphone_token not like ", value, "iphone_token");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenIn(List<String> values)
         {
              addCriterion("iphone_token in ", values, "iphone_token");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenNotIn(List<String> values)
         {
              addCriterion("iphone_token not in ", values, "iphone_token");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenBetween(String value1, String value2)
         {
              addCriterion("iphone_token between ", value1,value2, "iphone_token");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenNotBetween(String value1, String value2)
         {
              addCriterion("iphone_token not between ", value1,value2, "iphone_token");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenTimeIsNull()
         {
              addCriterion("iphone_token_time is null");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenTimeIsNotNull()
         {
              addCriterion("iphone_token_time is not null");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenTimeEqualTo(Date value)
         {
              addCriterion("iphone_token_time = ", value, "iphone_token_time");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenTimeNotEqualTo(Date value)
         {
              addCriterion("iphone_token_time <> ", value, "iphone_token_time");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenTimeGreaterThan(Date value)
         {
              addCriterion("iphone_token_time > ", value, "iphone_token_time");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("iphone_token_time >= ", value, "iphone_token_time");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenTimeLessThan(Date value)
         {
              addCriterion("iphone_token_time < ", value, "iphone_token_time");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("iphone_token_time <= ", value, "iphone_token_time");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenTimeIn(List<Date> values)
         {
              addCriterion("iphone_token_time in ", values, "iphone_token_time");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenTimeNotIn(List<Date> values)
         {
              addCriterion("iphone_token_time not in ", values, "iphone_token_time");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenTimeBetween(Date value1, Date value2)
         {
              addCriterion("iphone_token_time between ", value1,value2, "iphone_token_time");
              return (Criteria) this;
         }

         public Criteria andIphoneTokenTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("iphone_token_time not between ", value1,value2, "iphone_token_time");
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
