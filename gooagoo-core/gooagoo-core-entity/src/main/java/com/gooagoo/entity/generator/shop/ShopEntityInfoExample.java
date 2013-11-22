package com.gooagoo.entity.generator.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 实体店基本信息
 */

public class ShopEntityInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopEntityInfoExample()
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

         public Criteria andShopEntityNameIsNull()
         {
              addCriterion("shop_entity_name is null");
              return (Criteria) this;
         }

         public Criteria andShopEntityNameIsNotNull()
         {
              addCriterion("shop_entity_name is not null");
              return (Criteria) this;
         }

         public Criteria andShopEntityNameEqualTo(String value)
         {
              addCriterion("shop_entity_name = ", value, "shop_entity_name");
              return (Criteria) this;
         }

         public Criteria andShopEntityNameNotEqualTo(String value)
         {
              addCriterion("shop_entity_name <> ", value, "shop_entity_name");
              return (Criteria) this;
         }

         public Criteria andShopEntityNameGreaterThan(String value)
         {
              addCriterion("shop_entity_name > ", value, "shop_entity_name");
              return (Criteria) this;
         }

         public Criteria andShopEntityNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_entity_name >= ", value, "shop_entity_name");
              return (Criteria) this;
         }

         public Criteria andShopEntityNameLessThan(String value)
         {
              addCriterion("shop_entity_name < ", value, "shop_entity_name");
              return (Criteria) this;
         }

         public Criteria andShopEntityNameLessThanOrEqualTo(String value)
         {
              addCriterion("shop_entity_name <= ", value, "shop_entity_name");
              return (Criteria) this;
         }

         public Criteria andShopEntityNameLike(String value)
         {
              addCriterion("shop_entity_name like ", value, "shop_entity_name");
              return (Criteria) this;
         }

         public Criteria andShopEntityNameNotLike(String value)
         {
              addCriterion("shop_entity_name not like ", value, "shop_entity_name");
              return (Criteria) this;
         }

         public Criteria andShopEntityNameIn(List<String> values)
         {
              addCriterion("shop_entity_name in ", values, "shop_entity_name");
              return (Criteria) this;
         }

         public Criteria andShopEntityNameNotIn(List<String> values)
         {
              addCriterion("shop_entity_name not in ", values, "shop_entity_name");
              return (Criteria) this;
         }

         public Criteria andShopEntityNameBetween(String value1, String value2)
         {
              addCriterion("shop_entity_name between ", value1,value2, "shop_entity_name");
              return (Criteria) this;
         }

         public Criteria andShopEntityNameNotBetween(String value1, String value2)
         {
              addCriterion("shop_entity_name not between ", value1,value2, "shop_entity_name");
              return (Criteria) this;
         }

         public Criteria andIsGeneralIsNull()
         {
              addCriterion("is_general is null");
              return (Criteria) this;
         }

         public Criteria andIsGeneralIsNotNull()
         {
              addCriterion("is_general is not null");
              return (Criteria) this;
         }

         public Criteria andIsGeneralEqualTo(String value)
         {
              addCriterion("is_general = ", value, "is_general");
              return (Criteria) this;
         }

         public Criteria andIsGeneralNotEqualTo(String value)
         {
              addCriterion("is_general <> ", value, "is_general");
              return (Criteria) this;
         }

         public Criteria andIsGeneralGreaterThan(String value)
         {
              addCriterion("is_general > ", value, "is_general");
              return (Criteria) this;
         }

         public Criteria andIsGeneralGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_general >= ", value, "is_general");
              return (Criteria) this;
         }

         public Criteria andIsGeneralLessThan(String value)
         {
              addCriterion("is_general < ", value, "is_general");
              return (Criteria) this;
         }

         public Criteria andIsGeneralLessThanOrEqualTo(String value)
         {
              addCriterion("is_general <= ", value, "is_general");
              return (Criteria) this;
         }

         public Criteria andIsGeneralLike(String value)
         {
              addCriterion("is_general like ", value, "is_general");
              return (Criteria) this;
         }

         public Criteria andIsGeneralNotLike(String value)
         {
              addCriterion("is_general not like ", value, "is_general");
              return (Criteria) this;
         }

         public Criteria andIsGeneralIn(List<String> values)
         {
              addCriterion("is_general in ", values, "is_general");
              return (Criteria) this;
         }

         public Criteria andIsGeneralNotIn(List<String> values)
         {
              addCriterion("is_general not in ", values, "is_general");
              return (Criteria) this;
         }

         public Criteria andIsGeneralBetween(String value1, String value2)
         {
              addCriterion("is_general between ", value1,value2, "is_general");
              return (Criteria) this;
         }

         public Criteria andIsGeneralNotBetween(String value1, String value2)
         {
              addCriterion("is_general not between ", value1,value2, "is_general");
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

         public Criteria andTradeAreaIdIsNull()
         {
              addCriterion("trade_area_id is null");
              return (Criteria) this;
         }

         public Criteria andTradeAreaIdIsNotNull()
         {
              addCriterion("trade_area_id is not null");
              return (Criteria) this;
         }

         public Criteria andTradeAreaIdEqualTo(String value)
         {
              addCriterion("trade_area_id = ", value, "trade_area_id");
              return (Criteria) this;
         }

         public Criteria andTradeAreaIdNotEqualTo(String value)
         {
              addCriterion("trade_area_id <> ", value, "trade_area_id");
              return (Criteria) this;
         }

         public Criteria andTradeAreaIdGreaterThan(String value)
         {
              addCriterion("trade_area_id > ", value, "trade_area_id");
              return (Criteria) this;
         }

         public Criteria andTradeAreaIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("trade_area_id >= ", value, "trade_area_id");
              return (Criteria) this;
         }

         public Criteria andTradeAreaIdLessThan(String value)
         {
              addCriterion("trade_area_id < ", value, "trade_area_id");
              return (Criteria) this;
         }

         public Criteria andTradeAreaIdLessThanOrEqualTo(String value)
         {
              addCriterion("trade_area_id <= ", value, "trade_area_id");
              return (Criteria) this;
         }

         public Criteria andTradeAreaIdLike(String value)
         {
              addCriterion("trade_area_id like ", value, "trade_area_id");
              return (Criteria) this;
         }

         public Criteria andTradeAreaIdNotLike(String value)
         {
              addCriterion("trade_area_id not like ", value, "trade_area_id");
              return (Criteria) this;
         }

         public Criteria andTradeAreaIdIn(List<String> values)
         {
              addCriterion("trade_area_id in ", values, "trade_area_id");
              return (Criteria) this;
         }

         public Criteria andTradeAreaIdNotIn(List<String> values)
         {
              addCriterion("trade_area_id not in ", values, "trade_area_id");
              return (Criteria) this;
         }

         public Criteria andTradeAreaIdBetween(String value1, String value2)
         {
              addCriterion("trade_area_id between ", value1,value2, "trade_area_id");
              return (Criteria) this;
         }

         public Criteria andTradeAreaIdNotBetween(String value1, String value2)
         {
              addCriterion("trade_area_id not between ", value1,value2, "trade_area_id");
              return (Criteria) this;
         }

         public Criteria andRegisteredNumberIsNull()
         {
              addCriterion("registered_number is null");
              return (Criteria) this;
         }

         public Criteria andRegisteredNumberIsNotNull()
         {
              addCriterion("registered_number is not null");
              return (Criteria) this;
         }

         public Criteria andRegisteredNumberEqualTo(String value)
         {
              addCriterion("registered_number = ", value, "registered_number");
              return (Criteria) this;
         }

         public Criteria andRegisteredNumberNotEqualTo(String value)
         {
              addCriterion("registered_number <> ", value, "registered_number");
              return (Criteria) this;
         }

         public Criteria andRegisteredNumberGreaterThan(String value)
         {
              addCriterion("registered_number > ", value, "registered_number");
              return (Criteria) this;
         }

         public Criteria andRegisteredNumberGreaterThanOrEqualTo(String value)
         {
              addCriterion("registered_number >= ", value, "registered_number");
              return (Criteria) this;
         }

         public Criteria andRegisteredNumberLessThan(String value)
         {
              addCriterion("registered_number < ", value, "registered_number");
              return (Criteria) this;
         }

         public Criteria andRegisteredNumberLessThanOrEqualTo(String value)
         {
              addCriterion("registered_number <= ", value, "registered_number");
              return (Criteria) this;
         }

         public Criteria andRegisteredNumberLike(String value)
         {
              addCriterion("registered_number like ", value, "registered_number");
              return (Criteria) this;
         }

         public Criteria andRegisteredNumberNotLike(String value)
         {
              addCriterion("registered_number not like ", value, "registered_number");
              return (Criteria) this;
         }

         public Criteria andRegisteredNumberIn(List<String> values)
         {
              addCriterion("registered_number in ", values, "registered_number");
              return (Criteria) this;
         }

         public Criteria andRegisteredNumberNotIn(List<String> values)
         {
              addCriterion("registered_number not in ", values, "registered_number");
              return (Criteria) this;
         }

         public Criteria andRegisteredNumberBetween(String value1, String value2)
         {
              addCriterion("registered_number between ", value1,value2, "registered_number");
              return (Criteria) this;
         }

         public Criteria andRegisteredNumberNotBetween(String value1, String value2)
         {
              addCriterion("registered_number not between ", value1,value2, "registered_number");
              return (Criteria) this;
         }

         public Criteria andClassificationCodeIsNull()
         {
              addCriterion("classification_code is null");
              return (Criteria) this;
         }

         public Criteria andClassificationCodeIsNotNull()
         {
              addCriterion("classification_code is not null");
              return (Criteria) this;
         }

         public Criteria andClassificationCodeEqualTo(String value)
         {
              addCriterion("classification_code = ", value, "classification_code");
              return (Criteria) this;
         }

         public Criteria andClassificationCodeNotEqualTo(String value)
         {
              addCriterion("classification_code <> ", value, "classification_code");
              return (Criteria) this;
         }

         public Criteria andClassificationCodeGreaterThan(String value)
         {
              addCriterion("classification_code > ", value, "classification_code");
              return (Criteria) this;
         }

         public Criteria andClassificationCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("classification_code >= ", value, "classification_code");
              return (Criteria) this;
         }

         public Criteria andClassificationCodeLessThan(String value)
         {
              addCriterion("classification_code < ", value, "classification_code");
              return (Criteria) this;
         }

         public Criteria andClassificationCodeLessThanOrEqualTo(String value)
         {
              addCriterion("classification_code <= ", value, "classification_code");
              return (Criteria) this;
         }

         public Criteria andClassificationCodeLike(String value)
         {
              addCriterion("classification_code like ", value, "classification_code");
              return (Criteria) this;
         }

         public Criteria andClassificationCodeNotLike(String value)
         {
              addCriterion("classification_code not like ", value, "classification_code");
              return (Criteria) this;
         }

         public Criteria andClassificationCodeIn(List<String> values)
         {
              addCriterion("classification_code in ", values, "classification_code");
              return (Criteria) this;
         }

         public Criteria andClassificationCodeNotIn(List<String> values)
         {
              addCriterion("classification_code not in ", values, "classification_code");
              return (Criteria) this;
         }

         public Criteria andClassificationCodeBetween(String value1, String value2)
         {
              addCriterion("classification_code between ", value1,value2, "classification_code");
              return (Criteria) this;
         }

         public Criteria andClassificationCodeNotBetween(String value1, String value2)
         {
              addCriterion("classification_code not between ", value1,value2, "classification_code");
              return (Criteria) this;
         }

         public Criteria andOrganizationCodeIsNull()
         {
              addCriterion("organization_code is null");
              return (Criteria) this;
         }

         public Criteria andOrganizationCodeIsNotNull()
         {
              addCriterion("organization_code is not null");
              return (Criteria) this;
         }

         public Criteria andOrganizationCodeEqualTo(String value)
         {
              addCriterion("organization_code = ", value, "organization_code");
              return (Criteria) this;
         }

         public Criteria andOrganizationCodeNotEqualTo(String value)
         {
              addCriterion("organization_code <> ", value, "organization_code");
              return (Criteria) this;
         }

         public Criteria andOrganizationCodeGreaterThan(String value)
         {
              addCriterion("organization_code > ", value, "organization_code");
              return (Criteria) this;
         }

         public Criteria andOrganizationCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("organization_code >= ", value, "organization_code");
              return (Criteria) this;
         }

         public Criteria andOrganizationCodeLessThan(String value)
         {
              addCriterion("organization_code < ", value, "organization_code");
              return (Criteria) this;
         }

         public Criteria andOrganizationCodeLessThanOrEqualTo(String value)
         {
              addCriterion("organization_code <= ", value, "organization_code");
              return (Criteria) this;
         }

         public Criteria andOrganizationCodeLike(String value)
         {
              addCriterion("organization_code like ", value, "organization_code");
              return (Criteria) this;
         }

         public Criteria andOrganizationCodeNotLike(String value)
         {
              addCriterion("organization_code not like ", value, "organization_code");
              return (Criteria) this;
         }

         public Criteria andOrganizationCodeIn(List<String> values)
         {
              addCriterion("organization_code in ", values, "organization_code");
              return (Criteria) this;
         }

         public Criteria andOrganizationCodeNotIn(List<String> values)
         {
              addCriterion("organization_code not in ", values, "organization_code");
              return (Criteria) this;
         }

         public Criteria andOrganizationCodeBetween(String value1, String value2)
         {
              addCriterion("organization_code between ", value1,value2, "organization_code");
              return (Criteria) this;
         }

         public Criteria andOrganizationCodeNotBetween(String value1, String value2)
         {
              addCriterion("organization_code not between ", value1,value2, "organization_code");
              return (Criteria) this;
         }

         public Criteria andEnterpriseNameIsNull()
         {
              addCriterion("enterprise_name is null");
              return (Criteria) this;
         }

         public Criteria andEnterpriseNameIsNotNull()
         {
              addCriterion("enterprise_name is not null");
              return (Criteria) this;
         }

         public Criteria andEnterpriseNameEqualTo(String value)
         {
              addCriterion("enterprise_name = ", value, "enterprise_name");
              return (Criteria) this;
         }

         public Criteria andEnterpriseNameNotEqualTo(String value)
         {
              addCriterion("enterprise_name <> ", value, "enterprise_name");
              return (Criteria) this;
         }

         public Criteria andEnterpriseNameGreaterThan(String value)
         {
              addCriterion("enterprise_name > ", value, "enterprise_name");
              return (Criteria) this;
         }

         public Criteria andEnterpriseNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("enterprise_name >= ", value, "enterprise_name");
              return (Criteria) this;
         }

         public Criteria andEnterpriseNameLessThan(String value)
         {
              addCriterion("enterprise_name < ", value, "enterprise_name");
              return (Criteria) this;
         }

         public Criteria andEnterpriseNameLessThanOrEqualTo(String value)
         {
              addCriterion("enterprise_name <= ", value, "enterprise_name");
              return (Criteria) this;
         }

         public Criteria andEnterpriseNameLike(String value)
         {
              addCriterion("enterprise_name like ", value, "enterprise_name");
              return (Criteria) this;
         }

         public Criteria andEnterpriseNameNotLike(String value)
         {
              addCriterion("enterprise_name not like ", value, "enterprise_name");
              return (Criteria) this;
         }

         public Criteria andEnterpriseNameIn(List<String> values)
         {
              addCriterion("enterprise_name in ", values, "enterprise_name");
              return (Criteria) this;
         }

         public Criteria andEnterpriseNameNotIn(List<String> values)
         {
              addCriterion("enterprise_name not in ", values, "enterprise_name");
              return (Criteria) this;
         }

         public Criteria andEnterpriseNameBetween(String value1, String value2)
         {
              addCriterion("enterprise_name between ", value1,value2, "enterprise_name");
              return (Criteria) this;
         }

         public Criteria andEnterpriseNameNotBetween(String value1, String value2)
         {
              addCriterion("enterprise_name not between ", value1,value2, "enterprise_name");
              return (Criteria) this;
         }

         public Criteria andRegisteredCityIsNull()
         {
              addCriterion("registered_city is null");
              return (Criteria) this;
         }

         public Criteria andRegisteredCityIsNotNull()
         {
              addCriterion("registered_city is not null");
              return (Criteria) this;
         }

         public Criteria andRegisteredCityEqualTo(String value)
         {
              addCriterion("registered_city = ", value, "registered_city");
              return (Criteria) this;
         }

         public Criteria andRegisteredCityNotEqualTo(String value)
         {
              addCriterion("registered_city <> ", value, "registered_city");
              return (Criteria) this;
         }

         public Criteria andRegisteredCityGreaterThan(String value)
         {
              addCriterion("registered_city > ", value, "registered_city");
              return (Criteria) this;
         }

         public Criteria andRegisteredCityGreaterThanOrEqualTo(String value)
         {
              addCriterion("registered_city >= ", value, "registered_city");
              return (Criteria) this;
         }

         public Criteria andRegisteredCityLessThan(String value)
         {
              addCriterion("registered_city < ", value, "registered_city");
              return (Criteria) this;
         }

         public Criteria andRegisteredCityLessThanOrEqualTo(String value)
         {
              addCriterion("registered_city <= ", value, "registered_city");
              return (Criteria) this;
         }

         public Criteria andRegisteredCityLike(String value)
         {
              addCriterion("registered_city like ", value, "registered_city");
              return (Criteria) this;
         }

         public Criteria andRegisteredCityNotLike(String value)
         {
              addCriterion("registered_city not like ", value, "registered_city");
              return (Criteria) this;
         }

         public Criteria andRegisteredCityIn(List<String> values)
         {
              addCriterion("registered_city in ", values, "registered_city");
              return (Criteria) this;
         }

         public Criteria andRegisteredCityNotIn(List<String> values)
         {
              addCriterion("registered_city not in ", values, "registered_city");
              return (Criteria) this;
         }

         public Criteria andRegisteredCityBetween(String value1, String value2)
         {
              addCriterion("registered_city between ", value1,value2, "registered_city");
              return (Criteria) this;
         }

         public Criteria andRegisteredCityNotBetween(String value1, String value2)
         {
              addCriterion("registered_city not between ", value1,value2, "registered_city");
              return (Criteria) this;
         }

         public Criteria andCorporateIsNull()
         {
              addCriterion("corporate is null");
              return (Criteria) this;
         }

         public Criteria andCorporateIsNotNull()
         {
              addCriterion("corporate is not null");
              return (Criteria) this;
         }

         public Criteria andCorporateEqualTo(String value)
         {
              addCriterion("corporate = ", value, "corporate");
              return (Criteria) this;
         }

         public Criteria andCorporateNotEqualTo(String value)
         {
              addCriterion("corporate <> ", value, "corporate");
              return (Criteria) this;
         }

         public Criteria andCorporateGreaterThan(String value)
         {
              addCriterion("corporate > ", value, "corporate");
              return (Criteria) this;
         }

         public Criteria andCorporateGreaterThanOrEqualTo(String value)
         {
              addCriterion("corporate >= ", value, "corporate");
              return (Criteria) this;
         }

         public Criteria andCorporateLessThan(String value)
         {
              addCriterion("corporate < ", value, "corporate");
              return (Criteria) this;
         }

         public Criteria andCorporateLessThanOrEqualTo(String value)
         {
              addCriterion("corporate <= ", value, "corporate");
              return (Criteria) this;
         }

         public Criteria andCorporateLike(String value)
         {
              addCriterion("corporate like ", value, "corporate");
              return (Criteria) this;
         }

         public Criteria andCorporateNotLike(String value)
         {
              addCriterion("corporate not like ", value, "corporate");
              return (Criteria) this;
         }

         public Criteria andCorporateIn(List<String> values)
         {
              addCriterion("corporate in ", values, "corporate");
              return (Criteria) this;
         }

         public Criteria andCorporateNotIn(List<String> values)
         {
              addCriterion("corporate not in ", values, "corporate");
              return (Criteria) this;
         }

         public Criteria andCorporateBetween(String value1, String value2)
         {
              addCriterion("corporate between ", value1,value2, "corporate");
              return (Criteria) this;
         }

         public Criteria andCorporateNotBetween(String value1, String value2)
         {
              addCriterion("corporate not between ", value1,value2, "corporate");
              return (Criteria) this;
         }

         public Criteria andRegisteredCapitalIsNull()
         {
              addCriterion("registered_capital is null");
              return (Criteria) this;
         }

         public Criteria andRegisteredCapitalIsNotNull()
         {
              addCriterion("registered_capital is not null");
              return (Criteria) this;
         }

         public Criteria andRegisteredCapitalEqualTo(String value)
         {
              addCriterion("registered_capital = ", value, "registered_capital");
              return (Criteria) this;
         }

         public Criteria andRegisteredCapitalNotEqualTo(String value)
         {
              addCriterion("registered_capital <> ", value, "registered_capital");
              return (Criteria) this;
         }

         public Criteria andRegisteredCapitalGreaterThan(String value)
         {
              addCriterion("registered_capital > ", value, "registered_capital");
              return (Criteria) this;
         }

         public Criteria andRegisteredCapitalGreaterThanOrEqualTo(String value)
         {
              addCriterion("registered_capital >= ", value, "registered_capital");
              return (Criteria) this;
         }

         public Criteria andRegisteredCapitalLessThan(String value)
         {
              addCriterion("registered_capital < ", value, "registered_capital");
              return (Criteria) this;
         }

         public Criteria andRegisteredCapitalLessThanOrEqualTo(String value)
         {
              addCriterion("registered_capital <= ", value, "registered_capital");
              return (Criteria) this;
         }

         public Criteria andRegisteredCapitalLike(String value)
         {
              addCriterion("registered_capital like ", value, "registered_capital");
              return (Criteria) this;
         }

         public Criteria andRegisteredCapitalNotLike(String value)
         {
              addCriterion("registered_capital not like ", value, "registered_capital");
              return (Criteria) this;
         }

         public Criteria andRegisteredCapitalIn(List<String> values)
         {
              addCriterion("registered_capital in ", values, "registered_capital");
              return (Criteria) this;
         }

         public Criteria andRegisteredCapitalNotIn(List<String> values)
         {
              addCriterion("registered_capital not in ", values, "registered_capital");
              return (Criteria) this;
         }

         public Criteria andRegisteredCapitalBetween(String value1, String value2)
         {
              addCriterion("registered_capital between ", value1,value2, "registered_capital");
              return (Criteria) this;
         }

         public Criteria andRegisteredCapitalNotBetween(String value1, String value2)
         {
              addCriterion("registered_capital not between ", value1,value2, "registered_capital");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedStartTimeIsNull()
         {
              addCriterion("busniss_aloted_start_time is null");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedStartTimeIsNotNull()
         {
              addCriterion("busniss_aloted_start_time is not null");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedStartTimeEqualTo(Date value)
         {
              addCriterion("busniss_aloted_start_time = ", value, "busniss_aloted_start_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedStartTimeNotEqualTo(Date value)
         {
              addCriterion("busniss_aloted_start_time <> ", value, "busniss_aloted_start_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedStartTimeGreaterThan(Date value)
         {
              addCriterion("busniss_aloted_start_time > ", value, "busniss_aloted_start_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedStartTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("busniss_aloted_start_time >= ", value, "busniss_aloted_start_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedStartTimeLessThan(Date value)
         {
              addCriterion("busniss_aloted_start_time < ", value, "busniss_aloted_start_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedStartTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("busniss_aloted_start_time <= ", value, "busniss_aloted_start_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedStartTimeIn(List<Date> values)
         {
              addCriterion("busniss_aloted_start_time in ", values, "busniss_aloted_start_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedStartTimeNotIn(List<Date> values)
         {
              addCriterion("busniss_aloted_start_time not in ", values, "busniss_aloted_start_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedStartTimeBetween(Date value1, Date value2)
         {
              addCriterion("busniss_aloted_start_time between ", value1,value2, "busniss_aloted_start_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedStartTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("busniss_aloted_start_time not between ", value1,value2, "busniss_aloted_start_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedEndTimeIsNull()
         {
              addCriterion("busniss_aloted_end_time is null");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedEndTimeIsNotNull()
         {
              addCriterion("busniss_aloted_end_time is not null");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedEndTimeEqualTo(Date value)
         {
              addCriterion("busniss_aloted_end_time = ", value, "busniss_aloted_end_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedEndTimeNotEqualTo(Date value)
         {
              addCriterion("busniss_aloted_end_time <> ", value, "busniss_aloted_end_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedEndTimeGreaterThan(Date value)
         {
              addCriterion("busniss_aloted_end_time > ", value, "busniss_aloted_end_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedEndTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("busniss_aloted_end_time >= ", value, "busniss_aloted_end_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedEndTimeLessThan(Date value)
         {
              addCriterion("busniss_aloted_end_time < ", value, "busniss_aloted_end_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedEndTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("busniss_aloted_end_time <= ", value, "busniss_aloted_end_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedEndTimeIn(List<Date> values)
         {
              addCriterion("busniss_aloted_end_time in ", values, "busniss_aloted_end_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedEndTimeNotIn(List<Date> values)
         {
              addCriterion("busniss_aloted_end_time not in ", values, "busniss_aloted_end_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedEndTimeBetween(Date value1, Date value2)
         {
              addCriterion("busniss_aloted_end_time between ", value1,value2, "busniss_aloted_end_time");
              return (Criteria) this;
         }

         public Criteria andBusnissAlotedEndTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("busniss_aloted_end_time not between ", value1,value2, "busniss_aloted_end_time");
              return (Criteria) this;
         }

         public Criteria andBusinessLicenseIsNull()
         {
              addCriterion("business_license is null");
              return (Criteria) this;
         }

         public Criteria andBusinessLicenseIsNotNull()
         {
              addCriterion("business_license is not null");
              return (Criteria) this;
         }

         public Criteria andBusinessLicenseEqualTo(String value)
         {
              addCriterion("business_license = ", value, "business_license");
              return (Criteria) this;
         }

         public Criteria andBusinessLicenseNotEqualTo(String value)
         {
              addCriterion("business_license <> ", value, "business_license");
              return (Criteria) this;
         }

         public Criteria andBusinessLicenseGreaterThan(String value)
         {
              addCriterion("business_license > ", value, "business_license");
              return (Criteria) this;
         }

         public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value)
         {
              addCriterion("business_license >= ", value, "business_license");
              return (Criteria) this;
         }

         public Criteria andBusinessLicenseLessThan(String value)
         {
              addCriterion("business_license < ", value, "business_license");
              return (Criteria) this;
         }

         public Criteria andBusinessLicenseLessThanOrEqualTo(String value)
         {
              addCriterion("business_license <= ", value, "business_license");
              return (Criteria) this;
         }

         public Criteria andBusinessLicenseLike(String value)
         {
              addCriterion("business_license like ", value, "business_license");
              return (Criteria) this;
         }

         public Criteria andBusinessLicenseNotLike(String value)
         {
              addCriterion("business_license not like ", value, "business_license");
              return (Criteria) this;
         }

         public Criteria andBusinessLicenseIn(List<String> values)
         {
              addCriterion("business_license in ", values, "business_license");
              return (Criteria) this;
         }

         public Criteria andBusinessLicenseNotIn(List<String> values)
         {
              addCriterion("business_license not in ", values, "business_license");
              return (Criteria) this;
         }

         public Criteria andBusinessLicenseBetween(String value1, String value2)
         {
              addCriterion("business_license between ", value1,value2, "business_license");
              return (Criteria) this;
         }

         public Criteria andBusinessLicenseNotBetween(String value1, String value2)
         {
              addCriterion("business_license not between ", value1,value2, "business_license");
              return (Criteria) this;
         }

         public Criteria andInvoiceExpireIsNull()
         {
              addCriterion("invoice_expire is null");
              return (Criteria) this;
         }

         public Criteria andInvoiceExpireIsNotNull()
         {
              addCriterion("invoice_expire is not null");
              return (Criteria) this;
         }

         public Criteria andInvoiceExpireEqualTo(String value)
         {
              addCriterion("invoice_expire = ", value, "invoice_expire");
              return (Criteria) this;
         }

         public Criteria andInvoiceExpireNotEqualTo(String value)
         {
              addCriterion("invoice_expire <> ", value, "invoice_expire");
              return (Criteria) this;
         }

         public Criteria andInvoiceExpireGreaterThan(String value)
         {
              addCriterion("invoice_expire > ", value, "invoice_expire");
              return (Criteria) this;
         }

         public Criteria andInvoiceExpireGreaterThanOrEqualTo(String value)
         {
              addCriterion("invoice_expire >= ", value, "invoice_expire");
              return (Criteria) this;
         }

         public Criteria andInvoiceExpireLessThan(String value)
         {
              addCriterion("invoice_expire < ", value, "invoice_expire");
              return (Criteria) this;
         }

         public Criteria andInvoiceExpireLessThanOrEqualTo(String value)
         {
              addCriterion("invoice_expire <= ", value, "invoice_expire");
              return (Criteria) this;
         }

         public Criteria andInvoiceExpireLike(String value)
         {
              addCriterion("invoice_expire like ", value, "invoice_expire");
              return (Criteria) this;
         }

         public Criteria andInvoiceExpireNotLike(String value)
         {
              addCriterion("invoice_expire not like ", value, "invoice_expire");
              return (Criteria) this;
         }

         public Criteria andInvoiceExpireIn(List<String> values)
         {
              addCriterion("invoice_expire in ", values, "invoice_expire");
              return (Criteria) this;
         }

         public Criteria andInvoiceExpireNotIn(List<String> values)
         {
              addCriterion("invoice_expire not in ", values, "invoice_expire");
              return (Criteria) this;
         }

         public Criteria andInvoiceExpireBetween(String value1, String value2)
         {
              addCriterion("invoice_expire between ", value1,value2, "invoice_expire");
              return (Criteria) this;
         }

         public Criteria andInvoiceExpireNotBetween(String value1, String value2)
         {
              addCriterion("invoice_expire not between ", value1,value2, "invoice_expire");
              return (Criteria) this;
         }

         public Criteria andOpenTimeIsNull()
         {
              addCriterion("open_time is null");
              return (Criteria) this;
         }

         public Criteria andOpenTimeIsNotNull()
         {
              addCriterion("open_time is not null");
              return (Criteria) this;
         }

         public Criteria andOpenTimeEqualTo(String value)
         {
              addCriterion("open_time = ", value, "open_time");
              return (Criteria) this;
         }

         public Criteria andOpenTimeNotEqualTo(String value)
         {
              addCriterion("open_time <> ", value, "open_time");
              return (Criteria) this;
         }

         public Criteria andOpenTimeGreaterThan(String value)
         {
              addCriterion("open_time > ", value, "open_time");
              return (Criteria) this;
         }

         public Criteria andOpenTimeGreaterThanOrEqualTo(String value)
         {
              addCriterion("open_time >= ", value, "open_time");
              return (Criteria) this;
         }

         public Criteria andOpenTimeLessThan(String value)
         {
              addCriterion("open_time < ", value, "open_time");
              return (Criteria) this;
         }

         public Criteria andOpenTimeLessThanOrEqualTo(String value)
         {
              addCriterion("open_time <= ", value, "open_time");
              return (Criteria) this;
         }

         public Criteria andOpenTimeLike(String value)
         {
              addCriterion("open_time like ", value, "open_time");
              return (Criteria) this;
         }

         public Criteria andOpenTimeNotLike(String value)
         {
              addCriterion("open_time not like ", value, "open_time");
              return (Criteria) this;
         }

         public Criteria andOpenTimeIn(List<String> values)
         {
              addCriterion("open_time in ", values, "open_time");
              return (Criteria) this;
         }

         public Criteria andOpenTimeNotIn(List<String> values)
         {
              addCriterion("open_time not in ", values, "open_time");
              return (Criteria) this;
         }

         public Criteria andOpenTimeBetween(String value1, String value2)
         {
              addCriterion("open_time between ", value1,value2, "open_time");
              return (Criteria) this;
         }

         public Criteria andOpenTimeNotBetween(String value1, String value2)
         {
              addCriterion("open_time not between ", value1,value2, "open_time");
              return (Criteria) this;
         }

         public Criteria andCloseTimeIsNull()
         {
              addCriterion("close_time is null");
              return (Criteria) this;
         }

         public Criteria andCloseTimeIsNotNull()
         {
              addCriterion("close_time is not null");
              return (Criteria) this;
         }

         public Criteria andCloseTimeEqualTo(String value)
         {
              addCriterion("close_time = ", value, "close_time");
              return (Criteria) this;
         }

         public Criteria andCloseTimeNotEqualTo(String value)
         {
              addCriterion("close_time <> ", value, "close_time");
              return (Criteria) this;
         }

         public Criteria andCloseTimeGreaterThan(String value)
         {
              addCriterion("close_time > ", value, "close_time");
              return (Criteria) this;
         }

         public Criteria andCloseTimeGreaterThanOrEqualTo(String value)
         {
              addCriterion("close_time >= ", value, "close_time");
              return (Criteria) this;
         }

         public Criteria andCloseTimeLessThan(String value)
         {
              addCriterion("close_time < ", value, "close_time");
              return (Criteria) this;
         }

         public Criteria andCloseTimeLessThanOrEqualTo(String value)
         {
              addCriterion("close_time <= ", value, "close_time");
              return (Criteria) this;
         }

         public Criteria andCloseTimeLike(String value)
         {
              addCriterion("close_time like ", value, "close_time");
              return (Criteria) this;
         }

         public Criteria andCloseTimeNotLike(String value)
         {
              addCriterion("close_time not like ", value, "close_time");
              return (Criteria) this;
         }

         public Criteria andCloseTimeIn(List<String> values)
         {
              addCriterion("close_time in ", values, "close_time");
              return (Criteria) this;
         }

         public Criteria andCloseTimeNotIn(List<String> values)
         {
              addCriterion("close_time not in ", values, "close_time");
              return (Criteria) this;
         }

         public Criteria andCloseTimeBetween(String value1, String value2)
         {
              addCriterion("close_time between ", value1,value2, "close_time");
              return (Criteria) this;
         }

         public Criteria andCloseTimeNotBetween(String value1, String value2)
         {
              addCriterion("close_time not between ", value1,value2, "close_time");
              return (Criteria) this;
         }

         public Criteria andShopRoadGuideIsNull()
         {
              addCriterion("shop_road_guide is null");
              return (Criteria) this;
         }

         public Criteria andShopRoadGuideIsNotNull()
         {
              addCriterion("shop_road_guide is not null");
              return (Criteria) this;
         }

         public Criteria andShopRoadGuideEqualTo(String value)
         {
              addCriterion("shop_road_guide = ", value, "shop_road_guide");
              return (Criteria) this;
         }

         public Criteria andShopRoadGuideNotEqualTo(String value)
         {
              addCriterion("shop_road_guide <> ", value, "shop_road_guide");
              return (Criteria) this;
         }

         public Criteria andShopRoadGuideGreaterThan(String value)
         {
              addCriterion("shop_road_guide > ", value, "shop_road_guide");
              return (Criteria) this;
         }

         public Criteria andShopRoadGuideGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_road_guide >= ", value, "shop_road_guide");
              return (Criteria) this;
         }

         public Criteria andShopRoadGuideLessThan(String value)
         {
              addCriterion("shop_road_guide < ", value, "shop_road_guide");
              return (Criteria) this;
         }

         public Criteria andShopRoadGuideLessThanOrEqualTo(String value)
         {
              addCriterion("shop_road_guide <= ", value, "shop_road_guide");
              return (Criteria) this;
         }

         public Criteria andShopRoadGuideLike(String value)
         {
              addCriterion("shop_road_guide like ", value, "shop_road_guide");
              return (Criteria) this;
         }

         public Criteria andShopRoadGuideNotLike(String value)
         {
              addCriterion("shop_road_guide not like ", value, "shop_road_guide");
              return (Criteria) this;
         }

         public Criteria andShopRoadGuideIn(List<String> values)
         {
              addCriterion("shop_road_guide in ", values, "shop_road_guide");
              return (Criteria) this;
         }

         public Criteria andShopRoadGuideNotIn(List<String> values)
         {
              addCriterion("shop_road_guide not in ", values, "shop_road_guide");
              return (Criteria) this;
         }

         public Criteria andShopRoadGuideBetween(String value1, String value2)
         {
              addCriterion("shop_road_guide between ", value1,value2, "shop_road_guide");
              return (Criteria) this;
         }

         public Criteria andShopRoadGuideNotBetween(String value1, String value2)
         {
              addCriterion("shop_road_guide not between ", value1,value2, "shop_road_guide");
              return (Criteria) this;
         }

         public Criteria andIntroductionIsNull()
         {
              addCriterion("introduction is null");
              return (Criteria) this;
         }

         public Criteria andIntroductionIsNotNull()
         {
              addCriterion("introduction is not null");
              return (Criteria) this;
         }

         public Criteria andIntroductionEqualTo(String value)
         {
              addCriterion("introduction = ", value, "introduction");
              return (Criteria) this;
         }

         public Criteria andIntroductionNotEqualTo(String value)
         {
              addCriterion("introduction <> ", value, "introduction");
              return (Criteria) this;
         }

         public Criteria andIntroductionGreaterThan(String value)
         {
              addCriterion("introduction > ", value, "introduction");
              return (Criteria) this;
         }

         public Criteria andIntroductionGreaterThanOrEqualTo(String value)
         {
              addCriterion("introduction >= ", value, "introduction");
              return (Criteria) this;
         }

         public Criteria andIntroductionLessThan(String value)
         {
              addCriterion("introduction < ", value, "introduction");
              return (Criteria) this;
         }

         public Criteria andIntroductionLessThanOrEqualTo(String value)
         {
              addCriterion("introduction <= ", value, "introduction");
              return (Criteria) this;
         }

         public Criteria andIntroductionLike(String value)
         {
              addCriterion("introduction like ", value, "introduction");
              return (Criteria) this;
         }

         public Criteria andIntroductionNotLike(String value)
         {
              addCriterion("introduction not like ", value, "introduction");
              return (Criteria) this;
         }

         public Criteria andIntroductionIn(List<String> values)
         {
              addCriterion("introduction in ", values, "introduction");
              return (Criteria) this;
         }

         public Criteria andIntroductionNotIn(List<String> values)
         {
              addCriterion("introduction not in ", values, "introduction");
              return (Criteria) this;
         }

         public Criteria andIntroductionBetween(String value1, String value2)
         {
              addCriterion("introduction between ", value1,value2, "introduction");
              return (Criteria) this;
         }

         public Criteria andIntroductionNotBetween(String value1, String value2)
         {
              addCriterion("introduction not between ", value1,value2, "introduction");
              return (Criteria) this;
         }

         public Criteria andPromptinfoIsNull()
         {
              addCriterion("promptinfo is null");
              return (Criteria) this;
         }

         public Criteria andPromptinfoIsNotNull()
         {
              addCriterion("promptinfo is not null");
              return (Criteria) this;
         }

         public Criteria andPromptinfoEqualTo(String value)
         {
              addCriterion("promptinfo = ", value, "promptinfo");
              return (Criteria) this;
         }

         public Criteria andPromptinfoNotEqualTo(String value)
         {
              addCriterion("promptinfo <> ", value, "promptinfo");
              return (Criteria) this;
         }

         public Criteria andPromptinfoGreaterThan(String value)
         {
              addCriterion("promptinfo > ", value, "promptinfo");
              return (Criteria) this;
         }

         public Criteria andPromptinfoGreaterThanOrEqualTo(String value)
         {
              addCriterion("promptinfo >= ", value, "promptinfo");
              return (Criteria) this;
         }

         public Criteria andPromptinfoLessThan(String value)
         {
              addCriterion("promptinfo < ", value, "promptinfo");
              return (Criteria) this;
         }

         public Criteria andPromptinfoLessThanOrEqualTo(String value)
         {
              addCriterion("promptinfo <= ", value, "promptinfo");
              return (Criteria) this;
         }

         public Criteria andPromptinfoLike(String value)
         {
              addCriterion("promptinfo like ", value, "promptinfo");
              return (Criteria) this;
         }

         public Criteria andPromptinfoNotLike(String value)
         {
              addCriterion("promptinfo not like ", value, "promptinfo");
              return (Criteria) this;
         }

         public Criteria andPromptinfoIn(List<String> values)
         {
              addCriterion("promptinfo in ", values, "promptinfo");
              return (Criteria) this;
         }

         public Criteria andPromptinfoNotIn(List<String> values)
         {
              addCriterion("promptinfo not in ", values, "promptinfo");
              return (Criteria) this;
         }

         public Criteria andPromptinfoBetween(String value1, String value2)
         {
              addCriterion("promptinfo between ", value1,value2, "promptinfo");
              return (Criteria) this;
         }

         public Criteria andPromptinfoNotBetween(String value1, String value2)
         {
              addCriterion("promptinfo not between ", value1,value2, "promptinfo");
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
