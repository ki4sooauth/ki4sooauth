package com.gooagoo.entity.generator.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 后台管理系统用户信息表
 */

public class SysUserInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public SysUserInfoExample()
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

         public Criteria andPasswordIsNull()
         {
              addCriterion("password is null");
              return (Criteria) this;
         }

         public Criteria andPasswordIsNotNull()
         {
              addCriterion("password is not null");
              return (Criteria) this;
         }

         public Criteria andPasswordEqualTo(String value)
         {
              addCriterion("password = ", value, "password");
              return (Criteria) this;
         }

         public Criteria andPasswordNotEqualTo(String value)
         {
              addCriterion("password <> ", value, "password");
              return (Criteria) this;
         }

         public Criteria andPasswordGreaterThan(String value)
         {
              addCriterion("password > ", value, "password");
              return (Criteria) this;
         }

         public Criteria andPasswordGreaterThanOrEqualTo(String value)
         {
              addCriterion("password >= ", value, "password");
              return (Criteria) this;
         }

         public Criteria andPasswordLessThan(String value)
         {
              addCriterion("password < ", value, "password");
              return (Criteria) this;
         }

         public Criteria andPasswordLessThanOrEqualTo(String value)
         {
              addCriterion("password <= ", value, "password");
              return (Criteria) this;
         }

         public Criteria andPasswordLike(String value)
         {
              addCriterion("password like ", value, "password");
              return (Criteria) this;
         }

         public Criteria andPasswordNotLike(String value)
         {
              addCriterion("password not like ", value, "password");
              return (Criteria) this;
         }

         public Criteria andPasswordIn(List<String> values)
         {
              addCriterion("password in ", values, "password");
              return (Criteria) this;
         }

         public Criteria andPasswordNotIn(List<String> values)
         {
              addCriterion("password not in ", values, "password");
              return (Criteria) this;
         }

         public Criteria andPasswordBetween(String value1, String value2)
         {
              addCriterion("password between ", value1,value2, "password");
              return (Criteria) this;
         }

         public Criteria andPasswordNotBetween(String value1, String value2)
         {
              addCriterion("password not between ", value1,value2, "password");
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

         public Criteria andDepartmentIsNull()
         {
              addCriterion("department is null");
              return (Criteria) this;
         }

         public Criteria andDepartmentIsNotNull()
         {
              addCriterion("department is not null");
              return (Criteria) this;
         }

         public Criteria andDepartmentEqualTo(String value)
         {
              addCriterion("department = ", value, "department");
              return (Criteria) this;
         }

         public Criteria andDepartmentNotEqualTo(String value)
         {
              addCriterion("department <> ", value, "department");
              return (Criteria) this;
         }

         public Criteria andDepartmentGreaterThan(String value)
         {
              addCriterion("department > ", value, "department");
              return (Criteria) this;
         }

         public Criteria andDepartmentGreaterThanOrEqualTo(String value)
         {
              addCriterion("department >= ", value, "department");
              return (Criteria) this;
         }

         public Criteria andDepartmentLessThan(String value)
         {
              addCriterion("department < ", value, "department");
              return (Criteria) this;
         }

         public Criteria andDepartmentLessThanOrEqualTo(String value)
         {
              addCriterion("department <= ", value, "department");
              return (Criteria) this;
         }

         public Criteria andDepartmentLike(String value)
         {
              addCriterion("department like ", value, "department");
              return (Criteria) this;
         }

         public Criteria andDepartmentNotLike(String value)
         {
              addCriterion("department not like ", value, "department");
              return (Criteria) this;
         }

         public Criteria andDepartmentIn(List<String> values)
         {
              addCriterion("department in ", values, "department");
              return (Criteria) this;
         }

         public Criteria andDepartmentNotIn(List<String> values)
         {
              addCriterion("department not in ", values, "department");
              return (Criteria) this;
         }

         public Criteria andDepartmentBetween(String value1, String value2)
         {
              addCriterion("department between ", value1,value2, "department");
              return (Criteria) this;
         }

         public Criteria andDepartmentNotBetween(String value1, String value2)
         {
              addCriterion("department not between ", value1,value2, "department");
              return (Criteria) this;
         }

         public Criteria andIsAdminIsNull()
         {
              addCriterion("is_admin is null");
              return (Criteria) this;
         }

         public Criteria andIsAdminIsNotNull()
         {
              addCriterion("is_admin is not null");
              return (Criteria) this;
         }

         public Criteria andIsAdminEqualTo(String value)
         {
              addCriterion("is_admin = ", value, "is_admin");
              return (Criteria) this;
         }

         public Criteria andIsAdminNotEqualTo(String value)
         {
              addCriterion("is_admin <> ", value, "is_admin");
              return (Criteria) this;
         }

         public Criteria andIsAdminGreaterThan(String value)
         {
              addCriterion("is_admin > ", value, "is_admin");
              return (Criteria) this;
         }

         public Criteria andIsAdminGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_admin >= ", value, "is_admin");
              return (Criteria) this;
         }

         public Criteria andIsAdminLessThan(String value)
         {
              addCriterion("is_admin < ", value, "is_admin");
              return (Criteria) this;
         }

         public Criteria andIsAdminLessThanOrEqualTo(String value)
         {
              addCriterion("is_admin <= ", value, "is_admin");
              return (Criteria) this;
         }

         public Criteria andIsAdminLike(String value)
         {
              addCriterion("is_admin like ", value, "is_admin");
              return (Criteria) this;
         }

         public Criteria andIsAdminNotLike(String value)
         {
              addCriterion("is_admin not like ", value, "is_admin");
              return (Criteria) this;
         }

         public Criteria andIsAdminIn(List<String> values)
         {
              addCriterion("is_admin in ", values, "is_admin");
              return (Criteria) this;
         }

         public Criteria andIsAdminNotIn(List<String> values)
         {
              addCriterion("is_admin not in ", values, "is_admin");
              return (Criteria) this;
         }

         public Criteria andIsAdminBetween(String value1, String value2)
         {
              addCriterion("is_admin between ", value1,value2, "is_admin");
              return (Criteria) this;
         }

         public Criteria andIsAdminNotBetween(String value1, String value2)
         {
              addCriterion("is_admin not between ", value1,value2, "is_admin");
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
