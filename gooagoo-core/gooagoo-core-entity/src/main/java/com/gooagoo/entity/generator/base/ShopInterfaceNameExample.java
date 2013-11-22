package com.gooagoo.entity.generator.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 商家平台界面名称管理
 */

public class ShopInterfaceNameExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopInterfaceNameExample()
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

         public Criteria andNameCodeIsNull()
         {
              addCriterion("name_code is null");
              return (Criteria) this;
         }

         public Criteria andNameCodeIsNotNull()
         {
              addCriterion("name_code is not null");
              return (Criteria) this;
         }

         public Criteria andNameCodeEqualTo(String value)
         {
              addCriterion("name_code = ", value, "name_code");
              return (Criteria) this;
         }

         public Criteria andNameCodeNotEqualTo(String value)
         {
              addCriterion("name_code <> ", value, "name_code");
              return (Criteria) this;
         }

         public Criteria andNameCodeGreaterThan(String value)
         {
              addCriterion("name_code > ", value, "name_code");
              return (Criteria) this;
         }

         public Criteria andNameCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("name_code >= ", value, "name_code");
              return (Criteria) this;
         }

         public Criteria andNameCodeLessThan(String value)
         {
              addCriterion("name_code < ", value, "name_code");
              return (Criteria) this;
         }

         public Criteria andNameCodeLessThanOrEqualTo(String value)
         {
              addCriterion("name_code <= ", value, "name_code");
              return (Criteria) this;
         }

         public Criteria andNameCodeLike(String value)
         {
              addCriterion("name_code like ", value, "name_code");
              return (Criteria) this;
         }

         public Criteria andNameCodeNotLike(String value)
         {
              addCriterion("name_code not like ", value, "name_code");
              return (Criteria) this;
         }

         public Criteria andNameCodeIn(List<String> values)
         {
              addCriterion("name_code in ", values, "name_code");
              return (Criteria) this;
         }

         public Criteria andNameCodeNotIn(List<String> values)
         {
              addCriterion("name_code not in ", values, "name_code");
              return (Criteria) this;
         }

         public Criteria andNameCodeBetween(String value1, String value2)
         {
              addCriterion("name_code between ", value1,value2, "name_code");
              return (Criteria) this;
         }

         public Criteria andNameCodeNotBetween(String value1, String value2)
         {
              addCriterion("name_code not between ", value1,value2, "name_code");
              return (Criteria) this;
         }

         public Criteria andNameValueIsNull()
         {
              addCriterion("name_value is null");
              return (Criteria) this;
         }

         public Criteria andNameValueIsNotNull()
         {
              addCriterion("name_value is not null");
              return (Criteria) this;
         }

         public Criteria andNameValueEqualTo(String value)
         {
              addCriterion("name_value = ", value, "name_value");
              return (Criteria) this;
         }

         public Criteria andNameValueNotEqualTo(String value)
         {
              addCriterion("name_value <> ", value, "name_value");
              return (Criteria) this;
         }

         public Criteria andNameValueGreaterThan(String value)
         {
              addCriterion("name_value > ", value, "name_value");
              return (Criteria) this;
         }

         public Criteria andNameValueGreaterThanOrEqualTo(String value)
         {
              addCriterion("name_value >= ", value, "name_value");
              return (Criteria) this;
         }

         public Criteria andNameValueLessThan(String value)
         {
              addCriterion("name_value < ", value, "name_value");
              return (Criteria) this;
         }

         public Criteria andNameValueLessThanOrEqualTo(String value)
         {
              addCriterion("name_value <= ", value, "name_value");
              return (Criteria) this;
         }

         public Criteria andNameValueLike(String value)
         {
              addCriterion("name_value like ", value, "name_value");
              return (Criteria) this;
         }

         public Criteria andNameValueNotLike(String value)
         {
              addCriterion("name_value not like ", value, "name_value");
              return (Criteria) this;
         }

         public Criteria andNameValueIn(List<String> values)
         {
              addCriterion("name_value in ", values, "name_value");
              return (Criteria) this;
         }

         public Criteria andNameValueNotIn(List<String> values)
         {
              addCriterion("name_value not in ", values, "name_value");
              return (Criteria) this;
         }

         public Criteria andNameValueBetween(String value1, String value2)
         {
              addCriterion("name_value between ", value1,value2, "name_value");
              return (Criteria) this;
         }

         public Criteria andNameValueNotBetween(String value1, String value2)
         {
              addCriterion("name_value not between ", value1,value2, "name_value");
              return (Criteria) this;
         }

         public Criteria andSysIsNull()
         {
              addCriterion("sys is null");
              return (Criteria) this;
         }

         public Criteria andSysIsNotNull()
         {
              addCriterion("sys is not null");
              return (Criteria) this;
         }

         public Criteria andSysEqualTo(String value)
         {
              addCriterion("sys = ", value, "sys");
              return (Criteria) this;
         }

         public Criteria andSysNotEqualTo(String value)
         {
              addCriterion("sys <> ", value, "sys");
              return (Criteria) this;
         }

         public Criteria andSysGreaterThan(String value)
         {
              addCriterion("sys > ", value, "sys");
              return (Criteria) this;
         }

         public Criteria andSysGreaterThanOrEqualTo(String value)
         {
              addCriterion("sys >= ", value, "sys");
              return (Criteria) this;
         }

         public Criteria andSysLessThan(String value)
         {
              addCriterion("sys < ", value, "sys");
              return (Criteria) this;
         }

         public Criteria andSysLessThanOrEqualTo(String value)
         {
              addCriterion("sys <= ", value, "sys");
              return (Criteria) this;
         }

         public Criteria andSysLike(String value)
         {
              addCriterion("sys like ", value, "sys");
              return (Criteria) this;
         }

         public Criteria andSysNotLike(String value)
         {
              addCriterion("sys not like ", value, "sys");
              return (Criteria) this;
         }

         public Criteria andSysIn(List<String> values)
         {
              addCriterion("sys in ", values, "sys");
              return (Criteria) this;
         }

         public Criteria andSysNotIn(List<String> values)
         {
              addCriterion("sys not in ", values, "sys");
              return (Criteria) this;
         }

         public Criteria andSysBetween(String value1, String value2)
         {
              addCriterion("sys between ", value1,value2, "sys");
              return (Criteria) this;
         }

         public Criteria andSysNotBetween(String value1, String value2)
         {
              addCriterion("sys not between ", value1,value2, "sys");
              return (Criteria) this;
         }

         public Criteria andModuleIsNull()
         {
              addCriterion("module is null");
              return (Criteria) this;
         }

         public Criteria andModuleIsNotNull()
         {
              addCriterion("module is not null");
              return (Criteria) this;
         }

         public Criteria andModuleEqualTo(String value)
         {
              addCriterion("module = ", value, "module");
              return (Criteria) this;
         }

         public Criteria andModuleNotEqualTo(String value)
         {
              addCriterion("module <> ", value, "module");
              return (Criteria) this;
         }

         public Criteria andModuleGreaterThan(String value)
         {
              addCriterion("module > ", value, "module");
              return (Criteria) this;
         }

         public Criteria andModuleGreaterThanOrEqualTo(String value)
         {
              addCriterion("module >= ", value, "module");
              return (Criteria) this;
         }

         public Criteria andModuleLessThan(String value)
         {
              addCriterion("module < ", value, "module");
              return (Criteria) this;
         }

         public Criteria andModuleLessThanOrEqualTo(String value)
         {
              addCriterion("module <= ", value, "module");
              return (Criteria) this;
         }

         public Criteria andModuleLike(String value)
         {
              addCriterion("module like ", value, "module");
              return (Criteria) this;
         }

         public Criteria andModuleNotLike(String value)
         {
              addCriterion("module not like ", value, "module");
              return (Criteria) this;
         }

         public Criteria andModuleIn(List<String> values)
         {
              addCriterion("module in ", values, "module");
              return (Criteria) this;
         }

         public Criteria andModuleNotIn(List<String> values)
         {
              addCriterion("module not in ", values, "module");
              return (Criteria) this;
         }

         public Criteria andModuleBetween(String value1, String value2)
         {
              addCriterion("module between ", value1,value2, "module");
              return (Criteria) this;
         }

         public Criteria andModuleNotBetween(String value1, String value2)
         {
              addCriterion("module not between ", value1,value2, "module");
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

         public Criteria andVersionIsNull()
         {
              addCriterion("version is null");
              return (Criteria) this;
         }

         public Criteria andVersionIsNotNull()
         {
              addCriterion("version is not null");
              return (Criteria) this;
         }

         public Criteria andVersionEqualTo(String value)
         {
              addCriterion("version = ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionNotEqualTo(String value)
         {
              addCriterion("version <> ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionGreaterThan(String value)
         {
              addCriterion("version > ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionGreaterThanOrEqualTo(String value)
         {
              addCriterion("version >= ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionLessThan(String value)
         {
              addCriterion("version < ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionLessThanOrEqualTo(String value)
         {
              addCriterion("version <= ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionLike(String value)
         {
              addCriterion("version like ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionNotLike(String value)
         {
              addCriterion("version not like ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionIn(List<String> values)
         {
              addCriterion("version in ", values, "version");
              return (Criteria) this;
         }

         public Criteria andVersionNotIn(List<String> values)
         {
              addCriterion("version not in ", values, "version");
              return (Criteria) this;
         }

         public Criteria andVersionBetween(String value1, String value2)
         {
              addCriterion("version between ", value1,value2, "version");
              return (Criteria) this;
         }

         public Criteria andVersionNotBetween(String value1, String value2)
         {
              addCriterion("version not between ", value1,value2, "version");
              return (Criteria) this;
         }

         public Criteria andVersionNoteIsNull()
         {
              addCriterion("version_note is null");
              return (Criteria) this;
         }

         public Criteria andVersionNoteIsNotNull()
         {
              addCriterion("version_note is not null");
              return (Criteria) this;
         }

         public Criteria andVersionNoteEqualTo(String value)
         {
              addCriterion("version_note = ", value, "version_note");
              return (Criteria) this;
         }

         public Criteria andVersionNoteNotEqualTo(String value)
         {
              addCriterion("version_note <> ", value, "version_note");
              return (Criteria) this;
         }

         public Criteria andVersionNoteGreaterThan(String value)
         {
              addCriterion("version_note > ", value, "version_note");
              return (Criteria) this;
         }

         public Criteria andVersionNoteGreaterThanOrEqualTo(String value)
         {
              addCriterion("version_note >= ", value, "version_note");
              return (Criteria) this;
         }

         public Criteria andVersionNoteLessThan(String value)
         {
              addCriterion("version_note < ", value, "version_note");
              return (Criteria) this;
         }

         public Criteria andVersionNoteLessThanOrEqualTo(String value)
         {
              addCriterion("version_note <= ", value, "version_note");
              return (Criteria) this;
         }

         public Criteria andVersionNoteLike(String value)
         {
              addCriterion("version_note like ", value, "version_note");
              return (Criteria) this;
         }

         public Criteria andVersionNoteNotLike(String value)
         {
              addCriterion("version_note not like ", value, "version_note");
              return (Criteria) this;
         }

         public Criteria andVersionNoteIn(List<String> values)
         {
              addCriterion("version_note in ", values, "version_note");
              return (Criteria) this;
         }

         public Criteria andVersionNoteNotIn(List<String> values)
         {
              addCriterion("version_note not in ", values, "version_note");
              return (Criteria) this;
         }

         public Criteria andVersionNoteBetween(String value1, String value2)
         {
              addCriterion("version_note between ", value1,value2, "version_note");
              return (Criteria) this;
         }

         public Criteria andVersionNoteNotBetween(String value1, String value2)
         {
              addCriterion("version_note not between ", value1,value2, "version_note");
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
