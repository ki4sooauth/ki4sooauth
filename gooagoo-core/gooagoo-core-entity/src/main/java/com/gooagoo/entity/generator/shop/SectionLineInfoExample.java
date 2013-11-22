package com.gooagoo.entity.generator.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 分段线路信息--导航时需要
 */

public class SectionLineInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public SectionLineInfoExample()
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

         public Criteria andLineIdIsNull()
         {
              addCriterion("line_id is null");
              return (Criteria) this;
         }

         public Criteria andLineIdIsNotNull()
         {
              addCriterion("line_id is not null");
              return (Criteria) this;
         }

         public Criteria andLineIdEqualTo(String value)
         {
              addCriterion("line_id = ", value, "line_id");
              return (Criteria) this;
         }

         public Criteria andLineIdNotEqualTo(String value)
         {
              addCriterion("line_id <> ", value, "line_id");
              return (Criteria) this;
         }

         public Criteria andLineIdGreaterThan(String value)
         {
              addCriterion("line_id > ", value, "line_id");
              return (Criteria) this;
         }

         public Criteria andLineIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("line_id >= ", value, "line_id");
              return (Criteria) this;
         }

         public Criteria andLineIdLessThan(String value)
         {
              addCriterion("line_id < ", value, "line_id");
              return (Criteria) this;
         }

         public Criteria andLineIdLessThanOrEqualTo(String value)
         {
              addCriterion("line_id <= ", value, "line_id");
              return (Criteria) this;
         }

         public Criteria andLineIdLike(String value)
         {
              addCriterion("line_id like ", value, "line_id");
              return (Criteria) this;
         }

         public Criteria andLineIdNotLike(String value)
         {
              addCriterion("line_id not like ", value, "line_id");
              return (Criteria) this;
         }

         public Criteria andLineIdIn(List<String> values)
         {
              addCriterion("line_id in ", values, "line_id");
              return (Criteria) this;
         }

         public Criteria andLineIdNotIn(List<String> values)
         {
              addCriterion("line_id not in ", values, "line_id");
              return (Criteria) this;
         }

         public Criteria andLineIdBetween(String value1, String value2)
         {
              addCriterion("line_id between ", value1,value2, "line_id");
              return (Criteria) this;
         }

         public Criteria andLineIdNotBetween(String value1, String value2)
         {
              addCriterion("line_id not between ", value1,value2, "line_id");
              return (Criteria) this;
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

         public Criteria andSvgTagCodeIsNull()
         {
              addCriterion("svg_tag_code is null");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeIsNotNull()
         {
              addCriterion("svg_tag_code is not null");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeEqualTo(String value)
         {
              addCriterion("svg_tag_code = ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeNotEqualTo(String value)
         {
              addCriterion("svg_tag_code <> ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeGreaterThan(String value)
         {
              addCriterion("svg_tag_code > ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("svg_tag_code >= ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeLessThan(String value)
         {
              addCriterion("svg_tag_code < ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeLessThanOrEqualTo(String value)
         {
              addCriterion("svg_tag_code <= ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeLike(String value)
         {
              addCriterion("svg_tag_code like ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeNotLike(String value)
         {
              addCriterion("svg_tag_code not like ", value, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeIn(List<String> values)
         {
              addCriterion("svg_tag_code in ", values, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeNotIn(List<String> values)
         {
              addCriterion("svg_tag_code not in ", values, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeBetween(String value1, String value2)
         {
              addCriterion("svg_tag_code between ", value1,value2, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andSvgTagCodeNotBetween(String value1, String value2)
         {
              addCriterion("svg_tag_code not between ", value1,value2, "svg_tag_code");
              return (Criteria) this;
         }

         public Criteria andWeightIsNull()
         {
              addCriterion("weight is null");
              return (Criteria) this;
         }

         public Criteria andWeightIsNotNull()
         {
              addCriterion("weight is not null");
              return (Criteria) this;
         }

         public Criteria andWeightEqualTo(String value)
         {
              addCriterion("weight = ", value, "weight");
              return (Criteria) this;
         }

         public Criteria andWeightNotEqualTo(String value)
         {
              addCriterion("weight <> ", value, "weight");
              return (Criteria) this;
         }

         public Criteria andWeightGreaterThan(String value)
         {
              addCriterion("weight > ", value, "weight");
              return (Criteria) this;
         }

         public Criteria andWeightGreaterThanOrEqualTo(String value)
         {
              addCriterion("weight >= ", value, "weight");
              return (Criteria) this;
         }

         public Criteria andWeightLessThan(String value)
         {
              addCriterion("weight < ", value, "weight");
              return (Criteria) this;
         }

         public Criteria andWeightLessThanOrEqualTo(String value)
         {
              addCriterion("weight <= ", value, "weight");
              return (Criteria) this;
         }

         public Criteria andWeightLike(String value)
         {
              addCriterion("weight like ", value, "weight");
              return (Criteria) this;
         }

         public Criteria andWeightNotLike(String value)
         {
              addCriterion("weight not like ", value, "weight");
              return (Criteria) this;
         }

         public Criteria andWeightIn(List<String> values)
         {
              addCriterion("weight in ", values, "weight");
              return (Criteria) this;
         }

         public Criteria andWeightNotIn(List<String> values)
         {
              addCriterion("weight not in ", values, "weight");
              return (Criteria) this;
         }

         public Criteria andWeightBetween(String value1, String value2)
         {
              addCriterion("weight between ", value1,value2, "weight");
              return (Criteria) this;
         }

         public Criteria andWeightNotBetween(String value1, String value2)
         {
              addCriterion("weight not between ", value1,value2, "weight");
              return (Criteria) this;
         }

         public Criteria andLengthIsNull()
         {
              addCriterion("length is null");
              return (Criteria) this;
         }

         public Criteria andLengthIsNotNull()
         {
              addCriterion("length is not null");
              return (Criteria) this;
         }

         public Criteria andLengthEqualTo(String value)
         {
              addCriterion("length = ", value, "length");
              return (Criteria) this;
         }

         public Criteria andLengthNotEqualTo(String value)
         {
              addCriterion("length <> ", value, "length");
              return (Criteria) this;
         }

         public Criteria andLengthGreaterThan(String value)
         {
              addCriterion("length > ", value, "length");
              return (Criteria) this;
         }

         public Criteria andLengthGreaterThanOrEqualTo(String value)
         {
              addCriterion("length >= ", value, "length");
              return (Criteria) this;
         }

         public Criteria andLengthLessThan(String value)
         {
              addCriterion("length < ", value, "length");
              return (Criteria) this;
         }

         public Criteria andLengthLessThanOrEqualTo(String value)
         {
              addCriterion("length <= ", value, "length");
              return (Criteria) this;
         }

         public Criteria andLengthLike(String value)
         {
              addCriterion("length like ", value, "length");
              return (Criteria) this;
         }

         public Criteria andLengthNotLike(String value)
         {
              addCriterion("length not like ", value, "length");
              return (Criteria) this;
         }

         public Criteria andLengthIn(List<String> values)
         {
              addCriterion("length in ", values, "length");
              return (Criteria) this;
         }

         public Criteria andLengthNotIn(List<String> values)
         {
              addCriterion("length not in ", values, "length");
              return (Criteria) this;
         }

         public Criteria andLengthBetween(String value1, String value2)
         {
              addCriterion("length between ", value1,value2, "length");
              return (Criteria) this;
         }

         public Criteria andLengthNotBetween(String value1, String value2)
         {
              addCriterion("length not between ", value1,value2, "length");
              return (Criteria) this;
         }

         public Criteria andFirstPointXIsNull()
         {
              addCriterion("first_point_x is null");
              return (Criteria) this;
         }

         public Criteria andFirstPointXIsNotNull()
         {
              addCriterion("first_point_x is not null");
              return (Criteria) this;
         }

         public Criteria andFirstPointXEqualTo(String value)
         {
              addCriterion("first_point_x = ", value, "first_point_x");
              return (Criteria) this;
         }

         public Criteria andFirstPointXNotEqualTo(String value)
         {
              addCriterion("first_point_x <> ", value, "first_point_x");
              return (Criteria) this;
         }

         public Criteria andFirstPointXGreaterThan(String value)
         {
              addCriterion("first_point_x > ", value, "first_point_x");
              return (Criteria) this;
         }

         public Criteria andFirstPointXGreaterThanOrEqualTo(String value)
         {
              addCriterion("first_point_x >= ", value, "first_point_x");
              return (Criteria) this;
         }

         public Criteria andFirstPointXLessThan(String value)
         {
              addCriterion("first_point_x < ", value, "first_point_x");
              return (Criteria) this;
         }

         public Criteria andFirstPointXLessThanOrEqualTo(String value)
         {
              addCriterion("first_point_x <= ", value, "first_point_x");
              return (Criteria) this;
         }

         public Criteria andFirstPointXLike(String value)
         {
              addCriterion("first_point_x like ", value, "first_point_x");
              return (Criteria) this;
         }

         public Criteria andFirstPointXNotLike(String value)
         {
              addCriterion("first_point_x not like ", value, "first_point_x");
              return (Criteria) this;
         }

         public Criteria andFirstPointXIn(List<String> values)
         {
              addCriterion("first_point_x in ", values, "first_point_x");
              return (Criteria) this;
         }

         public Criteria andFirstPointXNotIn(List<String> values)
         {
              addCriterion("first_point_x not in ", values, "first_point_x");
              return (Criteria) this;
         }

         public Criteria andFirstPointXBetween(String value1, String value2)
         {
              addCriterion("first_point_x between ", value1,value2, "first_point_x");
              return (Criteria) this;
         }

         public Criteria andFirstPointXNotBetween(String value1, String value2)
         {
              addCriterion("first_point_x not between ", value1,value2, "first_point_x");
              return (Criteria) this;
         }

         public Criteria andFirstPointYIsNull()
         {
              addCriterion("first_point_y is null");
              return (Criteria) this;
         }

         public Criteria andFirstPointYIsNotNull()
         {
              addCriterion("first_point_y is not null");
              return (Criteria) this;
         }

         public Criteria andFirstPointYEqualTo(String value)
         {
              addCriterion("first_point_y = ", value, "first_point_y");
              return (Criteria) this;
         }

         public Criteria andFirstPointYNotEqualTo(String value)
         {
              addCriterion("first_point_y <> ", value, "first_point_y");
              return (Criteria) this;
         }

         public Criteria andFirstPointYGreaterThan(String value)
         {
              addCriterion("first_point_y > ", value, "first_point_y");
              return (Criteria) this;
         }

         public Criteria andFirstPointYGreaterThanOrEqualTo(String value)
         {
              addCriterion("first_point_y >= ", value, "first_point_y");
              return (Criteria) this;
         }

         public Criteria andFirstPointYLessThan(String value)
         {
              addCriterion("first_point_y < ", value, "first_point_y");
              return (Criteria) this;
         }

         public Criteria andFirstPointYLessThanOrEqualTo(String value)
         {
              addCriterion("first_point_y <= ", value, "first_point_y");
              return (Criteria) this;
         }

         public Criteria andFirstPointYLike(String value)
         {
              addCriterion("first_point_y like ", value, "first_point_y");
              return (Criteria) this;
         }

         public Criteria andFirstPointYNotLike(String value)
         {
              addCriterion("first_point_y not like ", value, "first_point_y");
              return (Criteria) this;
         }

         public Criteria andFirstPointYIn(List<String> values)
         {
              addCriterion("first_point_y in ", values, "first_point_y");
              return (Criteria) this;
         }

         public Criteria andFirstPointYNotIn(List<String> values)
         {
              addCriterion("first_point_y not in ", values, "first_point_y");
              return (Criteria) this;
         }

         public Criteria andFirstPointYBetween(String value1, String value2)
         {
              addCriterion("first_point_y between ", value1,value2, "first_point_y");
              return (Criteria) this;
         }

         public Criteria andFirstPointYNotBetween(String value1, String value2)
         {
              addCriterion("first_point_y not between ", value1,value2, "first_point_y");
              return (Criteria) this;
         }

         public Criteria andSecondPointXIsNull()
         {
              addCriterion("second_point_x is null");
              return (Criteria) this;
         }

         public Criteria andSecondPointXIsNotNull()
         {
              addCriterion("second_point_x is not null");
              return (Criteria) this;
         }

         public Criteria andSecondPointXEqualTo(String value)
         {
              addCriterion("second_point_x = ", value, "second_point_x");
              return (Criteria) this;
         }

         public Criteria andSecondPointXNotEqualTo(String value)
         {
              addCriterion("second_point_x <> ", value, "second_point_x");
              return (Criteria) this;
         }

         public Criteria andSecondPointXGreaterThan(String value)
         {
              addCriterion("second_point_x > ", value, "second_point_x");
              return (Criteria) this;
         }

         public Criteria andSecondPointXGreaterThanOrEqualTo(String value)
         {
              addCriterion("second_point_x >= ", value, "second_point_x");
              return (Criteria) this;
         }

         public Criteria andSecondPointXLessThan(String value)
         {
              addCriterion("second_point_x < ", value, "second_point_x");
              return (Criteria) this;
         }

         public Criteria andSecondPointXLessThanOrEqualTo(String value)
         {
              addCriterion("second_point_x <= ", value, "second_point_x");
              return (Criteria) this;
         }

         public Criteria andSecondPointXLike(String value)
         {
              addCriterion("second_point_x like ", value, "second_point_x");
              return (Criteria) this;
         }

         public Criteria andSecondPointXNotLike(String value)
         {
              addCriterion("second_point_x not like ", value, "second_point_x");
              return (Criteria) this;
         }

         public Criteria andSecondPointXIn(List<String> values)
         {
              addCriterion("second_point_x in ", values, "second_point_x");
              return (Criteria) this;
         }

         public Criteria andSecondPointXNotIn(List<String> values)
         {
              addCriterion("second_point_x not in ", values, "second_point_x");
              return (Criteria) this;
         }

         public Criteria andSecondPointXBetween(String value1, String value2)
         {
              addCriterion("second_point_x between ", value1,value2, "second_point_x");
              return (Criteria) this;
         }

         public Criteria andSecondPointXNotBetween(String value1, String value2)
         {
              addCriterion("second_point_x not between ", value1,value2, "second_point_x");
              return (Criteria) this;
         }

         public Criteria andSecondPointYIsNull()
         {
              addCriterion("second_point_y is null");
              return (Criteria) this;
         }

         public Criteria andSecondPointYIsNotNull()
         {
              addCriterion("second_point_y is not null");
              return (Criteria) this;
         }

         public Criteria andSecondPointYEqualTo(String value)
         {
              addCriterion("second_point_y = ", value, "second_point_y");
              return (Criteria) this;
         }

         public Criteria andSecondPointYNotEqualTo(String value)
         {
              addCriterion("second_point_y <> ", value, "second_point_y");
              return (Criteria) this;
         }

         public Criteria andSecondPointYGreaterThan(String value)
         {
              addCriterion("second_point_y > ", value, "second_point_y");
              return (Criteria) this;
         }

         public Criteria andSecondPointYGreaterThanOrEqualTo(String value)
         {
              addCriterion("second_point_y >= ", value, "second_point_y");
              return (Criteria) this;
         }

         public Criteria andSecondPointYLessThan(String value)
         {
              addCriterion("second_point_y < ", value, "second_point_y");
              return (Criteria) this;
         }

         public Criteria andSecondPointYLessThanOrEqualTo(String value)
         {
              addCriterion("second_point_y <= ", value, "second_point_y");
              return (Criteria) this;
         }

         public Criteria andSecondPointYLike(String value)
         {
              addCriterion("second_point_y like ", value, "second_point_y");
              return (Criteria) this;
         }

         public Criteria andSecondPointYNotLike(String value)
         {
              addCriterion("second_point_y not like ", value, "second_point_y");
              return (Criteria) this;
         }

         public Criteria andSecondPointYIn(List<String> values)
         {
              addCriterion("second_point_y in ", values, "second_point_y");
              return (Criteria) this;
         }

         public Criteria andSecondPointYNotIn(List<String> values)
         {
              addCriterion("second_point_y not in ", values, "second_point_y");
              return (Criteria) this;
         }

         public Criteria andSecondPointYBetween(String value1, String value2)
         {
              addCriterion("second_point_y between ", value1,value2, "second_point_y");
              return (Criteria) this;
         }

         public Criteria andSecondPointYNotBetween(String value1, String value2)
         {
              addCriterion("second_point_y not between ", value1,value2, "second_point_y");
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
