package com.gooagoo.entity.generator.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 省份城市字典表
 */

public class UserCityareaExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public UserCityareaExample()
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

         public Criteria andCityIdIsNull()
         {
              addCriterion("city_id is null");
              return (Criteria) this;
         }

         public Criteria andCityIdIsNotNull()
         {
              addCriterion("city_id is not null");
              return (Criteria) this;
         }

         public Criteria andCityIdEqualTo(String value)
         {
              addCriterion("city_id = ", value, "city_id");
              return (Criteria) this;
         }

         public Criteria andCityIdNotEqualTo(String value)
         {
              addCriterion("city_id <> ", value, "city_id");
              return (Criteria) this;
         }

         public Criteria andCityIdGreaterThan(String value)
         {
              addCriterion("city_id > ", value, "city_id");
              return (Criteria) this;
         }

         public Criteria andCityIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("city_id >= ", value, "city_id");
              return (Criteria) this;
         }

         public Criteria andCityIdLessThan(String value)
         {
              addCriterion("city_id < ", value, "city_id");
              return (Criteria) this;
         }

         public Criteria andCityIdLessThanOrEqualTo(String value)
         {
              addCriterion("city_id <= ", value, "city_id");
              return (Criteria) this;
         }

         public Criteria andCityIdLike(String value)
         {
              addCriterion("city_id like ", value, "city_id");
              return (Criteria) this;
         }

         public Criteria andCityIdNotLike(String value)
         {
              addCriterion("city_id not like ", value, "city_id");
              return (Criteria) this;
         }

         public Criteria andCityIdIn(List<String> values)
         {
              addCriterion("city_id in ", values, "city_id");
              return (Criteria) this;
         }

         public Criteria andCityIdNotIn(List<String> values)
         {
              addCriterion("city_id not in ", values, "city_id");
              return (Criteria) this;
         }

         public Criteria andCityIdBetween(String value1, String value2)
         {
              addCriterion("city_id between ", value1,value2, "city_id");
              return (Criteria) this;
         }

         public Criteria andCityIdNotBetween(String value1, String value2)
         {
              addCriterion("city_id not between ", value1,value2, "city_id");
              return (Criteria) this;
         }

         public Criteria andCityNameIsNull()
         {
              addCriterion("city_name is null");
              return (Criteria) this;
         }

         public Criteria andCityNameIsNotNull()
         {
              addCriterion("city_name is not null");
              return (Criteria) this;
         }

         public Criteria andCityNameEqualTo(String value)
         {
              addCriterion("city_name = ", value, "city_name");
              return (Criteria) this;
         }

         public Criteria andCityNameNotEqualTo(String value)
         {
              addCriterion("city_name <> ", value, "city_name");
              return (Criteria) this;
         }

         public Criteria andCityNameGreaterThan(String value)
         {
              addCriterion("city_name > ", value, "city_name");
              return (Criteria) this;
         }

         public Criteria andCityNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("city_name >= ", value, "city_name");
              return (Criteria) this;
         }

         public Criteria andCityNameLessThan(String value)
         {
              addCriterion("city_name < ", value, "city_name");
              return (Criteria) this;
         }

         public Criteria andCityNameLessThanOrEqualTo(String value)
         {
              addCriterion("city_name <= ", value, "city_name");
              return (Criteria) this;
         }

         public Criteria andCityNameLike(String value)
         {
              addCriterion("city_name like ", value, "city_name");
              return (Criteria) this;
         }

         public Criteria andCityNameNotLike(String value)
         {
              addCriterion("city_name not like ", value, "city_name");
              return (Criteria) this;
         }

         public Criteria andCityNameIn(List<String> values)
         {
              addCriterion("city_name in ", values, "city_name");
              return (Criteria) this;
         }

         public Criteria andCityNameNotIn(List<String> values)
         {
              addCriterion("city_name not in ", values, "city_name");
              return (Criteria) this;
         }

         public Criteria andCityNameBetween(String value1, String value2)
         {
              addCriterion("city_name between ", value1,value2, "city_name");
              return (Criteria) this;
         }

         public Criteria andCityNameNotBetween(String value1, String value2)
         {
              addCriterion("city_name not between ", value1,value2, "city_name");
              return (Criteria) this;
         }

         public Criteria andParentCityIdIsNull()
         {
              addCriterion("parent_city_id is null");
              return (Criteria) this;
         }

         public Criteria andParentCityIdIsNotNull()
         {
              addCriterion("parent_city_id is not null");
              return (Criteria) this;
         }

         public Criteria andParentCityIdEqualTo(String value)
         {
              addCriterion("parent_city_id = ", value, "parent_city_id");
              return (Criteria) this;
         }

         public Criteria andParentCityIdNotEqualTo(String value)
         {
              addCriterion("parent_city_id <> ", value, "parent_city_id");
              return (Criteria) this;
         }

         public Criteria andParentCityIdGreaterThan(String value)
         {
              addCriterion("parent_city_id > ", value, "parent_city_id");
              return (Criteria) this;
         }

         public Criteria andParentCityIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("parent_city_id >= ", value, "parent_city_id");
              return (Criteria) this;
         }

         public Criteria andParentCityIdLessThan(String value)
         {
              addCriterion("parent_city_id < ", value, "parent_city_id");
              return (Criteria) this;
         }

         public Criteria andParentCityIdLessThanOrEqualTo(String value)
         {
              addCriterion("parent_city_id <= ", value, "parent_city_id");
              return (Criteria) this;
         }

         public Criteria andParentCityIdLike(String value)
         {
              addCriterion("parent_city_id like ", value, "parent_city_id");
              return (Criteria) this;
         }

         public Criteria andParentCityIdNotLike(String value)
         {
              addCriterion("parent_city_id not like ", value, "parent_city_id");
              return (Criteria) this;
         }

         public Criteria andParentCityIdIn(List<String> values)
         {
              addCriterion("parent_city_id in ", values, "parent_city_id");
              return (Criteria) this;
         }

         public Criteria andParentCityIdNotIn(List<String> values)
         {
              addCriterion("parent_city_id not in ", values, "parent_city_id");
              return (Criteria) this;
         }

         public Criteria andParentCityIdBetween(String value1, String value2)
         {
              addCriterion("parent_city_id between ", value1,value2, "parent_city_id");
              return (Criteria) this;
         }

         public Criteria andParentCityIdNotBetween(String value1, String value2)
         {
              addCriterion("parent_city_id not between ", value1,value2, "parent_city_id");
              return (Criteria) this;
         }

         public Criteria andParentCityNameIsNull()
         {
              addCriterion("parent_city_name is null");
              return (Criteria) this;
         }

         public Criteria andParentCityNameIsNotNull()
         {
              addCriterion("parent_city_name is not null");
              return (Criteria) this;
         }

         public Criteria andParentCityNameEqualTo(String value)
         {
              addCriterion("parent_city_name = ", value, "parent_city_name");
              return (Criteria) this;
         }

         public Criteria andParentCityNameNotEqualTo(String value)
         {
              addCriterion("parent_city_name <> ", value, "parent_city_name");
              return (Criteria) this;
         }

         public Criteria andParentCityNameGreaterThan(String value)
         {
              addCriterion("parent_city_name > ", value, "parent_city_name");
              return (Criteria) this;
         }

         public Criteria andParentCityNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("parent_city_name >= ", value, "parent_city_name");
              return (Criteria) this;
         }

         public Criteria andParentCityNameLessThan(String value)
         {
              addCriterion("parent_city_name < ", value, "parent_city_name");
              return (Criteria) this;
         }

         public Criteria andParentCityNameLessThanOrEqualTo(String value)
         {
              addCriterion("parent_city_name <= ", value, "parent_city_name");
              return (Criteria) this;
         }

         public Criteria andParentCityNameLike(String value)
         {
              addCriterion("parent_city_name like ", value, "parent_city_name");
              return (Criteria) this;
         }

         public Criteria andParentCityNameNotLike(String value)
         {
              addCriterion("parent_city_name not like ", value, "parent_city_name");
              return (Criteria) this;
         }

         public Criteria andParentCityNameIn(List<String> values)
         {
              addCriterion("parent_city_name in ", values, "parent_city_name");
              return (Criteria) this;
         }

         public Criteria andParentCityNameNotIn(List<String> values)
         {
              addCriterion("parent_city_name not in ", values, "parent_city_name");
              return (Criteria) this;
         }

         public Criteria andParentCityNameBetween(String value1, String value2)
         {
              addCriterion("parent_city_name between ", value1,value2, "parent_city_name");
              return (Criteria) this;
         }

         public Criteria andParentCityNameNotBetween(String value1, String value2)
         {
              addCriterion("parent_city_name not between ", value1,value2, "parent_city_name");
              return (Criteria) this;
         }

         public Criteria andLevelCodeIsNull()
         {
              addCriterion("level_code is null");
              return (Criteria) this;
         }

         public Criteria andLevelCodeIsNotNull()
         {
              addCriterion("level_code is not null");
              return (Criteria) this;
         }

         public Criteria andLevelCodeEqualTo(String value)
         {
              addCriterion("level_code = ", value, "level_code");
              return (Criteria) this;
         }

         public Criteria andLevelCodeNotEqualTo(String value)
         {
              addCriterion("level_code <> ", value, "level_code");
              return (Criteria) this;
         }

         public Criteria andLevelCodeGreaterThan(String value)
         {
              addCriterion("level_code > ", value, "level_code");
              return (Criteria) this;
         }

         public Criteria andLevelCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("level_code >= ", value, "level_code");
              return (Criteria) this;
         }

         public Criteria andLevelCodeLessThan(String value)
         {
              addCriterion("level_code < ", value, "level_code");
              return (Criteria) this;
         }

         public Criteria andLevelCodeLessThanOrEqualTo(String value)
         {
              addCriterion("level_code <= ", value, "level_code");
              return (Criteria) this;
         }

         public Criteria andLevelCodeLike(String value)
         {
              addCriterion("level_code like ", value, "level_code");
              return (Criteria) this;
         }

         public Criteria andLevelCodeNotLike(String value)
         {
              addCriterion("level_code not like ", value, "level_code");
              return (Criteria) this;
         }

         public Criteria andLevelCodeIn(List<String> values)
         {
              addCriterion("level_code in ", values, "level_code");
              return (Criteria) this;
         }

         public Criteria andLevelCodeNotIn(List<String> values)
         {
              addCriterion("level_code not in ", values, "level_code");
              return (Criteria) this;
         }

         public Criteria andLevelCodeBetween(String value1, String value2)
         {
              addCriterion("level_code between ", value1,value2, "level_code");
              return (Criteria) this;
         }

         public Criteria andLevelCodeNotBetween(String value1, String value2)
         {
              addCriterion("level_code not between ", value1,value2, "level_code");
              return (Criteria) this;
         }

         public Criteria andSortOrderIsNull()
         {
              addCriterion("sort_order is null");
              return (Criteria) this;
         }

         public Criteria andSortOrderIsNotNull()
         {
              addCriterion("sort_order is not null");
              return (Criteria) this;
         }

         public Criteria andSortOrderEqualTo(String value)
         {
              addCriterion("sort_order = ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderNotEqualTo(String value)
         {
              addCriterion("sort_order <> ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderGreaterThan(String value)
         {
              addCriterion("sort_order > ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderGreaterThanOrEqualTo(String value)
         {
              addCriterion("sort_order >= ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderLessThan(String value)
         {
              addCriterion("sort_order < ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderLessThanOrEqualTo(String value)
         {
              addCriterion("sort_order <= ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderLike(String value)
         {
              addCriterion("sort_order like ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderNotLike(String value)
         {
              addCriterion("sort_order not like ", value, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderIn(List<String> values)
         {
              addCriterion("sort_order in ", values, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderNotIn(List<String> values)
         {
              addCriterion("sort_order not in ", values, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderBetween(String value1, String value2)
         {
              addCriterion("sort_order between ", value1,value2, "sort_order");
              return (Criteria) this;
         }

         public Criteria andSortOrderNotBetween(String value1, String value2)
         {
              addCriterion("sort_order not between ", value1,value2, "sort_order");
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
