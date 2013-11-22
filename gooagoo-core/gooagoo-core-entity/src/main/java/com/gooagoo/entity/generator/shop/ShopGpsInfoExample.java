package com.gooagoo.entity.generator.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 实体店GPS信息表
 */

public class ShopGpsInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopGpsInfoExample()
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

         public Criteria andShopGpsBaiduxIsNull()
         {
              addCriterion("shop_gps_baidux is null");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduxIsNotNull()
         {
              addCriterion("shop_gps_baidux is not null");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduxEqualTo(String value)
         {
              addCriterion("shop_gps_baidux = ", value, "shop_gps_baidux");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduxNotEqualTo(String value)
         {
              addCriterion("shop_gps_baidux <> ", value, "shop_gps_baidux");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduxGreaterThan(String value)
         {
              addCriterion("shop_gps_baidux > ", value, "shop_gps_baidux");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduxGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_gps_baidux >= ", value, "shop_gps_baidux");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduxLessThan(String value)
         {
              addCriterion("shop_gps_baidux < ", value, "shop_gps_baidux");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduxLessThanOrEqualTo(String value)
         {
              addCriterion("shop_gps_baidux <= ", value, "shop_gps_baidux");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduxLike(String value)
         {
              addCriterion("shop_gps_baidux like ", value, "shop_gps_baidux");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduxNotLike(String value)
         {
              addCriterion("shop_gps_baidux not like ", value, "shop_gps_baidux");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduxIn(List<String> values)
         {
              addCriterion("shop_gps_baidux in ", values, "shop_gps_baidux");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduxNotIn(List<String> values)
         {
              addCriterion("shop_gps_baidux not in ", values, "shop_gps_baidux");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduxBetween(String value1, String value2)
         {
              addCriterion("shop_gps_baidux between ", value1,value2, "shop_gps_baidux");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduxNotBetween(String value1, String value2)
         {
              addCriterion("shop_gps_baidux not between ", value1,value2, "shop_gps_baidux");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduyIsNull()
         {
              addCriterion("shop_gps_baiduy is null");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduyIsNotNull()
         {
              addCriterion("shop_gps_baiduy is not null");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduyEqualTo(String value)
         {
              addCriterion("shop_gps_baiduy = ", value, "shop_gps_baiduy");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduyNotEqualTo(String value)
         {
              addCriterion("shop_gps_baiduy <> ", value, "shop_gps_baiduy");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduyGreaterThan(String value)
         {
              addCriterion("shop_gps_baiduy > ", value, "shop_gps_baiduy");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduyGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_gps_baiduy >= ", value, "shop_gps_baiduy");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduyLessThan(String value)
         {
              addCriterion("shop_gps_baiduy < ", value, "shop_gps_baiduy");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduyLessThanOrEqualTo(String value)
         {
              addCriterion("shop_gps_baiduy <= ", value, "shop_gps_baiduy");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduyLike(String value)
         {
              addCriterion("shop_gps_baiduy like ", value, "shop_gps_baiduy");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduyNotLike(String value)
         {
              addCriterion("shop_gps_baiduy not like ", value, "shop_gps_baiduy");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduyIn(List<String> values)
         {
              addCriterion("shop_gps_baiduy in ", values, "shop_gps_baiduy");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduyNotIn(List<String> values)
         {
              addCriterion("shop_gps_baiduy not in ", values, "shop_gps_baiduy");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduyBetween(String value1, String value2)
         {
              addCriterion("shop_gps_baiduy between ", value1,value2, "shop_gps_baiduy");
              return (Criteria) this;
         }

         public Criteria andShopGpsBaiduyNotBetween(String value1, String value2)
         {
              addCriterion("shop_gps_baiduy not between ", value1,value2, "shop_gps_baiduy");
              return (Criteria) this;
         }

         public Criteria andShopGpsGooglexIsNull()
         {
              addCriterion("shop_gps_googlex is null");
              return (Criteria) this;
         }

         public Criteria andShopGpsGooglexIsNotNull()
         {
              addCriterion("shop_gps_googlex is not null");
              return (Criteria) this;
         }

         public Criteria andShopGpsGooglexEqualTo(String value)
         {
              addCriterion("shop_gps_googlex = ", value, "shop_gps_googlex");
              return (Criteria) this;
         }

         public Criteria andShopGpsGooglexNotEqualTo(String value)
         {
              addCriterion("shop_gps_googlex <> ", value, "shop_gps_googlex");
              return (Criteria) this;
         }

         public Criteria andShopGpsGooglexGreaterThan(String value)
         {
              addCriterion("shop_gps_googlex > ", value, "shop_gps_googlex");
              return (Criteria) this;
         }

         public Criteria andShopGpsGooglexGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_gps_googlex >= ", value, "shop_gps_googlex");
              return (Criteria) this;
         }

         public Criteria andShopGpsGooglexLessThan(String value)
         {
              addCriterion("shop_gps_googlex < ", value, "shop_gps_googlex");
              return (Criteria) this;
         }

         public Criteria andShopGpsGooglexLessThanOrEqualTo(String value)
         {
              addCriterion("shop_gps_googlex <= ", value, "shop_gps_googlex");
              return (Criteria) this;
         }

         public Criteria andShopGpsGooglexLike(String value)
         {
              addCriterion("shop_gps_googlex like ", value, "shop_gps_googlex");
              return (Criteria) this;
         }

         public Criteria andShopGpsGooglexNotLike(String value)
         {
              addCriterion("shop_gps_googlex not like ", value, "shop_gps_googlex");
              return (Criteria) this;
         }

         public Criteria andShopGpsGooglexIn(List<String> values)
         {
              addCriterion("shop_gps_googlex in ", values, "shop_gps_googlex");
              return (Criteria) this;
         }

         public Criteria andShopGpsGooglexNotIn(List<String> values)
         {
              addCriterion("shop_gps_googlex not in ", values, "shop_gps_googlex");
              return (Criteria) this;
         }

         public Criteria andShopGpsGooglexBetween(String value1, String value2)
         {
              addCriterion("shop_gps_googlex between ", value1,value2, "shop_gps_googlex");
              return (Criteria) this;
         }

         public Criteria andShopGpsGooglexNotBetween(String value1, String value2)
         {
              addCriterion("shop_gps_googlex not between ", value1,value2, "shop_gps_googlex");
              return (Criteria) this;
         }

         public Criteria andShopGpsGoogleyIsNull()
         {
              addCriterion("shop_gps_googley is null");
              return (Criteria) this;
         }

         public Criteria andShopGpsGoogleyIsNotNull()
         {
              addCriterion("shop_gps_googley is not null");
              return (Criteria) this;
         }

         public Criteria andShopGpsGoogleyEqualTo(String value)
         {
              addCriterion("shop_gps_googley = ", value, "shop_gps_googley");
              return (Criteria) this;
         }

         public Criteria andShopGpsGoogleyNotEqualTo(String value)
         {
              addCriterion("shop_gps_googley <> ", value, "shop_gps_googley");
              return (Criteria) this;
         }

         public Criteria andShopGpsGoogleyGreaterThan(String value)
         {
              addCriterion("shop_gps_googley > ", value, "shop_gps_googley");
              return (Criteria) this;
         }

         public Criteria andShopGpsGoogleyGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_gps_googley >= ", value, "shop_gps_googley");
              return (Criteria) this;
         }

         public Criteria andShopGpsGoogleyLessThan(String value)
         {
              addCriterion("shop_gps_googley < ", value, "shop_gps_googley");
              return (Criteria) this;
         }

         public Criteria andShopGpsGoogleyLessThanOrEqualTo(String value)
         {
              addCriterion("shop_gps_googley <= ", value, "shop_gps_googley");
              return (Criteria) this;
         }

         public Criteria andShopGpsGoogleyLike(String value)
         {
              addCriterion("shop_gps_googley like ", value, "shop_gps_googley");
              return (Criteria) this;
         }

         public Criteria andShopGpsGoogleyNotLike(String value)
         {
              addCriterion("shop_gps_googley not like ", value, "shop_gps_googley");
              return (Criteria) this;
         }

         public Criteria andShopGpsGoogleyIn(List<String> values)
         {
              addCriterion("shop_gps_googley in ", values, "shop_gps_googley");
              return (Criteria) this;
         }

         public Criteria andShopGpsGoogleyNotIn(List<String> values)
         {
              addCriterion("shop_gps_googley not in ", values, "shop_gps_googley");
              return (Criteria) this;
         }

         public Criteria andShopGpsGoogleyBetween(String value1, String value2)
         {
              addCriterion("shop_gps_googley between ", value1,value2, "shop_gps_googley");
              return (Criteria) this;
         }

         public Criteria andShopGpsGoogleyNotBetween(String value1, String value2)
         {
              addCriterion("shop_gps_googley not between ", value1,value2, "shop_gps_googley");
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
