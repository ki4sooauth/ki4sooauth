package com.gooagoo.entity.generator.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 区域地图参数
 */

public class AreaParaExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public AreaParaExample()
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

         public Criteria andMapIdIsNull()
         {
              addCriterion("map_id is null");
              return (Criteria) this;
         }

         public Criteria andMapIdIsNotNull()
         {
              addCriterion("map_id is not null");
              return (Criteria) this;
         }

         public Criteria andMapIdEqualTo(String value)
         {
              addCriterion("map_id = ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdNotEqualTo(String value)
         {
              addCriterion("map_id <> ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdGreaterThan(String value)
         {
              addCriterion("map_id > ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("map_id >= ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdLessThan(String value)
         {
              addCriterion("map_id < ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdLessThanOrEqualTo(String value)
         {
              addCriterion("map_id <= ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdLike(String value)
         {
              addCriterion("map_id like ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdNotLike(String value)
         {
              addCriterion("map_id not like ", value, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdIn(List<String> values)
         {
              addCriterion("map_id in ", values, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdNotIn(List<String> values)
         {
              addCriterion("map_id not in ", values, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdBetween(String value1, String value2)
         {
              addCriterion("map_id between ", value1,value2, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapIdNotBetween(String value1, String value2)
         {
              addCriterion("map_id not between ", value1,value2, "map_id");
              return (Criteria) this;
         }

         public Criteria andMapNameIsNull()
         {
              addCriterion("map_name is null");
              return (Criteria) this;
         }

         public Criteria andMapNameIsNotNull()
         {
              addCriterion("map_name is not null");
              return (Criteria) this;
         }

         public Criteria andMapNameEqualTo(String value)
         {
              addCriterion("map_name = ", value, "map_name");
              return (Criteria) this;
         }

         public Criteria andMapNameNotEqualTo(String value)
         {
              addCriterion("map_name <> ", value, "map_name");
              return (Criteria) this;
         }

         public Criteria andMapNameGreaterThan(String value)
         {
              addCriterion("map_name > ", value, "map_name");
              return (Criteria) this;
         }

         public Criteria andMapNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("map_name >= ", value, "map_name");
              return (Criteria) this;
         }

         public Criteria andMapNameLessThan(String value)
         {
              addCriterion("map_name < ", value, "map_name");
              return (Criteria) this;
         }

         public Criteria andMapNameLessThanOrEqualTo(String value)
         {
              addCriterion("map_name <= ", value, "map_name");
              return (Criteria) this;
         }

         public Criteria andMapNameLike(String value)
         {
              addCriterion("map_name like ", value, "map_name");
              return (Criteria) this;
         }

         public Criteria andMapNameNotLike(String value)
         {
              addCriterion("map_name not like ", value, "map_name");
              return (Criteria) this;
         }

         public Criteria andMapNameIn(List<String> values)
         {
              addCriterion("map_name in ", values, "map_name");
              return (Criteria) this;
         }

         public Criteria andMapNameNotIn(List<String> values)
         {
              addCriterion("map_name not in ", values, "map_name");
              return (Criteria) this;
         }

         public Criteria andMapNameBetween(String value1, String value2)
         {
              addCriterion("map_name between ", value1,value2, "map_name");
              return (Criteria) this;
         }

         public Criteria andMapNameNotBetween(String value1, String value2)
         {
              addCriterion("map_name not between ", value1,value2, "map_name");
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

         public Criteria andUrlHtmlIsNull()
         {
              addCriterion("url_html is null");
              return (Criteria) this;
         }

         public Criteria andUrlHtmlIsNotNull()
         {
              addCriterion("url_html is not null");
              return (Criteria) this;
         }

         public Criteria andUrlHtmlEqualTo(String value)
         {
              addCriterion("url_html = ", value, "url_html");
              return (Criteria) this;
         }

         public Criteria andUrlHtmlNotEqualTo(String value)
         {
              addCriterion("url_html <> ", value, "url_html");
              return (Criteria) this;
         }

         public Criteria andUrlHtmlGreaterThan(String value)
         {
              addCriterion("url_html > ", value, "url_html");
              return (Criteria) this;
         }

         public Criteria andUrlHtmlGreaterThanOrEqualTo(String value)
         {
              addCriterion("url_html >= ", value, "url_html");
              return (Criteria) this;
         }

         public Criteria andUrlHtmlLessThan(String value)
         {
              addCriterion("url_html < ", value, "url_html");
              return (Criteria) this;
         }

         public Criteria andUrlHtmlLessThanOrEqualTo(String value)
         {
              addCriterion("url_html <= ", value, "url_html");
              return (Criteria) this;
         }

         public Criteria andUrlHtmlLike(String value)
         {
              addCriterion("url_html like ", value, "url_html");
              return (Criteria) this;
         }

         public Criteria andUrlHtmlNotLike(String value)
         {
              addCriterion("url_html not like ", value, "url_html");
              return (Criteria) this;
         }

         public Criteria andUrlHtmlIn(List<String> values)
         {
              addCriterion("url_html in ", values, "url_html");
              return (Criteria) this;
         }

         public Criteria andUrlHtmlNotIn(List<String> values)
         {
              addCriterion("url_html not in ", values, "url_html");
              return (Criteria) this;
         }

         public Criteria andUrlHtmlBetween(String value1, String value2)
         {
              addCriterion("url_html between ", value1,value2, "url_html");
              return (Criteria) this;
         }

         public Criteria andUrlHtmlNotBetween(String value1, String value2)
         {
              addCriterion("url_html not between ", value1,value2, "url_html");
              return (Criteria) this;
         }

         public Criteria andUrlSvgIsNull()
         {
              addCriterion("url_svg is null");
              return (Criteria) this;
         }

         public Criteria andUrlSvgIsNotNull()
         {
              addCriterion("url_svg is not null");
              return (Criteria) this;
         }

         public Criteria andUrlSvgEqualTo(String value)
         {
              addCriterion("url_svg = ", value, "url_svg");
              return (Criteria) this;
         }

         public Criteria andUrlSvgNotEqualTo(String value)
         {
              addCriterion("url_svg <> ", value, "url_svg");
              return (Criteria) this;
         }

         public Criteria andUrlSvgGreaterThan(String value)
         {
              addCriterion("url_svg > ", value, "url_svg");
              return (Criteria) this;
         }

         public Criteria andUrlSvgGreaterThanOrEqualTo(String value)
         {
              addCriterion("url_svg >= ", value, "url_svg");
              return (Criteria) this;
         }

         public Criteria andUrlSvgLessThan(String value)
         {
              addCriterion("url_svg < ", value, "url_svg");
              return (Criteria) this;
         }

         public Criteria andUrlSvgLessThanOrEqualTo(String value)
         {
              addCriterion("url_svg <= ", value, "url_svg");
              return (Criteria) this;
         }

         public Criteria andUrlSvgLike(String value)
         {
              addCriterion("url_svg like ", value, "url_svg");
              return (Criteria) this;
         }

         public Criteria andUrlSvgNotLike(String value)
         {
              addCriterion("url_svg not like ", value, "url_svg");
              return (Criteria) this;
         }

         public Criteria andUrlSvgIn(List<String> values)
         {
              addCriterion("url_svg in ", values, "url_svg");
              return (Criteria) this;
         }

         public Criteria andUrlSvgNotIn(List<String> values)
         {
              addCriterion("url_svg not in ", values, "url_svg");
              return (Criteria) this;
         }

         public Criteria andUrlSvgBetween(String value1, String value2)
         {
              addCriterion("url_svg between ", value1,value2, "url_svg");
              return (Criteria) this;
         }

         public Criteria andUrlSvgNotBetween(String value1, String value2)
         {
              addCriterion("url_svg not between ", value1,value2, "url_svg");
              return (Criteria) this;
         }

         public Criteria andGridInfoIsNull()
         {
              addCriterion("grid_info is null");
              return (Criteria) this;
         }

         public Criteria andGridInfoIsNotNull()
         {
              addCriterion("grid_info is not null");
              return (Criteria) this;
         }

         public Criteria andGridInfoEqualTo(String value)
         {
              addCriterion("grid_info = ", value, "grid_info");
              return (Criteria) this;
         }

         public Criteria andGridInfoNotEqualTo(String value)
         {
              addCriterion("grid_info <> ", value, "grid_info");
              return (Criteria) this;
         }

         public Criteria andGridInfoGreaterThan(String value)
         {
              addCriterion("grid_info > ", value, "grid_info");
              return (Criteria) this;
         }

         public Criteria andGridInfoGreaterThanOrEqualTo(String value)
         {
              addCriterion("grid_info >= ", value, "grid_info");
              return (Criteria) this;
         }

         public Criteria andGridInfoLessThan(String value)
         {
              addCriterion("grid_info < ", value, "grid_info");
              return (Criteria) this;
         }

         public Criteria andGridInfoLessThanOrEqualTo(String value)
         {
              addCriterion("grid_info <= ", value, "grid_info");
              return (Criteria) this;
         }

         public Criteria andGridInfoLike(String value)
         {
              addCriterion("grid_info like ", value, "grid_info");
              return (Criteria) this;
         }

         public Criteria andGridInfoNotLike(String value)
         {
              addCriterion("grid_info not like ", value, "grid_info");
              return (Criteria) this;
         }

         public Criteria andGridInfoIn(List<String> values)
         {
              addCriterion("grid_info in ", values, "grid_info");
              return (Criteria) this;
         }

         public Criteria andGridInfoNotIn(List<String> values)
         {
              addCriterion("grid_info not in ", values, "grid_info");
              return (Criteria) this;
         }

         public Criteria andGridInfoBetween(String value1, String value2)
         {
              addCriterion("grid_info between ", value1,value2, "grid_info");
              return (Criteria) this;
         }

         public Criteria andGridInfoNotBetween(String value1, String value2)
         {
              addCriterion("grid_info not between ", value1,value2, "grid_info");
              return (Criteria) this;
         }

         public Criteria andIsParkIsNull()
         {
              addCriterion("is_park is null");
              return (Criteria) this;
         }

         public Criteria andIsParkIsNotNull()
         {
              addCriterion("is_park is not null");
              return (Criteria) this;
         }

         public Criteria andIsParkEqualTo(String value)
         {
              addCriterion("is_park = ", value, "is_park");
              return (Criteria) this;
         }

         public Criteria andIsParkNotEqualTo(String value)
         {
              addCriterion("is_park <> ", value, "is_park");
              return (Criteria) this;
         }

         public Criteria andIsParkGreaterThan(String value)
         {
              addCriterion("is_park > ", value, "is_park");
              return (Criteria) this;
         }

         public Criteria andIsParkGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_park >= ", value, "is_park");
              return (Criteria) this;
         }

         public Criteria andIsParkLessThan(String value)
         {
              addCriterion("is_park < ", value, "is_park");
              return (Criteria) this;
         }

         public Criteria andIsParkLessThanOrEqualTo(String value)
         {
              addCriterion("is_park <= ", value, "is_park");
              return (Criteria) this;
         }

         public Criteria andIsParkLike(String value)
         {
              addCriterion("is_park like ", value, "is_park");
              return (Criteria) this;
         }

         public Criteria andIsParkNotLike(String value)
         {
              addCriterion("is_park not like ", value, "is_park");
              return (Criteria) this;
         }

         public Criteria andIsParkIn(List<String> values)
         {
              addCriterion("is_park in ", values, "is_park");
              return (Criteria) this;
         }

         public Criteria andIsParkNotIn(List<String> values)
         {
              addCriterion("is_park not in ", values, "is_park");
              return (Criteria) this;
         }

         public Criteria andIsParkBetween(String value1, String value2)
         {
              addCriterion("is_park between ", value1,value2, "is_park");
              return (Criteria) this;
         }

         public Criteria andIsParkNotBetween(String value1, String value2)
         {
              addCriterion("is_park not between ", value1,value2, "is_park");
              return (Criteria) this;
         }

         public Criteria andMapRealWidthIsNull()
         {
              addCriterion("map_real_width is null");
              return (Criteria) this;
         }

         public Criteria andMapRealWidthIsNotNull()
         {
              addCriterion("map_real_width is not null");
              return (Criteria) this;
         }

         public Criteria andMapRealWidthEqualTo(String value)
         {
              addCriterion("map_real_width = ", value, "map_real_width");
              return (Criteria) this;
         }

         public Criteria andMapRealWidthNotEqualTo(String value)
         {
              addCriterion("map_real_width <> ", value, "map_real_width");
              return (Criteria) this;
         }

         public Criteria andMapRealWidthGreaterThan(String value)
         {
              addCriterion("map_real_width > ", value, "map_real_width");
              return (Criteria) this;
         }

         public Criteria andMapRealWidthGreaterThanOrEqualTo(String value)
         {
              addCriterion("map_real_width >= ", value, "map_real_width");
              return (Criteria) this;
         }

         public Criteria andMapRealWidthLessThan(String value)
         {
              addCriterion("map_real_width < ", value, "map_real_width");
              return (Criteria) this;
         }

         public Criteria andMapRealWidthLessThanOrEqualTo(String value)
         {
              addCriterion("map_real_width <= ", value, "map_real_width");
              return (Criteria) this;
         }

         public Criteria andMapRealWidthLike(String value)
         {
              addCriterion("map_real_width like ", value, "map_real_width");
              return (Criteria) this;
         }

         public Criteria andMapRealWidthNotLike(String value)
         {
              addCriterion("map_real_width not like ", value, "map_real_width");
              return (Criteria) this;
         }

         public Criteria andMapRealWidthIn(List<String> values)
         {
              addCriterion("map_real_width in ", values, "map_real_width");
              return (Criteria) this;
         }

         public Criteria andMapRealWidthNotIn(List<String> values)
         {
              addCriterion("map_real_width not in ", values, "map_real_width");
              return (Criteria) this;
         }

         public Criteria andMapRealWidthBetween(String value1, String value2)
         {
              addCriterion("map_real_width between ", value1,value2, "map_real_width");
              return (Criteria) this;
         }

         public Criteria andMapRealWidthNotBetween(String value1, String value2)
         {
              addCriterion("map_real_width not between ", value1,value2, "map_real_width");
              return (Criteria) this;
         }

         public Criteria andMapRealHeightIsNull()
         {
              addCriterion("map_real_height is null");
              return (Criteria) this;
         }

         public Criteria andMapRealHeightIsNotNull()
         {
              addCriterion("map_real_height is not null");
              return (Criteria) this;
         }

         public Criteria andMapRealHeightEqualTo(String value)
         {
              addCriterion("map_real_height = ", value, "map_real_height");
              return (Criteria) this;
         }

         public Criteria andMapRealHeightNotEqualTo(String value)
         {
              addCriterion("map_real_height <> ", value, "map_real_height");
              return (Criteria) this;
         }

         public Criteria andMapRealHeightGreaterThan(String value)
         {
              addCriterion("map_real_height > ", value, "map_real_height");
              return (Criteria) this;
         }

         public Criteria andMapRealHeightGreaterThanOrEqualTo(String value)
         {
              addCriterion("map_real_height >= ", value, "map_real_height");
              return (Criteria) this;
         }

         public Criteria andMapRealHeightLessThan(String value)
         {
              addCriterion("map_real_height < ", value, "map_real_height");
              return (Criteria) this;
         }

         public Criteria andMapRealHeightLessThanOrEqualTo(String value)
         {
              addCriterion("map_real_height <= ", value, "map_real_height");
              return (Criteria) this;
         }

         public Criteria andMapRealHeightLike(String value)
         {
              addCriterion("map_real_height like ", value, "map_real_height");
              return (Criteria) this;
         }

         public Criteria andMapRealHeightNotLike(String value)
         {
              addCriterion("map_real_height not like ", value, "map_real_height");
              return (Criteria) this;
         }

         public Criteria andMapRealHeightIn(List<String> values)
         {
              addCriterion("map_real_height in ", values, "map_real_height");
              return (Criteria) this;
         }

         public Criteria andMapRealHeightNotIn(List<String> values)
         {
              addCriterion("map_real_height not in ", values, "map_real_height");
              return (Criteria) this;
         }

         public Criteria andMapRealHeightBetween(String value1, String value2)
         {
              addCriterion("map_real_height between ", value1,value2, "map_real_height");
              return (Criteria) this;
         }

         public Criteria andMapRealHeightNotBetween(String value1, String value2)
         {
              addCriterion("map_real_height not between ", value1,value2, "map_real_height");
              return (Criteria) this;
         }

         public Criteria andRatioLocationIsNull()
         {
              addCriterion("ratio_location is null");
              return (Criteria) this;
         }

         public Criteria andRatioLocationIsNotNull()
         {
              addCriterion("ratio_location is not null");
              return (Criteria) this;
         }

         public Criteria andRatioLocationEqualTo(String value)
         {
              addCriterion("ratio_location = ", value, "ratio_location");
              return (Criteria) this;
         }

         public Criteria andRatioLocationNotEqualTo(String value)
         {
              addCriterion("ratio_location <> ", value, "ratio_location");
              return (Criteria) this;
         }

         public Criteria andRatioLocationGreaterThan(String value)
         {
              addCriterion("ratio_location > ", value, "ratio_location");
              return (Criteria) this;
         }

         public Criteria andRatioLocationGreaterThanOrEqualTo(String value)
         {
              addCriterion("ratio_location >= ", value, "ratio_location");
              return (Criteria) this;
         }

         public Criteria andRatioLocationLessThan(String value)
         {
              addCriterion("ratio_location < ", value, "ratio_location");
              return (Criteria) this;
         }

         public Criteria andRatioLocationLessThanOrEqualTo(String value)
         {
              addCriterion("ratio_location <= ", value, "ratio_location");
              return (Criteria) this;
         }

         public Criteria andRatioLocationLike(String value)
         {
              addCriterion("ratio_location like ", value, "ratio_location");
              return (Criteria) this;
         }

         public Criteria andRatioLocationNotLike(String value)
         {
              addCriterion("ratio_location not like ", value, "ratio_location");
              return (Criteria) this;
         }

         public Criteria andRatioLocationIn(List<String> values)
         {
              addCriterion("ratio_location in ", values, "ratio_location");
              return (Criteria) this;
         }

         public Criteria andRatioLocationNotIn(List<String> values)
         {
              addCriterion("ratio_location not in ", values, "ratio_location");
              return (Criteria) this;
         }

         public Criteria andRatioLocationBetween(String value1, String value2)
         {
              addCriterion("ratio_location between ", value1,value2, "ratio_location");
              return (Criteria) this;
         }

         public Criteria andRatioLocationNotBetween(String value1, String value2)
         {
              addCriterion("ratio_location not between ", value1,value2, "ratio_location");
              return (Criteria) this;
         }

         public Criteria andRatioGridIsNull()
         {
              addCriterion("ratio_grid is null");
              return (Criteria) this;
         }

         public Criteria andRatioGridIsNotNull()
         {
              addCriterion("ratio_grid is not null");
              return (Criteria) this;
         }

         public Criteria andRatioGridEqualTo(String value)
         {
              addCriterion("ratio_grid = ", value, "ratio_grid");
              return (Criteria) this;
         }

         public Criteria andRatioGridNotEqualTo(String value)
         {
              addCriterion("ratio_grid <> ", value, "ratio_grid");
              return (Criteria) this;
         }

         public Criteria andRatioGridGreaterThan(String value)
         {
              addCriterion("ratio_grid > ", value, "ratio_grid");
              return (Criteria) this;
         }

         public Criteria andRatioGridGreaterThanOrEqualTo(String value)
         {
              addCriterion("ratio_grid >= ", value, "ratio_grid");
              return (Criteria) this;
         }

         public Criteria andRatioGridLessThan(String value)
         {
              addCriterion("ratio_grid < ", value, "ratio_grid");
              return (Criteria) this;
         }

         public Criteria andRatioGridLessThanOrEqualTo(String value)
         {
              addCriterion("ratio_grid <= ", value, "ratio_grid");
              return (Criteria) this;
         }

         public Criteria andRatioGridLike(String value)
         {
              addCriterion("ratio_grid like ", value, "ratio_grid");
              return (Criteria) this;
         }

         public Criteria andRatioGridNotLike(String value)
         {
              addCriterion("ratio_grid not like ", value, "ratio_grid");
              return (Criteria) this;
         }

         public Criteria andRatioGridIn(List<String> values)
         {
              addCriterion("ratio_grid in ", values, "ratio_grid");
              return (Criteria) this;
         }

         public Criteria andRatioGridNotIn(List<String> values)
         {
              addCriterion("ratio_grid not in ", values, "ratio_grid");
              return (Criteria) this;
         }

         public Criteria andRatioGridBetween(String value1, String value2)
         {
              addCriterion("ratio_grid between ", value1,value2, "ratio_grid");
              return (Criteria) this;
         }

         public Criteria andRatioGridNotBetween(String value1, String value2)
         {
              addCriterion("ratio_grid not between ", value1,value2, "ratio_grid");
              return (Criteria) this;
         }

         public Criteria andRatioSvgIsNull()
         {
              addCriterion("ratio_svg is null");
              return (Criteria) this;
         }

         public Criteria andRatioSvgIsNotNull()
         {
              addCriterion("ratio_svg is not null");
              return (Criteria) this;
         }

         public Criteria andRatioSvgEqualTo(String value)
         {
              addCriterion("ratio_svg = ", value, "ratio_svg");
              return (Criteria) this;
         }

         public Criteria andRatioSvgNotEqualTo(String value)
         {
              addCriterion("ratio_svg <> ", value, "ratio_svg");
              return (Criteria) this;
         }

         public Criteria andRatioSvgGreaterThan(String value)
         {
              addCriterion("ratio_svg > ", value, "ratio_svg");
              return (Criteria) this;
         }

         public Criteria andRatioSvgGreaterThanOrEqualTo(String value)
         {
              addCriterion("ratio_svg >= ", value, "ratio_svg");
              return (Criteria) this;
         }

         public Criteria andRatioSvgLessThan(String value)
         {
              addCriterion("ratio_svg < ", value, "ratio_svg");
              return (Criteria) this;
         }

         public Criteria andRatioSvgLessThanOrEqualTo(String value)
         {
              addCriterion("ratio_svg <= ", value, "ratio_svg");
              return (Criteria) this;
         }

         public Criteria andRatioSvgLike(String value)
         {
              addCriterion("ratio_svg like ", value, "ratio_svg");
              return (Criteria) this;
         }

         public Criteria andRatioSvgNotLike(String value)
         {
              addCriterion("ratio_svg not like ", value, "ratio_svg");
              return (Criteria) this;
         }

         public Criteria andRatioSvgIn(List<String> values)
         {
              addCriterion("ratio_svg in ", values, "ratio_svg");
              return (Criteria) this;
         }

         public Criteria andRatioSvgNotIn(List<String> values)
         {
              addCriterion("ratio_svg not in ", values, "ratio_svg");
              return (Criteria) this;
         }

         public Criteria andRatioSvgBetween(String value1, String value2)
         {
              addCriterion("ratio_svg between ", value1,value2, "ratio_svg");
              return (Criteria) this;
         }

         public Criteria andRatioSvgNotBetween(String value1, String value2)
         {
              addCriterion("ratio_svg not between ", value1,value2, "ratio_svg");
              return (Criteria) this;
         }

         public Criteria andNoteIsNull()
         {
              addCriterion("note is null");
              return (Criteria) this;
         }

         public Criteria andNoteIsNotNull()
         {
              addCriterion("note is not null");
              return (Criteria) this;
         }

         public Criteria andNoteEqualTo(String value)
         {
              addCriterion("note = ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteNotEqualTo(String value)
         {
              addCriterion("note <> ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteGreaterThan(String value)
         {
              addCriterion("note > ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteGreaterThanOrEqualTo(String value)
         {
              addCriterion("note >= ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteLessThan(String value)
         {
              addCriterion("note < ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteLessThanOrEqualTo(String value)
         {
              addCriterion("note <= ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteLike(String value)
         {
              addCriterion("note like ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteNotLike(String value)
         {
              addCriterion("note not like ", value, "note");
              return (Criteria) this;
         }

         public Criteria andNoteIn(List<String> values)
         {
              addCriterion("note in ", values, "note");
              return (Criteria) this;
         }

         public Criteria andNoteNotIn(List<String> values)
         {
              addCriterion("note not in ", values, "note");
              return (Criteria) this;
         }

         public Criteria andNoteBetween(String value1, String value2)
         {
              addCriterion("note between ", value1,value2, "note");
              return (Criteria) this;
         }

         public Criteria andNoteNotBetween(String value1, String value2)
         {
              addCriterion("note not between ", value1,value2, "note");
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
