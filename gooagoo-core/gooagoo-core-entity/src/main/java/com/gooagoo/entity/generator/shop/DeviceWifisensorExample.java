package com.gooagoo.entity.generator.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 商家wifisensor设备表
 */

public class DeviceWifisensorExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public DeviceWifisensorExample()
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

         public Criteria andDeviceWifisensorIdIsNull()
         {
              addCriterion("device_wifisensor_id is null");
              return (Criteria) this;
         }

         public Criteria andDeviceWifisensorIdIsNotNull()
         {
              addCriterion("device_wifisensor_id is not null");
              return (Criteria) this;
         }

         public Criteria andDeviceWifisensorIdEqualTo(String value)
         {
              addCriterion("device_wifisensor_id = ", value, "device_wifisensor_id");
              return (Criteria) this;
         }

         public Criteria andDeviceWifisensorIdNotEqualTo(String value)
         {
              addCriterion("device_wifisensor_id <> ", value, "device_wifisensor_id");
              return (Criteria) this;
         }

         public Criteria andDeviceWifisensorIdGreaterThan(String value)
         {
              addCriterion("device_wifisensor_id > ", value, "device_wifisensor_id");
              return (Criteria) this;
         }

         public Criteria andDeviceWifisensorIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("device_wifisensor_id >= ", value, "device_wifisensor_id");
              return (Criteria) this;
         }

         public Criteria andDeviceWifisensorIdLessThan(String value)
         {
              addCriterion("device_wifisensor_id < ", value, "device_wifisensor_id");
              return (Criteria) this;
         }

         public Criteria andDeviceWifisensorIdLessThanOrEqualTo(String value)
         {
              addCriterion("device_wifisensor_id <= ", value, "device_wifisensor_id");
              return (Criteria) this;
         }

         public Criteria andDeviceWifisensorIdLike(String value)
         {
              addCriterion("device_wifisensor_id like ", value, "device_wifisensor_id");
              return (Criteria) this;
         }

         public Criteria andDeviceWifisensorIdNotLike(String value)
         {
              addCriterion("device_wifisensor_id not like ", value, "device_wifisensor_id");
              return (Criteria) this;
         }

         public Criteria andDeviceWifisensorIdIn(List<String> values)
         {
              addCriterion("device_wifisensor_id in ", values, "device_wifisensor_id");
              return (Criteria) this;
         }

         public Criteria andDeviceWifisensorIdNotIn(List<String> values)
         {
              addCriterion("device_wifisensor_id not in ", values, "device_wifisensor_id");
              return (Criteria) this;
         }

         public Criteria andDeviceWifisensorIdBetween(String value1, String value2)
         {
              addCriterion("device_wifisensor_id between ", value1,value2, "device_wifisensor_id");
              return (Criteria) this;
         }

         public Criteria andDeviceWifisensorIdNotBetween(String value1, String value2)
         {
              addCriterion("device_wifisensor_id not between ", value1,value2, "device_wifisensor_id");
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

         public Criteria andPositionNameIsNull()
         {
              addCriterion("position_name is null");
              return (Criteria) this;
         }

         public Criteria andPositionNameIsNotNull()
         {
              addCriterion("position_name is not null");
              return (Criteria) this;
         }

         public Criteria andPositionNameEqualTo(String value)
         {
              addCriterion("position_name = ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameNotEqualTo(String value)
         {
              addCriterion("position_name <> ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameGreaterThan(String value)
         {
              addCriterion("position_name > ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("position_name >= ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameLessThan(String value)
         {
              addCriterion("position_name < ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameLessThanOrEqualTo(String value)
         {
              addCriterion("position_name <= ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameLike(String value)
         {
              addCriterion("position_name like ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameNotLike(String value)
         {
              addCriterion("position_name not like ", value, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameIn(List<String> values)
         {
              addCriterion("position_name in ", values, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameNotIn(List<String> values)
         {
              addCriterion("position_name not in ", values, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameBetween(String value1, String value2)
         {
              addCriterion("position_name between ", value1,value2, "position_name");
              return (Criteria) this;
         }

         public Criteria andPositionNameNotBetween(String value1, String value2)
         {
              addCriterion("position_name not between ", value1,value2, "position_name");
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

         public Criteria andPxIsNull()
         {
              addCriterion("px is null");
              return (Criteria) this;
         }

         public Criteria andPxIsNotNull()
         {
              addCriterion("px is not null");
              return (Criteria) this;
         }

         public Criteria andPxEqualTo(String value)
         {
              addCriterion("px = ", value, "px");
              return (Criteria) this;
         }

         public Criteria andPxNotEqualTo(String value)
         {
              addCriterion("px <> ", value, "px");
              return (Criteria) this;
         }

         public Criteria andPxGreaterThan(String value)
         {
              addCriterion("px > ", value, "px");
              return (Criteria) this;
         }

         public Criteria andPxGreaterThanOrEqualTo(String value)
         {
              addCriterion("px >= ", value, "px");
              return (Criteria) this;
         }

         public Criteria andPxLessThan(String value)
         {
              addCriterion("px < ", value, "px");
              return (Criteria) this;
         }

         public Criteria andPxLessThanOrEqualTo(String value)
         {
              addCriterion("px <= ", value, "px");
              return (Criteria) this;
         }

         public Criteria andPxLike(String value)
         {
              addCriterion("px like ", value, "px");
              return (Criteria) this;
         }

         public Criteria andPxNotLike(String value)
         {
              addCriterion("px not like ", value, "px");
              return (Criteria) this;
         }

         public Criteria andPxIn(List<String> values)
         {
              addCriterion("px in ", values, "px");
              return (Criteria) this;
         }

         public Criteria andPxNotIn(List<String> values)
         {
              addCriterion("px not in ", values, "px");
              return (Criteria) this;
         }

         public Criteria andPxBetween(String value1, String value2)
         {
              addCriterion("px between ", value1,value2, "px");
              return (Criteria) this;
         }

         public Criteria andPxNotBetween(String value1, String value2)
         {
              addCriterion("px not between ", value1,value2, "px");
              return (Criteria) this;
         }

         public Criteria andPyIsNull()
         {
              addCriterion("py is null");
              return (Criteria) this;
         }

         public Criteria andPyIsNotNull()
         {
              addCriterion("py is not null");
              return (Criteria) this;
         }

         public Criteria andPyEqualTo(String value)
         {
              addCriterion("py = ", value, "py");
              return (Criteria) this;
         }

         public Criteria andPyNotEqualTo(String value)
         {
              addCriterion("py <> ", value, "py");
              return (Criteria) this;
         }

         public Criteria andPyGreaterThan(String value)
         {
              addCriterion("py > ", value, "py");
              return (Criteria) this;
         }

         public Criteria andPyGreaterThanOrEqualTo(String value)
         {
              addCriterion("py >= ", value, "py");
              return (Criteria) this;
         }

         public Criteria andPyLessThan(String value)
         {
              addCriterion("py < ", value, "py");
              return (Criteria) this;
         }

         public Criteria andPyLessThanOrEqualTo(String value)
         {
              addCriterion("py <= ", value, "py");
              return (Criteria) this;
         }

         public Criteria andPyLike(String value)
         {
              addCriterion("py like ", value, "py");
              return (Criteria) this;
         }

         public Criteria andPyNotLike(String value)
         {
              addCriterion("py not like ", value, "py");
              return (Criteria) this;
         }

         public Criteria andPyIn(List<String> values)
         {
              addCriterion("py in ", values, "py");
              return (Criteria) this;
         }

         public Criteria andPyNotIn(List<String> values)
         {
              addCriterion("py not in ", values, "py");
              return (Criteria) this;
         }

         public Criteria andPyBetween(String value1, String value2)
         {
              addCriterion("py between ", value1,value2, "py");
              return (Criteria) this;
         }

         public Criteria andPyNotBetween(String value1, String value2)
         {
              addCriterion("py not between ", value1,value2, "py");
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