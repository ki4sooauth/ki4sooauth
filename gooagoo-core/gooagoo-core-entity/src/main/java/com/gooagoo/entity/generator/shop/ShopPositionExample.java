package com.gooagoo.entity.generator.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 位置管理表
 */

public class ShopPositionExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopPositionExample()
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

         public Criteria andPositionIdIsNull()
         {
              addCriterion("position_id is null");
              return (Criteria) this;
         }

         public Criteria andPositionIdIsNotNull()
         {
              addCriterion("position_id is not null");
              return (Criteria) this;
         }

         public Criteria andPositionIdEqualTo(String value)
         {
              addCriterion("position_id = ", value, "position_id");
              return (Criteria) this;
         }

         public Criteria andPositionIdNotEqualTo(String value)
         {
              addCriterion("position_id <> ", value, "position_id");
              return (Criteria) this;
         }

         public Criteria andPositionIdGreaterThan(String value)
         {
              addCriterion("position_id > ", value, "position_id");
              return (Criteria) this;
         }

         public Criteria andPositionIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("position_id >= ", value, "position_id");
              return (Criteria) this;
         }

         public Criteria andPositionIdLessThan(String value)
         {
              addCriterion("position_id < ", value, "position_id");
              return (Criteria) this;
         }

         public Criteria andPositionIdLessThanOrEqualTo(String value)
         {
              addCriterion("position_id <= ", value, "position_id");
              return (Criteria) this;
         }

         public Criteria andPositionIdLike(String value)
         {
              addCriterion("position_id like ", value, "position_id");
              return (Criteria) this;
         }

         public Criteria andPositionIdNotLike(String value)
         {
              addCriterion("position_id not like ", value, "position_id");
              return (Criteria) this;
         }

         public Criteria andPositionIdIn(List<String> values)
         {
              addCriterion("position_id in ", values, "position_id");
              return (Criteria) this;
         }

         public Criteria andPositionIdNotIn(List<String> values)
         {
              addCriterion("position_id not in ", values, "position_id");
              return (Criteria) this;
         }

         public Criteria andPositionIdBetween(String value1, String value2)
         {
              addCriterion("position_id between ", value1,value2, "position_id");
              return (Criteria) this;
         }

         public Criteria andPositionIdNotBetween(String value1, String value2)
         {
              addCriterion("position_id not between ", value1,value2, "position_id");
              return (Criteria) this;
         }

         public Criteria andPositionNameIsNull()
         {
              addCriterion("position_name is null");
              return (Criteria) this;
         }

         public Criteria andPositionNameIsNotNull()
         {
              addCriterion("position_name is not null");
              return (Criteria) this;
         }

         public Criteria andPositionNameEqualTo(String value)
         {
              addCriterion("position_name = ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameNotEqualTo(String value)
         {
              addCriterion("position_name <> ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameGreaterThan(String value)
         {
              addCriterion("position_name > ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("position_name >= ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameLessThan(String value)
         {
              addCriterion("position_name < ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameLessThanOrEqualTo(String value)
         {
              addCriterion("position_name <= ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameLike(String value)
         {
              addCriterion("position_name like ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameNotLike(String value)
         {
              addCriterion("position_name not like ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameIn(List<String> values)
         {
              addCriterion("position_name in ", values, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameNotIn(List<String> values)
         {
              addCriterion("position_name not in ", values, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameBetween(String value1, String value2)
         {
              addCriterion("position_name between ", value1,value2, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameNotBetween(String value1, String value2)
         {
              addCriterion("position_name not between ", value1,value2, "position_name");
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

         public Criteria andShopEntityIdIsNull()
         {
              addCriterion("shop_entity_id is null");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdIsNotNull()
         {
              addCriterion("shop_entity_id is not null");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdEqualTo(String value)
         {
              addCriterion("shop_entity_id = ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdNotEqualTo(String value)
         {
              addCriterion("shop_entity_id <> ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdGreaterThan(String value)
         {
              addCriterion("shop_entity_id > ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_entity_id >= ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdLessThan(String value)
         {
              addCriterion("shop_entity_id < ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdLessThanOrEqualTo(String value)
         {
              addCriterion("shop_entity_id <= ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdLike(String value)
         {
              addCriterion("shop_entity_id like ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdNotLike(String value)
         {
              addCriterion("shop_entity_id not like ", value, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdIn(List<String> values)
         {
              addCriterion("shop_entity_id in ", values, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdNotIn(List<String> values)
         {
              addCriterion("shop_entity_id not in ", values, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdBetween(String value1, String value2)
         {
              addCriterion("shop_entity_id between ", value1,value2, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andShopEntityIdNotBetween(String value1, String value2)
         {
              addCriterion("shop_entity_id not between ", value1,value2, "shop_entity_id");
              return (Criteria) this;
         }

         public Criteria andParentPositionIdIsNull()
         {
              addCriterion("parentPosition_id is null");
              return (Criteria) this;
         }

         public Criteria andParentPositionIdIsNotNull()
         {
              addCriterion("parentPosition_id is not null");
              return (Criteria) this;
         }

         public Criteria andParentPositionIdEqualTo(String value)
         {
              addCriterion("parentPosition_id = ", value, "parentPosition_id");
              return (Criteria) this;
         }

         public Criteria andParentPositionIdNotEqualTo(String value)
         {
              addCriterion("parentPosition_id <> ", value, "parentPosition_id");
              return (Criteria) this;
         }

         public Criteria andParentPositionIdGreaterThan(String value)
         {
              addCriterion("parentPosition_id > ", value, "parentPosition_id");
              return (Criteria) this;
         }

         public Criteria andParentPositionIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("parentPosition_id >= ", value, "parentPosition_id");
              return (Criteria) this;
         }

         public Criteria andParentPositionIdLessThan(String value)
         {
              addCriterion("parentPosition_id < ", value, "parentPosition_id");
              return (Criteria) this;
         }

         public Criteria andParentPositionIdLessThanOrEqualTo(String value)
         {
              addCriterion("parentPosition_id <= ", value, "parentPosition_id");
              return (Criteria) this;
         }

         public Criteria andParentPositionIdLike(String value)
         {
              addCriterion("parentPosition_id like ", value, "parentPosition_id");
              return (Criteria) this;
         }

         public Criteria andParentPositionIdNotLike(String value)
         {
              addCriterion("parentPosition_id not like ", value, "parentPosition_id");
              return (Criteria) this;
         }

         public Criteria andParentPositionIdIn(List<String> values)
         {
              addCriterion("parentPosition_id in ", values, "parentPosition_id");
              return (Criteria) this;
         }

         public Criteria andParentPositionIdNotIn(List<String> values)
         {
              addCriterion("parentPosition_id not in ", values, "parentPosition_id");
              return (Criteria) this;
         }

         public Criteria andParentPositionIdBetween(String value1, String value2)
         {
              addCriterion("parentPosition_id between ", value1,value2, "parentPosition_id");
              return (Criteria) this;
         }

         public Criteria andParentPositionIdNotBetween(String value1, String value2)
         {
              addCriterion("parentPosition_id not between ", value1,value2, "parentPosition_id");
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

         public Criteria andLesseeShopIdIsNull()
         {
              addCriterion("lessee_shop_id is null");
              return (Criteria) this;
         }

         public Criteria andLesseeShopIdIsNotNull()
         {
              addCriterion("lessee_shop_id is not null");
              return (Criteria) this;
         }

         public Criteria andLesseeShopIdEqualTo(String value)
         {
              addCriterion("lessee_shop_id = ", value, "lessee_shop_id");
              return (Criteria) this;
         }

         public Criteria andLesseeShopIdNotEqualTo(String value)
         {
              addCriterion("lessee_shop_id <> ", value, "lessee_shop_id");
              return (Criteria) this;
         }

         public Criteria andLesseeShopIdGreaterThan(String value)
         {
              addCriterion("lessee_shop_id > ", value, "lessee_shop_id");
              return (Criteria) this;
         }

         public Criteria andLesseeShopIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("lessee_shop_id >= ", value, "lessee_shop_id");
              return (Criteria) this;
         }

         public Criteria andLesseeShopIdLessThan(String value)
         {
              addCriterion("lessee_shop_id < ", value, "lessee_shop_id");
              return (Criteria) this;
         }

         public Criteria andLesseeShopIdLessThanOrEqualTo(String value)
         {
              addCriterion("lessee_shop_id <= ", value, "lessee_shop_id");
              return (Criteria) this;
         }

         public Criteria andLesseeShopIdLike(String value)
         {
              addCriterion("lessee_shop_id like ", value, "lessee_shop_id");
              return (Criteria) this;
         }

         public Criteria andLesseeShopIdNotLike(String value)
         {
              addCriterion("lessee_shop_id not like ", value, "lessee_shop_id");
              return (Criteria) this;
         }

         public Criteria andLesseeShopIdIn(List<String> values)
         {
              addCriterion("lessee_shop_id in ", values, "lessee_shop_id");
              return (Criteria) this;
         }

         public Criteria andLesseeShopIdNotIn(List<String> values)
         {
              addCriterion("lessee_shop_id not in ", values, "lessee_shop_id");
              return (Criteria) this;
         }

         public Criteria andLesseeShopIdBetween(String value1, String value2)
         {
              addCriterion("lessee_shop_id between ", value1,value2, "lessee_shop_id");
              return (Criteria) this;
         }

         public Criteria andLesseeShopIdNotBetween(String value1, String value2)
         {
              addCriterion("lessee_shop_id not between ", value1,value2, "lessee_shop_id");
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
