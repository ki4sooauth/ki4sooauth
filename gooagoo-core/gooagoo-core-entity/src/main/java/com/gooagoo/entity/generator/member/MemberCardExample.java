package com.gooagoo.entity.generator.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 会员卡基本表
 */

public class MemberCardExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public MemberCardExample()
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

         public Criteria andCardIdIsNull()
         {
              addCriterion("card_id is null");
              return (Criteria) this;
         }

         public Criteria andCardIdIsNotNull()
         {
              addCriterion("card_id is not null");
              return (Criteria) this;
         }

         public Criteria andCardIdEqualTo(String value)
         {
              addCriterion("card_id = ", value, "card_id");
              return (Criteria) this;
         }

         public Criteria andCardIdNotEqualTo(String value)
         {
              addCriterion("card_id <> ", value, "card_id");
              return (Criteria) this;
         }

         public Criteria andCardIdGreaterThan(String value)
         {
              addCriterion("card_id > ", value, "card_id");
              return (Criteria) this;
         }

         public Criteria andCardIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("card_id >= ", value, "card_id");
              return (Criteria) this;
         }

         public Criteria andCardIdLessThan(String value)
         {
              addCriterion("card_id < ", value, "card_id");
              return (Criteria) this;
         }

         public Criteria andCardIdLessThanOrEqualTo(String value)
         {
              addCriterion("card_id <= ", value, "card_id");
              return (Criteria) this;
         }

         public Criteria andCardIdLike(String value)
         {
              addCriterion("card_id like ", value, "card_id");
              return (Criteria) this;
         }

         public Criteria andCardIdNotLike(String value)
         {
              addCriterion("card_id not like ", value, "card_id");
              return (Criteria) this;
         }

         public Criteria andCardIdIn(List<String> values)
         {
              addCriterion("card_id in ", values, "card_id");
              return (Criteria) this;
         }

         public Criteria andCardIdNotIn(List<String> values)
         {
              addCriterion("card_id not in ", values, "card_id");
              return (Criteria) this;
         }

         public Criteria andCardIdBetween(String value1, String value2)
         {
              addCriterion("card_id between ", value1,value2, "card_id");
              return (Criteria) this;
         }

         public Criteria andCardIdNotBetween(String value1, String value2)
         {
              addCriterion("card_id not between ", value1,value2, "card_id");
              return (Criteria) this;
         }

         public Criteria andCardNameIsNull()
         {
              addCriterion("card_name is null");
              return (Criteria) this;
         }

         public Criteria andCardNameIsNotNull()
         {
              addCriterion("card_name is not null");
              return (Criteria) this;
         }

         public Criteria andCardNameEqualTo(String value)
         {
              addCriterion("card_name = ", value, "card_name");
              return (Criteria) this;
         }

         public Criteria andCardNameNotEqualTo(String value)
         {
              addCriterion("card_name <> ", value, "card_name");
              return (Criteria) this;
         }

         public Criteria andCardNameGreaterThan(String value)
         {
              addCriterion("card_name > ", value, "card_name");
              return (Criteria) this;
         }

         public Criteria andCardNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("card_name >= ", value, "card_name");
              return (Criteria) this;
         }

         public Criteria andCardNameLessThan(String value)
         {
              addCriterion("card_name < ", value, "card_name");
              return (Criteria) this;
         }

         public Criteria andCardNameLessThanOrEqualTo(String value)
         {
              addCriterion("card_name <= ", value, "card_name");
              return (Criteria) this;
         }

         public Criteria andCardNameLike(String value)
         {
              addCriterion("card_name like ", value, "card_name");
              return (Criteria) this;
         }

         public Criteria andCardNameNotLike(String value)
         {
              addCriterion("card_name not like ", value, "card_name");
              return (Criteria) this;
         }

         public Criteria andCardNameIn(List<String> values)
         {
              addCriterion("card_name in ", values, "card_name");
              return (Criteria) this;
         }

         public Criteria andCardNameNotIn(List<String> values)
         {
              addCriterion("card_name not in ", values, "card_name");
              return (Criteria) this;
         }

         public Criteria andCardNameBetween(String value1, String value2)
         {
              addCriterion("card_name between ", value1,value2, "card_name");
              return (Criteria) this;
         }

         public Criteria andCardNameNotBetween(String value1, String value2)
         {
              addCriterion("card_name not between ", value1,value2, "card_name");
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

         public Criteria andCardTypeIsNull()
         {
              addCriterion("card_type is null");
              return (Criteria) this;
         }

         public Criteria andCardTypeIsNotNull()
         {
              addCriterion("card_type is not null");
              return (Criteria) this;
         }

         public Criteria andCardTypeEqualTo(String value)
         {
              addCriterion("card_type = ", value, "card_type");
              return (Criteria) this;
         }

         public Criteria andCardTypeNotEqualTo(String value)
         {
              addCriterion("card_type <> ", value, "card_type");
              return (Criteria) this;
         }

         public Criteria andCardTypeGreaterThan(String value)
         {
              addCriterion("card_type > ", value, "card_type");
              return (Criteria) this;
         }

         public Criteria andCardTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("card_type >= ", value, "card_type");
              return (Criteria) this;
         }

         public Criteria andCardTypeLessThan(String value)
         {
              addCriterion("card_type < ", value, "card_type");
              return (Criteria) this;
         }

         public Criteria andCardTypeLessThanOrEqualTo(String value)
         {
              addCriterion("card_type <= ", value, "card_type");
              return (Criteria) this;
         }

         public Criteria andCardTypeLike(String value)
         {
              addCriterion("card_type like ", value, "card_type");
              return (Criteria) this;
         }

         public Criteria andCardTypeNotLike(String value)
         {
              addCriterion("card_type not like ", value, "card_type");
              return (Criteria) this;
         }

         public Criteria andCardTypeIn(List<String> values)
         {
              addCriterion("card_type in ", values, "card_type");
              return (Criteria) this;
         }

         public Criteria andCardTypeNotIn(List<String> values)
         {
              addCriterion("card_type not in ", values, "card_type");
              return (Criteria) this;
         }

         public Criteria andCardTypeBetween(String value1, String value2)
         {
              addCriterion("card_type between ", value1,value2, "card_type");
              return (Criteria) this;
         }

         public Criteria andCardTypeNotBetween(String value1, String value2)
         {
              addCriterion("card_type not between ", value1,value2, "card_type");
              return (Criteria) this;
         }

         public Criteria andCardType2IsNull()
         {
              addCriterion("card_type2 is null");
              return (Criteria) this;
         }

         public Criteria andCardType2IsNotNull()
         {
              addCriterion("card_type2 is not null");
              return (Criteria) this;
         }

         public Criteria andCardType2EqualTo(String value)
         {
              addCriterion("card_type2 = ", value, "card_type2");
              return (Criteria) this;
         }

         public Criteria andCardType2NotEqualTo(String value)
         {
              addCriterion("card_type2 <> ", value, "card_type2");
              return (Criteria) this;
         }

         public Criteria andCardType2GreaterThan(String value)
         {
              addCriterion("card_type2 > ", value, "card_type2");
              return (Criteria) this;
         }

         public Criteria andCardType2GreaterThanOrEqualTo(String value)
         {
              addCriterion("card_type2 >= ", value, "card_type2");
              return (Criteria) this;
         }

         public Criteria andCardType2LessThan(String value)
         {
              addCriterion("card_type2 < ", value, "card_type2");
              return (Criteria) this;
         }

         public Criteria andCardType2LessThanOrEqualTo(String value)
         {
              addCriterion("card_type2 <= ", value, "card_type2");
              return (Criteria) this;
         }

         public Criteria andCardType2Like(String value)
         {
              addCriterion("card_type2 like ", value, "card_type2");
              return (Criteria) this;
         }

         public Criteria andCardType2NotLike(String value)
         {
              addCriterion("card_type2 not like ", value, "card_type2");
              return (Criteria) this;
         }

         public Criteria andCardType2In(List<String> values)
         {
              addCriterion("card_type2 in ", values, "card_type2");
              return (Criteria) this;
         }

         public Criteria andCardType2NotIn(List<String> values)
         {
              addCriterion("card_type2 not in ", values, "card_type2");
              return (Criteria) this;
         }

         public Criteria andCardType2Between(String value1, String value2)
         {
              addCriterion("card_type2 between ", value1,value2, "card_type2");
              return (Criteria) this;
         }

         public Criteria andCardType2NotBetween(String value1, String value2)
         {
              addCriterion("card_type2 not between ", value1,value2, "card_type2");
              return (Criteria) this;
         }

         public Criteria andCardLvlIsNull()
         {
              addCriterion("card_lvl is null");
              return (Criteria) this;
         }

         public Criteria andCardLvlIsNotNull()
         {
              addCriterion("card_lvl is not null");
              return (Criteria) this;
         }

         public Criteria andCardLvlEqualTo(String value)
         {
              addCriterion("card_lvl = ", value, "card_lvl");
              return (Criteria) this;
         }

         public Criteria andCardLvlNotEqualTo(String value)
         {
              addCriterion("card_lvl <> ", value, "card_lvl");
              return (Criteria) this;
         }

         public Criteria andCardLvlGreaterThan(String value)
         {
              addCriterion("card_lvl > ", value, "card_lvl");
              return (Criteria) this;
         }

         public Criteria andCardLvlGreaterThanOrEqualTo(String value)
         {
              addCriterion("card_lvl >= ", value, "card_lvl");
              return (Criteria) this;
         }

         public Criteria andCardLvlLessThan(String value)
         {
              addCriterion("card_lvl < ", value, "card_lvl");
              return (Criteria) this;
         }

         public Criteria andCardLvlLessThanOrEqualTo(String value)
         {
              addCriterion("card_lvl <= ", value, "card_lvl");
              return (Criteria) this;
         }

         public Criteria andCardLvlLike(String value)
         {
              addCriterion("card_lvl like ", value, "card_lvl");
              return (Criteria) this;
         }

         public Criteria andCardLvlNotLike(String value)
         {
              addCriterion("card_lvl not like ", value, "card_lvl");
              return (Criteria) this;
         }

         public Criteria andCardLvlIn(List<String> values)
         {
              addCriterion("card_lvl in ", values, "card_lvl");
              return (Criteria) this;
         }

         public Criteria andCardLvlNotIn(List<String> values)
         {
              addCriterion("card_lvl not in ", values, "card_lvl");
              return (Criteria) this;
         }

         public Criteria andCardLvlBetween(String value1, String value2)
         {
              addCriterion("card_lvl between ", value1,value2, "card_lvl");
              return (Criteria) this;
         }

         public Criteria andCardLvlNotBetween(String value1, String value2)
         {
              addCriterion("card_lvl not between ", value1,value2, "card_lvl");
              return (Criteria) this;
         }

         public Criteria andNeedApprovalIsNull()
         {
              addCriterion("need_approval is null");
              return (Criteria) this;
         }

         public Criteria andNeedApprovalIsNotNull()
         {
              addCriterion("need_approval is not null");
              return (Criteria) this;
         }

         public Criteria andNeedApprovalEqualTo(String value)
         {
              addCriterion("need_approval = ", value, "need_approval");
              return (Criteria) this;
         }

         public Criteria andNeedApprovalNotEqualTo(String value)
         {
              addCriterion("need_approval <> ", value, "need_approval");
              return (Criteria) this;
         }

         public Criteria andNeedApprovalGreaterThan(String value)
         {
              addCriterion("need_approval > ", value, "need_approval");
              return (Criteria) this;
         }

         public Criteria andNeedApprovalGreaterThanOrEqualTo(String value)
         {
              addCriterion("need_approval >= ", value, "need_approval");
              return (Criteria) this;
         }

         public Criteria andNeedApprovalLessThan(String value)
         {
              addCriterion("need_approval < ", value, "need_approval");
              return (Criteria) this;
         }

         public Criteria andNeedApprovalLessThanOrEqualTo(String value)
         {
              addCriterion("need_approval <= ", value, "need_approval");
              return (Criteria) this;
         }

         public Criteria andNeedApprovalLike(String value)
         {
              addCriterion("need_approval like ", value, "need_approval");
              return (Criteria) this;
         }

         public Criteria andNeedApprovalNotLike(String value)
         {
              addCriterion("need_approval not like ", value, "need_approval");
              return (Criteria) this;
         }

         public Criteria andNeedApprovalIn(List<String> values)
         {
              addCriterion("need_approval in ", values, "need_approval");
              return (Criteria) this;
         }

         public Criteria andNeedApprovalNotIn(List<String> values)
         {
              addCriterion("need_approval not in ", values, "need_approval");
              return (Criteria) this;
         }

         public Criteria andNeedApprovalBetween(String value1, String value2)
         {
              addCriterion("need_approval between ", value1,value2, "need_approval");
              return (Criteria) this;
         }

         public Criteria andNeedApprovalNotBetween(String value1, String value2)
         {
              addCriterion("need_approval not between ", value1,value2, "need_approval");
              return (Criteria) this;
         }

         public Criteria andNeedJifenIsNull()
         {
              addCriterion("need_jifen is null");
              return (Criteria) this;
         }

         public Criteria andNeedJifenIsNotNull()
         {
              addCriterion("need_jifen is not null");
              return (Criteria) this;
         }

         public Criteria andNeedJifenEqualTo(String value)
         {
              addCriterion("need_jifen = ", value, "need_jifen");
              return (Criteria) this;
         }

         public Criteria andNeedJifenNotEqualTo(String value)
         {
              addCriterion("need_jifen <> ", value, "need_jifen");
              return (Criteria) this;
         }

         public Criteria andNeedJifenGreaterThan(String value)
         {
              addCriterion("need_jifen > ", value, "need_jifen");
              return (Criteria) this;
         }

         public Criteria andNeedJifenGreaterThanOrEqualTo(String value)
         {
              addCriterion("need_jifen >= ", value, "need_jifen");
              return (Criteria) this;
         }

         public Criteria andNeedJifenLessThan(String value)
         {
              addCriterion("need_jifen < ", value, "need_jifen");
              return (Criteria) this;
         }

         public Criteria andNeedJifenLessThanOrEqualTo(String value)
         {
              addCriterion("need_jifen <= ", value, "need_jifen");
              return (Criteria) this;
         }

         public Criteria andNeedJifenLike(String value)
         {
              addCriterion("need_jifen like ", value, "need_jifen");
              return (Criteria) this;
         }

         public Criteria andNeedJifenNotLike(String value)
         {
              addCriterion("need_jifen not like ", value, "need_jifen");
              return (Criteria) this;
         }

         public Criteria andNeedJifenIn(List<String> values)
         {
              addCriterion("need_jifen in ", values, "need_jifen");
              return (Criteria) this;
         }

         public Criteria andNeedJifenNotIn(List<String> values)
         {
              addCriterion("need_jifen not in ", values, "need_jifen");
              return (Criteria) this;
         }

         public Criteria andNeedJifenBetween(String value1, String value2)
         {
              addCriterion("need_jifen between ", value1,value2, "need_jifen");
              return (Criteria) this;
         }

         public Criteria andNeedJifenNotBetween(String value1, String value2)
         {
              addCriterion("need_jifen not between ", value1,value2, "need_jifen");
              return (Criteria) this;
         }

         public Criteria andCardUrlIsNull()
         {
              addCriterion("card_url is null");
              return (Criteria) this;
         }

         public Criteria andCardUrlIsNotNull()
         {
              addCriterion("card_url is not null");
              return (Criteria) this;
         }

         public Criteria andCardUrlEqualTo(String value)
         {
              addCriterion("card_url = ", value, "card_url");
              return (Criteria) this;
         }

         public Criteria andCardUrlNotEqualTo(String value)
         {
              addCriterion("card_url <> ", value, "card_url");
              return (Criteria) this;
         }

         public Criteria andCardUrlGreaterThan(String value)
         {
              addCriterion("card_url > ", value, "card_url");
              return (Criteria) this;
         }

         public Criteria andCardUrlGreaterThanOrEqualTo(String value)
         {
              addCriterion("card_url >= ", value, "card_url");
              return (Criteria) this;
         }

         public Criteria andCardUrlLessThan(String value)
         {
              addCriterion("card_url < ", value, "card_url");
              return (Criteria) this;
         }

         public Criteria andCardUrlLessThanOrEqualTo(String value)
         {
              addCriterion("card_url <= ", value, "card_url");
              return (Criteria) this;
         }

         public Criteria andCardUrlLike(String value)
         {
              addCriterion("card_url like ", value, "card_url");
              return (Criteria) this;
         }

         public Criteria andCardUrlNotLike(String value)
         {
              addCriterion("card_url not like ", value, "card_url");
              return (Criteria) this;
         }

         public Criteria andCardUrlIn(List<String> values)
         {
              addCriterion("card_url in ", values, "card_url");
              return (Criteria) this;
         }

         public Criteria andCardUrlNotIn(List<String> values)
         {
              addCriterion("card_url not in ", values, "card_url");
              return (Criteria) this;
         }

         public Criteria andCardUrlBetween(String value1, String value2)
         {
              addCriterion("card_url between ", value1,value2, "card_url");
              return (Criteria) this;
         }

         public Criteria andCardUrlNotBetween(String value1, String value2)
         {
              addCriterion("card_url not between ", value1,value2, "card_url");
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

         public Criteria andUseLimitedIsNull()
         {
              addCriterion("useLimited is null");
              return (Criteria) this;
         }

         public Criteria andUseLimitedIsNotNull()
         {
              addCriterion("useLimited is not null");
              return (Criteria) this;
         }

         public Criteria andUseLimitedEqualTo(String value)
         {
              addCriterion("useLimited = ", value, "useLimited");
              return (Criteria) this;
         }

         public Criteria andUseLimitedNotEqualTo(String value)
         {
              addCriterion("useLimited <> ", value, "useLimited");
              return (Criteria) this;
         }

         public Criteria andUseLimitedGreaterThan(String value)
         {
              addCriterion("useLimited > ", value, "useLimited");
              return (Criteria) this;
         }

         public Criteria andUseLimitedGreaterThanOrEqualTo(String value)
         {
              addCriterion("useLimited >= ", value, "useLimited");
              return (Criteria) this;
         }

         public Criteria andUseLimitedLessThan(String value)
         {
              addCriterion("useLimited < ", value, "useLimited");
              return (Criteria) this;
         }

         public Criteria andUseLimitedLessThanOrEqualTo(String value)
         {
              addCriterion("useLimited <= ", value, "useLimited");
              return (Criteria) this;
         }

         public Criteria andUseLimitedLike(String value)
         {
              addCriterion("useLimited like ", value, "useLimited");
              return (Criteria) this;
         }

         public Criteria andUseLimitedNotLike(String value)
         {
              addCriterion("useLimited not like ", value, "useLimited");
              return (Criteria) this;
         }

         public Criteria andUseLimitedIn(List<String> values)
         {
              addCriterion("useLimited in ", values, "useLimited");
              return (Criteria) this;
         }

         public Criteria andUseLimitedNotIn(List<String> values)
         {
              addCriterion("useLimited not in ", values, "useLimited");
              return (Criteria) this;
         }

         public Criteria andUseLimitedBetween(String value1, String value2)
         {
              addCriterion("useLimited between ", value1,value2, "useLimited");
              return (Criteria) this;
         }

         public Criteria andUseLimitedNotBetween(String value1, String value2)
         {
              addCriterion("useLimited not between ", value1,value2, "useLimited");
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
