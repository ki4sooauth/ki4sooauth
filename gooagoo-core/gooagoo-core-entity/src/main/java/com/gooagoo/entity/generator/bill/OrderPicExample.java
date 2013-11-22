package com.gooagoo.entity.generator.bill;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 订单图片详情
 */

public class OrderPicExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public OrderPicExample()
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

         public Criteria andOrderDetailIdIsNull()
         {
              addCriterion("order_detail_id is null");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdIsNotNull()
         {
              addCriterion("order_detail_id is not null");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdEqualTo(String value)
         {
              addCriterion("order_detail_id = ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdNotEqualTo(String value)
         {
              addCriterion("order_detail_id <> ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdGreaterThan(String value)
         {
              addCriterion("order_detail_id > ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("order_detail_id >= ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdLessThan(String value)
         {
              addCriterion("order_detail_id < ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdLessThanOrEqualTo(String value)
         {
              addCriterion("order_detail_id <= ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdLike(String value)
         {
              addCriterion("order_detail_id like ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdNotLike(String value)
         {
              addCriterion("order_detail_id not like ", value, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdIn(List<String> values)
         {
              addCriterion("order_detail_id in ", values, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdNotIn(List<String> values)
         {
              addCriterion("order_detail_id not in ", values, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdBetween(String value1, String value2)
         {
              addCriterion("order_detail_id between ", value1,value2, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderDetailIdNotBetween(String value1, String value2)
         {
              addCriterion("order_detail_id not between ", value1,value2, "order_detail_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdIsNull()
         {
              addCriterion("order_id is null");
              return (Criteria) this;
         }

         public Criteria andOrderIdIsNotNull()
         {
              addCriterion("order_id is not null");
              return (Criteria) this;
         }

         public Criteria andOrderIdEqualTo(String value)
         {
              addCriterion("order_id = ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdNotEqualTo(String value)
         {
              addCriterion("order_id <> ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdGreaterThan(String value)
         {
              addCriterion("order_id > ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("order_id >= ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdLessThan(String value)
         {
              addCriterion("order_id < ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdLessThanOrEqualTo(String value)
         {
              addCriterion("order_id <= ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdLike(String value)
         {
              addCriterion("order_id like ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdNotLike(String value)
         {
              addCriterion("order_id not like ", value, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdIn(List<String> values)
         {
              addCriterion("order_id in ", values, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdNotIn(List<String> values)
         {
              addCriterion("order_id not in ", values, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdBetween(String value1, String value2)
         {
              addCriterion("order_id between ", value1,value2, "order_id");
              return (Criteria) this;
         }

         public Criteria andOrderIdNotBetween(String value1, String value2)
         {
              addCriterion("order_id not between ", value1,value2, "order_id");
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

         public Criteria andPicTypeIsNull()
         {
              addCriterion("pic_type is null");
              return (Criteria) this;
         }

         public Criteria andPicTypeIsNotNull()
         {
              addCriterion("pic_type is not null");
              return (Criteria) this;
         }

         public Criteria andPicTypeEqualTo(String value)
         {
              addCriterion("pic_type = ", value, "pic_type");
              return (Criteria) this;
         }

         public Criteria andPicTypeNotEqualTo(String value)
         {
              addCriterion("pic_type <> ", value, "pic_type");
              return (Criteria) this;
         }

         public Criteria andPicTypeGreaterThan(String value)
         {
              addCriterion("pic_type > ", value, "pic_type");
              return (Criteria) this;
         }

         public Criteria andPicTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("pic_type >= ", value, "pic_type");
              return (Criteria) this;
         }

         public Criteria andPicTypeLessThan(String value)
         {
              addCriterion("pic_type < ", value, "pic_type");
              return (Criteria) this;
         }

         public Criteria andPicTypeLessThanOrEqualTo(String value)
         {
              addCriterion("pic_type <= ", value, "pic_type");
              return (Criteria) this;
         }

         public Criteria andPicTypeLike(String value)
         {
              addCriterion("pic_type like ", value, "pic_type");
              return (Criteria) this;
         }

         public Criteria andPicTypeNotLike(String value)
         {
              addCriterion("pic_type not like ", value, "pic_type");
              return (Criteria) this;
         }

         public Criteria andPicTypeIn(List<String> values)
         {
              addCriterion("pic_type in ", values, "pic_type");
              return (Criteria) this;
         }

         public Criteria andPicTypeNotIn(List<String> values)
         {
              addCriterion("pic_type not in ", values, "pic_type");
              return (Criteria) this;
         }

         public Criteria andPicTypeBetween(String value1, String value2)
         {
              addCriterion("pic_type between ", value1,value2, "pic_type");
              return (Criteria) this;
         }

         public Criteria andPicTypeNotBetween(String value1, String value2)
         {
              addCriterion("pic_type not between ", value1,value2, "pic_type");
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
