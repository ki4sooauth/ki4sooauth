package com.gooagoo.entity.generator.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 权限表，由数据库管理员维护，只有在新增功能时才有可能变动
 */

public class SysAuthorityExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public SysAuthorityExample()
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

         public Criteria andAuthorityNameIsNull()
         {
              addCriterion("authority_name is null");
              return (Criteria) this;
         }

         public Criteria andAuthorityNameIsNotNull()
         {
              addCriterion("authority_name is not null");
              return (Criteria) this;
         }

         public Criteria andAuthorityNameEqualTo(String value)
         {
              addCriterion("authority_name = ", value, "authority_name");
              return (Criteria) this;
         }

         public Criteria andAuthorityNameNotEqualTo(String value)
         {
              addCriterion("authority_name <> ", value, "authority_name");
              return (Criteria) this;
         }

         public Criteria andAuthorityNameGreaterThan(String value)
         {
              addCriterion("authority_name > ", value, "authority_name");
              return (Criteria) this;
         }

         public Criteria andAuthorityNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("authority_name >= ", value, "authority_name");
              return (Criteria) this;
         }

         public Criteria andAuthorityNameLessThan(String value)
         {
              addCriterion("authority_name < ", value, "authority_name");
              return (Criteria) this;
         }

         public Criteria andAuthorityNameLessThanOrEqualTo(String value)
         {
              addCriterion("authority_name <= ", value, "authority_name");
              return (Criteria) this;
         }

         public Criteria andAuthorityNameLike(String value)
         {
              addCriterion("authority_name like ", value, "authority_name");
              return (Criteria) this;
         }

         public Criteria andAuthorityNameNotLike(String value)
         {
              addCriterion("authority_name not like ", value, "authority_name");
              return (Criteria) this;
         }

         public Criteria andAuthorityNameIn(List<String> values)
         {
              addCriterion("authority_name in ", values, "authority_name");
              return (Criteria) this;
         }

         public Criteria andAuthorityNameNotIn(List<String> values)
         {
              addCriterion("authority_name not in ", values, "authority_name");
              return (Criteria) this;
         }

         public Criteria andAuthorityNameBetween(String value1, String value2)
         {
              addCriterion("authority_name between ", value1,value2, "authority_name");
              return (Criteria) this;
         }

         public Criteria andAuthorityNameNotBetween(String value1, String value2)
         {
              addCriterion("authority_name not between ", value1,value2, "authority_name");
              return (Criteria) this;
         }

         public Criteria andParentAuthorityIdIsNull()
         {
              addCriterion("parent_authority_id is null");
              return (Criteria) this;
         }

         public Criteria andParentAuthorityIdIsNotNull()
         {
              addCriterion("parent_authority_id is not null");
              return (Criteria) this;
         }

         public Criteria andParentAuthorityIdEqualTo(String value)
         {
              addCriterion("parent_authority_id = ", value, "parent_authority_id");
              return (Criteria) this;
         }

         public Criteria andParentAuthorityIdNotEqualTo(String value)
         {
              addCriterion("parent_authority_id <> ", value, "parent_authority_id");
              return (Criteria) this;
         }

         public Criteria andParentAuthorityIdGreaterThan(String value)
         {
              addCriterion("parent_authority_id > ", value, "parent_authority_id");
              return (Criteria) this;
         }

         public Criteria andParentAuthorityIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("parent_authority_id >= ", value, "parent_authority_id");
              return (Criteria) this;
         }

         public Criteria andParentAuthorityIdLessThan(String value)
         {
              addCriterion("parent_authority_id < ", value, "parent_authority_id");
              return (Criteria) this;
         }

         public Criteria andParentAuthorityIdLessThanOrEqualTo(String value)
         {
              addCriterion("parent_authority_id <= ", value, "parent_authority_id");
              return (Criteria) this;
         }

         public Criteria andParentAuthorityIdLike(String value)
         {
              addCriterion("parent_authority_id like ", value, "parent_authority_id");
              return (Criteria) this;
         }

         public Criteria andParentAuthorityIdNotLike(String value)
         {
              addCriterion("parent_authority_id not like ", value, "parent_authority_id");
              return (Criteria) this;
         }

         public Criteria andParentAuthorityIdIn(List<String> values)
         {
              addCriterion("parent_authority_id in ", values, "parent_authority_id");
              return (Criteria) this;
         }

         public Criteria andParentAuthorityIdNotIn(List<String> values)
         {
              addCriterion("parent_authority_id not in ", values, "parent_authority_id");
              return (Criteria) this;
         }

         public Criteria andParentAuthorityIdBetween(String value1, String value2)
         {
              addCriterion("parent_authority_id between ", value1,value2, "parent_authority_id");
              return (Criteria) this;
         }

         public Criteria andParentAuthorityIdNotBetween(String value1, String value2)
         {
              addCriterion("parent_authority_id not between ", value1,value2, "parent_authority_id");
              return (Criteria) this;
         }

         public Criteria andLinkIsNull()
         {
              addCriterion("link is null");
              return (Criteria) this;
         }

         public Criteria andLinkIsNotNull()
         {
              addCriterion("link is not null");
              return (Criteria) this;
         }

         public Criteria andLinkEqualTo(String value)
         {
              addCriterion("link = ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkNotEqualTo(String value)
         {
              addCriterion("link <> ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkGreaterThan(String value)
         {
              addCriterion("link > ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkGreaterThanOrEqualTo(String value)
         {
              addCriterion("link >= ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkLessThan(String value)
         {
              addCriterion("link < ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkLessThanOrEqualTo(String value)
         {
              addCriterion("link <= ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkLike(String value)
         {
              addCriterion("link like ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkNotLike(String value)
         {
              addCriterion("link not like ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkIn(List<String> values)
         {
              addCriterion("link in ", values, "link");
              return (Criteria) this;
         }

         public Criteria andLinkNotIn(List<String> values)
         {
              addCriterion("link not in ", values, "link");
              return (Criteria) this;
         }

         public Criteria andLinkBetween(String value1, String value2)
         {
              addCriterion("link between ", value1,value2, "link");
              return (Criteria) this;
         }

         public Criteria andLinkNotBetween(String value1, String value2)
         {
              addCriterion("link not between ", value1,value2, "link");
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