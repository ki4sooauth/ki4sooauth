package com.gooagoo.entity.generator.bill;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 订单优惠凭证详情，包括三种途径提交的优惠凭证：提交用户订单时、提交结账申请时、单独提出优惠凭证申请
 */

public class OrderCouponInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public OrderCouponInfoExample()
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

         public Criteria andOrderDetailIdIsNull()
         {
              addCriterion("order_detail_id is null");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdIsNotNull()
         {
              addCriterion("order_detail_id is not null");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdEqualTo(String value)
         {
              addCriterion("order_detail_id = ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdNotEqualTo(String value)
         {
              addCriterion("order_detail_id <> ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdGreaterThan(String value)
         {
              addCriterion("order_detail_id > ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("order_detail_id >= ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdLessThan(String value)
         {
              addCriterion("order_detail_id < ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdLessThanOrEqualTo(String value)
         {
              addCriterion("order_detail_id <= ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdLike(String value)
         {
              addCriterion("order_detail_id like ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdNotLike(String value)
         {
              addCriterion("order_detail_id not like ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdIn(List<String> values)
         {
              addCriterion("order_detail_id in ", values, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdNotIn(List<String> values)
         {
              addCriterion("order_detail_id not in ", values, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdBetween(String value1, String value2)
         {
              addCriterion("order_detail_id between ", value1,value2, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdNotBetween(String value1, String value2)
         {
              addCriterion("order_detail_id not between ", value1,value2, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdIsNull()
         {
              addCriterion("order_id is null");
              return (Criteria) this;
         }

         public Criteria andOrderIdIsNotNull()
         {
              addCriterion("order_id is not null");
              return (Criteria) this;
         }

         public Criteria andOrderIdEqualTo(String value)
         {
              addCriterion("order_id = ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdNotEqualTo(String value)
         {
              addCriterion("order_id <> ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdGreaterThan(String value)
         {
              addCriterion("order_id > ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("order_id >= ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdLessThan(String value)
         {
              addCriterion("order_id < ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdLessThanOrEqualTo(String value)
         {
              addCriterion("order_id <= ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdLike(String value)
         {
              addCriterion("order_id like ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdNotLike(String value)
         {
              addCriterion("order_id not like ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdIn(List<String> values)
         {
              addCriterion("order_id in ", values, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdNotIn(List<String> values)
         {
              addCriterion("order_id not in ", values, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdBetween(String value1, String value2)
         {
              addCriterion("order_id between ", value1,value2, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdNotBetween(String value1, String value2)
         {
              addCriterion("order_id not between ", value1,value2, "order_id");
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

         public Criteria andStatusIsNull()
         {
              addCriterion("status is null");
              return (Criteria) this;
         }

         public Criteria andStatusIsNotNull()
         {
              addCriterion("status is not null");
              return (Criteria) this;
         }

         public Criteria andStatusEqualTo(String value)
         {
              addCriterion("status = ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusNotEqualTo(String value)
         {
              addCriterion("status <> ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusGreaterThan(String value)
         {
              addCriterion("status > ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusGreaterThanOrEqualTo(String value)
         {
              addCriterion("status >= ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusLessThan(String value)
         {
              addCriterion("status < ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusLessThanOrEqualTo(String value)
         {
              addCriterion("status <= ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusLike(String value)
         {
              addCriterion("status like ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusNotLike(String value)
         {
              addCriterion("status not like ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusIn(List<String> values)
         {
              addCriterion("status in ", values, "status");
              return (Criteria) this;
         }

         public Criteria andStatusNotIn(List<String> values)
         {
              addCriterion("status not in ", values, "status");
              return (Criteria) this;
         }

         public Criteria andStatusBetween(String value1, String value2)
         {
              addCriterion("status between ", value1,value2, "status");
              return (Criteria) this;
         }

         public Criteria andStatusNotBetween(String value1, String value2)
         {
              addCriterion("status not between ", value1,value2, "status");
              return (Criteria) this;
         }

         public Criteria andIsDealIsNull()
         {
              addCriterion("is_deal is null");
              return (Criteria) this;
         }

         public Criteria andIsDealIsNotNull()
         {
              addCriterion("is_deal is not null");
              return (Criteria) this;
         }

         public Criteria andIsDealEqualTo(String value)
         {
              addCriterion("is_deal = ", value, "is_deal");
              return (Criteria) this;
         }

         public Criteria andIsDealNotEqualTo(String value)
         {
              addCriterion("is_deal <> ", value, "is_deal");
              return (Criteria) this;
         }

         public Criteria andIsDealGreaterThan(String value)
         {
              addCriterion("is_deal > ", value, "is_deal");
              return (Criteria) this;
         }

         public Criteria andIsDealGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_deal >= ", value, "is_deal");
              return (Criteria) this;
         }

         public Criteria andIsDealLessThan(String value)
         {
              addCriterion("is_deal < ", value, "is_deal");
              return (Criteria) this;
         }

         public Criteria andIsDealLessThanOrEqualTo(String value)
         {
              addCriterion("is_deal <= ", value, "is_deal");
              return (Criteria) this;
         }

         public Criteria andIsDealLike(String value)
         {
              addCriterion("is_deal like ", value, "is_deal");
              return (Criteria) this;
         }

         public Criteria andIsDealNotLike(String value)
         {
              addCriterion("is_deal not like ", value, "is_deal");
              return (Criteria) this;
         }

         public Criteria andIsDealIn(List<String> values)
         {
              addCriterion("is_deal in ", values, "is_deal");
              return (Criteria) this;
         }

         public Criteria andIsDealNotIn(List<String> values)
         {
              addCriterion("is_deal not in ", values, "is_deal");
              return (Criteria) this;
         }

         public Criteria andIsDealBetween(String value1, String value2)
         {
              addCriterion("is_deal between ", value1,value2, "is_deal");
              return (Criteria) this;
         }

         public Criteria andIsDealNotBetween(String value1, String value2)
         {
              addCriterion("is_deal not between ", value1,value2, "is_deal");
              return (Criteria) this;
         }

         public Criteria andDealTimeIsNull()
         {
              addCriterion("deal_time is null");
              return (Criteria) this;
         }

         public Criteria andDealTimeIsNotNull()
         {
              addCriterion("deal_time is not null");
              return (Criteria) this;
         }

         public Criteria andDealTimeEqualTo(Date value)
         {
              addCriterion("deal_time = ", value, "deal_time");
              return (Criteria) this;
         }

         public Criteria andDealTimeNotEqualTo(Date value)
         {
              addCriterion("deal_time <> ", value, "deal_time");
              return (Criteria) this;
         }

         public Criteria andDealTimeGreaterThan(Date value)
         {
              addCriterion("deal_time > ", value, "deal_time");
              return (Criteria) this;
         }

         public Criteria andDealTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("deal_time >= ", value, "deal_time");
              return (Criteria) this;
         }

         public Criteria andDealTimeLessThan(Date value)
         {
              addCriterion("deal_time < ", value, "deal_time");
              return (Criteria) this;
         }

         public Criteria andDealTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("deal_time <= ", value, "deal_time");
              return (Criteria) this;
         }

         public Criteria andDealTimeIn(List<Date> values)
         {
              addCriterion("deal_time in ", values, "deal_time");
              return (Criteria) this;
         }

         public Criteria andDealTimeNotIn(List<Date> values)
         {
              addCriterion("deal_time not in ", values, "deal_time");
              return (Criteria) this;
         }

         public Criteria andDealTimeBetween(Date value1, Date value2)
         {
              addCriterion("deal_time between ", value1,value2, "deal_time");
              return (Criteria) this;
         }

         public Criteria andDealTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("deal_time not between ", value1,value2, "deal_time");
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
