package com.gooagoo.entity.generator.marketing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 积分兑换信息
 */

public class ShopIntegralConvertExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopIntegralConvertExample()
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

         public Criteria andShopIntegralConvertIdIsNull()
         {
              addCriterion("shop_integral_convert_id is null");
              return (Criteria) this;
         }

         public Criteria andShopIntegralConvertIdIsNotNull()
         {
              addCriterion("shop_integral_convert_id is not null");
              return (Criteria) this;
         }

         public Criteria andShopIntegralConvertIdEqualTo(String value)
         {
              addCriterion("shop_integral_convert_id = ", value, "shop_integral_convert_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralConvertIdNotEqualTo(String value)
         {
              addCriterion("shop_integral_convert_id <> ", value, "shop_integral_convert_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralConvertIdGreaterThan(String value)
         {
              addCriterion("shop_integral_convert_id > ", value, "shop_integral_convert_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralConvertIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_integral_convert_id >= ", value, "shop_integral_convert_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralConvertIdLessThan(String value)
         {
              addCriterion("shop_integral_convert_id < ", value, "shop_integral_convert_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralConvertIdLessThanOrEqualTo(String value)
         {
              addCriterion("shop_integral_convert_id <= ", value, "shop_integral_convert_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralConvertIdLike(String value)
         {
              addCriterion("shop_integral_convert_id like ", value, "shop_integral_convert_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralConvertIdNotLike(String value)
         {
              addCriterion("shop_integral_convert_id not like ", value, "shop_integral_convert_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralConvertIdIn(List<String> values)
         {
              addCriterion("shop_integral_convert_id in ", values, "shop_integral_convert_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralConvertIdNotIn(List<String> values)
         {
              addCriterion("shop_integral_convert_id not in ", values, "shop_integral_convert_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralConvertIdBetween(String value1, String value2)
         {
              addCriterion("shop_integral_convert_id between ", value1,value2, "shop_integral_convert_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralConvertIdNotBetween(String value1, String value2)
         {
              addCriterion("shop_integral_convert_id not between ", value1,value2, "shop_integral_convert_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralIdIsNull()
         {
              addCriterion("shop_integral_id is null");
              return (Criteria) this;
         }

         public Criteria andShopIntegralIdIsNotNull()
         {
              addCriterion("shop_integral_id is not null");
              return (Criteria) this;
         }

         public Criteria andShopIntegralIdEqualTo(String value)
         {
              addCriterion("shop_integral_id = ", value, "shop_integral_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralIdNotEqualTo(String value)
         {
              addCriterion("shop_integral_id <> ", value, "shop_integral_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralIdGreaterThan(String value)
         {
              addCriterion("shop_integral_id > ", value, "shop_integral_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_integral_id >= ", value, "shop_integral_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralIdLessThan(String value)
         {
              addCriterion("shop_integral_id < ", value, "shop_integral_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralIdLessThanOrEqualTo(String value)
         {
              addCriterion("shop_integral_id <= ", value, "shop_integral_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralIdLike(String value)
         {
              addCriterion("shop_integral_id like ", value, "shop_integral_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralIdNotLike(String value)
         {
              addCriterion("shop_integral_id not like ", value, "shop_integral_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralIdIn(List<String> values)
         {
              addCriterion("shop_integral_id in ", values, "shop_integral_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralIdNotIn(List<String> values)
         {
              addCriterion("shop_integral_id not in ", values, "shop_integral_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralIdBetween(String value1, String value2)
         {
              addCriterion("shop_integral_id between ", value1,value2, "shop_integral_id");
              return (Criteria) this;
         }

         public Criteria andShopIntegralIdNotBetween(String value1, String value2)
         {
              addCriterion("shop_integral_id not between ", value1,value2, "shop_integral_id");
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

         public Criteria andIntegralTradeTypeIsNull()
         {
              addCriterion("integral_trade_type is null");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeTypeIsNotNull()
         {
              addCriterion("integral_trade_type is not null");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeTypeEqualTo(String value)
         {
              addCriterion("integral_trade_type = ", value, "integral_trade_type");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeTypeNotEqualTo(String value)
         {
              addCriterion("integral_trade_type <> ", value, "integral_trade_type");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeTypeGreaterThan(String value)
         {
              addCriterion("integral_trade_type > ", value, "integral_trade_type");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("integral_trade_type >= ", value, "integral_trade_type");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeTypeLessThan(String value)
         {
              addCriterion("integral_trade_type < ", value, "integral_trade_type");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeTypeLessThanOrEqualTo(String value)
         {
              addCriterion("integral_trade_type <= ", value, "integral_trade_type");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeTypeLike(String value)
         {
              addCriterion("integral_trade_type like ", value, "integral_trade_type");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeTypeNotLike(String value)
         {
              addCriterion("integral_trade_type not like ", value, "integral_trade_type");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeTypeIn(List<String> values)
         {
              addCriterion("integral_trade_type in ", values, "integral_trade_type");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeTypeNotIn(List<String> values)
         {
              addCriterion("integral_trade_type not in ", values, "integral_trade_type");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeTypeBetween(String value1, String value2)
         {
              addCriterion("integral_trade_type between ", value1,value2, "integral_trade_type");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeTypeNotBetween(String value1, String value2)
         {
              addCriterion("integral_trade_type not between ", value1,value2, "integral_trade_type");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeIdIsNull()
         {
              addCriterion("integral_trade_id is null");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeIdIsNotNull()
         {
              addCriterion("integral_trade_id is not null");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeIdEqualTo(String value)
         {
              addCriterion("integral_trade_id = ", value, "integral_trade_id");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeIdNotEqualTo(String value)
         {
              addCriterion("integral_trade_id <> ", value, "integral_trade_id");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeIdGreaterThan(String value)
         {
              addCriterion("integral_trade_id > ", value, "integral_trade_id");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("integral_trade_id >= ", value, "integral_trade_id");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeIdLessThan(String value)
         {
              addCriterion("integral_trade_id < ", value, "integral_trade_id");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeIdLessThanOrEqualTo(String value)
         {
              addCriterion("integral_trade_id <= ", value, "integral_trade_id");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeIdLike(String value)
         {
              addCriterion("integral_trade_id like ", value, "integral_trade_id");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeIdNotLike(String value)
         {
              addCriterion("integral_trade_id not like ", value, "integral_trade_id");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeIdIn(List<String> values)
         {
              addCriterion("integral_trade_id in ", values, "integral_trade_id");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeIdNotIn(List<String> values)
         {
              addCriterion("integral_trade_id not in ", values, "integral_trade_id");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeIdBetween(String value1, String value2)
         {
              addCriterion("integral_trade_id between ", value1,value2, "integral_trade_id");
              return (Criteria) this;
         }

         public Criteria andIntegralTradeIdNotBetween(String value1, String value2)
         {
              addCriterion("integral_trade_id not between ", value1,value2, "integral_trade_id");
              return (Criteria) this;
         }

         public Criteria andTradeIntegralValueIsNull()
         {
              addCriterion("trade_integral_value is null");
              return (Criteria) this;
         }

         public Criteria andTradeIntegralValueIsNotNull()
         {
              addCriterion("trade_integral_value is not null");
              return (Criteria) this;
         }

         public Criteria andTradeIntegralValueEqualTo(String value)
         {
              addCriterion("trade_integral_value = ", value, "trade_integral_value");
              return (Criteria) this;
         }

         public Criteria andTradeIntegralValueNotEqualTo(String value)
         {
              addCriterion("trade_integral_value <> ", value, "trade_integral_value");
              return (Criteria) this;
         }

         public Criteria andTradeIntegralValueGreaterThan(String value)
         {
              addCriterion("trade_integral_value > ", value, "trade_integral_value");
              return (Criteria) this;
         }

         public Criteria andTradeIntegralValueGreaterThanOrEqualTo(String value)
         {
              addCriterion("trade_integral_value >= ", value, "trade_integral_value");
              return (Criteria) this;
         }

         public Criteria andTradeIntegralValueLessThan(String value)
         {
              addCriterion("trade_integral_value < ", value, "trade_integral_value");
              return (Criteria) this;
         }

         public Criteria andTradeIntegralValueLessThanOrEqualTo(String value)
         {
              addCriterion("trade_integral_value <= ", value, "trade_integral_value");
              return (Criteria) this;
         }

         public Criteria andTradeIntegralValueLike(String value)
         {
              addCriterion("trade_integral_value like ", value, "trade_integral_value");
              return (Criteria) this;
         }

         public Criteria andTradeIntegralValueNotLike(String value)
         {
              addCriterion("trade_integral_value not like ", value, "trade_integral_value");
              return (Criteria) this;
         }

         public Criteria andTradeIntegralValueIn(List<String> values)
         {
              addCriterion("trade_integral_value in ", values, "trade_integral_value");
              return (Criteria) this;
         }

         public Criteria andTradeIntegralValueNotIn(List<String> values)
         {
              addCriterion("trade_integral_value not in ", values, "trade_integral_value");
              return (Criteria) this;
         }

         public Criteria andTradeIntegralValueBetween(String value1, String value2)
         {
              addCriterion("trade_integral_value between ", value1,value2, "trade_integral_value");
              return (Criteria) this;
         }

         public Criteria andTradeIntegralValueNotBetween(String value1, String value2)
         {
              addCriterion("trade_integral_value not between ", value1,value2, "trade_integral_value");
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

         public Criteria andConvertTimeIsNull()
         {
              addCriterion("convert_time is null");
              return (Criteria) this;
         }

         public Criteria andConvertTimeIsNotNull()
         {
              addCriterion("convert_time is not null");
              return (Criteria) this;
         }

         public Criteria andConvertTimeEqualTo(Date value)
         {
              addCriterion("convert_time = ", value, "convert_time");
              return (Criteria) this;
         }

         public Criteria andConvertTimeNotEqualTo(Date value)
         {
              addCriterion("convert_time <> ", value, "convert_time");
              return (Criteria) this;
         }

         public Criteria andConvertTimeGreaterThan(Date value)
         {
              addCriterion("convert_time > ", value, "convert_time");
              return (Criteria) this;
         }

         public Criteria andConvertTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("convert_time >= ", value, "convert_time");
              return (Criteria) this;
         }

         public Criteria andConvertTimeLessThan(Date value)
         {
              addCriterion("convert_time < ", value, "convert_time");
              return (Criteria) this;
         }

         public Criteria andConvertTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("convert_time <= ", value, "convert_time");
              return (Criteria) this;
         }

         public Criteria andConvertTimeIn(List<Date> values)
         {
              addCriterion("convert_time in ", values, "convert_time");
              return (Criteria) this;
         }

         public Criteria andConvertTimeNotIn(List<Date> values)
         {
              addCriterion("convert_time not in ", values, "convert_time");
              return (Criteria) this;
         }

         public Criteria andConvertTimeBetween(Date value1, Date value2)
         {
              addCriterion("convert_time between ", value1,value2, "convert_time");
              return (Criteria) this;
         }

         public Criteria andConvertTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("convert_time not between ", value1,value2, "convert_time");
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
