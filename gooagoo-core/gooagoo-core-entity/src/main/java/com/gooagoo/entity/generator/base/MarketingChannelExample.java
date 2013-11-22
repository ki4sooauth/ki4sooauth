package com.gooagoo.entity.generator.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 营销渠道
 */

public class MarketingChannelExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public MarketingChannelExample()
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

         public Criteria andChannelCodeIsNull()
         {
              addCriterion("channel_code is null");
              return (Criteria) this;
         }

         public Criteria andChannelCodeIsNotNull()
         {
              addCriterion("channel_code is not null");
              return (Criteria) this;
         }

         public Criteria andChannelCodeEqualTo(String value)
         {
              addCriterion("channel_code = ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeNotEqualTo(String value)
         {
              addCriterion("channel_code <> ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeGreaterThan(String value)
         {
              addCriterion("channel_code > ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("channel_code >= ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeLessThan(String value)
         {
              addCriterion("channel_code < ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeLessThanOrEqualTo(String value)
         {
              addCriterion("channel_code <= ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeLike(String value)
         {
              addCriterion("channel_code like ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeNotLike(String value)
         {
              addCriterion("channel_code not like ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeIn(List<String> values)
         {
              addCriterion("channel_code in ", values, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeNotIn(List<String> values)
         {
              addCriterion("channel_code not in ", values, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeBetween(String value1, String value2)
         {
              addCriterion("channel_code between ", value1,value2, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeNotBetween(String value1, String value2)
         {
              addCriterion("channel_code not between ", value1,value2, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelNameIsNull()
         {
              addCriterion("channel_name is null");
              return (Criteria) this;
         }

         public Criteria andChannelNameIsNotNull()
         {
              addCriterion("channel_name is not null");
              return (Criteria) this;
         }

         public Criteria andChannelNameEqualTo(String value)
         {
              addCriterion("channel_name = ", value, "channel_name");
              return (Criteria) this;
         }

         public Criteria andChannelNameNotEqualTo(String value)
         {
              addCriterion("channel_name <> ", value, "channel_name");
              return (Criteria) this;
         }

         public Criteria andChannelNameGreaterThan(String value)
         {
              addCriterion("channel_name > ", value, "channel_name");
              return (Criteria) this;
         }

         public Criteria andChannelNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("channel_name >= ", value, "channel_name");
              return (Criteria) this;
         }

         public Criteria andChannelNameLessThan(String value)
         {
              addCriterion("channel_name < ", value, "channel_name");
              return (Criteria) this;
         }

         public Criteria andChannelNameLessThanOrEqualTo(String value)
         {
              addCriterion("channel_name <= ", value, "channel_name");
              return (Criteria) this;
         }

         public Criteria andChannelNameLike(String value)
         {
              addCriterion("channel_name like ", value, "channel_name");
              return (Criteria) this;
         }

         public Criteria andChannelNameNotLike(String value)
         {
              addCriterion("channel_name not like ", value, "channel_name");
              return (Criteria) this;
         }

         public Criteria andChannelNameIn(List<String> values)
         {
              addCriterion("channel_name in ", values, "channel_name");
              return (Criteria) this;
         }

         public Criteria andChannelNameNotIn(List<String> values)
         {
              addCriterion("channel_name not in ", values, "channel_name");
              return (Criteria) this;
         }

         public Criteria andChannelNameBetween(String value1, String value2)
         {
              addCriterion("channel_name between ", value1,value2, "channel_name");
              return (Criteria) this;
         }

         public Criteria andChannelNameNotBetween(String value1, String value2)
         {
              addCriterion("channel_name not between ", value1,value2, "channel_name");
              return (Criteria) this;
         }

         public Criteria andParentChannelCodeIsNull()
         {
              addCriterion("parent_channel_code is null");
              return (Criteria) this;
         }

         public Criteria andParentChannelCodeIsNotNull()
         {
              addCriterion("parent_channel_code is not null");
              return (Criteria) this;
         }

         public Criteria andParentChannelCodeEqualTo(String value)
         {
              addCriterion("parent_channel_code = ", value, "parent_channel_code");
              return (Criteria) this;
         }

         public Criteria andParentChannelCodeNotEqualTo(String value)
         {
              addCriterion("parent_channel_code <> ", value, "parent_channel_code");
              return (Criteria) this;
         }

         public Criteria andParentChannelCodeGreaterThan(String value)
         {
              addCriterion("parent_channel_code > ", value, "parent_channel_code");
              return (Criteria) this;
         }

         public Criteria andParentChannelCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("parent_channel_code >= ", value, "parent_channel_code");
              return (Criteria) this;
         }

         public Criteria andParentChannelCodeLessThan(String value)
         {
              addCriterion("parent_channel_code < ", value, "parent_channel_code");
              return (Criteria) this;
         }

         public Criteria andParentChannelCodeLessThanOrEqualTo(String value)
         {
              addCriterion("parent_channel_code <= ", value, "parent_channel_code");
              return (Criteria) this;
         }

         public Criteria andParentChannelCodeLike(String value)
         {
              addCriterion("parent_channel_code like ", value, "parent_channel_code");
              return (Criteria) this;
         }

         public Criteria andParentChannelCodeNotLike(String value)
         {
              addCriterion("parent_channel_code not like ", value, "parent_channel_code");
              return (Criteria) this;
         }

         public Criteria andParentChannelCodeIn(List<String> values)
         {
              addCriterion("parent_channel_code in ", values, "parent_channel_code");
              return (Criteria) this;
         }

         public Criteria andParentChannelCodeNotIn(List<String> values)
         {
              addCriterion("parent_channel_code not in ", values, "parent_channel_code");
              return (Criteria) this;
         }

         public Criteria andParentChannelCodeBetween(String value1, String value2)
         {
              addCriterion("parent_channel_code between ", value1,value2, "parent_channel_code");
              return (Criteria) this;
         }

         public Criteria andParentChannelCodeNotBetween(String value1, String value2)
         {
              addCriterion("parent_channel_code not between ", value1,value2, "parent_channel_code");
              return (Criteria) this;
         }

         public Criteria andSortOrderIsNull()
         {
              addCriterion("sort_order is null");
              return (Criteria) this;
         }

         public Criteria andSortOrderIsNotNull()
         {
              addCriterion("sort_order is not null");
              return (Criteria) this;
         }

         public Criteria andSortOrderEqualTo(String value)
         {
              addCriterion("sort_order = ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderNotEqualTo(String value)
         {
              addCriterion("sort_order <> ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderGreaterThan(String value)
         {
              addCriterion("sort_order > ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderGreaterThanOrEqualTo(String value)
         {
              addCriterion("sort_order >= ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderLessThan(String value)
         {
              addCriterion("sort_order < ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderLessThanOrEqualTo(String value)
         {
              addCriterion("sort_order <= ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderLike(String value)
         {
              addCriterion("sort_order like ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderNotLike(String value)
         {
              addCriterion("sort_order not like ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderIn(List<String> values)
         {
              addCriterion("sort_order in ", values, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderNotIn(List<String> values)
         {
              addCriterion("sort_order not in ", values, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderBetween(String value1, String value2)
         {
              addCriterion("sort_order between ", value1,value2, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderNotBetween(String value1, String value2)
         {
              addCriterion("sort_order not between ", value1,value2, "sort_order");
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
