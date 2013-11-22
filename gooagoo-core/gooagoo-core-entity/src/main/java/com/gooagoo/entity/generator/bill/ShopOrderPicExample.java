package com.gooagoo.entity.generator.bill;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * 商家订单原始信息图片详情
 */

public class ShopOrderPicExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopOrderPicExample()
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

         public Criteria andShopOrderDetailIdIsNull()
         {
              addCriterion("shop_order_detail_id is null");
              return (Criteria) this;
         }

         public Criteria andShopOrderDetailIdIsNotNull()
         {
              addCriterion("shop_order_detail_id is not null");
              return (Criteria) this;
         }

         public Criteria andShopOrderDetailIdEqualTo(String value)
         {
              addCriterion("shop_order_detail_id = ", value, "shop_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderDetailIdNotEqualTo(String value)
         {
              addCriterion("shop_order_detail_id <> ", value, "shop_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderDetailIdGreaterThan(String value)
         {
              addCriterion("shop_order_detail_id > ", value, "shop_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderDetailIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_order_detail_id >= ", value, "shop_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderDetailIdLessThan(String value)
         {
              addCriterion("shop_order_detail_id < ", value, "shop_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderDetailIdLessThanOrEqualTo(String value)
         {
              addCriterion("shop_order_detail_id <= ", value, "shop_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderDetailIdLike(String value)
         {
              addCriterion("shop_order_detail_id like ", value, "shop_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderDetailIdNotLike(String value)
         {
              addCriterion("shop_order_detail_id not like ", value, "shop_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderDetailIdIn(List<String> values)
         {
              addCriterion("shop_order_detail_id in ", values, "shop_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderDetailIdNotIn(List<String> values)
         {
              addCriterion("shop_order_detail_id not in ", values, "shop_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderDetailIdBetween(String value1, String value2)
         {
              addCriterion("shop_order_detail_id between ", value1,value2, "shop_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderDetailIdNotBetween(String value1, String value2)
         {
              addCriterion("shop_order_detail_id not between ", value1,value2, "shop_order_detail_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdIsNull()
         {
              addCriterion("shop_order_id is null");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdIsNotNull()
         {
              addCriterion("shop_order_id is not null");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdEqualTo(String value)
         {
              addCriterion("shop_order_id = ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdNotEqualTo(String value)
         {
              addCriterion("shop_order_id <> ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdGreaterThan(String value)
         {
              addCriterion("shop_order_id > ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_order_id >= ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdLessThan(String value)
         {
              addCriterion("shop_order_id < ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdLessThanOrEqualTo(String value)
         {
              addCriterion("shop_order_id <= ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdLike(String value)
         {
              addCriterion("shop_order_id like ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdNotLike(String value)
         {
              addCriterion("shop_order_id not like ", value, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdIn(List<String> values)
         {
              addCriterion("shop_order_id in ", values, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdNotIn(List<String> values)
         {
              addCriterion("shop_order_id not in ", values, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdBetween(String value1, String value2)
         {
              addCriterion("shop_order_id between ", value1,value2, "shop_order_id");
              return (Criteria) this;
         }

         public Criteria andShopOrderIdNotBetween(String value1, String value2)
         {
              addCriterion("shop_order_id not between ", value1,value2, "shop_order_id");
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
