package com.gooagoo.entity.generator.marketing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 营销内容与商品、活动、优惠凭证关联表
 */

public class MarketingItemLinkExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public MarketingItemLinkExample()
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

         public Criteria andMarketingTypeIsNull()
         {
              addCriterion("marketing_type is null");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeIsNotNull()
         {
              addCriterion("marketing_type is not null");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeEqualTo(String value)
         {
              addCriterion("marketing_type = ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeNotEqualTo(String value)
         {
              addCriterion("marketing_type <> ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeGreaterThan(String value)
         {
              addCriterion("marketing_type > ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("marketing_type >= ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeLessThan(String value)
         {
              addCriterion("marketing_type < ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeLessThanOrEqualTo(String value)
         {
              addCriterion("marketing_type <= ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeLike(String value)
         {
              addCriterion("marketing_type like ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeNotLike(String value)
         {
              addCriterion("marketing_type not like ", value, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeIn(List<String> values)
         {
              addCriterion("marketing_type in ", values, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeNotIn(List<String> values)
         {
              addCriterion("marketing_type not in ", values, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeBetween(String value1, String value2)
         {
              addCriterion("marketing_type between ", value1,value2, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingTypeNotBetween(String value1, String value2)
         {
              addCriterion("marketing_type not between ", value1,value2, "marketing_type");
              return (Criteria) this;
         }

         public Criteria andMarketingIdIsNull()
         {
              addCriterion("marketing_id is null");
              return (Criteria) this;
         }

         public Criteria andMarketingIdIsNotNull()
         {
              addCriterion("marketing_id is not null");
              return (Criteria) this;
         }

         public Criteria andMarketingIdEqualTo(String value)
         {
              addCriterion("marketing_id = ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdNotEqualTo(String value)
         {
              addCriterion("marketing_id <> ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdGreaterThan(String value)
         {
              addCriterion("marketing_id > ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("marketing_id >= ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdLessThan(String value)
         {
              addCriterion("marketing_id < ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdLessThanOrEqualTo(String value)
         {
              addCriterion("marketing_id <= ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdLike(String value)
         {
              addCriterion("marketing_id like ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdNotLike(String value)
         {
              addCriterion("marketing_id not like ", value, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdIn(List<String> values)
         {
              addCriterion("marketing_id in ", values, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdNotIn(List<String> values)
         {
              addCriterion("marketing_id not in ", values, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdBetween(String value1, String value2)
         {
              addCriterion("marketing_id between ", value1,value2, "marketing_id");
              return (Criteria) this;
         }

         public Criteria andMarketingIdNotBetween(String value1, String value2)
         {
              addCriterion("marketing_id not between ", value1,value2, "marketing_id");
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

         public Criteria andSortIsNull()
         {
              addCriterion("sort is null");
              return (Criteria) this;
         }

         public Criteria andSortIsNotNull()
         {
              addCriterion("sort is not null");
              return (Criteria) this;
         }

         public Criteria andSortEqualTo(String value)
         {
              addCriterion("sort = ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortNotEqualTo(String value)
         {
              addCriterion("sort <> ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortGreaterThan(String value)
         {
              addCriterion("sort > ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortGreaterThanOrEqualTo(String value)
         {
              addCriterion("sort >= ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortLessThan(String value)
         {
              addCriterion("sort < ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortLessThanOrEqualTo(String value)
         {
              addCriterion("sort <= ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortLike(String value)
         {
              addCriterion("sort like ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortNotLike(String value)
         {
              addCriterion("sort not like ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortIn(List<String> values)
         {
              addCriterion("sort in ", values, "sort");
              return (Criteria) this;
         }

         public Criteria andSortNotIn(List<String> values)
         {
              addCriterion("sort not in ", values, "sort");
              return (Criteria) this;
         }

         public Criteria andSortBetween(String value1, String value2)
         {
              addCriterion("sort between ", value1,value2, "sort");
              return (Criteria) this;
         }

         public Criteria andSortNotBetween(String value1, String value2)
         {
              addCriterion("sort not between ", value1,value2, "sort");
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
