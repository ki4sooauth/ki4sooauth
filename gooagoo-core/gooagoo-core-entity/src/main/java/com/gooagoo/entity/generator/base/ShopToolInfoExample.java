package com.gooagoo.entity.generator.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 商家服务工具字典表
 */

public class ShopToolInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopToolInfoExample()
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

         public Criteria andToolIdIsNull()
         {
              addCriterion("tool_id is null");
              return (Criteria) this;
         }

         public Criteria andToolIdIsNotNull()
         {
              addCriterion("tool_id is not null");
              return (Criteria) this;
         }

         public Criteria andToolIdEqualTo(String value)
         {
              addCriterion("tool_id = ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdNotEqualTo(String value)
         {
              addCriterion("tool_id <> ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdGreaterThan(String value)
         {
              addCriterion("tool_id > ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("tool_id >= ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdLessThan(String value)
         {
              addCriterion("tool_id < ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdLessThanOrEqualTo(String value)
         {
              addCriterion("tool_id <= ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdLike(String value)
         {
              addCriterion("tool_id like ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdNotLike(String value)
         {
              addCriterion("tool_id not like ", value, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdIn(List<String> values)
         {
              addCriterion("tool_id in ", values, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdNotIn(List<String> values)
         {
              addCriterion("tool_id not in ", values, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdBetween(String value1, String value2)
         {
              addCriterion("tool_id between ", value1,value2, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolIdNotBetween(String value1, String value2)
         {
              addCriterion("tool_id not between ", value1,value2, "tool_id");
              return (Criteria) this;
         }

         public Criteria andToolNameIsNull()
         {
              addCriterion("tool_name is null");
              return (Criteria) this;
         }

         public Criteria andToolNameIsNotNull()
         {
              addCriterion("tool_name is not null");
              return (Criteria) this;
         }

         public Criteria andToolNameEqualTo(String value)
         {
              addCriterion("tool_name = ", value, "tool_name");
              return (Criteria) this;
         }

         public Criteria andToolNameNotEqualTo(String value)
         {
              addCriterion("tool_name <> ", value, "tool_name");
              return (Criteria) this;
         }

         public Criteria andToolNameGreaterThan(String value)
         {
              addCriterion("tool_name > ", value, "tool_name");
              return (Criteria) this;
         }

         public Criteria andToolNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("tool_name >= ", value, "tool_name");
              return (Criteria) this;
         }

         public Criteria andToolNameLessThan(String value)
         {
              addCriterion("tool_name < ", value, "tool_name");
              return (Criteria) this;
         }

         public Criteria andToolNameLessThanOrEqualTo(String value)
         {
              addCriterion("tool_name <= ", value, "tool_name");
              return (Criteria) this;
         }

         public Criteria andToolNameLike(String value)
         {
              addCriterion("tool_name like ", value, "tool_name");
              return (Criteria) this;
         }

         public Criteria andToolNameNotLike(String value)
         {
              addCriterion("tool_name not like ", value, "tool_name");
              return (Criteria) this;
         }

         public Criteria andToolNameIn(List<String> values)
         {
              addCriterion("tool_name in ", values, "tool_name");
              return (Criteria) this;
         }

         public Criteria andToolNameNotIn(List<String> values)
         {
              addCriterion("tool_name not in ", values, "tool_name");
              return (Criteria) this;
         }

         public Criteria andToolNameBetween(String value1, String value2)
         {
              addCriterion("tool_name between ", value1,value2, "tool_name");
              return (Criteria) this;
         }

         public Criteria andToolNameNotBetween(String value1, String value2)
         {
              addCriterion("tool_name not between ", value1,value2, "tool_name");
              return (Criteria) this;
         }

         public Criteria andToolUrlIsNull()
         {
              addCriterion("tool_url is null");
              return (Criteria) this;
         }

         public Criteria andToolUrlIsNotNull()
         {
              addCriterion("tool_url is not null");
              return (Criteria) this;
         }

         public Criteria andToolUrlEqualTo(String value)
         {
              addCriterion("tool_url = ", value, "tool_url");
              return (Criteria) this;
         }

         public Criteria andToolUrlNotEqualTo(String value)
         {
              addCriterion("tool_url <> ", value, "tool_url");
              return (Criteria) this;
         }

         public Criteria andToolUrlGreaterThan(String value)
         {
              addCriterion("tool_url > ", value, "tool_url");
              return (Criteria) this;
         }

         public Criteria andToolUrlGreaterThanOrEqualTo(String value)
         {
              addCriterion("tool_url >= ", value, "tool_url");
              return (Criteria) this;
         }

         public Criteria andToolUrlLessThan(String value)
         {
              addCriterion("tool_url < ", value, "tool_url");
              return (Criteria) this;
         }

         public Criteria andToolUrlLessThanOrEqualTo(String value)
         {
              addCriterion("tool_url <= ", value, "tool_url");
              return (Criteria) this;
         }

         public Criteria andToolUrlLike(String value)
         {
              addCriterion("tool_url like ", value, "tool_url");
              return (Criteria) this;
         }

         public Criteria andToolUrlNotLike(String value)
         {
              addCriterion("tool_url not like ", value, "tool_url");
              return (Criteria) this;
         }

         public Criteria andToolUrlIn(List<String> values)
         {
              addCriterion("tool_url in ", values, "tool_url");
              return (Criteria) this;
         }

         public Criteria andToolUrlNotIn(List<String> values)
         {
              addCriterion("tool_url not in ", values, "tool_url");
              return (Criteria) this;
         }

         public Criteria andToolUrlBetween(String value1, String value2)
         {
              addCriterion("tool_url between ", value1,value2, "tool_url");
              return (Criteria) this;
         }

         public Criteria andToolUrlNotBetween(String value1, String value2)
         {
              addCriterion("tool_url not between ", value1,value2, "tool_url");
              return (Criteria) this;
         }

         public Criteria andToolIcoFocusIsNull()
         {
              addCriterion("tool_ico_focus is null");
              return (Criteria) this;
         }

         public Criteria andToolIcoFocusIsNotNull()
         {
              addCriterion("tool_ico_focus is not null");
              return (Criteria) this;
         }

         public Criteria andToolIcoFocusEqualTo(String value)
         {
              addCriterion("tool_ico_focus = ", value, "tool_ico_focus");
              return (Criteria) this;
         }

         public Criteria andToolIcoFocusNotEqualTo(String value)
         {
              addCriterion("tool_ico_focus <> ", value, "tool_ico_focus");
              return (Criteria) this;
         }

         public Criteria andToolIcoFocusGreaterThan(String value)
         {
              addCriterion("tool_ico_focus > ", value, "tool_ico_focus");
              return (Criteria) this;
         }

         public Criteria andToolIcoFocusGreaterThanOrEqualTo(String value)
         {
              addCriterion("tool_ico_focus >= ", value, "tool_ico_focus");
              return (Criteria) this;
         }

         public Criteria andToolIcoFocusLessThan(String value)
         {
              addCriterion("tool_ico_focus < ", value, "tool_ico_focus");
              return (Criteria) this;
         }

         public Criteria andToolIcoFocusLessThanOrEqualTo(String value)
         {
              addCriterion("tool_ico_focus <= ", value, "tool_ico_focus");
              return (Criteria) this;
         }

         public Criteria andToolIcoFocusLike(String value)
         {
              addCriterion("tool_ico_focus like ", value, "tool_ico_focus");
              return (Criteria) this;
         }

         public Criteria andToolIcoFocusNotLike(String value)
         {
              addCriterion("tool_ico_focus not like ", value, "tool_ico_focus");
              return (Criteria) this;
         }

         public Criteria andToolIcoFocusIn(List<String> values)
         {
              addCriterion("tool_ico_focus in ", values, "tool_ico_focus");
              return (Criteria) this;
         }

         public Criteria andToolIcoFocusNotIn(List<String> values)
         {
              addCriterion("tool_ico_focus not in ", values, "tool_ico_focus");
              return (Criteria) this;
         }

         public Criteria andToolIcoFocusBetween(String value1, String value2)
         {
              addCriterion("tool_ico_focus between ", value1,value2, "tool_ico_focus");
              return (Criteria) this;
         }

         public Criteria andToolIcoFocusNotBetween(String value1, String value2)
         {
              addCriterion("tool_ico_focus not between ", value1,value2, "tool_ico_focus");
              return (Criteria) this;
         }

         public Criteria andToolIcoUnfocusIsNull()
         {
              addCriterion("tool_ico_unfocus is null");
              return (Criteria) this;
         }

         public Criteria andToolIcoUnfocusIsNotNull()
         {
              addCriterion("tool_ico_unfocus is not null");
              return (Criteria) this;
         }

         public Criteria andToolIcoUnfocusEqualTo(String value)
         {
              addCriterion("tool_ico_unfocus = ", value, "tool_ico_unfocus");
              return (Criteria) this;
         }

         public Criteria andToolIcoUnfocusNotEqualTo(String value)
         {
              addCriterion("tool_ico_unfocus <> ", value, "tool_ico_unfocus");
              return (Criteria) this;
         }

         public Criteria andToolIcoUnfocusGreaterThan(String value)
         {
              addCriterion("tool_ico_unfocus > ", value, "tool_ico_unfocus");
              return (Criteria) this;
         }

         public Criteria andToolIcoUnfocusGreaterThanOrEqualTo(String value)
         {
              addCriterion("tool_ico_unfocus >= ", value, "tool_ico_unfocus");
              return (Criteria) this;
         }

         public Criteria andToolIcoUnfocusLessThan(String value)
         {
              addCriterion("tool_ico_unfocus < ", value, "tool_ico_unfocus");
              return (Criteria) this;
         }

         public Criteria andToolIcoUnfocusLessThanOrEqualTo(String value)
         {
              addCriterion("tool_ico_unfocus <= ", value, "tool_ico_unfocus");
              return (Criteria) this;
         }

         public Criteria andToolIcoUnfocusLike(String value)
         {
              addCriterion("tool_ico_unfocus like ", value, "tool_ico_unfocus");
              return (Criteria) this;
         }

         public Criteria andToolIcoUnfocusNotLike(String value)
         {
              addCriterion("tool_ico_unfocus not like ", value, "tool_ico_unfocus");
              return (Criteria) this;
         }

         public Criteria andToolIcoUnfocusIn(List<String> values)
         {
              addCriterion("tool_ico_unfocus in ", values, "tool_ico_unfocus");
              return (Criteria) this;
         }

         public Criteria andToolIcoUnfocusNotIn(List<String> values)
         {
              addCriterion("tool_ico_unfocus not in ", values, "tool_ico_unfocus");
              return (Criteria) this;
         }

         public Criteria andToolIcoUnfocusBetween(String value1, String value2)
         {
              addCriterion("tool_ico_unfocus between ", value1,value2, "tool_ico_unfocus");
              return (Criteria) this;
         }

         public Criteria andToolIcoUnfocusNotBetween(String value1, String value2)
         {
              addCriterion("tool_ico_unfocus not between ", value1,value2, "tool_ico_unfocus");
              return (Criteria) this;
         }

         public Criteria andToolTypeIsNull()
         {
              addCriterion("tool_type is null");
              return (Criteria) this;
         }

         public Criteria andToolTypeIsNotNull()
         {
              addCriterion("tool_type is not null");
              return (Criteria) this;
         }

         public Criteria andToolTypeEqualTo(String value)
         {
              addCriterion("tool_type = ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeNotEqualTo(String value)
         {
              addCriterion("tool_type <> ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeGreaterThan(String value)
         {
              addCriterion("tool_type > ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("tool_type >= ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeLessThan(String value)
         {
              addCriterion("tool_type < ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeLessThanOrEqualTo(String value)
         {
              addCriterion("tool_type <= ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeLike(String value)
         {
              addCriterion("tool_type like ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeNotLike(String value)
         {
              addCriterion("tool_type not like ", value, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeIn(List<String> values)
         {
              addCriterion("tool_type in ", values, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeNotIn(List<String> values)
         {
              addCriterion("tool_type not in ", values, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeBetween(String value1, String value2)
         {
              addCriterion("tool_type between ", value1,value2, "tool_type");
              return (Criteria) this;
         }

         public Criteria andToolTypeNotBetween(String value1, String value2)
         {
              addCriterion("tool_type not between ", value1,value2, "tool_type");
              return (Criteria) this;
         }

         public Criteria andLocalCmdIsNull()
         {
              addCriterion("local_cmd is null");
              return (Criteria) this;
         }

         public Criteria andLocalCmdIsNotNull()
         {
              addCriterion("local_cmd is not null");
              return (Criteria) this;
         }

         public Criteria andLocalCmdEqualTo(String value)
         {
              addCriterion("local_cmd = ", value, "local_cmd");
              return (Criteria) this;
         }

         public Criteria andLocalCmdNotEqualTo(String value)
         {
              addCriterion("local_cmd <> ", value, "local_cmd");
              return (Criteria) this;
         }

         public Criteria andLocalCmdGreaterThan(String value)
         {
              addCriterion("local_cmd > ", value, "local_cmd");
              return (Criteria) this;
         }

         public Criteria andLocalCmdGreaterThanOrEqualTo(String value)
         {
              addCriterion("local_cmd >= ", value, "local_cmd");
              return (Criteria) this;
         }

         public Criteria andLocalCmdLessThan(String value)
         {
              addCriterion("local_cmd < ", value, "local_cmd");
              return (Criteria) this;
         }

         public Criteria andLocalCmdLessThanOrEqualTo(String value)
         {
              addCriterion("local_cmd <= ", value, "local_cmd");
              return (Criteria) this;
         }

         public Criteria andLocalCmdLike(String value)
         {
              addCriterion("local_cmd like ", value, "local_cmd");
              return (Criteria) this;
         }

         public Criteria andLocalCmdNotLike(String value)
         {
              addCriterion("local_cmd not like ", value, "local_cmd");
              return (Criteria) this;
         }

         public Criteria andLocalCmdIn(List<String> values)
         {
              addCriterion("local_cmd in ", values, "local_cmd");
              return (Criteria) this;
         }

         public Criteria andLocalCmdNotIn(List<String> values)
         {
              addCriterion("local_cmd not in ", values, "local_cmd");
              return (Criteria) this;
         }

         public Criteria andLocalCmdBetween(String value1, String value2)
         {
              addCriterion("local_cmd between ", value1,value2, "local_cmd");
              return (Criteria) this;
         }

         public Criteria andLocalCmdNotBetween(String value1, String value2)
         {
              addCriterion("local_cmd not between ", value1,value2, "local_cmd");
              return (Criteria) this;
         }

         public Criteria andVerIsNull()
         {
              addCriterion("ver is null");
              return (Criteria) this;
         }

         public Criteria andVerIsNotNull()
         {
              addCriterion("ver is not null");
              return (Criteria) this;
         }

         public Criteria andVerEqualTo(String value)
         {
              addCriterion("ver = ", value, "ver");
              return (Criteria) this;
         }

         public Criteria andVerNotEqualTo(String value)
         {
              addCriterion("ver <> ", value, "ver");
              return (Criteria) this;
         }

         public Criteria andVerGreaterThan(String value)
         {
              addCriterion("ver > ", value, "ver");
              return (Criteria) this;
         }

         public Criteria andVerGreaterThanOrEqualTo(String value)
         {
              addCriterion("ver >= ", value, "ver");
              return (Criteria) this;
         }

         public Criteria andVerLessThan(String value)
         {
              addCriterion("ver < ", value, "ver");
              return (Criteria) this;
         }

         public Criteria andVerLessThanOrEqualTo(String value)
         {
              addCriterion("ver <= ", value, "ver");
              return (Criteria) this;
         }

         public Criteria andVerLike(String value)
         {
              addCriterion("ver like ", value, "ver");
              return (Criteria) this;
         }

         public Criteria andVerNotLike(String value)
         {
              addCriterion("ver not like ", value, "ver");
              return (Criteria) this;
         }

         public Criteria andVerIn(List<String> values)
         {
              addCriterion("ver in ", values, "ver");
              return (Criteria) this;
         }

         public Criteria andVerNotIn(List<String> values)
         {
              addCriterion("ver not in ", values, "ver");
              return (Criteria) this;
         }

         public Criteria andVerBetween(String value1, String value2)
         {
              addCriterion("ver between ", value1,value2, "ver");
              return (Criteria) this;
         }

         public Criteria andVerNotBetween(String value1, String value2)
         {
              addCriterion("ver not between ", value1,value2, "ver");
              return (Criteria) this;
         }

         public Criteria andRemarkIsNull()
         {
              addCriterion("remark is null");
              return (Criteria) this;
         }

         public Criteria andRemarkIsNotNull()
         {
              addCriterion("remark is not null");
              return (Criteria) this;
         }

         public Criteria andRemarkEqualTo(String value)
         {
              addCriterion("remark = ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkNotEqualTo(String value)
         {
              addCriterion("remark <> ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkGreaterThan(String value)
         {
              addCriterion("remark > ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkGreaterThanOrEqualTo(String value)
         {
              addCriterion("remark >= ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkLessThan(String value)
         {
              addCriterion("remark < ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkLessThanOrEqualTo(String value)
         {
              addCriterion("remark <= ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkLike(String value)
         {
              addCriterion("remark like ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkNotLike(String value)
         {
              addCriterion("remark not like ", value, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkIn(List<String> values)
         {
              addCriterion("remark in ", values, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkNotIn(List<String> values)
         {
              addCriterion("remark not in ", values, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkBetween(String value1, String value2)
         {
              addCriterion("remark between ", value1,value2, "remark");
              return (Criteria) this;
         }

         public Criteria andRemarkNotBetween(String value1, String value2)
         {
              addCriterion("remark not between ", value1,value2, "remark");
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
