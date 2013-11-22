package com.gooagoo.entity.generator.behave;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 收藏信息
 */

public class FavoriteInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public FavoriteInfoExample()
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

         public Criteria andFavoriteIdIsNull()
         {
              addCriterion("favorite_id is null");
              return (Criteria) this;
         }

         public Criteria andFavoriteIdIsNotNull()
         {
              addCriterion("favorite_id is not null");
              return (Criteria) this;
         }

         public Criteria andFavoriteIdEqualTo(String value)
         {
              addCriterion("favorite_id = ", value, "favorite_id");
              return (Criteria) this;
         }

         public Criteria andFavoriteIdNotEqualTo(String value)
         {
              addCriterion("favorite_id <> ", value, "favorite_id");
              return (Criteria) this;
         }

         public Criteria andFavoriteIdGreaterThan(String value)
         {
              addCriterion("favorite_id > ", value, "favorite_id");
              return (Criteria) this;
         }

         public Criteria andFavoriteIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("favorite_id >= ", value, "favorite_id");
              return (Criteria) this;
         }

         public Criteria andFavoriteIdLessThan(String value)
         {
              addCriterion("favorite_id < ", value, "favorite_id");
              return (Criteria) this;
         }

         public Criteria andFavoriteIdLessThanOrEqualTo(String value)
         {
              addCriterion("favorite_id <= ", value, "favorite_id");
              return (Criteria) this;
         }

         public Criteria andFavoriteIdLike(String value)
         {
              addCriterion("favorite_id like ", value, "favorite_id");
              return (Criteria) this;
         }

         public Criteria andFavoriteIdNotLike(String value)
         {
              addCriterion("favorite_id not like ", value, "favorite_id");
              return (Criteria) this;
         }

         public Criteria andFavoriteIdIn(List<String> values)
         {
              addCriterion("favorite_id in ", values, "favorite_id");
              return (Criteria) this;
         }

         public Criteria andFavoriteIdNotIn(List<String> values)
         {
              addCriterion("favorite_id not in ", values, "favorite_id");
              return (Criteria) this;
         }

         public Criteria andFavoriteIdBetween(String value1, String value2)
         {
              addCriterion("favorite_id between ", value1,value2, "favorite_id");
              return (Criteria) this;
         }

         public Criteria andFavoriteIdNotBetween(String value1, String value2)
         {
              addCriterion("favorite_id not between ", value1,value2, "favorite_id");
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

         public Criteria andInfoTitleIsNull()
         {
              addCriterion("info_title is null");
              return (Criteria) this;
         }

         public Criteria andInfoTitleIsNotNull()
         {
              addCriterion("info_title is not null");
              return (Criteria) this;
         }

         public Criteria andInfoTitleEqualTo(String value)
         {
              addCriterion("info_title = ", value, "info_title");
              return (Criteria) this;
         }

         public Criteria andInfoTitleNotEqualTo(String value)
         {
              addCriterion("info_title <> ", value, "info_title");
              return (Criteria) this;
         }

         public Criteria andInfoTitleGreaterThan(String value)
         {
              addCriterion("info_title > ", value, "info_title");
              return (Criteria) this;
         }

         public Criteria andInfoTitleGreaterThanOrEqualTo(String value)
         {
              addCriterion("info_title >= ", value, "info_title");
              return (Criteria) this;
         }

         public Criteria andInfoTitleLessThan(String value)
         {
              addCriterion("info_title < ", value, "info_title");
              return (Criteria) this;
         }

         public Criteria andInfoTitleLessThanOrEqualTo(String value)
         {
              addCriterion("info_title <= ", value, "info_title");
              return (Criteria) this;
         }

         public Criteria andInfoTitleLike(String value)
         {
              addCriterion("info_title like ", value, "info_title");
              return (Criteria) this;
         }

         public Criteria andInfoTitleNotLike(String value)
         {
              addCriterion("info_title not like ", value, "info_title");
              return (Criteria) this;
         }

         public Criteria andInfoTitleIn(List<String> values)
         {
              addCriterion("info_title in ", values, "info_title");
              return (Criteria) this;
         }

         public Criteria andInfoTitleNotIn(List<String> values)
         {
              addCriterion("info_title not in ", values, "info_title");
              return (Criteria) this;
         }

         public Criteria andInfoTitleBetween(String value1, String value2)
         {
              addCriterion("info_title between ", value1,value2, "info_title");
              return (Criteria) this;
         }

         public Criteria andInfoTitleNotBetween(String value1, String value2)
         {
              addCriterion("info_title not between ", value1,value2, "info_title");
              return (Criteria) this;
         }

         public Criteria andInfoTypeIsNull()
         {
              addCriterion("info_type is null");
              return (Criteria) this;
         }

         public Criteria andInfoTypeIsNotNull()
         {
              addCriterion("info_type is not null");
              return (Criteria) this;
         }

         public Criteria andInfoTypeEqualTo(String value)
         {
              addCriterion("info_type = ", value, "info_type");
              return (Criteria) this;
         }

         public Criteria andInfoTypeNotEqualTo(String value)
         {
              addCriterion("info_type <> ", value, "info_type");
              return (Criteria) this;
         }

         public Criteria andInfoTypeGreaterThan(String value)
         {
              addCriterion("info_type > ", value, "info_type");
              return (Criteria) this;
         }

         public Criteria andInfoTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("info_type >= ", value, "info_type");
              return (Criteria) this;
         }

         public Criteria andInfoTypeLessThan(String value)
         {
              addCriterion("info_type < ", value, "info_type");
              return (Criteria) this;
         }

         public Criteria andInfoTypeLessThanOrEqualTo(String value)
         {
              addCriterion("info_type <= ", value, "info_type");
              return (Criteria) this;
         }

         public Criteria andInfoTypeLike(String value)
         {
              addCriterion("info_type like ", value, "info_type");
              return (Criteria) this;
         }

         public Criteria andInfoTypeNotLike(String value)
         {
              addCriterion("info_type not like ", value, "info_type");
              return (Criteria) this;
         }

         public Criteria andInfoTypeIn(List<String> values)
         {
              addCriterion("info_type in ", values, "info_type");
              return (Criteria) this;
         }

         public Criteria andInfoTypeNotIn(List<String> values)
         {
              addCriterion("info_type not in ", values, "info_type");
              return (Criteria) this;
         }

         public Criteria andInfoTypeBetween(String value1, String value2)
         {
              addCriterion("info_type between ", value1,value2, "info_type");
              return (Criteria) this;
         }

         public Criteria andInfoTypeNotBetween(String value1, String value2)
         {
              addCriterion("info_type not between ", value1,value2, "info_type");
              return (Criteria) this;
         }

         public Criteria andInfoUrlIsNull()
         {
              addCriterion("info_url is null");
              return (Criteria) this;
         }

         public Criteria andInfoUrlIsNotNull()
         {
              addCriterion("info_url is not null");
              return (Criteria) this;
         }

         public Criteria andInfoUrlEqualTo(String value)
         {
              addCriterion("info_url = ", value, "info_url");
              return (Criteria) this;
         }

         public Criteria andInfoUrlNotEqualTo(String value)
         {
              addCriterion("info_url <> ", value, "info_url");
              return (Criteria) this;
         }

         public Criteria andInfoUrlGreaterThan(String value)
         {
              addCriterion("info_url > ", value, "info_url");
              return (Criteria) this;
         }

         public Criteria andInfoUrlGreaterThanOrEqualTo(String value)
         {
              addCriterion("info_url >= ", value, "info_url");
              return (Criteria) this;
         }

         public Criteria andInfoUrlLessThan(String value)
         {
              addCriterion("info_url < ", value, "info_url");
              return (Criteria) this;
         }

         public Criteria andInfoUrlLessThanOrEqualTo(String value)
         {
              addCriterion("info_url <= ", value, "info_url");
              return (Criteria) this;
         }

         public Criteria andInfoUrlLike(String value)
         {
              addCriterion("info_url like ", value, "info_url");
              return (Criteria) this;
         }

         public Criteria andInfoUrlNotLike(String value)
         {
              addCriterion("info_url not like ", value, "info_url");
              return (Criteria) this;
         }

         public Criteria andInfoUrlIn(List<String> values)
         {
              addCriterion("info_url in ", values, "info_url");
              return (Criteria) this;
         }

         public Criteria andInfoUrlNotIn(List<String> values)
         {
              addCriterion("info_url not in ", values, "info_url");
              return (Criteria) this;
         }

         public Criteria andInfoUrlBetween(String value1, String value2)
         {
              addCriterion("info_url between ", value1,value2, "info_url");
              return (Criteria) this;
         }

         public Criteria andInfoUrlNotBetween(String value1, String value2)
         {
              addCriterion("info_url not between ", value1,value2, "info_url");
              return (Criteria) this;
         }

         public Criteria andObjectIdIsNull()
         {
              addCriterion("object_id is null");
              return (Criteria) this;
         }

         public Criteria andObjectIdIsNotNull()
         {
              addCriterion("object_id is not null");
              return (Criteria) this;
         }

         public Criteria andObjectIdEqualTo(String value)
         {
              addCriterion("object_id = ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdNotEqualTo(String value)
         {
              addCriterion("object_id <> ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdGreaterThan(String value)
         {
              addCriterion("object_id > ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("object_id >= ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdLessThan(String value)
         {
              addCriterion("object_id < ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdLessThanOrEqualTo(String value)
         {
              addCriterion("object_id <= ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdLike(String value)
         {
              addCriterion("object_id like ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdNotLike(String value)
         {
              addCriterion("object_id not like ", value, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdIn(List<String> values)
         {
              addCriterion("object_id in ", values, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdNotIn(List<String> values)
         {
              addCriterion("object_id not in ", values, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdBetween(String value1, String value2)
         {
              addCriterion("object_id between ", value1,value2, "object_id");
              return (Criteria) this;
         }

         public Criteria andObjectIdNotBetween(String value1, String value2)
         {
              addCriterion("object_id not between ", value1,value2, "object_id");
              return (Criteria) this;
         }

         public Criteria andSourceIsNull()
         {
              addCriterion("source is null");
              return (Criteria) this;
         }

         public Criteria andSourceIsNotNull()
         {
              addCriterion("source is not null");
              return (Criteria) this;
         }

         public Criteria andSourceEqualTo(String value)
         {
              addCriterion("source = ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceNotEqualTo(String value)
         {
              addCriterion("source <> ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceGreaterThan(String value)
         {
              addCriterion("source > ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceGreaterThanOrEqualTo(String value)
         {
              addCriterion("source >= ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceLessThan(String value)
         {
              addCriterion("source < ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceLessThanOrEqualTo(String value)
         {
              addCriterion("source <= ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceLike(String value)
         {
              addCriterion("source like ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceNotLike(String value)
         {
              addCriterion("source not like ", value, "source");
              return (Criteria) this;
         }

         public Criteria andSourceIn(List<String> values)
         {
              addCriterion("source in ", values, "source");
              return (Criteria) this;
         }

         public Criteria andSourceNotIn(List<String> values)
         {
              addCriterion("source not in ", values, "source");
              return (Criteria) this;
         }

         public Criteria andSourceBetween(String value1, String value2)
         {
              addCriterion("source between ", value1,value2, "source");
              return (Criteria) this;
         }

         public Criteria andSourceNotBetween(String value1, String value2)
         {
              addCriterion("source not between ", value1,value2, "source");
              return (Criteria) this;
         }

         public Criteria andCouponStatusIsNull()
         {
              addCriterion("coupon_status is null");
              return (Criteria) this;
         }

         public Criteria andCouponStatusIsNotNull()
         {
              addCriterion("coupon_status is not null");
              return (Criteria) this;
         }

         public Criteria andCouponStatusEqualTo(String value)
         {
              addCriterion("coupon_status = ", value, "coupon_status");
              return (Criteria) this;
         }

         public Criteria andCouponStatusNotEqualTo(String value)
         {
              addCriterion("coupon_status <> ", value, "coupon_status");
              return (Criteria) this;
         }

         public Criteria andCouponStatusGreaterThan(String value)
         {
              addCriterion("coupon_status > ", value, "coupon_status");
              return (Criteria) this;
         }

         public Criteria andCouponStatusGreaterThanOrEqualTo(String value)
         {
              addCriterion("coupon_status >= ", value, "coupon_status");
              return (Criteria) this;
         }

         public Criteria andCouponStatusLessThan(String value)
         {
              addCriterion("coupon_status < ", value, "coupon_status");
              return (Criteria) this;
         }

         public Criteria andCouponStatusLessThanOrEqualTo(String value)
         {
              addCriterion("coupon_status <= ", value, "coupon_status");
              return (Criteria) this;
         }

         public Criteria andCouponStatusLike(String value)
         {
              addCriterion("coupon_status like ", value, "coupon_status");
              return (Criteria) this;
         }

         public Criteria andCouponStatusNotLike(String value)
         {
              addCriterion("coupon_status not like ", value, "coupon_status");
              return (Criteria) this;
         }

         public Criteria andCouponStatusIn(List<String> values)
         {
              addCriterion("coupon_status in ", values, "coupon_status");
              return (Criteria) this;
         }

         public Criteria andCouponStatusNotIn(List<String> values)
         {
              addCriterion("coupon_status not in ", values, "coupon_status");
              return (Criteria) this;
         }

         public Criteria andCouponStatusBetween(String value1, String value2)
         {
              addCriterion("coupon_status between ", value1,value2, "coupon_status");
              return (Criteria) this;
         }

         public Criteria andCouponStatusNotBetween(String value1, String value2)
         {
              addCriterion("coupon_status not between ", value1,value2, "coupon_status");
              return (Criteria) this;
         }

         public Criteria andUseTimeIsNull()
         {
              addCriterion("use_time is null");
              return (Criteria) this;
         }

         public Criteria andUseTimeIsNotNull()
         {
              addCriterion("use_time is not null");
              return (Criteria) this;
         }

         public Criteria andUseTimeEqualTo(Date value)
         {
              addCriterion("use_time = ", value, "use_time");
              return (Criteria) this;
         }

         public Criteria andUseTimeNotEqualTo(Date value)
         {
              addCriterion("use_time <> ", value, "use_time");
              return (Criteria) this;
         }

         public Criteria andUseTimeGreaterThan(Date value)
         {
              addCriterion("use_time > ", value, "use_time");
              return (Criteria) this;
         }

         public Criteria andUseTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("use_time >= ", value, "use_time");
              return (Criteria) this;
         }

         public Criteria andUseTimeLessThan(Date value)
         {
              addCriterion("use_time < ", value, "use_time");
              return (Criteria) this;
         }

         public Criteria andUseTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("use_time <= ", value, "use_time");
              return (Criteria) this;
         }

         public Criteria andUseTimeIn(List<Date> values)
         {
              addCriterion("use_time in ", values, "use_time");
              return (Criteria) this;
         }

         public Criteria andUseTimeNotIn(List<Date> values)
         {
              addCriterion("use_time not in ", values, "use_time");
              return (Criteria) this;
         }

         public Criteria andUseTimeBetween(Date value1, Date value2)
         {
              addCriterion("use_time between ", value1,value2, "use_time");
              return (Criteria) this;
         }

         public Criteria andUseTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("use_time not between ", value1,value2, "use_time");
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
