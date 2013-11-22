package com.gooagoo.entity.generator.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 商家信息
 */

public class ShopInfoExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopInfoExample()
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

         public Criteria andEmailIsNull()
         {
              addCriterion("email is null");
              return (Criteria) this;
         }

         public Criteria andEmailIsNotNull()
         {
              addCriterion("email is not null");
              return (Criteria) this;
         }

         public Criteria andEmailEqualTo(String value)
         {
              addCriterion("email = ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailNotEqualTo(String value)
         {
              addCriterion("email <> ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailGreaterThan(String value)
         {
              addCriterion("email > ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailGreaterThanOrEqualTo(String value)
         {
              addCriterion("email >= ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailLessThan(String value)
         {
              addCriterion("email < ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailLessThanOrEqualTo(String value)
         {
              addCriterion("email <= ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailLike(String value)
         {
              addCriterion("email like ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailNotLike(String value)
         {
              addCriterion("email not like ", value, "email");
              return (Criteria) this;
         }

         public Criteria andEmailIn(List<String> values)
         {
              addCriterion("email in ", values, "email");
              return (Criteria) this;
         }

         public Criteria andEmailNotIn(List<String> values)
         {
              addCriterion("email not in ", values, "email");
              return (Criteria) this;
         }

         public Criteria andEmailBetween(String value1, String value2)
         {
              addCriterion("email between ", value1,value2, "email");
              return (Criteria) this;
         }

         public Criteria andEmailNotBetween(String value1, String value2)
         {
              addCriterion("email not between ", value1,value2, "email");
              return (Criteria) this;
         }

         public Criteria andNickNameIsNull()
         {
              addCriterion("nick_name is null");
              return (Criteria) this;
         }

         public Criteria andNickNameIsNotNull()
         {
              addCriterion("nick_name is not null");
              return (Criteria) this;
         }

         public Criteria andNickNameEqualTo(String value)
         {
              addCriterion("nick_name = ", value, "nick_name");
              return (Criteria) this;
         }

         public Criteria andNickNameNotEqualTo(String value)
         {
              addCriterion("nick_name <> ", value, "nick_name");
              return (Criteria) this;
         }

         public Criteria andNickNameGreaterThan(String value)
         {
              addCriterion("nick_name > ", value, "nick_name");
              return (Criteria) this;
         }

         public Criteria andNickNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("nick_name >= ", value, "nick_name");
              return (Criteria) this;
         }

         public Criteria andNickNameLessThan(String value)
         {
              addCriterion("nick_name < ", value, "nick_name");
              return (Criteria) this;
         }

         public Criteria andNickNameLessThanOrEqualTo(String value)
         {
              addCriterion("nick_name <= ", value, "nick_name");
              return (Criteria) this;
         }

         public Criteria andNickNameLike(String value)
         {
              addCriterion("nick_name like ", value, "nick_name");
              return (Criteria) this;
         }

         public Criteria andNickNameNotLike(String value)
         {
              addCriterion("nick_name not like ", value, "nick_name");
              return (Criteria) this;
         }

         public Criteria andNickNameIn(List<String> values)
         {
              addCriterion("nick_name in ", values, "nick_name");
              return (Criteria) this;
         }

         public Criteria andNickNameNotIn(List<String> values)
         {
              addCriterion("nick_name not in ", values, "nick_name");
              return (Criteria) this;
         }

         public Criteria andNickNameBetween(String value1, String value2)
         {
              addCriterion("nick_name between ", value1,value2, "nick_name");
              return (Criteria) this;
         }

         public Criteria andNickNameNotBetween(String value1, String value2)
         {
              addCriterion("nick_name not between ", value1,value2, "nick_name");
              return (Criteria) this;
         }

         public Criteria andShopStatusIsNull()
         {
              addCriterion("shop_status is null");
              return (Criteria) this;
         }

         public Criteria andShopStatusIsNotNull()
         {
              addCriterion("shop_status is not null");
              return (Criteria) this;
         }

         public Criteria andShopStatusEqualTo(String value)
         {
              addCriterion("shop_status = ", value, "shop_status");
              return (Criteria) this;
         }

         public Criteria andShopStatusNotEqualTo(String value)
         {
              addCriterion("shop_status <> ", value, "shop_status");
              return (Criteria) this;
         }

         public Criteria andShopStatusGreaterThan(String value)
         {
              addCriterion("shop_status > ", value, "shop_status");
              return (Criteria) this;
         }

         public Criteria andShopStatusGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_status >= ", value, "shop_status");
              return (Criteria) this;
         }

         public Criteria andShopStatusLessThan(String value)
         {
              addCriterion("shop_status < ", value, "shop_status");
              return (Criteria) this;
         }

         public Criteria andShopStatusLessThanOrEqualTo(String value)
         {
              addCriterion("shop_status <= ", value, "shop_status");
              return (Criteria) this;
         }

         public Criteria andShopStatusLike(String value)
         {
              addCriterion("shop_status like ", value, "shop_status");
              return (Criteria) this;
         }

         public Criteria andShopStatusNotLike(String value)
         {
              addCriterion("shop_status not like ", value, "shop_status");
              return (Criteria) this;
         }

         public Criteria andShopStatusIn(List<String> values)
         {
              addCriterion("shop_status in ", values, "shop_status");
              return (Criteria) this;
         }

         public Criteria andShopStatusNotIn(List<String> values)
         {
              addCriterion("shop_status not in ", values, "shop_status");
              return (Criteria) this;
         }

         public Criteria andShopStatusBetween(String value1, String value2)
         {
              addCriterion("shop_status between ", value1,value2, "shop_status");
              return (Criteria) this;
         }

         public Criteria andShopStatusNotBetween(String value1, String value2)
         {
              addCriterion("shop_status not between ", value1,value2, "shop_status");
              return (Criteria) this;
         }

         public Criteria andIsChainIsNull()
         {
              addCriterion("is_chain is null");
              return (Criteria) this;
         }

         public Criteria andIsChainIsNotNull()
         {
              addCriterion("is_chain is not null");
              return (Criteria) this;
         }

         public Criteria andIsChainEqualTo(String value)
         {
              addCriterion("is_chain = ", value, "is_chain");
              return (Criteria) this;
         }

         public Criteria andIsChainNotEqualTo(String value)
         {
              addCriterion("is_chain <> ", value, "is_chain");
              return (Criteria) this;
         }

         public Criteria andIsChainGreaterThan(String value)
         {
              addCriterion("is_chain > ", value, "is_chain");
              return (Criteria) this;
         }

         public Criteria andIsChainGreaterThanOrEqualTo(String value)
         {
              addCriterion("is_chain >= ", value, "is_chain");
              return (Criteria) this;
         }

         public Criteria andIsChainLessThan(String value)
         {
              addCriterion("is_chain < ", value, "is_chain");
              return (Criteria) this;
         }

         public Criteria andIsChainLessThanOrEqualTo(String value)
         {
              addCriterion("is_chain <= ", value, "is_chain");
              return (Criteria) this;
         }

         public Criteria andIsChainLike(String value)
         {
              addCriterion("is_chain like ", value, "is_chain");
              return (Criteria) this;
         }

         public Criteria andIsChainNotLike(String value)
         {
              addCriterion("is_chain not like ", value, "is_chain");
              return (Criteria) this;
         }

         public Criteria andIsChainIn(List<String> values)
         {
              addCriterion("is_chain in ", values, "is_chain");
              return (Criteria) this;
         }

         public Criteria andIsChainNotIn(List<String> values)
         {
              addCriterion("is_chain not in ", values, "is_chain");
              return (Criteria) this;
         }

         public Criteria andIsChainBetween(String value1, String value2)
         {
              addCriterion("is_chain between ", value1,value2, "is_chain");
              return (Criteria) this;
         }

         public Criteria andIsChainNotBetween(String value1, String value2)
         {
              addCriterion("is_chain not between ", value1,value2, "is_chain");
              return (Criteria) this;
         }

         public Criteria andServiceStyleIsNull()
         {
              addCriterion("service_style is null");
              return (Criteria) this;
         }

         public Criteria andServiceStyleIsNotNull()
         {
              addCriterion("service_style is not null");
              return (Criteria) this;
         }

         public Criteria andServiceStyleEqualTo(String value)
         {
              addCriterion("service_style = ", value, "service_style");
              return (Criteria) this;
         }

         public Criteria andServiceStyleNotEqualTo(String value)
         {
              addCriterion("service_style <> ", value, "service_style");
              return (Criteria) this;
         }

         public Criteria andServiceStyleGreaterThan(String value)
         {
              addCriterion("service_style > ", value, "service_style");
              return (Criteria) this;
         }

         public Criteria andServiceStyleGreaterThanOrEqualTo(String value)
         {
              addCriterion("service_style >= ", value, "service_style");
              return (Criteria) this;
         }

         public Criteria andServiceStyleLessThan(String value)
         {
              addCriterion("service_style < ", value, "service_style");
              return (Criteria) this;
         }

         public Criteria andServiceStyleLessThanOrEqualTo(String value)
         {
              addCriterion("service_style <= ", value, "service_style");
              return (Criteria) this;
         }

         public Criteria andServiceStyleLike(String value)
         {
              addCriterion("service_style like ", value, "service_style");
              return (Criteria) this;
         }

         public Criteria andServiceStyleNotLike(String value)
         {
              addCriterion("service_style not like ", value, "service_style");
              return (Criteria) this;
         }

         public Criteria andServiceStyleIn(List<String> values)
         {
              addCriterion("service_style in ", values, "service_style");
              return (Criteria) this;
         }

         public Criteria andServiceStyleNotIn(List<String> values)
         {
              addCriterion("service_style not in ", values, "service_style");
              return (Criteria) this;
         }

         public Criteria andServiceStyleBetween(String value1, String value2)
         {
              addCriterion("service_style between ", value1,value2, "service_style");
              return (Criteria) this;
         }

         public Criteria andServiceStyleNotBetween(String value1, String value2)
         {
              addCriterion("service_style not between ", value1,value2, "service_style");
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

         public Criteria andShopTypeRootIsNull()
         {
              addCriterion("shop_type_root is null");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootIsNotNull()
         {
              addCriterion("shop_type_root is not null");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootEqualTo(String value)
         {
              addCriterion("shop_type_root = ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootNotEqualTo(String value)
         {
              addCriterion("shop_type_root <> ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootGreaterThan(String value)
         {
              addCriterion("shop_type_root > ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_type_root >= ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootLessThan(String value)
         {
              addCriterion("shop_type_root < ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootLessThanOrEqualTo(String value)
         {
              addCriterion("shop_type_root <= ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootLike(String value)
         {
              addCriterion("shop_type_root like ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootNotLike(String value)
         {
              addCriterion("shop_type_root not like ", value, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootIn(List<String> values)
         {
              addCriterion("shop_type_root in ", values, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootNotIn(List<String> values)
         {
              addCriterion("shop_type_root not in ", values, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootBetween(String value1, String value2)
         {
              addCriterion("shop_type_root between ", value1,value2, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeRootNotBetween(String value1, String value2)
         {
              addCriterion("shop_type_root not between ", value1,value2, "shop_type_root");
              return (Criteria) this;
         }

         public Criteria andShopTypeLeafIsNull()
         {
              addCriterion("shop_type_leaf is null");
              return (Criteria) this;
         }

         public Criteria andShopTypeLeafIsNotNull()
         {
              addCriterion("shop_type_leaf is not null");
              return (Criteria) this;
         }

         public Criteria andShopTypeLeafEqualTo(String value)
         {
              addCriterion("shop_type_leaf = ", value, "shop_type_leaf");
              return (Criteria) this;
         }

         public Criteria andShopTypeLeafNotEqualTo(String value)
         {
              addCriterion("shop_type_leaf <> ", value, "shop_type_leaf");
              return (Criteria) this;
         }

         public Criteria andShopTypeLeafGreaterThan(String value)
         {
              addCriterion("shop_type_leaf > ", value, "shop_type_leaf");
              return (Criteria) this;
         }

         public Criteria andShopTypeLeafGreaterThanOrEqualTo(String value)
         {
              addCriterion("shop_type_leaf >= ", value, "shop_type_leaf");
              return (Criteria) this;
         }

         public Criteria andShopTypeLeafLessThan(String value)
         {
              addCriterion("shop_type_leaf < ", value, "shop_type_leaf");
              return (Criteria) this;
         }

         public Criteria andShopTypeLeafLessThanOrEqualTo(String value)
         {
              addCriterion("shop_type_leaf <= ", value, "shop_type_leaf");
              return (Criteria) this;
         }

         public Criteria andShopTypeLeafLike(String value)
         {
              addCriterion("shop_type_leaf like ", value, "shop_type_leaf");
              return (Criteria) this;
         }

         public Criteria andShopTypeLeafNotLike(String value)
         {
              addCriterion("shop_type_leaf not like ", value, "shop_type_leaf");
              return (Criteria) this;
         }

         public Criteria andShopTypeLeafIn(List<String> values)
         {
              addCriterion("shop_type_leaf in ", values, "shop_type_leaf");
              return (Criteria) this;
         }

         public Criteria andShopTypeLeafNotIn(List<String> values)
         {
              addCriterion("shop_type_leaf not in ", values, "shop_type_leaf");
              return (Criteria) this;
         }

         public Criteria andShopTypeLeafBetween(String value1, String value2)
         {
              addCriterion("shop_type_leaf between ", value1,value2, "shop_type_leaf");
              return (Criteria) this;
         }

         public Criteria andShopTypeLeafNotBetween(String value1, String value2)
         {
              addCriterion("shop_type_leaf not between ", value1,value2, "shop_type_leaf");
              return (Criteria) this;
         }

         public Criteria andLogo1IsNull()
         {
              addCriterion("logo1 is null");
              return (Criteria) this;
         }

         public Criteria andLogo1IsNotNull()
         {
              addCriterion("logo1 is not null");
              return (Criteria) this;
         }

         public Criteria andLogo1EqualTo(String value)
         {
              addCriterion("logo1 = ", value, "logo1");
              return (Criteria) this;
         }

         public Criteria andLogo1NotEqualTo(String value)
         {
              addCriterion("logo1 <> ", value, "logo1");
              return (Criteria) this;
         }

         public Criteria andLogo1GreaterThan(String value)
         {
              addCriterion("logo1 > ", value, "logo1");
              return (Criteria) this;
         }

         public Criteria andLogo1GreaterThanOrEqualTo(String value)
         {
              addCriterion("logo1 >= ", value, "logo1");
              return (Criteria) this;
         }

         public Criteria andLogo1LessThan(String value)
         {
              addCriterion("logo1 < ", value, "logo1");
              return (Criteria) this;
         }

         public Criteria andLogo1LessThanOrEqualTo(String value)
         {
              addCriterion("logo1 <= ", value, "logo1");
              return (Criteria) this;
         }

         public Criteria andLogo1Like(String value)
         {
              addCriterion("logo1 like ", value, "logo1");
              return (Criteria) this;
         }

         public Criteria andLogo1NotLike(String value)
         {
              addCriterion("logo1 not like ", value, "logo1");
              return (Criteria) this;
         }

         public Criteria andLogo1In(List<String> values)
         {
              addCriterion("logo1 in ", values, "logo1");
              return (Criteria) this;
         }

         public Criteria andLogo1NotIn(List<String> values)
         {
              addCriterion("logo1 not in ", values, "logo1");
              return (Criteria) this;
         }

         public Criteria andLogo1Between(String value1, String value2)
         {
              addCriterion("logo1 between ", value1,value2, "logo1");
              return (Criteria) this;
         }

         public Criteria andLogo1NotBetween(String value1, String value2)
         {
              addCriterion("logo1 not between ", value1,value2, "logo1");
              return (Criteria) this;
         }

         public Criteria andLogo2IsNull()
         {
              addCriterion("logo2 is null");
              return (Criteria) this;
         }

         public Criteria andLogo2IsNotNull()
         {
              addCriterion("logo2 is not null");
              return (Criteria) this;
         }

         public Criteria andLogo2EqualTo(String value)
         {
              addCriterion("logo2 = ", value, "logo2");
              return (Criteria) this;
         }

         public Criteria andLogo2NotEqualTo(String value)
         {
              addCriterion("logo2 <> ", value, "logo2");
              return (Criteria) this;
         }

         public Criteria andLogo2GreaterThan(String value)
         {
              addCriterion("logo2 > ", value, "logo2");
              return (Criteria) this;
         }

         public Criteria andLogo2GreaterThanOrEqualTo(String value)
         {
              addCriterion("logo2 >= ", value, "logo2");
              return (Criteria) this;
         }

         public Criteria andLogo2LessThan(String value)
         {
              addCriterion("logo2 < ", value, "logo2");
              return (Criteria) this;
         }

         public Criteria andLogo2LessThanOrEqualTo(String value)
         {
              addCriterion("logo2 <= ", value, "logo2");
              return (Criteria) this;
         }

         public Criteria andLogo2Like(String value)
         {
              addCriterion("logo2 like ", value, "logo2");
              return (Criteria) this;
         }

         public Criteria andLogo2NotLike(String value)
         {
              addCriterion("logo2 not like ", value, "logo2");
              return (Criteria) this;
         }

         public Criteria andLogo2In(List<String> values)
         {
              addCriterion("logo2 in ", values, "logo2");
              return (Criteria) this;
         }

         public Criteria andLogo2NotIn(List<String> values)
         {
              addCriterion("logo2 not in ", values, "logo2");
              return (Criteria) this;
         }

         public Criteria andLogo2Between(String value1, String value2)
         {
              addCriterion("logo2 between ", value1,value2, "logo2");
              return (Criteria) this;
         }

         public Criteria andLogo2NotBetween(String value1, String value2)
         {
              addCriterion("logo2 not between ", value1,value2, "logo2");
              return (Criteria) this;
         }

         public Criteria andLogo3IsNull()
         {
              addCriterion("logo3 is null");
              return (Criteria) this;
         }

         public Criteria andLogo3IsNotNull()
         {
              addCriterion("logo3 is not null");
              return (Criteria) this;
         }

         public Criteria andLogo3EqualTo(String value)
         {
              addCriterion("logo3 = ", value, "logo3");
              return (Criteria) this;
         }

         public Criteria andLogo3NotEqualTo(String value)
         {
              addCriterion("logo3 <> ", value, "logo3");
              return (Criteria) this;
         }

         public Criteria andLogo3GreaterThan(String value)
         {
              addCriterion("logo3 > ", value, "logo3");
              return (Criteria) this;
         }

         public Criteria andLogo3GreaterThanOrEqualTo(String value)
         {
              addCriterion("logo3 >= ", value, "logo3");
              return (Criteria) this;
         }

         public Criteria andLogo3LessThan(String value)
         {
              addCriterion("logo3 < ", value, "logo3");
              return (Criteria) this;
         }

         public Criteria andLogo3LessThanOrEqualTo(String value)
         {
              addCriterion("logo3 <= ", value, "logo3");
              return (Criteria) this;
         }

         public Criteria andLogo3Like(String value)
         {
              addCriterion("logo3 like ", value, "logo3");
              return (Criteria) this;
         }

         public Criteria andLogo3NotLike(String value)
         {
              addCriterion("logo3 not like ", value, "logo3");
              return (Criteria) this;
         }

         public Criteria andLogo3In(List<String> values)
         {
              addCriterion("logo3 in ", values, "logo3");
              return (Criteria) this;
         }

         public Criteria andLogo3NotIn(List<String> values)
         {
              addCriterion("logo3 not in ", values, "logo3");
              return (Criteria) this;
         }

         public Criteria andLogo3Between(String value1, String value2)
         {
              addCriterion("logo3 between ", value1,value2, "logo3");
              return (Criteria) this;
         }

         public Criteria andLogo3NotBetween(String value1, String value2)
         {
              addCriterion("logo3 not between ", value1,value2, "logo3");
              return (Criteria) this;
         }

         public Criteria andScopeIsNull()
         {
              addCriterion("scope is null");
              return (Criteria) this;
         }

         public Criteria andScopeIsNotNull()
         {
              addCriterion("scope is not null");
              return (Criteria) this;
         }

         public Criteria andScopeEqualTo(String value)
         {
              addCriterion("scope = ", value, "scope");
              return (Criteria) this;
         }

         public Criteria andScopeNotEqualTo(String value)
         {
              addCriterion("scope <> ", value, "scope");
              return (Criteria) this;
         }

         public Criteria andScopeGreaterThan(String value)
         {
              addCriterion("scope > ", value, "scope");
              return (Criteria) this;
         }

         public Criteria andScopeGreaterThanOrEqualTo(String value)
         {
              addCriterion("scope >= ", value, "scope");
              return (Criteria) this;
         }

         public Criteria andScopeLessThan(String value)
         {
              addCriterion("scope < ", value, "scope");
              return (Criteria) this;
         }

         public Criteria andScopeLessThanOrEqualTo(String value)
         {
              addCriterion("scope <= ", value, "scope");
              return (Criteria) this;
         }

         public Criteria andScopeLike(String value)
         {
              addCriterion("scope like ", value, "scope");
              return (Criteria) this;
         }

         public Criteria andScopeNotLike(String value)
         {
              addCriterion("scope not like ", value, "scope");
              return (Criteria) this;
         }

         public Criteria andScopeIn(List<String> values)
         {
              addCriterion("scope in ", values, "scope");
              return (Criteria) this;
         }

         public Criteria andScopeNotIn(List<String> values)
         {
              addCriterion("scope not in ", values, "scope");
              return (Criteria) this;
         }

         public Criteria andScopeBetween(String value1, String value2)
         {
              addCriterion("scope between ", value1,value2, "scope");
              return (Criteria) this;
         }

         public Criteria andScopeNotBetween(String value1, String value2)
         {
              addCriterion("scope not between ", value1,value2, "scope");
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
