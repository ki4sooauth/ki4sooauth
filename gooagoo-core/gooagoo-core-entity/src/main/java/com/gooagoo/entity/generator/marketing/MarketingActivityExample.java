package com.gooagoo.entity.generator.marketing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 营销活动表
 */

public class MarketingActivityExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public MarketingActivityExample()
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

         public Criteria andActivityNameIsNull()
         {
              addCriterion("activity_name is null");
              return (Criteria) this;
         }

         public Criteria andActivityNameIsNotNull()
         {
              addCriterion("activity_name is not null");
              return (Criteria) this;
         }

         public Criteria andActivityNameEqualTo(String value)
         {
              addCriterion("activity_name = ", value, "activity_name");
              return (Criteria) this;
         }

         public Criteria andActivityNameNotEqualTo(String value)
         {
              addCriterion("activity_name <> ", value, "activity_name");
              return (Criteria) this;
         }

         public Criteria andActivityNameGreaterThan(String value)
         {
              addCriterion("activity_name > ", value, "activity_name");
              return (Criteria) this;
         }

         public Criteria andActivityNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("activity_name >= ", value, "activity_name");
              return (Criteria) this;
         }

         public Criteria andActivityNameLessThan(String value)
         {
              addCriterion("activity_name < ", value, "activity_name");
              return (Criteria) this;
         }

         public Criteria andActivityNameLessThanOrEqualTo(String value)
         {
              addCriterion("activity_name <= ", value, "activity_name");
              return (Criteria) this;
         }

         public Criteria andActivityNameLike(String value)
         {
              addCriterion("activity_name like ", value, "activity_name");
              return (Criteria) this;
         }

         public Criteria andActivityNameNotLike(String value)
         {
              addCriterion("activity_name not like ", value, "activity_name");
              return (Criteria) this;
         }

         public Criteria andActivityNameIn(List<String> values)
         {
              addCriterion("activity_name in ", values, "activity_name");
              return (Criteria) this;
         }

         public Criteria andActivityNameNotIn(List<String> values)
         {
              addCriterion("activity_name not in ", values, "activity_name");
              return (Criteria) this;
         }

         public Criteria andActivityNameBetween(String value1, String value2)
         {
              addCriterion("activity_name between ", value1,value2, "activity_name");
              return (Criteria) this;
         }

         public Criteria andActivityNameNotBetween(String value1, String value2)
         {
              addCriterion("activity_name not between ", value1,value2, "activity_name");
              return (Criteria) this;
         }

         public Criteria andTitleIsNull()
         {
              addCriterion("title is null");
              return (Criteria) this;
         }

         public Criteria andTitleIsNotNull()
         {
              addCriterion("title is not null");
              return (Criteria) this;
         }

         public Criteria andTitleEqualTo(String value)
         {
              addCriterion("title = ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleNotEqualTo(String value)
         {
              addCriterion("title <> ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleGreaterThan(String value)
         {
              addCriterion("title > ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleGreaterThanOrEqualTo(String value)
         {
              addCriterion("title >= ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleLessThan(String value)
         {
              addCriterion("title < ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleLessThanOrEqualTo(String value)
         {
              addCriterion("title <= ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleLike(String value)
         {
              addCriterion("title like ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleNotLike(String value)
         {
              addCriterion("title not like ", value, "title");
              return (Criteria) this;
         }

         public Criteria andTitleIn(List<String> values)
         {
              addCriterion("title in ", values, "title");
              return (Criteria) this;
         }

         public Criteria andTitleNotIn(List<String> values)
         {
              addCriterion("title not in ", values, "title");
              return (Criteria) this;
         }

         public Criteria andTitleBetween(String value1, String value2)
         {
              addCriterion("title between ", value1,value2, "title");
              return (Criteria) this;
         }

         public Criteria andTitleNotBetween(String value1, String value2)
         {
              addCriterion("title not between ", value1,value2, "title");
              return (Criteria) this;
         }

         public Criteria andStartTimeIsNull()
         {
              addCriterion("start_time is null");
              return (Criteria) this;
         }

         public Criteria andStartTimeIsNotNull()
         {
              addCriterion("start_time is not null");
              return (Criteria) this;
         }

         public Criteria andStartTimeEqualTo(Date value)
         {
              addCriterion("start_time = ", value, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeNotEqualTo(Date value)
         {
              addCriterion("start_time <> ", value, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeGreaterThan(Date value)
         {
              addCriterion("start_time > ", value, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("start_time >= ", value, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeLessThan(Date value)
         {
              addCriterion("start_time < ", value, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("start_time <= ", value, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeIn(List<Date> values)
         {
              addCriterion("start_time in ", values, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeNotIn(List<Date> values)
         {
              addCriterion("start_time not in ", values, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeBetween(Date value1, Date value2)
         {
              addCriterion("start_time between ", value1,value2, "start_time");
              return (Criteria) this;
         }

         public Criteria andStartTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("start_time not between ", value1,value2, "start_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeIsNull()
         {
              addCriterion("end_time is null");
              return (Criteria) this;
         }

         public Criteria andEndTimeIsNotNull()
         {
              addCriterion("end_time is not null");
              return (Criteria) this;
         }

         public Criteria andEndTimeEqualTo(Date value)
         {
              addCriterion("end_time = ", value, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeNotEqualTo(Date value)
         {
              addCriterion("end_time <> ", value, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeGreaterThan(Date value)
         {
              addCriterion("end_time > ", value, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("end_time >= ", value, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeLessThan(Date value)
         {
              addCriterion("end_time < ", value, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("end_time <= ", value, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeIn(List<Date> values)
         {
              addCriterion("end_time in ", values, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeNotIn(List<Date> values)
         {
              addCriterion("end_time not in ", values, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeBetween(Date value1, Date value2)
         {
              addCriterion("end_time between ", value1,value2, "end_time");
              return (Criteria) this;
         }

         public Criteria andEndTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("end_time not between ", value1,value2, "end_time");
              return (Criteria) this;
         }

         public Criteria andImgUrlIsNull()
         {
              addCriterion("img_url is null");
              return (Criteria) this;
         }

         public Criteria andImgUrlIsNotNull()
         {
              addCriterion("img_url is not null");
              return (Criteria) this;
         }

         public Criteria andImgUrlEqualTo(String value)
         {
              addCriterion("img_url = ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlNotEqualTo(String value)
         {
              addCriterion("img_url <> ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlGreaterThan(String value)
         {
              addCriterion("img_url > ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlGreaterThanOrEqualTo(String value)
         {
              addCriterion("img_url >= ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlLessThan(String value)
         {
              addCriterion("img_url < ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlLessThanOrEqualTo(String value)
         {
              addCriterion("img_url <= ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlLike(String value)
         {
              addCriterion("img_url like ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlNotLike(String value)
         {
              addCriterion("img_url not like ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlIn(List<String> values)
         {
              addCriterion("img_url in ", values, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlNotIn(List<String> values)
         {
              addCriterion("img_url not in ", values, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlBetween(String value1, String value2)
         {
              addCriterion("img_url between ", value1,value2, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlNotBetween(String value1, String value2)
         {
              addCriterion("img_url not between ", value1,value2, "img_url");
              return (Criteria) this;
         }

         public Criteria andContentIsNull()
         {
              addCriterion("content is null");
              return (Criteria) this;
         }

         public Criteria andContentIsNotNull()
         {
              addCriterion("content is not null");
              return (Criteria) this;
         }

         public Criteria andContentEqualTo(String value)
         {
              addCriterion("content = ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentNotEqualTo(String value)
         {
              addCriterion("content <> ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentGreaterThan(String value)
         {
              addCriterion("content > ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentGreaterThanOrEqualTo(String value)
         {
              addCriterion("content >= ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentLessThan(String value)
         {
              addCriterion("content < ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentLessThanOrEqualTo(String value)
         {
              addCriterion("content <= ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentLike(String value)
         {
              addCriterion("content like ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentNotLike(String value)
         {
              addCriterion("content not like ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentIn(List<String> values)
         {
              addCriterion("content in ", values, "content");
              return (Criteria) this;
         }

         public Criteria andContentNotIn(List<String> values)
         {
              addCriterion("content not in ", values, "content");
              return (Criteria) this;
         }

         public Criteria andContentBetween(String value1, String value2)
         {
              addCriterion("content between ", value1,value2, "content");
              return (Criteria) this;
         }

         public Criteria andContentNotBetween(String value1, String value2)
         {
              addCriterion("content not between ", value1,value2, "content");
              return (Criteria) this;
         }

         public Criteria andPurposeIsNull()
         {
              addCriterion("purpose is null");
              return (Criteria) this;
         }

         public Criteria andPurposeIsNotNull()
         {
              addCriterion("purpose is not null");
              return (Criteria) this;
         }

         public Criteria andPurposeEqualTo(String value)
         {
              addCriterion("purpose = ", value, "purpose");
              return (Criteria) this;
         }

         public Criteria andPurposeNotEqualTo(String value)
         {
              addCriterion("purpose <> ", value, "purpose");
              return (Criteria) this;
         }

         public Criteria andPurposeGreaterThan(String value)
         {
              addCriterion("purpose > ", value, "purpose");
              return (Criteria) this;
         }

         public Criteria andPurposeGreaterThanOrEqualTo(String value)
         {
              addCriterion("purpose >= ", value, "purpose");
              return (Criteria) this;
         }

         public Criteria andPurposeLessThan(String value)
         {
              addCriterion("purpose < ", value, "purpose");
              return (Criteria) this;
         }

         public Criteria andPurposeLessThanOrEqualTo(String value)
         {
              addCriterion("purpose <= ", value, "purpose");
              return (Criteria) this;
         }

         public Criteria andPurposeLike(String value)
         {
              addCriterion("purpose like ", value, "purpose");
              return (Criteria) this;
         }

         public Criteria andPurposeNotLike(String value)
         {
              addCriterion("purpose not like ", value, "purpose");
              return (Criteria) this;
         }

         public Criteria andPurposeIn(List<String> values)
         {
              addCriterion("purpose in ", values, "purpose");
              return (Criteria) this;
         }

         public Criteria andPurposeNotIn(List<String> values)
         {
              addCriterion("purpose not in ", values, "purpose");
              return (Criteria) this;
         }

         public Criteria andPurposeBetween(String value1, String value2)
         {
              addCriterion("purpose between ", value1,value2, "purpose");
              return (Criteria) this;
         }

         public Criteria andPurposeNotBetween(String value1, String value2)
         {
              addCriterion("purpose not between ", value1,value2, "purpose");
              return (Criteria) this;
         }

         public Criteria andDescriptionIsNull()
         {
              addCriterion("description is null");
              return (Criteria) this;
         }

         public Criteria andDescriptionIsNotNull()
         {
              addCriterion("description is not null");
              return (Criteria) this;
         }

         public Criteria andDescriptionEqualTo(String value)
         {
              addCriterion("description = ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionNotEqualTo(String value)
         {
              addCriterion("description <> ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionGreaterThan(String value)
         {
              addCriterion("description > ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionGreaterThanOrEqualTo(String value)
         {
              addCriterion("description >= ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionLessThan(String value)
         {
              addCriterion("description < ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionLessThanOrEqualTo(String value)
         {
              addCriterion("description <= ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionLike(String value)
         {
              addCriterion("description like ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionNotLike(String value)
         {
              addCriterion("description not like ", value, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionIn(List<String> values)
         {
              addCriterion("description in ", values, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionNotIn(List<String> values)
         {
              addCriterion("description not in ", values, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionBetween(String value1, String value2)
         {
              addCriterion("description between ", value1,value2, "description");
              return (Criteria) this;
         }

         public Criteria andDescriptionNotBetween(String value1, String value2)
         {
              addCriterion("description not between ", value1,value2, "description");
              return (Criteria) this;
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

         public Criteria andTemplateDataIsNull()
         {
              addCriterion("template_data is null");
              return (Criteria) this;
         }

         public Criteria andTemplateDataIsNotNull()
         {
              addCriterion("template_data is not null");
              return (Criteria) this;
         }

         public Criteria andTemplateDataEqualTo(String value)
         {
              addCriterion("template_data = ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataNotEqualTo(String value)
         {
              addCriterion("template_data <> ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataGreaterThan(String value)
         {
              addCriterion("template_data > ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataGreaterThanOrEqualTo(String value)
         {
              addCriterion("template_data >= ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataLessThan(String value)
         {
              addCriterion("template_data < ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataLessThanOrEqualTo(String value)
         {
              addCriterion("template_data <= ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataLike(String value)
         {
              addCriterion("template_data like ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataNotLike(String value)
         {
              addCriterion("template_data not like ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataIn(List<String> values)
         {
              addCriterion("template_data in ", values, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataNotIn(List<String> values)
         {
              addCriterion("template_data not in ", values, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataBetween(String value1, String value2)
         {
              addCriterion("template_data between ", value1,value2, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataNotBetween(String value1, String value2)
         {
              addCriterion("template_data not between ", value1,value2, "template_data");
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
