package com.gooagoo.entity.generator.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 个人用户表
 */

public class UserInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public UserInfoExample()
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

         public Criteria andUserTypeIsNull()
         {
              addCriterion("user_type is null");
              return (Criteria) this;
         }

         public Criteria andUserTypeIsNotNull()
         {
              addCriterion("user_type is not null");
              return (Criteria) this;
         }

         public Criteria andUserTypeEqualTo(String value)
         {
              addCriterion("user_type = ", value, "user_type");
              return (Criteria) this;
         }

         public Criteria andUserTypeNotEqualTo(String value)
         {
              addCriterion("user_type <> ", value, "user_type");
              return (Criteria) this;
         }

         public Criteria andUserTypeGreaterThan(String value)
         {
              addCriterion("user_type > ", value, "user_type");
              return (Criteria) this;
         }

         public Criteria andUserTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("user_type >= ", value, "user_type");
              return (Criteria) this;
         }

         public Criteria andUserTypeLessThan(String value)
         {
              addCriterion("user_type < ", value, "user_type");
              return (Criteria) this;
         }

         public Criteria andUserTypeLessThanOrEqualTo(String value)
         {
              addCriterion("user_type <= ", value, "user_type");
              return (Criteria) this;
         }

         public Criteria andUserTypeLike(String value)
         {
              addCriterion("user_type like ", value, "user_type");
              return (Criteria) this;
         }

         public Criteria andUserTypeNotLike(String value)
         {
              addCriterion("user_type not like ", value, "user_type");
              return (Criteria) this;
         }

         public Criteria andUserTypeIn(List<String> values)
         {
              addCriterion("user_type in ", values, "user_type");
              return (Criteria) this;
         }

         public Criteria andUserTypeNotIn(List<String> values)
         {
              addCriterion("user_type not in ", values, "user_type");
              return (Criteria) this;
         }

         public Criteria andUserTypeBetween(String value1, String value2)
         {
              addCriterion("user_type between ", value1,value2, "user_type");
              return (Criteria) this;
         }

         public Criteria andUserTypeNotBetween(String value1, String value2)
         {
              addCriterion("user_type not between ", value1,value2, "user_type");
              return (Criteria) this;
         }

         public Criteria andUserStatusIsNull()
         {
              addCriterion("user_status is null");
              return (Criteria) this;
         }

         public Criteria andUserStatusIsNotNull()
         {
              addCriterion("user_status is not null");
              return (Criteria) this;
         }

         public Criteria andUserStatusEqualTo(String value)
         {
              addCriterion("user_status = ", value, "user_status");
              return (Criteria) this;
         }

         public Criteria andUserStatusNotEqualTo(String value)
         {
              addCriterion("user_status <> ", value, "user_status");
              return (Criteria) this;
         }

         public Criteria andUserStatusGreaterThan(String value)
         {
              addCriterion("user_status > ", value, "user_status");
              return (Criteria) this;
         }

         public Criteria andUserStatusGreaterThanOrEqualTo(String value)
         {
              addCriterion("user_status >= ", value, "user_status");
              return (Criteria) this;
         }

         public Criteria andUserStatusLessThan(String value)
         {
              addCriterion("user_status < ", value, "user_status");
              return (Criteria) this;
         }

         public Criteria andUserStatusLessThanOrEqualTo(String value)
         {
              addCriterion("user_status <= ", value, "user_status");
              return (Criteria) this;
         }

         public Criteria andUserStatusLike(String value)
         {
              addCriterion("user_status like ", value, "user_status");
              return (Criteria) this;
         }

         public Criteria andUserStatusNotLike(String value)
         {
              addCriterion("user_status not like ", value, "user_status");
              return (Criteria) this;
         }

         public Criteria andUserStatusIn(List<String> values)
         {
              addCriterion("user_status in ", values, "user_status");
              return (Criteria) this;
         }

         public Criteria andUserStatusNotIn(List<String> values)
         {
              addCriterion("user_status not in ", values, "user_status");
              return (Criteria) this;
         }

         public Criteria andUserStatusBetween(String value1, String value2)
         {
              addCriterion("user_status between ", value1,value2, "user_status");
              return (Criteria) this;
         }

         public Criteria andUserStatusNotBetween(String value1, String value2)
         {
              addCriterion("user_status not between ", value1,value2, "user_status");
              return (Criteria) this;
         }

         public Criteria andUserNumIsNull()
         {
              addCriterion("user_num is null");
              return (Criteria) this;
         }

         public Criteria andUserNumIsNotNull()
         {
              addCriterion("user_num is not null");
              return (Criteria) this;
         }

         public Criteria andUserNumEqualTo(String value)
         {
              addCriterion("user_num = ", value, "user_num");
              return (Criteria) this;
         }

         public Criteria andUserNumNotEqualTo(String value)
         {
              addCriterion("user_num <> ", value, "user_num");
              return (Criteria) this;
         }

         public Criteria andUserNumGreaterThan(String value)
         {
              addCriterion("user_num > ", value, "user_num");
              return (Criteria) this;
         }

         public Criteria andUserNumGreaterThanOrEqualTo(String value)
         {
              addCriterion("user_num >= ", value, "user_num");
              return (Criteria) this;
         }

         public Criteria andUserNumLessThan(String value)
         {
              addCriterion("user_num < ", value, "user_num");
              return (Criteria) this;
         }

         public Criteria andUserNumLessThanOrEqualTo(String value)
         {
              addCriterion("user_num <= ", value, "user_num");
              return (Criteria) this;
         }

         public Criteria andUserNumLike(String value)
         {
              addCriterion("user_num like ", value, "user_num");
              return (Criteria) this;
         }

         public Criteria andUserNumNotLike(String value)
         {
              addCriterion("user_num not like ", value, "user_num");
              return (Criteria) this;
         }

         public Criteria andUserNumIn(List<String> values)
         {
              addCriterion("user_num in ", values, "user_num");
              return (Criteria) this;
         }

         public Criteria andUserNumNotIn(List<String> values)
         {
              addCriterion("user_num not in ", values, "user_num");
              return (Criteria) this;
         }

         public Criteria andUserNumBetween(String value1, String value2)
         {
              addCriterion("user_num between ", value1,value2, "user_num");
              return (Criteria) this;
         }

         public Criteria andUserNumNotBetween(String value1, String value2)
         {
              addCriterion("user_num not between ", value1,value2, "user_num");
              return (Criteria) this;
         }

         public Criteria andIsActiveEmailIsNull()
         {
              addCriterion("is_active_email is null");
              return (Criteria) this;
         }

         public Criteria andIsActiveEmailIsNotNull()
         {
              addCriterion("is_active_email is not null");
              return (Criteria) this;
         }

         public Criteria andIsActiveEmailEqualTo(String value)
         {
              addCriterion("is_active_email = ", value, "is_active_email");
              return (Criteria) this;
         }

         public Criteria andIsActiveEmailNotEqualTo(String value)
         {
              addCriterion("is_active_email <> ", value, "is_active_email");
              return (Criteria) this;
         }

         public Criteria andIsActiveEmailGreaterThan(String value)
         {
              addCriterion("is_active_email > ", value, "is_active_email");
              return (Criteria) this;
         }

         public Criteria andIsActiveEmailGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_active_email >= ", value, "is_active_email");
              return (Criteria) this;
         }

         public Criteria andIsActiveEmailLessThan(String value)
         {
              addCriterion("is_active_email < ", value, "is_active_email");
              return (Criteria) this;
         }

         public Criteria andIsActiveEmailLessThanOrEqualTo(String value)
         {
              addCriterion("is_active_email <= ", value, "is_active_email");
              return (Criteria) this;
         }

         public Criteria andIsActiveEmailLike(String value)
         {
              addCriterion("is_active_email like ", value, "is_active_email");
              return (Criteria) this;
         }

         public Criteria andIsActiveEmailNotLike(String value)
         {
              addCriterion("is_active_email not like ", value, "is_active_email");
              return (Criteria) this;
         }

         public Criteria andIsActiveEmailIn(List<String> values)
         {
              addCriterion("is_active_email in ", values, "is_active_email");
              return (Criteria) this;
         }

         public Criteria andIsActiveEmailNotIn(List<String> values)
         {
              addCriterion("is_active_email not in ", values, "is_active_email");
              return (Criteria) this;
         }

         public Criteria andIsActiveEmailBetween(String value1, String value2)
         {
              addCriterion("is_active_email between ", value1,value2, "is_active_email");
              return (Criteria) this;
         }

         public Criteria andIsActiveEmailNotBetween(String value1, String value2)
         {
              addCriterion("is_active_email not between ", value1,value2, "is_active_email");
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
