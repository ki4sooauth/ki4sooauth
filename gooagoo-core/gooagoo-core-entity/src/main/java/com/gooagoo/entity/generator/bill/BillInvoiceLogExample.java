package com.gooagoo.entity.generator.bill;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 开发票申请信息
 */

public class BillInvoiceLogExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public BillInvoiceLogExample()
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

         public Criteria andInvoicedTypeIsNull()
         {
              addCriterion("invoiced_type is null");
              return (Criteria) this;
         }

         public Criteria andInvoicedTypeIsNotNull()
         {
              addCriterion("invoiced_type is not null");
              return (Criteria) this;
         }

         public Criteria andInvoicedTypeEqualTo(String value)
         {
              addCriterion("invoiced_type = ", value, "invoiced_type");
              return (Criteria) this;
         }

         public Criteria andInvoicedTypeNotEqualTo(String value)
         {
              addCriterion("invoiced_type <> ", value, "invoiced_type");
              return (Criteria) this;
         }

         public Criteria andInvoicedTypeGreaterThan(String value)
         {
              addCriterion("invoiced_type > ", value, "invoiced_type");
              return (Criteria) this;
         }

         public Criteria andInvoicedTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("invoiced_type >= ", value, "invoiced_type");
              return (Criteria) this;
         }

         public Criteria andInvoicedTypeLessThan(String value)
         {
              addCriterion("invoiced_type < ", value, "invoiced_type");
              return (Criteria) this;
         }

         public Criteria andInvoicedTypeLessThanOrEqualTo(String value)
         {
              addCriterion("invoiced_type <= ", value, "invoiced_type");
              return (Criteria) this;
         }

         public Criteria andInvoicedTypeLike(String value)
         {
              addCriterion("invoiced_type like ", value, "invoiced_type");
              return (Criteria) this;
         }

         public Criteria andInvoicedTypeNotLike(String value)
         {
              addCriterion("invoiced_type not like ", value, "invoiced_type");
              return (Criteria) this;
         }

         public Criteria andInvoicedTypeIn(List<String> values)
         {
              addCriterion("invoiced_type in ", values, "invoiced_type");
              return (Criteria) this;
         }

         public Criteria andInvoicedTypeNotIn(List<String> values)
         {
              addCriterion("invoiced_type not in ", values, "invoiced_type");
              return (Criteria) this;
         }

         public Criteria andInvoicedTypeBetween(String value1, String value2)
         {
              addCriterion("invoiced_type between ", value1,value2, "invoiced_type");
              return (Criteria) this;
         }

         public Criteria andInvoicedTypeNotBetween(String value1, String value2)
         {
              addCriterion("invoiced_type not between ", value1,value2, "invoiced_type");
              return (Criteria) this;
         }

         public Criteria andInvoicedTileIsNull()
         {
              addCriterion("invoiced_tile is null");
              return (Criteria) this;
         }

         public Criteria andInvoicedTileIsNotNull()
         {
              addCriterion("invoiced_tile is not null");
              return (Criteria) this;
         }

         public Criteria andInvoicedTileEqualTo(String value)
         {
              addCriterion("invoiced_tile = ", value, "invoiced_tile");
              return (Criteria) this;
         }

         public Criteria andInvoicedTileNotEqualTo(String value)
         {
              addCriterion("invoiced_tile <> ", value, "invoiced_tile");
              return (Criteria) this;
         }

         public Criteria andInvoicedTileGreaterThan(String value)
         {
              addCriterion("invoiced_tile > ", value, "invoiced_tile");
              return (Criteria) this;
         }

         public Criteria andInvoicedTileGreaterThanOrEqualTo(String value)
         {
              addCriterion("invoiced_tile >= ", value, "invoiced_tile");
              return (Criteria) this;
         }

         public Criteria andInvoicedTileLessThan(String value)
         {
              addCriterion("invoiced_tile < ", value, "invoiced_tile");
              return (Criteria) this;
         }

         public Criteria andInvoicedTileLessThanOrEqualTo(String value)
         {
              addCriterion("invoiced_tile <= ", value, "invoiced_tile");
              return (Criteria) this;
         }

         public Criteria andInvoicedTileLike(String value)
         {
              addCriterion("invoiced_tile like ", value, "invoiced_tile");
              return (Criteria) this;
         }

         public Criteria andInvoicedTileNotLike(String value)
         {
              addCriterion("invoiced_tile not like ", value, "invoiced_tile");
              return (Criteria) this;
         }

         public Criteria andInvoicedTileIn(List<String> values)
         {
              addCriterion("invoiced_tile in ", values, "invoiced_tile");
              return (Criteria) this;
         }

         public Criteria andInvoicedTileNotIn(List<String> values)
         {
              addCriterion("invoiced_tile not in ", values, "invoiced_tile");
              return (Criteria) this;
         }

         public Criteria andInvoicedTileBetween(String value1, String value2)
         {
              addCriterion("invoiced_tile between ", value1,value2, "invoiced_tile");
              return (Criteria) this;
         }

         public Criteria andInvoicedTileNotBetween(String value1, String value2)
         {
              addCriterion("invoiced_tile not between ", value1,value2, "invoiced_tile");
              return (Criteria) this;
         }

         public Criteria andInvoicedPriceIsNull()
         {
              addCriterion("invoiced_price is null");
              return (Criteria) this;
         }

         public Criteria andInvoicedPriceIsNotNull()
         {
              addCriterion("invoiced_price is not null");
              return (Criteria) this;
         }

         public Criteria andInvoicedPriceEqualTo(String value)
         {
              addCriterion("invoiced_price = ", value, "invoiced_price");
              return (Criteria) this;
         }

         public Criteria andInvoicedPriceNotEqualTo(String value)
         {
              addCriterion("invoiced_price <> ", value, "invoiced_price");
              return (Criteria) this;
         }

         public Criteria andInvoicedPriceGreaterThan(String value)
         {
              addCriterion("invoiced_price > ", value, "invoiced_price");
              return (Criteria) this;
         }

         public Criteria andInvoicedPriceGreaterThanOrEqualTo(String value)
         {
              addCriterion("invoiced_price >= ", value, "invoiced_price");
              return (Criteria) this;
         }

         public Criteria andInvoicedPriceLessThan(String value)
         {
              addCriterion("invoiced_price < ", value, "invoiced_price");
              return (Criteria) this;
         }

         public Criteria andInvoicedPriceLessThanOrEqualTo(String value)
         {
              addCriterion("invoiced_price <= ", value, "invoiced_price");
              return (Criteria) this;
         }

         public Criteria andInvoicedPriceLike(String value)
         {
              addCriterion("invoiced_price like ", value, "invoiced_price");
              return (Criteria) this;
         }

         public Criteria andInvoicedPriceNotLike(String value)
         {
              addCriterion("invoiced_price not like ", value, "invoiced_price");
              return (Criteria) this;
         }

         public Criteria andInvoicedPriceIn(List<String> values)
         {
              addCriterion("invoiced_price in ", values, "invoiced_price");
              return (Criteria) this;
         }

         public Criteria andInvoicedPriceNotIn(List<String> values)
         {
              addCriterion("invoiced_price not in ", values, "invoiced_price");
              return (Criteria) this;
         }

         public Criteria andInvoicedPriceBetween(String value1, String value2)
         {
              addCriterion("invoiced_price between ", value1,value2, "invoiced_price");
              return (Criteria) this;
         }

         public Criteria andInvoicedPriceNotBetween(String value1, String value2)
         {
              addCriterion("invoiced_price not between ", value1,value2, "invoiced_price");
              return (Criteria) this;
         }

         public Criteria andInvoicedItemIsNull()
         {
              addCriterion("invoiced_item is null");
              return (Criteria) this;
         }

         public Criteria andInvoicedItemIsNotNull()
         {
              addCriterion("invoiced_item is not null");
              return (Criteria) this;
         }

         public Criteria andInvoicedItemEqualTo(String value)
         {
              addCriterion("invoiced_item = ", value, "invoiced_item");
              return (Criteria) this;
         }

         public Criteria andInvoicedItemNotEqualTo(String value)
         {
              addCriterion("invoiced_item <> ", value, "invoiced_item");
              return (Criteria) this;
         }

         public Criteria andInvoicedItemGreaterThan(String value)
         {
              addCriterion("invoiced_item > ", value, "invoiced_item");
              return (Criteria) this;
         }

         public Criteria andInvoicedItemGreaterThanOrEqualTo(String value)
         {
              addCriterion("invoiced_item >= ", value, "invoiced_item");
              return (Criteria) this;
         }

         public Criteria andInvoicedItemLessThan(String value)
         {
              addCriterion("invoiced_item < ", value, "invoiced_item");
              return (Criteria) this;
         }

         public Criteria andInvoicedItemLessThanOrEqualTo(String value)
         {
              addCriterion("invoiced_item <= ", value, "invoiced_item");
              return (Criteria) this;
         }

         public Criteria andInvoicedItemLike(String value)
         {
              addCriterion("invoiced_item like ", value, "invoiced_item");
              return (Criteria) this;
         }

         public Criteria andInvoicedItemNotLike(String value)
         {
              addCriterion("invoiced_item not like ", value, "invoiced_item");
              return (Criteria) this;
         }

         public Criteria andInvoicedItemIn(List<String> values)
         {
              addCriterion("invoiced_item in ", values, "invoiced_item");
              return (Criteria) this;
         }

         public Criteria andInvoicedItemNotIn(List<String> values)
         {
              addCriterion("invoiced_item not in ", values, "invoiced_item");
              return (Criteria) this;
         }

         public Criteria andInvoicedItemBetween(String value1, String value2)
         {
              addCriterion("invoiced_item between ", value1,value2, "invoiced_item");
              return (Criteria) this;
         }

         public Criteria andInvoicedItemNotBetween(String value1, String value2)
         {
              addCriterion("invoiced_item not between ", value1,value2, "invoiced_item");
              return (Criteria) this;
         }

         public Criteria andInvoicedTimeIsNull()
         {
              addCriterion("invoiced_time is null");
              return (Criteria) this;
         }

         public Criteria andInvoicedTimeIsNotNull()
         {
              addCriterion("invoiced_time is not null");
              return (Criteria) this;
         }

         public Criteria andInvoicedTimeEqualTo(Date value)
         {
              addCriterion("invoiced_time = ", value, "invoiced_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedTimeNotEqualTo(Date value)
         {
              addCriterion("invoiced_time <> ", value, "invoiced_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedTimeGreaterThan(Date value)
         {
              addCriterion("invoiced_time > ", value, "invoiced_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("invoiced_time >= ", value, "invoiced_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedTimeLessThan(Date value)
         {
              addCriterion("invoiced_time < ", value, "invoiced_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("invoiced_time <= ", value, "invoiced_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedTimeIn(List<Date> values)
         {
              addCriterion("invoiced_time in ", values, "invoiced_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedTimeNotIn(List<Date> values)
         {
              addCriterion("invoiced_time not in ", values, "invoiced_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedTimeBetween(Date value1, Date value2)
         {
              addCriterion("invoiced_time between ", value1,value2, "invoiced_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("invoiced_time not between ", value1,value2, "invoiced_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedRequestTimeIsNull()
         {
              addCriterion("invoiced_request_time is null");
              return (Criteria) this;
         }

         public Criteria andInvoicedRequestTimeIsNotNull()
         {
              addCriterion("invoiced_request_time is not null");
              return (Criteria) this;
         }

         public Criteria andInvoicedRequestTimeEqualTo(Date value)
         {
              addCriterion("invoiced_request_time = ", value, "invoiced_request_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedRequestTimeNotEqualTo(Date value)
         {
              addCriterion("invoiced_request_time <> ", value, "invoiced_request_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedRequestTimeGreaterThan(Date value)
         {
              addCriterion("invoiced_request_time > ", value, "invoiced_request_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedRequestTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("invoiced_request_time >= ", value, "invoiced_request_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedRequestTimeLessThan(Date value)
         {
              addCriterion("invoiced_request_time < ", value, "invoiced_request_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedRequestTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("invoiced_request_time <= ", value, "invoiced_request_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedRequestTimeIn(List<Date> values)
         {
              addCriterion("invoiced_request_time in ", values, "invoiced_request_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedRequestTimeNotIn(List<Date> values)
         {
              addCriterion("invoiced_request_time not in ", values, "invoiced_request_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedRequestTimeBetween(Date value1, Date value2)
         {
              addCriterion("invoiced_request_time between ", value1,value2, "invoiced_request_time");
              return (Criteria) this;
         }

         public Criteria andInvoicedRequestTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("invoiced_request_time not between ", value1,value2, "invoiced_request_time");
              return (Criteria) this;
         }

         public Criteria andNeedInvoicedDetailIsNull()
         {
              addCriterion("need_invoiced_detail is null");
              return (Criteria) this;
         }

         public Criteria andNeedInvoicedDetailIsNotNull()
         {
              addCriterion("need_invoiced_detail is not null");
              return (Criteria) this;
         }

         public Criteria andNeedInvoicedDetailEqualTo(String value)
         {
              addCriterion("need_invoiced_detail = ", value, "need_invoiced_detail");
              return (Criteria) this;
         }

         public Criteria andNeedInvoicedDetailNotEqualTo(String value)
         {
              addCriterion("need_invoiced_detail <> ", value, "need_invoiced_detail");
              return (Criteria) this;
         }

         public Criteria andNeedInvoicedDetailGreaterThan(String value)
         {
              addCriterion("need_invoiced_detail > ", value, "need_invoiced_detail");
              return (Criteria) this;
         }

         public Criteria andNeedInvoicedDetailGreaterThanOrEqualTo(String value)
         {
              addCriterion("need_invoiced_detail >= ", value, "need_invoiced_detail");
              return (Criteria) this;
         }

         public Criteria andNeedInvoicedDetailLessThan(String value)
         {
              addCriterion("need_invoiced_detail < ", value, "need_invoiced_detail");
              return (Criteria) this;
         }

         public Criteria andNeedInvoicedDetailLessThanOrEqualTo(String value)
         {
              addCriterion("need_invoiced_detail <= ", value, "need_invoiced_detail");
              return (Criteria) this;
         }

         public Criteria andNeedInvoicedDetailLike(String value)
         {
              addCriterion("need_invoiced_detail like ", value, "need_invoiced_detail");
              return (Criteria) this;
         }

         public Criteria andNeedInvoicedDetailNotLike(String value)
         {
              addCriterion("need_invoiced_detail not like ", value, "need_invoiced_detail");
              return (Criteria) this;
         }

         public Criteria andNeedInvoicedDetailIn(List<String> values)
         {
              addCriterion("need_invoiced_detail in ", values, "need_invoiced_detail");
              return (Criteria) this;
         }

         public Criteria andNeedInvoicedDetailNotIn(List<String> values)
         {
              addCriterion("need_invoiced_detail not in ", values, "need_invoiced_detail");
              return (Criteria) this;
         }

         public Criteria andNeedInvoicedDetailBetween(String value1, String value2)
         {
              addCriterion("need_invoiced_detail between ", value1,value2, "need_invoiced_detail");
              return (Criteria) this;
         }

         public Criteria andNeedInvoicedDetailNotBetween(String value1, String value2)
         {
              addCriterion("need_invoiced_detail not between ", value1,value2, "need_invoiced_detail");
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
