package com.gooagoo.entity.generator.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 角色-权限关联
 */

public class SysRoleAuthorityExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public SysRoleAuthorityExample()
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

         public Criteria andSysRoleAuthorityIdIsNull()
         {
              addCriterion("sys_role_authority_id is null");
              return (Criteria) this;
         }

         public Criteria andSysRoleAuthorityIdIsNotNull()
         {
              addCriterion("sys_role_authority_id is not null");
              return (Criteria) this;
         }

         public Criteria andSysRoleAuthorityIdEqualTo(String value)
         {
              addCriterion("sys_role_authority_id = ", value, "sys_role_authority_id");
              return (Criteria) this;
         }

         public Criteria andSysRoleAuthorityIdNotEqualTo(String value)
         {
              addCriterion("sys_role_authority_id <> ", value, "sys_role_authority_id");
              return (Criteria) this;
         }

         public Criteria andSysRoleAuthorityIdGreaterThan(String value)
         {
              addCriterion("sys_role_authority_id > ", value, "sys_role_authority_id");
              return (Criteria) this;
         }

         public Criteria andSysRoleAuthorityIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("sys_role_authority_id >= ", value, "sys_role_authority_id");
              return (Criteria) this;
         }

         public Criteria andSysRoleAuthorityIdLessThan(String value)
         {
              addCriterion("sys_role_authority_id < ", value, "sys_role_authority_id");
              return (Criteria) this;
         }

         public Criteria andSysRoleAuthorityIdLessThanOrEqualTo(String value)
         {
              addCriterion("sys_role_authority_id <= ", value, "sys_role_authority_id");
              return (Criteria) this;
         }

         public Criteria andSysRoleAuthorityIdLike(String value)
         {
              addCriterion("sys_role_authority_id like ", value, "sys_role_authority_id");
              return (Criteria) this;
         }

         public Criteria andSysRoleAuthorityIdNotLike(String value)
         {
              addCriterion("sys_role_authority_id not like ", value, "sys_role_authority_id");
              return (Criteria) this;
         }

         public Criteria andSysRoleAuthorityIdIn(List<String> values)
         {
              addCriterion("sys_role_authority_id in ", values, "sys_role_authority_id");
              return (Criteria) this;
         }

         public Criteria andSysRoleAuthorityIdNotIn(List<String> values)
         {
              addCriterion("sys_role_authority_id not in ", values, "sys_role_authority_id");
              return (Criteria) this;
         }

         public Criteria andSysRoleAuthorityIdBetween(String value1, String value2)
         {
              addCriterion("sys_role_authority_id between ", value1,value2, "sys_role_authority_id");
              return (Criteria) this;
         }

         public Criteria andSysRoleAuthorityIdNotBetween(String value1, String value2)
         {
              addCriterion("sys_role_authority_id not between ", value1,value2, "sys_role_authority_id");
              return (Criteria) this;
         }

         public Criteria andRoleIdIsNull()
         {
              addCriterion("role_id is null");
              return (Criteria) this;
         }

         public Criteria andRoleIdIsNotNull()
         {
              addCriterion("role_id is not null");
              return (Criteria) this;
         }

         public Criteria andRoleIdEqualTo(String value)
         {
              addCriterion("role_id = ", value, "role_id");
              return (Criteria) this;
         }

         public Criteria andRoleIdNotEqualTo(String value)
         {
              addCriterion("role_id <> ", value, "role_id");
              return (Criteria) this;
         }

         public Criteria andRoleIdGreaterThan(String value)
         {
              addCriterion("role_id > ", value, "role_id");
              return (Criteria) this;
         }

         public Criteria andRoleIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("role_id >= ", value, "role_id");
              return (Criteria) this;
         }

         public Criteria andRoleIdLessThan(String value)
         {
              addCriterion("role_id < ", value, "role_id");
              return (Criteria) this;
         }

         public Criteria andRoleIdLessThanOrEqualTo(String value)
         {
              addCriterion("role_id <= ", value, "role_id");
              return (Criteria) this;
         }

         public Criteria andRoleIdLike(String value)
         {
              addCriterion("role_id like ", value, "role_id");
              return (Criteria) this;
         }

         public Criteria andRoleIdNotLike(String value)
         {
              addCriterion("role_id not like ", value, "role_id");
              return (Criteria) this;
         }

         public Criteria andRoleIdIn(List<String> values)
         {
              addCriterion("role_id in ", values, "role_id");
              return (Criteria) this;
         }

         public Criteria andRoleIdNotIn(List<String> values)
         {
              addCriterion("role_id not in ", values, "role_id");
              return (Criteria) this;
         }

         public Criteria andRoleIdBetween(String value1, String value2)
         {
              addCriterion("role_id between ", value1,value2, "role_id");
              return (Criteria) this;
         }

         public Criteria andRoleIdNotBetween(String value1, String value2)
         {
              addCriterion("role_id not between ", value1,value2, "role_id");
              return (Criteria) this;
         }

         public Criteria andAuthorityIdIsNull()
         {
              addCriterion("authority_id is null");
              return (Criteria) this;
         }

         public Criteria andAuthorityIdIsNotNull()
         {
              addCriterion("authority_id is not null");
              return (Criteria) this;
         }

         public Criteria andAuthorityIdEqualTo(String value)
         {
              addCriterion("authority_id = ", value, "authority_id");
              return (Criteria) this;
         }

         public Criteria andAuthorityIdNotEqualTo(String value)
         {
              addCriterion("authority_id <> ", value, "authority_id");
              return (Criteria) this;
         }

         public Criteria andAuthorityIdGreaterThan(String value)
         {
              addCriterion("authority_id > ", value, "authority_id");
              return (Criteria) this;
         }

         public Criteria andAuthorityIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("authority_id >= ", value, "authority_id");
              return (Criteria) this;
         }

         public Criteria andAuthorityIdLessThan(String value)
         {
              addCriterion("authority_id < ", value, "authority_id");
              return (Criteria) this;
         }

         public Criteria andAuthorityIdLessThanOrEqualTo(String value)
         {
              addCriterion("authority_id <= ", value, "authority_id");
              return (Criteria) this;
         }

         public Criteria andAuthorityIdLike(String value)
         {
              addCriterion("authority_id like ", value, "authority_id");
              return (Criteria) this;
         }

         public Criteria andAuthorityIdNotLike(String value)
         {
              addCriterion("authority_id not like ", value, "authority_id");
              return (Criteria) this;
         }

         public Criteria andAuthorityIdIn(List<String> values)
         {
              addCriterion("authority_id in ", values, "authority_id");
              return (Criteria) this;
         }

         public Criteria andAuthorityIdNotIn(List<String> values)
         {
              addCriterion("authority_id not in ", values, "authority_id");
              return (Criteria) this;
         }

         public Criteria andAuthorityIdBetween(String value1, String value2)
         {
              addCriterion("authority_id between ", value1,value2, "authority_id");
              return (Criteria) this;
         }

         public Criteria andAuthorityIdNotBetween(String value1, String value2)
         {
              addCriterion("authority_id not between ", value1,value2, "authority_id");
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
