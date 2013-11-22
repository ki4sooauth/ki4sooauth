package com.gooagoo.entity.generator.goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 商品营销信息
 */

public class GoodsMarketingInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public GoodsMarketingInfoExample()
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

         public Criteria andVendorIsNull()
         {
              addCriterion("vendor is null");
              return (Criteria) this;
         }

         public Criteria andVendorIsNotNull()
         {
              addCriterion("vendor is not null");
              return (Criteria) this;
         }

         public Criteria andVendorEqualTo(String value)
         {
              addCriterion("vendor = ", value, "vendor");
              return (Criteria) this;
         }

         public Criteria andVendorNotEqualTo(String value)
         {
              addCriterion("vendor <> ", value, "vendor");
              return (Criteria) this;
         }

         public Criteria andVendorGreaterThan(String value)
         {
              addCriterion("vendor > ", value, "vendor");
              return (Criteria) this;
         }

         public Criteria andVendorGreaterThanOrEqualTo(String value)
         {
              addCriterion("vendor >= ", value, "vendor");
              return (Criteria) this;
         }

         public Criteria andVendorLessThan(String value)
         {
              addCriterion("vendor < ", value, "vendor");
              return (Criteria) this;
         }

         public Criteria andVendorLessThanOrEqualTo(String value)
         {
              addCriterion("vendor <= ", value, "vendor");
              return (Criteria) this;
         }

         public Criteria andVendorLike(String value)
         {
              addCriterion("vendor like ", value, "vendor");
              return (Criteria) this;
         }

         public Criteria andVendorNotLike(String value)
         {
              addCriterion("vendor not like ", value, "vendor");
              return (Criteria) this;
         }

         public Criteria andVendorIn(List<String> values)
         {
              addCriterion("vendor in ", values, "vendor");
              return (Criteria) this;
         }

         public Criteria andVendorNotIn(List<String> values)
         {
              addCriterion("vendor not in ", values, "vendor");
              return (Criteria) this;
         }

         public Criteria andVendorBetween(String value1, String value2)
         {
              addCriterion("vendor between ", value1,value2, "vendor");
              return (Criteria) this;
         }

         public Criteria andVendorNotBetween(String value1, String value2)
         {
              addCriterion("vendor not between ", value1,value2, "vendor");
              return (Criteria) this;
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

         public Criteria andGoodsContentIsNull()
         {
              addCriterion("goods_content is null");
              return (Criteria) this;
         }

         public Criteria andGoodsContentIsNotNull()
         {
              addCriterion("goods_content is not null");
              return (Criteria) this;
         }

         public Criteria andGoodsContentEqualTo(String value)
         {
              addCriterion("goods_content = ", value, "goods_content");
              return (Criteria) this;
         }

         public Criteria andGoodsContentNotEqualTo(String value)
         {
              addCriterion("goods_content <> ", value, "goods_content");
              return (Criteria) this;
         }

         public Criteria andGoodsContentGreaterThan(String value)
         {
              addCriterion("goods_content > ", value, "goods_content");
              return (Criteria) this;
         }

         public Criteria andGoodsContentGreaterThanOrEqualTo(String value)
         {
              addCriterion("goods_content >= ", value, "goods_content");
              return (Criteria) this;
         }

         public Criteria andGoodsContentLessThan(String value)
         {
              addCriterion("goods_content < ", value, "goods_content");
              return (Criteria) this;
         }

         public Criteria andGoodsContentLessThanOrEqualTo(String value)
         {
              addCriterion("goods_content <= ", value, "goods_content");
              return (Criteria) this;
         }

         public Criteria andGoodsContentLike(String value)
         {
              addCriterion("goods_content like ", value, "goods_content");
              return (Criteria) this;
         }

         public Criteria andGoodsContentNotLike(String value)
         {
              addCriterion("goods_content not like ", value, "goods_content");
              return (Criteria) this;
         }

         public Criteria andGoodsContentIn(List<String> values)
         {
              addCriterion("goods_content in ", values, "goods_content");
              return (Criteria) this;
         }

         public Criteria andGoodsContentNotIn(List<String> values)
         {
              addCriterion("goods_content not in ", values, "goods_content");
              return (Criteria) this;
         }

         public Criteria andGoodsContentBetween(String value1, String value2)
         {
              addCriterion("goods_content between ", value1,value2, "goods_content");
              return (Criteria) this;
         }

         public Criteria andGoodsContentNotBetween(String value1, String value2)
         {
              addCriterion("goods_content not between ", value1,value2, "goods_content");
              return (Criteria) this;
         }

         public Criteria andGoodsSolutionIsNull()
         {
              addCriterion("goods_solution is null");
              return (Criteria) this;
         }

         public Criteria andGoodsSolutionIsNotNull()
         {
              addCriterion("goods_solution is not null");
              return (Criteria) this;
         }

         public Criteria andGoodsSolutionEqualTo(String value)
         {
              addCriterion("goods_solution = ", value, "goods_solution");
              return (Criteria) this;
         }

         public Criteria andGoodsSolutionNotEqualTo(String value)
         {
              addCriterion("goods_solution <> ", value, "goods_solution");
              return (Criteria) this;
         }

         public Criteria andGoodsSolutionGreaterThan(String value)
         {
              addCriterion("goods_solution > ", value, "goods_solution");
              return (Criteria) this;
         }

         public Criteria andGoodsSolutionGreaterThanOrEqualTo(String value)
         {
              addCriterion("goods_solution >= ", value, "goods_solution");
              return (Criteria) this;
         }

         public Criteria andGoodsSolutionLessThan(String value)
         {
              addCriterion("goods_solution < ", value, "goods_solution");
              return (Criteria) this;
         }

         public Criteria andGoodsSolutionLessThanOrEqualTo(String value)
         {
              addCriterion("goods_solution <= ", value, "goods_solution");
              return (Criteria) this;
         }

         public Criteria andGoodsSolutionLike(String value)
         {
              addCriterion("goods_solution like ", value, "goods_solution");
              return (Criteria) this;
         }

         public Criteria andGoodsSolutionNotLike(String value)
         {
              addCriterion("goods_solution not like ", value, "goods_solution");
              return (Criteria) this;
         }

         public Criteria andGoodsSolutionIn(List<String> values)
         {
              addCriterion("goods_solution in ", values, "goods_solution");
              return (Criteria) this;
         }

         public Criteria andGoodsSolutionNotIn(List<String> values)
         {
              addCriterion("goods_solution not in ", values, "goods_solution");
              return (Criteria) this;
         }

         public Criteria andGoodsSolutionBetween(String value1, String value2)
         {
              addCriterion("goods_solution between ", value1,value2, "goods_solution");
              return (Criteria) this;
         }

         public Criteria andGoodsSolutionNotBetween(String value1, String value2)
         {
              addCriterion("goods_solution not between ", value1,value2, "goods_solution");
              return (Criteria) this;
         }

         public Criteria andCrossGoodsIsNull()
         {
              addCriterion("cross_goods is null");
              return (Criteria) this;
         }

         public Criteria andCrossGoodsIsNotNull()
         {
              addCriterion("cross_goods is not null");
              return (Criteria) this;
         }

         public Criteria andCrossGoodsEqualTo(String value)
         {
              addCriterion("cross_goods = ", value, "cross_goods");
              return (Criteria) this;
         }

         public Criteria andCrossGoodsNotEqualTo(String value)
         {
              addCriterion("cross_goods <> ", value, "cross_goods");
              return (Criteria) this;
         }

         public Criteria andCrossGoodsGreaterThan(String value)
         {
              addCriterion("cross_goods > ", value, "cross_goods");
              return (Criteria) this;
         }

         public Criteria andCrossGoodsGreaterThanOrEqualTo(String value)
         {
              addCriterion("cross_goods >= ", value, "cross_goods");
              return (Criteria) this;
         }

         public Criteria andCrossGoodsLessThan(String value)
         {
              addCriterion("cross_goods < ", value, "cross_goods");
              return (Criteria) this;
         }

         public Criteria andCrossGoodsLessThanOrEqualTo(String value)
         {
              addCriterion("cross_goods <= ", value, "cross_goods");
              return (Criteria) this;
         }

         public Criteria andCrossGoodsLike(String value)
         {
              addCriterion("cross_goods like ", value, "cross_goods");
              return (Criteria) this;
         }

         public Criteria andCrossGoodsNotLike(String value)
         {
              addCriterion("cross_goods not like ", value, "cross_goods");
              return (Criteria) this;
         }

         public Criteria andCrossGoodsIn(List<String> values)
         {
              addCriterion("cross_goods in ", values, "cross_goods");
              return (Criteria) this;
         }

         public Criteria andCrossGoodsNotIn(List<String> values)
         {
              addCriterion("cross_goods not in ", values, "cross_goods");
              return (Criteria) this;
         }

         public Criteria andCrossGoodsBetween(String value1, String value2)
         {
              addCriterion("cross_goods between ", value1,value2, "cross_goods");
              return (Criteria) this;
         }

         public Criteria andCrossGoodsNotBetween(String value1, String value2)
         {
              addCriterion("cross_goods not between ", value1,value2, "cross_goods");
              return (Criteria) this;
         }

         public Criteria andRelationGoodsIsNull()
         {
              addCriterion("relation_goods is null");
              return (Criteria) this;
         }

         public Criteria andRelationGoodsIsNotNull()
         {
              addCriterion("relation_goods is not null");
              return (Criteria) this;
         }

         public Criteria andRelationGoodsEqualTo(String value)
         {
              addCriterion("relation_goods = ", value, "relation_goods");
              return (Criteria) this;
         }

         public Criteria andRelationGoodsNotEqualTo(String value)
         {
              addCriterion("relation_goods <> ", value, "relation_goods");
              return (Criteria) this;
         }

         public Criteria andRelationGoodsGreaterThan(String value)
         {
              addCriterion("relation_goods > ", value, "relation_goods");
              return (Criteria) this;
         }

         public Criteria andRelationGoodsGreaterThanOrEqualTo(String value)
         {
              addCriterion("relation_goods >= ", value, "relation_goods");
              return (Criteria) this;
         }

         public Criteria andRelationGoodsLessThan(String value)
         {
              addCriterion("relation_goods < ", value, "relation_goods");
              return (Criteria) this;
         }

         public Criteria andRelationGoodsLessThanOrEqualTo(String value)
         {
              addCriterion("relation_goods <= ", value, "relation_goods");
              return (Criteria) this;
         }

         public Criteria andRelationGoodsLike(String value)
         {
              addCriterion("relation_goods like ", value, "relation_goods");
              return (Criteria) this;
         }

         public Criteria andRelationGoodsNotLike(String value)
         {
              addCriterion("relation_goods not like ", value, "relation_goods");
              return (Criteria) this;
         }

         public Criteria andRelationGoodsIn(List<String> values)
         {
              addCriterion("relation_goods in ", values, "relation_goods");
              return (Criteria) this;
         }

         public Criteria andRelationGoodsNotIn(List<String> values)
         {
              addCriterion("relation_goods not in ", values, "relation_goods");
              return (Criteria) this;
         }

         public Criteria andRelationGoodsBetween(String value1, String value2)
         {
              addCriterion("relation_goods between ", value1,value2, "relation_goods");
              return (Criteria) this;
         }

         public Criteria andRelationGoodsNotBetween(String value1, String value2)
         {
              addCriterion("relation_goods not between ", value1,value2, "relation_goods");
              return (Criteria) this;
         }

         public Criteria andReplaceGoodsIsNull()
         {
              addCriterion("replace_goods is null");
              return (Criteria) this;
         }

         public Criteria andReplaceGoodsIsNotNull()
         {
              addCriterion("replace_goods is not null");
              return (Criteria) this;
         }

         public Criteria andReplaceGoodsEqualTo(String value)
         {
              addCriterion("replace_goods = ", value, "replace_goods");
              return (Criteria) this;
         }

         public Criteria andReplaceGoodsNotEqualTo(String value)
         {
              addCriterion("replace_goods <> ", value, "replace_goods");
              return (Criteria) this;
         }

         public Criteria andReplaceGoodsGreaterThan(String value)
         {
              addCriterion("replace_goods > ", value, "replace_goods");
              return (Criteria) this;
         }

         public Criteria andReplaceGoodsGreaterThanOrEqualTo(String value)
         {
              addCriterion("replace_goods >= ", value, "replace_goods");
              return (Criteria) this;
         }

         public Criteria andReplaceGoodsLessThan(String value)
         {
              addCriterion("replace_goods < ", value, "replace_goods");
              return (Criteria) this;
         }

         public Criteria andReplaceGoodsLessThanOrEqualTo(String value)
         {
              addCriterion("replace_goods <= ", value, "replace_goods");
              return (Criteria) this;
         }

         public Criteria andReplaceGoodsLike(String value)
         {
              addCriterion("replace_goods like ", value, "replace_goods");
              return (Criteria) this;
         }

         public Criteria andReplaceGoodsNotLike(String value)
         {
              addCriterion("replace_goods not like ", value, "replace_goods");
              return (Criteria) this;
         }

         public Criteria andReplaceGoodsIn(List<String> values)
         {
              addCriterion("replace_goods in ", values, "replace_goods");
              return (Criteria) this;
         }

         public Criteria andReplaceGoodsNotIn(List<String> values)
         {
              addCriterion("replace_goods not in ", values, "replace_goods");
              return (Criteria) this;
         }

         public Criteria andReplaceGoodsBetween(String value1, String value2)
         {
              addCriterion("replace_goods between ", value1,value2, "replace_goods");
              return (Criteria) this;
         }

         public Criteria andReplaceGoodsNotBetween(String value1, String value2)
         {
              addCriterion("replace_goods not between ", value1,value2, "replace_goods");
              return (Criteria) this;
         }

         public Criteria andLifeIdeaIsNull()
         {
              addCriterion("life_idea is null");
              return (Criteria) this;
         }

         public Criteria andLifeIdeaIsNotNull()
         {
              addCriterion("life_idea is not null");
              return (Criteria) this;
         }

         public Criteria andLifeIdeaEqualTo(String value)
         {
              addCriterion("life_idea = ", value, "life_idea");
              return (Criteria) this;
         }

         public Criteria andLifeIdeaNotEqualTo(String value)
         {
              addCriterion("life_idea <> ", value, "life_idea");
              return (Criteria) this;
         }

         public Criteria andLifeIdeaGreaterThan(String value)
         {
              addCriterion("life_idea > ", value, "life_idea");
              return (Criteria) this;
         }

         public Criteria andLifeIdeaGreaterThanOrEqualTo(String value)
         {
              addCriterion("life_idea >= ", value, "life_idea");
              return (Criteria) this;
         }

         public Criteria andLifeIdeaLessThan(String value)
         {
              addCriterion("life_idea < ", value, "life_idea");
              return (Criteria) this;
         }

         public Criteria andLifeIdeaLessThanOrEqualTo(String value)
         {
              addCriterion("life_idea <= ", value, "life_idea");
              return (Criteria) this;
         }

         public Criteria andLifeIdeaLike(String value)
         {
              addCriterion("life_idea like ", value, "life_idea");
              return (Criteria) this;
         }

         public Criteria andLifeIdeaNotLike(String value)
         {
              addCriterion("life_idea not like ", value, "life_idea");
              return (Criteria) this;
         }

         public Criteria andLifeIdeaIn(List<String> values)
         {
              addCriterion("life_idea in ", values, "life_idea");
              return (Criteria) this;
         }

         public Criteria andLifeIdeaNotIn(List<String> values)
         {
              addCriterion("life_idea not in ", values, "life_idea");
              return (Criteria) this;
         }

         public Criteria andLifeIdeaBetween(String value1, String value2)
         {
              addCriterion("life_idea between ", value1,value2, "life_idea");
              return (Criteria) this;
         }

         public Criteria andLifeIdeaNotBetween(String value1, String value2)
         {
              addCriterion("life_idea not between ", value1,value2, "life_idea");
              return (Criteria) this;
         }

         public Criteria andUseTypeIsNull()
         {
              addCriterion("use_type is null");
              return (Criteria) this;
         }

         public Criteria andUseTypeIsNotNull()
         {
              addCriterion("use_type is not null");
              return (Criteria) this;
         }

         public Criteria andUseTypeEqualTo(String value)
         {
              addCriterion("use_type = ", value, "use_type");
              return (Criteria) this;
         }

         public Criteria andUseTypeNotEqualTo(String value)
         {
              addCriterion("use_type <> ", value, "use_type");
              return (Criteria) this;
         }

         public Criteria andUseTypeGreaterThan(String value)
         {
              addCriterion("use_type > ", value, "use_type");
              return (Criteria) this;
         }

         public Criteria andUseTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("use_type >= ", value, "use_type");
              return (Criteria) this;
         }

         public Criteria andUseTypeLessThan(String value)
         {
              addCriterion("use_type < ", value, "use_type");
              return (Criteria) this;
         }

         public Criteria andUseTypeLessThanOrEqualTo(String value)
         {
              addCriterion("use_type <= ", value, "use_type");
              return (Criteria) this;
         }

         public Criteria andUseTypeLike(String value)
         {
              addCriterion("use_type like ", value, "use_type");
              return (Criteria) this;
         }

         public Criteria andUseTypeNotLike(String value)
         {
              addCriterion("use_type not like ", value, "use_type");
              return (Criteria) this;
         }

         public Criteria andUseTypeIn(List<String> values)
         {
              addCriterion("use_type in ", values, "use_type");
              return (Criteria) this;
         }

         public Criteria andUseTypeNotIn(List<String> values)
         {
              addCriterion("use_type not in ", values, "use_type");
              return (Criteria) this;
         }

         public Criteria andUseTypeBetween(String value1, String value2)
         {
              addCriterion("use_type between ", value1,value2, "use_type");
              return (Criteria) this;
         }

         public Criteria andUseTypeNotBetween(String value1, String value2)
         {
              addCriterion("use_type not between ", value1,value2, "use_type");
              return (Criteria) this;
         }

         public Criteria andFeatureIsNull()
         {
              addCriterion("feature is null");
              return (Criteria) this;
         }

         public Criteria andFeatureIsNotNull()
         {
              addCriterion("feature is not null");
              return (Criteria) this;
         }

         public Criteria andFeatureEqualTo(String value)
         {
              addCriterion("feature = ", value, "feature");
              return (Criteria) this;
         }

         public Criteria andFeatureNotEqualTo(String value)
         {
              addCriterion("feature <> ", value, "feature");
              return (Criteria) this;
         }

         public Criteria andFeatureGreaterThan(String value)
         {
              addCriterion("feature > ", value, "feature");
              return (Criteria) this;
         }

         public Criteria andFeatureGreaterThanOrEqualTo(String value)
         {
              addCriterion("feature >= ", value, "feature");
              return (Criteria) this;
         }

         public Criteria andFeatureLessThan(String value)
         {
              addCriterion("feature < ", value, "feature");
              return (Criteria) this;
         }

         public Criteria andFeatureLessThanOrEqualTo(String value)
         {
              addCriterion("feature <= ", value, "feature");
              return (Criteria) this;
         }

         public Criteria andFeatureLike(String value)
         {
              addCriterion("feature like ", value, "feature");
              return (Criteria) this;
         }

         public Criteria andFeatureNotLike(String value)
         {
              addCriterion("feature not like ", value, "feature");
              return (Criteria) this;
         }

         public Criteria andFeatureIn(List<String> values)
         {
              addCriterion("feature in ", values, "feature");
              return (Criteria) this;
         }

         public Criteria andFeatureNotIn(List<String> values)
         {
              addCriterion("feature not in ", values, "feature");
              return (Criteria) this;
         }

         public Criteria andFeatureBetween(String value1, String value2)
         {
              addCriterion("feature between ", value1,value2, "feature");
              return (Criteria) this;
         }

         public Criteria andFeatureNotBetween(String value1, String value2)
         {
              addCriterion("feature not between ", value1,value2, "feature");
              return (Criteria) this;
         }

         public Criteria andAddressIsNull()
         {
              addCriterion("address is null");
              return (Criteria) this;
         }

         public Criteria andAddressIsNotNull()
         {
              addCriterion("address is not null");
              return (Criteria) this;
         }

         public Criteria andAddressEqualTo(String value)
         {
              addCriterion("address = ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressNotEqualTo(String value)
         {
              addCriterion("address <> ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressGreaterThan(String value)
         {
              addCriterion("address > ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressGreaterThanOrEqualTo(String value)
         {
              addCriterion("address >= ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressLessThan(String value)
         {
              addCriterion("address < ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressLessThanOrEqualTo(String value)
         {
              addCriterion("address <= ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressLike(String value)
         {
              addCriterion("address like ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressNotLike(String value)
         {
              addCriterion("address not like ", value, "address");
              return (Criteria) this;
         }

         public Criteria andAddressIn(List<String> values)
         {
              addCriterion("address in ", values, "address");
              return (Criteria) this;
         }

         public Criteria andAddressNotIn(List<String> values)
         {
              addCriterion("address not in ", values, "address");
              return (Criteria) this;
         }

         public Criteria andAddressBetween(String value1, String value2)
         {
              addCriterion("address between ", value1,value2, "address");
              return (Criteria) this;
         }

         public Criteria andAddressNotBetween(String value1, String value2)
         {
              addCriterion("address not between ", value1,value2, "address");
              return (Criteria) this;
         }

         public Criteria andCrowdIsNull()
         {
              addCriterion("crowd is null");
              return (Criteria) this;
         }

         public Criteria andCrowdIsNotNull()
         {
              addCriterion("crowd is not null");
              return (Criteria) this;
         }

         public Criteria andCrowdEqualTo(String value)
         {
              addCriterion("crowd = ", value, "crowd");
              return (Criteria) this;
         }

         public Criteria andCrowdNotEqualTo(String value)
         {
              addCriterion("crowd <> ", value, "crowd");
              return (Criteria) this;
         }

         public Criteria andCrowdGreaterThan(String value)
         {
              addCriterion("crowd > ", value, "crowd");
              return (Criteria) this;
         }

         public Criteria andCrowdGreaterThanOrEqualTo(String value)
         {
              addCriterion("crowd >= ", value, "crowd");
              return (Criteria) this;
         }

         public Criteria andCrowdLessThan(String value)
         {
              addCriterion("crowd < ", value, "crowd");
              return (Criteria) this;
         }

         public Criteria andCrowdLessThanOrEqualTo(String value)
         {
              addCriterion("crowd <= ", value, "crowd");
              return (Criteria) this;
         }

         public Criteria andCrowdLike(String value)
         {
              addCriterion("crowd like ", value, "crowd");
              return (Criteria) this;
         }

         public Criteria andCrowdNotLike(String value)
         {
              addCriterion("crowd not like ", value, "crowd");
              return (Criteria) this;
         }

         public Criteria andCrowdIn(List<String> values)
         {
              addCriterion("crowd in ", values, "crowd");
              return (Criteria) this;
         }

         public Criteria andCrowdNotIn(List<String> values)
         {
              addCriterion("crowd not in ", values, "crowd");
              return (Criteria) this;
         }

         public Criteria andCrowdBetween(String value1, String value2)
         {
              addCriterion("crowd between ", value1,value2, "crowd");
              return (Criteria) this;
         }

         public Criteria andCrowdNotBetween(String value1, String value2)
         {
              addCriterion("crowd not between ", value1,value2, "crowd");
              return (Criteria) this;
         }

         public Criteria andUseMessageIsNull()
         {
              addCriterion("use_message is null");
              return (Criteria) this;
         }

         public Criteria andUseMessageIsNotNull()
         {
              addCriterion("use_message is not null");
              return (Criteria) this;
         }

         public Criteria andUseMessageEqualTo(String value)
         {
              addCriterion("use_message = ", value, "use_message");
              return (Criteria) this;
         }

         public Criteria andUseMessageNotEqualTo(String value)
         {
              addCriterion("use_message <> ", value, "use_message");
              return (Criteria) this;
         }

         public Criteria andUseMessageGreaterThan(String value)
         {
              addCriterion("use_message > ", value, "use_message");
              return (Criteria) this;
         }

         public Criteria andUseMessageGreaterThanOrEqualTo(String value)
         {
              addCriterion("use_message >= ", value, "use_message");
              return (Criteria) this;
         }

         public Criteria andUseMessageLessThan(String value)
         {
              addCriterion("use_message < ", value, "use_message");
              return (Criteria) this;
         }

         public Criteria andUseMessageLessThanOrEqualTo(String value)
         {
              addCriterion("use_message <= ", value, "use_message");
              return (Criteria) this;
         }

         public Criteria andUseMessageLike(String value)
         {
              addCriterion("use_message like ", value, "use_message");
              return (Criteria) this;
         }

         public Criteria andUseMessageNotLike(String value)
         {
              addCriterion("use_message not like ", value, "use_message");
              return (Criteria) this;
         }

         public Criteria andUseMessageIn(List<String> values)
         {
              addCriterion("use_message in ", values, "use_message");
              return (Criteria) this;
         }

         public Criteria andUseMessageNotIn(List<String> values)
         {
              addCriterion("use_message not in ", values, "use_message");
              return (Criteria) this;
         }

         public Criteria andUseMessageBetween(String value1, String value2)
         {
              addCriterion("use_message between ", value1,value2, "use_message");
              return (Criteria) this;
         }

         public Criteria andUseMessageNotBetween(String value1, String value2)
         {
              addCriterion("use_message not between ", value1,value2, "use_message");
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
