package com.gooagoo.entity.generator.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 用户密保问题表
 */

public class UserSecurityQuestionExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public UserSecurityQuestionExample()
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

         public Criteria andTypeIsNull()
         {
              addCriterion("type is null");
              return (Criteria) this;
         }

         public Criteria andTypeIsNotNull()
         {
              addCriterion("type is not null");
              return (Criteria) this;
         }

         public Criteria andTypeEqualTo(String value)
         {
              addCriterion("type = ", value, "type");
              return (Criteria) this;
         }

         public Criteria andTypeNotEqualTo(String value)
         {
              addCriterion("type <> ", value, "type");
              return (Criteria) this;
         }

         public Criteria andTypeGreaterThan(String value)
         {
              addCriterion("type > ", value, "type");
              return (Criteria) this;
         }

         public Criteria andTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("type >= ", value, "type");
              return (Criteria) this;
         }

         public Criteria andTypeLessThan(String value)
         {
              addCriterion("type < ", value, "type");
              return (Criteria) this;
         }

         public Criteria andTypeLessThanOrEqualTo(String value)
         {
              addCriterion("type <= ", value, "type");
              return (Criteria) this;
         }

         public Criteria andTypeLike(String value)
         {
              addCriterion("type like ", value, "type");
              return (Criteria) this;
         }

         public Criteria andTypeNotLike(String value)
         {
              addCriterion("type not like ", value, "type");
              return (Criteria) this;
         }

         public Criteria andTypeIn(List<String> values)
         {
              addCriterion("type in ", values, "type");
              return (Criteria) this;
         }

         public Criteria andTypeNotIn(List<String> values)
         {
              addCriterion("type not in ", values, "type");
              return (Criteria) this;
         }

         public Criteria andTypeBetween(String value1, String value2)
         {
              addCriterion("type between ", value1,value2, "type");
              return (Criteria) this;
         }

         public Criteria andTypeNotBetween(String value1, String value2)
         {
              addCriterion("type not between ", value1,value2, "type");
              return (Criteria) this;
         }

         public Criteria andSysIdIsNull()
         {
              addCriterion("sys_id is null");
              return (Criteria) this;
         }

         public Criteria andSysIdIsNotNull()
         {
              addCriterion("sys_id is not null");
              return (Criteria) this;
         }

         public Criteria andSysIdEqualTo(String value)
         {
              addCriterion("sys_id = ", value, "sys_id");
              return (Criteria) this;
         }

         public Criteria andSysIdNotEqualTo(String value)
         {
              addCriterion("sys_id <> ", value, "sys_id");
              return (Criteria) this;
         }

         public Criteria andSysIdGreaterThan(String value)
         {
              addCriterion("sys_id > ", value, "sys_id");
              return (Criteria) this;
         }

         public Criteria andSysIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("sys_id >= ", value, "sys_id");
              return (Criteria) this;
         }

         public Criteria andSysIdLessThan(String value)
         {
              addCriterion("sys_id < ", value, "sys_id");
              return (Criteria) this;
         }

         public Criteria andSysIdLessThanOrEqualTo(String value)
         {
              addCriterion("sys_id <= ", value, "sys_id");
              return (Criteria) this;
         }

         public Criteria andSysIdLike(String value)
         {
              addCriterion("sys_id like ", value, "sys_id");
              return (Criteria) this;
         }

         public Criteria andSysIdNotLike(String value)
         {
              addCriterion("sys_id not like ", value, "sys_id");
              return (Criteria) this;
         }

         public Criteria andSysIdIn(List<String> values)
         {
              addCriterion("sys_id in ", values, "sys_id");
              return (Criteria) this;
         }

         public Criteria andSysIdNotIn(List<String> values)
         {
              addCriterion("sys_id not in ", values, "sys_id");
              return (Criteria) this;
         }

         public Criteria andSysIdBetween(String value1, String value2)
         {
              addCriterion("sys_id between ", value1,value2, "sys_id");
              return (Criteria) this;
         }

         public Criteria andSysIdNotBetween(String value1, String value2)
         {
              addCriterion("sys_id not between ", value1,value2, "sys_id");
              return (Criteria) this;
         }

         public Criteria andContentIsNull()
         {
              addCriterion("content is null");
              return (Criteria) this;
         }

         public Criteria andContentIsNotNull()
         {
              addCriterion("content is not null");
              return (Criteria) this;
         }

         public Criteria andContentEqualTo(String value)
         {
              addCriterion("content = ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentNotEqualTo(String value)
         {
              addCriterion("content <> ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentGreaterThan(String value)
         {
              addCriterion("content > ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentGreaterThanOrEqualTo(String value)
         {
              addCriterion("content >= ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentLessThan(String value)
         {
              addCriterion("content < ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentLessThanOrEqualTo(String value)
         {
              addCriterion("content <= ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentLike(String value)
         {
              addCriterion("content like ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentNotLike(String value)
         {
              addCriterion("content not like ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentIn(List<String> values)
         {
              addCriterion("content in ", values, "content");
              return (Criteria) this;
         }

         public Criteria andContentNotIn(List<String> values)
         {
              addCriterion("content not in ", values, "content");
              return (Criteria) this;
         }

         public Criteria andContentBetween(String value1, String value2)
         {
              addCriterion("content between ", value1,value2, "content");
              return (Criteria) this;
         }

         public Criteria andContentNotBetween(String value1, String value2)
         {
              addCriterion("content not between ", value1,value2, "content");
              return (Criteria) this;
         }

         public Criteria andAnswerIsNull()
         {
              addCriterion("answer is null");
              return (Criteria) this;
         }

         public Criteria andAnswerIsNotNull()
         {
              addCriterion("answer is not null");
              return (Criteria) this;
         }

         public Criteria andAnswerEqualTo(String value)
         {
              addCriterion("answer = ", value, "answer");
              return (Criteria) this;
         }

         public Criteria andAnswerNotEqualTo(String value)
         {
              addCriterion("answer <> ", value, "answer");
              return (Criteria) this;
         }

         public Criteria andAnswerGreaterThan(String value)
         {
              addCriterion("answer > ", value, "answer");
              return (Criteria) this;
         }

         public Criteria andAnswerGreaterThanOrEqualTo(String value)
         {
              addCriterion("answer >= ", value, "answer");
              return (Criteria) this;
         }

         public Criteria andAnswerLessThan(String value)
         {
              addCriterion("answer < ", value, "answer");
              return (Criteria) this;
         }

         public Criteria andAnswerLessThanOrEqualTo(String value)
         {
              addCriterion("answer <= ", value, "answer");
              return (Criteria) this;
         }

         public Criteria andAnswerLike(String value)
         {
              addCriterion("answer like ", value, "answer");
              return (Criteria) this;
         }

         public Criteria andAnswerNotLike(String value)
         {
              addCriterion("answer not like ", value, "answer");
              return (Criteria) this;
         }

         public Criteria andAnswerIn(List<String> values)
         {
              addCriterion("answer in ", values, "answer");
              return (Criteria) this;
         }

         public Criteria andAnswerNotIn(List<String> values)
         {
              addCriterion("answer not in ", values, "answer");
              return (Criteria) this;
         }

         public Criteria andAnswerBetween(String value1, String value2)
         {
              addCriterion("answer between ", value1,value2, "answer");
              return (Criteria) this;
         }

         public Criteria andAnswerNotBetween(String value1, String value2)
         {
              addCriterion("answer not between ", value1,value2, "answer");
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
