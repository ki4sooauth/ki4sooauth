package com.gooagoo.entity.generator.marketing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 商家通知信息表
 */

public class NoticeInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public NoticeInfoExample()
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

         public Criteria andNoticeInfoIdIsNull()
         {
              addCriterion("notice_info_id is null");
              return (Criteria) this;
         }

         public Criteria andNoticeInfoIdIsNotNull()
         {
              addCriterion("notice_info_id is not null");
              return (Criteria) this;
         }

         public Criteria andNoticeInfoIdEqualTo(String value)
         {
              addCriterion("notice_info_id = ", value, "notice_info_id");
              return (Criteria) this;
         }

         public Criteria andNoticeInfoIdNotEqualTo(String value)
         {
              addCriterion("notice_info_id <> ", value, "notice_info_id");
              return (Criteria) this;
         }

         public Criteria andNoticeInfoIdGreaterThan(String value)
         {
              addCriterion("notice_info_id > ", value, "notice_info_id");
              return (Criteria) this;
         }

         public Criteria andNoticeInfoIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("notice_info_id >= ", value, "notice_info_id");
              return (Criteria) this;
         }

         public Criteria andNoticeInfoIdLessThan(String value)
         {
              addCriterion("notice_info_id < ", value, "notice_info_id");
              return (Criteria) this;
         }

         public Criteria andNoticeInfoIdLessThanOrEqualTo(String value)
         {
              addCriterion("notice_info_id <= ", value, "notice_info_id");
              return (Criteria) this;
         }

         public Criteria andNoticeInfoIdLike(String value)
         {
              addCriterion("notice_info_id like ", value, "notice_info_id");
              return (Criteria) this;
         }

         public Criteria andNoticeInfoIdNotLike(String value)
         {
              addCriterion("notice_info_id not like ", value, "notice_info_id");
              return (Criteria) this;
         }

         public Criteria andNoticeInfoIdIn(List<String> values)
         {
              addCriterion("notice_info_id in ", values, "notice_info_id");
              return (Criteria) this;
         }

         public Criteria andNoticeInfoIdNotIn(List<String> values)
         {
              addCriterion("notice_info_id not in ", values, "notice_info_id");
              return (Criteria) this;
         }

         public Criteria andNoticeInfoIdBetween(String value1, String value2)
         {
              addCriterion("notice_info_id between ", value1,value2, "notice_info_id");
              return (Criteria) this;
         }

         public Criteria andNoticeInfoIdNotBetween(String value1, String value2)
         {
              addCriterion("notice_info_id not between ", value1,value2, "notice_info_id");
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

         public Criteria andNoticeTitleIsNull()
         {
              addCriterion("notice_title is null");
              return (Criteria) this;
         }

         public Criteria andNoticeTitleIsNotNull()
         {
              addCriterion("notice_title is not null");
              return (Criteria) this;
         }

         public Criteria andNoticeTitleEqualTo(String value)
         {
              addCriterion("notice_title = ", value, "notice_title");
              return (Criteria) this;
         }

         public Criteria andNoticeTitleNotEqualTo(String value)
         {
              addCriterion("notice_title <> ", value, "notice_title");
              return (Criteria) this;
         }

         public Criteria andNoticeTitleGreaterThan(String value)
         {
              addCriterion("notice_title > ", value, "notice_title");
              return (Criteria) this;
         }

         public Criteria andNoticeTitleGreaterThanOrEqualTo(String value)
         {
              addCriterion("notice_title >= ", value, "notice_title");
              return (Criteria) this;
         }

         public Criteria andNoticeTitleLessThan(String value)
         {
              addCriterion("notice_title < ", value, "notice_title");
              return (Criteria) this;
         }

         public Criteria andNoticeTitleLessThanOrEqualTo(String value)
         {
              addCriterion("notice_title <= ", value, "notice_title");
              return (Criteria) this;
         }

         public Criteria andNoticeTitleLike(String value)
         {
              addCriterion("notice_title like ", value, "notice_title");
              return (Criteria) this;
         }

         public Criteria andNoticeTitleNotLike(String value)
         {
              addCriterion("notice_title not like ", value, "notice_title");
              return (Criteria) this;
         }

         public Criteria andNoticeTitleIn(List<String> values)
         {
              addCriterion("notice_title in ", values, "notice_title");
              return (Criteria) this;
         }

         public Criteria andNoticeTitleNotIn(List<String> values)
         {
              addCriterion("notice_title not in ", values, "notice_title");
              return (Criteria) this;
         }

         public Criteria andNoticeTitleBetween(String value1, String value2)
         {
              addCriterion("notice_title between ", value1,value2, "notice_title");
              return (Criteria) this;
         }

         public Criteria andNoticeTitleNotBetween(String value1, String value2)
         {
              addCriterion("notice_title not between ", value1,value2, "notice_title");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkTypeIsNull()
         {
              addCriterion("marketing_link_type is null");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkTypeIsNotNull()
         {
              addCriterion("marketing_link_type is not null");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkTypeEqualTo(String value)
         {
              addCriterion("marketing_link_type = ", value, "marketing_link_type");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkTypeNotEqualTo(String value)
         {
              addCriterion("marketing_link_type <> ", value, "marketing_link_type");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkTypeGreaterThan(String value)
         {
              addCriterion("marketing_link_type > ", value, "marketing_link_type");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("marketing_link_type >= ", value, "marketing_link_type");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkTypeLessThan(String value)
         {
              addCriterion("marketing_link_type < ", value, "marketing_link_type");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkTypeLessThanOrEqualTo(String value)
         {
              addCriterion("marketing_link_type <= ", value, "marketing_link_type");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkTypeLike(String value)
         {
              addCriterion("marketing_link_type like ", value, "marketing_link_type");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkTypeNotLike(String value)
         {
              addCriterion("marketing_link_type not like ", value, "marketing_link_type");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkTypeIn(List<String> values)
         {
              addCriterion("marketing_link_type in ", values, "marketing_link_type");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkTypeNotIn(List<String> values)
         {
              addCriterion("marketing_link_type not in ", values, "marketing_link_type");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkTypeBetween(String value1, String value2)
         {
              addCriterion("marketing_link_type between ", value1,value2, "marketing_link_type");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkTypeNotBetween(String value1, String value2)
         {
              addCriterion("marketing_link_type not between ", value1,value2, "marketing_link_type");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkIdIsNull()
         {
              addCriterion("marketing_link_id is null");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkIdIsNotNull()
         {
              addCriterion("marketing_link_id is not null");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkIdEqualTo(String value)
         {
              addCriterion("marketing_link_id = ", value, "marketing_link_id");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkIdNotEqualTo(String value)
         {
              addCriterion("marketing_link_id <> ", value, "marketing_link_id");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkIdGreaterThan(String value)
         {
              addCriterion("marketing_link_id > ", value, "marketing_link_id");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("marketing_link_id >= ", value, "marketing_link_id");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkIdLessThan(String value)
         {
              addCriterion("marketing_link_id < ", value, "marketing_link_id");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkIdLessThanOrEqualTo(String value)
         {
              addCriterion("marketing_link_id <= ", value, "marketing_link_id");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkIdLike(String value)
         {
              addCriterion("marketing_link_id like ", value, "marketing_link_id");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkIdNotLike(String value)
         {
              addCriterion("marketing_link_id not like ", value, "marketing_link_id");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkIdIn(List<String> values)
         {
              addCriterion("marketing_link_id in ", values, "marketing_link_id");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkIdNotIn(List<String> values)
         {
              addCriterion("marketing_link_id not in ", values, "marketing_link_id");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkIdBetween(String value1, String value2)
         {
              addCriterion("marketing_link_id between ", value1,value2, "marketing_link_id");
              return (Criteria) this;
         }

         public Criteria andMarketingLinkIdNotBetween(String value1, String value2)
         {
              addCriterion("marketing_link_id not between ", value1,value2, "marketing_link_id");
              return (Criteria) this;
         }

         public Criteria andNoticeTextMobileIsNull()
         {
              addCriterion("notice_text_mobile is null");
              return (Criteria) this;
         }

         public Criteria andNoticeTextMobileIsNotNull()
         {
              addCriterion("notice_text_mobile is not null");
              return (Criteria) this;
         }

         public Criteria andNoticeTextMobileEqualTo(String value)
         {
              addCriterion("notice_text_mobile = ", value, "notice_text_mobile");
              return (Criteria) this;
         }

         public Criteria andNoticeTextMobileNotEqualTo(String value)
         {
              addCriterion("notice_text_mobile <> ", value, "notice_text_mobile");
              return (Criteria) this;
         }

         public Criteria andNoticeTextMobileGreaterThan(String value)
         {
              addCriterion("notice_text_mobile > ", value, "notice_text_mobile");
              return (Criteria) this;
         }

         public Criteria andNoticeTextMobileGreaterThanOrEqualTo(String value)
         {
              addCriterion("notice_text_mobile >= ", value, "notice_text_mobile");
              return (Criteria) this;
         }

         public Criteria andNoticeTextMobileLessThan(String value)
         {
              addCriterion("notice_text_mobile < ", value, "notice_text_mobile");
              return (Criteria) this;
         }

         public Criteria andNoticeTextMobileLessThanOrEqualTo(String value)
         {
              addCriterion("notice_text_mobile <= ", value, "notice_text_mobile");
              return (Criteria) this;
         }

         public Criteria andNoticeTextMobileLike(String value)
         {
              addCriterion("notice_text_mobile like ", value, "notice_text_mobile");
              return (Criteria) this;
         }

         public Criteria andNoticeTextMobileNotLike(String value)
         {
              addCriterion("notice_text_mobile not like ", value, "notice_text_mobile");
              return (Criteria) this;
         }

         public Criteria andNoticeTextMobileIn(List<String> values)
         {
              addCriterion("notice_text_mobile in ", values, "notice_text_mobile");
              return (Criteria) this;
         }

         public Criteria andNoticeTextMobileNotIn(List<String> values)
         {
              addCriterion("notice_text_mobile not in ", values, "notice_text_mobile");
              return (Criteria) this;
         }

         public Criteria andNoticeTextMobileBetween(String value1, String value2)
         {
              addCriterion("notice_text_mobile between ", value1,value2, "notice_text_mobile");
              return (Criteria) this;
         }

         public Criteria andNoticeTextMobileNotBetween(String value1, String value2)
         {
              addCriterion("notice_text_mobile not between ", value1,value2, "notice_text_mobile");
              return (Criteria) this;
         }

         public Criteria andNoticeTextWebIsNull()
         {
              addCriterion("notice_text_web is null");
              return (Criteria) this;
         }

         public Criteria andNoticeTextWebIsNotNull()
         {
              addCriterion("notice_text_web is not null");
              return (Criteria) this;
         }

         public Criteria andNoticeTextWebEqualTo(String value)
         {
              addCriterion("notice_text_web = ", value, "notice_text_web");
              return (Criteria) this;
         }

         public Criteria andNoticeTextWebNotEqualTo(String value)
         {
              addCriterion("notice_text_web <> ", value, "notice_text_web");
              return (Criteria) this;
         }

         public Criteria andNoticeTextWebGreaterThan(String value)
         {
              addCriterion("notice_text_web > ", value, "notice_text_web");
              return (Criteria) this;
         }

         public Criteria andNoticeTextWebGreaterThanOrEqualTo(String value)
         {
              addCriterion("notice_text_web >= ", value, "notice_text_web");
              return (Criteria) this;
         }

         public Criteria andNoticeTextWebLessThan(String value)
         {
              addCriterion("notice_text_web < ", value, "notice_text_web");
              return (Criteria) this;
         }

         public Criteria andNoticeTextWebLessThanOrEqualTo(String value)
         {
              addCriterion("notice_text_web <= ", value, "notice_text_web");
              return (Criteria) this;
         }

         public Criteria andNoticeTextWebLike(String value)
         {
              addCriterion("notice_text_web like ", value, "notice_text_web");
              return (Criteria) this;
         }

         public Criteria andNoticeTextWebNotLike(String value)
         {
              addCriterion("notice_text_web not like ", value, "notice_text_web");
              return (Criteria) this;
         }

         public Criteria andNoticeTextWebIn(List<String> values)
         {
              addCriterion("notice_text_web in ", values, "notice_text_web");
              return (Criteria) this;
         }

         public Criteria andNoticeTextWebNotIn(List<String> values)
         {
              addCriterion("notice_text_web not in ", values, "notice_text_web");
              return (Criteria) this;
         }

         public Criteria andNoticeTextWebBetween(String value1, String value2)
         {
              addCriterion("notice_text_web between ", value1,value2, "notice_text_web");
              return (Criteria) this;
         }

         public Criteria andNoticeTextWebNotBetween(String value1, String value2)
         {
              addCriterion("notice_text_web not between ", value1,value2, "notice_text_web");
              return (Criteria) this;
         }

         public Criteria andImgIsNull()
         {
              addCriterion("img is null");
              return (Criteria) this;
         }

         public Criteria andImgIsNotNull()
         {
              addCriterion("img is not null");
              return (Criteria) this;
         }

         public Criteria andImgEqualTo(String value)
         {
              addCriterion("img = ", value, "img");
              return (Criteria) this;
         }

         public Criteria andImgNotEqualTo(String value)
         {
              addCriterion("img <> ", value, "img");
              return (Criteria) this;
         }

         public Criteria andImgGreaterThan(String value)
         {
              addCriterion("img > ", value, "img");
              return (Criteria) this;
         }

         public Criteria andImgGreaterThanOrEqualTo(String value)
         {
              addCriterion("img >= ", value, "img");
              return (Criteria) this;
         }

         public Criteria andImgLessThan(String value)
         {
              addCriterion("img < ", value, "img");
              return (Criteria) this;
         }

         public Criteria andImgLessThanOrEqualTo(String value)
         {
              addCriterion("img <= ", value, "img");
              return (Criteria) this;
         }

         public Criteria andImgLike(String value)
         {
              addCriterion("img like ", value, "img");
              return (Criteria) this;
         }

         public Criteria andImgNotLike(String value)
         {
              addCriterion("img not like ", value, "img");
              return (Criteria) this;
         }

         public Criteria andImgIn(List<String> values)
         {
              addCriterion("img in ", values, "img");
              return (Criteria) this;
         }

         public Criteria andImgNotIn(List<String> values)
         {
              addCriterion("img not in ", values, "img");
              return (Criteria) this;
         }

         public Criteria andImgBetween(String value1, String value2)
         {
              addCriterion("img between ", value1,value2, "img");
              return (Criteria) this;
         }

         public Criteria andImgNotBetween(String value1, String value2)
         {
              addCriterion("img not between ", value1,value2, "img");
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

         public Criteria andRuleIdIsNull()
         {
              addCriterion("rule_id is null");
              return (Criteria) this;
         }

         public Criteria andRuleIdIsNotNull()
         {
              addCriterion("rule_id is not null");
              return (Criteria) this;
         }

         public Criteria andRuleIdEqualTo(String value)
         {
              addCriterion("rule_id = ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdNotEqualTo(String value)
         {
              addCriterion("rule_id <> ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdGreaterThan(String value)
         {
              addCriterion("rule_id > ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("rule_id >= ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdLessThan(String value)
         {
              addCriterion("rule_id < ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdLessThanOrEqualTo(String value)
         {
              addCriterion("rule_id <= ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdLike(String value)
         {
              addCriterion("rule_id like ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdNotLike(String value)
         {
              addCriterion("rule_id not like ", value, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdIn(List<String> values)
         {
              addCriterion("rule_id in ", values, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdNotIn(List<String> values)
         {
              addCriterion("rule_id not in ", values, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdBetween(String value1, String value2)
         {
              addCriterion("rule_id between ", value1,value2, "rule_id");
              return (Criteria) this;
         }

         public Criteria andRuleIdNotBetween(String value1, String value2)
         {
              addCriterion("rule_id not between ", value1,value2, "rule_id");
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
