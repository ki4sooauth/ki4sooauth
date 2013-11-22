package com.gooagoo.entity.generator.behave;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 用户评论
 */

public class UserCommentExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public UserCommentExample()
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

         public Criteria andCommentIdIsNull()
         {
              addCriterion("comment_id is null");
              return (Criteria) this;
         }

         public Criteria andCommentIdIsNotNull()
         {
              addCriterion("comment_id is not null");
              return (Criteria) this;
         }

         public Criteria andCommentIdEqualTo(String value)
         {
              addCriterion("comment_id = ", value, "comment_id");
              return (Criteria) this;
         }

         public Criteria andCommentIdNotEqualTo(String value)
         {
              addCriterion("comment_id <> ", value, "comment_id");
              return (Criteria) this;
         }

         public Criteria andCommentIdGreaterThan(String value)
         {
              addCriterion("comment_id > ", value, "comment_id");
              return (Criteria) this;
         }

         public Criteria andCommentIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("comment_id >= ", value, "comment_id");
              return (Criteria) this;
         }

         public Criteria andCommentIdLessThan(String value)
         {
              addCriterion("comment_id < ", value, "comment_id");
              return (Criteria) this;
         }

         public Criteria andCommentIdLessThanOrEqualTo(String value)
         {
              addCriterion("comment_id <= ", value, "comment_id");
              return (Criteria) this;
         }

         public Criteria andCommentIdLike(String value)
         {
              addCriterion("comment_id like ", value, "comment_id");
              return (Criteria) this;
         }

         public Criteria andCommentIdNotLike(String value)
         {
              addCriterion("comment_id not like ", value, "comment_id");
              return (Criteria) this;
         }

         public Criteria andCommentIdIn(List<String> values)
         {
              addCriterion("comment_id in ", values, "comment_id");
              return (Criteria) this;
         }

         public Criteria andCommentIdNotIn(List<String> values)
         {
              addCriterion("comment_id not in ", values, "comment_id");
              return (Criteria) this;
         }

         public Criteria andCommentIdBetween(String value1, String value2)
         {
              addCriterion("comment_id between ", value1,value2, "comment_id");
              return (Criteria) this;
         }

         public Criteria andCommentIdNotBetween(String value1, String value2)
         {
              addCriterion("comment_id not between ", value1,value2, "comment_id");
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

         public Criteria andGoodsIdIsNull()
         {
              addCriterion("goods_id is null");
              return (Criteria) this;
         }

         public Criteria andGoodsIdIsNotNull()
         {
              addCriterion("goods_id is not null");
              return (Criteria) this;
         }

         public Criteria andGoodsIdEqualTo(String value)
         {
              addCriterion("goods_id = ", value, "goods_id");
              return (Criteria) this;
         }

         public Criteria andGoodsIdNotEqualTo(String value)
         {
              addCriterion("goods_id <> ", value, "goods_id");
              return (Criteria) this;
         }

         public Criteria andGoodsIdGreaterThan(String value)
         {
              addCriterion("goods_id > ", value, "goods_id");
              return (Criteria) this;
         }

         public Criteria andGoodsIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("goods_id >= ", value, "goods_id");
              return (Criteria) this;
         }

         public Criteria andGoodsIdLessThan(String value)
         {
              addCriterion("goods_id < ", value, "goods_id");
              return (Criteria) this;
         }

         public Criteria andGoodsIdLessThanOrEqualTo(String value)
         {
              addCriterion("goods_id <= ", value, "goods_id");
              return (Criteria) this;
         }

         public Criteria andGoodsIdLike(String value)
         {
              addCriterion("goods_id like ", value, "goods_id");
              return (Criteria) this;
         }

         public Criteria andGoodsIdNotLike(String value)
         {
              addCriterion("goods_id not like ", value, "goods_id");
              return (Criteria) this;
         }

         public Criteria andGoodsIdIn(List<String> values)
         {
              addCriterion("goods_id in ", values, "goods_id");
              return (Criteria) this;
         }

         public Criteria andGoodsIdNotIn(List<String> values)
         {
              addCriterion("goods_id not in ", values, "goods_id");
              return (Criteria) this;
         }

         public Criteria andGoodsIdBetween(String value1, String value2)
         {
              addCriterion("goods_id between ", value1,value2, "goods_id");
              return (Criteria) this;
         }

         public Criteria andGoodsIdNotBetween(String value1, String value2)
         {
              addCriterion("goods_id not between ", value1,value2, "goods_id");
              return (Criteria) this;
         }

         public Criteria andCommentTypeIsNull()
         {
              addCriterion("comment_type is null");
              return (Criteria) this;
         }

         public Criteria andCommentTypeIsNotNull()
         {
              addCriterion("comment_type is not null");
              return (Criteria) this;
         }

         public Criteria andCommentTypeEqualTo(String value)
         {
              addCriterion("comment_type = ", value, "comment_type");
              return (Criteria) this;
         }

         public Criteria andCommentTypeNotEqualTo(String value)
         {
              addCriterion("comment_type <> ", value, "comment_type");
              return (Criteria) this;
         }

         public Criteria andCommentTypeGreaterThan(String value)
         {
              addCriterion("comment_type > ", value, "comment_type");
              return (Criteria) this;
         }

         public Criteria andCommentTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("comment_type >= ", value, "comment_type");
              return (Criteria) this;
         }

         public Criteria andCommentTypeLessThan(String value)
         {
              addCriterion("comment_type < ", value, "comment_type");
              return (Criteria) this;
         }

         public Criteria andCommentTypeLessThanOrEqualTo(String value)
         {
              addCriterion("comment_type <= ", value, "comment_type");
              return (Criteria) this;
         }

         public Criteria andCommentTypeLike(String value)
         {
              addCriterion("comment_type like ", value, "comment_type");
              return (Criteria) this;
         }

         public Criteria andCommentTypeNotLike(String value)
         {
              addCriterion("comment_type not like ", value, "comment_type");
              return (Criteria) this;
         }

         public Criteria andCommentTypeIn(List<String> values)
         {
              addCriterion("comment_type in ", values, "comment_type");
              return (Criteria) this;
         }

         public Criteria andCommentTypeNotIn(List<String> values)
         {
              addCriterion("comment_type not in ", values, "comment_type");
              return (Criteria) this;
         }

         public Criteria andCommentTypeBetween(String value1, String value2)
         {
              addCriterion("comment_type between ", value1,value2, "comment_type");
              return (Criteria) this;
         }

         public Criteria andCommentTypeNotBetween(String value1, String value2)
         {
              addCriterion("comment_type not between ", value1,value2, "comment_type");
              return (Criteria) this;
         }

         public Criteria andCommentLevelIsNull()
         {
              addCriterion("comment_level is null");
              return (Criteria) this;
         }

         public Criteria andCommentLevelIsNotNull()
         {
              addCriterion("comment_level is not null");
              return (Criteria) this;
         }

         public Criteria andCommentLevelEqualTo(String value)
         {
              addCriterion("comment_level = ", value, "comment_level");
              return (Criteria) this;
         }

         public Criteria andCommentLevelNotEqualTo(String value)
         {
              addCriterion("comment_level <> ", value, "comment_level");
              return (Criteria) this;
         }

         public Criteria andCommentLevelGreaterThan(String value)
         {
              addCriterion("comment_level > ", value, "comment_level");
              return (Criteria) this;
         }

         public Criteria andCommentLevelGreaterThanOrEqualTo(String value)
         {
              addCriterion("comment_level >= ", value, "comment_level");
              return (Criteria) this;
         }

         public Criteria andCommentLevelLessThan(String value)
         {
              addCriterion("comment_level < ", value, "comment_level");
              return (Criteria) this;
         }

         public Criteria andCommentLevelLessThanOrEqualTo(String value)
         {
              addCriterion("comment_level <= ", value, "comment_level");
              return (Criteria) this;
         }

         public Criteria andCommentLevelLike(String value)
         {
              addCriterion("comment_level like ", value, "comment_level");
              return (Criteria) this;
         }

         public Criteria andCommentLevelNotLike(String value)
         {
              addCriterion("comment_level not like ", value, "comment_level");
              return (Criteria) this;
         }

         public Criteria andCommentLevelIn(List<String> values)
         {
              addCriterion("comment_level in ", values, "comment_level");
              return (Criteria) this;
         }

         public Criteria andCommentLevelNotIn(List<String> values)
         {
              addCriterion("comment_level not in ", values, "comment_level");
              return (Criteria) this;
         }

         public Criteria andCommentLevelBetween(String value1, String value2)
         {
              addCriterion("comment_level between ", value1,value2, "comment_level");
              return (Criteria) this;
         }

         public Criteria andCommentLevelNotBetween(String value1, String value2)
         {
              addCriterion("comment_level not between ", value1,value2, "comment_level");
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

         public Criteria andComeIpIsNull()
         {
              addCriterion("come_ip is null");
              return (Criteria) this;
         }

         public Criteria andComeIpIsNotNull()
         {
              addCriterion("come_ip is not null");
              return (Criteria) this;
         }

         public Criteria andComeIpEqualTo(String value)
         {
              addCriterion("come_ip = ", value, "come_ip");
              return (Criteria) this;
         }

         public Criteria andComeIpNotEqualTo(String value)
         {
              addCriterion("come_ip <> ", value, "come_ip");
              return (Criteria) this;
         }

         public Criteria andComeIpGreaterThan(String value)
         {
              addCriterion("come_ip > ", value, "come_ip");
              return (Criteria) this;
         }

         public Criteria andComeIpGreaterThanOrEqualTo(String value)
         {
              addCriterion("come_ip >= ", value, "come_ip");
              return (Criteria) this;
         }

         public Criteria andComeIpLessThan(String value)
         {
              addCriterion("come_ip < ", value, "come_ip");
              return (Criteria) this;
         }

         public Criteria andComeIpLessThanOrEqualTo(String value)
         {
              addCriterion("come_ip <= ", value, "come_ip");
              return (Criteria) this;
         }

         public Criteria andComeIpLike(String value)
         {
              addCriterion("come_ip like ", value, "come_ip");
              return (Criteria) this;
         }

         public Criteria andComeIpNotLike(String value)
         {
              addCriterion("come_ip not like ", value, "come_ip");
              return (Criteria) this;
         }

         public Criteria andComeIpIn(List<String> values)
         {
              addCriterion("come_ip in ", values, "come_ip");
              return (Criteria) this;
         }

         public Criteria andComeIpNotIn(List<String> values)
         {
              addCriterion("come_ip not in ", values, "come_ip");
              return (Criteria) this;
         }

         public Criteria andComeIpBetween(String value1, String value2)
         {
              addCriterion("come_ip between ", value1,value2, "come_ip");
              return (Criteria) this;
         }

         public Criteria andComeIpNotBetween(String value1, String value2)
         {
              addCriterion("come_ip not between ", value1,value2, "come_ip");
              return (Criteria) this;
         }

         public Criteria andIsAuditingIsNull()
         {
              addCriterion("is_auditing is null");
              return (Criteria) this;
         }

         public Criteria andIsAuditingIsNotNull()
         {
              addCriterion("is_auditing is not null");
              return (Criteria) this;
         }

         public Criteria andIsAuditingEqualTo(String value)
         {
              addCriterion("is_auditing = ", value, "is_auditing");
              return (Criteria) this;
         }

         public Criteria andIsAuditingNotEqualTo(String value)
         {
              addCriterion("is_auditing <> ", value, "is_auditing");
              return (Criteria) this;
         }

         public Criteria andIsAuditingGreaterThan(String value)
         {
              addCriterion("is_auditing > ", value, "is_auditing");
              return (Criteria) this;
         }

         public Criteria andIsAuditingGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_auditing >= ", value, "is_auditing");
              return (Criteria) this;
         }

         public Criteria andIsAuditingLessThan(String value)
         {
              addCriterion("is_auditing < ", value, "is_auditing");
              return (Criteria) this;
         }

         public Criteria andIsAuditingLessThanOrEqualTo(String value)
         {
              addCriterion("is_auditing <= ", value, "is_auditing");
              return (Criteria) this;
         }

         public Criteria andIsAuditingLike(String value)
         {
              addCriterion("is_auditing like ", value, "is_auditing");
              return (Criteria) this;
         }

         public Criteria andIsAuditingNotLike(String value)
         {
              addCriterion("is_auditing not like ", value, "is_auditing");
              return (Criteria) this;
         }

         public Criteria andIsAuditingIn(List<String> values)
         {
              addCriterion("is_auditing in ", values, "is_auditing");
              return (Criteria) this;
         }

         public Criteria andIsAuditingNotIn(List<String> values)
         {
              addCriterion("is_auditing not in ", values, "is_auditing");
              return (Criteria) this;
         }

         public Criteria andIsAuditingBetween(String value1, String value2)
         {
              addCriterion("is_auditing between ", value1,value2, "is_auditing");
              return (Criteria) this;
         }

         public Criteria andIsAuditingNotBetween(String value1, String value2)
         {
              addCriterion("is_auditing not between ", value1,value2, "is_auditing");
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
