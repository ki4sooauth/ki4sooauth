package com.gooagoo.entity.generator.goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 商品基本信息
 */

public class GoodsBaseInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public GoodsBaseInfoExample()
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

         public Criteria andTemplateIdIsNull()
         {
              addCriterion("template_id is null");
              return (Criteria) this;
         }

         public Criteria andTemplateIdIsNotNull()
         {
              addCriterion("template_id is not null");
              return (Criteria) this;
         }

         public Criteria andTemplateIdEqualTo(String value)
         {
              addCriterion("template_id = ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdNotEqualTo(String value)
         {
              addCriterion("template_id <> ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdGreaterThan(String value)
         {
              addCriterion("template_id > ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("template_id >= ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdLessThan(String value)
         {
              addCriterion("template_id < ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdLessThanOrEqualTo(String value)
         {
              addCriterion("template_id <= ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdLike(String value)
         {
              addCriterion("template_id like ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdNotLike(String value)
         {
              addCriterion("template_id not like ", value, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdIn(List<String> values)
         {
              addCriterion("template_id in ", values, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdNotIn(List<String> values)
         {
              addCriterion("template_id not in ", values, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdBetween(String value1, String value2)
         {
              addCriterion("template_id between ", value1,value2, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateIdNotBetween(String value1, String value2)
         {
              addCriterion("template_id not between ", value1,value2, "template_id");
              return (Criteria) this;
         }

         public Criteria andTemplateDataIsNull()
         {
              addCriterion("template_data is null");
              return (Criteria) this;
         }

         public Criteria andTemplateDataIsNotNull()
         {
              addCriterion("template_data is not null");
              return (Criteria) this;
         }

         public Criteria andTemplateDataEqualTo(String value)
         {
              addCriterion("template_data = ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataNotEqualTo(String value)
         {
              addCriterion("template_data <> ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataGreaterThan(String value)
         {
              addCriterion("template_data > ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataGreaterThanOrEqualTo(String value)
         {
              addCriterion("template_data >= ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataLessThan(String value)
         {
              addCriterion("template_data < ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataLessThanOrEqualTo(String value)
         {
              addCriterion("template_data <= ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataLike(String value)
         {
              addCriterion("template_data like ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataNotLike(String value)
         {
              addCriterion("template_data not like ", value, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataIn(List<String> values)
         {
              addCriterion("template_data in ", values, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataNotIn(List<String> values)
         {
              addCriterion("template_data not in ", values, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataBetween(String value1, String value2)
         {
              addCriterion("template_data between ", value1,value2, "template_data");
              return (Criteria) this;
         }

         public Criteria andTemplateDataNotBetween(String value1, String value2)
         {
              addCriterion("template_data not between ", value1,value2, "template_data");
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
