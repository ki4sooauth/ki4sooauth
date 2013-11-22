package com.gooagoo.entity.generator.bill;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * 用户订单原始信息优惠凭证详情
 */

public class UserOrderCouponExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public UserOrderCouponExample()
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

         public Criteria andUserOrderDetailIdIsNull()
         {
              addCriterion("user_order_detail_id is null");
              return (Criteria) this;
         }

         public Criteria andUserOrderDetailIdIsNotNull()
         {
              addCriterion("user_order_detail_id is not null");
              return (Criteria) this;
         }

         public Criteria andUserOrderDetailIdEqualTo(String value)
         {
              addCriterion("user_order_detail_id = ", value, "user_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderDetailIdNotEqualTo(String value)
         {
              addCriterion("user_order_detail_id <> ", value, "user_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderDetailIdGreaterThan(String value)
         {
              addCriterion("user_order_detail_id > ", value, "user_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderDetailIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("user_order_detail_id >= ", value, "user_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderDetailIdLessThan(String value)
         {
              addCriterion("user_order_detail_id < ", value, "user_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderDetailIdLessThanOrEqualTo(String value)
         {
              addCriterion("user_order_detail_id <= ", value, "user_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderDetailIdLike(String value)
         {
              addCriterion("user_order_detail_id like ", value, "user_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderDetailIdNotLike(String value)
         {
              addCriterion("user_order_detail_id not like ", value, "user_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderDetailIdIn(List<String> values)
         {
              addCriterion("user_order_detail_id in ", values, "user_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderDetailIdNotIn(List<String> values)
         {
              addCriterion("user_order_detail_id not in ", values, "user_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderDetailIdBetween(String value1, String value2)
         {
              addCriterion("user_order_detail_id between ", value1,value2, "user_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderDetailIdNotBetween(String value1, String value2)
         {
              addCriterion("user_order_detail_id not between ", value1,value2, "user_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderIdIsNull()
         {
              addCriterion("user_order_id is null");
              return (Criteria) this;
         }

         public Criteria andUserOrderIdIsNotNull()
         {
              addCriterion("user_order_id is not null");
              return (Criteria) this;
         }

         public Criteria andUserOrderIdEqualTo(String value)
         {
              addCriterion("user_order_id = ", value, "user_order_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderIdNotEqualTo(String value)
         {
              addCriterion("user_order_id <> ", value, "user_order_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderIdGreaterThan(String value)
         {
              addCriterion("user_order_id > ", value, "user_order_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("user_order_id >= ", value, "user_order_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderIdLessThan(String value)
         {
              addCriterion("user_order_id < ", value, "user_order_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderIdLessThanOrEqualTo(String value)
         {
              addCriterion("user_order_id <= ", value, "user_order_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderIdLike(String value)
         {
              addCriterion("user_order_id like ", value, "user_order_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderIdNotLike(String value)
         {
              addCriterion("user_order_id not like ", value, "user_order_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderIdIn(List<String> values)
         {
              addCriterion("user_order_id in ", values, "user_order_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderIdNotIn(List<String> values)
         {
              addCriterion("user_order_id not in ", values, "user_order_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderIdBetween(String value1, String value2)
         {
              addCriterion("user_order_id between ", value1,value2, "user_order_id");
              return (Criteria) this;
         }

         public Criteria andUserOrderIdNotBetween(String value1, String value2)
         {
              addCriterion("user_order_id not between ", value1,value2, "user_order_id");
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

         public Criteria andShopEntityIdIsNull()
         {
              addCriterion("shop_entity_id is null");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdIsNotNull()
         {
              addCriterion("shop_entity_id is not null");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdEqualTo(String value)
         {
              addCriterion("shop_entity_id = ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdNotEqualTo(String value)
         {
              addCriterion("shop_entity_id <> ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdGreaterThan(String value)
         {
              addCriterion("shop_entity_id > ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_entity_id >= ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdLessThan(String value)
         {
              addCriterion("shop_entity_id < ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdLessThanOrEqualTo(String value)
         {
              addCriterion("shop_entity_id <= ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdLike(String value)
         {
              addCriterion("shop_entity_id like ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdNotLike(String value)
         {
              addCriterion("shop_entity_id not like ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdIn(List<String> values)
         {
              addCriterion("shop_entity_id in ", values, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdNotIn(List<String> values)
         {
              addCriterion("shop_entity_id not in ", values, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdBetween(String value1, String value2)
         {
              addCriterion("shop_entity_id between ", value1,value2, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdNotBetween(String value1, String value2)
         {
              addCriterion("shop_entity_id not between ", value1,value2, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andCouponUserIdIsNull()
         {
              addCriterion("coupon_user_id is null");
              return (Criteria) this;
         }

         public Criteria andCouponUserIdIsNotNull()
         {
              addCriterion("coupon_user_id is not null");
              return (Criteria) this;
         }

         public Criteria andCouponUserIdEqualTo(String value)
         {
              addCriterion("coupon_user_id = ", value, "coupon_user_id");
              return (Criteria) this;
         }

         public Criteria andCouponUserIdNotEqualTo(String value)
         {
              addCriterion("coupon_user_id <> ", value, "coupon_user_id");
              return (Criteria) this;
         }

         public Criteria andCouponUserIdGreaterThan(String value)
         {
              addCriterion("coupon_user_id > ", value, "coupon_user_id");
              return (Criteria) this;
         }

         public Criteria andCouponUserIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("coupon_user_id >= ", value, "coupon_user_id");
              return (Criteria) this;
         }

         public Criteria andCouponUserIdLessThan(String value)
         {
              addCriterion("coupon_user_id < ", value, "coupon_user_id");
              return (Criteria) this;
         }

         public Criteria andCouponUserIdLessThanOrEqualTo(String value)
         {
              addCriterion("coupon_user_id <= ", value, "coupon_user_id");
              return (Criteria) this;
         }

         public Criteria andCouponUserIdLike(String value)
         {
              addCriterion("coupon_user_id like ", value, "coupon_user_id");
              return (Criteria) this;
         }

         public Criteria andCouponUserIdNotLike(String value)
         {
              addCriterion("coupon_user_id not like ", value, "coupon_user_id");
              return (Criteria) this;
         }

         public Criteria andCouponUserIdIn(List<String> values)
         {
              addCriterion("coupon_user_id in ", values, "coupon_user_id");
              return (Criteria) this;
         }

         public Criteria andCouponUserIdNotIn(List<String> values)
         {
              addCriterion("coupon_user_id not in ", values, "coupon_user_id");
              return (Criteria) this;
         }

         public Criteria andCouponUserIdBetween(String value1, String value2)
         {
              addCriterion("coupon_user_id between ", value1,value2, "coupon_user_id");
              return (Criteria) this;
         }

         public Criteria andCouponUserIdNotBetween(String value1, String value2)
         {
              addCriterion("coupon_user_id not between ", value1,value2, "coupon_user_id");
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

         public Criteria andCouponSourceIsNull()
         {
              addCriterion("coupon_source is null");
              return (Criteria) this;
         }

         public Criteria andCouponSourceIsNotNull()
         {
              addCriterion("coupon_source is not null");
              return (Criteria) this;
         }

         public Criteria andCouponSourceEqualTo(String value)
         {
              addCriterion("coupon_source = ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceNotEqualTo(String value)
         {
              addCriterion("coupon_source <> ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceGreaterThan(String value)
         {
              addCriterion("coupon_source > ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceGreaterThanOrEqualTo(String value)
         {
              addCriterion("coupon_source >= ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceLessThan(String value)
         {
              addCriterion("coupon_source < ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceLessThanOrEqualTo(String value)
         {
              addCriterion("coupon_source <= ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceLike(String value)
         {
              addCriterion("coupon_source like ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceNotLike(String value)
         {
              addCriterion("coupon_source not like ", value, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceIn(List<String> values)
         {
              addCriterion("coupon_source in ", values, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceNotIn(List<String> values)
         {
              addCriterion("coupon_source not in ", values, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceBetween(String value1, String value2)
         {
              addCriterion("coupon_source between ", value1,value2, "coupon_source");
              return (Criteria) this;
         }

         public Criteria andCouponSourceNotBetween(String value1, String value2)
         {
              addCriterion("coupon_source not between ", value1,value2, "coupon_source");
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
