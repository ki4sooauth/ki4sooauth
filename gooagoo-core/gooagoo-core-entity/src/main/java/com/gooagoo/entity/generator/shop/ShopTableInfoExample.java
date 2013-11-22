package com.gooagoo.entity.generator.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 餐厅桌号信息表
 */

public class ShopTableInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopTableInfoExample()
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

         public Criteria andTableNameIsNull()
         {
              addCriterion("table_name is null");
              return (Criteria) this;
         }

         public Criteria andTableNameIsNotNull()
         {
              addCriterion("table_name is not null");
              return (Criteria) this;
         }

         public Criteria andTableNameEqualTo(String value)
         {
              addCriterion("table_name = ", value, "table_name");
              return (Criteria) this;
         }

         public Criteria andTableNameNotEqualTo(String value)
         {
              addCriterion("table_name <> ", value, "table_name");
              return (Criteria) this;
         }

         public Criteria andTableNameGreaterThan(String value)
         {
              addCriterion("table_name > ", value, "table_name");
              return (Criteria) this;
         }

         public Criteria andTableNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("table_name >= ", value, "table_name");
              return (Criteria) this;
         }

         public Criteria andTableNameLessThan(String value)
         {
              addCriterion("table_name < ", value, "table_name");
              return (Criteria) this;
         }

         public Criteria andTableNameLessThanOrEqualTo(String value)
         {
              addCriterion("table_name <= ", value, "table_name");
              return (Criteria) this;
         }

         public Criteria andTableNameLike(String value)
         {
              addCriterion("table_name like ", value, "table_name");
              return (Criteria) this;
         }

         public Criteria andTableNameNotLike(String value)
         {
              addCriterion("table_name not like ", value, "table_name");
              return (Criteria) this;
         }

         public Criteria andTableNameIn(List<String> values)
         {
              addCriterion("table_name in ", values, "table_name");
              return (Criteria) this;
         }

         public Criteria andTableNameNotIn(List<String> values)
         {
              addCriterion("table_name not in ", values, "table_name");
              return (Criteria) this;
         }

         public Criteria andTableNameBetween(String value1, String value2)
         {
              addCriterion("table_name between ", value1,value2, "table_name");
              return (Criteria) this;
         }

         public Criteria andTableNameNotBetween(String value1, String value2)
         {
              addCriterion("table_name not between ", value1,value2, "table_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameIsNull()
         {
              addCriterion("room_name is null");
              return (Criteria) this;
         }

         public Criteria andRoomNameIsNotNull()
         {
              addCriterion("room_name is not null");
              return (Criteria) this;
         }

         public Criteria andRoomNameEqualTo(String value)
         {
              addCriterion("room_name = ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameNotEqualTo(String value)
         {
              addCriterion("room_name <> ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameGreaterThan(String value)
         {
              addCriterion("room_name > ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("room_name >= ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameLessThan(String value)
         {
              addCriterion("room_name < ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameLessThanOrEqualTo(String value)
         {
              addCriterion("room_name <= ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameLike(String value)
         {
              addCriterion("room_name like ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameNotLike(String value)
         {
              addCriterion("room_name not like ", value, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameIn(List<String> values)
         {
              addCriterion("room_name in ", values, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameNotIn(List<String> values)
         {
              addCriterion("room_name not in ", values, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameBetween(String value1, String value2)
         {
              addCriterion("room_name between ", value1,value2, "room_name");
              return (Criteria) this;
         }

         public Criteria andRoomNameNotBetween(String value1, String value2)
         {
              addCriterion("room_name not between ", value1,value2, "room_name");
              return (Criteria) this;
         }

         public Criteria andRemarkIsNull()
         {
              addCriterion("remark is null");
              return (Criteria) this;
         }

         public Criteria andRemarkIsNotNull()
         {
              addCriterion("remark is not null");
              return (Criteria) this;
         }

         public Criteria andRemarkEqualTo(String value)
         {
              addCriterion("remark = ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkNotEqualTo(String value)
         {
              addCriterion("remark <> ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkGreaterThan(String value)
         {
              addCriterion("remark > ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkGreaterThanOrEqualTo(String value)
         {
              addCriterion("remark >= ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkLessThan(String value)
         {
              addCriterion("remark < ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkLessThanOrEqualTo(String value)
         {
              addCriterion("remark <= ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkLike(String value)
         {
              addCriterion("remark like ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkNotLike(String value)
         {
              addCriterion("remark not like ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkIn(List<String> values)
         {
              addCriterion("remark in ", values, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkNotIn(List<String> values)
         {
              addCriterion("remark not in ", values, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkBetween(String value1, String value2)
         {
              addCriterion("remark between ", value1,value2, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkNotBetween(String value1, String value2)
         {
              addCriterion("remark not between ", value1,value2, "remark");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeIsNull()
         {
              addCriterion("table_type_code is null");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeIsNotNull()
         {
              addCriterion("table_type_code is not null");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeEqualTo(String value)
         {
              addCriterion("table_type_code = ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeNotEqualTo(String value)
         {
              addCriterion("table_type_code <> ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeGreaterThan(String value)
         {
              addCriterion("table_type_code > ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("table_type_code >= ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeLessThan(String value)
         {
              addCriterion("table_type_code < ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeLessThanOrEqualTo(String value)
         {
              addCriterion("table_type_code <= ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeLike(String value)
         {
              addCriterion("table_type_code like ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeNotLike(String value)
         {
              addCriterion("table_type_code not like ", value, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeIn(List<String> values)
         {
              addCriterion("table_type_code in ", values, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeNotIn(List<String> values)
         {
              addCriterion("table_type_code not in ", values, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeBetween(String value1, String value2)
         {
              addCriterion("table_type_code between ", value1,value2, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andTableTypeCodeNotBetween(String value1, String value2)
         {
              addCriterion("table_type_code not between ", value1,value2, "table_type_code");
              return (Criteria) this;
         }

         public Criteria andStatusIsNull()
         {
              addCriterion("status is null");
              return (Criteria) this;
         }

         public Criteria andStatusIsNotNull()
         {
              addCriterion("status is not null");
              return (Criteria) this;
         }

         public Criteria andStatusEqualTo(String value)
         {
              addCriterion("status = ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusNotEqualTo(String value)
         {
              addCriterion("status <> ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusGreaterThan(String value)
         {
              addCriterion("status > ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusGreaterThanOrEqualTo(String value)
         {
              addCriterion("status >= ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusLessThan(String value)
         {
              addCriterion("status < ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusLessThanOrEqualTo(String value)
         {
              addCriterion("status <= ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusLike(String value)
         {
              addCriterion("status like ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusNotLike(String value)
         {
              addCriterion("status not like ", value, "status");
              return (Criteria) this;
         }

         public Criteria andStatusIn(List<String> values)
         {
              addCriterion("status in ", values, "status");
              return (Criteria) this;
         }

         public Criteria andStatusNotIn(List<String> values)
         {
              addCriterion("status not in ", values, "status");
              return (Criteria) this;
         }

         public Criteria andStatusBetween(String value1, String value2)
         {
              addCriterion("status between ", value1,value2, "status");
              return (Criteria) this;
         }

         public Criteria andStatusNotBetween(String value1, String value2)
         {
              addCriterion("status not between ", value1,value2, "status");
              return (Criteria) this;
         }

         public Criteria andMacIsNull()
         {
              addCriterion("mac is null");
              return (Criteria) this;
         }

         public Criteria andMacIsNotNull()
         {
              addCriterion("mac is not null");
              return (Criteria) this;
         }

         public Criteria andMacEqualTo(String value)
         {
              addCriterion("mac = ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacNotEqualTo(String value)
         {
              addCriterion("mac <> ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacGreaterThan(String value)
         {
              addCriterion("mac > ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacGreaterThanOrEqualTo(String value)
         {
              addCriterion("mac >= ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacLessThan(String value)
         {
              addCriterion("mac < ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacLessThanOrEqualTo(String value)
         {
              addCriterion("mac <= ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacLike(String value)
         {
              addCriterion("mac like ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacNotLike(String value)
         {
              addCriterion("mac not like ", value, "mac");
              return (Criteria) this;
         }

         public Criteria andMacIn(List<String> values)
         {
              addCriterion("mac in ", values, "mac");
              return (Criteria) this;
         }

         public Criteria andMacNotIn(List<String> values)
         {
              addCriterion("mac not in ", values, "mac");
              return (Criteria) this;
         }

         public Criteria andMacBetween(String value1, String value2)
         {
              addCriterion("mac between ", value1,value2, "mac");
              return (Criteria) this;
         }

         public Criteria andMacNotBetween(String value1, String value2)
         {
              addCriterion("mac not between ", value1,value2, "mac");
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
