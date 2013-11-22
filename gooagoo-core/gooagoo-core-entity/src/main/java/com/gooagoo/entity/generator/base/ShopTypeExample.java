package com.gooagoo.entity.generator.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 商家类型字典表
 */

public class ShopTypeExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopTypeExample()
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

         public Criteria andShopTypeIdIsNull()
         {
              addCriterion("shop_type_id is null");
              return (Criteria) this;
         }

         public Criteria andShopTypeIdIsNotNull()
         {
              addCriterion("shop_type_id is not null");
              return (Criteria) this;
         }

         public Criteria andShopTypeIdEqualTo(String value)
         {
              addCriterion("shop_type_id = ", value, "shop_type_id");
              return (Criteria) this;
         }

         public Criteria andShopTypeIdNotEqualTo(String value)
         {
              addCriterion("shop_type_id <> ", value, "shop_type_id");
              return (Criteria) this;
         }

         public Criteria andShopTypeIdGreaterThan(String value)
         {
              addCriterion("shop_type_id > ", value, "shop_type_id");
              return (Criteria) this;
         }

         public Criteria andShopTypeIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_type_id >= ", value, "shop_type_id");
              return (Criteria) this;
         }

         public Criteria andShopTypeIdLessThan(String value)
         {
              addCriterion("shop_type_id < ", value, "shop_type_id");
              return (Criteria) this;
         }

         public Criteria andShopTypeIdLessThanOrEqualTo(String value)
         {
              addCriterion("shop_type_id <= ", value, "shop_type_id");
              return (Criteria) this;
         }

         public Criteria andShopTypeIdLike(String value)
         {
              addCriterion("shop_type_id like ", value, "shop_type_id");
              return (Criteria) this;
         }

         public Criteria andShopTypeIdNotLike(String value)
         {
              addCriterion("shop_type_id not like ", value, "shop_type_id");
              return (Criteria) this;
         }

         public Criteria andShopTypeIdIn(List<String> values)
         {
              addCriterion("shop_type_id in ", values, "shop_type_id");
              return (Criteria) this;
         }

         public Criteria andShopTypeIdNotIn(List<String> values)
         {
              addCriterion("shop_type_id not in ", values, "shop_type_id");
              return (Criteria) this;
         }

         public Criteria andShopTypeIdBetween(String value1, String value2)
         {
              addCriterion("shop_type_id between ", value1,value2, "shop_type_id");
              return (Criteria) this;
         }

         public Criteria andShopTypeIdNotBetween(String value1, String value2)
         {
              addCriterion("shop_type_id not between ", value1,value2, "shop_type_id");
              return (Criteria) this;
         }

         public Criteria andShopTypeNameIsNull()
         {
              addCriterion("shop_type_name is null");
              return (Criteria) this;
         }

         public Criteria andShopTypeNameIsNotNull()
         {
              addCriterion("shop_type_name is not null");
              return (Criteria) this;
         }

         public Criteria andShopTypeNameEqualTo(String value)
         {
              addCriterion("shop_type_name = ", value, "shop_type_name");
              return (Criteria) this;
         }

         public Criteria andShopTypeNameNotEqualTo(String value)
         {
              addCriterion("shop_type_name <> ", value, "shop_type_name");
              return (Criteria) this;
         }

         public Criteria andShopTypeNameGreaterThan(String value)
         {
              addCriterion("shop_type_name > ", value, "shop_type_name");
              return (Criteria) this;
         }

         public Criteria andShopTypeNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_type_name >= ", value, "shop_type_name");
              return (Criteria) this;
         }

         public Criteria andShopTypeNameLessThan(String value)
         {
              addCriterion("shop_type_name < ", value, "shop_type_name");
              return (Criteria) this;
         }

         public Criteria andShopTypeNameLessThanOrEqualTo(String value)
         {
              addCriterion("shop_type_name <= ", value, "shop_type_name");
              return (Criteria) this;
         }

         public Criteria andShopTypeNameLike(String value)
         {
              addCriterion("shop_type_name like ", value, "shop_type_name");
              return (Criteria) this;
         }

         public Criteria andShopTypeNameNotLike(String value)
         {
              addCriterion("shop_type_name not like ", value, "shop_type_name");
              return (Criteria) this;
         }

         public Criteria andShopTypeNameIn(List<String> values)
         {
              addCriterion("shop_type_name in ", values, "shop_type_name");
              return (Criteria) this;
         }

         public Criteria andShopTypeNameNotIn(List<String> values)
         {
              addCriterion("shop_type_name not in ", values, "shop_type_name");
              return (Criteria) this;
         }

         public Criteria andShopTypeNameBetween(String value1, String value2)
         {
              addCriterion("shop_type_name between ", value1,value2, "shop_type_name");
              return (Criteria) this;
         }

         public Criteria andShopTypeNameNotBetween(String value1, String value2)
         {
              addCriterion("shop_type_name not between ", value1,value2, "shop_type_name");
              return (Criteria) this;
         }

         public Criteria andParentShopTypeIdIsNull()
         {
              addCriterion("parent_shop_type_id is null");
              return (Criteria) this;
         }

         public Criteria andParentShopTypeIdIsNotNull()
         {
              addCriterion("parent_shop_type_id is not null");
              return (Criteria) this;
         }

         public Criteria andParentShopTypeIdEqualTo(String value)
         {
              addCriterion("parent_shop_type_id = ", value, "parent_shop_type_id");
              return (Criteria) this;
         }

         public Criteria andParentShopTypeIdNotEqualTo(String value)
         {
              addCriterion("parent_shop_type_id <> ", value, "parent_shop_type_id");
              return (Criteria) this;
         }

         public Criteria andParentShopTypeIdGreaterThan(String value)
         {
              addCriterion("parent_shop_type_id > ", value, "parent_shop_type_id");
              return (Criteria) this;
         }

         public Criteria andParentShopTypeIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("parent_shop_type_id >= ", value, "parent_shop_type_id");
              return (Criteria) this;
         }

         public Criteria andParentShopTypeIdLessThan(String value)
         {
              addCriterion("parent_shop_type_id < ", value, "parent_shop_type_id");
              return (Criteria) this;
         }

         public Criteria andParentShopTypeIdLessThanOrEqualTo(String value)
         {
              addCriterion("parent_shop_type_id <= ", value, "parent_shop_type_id");
              return (Criteria) this;
         }

         public Criteria andParentShopTypeIdLike(String value)
         {
              addCriterion("parent_shop_type_id like ", value, "parent_shop_type_id");
              return (Criteria) this;
         }

         public Criteria andParentShopTypeIdNotLike(String value)
         {
              addCriterion("parent_shop_type_id not like ", value, "parent_shop_type_id");
              return (Criteria) this;
         }

         public Criteria andParentShopTypeIdIn(List<String> values)
         {
              addCriterion("parent_shop_type_id in ", values, "parent_shop_type_id");
              return (Criteria) this;
         }

         public Criteria andParentShopTypeIdNotIn(List<String> values)
         {
              addCriterion("parent_shop_type_id not in ", values, "parent_shop_type_id");
              return (Criteria) this;
         }

         public Criteria andParentShopTypeIdBetween(String value1, String value2)
         {
              addCriterion("parent_shop_type_id between ", value1,value2, "parent_shop_type_id");
              return (Criteria) this;
         }

         public Criteria andParentShopTypeIdNotBetween(String value1, String value2)
         {
              addCriterion("parent_shop_type_id not between ", value1,value2, "parent_shop_type_id");
              return (Criteria) this;
         }

         public Criteria andFrontPicIsNull()
         {
              addCriterion("front_pic is null");
              return (Criteria) this;
         }

         public Criteria andFrontPicIsNotNull()
         {
              addCriterion("front_pic is not null");
              return (Criteria) this;
         }

         public Criteria andFrontPicEqualTo(String value)
         {
              addCriterion("front_pic = ", value, "front_pic");
              return (Criteria) this;
         }

         public Criteria andFrontPicNotEqualTo(String value)
         {
              addCriterion("front_pic <> ", value, "front_pic");
              return (Criteria) this;
         }

         public Criteria andFrontPicGreaterThan(String value)
         {
              addCriterion("front_pic > ", value, "front_pic");
              return (Criteria) this;
         }

         public Criteria andFrontPicGreaterThanOrEqualTo(String value)
         {
              addCriterion("front_pic >= ", value, "front_pic");
              return (Criteria) this;
         }

         public Criteria andFrontPicLessThan(String value)
         {
              addCriterion("front_pic < ", value, "front_pic");
              return (Criteria) this;
         }

         public Criteria andFrontPicLessThanOrEqualTo(String value)
         {
              addCriterion("front_pic <= ", value, "front_pic");
              return (Criteria) this;
         }

         public Criteria andFrontPicLike(String value)
         {
              addCriterion("front_pic like ", value, "front_pic");
              return (Criteria) this;
         }

         public Criteria andFrontPicNotLike(String value)
         {
              addCriterion("front_pic not like ", value, "front_pic");
              return (Criteria) this;
         }

         public Criteria andFrontPicIn(List<String> values)
         {
              addCriterion("front_pic in ", values, "front_pic");
              return (Criteria) this;
         }

         public Criteria andFrontPicNotIn(List<String> values)
         {
              addCriterion("front_pic not in ", values, "front_pic");
              return (Criteria) this;
         }

         public Criteria andFrontPicBetween(String value1, String value2)
         {
              addCriterion("front_pic between ", value1,value2, "front_pic");
              return (Criteria) this;
         }

         public Criteria andFrontPicNotBetween(String value1, String value2)
         {
              addCriterion("front_pic not between ", value1,value2, "front_pic");
              return (Criteria) this;
         }

         public Criteria andBackPicIsNull()
         {
              addCriterion("back_pic is null");
              return (Criteria) this;
         }

         public Criteria andBackPicIsNotNull()
         {
              addCriterion("back_pic is not null");
              return (Criteria) this;
         }

         public Criteria andBackPicEqualTo(String value)
         {
              addCriterion("back_pic = ", value, "back_pic");
              return (Criteria) this;
         }

         public Criteria andBackPicNotEqualTo(String value)
         {
              addCriterion("back_pic <> ", value, "back_pic");
              return (Criteria) this;
         }

         public Criteria andBackPicGreaterThan(String value)
         {
              addCriterion("back_pic > ", value, "back_pic");
              return (Criteria) this;
         }

         public Criteria andBackPicGreaterThanOrEqualTo(String value)
         {
              addCriterion("back_pic >= ", value, "back_pic");
              return (Criteria) this;
         }

         public Criteria andBackPicLessThan(String value)
         {
              addCriterion("back_pic < ", value, "back_pic");
              return (Criteria) this;
         }

         public Criteria andBackPicLessThanOrEqualTo(String value)
         {
              addCriterion("back_pic <= ", value, "back_pic");
              return (Criteria) this;
         }

         public Criteria andBackPicLike(String value)
         {
              addCriterion("back_pic like ", value, "back_pic");
              return (Criteria) this;
         }

         public Criteria andBackPicNotLike(String value)
         {
              addCriterion("back_pic not like ", value, "back_pic");
              return (Criteria) this;
         }

         public Criteria andBackPicIn(List<String> values)
         {
              addCriterion("back_pic in ", values, "back_pic");
              return (Criteria) this;
         }

         public Criteria andBackPicNotIn(List<String> values)
         {
              addCriterion("back_pic not in ", values, "back_pic");
              return (Criteria) this;
         }

         public Criteria andBackPicBetween(String value1, String value2)
         {
              addCriterion("back_pic between ", value1,value2, "back_pic");
              return (Criteria) this;
         }

         public Criteria andBackPicNotBetween(String value1, String value2)
         {
              addCriterion("back_pic not between ", value1,value2, "back_pic");
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
