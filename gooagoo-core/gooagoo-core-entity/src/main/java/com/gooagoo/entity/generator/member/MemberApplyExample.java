package com.gooagoo.entity.generator.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 会员卡申请
 */

public class MemberApplyExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public MemberApplyExample()
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

         public Criteria andNameIsNull()
         {
              addCriterion("name is null");
              return (Criteria) this;
         }

         public Criteria andNameIsNotNull()
         {
              addCriterion("name is not null");
              return (Criteria) this;
         }

         public Criteria andNameEqualTo(String value)
         {
              addCriterion("name = ", value, "name");
              return (Criteria) this;
         }

         public Criteria andNameNotEqualTo(String value)
         {
              addCriterion("name <> ", value, "name");
              return (Criteria) this;
         }

         public Criteria andNameGreaterThan(String value)
         {
              addCriterion("name > ", value, "name");
              return (Criteria) this;
         }

         public Criteria andNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("name >= ", value, "name");
              return (Criteria) this;
         }

         public Criteria andNameLessThan(String value)
         {
              addCriterion("name < ", value, "name");
              return (Criteria) this;
         }

         public Criteria andNameLessThanOrEqualTo(String value)
         {
              addCriterion("name <= ", value, "name");
              return (Criteria) this;
         }

         public Criteria andNameLike(String value)
         {
              addCriterion("name like ", value, "name");
              return (Criteria) this;
         }

         public Criteria andNameNotLike(String value)
         {
              addCriterion("name not like ", value, "name");
              return (Criteria) this;
         }

         public Criteria andNameIn(List<String> values)
         {
              addCriterion("name in ", values, "name");
              return (Criteria) this;
         }

         public Criteria andNameNotIn(List<String> values)
         {
              addCriterion("name not in ", values, "name");
              return (Criteria) this;
         }

         public Criteria andNameBetween(String value1, String value2)
         {
              addCriterion("name between ", value1,value2, "name");
              return (Criteria) this;
         }

         public Criteria andNameNotBetween(String value1, String value2)
         {
              addCriterion("name not between ", value1,value2, "name");
              return (Criteria) this;
         }

         public Criteria andSexIsNull()
         {
              addCriterion("sex is null");
              return (Criteria) this;
         }

         public Criteria andSexIsNotNull()
         {
              addCriterion("sex is not null");
              return (Criteria) this;
         }

         public Criteria andSexEqualTo(String value)
         {
              addCriterion("sex = ", value, "sex");
              return (Criteria) this;
         }

         public Criteria andSexNotEqualTo(String value)
         {
              addCriterion("sex <> ", value, "sex");
              return (Criteria) this;
         }

         public Criteria andSexGreaterThan(String value)
         {
              addCriterion("sex > ", value, "sex");
              return (Criteria) this;
         }

         public Criteria andSexGreaterThanOrEqualTo(String value)
         {
              addCriterion("sex >= ", value, "sex");
              return (Criteria) this;
         }

         public Criteria andSexLessThan(String value)
         {
              addCriterion("sex < ", value, "sex");
              return (Criteria) this;
         }

         public Criteria andSexLessThanOrEqualTo(String value)
         {
              addCriterion("sex <= ", value, "sex");
              return (Criteria) this;
         }

         public Criteria andSexLike(String value)
         {
              addCriterion("sex like ", value, "sex");
              return (Criteria) this;
         }

         public Criteria andSexNotLike(String value)
         {
              addCriterion("sex not like ", value, "sex");
              return (Criteria) this;
         }

         public Criteria andSexIn(List<String> values)
         {
              addCriterion("sex in ", values, "sex");
              return (Criteria) this;
         }

         public Criteria andSexNotIn(List<String> values)
         {
              addCriterion("sex not in ", values, "sex");
              return (Criteria) this;
         }

         public Criteria andSexBetween(String value1, String value2)
         {
              addCriterion("sex between ", value1,value2, "sex");
              return (Criteria) this;
         }

         public Criteria andSexNotBetween(String value1, String value2)
         {
              addCriterion("sex not between ", value1,value2, "sex");
              return (Criteria) this;
         }

         public Criteria andBirthdayIsNull()
         {
              addCriterion("birthday is null");
              return (Criteria) this;
         }

         public Criteria andBirthdayIsNotNull()
         {
              addCriterion("birthday is not null");
              return (Criteria) this;
         }

         public Criteria andBirthdayEqualTo(Date value)
         {
              addCriterion("birthday = ", value, "birthday");
              return (Criteria) this;
         }

         public Criteria andBirthdayNotEqualTo(Date value)
         {
              addCriterion("birthday <> ", value, "birthday");
              return (Criteria) this;
         }

         public Criteria andBirthdayGreaterThan(Date value)
         {
              addCriterion("birthday > ", value, "birthday");
              return (Criteria) this;
         }

         public Criteria andBirthdayGreaterThanOrEqualTo(Date value)
         {
              addCriterion("birthday >= ", value, "birthday");
              return (Criteria) this;
         }

         public Criteria andBirthdayLessThan(Date value)
         {
              addCriterion("birthday < ", value, "birthday");
              return (Criteria) this;
         }

         public Criteria andBirthdayLessThanOrEqualTo(Date value)
         {
              addCriterion("birthday <= ", value, "birthday");
              return (Criteria) this;
         }

         public Criteria andBirthdayIn(List<Date> values)
         {
              addCriterion("birthday in ", values, "birthday");
              return (Criteria) this;
         }

         public Criteria andBirthdayNotIn(List<Date> values)
         {
              addCriterion("birthday not in ", values, "birthday");
              return (Criteria) this;
         }

         public Criteria andBirthdayBetween(Date value1, Date value2)
         {
              addCriterion("birthday between ", value1,value2, "birthday");
              return (Criteria) this;
         }

         public Criteria andBirthdayNotBetween(Date value1, Date value2)
         {
              addCriterion("birthday not between ", value1,value2, "birthday");
              return (Criteria) this;
         }

         public Criteria andIdTypeIsNull()
         {
              addCriterion("id_type is null");
              return (Criteria) this;
         }

         public Criteria andIdTypeIsNotNull()
         {
              addCriterion("id_type is not null");
              return (Criteria) this;
         }

         public Criteria andIdTypeEqualTo(String value)
         {
              addCriterion("id_type = ", value, "id_type");
              return (Criteria) this;
         }

         public Criteria andIdTypeNotEqualTo(String value)
         {
              addCriterion("id_type <> ", value, "id_type");
              return (Criteria) this;
         }

         public Criteria andIdTypeGreaterThan(String value)
         {
              addCriterion("id_type > ", value, "id_type");
              return (Criteria) this;
         }

         public Criteria andIdTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("id_type >= ", value, "id_type");
              return (Criteria) this;
         }

         public Criteria andIdTypeLessThan(String value)
         {
              addCriterion("id_type < ", value, "id_type");
              return (Criteria) this;
         }

         public Criteria andIdTypeLessThanOrEqualTo(String value)
         {
              addCriterion("id_type <= ", value, "id_type");
              return (Criteria) this;
         }

         public Criteria andIdTypeLike(String value)
         {
              addCriterion("id_type like ", value, "id_type");
              return (Criteria) this;
         }

         public Criteria andIdTypeNotLike(String value)
         {
              addCriterion("id_type not like ", value, "id_type");
              return (Criteria) this;
         }

         public Criteria andIdTypeIn(List<String> values)
         {
              addCriterion("id_type in ", values, "id_type");
              return (Criteria) this;
         }

         public Criteria andIdTypeNotIn(List<String> values)
         {
              addCriterion("id_type not in ", values, "id_type");
              return (Criteria) this;
         }

         public Criteria andIdTypeBetween(String value1, String value2)
         {
              addCriterion("id_type between ", value1,value2, "id_type");
              return (Criteria) this;
         }

         public Criteria andIdTypeNotBetween(String value1, String value2)
         {
              addCriterion("id_type not between ", value1,value2, "id_type");
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

         public Criteria andTelephoneIsNull()
         {
              addCriterion("telephone is null");
              return (Criteria) this;
         }

         public Criteria andTelephoneIsNotNull()
         {
              addCriterion("telephone is not null");
              return (Criteria) this;
         }

         public Criteria andTelephoneEqualTo(String value)
         {
              addCriterion("telephone = ", value, "telephone");
              return (Criteria) this;
         }

         public Criteria andTelephoneNotEqualTo(String value)
         {
              addCriterion("telephone <> ", value, "telephone");
              return (Criteria) this;
         }

         public Criteria andTelephoneGreaterThan(String value)
         {
              addCriterion("telephone > ", value, "telephone");
              return (Criteria) this;
         }

         public Criteria andTelephoneGreaterThanOrEqualTo(String value)
         {
              addCriterion("telephone >= ", value, "telephone");
              return (Criteria) this;
         }

         public Criteria andTelephoneLessThan(String value)
         {
              addCriterion("telephone < ", value, "telephone");
              return (Criteria) this;
         }

         public Criteria andTelephoneLessThanOrEqualTo(String value)
         {
              addCriterion("telephone <= ", value, "telephone");
              return (Criteria) this;
         }

         public Criteria andTelephoneLike(String value)
         {
              addCriterion("telephone like ", value, "telephone");
              return (Criteria) this;
         }

         public Criteria andTelephoneNotLike(String value)
         {
              addCriterion("telephone not like ", value, "telephone");
              return (Criteria) this;
         }

         public Criteria andTelephoneIn(List<String> values)
         {
              addCriterion("telephone in ", values, "telephone");
              return (Criteria) this;
         }

         public Criteria andTelephoneNotIn(List<String> values)
         {
              addCriterion("telephone not in ", values, "telephone");
              return (Criteria) this;
         }

         public Criteria andTelephoneBetween(String value1, String value2)
         {
              addCriterion("telephone between ", value1,value2, "telephone");
              return (Criteria) this;
         }

         public Criteria andTelephoneNotBetween(String value1, String value2)
         {
              addCriterion("telephone not between ", value1,value2, "telephone");
              return (Criteria) this;
         }

         public Criteria andEmailIsNull()
         {
              addCriterion("email is null");
              return (Criteria) this;
         }

         public Criteria andEmailIsNotNull()
         {
              addCriterion("email is not null");
              return (Criteria) this;
         }

         public Criteria andEmailEqualTo(String value)
         {
              addCriterion("email = ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailNotEqualTo(String value)
         {
              addCriterion("email <> ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailGreaterThan(String value)
         {
              addCriterion("email > ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailGreaterThanOrEqualTo(String value)
         {
              addCriterion("email >= ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailLessThan(String value)
         {
              addCriterion("email < ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailLessThanOrEqualTo(String value)
         {
              addCriterion("email <= ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailLike(String value)
         {
              addCriterion("email like ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailNotLike(String value)
         {
              addCriterion("email not like ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailIn(List<String> values)
         {
              addCriterion("email in ", values, "email");
              return (Criteria) this;
         }

         public Criteria andEmailNotIn(List<String> values)
         {
              addCriterion("email not in ", values, "email");
              return (Criteria) this;
         }

         public Criteria andEmailBetween(String value1, String value2)
         {
              addCriterion("email between ", value1,value2, "email");
              return (Criteria) this;
         }

         public Criteria andEmailNotBetween(String value1, String value2)
         {
              addCriterion("email not between ", value1,value2, "email");
              return (Criteria) this;
         }

         public Criteria andPostcodeIsNull()
         {
              addCriterion("postcode is null");
              return (Criteria) this;
         }

         public Criteria andPostcodeIsNotNull()
         {
              addCriterion("postcode is not null");
              return (Criteria) this;
         }

         public Criteria andPostcodeEqualTo(String value)
         {
              addCriterion("postcode = ", value, "postcode");
              return (Criteria) this;
         }

         public Criteria andPostcodeNotEqualTo(String value)
         {
              addCriterion("postcode <> ", value, "postcode");
              return (Criteria) this;
         }

         public Criteria andPostcodeGreaterThan(String value)
         {
              addCriterion("postcode > ", value, "postcode");
              return (Criteria) this;
         }

         public Criteria andPostcodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("postcode >= ", value, "postcode");
              return (Criteria) this;
         }

         public Criteria andPostcodeLessThan(String value)
         {
              addCriterion("postcode < ", value, "postcode");
              return (Criteria) this;
         }

         public Criteria andPostcodeLessThanOrEqualTo(String value)
         {
              addCriterion("postcode <= ", value, "postcode");
              return (Criteria) this;
         }

         public Criteria andPostcodeLike(String value)
         {
              addCriterion("postcode like ", value, "postcode");
              return (Criteria) this;
         }

         public Criteria andPostcodeNotLike(String value)
         {
              addCriterion("postcode not like ", value, "postcode");
              return (Criteria) this;
         }

         public Criteria andPostcodeIn(List<String> values)
         {
              addCriterion("postcode in ", values, "postcode");
              return (Criteria) this;
         }

         public Criteria andPostcodeNotIn(List<String> values)
         {
              addCriterion("postcode not in ", values, "postcode");
              return (Criteria) this;
         }

         public Criteria andPostcodeBetween(String value1, String value2)
         {
              addCriterion("postcode between ", value1,value2, "postcode");
              return (Criteria) this;
         }

         public Criteria andPostcodeNotBetween(String value1, String value2)
         {
              addCriterion("postcode not between ", value1,value2, "postcode");
              return (Criteria) this;
         }

         public Criteria andAddressIsNull()
         {
              addCriterion("address is null");
              return (Criteria) this;
         }

         public Criteria andAddressIsNotNull()
         {
              addCriterion("address is not null");
              return (Criteria) this;
         }

         public Criteria andAddressEqualTo(String value)
         {
              addCriterion("address = ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressNotEqualTo(String value)
         {
              addCriterion("address <> ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressGreaterThan(String value)
         {
              addCriterion("address > ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressGreaterThanOrEqualTo(String value)
         {
              addCriterion("address >= ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressLessThan(String value)
         {
              addCriterion("address < ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressLessThanOrEqualTo(String value)
         {
              addCriterion("address <= ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressLike(String value)
         {
              addCriterion("address like ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressNotLike(String value)
         {
              addCriterion("address not like ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressIn(List<String> values)
         {
              addCriterion("address in ", values, "address");
              return (Criteria) this;
         }

         public Criteria andAddressNotIn(List<String> values)
         {
              addCriterion("address not in ", values, "address");
              return (Criteria) this;
         }

         public Criteria andAddressBetween(String value1, String value2)
         {
              addCriterion("address between ", value1,value2, "address");
              return (Criteria) this;
         }

         public Criteria andAddressNotBetween(String value1, String value2)
         {
              addCriterion("address not between ", value1,value2, "address");
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
