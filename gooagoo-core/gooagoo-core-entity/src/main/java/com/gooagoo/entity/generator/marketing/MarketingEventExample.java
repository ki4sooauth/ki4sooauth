package com.gooagoo.entity.generator.marketing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 营销事件
 */

public class MarketingEventExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public MarketingEventExample()
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

         public Criteria andEventIdIsNull()
         {
              addCriterion("event_id is null");
              return (Criteria) this;
         }

         public Criteria andEventIdIsNotNull()
         {
              addCriterion("event_id is not null");
              return (Criteria) this;
         }

         public Criteria andEventIdEqualTo(String value)
         {
              addCriterion("event_id = ", value, "event_id");
              return (Criteria) this;
         }

         public Criteria andEventIdNotEqualTo(String value)
         {
              addCriterion("event_id <> ", value, "event_id");
              return (Criteria) this;
         }

         public Criteria andEventIdGreaterThan(String value)
         {
              addCriterion("event_id > ", value, "event_id");
              return (Criteria) this;
         }

         public Criteria andEventIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("event_id >= ", value, "event_id");
              return (Criteria) this;
         }

         public Criteria andEventIdLessThan(String value)
         {
              addCriterion("event_id < ", value, "event_id");
              return (Criteria) this;
         }

         public Criteria andEventIdLessThanOrEqualTo(String value)
         {
              addCriterion("event_id <= ", value, "event_id");
              return (Criteria) this;
         }

         public Criteria andEventIdLike(String value)
         {
              addCriterion("event_id like ", value, "event_id");
              return (Criteria) this;
         }

         public Criteria andEventIdNotLike(String value)
         {
              addCriterion("event_id not like ", value, "event_id");
              return (Criteria) this;
         }

         public Criteria andEventIdIn(List<String> values)
         {
              addCriterion("event_id in ", values, "event_id");
              return (Criteria) this;
         }

         public Criteria andEventIdNotIn(List<String> values)
         {
              addCriterion("event_id not in ", values, "event_id");
              return (Criteria) this;
         }

         public Criteria andEventIdBetween(String value1, String value2)
         {
              addCriterion("event_id between ", value1,value2, "event_id");
              return (Criteria) this;
         }

         public Criteria andEventIdNotBetween(String value1, String value2)
         {
              addCriterion("event_id not between ", value1,value2, "event_id");
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

         public Criteria andEventNameIsNull()
         {
              addCriterion("event_name is null");
              return (Criteria) this;
         }

         public Criteria andEventNameIsNotNull()
         {
              addCriterion("event_name is not null");
              return (Criteria) this;
         }

         public Criteria andEventNameEqualTo(String value)
         {
              addCriterion("event_name = ", value, "event_name");
              return (Criteria) this;
         }

         public Criteria andEventNameNotEqualTo(String value)
         {
              addCriterion("event_name <> ", value, "event_name");
              return (Criteria) this;
         }

         public Criteria andEventNameGreaterThan(String value)
         {
              addCriterion("event_name > ", value, "event_name");
              return (Criteria) this;
         }

         public Criteria andEventNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("event_name >= ", value, "event_name");
              return (Criteria) this;
         }

         public Criteria andEventNameLessThan(String value)
         {
              addCriterion("event_name < ", value, "event_name");
              return (Criteria) this;
         }

         public Criteria andEventNameLessThanOrEqualTo(String value)
         {
              addCriterion("event_name <= ", value, "event_name");
              return (Criteria) this;
         }

         public Criteria andEventNameLike(String value)
         {
              addCriterion("event_name like ", value, "event_name");
              return (Criteria) this;
         }

         public Criteria andEventNameNotLike(String value)
         {
              addCriterion("event_name not like ", value, "event_name");
              return (Criteria) this;
         }

         public Criteria andEventNameIn(List<String> values)
         {
              addCriterion("event_name in ", values, "event_name");
              return (Criteria) this;
         }

         public Criteria andEventNameNotIn(List<String> values)
         {
              addCriterion("event_name not in ", values, "event_name");
              return (Criteria) this;
         }

         public Criteria andEventNameBetween(String value1, String value2)
         {
              addCriterion("event_name between ", value1,value2, "event_name");
              return (Criteria) this;
         }

         public Criteria andEventNameNotBetween(String value1, String value2)
         {
              addCriterion("event_name not between ", value1,value2, "event_name");
              return (Criteria) this;
         }

         public Criteria andEventTargetIsNull()
         {
              addCriterion("event_target is null");
              return (Criteria) this;
         }

         public Criteria andEventTargetIsNotNull()
         {
              addCriterion("event_target is not null");
              return (Criteria) this;
         }

         public Criteria andEventTargetEqualTo(String value)
         {
              addCriterion("event_target = ", value, "event_target");
              return (Criteria) this;
         }

         public Criteria andEventTargetNotEqualTo(String value)
         {
              addCriterion("event_target <> ", value, "event_target");
              return (Criteria) this;
         }

         public Criteria andEventTargetGreaterThan(String value)
         {
              addCriterion("event_target > ", value, "event_target");
              return (Criteria) this;
         }

         public Criteria andEventTargetGreaterThanOrEqualTo(String value)
         {
              addCriterion("event_target >= ", value, "event_target");
              return (Criteria) this;
         }

         public Criteria andEventTargetLessThan(String value)
         {
              addCriterion("event_target < ", value, "event_target");
              return (Criteria) this;
         }

         public Criteria andEventTargetLessThanOrEqualTo(String value)
         {
              addCriterion("event_target <= ", value, "event_target");
              return (Criteria) this;
         }

         public Criteria andEventTargetLike(String value)
         {
              addCriterion("event_target like ", value, "event_target");
              return (Criteria) this;
         }

         public Criteria andEventTargetNotLike(String value)
         {
              addCriterion("event_target not like ", value, "event_target");
              return (Criteria) this;
         }

         public Criteria andEventTargetIn(List<String> values)
         {
              addCriterion("event_target in ", values, "event_target");
              return (Criteria) this;
         }

         public Criteria andEventTargetNotIn(List<String> values)
         {
              addCriterion("event_target not in ", values, "event_target");
              return (Criteria) this;
         }

         public Criteria andEventTargetBetween(String value1, String value2)
         {
              addCriterion("event_target between ", value1,value2, "event_target");
              return (Criteria) this;
         }

         public Criteria andEventTargetNotBetween(String value1, String value2)
         {
              addCriterion("event_target not between ", value1,value2, "event_target");
              return (Criteria) this;
         }

         public Criteria andChannelRootIsNull()
         {
              addCriterion("channel_root is null");
              return (Criteria) this;
         }

         public Criteria andChannelRootIsNotNull()
         {
              addCriterion("channel_root is not null");
              return (Criteria) this;
         }

         public Criteria andChannelRootEqualTo(String value)
         {
              addCriterion("channel_root = ", value, "channel_root");
              return (Criteria) this;
         }

         public Criteria andChannelRootNotEqualTo(String value)
         {
              addCriterion("channel_root <> ", value, "channel_root");
              return (Criteria) this;
         }

         public Criteria andChannelRootGreaterThan(String value)
         {
              addCriterion("channel_root > ", value, "channel_root");
              return (Criteria) this;
         }

         public Criteria andChannelRootGreaterThanOrEqualTo(String value)
         {
              addCriterion("channel_root >= ", value, "channel_root");
              return (Criteria) this;
         }

         public Criteria andChannelRootLessThan(String value)
         {
              addCriterion("channel_root < ", value, "channel_root");
              return (Criteria) this;
         }

         public Criteria andChannelRootLessThanOrEqualTo(String value)
         {
              addCriterion("channel_root <= ", value, "channel_root");
              return (Criteria) this;
         }

         public Criteria andChannelRootLike(String value)
         {
              addCriterion("channel_root like ", value, "channel_root");
              return (Criteria) this;
         }

         public Criteria andChannelRootNotLike(String value)
         {
              addCriterion("channel_root not like ", value, "channel_root");
              return (Criteria) this;
         }

         public Criteria andChannelRootIn(List<String> values)
         {
              addCriterion("channel_root in ", values, "channel_root");
              return (Criteria) this;
         }

         public Criteria andChannelRootNotIn(List<String> values)
         {
              addCriterion("channel_root not in ", values, "channel_root");
              return (Criteria) this;
         }

         public Criteria andChannelRootBetween(String value1, String value2)
         {
              addCriterion("channel_root between ", value1,value2, "channel_root");
              return (Criteria) this;
         }

         public Criteria andChannelRootNotBetween(String value1, String value2)
         {
              addCriterion("channel_root not between ", value1,value2, "channel_root");
              return (Criteria) this;
         }

         public Criteria andChannelLeafIsNull()
         {
              addCriterion("channel_leaf is null");
              return (Criteria) this;
         }

         public Criteria andChannelLeafIsNotNull()
         {
              addCriterion("channel_leaf is not null");
              return (Criteria) this;
         }

         public Criteria andChannelLeafEqualTo(String value)
         {
              addCriterion("channel_leaf = ", value, "channel_leaf");
              return (Criteria) this;
         }

         public Criteria andChannelLeafNotEqualTo(String value)
         {
              addCriterion("channel_leaf <> ", value, "channel_leaf");
              return (Criteria) this;
         }

         public Criteria andChannelLeafGreaterThan(String value)
         {
              addCriterion("channel_leaf > ", value, "channel_leaf");
              return (Criteria) this;
         }

         public Criteria andChannelLeafGreaterThanOrEqualTo(String value)
         {
              addCriterion("channel_leaf >= ", value, "channel_leaf");
              return (Criteria) this;
         }

         public Criteria andChannelLeafLessThan(String value)
         {
              addCriterion("channel_leaf < ", value, "channel_leaf");
              return (Criteria) this;
         }

         public Criteria andChannelLeafLessThanOrEqualTo(String value)
         {
              addCriterion("channel_leaf <= ", value, "channel_leaf");
              return (Criteria) this;
         }

         public Criteria andChannelLeafLike(String value)
         {
              addCriterion("channel_leaf like ", value, "channel_leaf");
              return (Criteria) this;
         }

         public Criteria andChannelLeafNotLike(String value)
         {
              addCriterion("channel_leaf not like ", value, "channel_leaf");
              return (Criteria) this;
         }

         public Criteria andChannelLeafIn(List<String> values)
         {
              addCriterion("channel_leaf in ", values, "channel_leaf");
              return (Criteria) this;
         }

         public Criteria andChannelLeafNotIn(List<String> values)
         {
              addCriterion("channel_leaf not in ", values, "channel_leaf");
              return (Criteria) this;
         }

         public Criteria andChannelLeafBetween(String value1, String value2)
         {
              addCriterion("channel_leaf between ", value1,value2, "channel_leaf");
              return (Criteria) this;
         }

         public Criteria andChannelLeafNotBetween(String value1, String value2)
         {
              addCriterion("channel_leaf not between ", value1,value2, "channel_leaf");
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
