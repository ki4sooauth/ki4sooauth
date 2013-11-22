package com.gooagoo.entity.generator.marketing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 规则表，为事件、吆喝、通知、邮件、短信、积分、优惠、发卡制定发布规则。此表为发布规则的索引信息，发布规则的详细信息参考n
 */

public class RuleInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public RuleInfoExample()
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

         public Criteria andRuleIdIsNull()
         {
              addCriterion("rule_id is null");
              return (Criteria) this;
         }

         public Criteria andRuleIdIsNotNull()
         {
              addCriterion("rule_id is not null");
              return (Criteria) this;
         }

         public Criteria andRuleIdEqualTo(String value)
         {
              addCriterion("rule_id = ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdNotEqualTo(String value)
         {
              addCriterion("rule_id <> ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdGreaterThan(String value)
         {
              addCriterion("rule_id > ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("rule_id >= ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdLessThan(String value)
         {
              addCriterion("rule_id < ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdLessThanOrEqualTo(String value)
         {
              addCriterion("rule_id <= ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdLike(String value)
         {
              addCriterion("rule_id like ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdNotLike(String value)
         {
              addCriterion("rule_id not like ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdIn(List<String> values)
         {
              addCriterion("rule_id in ", values, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdNotIn(List<String> values)
         {
              addCriterion("rule_id not in ", values, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdBetween(String value1, String value2)
         {
              addCriterion("rule_id between ", value1,value2, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdNotBetween(String value1, String value2)
         {
              addCriterion("rule_id not between ", value1,value2, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleNameIsNull()
         {
              addCriterion("rule_name is null");
              return (Criteria) this;
         }

         public Criteria andRuleNameIsNotNull()
         {
              addCriterion("rule_name is not null");
              return (Criteria) this;
         }

         public Criteria andRuleNameEqualTo(String value)
         {
              addCriterion("rule_name = ", value, "rule_name");
              return (Criteria) this;
         }

         public Criteria andRuleNameNotEqualTo(String value)
         {
              addCriterion("rule_name <> ", value, "rule_name");
              return (Criteria) this;
         }

         public Criteria andRuleNameGreaterThan(String value)
         {
              addCriterion("rule_name > ", value, "rule_name");
              return (Criteria) this;
         }

         public Criteria andRuleNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("rule_name >= ", value, "rule_name");
              return (Criteria) this;
         }

         public Criteria andRuleNameLessThan(String value)
         {
              addCriterion("rule_name < ", value, "rule_name");
              return (Criteria) this;
         }

         public Criteria andRuleNameLessThanOrEqualTo(String value)
         {
              addCriterion("rule_name <= ", value, "rule_name");
              return (Criteria) this;
         }

         public Criteria andRuleNameLike(String value)
         {
              addCriterion("rule_name like ", value, "rule_name");
              return (Criteria) this;
         }

         public Criteria andRuleNameNotLike(String value)
         {
              addCriterion("rule_name not like ", value, "rule_name");
              return (Criteria) this;
         }

         public Criteria andRuleNameIn(List<String> values)
         {
              addCriterion("rule_name in ", values, "rule_name");
              return (Criteria) this;
         }

         public Criteria andRuleNameNotIn(List<String> values)
         {
              addCriterion("rule_name not in ", values, "rule_name");
              return (Criteria) this;
         }

         public Criteria andRuleNameBetween(String value1, String value2)
         {
              addCriterion("rule_name between ", value1,value2, "rule_name");
              return (Criteria) this;
         }

         public Criteria andRuleNameNotBetween(String value1, String value2)
         {
              addCriterion("rule_name not between ", value1,value2, "rule_name");
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

         public Criteria andActivityIdIsNull()
         {
              addCriterion("activity_id is null");
              return (Criteria) this;
         }

         public Criteria andActivityIdIsNotNull()
         {
              addCriterion("activity_id is not null");
              return (Criteria) this;
         }

         public Criteria andActivityIdEqualTo(String value)
         {
              addCriterion("activity_id = ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdNotEqualTo(String value)
         {
              addCriterion("activity_id <> ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdGreaterThan(String value)
         {
              addCriterion("activity_id > ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("activity_id >= ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdLessThan(String value)
         {
              addCriterion("activity_id < ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdLessThanOrEqualTo(String value)
         {
              addCriterion("activity_id <= ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdLike(String value)
         {
              addCriterion("activity_id like ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdNotLike(String value)
         {
              addCriterion("activity_id not like ", value, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdIn(List<String> values)
         {
              addCriterion("activity_id in ", values, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdNotIn(List<String> values)
         {
              addCriterion("activity_id not in ", values, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdBetween(String value1, String value2)
         {
              addCriterion("activity_id between ", value1,value2, "activity_id");
              return (Criteria) this;
         }

         public Criteria andActivityIdNotBetween(String value1, String value2)
         {
              addCriterion("activity_id not between ", value1,value2, "activity_id");
              return (Criteria) this;
         }

         public Criteria andRuleTypeIsNull()
         {
              addCriterion("rule_type is null");
              return (Criteria) this;
         }

         public Criteria andRuleTypeIsNotNull()
         {
              addCriterion("rule_type is not null");
              return (Criteria) this;
         }

         public Criteria andRuleTypeEqualTo(String value)
         {
              addCriterion("rule_type = ", value, "rule_type");
              return (Criteria) this;
         }

         public Criteria andRuleTypeNotEqualTo(String value)
         {
              addCriterion("rule_type <> ", value, "rule_type");
              return (Criteria) this;
         }

         public Criteria andRuleTypeGreaterThan(String value)
         {
              addCriterion("rule_type > ", value, "rule_type");
              return (Criteria) this;
         }

         public Criteria andRuleTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("rule_type >= ", value, "rule_type");
              return (Criteria) this;
         }

         public Criteria andRuleTypeLessThan(String value)
         {
              addCriterion("rule_type < ", value, "rule_type");
              return (Criteria) this;
         }

         public Criteria andRuleTypeLessThanOrEqualTo(String value)
         {
              addCriterion("rule_type <= ", value, "rule_type");
              return (Criteria) this;
         }

         public Criteria andRuleTypeLike(String value)
         {
              addCriterion("rule_type like ", value, "rule_type");
              return (Criteria) this;
         }

         public Criteria andRuleTypeNotLike(String value)
         {
              addCriterion("rule_type not like ", value, "rule_type");
              return (Criteria) this;
         }

         public Criteria andRuleTypeIn(List<String> values)
         {
              addCriterion("rule_type in ", values, "rule_type");
              return (Criteria) this;
         }

         public Criteria andRuleTypeNotIn(List<String> values)
         {
              addCriterion("rule_type not in ", values, "rule_type");
              return (Criteria) this;
         }

         public Criteria andRuleTypeBetween(String value1, String value2)
         {
              addCriterion("rule_type between ", value1,value2, "rule_type");
              return (Criteria) this;
         }

         public Criteria andRuleTypeNotBetween(String value1, String value2)
         {
              addCriterion("rule_type not between ", value1,value2, "rule_type");
              return (Criteria) this;
         }

         public Criteria andRuleActiveTypeIsNull()
         {
              addCriterion("rule_active_type is null");
              return (Criteria) this;
         }

         public Criteria andRuleActiveTypeIsNotNull()
         {
              addCriterion("rule_active_type is not null");
              return (Criteria) this;
         }

         public Criteria andRuleActiveTypeEqualTo(String value)
         {
              addCriterion("rule_active_type = ", value, "rule_active_type");
              return (Criteria) this;
         }

         public Criteria andRuleActiveTypeNotEqualTo(String value)
         {
              addCriterion("rule_active_type <> ", value, "rule_active_type");
              return (Criteria) this;
         }

         public Criteria andRuleActiveTypeGreaterThan(String value)
         {
              addCriterion("rule_active_type > ", value, "rule_active_type");
              return (Criteria) this;
         }

         public Criteria andRuleActiveTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("rule_active_type >= ", value, "rule_active_type");
              return (Criteria) this;
         }

         public Criteria andRuleActiveTypeLessThan(String value)
         {
              addCriterion("rule_active_type < ", value, "rule_active_type");
              return (Criteria) this;
         }

         public Criteria andRuleActiveTypeLessThanOrEqualTo(String value)
         {
              addCriterion("rule_active_type <= ", value, "rule_active_type");
              return (Criteria) this;
         }

         public Criteria andRuleActiveTypeLike(String value)
         {
              addCriterion("rule_active_type like ", value, "rule_active_type");
              return (Criteria) this;
         }

         public Criteria andRuleActiveTypeNotLike(String value)
         {
              addCriterion("rule_active_type not like ", value, "rule_active_type");
              return (Criteria) this;
         }

         public Criteria andRuleActiveTypeIn(List<String> values)
         {
              addCriterion("rule_active_type in ", values, "rule_active_type");
              return (Criteria) this;
         }

         public Criteria andRuleActiveTypeNotIn(List<String> values)
         {
              addCriterion("rule_active_type not in ", values, "rule_active_type");
              return (Criteria) this;
         }

         public Criteria andRuleActiveTypeBetween(String value1, String value2)
         {
              addCriterion("rule_active_type between ", value1,value2, "rule_active_type");
              return (Criteria) this;
         }

         public Criteria andRuleActiveTypeNotBetween(String value1, String value2)
         {
              addCriterion("rule_active_type not between ", value1,value2, "rule_active_type");
              return (Criteria) this;
         }

         public Criteria andObjectIdIsNull()
         {
              addCriterion("object_id is null");
              return (Criteria) this;
         }

         public Criteria andObjectIdIsNotNull()
         {
              addCriterion("object_id is not null");
              return (Criteria) this;
         }

         public Criteria andObjectIdEqualTo(String value)
         {
              addCriterion("object_id = ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdNotEqualTo(String value)
         {
              addCriterion("object_id <> ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdGreaterThan(String value)
         {
              addCriterion("object_id > ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("object_id >= ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdLessThan(String value)
         {
              addCriterion("object_id < ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdLessThanOrEqualTo(String value)
         {
              addCriterion("object_id <= ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdLike(String value)
         {
              addCriterion("object_id like ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdNotLike(String value)
         {
              addCriterion("object_id not like ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdIn(List<String> values)
         {
              addCriterion("object_id in ", values, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdNotIn(List<String> values)
         {
              addCriterion("object_id not in ", values, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdBetween(String value1, String value2)
         {
              addCriterion("object_id between ", value1,value2, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdNotBetween(String value1, String value2)
         {
              addCriterion("object_id not between ", value1,value2, "object_id");
              return (Criteria) this;
         }

         public Criteria andIsActiveForeverIsNull()
         {
              addCriterion("is_active_forever is null");
              return (Criteria) this;
         }

         public Criteria andIsActiveForeverIsNotNull()
         {
              addCriterion("is_active_forever is not null");
              return (Criteria) this;
         }

         public Criteria andIsActiveForeverEqualTo(String value)
         {
              addCriterion("is_active_forever = ", value, "is_active_forever");
              return (Criteria) this;
         }

         public Criteria andIsActiveForeverNotEqualTo(String value)
         {
              addCriterion("is_active_forever <> ", value, "is_active_forever");
              return (Criteria) this;
         }

         public Criteria andIsActiveForeverGreaterThan(String value)
         {
              addCriterion("is_active_forever > ", value, "is_active_forever");
              return (Criteria) this;
         }

         public Criteria andIsActiveForeverGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_active_forever >= ", value, "is_active_forever");
              return (Criteria) this;
         }

         public Criteria andIsActiveForeverLessThan(String value)
         {
              addCriterion("is_active_forever < ", value, "is_active_forever");
              return (Criteria) this;
         }

         public Criteria andIsActiveForeverLessThanOrEqualTo(String value)
         {
              addCriterion("is_active_forever <= ", value, "is_active_forever");
              return (Criteria) this;
         }

         public Criteria andIsActiveForeverLike(String value)
         {
              addCriterion("is_active_forever like ", value, "is_active_forever");
              return (Criteria) this;
         }

         public Criteria andIsActiveForeverNotLike(String value)
         {
              addCriterion("is_active_forever not like ", value, "is_active_forever");
              return (Criteria) this;
         }

         public Criteria andIsActiveForeverIn(List<String> values)
         {
              addCriterion("is_active_forever in ", values, "is_active_forever");
              return (Criteria) this;
         }

         public Criteria andIsActiveForeverNotIn(List<String> values)
         {
              addCriterion("is_active_forever not in ", values, "is_active_forever");
              return (Criteria) this;
         }

         public Criteria andIsActiveForeverBetween(String value1, String value2)
         {
              addCriterion("is_active_forever between ", value1,value2, "is_active_forever");
              return (Criteria) this;
         }

         public Criteria andIsActiveForeverNotBetween(String value1, String value2)
         {
              addCriterion("is_active_forever not between ", value1,value2, "is_active_forever");
              return (Criteria) this;
         }

         public Criteria andStartTimeIsNull()
         {
              addCriterion("start_time is null");
              return (Criteria) this;
         }

         public Criteria andStartTimeIsNotNull()
         {
              addCriterion("start_time is not null");
              return (Criteria) this;
         }

         public Criteria andStartTimeEqualTo(Date value)
         {
              addCriterion("start_time = ", value, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeNotEqualTo(Date value)
         {
              addCriterion("start_time <> ", value, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeGreaterThan(Date value)
         {
              addCriterion("start_time > ", value, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("start_time >= ", value, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeLessThan(Date value)
         {
              addCriterion("start_time < ", value, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("start_time <= ", value, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeIn(List<Date> values)
         {
              addCriterion("start_time in ", values, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeNotIn(List<Date> values)
         {
              addCriterion("start_time not in ", values, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeBetween(Date value1, Date value2)
         {
              addCriterion("start_time between ", value1,value2, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("start_time not between ", value1,value2, "start_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeIsNull()
         {
              addCriterion("end_time is null");
              return (Criteria) this;
         }

         public Criteria andEndTimeIsNotNull()
         {
              addCriterion("end_time is not null");
              return (Criteria) this;
         }

         public Criteria andEndTimeEqualTo(Date value)
         {
              addCriterion("end_time = ", value, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeNotEqualTo(Date value)
         {
              addCriterion("end_time <> ", value, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeGreaterThan(Date value)
         {
              addCriterion("end_time > ", value, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("end_time >= ", value, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeLessThan(Date value)
         {
              addCriterion("end_time < ", value, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("end_time <= ", value, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeIn(List<Date> values)
         {
              addCriterion("end_time in ", values, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeNotIn(List<Date> values)
         {
              addCriterion("end_time not in ", values, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeBetween(Date value1, Date value2)
         {
              addCriterion("end_time between ", value1,value2, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("end_time not between ", value1,value2, "end_time");
              return (Criteria) this;
         }

         public Criteria andCrowdTypeIsNull()
         {
              addCriterion("crowd_type is null");
              return (Criteria) this;
         }

         public Criteria andCrowdTypeIsNotNull()
         {
              addCriterion("crowd_type is not null");
              return (Criteria) this;
         }

         public Criteria andCrowdTypeEqualTo(String value)
         {
              addCriterion("crowd_type = ", value, "crowd_type");
              return (Criteria) this;
         }

         public Criteria andCrowdTypeNotEqualTo(String value)
         {
              addCriterion("crowd_type <> ", value, "crowd_type");
              return (Criteria) this;
         }

         public Criteria andCrowdTypeGreaterThan(String value)
         {
              addCriterion("crowd_type > ", value, "crowd_type");
              return (Criteria) this;
         }

         public Criteria andCrowdTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("crowd_type >= ", value, "crowd_type");
              return (Criteria) this;
         }

         public Criteria andCrowdTypeLessThan(String value)
         {
              addCriterion("crowd_type < ", value, "crowd_type");
              return (Criteria) this;
         }

         public Criteria andCrowdTypeLessThanOrEqualTo(String value)
         {
              addCriterion("crowd_type <= ", value, "crowd_type");
              return (Criteria) this;
         }

         public Criteria andCrowdTypeLike(String value)
         {
              addCriterion("crowd_type like ", value, "crowd_type");
              return (Criteria) this;
         }

         public Criteria andCrowdTypeNotLike(String value)
         {
              addCriterion("crowd_type not like ", value, "crowd_type");
              return (Criteria) this;
         }

         public Criteria andCrowdTypeIn(List<String> values)
         {
              addCriterion("crowd_type in ", values, "crowd_type");
              return (Criteria) this;
         }

         public Criteria andCrowdTypeNotIn(List<String> values)
         {
              addCriterion("crowd_type not in ", values, "crowd_type");
              return (Criteria) this;
         }

         public Criteria andCrowdTypeBetween(String value1, String value2)
         {
              addCriterion("crowd_type between ", value1,value2, "crowd_type");
              return (Criteria) this;
         }

         public Criteria andCrowdTypeNotBetween(String value1, String value2)
         {
              addCriterion("crowd_type not between ", value1,value2, "crowd_type");
              return (Criteria) this;
         }

         public Criteria andIsPublishImmediatelyIsNull()
         {
              addCriterion("is_publish_immediately is null");
              return (Criteria) this;
         }

         public Criteria andIsPublishImmediatelyIsNotNull()
         {
              addCriterion("is_publish_immediately is not null");
              return (Criteria) this;
         }

         public Criteria andIsPublishImmediatelyEqualTo(String value)
         {
              addCriterion("is_publish_immediately = ", value, "is_publish_immediately");
              return (Criteria) this;
         }

         public Criteria andIsPublishImmediatelyNotEqualTo(String value)
         {
              addCriterion("is_publish_immediately <> ", value, "is_publish_immediately");
              return (Criteria) this;
         }

         public Criteria andIsPublishImmediatelyGreaterThan(String value)
         {
              addCriterion("is_publish_immediately > ", value, "is_publish_immediately");
              return (Criteria) this;
         }

         public Criteria andIsPublishImmediatelyGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_publish_immediately >= ", value, "is_publish_immediately");
              return (Criteria) this;
         }

         public Criteria andIsPublishImmediatelyLessThan(String value)
         {
              addCriterion("is_publish_immediately < ", value, "is_publish_immediately");
              return (Criteria) this;
         }

         public Criteria andIsPublishImmediatelyLessThanOrEqualTo(String value)
         {
              addCriterion("is_publish_immediately <= ", value, "is_publish_immediately");
              return (Criteria) this;
         }

         public Criteria andIsPublishImmediatelyLike(String value)
         {
              addCriterion("is_publish_immediately like ", value, "is_publish_immediately");
              return (Criteria) this;
         }

         public Criteria andIsPublishImmediatelyNotLike(String value)
         {
              addCriterion("is_publish_immediately not like ", value, "is_publish_immediately");
              return (Criteria) this;
         }

         public Criteria andIsPublishImmediatelyIn(List<String> values)
         {
              addCriterion("is_publish_immediately in ", values, "is_publish_immediately");
              return (Criteria) this;
         }

         public Criteria andIsPublishImmediatelyNotIn(List<String> values)
         {
              addCriterion("is_publish_immediately not in ", values, "is_publish_immediately");
              return (Criteria) this;
         }

         public Criteria andIsPublishImmediatelyBetween(String value1, String value2)
         {
              addCriterion("is_publish_immediately between ", value1,value2, "is_publish_immediately");
              return (Criteria) this;
         }

         public Criteria andIsPublishImmediatelyNotBetween(String value1, String value2)
         {
              addCriterion("is_publish_immediately not between ", value1,value2, "is_publish_immediately");
              return (Criteria) this;
         }

         public Criteria andExpectPublishTimeIsNull()
         {
              addCriterion("expect_publish_time is null");
              return (Criteria) this;
         }

         public Criteria andExpectPublishTimeIsNotNull()
         {
              addCriterion("expect_publish_time is not null");
              return (Criteria) this;
         }

         public Criteria andExpectPublishTimeEqualTo(Date value)
         {
              addCriterion("expect_publish_time = ", value, "expect_publish_time");
              return (Criteria) this;
         }

         public Criteria andExpectPublishTimeNotEqualTo(Date value)
         {
              addCriterion("expect_publish_time <> ", value, "expect_publish_time");
              return (Criteria) this;
         }

         public Criteria andExpectPublishTimeGreaterThan(Date value)
         {
              addCriterion("expect_publish_time > ", value, "expect_publish_time");
              return (Criteria) this;
         }

         public Criteria andExpectPublishTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("expect_publish_time >= ", value, "expect_publish_time");
              return (Criteria) this;
         }

         public Criteria andExpectPublishTimeLessThan(Date value)
         {
              addCriterion("expect_publish_time < ", value, "expect_publish_time");
              return (Criteria) this;
         }

         public Criteria andExpectPublishTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("expect_publish_time <= ", value, "expect_publish_time");
              return (Criteria) this;
         }

         public Criteria andExpectPublishTimeIn(List<Date> values)
         {
              addCriterion("expect_publish_time in ", values, "expect_publish_time");
              return (Criteria) this;
         }

         public Criteria andExpectPublishTimeNotIn(List<Date> values)
         {
              addCriterion("expect_publish_time not in ", values, "expect_publish_time");
              return (Criteria) this;
         }

         public Criteria andExpectPublishTimeBetween(Date value1, Date value2)
         {
              addCriterion("expect_publish_time between ", value1,value2, "expect_publish_time");
              return (Criteria) this;
         }

         public Criteria andExpectPublishTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("expect_publish_time not between ", value1,value2, "expect_publish_time");
              return (Criteria) this;
         }

         public Criteria andActualPublishTimeIsNull()
         {
              addCriterion("actual_publish_time is null");
              return (Criteria) this;
         }

         public Criteria andActualPublishTimeIsNotNull()
         {
              addCriterion("actual_publish_time is not null");
              return (Criteria) this;
         }

         public Criteria andActualPublishTimeEqualTo(Date value)
         {
              addCriterion("actual_publish_time = ", value, "actual_publish_time");
              return (Criteria) this;
         }

         public Criteria andActualPublishTimeNotEqualTo(Date value)
         {
              addCriterion("actual_publish_time <> ", value, "actual_publish_time");
              return (Criteria) this;
         }

         public Criteria andActualPublishTimeGreaterThan(Date value)
         {
              addCriterion("actual_publish_time > ", value, "actual_publish_time");
              return (Criteria) this;
         }

         public Criteria andActualPublishTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("actual_publish_time >= ", value, "actual_publish_time");
              return (Criteria) this;
         }

         public Criteria andActualPublishTimeLessThan(Date value)
         {
              addCriterion("actual_publish_time < ", value, "actual_publish_time");
              return (Criteria) this;
         }

         public Criteria andActualPublishTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("actual_publish_time <= ", value, "actual_publish_time");
              return (Criteria) this;
         }

         public Criteria andActualPublishTimeIn(List<Date> values)
         {
              addCriterion("actual_publish_time in ", values, "actual_publish_time");
              return (Criteria) this;
         }

         public Criteria andActualPublishTimeNotIn(List<Date> values)
         {
              addCriterion("actual_publish_time not in ", values, "actual_publish_time");
              return (Criteria) this;
         }

         public Criteria andActualPublishTimeBetween(Date value1, Date value2)
         {
              addCriterion("actual_publish_time between ", value1,value2, "actual_publish_time");
              return (Criteria) this;
         }

         public Criteria andActualPublishTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("actual_publish_time not between ", value1,value2, "actual_publish_time");
              return (Criteria) this;
         }

         public Criteria andRuleContentIsNull()
         {
              addCriterion("rule_content is null");
              return (Criteria) this;
         }

         public Criteria andRuleContentIsNotNull()
         {
              addCriterion("rule_content is not null");
              return (Criteria) this;
         }

         public Criteria andRuleContentEqualTo(String value)
         {
              addCriterion("rule_content = ", value, "rule_content");
              return (Criteria) this;
         }

         public Criteria andRuleContentNotEqualTo(String value)
         {
              addCriterion("rule_content <> ", value, "rule_content");
              return (Criteria) this;
         }

         public Criteria andRuleContentGreaterThan(String value)
         {
              addCriterion("rule_content > ", value, "rule_content");
              return (Criteria) this;
         }

         public Criteria andRuleContentGreaterThanOrEqualTo(String value)
         {
              addCriterion("rule_content >= ", value, "rule_content");
              return (Criteria) this;
         }

         public Criteria andRuleContentLessThan(String value)
         {
              addCriterion("rule_content < ", value, "rule_content");
              return (Criteria) this;
         }

         public Criteria andRuleContentLessThanOrEqualTo(String value)
         {
              addCriterion("rule_content <= ", value, "rule_content");
              return (Criteria) this;
         }

         public Criteria andRuleContentLike(String value)
         {
              addCriterion("rule_content like ", value, "rule_content");
              return (Criteria) this;
         }

         public Criteria andRuleContentNotLike(String value)
         {
              addCriterion("rule_content not like ", value, "rule_content");
              return (Criteria) this;
         }

         public Criteria andRuleContentIn(List<String> values)
         {
              addCriterion("rule_content in ", values, "rule_content");
              return (Criteria) this;
         }

         public Criteria andRuleContentNotIn(List<String> values)
         {
              addCriterion("rule_content not in ", values, "rule_content");
              return (Criteria) this;
         }

         public Criteria andRuleContentBetween(String value1, String value2)
         {
              addCriterion("rule_content between ", value1,value2, "rule_content");
              return (Criteria) this;
         }

         public Criteria andRuleContentNotBetween(String value1, String value2)
         {
              addCriterion("rule_content not between ", value1,value2, "rule_content");
              return (Criteria) this;
         }

         public Criteria andPublishStatusIsNull()
         {
              addCriterion("publish_status is null");
              return (Criteria) this;
         }

         public Criteria andPublishStatusIsNotNull()
         {
              addCriterion("publish_status is not null");
              return (Criteria) this;
         }

         public Criteria andPublishStatusEqualTo(String value)
         {
              addCriterion("publish_status = ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusNotEqualTo(String value)
         {
              addCriterion("publish_status <> ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusGreaterThan(String value)
         {
              addCriterion("publish_status > ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusGreaterThanOrEqualTo(String value)
         {
              addCriterion("publish_status >= ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusLessThan(String value)
         {
              addCriterion("publish_status < ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusLessThanOrEqualTo(String value)
         {
              addCriterion("publish_status <= ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusLike(String value)
         {
              addCriterion("publish_status like ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusNotLike(String value)
         {
              addCriterion("publish_status not like ", value, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusIn(List<String> values)
         {
              addCriterion("publish_status in ", values, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusNotIn(List<String> values)
         {
              addCriterion("publish_status not in ", values, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusBetween(String value1, String value2)
         {
              addCriterion("publish_status between ", value1,value2, "publish_status");
              return (Criteria) this;
         }

         public Criteria andPublishStatusNotBetween(String value1, String value2)
         {
              addCriterion("publish_status not between ", value1,value2, "publish_status");
              return (Criteria) this;
         }

         public Criteria andAuditNoteIsNull()
         {
              addCriterion("audit_note is null");
              return (Criteria) this;
         }

         public Criteria andAuditNoteIsNotNull()
         {
              addCriterion("audit_note is not null");
              return (Criteria) this;
         }

         public Criteria andAuditNoteEqualTo(String value)
         {
              addCriterion("audit_note = ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteNotEqualTo(String value)
         {
              addCriterion("audit_note <> ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteGreaterThan(String value)
         {
              addCriterion("audit_note > ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteGreaterThanOrEqualTo(String value)
         {
              addCriterion("audit_note >= ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteLessThan(String value)
         {
              addCriterion("audit_note < ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteLessThanOrEqualTo(String value)
         {
              addCriterion("audit_note <= ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteLike(String value)
         {
              addCriterion("audit_note like ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteNotLike(String value)
         {
              addCriterion("audit_note not like ", value, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteIn(List<String> values)
         {
              addCriterion("audit_note in ", values, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteNotIn(List<String> values)
         {
              addCriterion("audit_note not in ", values, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteBetween(String value1, String value2)
         {
              addCriterion("audit_note between ", value1,value2, "audit_note");
              return (Criteria) this;
         }

         public Criteria andAuditNoteNotBetween(String value1, String value2)
         {
              addCriterion("audit_note not between ", value1,value2, "audit_note");
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
