package com.gooagoo.entity.generator.marketing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 积分商城
 */

public class ShopIntegralExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopIntegralExample()
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

         public Criteria andTradeStartTimeIsNull()
         {
              addCriterion("trade_start_time is null");
              return (Criteria) this;
         }

         public Criteria andTradeStartTimeIsNotNull()
         {
              addCriterion("trade_start_time is not null");
              return (Criteria) this;
         }

         public Criteria andTradeStartTimeEqualTo(Date value)
         {
              addCriterion("trade_start_time = ", value, "trade_start_time");
              return (Criteria) this;
         }

         public Criteria andTradeStartTimeNotEqualTo(Date value)
         {
              addCriterion("trade_start_time <> ", value, "trade_start_time");
              return (Criteria) this;
         }

         public Criteria andTradeStartTimeGreaterThan(Date value)
         {
              addCriterion("trade_start_time > ", value, "trade_start_time");
              return (Criteria) this;
         }

         public Criteria andTradeStartTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("trade_start_time >= ", value, "trade_start_time");
              return (Criteria) this;
         }

         public Criteria andTradeStartTimeLessThan(Date value)
         {
              addCriterion("trade_start_time < ", value, "trade_start_time");
              return (Criteria) this;
         }

         public Criteria andTradeStartTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("trade_start_time <= ", value, "trade_start_time");
              return (Criteria) this;
         }

         public Criteria andTradeStartTimeIn(List<Date> values)
         {
              addCriterion("trade_start_time in ", values, "trade_start_time");
              return (Criteria) this;
         }

         public Criteria andTradeStartTimeNotIn(List<Date> values)
         {
              addCriterion("trade_start_time not in ", values, "trade_start_time");
              return (Criteria) this;
         }

         public Criteria andTradeStartTimeBetween(Date value1, Date value2)
         {
              addCriterion("trade_start_time between ", value1,value2, "trade_start_time");
              return (Criteria) this;
         }

         public Criteria andTradeStartTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("trade_start_time not between ", value1,value2, "trade_start_time");
              return (Criteria) this;
         }

         public Criteria andTradeEndTimeIsNull()
         {
              addCriterion("trade_end_time is null");
              return (Criteria) this;
         }

         public Criteria andTradeEndTimeIsNotNull()
         {
              addCriterion("trade_end_time is not null");
              return (Criteria) this;
         }

         public Criteria andTradeEndTimeEqualTo(Date value)
         {
              addCriterion("trade_end_time = ", value, "trade_end_time");
              return (Criteria) this;
         }

         public Criteria andTradeEndTimeNotEqualTo(Date value)
         {
              addCriterion("trade_end_time <> ", value, "trade_end_time");
              return (Criteria) this;
         }

         public Criteria andTradeEndTimeGreaterThan(Date value)
         {
              addCriterion("trade_end_time > ", value, "trade_end_time");
              return (Criteria) this;
         }

         public Criteria andTradeEndTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("trade_end_time >= ", value, "trade_end_time");
              return (Criteria) this;
         }

         public Criteria andTradeEndTimeLessThan(Date value)
         {
              addCriterion("trade_end_time < ", value, "trade_end_time");
              return (Criteria) this;
         }

         public Criteria andTradeEndTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("trade_end_time <= ", value, "trade_end_time");
              return (Criteria) this;
         }

         public Criteria andTradeEndTimeIn(List<Date> values)
         {
              addCriterion("trade_end_time in ", values, "trade_end_time");
              return (Criteria) this;
         }

         public Criteria andTradeEndTimeNotIn(List<Date> values)
         {
              addCriterion("trade_end_time not in ", values, "trade_end_time");
              return (Criteria) this;
         }

         public Criteria andTradeEndTimeBetween(Date value1, Date value2)
         {
              addCriterion("trade_end_time between ", value1,value2, "trade_end_time");
              return (Criteria) this;
         }

         public Criteria andTradeEndTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("trade_end_time not between ", value1,value2, "trade_end_time");
              return (Criteria) this;
         }

         public Criteria andConvertNumsIsNull()
         {
              addCriterion("convert_nums is null");
              return (Criteria) this;
         }

         public Criteria andConvertNumsIsNotNull()
         {
              addCriterion("convert_nums is not null");
              return (Criteria) this;
         }

         public Criteria andConvertNumsEqualTo(String value)
         {
              addCriterion("convert_nums = ", value, "convert_nums");
              return (Criteria) this;
         }

         public Criteria andConvertNumsNotEqualTo(String value)
         {
              addCriterion("convert_nums <> ", value, "convert_nums");
              return (Criteria) this;
         }

         public Criteria andConvertNumsGreaterThan(String value)
         {
              addCriterion("convert_nums > ", value, "convert_nums");
              return (Criteria) this;
         }

         public Criteria andConvertNumsGreaterThanOrEqualTo(String value)
         {
              addCriterion("convert_nums >= ", value, "convert_nums");
              return (Criteria) this;
         }

         public Criteria andConvertNumsLessThan(String value)
         {
              addCriterion("convert_nums < ", value, "convert_nums");
              return (Criteria) this;
         }

         public Criteria andConvertNumsLessThanOrEqualTo(String value)
         {
              addCriterion("convert_nums <= ", value, "convert_nums");
              return (Criteria) this;
         }

         public Criteria andConvertNumsLike(String value)
         {
              addCriterion("convert_nums like ", value, "convert_nums");
              return (Criteria) this;
         }

         public Criteria andConvertNumsNotLike(String value)
         {
              addCriterion("convert_nums not like ", value, "convert_nums");
              return (Criteria) this;
         }

         public Criteria andConvertNumsIn(List<String> values)
         {
              addCriterion("convert_nums in ", values, "convert_nums");
              return (Criteria) this;
         }

         public Criteria andConvertNumsNotIn(List<String> values)
         {
              addCriterion("convert_nums not in ", values, "convert_nums");
              return (Criteria) this;
         }

         public Criteria andConvertNumsBetween(String value1, String value2)
         {
              addCriterion("convert_nums between ", value1,value2, "convert_nums");
              return (Criteria) this;
         }

         public Criteria andConvertNumsNotBetween(String value1, String value2)
         {
              addCriterion("convert_nums not between ", value1,value2, "convert_nums");
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
