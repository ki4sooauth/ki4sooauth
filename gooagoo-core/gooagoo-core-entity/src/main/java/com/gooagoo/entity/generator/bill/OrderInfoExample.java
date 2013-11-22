package com.gooagoo.entity.generator.bill;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 订单信息，记录用户订单、商家订单、账单、开发票的全程变化，对外服务的数据全都从这个表中获取。
 */

public class OrderInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public OrderInfoExample()
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

         public Criteria andBillTypeIsNull()
         {
              addCriterion("bill_type is null");
              return (Criteria) this;
         }

         public Criteria andBillTypeIsNotNull()
         {
              addCriterion("bill_type is not null");
              return (Criteria) this;
         }

         public Criteria andBillTypeEqualTo(String value)
         {
              addCriterion("bill_type = ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeNotEqualTo(String value)
         {
              addCriterion("bill_type <> ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeGreaterThan(String value)
         {
              addCriterion("bill_type > ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("bill_type >= ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeLessThan(String value)
         {
              addCriterion("bill_type < ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeLessThanOrEqualTo(String value)
         {
              addCriterion("bill_type <= ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeLike(String value)
         {
              addCriterion("bill_type like ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeNotLike(String value)
         {
              addCriterion("bill_type not like ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeIn(List<String> values)
         {
              addCriterion("bill_type in ", values, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeNotIn(List<String> values)
         {
              addCriterion("bill_type not in ", values, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeBetween(String value1, String value2)
         {
              addCriterion("bill_type between ", value1,value2, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeNotBetween(String value1, String value2)
         {
              addCriterion("bill_type not between ", value1,value2, "bill_type");
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

         public Criteria andRequestTimeIsNull()
         {
              addCriterion("request_time is null");
              return (Criteria) this;
         }

         public Criteria andRequestTimeIsNotNull()
         {
              addCriterion("request_time is not null");
              return (Criteria) this;
         }

         public Criteria andRequestTimeEqualTo(Date value)
         {
              addCriterion("request_time = ", value, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeNotEqualTo(Date value)
         {
              addCriterion("request_time <> ", value, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeGreaterThan(Date value)
         {
              addCriterion("request_time > ", value, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("request_time >= ", value, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeLessThan(Date value)
         {
              addCriterion("request_time < ", value, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("request_time <= ", value, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeIn(List<Date> values)
         {
              addCriterion("request_time in ", values, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeNotIn(List<Date> values)
         {
              addCriterion("request_time not in ", values, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeBetween(Date value1, Date value2)
         {
              addCriterion("request_time between ", value1,value2, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("request_time not between ", value1,value2, "request_time");
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

         public Criteria andDeliveryStatusIsNull()
         {
              addCriterion("delivery_status is null");
              return (Criteria) this;
         }

         public Criteria andDeliveryStatusIsNotNull()
         {
              addCriterion("delivery_status is not null");
              return (Criteria) this;
         }

         public Criteria andDeliveryStatusEqualTo(String value)
         {
              addCriterion("delivery_status = ", value, "delivery_status");
              return (Criteria) this;
         }

         public Criteria andDeliveryStatusNotEqualTo(String value)
         {
              addCriterion("delivery_status <> ", value, "delivery_status");
              return (Criteria) this;
         }

         public Criteria andDeliveryStatusGreaterThan(String value)
         {
              addCriterion("delivery_status > ", value, "delivery_status");
              return (Criteria) this;
         }

         public Criteria andDeliveryStatusGreaterThanOrEqualTo(String value)
         {
              addCriterion("delivery_status >= ", value, "delivery_status");
              return (Criteria) this;
         }

         public Criteria andDeliveryStatusLessThan(String value)
         {
              addCriterion("delivery_status < ", value, "delivery_status");
              return (Criteria) this;
         }

         public Criteria andDeliveryStatusLessThanOrEqualTo(String value)
         {
              addCriterion("delivery_status <= ", value, "delivery_status");
              return (Criteria) this;
         }

         public Criteria andDeliveryStatusLike(String value)
         {
              addCriterion("delivery_status like ", value, "delivery_status");
              return (Criteria) this;
         }

         public Criteria andDeliveryStatusNotLike(String value)
         {
              addCriterion("delivery_status not like ", value, "delivery_status");
              return (Criteria) this;
         }

         public Criteria andDeliveryStatusIn(List<String> values)
         {
              addCriterion("delivery_status in ", values, "delivery_status");
              return (Criteria) this;
         }

         public Criteria andDeliveryStatusNotIn(List<String> values)
         {
              addCriterion("delivery_status not in ", values, "delivery_status");
              return (Criteria) this;
         }

         public Criteria andDeliveryStatusBetween(String value1, String value2)
         {
              addCriterion("delivery_status between ", value1,value2, "delivery_status");
              return (Criteria) this;
         }

         public Criteria andDeliveryStatusNotBetween(String value1, String value2)
         {
              addCriterion("delivery_status not between ", value1,value2, "delivery_status");
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

         public Criteria andUserOrderTimeIsNull()
         {
              addCriterion("user_order_time is null");
              return (Criteria) this;
         }

         public Criteria andUserOrderTimeIsNotNull()
         {
              addCriterion("user_order_time is not null");
              return (Criteria) this;
         }

         public Criteria andUserOrderTimeEqualTo(Date value)
         {
              addCriterion("user_order_time = ", value, "user_order_time");
              return (Criteria) this;
         }

         public Criteria andUserOrderTimeNotEqualTo(Date value)
         {
              addCriterion("user_order_time <> ", value, "user_order_time");
              return (Criteria) this;
         }

         public Criteria andUserOrderTimeGreaterThan(Date value)
         {
              addCriterion("user_order_time > ", value, "user_order_time");
              return (Criteria) this;
         }

         public Criteria andUserOrderTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("user_order_time >= ", value, "user_order_time");
              return (Criteria) this;
         }

         public Criteria andUserOrderTimeLessThan(Date value)
         {
              addCriterion("user_order_time < ", value, "user_order_time");
              return (Criteria) this;
         }

         public Criteria andUserOrderTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("user_order_time <= ", value, "user_order_time");
              return (Criteria) this;
         }

         public Criteria andUserOrderTimeIn(List<Date> values)
         {
              addCriterion("user_order_time in ", values, "user_order_time");
              return (Criteria) this;
         }

         public Criteria andUserOrderTimeNotIn(List<Date> values)
         {
              addCriterion("user_order_time not in ", values, "user_order_time");
              return (Criteria) this;
         }

         public Criteria andUserOrderTimeBetween(Date value1, Date value2)
         {
              addCriterion("user_order_time between ", value1,value2, "user_order_time");
              return (Criteria) this;
         }

         public Criteria andUserOrderTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("user_order_time not between ", value1,value2, "user_order_time");
              return (Criteria) this;
         }

         public Criteria andShopOrderTimeIsNull()
         {
              addCriterion("shop_order_time is null");
              return (Criteria) this;
         }

         public Criteria andShopOrderTimeIsNotNull()
         {
              addCriterion("shop_order_time is not null");
              return (Criteria) this;
         }

         public Criteria andShopOrderTimeEqualTo(Date value)
         {
              addCriterion("shop_order_time = ", value, "shop_order_time");
              return (Criteria) this;
         }

         public Criteria andShopOrderTimeNotEqualTo(Date value)
         {
              addCriterion("shop_order_time <> ", value, "shop_order_time");
              return (Criteria) this;
         }

         public Criteria andShopOrderTimeGreaterThan(Date value)
         {
              addCriterion("shop_order_time > ", value, "shop_order_time");
              return (Criteria) this;
         }

         public Criteria andShopOrderTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("shop_order_time >= ", value, "shop_order_time");
              return (Criteria) this;
         }

         public Criteria andShopOrderTimeLessThan(Date value)
         {
              addCriterion("shop_order_time < ", value, "shop_order_time");
              return (Criteria) this;
         }

         public Criteria andShopOrderTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("shop_order_time <= ", value, "shop_order_time");
              return (Criteria) this;
         }

         public Criteria andShopOrderTimeIn(List<Date> values)
         {
              addCriterion("shop_order_time in ", values, "shop_order_time");
              return (Criteria) this;
         }

         public Criteria andShopOrderTimeNotIn(List<Date> values)
         {
              addCriterion("shop_order_time not in ", values, "shop_order_time");
              return (Criteria) this;
         }

         public Criteria andShopOrderTimeBetween(Date value1, Date value2)
         {
              addCriterion("shop_order_time between ", value1,value2, "shop_order_time");
              return (Criteria) this;
         }

         public Criteria andShopOrderTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("shop_order_time not between ", value1,value2, "shop_order_time");
              return (Criteria) this;
         }

         public Criteria andPaymentApplicationTimeIsNull()
         {
              addCriterion("payment_application_time is null");
              return (Criteria) this;
         }

         public Criteria andPaymentApplicationTimeIsNotNull()
         {
              addCriterion("payment_application_time is not null");
              return (Criteria) this;
         }

         public Criteria andPaymentApplicationTimeEqualTo(Date value)
         {
              addCriterion("payment_application_time = ", value, "payment_application_time");
              return (Criteria) this;
         }

         public Criteria andPaymentApplicationTimeNotEqualTo(Date value)
         {
              addCriterion("payment_application_time <> ", value, "payment_application_time");
              return (Criteria) this;
         }

         public Criteria andPaymentApplicationTimeGreaterThan(Date value)
         {
              addCriterion("payment_application_time > ", value, "payment_application_time");
              return (Criteria) this;
         }

         public Criteria andPaymentApplicationTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("payment_application_time >= ", value, "payment_application_time");
              return (Criteria) this;
         }

         public Criteria andPaymentApplicationTimeLessThan(Date value)
         {
              addCriterion("payment_application_time < ", value, "payment_application_time");
              return (Criteria) this;
         }

         public Criteria andPaymentApplicationTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("payment_application_time <= ", value, "payment_application_time");
              return (Criteria) this;
         }

         public Criteria andPaymentApplicationTimeIn(List<Date> values)
         {
              addCriterion("payment_application_time in ", values, "payment_application_time");
              return (Criteria) this;
         }

         public Criteria andPaymentApplicationTimeNotIn(List<Date> values)
         {
              addCriterion("payment_application_time not in ", values, "payment_application_time");
              return (Criteria) this;
         }

         public Criteria andPaymentApplicationTimeBetween(Date value1, Date value2)
         {
              addCriterion("payment_application_time between ", value1,value2, "payment_application_time");
              return (Criteria) this;
         }

         public Criteria andPaymentApplicationTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("payment_application_time not between ", value1,value2, "payment_application_time");
              return (Criteria) this;
         }

         public Criteria andPaymentTimeIsNull()
         {
              addCriterion("payment_time is null");
              return (Criteria) this;
         }

         public Criteria andPaymentTimeIsNotNull()
         {
              addCriterion("payment_time is not null");
              return (Criteria) this;
         }

         public Criteria andPaymentTimeEqualTo(Date value)
         {
              addCriterion("payment_time = ", value, "payment_time");
              return (Criteria) this;
         }

         public Criteria andPaymentTimeNotEqualTo(Date value)
         {
              addCriterion("payment_time <> ", value, "payment_time");
              return (Criteria) this;
         }

         public Criteria andPaymentTimeGreaterThan(Date value)
         {
              addCriterion("payment_time > ", value, "payment_time");
              return (Criteria) this;
         }

         public Criteria andPaymentTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("payment_time >= ", value, "payment_time");
              return (Criteria) this;
         }

         public Criteria andPaymentTimeLessThan(Date value)
         {
              addCriterion("payment_time < ", value, "payment_time");
              return (Criteria) this;
         }

         public Criteria andPaymentTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("payment_time <= ", value, "payment_time");
              return (Criteria) this;
         }

         public Criteria andPaymentTimeIn(List<Date> values)
         {
              addCriterion("payment_time in ", values, "payment_time");
              return (Criteria) this;
         }

         public Criteria andPaymentTimeNotIn(List<Date> values)
         {
              addCriterion("payment_time not in ", values, "payment_time");
              return (Criteria) this;
         }

         public Criteria andPaymentTimeBetween(Date value1, Date value2)
         {
              addCriterion("payment_time between ", value1,value2, "payment_time");
              return (Criteria) this;
         }

         public Criteria andPaymentTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("payment_time not between ", value1,value2, "payment_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceApplicationTimeIsNull()
         {
              addCriterion("invoice_application_time is null");
              return (Criteria) this;
         }

         public Criteria andInvoiceApplicationTimeIsNotNull()
         {
              addCriterion("invoice_application_time is not null");
              return (Criteria) this;
         }

         public Criteria andInvoiceApplicationTimeEqualTo(Date value)
         {
              addCriterion("invoice_application_time = ", value, "invoice_application_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceApplicationTimeNotEqualTo(Date value)
         {
              addCriterion("invoice_application_time <> ", value, "invoice_application_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceApplicationTimeGreaterThan(Date value)
         {
              addCriterion("invoice_application_time > ", value, "invoice_application_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceApplicationTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("invoice_application_time >= ", value, "invoice_application_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceApplicationTimeLessThan(Date value)
         {
              addCriterion("invoice_application_time < ", value, "invoice_application_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceApplicationTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("invoice_application_time <= ", value, "invoice_application_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceApplicationTimeIn(List<Date> values)
         {
              addCriterion("invoice_application_time in ", values, "invoice_application_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceApplicationTimeNotIn(List<Date> values)
         {
              addCriterion("invoice_application_time not in ", values, "invoice_application_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceApplicationTimeBetween(Date value1, Date value2)
         {
              addCriterion("invoice_application_time between ", value1,value2, "invoice_application_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceApplicationTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("invoice_application_time not between ", value1,value2, "invoice_application_time");
              return (Criteria) this;
         }

         public Criteria andIsInvoiceIsNull()
         {
              addCriterion("is_invoice is null");
              return (Criteria) this;
         }

         public Criteria andIsInvoiceIsNotNull()
         {
              addCriterion("is_invoice is not null");
              return (Criteria) this;
         }

         public Criteria andIsInvoiceEqualTo(String value)
         {
              addCriterion("is_invoice = ", value, "is_invoice");
              return (Criteria) this;
         }

         public Criteria andIsInvoiceNotEqualTo(String value)
         {
              addCriterion("is_invoice <> ", value, "is_invoice");
              return (Criteria) this;
         }

         public Criteria andIsInvoiceGreaterThan(String value)
         {
              addCriterion("is_invoice > ", value, "is_invoice");
              return (Criteria) this;
         }

         public Criteria andIsInvoiceGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_invoice >= ", value, "is_invoice");
              return (Criteria) this;
         }

         public Criteria andIsInvoiceLessThan(String value)
         {
              addCriterion("is_invoice < ", value, "is_invoice");
              return (Criteria) this;
         }

         public Criteria andIsInvoiceLessThanOrEqualTo(String value)
         {
              addCriterion("is_invoice <= ", value, "is_invoice");
              return (Criteria) this;
         }

         public Criteria andIsInvoiceLike(String value)
         {
              addCriterion("is_invoice like ", value, "is_invoice");
              return (Criteria) this;
         }

         public Criteria andIsInvoiceNotLike(String value)
         {
              addCriterion("is_invoice not like ", value, "is_invoice");
              return (Criteria) this;
         }

         public Criteria andIsInvoiceIn(List<String> values)
         {
              addCriterion("is_invoice in ", values, "is_invoice");
              return (Criteria) this;
         }

         public Criteria andIsInvoiceNotIn(List<String> values)
         {
              addCriterion("is_invoice not in ", values, "is_invoice");
              return (Criteria) this;
         }

         public Criteria andIsInvoiceBetween(String value1, String value2)
         {
              addCriterion("is_invoice between ", value1,value2, "is_invoice");
              return (Criteria) this;
         }

         public Criteria andIsInvoiceNotBetween(String value1, String value2)
         {
              addCriterion("is_invoice not between ", value1,value2, "is_invoice");
              return (Criteria) this;
         }

         public Criteria andInvoiceTimeIsNull()
         {
              addCriterion("invoice_time is null");
              return (Criteria) this;
         }

         public Criteria andInvoiceTimeIsNotNull()
         {
              addCriterion("invoice_time is not null");
              return (Criteria) this;
         }

         public Criteria andInvoiceTimeEqualTo(Date value)
         {
              addCriterion("invoice_time = ", value, "invoice_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceTimeNotEqualTo(Date value)
         {
              addCriterion("invoice_time <> ", value, "invoice_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceTimeGreaterThan(Date value)
         {
              addCriterion("invoice_time > ", value, "invoice_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("invoice_time >= ", value, "invoice_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceTimeLessThan(Date value)
         {
              addCriterion("invoice_time < ", value, "invoice_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("invoice_time <= ", value, "invoice_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceTimeIn(List<Date> values)
         {
              addCriterion("invoice_time in ", values, "invoice_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceTimeNotIn(List<Date> values)
         {
              addCriterion("invoice_time not in ", values, "invoice_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceTimeBetween(Date value1, Date value2)
         {
              addCriterion("invoice_time between ", value1,value2, "invoice_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("invoice_time not between ", value1,value2, "invoice_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceLatestTimeIsNull()
         {
              addCriterion("invoice_latest_time is null");
              return (Criteria) this;
         }

         public Criteria andInvoiceLatestTimeIsNotNull()
         {
              addCriterion("invoice_latest_time is not null");
              return (Criteria) this;
         }

         public Criteria andInvoiceLatestTimeEqualTo(Date value)
         {
              addCriterion("invoice_latest_time = ", value, "invoice_latest_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceLatestTimeNotEqualTo(Date value)
         {
              addCriterion("invoice_latest_time <> ", value, "invoice_latest_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceLatestTimeGreaterThan(Date value)
         {
              addCriterion("invoice_latest_time > ", value, "invoice_latest_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceLatestTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("invoice_latest_time >= ", value, "invoice_latest_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceLatestTimeLessThan(Date value)
         {
              addCriterion("invoice_latest_time < ", value, "invoice_latest_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceLatestTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("invoice_latest_time <= ", value, "invoice_latest_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceLatestTimeIn(List<Date> values)
         {
              addCriterion("invoice_latest_time in ", values, "invoice_latest_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceLatestTimeNotIn(List<Date> values)
         {
              addCriterion("invoice_latest_time not in ", values, "invoice_latest_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceLatestTimeBetween(Date value1, Date value2)
         {
              addCriterion("invoice_latest_time between ", value1,value2, "invoice_latest_time");
              return (Criteria) this;
         }

         public Criteria andInvoiceLatestTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("invoice_latest_time not between ", value1,value2, "invoice_latest_time");
              return (Criteria) this;
         }

         public Criteria andAvoidItemIsNull()
         {
              addCriterion("avoid_item is null");
              return (Criteria) this;
         }

         public Criteria andAvoidItemIsNotNull()
         {
              addCriterion("avoid_item is not null");
              return (Criteria) this;
         }

         public Criteria andAvoidItemEqualTo(String value)
         {
              addCriterion("avoid_item = ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemNotEqualTo(String value)
         {
              addCriterion("avoid_item <> ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemGreaterThan(String value)
         {
              addCriterion("avoid_item > ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemGreaterThanOrEqualTo(String value)
         {
              addCriterion("avoid_item >= ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemLessThan(String value)
         {
              addCriterion("avoid_item < ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemLessThanOrEqualTo(String value)
         {
              addCriterion("avoid_item <= ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemLike(String value)
         {
              addCriterion("avoid_item like ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemNotLike(String value)
         {
              addCriterion("avoid_item not like ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemIn(List<String> values)
         {
              addCriterion("avoid_item in ", values, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemNotIn(List<String> values)
         {
              addCriterion("avoid_item not in ", values, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemBetween(String value1, String value2)
         {
              addCriterion("avoid_item between ", value1,value2, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemNotBetween(String value1, String value2)
         {
              addCriterion("avoid_item not between ", value1,value2, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andDiningNumbersIsNull()
         {
              addCriterion("dining_numbers is null");
              return (Criteria) this;
         }

         public Criteria andDiningNumbersIsNotNull()
         {
              addCriterion("dining_numbers is not null");
              return (Criteria) this;
         }

         public Criteria andDiningNumbersEqualTo(String value)
         {
              addCriterion("dining_numbers = ", value, "dining_numbers");
              return (Criteria) this;
         }

         public Criteria andDiningNumbersNotEqualTo(String value)
         {
              addCriterion("dining_numbers <> ", value, "dining_numbers");
              return (Criteria) this;
         }

         public Criteria andDiningNumbersGreaterThan(String value)
         {
              addCriterion("dining_numbers > ", value, "dining_numbers");
              return (Criteria) this;
         }

         public Criteria andDiningNumbersGreaterThanOrEqualTo(String value)
         {
              addCriterion("dining_numbers >= ", value, "dining_numbers");
              return (Criteria) this;
         }

         public Criteria andDiningNumbersLessThan(String value)
         {
              addCriterion("dining_numbers < ", value, "dining_numbers");
              return (Criteria) this;
         }

         public Criteria andDiningNumbersLessThanOrEqualTo(String value)
         {
              addCriterion("dining_numbers <= ", value, "dining_numbers");
              return (Criteria) this;
         }

         public Criteria andDiningNumbersLike(String value)
         {
              addCriterion("dining_numbers like ", value, "dining_numbers");
              return (Criteria) this;
         }

         public Criteria andDiningNumbersNotLike(String value)
         {
              addCriterion("dining_numbers not like ", value, "dining_numbers");
              return (Criteria) this;
         }

         public Criteria andDiningNumbersIn(List<String> values)
         {
              addCriterion("dining_numbers in ", values, "dining_numbers");
              return (Criteria) this;
         }

         public Criteria andDiningNumbersNotIn(List<String> values)
         {
              addCriterion("dining_numbers not in ", values, "dining_numbers");
              return (Criteria) this;
         }

         public Criteria andDiningNumbersBetween(String value1, String value2)
         {
              addCriterion("dining_numbers between ", value1,value2, "dining_numbers");
              return (Criteria) this;
         }

         public Criteria andDiningNumbersNotBetween(String value1, String value2)
         {
              addCriterion("dining_numbers not between ", value1,value2, "dining_numbers");
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
