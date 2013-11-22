package com.gooagoo.entity.generator.bill;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * 原始账单信息图片详情
 */

public class OriginalBillPicExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public OriginalBillPicExample()
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

         public Criteria andBillDetailIdIsNull()
         {
              addCriterion("bill_detail_id is null");
              return (Criteria) this;
         }

         public Criteria andBillDetailIdIsNotNull()
         {
              addCriterion("bill_detail_id is not null");
              return (Criteria) this;
         }

         public Criteria andBillDetailIdEqualTo(String value)
         {
              addCriterion("bill_detail_id = ", value, "bill_detail_id");
              return (Criteria) this;
         }

         public Criteria andBillDetailIdNotEqualTo(String value)
         {
              addCriterion("bill_detail_id <> ", value, "bill_detail_id");
              return (Criteria) this;
         }

         public Criteria andBillDetailIdGreaterThan(String value)
         {
              addCriterion("bill_detail_id > ", value, "bill_detail_id");
              return (Criteria) this;
         }

         public Criteria andBillDetailIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("bill_detail_id >= ", value, "bill_detail_id");
              return (Criteria) this;
         }

         public Criteria andBillDetailIdLessThan(String value)
         {
              addCriterion("bill_detail_id < ", value, "bill_detail_id");
              return (Criteria) this;
         }

         public Criteria andBillDetailIdLessThanOrEqualTo(String value)
         {
              addCriterion("bill_detail_id <= ", value, "bill_detail_id");
              return (Criteria) this;
         }

         public Criteria andBillDetailIdLike(String value)
         {
              addCriterion("bill_detail_id like ", value, "bill_detail_id");
              return (Criteria) this;
         }

         public Criteria andBillDetailIdNotLike(String value)
         {
              addCriterion("bill_detail_id not like ", value, "bill_detail_id");
              return (Criteria) this;
         }

         public Criteria andBillDetailIdIn(List<String> values)
         {
              addCriterion("bill_detail_id in ", values, "bill_detail_id");
              return (Criteria) this;
         }

         public Criteria andBillDetailIdNotIn(List<String> values)
         {
              addCriterion("bill_detail_id not in ", values, "bill_detail_id");
              return (Criteria) this;
         }

         public Criteria andBillDetailIdBetween(String value1, String value2)
         {
              addCriterion("bill_detail_id between ", value1,value2, "bill_detail_id");
              return (Criteria) this;
         }

         public Criteria andBillDetailIdNotBetween(String value1, String value2)
         {
              addCriterion("bill_detail_id not between ", value1,value2, "bill_detail_id");
              return (Criteria) this;
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

         public Criteria andPicUrlIsNull()
         {
              addCriterion("pic_url is null");
              return (Criteria) this;
         }

         public Criteria andPicUrlIsNotNull()
         {
              addCriterion("pic_url is not null");
              return (Criteria) this;
         }

         public Criteria andPicUrlEqualTo(String value)
         {
              addCriterion("pic_url = ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlNotEqualTo(String value)
         {
              addCriterion("pic_url <> ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlGreaterThan(String value)
         {
              addCriterion("pic_url > ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlGreaterThanOrEqualTo(String value)
         {
              addCriterion("pic_url >= ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlLessThan(String value)
         {
              addCriterion("pic_url < ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlLessThanOrEqualTo(String value)
         {
              addCriterion("pic_url <= ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlLike(String value)
         {
              addCriterion("pic_url like ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlNotLike(String value)
         {
              addCriterion("pic_url not like ", value, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlIn(List<String> values)
         {
              addCriterion("pic_url in ", values, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlNotIn(List<String> values)
         {
              addCriterion("pic_url not in ", values, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlBetween(String value1, String value2)
         {
              addCriterion("pic_url between ", value1,value2, "pic_url");
              return (Criteria) this;
         }

         public Criteria andPicUrlNotBetween(String value1, String value2)
         {
              addCriterion("pic_url not between ", value1,value2, "pic_url");
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
