package com.gooagoo.entity.generator.behave;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 购物清单商品表
 */

public class ShoppingPlanGoodsExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShoppingPlanGoodsExample()
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

         public Criteria andShoppingGoodsIdIsNull()
         {
              addCriterion("shopping_goods_id is null");
              return (Criteria) this;
         }

         public Criteria andShoppingGoodsIdIsNotNull()
         {
              addCriterion("shopping_goods_id is not null");
              return (Criteria) this;
         }

         public Criteria andShoppingGoodsIdEqualTo(String value)
         {
              addCriterion("shopping_goods_id = ", value, "shopping_goods_id");
              return (Criteria) this;
         }

         public Criteria andShoppingGoodsIdNotEqualTo(String value)
         {
              addCriterion("shopping_goods_id <> ", value, "shopping_goods_id");
              return (Criteria) this;
         }

         public Criteria andShoppingGoodsIdGreaterThan(String value)
         {
              addCriterion("shopping_goods_id > ", value, "shopping_goods_id");
              return (Criteria) this;
         }

         public Criteria andShoppingGoodsIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("shopping_goods_id >= ", value, "shopping_goods_id");
              return (Criteria) this;
         }

         public Criteria andShoppingGoodsIdLessThan(String value)
         {
              addCriterion("shopping_goods_id < ", value, "shopping_goods_id");
              return (Criteria) this;
         }

         public Criteria andShoppingGoodsIdLessThanOrEqualTo(String value)
         {
              addCriterion("shopping_goods_id <= ", value, "shopping_goods_id");
              return (Criteria) this;
         }

         public Criteria andShoppingGoodsIdLike(String value)
         {
              addCriterion("shopping_goods_id like ", value, "shopping_goods_id");
              return (Criteria) this;
         }

         public Criteria andShoppingGoodsIdNotLike(String value)
         {
              addCriterion("shopping_goods_id not like ", value, "shopping_goods_id");
              return (Criteria) this;
         }

         public Criteria andShoppingGoodsIdIn(List<String> values)
         {
              addCriterion("shopping_goods_id in ", values, "shopping_goods_id");
              return (Criteria) this;
         }

         public Criteria andShoppingGoodsIdNotIn(List<String> values)
         {
              addCriterion("shopping_goods_id not in ", values, "shopping_goods_id");
              return (Criteria) this;
         }

         public Criteria andShoppingGoodsIdBetween(String value1, String value2)
         {
              addCriterion("shopping_goods_id between ", value1,value2, "shopping_goods_id");
              return (Criteria) this;
         }

         public Criteria andShoppingGoodsIdNotBetween(String value1, String value2)
         {
              addCriterion("shopping_goods_id not between ", value1,value2, "shopping_goods_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdIsNull()
         {
              addCriterion("shopping_list_id is null");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdIsNotNull()
         {
              addCriterion("shopping_list_id is not null");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdEqualTo(String value)
         {
              addCriterion("shopping_list_id = ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdNotEqualTo(String value)
         {
              addCriterion("shopping_list_id <> ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdGreaterThan(String value)
         {
              addCriterion("shopping_list_id > ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("shopping_list_id >= ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdLessThan(String value)
         {
              addCriterion("shopping_list_id < ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdLessThanOrEqualTo(String value)
         {
              addCriterion("shopping_list_id <= ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdLike(String value)
         {
              addCriterion("shopping_list_id like ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdNotLike(String value)
         {
              addCriterion("shopping_list_id not like ", value, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdIn(List<String> values)
         {
              addCriterion("shopping_list_id in ", values, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdNotIn(List<String> values)
         {
              addCriterion("shopping_list_id not in ", values, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdBetween(String value1, String value2)
         {
              addCriterion("shopping_list_id between ", value1,value2, "shopping_list_id");
              return (Criteria) this;
         }

         public Criteria andShoppingListIdNotBetween(String value1, String value2)
         {
              addCriterion("shopping_list_id not between ", value1,value2, "shopping_list_id");
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

         public Criteria andGoodsNameIsNull()
         {
              addCriterion("goods_name is null");
              return (Criteria) this;
         }

         public Criteria andGoodsNameIsNotNull()
         {
              addCriterion("goods_name is not null");
              return (Criteria) this;
         }

         public Criteria andGoodsNameEqualTo(String value)
         {
              addCriterion("goods_name = ", value, "goods_name");
              return (Criteria) this;
         }

         public Criteria andGoodsNameNotEqualTo(String value)
         {
              addCriterion("goods_name <> ", value, "goods_name");
              return (Criteria) this;
         }

         public Criteria andGoodsNameGreaterThan(String value)
         {
              addCriterion("goods_name > ", value, "goods_name");
              return (Criteria) this;
         }

         public Criteria andGoodsNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("goods_name >= ", value, "goods_name");
              return (Criteria) this;
         }

         public Criteria andGoodsNameLessThan(String value)
         {
              addCriterion("goods_name < ", value, "goods_name");
              return (Criteria) this;
         }

         public Criteria andGoodsNameLessThanOrEqualTo(String value)
         {
              addCriterion("goods_name <= ", value, "goods_name");
              return (Criteria) this;
         }

         public Criteria andGoodsNameLike(String value)
         {
              addCriterion("goods_name like ", value, "goods_name");
              return (Criteria) this;
         }

         public Criteria andGoodsNameNotLike(String value)
         {
              addCriterion("goods_name not like ", value, "goods_name");
              return (Criteria) this;
         }

         public Criteria andGoodsNameIn(List<String> values)
         {
              addCriterion("goods_name in ", values, "goods_name");
              return (Criteria) this;
         }

         public Criteria andGoodsNameNotIn(List<String> values)
         {
              addCriterion("goods_name not in ", values, "goods_name");
              return (Criteria) this;
         }

         public Criteria andGoodsNameBetween(String value1, String value2)
         {
              addCriterion("goods_name between ", value1,value2, "goods_name");
              return (Criteria) this;
         }

         public Criteria andGoodsNameNotBetween(String value1, String value2)
         {
              addCriterion("goods_name not between ", value1,value2, "goods_name");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeIdIsNull()
         {
              addCriterion("goods_type_id is null");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeIdIsNotNull()
         {
              addCriterion("goods_type_id is not null");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeIdEqualTo(String value)
         {
              addCriterion("goods_type_id = ", value, "goods_type_id");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeIdNotEqualTo(String value)
         {
              addCriterion("goods_type_id <> ", value, "goods_type_id");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeIdGreaterThan(String value)
         {
              addCriterion("goods_type_id > ", value, "goods_type_id");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("goods_type_id >= ", value, "goods_type_id");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeIdLessThan(String value)
         {
              addCriterion("goods_type_id < ", value, "goods_type_id");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeIdLessThanOrEqualTo(String value)
         {
              addCriterion("goods_type_id <= ", value, "goods_type_id");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeIdLike(String value)
         {
              addCriterion("goods_type_id like ", value, "goods_type_id");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeIdNotLike(String value)
         {
              addCriterion("goods_type_id not like ", value, "goods_type_id");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeIdIn(List<String> values)
         {
              addCriterion("goods_type_id in ", values, "goods_type_id");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeIdNotIn(List<String> values)
         {
              addCriterion("goods_type_id not in ", values, "goods_type_id");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeIdBetween(String value1, String value2)
         {
              addCriterion("goods_type_id between ", value1,value2, "goods_type_id");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeIdNotBetween(String value1, String value2)
         {
              addCriterion("goods_type_id not between ", value1,value2, "goods_type_id");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeNameIsNull()
         {
              addCriterion("goods_type_name is null");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeNameIsNotNull()
         {
              addCriterion("goods_type_name is not null");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeNameEqualTo(String value)
         {
              addCriterion("goods_type_name = ", value, "goods_type_name");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeNameNotEqualTo(String value)
         {
              addCriterion("goods_type_name <> ", value, "goods_type_name");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeNameGreaterThan(String value)
         {
              addCriterion("goods_type_name > ", value, "goods_type_name");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("goods_type_name >= ", value, "goods_type_name");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeNameLessThan(String value)
         {
              addCriterion("goods_type_name < ", value, "goods_type_name");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeNameLessThanOrEqualTo(String value)
         {
              addCriterion("goods_type_name <= ", value, "goods_type_name");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeNameLike(String value)
         {
              addCriterion("goods_type_name like ", value, "goods_type_name");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeNameNotLike(String value)
         {
              addCriterion("goods_type_name not like ", value, "goods_type_name");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeNameIn(List<String> values)
         {
              addCriterion("goods_type_name in ", values, "goods_type_name");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeNameNotIn(List<String> values)
         {
              addCriterion("goods_type_name not in ", values, "goods_type_name");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeNameBetween(String value1, String value2)
         {
              addCriterion("goods_type_name between ", value1,value2, "goods_type_name");
              return (Criteria) this;
         }

         public Criteria andGoodsTypeNameNotBetween(String value1, String value2)
         {
              addCriterion("goods_type_name not between ", value1,value2, "goods_type_name");
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
