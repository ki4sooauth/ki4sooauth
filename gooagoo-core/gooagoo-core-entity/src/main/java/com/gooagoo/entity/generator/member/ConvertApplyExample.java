package com.gooagoo.entity.generator.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 物理卡转换申请
 */

public class ConvertApplyExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ConvertApplyExample()
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

         public Criteria andApplicationIdIsNull()
         {
              addCriterion("application_id is null");
              return (Criteria) this;
         }

         public Criteria andApplicationIdIsNotNull()
         {
              addCriterion("application_id is not null");
              return (Criteria) this;
         }

         public Criteria andApplicationIdEqualTo(String value)
         {
              addCriterion("application_id = ", value, "application_id");
              return (Criteria) this;
         }

         public Criteria andApplicationIdNotEqualTo(String value)
         {
              addCriterion("application_id <> ", value, "application_id");
              return (Criteria) this;
         }

         public Criteria andApplicationIdGreaterThan(String value)
         {
              addCriterion("application_id > ", value, "application_id");
              return (Criteria) this;
         }

         public Criteria andApplicationIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("application_id >= ", value, "application_id");
              return (Criteria) this;
         }

         public Criteria andApplicationIdLessThan(String value)
         {
              addCriterion("application_id < ", value, "application_id");
              return (Criteria) this;
         }

         public Criteria andApplicationIdLessThanOrEqualTo(String value)
         {
              addCriterion("application_id <= ", value, "application_id");
              return (Criteria) this;
         }

         public Criteria andApplicationIdLike(String value)
         {
              addCriterion("application_id like ", value, "application_id");
              return (Criteria) this;
         }

         public Criteria andApplicationIdNotLike(String value)
         {
              addCriterion("application_id not like ", value, "application_id");
              return (Criteria) this;
         }

         public Criteria andApplicationIdIn(List<String> values)
         {
              addCriterion("application_id in ", values, "application_id");
              return (Criteria) this;
         }

         public Criteria andApplicationIdNotIn(List<String> values)
         {
              addCriterion("application_id not in ", values, "application_id");
              return (Criteria) this;
         }

         public Criteria andApplicationIdBetween(String value1, String value2)
         {
              addCriterion("application_id between ", value1,value2, "application_id");
              return (Criteria) this;
         }

         public Criteria andApplicationIdNotBetween(String value1, String value2)
         {
              addCriterion("application_id not between ", value1,value2, "application_id");
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

         public Criteria andApplyTimeIsNull()
         {
              addCriterion("apply_time is null");
              return (Criteria) this;
         }

         public Criteria andApplyTimeIsNotNull()
         {
              addCriterion("apply_time is not null");
              return (Criteria) this;
         }

         public Criteria andApplyTimeEqualTo(Date value)
         {
              addCriterion("apply_time = ", value, "apply_time");
              return (Criteria) this;
         }

         public Criteria andApplyTimeNotEqualTo(Date value)
         {
              addCriterion("apply_time <> ", value, "apply_time");
              return (Criteria) this;
         }

         public Criteria andApplyTimeGreaterThan(Date value)
         {
              addCriterion("apply_time > ", value, "apply_time");
              return (Criteria) this;
         }

         public Criteria andApplyTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("apply_time >= ", value, "apply_time");
              return (Criteria) this;
         }

         public Criteria andApplyTimeLessThan(Date value)
         {
              addCriterion("apply_time < ", value, "apply_time");
              return (Criteria) this;
         }

         public Criteria andApplyTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("apply_time <= ", value, "apply_time");
              return (Criteria) this;
         }

         public Criteria andApplyTimeIn(List<Date> values)
         {
              addCriterion("apply_time in ", values, "apply_time");
              return (Criteria) this;
         }

         public Criteria andApplyTimeNotIn(List<Date> values)
         {
              addCriterion("apply_time not in ", values, "apply_time");
              return (Criteria) this;
         }

         public Criteria andApplyTimeBetween(Date value1, Date value2)
         {
              addCriterion("apply_time between ", value1,value2, "apply_time");
              return (Criteria) this;
         }

         public Criteria andApplyTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("apply_time not between ", value1,value2, "apply_time");
              return (Criteria) this;
         }

         public Criteria andPhyNoIsNull()
         {
              addCriterion("phy_no is null");
              return (Criteria) this;
         }

         public Criteria andPhyNoIsNotNull()
         {
              addCriterion("phy_no is not null");
              return (Criteria) this;
         }

         public Criteria andPhyNoEqualTo(String value)
         {
              addCriterion("phy_no = ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoNotEqualTo(String value)
         {
              addCriterion("phy_no <> ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoGreaterThan(String value)
         {
              addCriterion("phy_no > ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoGreaterThanOrEqualTo(String value)
         {
              addCriterion("phy_no >= ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoLessThan(String value)
         {
              addCriterion("phy_no < ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoLessThanOrEqualTo(String value)
         {
              addCriterion("phy_no <= ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoLike(String value)
         {
              addCriterion("phy_no like ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoNotLike(String value)
         {
              addCriterion("phy_no not like ", value, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoIn(List<String> values)
         {
              addCriterion("phy_no in ", values, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoNotIn(List<String> values)
         {
              addCriterion("phy_no not in ", values, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoBetween(String value1, String value2)
         {
              addCriterion("phy_no between ", value1,value2, "phy_no");
              return (Criteria) this;
         }

         public Criteria andPhyNoNotBetween(String value1, String value2)
         {
              addCriterion("phy_no not between ", value1,value2, "phy_no");
              return (Criteria) this;
         }

         public Criteria andIdNoIsNull()
         {
              addCriterion("id_no is null");
              return (Criteria) this;
         }

         public Criteria andIdNoIsNotNull()
         {
              addCriterion("id_no is not null");
              return (Criteria) this;
         }

         public Criteria andIdNoEqualTo(String value)
         {
              addCriterion("id_no = ", value, "id_no");
              return (Criteria) this;
         }

         public Criteria andIdNoNotEqualTo(String value)
         {
              addCriterion("id_no <> ", value, "id_no");
              return (Criteria) this;
         }

         public Criteria andIdNoGreaterThan(String value)
         {
              addCriterion("id_no > ", value, "id_no");
              return (Criteria) this;
         }

         public Criteria andIdNoGreaterThanOrEqualTo(String value)
         {
              addCriterion("id_no >= ", value, "id_no");
              return (Criteria) this;
         }

         public Criteria andIdNoLessThan(String value)
         {
              addCriterion("id_no < ", value, "id_no");
              return (Criteria) this;
         }

         public Criteria andIdNoLessThanOrEqualTo(String value)
         {
              addCriterion("id_no <= ", value, "id_no");
              return (Criteria) this;
         }

         public Criteria andIdNoLike(String value)
         {
              addCriterion("id_no like ", value, "id_no");
              return (Criteria) this;
         }

         public Criteria andIdNoNotLike(String value)
         {
              addCriterion("id_no not like ", value, "id_no");
              return (Criteria) this;
         }

         public Criteria andIdNoIn(List<String> values)
         {
              addCriterion("id_no in ", values, "id_no");
              return (Criteria) this;
         }

         public Criteria andIdNoNotIn(List<String> values)
         {
              addCriterion("id_no not in ", values, "id_no");
              return (Criteria) this;
         }

         public Criteria andIdNoBetween(String value1, String value2)
         {
              addCriterion("id_no between ", value1,value2, "id_no");
              return (Criteria) this;
         }

         public Criteria andIdNoNotBetween(String value1, String value2)
         {
              addCriterion("id_no not between ", value1,value2, "id_no");
              return (Criteria) this;
         }

         public Criteria andMobileIsNull()
         {
              addCriterion("mobile is null");
              return (Criteria) this;
         }

         public Criteria andMobileIsNotNull()
         {
              addCriterion("mobile is not null");
              return (Criteria) this;
         }

         public Criteria andMobileEqualTo(String value)
         {
              addCriterion("mobile = ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileNotEqualTo(String value)
         {
              addCriterion("mobile <> ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileGreaterThan(String value)
         {
              addCriterion("mobile > ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileGreaterThanOrEqualTo(String value)
         {
              addCriterion("mobile >= ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileLessThan(String value)
         {
              addCriterion("mobile < ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileLessThanOrEqualTo(String value)
         {
              addCriterion("mobile <= ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileLike(String value)
         {
              addCriterion("mobile like ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileNotLike(String value)
         {
              addCriterion("mobile not like ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileIn(List<String> values)
         {
              addCriterion("mobile in ", values, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileNotIn(List<String> values)
         {
              addCriterion("mobile not in ", values, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileBetween(String value1, String value2)
         {
              addCriterion("mobile between ", value1,value2, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileNotBetween(String value1, String value2)
         {
              addCriterion("mobile not between ", value1,value2, "mobile");
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

         public Criteria andSourceIsNull()
         {
              addCriterion("source is null");
              return (Criteria) this;
         }

         public Criteria andSourceIsNotNull()
         {
              addCriterion("source is not null");
              return (Criteria) this;
         }

         public Criteria andSourceEqualTo(String value)
         {
              addCriterion("source = ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceNotEqualTo(String value)
         {
              addCriterion("source <> ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceGreaterThan(String value)
         {
              addCriterion("source > ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceGreaterThanOrEqualTo(String value)
         {
              addCriterion("source >= ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceLessThan(String value)
         {
              addCriterion("source < ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceLessThanOrEqualTo(String value)
         {
              addCriterion("source <= ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceLike(String value)
         {
              addCriterion("source like ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceNotLike(String value)
         {
              addCriterion("source not like ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceIn(List<String> values)
         {
              addCriterion("source in ", values, "source");
              return (Criteria) this;
         }

         public Criteria andSourceNotIn(List<String> values)
         {
              addCriterion("source not in ", values, "source");
              return (Criteria) this;
         }

         public Criteria andSourceBetween(String value1, String value2)
         {
              addCriterion("source between ", value1,value2, "source");
              return (Criteria) this;
         }

         public Criteria andSourceNotBetween(String value1, String value2)
         {
              addCriterion("source not between ", value1,value2, "source");
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
