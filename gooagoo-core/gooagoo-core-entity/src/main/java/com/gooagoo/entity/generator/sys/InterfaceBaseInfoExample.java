package com.gooagoo.entity.generator.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 接口基础信息表
 */

public class InterfaceBaseInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public InterfaceBaseInfoExample()
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

         public Criteria andICodeIsNull()
         {
              addCriterion("i_code is null");
              return (Criteria) this;
         }

         public Criteria andICodeIsNotNull()
         {
              addCriterion("i_code is not null");
              return (Criteria) this;
         }

         public Criteria andICodeEqualTo(String value)
         {
              addCriterion("i_code = ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeNotEqualTo(String value)
         {
              addCriterion("i_code <> ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeGreaterThan(String value)
         {
              addCriterion("i_code > ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("i_code >= ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeLessThan(String value)
         {
              addCriterion("i_code < ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeLessThanOrEqualTo(String value)
         {
              addCriterion("i_code <= ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeLike(String value)
         {
              addCriterion("i_code like ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeNotLike(String value)
         {
              addCriterion("i_code not like ", value, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeIn(List<String> values)
         {
              addCriterion("i_code in ", values, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeNotIn(List<String> values)
         {
              addCriterion("i_code not in ", values, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeBetween(String value1, String value2)
         {
              addCriterion("i_code between ", value1,value2, "i_code");
              return (Criteria) this;
         }

         public Criteria andICodeNotBetween(String value1, String value2)
         {
              addCriterion("i_code not between ", value1,value2, "i_code");
              return (Criteria) this;
         }

         public Criteria andINameIsNull()
         {
              addCriterion("i_name is null");
              return (Criteria) this;
         }

         public Criteria andINameIsNotNull()
         {
              addCriterion("i_name is not null");
              return (Criteria) this;
         }

         public Criteria andINameEqualTo(String value)
         {
              addCriterion("i_name = ", value, "i_name");
              return (Criteria) this;
         }

         public Criteria andINameNotEqualTo(String value)
         {
              addCriterion("i_name <> ", value, "i_name");
              return (Criteria) this;
         }

         public Criteria andINameGreaterThan(String value)
         {
              addCriterion("i_name > ", value, "i_name");
              return (Criteria) this;
         }

         public Criteria andINameGreaterThanOrEqualTo(String value)
         {
              addCriterion("i_name >= ", value, "i_name");
              return (Criteria) this;
         }

         public Criteria andINameLessThan(String value)
         {
              addCriterion("i_name < ", value, "i_name");
              return (Criteria) this;
         }

         public Criteria andINameLessThanOrEqualTo(String value)
         {
              addCriterion("i_name <= ", value, "i_name");
              return (Criteria) this;
         }

         public Criteria andINameLike(String value)
         {
              addCriterion("i_name like ", value, "i_name");
              return (Criteria) this;
         }

         public Criteria andINameNotLike(String value)
         {
              addCriterion("i_name not like ", value, "i_name");
              return (Criteria) this;
         }

         public Criteria andINameIn(List<String> values)
         {
              addCriterion("i_name in ", values, "i_name");
              return (Criteria) this;
         }

         public Criteria andINameNotIn(List<String> values)
         {
              addCriterion("i_name not in ", values, "i_name");
              return (Criteria) this;
         }

         public Criteria andINameBetween(String value1, String value2)
         {
              addCriterion("i_name between ", value1,value2, "i_name");
              return (Criteria) this;
         }

         public Criteria andINameNotBetween(String value1, String value2)
         {
              addCriterion("i_name not between ", value1,value2, "i_name");
              return (Criteria) this;
         }

         public Criteria andITypeIsNull()
         {
              addCriterion("i_type is null");
              return (Criteria) this;
         }

         public Criteria andITypeIsNotNull()
         {
              addCriterion("i_type is not null");
              return (Criteria) this;
         }

         public Criteria andITypeEqualTo(String value)
         {
              addCriterion("i_type = ", value, "i_type");
              return (Criteria) this;
         }

         public Criteria andITypeNotEqualTo(String value)
         {
              addCriterion("i_type <> ", value, "i_type");
              return (Criteria) this;
         }

         public Criteria andITypeGreaterThan(String value)
         {
              addCriterion("i_type > ", value, "i_type");
              return (Criteria) this;
         }

         public Criteria andITypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("i_type >= ", value, "i_type");
              return (Criteria) this;
         }

         public Criteria andITypeLessThan(String value)
         {
              addCriterion("i_type < ", value, "i_type");
              return (Criteria) this;
         }

         public Criteria andITypeLessThanOrEqualTo(String value)
         {
              addCriterion("i_type <= ", value, "i_type");
              return (Criteria) this;
         }

         public Criteria andITypeLike(String value)
         {
              addCriterion("i_type like ", value, "i_type");
              return (Criteria) this;
         }

         public Criteria andITypeNotLike(String value)
         {
              addCriterion("i_type not like ", value, "i_type");
              return (Criteria) this;
         }

         public Criteria andITypeIn(List<String> values)
         {
              addCriterion("i_type in ", values, "i_type");
              return (Criteria) this;
         }

         public Criteria andITypeNotIn(List<String> values)
         {
              addCriterion("i_type not in ", values, "i_type");
              return (Criteria) this;
         }

         public Criteria andITypeBetween(String value1, String value2)
         {
              addCriterion("i_type between ", value1,value2, "i_type");
              return (Criteria) this;
         }

         public Criteria andITypeNotBetween(String value1, String value2)
         {
              addCriterion("i_type not between ", value1,value2, "i_type");
              return (Criteria) this;
         }

         public Criteria andIFunctionIsNull()
         {
              addCriterion("i_function is null");
              return (Criteria) this;
         }

         public Criteria andIFunctionIsNotNull()
         {
              addCriterion("i_function is not null");
              return (Criteria) this;
         }

         public Criteria andIFunctionEqualTo(String value)
         {
              addCriterion("i_function = ", value, "i_function");
              return (Criteria) this;
         }

         public Criteria andIFunctionNotEqualTo(String value)
         {
              addCriterion("i_function <> ", value, "i_function");
              return (Criteria) this;
         }

         public Criteria andIFunctionGreaterThan(String value)
         {
              addCriterion("i_function > ", value, "i_function");
              return (Criteria) this;
         }

         public Criteria andIFunctionGreaterThanOrEqualTo(String value)
         {
              addCriterion("i_function >= ", value, "i_function");
              return (Criteria) this;
         }

         public Criteria andIFunctionLessThan(String value)
         {
              addCriterion("i_function < ", value, "i_function");
              return (Criteria) this;
         }

         public Criteria andIFunctionLessThanOrEqualTo(String value)
         {
              addCriterion("i_function <= ", value, "i_function");
              return (Criteria) this;
         }

         public Criteria andIFunctionLike(String value)
         {
              addCriterion("i_function like ", value, "i_function");
              return (Criteria) this;
         }

         public Criteria andIFunctionNotLike(String value)
         {
              addCriterion("i_function not like ", value, "i_function");
              return (Criteria) this;
         }

         public Criteria andIFunctionIn(List<String> values)
         {
              addCriterion("i_function in ", values, "i_function");
              return (Criteria) this;
         }

         public Criteria andIFunctionNotIn(List<String> values)
         {
              addCriterion("i_function not in ", values, "i_function");
              return (Criteria) this;
         }

         public Criteria andIFunctionBetween(String value1, String value2)
         {
              addCriterion("i_function between ", value1,value2, "i_function");
              return (Criteria) this;
         }

         public Criteria andIFunctionNotBetween(String value1, String value2)
         {
              addCriterion("i_function not between ", value1,value2, "i_function");
              return (Criteria) this;
         }

         public Criteria andIUrlIsNull()
         {
              addCriterion("i_url is null");
              return (Criteria) this;
         }

         public Criteria andIUrlIsNotNull()
         {
              addCriterion("i_url is not null");
              return (Criteria) this;
         }

         public Criteria andIUrlEqualTo(String value)
         {
              addCriterion("i_url = ", value, "i_url");
              return (Criteria) this;
         }

         public Criteria andIUrlNotEqualTo(String value)
         {
              addCriterion("i_url <> ", value, "i_url");
              return (Criteria) this;
         }

         public Criteria andIUrlGreaterThan(String value)
         {
              addCriterion("i_url > ", value, "i_url");
              return (Criteria) this;
         }

         public Criteria andIUrlGreaterThanOrEqualTo(String value)
         {
              addCriterion("i_url >= ", value, "i_url");
              return (Criteria) this;
         }

         public Criteria andIUrlLessThan(String value)
         {
              addCriterion("i_url < ", value, "i_url");
              return (Criteria) this;
         }

         public Criteria andIUrlLessThanOrEqualTo(String value)
         {
              addCriterion("i_url <= ", value, "i_url");
              return (Criteria) this;
         }

         public Criteria andIUrlLike(String value)
         {
              addCriterion("i_url like ", value, "i_url");
              return (Criteria) this;
         }

         public Criteria andIUrlNotLike(String value)
         {
              addCriterion("i_url not like ", value, "i_url");
              return (Criteria) this;
         }

         public Criteria andIUrlIn(List<String> values)
         {
              addCriterion("i_url in ", values, "i_url");
              return (Criteria) this;
         }

         public Criteria andIUrlNotIn(List<String> values)
         {
              addCriterion("i_url not in ", values, "i_url");
              return (Criteria) this;
         }

         public Criteria andIUrlBetween(String value1, String value2)
         {
              addCriterion("i_url between ", value1,value2, "i_url");
              return (Criteria) this;
         }

         public Criteria andIUrlNotBetween(String value1, String value2)
         {
              addCriterion("i_url not between ", value1,value2, "i_url");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeIsNull()
         {
              addCriterion("behave_type is null");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeIsNotNull()
         {
              addCriterion("behave_type is not null");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeEqualTo(String value)
         {
              addCriterion("behave_type = ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeNotEqualTo(String value)
         {
              addCriterion("behave_type <> ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeGreaterThan(String value)
         {
              addCriterion("behave_type > ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("behave_type >= ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeLessThan(String value)
         {
              addCriterion("behave_type < ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeLessThanOrEqualTo(String value)
         {
              addCriterion("behave_type <= ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeLike(String value)
         {
              addCriterion("behave_type like ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeNotLike(String value)
         {
              addCriterion("behave_type not like ", value, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeIn(List<String> values)
         {
              addCriterion("behave_type in ", values, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeNotIn(List<String> values)
         {
              addCriterion("behave_type not in ", values, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeBetween(String value1, String value2)
         {
              addCriterion("behave_type between ", value1,value2, "behave_type");
              return (Criteria) this;
         }

         public Criteria andBehaveTypeNotBetween(String value1, String value2)
         {
              addCriterion("behave_type not between ", value1,value2, "behave_type");
              return (Criteria) this;
         }

         public Criteria andCanAllocateIsNull()
         {
              addCriterion("can_allocate is null");
              return (Criteria) this;
         }

         public Criteria andCanAllocateIsNotNull()
         {
              addCriterion("can_allocate is not null");
              return (Criteria) this;
         }

         public Criteria andCanAllocateEqualTo(String value)
         {
              addCriterion("can_allocate = ", value, "can_allocate");
              return (Criteria) this;
         }

         public Criteria andCanAllocateNotEqualTo(String value)
         {
              addCriterion("can_allocate <> ", value, "can_allocate");
              return (Criteria) this;
         }

         public Criteria andCanAllocateGreaterThan(String value)
         {
              addCriterion("can_allocate > ", value, "can_allocate");
              return (Criteria) this;
         }

         public Criteria andCanAllocateGreaterThanOrEqualTo(String value)
         {
              addCriterion("can_allocate >= ", value, "can_allocate");
              return (Criteria) this;
         }

         public Criteria andCanAllocateLessThan(String value)
         {
              addCriterion("can_allocate < ", value, "can_allocate");
              return (Criteria) this;
         }

         public Criteria andCanAllocateLessThanOrEqualTo(String value)
         {
              addCriterion("can_allocate <= ", value, "can_allocate");
              return (Criteria) this;
         }

         public Criteria andCanAllocateLike(String value)
         {
              addCriterion("can_allocate like ", value, "can_allocate");
              return (Criteria) this;
         }

         public Criteria andCanAllocateNotLike(String value)
         {
              addCriterion("can_allocate not like ", value, "can_allocate");
              return (Criteria) this;
         }

         public Criteria andCanAllocateIn(List<String> values)
         {
              addCriterion("can_allocate in ", values, "can_allocate");
              return (Criteria) this;
         }

         public Criteria andCanAllocateNotIn(List<String> values)
         {
              addCriterion("can_allocate not in ", values, "can_allocate");
              return (Criteria) this;
         }

         public Criteria andCanAllocateBetween(String value1, String value2)
         {
              addCriterion("can_allocate between ", value1,value2, "can_allocate");
              return (Criteria) this;
         }

         public Criteria andCanAllocateNotBetween(String value1, String value2)
         {
              addCriterion("can_allocate not between ", value1,value2, "can_allocate");
              return (Criteria) this;
         }

         public Criteria andDataXmlIsNull()
         {
              addCriterion("data_xml is null");
              return (Criteria) this;
         }

         public Criteria andDataXmlIsNotNull()
         {
              addCriterion("data_xml is not null");
              return (Criteria) this;
         }

         public Criteria andDataXmlEqualTo(String value)
         {
              addCriterion("data_xml = ", value, "data_xml");
              return (Criteria) this;
         }

         public Criteria andDataXmlNotEqualTo(String value)
         {
              addCriterion("data_xml <> ", value, "data_xml");
              return (Criteria) this;
         }

         public Criteria andDataXmlGreaterThan(String value)
         {
              addCriterion("data_xml > ", value, "data_xml");
              return (Criteria) this;
         }

         public Criteria andDataXmlGreaterThanOrEqualTo(String value)
         {
              addCriterion("data_xml >= ", value, "data_xml");
              return (Criteria) this;
         }

         public Criteria andDataXmlLessThan(String value)
         {
              addCriterion("data_xml < ", value, "data_xml");
              return (Criteria) this;
         }

         public Criteria andDataXmlLessThanOrEqualTo(String value)
         {
              addCriterion("data_xml <= ", value, "data_xml");
              return (Criteria) this;
         }

         public Criteria andDataXmlLike(String value)
         {
              addCriterion("data_xml like ", value, "data_xml");
              return (Criteria) this;
         }

         public Criteria andDataXmlNotLike(String value)
         {
              addCriterion("data_xml not like ", value, "data_xml");
              return (Criteria) this;
         }

         public Criteria andDataXmlIn(List<String> values)
         {
              addCriterion("data_xml in ", values, "data_xml");
              return (Criteria) this;
         }

         public Criteria andDataXmlNotIn(List<String> values)
         {
              addCriterion("data_xml not in ", values, "data_xml");
              return (Criteria) this;
         }

         public Criteria andDataXmlBetween(String value1, String value2)
         {
              addCriterion("data_xml between ", value1,value2, "data_xml");
              return (Criteria) this;
         }

         public Criteria andDataXmlNotBetween(String value1, String value2)
         {
              addCriterion("data_xml not between ", value1,value2, "data_xml");
              return (Criteria) this;
         }

         public Criteria andDataJsonIsNull()
         {
              addCriterion("data_json is null");
              return (Criteria) this;
         }

         public Criteria andDataJsonIsNotNull()
         {
              addCriterion("data_json is not null");
              return (Criteria) this;
         }

         public Criteria andDataJsonEqualTo(String value)
         {
              addCriterion("data_json = ", value, "data_json");
              return (Criteria) this;
         }

         public Criteria andDataJsonNotEqualTo(String value)
         {
              addCriterion("data_json <> ", value, "data_json");
              return (Criteria) this;
         }

         public Criteria andDataJsonGreaterThan(String value)
         {
              addCriterion("data_json > ", value, "data_json");
              return (Criteria) this;
         }

         public Criteria andDataJsonGreaterThanOrEqualTo(String value)
         {
              addCriterion("data_json >= ", value, "data_json");
              return (Criteria) this;
         }

         public Criteria andDataJsonLessThan(String value)
         {
              addCriterion("data_json < ", value, "data_json");
              return (Criteria) this;
         }

         public Criteria andDataJsonLessThanOrEqualTo(String value)
         {
              addCriterion("data_json <= ", value, "data_json");
              return (Criteria) this;
         }

         public Criteria andDataJsonLike(String value)
         {
              addCriterion("data_json like ", value, "data_json");
              return (Criteria) this;
         }

         public Criteria andDataJsonNotLike(String value)
         {
              addCriterion("data_json not like ", value, "data_json");
              return (Criteria) this;
         }

         public Criteria andDataJsonIn(List<String> values)
         {
              addCriterion("data_json in ", values, "data_json");
              return (Criteria) this;
         }

         public Criteria andDataJsonNotIn(List<String> values)
         {
              addCriterion("data_json not in ", values, "data_json");
              return (Criteria) this;
         }

         public Criteria andDataJsonBetween(String value1, String value2)
         {
              addCriterion("data_json between ", value1,value2, "data_json");
              return (Criteria) this;
         }

         public Criteria andDataJsonNotBetween(String value1, String value2)
         {
              addCriterion("data_json not between ", value1,value2, "data_json");
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
