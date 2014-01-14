package com.gooagoo.entity.generator.open;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 应用基本信息表
 */

public class OpenAppInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public OpenAppInfoExample()
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

         public Criteria andAppKeyIsNull()
         {
              addCriterion("app_key is null");
              return (Criteria) this;
         }

         public Criteria andAppKeyIsNotNull()
         {
              addCriterion("app_key is not null");
              return (Criteria) this;
         }

         public Criteria andAppKeyEqualTo(String value)
         {
              addCriterion("app_key = ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyNotEqualTo(String value)
         {
              addCriterion("app_key <> ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyGreaterThan(String value)
         {
              addCriterion("app_key > ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyGreaterThanOrEqualTo(String value)
         {
              addCriterion("app_key >= ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyLessThan(String value)
         {
              addCriterion("app_key < ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyLessThanOrEqualTo(String value)
         {
              addCriterion("app_key <= ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyLike(String value)
         {
              addCriterion("app_key like ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyNotLike(String value)
         {
              addCriterion("app_key not like ", value, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyIn(List<String> values)
         {
              addCriterion("app_key in ", values, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyNotIn(List<String> values)
         {
              addCriterion("app_key not in ", values, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyBetween(String value1, String value2)
         {
              addCriterion("app_key between ", value1,value2, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppKeyNotBetween(String value1, String value2)
         {
              addCriterion("app_key not between ", value1,value2, "app_key");
              return (Criteria) this;
         }

         public Criteria andAppNameIsNull()
         {
              addCriterion("app_name is null");
              return (Criteria) this;
         }

         public Criteria andAppNameIsNotNull()
         {
              addCriterion("app_name is not null");
              return (Criteria) this;
         }

         public Criteria andAppNameEqualTo(String value)
         {
              addCriterion("app_name = ", value, "app_name");
              return (Criteria) this;
         }

         public Criteria andAppNameNotEqualTo(String value)
         {
              addCriterion("app_name <> ", value, "app_name");
              return (Criteria) this;
         }

         public Criteria andAppNameGreaterThan(String value)
         {
              addCriterion("app_name > ", value, "app_name");
              return (Criteria) this;
         }

         public Criteria andAppNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("app_name >= ", value, "app_name");
              return (Criteria) this;
         }

         public Criteria andAppNameLessThan(String value)
         {
              addCriterion("app_name < ", value, "app_name");
              return (Criteria) this;
         }

         public Criteria andAppNameLessThanOrEqualTo(String value)
         {
              addCriterion("app_name <= ", value, "app_name");
              return (Criteria) this;
         }

         public Criteria andAppNameLike(String value)
         {
              addCriterion("app_name like ", value, "app_name");
              return (Criteria) this;
         }

         public Criteria andAppNameNotLike(String value)
         {
              addCriterion("app_name not like ", value, "app_name");
              return (Criteria) this;
         }

         public Criteria andAppNameIn(List<String> values)
         {
              addCriterion("app_name in ", values, "app_name");
              return (Criteria) this;
         }

         public Criteria andAppNameNotIn(List<String> values)
         {
              addCriterion("app_name not in ", values, "app_name");
              return (Criteria) this;
         }

         public Criteria andAppNameBetween(String value1, String value2)
         {
              addCriterion("app_name between ", value1,value2, "app_name");
              return (Criteria) this;
         }

         public Criteria andAppNameNotBetween(String value1, String value2)
         {
              addCriterion("app_name not between ", value1,value2, "app_name");
              return (Criteria) this;
         }

         public Criteria andAppTypeIsNull()
         {
              addCriterion("app_type is null");
              return (Criteria) this;
         }

         public Criteria andAppTypeIsNotNull()
         {
              addCriterion("app_type is not null");
              return (Criteria) this;
         }

         public Criteria andAppTypeEqualTo(String value)
         {
              addCriterion("app_type = ", value, "app_type");
              return (Criteria) this;
         }

         public Criteria andAppTypeNotEqualTo(String value)
         {
              addCriterion("app_type <> ", value, "app_type");
              return (Criteria) this;
         }

         public Criteria andAppTypeGreaterThan(String value)
         {
              addCriterion("app_type > ", value, "app_type");
              return (Criteria) this;
         }

         public Criteria andAppTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("app_type >= ", value, "app_type");
              return (Criteria) this;
         }

         public Criteria andAppTypeLessThan(String value)
         {
              addCriterion("app_type < ", value, "app_type");
              return (Criteria) this;
         }

         public Criteria andAppTypeLessThanOrEqualTo(String value)
         {
              addCriterion("app_type <= ", value, "app_type");
              return (Criteria) this;
         }

         public Criteria andAppTypeLike(String value)
         {
              addCriterion("app_type like ", value, "app_type");
              return (Criteria) this;
         }

         public Criteria andAppTypeNotLike(String value)
         {
              addCriterion("app_type not like ", value, "app_type");
              return (Criteria) this;
         }

         public Criteria andAppTypeIn(List<String> values)
         {
              addCriterion("app_type in ", values, "app_type");
              return (Criteria) this;
         }

         public Criteria andAppTypeNotIn(List<String> values)
         {
              addCriterion("app_type not in ", values, "app_type");
              return (Criteria) this;
         }

         public Criteria andAppTypeBetween(String value1, String value2)
         {
              addCriterion("app_type between ", value1,value2, "app_type");
              return (Criteria) this;
         }

         public Criteria andAppTypeNotBetween(String value1, String value2)
         {
              addCriterion("app_type not between ", value1,value2, "app_type");
              return (Criteria) this;
         }

         public Criteria andAppLabelIsNull()
         {
              addCriterion("app_label is null");
              return (Criteria) this;
         }

         public Criteria andAppLabelIsNotNull()
         {
              addCriterion("app_label is not null");
              return (Criteria) this;
         }

         public Criteria andAppLabelEqualTo(String value)
         {
              addCriterion("app_label = ", value, "app_label");
              return (Criteria) this;
         }

         public Criteria andAppLabelNotEqualTo(String value)
         {
              addCriterion("app_label <> ", value, "app_label");
              return (Criteria) this;
         }

         public Criteria andAppLabelGreaterThan(String value)
         {
              addCriterion("app_label > ", value, "app_label");
              return (Criteria) this;
         }

         public Criteria andAppLabelGreaterThanOrEqualTo(String value)
         {
              addCriterion("app_label >= ", value, "app_label");
              return (Criteria) this;
         }

         public Criteria andAppLabelLessThan(String value)
         {
              addCriterion("app_label < ", value, "app_label");
              return (Criteria) this;
         }

         public Criteria andAppLabelLessThanOrEqualTo(String value)
         {
              addCriterion("app_label <= ", value, "app_label");
              return (Criteria) this;
         }

         public Criteria andAppLabelLike(String value)
         {
              addCriterion("app_label like ", value, "app_label");
              return (Criteria) this;
         }

         public Criteria andAppLabelNotLike(String value)
         {
              addCriterion("app_label not like ", value, "app_label");
              return (Criteria) this;
         }

         public Criteria andAppLabelIn(List<String> values)
         {
              addCriterion("app_label in ", values, "app_label");
              return (Criteria) this;
         }

         public Criteria andAppLabelNotIn(List<String> values)
         {
              addCriterion("app_label not in ", values, "app_label");
              return (Criteria) this;
         }

         public Criteria andAppLabelBetween(String value1, String value2)
         {
              addCriterion("app_label between ", value1,value2, "app_label");
              return (Criteria) this;
         }

         public Criteria andAppLabelNotBetween(String value1, String value2)
         {
              addCriterion("app_label not between ", value1,value2, "app_label");
              return (Criteria) this;
         }

         public Criteria andAppSecretIsNull()
         {
              addCriterion("app_secret is null");
              return (Criteria) this;
         }

         public Criteria andAppSecretIsNotNull()
         {
              addCriterion("app_secret is not null");
              return (Criteria) this;
         }

         public Criteria andAppSecretEqualTo(String value)
         {
              addCriterion("app_secret = ", value, "app_secret");
              return (Criteria) this;
         }

         public Criteria andAppSecretNotEqualTo(String value)
         {
              addCriterion("app_secret <> ", value, "app_secret");
              return (Criteria) this;
         }

         public Criteria andAppSecretGreaterThan(String value)
         {
              addCriterion("app_secret > ", value, "app_secret");
              return (Criteria) this;
         }

         public Criteria andAppSecretGreaterThanOrEqualTo(String value)
         {
              addCriterion("app_secret >= ", value, "app_secret");
              return (Criteria) this;
         }

         public Criteria andAppSecretLessThan(String value)
         {
              addCriterion("app_secret < ", value, "app_secret");
              return (Criteria) this;
         }

         public Criteria andAppSecretLessThanOrEqualTo(String value)
         {
              addCriterion("app_secret <= ", value, "app_secret");
              return (Criteria) this;
         }

         public Criteria andAppSecretLike(String value)
         {
              addCriterion("app_secret like ", value, "app_secret");
              return (Criteria) this;
         }

         public Criteria andAppSecretNotLike(String value)
         {
              addCriterion("app_secret not like ", value, "app_secret");
              return (Criteria) this;
         }

         public Criteria andAppSecretIn(List<String> values)
         {
              addCriterion("app_secret in ", values, "app_secret");
              return (Criteria) this;
         }

         public Criteria andAppSecretNotIn(List<String> values)
         {
              addCriterion("app_secret not in ", values, "app_secret");
              return (Criteria) this;
         }

         public Criteria andAppSecretBetween(String value1, String value2)
         {
              addCriterion("app_secret between ", value1,value2, "app_secret");
              return (Criteria) this;
         }

         public Criteria andAppSecretNotBetween(String value1, String value2)
         {
              addCriterion("app_secret not between ", value1,value2, "app_secret");
              return (Criteria) this;
         }

         public Criteria andVolumeIsNull()
         {
              addCriterion("volume is null");
              return (Criteria) this;
         }

         public Criteria andVolumeIsNotNull()
         {
              addCriterion("volume is not null");
              return (Criteria) this;
         }

         public Criteria andVolumeEqualTo(String value)
         {
              addCriterion("volume = ", value, "volume");
              return (Criteria) this;
         }

         public Criteria andVolumeNotEqualTo(String value)
         {
              addCriterion("volume <> ", value, "volume");
              return (Criteria) this;
         }

         public Criteria andVolumeGreaterThan(String value)
         {
              addCriterion("volume > ", value, "volume");
              return (Criteria) this;
         }

         public Criteria andVolumeGreaterThanOrEqualTo(String value)
         {
              addCriterion("volume >= ", value, "volume");
              return (Criteria) this;
         }

         public Criteria andVolumeLessThan(String value)
         {
              addCriterion("volume < ", value, "volume");
              return (Criteria) this;
         }

         public Criteria andVolumeLessThanOrEqualTo(String value)
         {
              addCriterion("volume <= ", value, "volume");
              return (Criteria) this;
         }

         public Criteria andVolumeLike(String value)
         {
              addCriterion("volume like ", value, "volume");
              return (Criteria) this;
         }

         public Criteria andVolumeNotLike(String value)
         {
              addCriterion("volume not like ", value, "volume");
              return (Criteria) this;
         }

         public Criteria andVolumeIn(List<String> values)
         {
              addCriterion("volume in ", values, "volume");
              return (Criteria) this;
         }

         public Criteria andVolumeNotIn(List<String> values)
         {
              addCriterion("volume not in ", values, "volume");
              return (Criteria) this;
         }

         public Criteria andVolumeBetween(String value1, String value2)
         {
              addCriterion("volume between ", value1,value2, "volume");
              return (Criteria) this;
         }

         public Criteria andVolumeNotBetween(String value1, String value2)
         {
              addCriterion("volume not between ", value1,value2, "volume");
              return (Criteria) this;
         }

         public Criteria andAppStatusIsNull()
         {
              addCriterion("app_status is null");
              return (Criteria) this;
         }

         public Criteria andAppStatusIsNotNull()
         {
              addCriterion("app_status is not null");
              return (Criteria) this;
         }

         public Criteria andAppStatusEqualTo(String value)
         {
              addCriterion("app_status = ", value, "app_status");
              return (Criteria) this;
         }

         public Criteria andAppStatusNotEqualTo(String value)
         {
              addCriterion("app_status <> ", value, "app_status");
              return (Criteria) this;
         }

         public Criteria andAppStatusGreaterThan(String value)
         {
              addCriterion("app_status > ", value, "app_status");
              return (Criteria) this;
         }

         public Criteria andAppStatusGreaterThanOrEqualTo(String value)
         {
              addCriterion("app_status >= ", value, "app_status");
              return (Criteria) this;
         }

         public Criteria andAppStatusLessThan(String value)
         {
              addCriterion("app_status < ", value, "app_status");
              return (Criteria) this;
         }

         public Criteria andAppStatusLessThanOrEqualTo(String value)
         {
              addCriterion("app_status <= ", value, "app_status");
              return (Criteria) this;
         }

         public Criteria andAppStatusLike(String value)
         {
              addCriterion("app_status like ", value, "app_status");
              return (Criteria) this;
         }

         public Criteria andAppStatusNotLike(String value)
         {
              addCriterion("app_status not like ", value, "app_status");
              return (Criteria) this;
         }

         public Criteria andAppStatusIn(List<String> values)
         {
              addCriterion("app_status in ", values, "app_status");
              return (Criteria) this;
         }

         public Criteria andAppStatusNotIn(List<String> values)
         {
              addCriterion("app_status not in ", values, "app_status");
              return (Criteria) this;
         }

         public Criteria andAppStatusBetween(String value1, String value2)
         {
              addCriterion("app_status between ", value1,value2, "app_status");
              return (Criteria) this;
         }

         public Criteria andAppStatusNotBetween(String value1, String value2)
         {
              addCriterion("app_status not between ", value1,value2, "app_status");
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

         public Criteria andCreateDtIsNull()
         {
              addCriterion("create_dt is null");
              return (Criteria) this;
         }

         public Criteria andCreateDtIsNotNull()
         {
              addCriterion("create_dt is not null");
              return (Criteria) this;
         }

         public Criteria andCreateDtEqualTo(Date value)
         {
              addCriterion("create_dt = ", value, "create_dt");
              return (Criteria) this;
         }

         public Criteria andCreateDtNotEqualTo(Date value)
         {
              addCriterion("create_dt <> ", value, "create_dt");
              return (Criteria) this;
         }

         public Criteria andCreateDtGreaterThan(Date value)
         {
              addCriterion("create_dt > ", value, "create_dt");
              return (Criteria) this;
         }

         public Criteria andCreateDtGreaterThanOrEqualTo(Date value)
         {
              addCriterion("create_dt >= ", value, "create_dt");
              return (Criteria) this;
         }

         public Criteria andCreateDtLessThan(Date value)
         {
              addCriterion("create_dt < ", value, "create_dt");
              return (Criteria) this;
         }

         public Criteria andCreateDtLessThanOrEqualTo(Date value)
         {
              addCriterion("create_dt <= ", value, "create_dt");
              return (Criteria) this;
         }

         public Criteria andCreateDtIn(List<Date> values)
         {
              addCriterion("create_dt in ", values, "create_dt");
              return (Criteria) this;
         }

         public Criteria andCreateDtNotIn(List<Date> values)
         {
              addCriterion("create_dt not in ", values, "create_dt");
              return (Criteria) this;
         }

         public Criteria andCreateDtBetween(Date value1, Date value2)
         {
              addCriterion("create_dt between ", value1,value2, "create_dt");
              return (Criteria) this;
         }

         public Criteria andCreateDtNotBetween(Date value1, Date value2)
         {
              addCriterion("create_dt not between ", value1,value2, "create_dt");
              return (Criteria) this;
         }

         public Criteria andUpdateDtIsNull()
         {
              addCriterion("update_dt is null");
              return (Criteria) this;
         }

         public Criteria andUpdateDtIsNotNull()
         {
              addCriterion("update_dt is not null");
              return (Criteria) this;
         }

         public Criteria andUpdateDtEqualTo(Date value)
         {
              addCriterion("update_dt = ", value, "update_dt");
              return (Criteria) this;
         }

         public Criteria andUpdateDtNotEqualTo(Date value)
         {
              addCriterion("update_dt <> ", value, "update_dt");
              return (Criteria) this;
         }

         public Criteria andUpdateDtGreaterThan(Date value)
         {
              addCriterion("update_dt > ", value, "update_dt");
              return (Criteria) this;
         }

         public Criteria andUpdateDtGreaterThanOrEqualTo(Date value)
         {
              addCriterion("update_dt >= ", value, "update_dt");
              return (Criteria) this;
         }

         public Criteria andUpdateDtLessThan(Date value)
         {
              addCriterion("update_dt < ", value, "update_dt");
              return (Criteria) this;
         }

         public Criteria andUpdateDtLessThanOrEqualTo(Date value)
         {
              addCriterion("update_dt <= ", value, "update_dt");
              return (Criteria) this;
         }

         public Criteria andUpdateDtIn(List<Date> values)
         {
              addCriterion("update_dt in ", values, "update_dt");
              return (Criteria) this;
         }

         public Criteria andUpdateDtNotIn(List<Date> values)
         {
              addCriterion("update_dt not in ", values, "update_dt");
              return (Criteria) this;
         }

         public Criteria andUpdateDtBetween(Date value1, Date value2)
         {
              addCriterion("update_dt between ", value1,value2, "update_dt");
              return (Criteria) this;
         }

         public Criteria andUpdateDtNotBetween(Date value1, Date value2)
         {
              addCriterion("update_dt not between ", value1,value2, "update_dt");
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
