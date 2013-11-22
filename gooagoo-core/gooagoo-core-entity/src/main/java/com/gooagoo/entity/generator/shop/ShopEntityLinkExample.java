package com.gooagoo.entity.generator.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 实体店联系方式
 */

public class ShopEntityLinkExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopEntityLinkExample()
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

         public Criteria andMobileIsNull()
         {
              addCriterion("mobile is null");
              return (Criteria) this;
         }

         public Criteria andMobileIsNotNull()
         {
              addCriterion("mobile is not null");
              return (Criteria) this;
         }

         public Criteria andMobileEqualTo(String value)
         {
              addCriterion("mobile = ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileNotEqualTo(String value)
         {
              addCriterion("mobile <> ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileGreaterThan(String value)
         {
              addCriterion("mobile > ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileGreaterThanOrEqualTo(String value)
         {
              addCriterion("mobile >= ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileLessThan(String value)
         {
              addCriterion("mobile < ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileLessThanOrEqualTo(String value)
         {
              addCriterion("mobile <= ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileLike(String value)
         {
              addCriterion("mobile like ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileNotLike(String value)
         {
              addCriterion("mobile not like ", value, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileIn(List<String> values)
         {
              addCriterion("mobile in ", values, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileNotIn(List<String> values)
         {
              addCriterion("mobile not in ", values, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileBetween(String value1, String value2)
         {
              addCriterion("mobile between ", value1,value2, "mobile");
              return (Criteria) this;
         }

         public Criteria andMobileNotBetween(String value1, String value2)
         {
              addCriterion("mobile not between ", value1,value2, "mobile");
              return (Criteria) this;
         }

         public Criteria andPhoneIsNull()
         {
              addCriterion("phone is null");
              return (Criteria) this;
         }

         public Criteria andPhoneIsNotNull()
         {
              addCriterion("phone is not null");
              return (Criteria) this;
         }

         public Criteria andPhoneEqualTo(String value)
         {
              addCriterion("phone = ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneNotEqualTo(String value)
         {
              addCriterion("phone <> ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneGreaterThan(String value)
         {
              addCriterion("phone > ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneGreaterThanOrEqualTo(String value)
         {
              addCriterion("phone >= ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneLessThan(String value)
         {
              addCriterion("phone < ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneLessThanOrEqualTo(String value)
         {
              addCriterion("phone <= ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneLike(String value)
         {
              addCriterion("phone like ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneNotLike(String value)
         {
              addCriterion("phone not like ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneIn(List<String> values)
         {
              addCriterion("phone in ", values, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneNotIn(List<String> values)
         {
              addCriterion("phone not in ", values, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneBetween(String value1, String value2)
         {
              addCriterion("phone between ", value1,value2, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneNotBetween(String value1, String value2)
         {
              addCriterion("phone not between ", value1,value2, "phone");
              return (Criteria) this;
         }

         public Criteria andPostCodeIsNull()
         {
              addCriterion("post_code is null");
              return (Criteria) this;
         }

         public Criteria andPostCodeIsNotNull()
         {
              addCriterion("post_code is not null");
              return (Criteria) this;
         }

         public Criteria andPostCodeEqualTo(String value)
         {
              addCriterion("post_code = ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeNotEqualTo(String value)
         {
              addCriterion("post_code <> ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeGreaterThan(String value)
         {
              addCriterion("post_code > ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("post_code >= ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeLessThan(String value)
         {
              addCriterion("post_code < ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeLessThanOrEqualTo(String value)
         {
              addCriterion("post_code <= ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeLike(String value)
         {
              addCriterion("post_code like ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeNotLike(String value)
         {
              addCriterion("post_code not like ", value, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeIn(List<String> values)
         {
              addCriterion("post_code in ", values, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeNotIn(List<String> values)
         {
              addCriterion("post_code not in ", values, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeBetween(String value1, String value2)
         {
              addCriterion("post_code between ", value1,value2, "post_code");
              return (Criteria) this;
         }

         public Criteria andPostCodeNotBetween(String value1, String value2)
         {
              addCriterion("post_code not between ", value1,value2, "post_code");
              return (Criteria) this;
         }

         public Criteria andProvinceIsNull()
         {
              addCriterion("province is null");
              return (Criteria) this;
         }

         public Criteria andProvinceIsNotNull()
         {
              addCriterion("province is not null");
              return (Criteria) this;
         }

         public Criteria andProvinceEqualTo(String value)
         {
              addCriterion("province = ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceNotEqualTo(String value)
         {
              addCriterion("province <> ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceGreaterThan(String value)
         {
              addCriterion("province > ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceGreaterThanOrEqualTo(String value)
         {
              addCriterion("province >= ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceLessThan(String value)
         {
              addCriterion("province < ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceLessThanOrEqualTo(String value)
         {
              addCriterion("province <= ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceLike(String value)
         {
              addCriterion("province like ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceNotLike(String value)
         {
              addCriterion("province not like ", value, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceIn(List<String> values)
         {
              addCriterion("province in ", values, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceNotIn(List<String> values)
         {
              addCriterion("province not in ", values, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceBetween(String value1, String value2)
         {
              addCriterion("province between ", value1,value2, "province");
              return (Criteria) this;
         }

         public Criteria andProvinceNotBetween(String value1, String value2)
         {
              addCriterion("province not between ", value1,value2, "province");
              return (Criteria) this;
         }

         public Criteria andCityIsNull()
         {
              addCriterion("city is null");
              return (Criteria) this;
         }

         public Criteria andCityIsNotNull()
         {
              addCriterion("city is not null");
              return (Criteria) this;
         }

         public Criteria andCityEqualTo(String value)
         {
              addCriterion("city = ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityNotEqualTo(String value)
         {
              addCriterion("city <> ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityGreaterThan(String value)
         {
              addCriterion("city > ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityGreaterThanOrEqualTo(String value)
         {
              addCriterion("city >= ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityLessThan(String value)
         {
              addCriterion("city < ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityLessThanOrEqualTo(String value)
         {
              addCriterion("city <= ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityLike(String value)
         {
              addCriterion("city like ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityNotLike(String value)
         {
              addCriterion("city not like ", value, "city");
              return (Criteria) this;
         }

         public Criteria andCityIn(List<String> values)
         {
              addCriterion("city in ", values, "city");
              return (Criteria) this;
         }

         public Criteria andCityNotIn(List<String> values)
         {
              addCriterion("city not in ", values, "city");
              return (Criteria) this;
         }

         public Criteria andCityBetween(String value1, String value2)
         {
              addCriterion("city between ", value1,value2, "city");
              return (Criteria) this;
         }

         public Criteria andCityNotBetween(String value1, String value2)
         {
              addCriterion("city not between ", value1,value2, "city");
              return (Criteria) this;
         }

         public Criteria andAreaIsNull()
         {
              addCriterion("area is null");
              return (Criteria) this;
         }

         public Criteria andAreaIsNotNull()
         {
              addCriterion("area is not null");
              return (Criteria) this;
         }

         public Criteria andAreaEqualTo(String value)
         {
              addCriterion("area = ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaNotEqualTo(String value)
         {
              addCriterion("area <> ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaGreaterThan(String value)
         {
              addCriterion("area > ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaGreaterThanOrEqualTo(String value)
         {
              addCriterion("area >= ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaLessThan(String value)
         {
              addCriterion("area < ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaLessThanOrEqualTo(String value)
         {
              addCriterion("area <= ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaLike(String value)
         {
              addCriterion("area like ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaNotLike(String value)
         {
              addCriterion("area not like ", value, "area");
              return (Criteria) this;
         }

         public Criteria andAreaIn(List<String> values)
         {
              addCriterion("area in ", values, "area");
              return (Criteria) this;
         }

         public Criteria andAreaNotIn(List<String> values)
         {
              addCriterion("area not in ", values, "area");
              return (Criteria) this;
         }

         public Criteria andAreaBetween(String value1, String value2)
         {
              addCriterion("area between ", value1,value2, "area");
              return (Criteria) this;
         }

         public Criteria andAreaNotBetween(String value1, String value2)
         {
              addCriterion("area not between ", value1,value2, "area");
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
