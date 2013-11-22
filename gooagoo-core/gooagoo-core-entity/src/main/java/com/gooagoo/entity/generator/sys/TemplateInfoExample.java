package com.gooagoo.entity.generator.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 后台用户维护的模板基础信息
 */

public class TemplateInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public TemplateInfoExample()
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

         public Criteria andTemplateIdIsNull()
         {
              addCriterion("template_id is null");
              return (Criteria) this;
         }

         public Criteria andTemplateIdIsNotNull()
         {
              addCriterion("template_id is not null");
              return (Criteria) this;
         }

         public Criteria andTemplateIdEqualTo(String value)
         {
              addCriterion("template_id = ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdNotEqualTo(String value)
         {
              addCriterion("template_id <> ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdGreaterThan(String value)
         {
              addCriterion("template_id > ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("template_id >= ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdLessThan(String value)
         {
              addCriterion("template_id < ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdLessThanOrEqualTo(String value)
         {
              addCriterion("template_id <= ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdLike(String value)
         {
              addCriterion("template_id like ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdNotLike(String value)
         {
              addCriterion("template_id not like ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdIn(List<String> values)
         {
              addCriterion("template_id in ", values, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdNotIn(List<String> values)
         {
              addCriterion("template_id not in ", values, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdBetween(String value1, String value2)
         {
              addCriterion("template_id between ", value1,value2, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdNotBetween(String value1, String value2)
         {
              addCriterion("template_id not between ", value1,value2, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateTypeIsNull()
         {
              addCriterion("template_type is null");
              return (Criteria) this;
         }

         public Criteria andTemplateTypeIsNotNull()
         {
              addCriterion("template_type is not null");
              return (Criteria) this;
         }

         public Criteria andTemplateTypeEqualTo(String value)
         {
              addCriterion("template_type = ", value, "template_type");
              return (Criteria) this;
         }

         public Criteria andTemplateTypeNotEqualTo(String value)
         {
              addCriterion("template_type <> ", value, "template_type");
              return (Criteria) this;
         }

         public Criteria andTemplateTypeGreaterThan(String value)
         {
              addCriterion("template_type > ", value, "template_type");
              return (Criteria) this;
         }

         public Criteria andTemplateTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("template_type >= ", value, "template_type");
              return (Criteria) this;
         }

         public Criteria andTemplateTypeLessThan(String value)
         {
              addCriterion("template_type < ", value, "template_type");
              return (Criteria) this;
         }

         public Criteria andTemplateTypeLessThanOrEqualTo(String value)
         {
              addCriterion("template_type <= ", value, "template_type");
              return (Criteria) this;
         }

         public Criteria andTemplateTypeLike(String value)
         {
              addCriterion("template_type like ", value, "template_type");
              return (Criteria) this;
         }

         public Criteria andTemplateTypeNotLike(String value)
         {
              addCriterion("template_type not like ", value, "template_type");
              return (Criteria) this;
         }

         public Criteria andTemplateTypeIn(List<String> values)
         {
              addCriterion("template_type in ", values, "template_type");
              return (Criteria) this;
         }

         public Criteria andTemplateTypeNotIn(List<String> values)
         {
              addCriterion("template_type not in ", values, "template_type");
              return (Criteria) this;
         }

         public Criteria andTemplateTypeBetween(String value1, String value2)
         {
              addCriterion("template_type between ", value1,value2, "template_type");
              return (Criteria) this;
         }

         public Criteria andTemplateTypeNotBetween(String value1, String value2)
         {
              addCriterion("template_type not between ", value1,value2, "template_type");
              return (Criteria) this;
         }

         public Criteria andChannelCodeIsNull()
         {
              addCriterion("channel_code is null");
              return (Criteria) this;
         }

         public Criteria andChannelCodeIsNotNull()
         {
              addCriterion("channel_code is not null");
              return (Criteria) this;
         }

         public Criteria andChannelCodeEqualTo(String value)
         {
              addCriterion("channel_code = ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeNotEqualTo(String value)
         {
              addCriterion("channel_code <> ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeGreaterThan(String value)
         {
              addCriterion("channel_code > ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("channel_code >= ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeLessThan(String value)
         {
              addCriterion("channel_code < ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeLessThanOrEqualTo(String value)
         {
              addCriterion("channel_code <= ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeLike(String value)
         {
              addCriterion("channel_code like ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeNotLike(String value)
         {
              addCriterion("channel_code not like ", value, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeIn(List<String> values)
         {
              addCriterion("channel_code in ", values, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeNotIn(List<String> values)
         {
              addCriterion("channel_code not in ", values, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeBetween(String value1, String value2)
         {
              addCriterion("channel_code between ", value1,value2, "channel_code");
              return (Criteria) this;
         }

         public Criteria andChannelCodeNotBetween(String value1, String value2)
         {
              addCriterion("channel_code not between ", value1,value2, "channel_code");
              return (Criteria) this;
         }

         public Criteria andTemplateNameIsNull()
         {
              addCriterion("template_name is null");
              return (Criteria) this;
         }

         public Criteria andTemplateNameIsNotNull()
         {
              addCriterion("template_name is not null");
              return (Criteria) this;
         }

         public Criteria andTemplateNameEqualTo(String value)
         {
              addCriterion("template_name = ", value, "template_name");
              return (Criteria) this;
         }

         public Criteria andTemplateNameNotEqualTo(String value)
         {
              addCriterion("template_name <> ", value, "template_name");
              return (Criteria) this;
         }

         public Criteria andTemplateNameGreaterThan(String value)
         {
              addCriterion("template_name > ", value, "template_name");
              return (Criteria) this;
         }

         public Criteria andTemplateNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("template_name >= ", value, "template_name");
              return (Criteria) this;
         }

         public Criteria andTemplateNameLessThan(String value)
         {
              addCriterion("template_name < ", value, "template_name");
              return (Criteria) this;
         }

         public Criteria andTemplateNameLessThanOrEqualTo(String value)
         {
              addCriterion("template_name <= ", value, "template_name");
              return (Criteria) this;
         }

         public Criteria andTemplateNameLike(String value)
         {
              addCriterion("template_name like ", value, "template_name");
              return (Criteria) this;
         }

         public Criteria andTemplateNameNotLike(String value)
         {
              addCriterion("template_name not like ", value, "template_name");
              return (Criteria) this;
         }

         public Criteria andTemplateNameIn(List<String> values)
         {
              addCriterion("template_name in ", values, "template_name");
              return (Criteria) this;
         }

         public Criteria andTemplateNameNotIn(List<String> values)
         {
              addCriterion("template_name not in ", values, "template_name");
              return (Criteria) this;
         }

         public Criteria andTemplateNameBetween(String value1, String value2)
         {
              addCriterion("template_name between ", value1,value2, "template_name");
              return (Criteria) this;
         }

         public Criteria andTemplateNameNotBetween(String value1, String value2)
         {
              addCriterion("template_name not between ", value1,value2, "template_name");
              return (Criteria) this;
         }

         public Criteria andTemplateImgIsNull()
         {
              addCriterion("template_img is null");
              return (Criteria) this;
         }

         public Criteria andTemplateImgIsNotNull()
         {
              addCriterion("template_img is not null");
              return (Criteria) this;
         }

         public Criteria andTemplateImgEqualTo(String value)
         {
              addCriterion("template_img = ", value, "template_img");
              return (Criteria) this;
         }

         public Criteria andTemplateImgNotEqualTo(String value)
         {
              addCriterion("template_img <> ", value, "template_img");
              return (Criteria) this;
         }

         public Criteria andTemplateImgGreaterThan(String value)
         {
              addCriterion("template_img > ", value, "template_img");
              return (Criteria) this;
         }

         public Criteria andTemplateImgGreaterThanOrEqualTo(String value)
         {
              addCriterion("template_img >= ", value, "template_img");
              return (Criteria) this;
         }

         public Criteria andTemplateImgLessThan(String value)
         {
              addCriterion("template_img < ", value, "template_img");
              return (Criteria) this;
         }

         public Criteria andTemplateImgLessThanOrEqualTo(String value)
         {
              addCriterion("template_img <= ", value, "template_img");
              return (Criteria) this;
         }

         public Criteria andTemplateImgLike(String value)
         {
              addCriterion("template_img like ", value, "template_img");
              return (Criteria) this;
         }

         public Criteria andTemplateImgNotLike(String value)
         {
              addCriterion("template_img not like ", value, "template_img");
              return (Criteria) this;
         }

         public Criteria andTemplateImgIn(List<String> values)
         {
              addCriterion("template_img in ", values, "template_img");
              return (Criteria) this;
         }

         public Criteria andTemplateImgNotIn(List<String> values)
         {
              addCriterion("template_img not in ", values, "template_img");
              return (Criteria) this;
         }

         public Criteria andTemplateImgBetween(String value1, String value2)
         {
              addCriterion("template_img between ", value1,value2, "template_img");
              return (Criteria) this;
         }

         public Criteria andTemplateImgNotBetween(String value1, String value2)
         {
              addCriterion("template_img not between ", value1,value2, "template_img");
              return (Criteria) this;
         }

         public Criteria andTemplateContIsNull()
         {
              addCriterion("template_cont is null");
              return (Criteria) this;
         }

         public Criteria andTemplateContIsNotNull()
         {
              addCriterion("template_cont is not null");
              return (Criteria) this;
         }

         public Criteria andTemplateContEqualTo(String value)
         {
              addCriterion("template_cont = ", value, "template_cont");
              return (Criteria) this;
         }

         public Criteria andTemplateContNotEqualTo(String value)
         {
              addCriterion("template_cont <> ", value, "template_cont");
              return (Criteria) this;
         }

         public Criteria andTemplateContGreaterThan(String value)
         {
              addCriterion("template_cont > ", value, "template_cont");
              return (Criteria) this;
         }

         public Criteria andTemplateContGreaterThanOrEqualTo(String value)
         {
              addCriterion("template_cont >= ", value, "template_cont");
              return (Criteria) this;
         }

         public Criteria andTemplateContLessThan(String value)
         {
              addCriterion("template_cont < ", value, "template_cont");
              return (Criteria) this;
         }

         public Criteria andTemplateContLessThanOrEqualTo(String value)
         {
              addCriterion("template_cont <= ", value, "template_cont");
              return (Criteria) this;
         }

         public Criteria andTemplateContLike(String value)
         {
              addCriterion("template_cont like ", value, "template_cont");
              return (Criteria) this;
         }

         public Criteria andTemplateContNotLike(String value)
         {
              addCriterion("template_cont not like ", value, "template_cont");
              return (Criteria) this;
         }

         public Criteria andTemplateContIn(List<String> values)
         {
              addCriterion("template_cont in ", values, "template_cont");
              return (Criteria) this;
         }

         public Criteria andTemplateContNotIn(List<String> values)
         {
              addCriterion("template_cont not in ", values, "template_cont");
              return (Criteria) this;
         }

         public Criteria andTemplateContBetween(String value1, String value2)
         {
              addCriterion("template_cont between ", value1,value2, "template_cont");
              return (Criteria) this;
         }

         public Criteria andTemplateContNotBetween(String value1, String value2)
         {
              addCriterion("template_cont not between ", value1,value2, "template_cont");
              return (Criteria) this;
         }

         public Criteria andTemplateDescriptionIsNull()
         {
              addCriterion("template_description is null");
              return (Criteria) this;
         }

         public Criteria andTemplateDescriptionIsNotNull()
         {
              addCriterion("template_description is not null");
              return (Criteria) this;
         }

         public Criteria andTemplateDescriptionEqualTo(String value)
         {
              addCriterion("template_description = ", value, "template_description");
              return (Criteria) this;
         }

         public Criteria andTemplateDescriptionNotEqualTo(String value)
         {
              addCriterion("template_description <> ", value, "template_description");
              return (Criteria) this;
         }

         public Criteria andTemplateDescriptionGreaterThan(String value)
         {
              addCriterion("template_description > ", value, "template_description");
              return (Criteria) this;
         }

         public Criteria andTemplateDescriptionGreaterThanOrEqualTo(String value)
         {
              addCriterion("template_description >= ", value, "template_description");
              return (Criteria) this;
         }

         public Criteria andTemplateDescriptionLessThan(String value)
         {
              addCriterion("template_description < ", value, "template_description");
              return (Criteria) this;
         }

         public Criteria andTemplateDescriptionLessThanOrEqualTo(String value)
         {
              addCriterion("template_description <= ", value, "template_description");
              return (Criteria) this;
         }

         public Criteria andTemplateDescriptionLike(String value)
         {
              addCriterion("template_description like ", value, "template_description");
              return (Criteria) this;
         }

         public Criteria andTemplateDescriptionNotLike(String value)
         {
              addCriterion("template_description not like ", value, "template_description");
              return (Criteria) this;
         }

         public Criteria andTemplateDescriptionIn(List<String> values)
         {
              addCriterion("template_description in ", values, "template_description");
              return (Criteria) this;
         }

         public Criteria andTemplateDescriptionNotIn(List<String> values)
         {
              addCriterion("template_description not in ", values, "template_description");
              return (Criteria) this;
         }

         public Criteria andTemplateDescriptionBetween(String value1, String value2)
         {
              addCriterion("template_description between ", value1,value2, "template_description");
              return (Criteria) this;
         }

         public Criteria andTemplateDescriptionNotBetween(String value1, String value2)
         {
              addCriterion("template_description not between ", value1,value2, "template_description");
              return (Criteria) this;
         }

         public Criteria andAuthorizationIsNull()
         {
              addCriterion("authorization is null");
              return (Criteria) this;
         }

         public Criteria andAuthorizationIsNotNull()
         {
              addCriterion("authorization is not null");
              return (Criteria) this;
         }

         public Criteria andAuthorizationEqualTo(String value)
         {
              addCriterion("authorization = ", value, "authorization");
              return (Criteria) this;
         }

         public Criteria andAuthorizationNotEqualTo(String value)
         {
              addCriterion("authorization <> ", value, "authorization");
              return (Criteria) this;
         }

         public Criteria andAuthorizationGreaterThan(String value)
         {
              addCriterion("authorization > ", value, "authorization");
              return (Criteria) this;
         }

         public Criteria andAuthorizationGreaterThanOrEqualTo(String value)
         {
              addCriterion("authorization >= ", value, "authorization");
              return (Criteria) this;
         }

         public Criteria andAuthorizationLessThan(String value)
         {
              addCriterion("authorization < ", value, "authorization");
              return (Criteria) this;
         }

         public Criteria andAuthorizationLessThanOrEqualTo(String value)
         {
              addCriterion("authorization <= ", value, "authorization");
              return (Criteria) this;
         }

         public Criteria andAuthorizationLike(String value)
         {
              addCriterion("authorization like ", value, "authorization");
              return (Criteria) this;
         }

         public Criteria andAuthorizationNotLike(String value)
         {
              addCriterion("authorization not like ", value, "authorization");
              return (Criteria) this;
         }

         public Criteria andAuthorizationIn(List<String> values)
         {
              addCriterion("authorization in ", values, "authorization");
              return (Criteria) this;
         }

         public Criteria andAuthorizationNotIn(List<String> values)
         {
              addCriterion("authorization not in ", values, "authorization");
              return (Criteria) this;
         }

         public Criteria andAuthorizationBetween(String value1, String value2)
         {
              addCriterion("authorization between ", value1,value2, "authorization");
              return (Criteria) this;
         }

         public Criteria andAuthorizationNotBetween(String value1, String value2)
         {
              addCriterion("authorization not between ", value1,value2, "authorization");
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

         public Criteria andPriceIsNull()
         {
              addCriterion("price is null");
              return (Criteria) this;
         }

         public Criteria andPriceIsNotNull()
         {
              addCriterion("price is not null");
              return (Criteria) this;
         }

         public Criteria andPriceEqualTo(String value)
         {
              addCriterion("price = ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceNotEqualTo(String value)
         {
              addCriterion("price <> ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceGreaterThan(String value)
         {
              addCriterion("price > ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceGreaterThanOrEqualTo(String value)
         {
              addCriterion("price >= ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceLessThan(String value)
         {
              addCriterion("price < ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceLessThanOrEqualTo(String value)
         {
              addCriterion("price <= ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceLike(String value)
         {
              addCriterion("price like ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceNotLike(String value)
         {
              addCriterion("price not like ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceIn(List<String> values)
         {
              addCriterion("price in ", values, "price");
              return (Criteria) this;
         }

         public Criteria andPriceNotIn(List<String> values)
         {
              addCriterion("price not in ", values, "price");
              return (Criteria) this;
         }

         public Criteria andPriceBetween(String value1, String value2)
         {
              addCriterion("price between ", value1,value2, "price");
              return (Criteria) this;
         }

         public Criteria andPriceNotBetween(String value1, String value2)
         {
              addCriterion("price not between ", value1,value2, "price");
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
