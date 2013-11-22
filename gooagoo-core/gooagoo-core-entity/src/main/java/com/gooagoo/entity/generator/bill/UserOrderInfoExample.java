package com.gooagoo.entity.generator.bill;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 用户订单原始信息
 */

public class UserOrderInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public UserOrderInfoExample()
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

         public Criteria andGoodsTotalNumIsNull()
         {
              addCriterion("goods_total_num is null");
              return (Criteria) this;
         }

         public Criteria andGoodsTotalNumIsNotNull()
         {
              addCriterion("goods_total_num is not null");
              return (Criteria) this;
         }

         public Criteria andGoodsTotalNumEqualTo(String value)
         {
              addCriterion("goods_total_num = ", value, "goods_total_num");
              return (Criteria) this;
         }

         public Criteria andGoodsTotalNumNotEqualTo(String value)
         {
              addCriterion("goods_total_num <> ", value, "goods_total_num");
              return (Criteria) this;
         }

         public Criteria andGoodsTotalNumGreaterThan(String value)
         {
              addCriterion("goods_total_num > ", value, "goods_total_num");
              return (Criteria) this;
         }

         public Criteria andGoodsTotalNumGreaterThanOrEqualTo(String value)
         {
              addCriterion("goods_total_num >= ", value, "goods_total_num");
              return (Criteria) this;
         }

         public Criteria andGoodsTotalNumLessThan(String value)
         {
              addCriterion("goods_total_num < ", value, "goods_total_num");
              return (Criteria) this;
         }

         public Criteria andGoodsTotalNumLessThanOrEqualTo(String value)
         {
              addCriterion("goods_total_num <= ", value, "goods_total_num");
              return (Criteria) this;
         }

         public Criteria andGoodsTotalNumLike(String value)
         {
              addCriterion("goods_total_num like ", value, "goods_total_num");
              return (Criteria) this;
         }

         public Criteria andGoodsTotalNumNotLike(String value)
         {
              addCriterion("goods_total_num not like ", value, "goods_total_num");
              return (Criteria) this;
         }

         public Criteria andGoodsTotalNumIn(List<String> values)
         {
              addCriterion("goods_total_num in ", values, "goods_total_num");
              return (Criteria) this;
         }

         public Criteria andGoodsTotalNumNotIn(List<String> values)
         {
              addCriterion("goods_total_num not in ", values, "goods_total_num");
              return (Criteria) this;
         }

         public Criteria andGoodsTotalNumBetween(String value1, String value2)
         {
              addCriterion("goods_total_num between ", value1,value2, "goods_total_num");
              return (Criteria) this;
         }

         public Criteria andGoodsTotalNumNotBetween(String value1, String value2)
         {
              addCriterion("goods_total_num not between ", value1,value2, "goods_total_num");
              return (Criteria) this;
         }

         public Criteria andOriginalPriceIsNull()
         {
              addCriterion("original_price is null");
              return (Criteria) this;
         }

         public Criteria andOriginalPriceIsNotNull()
         {
              addCriterion("original_price is not null");
              return (Criteria) this;
         }

         public Criteria andOriginalPriceEqualTo(String value)
         {
              addCriterion("original_price = ", value, "original_price");
              return (Criteria) this;
         }

         public Criteria andOriginalPriceNotEqualTo(String value)
         {
              addCriterion("original_price <> ", value, "original_price");
              return (Criteria) this;
         }

         public Criteria andOriginalPriceGreaterThan(String value)
         {
              addCriterion("original_price > ", value, "original_price");
              return (Criteria) this;
         }

         public Criteria andOriginalPriceGreaterThanOrEqualTo(String value)
         {
              addCriterion("original_price >= ", value, "original_price");
              return (Criteria) this;
         }

         public Criteria andOriginalPriceLessThan(String value)
         {
              addCriterion("original_price < ", value, "original_price");
              return (Criteria) this;
         }

         public Criteria andOriginalPriceLessThanOrEqualTo(String value)
         {
              addCriterion("original_price <= ", value, "original_price");
              return (Criteria) this;
         }

         public Criteria andOriginalPriceLike(String value)
         {
              addCriterion("original_price like ", value, "original_price");
              return (Criteria) this;
         }

         public Criteria andOriginalPriceNotLike(String value)
         {
              addCriterion("original_price not like ", value, "original_price");
              return (Criteria) this;
         }

         public Criteria andOriginalPriceIn(List<String> values)
         {
              addCriterion("original_price in ", values, "original_price");
              return (Criteria) this;
         }

         public Criteria andOriginalPriceNotIn(List<String> values)
         {
              addCriterion("original_price not in ", values, "original_price");
              return (Criteria) this;
         }

         public Criteria andOriginalPriceBetween(String value1, String value2)
         {
              addCriterion("original_price between ", value1,value2, "original_price");
              return (Criteria) this;
         }

         public Criteria andOriginalPriceNotBetween(String value1, String value2)
         {
              addCriterion("original_price not between ", value1,value2, "original_price");
              return (Criteria) this;
         }

         public Criteria andDiscountRateIsNull()
         {
              addCriterion("discount_rate is null");
              return (Criteria) this;
         }

         public Criteria andDiscountRateIsNotNull()
         {
              addCriterion("discount_rate is not null");
              return (Criteria) this;
         }

         public Criteria andDiscountRateEqualTo(String value)
         {
              addCriterion("discount_rate = ", value, "discount_rate");
              return (Criteria) this;
         }

         public Criteria andDiscountRateNotEqualTo(String value)
         {
              addCriterion("discount_rate <> ", value, "discount_rate");
              return (Criteria) this;
         }

         public Criteria andDiscountRateGreaterThan(String value)
         {
              addCriterion("discount_rate > ", value, "discount_rate");
              return (Criteria) this;
         }

         public Criteria andDiscountRateGreaterThanOrEqualTo(String value)
         {
              addCriterion("discount_rate >= ", value, "discount_rate");
              return (Criteria) this;
         }

         public Criteria andDiscountRateLessThan(String value)
         {
              addCriterion("discount_rate < ", value, "discount_rate");
              return (Criteria) this;
         }

         public Criteria andDiscountRateLessThanOrEqualTo(String value)
         {
              addCriterion("discount_rate <= ", value, "discount_rate");
              return (Criteria) this;
         }

         public Criteria andDiscountRateLike(String value)
         {
              addCriterion("discount_rate like ", value, "discount_rate");
              return (Criteria) this;
         }

         public Criteria andDiscountRateNotLike(String value)
         {
              addCriterion("discount_rate not like ", value, "discount_rate");
              return (Criteria) this;
         }

         public Criteria andDiscountRateIn(List<String> values)
         {
              addCriterion("discount_rate in ", values, "discount_rate");
              return (Criteria) this;
         }

         public Criteria andDiscountRateNotIn(List<String> values)
         {
              addCriterion("discount_rate not in ", values, "discount_rate");
              return (Criteria) this;
         }

         public Criteria andDiscountRateBetween(String value1, String value2)
         {
              addCriterion("discount_rate between ", value1,value2, "discount_rate");
              return (Criteria) this;
         }

         public Criteria andDiscountRateNotBetween(String value1, String value2)
         {
              addCriterion("discount_rate not between ", value1,value2, "discount_rate");
              return (Criteria) this;
         }

         public Criteria andPayPriceIsNull()
         {
              addCriterion("pay_price is null");
              return (Criteria) this;
         }

         public Criteria andPayPriceIsNotNull()
         {
              addCriterion("pay_price is not null");
              return (Criteria) this;
         }

         public Criteria andPayPriceEqualTo(String value)
         {
              addCriterion("pay_price = ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceNotEqualTo(String value)
         {
              addCriterion("pay_price <> ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceGreaterThan(String value)
         {
              addCriterion("pay_price > ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceGreaterThanOrEqualTo(String value)
         {
              addCriterion("pay_price >= ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceLessThan(String value)
         {
              addCriterion("pay_price < ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceLessThanOrEqualTo(String value)
         {
              addCriterion("pay_price <= ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceLike(String value)
         {
              addCriterion("pay_price like ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceNotLike(String value)
         {
              addCriterion("pay_price not like ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceIn(List<String> values)
         {
              addCriterion("pay_price in ", values, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceNotIn(List<String> values)
         {
              addCriterion("pay_price not in ", values, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceBetween(String value1, String value2)
         {
              addCriterion("pay_price between ", value1,value2, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceNotBetween(String value1, String value2)
         {
              addCriterion("pay_price not between ", value1,value2, "pay_price");
              return (Criteria) this;
         }

         public Criteria andTakeMethodIsNull()
         {
              addCriterion("take_method is null");
              return (Criteria) this;
         }

         public Criteria andTakeMethodIsNotNull()
         {
              addCriterion("take_method is not null");
              return (Criteria) this;
         }

         public Criteria andTakeMethodEqualTo(String value)
         {
              addCriterion("take_method = ", value, "take_method");
              return (Criteria) this;
         }

         public Criteria andTakeMethodNotEqualTo(String value)
         {
              addCriterion("take_method <> ", value, "take_method");
              return (Criteria) this;
         }

         public Criteria andTakeMethodGreaterThan(String value)
         {
              addCriterion("take_method > ", value, "take_method");
              return (Criteria) this;
         }

         public Criteria andTakeMethodGreaterThanOrEqualTo(String value)
         {
              addCriterion("take_method >= ", value, "take_method");
              return (Criteria) this;
         }

         public Criteria andTakeMethodLessThan(String value)
         {
              addCriterion("take_method < ", value, "take_method");
              return (Criteria) this;
         }

         public Criteria andTakeMethodLessThanOrEqualTo(String value)
         {
              addCriterion("take_method <= ", value, "take_method");
              return (Criteria) this;
         }

         public Criteria andTakeMethodLike(String value)
         {
              addCriterion("take_method like ", value, "take_method");
              return (Criteria) this;
         }

         public Criteria andTakeMethodNotLike(String value)
         {
              addCriterion("take_method not like ", value, "take_method");
              return (Criteria) this;
         }

         public Criteria andTakeMethodIn(List<String> values)
         {
              addCriterion("take_method in ", values, "take_method");
              return (Criteria) this;
         }

         public Criteria andTakeMethodNotIn(List<String> values)
         {
              addCriterion("take_method not in ", values, "take_method");
              return (Criteria) this;
         }

         public Criteria andTakeMethodBetween(String value1, String value2)
         {
              addCriterion("take_method between ", value1,value2, "take_method");
              return (Criteria) this;
         }

         public Criteria andTakeMethodNotBetween(String value1, String value2)
         {
              addCriterion("take_method not between ", value1,value2, "take_method");
              return (Criteria) this;
         }

         public Criteria andConsigneeIdIsNull()
         {
              addCriterion("consignee_id is null");
              return (Criteria) this;
         }

         public Criteria andConsigneeIdIsNotNull()
         {
              addCriterion("consignee_id is not null");
              return (Criteria) this;
         }

         public Criteria andConsigneeIdEqualTo(String value)
         {
              addCriterion("consignee_id = ", value, "consignee_id");
              return (Criteria) this;
         }

         public Criteria andConsigneeIdNotEqualTo(String value)
         {
              addCriterion("consignee_id <> ", value, "consignee_id");
              return (Criteria) this;
         }

         public Criteria andConsigneeIdGreaterThan(String value)
         {
              addCriterion("consignee_id > ", value, "consignee_id");
              return (Criteria) this;
         }

         public Criteria andConsigneeIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("consignee_id >= ", value, "consignee_id");
              return (Criteria) this;
         }

         public Criteria andConsigneeIdLessThan(String value)
         {
              addCriterion("consignee_id < ", value, "consignee_id");
              return (Criteria) this;
         }

         public Criteria andConsigneeIdLessThanOrEqualTo(String value)
         {
              addCriterion("consignee_id <= ", value, "consignee_id");
              return (Criteria) this;
         }

         public Criteria andConsigneeIdLike(String value)
         {
              addCriterion("consignee_id like ", value, "consignee_id");
              return (Criteria) this;
         }

         public Criteria andConsigneeIdNotLike(String value)
         {
              addCriterion("consignee_id not like ", value, "consignee_id");
              return (Criteria) this;
         }

         public Criteria andConsigneeIdIn(List<String> values)
         {
              addCriterion("consignee_id in ", values, "consignee_id");
              return (Criteria) this;
         }

         public Criteria andConsigneeIdNotIn(List<String> values)
         {
              addCriterion("consignee_id not in ", values, "consignee_id");
              return (Criteria) this;
         }

         public Criteria andConsigneeIdBetween(String value1, String value2)
         {
              addCriterion("consignee_id between ", value1,value2, "consignee_id");
              return (Criteria) this;
         }

         public Criteria andConsigneeIdNotBetween(String value1, String value2)
         {
              addCriterion("consignee_id not between ", value1,value2, "consignee_id");
              return (Criteria) this;
         }

         public Criteria andRoomNameIsNull()
         {
              addCriterion("room_name is null");
              return (Criteria) this;
         }

         public Criteria andRoomNameIsNotNull()
         {
              addCriterion("room_name is not null");
              return (Criteria) this;
         }

         public Criteria andRoomNameEqualTo(String value)
         {
              addCriterion("room_name = ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameNotEqualTo(String value)
         {
              addCriterion("room_name <> ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameGreaterThan(String value)
         {
              addCriterion("room_name > ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("room_name >= ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameLessThan(String value)
         {
              addCriterion("room_name < ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameLessThanOrEqualTo(String value)
         {
              addCriterion("room_name <= ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameLike(String value)
         {
              addCriterion("room_name like ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameNotLike(String value)
         {
              addCriterion("room_name not like ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameIn(List<String> values)
         {
              addCriterion("room_name in ", values, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameNotIn(List<String> values)
         {
              addCriterion("room_name not in ", values, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameBetween(String value1, String value2)
         {
              addCriterion("room_name between ", value1,value2, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameNotBetween(String value1, String value2)
         {
              addCriterion("room_name not between ", value1,value2, "room_name");
              return (Criteria) this;
         }

         public Criteria andDeskNameIsNull()
         {
              addCriterion("desk_name is null");
              return (Criteria) this;
         }

         public Criteria andDeskNameIsNotNull()
         {
              addCriterion("desk_name is not null");
              return (Criteria) this;
         }

         public Criteria andDeskNameEqualTo(String value)
         {
              addCriterion("desk_name = ", value, "desk_name");
              return (Criteria) this;
         }

         public Criteria andDeskNameNotEqualTo(String value)
         {
              addCriterion("desk_name <> ", value, "desk_name");
              return (Criteria) this;
         }

         public Criteria andDeskNameGreaterThan(String value)
         {
              addCriterion("desk_name > ", value, "desk_name");
              return (Criteria) this;
         }

         public Criteria andDeskNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("desk_name >= ", value, "desk_name");
              return (Criteria) this;
         }

         public Criteria andDeskNameLessThan(String value)
         {
              addCriterion("desk_name < ", value, "desk_name");
              return (Criteria) this;
         }

         public Criteria andDeskNameLessThanOrEqualTo(String value)
         {
              addCriterion("desk_name <= ", value, "desk_name");
              return (Criteria) this;
         }

         public Criteria andDeskNameLike(String value)
         {
              addCriterion("desk_name like ", value, "desk_name");
              return (Criteria) this;
         }

         public Criteria andDeskNameNotLike(String value)
         {
              addCriterion("desk_name not like ", value, "desk_name");
              return (Criteria) this;
         }

         public Criteria andDeskNameIn(List<String> values)
         {
              addCriterion("desk_name in ", values, "desk_name");
              return (Criteria) this;
         }

         public Criteria andDeskNameNotIn(List<String> values)
         {
              addCriterion("desk_name not in ", values, "desk_name");
              return (Criteria) this;
         }

         public Criteria andDeskNameBetween(String value1, String value2)
         {
              addCriterion("desk_name between ", value1,value2, "desk_name");
              return (Criteria) this;
         }

         public Criteria andDeskNameNotBetween(String value1, String value2)
         {
              addCriterion("desk_name not between ", value1,value2, "desk_name");
              return (Criteria) this;
         }

         public Criteria andIsSaCommitIsNull()
         {
              addCriterion("is_sa_commit is null");
              return (Criteria) this;
         }

         public Criteria andIsSaCommitIsNotNull()
         {
              addCriterion("is_sa_commit is not null");
              return (Criteria) this;
         }

         public Criteria andIsSaCommitEqualTo(String value)
         {
              addCriterion("is_sa_commit = ", value, "is_sa_commit");
              return (Criteria) this;
         }

         public Criteria andIsSaCommitNotEqualTo(String value)
         {
              addCriterion("is_sa_commit <> ", value, "is_sa_commit");
              return (Criteria) this;
         }

         public Criteria andIsSaCommitGreaterThan(String value)
         {
              addCriterion("is_sa_commit > ", value, "is_sa_commit");
              return (Criteria) this;
         }

         public Criteria andIsSaCommitGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_sa_commit >= ", value, "is_sa_commit");
              return (Criteria) this;
         }

         public Criteria andIsSaCommitLessThan(String value)
         {
              addCriterion("is_sa_commit < ", value, "is_sa_commit");
              return (Criteria) this;
         }

         public Criteria andIsSaCommitLessThanOrEqualTo(String value)
         {
              addCriterion("is_sa_commit <= ", value, "is_sa_commit");
              return (Criteria) this;
         }

         public Criteria andIsSaCommitLike(String value)
         {
              addCriterion("is_sa_commit like ", value, "is_sa_commit");
              return (Criteria) this;
         }

         public Criteria andIsSaCommitNotLike(String value)
         {
              addCriterion("is_sa_commit not like ", value, "is_sa_commit");
              return (Criteria) this;
         }

         public Criteria andIsSaCommitIn(List<String> values)
         {
              addCriterion("is_sa_commit in ", values, "is_sa_commit");
              return (Criteria) this;
         }

         public Criteria andIsSaCommitNotIn(List<String> values)
         {
              addCriterion("is_sa_commit not in ", values, "is_sa_commit");
              return (Criteria) this;
         }

         public Criteria andIsSaCommitBetween(String value1, String value2)
         {
              addCriterion("is_sa_commit between ", value1,value2, "is_sa_commit");
              return (Criteria) this;
         }

         public Criteria andIsSaCommitNotBetween(String value1, String value2)
         {
              addCriterion("is_sa_commit not between ", value1,value2, "is_sa_commit");
              return (Criteria) this;
         }

         public Criteria andAccountIsNull()
         {
              addCriterion("account is null");
              return (Criteria) this;
         }

         public Criteria andAccountIsNotNull()
         {
              addCriterion("account is not null");
              return (Criteria) this;
         }

         public Criteria andAccountEqualTo(String value)
         {
              addCriterion("account = ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountNotEqualTo(String value)
         {
              addCriterion("account <> ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountGreaterThan(String value)
         {
              addCriterion("account > ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountGreaterThanOrEqualTo(String value)
         {
              addCriterion("account >= ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountLessThan(String value)
         {
              addCriterion("account < ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountLessThanOrEqualTo(String value)
         {
              addCriterion("account <= ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountLike(String value)
         {
              addCriterion("account like ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountNotLike(String value)
         {
              addCriterion("account not like ", value, "account");
              return (Criteria) this;
         }

         public Criteria andAccountIn(List<String> values)
         {
              addCriterion("account in ", values, "account");
              return (Criteria) this;
         }

         public Criteria andAccountNotIn(List<String> values)
         {
              addCriterion("account not in ", values, "account");
              return (Criteria) this;
         }

         public Criteria andAccountBetween(String value1, String value2)
         {
              addCriterion("account between ", value1,value2, "account");
              return (Criteria) this;
         }

         public Criteria andAccountNotBetween(String value1, String value2)
         {
              addCriterion("account not between ", value1,value2, "account");
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
