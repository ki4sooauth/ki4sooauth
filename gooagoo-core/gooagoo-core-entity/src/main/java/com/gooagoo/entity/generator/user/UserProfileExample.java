package com.gooagoo.entity.generator.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 用户辅助信息
 */

public class UserProfileExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public UserProfileExample()
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

         public Criteria andRealNameIsNull()
         {
              addCriterion("real_name is null");
              return (Criteria) this;
         }

         public Criteria andRealNameIsNotNull()
         {
              addCriterion("real_name is not null");
              return (Criteria) this;
         }

         public Criteria andRealNameEqualTo(String value)
         {
              addCriterion("real_name = ", value, "real_name");
              return (Criteria) this;
         }

         public Criteria andRealNameNotEqualTo(String value)
         {
              addCriterion("real_name <> ", value, "real_name");
              return (Criteria) this;
         }

         public Criteria andRealNameGreaterThan(String value)
         {
              addCriterion("real_name > ", value, "real_name");
              return (Criteria) this;
         }

         public Criteria andRealNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("real_name >= ", value, "real_name");
              return (Criteria) this;
         }

         public Criteria andRealNameLessThan(String value)
         {
              addCriterion("real_name < ", value, "real_name");
              return (Criteria) this;
         }

         public Criteria andRealNameLessThanOrEqualTo(String value)
         {
              addCriterion("real_name <= ", value, "real_name");
              return (Criteria) this;
         }

         public Criteria andRealNameLike(String value)
         {
              addCriterion("real_name like ", value, "real_name");
              return (Criteria) this;
         }

         public Criteria andRealNameNotLike(String value)
         {
              addCriterion("real_name not like ", value, "real_name");
              return (Criteria) this;
         }

         public Criteria andRealNameIn(List<String> values)
         {
              addCriterion("real_name in ", values, "real_name");
              return (Criteria) this;
         }

         public Criteria andRealNameNotIn(List<String> values)
         {
              addCriterion("real_name not in ", values, "real_name");
              return (Criteria) this;
         }

         public Criteria andRealNameBetween(String value1, String value2)
         {
              addCriterion("real_name between ", value1,value2, "real_name");
              return (Criteria) this;
         }

         public Criteria andRealNameNotBetween(String value1, String value2)
         {
              addCriterion("real_name not between ", value1,value2, "real_name");
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

         public Criteria andPostCodeIsNull()
         {
              addCriterion("post_code is null");
              return (Criteria) this;
         }

         public Criteria andPostCodeIsNotNull()
         {
              addCriterion("post_code is not null");
              return (Criteria) this;
         }

         public Criteria andPostCodeEqualTo(String value)
         {
              addCriterion("post_code = ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeNotEqualTo(String value)
         {
              addCriterion("post_code <> ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeGreaterThan(String value)
         {
              addCriterion("post_code > ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("post_code >= ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeLessThan(String value)
         {
              addCriterion("post_code < ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeLessThanOrEqualTo(String value)
         {
              addCriterion("post_code <= ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeLike(String value)
         {
              addCriterion("post_code like ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeNotLike(String value)
         {
              addCriterion("post_code not like ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeIn(List<String> values)
         {
              addCriterion("post_code in ", values, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeNotIn(List<String> values)
         {
              addCriterion("post_code not in ", values, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeBetween(String value1, String value2)
         {
              addCriterion("post_code between ", value1,value2, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeNotBetween(String value1, String value2)
         {
              addCriterion("post_code not between ", value1,value2, "post_code");
              return (Criteria) this;
         }

         public Criteria andProvinceIsNull()
         {
              addCriterion("province is null");
              return (Criteria) this;
         }

         public Criteria andProvinceIsNotNull()
         {
              addCriterion("province is not null");
              return (Criteria) this;
         }

         public Criteria andProvinceEqualTo(String value)
         {
              addCriterion("province = ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceNotEqualTo(String value)
         {
              addCriterion("province <> ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceGreaterThan(String value)
         {
              addCriterion("province > ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceGreaterThanOrEqualTo(String value)
         {
              addCriterion("province >= ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceLessThan(String value)
         {
              addCriterion("province < ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceLessThanOrEqualTo(String value)
         {
              addCriterion("province <= ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceLike(String value)
         {
              addCriterion("province like ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceNotLike(String value)
         {
              addCriterion("province not like ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceIn(List<String> values)
         {
              addCriterion("province in ", values, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceNotIn(List<String> values)
         {
              addCriterion("province not in ", values, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceBetween(String value1, String value2)
         {
              addCriterion("province between ", value1,value2, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceNotBetween(String value1, String value2)
         {
              addCriterion("province not between ", value1,value2, "province");
              return (Criteria) this;
         }

         public Criteria andCityIsNull()
         {
              addCriterion("city is null");
              return (Criteria) this;
         }

         public Criteria andCityIsNotNull()
         {
              addCriterion("city is not null");
              return (Criteria) this;
         }

         public Criteria andCityEqualTo(String value)
         {
              addCriterion("city = ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityNotEqualTo(String value)
         {
              addCriterion("city <> ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityGreaterThan(String value)
         {
              addCriterion("city > ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityGreaterThanOrEqualTo(String value)
         {
              addCriterion("city >= ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityLessThan(String value)
         {
              addCriterion("city < ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityLessThanOrEqualTo(String value)
         {
              addCriterion("city <= ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityLike(String value)
         {
              addCriterion("city like ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityNotLike(String value)
         {
              addCriterion("city not like ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityIn(List<String> values)
         {
              addCriterion("city in ", values, "city");
              return (Criteria) this;
         }

         public Criteria andCityNotIn(List<String> values)
         {
              addCriterion("city not in ", values, "city");
              return (Criteria) this;
         }

         public Criteria andCityBetween(String value1, String value2)
         {
              addCriterion("city between ", value1,value2, "city");
              return (Criteria) this;
         }

         public Criteria andCityNotBetween(String value1, String value2)
         {
              addCriterion("city not between ", value1,value2, "city");
              return (Criteria) this;
         }

         public Criteria andAreaIsNull()
         {
              addCriterion("area is null");
              return (Criteria) this;
         }

         public Criteria andAreaIsNotNull()
         {
              addCriterion("area is not null");
              return (Criteria) this;
         }

         public Criteria andAreaEqualTo(String value)
         {
              addCriterion("area = ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaNotEqualTo(String value)
         {
              addCriterion("area <> ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaGreaterThan(String value)
         {
              addCriterion("area > ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaGreaterThanOrEqualTo(String value)
         {
              addCriterion("area >= ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaLessThan(String value)
         {
              addCriterion("area < ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaLessThanOrEqualTo(String value)
         {
              addCriterion("area <= ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaLike(String value)
         {
              addCriterion("area like ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaNotLike(String value)
         {
              addCriterion("area not like ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaIn(List<String> values)
         {
              addCriterion("area in ", values, "area");
              return (Criteria) this;
         }

         public Criteria andAreaNotIn(List<String> values)
         {
              addCriterion("area not in ", values, "area");
              return (Criteria) this;
         }

         public Criteria andAreaBetween(String value1, String value2)
         {
              addCriterion("area between ", value1,value2, "area");
              return (Criteria) this;
         }

         public Criteria andAreaNotBetween(String value1, String value2)
         {
              addCriterion("area not between ", value1,value2, "area");
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

         public Criteria andRegIpIsNull()
         {
              addCriterion("reg_ip is null");
              return (Criteria) this;
         }

         public Criteria andRegIpIsNotNull()
         {
              addCriterion("reg_ip is not null");
              return (Criteria) this;
         }

         public Criteria andRegIpEqualTo(String value)
         {
              addCriterion("reg_ip = ", value, "reg_ip");
              return (Criteria) this;
         }

         public Criteria andRegIpNotEqualTo(String value)
         {
              addCriterion("reg_ip <> ", value, "reg_ip");
              return (Criteria) this;
         }

         public Criteria andRegIpGreaterThan(String value)
         {
              addCriterion("reg_ip > ", value, "reg_ip");
              return (Criteria) this;
         }

         public Criteria andRegIpGreaterThanOrEqualTo(String value)
         {
              addCriterion("reg_ip >= ", value, "reg_ip");
              return (Criteria) this;
         }

         public Criteria andRegIpLessThan(String value)
         {
              addCriterion("reg_ip < ", value, "reg_ip");
              return (Criteria) this;
         }

         public Criteria andRegIpLessThanOrEqualTo(String value)
         {
              addCriterion("reg_ip <= ", value, "reg_ip");
              return (Criteria) this;
         }

         public Criteria andRegIpLike(String value)
         {
              addCriterion("reg_ip like ", value, "reg_ip");
              return (Criteria) this;
         }

         public Criteria andRegIpNotLike(String value)
         {
              addCriterion("reg_ip not like ", value, "reg_ip");
              return (Criteria) this;
         }

         public Criteria andRegIpIn(List<String> values)
         {
              addCriterion("reg_ip in ", values, "reg_ip");
              return (Criteria) this;
         }

         public Criteria andRegIpNotIn(List<String> values)
         {
              addCriterion("reg_ip not in ", values, "reg_ip");
              return (Criteria) this;
         }

         public Criteria andRegIpBetween(String value1, String value2)
         {
              addCriterion("reg_ip between ", value1,value2, "reg_ip");
              return (Criteria) this;
         }

         public Criteria andRegIpNotBetween(String value1, String value2)
         {
              addCriterion("reg_ip not between ", value1,value2, "reg_ip");
              return (Criteria) this;
         }

         public Criteria andIsAllowFriendIsNull()
         {
              addCriterion("is_allow_friend is null");
              return (Criteria) this;
         }

         public Criteria andIsAllowFriendIsNotNull()
         {
              addCriterion("is_allow_friend is not null");
              return (Criteria) this;
         }

         public Criteria andIsAllowFriendEqualTo(String value)
         {
              addCriterion("is_allow_friend = ", value, "is_allow_friend");
              return (Criteria) this;
         }

         public Criteria andIsAllowFriendNotEqualTo(String value)
         {
              addCriterion("is_allow_friend <> ", value, "is_allow_friend");
              return (Criteria) this;
         }

         public Criteria andIsAllowFriendGreaterThan(String value)
         {
              addCriterion("is_allow_friend > ", value, "is_allow_friend");
              return (Criteria) this;
         }

         public Criteria andIsAllowFriendGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_allow_friend >= ", value, "is_allow_friend");
              return (Criteria) this;
         }

         public Criteria andIsAllowFriendLessThan(String value)
         {
              addCriterion("is_allow_friend < ", value, "is_allow_friend");
              return (Criteria) this;
         }

         public Criteria andIsAllowFriendLessThanOrEqualTo(String value)
         {
              addCriterion("is_allow_friend <= ", value, "is_allow_friend");
              return (Criteria) this;
         }

         public Criteria andIsAllowFriendLike(String value)
         {
              addCriterion("is_allow_friend like ", value, "is_allow_friend");
              return (Criteria) this;
         }

         public Criteria andIsAllowFriendNotLike(String value)
         {
              addCriterion("is_allow_friend not like ", value, "is_allow_friend");
              return (Criteria) this;
         }

         public Criteria andIsAllowFriendIn(List<String> values)
         {
              addCriterion("is_allow_friend in ", values, "is_allow_friend");
              return (Criteria) this;
         }

         public Criteria andIsAllowFriendNotIn(List<String> values)
         {
              addCriterion("is_allow_friend not in ", values, "is_allow_friend");
              return (Criteria) this;
         }

         public Criteria andIsAllowFriendBetween(String value1, String value2)
         {
              addCriterion("is_allow_friend between ", value1,value2, "is_allow_friend");
              return (Criteria) this;
         }

         public Criteria andIsAllowFriendNotBetween(String value1, String value2)
         {
              addCriterion("is_allow_friend not between ", value1,value2, "is_allow_friend");
              return (Criteria) this;
         }

         public Criteria andHeadPicIsNull()
         {
              addCriterion("head_pic is null");
              return (Criteria) this;
         }

         public Criteria andHeadPicIsNotNull()
         {
              addCriterion("head_pic is not null");
              return (Criteria) this;
         }

         public Criteria andHeadPicEqualTo(String value)
         {
              addCriterion("head_pic = ", value, "head_pic");
              return (Criteria) this;
         }

         public Criteria andHeadPicNotEqualTo(String value)
         {
              addCriterion("head_pic <> ", value, "head_pic");
              return (Criteria) this;
         }

         public Criteria andHeadPicGreaterThan(String value)
         {
              addCriterion("head_pic > ", value, "head_pic");
              return (Criteria) this;
         }

         public Criteria andHeadPicGreaterThanOrEqualTo(String value)
         {
              addCriterion("head_pic >= ", value, "head_pic");
              return (Criteria) this;
         }

         public Criteria andHeadPicLessThan(String value)
         {
              addCriterion("head_pic < ", value, "head_pic");
              return (Criteria) this;
         }

         public Criteria andHeadPicLessThanOrEqualTo(String value)
         {
              addCriterion("head_pic <= ", value, "head_pic");
              return (Criteria) this;
         }

         public Criteria andHeadPicLike(String value)
         {
              addCriterion("head_pic like ", value, "head_pic");
              return (Criteria) this;
         }

         public Criteria andHeadPicNotLike(String value)
         {
              addCriterion("head_pic not like ", value, "head_pic");
              return (Criteria) this;
         }

         public Criteria andHeadPicIn(List<String> values)
         {
              addCriterion("head_pic in ", values, "head_pic");
              return (Criteria) this;
         }

         public Criteria andHeadPicNotIn(List<String> values)
         {
              addCriterion("head_pic not in ", values, "head_pic");
              return (Criteria) this;
         }

         public Criteria andHeadPicBetween(String value1, String value2)
         {
              addCriterion("head_pic between ", value1,value2, "head_pic");
              return (Criteria) this;
         }

         public Criteria andHeadPicNotBetween(String value1, String value2)
         {
              addCriterion("head_pic not between ", value1,value2, "head_pic");
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
