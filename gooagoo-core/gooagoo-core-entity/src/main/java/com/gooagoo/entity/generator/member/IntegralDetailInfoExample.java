package com.gooagoo.entity.generator.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 积分明细表
 */

public class IntegralDetailInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public IntegralDetailInfoExample()
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

         public Criteria andIntegralIdIsNull()
         {
              addCriterion("integral_id is null");
              return (Criteria) this;
         }

         public Criteria andIntegralIdIsNotNull()
         {
              addCriterion("integral_id is not null");
              return (Criteria) this;
         }

         public Criteria andIntegralIdEqualTo(String value)
         {
              addCriterion("integral_id = ", value, "integral_id");
              return (Criteria) this;
         }

         public Criteria andIntegralIdNotEqualTo(String value)
         {
              addCriterion("integral_id <> ", value, "integral_id");
              return (Criteria) this;
         }

         public Criteria andIntegralIdGreaterThan(String value)
         {
              addCriterion("integral_id > ", value, "integral_id");
              return (Criteria) this;
         }

         public Criteria andIntegralIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("integral_id >= ", value, "integral_id");
              return (Criteria) this;
         }

         public Criteria andIntegralIdLessThan(String value)
         {
              addCriterion("integral_id < ", value, "integral_id");
              return (Criteria) this;
         }

         public Criteria andIntegralIdLessThanOrEqualTo(String value)
         {
              addCriterion("integral_id <= ", value, "integral_id");
              return (Criteria) this;
         }

         public Criteria andIntegralIdLike(String value)
         {
              addCriterion("integral_id like ", value, "integral_id");
              return (Criteria) this;
         }

         public Criteria andIntegralIdNotLike(String value)
         {
              addCriterion("integral_id not like ", value, "integral_id");
              return (Criteria) this;
         }

         public Criteria andIntegralIdIn(List<String> values)
         {
              addCriterion("integral_id in ", values, "integral_id");
              return (Criteria) this;
         }

         public Criteria andIntegralIdNotIn(List<String> values)
         {
              addCriterion("integral_id not in ", values, "integral_id");
              return (Criteria) this;
         }

         public Criteria andIntegralIdBetween(String value1, String value2)
         {
              addCriterion("integral_id between ", value1,value2, "integral_id");
              return (Criteria) this;
         }

         public Criteria andIntegralIdNotBetween(String value1, String value2)
         {
              addCriterion("integral_id not between ", value1,value2, "integral_id");
              return (Criteria) this;
         }

         public Criteria andUserIdIsNull()
         {
              addCriterion("user_id is null");
              return (Criteria) this;
         }

         public Criteria andUserIdIsNotNull()
         {
              addCriterion("user_id is not null");
              return (Criteria) this;
         }

         public Criteria andUserIdEqualTo(String value)
         {
              addCriterion("user_id = ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdNotEqualTo(String value)
         {
              addCriterion("user_id <> ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdGreaterThan(String value)
         {
              addCriterion("user_id > ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("user_id >= ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdLessThan(String value)
         {
              addCriterion("user_id < ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdLessThanOrEqualTo(String value)
         {
              addCriterion("user_id <= ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdLike(String value)
         {
              addCriterion("user_id like ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdNotLike(String value)
         {
              addCriterion("user_id not like ", value, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdIn(List<String> values)
         {
              addCriterion("user_id in ", values, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdNotIn(List<String> values)
         {
              addCriterion("user_id not in ", values, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdBetween(String value1, String value2)
         {
              addCriterion("user_id between ", value1,value2, "user_id");
              return (Criteria) this;
         }

         public Criteria andUserIdNotBetween(String value1, String value2)
         {
              addCriterion("user_id not between ", value1,value2, "user_id");
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

         public Criteria andIntegralNumberIsNull()
         {
              addCriterion("integral_number is null");
              return (Criteria) this;
         }

         public Criteria andIntegralNumberIsNotNull()
         {
              addCriterion("integral_number is not null");
              return (Criteria) this;
         }

         public Criteria andIntegralNumberEqualTo(String value)
         {
              addCriterion("integral_number = ", value, "integral_number");
              return (Criteria) this;
         }

         public Criteria andIntegralNumberNotEqualTo(String value)
         {
              addCriterion("integral_number <> ", value, "integral_number");
              return (Criteria) this;
         }

         public Criteria andIntegralNumberGreaterThan(String value)
         {
              addCriterion("integral_number > ", value, "integral_number");
              return (Criteria) this;
         }

         public Criteria andIntegralNumberGreaterThanOrEqualTo(String value)
         {
              addCriterion("integral_number >= ", value, "integral_number");
              return (Criteria) this;
         }

         public Criteria andIntegralNumberLessThan(String value)
         {
              addCriterion("integral_number < ", value, "integral_number");
              return (Criteria) this;
         }

         public Criteria andIntegralNumberLessThanOrEqualTo(String value)
         {
              addCriterion("integral_number <= ", value, "integral_number");
              return (Criteria) this;
         }

         public Criteria andIntegralNumberLike(String value)
         {
              addCriterion("integral_number like ", value, "integral_number");
              return (Criteria) this;
         }

         public Criteria andIntegralNumberNotLike(String value)
         {
              addCriterion("integral_number not like ", value, "integral_number");
              return (Criteria) this;
         }

         public Criteria andIntegralNumberIn(List<String> values)
         {
              addCriterion("integral_number in ", values, "integral_number");
              return (Criteria) this;
         }

         public Criteria andIntegralNumberNotIn(List<String> values)
         {
              addCriterion("integral_number not in ", values, "integral_number");
              return (Criteria) this;
         }

         public Criteria andIntegralNumberBetween(String value1, String value2)
         {
              addCriterion("integral_number between ", value1,value2, "integral_number");
              return (Criteria) this;
         }

         public Criteria andIntegralNumberNotBetween(String value1, String value2)
         {
              addCriterion("integral_number not between ", value1,value2, "integral_number");
              return (Criteria) this;
         }

         public Criteria andIntegralSourceIsNull()
         {
              addCriterion("integral_source is null");
              return (Criteria) this;
         }

         public Criteria andIntegralSourceIsNotNull()
         {
              addCriterion("integral_source is not null");
              return (Criteria) this;
         }

         public Criteria andIntegralSourceEqualTo(String value)
         {
              addCriterion("integral_source = ", value, "integral_source");
              return (Criteria) this;
         }

         public Criteria andIntegralSourceNotEqualTo(String value)
         {
              addCriterion("integral_source <> ", value, "integral_source");
              return (Criteria) this;
         }

         public Criteria andIntegralSourceGreaterThan(String value)
         {
              addCriterion("integral_source > ", value, "integral_source");
              return (Criteria) this;
         }

         public Criteria andIntegralSourceGreaterThanOrEqualTo(String value)
         {
              addCriterion("integral_source >= ", value, "integral_source");
              return (Criteria) this;
         }

         public Criteria andIntegralSourceLessThan(String value)
         {
              addCriterion("integral_source < ", value, "integral_source");
              return (Criteria) this;
         }

         public Criteria andIntegralSourceLessThanOrEqualTo(String value)
         {
              addCriterion("integral_source <= ", value, "integral_source");
              return (Criteria) this;
         }

         public Criteria andIntegralSourceLike(String value)
         {
              addCriterion("integral_source like ", value, "integral_source");
              return (Criteria) this;
         }

         public Criteria andIntegralSourceNotLike(String value)
         {
              addCriterion("integral_source not like ", value, "integral_source");
              return (Criteria) this;
         }

         public Criteria andIntegralSourceIn(List<String> values)
         {
              addCriterion("integral_source in ", values, "integral_source");
              return (Criteria) this;
         }

         public Criteria andIntegralSourceNotIn(List<String> values)
         {
              addCriterion("integral_source not in ", values, "integral_source");
              return (Criteria) this;
         }

         public Criteria andIntegralSourceBetween(String value1, String value2)
         {
              addCriterion("integral_source between ", value1,value2, "integral_source");
              return (Criteria) this;
         }

         public Criteria andIntegralSourceNotBetween(String value1, String value2)
         {
              addCriterion("integral_source not between ", value1,value2, "integral_source");
              return (Criteria) this;
         }

         public Criteria andIntegralCreateTimeIsNull()
         {
              addCriterion("integral_create_time is null");
              return (Criteria) this;
         }

         public Criteria andIntegralCreateTimeIsNotNull()
         {
              addCriterion("integral_create_time is not null");
              return (Criteria) this;
         }

         public Criteria andIntegralCreateTimeEqualTo(Date value)
         {
              addCriterion("integral_create_time = ", value, "integral_create_time");
              return (Criteria) this;
         }

         public Criteria andIntegralCreateTimeNotEqualTo(Date value)
         {
              addCriterion("integral_create_time <> ", value, "integral_create_time");
              return (Criteria) this;
         }

         public Criteria andIntegralCreateTimeGreaterThan(Date value)
         {
              addCriterion("integral_create_time > ", value, "integral_create_time");
              return (Criteria) this;
         }

         public Criteria andIntegralCreateTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("integral_create_time >= ", value, "integral_create_time");
              return (Criteria) this;
         }

         public Criteria andIntegralCreateTimeLessThan(Date value)
         {
              addCriterion("integral_create_time < ", value, "integral_create_time");
              return (Criteria) this;
         }

         public Criteria andIntegralCreateTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("integral_create_time <= ", value, "integral_create_time");
              return (Criteria) this;
         }

         public Criteria andIntegralCreateTimeIn(List<Date> values)
         {
              addCriterion("integral_create_time in ", values, "integral_create_time");
              return (Criteria) this;
         }

         public Criteria andIntegralCreateTimeNotIn(List<Date> values)
         {
              addCriterion("integral_create_time not in ", values, "integral_create_time");
              return (Criteria) this;
         }

         public Criteria andIntegralCreateTimeBetween(Date value1, Date value2)
         {
              addCriterion("integral_create_time between ", value1,value2, "integral_create_time");
              return (Criteria) this;
         }

         public Criteria andIntegralCreateTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("integral_create_time not between ", value1,value2, "integral_create_time");
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

         public Criteria andIsFreezIsNull()
         {
              addCriterion("is_freez is null");
              return (Criteria) this;
         }

         public Criteria andIsFreezIsNotNull()
         {
              addCriterion("is_freez is not null");
              return (Criteria) this;
         }

         public Criteria andIsFreezEqualTo(String value)
         {
              addCriterion("is_freez = ", value, "is_freez");
              return (Criteria) this;
         }

         public Criteria andIsFreezNotEqualTo(String value)
         {
              addCriterion("is_freez <> ", value, "is_freez");
              return (Criteria) this;
         }

         public Criteria andIsFreezGreaterThan(String value)
         {
              addCriterion("is_freez > ", value, "is_freez");
              return (Criteria) this;
         }

         public Criteria andIsFreezGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_freez >= ", value, "is_freez");
              return (Criteria) this;
         }

         public Criteria andIsFreezLessThan(String value)
         {
              addCriterion("is_freez < ", value, "is_freez");
              return (Criteria) this;
         }

         public Criteria andIsFreezLessThanOrEqualTo(String value)
         {
              addCriterion("is_freez <= ", value, "is_freez");
              return (Criteria) this;
         }

         public Criteria andIsFreezLike(String value)
         {
              addCriterion("is_freez like ", value, "is_freez");
              return (Criteria) this;
         }

         public Criteria andIsFreezNotLike(String value)
         {
              addCriterion("is_freez not like ", value, "is_freez");
              return (Criteria) this;
         }

         public Criteria andIsFreezIn(List<String> values)
         {
              addCriterion("is_freez in ", values, "is_freez");
              return (Criteria) this;
         }

         public Criteria andIsFreezNotIn(List<String> values)
         {
              addCriterion("is_freez not in ", values, "is_freez");
              return (Criteria) this;
         }

         public Criteria andIsFreezBetween(String value1, String value2)
         {
              addCriterion("is_freez between ", value1,value2, "is_freez");
              return (Criteria) this;
         }

         public Criteria andIsFreezNotBetween(String value1, String value2)
         {
              addCriterion("is_freez not between ", value1,value2, "is_freez");
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
