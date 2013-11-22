package com.gooagoo.entity.generator.bill;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * 订单商品详细信息
 */

public class OrderDetailInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public OrderDetailInfoExample()
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

         public Criteria andOrderDetailIdIsNull()
         {
              addCriterion("order_detail_id is null");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdIsNotNull()
         {
              addCriterion("order_detail_id is not null");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdEqualTo(String value)
         {
              addCriterion("order_detail_id = ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdNotEqualTo(String value)
         {
              addCriterion("order_detail_id <> ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdGreaterThan(String value)
         {
              addCriterion("order_detail_id > ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("order_detail_id >= ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdLessThan(String value)
         {
              addCriterion("order_detail_id < ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdLessThanOrEqualTo(String value)
         {
              addCriterion("order_detail_id <= ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdLike(String value)
         {
              addCriterion("order_detail_id like ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdNotLike(String value)
         {
              addCriterion("order_detail_id not like ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdIn(List<String> values)
         {
              addCriterion("order_detail_id in ", values, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdNotIn(List<String> values)
         {
              addCriterion("order_detail_id not in ", values, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdBetween(String value1, String value2)
         {
              addCriterion("order_detail_id between ", value1,value2, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdNotBetween(String value1, String value2)
         {
              addCriterion("order_detail_id not between ", value1,value2, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdIsNull()
         {
              addCriterion("order_id is null");
              return (Criteria) this;
         }

         public Criteria andOrderIdIsNotNull()
         {
              addCriterion("order_id is not null");
              return (Criteria) this;
         }

         public Criteria andOrderIdEqualTo(String value)
         {
              addCriterion("order_id = ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdNotEqualTo(String value)
         {
              addCriterion("order_id <> ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdGreaterThan(String value)
         {
              addCriterion("order_id > ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("order_id >= ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdLessThan(String value)
         {
              addCriterion("order_id < ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdLessThanOrEqualTo(String value)
         {
              addCriterion("order_id <= ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdLike(String value)
         {
              addCriterion("order_id like ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdNotLike(String value)
         {
              addCriterion("order_id not like ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdIn(List<String> values)
         {
              addCriterion("order_id in ", values, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdNotIn(List<String> values)
         {
              addCriterion("order_id not in ", values, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdBetween(String value1, String value2)
         {
              addCriterion("order_id between ", value1,value2, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdNotBetween(String value1, String value2)
         {
              addCriterion("order_id not between ", value1,value2, "order_id");
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

         public Criteria andGoodsCategoryRootIsNull()
         {
              addCriterion("goods_category_root is null");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryRootIsNotNull()
         {
              addCriterion("goods_category_root is not null");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryRootEqualTo(String value)
         {
              addCriterion("goods_category_root = ", value, "goods_category_root");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryRootNotEqualTo(String value)
         {
              addCriterion("goods_category_root <> ", value, "goods_category_root");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryRootGreaterThan(String value)
         {
              addCriterion("goods_category_root > ", value, "goods_category_root");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryRootGreaterThanOrEqualTo(String value)
         {
              addCriterion("goods_category_root >= ", value, "goods_category_root");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryRootLessThan(String value)
         {
              addCriterion("goods_category_root < ", value, "goods_category_root");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryRootLessThanOrEqualTo(String value)
         {
              addCriterion("goods_category_root <= ", value, "goods_category_root");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryRootLike(String value)
         {
              addCriterion("goods_category_root like ", value, "goods_category_root");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryRootNotLike(String value)
         {
              addCriterion("goods_category_root not like ", value, "goods_category_root");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryRootIn(List<String> values)
         {
              addCriterion("goods_category_root in ", values, "goods_category_root");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryRootNotIn(List<String> values)
         {
              addCriterion("goods_category_root not in ", values, "goods_category_root");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryRootBetween(String value1, String value2)
         {
              addCriterion("goods_category_root between ", value1,value2, "goods_category_root");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryRootNotBetween(String value1, String value2)
         {
              addCriterion("goods_category_root not between ", value1,value2, "goods_category_root");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryLeafIsNull()
         {
              addCriterion("goods_category_leaf is null");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryLeafIsNotNull()
         {
              addCriterion("goods_category_leaf is not null");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryLeafEqualTo(String value)
         {
              addCriterion("goods_category_leaf = ", value, "goods_category_leaf");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryLeafNotEqualTo(String value)
         {
              addCriterion("goods_category_leaf <> ", value, "goods_category_leaf");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryLeafGreaterThan(String value)
         {
              addCriterion("goods_category_leaf > ", value, "goods_category_leaf");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryLeafGreaterThanOrEqualTo(String value)
         {
              addCriterion("goods_category_leaf >= ", value, "goods_category_leaf");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryLeafLessThan(String value)
         {
              addCriterion("goods_category_leaf < ", value, "goods_category_leaf");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryLeafLessThanOrEqualTo(String value)
         {
              addCriterion("goods_category_leaf <= ", value, "goods_category_leaf");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryLeafLike(String value)
         {
              addCriterion("goods_category_leaf like ", value, "goods_category_leaf");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryLeafNotLike(String value)
         {
              addCriterion("goods_category_leaf not like ", value, "goods_category_leaf");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryLeafIn(List<String> values)
         {
              addCriterion("goods_category_leaf in ", values, "goods_category_leaf");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryLeafNotIn(List<String> values)
         {
              addCriterion("goods_category_leaf not in ", values, "goods_category_leaf");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryLeafBetween(String value1, String value2)
         {
              addCriterion("goods_category_leaf between ", value1,value2, "goods_category_leaf");
              return (Criteria) this;
         }

         public Criteria andGoodsCategoryLeafNotBetween(String value1, String value2)
         {
              addCriterion("goods_category_leaf not between ", value1,value2, "goods_category_leaf");
              return (Criteria) this;
         }

         public Criteria andGoodsBrandIsNull()
         {
              addCriterion("goods_brand is null");
              return (Criteria) this;
         }

         public Criteria andGoodsBrandIsNotNull()
         {
              addCriterion("goods_brand is not null");
              return (Criteria) this;
         }

         public Criteria andGoodsBrandEqualTo(String value)
         {
              addCriterion("goods_brand = ", value, "goods_brand");
              return (Criteria) this;
         }

         public Criteria andGoodsBrandNotEqualTo(String value)
         {
              addCriterion("goods_brand <> ", value, "goods_brand");
              return (Criteria) this;
         }

         public Criteria andGoodsBrandGreaterThan(String value)
         {
              addCriterion("goods_brand > ", value, "goods_brand");
              return (Criteria) this;
         }

         public Criteria andGoodsBrandGreaterThanOrEqualTo(String value)
         {
              addCriterion("goods_brand >= ", value, "goods_brand");
              return (Criteria) this;
         }

         public Criteria andGoodsBrandLessThan(String value)
         {
              addCriterion("goods_brand < ", value, "goods_brand");
              return (Criteria) this;
         }

         public Criteria andGoodsBrandLessThanOrEqualTo(String value)
         {
              addCriterion("goods_brand <= ", value, "goods_brand");
              return (Criteria) this;
         }

         public Criteria andGoodsBrandLike(String value)
         {
              addCriterion("goods_brand like ", value, "goods_brand");
              return (Criteria) this;
         }

         public Criteria andGoodsBrandNotLike(String value)
         {
              addCriterion("goods_brand not like ", value, "goods_brand");
              return (Criteria) this;
         }

         public Criteria andGoodsBrandIn(List<String> values)
         {
              addCriterion("goods_brand in ", values, "goods_brand");
              return (Criteria) this;
         }

         public Criteria andGoodsBrandNotIn(List<String> values)
         {
              addCriterion("goods_brand not in ", values, "goods_brand");
              return (Criteria) this;
         }

         public Criteria andGoodsBrandBetween(String value1, String value2)
         {
              addCriterion("goods_brand between ", value1,value2, "goods_brand");
              return (Criteria) this;
         }

         public Criteria andGoodsBrandNotBetween(String value1, String value2)
         {
              addCriterion("goods_brand not between ", value1,value2, "goods_brand");
              return (Criteria) this;
         }

         public Criteria andGoodsSerialIsNull()
         {
              addCriterion("goods_serial is null");
              return (Criteria) this;
         }

         public Criteria andGoodsSerialIsNotNull()
         {
              addCriterion("goods_serial is not null");
              return (Criteria) this;
         }

         public Criteria andGoodsSerialEqualTo(String value)
         {
              addCriterion("goods_serial = ", value, "goods_serial");
              return (Criteria) this;
         }

         public Criteria andGoodsSerialNotEqualTo(String value)
         {
              addCriterion("goods_serial <> ", value, "goods_serial");
              return (Criteria) this;
         }

         public Criteria andGoodsSerialGreaterThan(String value)
         {
              addCriterion("goods_serial > ", value, "goods_serial");
              return (Criteria) this;
         }

         public Criteria andGoodsSerialGreaterThanOrEqualTo(String value)
         {
              addCriterion("goods_serial >= ", value, "goods_serial");
              return (Criteria) this;
         }

         public Criteria andGoodsSerialLessThan(String value)
         {
              addCriterion("goods_serial < ", value, "goods_serial");
              return (Criteria) this;
         }

         public Criteria andGoodsSerialLessThanOrEqualTo(String value)
         {
              addCriterion("goods_serial <= ", value, "goods_serial");
              return (Criteria) this;
         }

         public Criteria andGoodsSerialLike(String value)
         {
              addCriterion("goods_serial like ", value, "goods_serial");
              return (Criteria) this;
         }

         public Criteria andGoodsSerialNotLike(String value)
         {
              addCriterion("goods_serial not like ", value, "goods_serial");
              return (Criteria) this;
         }

         public Criteria andGoodsSerialIn(List<String> values)
         {
              addCriterion("goods_serial in ", values, "goods_serial");
              return (Criteria) this;
         }

         public Criteria andGoodsSerialNotIn(List<String> values)
         {
              addCriterion("goods_serial not in ", values, "goods_serial");
              return (Criteria) this;
         }

         public Criteria andGoodsSerialBetween(String value1, String value2)
         {
              addCriterion("goods_serial between ", value1,value2, "goods_serial");
              return (Criteria) this;
         }

         public Criteria andGoodsSerialNotBetween(String value1, String value2)
         {
              addCriterion("goods_serial not between ", value1,value2, "goods_serial");
              return (Criteria) this;
         }

         public Criteria andItemSerialIsNull()
         {
              addCriterion("item_serial is null");
              return (Criteria) this;
         }

         public Criteria andItemSerialIsNotNull()
         {
              addCriterion("item_serial is not null");
              return (Criteria) this;
         }

         public Criteria andItemSerialEqualTo(String value)
         {
              addCriterion("item_serial = ", value, "item_serial");
              return (Criteria) this;
         }

         public Criteria andItemSerialNotEqualTo(String value)
         {
              addCriterion("item_serial <> ", value, "item_serial");
              return (Criteria) this;
         }

         public Criteria andItemSerialGreaterThan(String value)
         {
              addCriterion("item_serial > ", value, "item_serial");
              return (Criteria) this;
         }

         public Criteria andItemSerialGreaterThanOrEqualTo(String value)
         {
              addCriterion("item_serial >= ", value, "item_serial");
              return (Criteria) this;
         }

         public Criteria andItemSerialLessThan(String value)
         {
              addCriterion("item_serial < ", value, "item_serial");
              return (Criteria) this;
         }

         public Criteria andItemSerialLessThanOrEqualTo(String value)
         {
              addCriterion("item_serial <= ", value, "item_serial");
              return (Criteria) this;
         }

         public Criteria andItemSerialLike(String value)
         {
              addCriterion("item_serial like ", value, "item_serial");
              return (Criteria) this;
         }

         public Criteria andItemSerialNotLike(String value)
         {
              addCriterion("item_serial not like ", value, "item_serial");
              return (Criteria) this;
         }

         public Criteria andItemSerialIn(List<String> values)
         {
              addCriterion("item_serial in ", values, "item_serial");
              return (Criteria) this;
         }

         public Criteria andItemSerialNotIn(List<String> values)
         {
              addCriterion("item_serial not in ", values, "item_serial");
              return (Criteria) this;
         }

         public Criteria andItemSerialBetween(String value1, String value2)
         {
              addCriterion("item_serial between ", value1,value2, "item_serial");
              return (Criteria) this;
         }

         public Criteria andItemSerialNotBetween(String value1, String value2)
         {
              addCriterion("item_serial not between ", value1,value2, "item_serial");
              return (Criteria) this;
         }

         public Criteria andPriceIsNull()
         {
              addCriterion("price is null");
              return (Criteria) this;
         }

         public Criteria andPriceIsNotNull()
         {
              addCriterion("price is not null");
              return (Criteria) this;
         }

         public Criteria andPriceEqualTo(String value)
         {
              addCriterion("price = ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceNotEqualTo(String value)
         {
              addCriterion("price <> ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceGreaterThan(String value)
         {
              addCriterion("price > ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceGreaterThanOrEqualTo(String value)
         {
              addCriterion("price >= ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceLessThan(String value)
         {
              addCriterion("price < ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceLessThanOrEqualTo(String value)
         {
              addCriterion("price <= ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceLike(String value)
         {
              addCriterion("price like ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceNotLike(String value)
         {
              addCriterion("price not like ", value, "price");
              return (Criteria) this;
         }

         public Criteria andPriceIn(List<String> values)
         {
              addCriterion("price in ", values, "price");
              return (Criteria) this;
         }

         public Criteria andPriceNotIn(List<String> values)
         {
              addCriterion("price not in ", values, "price");
              return (Criteria) this;
         }

         public Criteria andPriceBetween(String value1, String value2)
         {
              addCriterion("price between ", value1,value2, "price");
              return (Criteria) this;
         }

         public Criteria andPriceNotBetween(String value1, String value2)
         {
              addCriterion("price not between ", value1,value2, "price");
              return (Criteria) this;
         }

         public Criteria andGoodsImgIsNull()
         {
              addCriterion("goods_img is null");
              return (Criteria) this;
         }

         public Criteria andGoodsImgIsNotNull()
         {
              addCriterion("goods_img is not null");
              return (Criteria) this;
         }

         public Criteria andGoodsImgEqualTo(String value)
         {
              addCriterion("goods_img = ", value, "goods_img");
              return (Criteria) this;
         }

         public Criteria andGoodsImgNotEqualTo(String value)
         {
              addCriterion("goods_img <> ", value, "goods_img");
              return (Criteria) this;
         }

         public Criteria andGoodsImgGreaterThan(String value)
         {
              addCriterion("goods_img > ", value, "goods_img");
              return (Criteria) this;
         }

         public Criteria andGoodsImgGreaterThanOrEqualTo(String value)
         {
              addCriterion("goods_img >= ", value, "goods_img");
              return (Criteria) this;
         }

         public Criteria andGoodsImgLessThan(String value)
         {
              addCriterion("goods_img < ", value, "goods_img");
              return (Criteria) this;
         }

         public Criteria andGoodsImgLessThanOrEqualTo(String value)
         {
              addCriterion("goods_img <= ", value, "goods_img");
              return (Criteria) this;
         }

         public Criteria andGoodsImgLike(String value)
         {
              addCriterion("goods_img like ", value, "goods_img");
              return (Criteria) this;
         }

         public Criteria andGoodsImgNotLike(String value)
         {
              addCriterion("goods_img not like ", value, "goods_img");
              return (Criteria) this;
         }

         public Criteria andGoodsImgIn(List<String> values)
         {
              addCriterion("goods_img in ", values, "goods_img");
              return (Criteria) this;
         }

         public Criteria andGoodsImgNotIn(List<String> values)
         {
              addCriterion("goods_img not in ", values, "goods_img");
              return (Criteria) this;
         }

         public Criteria andGoodsImgBetween(String value1, String value2)
         {
              addCriterion("goods_img between ", value1,value2, "goods_img");
              return (Criteria) this;
         }

         public Criteria andGoodsImgNotBetween(String value1, String value2)
         {
              addCriterion("goods_img not between ", value1,value2, "goods_img");
              return (Criteria) this;
         }

         public Criteria andPayPriceIsNull()
         {
              addCriterion("pay_price is null");
              return (Criteria) this;
         }

         public Criteria andPayPriceIsNotNull()
         {
              addCriterion("pay_price is not null");
              return (Criteria) this;
         }

         public Criteria andPayPriceEqualTo(String value)
         {
              addCriterion("pay_price = ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceNotEqualTo(String value)
         {
              addCriterion("pay_price <> ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceGreaterThan(String value)
         {
              addCriterion("pay_price > ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceGreaterThanOrEqualTo(String value)
         {
              addCriterion("pay_price >= ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceLessThan(String value)
         {
              addCriterion("pay_price < ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceLessThanOrEqualTo(String value)
         {
              addCriterion("pay_price <= ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceLike(String value)
         {
              addCriterion("pay_price like ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceNotLike(String value)
         {
              addCriterion("pay_price not like ", value, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceIn(List<String> values)
         {
              addCriterion("pay_price in ", values, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceNotIn(List<String> values)
         {
              addCriterion("pay_price not in ", values, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceBetween(String value1, String value2)
         {
              addCriterion("pay_price between ", value1,value2, "pay_price");
              return (Criteria) this;
         }

         public Criteria andPayPriceNotBetween(String value1, String value2)
         {
              addCriterion("pay_price not between ", value1,value2, "pay_price");
              return (Criteria) this;
         }

         public Criteria andGoodsNumIsNull()
         {
              addCriterion("goods_num is null");
              return (Criteria) this;
         }

         public Criteria andGoodsNumIsNotNull()
         {
              addCriterion("goods_num is not null");
              return (Criteria) this;
         }

         public Criteria andGoodsNumEqualTo(String value)
         {
              addCriterion("goods_num = ", value, "goods_num");
              return (Criteria) this;
         }

         public Criteria andGoodsNumNotEqualTo(String value)
         {
              addCriterion("goods_num <> ", value, "goods_num");
              return (Criteria) this;
         }

         public Criteria andGoodsNumGreaterThan(String value)
         {
              addCriterion("goods_num > ", value, "goods_num");
              return (Criteria) this;
         }

         public Criteria andGoodsNumGreaterThanOrEqualTo(String value)
         {
              addCriterion("goods_num >= ", value, "goods_num");
              return (Criteria) this;
         }

         public Criteria andGoodsNumLessThan(String value)
         {
              addCriterion("goods_num < ", value, "goods_num");
              return (Criteria) this;
         }

         public Criteria andGoodsNumLessThanOrEqualTo(String value)
         {
              addCriterion("goods_num <= ", value, "goods_num");
              return (Criteria) this;
         }

         public Criteria andGoodsNumLike(String value)
         {
              addCriterion("goods_num like ", value, "goods_num");
              return (Criteria) this;
         }

         public Criteria andGoodsNumNotLike(String value)
         {
              addCriterion("goods_num not like ", value, "goods_num");
              return (Criteria) this;
         }

         public Criteria andGoodsNumIn(List<String> values)
         {
              addCriterion("goods_num in ", values, "goods_num");
              return (Criteria) this;
         }

         public Criteria andGoodsNumNotIn(List<String> values)
         {
              addCriterion("goods_num not in ", values, "goods_num");
              return (Criteria) this;
         }

         public Criteria andGoodsNumBetween(String value1, String value2)
         {
              addCriterion("goods_num between ", value1,value2, "goods_num");
              return (Criteria) this;
         }

         public Criteria andGoodsNumNotBetween(String value1, String value2)
         {
              addCriterion("goods_num not between ", value1,value2, "goods_num");
              return (Criteria) this;
         }

         public Criteria andGoodsWeightIsNull()
         {
              addCriterion("goods_weight is null");
              return (Criteria) this;
         }

         public Criteria andGoodsWeightIsNotNull()
         {
              addCriterion("goods_weight is not null");
              return (Criteria) this;
         }

         public Criteria andGoodsWeightEqualTo(String value)
         {
              addCriterion("goods_weight = ", value, "goods_weight");
              return (Criteria) this;
         }

         public Criteria andGoodsWeightNotEqualTo(String value)
         {
              addCriterion("goods_weight <> ", value, "goods_weight");
              return (Criteria) this;
         }

         public Criteria andGoodsWeightGreaterThan(String value)
         {
              addCriterion("goods_weight > ", value, "goods_weight");
              return (Criteria) this;
         }

         public Criteria andGoodsWeightGreaterThanOrEqualTo(String value)
         {
              addCriterion("goods_weight >= ", value, "goods_weight");
              return (Criteria) this;
         }

         public Criteria andGoodsWeightLessThan(String value)
         {
              addCriterion("goods_weight < ", value, "goods_weight");
              return (Criteria) this;
         }

         public Criteria andGoodsWeightLessThanOrEqualTo(String value)
         {
              addCriterion("goods_weight <= ", value, "goods_weight");
              return (Criteria) this;
         }

         public Criteria andGoodsWeightLike(String value)
         {
              addCriterion("goods_weight like ", value, "goods_weight");
              return (Criteria) this;
         }

         public Criteria andGoodsWeightNotLike(String value)
         {
              addCriterion("goods_weight not like ", value, "goods_weight");
              return (Criteria) this;
         }

         public Criteria andGoodsWeightIn(List<String> values)
         {
              addCriterion("goods_weight in ", values, "goods_weight");
              return (Criteria) this;
         }

         public Criteria andGoodsWeightNotIn(List<String> values)
         {
              addCriterion("goods_weight not in ", values, "goods_weight");
              return (Criteria) this;
         }

         public Criteria andGoodsWeightBetween(String value1, String value2)
         {
              addCriterion("goods_weight between ", value1,value2, "goods_weight");
              return (Criteria) this;
         }

         public Criteria andGoodsWeightNotBetween(String value1, String value2)
         {
              addCriterion("goods_weight not between ", value1,value2, "goods_weight");
              return (Criteria) this;
         }

         public Criteria andTotalPriceIsNull()
         {
              addCriterion("total_price is null");
              return (Criteria) this;
         }

         public Criteria andTotalPriceIsNotNull()
         {
              addCriterion("total_price is not null");
              return (Criteria) this;
         }

         public Criteria andTotalPriceEqualTo(String value)
         {
              addCriterion("total_price = ", value, "total_price");
              return (Criteria) this;
         }

         public Criteria andTotalPriceNotEqualTo(String value)
         {
              addCriterion("total_price <> ", value, "total_price");
              return (Criteria) this;
         }

         public Criteria andTotalPriceGreaterThan(String value)
         {
              addCriterion("total_price > ", value, "total_price");
              return (Criteria) this;
         }

         public Criteria andTotalPriceGreaterThanOrEqualTo(String value)
         {
              addCriterion("total_price >= ", value, "total_price");
              return (Criteria) this;
         }

         public Criteria andTotalPriceLessThan(String value)
         {
              addCriterion("total_price < ", value, "total_price");
              return (Criteria) this;
         }

         public Criteria andTotalPriceLessThanOrEqualTo(String value)
         {
              addCriterion("total_price <= ", value, "total_price");
              return (Criteria) this;
         }

         public Criteria andTotalPriceLike(String value)
         {
              addCriterion("total_price like ", value, "total_price");
              return (Criteria) this;
         }

         public Criteria andTotalPriceNotLike(String value)
         {
              addCriterion("total_price not like ", value, "total_price");
              return (Criteria) this;
         }

         public Criteria andTotalPriceIn(List<String> values)
         {
              addCriterion("total_price in ", values, "total_price");
              return (Criteria) this;
         }

         public Criteria andTotalPriceNotIn(List<String> values)
         {
              addCriterion("total_price not in ", values, "total_price");
              return (Criteria) this;
         }

         public Criteria andTotalPriceBetween(String value1, String value2)
         {
              addCriterion("total_price between ", value1,value2, "total_price");
              return (Criteria) this;
         }

         public Criteria andTotalPriceNotBetween(String value1, String value2)
         {
              addCriterion("total_price not between ", value1,value2, "total_price");
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

         public Criteria andAvoidItemIsNull()
         {
              addCriterion("avoid_item is null");
              return (Criteria) this;
         }

         public Criteria andAvoidItemIsNotNull()
         {
              addCriterion("avoid_item is not null");
              return (Criteria) this;
         }

         public Criteria andAvoidItemEqualTo(String value)
         {
              addCriterion("avoid_item = ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemNotEqualTo(String value)
         {
              addCriterion("avoid_item <> ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemGreaterThan(String value)
         {
              addCriterion("avoid_item > ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemGreaterThanOrEqualTo(String value)
         {
              addCriterion("avoid_item >= ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemLessThan(String value)
         {
              addCriterion("avoid_item < ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemLessThanOrEqualTo(String value)
         {
              addCriterion("avoid_item <= ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemLike(String value)
         {
              addCriterion("avoid_item like ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemNotLike(String value)
         {
              addCriterion("avoid_item not like ", value, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemIn(List<String> values)
         {
              addCriterion("avoid_item in ", values, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemNotIn(List<String> values)
         {
              addCriterion("avoid_item not in ", values, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemBetween(String value1, String value2)
         {
              addCriterion("avoid_item between ", value1,value2, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andAvoidItemNotBetween(String value1, String value2)
         {
              addCriterion("avoid_item not between ", value1,value2, "avoid_item");
              return (Criteria) this;
         }

         public Criteria andServeNumIsNull()
         {
              addCriterion("serve_num is null");
              return (Criteria) this;
         }

         public Criteria andServeNumIsNotNull()
         {
              addCriterion("serve_num is not null");
              return (Criteria) this;
         }

         public Criteria andServeNumEqualTo(String value)
         {
              addCriterion("serve_num = ", value, "serve_num");
              return (Criteria) this;
         }

         public Criteria andServeNumNotEqualTo(String value)
         {
              addCriterion("serve_num <> ", value, "serve_num");
              return (Criteria) this;
         }

         public Criteria andServeNumGreaterThan(String value)
         {
              addCriterion("serve_num > ", value, "serve_num");
              return (Criteria) this;
         }

         public Criteria andServeNumGreaterThanOrEqualTo(String value)
         {
              addCriterion("serve_num >= ", value, "serve_num");
              return (Criteria) this;
         }

         public Criteria andServeNumLessThan(String value)
         {
              addCriterion("serve_num < ", value, "serve_num");
              return (Criteria) this;
         }

         public Criteria andServeNumLessThanOrEqualTo(String value)
         {
              addCriterion("serve_num <= ", value, "serve_num");
              return (Criteria) this;
         }

         public Criteria andServeNumLike(String value)
         {
              addCriterion("serve_num like ", value, "serve_num");
              return (Criteria) this;
         }

         public Criteria andServeNumNotLike(String value)
         {
              addCriterion("serve_num not like ", value, "serve_num");
              return (Criteria) this;
         }

         public Criteria andServeNumIn(List<String> values)
         {
              addCriterion("serve_num in ", values, "serve_num");
              return (Criteria) this;
         }

         public Criteria andServeNumNotIn(List<String> values)
         {
              addCriterion("serve_num not in ", values, "serve_num");
              return (Criteria) this;
         }

         public Criteria andServeNumBetween(String value1, String value2)
         {
              addCriterion("serve_num between ", value1,value2, "serve_num");
              return (Criteria) this;
         }

         public Criteria andServeNumNotBetween(String value1, String value2)
         {
              addCriterion("serve_num not between ", value1,value2, "serve_num");
              return (Criteria) this;
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
