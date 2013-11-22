package com.gooagoo.entity.generator.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * cms内容信息
 */

public class CmsContentExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public CmsContentExample()
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

         public Criteria andCmsContentIdIsNull()
         {
              addCriterion("cms_content_id is null");
              return (Criteria) this;
         }

         public Criteria andCmsContentIdIsNotNull()
         {
              addCriterion("cms_content_id is not null");
              return (Criteria) this;
         }

         public Criteria andCmsContentIdEqualTo(String value)
         {
              addCriterion("cms_content_id = ", value, "cms_content_id");
              return (Criteria) this;
         }

         public Criteria andCmsContentIdNotEqualTo(String value)
         {
              addCriterion("cms_content_id <> ", value, "cms_content_id");
              return (Criteria) this;
         }

         public Criteria andCmsContentIdGreaterThan(String value)
         {
              addCriterion("cms_content_id > ", value, "cms_content_id");
              return (Criteria) this;
         }

         public Criteria andCmsContentIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("cms_content_id >= ", value, "cms_content_id");
              return (Criteria) this;
         }

         public Criteria andCmsContentIdLessThan(String value)
         {
              addCriterion("cms_content_id < ", value, "cms_content_id");
              return (Criteria) this;
         }

         public Criteria andCmsContentIdLessThanOrEqualTo(String value)
         {
              addCriterion("cms_content_id <= ", value, "cms_content_id");
              return (Criteria) this;
         }

         public Criteria andCmsContentIdLike(String value)
         {
              addCriterion("cms_content_id like ", value, "cms_content_id");
              return (Criteria) this;
         }

         public Criteria andCmsContentIdNotLike(String value)
         {
              addCriterion("cms_content_id not like ", value, "cms_content_id");
              return (Criteria) this;
         }

         public Criteria andCmsContentIdIn(List<String> values)
         {
              addCriterion("cms_content_id in ", values, "cms_content_id");
              return (Criteria) this;
         }

         public Criteria andCmsContentIdNotIn(List<String> values)
         {
              addCriterion("cms_content_id not in ", values, "cms_content_id");
              return (Criteria) this;
         }

         public Criteria andCmsContentIdBetween(String value1, String value2)
         {
              addCriterion("cms_content_id between ", value1,value2, "cms_content_id");
              return (Criteria) this;
         }

         public Criteria andCmsContentIdNotBetween(String value1, String value2)
         {
              addCriterion("cms_content_id not between ", value1,value2, "cms_content_id");
              return (Criteria) this;
         }

         public Criteria andCmsContentTypeIsNull()
         {
              addCriterion("cms_content_type is null");
              return (Criteria) this;
         }

         public Criteria andCmsContentTypeIsNotNull()
         {
              addCriterion("cms_content_type is not null");
              return (Criteria) this;
         }

         public Criteria andCmsContentTypeEqualTo(String value)
         {
              addCriterion("cms_content_type = ", value, "cms_content_type");
              return (Criteria) this;
         }

         public Criteria andCmsContentTypeNotEqualTo(String value)
         {
              addCriterion("cms_content_type <> ", value, "cms_content_type");
              return (Criteria) this;
         }

         public Criteria andCmsContentTypeGreaterThan(String value)
         {
              addCriterion("cms_content_type > ", value, "cms_content_type");
              return (Criteria) this;
         }

         public Criteria andCmsContentTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("cms_content_type >= ", value, "cms_content_type");
              return (Criteria) this;
         }

         public Criteria andCmsContentTypeLessThan(String value)
         {
              addCriterion("cms_content_type < ", value, "cms_content_type");
              return (Criteria) this;
         }

         public Criteria andCmsContentTypeLessThanOrEqualTo(String value)
         {
              addCriterion("cms_content_type <= ", value, "cms_content_type");
              return (Criteria) this;
         }

         public Criteria andCmsContentTypeLike(String value)
         {
              addCriterion("cms_content_type like ", value, "cms_content_type");
              return (Criteria) this;
         }

         public Criteria andCmsContentTypeNotLike(String value)
         {
              addCriterion("cms_content_type not like ", value, "cms_content_type");
              return (Criteria) this;
         }

         public Criteria andCmsContentTypeIn(List<String> values)
         {
              addCriterion("cms_content_type in ", values, "cms_content_type");
              return (Criteria) this;
         }

         public Criteria andCmsContentTypeNotIn(List<String> values)
         {
              addCriterion("cms_content_type not in ", values, "cms_content_type");
              return (Criteria) this;
         }

         public Criteria andCmsContentTypeBetween(String value1, String value2)
         {
              addCriterion("cms_content_type between ", value1,value2, "cms_content_type");
              return (Criteria) this;
         }

         public Criteria andCmsContentTypeNotBetween(String value1, String value2)
         {
              addCriterion("cms_content_type not between ", value1,value2, "cms_content_type");
              return (Criteria) this;
         }

         public Criteria andParentCmsContentIdIsNull()
         {
              addCriterion("parent_cms_content_id is null");
              return (Criteria) this;
         }

         public Criteria andParentCmsContentIdIsNotNull()
         {
              addCriterion("parent_cms_content_id is not null");
              return (Criteria) this;
         }

         public Criteria andParentCmsContentIdEqualTo(String value)
         {
              addCriterion("parent_cms_content_id = ", value, "parent_cms_content_id");
              return (Criteria) this;
         }

         public Criteria andParentCmsContentIdNotEqualTo(String value)
         {
              addCriterion("parent_cms_content_id <> ", value, "parent_cms_content_id");
              return (Criteria) this;
         }

         public Criteria andParentCmsContentIdGreaterThan(String value)
         {
              addCriterion("parent_cms_content_id > ", value, "parent_cms_content_id");
              return (Criteria) this;
         }

         public Criteria andParentCmsContentIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("parent_cms_content_id >= ", value, "parent_cms_content_id");
              return (Criteria) this;
         }

         public Criteria andParentCmsContentIdLessThan(String value)
         {
              addCriterion("parent_cms_content_id < ", value, "parent_cms_content_id");
              return (Criteria) this;
         }

         public Criteria andParentCmsContentIdLessThanOrEqualTo(String value)
         {
              addCriterion("parent_cms_content_id <= ", value, "parent_cms_content_id");
              return (Criteria) this;
         }

         public Criteria andParentCmsContentIdLike(String value)
         {
              addCriterion("parent_cms_content_id like ", value, "parent_cms_content_id");
              return (Criteria) this;
         }

         public Criteria andParentCmsContentIdNotLike(String value)
         {
              addCriterion("parent_cms_content_id not like ", value, "parent_cms_content_id");
              return (Criteria) this;
         }

         public Criteria andParentCmsContentIdIn(List<String> values)
         {
              addCriterion("parent_cms_content_id in ", values, "parent_cms_content_id");
              return (Criteria) this;
         }

         public Criteria andParentCmsContentIdNotIn(List<String> values)
         {
              addCriterion("parent_cms_content_id not in ", values, "parent_cms_content_id");
              return (Criteria) this;
         }

         public Criteria andParentCmsContentIdBetween(String value1, String value2)
         {
              addCriterion("parent_cms_content_id between ", value1,value2, "parent_cms_content_id");
              return (Criteria) this;
         }

         public Criteria andParentCmsContentIdNotBetween(String value1, String value2)
         {
              addCriterion("parent_cms_content_id not between ", value1,value2, "parent_cms_content_id");
              return (Criteria) this;
         }

         public Criteria andChannelTypeIsNull()
         {
              addCriterion("channel_type is null");
              return (Criteria) this;
         }

         public Criteria andChannelTypeIsNotNull()
         {
              addCriterion("channel_type is not null");
              return (Criteria) this;
         }

         public Criteria andChannelTypeEqualTo(String value)
         {
              addCriterion("channel_type = ", value, "channel_type");
              return (Criteria) this;
         }

         public Criteria andChannelTypeNotEqualTo(String value)
         {
              addCriterion("channel_type <> ", value, "channel_type");
              return (Criteria) this;
         }

         public Criteria andChannelTypeGreaterThan(String value)
         {
              addCriterion("channel_type > ", value, "channel_type");
              return (Criteria) this;
         }

         public Criteria andChannelTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("channel_type >= ", value, "channel_type");
              return (Criteria) this;
         }

         public Criteria andChannelTypeLessThan(String value)
         {
              addCriterion("channel_type < ", value, "channel_type");
              return (Criteria) this;
         }

         public Criteria andChannelTypeLessThanOrEqualTo(String value)
         {
              addCriterion("channel_type <= ", value, "channel_type");
              return (Criteria) this;
         }

         public Criteria andChannelTypeLike(String value)
         {
              addCriterion("channel_type like ", value, "channel_type");
              return (Criteria) this;
         }

         public Criteria andChannelTypeNotLike(String value)
         {
              addCriterion("channel_type not like ", value, "channel_type");
              return (Criteria) this;
         }

         public Criteria andChannelTypeIn(List<String> values)
         {
              addCriterion("channel_type in ", values, "channel_type");
              return (Criteria) this;
         }

         public Criteria andChannelTypeNotIn(List<String> values)
         {
              addCriterion("channel_type not in ", values, "channel_type");
              return (Criteria) this;
         }

         public Criteria andChannelTypeBetween(String value1, String value2)
         {
              addCriterion("channel_type between ", value1,value2, "channel_type");
              return (Criteria) this;
         }

         public Criteria andChannelTypeNotBetween(String value1, String value2)
         {
              addCriterion("channel_type not between ", value1,value2, "channel_type");
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

         public Criteria andCmsContentNameIsNull()
         {
              addCriterion("cms_content_name is null");
              return (Criteria) this;
         }

         public Criteria andCmsContentNameIsNotNull()
         {
              addCriterion("cms_content_name is not null");
              return (Criteria) this;
         }

         public Criteria andCmsContentNameEqualTo(String value)
         {
              addCriterion("cms_content_name = ", value, "cms_content_name");
              return (Criteria) this;
         }

         public Criteria andCmsContentNameNotEqualTo(String value)
         {
              addCriterion("cms_content_name <> ", value, "cms_content_name");
              return (Criteria) this;
         }

         public Criteria andCmsContentNameGreaterThan(String value)
         {
              addCriterion("cms_content_name > ", value, "cms_content_name");
              return (Criteria) this;
         }

         public Criteria andCmsContentNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("cms_content_name >= ", value, "cms_content_name");
              return (Criteria) this;
         }

         public Criteria andCmsContentNameLessThan(String value)
         {
              addCriterion("cms_content_name < ", value, "cms_content_name");
              return (Criteria) this;
         }

         public Criteria andCmsContentNameLessThanOrEqualTo(String value)
         {
              addCriterion("cms_content_name <= ", value, "cms_content_name");
              return (Criteria) this;
         }

         public Criteria andCmsContentNameLike(String value)
         {
              addCriterion("cms_content_name like ", value, "cms_content_name");
              return (Criteria) this;
         }

         public Criteria andCmsContentNameNotLike(String value)
         {
              addCriterion("cms_content_name not like ", value, "cms_content_name");
              return (Criteria) this;
         }

         public Criteria andCmsContentNameIn(List<String> values)
         {
              addCriterion("cms_content_name in ", values, "cms_content_name");
              return (Criteria) this;
         }

         public Criteria andCmsContentNameNotIn(List<String> values)
         {
              addCriterion("cms_content_name not in ", values, "cms_content_name");
              return (Criteria) this;
         }

         public Criteria andCmsContentNameBetween(String value1, String value2)
         {
              addCriterion("cms_content_name between ", value1,value2, "cms_content_name");
              return (Criteria) this;
         }

         public Criteria andCmsContentNameNotBetween(String value1, String value2)
         {
              addCriterion("cms_content_name not between ", value1,value2, "cms_content_name");
              return (Criteria) this;
         }

         public Criteria andCmsContentImgIsNull()
         {
              addCriterion("cms_content_img is null");
              return (Criteria) this;
         }

         public Criteria andCmsContentImgIsNotNull()
         {
              addCriterion("cms_content_img is not null");
              return (Criteria) this;
         }

         public Criteria andCmsContentImgEqualTo(String value)
         {
              addCriterion("cms_content_img = ", value, "cms_content_img");
              return (Criteria) this;
         }

         public Criteria andCmsContentImgNotEqualTo(String value)
         {
              addCriterion("cms_content_img <> ", value, "cms_content_img");
              return (Criteria) this;
         }

         public Criteria andCmsContentImgGreaterThan(String value)
         {
              addCriterion("cms_content_img > ", value, "cms_content_img");
              return (Criteria) this;
         }

         public Criteria andCmsContentImgGreaterThanOrEqualTo(String value)
         {
              addCriterion("cms_content_img >= ", value, "cms_content_img");
              return (Criteria) this;
         }

         public Criteria andCmsContentImgLessThan(String value)
         {
              addCriterion("cms_content_img < ", value, "cms_content_img");
              return (Criteria) this;
         }

         public Criteria andCmsContentImgLessThanOrEqualTo(String value)
         {
              addCriterion("cms_content_img <= ", value, "cms_content_img");
              return (Criteria) this;
         }

         public Criteria andCmsContentImgLike(String value)
         {
              addCriterion("cms_content_img like ", value, "cms_content_img");
              return (Criteria) this;
         }

         public Criteria andCmsContentImgNotLike(String value)
         {
              addCriterion("cms_content_img not like ", value, "cms_content_img");
              return (Criteria) this;
         }

         public Criteria andCmsContentImgIn(List<String> values)
         {
              addCriterion("cms_content_img in ", values, "cms_content_img");
              return (Criteria) this;
         }

         public Criteria andCmsContentImgNotIn(List<String> values)
         {
              addCriterion("cms_content_img not in ", values, "cms_content_img");
              return (Criteria) this;
         }

         public Criteria andCmsContentImgBetween(String value1, String value2)
         {
              addCriterion("cms_content_img between ", value1,value2, "cms_content_img");
              return (Criteria) this;
         }

         public Criteria andCmsContentImgNotBetween(String value1, String value2)
         {
              addCriterion("cms_content_img not between ", value1,value2, "cms_content_img");
              return (Criteria) this;
         }

         public Criteria andCmsContentDesIsNull()
         {
              addCriterion("cms_content_des is null");
              return (Criteria) this;
         }

         public Criteria andCmsContentDesIsNotNull()
         {
              addCriterion("cms_content_des is not null");
              return (Criteria) this;
         }

         public Criteria andCmsContentDesEqualTo(String value)
         {
              addCriterion("cms_content_des = ", value, "cms_content_des");
              return (Criteria) this;
         }

         public Criteria andCmsContentDesNotEqualTo(String value)
         {
              addCriterion("cms_content_des <> ", value, "cms_content_des");
              return (Criteria) this;
         }

         public Criteria andCmsContentDesGreaterThan(String value)
         {
              addCriterion("cms_content_des > ", value, "cms_content_des");
              return (Criteria) this;
         }

         public Criteria andCmsContentDesGreaterThanOrEqualTo(String value)
         {
              addCriterion("cms_content_des >= ", value, "cms_content_des");
              return (Criteria) this;
         }

         public Criteria andCmsContentDesLessThan(String value)
         {
              addCriterion("cms_content_des < ", value, "cms_content_des");
              return (Criteria) this;
         }

         public Criteria andCmsContentDesLessThanOrEqualTo(String value)
         {
              addCriterion("cms_content_des <= ", value, "cms_content_des");
              return (Criteria) this;
         }

         public Criteria andCmsContentDesLike(String value)
         {
              addCriterion("cms_content_des like ", value, "cms_content_des");
              return (Criteria) this;
         }

         public Criteria andCmsContentDesNotLike(String value)
         {
              addCriterion("cms_content_des not like ", value, "cms_content_des");
              return (Criteria) this;
         }

         public Criteria andCmsContentDesIn(List<String> values)
         {
              addCriterion("cms_content_des in ", values, "cms_content_des");
              return (Criteria) this;
         }

         public Criteria andCmsContentDesNotIn(List<String> values)
         {
              addCriterion("cms_content_des not in ", values, "cms_content_des");
              return (Criteria) this;
         }

         public Criteria andCmsContentDesBetween(String value1, String value2)
         {
              addCriterion("cms_content_des between ", value1,value2, "cms_content_des");
              return (Criteria) this;
         }

         public Criteria andCmsContentDesNotBetween(String value1, String value2)
         {
              addCriterion("cms_content_des not between ", value1,value2, "cms_content_des");
              return (Criteria) this;
         }

         public Criteria andCmsContentUrlIsNull()
         {
              addCriterion("cms_content_url is null");
              return (Criteria) this;
         }

         public Criteria andCmsContentUrlIsNotNull()
         {
              addCriterion("cms_content_url is not null");
              return (Criteria) this;
         }

         public Criteria andCmsContentUrlEqualTo(String value)
         {
              addCriterion("cms_content_url = ", value, "cms_content_url");
              return (Criteria) this;
         }

         public Criteria andCmsContentUrlNotEqualTo(String value)
         {
              addCriterion("cms_content_url <> ", value, "cms_content_url");
              return (Criteria) this;
         }

         public Criteria andCmsContentUrlGreaterThan(String value)
         {
              addCriterion("cms_content_url > ", value, "cms_content_url");
              return (Criteria) this;
         }

         public Criteria andCmsContentUrlGreaterThanOrEqualTo(String value)
         {
              addCriterion("cms_content_url >= ", value, "cms_content_url");
              return (Criteria) this;
         }

         public Criteria andCmsContentUrlLessThan(String value)
         {
              addCriterion("cms_content_url < ", value, "cms_content_url");
              return (Criteria) this;
         }

         public Criteria andCmsContentUrlLessThanOrEqualTo(String value)
         {
              addCriterion("cms_content_url <= ", value, "cms_content_url");
              return (Criteria) this;
         }

         public Criteria andCmsContentUrlLike(String value)
         {
              addCriterion("cms_content_url like ", value, "cms_content_url");
              return (Criteria) this;
         }

         public Criteria andCmsContentUrlNotLike(String value)
         {
              addCriterion("cms_content_url not like ", value, "cms_content_url");
              return (Criteria) this;
         }

         public Criteria andCmsContentUrlIn(List<String> values)
         {
              addCriterion("cms_content_url in ", values, "cms_content_url");
              return (Criteria) this;
         }

         public Criteria andCmsContentUrlNotIn(List<String> values)
         {
              addCriterion("cms_content_url not in ", values, "cms_content_url");
              return (Criteria) this;
         }

         public Criteria andCmsContentUrlBetween(String value1, String value2)
         {
              addCriterion("cms_content_url between ", value1,value2, "cms_content_url");
              return (Criteria) this;
         }

         public Criteria andCmsContentUrlNotBetween(String value1, String value2)
         {
              addCriterion("cms_content_url not between ", value1,value2, "cms_content_url");
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

         public Criteria andIsTopIsNull()
         {
              addCriterion("is_top is null");
              return (Criteria) this;
         }

         public Criteria andIsTopIsNotNull()
         {
              addCriterion("is_top is not null");
              return (Criteria) this;
         }

         public Criteria andIsTopEqualTo(String value)
         {
              addCriterion("is_top = ", value, "is_top");
              return (Criteria) this;
         }

         public Criteria andIsTopNotEqualTo(String value)
         {
              addCriterion("is_top <> ", value, "is_top");
              return (Criteria) this;
         }

         public Criteria andIsTopGreaterThan(String value)
         {
              addCriterion("is_top > ", value, "is_top");
              return (Criteria) this;
         }

         public Criteria andIsTopGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_top >= ", value, "is_top");
              return (Criteria) this;
         }

         public Criteria andIsTopLessThan(String value)
         {
              addCriterion("is_top < ", value, "is_top");
              return (Criteria) this;
         }

         public Criteria andIsTopLessThanOrEqualTo(String value)
         {
              addCriterion("is_top <= ", value, "is_top");
              return (Criteria) this;
         }

         public Criteria andIsTopLike(String value)
         {
              addCriterion("is_top like ", value, "is_top");
              return (Criteria) this;
         }

         public Criteria andIsTopNotLike(String value)
         {
              addCriterion("is_top not like ", value, "is_top");
              return (Criteria) this;
         }

         public Criteria andIsTopIn(List<String> values)
         {
              addCriterion("is_top in ", values, "is_top");
              return (Criteria) this;
         }

         public Criteria andIsTopNotIn(List<String> values)
         {
              addCriterion("is_top not in ", values, "is_top");
              return (Criteria) this;
         }

         public Criteria andIsTopBetween(String value1, String value2)
         {
              addCriterion("is_top between ", value1,value2, "is_top");
              return (Criteria) this;
         }

         public Criteria andIsTopNotBetween(String value1, String value2)
         {
              addCriterion("is_top not between ", value1,value2, "is_top");
              return (Criteria) this;
         }

         public Criteria andOrderNoIsNull()
         {
              addCriterion("order_no is null");
              return (Criteria) this;
         }

         public Criteria andOrderNoIsNotNull()
         {
              addCriterion("order_no is not null");
              return (Criteria) this;
         }

         public Criteria andOrderNoEqualTo(String value)
         {
              addCriterion("order_no = ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoNotEqualTo(String value)
         {
              addCriterion("order_no <> ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoGreaterThan(String value)
         {
              addCriterion("order_no > ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoGreaterThanOrEqualTo(String value)
         {
              addCriterion("order_no >= ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoLessThan(String value)
         {
              addCriterion("order_no < ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoLessThanOrEqualTo(String value)
         {
              addCriterion("order_no <= ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoLike(String value)
         {
              addCriterion("order_no like ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoNotLike(String value)
         {
              addCriterion("order_no not like ", value, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoIn(List<String> values)
         {
              addCriterion("order_no in ", values, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoNotIn(List<String> values)
         {
              addCriterion("order_no not in ", values, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoBetween(String value1, String value2)
         {
              addCriterion("order_no between ", value1,value2, "order_no");
              return (Criteria) this;
         }

         public Criteria andOrderNoNotBetween(String value1, String value2)
         {
              addCriterion("order_no not between ", value1,value2, "order_no");
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

         public Criteria andPublishTimeIsNull()
         {
              addCriterion("publish_time is null");
              return (Criteria) this;
         }

         public Criteria andPublishTimeIsNotNull()
         {
              addCriterion("publish_time is not null");
              return (Criteria) this;
         }

         public Criteria andPublishTimeEqualTo(Date value)
         {
              addCriterion("publish_time = ", value, "publish_time");
              return (Criteria) this;
         }

         public Criteria andPublishTimeNotEqualTo(Date value)
         {
              addCriterion("publish_time <> ", value, "publish_time");
              return (Criteria) this;
         }

         public Criteria andPublishTimeGreaterThan(Date value)
         {
              addCriterion("publish_time > ", value, "publish_time");
              return (Criteria) this;
         }

         public Criteria andPublishTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("publish_time >= ", value, "publish_time");
              return (Criteria) this;
         }

         public Criteria andPublishTimeLessThan(Date value)
         {
              addCriterion("publish_time < ", value, "publish_time");
              return (Criteria) this;
         }

         public Criteria andPublishTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("publish_time <= ", value, "publish_time");
              return (Criteria) this;
         }

         public Criteria andPublishTimeIn(List<Date> values)
         {
              addCriterion("publish_time in ", values, "publish_time");
              return (Criteria) this;
         }

         public Criteria andPublishTimeNotIn(List<Date> values)
         {
              addCriterion("publish_time not in ", values, "publish_time");
              return (Criteria) this;
         }

         public Criteria andPublishTimeBetween(Date value1, Date value2)
         {
              addCriterion("publish_time between ", value1,value2, "publish_time");
              return (Criteria) this;
         }

         public Criteria andPublishTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("publish_time not between ", value1,value2, "publish_time");
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
