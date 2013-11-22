package com.gooagoo.entity.generator.behave;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 用户反馈，收集用户对gooagooAPP的使用反馈
 */

public class UserFeedbackExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public UserFeedbackExample()
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

         public Criteria andFeedbackIdIsNull()
         {
              addCriterion("feedback_id is null");
              return (Criteria) this;
         }

         public Criteria andFeedbackIdIsNotNull()
         {
              addCriterion("feedback_id is not null");
              return (Criteria) this;
         }

         public Criteria andFeedbackIdEqualTo(String value)
         {
              addCriterion("feedback_id = ", value, "feedback_id");
              return (Criteria) this;
         }

         public Criteria andFeedbackIdNotEqualTo(String value)
         {
              addCriterion("feedback_id <> ", value, "feedback_id");
              return (Criteria) this;
         }

         public Criteria andFeedbackIdGreaterThan(String value)
         {
              addCriterion("feedback_id > ", value, "feedback_id");
              return (Criteria) this;
         }

         public Criteria andFeedbackIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("feedback_id >= ", value, "feedback_id");
              return (Criteria) this;
         }

         public Criteria andFeedbackIdLessThan(String value)
         {
              addCriterion("feedback_id < ", value, "feedback_id");
              return (Criteria) this;
         }

         public Criteria andFeedbackIdLessThanOrEqualTo(String value)
         {
              addCriterion("feedback_id <= ", value, "feedback_id");
              return (Criteria) this;
         }

         public Criteria andFeedbackIdLike(String value)
         {
              addCriterion("feedback_id like ", value, "feedback_id");
              return (Criteria) this;
         }

         public Criteria andFeedbackIdNotLike(String value)
         {
              addCriterion("feedback_id not like ", value, "feedback_id");
              return (Criteria) this;
         }

         public Criteria andFeedbackIdIn(List<String> values)
         {
              addCriterion("feedback_id in ", values, "feedback_id");
              return (Criteria) this;
         }

         public Criteria andFeedbackIdNotIn(List<String> values)
         {
              addCriterion("feedback_id not in ", values, "feedback_id");
              return (Criteria) this;
         }

         public Criteria andFeedbackIdBetween(String value1, String value2)
         {
              addCriterion("feedback_id between ", value1,value2, "feedback_id");
              return (Criteria) this;
         }

         public Criteria andFeedbackIdNotBetween(String value1, String value2)
         {
              addCriterion("feedback_id not between ", value1,value2, "feedback_id");
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

         public Criteria andGooagooIdIsNull()
         {
              addCriterion("gooagoo_id is null");
              return (Criteria) this;
         }

         public Criteria andGooagooIdIsNotNull()
         {
              addCriterion("gooagoo_id is not null");
              return (Criteria) this;
         }

         public Criteria andGooagooIdEqualTo(String value)
         {
              addCriterion("gooagoo_id = ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdNotEqualTo(String value)
         {
              addCriterion("gooagoo_id <> ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdGreaterThan(String value)
         {
              addCriterion("gooagoo_id > ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("gooagoo_id >= ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdLessThan(String value)
         {
              addCriterion("gooagoo_id < ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdLessThanOrEqualTo(String value)
         {
              addCriterion("gooagoo_id <= ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdLike(String value)
         {
              addCriterion("gooagoo_id like ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdNotLike(String value)
         {
              addCriterion("gooagoo_id not like ", value, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdIn(List<String> values)
         {
              addCriterion("gooagoo_id in ", values, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdNotIn(List<String> values)
         {
              addCriterion("gooagoo_id not in ", values, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdBetween(String value1, String value2)
         {
              addCriterion("gooagoo_id between ", value1,value2, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andGooagooIdNotBetween(String value1, String value2)
         {
              addCriterion("gooagoo_id not between ", value1,value2, "gooagoo_id");
              return (Criteria) this;
         }

         public Criteria andIpAddressIsNull()
         {
              addCriterion("ip_address is null");
              return (Criteria) this;
         }

         public Criteria andIpAddressIsNotNull()
         {
              addCriterion("ip_address is not null");
              return (Criteria) this;
         }

         public Criteria andIpAddressEqualTo(String value)
         {
              addCriterion("ip_address = ", value, "ip_address");
              return (Criteria) this;
         }

         public Criteria andIpAddressNotEqualTo(String value)
         {
              addCriterion("ip_address <> ", value, "ip_address");
              return (Criteria) this;
         }

         public Criteria andIpAddressGreaterThan(String value)
         {
              addCriterion("ip_address > ", value, "ip_address");
              return (Criteria) this;
         }

         public Criteria andIpAddressGreaterThanOrEqualTo(String value)
         {
              addCriterion("ip_address >= ", value, "ip_address");
              return (Criteria) this;
         }

         public Criteria andIpAddressLessThan(String value)
         {
              addCriterion("ip_address < ", value, "ip_address");
              return (Criteria) this;
         }

         public Criteria andIpAddressLessThanOrEqualTo(String value)
         {
              addCriterion("ip_address <= ", value, "ip_address");
              return (Criteria) this;
         }

         public Criteria andIpAddressLike(String value)
         {
              addCriterion("ip_address like ", value, "ip_address");
              return (Criteria) this;
         }

         public Criteria andIpAddressNotLike(String value)
         {
              addCriterion("ip_address not like ", value, "ip_address");
              return (Criteria) this;
         }

         public Criteria andIpAddressIn(List<String> values)
         {
              addCriterion("ip_address in ", values, "ip_address");
              return (Criteria) this;
         }

         public Criteria andIpAddressNotIn(List<String> values)
         {
              addCriterion("ip_address not in ", values, "ip_address");
              return (Criteria) this;
         }

         public Criteria andIpAddressBetween(String value1, String value2)
         {
              addCriterion("ip_address between ", value1,value2, "ip_address");
              return (Criteria) this;
         }

         public Criteria andIpAddressNotBetween(String value1, String value2)
         {
              addCriterion("ip_address not between ", value1,value2, "ip_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressIsNull()
         {
              addCriterion("mac_address is null");
              return (Criteria) this;
         }

         public Criteria andMacAddressIsNotNull()
         {
              addCriterion("mac_address is not null");
              return (Criteria) this;
         }

         public Criteria andMacAddressEqualTo(String value)
         {
              addCriterion("mac_address = ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressNotEqualTo(String value)
         {
              addCriterion("mac_address <> ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressGreaterThan(String value)
         {
              addCriterion("mac_address > ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressGreaterThanOrEqualTo(String value)
         {
              addCriterion("mac_address >= ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressLessThan(String value)
         {
              addCriterion("mac_address < ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressLessThanOrEqualTo(String value)
         {
              addCriterion("mac_address <= ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressLike(String value)
         {
              addCriterion("mac_address like ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressNotLike(String value)
         {
              addCriterion("mac_address not like ", value, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressIn(List<String> values)
         {
              addCriterion("mac_address in ", values, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressNotIn(List<String> values)
         {
              addCriterion("mac_address not in ", values, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressBetween(String value1, String value2)
         {
              addCriterion("mac_address between ", value1,value2, "mac_address");
              return (Criteria) this;
         }

         public Criteria andMacAddressNotBetween(String value1, String value2)
         {
              addCriterion("mac_address not between ", value1,value2, "mac_address");
              return (Criteria) this;
         }

         public Criteria andHostNameIsNull()
         {
              addCriterion("host_name is null");
              return (Criteria) this;
         }

         public Criteria andHostNameIsNotNull()
         {
              addCriterion("host_name is not null");
              return (Criteria) this;
         }

         public Criteria andHostNameEqualTo(String value)
         {
              addCriterion("host_name = ", value, "host_name");
              return (Criteria) this;
         }

         public Criteria andHostNameNotEqualTo(String value)
         {
              addCriterion("host_name <> ", value, "host_name");
              return (Criteria) this;
         }

         public Criteria andHostNameGreaterThan(String value)
         {
              addCriterion("host_name > ", value, "host_name");
              return (Criteria) this;
         }

         public Criteria andHostNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("host_name >= ", value, "host_name");
              return (Criteria) this;
         }

         public Criteria andHostNameLessThan(String value)
         {
              addCriterion("host_name < ", value, "host_name");
              return (Criteria) this;
         }

         public Criteria andHostNameLessThanOrEqualTo(String value)
         {
              addCriterion("host_name <= ", value, "host_name");
              return (Criteria) this;
         }

         public Criteria andHostNameLike(String value)
         {
              addCriterion("host_name like ", value, "host_name");
              return (Criteria) this;
         }

         public Criteria andHostNameNotLike(String value)
         {
              addCriterion("host_name not like ", value, "host_name");
              return (Criteria) this;
         }

         public Criteria andHostNameIn(List<String> values)
         {
              addCriterion("host_name in ", values, "host_name");
              return (Criteria) this;
         }

         public Criteria andHostNameNotIn(List<String> values)
         {
              addCriterion("host_name not in ", values, "host_name");
              return (Criteria) this;
         }

         public Criteria andHostNameBetween(String value1, String value2)
         {
              addCriterion("host_name between ", value1,value2, "host_name");
              return (Criteria) this;
         }

         public Criteria andHostNameNotBetween(String value1, String value2)
         {
              addCriterion("host_name not between ", value1,value2, "host_name");
              return (Criteria) this;
         }

         public Criteria andPhoneIsNull()
         {
              addCriterion("phone is null");
              return (Criteria) this;
         }

         public Criteria andPhoneIsNotNull()
         {
              addCriterion("phone is not null");
              return (Criteria) this;
         }

         public Criteria andPhoneEqualTo(String value)
         {
              addCriterion("phone = ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneNotEqualTo(String value)
         {
              addCriterion("phone <> ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneGreaterThan(String value)
         {
              addCriterion("phone > ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneGreaterThanOrEqualTo(String value)
         {
              addCriterion("phone >= ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneLessThan(String value)
         {
              addCriterion("phone < ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneLessThanOrEqualTo(String value)
         {
              addCriterion("phone <= ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneLike(String value)
         {
              addCriterion("phone like ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneNotLike(String value)
         {
              addCriterion("phone not like ", value, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneIn(List<String> values)
         {
              addCriterion("phone in ", values, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneNotIn(List<String> values)
         {
              addCriterion("phone not in ", values, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneBetween(String value1, String value2)
         {
              addCriterion("phone between ", value1,value2, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneNotBetween(String value1, String value2)
         {
              addCriterion("phone not between ", value1,value2, "phone");
              return (Criteria) this;
         }

         public Criteria andPhoneTypeIsNull()
         {
              addCriterion("phone_type is null");
              return (Criteria) this;
         }

         public Criteria andPhoneTypeIsNotNull()
         {
              addCriterion("phone_type is not null");
              return (Criteria) this;
         }

         public Criteria andPhoneTypeEqualTo(String value)
         {
              addCriterion("phone_type = ", value, "phone_type");
              return (Criteria) this;
         }

         public Criteria andPhoneTypeNotEqualTo(String value)
         {
              addCriterion("phone_type <> ", value, "phone_type");
              return (Criteria) this;
         }

         public Criteria andPhoneTypeGreaterThan(String value)
         {
              addCriterion("phone_type > ", value, "phone_type");
              return (Criteria) this;
         }

         public Criteria andPhoneTypeGreaterThanOrEqualTo(String value)
         {
              addCriterion("phone_type >= ", value, "phone_type");
              return (Criteria) this;
         }

         public Criteria andPhoneTypeLessThan(String value)
         {
              addCriterion("phone_type < ", value, "phone_type");
              return (Criteria) this;
         }

         public Criteria andPhoneTypeLessThanOrEqualTo(String value)
         {
              addCriterion("phone_type <= ", value, "phone_type");
              return (Criteria) this;
         }

         public Criteria andPhoneTypeLike(String value)
         {
              addCriterion("phone_type like ", value, "phone_type");
              return (Criteria) this;
         }

         public Criteria andPhoneTypeNotLike(String value)
         {
              addCriterion("phone_type not like ", value, "phone_type");
              return (Criteria) this;
         }

         public Criteria andPhoneTypeIn(List<String> values)
         {
              addCriterion("phone_type in ", values, "phone_type");
              return (Criteria) this;
         }

         public Criteria andPhoneTypeNotIn(List<String> values)
         {
              addCriterion("phone_type not in ", values, "phone_type");
              return (Criteria) this;
         }

         public Criteria andPhoneTypeBetween(String value1, String value2)
         {
              addCriterion("phone_type between ", value1,value2, "phone_type");
              return (Criteria) this;
         }

         public Criteria andPhoneTypeNotBetween(String value1, String value2)
         {
              addCriterion("phone_type not between ", value1,value2, "phone_type");
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

         public Criteria andContentIsNull()
         {
              addCriterion("content is null");
              return (Criteria) this;
         }

         public Criteria andContentIsNotNull()
         {
              addCriterion("content is not null");
              return (Criteria) this;
         }

         public Criteria andContentEqualTo(String value)
         {
              addCriterion("content = ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentNotEqualTo(String value)
         {
              addCriterion("content <> ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentGreaterThan(String value)
         {
              addCriterion("content > ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentGreaterThanOrEqualTo(String value)
         {
              addCriterion("content >= ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentLessThan(String value)
         {
              addCriterion("content < ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentLessThanOrEqualTo(String value)
         {
              addCriterion("content <= ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentLike(String value)
         {
              addCriterion("content like ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentNotLike(String value)
         {
              addCriterion("content not like ", value, "content");
              return (Criteria) this;
         }

         public Criteria andContentIn(List<String> values)
         {
              addCriterion("content in ", values, "content");
              return (Criteria) this;
         }

         public Criteria andContentNotIn(List<String> values)
         {
              addCriterion("content not in ", values, "content");
              return (Criteria) this;
         }

         public Criteria andContentBetween(String value1, String value2)
         {
              addCriterion("content between ", value1,value2, "content");
              return (Criteria) this;
         }

         public Criteria andContentNotBetween(String value1, String value2)
         {
              addCriterion("content not between ", value1,value2, "content");
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
