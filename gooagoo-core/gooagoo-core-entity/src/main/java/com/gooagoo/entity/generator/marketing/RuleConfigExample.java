package com.gooagoo.entity.generator.marketing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 规则配置表
 */

public class RuleConfigExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public RuleConfigExample()
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

         public Criteria andIdIsNull()
         {
              addCriterion("id is null");
              return (Criteria) this;
         }

         public Criteria andIdIsNotNull()
         {
              addCriterion("id is not null");
              return (Criteria) this;
         }

         public Criteria andIdEqualTo(String value)
         {
              addCriterion("id = ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdNotEqualTo(String value)
         {
              addCriterion("id <> ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdGreaterThan(String value)
         {
              addCriterion("id > ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("id >= ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdLessThan(String value)
         {
              addCriterion("id < ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdLessThanOrEqualTo(String value)
         {
              addCriterion("id <= ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdLike(String value)
         {
              addCriterion("id like ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdNotLike(String value)
         {
              addCriterion("id not like ", value, "id");
              return (Criteria) this;
         }

         public Criteria andIdIn(List<String> values)
         {
              addCriterion("id in ", values, "id");
              return (Criteria) this;
         }

         public Criteria andIdNotIn(List<String> values)
         {
              addCriterion("id not in ", values, "id");
              return (Criteria) this;
         }

         public Criteria andIdBetween(String value1, String value2)
         {
              addCriterion("id between ", value1,value2, "id");
              return (Criteria) this;
         }

         public Criteria andIdNotBetween(String value1, String value2)
         {
              addCriterion("id not between ", value1,value2, "id");
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

         public Criteria andBehaveTypeIsNull()
         {
              addCriterion("behave_type is null");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeIsNotNull()
         {
              addCriterion("behave_type is not null");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeEqualTo(String value)
         {
              addCriterion("behave_type = ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeNotEqualTo(String value)
         {
              addCriterion("behave_type <> ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeGreaterThan(String value)
         {
              addCriterion("behave_type > ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("behave_type >= ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeLessThan(String value)
         {
              addCriterion("behave_type < ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeLessThanOrEqualTo(String value)
         {
              addCriterion("behave_type <= ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeLike(String value)
         {
              addCriterion("behave_type like ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeNotLike(String value)
         {
              addCriterion("behave_type not like ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeIn(List<String> values)
         {
              addCriterion("behave_type in ", values, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeNotIn(List<String> values)
         {
              addCriterion("behave_type not in ", values, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeBetween(String value1, String value2)
         {
              addCriterion("behave_type between ", value1,value2, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeNotBetween(String value1, String value2)
         {
              addCriterion("behave_type not between ", value1,value2, "behave_type");
              return (Criteria) this;
         }

         public Criteria andIsShowDateScopeIsNull()
         {
              addCriterion("is_show_date_scope is null");
              return (Criteria) this;
         }

         public Criteria andIsShowDateScopeIsNotNull()
         {
              addCriterion("is_show_date_scope is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowDateScopeEqualTo(String value)
         {
              addCriterion("is_show_date_scope = ", value, "is_show_date_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowDateScopeNotEqualTo(String value)
         {
              addCriterion("is_show_date_scope <> ", value, "is_show_date_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowDateScopeGreaterThan(String value)
         {
              addCriterion("is_show_date_scope > ", value, "is_show_date_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowDateScopeGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_date_scope >= ", value, "is_show_date_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowDateScopeLessThan(String value)
         {
              addCriterion("is_show_date_scope < ", value, "is_show_date_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowDateScopeLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_date_scope <= ", value, "is_show_date_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowDateScopeLike(String value)
         {
              addCriterion("is_show_date_scope like ", value, "is_show_date_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowDateScopeNotLike(String value)
         {
              addCriterion("is_show_date_scope not like ", value, "is_show_date_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowDateScopeIn(List<String> values)
         {
              addCriterion("is_show_date_scope in ", values, "is_show_date_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowDateScopeNotIn(List<String> values)
         {
              addCriterion("is_show_date_scope not in ", values, "is_show_date_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowDateScopeBetween(String value1, String value2)
         {
              addCriterion("is_show_date_scope between ", value1,value2, "is_show_date_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowDateScopeNotBetween(String value1, String value2)
         {
              addCriterion("is_show_date_scope not between ", value1,value2, "is_show_date_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowWeekScopeIsNull()
         {
              addCriterion("is_show_week_scope is null");
              return (Criteria) this;
         }

         public Criteria andIsShowWeekScopeIsNotNull()
         {
              addCriterion("is_show_week_scope is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowWeekScopeEqualTo(String value)
         {
              addCriterion("is_show_week_scope = ", value, "is_show_week_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowWeekScopeNotEqualTo(String value)
         {
              addCriterion("is_show_week_scope <> ", value, "is_show_week_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowWeekScopeGreaterThan(String value)
         {
              addCriterion("is_show_week_scope > ", value, "is_show_week_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowWeekScopeGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_week_scope >= ", value, "is_show_week_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowWeekScopeLessThan(String value)
         {
              addCriterion("is_show_week_scope < ", value, "is_show_week_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowWeekScopeLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_week_scope <= ", value, "is_show_week_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowWeekScopeLike(String value)
         {
              addCriterion("is_show_week_scope like ", value, "is_show_week_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowWeekScopeNotLike(String value)
         {
              addCriterion("is_show_week_scope not like ", value, "is_show_week_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowWeekScopeIn(List<String> values)
         {
              addCriterion("is_show_week_scope in ", values, "is_show_week_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowWeekScopeNotIn(List<String> values)
         {
              addCriterion("is_show_week_scope not in ", values, "is_show_week_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowWeekScopeBetween(String value1, String value2)
         {
              addCriterion("is_show_week_scope between ", value1,value2, "is_show_week_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowWeekScopeNotBetween(String value1, String value2)
         {
              addCriterion("is_show_week_scope not between ", value1,value2, "is_show_week_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeScopeIsNull()
         {
              addCriterion("is_show_time_scope is null");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeScopeIsNotNull()
         {
              addCriterion("is_show_time_scope is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeScopeEqualTo(String value)
         {
              addCriterion("is_show_time_scope = ", value, "is_show_time_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeScopeNotEqualTo(String value)
         {
              addCriterion("is_show_time_scope <> ", value, "is_show_time_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeScopeGreaterThan(String value)
         {
              addCriterion("is_show_time_scope > ", value, "is_show_time_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeScopeGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_time_scope >= ", value, "is_show_time_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeScopeLessThan(String value)
         {
              addCriterion("is_show_time_scope < ", value, "is_show_time_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeScopeLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_time_scope <= ", value, "is_show_time_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeScopeLike(String value)
         {
              addCriterion("is_show_time_scope like ", value, "is_show_time_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeScopeNotLike(String value)
         {
              addCriterion("is_show_time_scope not like ", value, "is_show_time_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeScopeIn(List<String> values)
         {
              addCriterion("is_show_time_scope in ", values, "is_show_time_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeScopeNotIn(List<String> values)
         {
              addCriterion("is_show_time_scope not in ", values, "is_show_time_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeScopeBetween(String value1, String value2)
         {
              addCriterion("is_show_time_scope between ", value1,value2, "is_show_time_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeScopeNotBetween(String value1, String value2)
         {
              addCriterion("is_show_time_scope not between ", value1,value2, "is_show_time_scope");
              return (Criteria) this;
         }

         public Criteria andIsShowVipGradeIsNull()
         {
              addCriterion("is_show_vip_grade is null");
              return (Criteria) this;
         }

         public Criteria andIsShowVipGradeIsNotNull()
         {
              addCriterion("is_show_vip_grade is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowVipGradeEqualTo(String value)
         {
              addCriterion("is_show_vip_grade = ", value, "is_show_vip_grade");
              return (Criteria) this;
         }

         public Criteria andIsShowVipGradeNotEqualTo(String value)
         {
              addCriterion("is_show_vip_grade <> ", value, "is_show_vip_grade");
              return (Criteria) this;
         }

         public Criteria andIsShowVipGradeGreaterThan(String value)
         {
              addCriterion("is_show_vip_grade > ", value, "is_show_vip_grade");
              return (Criteria) this;
         }

         public Criteria andIsShowVipGradeGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_vip_grade >= ", value, "is_show_vip_grade");
              return (Criteria) this;
         }

         public Criteria andIsShowVipGradeLessThan(String value)
         {
              addCriterion("is_show_vip_grade < ", value, "is_show_vip_grade");
              return (Criteria) this;
         }

         public Criteria andIsShowVipGradeLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_vip_grade <= ", value, "is_show_vip_grade");
              return (Criteria) this;
         }

         public Criteria andIsShowVipGradeLike(String value)
         {
              addCriterion("is_show_vip_grade like ", value, "is_show_vip_grade");
              return (Criteria) this;
         }

         public Criteria andIsShowVipGradeNotLike(String value)
         {
              addCriterion("is_show_vip_grade not like ", value, "is_show_vip_grade");
              return (Criteria) this;
         }

         public Criteria andIsShowVipGradeIn(List<String> values)
         {
              addCriterion("is_show_vip_grade in ", values, "is_show_vip_grade");
              return (Criteria) this;
         }

         public Criteria andIsShowVipGradeNotIn(List<String> values)
         {
              addCriterion("is_show_vip_grade not in ", values, "is_show_vip_grade");
              return (Criteria) this;
         }

         public Criteria andIsShowVipGradeBetween(String value1, String value2)
         {
              addCriterion("is_show_vip_grade between ", value1,value2, "is_show_vip_grade");
              return (Criteria) this;
         }

         public Criteria andIsShowVipGradeNotBetween(String value1, String value2)
         {
              addCriterion("is_show_vip_grade not between ", value1,value2, "is_show_vip_grade");
              return (Criteria) this;
         }

         public Criteria andIsShowActionSourceIsNull()
         {
              addCriterion("is_show_action_source is null");
              return (Criteria) this;
         }

         public Criteria andIsShowActionSourceIsNotNull()
         {
              addCriterion("is_show_action_source is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowActionSourceEqualTo(String value)
         {
              addCriterion("is_show_action_source = ", value, "is_show_action_source");
              return (Criteria) this;
         }

         public Criteria andIsShowActionSourceNotEqualTo(String value)
         {
              addCriterion("is_show_action_source <> ", value, "is_show_action_source");
              return (Criteria) this;
         }

         public Criteria andIsShowActionSourceGreaterThan(String value)
         {
              addCriterion("is_show_action_source > ", value, "is_show_action_source");
              return (Criteria) this;
         }

         public Criteria andIsShowActionSourceGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_action_source >= ", value, "is_show_action_source");
              return (Criteria) this;
         }

         public Criteria andIsShowActionSourceLessThan(String value)
         {
              addCriterion("is_show_action_source < ", value, "is_show_action_source");
              return (Criteria) this;
         }

         public Criteria andIsShowActionSourceLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_action_source <= ", value, "is_show_action_source");
              return (Criteria) this;
         }

         public Criteria andIsShowActionSourceLike(String value)
         {
              addCriterion("is_show_action_source like ", value, "is_show_action_source");
              return (Criteria) this;
         }

         public Criteria andIsShowActionSourceNotLike(String value)
         {
              addCriterion("is_show_action_source not like ", value, "is_show_action_source");
              return (Criteria) this;
         }

         public Criteria andIsShowActionSourceIn(List<String> values)
         {
              addCriterion("is_show_action_source in ", values, "is_show_action_source");
              return (Criteria) this;
         }

         public Criteria andIsShowActionSourceNotIn(List<String> values)
         {
              addCriterion("is_show_action_source not in ", values, "is_show_action_source");
              return (Criteria) this;
         }

         public Criteria andIsShowActionSourceBetween(String value1, String value2)
         {
              addCriterion("is_show_action_source between ", value1,value2, "is_show_action_source");
              return (Criteria) this;
         }

         public Criteria andIsShowActionSourceNotBetween(String value1, String value2)
         {
              addCriterion("is_show_action_source not between ", value1,value2, "is_show_action_source");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeIsNull()
         {
              addCriterion("is_show_time is null");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeIsNotNull()
         {
              addCriterion("is_show_time is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeEqualTo(String value)
         {
              addCriterion("is_show_time = ", value, "is_show_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeNotEqualTo(String value)
         {
              addCriterion("is_show_time <> ", value, "is_show_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeGreaterThan(String value)
         {
              addCriterion("is_show_time > ", value, "is_show_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_time >= ", value, "is_show_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeLessThan(String value)
         {
              addCriterion("is_show_time < ", value, "is_show_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_time <= ", value, "is_show_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeLike(String value)
         {
              addCriterion("is_show_time like ", value, "is_show_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeNotLike(String value)
         {
              addCriterion("is_show_time not like ", value, "is_show_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeIn(List<String> values)
         {
              addCriterion("is_show_time in ", values, "is_show_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeNotIn(List<String> values)
         {
              addCriterion("is_show_time not in ", values, "is_show_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeBetween(String value1, String value2)
         {
              addCriterion("is_show_time between ", value1,value2, "is_show_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTimeNotBetween(String value1, String value2)
         {
              addCriterion("is_show_time not between ", value1,value2, "is_show_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTotalTimeIsNull()
         {
              addCriterion("is_show_total_time is null");
              return (Criteria) this;
         }

         public Criteria andIsShowTotalTimeIsNotNull()
         {
              addCriterion("is_show_total_time is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowTotalTimeEqualTo(String value)
         {
              addCriterion("is_show_total_time = ", value, "is_show_total_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTotalTimeNotEqualTo(String value)
         {
              addCriterion("is_show_total_time <> ", value, "is_show_total_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTotalTimeGreaterThan(String value)
         {
              addCriterion("is_show_total_time > ", value, "is_show_total_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTotalTimeGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_total_time >= ", value, "is_show_total_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTotalTimeLessThan(String value)
         {
              addCriterion("is_show_total_time < ", value, "is_show_total_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTotalTimeLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_total_time <= ", value, "is_show_total_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTotalTimeLike(String value)
         {
              addCriterion("is_show_total_time like ", value, "is_show_total_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTotalTimeNotLike(String value)
         {
              addCriterion("is_show_total_time not like ", value, "is_show_total_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTotalTimeIn(List<String> values)
         {
              addCriterion("is_show_total_time in ", values, "is_show_total_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTotalTimeNotIn(List<String> values)
         {
              addCriterion("is_show_total_time not in ", values, "is_show_total_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTotalTimeBetween(String value1, String value2)
         {
              addCriterion("is_show_total_time between ", value1,value2, "is_show_total_time");
              return (Criteria) this;
         }

         public Criteria andIsShowTotalTimeNotBetween(String value1, String value2)
         {
              addCriterion("is_show_total_time not between ", value1,value2, "is_show_total_time");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsCategoryIsNull()
         {
              addCriterion("is_show_marketing_goods_category is null");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsCategoryIsNotNull()
         {
              addCriterion("is_show_marketing_goods_category is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsCategoryEqualTo(String value)
         {
              addCriterion("is_show_marketing_goods_category = ", value, "is_show_marketing_goods_category");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsCategoryNotEqualTo(String value)
         {
              addCriterion("is_show_marketing_goods_category <> ", value, "is_show_marketing_goods_category");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsCategoryGreaterThan(String value)
         {
              addCriterion("is_show_marketing_goods_category > ", value, "is_show_marketing_goods_category");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsCategoryGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_marketing_goods_category >= ", value, "is_show_marketing_goods_category");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsCategoryLessThan(String value)
         {
              addCriterion("is_show_marketing_goods_category < ", value, "is_show_marketing_goods_category");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsCategoryLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_marketing_goods_category <= ", value, "is_show_marketing_goods_category");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsCategoryLike(String value)
         {
              addCriterion("is_show_marketing_goods_category like ", value, "is_show_marketing_goods_category");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsCategoryNotLike(String value)
         {
              addCriterion("is_show_marketing_goods_category not like ", value, "is_show_marketing_goods_category");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsCategoryIn(List<String> values)
         {
              addCriterion("is_show_marketing_goods_category in ", values, "is_show_marketing_goods_category");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsCategoryNotIn(List<String> values)
         {
              addCriterion("is_show_marketing_goods_category not in ", values, "is_show_marketing_goods_category");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsCategoryBetween(String value1, String value2)
         {
              addCriterion("is_show_marketing_goods_category between ", value1,value2, "is_show_marketing_goods_category");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsCategoryNotBetween(String value1, String value2)
         {
              addCriterion("is_show_marketing_goods_category not between ", value1,value2, "is_show_marketing_goods_category");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsBrandIsNull()
         {
              addCriterion("is_show_marketing_goods_brand is null");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsBrandIsNotNull()
         {
              addCriterion("is_show_marketing_goods_brand is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsBrandEqualTo(String value)
         {
              addCriterion("is_show_marketing_goods_brand = ", value, "is_show_marketing_goods_brand");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsBrandNotEqualTo(String value)
         {
              addCriterion("is_show_marketing_goods_brand <> ", value, "is_show_marketing_goods_brand");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsBrandGreaterThan(String value)
         {
              addCriterion("is_show_marketing_goods_brand > ", value, "is_show_marketing_goods_brand");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsBrandGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_marketing_goods_brand >= ", value, "is_show_marketing_goods_brand");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsBrandLessThan(String value)
         {
              addCriterion("is_show_marketing_goods_brand < ", value, "is_show_marketing_goods_brand");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsBrandLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_marketing_goods_brand <= ", value, "is_show_marketing_goods_brand");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsBrandLike(String value)
         {
              addCriterion("is_show_marketing_goods_brand like ", value, "is_show_marketing_goods_brand");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsBrandNotLike(String value)
         {
              addCriterion("is_show_marketing_goods_brand not like ", value, "is_show_marketing_goods_brand");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsBrandIn(List<String> values)
         {
              addCriterion("is_show_marketing_goods_brand in ", values, "is_show_marketing_goods_brand");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsBrandNotIn(List<String> values)
         {
              addCriterion("is_show_marketing_goods_brand not in ", values, "is_show_marketing_goods_brand");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsBrandBetween(String value1, String value2)
         {
              addCriterion("is_show_marketing_goods_brand between ", value1,value2, "is_show_marketing_goods_brand");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsBrandNotBetween(String value1, String value2)
         {
              addCriterion("is_show_marketing_goods_brand not between ", value1,value2, "is_show_marketing_goods_brand");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsIsNull()
         {
              addCriterion("is_show_marketing_goods is null");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsIsNotNull()
         {
              addCriterion("is_show_marketing_goods is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsEqualTo(String value)
         {
              addCriterion("is_show_marketing_goods = ", value, "is_show_marketing_goods");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsNotEqualTo(String value)
         {
              addCriterion("is_show_marketing_goods <> ", value, "is_show_marketing_goods");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsGreaterThan(String value)
         {
              addCriterion("is_show_marketing_goods > ", value, "is_show_marketing_goods");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_marketing_goods >= ", value, "is_show_marketing_goods");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsLessThan(String value)
         {
              addCriterion("is_show_marketing_goods < ", value, "is_show_marketing_goods");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_marketing_goods <= ", value, "is_show_marketing_goods");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsLike(String value)
         {
              addCriterion("is_show_marketing_goods like ", value, "is_show_marketing_goods");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsNotLike(String value)
         {
              addCriterion("is_show_marketing_goods not like ", value, "is_show_marketing_goods");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsIn(List<String> values)
         {
              addCriterion("is_show_marketing_goods in ", values, "is_show_marketing_goods");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsNotIn(List<String> values)
         {
              addCriterion("is_show_marketing_goods not in ", values, "is_show_marketing_goods");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsBetween(String value1, String value2)
         {
              addCriterion("is_show_marketing_goods between ", value1,value2, "is_show_marketing_goods");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingGoodsNotBetween(String value1, String value2)
         {
              addCriterion("is_show_marketing_goods not between ", value1,value2, "is_show_marketing_goods");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingActionIsNull()
         {
              addCriterion("is_show_marketing_action is null");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingActionIsNotNull()
         {
              addCriterion("is_show_marketing_action is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingActionEqualTo(String value)
         {
              addCriterion("is_show_marketing_action = ", value, "is_show_marketing_action");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingActionNotEqualTo(String value)
         {
              addCriterion("is_show_marketing_action <> ", value, "is_show_marketing_action");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingActionGreaterThan(String value)
         {
              addCriterion("is_show_marketing_action > ", value, "is_show_marketing_action");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingActionGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_marketing_action >= ", value, "is_show_marketing_action");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingActionLessThan(String value)
         {
              addCriterion("is_show_marketing_action < ", value, "is_show_marketing_action");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingActionLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_marketing_action <= ", value, "is_show_marketing_action");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingActionLike(String value)
         {
              addCriterion("is_show_marketing_action like ", value, "is_show_marketing_action");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingActionNotLike(String value)
         {
              addCriterion("is_show_marketing_action not like ", value, "is_show_marketing_action");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingActionIn(List<String> values)
         {
              addCriterion("is_show_marketing_action in ", values, "is_show_marketing_action");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingActionNotIn(List<String> values)
         {
              addCriterion("is_show_marketing_action not in ", values, "is_show_marketing_action");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingActionBetween(String value1, String value2)
         {
              addCriterion("is_show_marketing_action between ", value1,value2, "is_show_marketing_action");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingActionNotBetween(String value1, String value2)
         {
              addCriterion("is_show_marketing_action not between ", value1,value2, "is_show_marketing_action");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingCouponIsNull()
         {
              addCriterion("is_show_marketing_coupon is null");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingCouponIsNotNull()
         {
              addCriterion("is_show_marketing_coupon is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingCouponEqualTo(String value)
         {
              addCriterion("is_show_marketing_coupon = ", value, "is_show_marketing_coupon");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingCouponNotEqualTo(String value)
         {
              addCriterion("is_show_marketing_coupon <> ", value, "is_show_marketing_coupon");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingCouponGreaterThan(String value)
         {
              addCriterion("is_show_marketing_coupon > ", value, "is_show_marketing_coupon");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingCouponGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_marketing_coupon >= ", value, "is_show_marketing_coupon");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingCouponLessThan(String value)
         {
              addCriterion("is_show_marketing_coupon < ", value, "is_show_marketing_coupon");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingCouponLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_marketing_coupon <= ", value, "is_show_marketing_coupon");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingCouponLike(String value)
         {
              addCriterion("is_show_marketing_coupon like ", value, "is_show_marketing_coupon");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingCouponNotLike(String value)
         {
              addCriterion("is_show_marketing_coupon not like ", value, "is_show_marketing_coupon");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingCouponIn(List<String> values)
         {
              addCriterion("is_show_marketing_coupon in ", values, "is_show_marketing_coupon");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingCouponNotIn(List<String> values)
         {
              addCriterion("is_show_marketing_coupon not in ", values, "is_show_marketing_coupon");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingCouponBetween(String value1, String value2)
         {
              addCriterion("is_show_marketing_coupon between ", value1,value2, "is_show_marketing_coupon");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingCouponNotBetween(String value1, String value2)
         {
              addCriterion("is_show_marketing_coupon not between ", value1,value2, "is_show_marketing_coupon");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingEventIsNull()
         {
              addCriterion("is_show_marketing_event is null");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingEventIsNotNull()
         {
              addCriterion("is_show_marketing_event is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingEventEqualTo(String value)
         {
              addCriterion("is_show_marketing_event = ", value, "is_show_marketing_event");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingEventNotEqualTo(String value)
         {
              addCriterion("is_show_marketing_event <> ", value, "is_show_marketing_event");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingEventGreaterThan(String value)
         {
              addCriterion("is_show_marketing_event > ", value, "is_show_marketing_event");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingEventGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_marketing_event >= ", value, "is_show_marketing_event");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingEventLessThan(String value)
         {
              addCriterion("is_show_marketing_event < ", value, "is_show_marketing_event");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingEventLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_marketing_event <= ", value, "is_show_marketing_event");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingEventLike(String value)
         {
              addCriterion("is_show_marketing_event like ", value, "is_show_marketing_event");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingEventNotLike(String value)
         {
              addCriterion("is_show_marketing_event not like ", value, "is_show_marketing_event");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingEventIn(List<String> values)
         {
              addCriterion("is_show_marketing_event in ", values, "is_show_marketing_event");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingEventNotIn(List<String> values)
         {
              addCriterion("is_show_marketing_event not in ", values, "is_show_marketing_event");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingEventBetween(String value1, String value2)
         {
              addCriterion("is_show_marketing_event between ", value1,value2, "is_show_marketing_event");
              return (Criteria) this;
         }

         public Criteria andIsShowMarketingEventNotBetween(String value1, String value2)
         {
              addCriterion("is_show_marketing_event not between ", value1,value2, "is_show_marketing_event");
              return (Criteria) this;
         }

         public Criteria andIsShowServerToolsIsNull()
         {
              addCriterion("is_show_server_tools is null");
              return (Criteria) this;
         }

         public Criteria andIsShowServerToolsIsNotNull()
         {
              addCriterion("is_show_server_tools is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowServerToolsEqualTo(String value)
         {
              addCriterion("is_show_server_tools = ", value, "is_show_server_tools");
              return (Criteria) this;
         }

         public Criteria andIsShowServerToolsNotEqualTo(String value)
         {
              addCriterion("is_show_server_tools <> ", value, "is_show_server_tools");
              return (Criteria) this;
         }

         public Criteria andIsShowServerToolsGreaterThan(String value)
         {
              addCriterion("is_show_server_tools > ", value, "is_show_server_tools");
              return (Criteria) this;
         }

         public Criteria andIsShowServerToolsGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_server_tools >= ", value, "is_show_server_tools");
              return (Criteria) this;
         }

         public Criteria andIsShowServerToolsLessThan(String value)
         {
              addCriterion("is_show_server_tools < ", value, "is_show_server_tools");
              return (Criteria) this;
         }

         public Criteria andIsShowServerToolsLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_server_tools <= ", value, "is_show_server_tools");
              return (Criteria) this;
         }

         public Criteria andIsShowServerToolsLike(String value)
         {
              addCriterion("is_show_server_tools like ", value, "is_show_server_tools");
              return (Criteria) this;
         }

         public Criteria andIsShowServerToolsNotLike(String value)
         {
              addCriterion("is_show_server_tools not like ", value, "is_show_server_tools");
              return (Criteria) this;
         }

         public Criteria andIsShowServerToolsIn(List<String> values)
         {
              addCriterion("is_show_server_tools in ", values, "is_show_server_tools");
              return (Criteria) this;
         }

         public Criteria andIsShowServerToolsNotIn(List<String> values)
         {
              addCriterion("is_show_server_tools not in ", values, "is_show_server_tools");
              return (Criteria) this;
         }

         public Criteria andIsShowServerToolsBetween(String value1, String value2)
         {
              addCriterion("is_show_server_tools between ", value1,value2, "is_show_server_tools");
              return (Criteria) this;
         }

         public Criteria andIsShowServerToolsNotBetween(String value1, String value2)
         {
              addCriterion("is_show_server_tools not between ", value1,value2, "is_show_server_tools");
              return (Criteria) this;
         }

         public Criteria andIsShowPositionIsNull()
         {
              addCriterion("is_show_position is null");
              return (Criteria) this;
         }

         public Criteria andIsShowPositionIsNotNull()
         {
              addCriterion("is_show_position is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowPositionEqualTo(String value)
         {
              addCriterion("is_show_position = ", value, "is_show_position");
              return (Criteria) this;
         }

         public Criteria andIsShowPositionNotEqualTo(String value)
         {
              addCriterion("is_show_position <> ", value, "is_show_position");
              return (Criteria) this;
         }

         public Criteria andIsShowPositionGreaterThan(String value)
         {
              addCriterion("is_show_position > ", value, "is_show_position");
              return (Criteria) this;
         }

         public Criteria andIsShowPositionGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_position >= ", value, "is_show_position");
              return (Criteria) this;
         }

         public Criteria andIsShowPositionLessThan(String value)
         {
              addCriterion("is_show_position < ", value, "is_show_position");
              return (Criteria) this;
         }

         public Criteria andIsShowPositionLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_position <= ", value, "is_show_position");
              return (Criteria) this;
         }

         public Criteria andIsShowPositionLike(String value)
         {
              addCriterion("is_show_position like ", value, "is_show_position");
              return (Criteria) this;
         }

         public Criteria andIsShowPositionNotLike(String value)
         {
              addCriterion("is_show_position not like ", value, "is_show_position");
              return (Criteria) this;
         }

         public Criteria andIsShowPositionIn(List<String> values)
         {
              addCriterion("is_show_position in ", values, "is_show_position");
              return (Criteria) this;
         }

         public Criteria andIsShowPositionNotIn(List<String> values)
         {
              addCriterion("is_show_position not in ", values, "is_show_position");
              return (Criteria) this;
         }

         public Criteria andIsShowPositionBetween(String value1, String value2)
         {
              addCriterion("is_show_position between ", value1,value2, "is_show_position");
              return (Criteria) this;
         }

         public Criteria andIsShowPositionNotBetween(String value1, String value2)
         {
              addCriterion("is_show_position not between ", value1,value2, "is_show_position");
              return (Criteria) this;
         }

         public Criteria andIsShowDurationIsNull()
         {
              addCriterion("is_show_duration is null");
              return (Criteria) this;
         }

         public Criteria andIsShowDurationIsNotNull()
         {
              addCriterion("is_show_duration is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowDurationEqualTo(String value)
         {
              addCriterion("is_show_duration = ", value, "is_show_duration");
              return (Criteria) this;
         }

         public Criteria andIsShowDurationNotEqualTo(String value)
         {
              addCriterion("is_show_duration <> ", value, "is_show_duration");
              return (Criteria) this;
         }

         public Criteria andIsShowDurationGreaterThan(String value)
         {
              addCriterion("is_show_duration > ", value, "is_show_duration");
              return (Criteria) this;
         }

         public Criteria andIsShowDurationGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_duration >= ", value, "is_show_duration");
              return (Criteria) this;
         }

         public Criteria andIsShowDurationLessThan(String value)
         {
              addCriterion("is_show_duration < ", value, "is_show_duration");
              return (Criteria) this;
         }

         public Criteria andIsShowDurationLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_duration <= ", value, "is_show_duration");
              return (Criteria) this;
         }

         public Criteria andIsShowDurationLike(String value)
         {
              addCriterion("is_show_duration like ", value, "is_show_duration");
              return (Criteria) this;
         }

         public Criteria andIsShowDurationNotLike(String value)
         {
              addCriterion("is_show_duration not like ", value, "is_show_duration");
              return (Criteria) this;
         }

         public Criteria andIsShowDurationIn(List<String> values)
         {
              addCriterion("is_show_duration in ", values, "is_show_duration");
              return (Criteria) this;
         }

         public Criteria andIsShowDurationNotIn(List<String> values)
         {
              addCriterion("is_show_duration not in ", values, "is_show_duration");
              return (Criteria) this;
         }

         public Criteria andIsShowDurationBetween(String value1, String value2)
         {
              addCriterion("is_show_duration between ", value1,value2, "is_show_duration");
              return (Criteria) this;
         }

         public Criteria andIsShowDurationNotBetween(String value1, String value2)
         {
              addCriterion("is_show_duration not between ", value1,value2, "is_show_duration");
              return (Criteria) this;
         }

         public Criteria andIsShowConsumeMoneyIsNull()
         {
              addCriterion("is_show_consume_money is null");
              return (Criteria) this;
         }

         public Criteria andIsShowConsumeMoneyIsNotNull()
         {
              addCriterion("is_show_consume_money is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowConsumeMoneyEqualTo(String value)
         {
              addCriterion("is_show_consume_money = ", value, "is_show_consume_money");
              return (Criteria) this;
         }

         public Criteria andIsShowConsumeMoneyNotEqualTo(String value)
         {
              addCriterion("is_show_consume_money <> ", value, "is_show_consume_money");
              return (Criteria) this;
         }

         public Criteria andIsShowConsumeMoneyGreaterThan(String value)
         {
              addCriterion("is_show_consume_money > ", value, "is_show_consume_money");
              return (Criteria) this;
         }

         public Criteria andIsShowConsumeMoneyGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_consume_money >= ", value, "is_show_consume_money");
              return (Criteria) this;
         }

         public Criteria andIsShowConsumeMoneyLessThan(String value)
         {
              addCriterion("is_show_consume_money < ", value, "is_show_consume_money");
              return (Criteria) this;
         }

         public Criteria andIsShowConsumeMoneyLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_consume_money <= ", value, "is_show_consume_money");
              return (Criteria) this;
         }

         public Criteria andIsShowConsumeMoneyLike(String value)
         {
              addCriterion("is_show_consume_money like ", value, "is_show_consume_money");
              return (Criteria) this;
         }

         public Criteria andIsShowConsumeMoneyNotLike(String value)
         {
              addCriterion("is_show_consume_money not like ", value, "is_show_consume_money");
              return (Criteria) this;
         }

         public Criteria andIsShowConsumeMoneyIn(List<String> values)
         {
              addCriterion("is_show_consume_money in ", values, "is_show_consume_money");
              return (Criteria) this;
         }

         public Criteria andIsShowConsumeMoneyNotIn(List<String> values)
         {
              addCriterion("is_show_consume_money not in ", values, "is_show_consume_money");
              return (Criteria) this;
         }

         public Criteria andIsShowConsumeMoneyBetween(String value1, String value2)
         {
              addCriterion("is_show_consume_money between ", value1,value2, "is_show_consume_money");
              return (Criteria) this;
         }

         public Criteria andIsShowConsumeMoneyNotBetween(String value1, String value2)
         {
              addCriterion("is_show_consume_money not between ", value1,value2, "is_show_consume_money");
              return (Criteria) this;
         }

         public Criteria andIsShowVbIsNull()
         {
              addCriterion("is_show_vb is null");
              return (Criteria) this;
         }

         public Criteria andIsShowVbIsNotNull()
         {
              addCriterion("is_show_vb is not null");
              return (Criteria) this;
         }

         public Criteria andIsShowVbEqualTo(String value)
         {
              addCriterion("is_show_vb = ", value, "is_show_vb");
              return (Criteria) this;
         }

         public Criteria andIsShowVbNotEqualTo(String value)
         {
              addCriterion("is_show_vb <> ", value, "is_show_vb");
              return (Criteria) this;
         }

         public Criteria andIsShowVbGreaterThan(String value)
         {
              addCriterion("is_show_vb > ", value, "is_show_vb");
              return (Criteria) this;
         }

         public Criteria andIsShowVbGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_show_vb >= ", value, "is_show_vb");
              return (Criteria) this;
         }

         public Criteria andIsShowVbLessThan(String value)
         {
              addCriterion("is_show_vb < ", value, "is_show_vb");
              return (Criteria) this;
         }

         public Criteria andIsShowVbLessThanOrEqualTo(String value)
         {
              addCriterion("is_show_vb <= ", value, "is_show_vb");
              return (Criteria) this;
         }

         public Criteria andIsShowVbLike(String value)
         {
              addCriterion("is_show_vb like ", value, "is_show_vb");
              return (Criteria) this;
         }

         public Criteria andIsShowVbNotLike(String value)
         {
              addCriterion("is_show_vb not like ", value, "is_show_vb");
              return (Criteria) this;
         }

         public Criteria andIsShowVbIn(List<String> values)
         {
              addCriterion("is_show_vb in ", values, "is_show_vb");
              return (Criteria) this;
         }

         public Criteria andIsShowVbNotIn(List<String> values)
         {
              addCriterion("is_show_vb not in ", values, "is_show_vb");
              return (Criteria) this;
         }

         public Criteria andIsShowVbBetween(String value1, String value2)
         {
              addCriterion("is_show_vb between ", value1,value2, "is_show_vb");
              return (Criteria) this;
         }

         public Criteria andIsShowVbNotBetween(String value1, String value2)
         {
              addCriterion("is_show_vb not between ", value1,value2, "is_show_vb");
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
