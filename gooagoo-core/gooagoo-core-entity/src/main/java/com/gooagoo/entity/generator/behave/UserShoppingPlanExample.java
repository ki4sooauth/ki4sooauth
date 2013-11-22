package com.gooagoo.entity.generator.behave;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 购物清单主表
 */

public class UserShoppingPlanExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public UserShoppingPlanExample()
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

         public Criteria andShoppingListIdIsNull()
         {
              addCriterion("shopping_list_id is null");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdIsNotNull()
         {
              addCriterion("shopping_list_id is not null");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdEqualTo(String value)
         {
              addCriterion("shopping_list_id = ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdNotEqualTo(String value)
         {
              addCriterion("shopping_list_id <> ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdGreaterThan(String value)
         {
              addCriterion("shopping_list_id > ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("shopping_list_id >= ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdLessThan(String value)
         {
              addCriterion("shopping_list_id < ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdLessThanOrEqualTo(String value)
         {
              addCriterion("shopping_list_id <= ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdLike(String value)
         {
              addCriterion("shopping_list_id like ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdNotLike(String value)
         {
              addCriterion("shopping_list_id not like ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdIn(List<String> values)
         {
              addCriterion("shopping_list_id in ", values, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdNotIn(List<String> values)
         {
              addCriterion("shopping_list_id not in ", values, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdBetween(String value1, String value2)
         {
              addCriterion("shopping_list_id between ", value1,value2, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdNotBetween(String value1, String value2)
         {
              addCriterion("shopping_list_id not between ", value1,value2, "shopping_list_id");
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

         public Criteria andTitleIsNull()
         {
              addCriterion("title is null");
              return (Criteria) this;
         }

         public Criteria andTitleIsNotNull()
         {
              addCriterion("title is not null");
              return (Criteria) this;
         }

         public Criteria andTitleEqualTo(String value)
         {
              addCriterion("title = ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleNotEqualTo(String value)
         {
              addCriterion("title <> ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleGreaterThan(String value)
         {
              addCriterion("title > ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleGreaterThanOrEqualTo(String value)
         {
              addCriterion("title >= ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleLessThan(String value)
         {
              addCriterion("title < ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleLessThanOrEqualTo(String value)
         {
              addCriterion("title <= ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleLike(String value)
         {
              addCriterion("title like ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleNotLike(String value)
         {
              addCriterion("title not like ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleIn(List<String> values)
         {
              addCriterion("title in ", values, "title");
              return (Criteria) this;
         }

         public Criteria andTitleNotIn(List<String> values)
         {
              addCriterion("title not in ", values, "title");
              return (Criteria) this;
         }

         public Criteria andTitleBetween(String value1, String value2)
         {
              addCriterion("title between ", value1,value2, "title");
              return (Criteria) this;
         }

         public Criteria andTitleNotBetween(String value1, String value2)
         {
              addCriterion("title not between ", value1,value2, "title");
              return (Criteria) this;
         }

         public Criteria andPreShoppingTimeIsNull()
         {
              addCriterion("pre_shopping_time is null");
              return (Criteria) this;
         }

         public Criteria andPreShoppingTimeIsNotNull()
         {
              addCriterion("pre_shopping_time is not null");
              return (Criteria) this;
         }

         public Criteria andPreShoppingTimeEqualTo(Date value)
         {
              addCriterion("pre_shopping_time = ", value, "pre_shopping_time");
              return (Criteria) this;
         }

         public Criteria andPreShoppingTimeNotEqualTo(Date value)
         {
              addCriterion("pre_shopping_time <> ", value, "pre_shopping_time");
              return (Criteria) this;
         }

         public Criteria andPreShoppingTimeGreaterThan(Date value)
         {
              addCriterion("pre_shopping_time > ", value, "pre_shopping_time");
              return (Criteria) this;
         }

         public Criteria andPreShoppingTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("pre_shopping_time >= ", value, "pre_shopping_time");
              return (Criteria) this;
         }

         public Criteria andPreShoppingTimeLessThan(Date value)
         {
              addCriterion("pre_shopping_time < ", value, "pre_shopping_time");
              return (Criteria) this;
         }

         public Criteria andPreShoppingTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("pre_shopping_time <= ", value, "pre_shopping_time");
              return (Criteria) this;
         }

         public Criteria andPreShoppingTimeIn(List<Date> values)
         {
              addCriterion("pre_shopping_time in ", values, "pre_shopping_time");
              return (Criteria) this;
         }

         public Criteria andPreShoppingTimeNotIn(List<Date> values)
         {
              addCriterion("pre_shopping_time not in ", values, "pre_shopping_time");
              return (Criteria) this;
         }

         public Criteria andPreShoppingTimeBetween(Date value1, Date value2)
         {
              addCriterion("pre_shopping_time between ", value1,value2, "pre_shopping_time");
              return (Criteria) this;
         }

         public Criteria andPreShoppingTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("pre_shopping_time not between ", value1,value2, "pre_shopping_time");
              return (Criteria) this;
         }

         public Criteria andInfoSourceIsNull()
         {
              addCriterion("info_source is null");
              return (Criteria) this;
         }

         public Criteria andInfoSourceIsNotNull()
         {
              addCriterion("info_source is not null");
              return (Criteria) this;
         }

         public Criteria andInfoSourceEqualTo(String value)
         {
              addCriterion("info_source = ", value, "info_source");
              return (Criteria) this;
         }

         public Criteria andInfoSourceNotEqualTo(String value)
         {
              addCriterion("info_source <> ", value, "info_source");
              return (Criteria) this;
         }

         public Criteria andInfoSourceGreaterThan(String value)
         {
              addCriterion("info_source > ", value, "info_source");
              return (Criteria) this;
         }

         public Criteria andInfoSourceGreaterThanOrEqualTo(String value)
         {
              addCriterion("info_source >= ", value, "info_source");
              return (Criteria) this;
         }

         public Criteria andInfoSourceLessThan(String value)
         {
              addCriterion("info_source < ", value, "info_source");
              return (Criteria) this;
         }

         public Criteria andInfoSourceLessThanOrEqualTo(String value)
         {
              addCriterion("info_source <= ", value, "info_source");
              return (Criteria) this;
         }

         public Criteria andInfoSourceLike(String value)
         {
              addCriterion("info_source like ", value, "info_source");
              return (Criteria) this;
         }

         public Criteria andInfoSourceNotLike(String value)
         {
              addCriterion("info_source not like ", value, "info_source");
              return (Criteria) this;
         }

         public Criteria andInfoSourceIn(List<String> values)
         {
              addCriterion("info_source in ", values, "info_source");
              return (Criteria) this;
         }

         public Criteria andInfoSourceNotIn(List<String> values)
         {
              addCriterion("info_source not in ", values, "info_source");
              return (Criteria) this;
         }

         public Criteria andInfoSourceBetween(String value1, String value2)
         {
              addCriterion("info_source between ", value1,value2, "info_source");
              return (Criteria) this;
         }

         public Criteria andInfoSourceNotBetween(String value1, String value2)
         {
              addCriterion("info_source not between ", value1,value2, "info_source");
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
