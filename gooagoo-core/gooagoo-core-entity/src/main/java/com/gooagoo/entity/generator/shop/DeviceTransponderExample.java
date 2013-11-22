package com.gooagoo.entity.generator.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 商家转发器设备表
 */

public class DeviceTransponderExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public DeviceTransponderExample()
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

         public Criteria andDeviceTransponderIdIsNull()
         {
              addCriterion("device_transponder_id is null");
              return (Criteria) this;
         }

         public Criteria andDeviceTransponderIdIsNotNull()
         {
              addCriterion("device_transponder_id is not null");
              return (Criteria) this;
         }

         public Criteria andDeviceTransponderIdEqualTo(String value)
         {
              addCriterion("device_transponder_id = ", value, "device_transponder_id");
              return (Criteria) this;
         }

         public Criteria andDeviceTransponderIdNotEqualTo(String value)
         {
              addCriterion("device_transponder_id <> ", value, "device_transponder_id");
              return (Criteria) this;
         }

         public Criteria andDeviceTransponderIdGreaterThan(String value)
         {
              addCriterion("device_transponder_id > ", value, "device_transponder_id");
              return (Criteria) this;
         }

         public Criteria andDeviceTransponderIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("device_transponder_id >= ", value, "device_transponder_id");
              return (Criteria) this;
         }

         public Criteria andDeviceTransponderIdLessThan(String value)
         {
              addCriterion("device_transponder_id < ", value, "device_transponder_id");
              return (Criteria) this;
         }

         public Criteria andDeviceTransponderIdLessThanOrEqualTo(String value)
         {
              addCriterion("device_transponder_id <= ", value, "device_transponder_id");
              return (Criteria) this;
         }

         public Criteria andDeviceTransponderIdLike(String value)
         {
              addCriterion("device_transponder_id like ", value, "device_transponder_id");
              return (Criteria) this;
         }

         public Criteria andDeviceTransponderIdNotLike(String value)
         {
              addCriterion("device_transponder_id not like ", value, "device_transponder_id");
              return (Criteria) this;
         }

         public Criteria andDeviceTransponderIdIn(List<String> values)
         {
              addCriterion("device_transponder_id in ", values, "device_transponder_id");
              return (Criteria) this;
         }

         public Criteria andDeviceTransponderIdNotIn(List<String> values)
         {
              addCriterion("device_transponder_id not in ", values, "device_transponder_id");
              return (Criteria) this;
         }

         public Criteria andDeviceTransponderIdBetween(String value1, String value2)
         {
              addCriterion("device_transponder_id between ", value1,value2, "device_transponder_id");
              return (Criteria) this;
         }

         public Criteria andDeviceTransponderIdNotBetween(String value1, String value2)
         {
              addCriterion("device_transponder_id not between ", value1,value2, "device_transponder_id");
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

         public Criteria andDeviceMacIsNull()
         {
              addCriterion("device_mac is null");
              return (Criteria) this;
         }

         public Criteria andDeviceMacIsNotNull()
         {
              addCriterion("device_mac is not null");
              return (Criteria) this;
         }

         public Criteria andDeviceMacEqualTo(String value)
         {
              addCriterion("device_mac = ", value, "device_mac");
              return (Criteria) this;
         }

         public Criteria andDeviceMacNotEqualTo(String value)
         {
              addCriterion("device_mac <> ", value, "device_mac");
              return (Criteria) this;
         }

         public Criteria andDeviceMacGreaterThan(String value)
         {
              addCriterion("device_mac > ", value, "device_mac");
              return (Criteria) this;
         }

         public Criteria andDeviceMacGreaterThanOrEqualTo(String value)
         {
              addCriterion("device_mac >= ", value, "device_mac");
              return (Criteria) this;
         }

         public Criteria andDeviceMacLessThan(String value)
         {
              addCriterion("device_mac < ", value, "device_mac");
              return (Criteria) this;
         }

         public Criteria andDeviceMacLessThanOrEqualTo(String value)
         {
              addCriterion("device_mac <= ", value, "device_mac");
              return (Criteria) this;
         }

         public Criteria andDeviceMacLike(String value)
         {
              addCriterion("device_mac like ", value, "device_mac");
              return (Criteria) this;
         }

         public Criteria andDeviceMacNotLike(String value)
         {
              addCriterion("device_mac not like ", value, "device_mac");
              return (Criteria) this;
         }

         public Criteria andDeviceMacIn(List<String> values)
         {
              addCriterion("device_mac in ", values, "device_mac");
              return (Criteria) this;
         }

         public Criteria andDeviceMacNotIn(List<String> values)
         {
              addCriterion("device_mac not in ", values, "device_mac");
              return (Criteria) this;
         }

         public Criteria andDeviceMacBetween(String value1, String value2)
         {
              addCriterion("device_mac between ", value1,value2, "device_mac");
              return (Criteria) this;
         }

         public Criteria andDeviceMacNotBetween(String value1, String value2)
         {
              addCriterion("device_mac not between ", value1,value2, "device_mac");
              return (Criteria) this;
         }

         public Criteria andDeviceTypeIsNull()
         {
              addCriterion("device_type is null");
              return (Criteria) this;
         }

         public Criteria andDeviceTypeIsNotNull()
         {
              addCriterion("device_type is not null");
              return (Criteria) this;
         }

         public Criteria andDeviceTypeEqualTo(String value)
         {
              addCriterion("device_type = ", value, "device_type");
              return (Criteria) this;
         }

         public Criteria andDeviceTypeNotEqualTo(String value)
         {
              addCriterion("device_type <> ", value, "device_type");
              return (Criteria) this;
         }

         public Criteria andDeviceTypeGreaterThan(String value)
         {
              addCriterion("device_type > ", value, "device_type");
              return (Criteria) this;
         }

         public Criteria andDeviceTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("device_type >= ", value, "device_type");
              return (Criteria) this;
         }

         public Criteria andDeviceTypeLessThan(String value)
         {
              addCriterion("device_type < ", value, "device_type");
              return (Criteria) this;
         }

         public Criteria andDeviceTypeLessThanOrEqualTo(String value)
         {
              addCriterion("device_type <= ", value, "device_type");
              return (Criteria) this;
         }

         public Criteria andDeviceTypeLike(String value)
         {
              addCriterion("device_type like ", value, "device_type");
              return (Criteria) this;
         }

         public Criteria andDeviceTypeNotLike(String value)
         {
              addCriterion("device_type not like ", value, "device_type");
              return (Criteria) this;
         }

         public Criteria andDeviceTypeIn(List<String> values)
         {
              addCriterion("device_type in ", values, "device_type");
              return (Criteria) this;
         }

         public Criteria andDeviceTypeNotIn(List<String> values)
         {
              addCriterion("device_type not in ", values, "device_type");
              return (Criteria) this;
         }

         public Criteria andDeviceTypeBetween(String value1, String value2)
         {
              addCriterion("device_type between ", value1,value2, "device_type");
              return (Criteria) this;
         }

         public Criteria andDeviceTypeNotBetween(String value1, String value2)
         {
              addCriterion("device_type not between ", value1,value2, "device_type");
              return (Criteria) this;
         }

         public Criteria andDeviceSnIsNull()
         {
              addCriterion("device_sn is null");
              return (Criteria) this;
         }

         public Criteria andDeviceSnIsNotNull()
         {
              addCriterion("device_sn is not null");
              return (Criteria) this;
         }

         public Criteria andDeviceSnEqualTo(String value)
         {
              addCriterion("device_sn = ", value, "device_sn");
              return (Criteria) this;
         }

         public Criteria andDeviceSnNotEqualTo(String value)
         {
              addCriterion("device_sn <> ", value, "device_sn");
              return (Criteria) this;
         }

         public Criteria andDeviceSnGreaterThan(String value)
         {
              addCriterion("device_sn > ", value, "device_sn");
              return (Criteria) this;
         }

         public Criteria andDeviceSnGreaterThanOrEqualTo(String value)
         {
              addCriterion("device_sn >= ", value, "device_sn");
              return (Criteria) this;
         }

         public Criteria andDeviceSnLessThan(String value)
         {
              addCriterion("device_sn < ", value, "device_sn");
              return (Criteria) this;
         }

         public Criteria andDeviceSnLessThanOrEqualTo(String value)
         {
              addCriterion("device_sn <= ", value, "device_sn");
              return (Criteria) this;
         }

         public Criteria andDeviceSnLike(String value)
         {
              addCriterion("device_sn like ", value, "device_sn");
              return (Criteria) this;
         }

         public Criteria andDeviceSnNotLike(String value)
         {
              addCriterion("device_sn not like ", value, "device_sn");
              return (Criteria) this;
         }

         public Criteria andDeviceSnIn(List<String> values)
         {
              addCriterion("device_sn in ", values, "device_sn");
              return (Criteria) this;
         }

         public Criteria andDeviceSnNotIn(List<String> values)
         {
              addCriterion("device_sn not in ", values, "device_sn");
              return (Criteria) this;
         }

         public Criteria andDeviceSnBetween(String value1, String value2)
         {
              addCriterion("device_sn between ", value1,value2, "device_sn");
              return (Criteria) this;
         }

         public Criteria andDeviceSnNotBetween(String value1, String value2)
         {
              addCriterion("device_sn not between ", value1,value2, "device_sn");
              return (Criteria) this;
         }

         public Criteria andInstallDateIsNull()
         {
              addCriterion("install_date is null");
              return (Criteria) this;
         }

         public Criteria andInstallDateIsNotNull()
         {
              addCriterion("install_date is not null");
              return (Criteria) this;
         }

         public Criteria andInstallDateEqualTo(Date value)
         {
              addCriterion("install_date = ", value, "install_date");
              return (Criteria) this;
         }

         public Criteria andInstallDateNotEqualTo(Date value)
         {
              addCriterion("install_date <> ", value, "install_date");
              return (Criteria) this;
         }

         public Criteria andInstallDateGreaterThan(Date value)
         {
              addCriterion("install_date > ", value, "install_date");
              return (Criteria) this;
         }

         public Criteria andInstallDateGreaterThanOrEqualTo(Date value)
         {
              addCriterion("install_date >= ", value, "install_date");
              return (Criteria) this;
         }

         public Criteria andInstallDateLessThan(Date value)
         {
              addCriterion("install_date < ", value, "install_date");
              return (Criteria) this;
         }

         public Criteria andInstallDateLessThanOrEqualTo(Date value)
         {
              addCriterion("install_date <= ", value, "install_date");
              return (Criteria) this;
         }

         public Criteria andInstallDateIn(List<Date> values)
         {
              addCriterion("install_date in ", values, "install_date");
              return (Criteria) this;
         }

         public Criteria andInstallDateNotIn(List<Date> values)
         {
              addCriterion("install_date not in ", values, "install_date");
              return (Criteria) this;
         }

         public Criteria andInstallDateBetween(Date value1, Date value2)
         {
              addCriterion("install_date between ", value1,value2, "install_date");
              return (Criteria) this;
         }

         public Criteria andInstallDateNotBetween(Date value1, Date value2)
         {
              addCriterion("install_date not between ", value1,value2, "install_date");
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

         public Criteria andSystemTypeIsNull()
         {
              addCriterion("system_type is null");
              return (Criteria) this;
         }

         public Criteria andSystemTypeIsNotNull()
         {
              addCriterion("system_type is not null");
              return (Criteria) this;
         }

         public Criteria andSystemTypeEqualTo(String value)
         {
              addCriterion("system_type = ", value, "system_type");
              return (Criteria) this;
         }

         public Criteria andSystemTypeNotEqualTo(String value)
         {
              addCriterion("system_type <> ", value, "system_type");
              return (Criteria) this;
         }

         public Criteria andSystemTypeGreaterThan(String value)
         {
              addCriterion("system_type > ", value, "system_type");
              return (Criteria) this;
         }

         public Criteria andSystemTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("system_type >= ", value, "system_type");
              return (Criteria) this;
         }

         public Criteria andSystemTypeLessThan(String value)
         {
              addCriterion("system_type < ", value, "system_type");
              return (Criteria) this;
         }

         public Criteria andSystemTypeLessThanOrEqualTo(String value)
         {
              addCriterion("system_type <= ", value, "system_type");
              return (Criteria) this;
         }

         public Criteria andSystemTypeLike(String value)
         {
              addCriterion("system_type like ", value, "system_type");
              return (Criteria) this;
         }

         public Criteria andSystemTypeNotLike(String value)
         {
              addCriterion("system_type not like ", value, "system_type");
              return (Criteria) this;
         }

         public Criteria andSystemTypeIn(List<String> values)
         {
              addCriterion("system_type in ", values, "system_type");
              return (Criteria) this;
         }

         public Criteria andSystemTypeNotIn(List<String> values)
         {
              addCriterion("system_type not in ", values, "system_type");
              return (Criteria) this;
         }

         public Criteria andSystemTypeBetween(String value1, String value2)
         {
              addCriterion("system_type between ", value1,value2, "system_type");
              return (Criteria) this;
         }

         public Criteria andSystemTypeNotBetween(String value1, String value2)
         {
              addCriterion("system_type not between ", value1,value2, "system_type");
              return (Criteria) this;
         }

         public Criteria andBillParseIsNull()
         {
              addCriterion("bill_parse is null");
              return (Criteria) this;
         }

         public Criteria andBillParseIsNotNull()
         {
              addCriterion("bill_parse is not null");
              return (Criteria) this;
         }

         public Criteria andBillParseEqualTo(String value)
         {
              addCriterion("bill_parse = ", value, "bill_parse");
              return (Criteria) this;
         }

         public Criteria andBillParseNotEqualTo(String value)
         {
              addCriterion("bill_parse <> ", value, "bill_parse");
              return (Criteria) this;
         }

         public Criteria andBillParseGreaterThan(String value)
         {
              addCriterion("bill_parse > ", value, "bill_parse");
              return (Criteria) this;
         }

         public Criteria andBillParseGreaterThanOrEqualTo(String value)
         {
              addCriterion("bill_parse >= ", value, "bill_parse");
              return (Criteria) this;
         }

         public Criteria andBillParseLessThan(String value)
         {
              addCriterion("bill_parse < ", value, "bill_parse");
              return (Criteria) this;
         }

         public Criteria andBillParseLessThanOrEqualTo(String value)
         {
              addCriterion("bill_parse <= ", value, "bill_parse");
              return (Criteria) this;
         }

         public Criteria andBillParseLike(String value)
         {
              addCriterion("bill_parse like ", value, "bill_parse");
              return (Criteria) this;
         }

         public Criteria andBillParseNotLike(String value)
         {
              addCriterion("bill_parse not like ", value, "bill_parse");
              return (Criteria) this;
         }

         public Criteria andBillParseIn(List<String> values)
         {
              addCriterion("bill_parse in ", values, "bill_parse");
              return (Criteria) this;
         }

         public Criteria andBillParseNotIn(List<String> values)
         {
              addCriterion("bill_parse not in ", values, "bill_parse");
              return (Criteria) this;
         }

         public Criteria andBillParseBetween(String value1, String value2)
         {
              addCriterion("bill_parse between ", value1,value2, "bill_parse");
              return (Criteria) this;
         }

         public Criteria andBillParseNotBetween(String value1, String value2)
         {
              addCriterion("bill_parse not between ", value1,value2, "bill_parse");
              return (Criteria) this;
         }

         public Criteria andStServiceIsNull()
         {
              addCriterion("st_service is null");
              return (Criteria) this;
         }

         public Criteria andStServiceIsNotNull()
         {
              addCriterion("st_service is not null");
              return (Criteria) this;
         }

         public Criteria andStServiceEqualTo(String value)
         {
              addCriterion("st_service = ", value, "st_service");
              return (Criteria) this;
         }

         public Criteria andStServiceNotEqualTo(String value)
         {
              addCriterion("st_service <> ", value, "st_service");
              return (Criteria) this;
         }

         public Criteria andStServiceGreaterThan(String value)
         {
              addCriterion("st_service > ", value, "st_service");
              return (Criteria) this;
         }

         public Criteria andStServiceGreaterThanOrEqualTo(String value)
         {
              addCriterion("st_service >= ", value, "st_service");
              return (Criteria) this;
         }

         public Criteria andStServiceLessThan(String value)
         {
              addCriterion("st_service < ", value, "st_service");
              return (Criteria) this;
         }

         public Criteria andStServiceLessThanOrEqualTo(String value)
         {
              addCriterion("st_service <= ", value, "st_service");
              return (Criteria) this;
         }

         public Criteria andStServiceLike(String value)
         {
              addCriterion("st_service like ", value, "st_service");
              return (Criteria) this;
         }

         public Criteria andStServiceNotLike(String value)
         {
              addCriterion("st_service not like ", value, "st_service");
              return (Criteria) this;
         }

         public Criteria andStServiceIn(List<String> values)
         {
              addCriterion("st_service in ", values, "st_service");
              return (Criteria) this;
         }

         public Criteria andStServiceNotIn(List<String> values)
         {
              addCriterion("st_service not in ", values, "st_service");
              return (Criteria) this;
         }

         public Criteria andStServiceBetween(String value1, String value2)
         {
              addCriterion("st_service between ", value1,value2, "st_service");
              return (Criteria) this;
         }

         public Criteria andStServiceNotBetween(String value1, String value2)
         {
              addCriterion("st_service not between ", value1,value2, "st_service");
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
