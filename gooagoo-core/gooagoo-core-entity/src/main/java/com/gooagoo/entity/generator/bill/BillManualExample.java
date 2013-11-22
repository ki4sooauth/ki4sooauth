package com.gooagoo.entity.generator.bill;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 通过网站手工添加的账单
 */

public class BillManualExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public BillManualExample()
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

         public Criteria andBillIdIsNull()
         {
              addCriterion("bill_id is null");
              return (Criteria) this;
         }

         public Criteria andBillIdIsNotNull()
         {
              addCriterion("bill_id is not null");
              return (Criteria) this;
         }

         public Criteria andBillIdEqualTo(String value)
         {
              addCriterion("bill_id = ", value, "bill_id");
              return (Criteria) this;
         }

         public Criteria andBillIdNotEqualTo(String value)
         {
              addCriterion("bill_id <> ", value, "bill_id");
              return (Criteria) this;
         }

         public Criteria andBillIdGreaterThan(String value)
         {
              addCriterion("bill_id > ", value, "bill_id");
              return (Criteria) this;
         }

         public Criteria andBillIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("bill_id >= ", value, "bill_id");
              return (Criteria) this;
         }

         public Criteria andBillIdLessThan(String value)
         {
              addCriterion("bill_id < ", value, "bill_id");
              return (Criteria) this;
         }

         public Criteria andBillIdLessThanOrEqualTo(String value)
         {
              addCriterion("bill_id <= ", value, "bill_id");
              return (Criteria) this;
         }

         public Criteria andBillIdLike(String value)
         {
              addCriterion("bill_id like ", value, "bill_id");
              return (Criteria) this;
         }

         public Criteria andBillIdNotLike(String value)
         {
              addCriterion("bill_id not like ", value, "bill_id");
              return (Criteria) this;
         }

         public Criteria andBillIdIn(List<String> values)
         {
              addCriterion("bill_id in ", values, "bill_id");
              return (Criteria) this;
         }

         public Criteria andBillIdNotIn(List<String> values)
         {
              addCriterion("bill_id not in ", values, "bill_id");
              return (Criteria) this;
         }

         public Criteria andBillIdBetween(String value1, String value2)
         {
              addCriterion("bill_id between ", value1,value2, "bill_id");
              return (Criteria) this;
         }

         public Criteria andBillIdNotBetween(String value1, String value2)
         {
              addCriterion("bill_id not between ", value1,value2, "bill_id");
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

         public Criteria andBillNoIsNull()
         {
              addCriterion("bill_no is null");
              return (Criteria) this;
         }

         public Criteria andBillNoIsNotNull()
         {
              addCriterion("bill_no is not null");
              return (Criteria) this;
         }

         public Criteria andBillNoEqualTo(String value)
         {
              addCriterion("bill_no = ", value, "bill_no");
              return (Criteria) this;
         }

         public Criteria andBillNoNotEqualTo(String value)
         {
              addCriterion("bill_no <> ", value, "bill_no");
              return (Criteria) this;
         }

         public Criteria andBillNoGreaterThan(String value)
         {
              addCriterion("bill_no > ", value, "bill_no");
              return (Criteria) this;
         }

         public Criteria andBillNoGreaterThanOrEqualTo(String value)
         {
              addCriterion("bill_no >= ", value, "bill_no");
              return (Criteria) this;
         }

         public Criteria andBillNoLessThan(String value)
         {
              addCriterion("bill_no < ", value, "bill_no");
              return (Criteria) this;
         }

         public Criteria andBillNoLessThanOrEqualTo(String value)
         {
              addCriterion("bill_no <= ", value, "bill_no");
              return (Criteria) this;
         }

         public Criteria andBillNoLike(String value)
         {
              addCriterion("bill_no like ", value, "bill_no");
              return (Criteria) this;
         }

         public Criteria andBillNoNotLike(String value)
         {
              addCriterion("bill_no not like ", value, "bill_no");
              return (Criteria) this;
         }

         public Criteria andBillNoIn(List<String> values)
         {
              addCriterion("bill_no in ", values, "bill_no");
              return (Criteria) this;
         }

         public Criteria andBillNoNotIn(List<String> values)
         {
              addCriterion("bill_no not in ", values, "bill_no");
              return (Criteria) this;
         }

         public Criteria andBillNoBetween(String value1, String value2)
         {
              addCriterion("bill_no between ", value1,value2, "bill_no");
              return (Criteria) this;
         }

         public Criteria andBillNoNotBetween(String value1, String value2)
         {
              addCriterion("bill_no not between ", value1,value2, "bill_no");
              return (Criteria) this;
         }

         public Criteria andBillTypeIsNull()
         {
              addCriterion("bill_type is null");
              return (Criteria) this;
         }

         public Criteria andBillTypeIsNotNull()
         {
              addCriterion("bill_type is not null");
              return (Criteria) this;
         }

         public Criteria andBillTypeEqualTo(String value)
         {
              addCriterion("bill_type = ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeNotEqualTo(String value)
         {
              addCriterion("bill_type <> ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeGreaterThan(String value)
         {
              addCriterion("bill_type > ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("bill_type >= ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeLessThan(String value)
         {
              addCriterion("bill_type < ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeLessThanOrEqualTo(String value)
         {
              addCriterion("bill_type <= ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeLike(String value)
         {
              addCriterion("bill_type like ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeNotLike(String value)
         {
              addCriterion("bill_type not like ", value, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeIn(List<String> values)
         {
              addCriterion("bill_type in ", values, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeNotIn(List<String> values)
         {
              addCriterion("bill_type not in ", values, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeBetween(String value1, String value2)
         {
              addCriterion("bill_type between ", value1,value2, "bill_type");
              return (Criteria) this;
         }

         public Criteria andBillTypeNotBetween(String value1, String value2)
         {
              addCriterion("bill_type not between ", value1,value2, "bill_type");
              return (Criteria) this;
         }

         public Criteria andFeeIsNull()
         {
              addCriterion("fee is null");
              return (Criteria) this;
         }

         public Criteria andFeeIsNotNull()
         {
              addCriterion("fee is not null");
              return (Criteria) this;
         }

         public Criteria andFeeEqualTo(String value)
         {
              addCriterion("fee = ", value, "fee");
              return (Criteria) this;
         }

         public Criteria andFeeNotEqualTo(String value)
         {
              addCriterion("fee <> ", value, "fee");
              return (Criteria) this;
         }

         public Criteria andFeeGreaterThan(String value)
         {
              addCriterion("fee > ", value, "fee");
              return (Criteria) this;
         }

         public Criteria andFeeGreaterThanOrEqualTo(String value)
         {
              addCriterion("fee >= ", value, "fee");
              return (Criteria) this;
         }

         public Criteria andFeeLessThan(String value)
         {
              addCriterion("fee < ", value, "fee");
              return (Criteria) this;
         }

         public Criteria andFeeLessThanOrEqualTo(String value)
         {
              addCriterion("fee <= ", value, "fee");
              return (Criteria) this;
         }

         public Criteria andFeeLike(String value)
         {
              addCriterion("fee like ", value, "fee");
              return (Criteria) this;
         }

         public Criteria andFeeNotLike(String value)
         {
              addCriterion("fee not like ", value, "fee");
              return (Criteria) this;
         }

         public Criteria andFeeIn(List<String> values)
         {
              addCriterion("fee in ", values, "fee");
              return (Criteria) this;
         }

         public Criteria andFeeNotIn(List<String> values)
         {
              addCriterion("fee not in ", values, "fee");
              return (Criteria) this;
         }

         public Criteria andFeeBetween(String value1, String value2)
         {
              addCriterion("fee between ", value1,value2, "fee");
              return (Criteria) this;
         }

         public Criteria andFeeNotBetween(String value1, String value2)
         {
              addCriterion("fee not between ", value1,value2, "fee");
              return (Criteria) this;
         }

         public Criteria andRequestTimeIsNull()
         {
              addCriterion("request_time is null");
              return (Criteria) this;
         }

         public Criteria andRequestTimeIsNotNull()
         {
              addCriterion("request_time is not null");
              return (Criteria) this;
         }

         public Criteria andRequestTimeEqualTo(Date value)
         {
              addCriterion("request_time = ", value, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeNotEqualTo(Date value)
         {
              addCriterion("request_time <> ", value, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeGreaterThan(Date value)
         {
              addCriterion("request_time > ", value, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("request_time >= ", value, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeLessThan(Date value)
         {
              addCriterion("request_time < ", value, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("request_time <= ", value, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeIn(List<Date> values)
         {
              addCriterion("request_time in ", values, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeNotIn(List<Date> values)
         {
              addCriterion("request_time not in ", values, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeBetween(Date value1, Date value2)
         {
              addCriterion("request_time between ", value1,value2, "request_time");
              return (Criteria) this;
         }

         public Criteria andRequestTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("request_time not between ", value1,value2, "request_time");
              return (Criteria) this;
         }

         public Criteria andShopNameIsNull()
         {
              addCriterion("shop_name is null");
              return (Criteria) this;
         }

         public Criteria andShopNameIsNotNull()
         {
              addCriterion("shop_name is not null");
              return (Criteria) this;
         }

         public Criteria andShopNameEqualTo(String value)
         {
              addCriterion("shop_name = ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameNotEqualTo(String value)
         {
              addCriterion("shop_name <> ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameGreaterThan(String value)
         {
              addCriterion("shop_name > ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_name >= ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameLessThan(String value)
         {
              addCriterion("shop_name < ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameLessThanOrEqualTo(String value)
         {
              addCriterion("shop_name <= ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameLike(String value)
         {
              addCriterion("shop_name like ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameNotLike(String value)
         {
              addCriterion("shop_name not like ", value, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameIn(List<String> values)
         {
              addCriterion("shop_name in ", values, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameNotIn(List<String> values)
         {
              addCriterion("shop_name not in ", values, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameBetween(String value1, String value2)
         {
              addCriterion("shop_name between ", value1,value2, "shop_name");
              return (Criteria) this;
         }

         public Criteria andShopNameNotBetween(String value1, String value2)
         {
              addCriterion("shop_name not between ", value1,value2, "shop_name");
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
