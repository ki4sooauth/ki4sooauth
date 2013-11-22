package com.gooagoo.entity.generator.marketing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 规结果则表（包括积分规则结果，营销规则结果）
 */

public class RuleResultExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public RuleResultExample()
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

         public Criteria andRuleResultIdIsNull()
         {
              addCriterion("rule_result_id is null");
              return (Criteria) this;
         }

         public Criteria andRuleResultIdIsNotNull()
         {
              addCriterion("rule_result_id is not null");
              return (Criteria) this;
         }

         public Criteria andRuleResultIdEqualTo(String value)
         {
              addCriterion("rule_result_id = ", value, "rule_result_id");
              return (Criteria) this;
         }

         public Criteria andRuleResultIdNotEqualTo(String value)
         {
              addCriterion("rule_result_id <> ", value, "rule_result_id");
              return (Criteria) this;
         }

         public Criteria andRuleResultIdGreaterThan(String value)
         {
              addCriterion("rule_result_id > ", value, "rule_result_id");
              return (Criteria) this;
         }

         public Criteria andRuleResultIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("rule_result_id >= ", value, "rule_result_id");
              return (Criteria) this;
         }

         public Criteria andRuleResultIdLessThan(String value)
         {
              addCriterion("rule_result_id < ", value, "rule_result_id");
              return (Criteria) this;
         }

         public Criteria andRuleResultIdLessThanOrEqualTo(String value)
         {
              addCriterion("rule_result_id <= ", value, "rule_result_id");
              return (Criteria) this;
         }

         public Criteria andRuleResultIdLike(String value)
         {
              addCriterion("rule_result_id like ", value, "rule_result_id");
              return (Criteria) this;
         }

         public Criteria andRuleResultIdNotLike(String value)
         {
              addCriterion("rule_result_id not like ", value, "rule_result_id");
              return (Criteria) this;
         }

         public Criteria andRuleResultIdIn(List<String> values)
         {
              addCriterion("rule_result_id in ", values, "rule_result_id");
              return (Criteria) this;
         }

         public Criteria andRuleResultIdNotIn(List<String> values)
         {
              addCriterion("rule_result_id not in ", values, "rule_result_id");
              return (Criteria) this;
         }

         public Criteria andRuleResultIdBetween(String value1, String value2)
         {
              addCriterion("rule_result_id between ", value1,value2, "rule_result_id");
              return (Criteria) this;
         }

         public Criteria andRuleResultIdNotBetween(String value1, String value2)
         {
              addCriterion("rule_result_id not between ", value1,value2, "rule_result_id");
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

         public Criteria andAddConsumeMoneyIsNull()
         {
              addCriterion("add_consume_money is null");
              return (Criteria) this;
         }

         public Criteria andAddConsumeMoneyIsNotNull()
         {
              addCriterion("add_consume_money is not null");
              return (Criteria) this;
         }

         public Criteria andAddConsumeMoneyEqualTo(String value)
         {
              addCriterion("add_consume_money = ", value, "add_consume_money");
              return (Criteria) this;
         }

         public Criteria andAddConsumeMoneyNotEqualTo(String value)
         {
              addCriterion("add_consume_money <> ", value, "add_consume_money");
              return (Criteria) this;
         }

         public Criteria andAddConsumeMoneyGreaterThan(String value)
         {
              addCriterion("add_consume_money > ", value, "add_consume_money");
              return (Criteria) this;
         }

         public Criteria andAddConsumeMoneyGreaterThanOrEqualTo(String value)
         {
              addCriterion("add_consume_money >= ", value, "add_consume_money");
              return (Criteria) this;
         }

         public Criteria andAddConsumeMoneyLessThan(String value)
         {
              addCriterion("add_consume_money < ", value, "add_consume_money");
              return (Criteria) this;
         }

         public Criteria andAddConsumeMoneyLessThanOrEqualTo(String value)
         {
              addCriterion("add_consume_money <= ", value, "add_consume_money");
              return (Criteria) this;
         }

         public Criteria andAddConsumeMoneyLike(String value)
         {
              addCriterion("add_consume_money like ", value, "add_consume_money");
              return (Criteria) this;
         }

         public Criteria andAddConsumeMoneyNotLike(String value)
         {
              addCriterion("add_consume_money not like ", value, "add_consume_money");
              return (Criteria) this;
         }

         public Criteria andAddConsumeMoneyIn(List<String> values)
         {
              addCriterion("add_consume_money in ", values, "add_consume_money");
              return (Criteria) this;
         }

         public Criteria andAddConsumeMoneyNotIn(List<String> values)
         {
              addCriterion("add_consume_money not in ", values, "add_consume_money");
              return (Criteria) this;
         }

         public Criteria andAddConsumeMoneyBetween(String value1, String value2)
         {
              addCriterion("add_consume_money between ", value1,value2, "add_consume_money");
              return (Criteria) this;
         }

         public Criteria andAddConsumeMoneyNotBetween(String value1, String value2)
         {
              addCriterion("add_consume_money not between ", value1,value2, "add_consume_money");
              return (Criteria) this;
         }

         public Criteria andRuleResultTypeIsNull()
         {
              addCriterion("rule_result_type is null");
              return (Criteria) this;
         }

         public Criteria andRuleResultTypeIsNotNull()
         {
              addCriterion("rule_result_type is not null");
              return (Criteria) this;
         }

         public Criteria andRuleResultTypeEqualTo(String value)
         {
              addCriterion("rule_result_type = ", value, "rule_result_type");
              return (Criteria) this;
         }

         public Criteria andRuleResultTypeNotEqualTo(String value)
         {
              addCriterion("rule_result_type <> ", value, "rule_result_type");
              return (Criteria) this;
         }

         public Criteria andRuleResultTypeGreaterThan(String value)
         {
              addCriterion("rule_result_type > ", value, "rule_result_type");
              return (Criteria) this;
         }

         public Criteria andRuleResultTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("rule_result_type >= ", value, "rule_result_type");
              return (Criteria) this;
         }

         public Criteria andRuleResultTypeLessThan(String value)
         {
              addCriterion("rule_result_type < ", value, "rule_result_type");
              return (Criteria) this;
         }

         public Criteria andRuleResultTypeLessThanOrEqualTo(String value)
         {
              addCriterion("rule_result_type <= ", value, "rule_result_type");
              return (Criteria) this;
         }

         public Criteria andRuleResultTypeLike(String value)
         {
              addCriterion("rule_result_type like ", value, "rule_result_type");
              return (Criteria) this;
         }

         public Criteria andRuleResultTypeNotLike(String value)
         {
              addCriterion("rule_result_type not like ", value, "rule_result_type");
              return (Criteria) this;
         }

         public Criteria andRuleResultTypeIn(List<String> values)
         {
              addCriterion("rule_result_type in ", values, "rule_result_type");
              return (Criteria) this;
         }

         public Criteria andRuleResultTypeNotIn(List<String> values)
         {
              addCriterion("rule_result_type not in ", values, "rule_result_type");
              return (Criteria) this;
         }

         public Criteria andRuleResultTypeBetween(String value1, String value2)
         {
              addCriterion("rule_result_type between ", value1,value2, "rule_result_type");
              return (Criteria) this;
         }

         public Criteria andRuleResultTypeNotBetween(String value1, String value2)
         {
              addCriterion("rule_result_type not between ", value1,value2, "rule_result_type");
              return (Criteria) this;
         }

         public Criteria andRuleResultValueIsNull()
         {
              addCriterion("rule_result_value is null");
              return (Criteria) this;
         }

         public Criteria andRuleResultValueIsNotNull()
         {
              addCriterion("rule_result_value is not null");
              return (Criteria) this;
         }

         public Criteria andRuleResultValueEqualTo(String value)
         {
              addCriterion("rule_result_value = ", value, "rule_result_value");
              return (Criteria) this;
         }

         public Criteria andRuleResultValueNotEqualTo(String value)
         {
              addCriterion("rule_result_value <> ", value, "rule_result_value");
              return (Criteria) this;
         }

         public Criteria andRuleResultValueGreaterThan(String value)
         {
              addCriterion("rule_result_value > ", value, "rule_result_value");
              return (Criteria) this;
         }

         public Criteria andRuleResultValueGreaterThanOrEqualTo(String value)
         {
              addCriterion("rule_result_value >= ", value, "rule_result_value");
              return (Criteria) this;
         }

         public Criteria andRuleResultValueLessThan(String value)
         {
              addCriterion("rule_result_value < ", value, "rule_result_value");
              return (Criteria) this;
         }

         public Criteria andRuleResultValueLessThanOrEqualTo(String value)
         {
              addCriterion("rule_result_value <= ", value, "rule_result_value");
              return (Criteria) this;
         }

         public Criteria andRuleResultValueLike(String value)
         {
              addCriterion("rule_result_value like ", value, "rule_result_value");
              return (Criteria) this;
         }

         public Criteria andRuleResultValueNotLike(String value)
         {
              addCriterion("rule_result_value not like ", value, "rule_result_value");
              return (Criteria) this;
         }

         public Criteria andRuleResultValueIn(List<String> values)
         {
              addCriterion("rule_result_value in ", values, "rule_result_value");
              return (Criteria) this;
         }

         public Criteria andRuleResultValueNotIn(List<String> values)
         {
              addCriterion("rule_result_value not in ", values, "rule_result_value");
              return (Criteria) this;
         }

         public Criteria andRuleResultValueBetween(String value1, String value2)
         {
              addCriterion("rule_result_value between ", value1,value2, "rule_result_value");
              return (Criteria) this;
         }

         public Criteria andRuleResultValueNotBetween(String value1, String value2)
         {
              addCriterion("rule_result_value not between ", value1,value2, "rule_result_value");
              return (Criteria) this;
         }

         public Criteria andRuleDescIsNull()
         {
              addCriterion("rule_desc is null");
              return (Criteria) this;
         }

         public Criteria andRuleDescIsNotNull()
         {
              addCriterion("rule_desc is not null");
              return (Criteria) this;
         }

         public Criteria andRuleDescEqualTo(String value)
         {
              addCriterion("rule_desc = ", value, "rule_desc");
              return (Criteria) this;
         }

         public Criteria andRuleDescNotEqualTo(String value)
         {
              addCriterion("rule_desc <> ", value, "rule_desc");
              return (Criteria) this;
         }

         public Criteria andRuleDescGreaterThan(String value)
         {
              addCriterion("rule_desc > ", value, "rule_desc");
              return (Criteria) this;
         }

         public Criteria andRuleDescGreaterThanOrEqualTo(String value)
         {
              addCriterion("rule_desc >= ", value, "rule_desc");
              return (Criteria) this;
         }

         public Criteria andRuleDescLessThan(String value)
         {
              addCriterion("rule_desc < ", value, "rule_desc");
              return (Criteria) this;
         }

         public Criteria andRuleDescLessThanOrEqualTo(String value)
         {
              addCriterion("rule_desc <= ", value, "rule_desc");
              return (Criteria) this;
         }

         public Criteria andRuleDescLike(String value)
         {
              addCriterion("rule_desc like ", value, "rule_desc");
              return (Criteria) this;
         }

         public Criteria andRuleDescNotLike(String value)
         {
              addCriterion("rule_desc not like ", value, "rule_desc");
              return (Criteria) this;
         }

         public Criteria andRuleDescIn(List<String> values)
         {
              addCriterion("rule_desc in ", values, "rule_desc");
              return (Criteria) this;
         }

         public Criteria andRuleDescNotIn(List<String> values)
         {
              addCriterion("rule_desc not in ", values, "rule_desc");
              return (Criteria) this;
         }

         public Criteria andRuleDescBetween(String value1, String value2)
         {
              addCriterion("rule_desc between ", value1,value2, "rule_desc");
              return (Criteria) this;
         }

         public Criteria andRuleDescNotBetween(String value1, String value2)
         {
              addCriterion("rule_desc not between ", value1,value2, "rule_desc");
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
