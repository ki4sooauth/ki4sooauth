package com.gooagoo.entity.generator.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 移动设备版本管理表
 */

public class MobileVersionExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public MobileVersionExample()
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

         public Criteria andAppCodeIsNull()
         {
              addCriterion("app_code is null");
              return (Criteria) this;
         }

         public Criteria andAppCodeIsNotNull()
         {
              addCriterion("app_code is not null");
              return (Criteria) this;
         }

         public Criteria andAppCodeEqualTo(String value)
         {
              addCriterion("app_code = ", value, "app_code");
              return (Criteria) this;
         }

         public Criteria andAppCodeNotEqualTo(String value)
         {
              addCriterion("app_code <> ", value, "app_code");
              return (Criteria) this;
         }

         public Criteria andAppCodeGreaterThan(String value)
         {
              addCriterion("app_code > ", value, "app_code");
              return (Criteria) this;
         }

         public Criteria andAppCodeGreaterThanOrEqualTo(String value)
         {
              addCriterion("app_code >= ", value, "app_code");
              return (Criteria) this;
         }

         public Criteria andAppCodeLessThan(String value)
         {
              addCriterion("app_code < ", value, "app_code");
              return (Criteria) this;
         }

         public Criteria andAppCodeLessThanOrEqualTo(String value)
         {
              addCriterion("app_code <= ", value, "app_code");
              return (Criteria) this;
         }

         public Criteria andAppCodeLike(String value)
         {
              addCriterion("app_code like ", value, "app_code");
              return (Criteria) this;
         }

         public Criteria andAppCodeNotLike(String value)
         {
              addCriterion("app_code not like ", value, "app_code");
              return (Criteria) this;
         }

         public Criteria andAppCodeIn(List<String> values)
         {
              addCriterion("app_code in ", values, "app_code");
              return (Criteria) this;
         }

         public Criteria andAppCodeNotIn(List<String> values)
         {
              addCriterion("app_code not in ", values, "app_code");
              return (Criteria) this;
         }

         public Criteria andAppCodeBetween(String value1, String value2)
         {
              addCriterion("app_code between ", value1,value2, "app_code");
              return (Criteria) this;
         }

         public Criteria andAppCodeNotBetween(String value1, String value2)
         {
              addCriterion("app_code not between ", value1,value2, "app_code");
              return (Criteria) this;
         }

         public Criteria andMobileTypeIsNull()
         {
              addCriterion("mobile_type is null");
              return (Criteria) this;
         }

         public Criteria andMobileTypeIsNotNull()
         {
              addCriterion("mobile_type is not null");
              return (Criteria) this;
         }

         public Criteria andMobileTypeEqualTo(String value)
         {
              addCriterion("mobile_type = ", value, "mobile_type");
              return (Criteria) this;
         }

         public Criteria andMobileTypeNotEqualTo(String value)
         {
              addCriterion("mobile_type <> ", value, "mobile_type");
              return (Criteria) this;
         }

         public Criteria andMobileTypeGreaterThan(String value)
         {
              addCriterion("mobile_type > ", value, "mobile_type");
              return (Criteria) this;
         }

         public Criteria andMobileTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("mobile_type >= ", value, "mobile_type");
              return (Criteria) this;
         }

         public Criteria andMobileTypeLessThan(String value)
         {
              addCriterion("mobile_type < ", value, "mobile_type");
              return (Criteria) this;
         }

         public Criteria andMobileTypeLessThanOrEqualTo(String value)
         {
              addCriterion("mobile_type <= ", value, "mobile_type");
              return (Criteria) this;
         }

         public Criteria andMobileTypeLike(String value)
         {
              addCriterion("mobile_type like ", value, "mobile_type");
              return (Criteria) this;
         }

         public Criteria andMobileTypeNotLike(String value)
         {
              addCriterion("mobile_type not like ", value, "mobile_type");
              return (Criteria) this;
         }

         public Criteria andMobileTypeIn(List<String> values)
         {
              addCriterion("mobile_type in ", values, "mobile_type");
              return (Criteria) this;
         }

         public Criteria andMobileTypeNotIn(List<String> values)
         {
              addCriterion("mobile_type not in ", values, "mobile_type");
              return (Criteria) this;
         }

         public Criteria andMobileTypeBetween(String value1, String value2)
         {
              addCriterion("mobile_type between ", value1,value2, "mobile_type");
              return (Criteria) this;
         }

         public Criteria andMobileTypeNotBetween(String value1, String value2)
         {
              addCriterion("mobile_type not between ", value1,value2, "mobile_type");
              return (Criteria) this;
         }

         public Criteria andVersionIsNull()
         {
              addCriterion("version is null");
              return (Criteria) this;
         }

         public Criteria andVersionIsNotNull()
         {
              addCriterion("version is not null");
              return (Criteria) this;
         }

         public Criteria andVersionEqualTo(String value)
         {
              addCriterion("version = ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionNotEqualTo(String value)
         {
              addCriterion("version <> ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionGreaterThan(String value)
         {
              addCriterion("version > ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionGreaterThanOrEqualTo(String value)
         {
              addCriterion("version >= ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionLessThan(String value)
         {
              addCriterion("version < ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionLessThanOrEqualTo(String value)
         {
              addCriterion("version <= ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionLike(String value)
         {
              addCriterion("version like ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionNotLike(String value)
         {
              addCriterion("version not like ", value, "version");
              return (Criteria) this;
         }

         public Criteria andVersionIn(List<String> values)
         {
              addCriterion("version in ", values, "version");
              return (Criteria) this;
         }

         public Criteria andVersionNotIn(List<String> values)
         {
              addCriterion("version not in ", values, "version");
              return (Criteria) this;
         }

         public Criteria andVersionBetween(String value1, String value2)
         {
              addCriterion("version between ", value1,value2, "version");
              return (Criteria) this;
         }

         public Criteria andVersionNotBetween(String value1, String value2)
         {
              addCriterion("version not between ", value1,value2, "version");
              return (Criteria) this;
         }

         public Criteria andVersionNameIsNull()
         {
              addCriterion("version_name is null");
              return (Criteria) this;
         }

         public Criteria andVersionNameIsNotNull()
         {
              addCriterion("version_name is not null");
              return (Criteria) this;
         }

         public Criteria andVersionNameEqualTo(String value)
         {
              addCriterion("version_name = ", value, "version_name");
              return (Criteria) this;
         }

         public Criteria andVersionNameNotEqualTo(String value)
         {
              addCriterion("version_name <> ", value, "version_name");
              return (Criteria) this;
         }

         public Criteria andVersionNameGreaterThan(String value)
         {
              addCriterion("version_name > ", value, "version_name");
              return (Criteria) this;
         }

         public Criteria andVersionNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("version_name >= ", value, "version_name");
              return (Criteria) this;
         }

         public Criteria andVersionNameLessThan(String value)
         {
              addCriterion("version_name < ", value, "version_name");
              return (Criteria) this;
         }

         public Criteria andVersionNameLessThanOrEqualTo(String value)
         {
              addCriterion("version_name <= ", value, "version_name");
              return (Criteria) this;
         }

         public Criteria andVersionNameLike(String value)
         {
              addCriterion("version_name like ", value, "version_name");
              return (Criteria) this;
         }

         public Criteria andVersionNameNotLike(String value)
         {
              addCriterion("version_name not like ", value, "version_name");
              return (Criteria) this;
         }

         public Criteria andVersionNameIn(List<String> values)
         {
              addCriterion("version_name in ", values, "version_name");
              return (Criteria) this;
         }

         public Criteria andVersionNameNotIn(List<String> values)
         {
              addCriterion("version_name not in ", values, "version_name");
              return (Criteria) this;
         }

         public Criteria andVersionNameBetween(String value1, String value2)
         {
              addCriterion("version_name between ", value1,value2, "version_name");
              return (Criteria) this;
         }

         public Criteria andVersionNameNotBetween(String value1, String value2)
         {
              addCriterion("version_name not between ", value1,value2, "version_name");
              return (Criteria) this;
         }

         public Criteria andLinkIsNull()
         {
              addCriterion("link is null");
              return (Criteria) this;
         }

         public Criteria andLinkIsNotNull()
         {
              addCriterion("link is not null");
              return (Criteria) this;
         }

         public Criteria andLinkEqualTo(String value)
         {
              addCriterion("link = ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkNotEqualTo(String value)
         {
              addCriterion("link <> ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkGreaterThan(String value)
         {
              addCriterion("link > ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkGreaterThanOrEqualTo(String value)
         {
              addCriterion("link >= ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkLessThan(String value)
         {
              addCriterion("link < ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkLessThanOrEqualTo(String value)
         {
              addCriterion("link <= ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkLike(String value)
         {
              addCriterion("link like ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkNotLike(String value)
         {
              addCriterion("link not like ", value, "link");
              return (Criteria) this;
         }

         public Criteria andLinkIn(List<String> values)
         {
              addCriterion("link in ", values, "link");
              return (Criteria) this;
         }

         public Criteria andLinkNotIn(List<String> values)
         {
              addCriterion("link not in ", values, "link");
              return (Criteria) this;
         }

         public Criteria andLinkBetween(String value1, String value2)
         {
              addCriterion("link between ", value1,value2, "link");
              return (Criteria) this;
         }

         public Criteria andLinkNotBetween(String value1, String value2)
         {
              addCriterion("link not between ", value1,value2, "link");
              return (Criteria) this;
         }

         public Criteria andPlatformIsNull()
         {
              addCriterion("platform is null");
              return (Criteria) this;
         }

         public Criteria andPlatformIsNotNull()
         {
              addCriterion("platform is not null");
              return (Criteria) this;
         }

         public Criteria andPlatformEqualTo(String value)
         {
              addCriterion("platform = ", value, "platform");
              return (Criteria) this;
         }

         public Criteria andPlatformNotEqualTo(String value)
         {
              addCriterion("platform <> ", value, "platform");
              return (Criteria) this;
         }

         public Criteria andPlatformGreaterThan(String value)
         {
              addCriterion("platform > ", value, "platform");
              return (Criteria) this;
         }

         public Criteria andPlatformGreaterThanOrEqualTo(String value)
         {
              addCriterion("platform >= ", value, "platform");
              return (Criteria) this;
         }

         public Criteria andPlatformLessThan(String value)
         {
              addCriterion("platform < ", value, "platform");
              return (Criteria) this;
         }

         public Criteria andPlatformLessThanOrEqualTo(String value)
         {
              addCriterion("platform <= ", value, "platform");
              return (Criteria) this;
         }

         public Criteria andPlatformLike(String value)
         {
              addCriterion("platform like ", value, "platform");
              return (Criteria) this;
         }

         public Criteria andPlatformNotLike(String value)
         {
              addCriterion("platform not like ", value, "platform");
              return (Criteria) this;
         }

         public Criteria andPlatformIn(List<String> values)
         {
              addCriterion("platform in ", values, "platform");
              return (Criteria) this;
         }

         public Criteria andPlatformNotIn(List<String> values)
         {
              addCriterion("platform not in ", values, "platform");
              return (Criteria) this;
         }

         public Criteria andPlatformBetween(String value1, String value2)
         {
              addCriterion("platform between ", value1,value2, "platform");
              return (Criteria) this;
         }

         public Criteria andPlatformNotBetween(String value1, String value2)
         {
              addCriterion("platform not between ", value1,value2, "platform");
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
