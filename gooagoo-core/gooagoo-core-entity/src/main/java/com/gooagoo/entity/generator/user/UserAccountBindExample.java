package com.gooagoo.entity.generator.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 描述购阿购平台用户帐号与第三方平台用户帐号的绑定关系。一个购阿购平台用户帐号可以绑定多个第三方平台用户帐号。
 */

public class UserAccountBindExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public UserAccountBindExample()
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

         public Criteria andThirdAccountTypeIsNull()
         {
              addCriterion("third_account_type is null");
              return (Criteria) this;
         }

         public Criteria andThirdAccountTypeIsNotNull()
         {
              addCriterion("third_account_type is not null");
              return (Criteria) this;
         }

         public Criteria andThirdAccountTypeEqualTo(String value)
         {
              addCriterion("third_account_type = ", value, "third_account_type");
              return (Criteria) this;
         }

         public Criteria andThirdAccountTypeNotEqualTo(String value)
         {
              addCriterion("third_account_type <> ", value, "third_account_type");
              return (Criteria) this;
         }

         public Criteria andThirdAccountTypeGreaterThan(String value)
         {
              addCriterion("third_account_type > ", value, "third_account_type");
              return (Criteria) this;
         }

         public Criteria andThirdAccountTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("third_account_type >= ", value, "third_account_type");
              return (Criteria) this;
         }

         public Criteria andThirdAccountTypeLessThan(String value)
         {
              addCriterion("third_account_type < ", value, "third_account_type");
              return (Criteria) this;
         }

         public Criteria andThirdAccountTypeLessThanOrEqualTo(String value)
         {
              addCriterion("third_account_type <= ", value, "third_account_type");
              return (Criteria) this;
         }

         public Criteria andThirdAccountTypeLike(String value)
         {
              addCriterion("third_account_type like ", value, "third_account_type");
              return (Criteria) this;
         }

         public Criteria andThirdAccountTypeNotLike(String value)
         {
              addCriterion("third_account_type not like ", value, "third_account_type");
              return (Criteria) this;
         }

         public Criteria andThirdAccountTypeIn(List<String> values)
         {
              addCriterion("third_account_type in ", values, "third_account_type");
              return (Criteria) this;
         }

         public Criteria andThirdAccountTypeNotIn(List<String> values)
         {
              addCriterion("third_account_type not in ", values, "third_account_type");
              return (Criteria) this;
         }

         public Criteria andThirdAccountTypeBetween(String value1, String value2)
         {
              addCriterion("third_account_type between ", value1,value2, "third_account_type");
              return (Criteria) this;
         }

         public Criteria andThirdAccountTypeNotBetween(String value1, String value2)
         {
              addCriterion("third_account_type not between ", value1,value2, "third_account_type");
              return (Criteria) this;
         }

         public Criteria andThirdAccountIsNull()
         {
              addCriterion("third_account is null");
              return (Criteria) this;
         }

         public Criteria andThirdAccountIsNotNull()
         {
              addCriterion("third_account is not null");
              return (Criteria) this;
         }

         public Criteria andThirdAccountEqualTo(String value)
         {
              addCriterion("third_account = ", value, "third_account");
              return (Criteria) this;
         }

         public Criteria andThirdAccountNotEqualTo(String value)
         {
              addCriterion("third_account <> ", value, "third_account");
              return (Criteria) this;
         }

         public Criteria andThirdAccountGreaterThan(String value)
         {
              addCriterion("third_account > ", value, "third_account");
              return (Criteria) this;
         }

         public Criteria andThirdAccountGreaterThanOrEqualTo(String value)
         {
              addCriterion("third_account >= ", value, "third_account");
              return (Criteria) this;
         }

         public Criteria andThirdAccountLessThan(String value)
         {
              addCriterion("third_account < ", value, "third_account");
              return (Criteria) this;
         }

         public Criteria andThirdAccountLessThanOrEqualTo(String value)
         {
              addCriterion("third_account <= ", value, "third_account");
              return (Criteria) this;
         }

         public Criteria andThirdAccountLike(String value)
         {
              addCriterion("third_account like ", value, "third_account");
              return (Criteria) this;
         }

         public Criteria andThirdAccountNotLike(String value)
         {
              addCriterion("third_account not like ", value, "third_account");
              return (Criteria) this;
         }

         public Criteria andThirdAccountIn(List<String> values)
         {
              addCriterion("third_account in ", values, "third_account");
              return (Criteria) this;
         }

         public Criteria andThirdAccountNotIn(List<String> values)
         {
              addCriterion("third_account not in ", values, "third_account");
              return (Criteria) this;
         }

         public Criteria andThirdAccountBetween(String value1, String value2)
         {
              addCriterion("third_account between ", value1,value2, "third_account");
              return (Criteria) this;
         }

         public Criteria andThirdAccountNotBetween(String value1, String value2)
         {
              addCriterion("third_account not between ", value1,value2, "third_account");
              return (Criteria) this;
         }

         public Criteria andAuthorizeIdIsNull()
         {
              addCriterion("authorize_id is null");
              return (Criteria) this;
         }

         public Criteria andAuthorizeIdIsNotNull()
         {
              addCriterion("authorize_id is not null");
              return (Criteria) this;
         }

         public Criteria andAuthorizeIdEqualTo(String value)
         {
              addCriterion("authorize_id = ", value, "authorize_id");
              return (Criteria) this;
         }

         public Criteria andAuthorizeIdNotEqualTo(String value)
         {
              addCriterion("authorize_id <> ", value, "authorize_id");
              return (Criteria) this;
         }

         public Criteria andAuthorizeIdGreaterThan(String value)
         {
              addCriterion("authorize_id > ", value, "authorize_id");
              return (Criteria) this;
         }

         public Criteria andAuthorizeIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("authorize_id >= ", value, "authorize_id");
              return (Criteria) this;
         }

         public Criteria andAuthorizeIdLessThan(String value)
         {
              addCriterion("authorize_id < ", value, "authorize_id");
              return (Criteria) this;
         }

         public Criteria andAuthorizeIdLessThanOrEqualTo(String value)
         {
              addCriterion("authorize_id <= ", value, "authorize_id");
              return (Criteria) this;
         }

         public Criteria andAuthorizeIdLike(String value)
         {
              addCriterion("authorize_id like ", value, "authorize_id");
              return (Criteria) this;
         }

         public Criteria andAuthorizeIdNotLike(String value)
         {
              addCriterion("authorize_id not like ", value, "authorize_id");
              return (Criteria) this;
         }

         public Criteria andAuthorizeIdIn(List<String> values)
         {
              addCriterion("authorize_id in ", values, "authorize_id");
              return (Criteria) this;
         }

         public Criteria andAuthorizeIdNotIn(List<String> values)
         {
              addCriterion("authorize_id not in ", values, "authorize_id");
              return (Criteria) this;
         }

         public Criteria andAuthorizeIdBetween(String value1, String value2)
         {
              addCriterion("authorize_id between ", value1,value2, "authorize_id");
              return (Criteria) this;
         }

         public Criteria andAuthorizeIdNotBetween(String value1, String value2)
         {
              addCriterion("authorize_id not between ", value1,value2, "authorize_id");
              return (Criteria) this;
         }

         public Criteria andAuthorizeExpireTimeIsNull()
         {
              addCriterion("authorize_expire_time is null");
              return (Criteria) this;
         }

         public Criteria andAuthorizeExpireTimeIsNotNull()
         {
              addCriterion("authorize_expire_time is not null");
              return (Criteria) this;
         }

         public Criteria andAuthorizeExpireTimeEqualTo(Date value)
         {
              addCriterion("authorize_expire_time = ", value, "authorize_expire_time");
              return (Criteria) this;
         }

         public Criteria andAuthorizeExpireTimeNotEqualTo(Date value)
         {
              addCriterion("authorize_expire_time <> ", value, "authorize_expire_time");
              return (Criteria) this;
         }

         public Criteria andAuthorizeExpireTimeGreaterThan(Date value)
         {
              addCriterion("authorize_expire_time > ", value, "authorize_expire_time");
              return (Criteria) this;
         }

         public Criteria andAuthorizeExpireTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("authorize_expire_time >= ", value, "authorize_expire_time");
              return (Criteria) this;
         }

         public Criteria andAuthorizeExpireTimeLessThan(Date value)
         {
              addCriterion("authorize_expire_time < ", value, "authorize_expire_time");
              return (Criteria) this;
         }

         public Criteria andAuthorizeExpireTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("authorize_expire_time <= ", value, "authorize_expire_time");
              return (Criteria) this;
         }

         public Criteria andAuthorizeExpireTimeIn(List<Date> values)
         {
              addCriterion("authorize_expire_time in ", values, "authorize_expire_time");
              return (Criteria) this;
         }

         public Criteria andAuthorizeExpireTimeNotIn(List<Date> values)
         {
              addCriterion("authorize_expire_time not in ", values, "authorize_expire_time");
              return (Criteria) this;
         }

         public Criteria andAuthorizeExpireTimeBetween(Date value1, Date value2)
         {
              addCriterion("authorize_expire_time between ", value1,value2, "authorize_expire_time");
              return (Criteria) this;
         }

         public Criteria andAuthorizeExpireTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("authorize_expire_time not between ", value1,value2, "authorize_expire_time");
              return (Criteria) this;
         }

         public Criteria andNoteIsNull()
         {
              addCriterion("note is null");
              return (Criteria) this;
         }

         public Criteria andNoteIsNotNull()
         {
              addCriterion("note is not null");
              return (Criteria) this;
         }

         public Criteria andNoteEqualTo(String value)
         {
              addCriterion("note = ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteNotEqualTo(String value)
         {
              addCriterion("note <> ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteGreaterThan(String value)
         {
              addCriterion("note > ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteGreaterThanOrEqualTo(String value)
         {
              addCriterion("note >= ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteLessThan(String value)
         {
              addCriterion("note < ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteLessThanOrEqualTo(String value)
         {
              addCriterion("note <= ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteLike(String value)
         {
              addCriterion("note like ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteNotLike(String value)
         {
              addCriterion("note not like ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteIn(List<String> values)
         {
              addCriterion("note in ", values, "note");
              return (Criteria) this;
         }

         public Criteria andNoteNotIn(List<String> values)
         {
              addCriterion("note not in ", values, "note");
              return (Criteria) this;
         }

         public Criteria andNoteBetween(String value1, String value2)
         {
              addCriterion("note between ", value1,value2, "note");
              return (Criteria) this;
         }

         public Criteria andNoteNotBetween(String value1, String value2)
         {
              addCriterion("note not between ", value1,value2, "note");
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
