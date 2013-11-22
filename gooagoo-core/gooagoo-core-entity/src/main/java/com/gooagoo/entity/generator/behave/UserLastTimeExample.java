package com.gooagoo.entity.generator.behave;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 用户最后一次足迹以及购物时间
 */

public class UserLastTimeExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public UserLastTimeExample()
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

         public Criteria andShopNameIsNull()
         {
              addCriterion("shop_name is null");
              return (Criteria) this;
         }

         public Criteria andShopNameIsNotNull()
         {
              addCriterion("shop_name is not null");
              return (Criteria) this;
         }

         public Criteria andShopNameEqualTo(String value)
         {
              addCriterion("shop_name = ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameNotEqualTo(String value)
         {
              addCriterion("shop_name <> ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameGreaterThan(String value)
         {
              addCriterion("shop_name > ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_name >= ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameLessThan(String value)
         {
              addCriterion("shop_name < ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameLessThanOrEqualTo(String value)
         {
              addCriterion("shop_name <= ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameLike(String value)
         {
              addCriterion("shop_name like ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameNotLike(String value)
         {
              addCriterion("shop_name not like ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameIn(List<String> values)
         {
              addCriterion("shop_name in ", values, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameNotIn(List<String> values)
         {
              addCriterion("shop_name not in ", values, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameBetween(String value1, String value2)
         {
              addCriterion("shop_name between ", value1,value2, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameNotBetween(String value1, String value2)
         {
              addCriterion("shop_name not between ", value1,value2, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootIsNull()
         {
              addCriterion("shop_type_root is null");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootIsNotNull()
         {
              addCriterion("shop_type_root is not null");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootEqualTo(String value)
         {
              addCriterion("shop_type_root = ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootNotEqualTo(String value)
         {
              addCriterion("shop_type_root <> ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootGreaterThan(String value)
         {
              addCriterion("shop_type_root > ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_type_root >= ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootLessThan(String value)
         {
              addCriterion("shop_type_root < ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootLessThanOrEqualTo(String value)
         {
              addCriterion("shop_type_root <= ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootLike(String value)
         {
              addCriterion("shop_type_root like ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootNotLike(String value)
         {
              addCriterion("shop_type_root not like ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootIn(List<String> values)
         {
              addCriterion("shop_type_root in ", values, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootNotIn(List<String> values)
         {
              addCriterion("shop_type_root not in ", values, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootBetween(String value1, String value2)
         {
              addCriterion("shop_type_root between ", value1,value2, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootNotBetween(String value1, String value2)
         {
              addCriterion("shop_type_root not between ", value1,value2, "shop_type_root");
              return (Criteria) this;
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

         public Criteria andScardnoIsNull()
         {
              addCriterion("scardno is null");
              return (Criteria) this;
         }

         public Criteria andScardnoIsNotNull()
         {
              addCriterion("scardno is not null");
              return (Criteria) this;
         }

         public Criteria andScardnoEqualTo(String value)
         {
              addCriterion("scardno = ", value, "scardno");
              return (Criteria) this;
         }

         public Criteria andScardnoNotEqualTo(String value)
         {
              addCriterion("scardno <> ", value, "scardno");
              return (Criteria) this;
         }

         public Criteria andScardnoGreaterThan(String value)
         {
              addCriterion("scardno > ", value, "scardno");
              return (Criteria) this;
         }

         public Criteria andScardnoGreaterThanOrEqualTo(String value)
         {
              addCriterion("scardno >= ", value, "scardno");
              return (Criteria) this;
         }

         public Criteria andScardnoLessThan(String value)
         {
              addCriterion("scardno < ", value, "scardno");
              return (Criteria) this;
         }

         public Criteria andScardnoLessThanOrEqualTo(String value)
         {
              addCriterion("scardno <= ", value, "scardno");
              return (Criteria) this;
         }

         public Criteria andScardnoLike(String value)
         {
              addCriterion("scardno like ", value, "scardno");
              return (Criteria) this;
         }

         public Criteria andScardnoNotLike(String value)
         {
              addCriterion("scardno not like ", value, "scardno");
              return (Criteria) this;
         }

         public Criteria andScardnoIn(List<String> values)
         {
              addCriterion("scardno in ", values, "scardno");
              return (Criteria) this;
         }

         public Criteria andScardnoNotIn(List<String> values)
         {
              addCriterion("scardno not in ", values, "scardno");
              return (Criteria) this;
         }

         public Criteria andScardnoBetween(String value1, String value2)
         {
              addCriterion("scardno between ", value1,value2, "scardno");
              return (Criteria) this;
         }

         public Criteria andScardnoNotBetween(String value1, String value2)
         {
              addCriterion("scardno not between ", value1,value2, "scardno");
              return (Criteria) this;
         }

         public Criteria andShoppingTimeIsNull()
         {
              addCriterion("shopping_time is null");
              return (Criteria) this;
         }

         public Criteria andShoppingTimeIsNotNull()
         {
              addCriterion("shopping_time is not null");
              return (Criteria) this;
         }

         public Criteria andShoppingTimeEqualTo(Date value)
         {
              addCriterion("shopping_time = ", value, "shopping_time");
              return (Criteria) this;
         }

         public Criteria andShoppingTimeNotEqualTo(Date value)
         {
              addCriterion("shopping_time <> ", value, "shopping_time");
              return (Criteria) this;
         }

         public Criteria andShoppingTimeGreaterThan(Date value)
         {
              addCriterion("shopping_time > ", value, "shopping_time");
              return (Criteria) this;
         }

         public Criteria andShoppingTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("shopping_time >= ", value, "shopping_time");
              return (Criteria) this;
         }

         public Criteria andShoppingTimeLessThan(Date value)
         {
              addCriterion("shopping_time < ", value, "shopping_time");
              return (Criteria) this;
         }

         public Criteria andShoppingTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("shopping_time <= ", value, "shopping_time");
              return (Criteria) this;
         }

         public Criteria andShoppingTimeIn(List<Date> values)
         {
              addCriterion("shopping_time in ", values, "shopping_time");
              return (Criteria) this;
         }

         public Criteria andShoppingTimeNotIn(List<Date> values)
         {
              addCriterion("shopping_time not in ", values, "shopping_time");
              return (Criteria) this;
         }

         public Criteria andShoppingTimeBetween(Date value1, Date value2)
         {
              addCriterion("shopping_time between ", value1,value2, "shopping_time");
              return (Criteria) this;
         }

         public Criteria andShoppingTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("shopping_time not between ", value1,value2, "shopping_time");
              return (Criteria) this;
         }

         public Criteria andStrollTimeIsNull()
         {
              addCriterion("stroll_time is null");
              return (Criteria) this;
         }

         public Criteria andStrollTimeIsNotNull()
         {
              addCriterion("stroll_time is not null");
              return (Criteria) this;
         }

         public Criteria andStrollTimeEqualTo(Date value)
         {
              addCriterion("stroll_time = ", value, "stroll_time");
              return (Criteria) this;
         }

         public Criteria andStrollTimeNotEqualTo(Date value)
         {
              addCriterion("stroll_time <> ", value, "stroll_time");
              return (Criteria) this;
         }

         public Criteria andStrollTimeGreaterThan(Date value)
         {
              addCriterion("stroll_time > ", value, "stroll_time");
              return (Criteria) this;
         }

         public Criteria andStrollTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("stroll_time >= ", value, "stroll_time");
              return (Criteria) this;
         }

         public Criteria andStrollTimeLessThan(Date value)
         {
              addCriterion("stroll_time < ", value, "stroll_time");
              return (Criteria) this;
         }

         public Criteria andStrollTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("stroll_time <= ", value, "stroll_time");
              return (Criteria) this;
         }

         public Criteria andStrollTimeIn(List<Date> values)
         {
              addCriterion("stroll_time in ", values, "stroll_time");
              return (Criteria) this;
         }

         public Criteria andStrollTimeNotIn(List<Date> values)
         {
              addCriterion("stroll_time not in ", values, "stroll_time");
              return (Criteria) this;
         }

         public Criteria andStrollTimeBetween(Date value1, Date value2)
         {
              addCriterion("stroll_time between ", value1,value2, "stroll_time");
              return (Criteria) this;
         }

         public Criteria andStrollTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("stroll_time not between ", value1,value2, "stroll_time");
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
