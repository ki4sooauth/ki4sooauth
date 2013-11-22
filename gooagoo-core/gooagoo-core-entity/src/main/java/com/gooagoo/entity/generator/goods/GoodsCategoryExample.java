package com.gooagoo.entity.generator.goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 品类信息，每个商家自行维护
 */

public class GoodsCategoryExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public GoodsCategoryExample()
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

         public Criteria andCategoryIdIsNull()
         {
              addCriterion("category_id is null");
              return (Criteria) this;
         }

         public Criteria andCategoryIdIsNotNull()
         {
              addCriterion("category_id is not null");
              return (Criteria) this;
         }

         public Criteria andCategoryIdEqualTo(String value)
         {
              addCriterion("category_id = ", value, "category_id");
              return (Criteria) this;
         }

         public Criteria andCategoryIdNotEqualTo(String value)
         {
              addCriterion("category_id <> ", value, "category_id");
              return (Criteria) this;
         }

         public Criteria andCategoryIdGreaterThan(String value)
         {
              addCriterion("category_id > ", value, "category_id");
              return (Criteria) this;
         }

         public Criteria andCategoryIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("category_id >= ", value, "category_id");
              return (Criteria) this;
         }

         public Criteria andCategoryIdLessThan(String value)
         {
              addCriterion("category_id < ", value, "category_id");
              return (Criteria) this;
         }

         public Criteria andCategoryIdLessThanOrEqualTo(String value)
         {
              addCriterion("category_id <= ", value, "category_id");
              return (Criteria) this;
         }

         public Criteria andCategoryIdLike(String value)
         {
              addCriterion("category_id like ", value, "category_id");
              return (Criteria) this;
         }

         public Criteria andCategoryIdNotLike(String value)
         {
              addCriterion("category_id not like ", value, "category_id");
              return (Criteria) this;
         }

         public Criteria andCategoryIdIn(List<String> values)
         {
              addCriterion("category_id in ", values, "category_id");
              return (Criteria) this;
         }

         public Criteria andCategoryIdNotIn(List<String> values)
         {
              addCriterion("category_id not in ", values, "category_id");
              return (Criteria) this;
         }

         public Criteria andCategoryIdBetween(String value1, String value2)
         {
              addCriterion("category_id between ", value1,value2, "category_id");
              return (Criteria) this;
         }

         public Criteria andCategoryIdNotBetween(String value1, String value2)
         {
              addCriterion("category_id not between ", value1,value2, "category_id");
              return (Criteria) this;
         }

         public Criteria andCategoryNameIsNull()
         {
              addCriterion("category_name is null");
              return (Criteria) this;
         }

         public Criteria andCategoryNameIsNotNull()
         {
              addCriterion("category_name is not null");
              return (Criteria) this;
         }

         public Criteria andCategoryNameEqualTo(String value)
         {
              addCriterion("category_name = ", value, "category_name");
              return (Criteria) this;
         }

         public Criteria andCategoryNameNotEqualTo(String value)
         {
              addCriterion("category_name <> ", value, "category_name");
              return (Criteria) this;
         }

         public Criteria andCategoryNameGreaterThan(String value)
         {
              addCriterion("category_name > ", value, "category_name");
              return (Criteria) this;
         }

         public Criteria andCategoryNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("category_name >= ", value, "category_name");
              return (Criteria) this;
         }

         public Criteria andCategoryNameLessThan(String value)
         {
              addCriterion("category_name < ", value, "category_name");
              return (Criteria) this;
         }

         public Criteria andCategoryNameLessThanOrEqualTo(String value)
         {
              addCriterion("category_name <= ", value, "category_name");
              return (Criteria) this;
         }

         public Criteria andCategoryNameLike(String value)
         {
              addCriterion("category_name like ", value, "category_name");
              return (Criteria) this;
         }

         public Criteria andCategoryNameNotLike(String value)
         {
              addCriterion("category_name not like ", value, "category_name");
              return (Criteria) this;
         }

         public Criteria andCategoryNameIn(List<String> values)
         {
              addCriterion("category_name in ", values, "category_name");
              return (Criteria) this;
         }

         public Criteria andCategoryNameNotIn(List<String> values)
         {
              addCriterion("category_name not in ", values, "category_name");
              return (Criteria) this;
         }

         public Criteria andCategoryNameBetween(String value1, String value2)
         {
              addCriterion("category_name between ", value1,value2, "category_name");
              return (Criteria) this;
         }

         public Criteria andCategoryNameNotBetween(String value1, String value2)
         {
              addCriterion("category_name not between ", value1,value2, "category_name");
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

         public Criteria andParentCategoryIdIsNull()
         {
              addCriterion("parent_category_id is null");
              return (Criteria) this;
         }

         public Criteria andParentCategoryIdIsNotNull()
         {
              addCriterion("parent_category_id is not null");
              return (Criteria) this;
         }

         public Criteria andParentCategoryIdEqualTo(String value)
         {
              addCriterion("parent_category_id = ", value, "parent_category_id");
              return (Criteria) this;
         }

         public Criteria andParentCategoryIdNotEqualTo(String value)
         {
              addCriterion("parent_category_id <> ", value, "parent_category_id");
              return (Criteria) this;
         }

         public Criteria andParentCategoryIdGreaterThan(String value)
         {
              addCriterion("parent_category_id > ", value, "parent_category_id");
              return (Criteria) this;
         }

         public Criteria andParentCategoryIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("parent_category_id >= ", value, "parent_category_id");
              return (Criteria) this;
         }

         public Criteria andParentCategoryIdLessThan(String value)
         {
              addCriterion("parent_category_id < ", value, "parent_category_id");
              return (Criteria) this;
         }

         public Criteria andParentCategoryIdLessThanOrEqualTo(String value)
         {
              addCriterion("parent_category_id <= ", value, "parent_category_id");
              return (Criteria) this;
         }

         public Criteria andParentCategoryIdLike(String value)
         {
              addCriterion("parent_category_id like ", value, "parent_category_id");
              return (Criteria) this;
         }

         public Criteria andParentCategoryIdNotLike(String value)
         {
              addCriterion("parent_category_id not like ", value, "parent_category_id");
              return (Criteria) this;
         }

         public Criteria andParentCategoryIdIn(List<String> values)
         {
              addCriterion("parent_category_id in ", values, "parent_category_id");
              return (Criteria) this;
         }

         public Criteria andParentCategoryIdNotIn(List<String> values)
         {
              addCriterion("parent_category_id not in ", values, "parent_category_id");
              return (Criteria) this;
         }

         public Criteria andParentCategoryIdBetween(String value1, String value2)
         {
              addCriterion("parent_category_id between ", value1,value2, "parent_category_id");
              return (Criteria) this;
         }

         public Criteria andParentCategoryIdNotBetween(String value1, String value2)
         {
              addCriterion("parent_category_id not between ", value1,value2, "parent_category_id");
              return (Criteria) this;
         }

         public Criteria andPicUrlIsNull()
         {
              addCriterion("pic_url is null");
              return (Criteria) this;
         }

         public Criteria andPicUrlIsNotNull()
         {
              addCriterion("pic_url is not null");
              return (Criteria) this;
         }

         public Criteria andPicUrlEqualTo(String value)
         {
              addCriterion("pic_url = ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlNotEqualTo(String value)
         {
              addCriterion("pic_url <> ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlGreaterThan(String value)
         {
              addCriterion("pic_url > ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlGreaterThanOrEqualTo(String value)
         {
              addCriterion("pic_url >= ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlLessThan(String value)
         {
              addCriterion("pic_url < ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlLessThanOrEqualTo(String value)
         {
              addCriterion("pic_url <= ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlLike(String value)
         {
              addCriterion("pic_url like ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlNotLike(String value)
         {
              addCriterion("pic_url not like ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlIn(List<String> values)
         {
              addCriterion("pic_url in ", values, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlNotIn(List<String> values)
         {
              addCriterion("pic_url not in ", values, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlBetween(String value1, String value2)
         {
              addCriterion("pic_url between ", value1,value2, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlNotBetween(String value1, String value2)
         {
              addCriterion("pic_url not between ", value1,value2, "pic_url");
              return (Criteria) this;
         }

         public Criteria andSortIsNull()
         {
              addCriterion("sort is null");
              return (Criteria) this;
         }

         public Criteria andSortIsNotNull()
         {
              addCriterion("sort is not null");
              return (Criteria) this;
         }

         public Criteria andSortEqualTo(String value)
         {
              addCriterion("sort = ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortNotEqualTo(String value)
         {
              addCriterion("sort <> ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortGreaterThan(String value)
         {
              addCriterion("sort > ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortGreaterThanOrEqualTo(String value)
         {
              addCriterion("sort >= ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortLessThan(String value)
         {
              addCriterion("sort < ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortLessThanOrEqualTo(String value)
         {
              addCriterion("sort <= ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortLike(String value)
         {
              addCriterion("sort like ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortNotLike(String value)
         {
              addCriterion("sort not like ", value, "sort");
              return (Criteria) this;
         }

         public Criteria andSortIn(List<String> values)
         {
              addCriterion("sort in ", values, "sort");
              return (Criteria) this;
         }

         public Criteria andSortNotIn(List<String> values)
         {
              addCriterion("sort not in ", values, "sort");
              return (Criteria) this;
         }

         public Criteria andSortBetween(String value1, String value2)
         {
              addCriterion("sort between ", value1,value2, "sort");
              return (Criteria) this;
         }

         public Criteria andSortNotBetween(String value1, String value2)
         {
              addCriterion("sort not between ", value1,value2, "sort");
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
