package com.gooagoo.entity.generator.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 会员卡与用户关联表
 */

public class MemberOfCardExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public MemberOfCardExample()
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

         public Criteria andPhyCardNoIsNull()
         {
              addCriterion("phy_card_no is null");
              return (Criteria) this;
         }

         public Criteria andPhyCardNoIsNotNull()
         {
              addCriterion("phy_card_no is not null");
              return (Criteria) this;
         }

         public Criteria andPhyCardNoEqualTo(String value)
         {
              addCriterion("phy_card_no = ", value, "phy_card_no");
              return (Criteria) this;
         }

         public Criteria andPhyCardNoNotEqualTo(String value)
         {
              addCriterion("phy_card_no <> ", value, "phy_card_no");
              return (Criteria) this;
         }

         public Criteria andPhyCardNoGreaterThan(String value)
         {
              addCriterion("phy_card_no > ", value, "phy_card_no");
              return (Criteria) this;
         }

         public Criteria andPhyCardNoGreaterThanOrEqualTo(String value)
         {
              addCriterion("phy_card_no >= ", value, "phy_card_no");
              return (Criteria) this;
         }

         public Criteria andPhyCardNoLessThan(String value)
         {
              addCriterion("phy_card_no < ", value, "phy_card_no");
              return (Criteria) this;
         }

         public Criteria andPhyCardNoLessThanOrEqualTo(String value)
         {
              addCriterion("phy_card_no <= ", value, "phy_card_no");
              return (Criteria) this;
         }

         public Criteria andPhyCardNoLike(String value)
         {
              addCriterion("phy_card_no like ", value, "phy_card_no");
              return (Criteria) this;
         }

         public Criteria andPhyCardNoNotLike(String value)
         {
              addCriterion("phy_card_no not like ", value, "phy_card_no");
              return (Criteria) this;
         }

         public Criteria andPhyCardNoIn(List<String> values)
         {
              addCriterion("phy_card_no in ", values, "phy_card_no");
              return (Criteria) this;
         }

         public Criteria andPhyCardNoNotIn(List<String> values)
         {
              addCriterion("phy_card_no not in ", values, "phy_card_no");
              return (Criteria) this;
         }

         public Criteria andPhyCardNoBetween(String value1, String value2)
         {
              addCriterion("phy_card_no between ", value1,value2, "phy_card_no");
              return (Criteria) this;
         }

         public Criteria andPhyCardNoNotBetween(String value1, String value2)
         {
              addCriterion("phy_card_no not between ", value1,value2, "phy_card_no");
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

         public Criteria andExpireDateIsNull()
         {
              addCriterion("expireDate is null");
              return (Criteria) this;
         }

         public Criteria andExpireDateIsNotNull()
         {
              addCriterion("expireDate is not null");
              return (Criteria) this;
         }

         public Criteria andExpireDateEqualTo(Date value)
         {
              addCriterion("expireDate = ", value, "expireDate");
              return (Criteria) this;
         }

         public Criteria andExpireDateNotEqualTo(Date value)
         {
              addCriterion("expireDate <> ", value, "expireDate");
              return (Criteria) this;
         }

         public Criteria andExpireDateGreaterThan(Date value)
         {
              addCriterion("expireDate > ", value, "expireDate");
              return (Criteria) this;
         }

         public Criteria andExpireDateGreaterThanOrEqualTo(Date value)
         {
              addCriterion("expireDate >= ", value, "expireDate");
              return (Criteria) this;
         }

         public Criteria andExpireDateLessThan(Date value)
         {
              addCriterion("expireDate < ", value, "expireDate");
              return (Criteria) this;
         }

         public Criteria andExpireDateLessThanOrEqualTo(Date value)
         {
              addCriterion("expireDate <= ", value, "expireDate");
              return (Criteria) this;
         }

         public Criteria andExpireDateIn(List<Date> values)
         {
              addCriterion("expireDate in ", values, "expireDate");
              return (Criteria) this;
         }

         public Criteria andExpireDateNotIn(List<Date> values)
         {
              addCriterion("expireDate not in ", values, "expireDate");
              return (Criteria) this;
         }

         public Criteria andExpireDateBetween(Date value1, Date value2)
         {
              addCriterion("expireDate between ", value1,value2, "expireDate");
              return (Criteria) this;
         }

         public Criteria andExpireDateNotBetween(Date value1, Date value2)
         {
              addCriterion("expireDate not between ", value1,value2, "expireDate");
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
