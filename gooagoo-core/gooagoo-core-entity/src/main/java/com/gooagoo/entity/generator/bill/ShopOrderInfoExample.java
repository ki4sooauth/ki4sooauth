package com.gooagoo.entity.generator.bill;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 商家订单原始信息。商家订单来源：转发器产生的订单文件。只有餐饮业才有商家订单。
 */

public class ShopOrderInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopOrderInfoExample()
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

         public Criteria andShopOrderIdIsNull()
         {
              addCriterion("shop_order_id is null");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdIsNotNull()
         {
              addCriterion("shop_order_id is not null");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdEqualTo(String value)
         {
              addCriterion("shop_order_id = ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdNotEqualTo(String value)
         {
              addCriterion("shop_order_id <> ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdGreaterThan(String value)
         {
              addCriterion("shop_order_id > ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_order_id >= ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdLessThan(String value)
         {
              addCriterion("shop_order_id < ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdLessThanOrEqualTo(String value)
         {
              addCriterion("shop_order_id <= ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdLike(String value)
         {
              addCriterion("shop_order_id like ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdNotLike(String value)
         {
              addCriterion("shop_order_id not like ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdIn(List<String> values)
         {
              addCriterion("shop_order_id in ", values, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdNotIn(List<String> values)
         {
              addCriterion("shop_order_id not in ", values, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdBetween(String value1, String value2)
         {
              addCriterion("shop_order_id between ", value1,value2, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdNotBetween(String value1, String value2)
         {
              addCriterion("shop_order_id not between ", value1,value2, "shop_order_id");
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

         public Criteria andMacIsNull()
         {
              addCriterion("mac is null");
              return (Criteria) this;
         }

         public Criteria andMacIsNotNull()
         {
              addCriterion("mac is not null");
              return (Criteria) this;
         }

         public Criteria andMacEqualTo(String value)
         {
              addCriterion("mac = ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacNotEqualTo(String value)
         {
              addCriterion("mac <> ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacGreaterThan(String value)
         {
              addCriterion("mac > ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacGreaterThanOrEqualTo(String value)
         {
              addCriterion("mac >= ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacLessThan(String value)
         {
              addCriterion("mac < ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacLessThanOrEqualTo(String value)
         {
              addCriterion("mac <= ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacLike(String value)
         {
              addCriterion("mac like ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacNotLike(String value)
         {
              addCriterion("mac not like ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacIn(List<String> values)
         {
              addCriterion("mac in ", values, "mac");
              return (Criteria) this;
         }

         public Criteria andMacNotIn(List<String> values)
         {
              addCriterion("mac not in ", values, "mac");
              return (Criteria) this;
         }

         public Criteria andMacBetween(String value1, String value2)
         {
              addCriterion("mac between ", value1,value2, "mac");
              return (Criteria) this;
         }

         public Criteria andMacNotBetween(String value1, String value2)
         {
              addCriterion("mac not between ", value1,value2, "mac");
              return (Criteria) this;
         }

         public Criteria andThirdOrderIdIsNull()
         {
              addCriterion("third_order_id is null");
              return (Criteria) this;
         }

         public Criteria andThirdOrderIdIsNotNull()
         {
              addCriterion("third_order_id is not null");
              return (Criteria) this;
         }

         public Criteria andThirdOrderIdEqualTo(String value)
         {
              addCriterion("third_order_id = ", value, "third_order_id");
              return (Criteria) this;
         }

         public Criteria andThirdOrderIdNotEqualTo(String value)
         {
              addCriterion("third_order_id <> ", value, "third_order_id");
              return (Criteria) this;
         }

         public Criteria andThirdOrderIdGreaterThan(String value)
         {
              addCriterion("third_order_id > ", value, "third_order_id");
              return (Criteria) this;
         }

         public Criteria andThirdOrderIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("third_order_id >= ", value, "third_order_id");
              return (Criteria) this;
         }

         public Criteria andThirdOrderIdLessThan(String value)
         {
              addCriterion("third_order_id < ", value, "third_order_id");
              return (Criteria) this;
         }

         public Criteria andThirdOrderIdLessThanOrEqualTo(String value)
         {
              addCriterion("third_order_id <= ", value, "third_order_id");
              return (Criteria) this;
         }

         public Criteria andThirdOrderIdLike(String value)
         {
              addCriterion("third_order_id like ", value, "third_order_id");
              return (Criteria) this;
         }

         public Criteria andThirdOrderIdNotLike(String value)
         {
              addCriterion("third_order_id not like ", value, "third_order_id");
              return (Criteria) this;
         }

         public Criteria andThirdOrderIdIn(List<String> values)
         {
              addCriterion("third_order_id in ", values, "third_order_id");
              return (Criteria) this;
         }

         public Criteria andThirdOrderIdNotIn(List<String> values)
         {
              addCriterion("third_order_id not in ", values, "third_order_id");
              return (Criteria) this;
         }

         public Criteria andThirdOrderIdBetween(String value1, String value2)
         {
              addCriterion("third_order_id between ", value1,value2, "third_order_id");
              return (Criteria) this;
         }

         public Criteria andThirdOrderIdNotBetween(String value1, String value2)
         {
              addCriterion("third_order_id not between ", value1,value2, "third_order_id");
              return (Criteria) this;
         }

         public Criteria andScardNoIsNull()
         {
              addCriterion("scard_no is null");
              return (Criteria) this;
         }

         public Criteria andScardNoIsNotNull()
         {
              addCriterion("scard_no is not null");
              return (Criteria) this;
         }

         public Criteria andScardNoEqualTo(String value)
         {
              addCriterion("scard_no = ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoNotEqualTo(String value)
         {
              addCriterion("scard_no <> ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoGreaterThan(String value)
         {
              addCriterion("scard_no > ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoGreaterThanOrEqualTo(String value)
         {
              addCriterion("scard_no >= ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoLessThan(String value)
         {
              addCriterion("scard_no < ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoLessThanOrEqualTo(String value)
         {
              addCriterion("scard_no <= ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoLike(String value)
         {
              addCriterion("scard_no like ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoNotLike(String value)
         {
              addCriterion("scard_no not like ", value, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoIn(List<String> values)
         {
              addCriterion("scard_no in ", values, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoNotIn(List<String> values)
         {
              addCriterion("scard_no not in ", values, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoBetween(String value1, String value2)
         {
              addCriterion("scard_no between ", value1,value2, "scard_no");
              return (Criteria) this;
         }

         public Criteria andScardNoNotBetween(String value1, String value2)
         {
              addCriterion("scard_no not between ", value1,value2, "scard_no");
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
