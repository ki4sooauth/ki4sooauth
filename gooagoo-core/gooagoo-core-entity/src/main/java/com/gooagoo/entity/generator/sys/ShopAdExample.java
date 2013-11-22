package com.gooagoo.entity.generator.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 广告位信息
 */

public class ShopAdExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public ShopAdExample()
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

         public Criteria andAdCodeIsNull()
         {
              addCriterion("ad_code is null");
              return (Criteria) this;
         }

         public Criteria andAdCodeIsNotNull()
         {
              addCriterion("ad_code is not null");
              return (Criteria) this;
         }

         public Criteria andAdCodeEqualTo(String value)
         {
              addCriterion("ad_code = ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeNotEqualTo(String value)
         {
              addCriterion("ad_code <> ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeGreaterThan(String value)
         {
              addCriterion("ad_code > ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("ad_code >= ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeLessThan(String value)
         {
              addCriterion("ad_code < ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeLessThanOrEqualTo(String value)
         {
              addCriterion("ad_code <= ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeLike(String value)
         {
              addCriterion("ad_code like ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeNotLike(String value)
         {
              addCriterion("ad_code not like ", value, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeIn(List<String> values)
         {
              addCriterion("ad_code in ", values, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeNotIn(List<String> values)
         {
              addCriterion("ad_code not in ", values, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeBetween(String value1, String value2)
         {
              addCriterion("ad_code between ", value1,value2, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdCodeNotBetween(String value1, String value2)
         {
              addCriterion("ad_code not between ", value1,value2, "ad_code");
              return (Criteria) this;
         }

         public Criteria andAdTypeIsNull()
         {
              addCriterion("ad_type is null");
              return (Criteria) this;
         }

         public Criteria andAdTypeIsNotNull()
         {
              addCriterion("ad_type is not null");
              return (Criteria) this;
         }

         public Criteria andAdTypeEqualTo(String value)
         {
              addCriterion("ad_type = ", value, "ad_type");
              return (Criteria) this;
         }

         public Criteria andAdTypeNotEqualTo(String value)
         {
              addCriterion("ad_type <> ", value, "ad_type");
              return (Criteria) this;
         }

         public Criteria andAdTypeGreaterThan(String value)
         {
              addCriterion("ad_type > ", value, "ad_type");
              return (Criteria) this;
         }

         public Criteria andAdTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("ad_type >= ", value, "ad_type");
              return (Criteria) this;
         }

         public Criteria andAdTypeLessThan(String value)
         {
              addCriterion("ad_type < ", value, "ad_type");
              return (Criteria) this;
         }

         public Criteria andAdTypeLessThanOrEqualTo(String value)
         {
              addCriterion("ad_type <= ", value, "ad_type");
              return (Criteria) this;
         }

         public Criteria andAdTypeLike(String value)
         {
              addCriterion("ad_type like ", value, "ad_type");
              return (Criteria) this;
         }

         public Criteria andAdTypeNotLike(String value)
         {
              addCriterion("ad_type not like ", value, "ad_type");
              return (Criteria) this;
         }

         public Criteria andAdTypeIn(List<String> values)
         {
              addCriterion("ad_type in ", values, "ad_type");
              return (Criteria) this;
         }

         public Criteria andAdTypeNotIn(List<String> values)
         {
              addCriterion("ad_type not in ", values, "ad_type");
              return (Criteria) this;
         }

         public Criteria andAdTypeBetween(String value1, String value2)
         {
              addCriterion("ad_type between ", value1,value2, "ad_type");
              return (Criteria) this;
         }

         public Criteria andAdTypeNotBetween(String value1, String value2)
         {
              addCriterion("ad_type not between ", value1,value2, "ad_type");
              return (Criteria) this;
         }

         public Criteria andAdNameIsNull()
         {
              addCriterion("ad_name is null");
              return (Criteria) this;
         }

         public Criteria andAdNameIsNotNull()
         {
              addCriterion("ad_name is not null");
              return (Criteria) this;
         }

         public Criteria andAdNameEqualTo(String value)
         {
              addCriterion("ad_name = ", value, "ad_name");
              return (Criteria) this;
         }

         public Criteria andAdNameNotEqualTo(String value)
         {
              addCriterion("ad_name <> ", value, "ad_name");
              return (Criteria) this;
         }

         public Criteria andAdNameGreaterThan(String value)
         {
              addCriterion("ad_name > ", value, "ad_name");
              return (Criteria) this;
         }

         public Criteria andAdNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("ad_name >= ", value, "ad_name");
              return (Criteria) this;
         }

         public Criteria andAdNameLessThan(String value)
         {
              addCriterion("ad_name < ", value, "ad_name");
              return (Criteria) this;
         }

         public Criteria andAdNameLessThanOrEqualTo(String value)
         {
              addCriterion("ad_name <= ", value, "ad_name");
              return (Criteria) this;
         }

         public Criteria andAdNameLike(String value)
         {
              addCriterion("ad_name like ", value, "ad_name");
              return (Criteria) this;
         }

         public Criteria andAdNameNotLike(String value)
         {
              addCriterion("ad_name not like ", value, "ad_name");
              return (Criteria) this;
         }

         public Criteria andAdNameIn(List<String> values)
         {
              addCriterion("ad_name in ", values, "ad_name");
              return (Criteria) this;
         }

         public Criteria andAdNameNotIn(List<String> values)
         {
              addCriterion("ad_name not in ", values, "ad_name");
              return (Criteria) this;
         }

         public Criteria andAdNameBetween(String value1, String value2)
         {
              addCriterion("ad_name between ", value1,value2, "ad_name");
              return (Criteria) this;
         }

         public Criteria andAdNameNotBetween(String value1, String value2)
         {
              addCriterion("ad_name not between ", value1,value2, "ad_name");
              return (Criteria) this;
         }

         public Criteria andAdDescriptionIsNull()
         {
              addCriterion("ad_description is null");
              return (Criteria) this;
         }

         public Criteria andAdDescriptionIsNotNull()
         {
              addCriterion("ad_description is not null");
              return (Criteria) this;
         }

         public Criteria andAdDescriptionEqualTo(String value)
         {
              addCriterion("ad_description = ", value, "ad_description");
              return (Criteria) this;
         }

         public Criteria andAdDescriptionNotEqualTo(String value)
         {
              addCriterion("ad_description <> ", value, "ad_description");
              return (Criteria) this;
         }

         public Criteria andAdDescriptionGreaterThan(String value)
         {
              addCriterion("ad_description > ", value, "ad_description");
              return (Criteria) this;
         }

         public Criteria andAdDescriptionGreaterThanOrEqualTo(String value)
         {
              addCriterion("ad_description >= ", value, "ad_description");
              return (Criteria) this;
         }

         public Criteria andAdDescriptionLessThan(String value)
         {
              addCriterion("ad_description < ", value, "ad_description");
              return (Criteria) this;
         }

         public Criteria andAdDescriptionLessThanOrEqualTo(String value)
         {
              addCriterion("ad_description <= ", value, "ad_description");
              return (Criteria) this;
         }

         public Criteria andAdDescriptionLike(String value)
         {
              addCriterion("ad_description like ", value, "ad_description");
              return (Criteria) this;
         }

         public Criteria andAdDescriptionNotLike(String value)
         {
              addCriterion("ad_description not like ", value, "ad_description");
              return (Criteria) this;
         }

         public Criteria andAdDescriptionIn(List<String> values)
         {
              addCriterion("ad_description in ", values, "ad_description");
              return (Criteria) this;
         }

         public Criteria andAdDescriptionNotIn(List<String> values)
         {
              addCriterion("ad_description not in ", values, "ad_description");
              return (Criteria) this;
         }

         public Criteria andAdDescriptionBetween(String value1, String value2)
         {
              addCriterion("ad_description between ", value1,value2, "ad_description");
              return (Criteria) this;
         }

         public Criteria andAdDescriptionNotBetween(String value1, String value2)
         {
              addCriterion("ad_description not between ", value1,value2, "ad_description");
              return (Criteria) this;
         }

         public Criteria andImgUrlIsNull()
         {
              addCriterion("img_url is null");
              return (Criteria) this;
         }

         public Criteria andImgUrlIsNotNull()
         {
              addCriterion("img_url is not null");
              return (Criteria) this;
         }

         public Criteria andImgUrlEqualTo(String value)
         {
              addCriterion("img_url = ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlNotEqualTo(String value)
         {
              addCriterion("img_url <> ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlGreaterThan(String value)
         {
              addCriterion("img_url > ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlGreaterThanOrEqualTo(String value)
         {
              addCriterion("img_url >= ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlLessThan(String value)
         {
              addCriterion("img_url < ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlLessThanOrEqualTo(String value)
         {
              addCriterion("img_url <= ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlLike(String value)
         {
              addCriterion("img_url like ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlNotLike(String value)
         {
              addCriterion("img_url not like ", value, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlIn(List<String> values)
         {
              addCriterion("img_url in ", values, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlNotIn(List<String> values)
         {
              addCriterion("img_url not in ", values, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlBetween(String value1, String value2)
         {
              addCriterion("img_url between ", value1,value2, "img_url");
              return (Criteria) this;
         }

         public Criteria andImgUrlNotBetween(String value1, String value2)
         {
              addCriterion("img_url not between ", value1,value2, "img_url");
              return (Criteria) this;
         }

         public Criteria andLinkUrlIsNull()
         {
              addCriterion("link_url is null");
              return (Criteria) this;
         }

         public Criteria andLinkUrlIsNotNull()
         {
              addCriterion("link_url is not null");
              return (Criteria) this;
         }

         public Criteria andLinkUrlEqualTo(String value)
         {
              addCriterion("link_url = ", value, "link_url");
              return (Criteria) this;
         }

         public Criteria andLinkUrlNotEqualTo(String value)
         {
              addCriterion("link_url <> ", value, "link_url");
              return (Criteria) this;
         }

         public Criteria andLinkUrlGreaterThan(String value)
         {
              addCriterion("link_url > ", value, "link_url");
              return (Criteria) this;
         }

         public Criteria andLinkUrlGreaterThanOrEqualTo(String value)
         {
              addCriterion("link_url >= ", value, "link_url");
              return (Criteria) this;
         }

         public Criteria andLinkUrlLessThan(String value)
         {
              addCriterion("link_url < ", value, "link_url");
              return (Criteria) this;
         }

         public Criteria andLinkUrlLessThanOrEqualTo(String value)
         {
              addCriterion("link_url <= ", value, "link_url");
              return (Criteria) this;
         }

         public Criteria andLinkUrlLike(String value)
         {
              addCriterion("link_url like ", value, "link_url");
              return (Criteria) this;
         }

         public Criteria andLinkUrlNotLike(String value)
         {
              addCriterion("link_url not like ", value, "link_url");
              return (Criteria) this;
         }

         public Criteria andLinkUrlIn(List<String> values)
         {
              addCriterion("link_url in ", values, "link_url");
              return (Criteria) this;
         }

         public Criteria andLinkUrlNotIn(List<String> values)
         {
              addCriterion("link_url not in ", values, "link_url");
              return (Criteria) this;
         }

         public Criteria andLinkUrlBetween(String value1, String value2)
         {
              addCriterion("link_url between ", value1,value2, "link_url");
              return (Criteria) this;
         }

         public Criteria andLinkUrlNotBetween(String value1, String value2)
         {
              addCriterion("link_url not between ", value1,value2, "link_url");
              return (Criteria) this;
         }

         public Criteria andAdUrlIsNull()
         {
              addCriterion("ad_url is null");
              return (Criteria) this;
         }

         public Criteria andAdUrlIsNotNull()
         {
              addCriterion("ad_url is not null");
              return (Criteria) this;
         }

         public Criteria andAdUrlEqualTo(String value)
         {
              addCriterion("ad_url = ", value, "ad_url");
              return (Criteria) this;
         }

         public Criteria andAdUrlNotEqualTo(String value)
         {
              addCriterion("ad_url <> ", value, "ad_url");
              return (Criteria) this;
         }

         public Criteria andAdUrlGreaterThan(String value)
         {
              addCriterion("ad_url > ", value, "ad_url");
              return (Criteria) this;
         }

         public Criteria andAdUrlGreaterThanOrEqualTo(String value)
         {
              addCriterion("ad_url >= ", value, "ad_url");
              return (Criteria) this;
         }

         public Criteria andAdUrlLessThan(String value)
         {
              addCriterion("ad_url < ", value, "ad_url");
              return (Criteria) this;
         }

         public Criteria andAdUrlLessThanOrEqualTo(String value)
         {
              addCriterion("ad_url <= ", value, "ad_url");
              return (Criteria) this;
         }

         public Criteria andAdUrlLike(String value)
         {
              addCriterion("ad_url like ", value, "ad_url");
              return (Criteria) this;
         }

         public Criteria andAdUrlNotLike(String value)
         {
              addCriterion("ad_url not like ", value, "ad_url");
              return (Criteria) this;
         }

         public Criteria andAdUrlIn(List<String> values)
         {
              addCriterion("ad_url in ", values, "ad_url");
              return (Criteria) this;
         }

         public Criteria andAdUrlNotIn(List<String> values)
         {
              addCriterion("ad_url not in ", values, "ad_url");
              return (Criteria) this;
         }

         public Criteria andAdUrlBetween(String value1, String value2)
         {
              addCriterion("ad_url between ", value1,value2, "ad_url");
              return (Criteria) this;
         }

         public Criteria andAdUrlNotBetween(String value1, String value2)
         {
              addCriterion("ad_url not between ", value1,value2, "ad_url");
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
