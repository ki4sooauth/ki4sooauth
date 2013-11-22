package com.gooagoo.entity.generator.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 广告位管理
 */

public class AdsManageExample implements Serializable
{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart = -1;

    protected Integer limitEnd = -1;


    public AdsManageExample()
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

         public Criteria andBidIdIsNull()
         {
              addCriterion("bid_id is null");
              return (Criteria) this;
         }

         public Criteria andBidIdIsNotNull()
         {
              addCriterion("bid_id is not null");
              return (Criteria) this;
         }

         public Criteria andBidIdEqualTo(String value)
         {
              addCriterion("bid_id = ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdNotEqualTo(String value)
         {
              addCriterion("bid_id <> ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdGreaterThan(String value)
         {
              addCriterion("bid_id > ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("bid_id >= ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdLessThan(String value)
         {
              addCriterion("bid_id < ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdLessThanOrEqualTo(String value)
         {
              addCriterion("bid_id <= ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdLike(String value)
         {
              addCriterion("bid_id like ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdNotLike(String value)
         {
              addCriterion("bid_id not like ", value, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdIn(List<String> values)
         {
              addCriterion("bid_id in ", values, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdNotIn(List<String> values)
         {
              addCriterion("bid_id not in ", values, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdBetween(String value1, String value2)
         {
              addCriterion("bid_id between ", value1,value2, "bid_id");
              return (Criteria) this;
         }

         public Criteria andBidIdNotBetween(String value1, String value2)
         {
              addCriterion("bid_id not between ", value1,value2, "bid_id");
              return (Criteria) this;
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

         public Criteria andStartingPriceIsNull()
         {
              addCriterion("starting_price is null");
              return (Criteria) this;
         }

         public Criteria andStartingPriceIsNotNull()
         {
              addCriterion("starting_price is not null");
              return (Criteria) this;
         }

         public Criteria andStartingPriceEqualTo(String value)
         {
              addCriterion("starting_price = ", value, "starting_price");
              return (Criteria) this;
         }

         public Criteria andStartingPriceNotEqualTo(String value)
         {
              addCriterion("starting_price <> ", value, "starting_price");
              return (Criteria) this;
         }

         public Criteria andStartingPriceGreaterThan(String value)
         {
              addCriterion("starting_price > ", value, "starting_price");
              return (Criteria) this;
         }

         public Criteria andStartingPriceGreaterThanOrEqualTo(String value)
         {
              addCriterion("starting_price >= ", value, "starting_price");
              return (Criteria) this;
         }

         public Criteria andStartingPriceLessThan(String value)
         {
              addCriterion("starting_price < ", value, "starting_price");
              return (Criteria) this;
         }

         public Criteria andStartingPriceLessThanOrEqualTo(String value)
         {
              addCriterion("starting_price <= ", value, "starting_price");
              return (Criteria) this;
         }

         public Criteria andStartingPriceLike(String value)
         {
              addCriterion("starting_price like ", value, "starting_price");
              return (Criteria) this;
         }

         public Criteria andStartingPriceNotLike(String value)
         {
              addCriterion("starting_price not like ", value, "starting_price");
              return (Criteria) this;
         }

         public Criteria andStartingPriceIn(List<String> values)
         {
              addCriterion("starting_price in ", values, "starting_price");
              return (Criteria) this;
         }

         public Criteria andStartingPriceNotIn(List<String> values)
         {
              addCriterion("starting_price not in ", values, "starting_price");
              return (Criteria) this;
         }

         public Criteria andStartingPriceBetween(String value1, String value2)
         {
              addCriterion("starting_price between ", value1,value2, "starting_price");
              return (Criteria) this;
         }

         public Criteria andStartingPriceNotBetween(String value1, String value2)
         {
              addCriterion("starting_price not between ", value1,value2, "starting_price");
              return (Criteria) this;
         }

         public Criteria andIncreaseIsNull()
         {
              addCriterion("increase is null");
              return (Criteria) this;
         }

         public Criteria andIncreaseIsNotNull()
         {
              addCriterion("increase is not null");
              return (Criteria) this;
         }

         public Criteria andIncreaseEqualTo(String value)
         {
              addCriterion("increase = ", value, "increase");
              return (Criteria) this;
         }

         public Criteria andIncreaseNotEqualTo(String value)
         {
              addCriterion("increase <> ", value, "increase");
              return (Criteria) this;
         }

         public Criteria andIncreaseGreaterThan(String value)
         {
              addCriterion("increase > ", value, "increase");
              return (Criteria) this;
         }

         public Criteria andIncreaseGreaterThanOrEqualTo(String value)
         {
              addCriterion("increase >= ", value, "increase");
              return (Criteria) this;
         }

         public Criteria andIncreaseLessThan(String value)
         {
              addCriterion("increase < ", value, "increase");
              return (Criteria) this;
         }

         public Criteria andIncreaseLessThanOrEqualTo(String value)
         {
              addCriterion("increase <= ", value, "increase");
              return (Criteria) this;
         }

         public Criteria andIncreaseLike(String value)
         {
              addCriterion("increase like ", value, "increase");
              return (Criteria) this;
         }

         public Criteria andIncreaseNotLike(String value)
         {
              addCriterion("increase not like ", value, "increase");
              return (Criteria) this;
         }

         public Criteria andIncreaseIn(List<String> values)
         {
              addCriterion("increase in ", values, "increase");
              return (Criteria) this;
         }

         public Criteria andIncreaseNotIn(List<String> values)
         {
              addCriterion("increase not in ", values, "increase");
              return (Criteria) this;
         }

         public Criteria andIncreaseBetween(String value1, String value2)
         {
              addCriterion("increase between ", value1,value2, "increase");
              return (Criteria) this;
         }

         public Criteria andIncreaseNotBetween(String value1, String value2)
         {
              addCriterion("increase not between ", value1,value2, "increase");
              return (Criteria) this;
         }

         public Criteria andStateIsNull()
         {
              addCriterion("state is null");
              return (Criteria) this;
         }

         public Criteria andStateIsNotNull()
         {
              addCriterion("state is not null");
              return (Criteria) this;
         }

         public Criteria andStateEqualTo(String value)
         {
              addCriterion("state = ", value, "state");
              return (Criteria) this;
         }

         public Criteria andStateNotEqualTo(String value)
         {
              addCriterion("state <> ", value, "state");
              return (Criteria) this;
         }

         public Criteria andStateGreaterThan(String value)
         {
              addCriterion("state > ", value, "state");
              return (Criteria) this;
         }

         public Criteria andStateGreaterThanOrEqualTo(String value)
         {
              addCriterion("state >= ", value, "state");
              return (Criteria) this;
         }

         public Criteria andStateLessThan(String value)
         {
              addCriterion("state < ", value, "state");
              return (Criteria) this;
         }

         public Criteria andStateLessThanOrEqualTo(String value)
         {
              addCriterion("state <= ", value, "state");
              return (Criteria) this;
         }

         public Criteria andStateLike(String value)
         {
              addCriterion("state like ", value, "state");
              return (Criteria) this;
         }

         public Criteria andStateNotLike(String value)
         {
              addCriterion("state not like ", value, "state");
              return (Criteria) this;
         }

         public Criteria andStateIn(List<String> values)
         {
              addCriterion("state in ", values, "state");
              return (Criteria) this;
         }

         public Criteria andStateNotIn(List<String> values)
         {
              addCriterion("state not in ", values, "state");
              return (Criteria) this;
         }

         public Criteria andStateBetween(String value1, String value2)
         {
              addCriterion("state between ", value1,value2, "state");
              return (Criteria) this;
         }

         public Criteria andStateNotBetween(String value1, String value2)
         {
              addCriterion("state not between ", value1,value2, "state");
              return (Criteria) this;
         }

         public Criteria andWinnerShooIdIsNull()
         {
              addCriterion("winner_shoo_id is null");
              return (Criteria) this;
         }

         public Criteria andWinnerShooIdIsNotNull()
         {
              addCriterion("winner_shoo_id is not null");
              return (Criteria) this;
         }

         public Criteria andWinnerShooIdEqualTo(String value)
         {
              addCriterion("winner_shoo_id = ", value, "winner_shoo_id");
              return (Criteria) this;
         }

         public Criteria andWinnerShooIdNotEqualTo(String value)
         {
              addCriterion("winner_shoo_id <> ", value, "winner_shoo_id");
              return (Criteria) this;
         }

         public Criteria andWinnerShooIdGreaterThan(String value)
         {
              addCriterion("winner_shoo_id > ", value, "winner_shoo_id");
              return (Criteria) this;
         }

         public Criteria andWinnerShooIdGreaterThanOrEqualTo(String value)
         {
              addCriterion("winner_shoo_id >= ", value, "winner_shoo_id");
              return (Criteria) this;
         }

         public Criteria andWinnerShooIdLessThan(String value)
         {
              addCriterion("winner_shoo_id < ", value, "winner_shoo_id");
              return (Criteria) this;
         }

         public Criteria andWinnerShooIdLessThanOrEqualTo(String value)
         {
              addCriterion("winner_shoo_id <= ", value, "winner_shoo_id");
              return (Criteria) this;
         }

         public Criteria andWinnerShooIdLike(String value)
         {
              addCriterion("winner_shoo_id like ", value, "winner_shoo_id");
              return (Criteria) this;
         }

         public Criteria andWinnerShooIdNotLike(String value)
         {
              addCriterion("winner_shoo_id not like ", value, "winner_shoo_id");
              return (Criteria) this;
         }

         public Criteria andWinnerShooIdIn(List<String> values)
         {
              addCriterion("winner_shoo_id in ", values, "winner_shoo_id");
              return (Criteria) this;
         }

         public Criteria andWinnerShooIdNotIn(List<String> values)
         {
              addCriterion("winner_shoo_id not in ", values, "winner_shoo_id");
              return (Criteria) this;
         }

         public Criteria andWinnerShooIdBetween(String value1, String value2)
         {
              addCriterion("winner_shoo_id between ", value1,value2, "winner_shoo_id");
              return (Criteria) this;
         }

         public Criteria andWinnerShooIdNotBetween(String value1, String value2)
         {
              addCriterion("winner_shoo_id not between ", value1,value2, "winner_shoo_id");
              return (Criteria) this;
         }

         public Criteria andWinnerShooNameIsNull()
         {
              addCriterion("winner_shoo_name is null");
              return (Criteria) this;
         }

         public Criteria andWinnerShooNameIsNotNull()
         {
              addCriterion("winner_shoo_name is not null");
              return (Criteria) this;
         }

         public Criteria andWinnerShooNameEqualTo(String value)
         {
              addCriterion("winner_shoo_name = ", value, "winner_shoo_name");
              return (Criteria) this;
         }

         public Criteria andWinnerShooNameNotEqualTo(String value)
         {
              addCriterion("winner_shoo_name <> ", value, "winner_shoo_name");
              return (Criteria) this;
         }

         public Criteria andWinnerShooNameGreaterThan(String value)
         {
              addCriterion("winner_shoo_name > ", value, "winner_shoo_name");
              return (Criteria) this;
         }

         public Criteria andWinnerShooNameGreaterThanOrEqualTo(String value)
         {
              addCriterion("winner_shoo_name >= ", value, "winner_shoo_name");
              return (Criteria) this;
         }

         public Criteria andWinnerShooNameLessThan(String value)
         {
              addCriterion("winner_shoo_name < ", value, "winner_shoo_name");
              return (Criteria) this;
         }

         public Criteria andWinnerShooNameLessThanOrEqualTo(String value)
         {
              addCriterion("winner_shoo_name <= ", value, "winner_shoo_name");
              return (Criteria) this;
         }

         public Criteria andWinnerShooNameLike(String value)
         {
              addCriterion("winner_shoo_name like ", value, "winner_shoo_name");
              return (Criteria) this;
         }

         public Criteria andWinnerShooNameNotLike(String value)
         {
              addCriterion("winner_shoo_name not like ", value, "winner_shoo_name");
              return (Criteria) this;
         }

         public Criteria andWinnerShooNameIn(List<String> values)
         {
              addCriterion("winner_shoo_name in ", values, "winner_shoo_name");
              return (Criteria) this;
         }

         public Criteria andWinnerShooNameNotIn(List<String> values)
         {
              addCriterion("winner_shoo_name not in ", values, "winner_shoo_name");
              return (Criteria) this;
         }

         public Criteria andWinnerShooNameBetween(String value1, String value2)
         {
              addCriterion("winner_shoo_name between ", value1,value2, "winner_shoo_name");
              return (Criteria) this;
         }

         public Criteria andWinnerShooNameNotBetween(String value1, String value2)
         {
              addCriterion("winner_shoo_name not between ", value1,value2, "winner_shoo_name");
              return (Criteria) this;
         }

         public Criteria andBidAmountIsNull()
         {
              addCriterion("bid_amount is null");
              return (Criteria) this;
         }

         public Criteria andBidAmountIsNotNull()
         {
              addCriterion("bid_amount is not null");
              return (Criteria) this;
         }

         public Criteria andBidAmountEqualTo(String value)
         {
              addCriterion("bid_amount = ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountNotEqualTo(String value)
         {
              addCriterion("bid_amount <> ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountGreaterThan(String value)
         {
              addCriterion("bid_amount > ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountGreaterThanOrEqualTo(String value)
         {
              addCriterion("bid_amount >= ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountLessThan(String value)
         {
              addCriterion("bid_amount < ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountLessThanOrEqualTo(String value)
         {
              addCriterion("bid_amount <= ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountLike(String value)
         {
              addCriterion("bid_amount like ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountNotLike(String value)
         {
              addCriterion("bid_amount not like ", value, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountIn(List<String> values)
         {
              addCriterion("bid_amount in ", values, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountNotIn(List<String> values)
         {
              addCriterion("bid_amount not in ", values, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountBetween(String value1, String value2)
         {
              addCriterion("bid_amount between ", value1,value2, "bid_amount");
              return (Criteria) this;
         }

         public Criteria andBidAmountNotBetween(String value1, String value2)
         {
              addCriterion("bid_amount not between ", value1,value2, "bid_amount");
              return (Criteria) this;
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

         public Criteria andBidStartTimeIsNull()
         {
              addCriterion("bid_start_time is null");
              return (Criteria) this;
         }

         public Criteria andBidStartTimeIsNotNull()
         {
              addCriterion("bid_start_time is not null");
              return (Criteria) this;
         }

         public Criteria andBidStartTimeEqualTo(Date value)
         {
              addCriterion("bid_start_time = ", value, "bid_start_time");
              return (Criteria) this;
         }

         public Criteria andBidStartTimeNotEqualTo(Date value)
         {
              addCriterion("bid_start_time <> ", value, "bid_start_time");
              return (Criteria) this;
         }

         public Criteria andBidStartTimeGreaterThan(Date value)
         {
              addCriterion("bid_start_time > ", value, "bid_start_time");
              return (Criteria) this;
         }

         public Criteria andBidStartTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("bid_start_time >= ", value, "bid_start_time");
              return (Criteria) this;
         }

         public Criteria andBidStartTimeLessThan(Date value)
         {
              addCriterion("bid_start_time < ", value, "bid_start_time");
              return (Criteria) this;
         }

         public Criteria andBidStartTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("bid_start_time <= ", value, "bid_start_time");
              return (Criteria) this;
         }

         public Criteria andBidStartTimeIn(List<Date> values)
         {
              addCriterion("bid_start_time in ", values, "bid_start_time");
              return (Criteria) this;
         }

         public Criteria andBidStartTimeNotIn(List<Date> values)
         {
              addCriterion("bid_start_time not in ", values, "bid_start_time");
              return (Criteria) this;
         }

         public Criteria andBidStartTimeBetween(Date value1, Date value2)
         {
              addCriterion("bid_start_time between ", value1,value2, "bid_start_time");
              return (Criteria) this;
         }

         public Criteria andBidStartTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("bid_start_time not between ", value1,value2, "bid_start_time");
              return (Criteria) this;
         }

         public Criteria andBidEndTimeIsNull()
         {
              addCriterion("bid_end_time is null");
              return (Criteria) this;
         }

         public Criteria andBidEndTimeIsNotNull()
         {
              addCriterion("bid_end_time is not null");
              return (Criteria) this;
         }

         public Criteria andBidEndTimeEqualTo(Date value)
         {
              addCriterion("bid_end_time = ", value, "bid_end_time");
              return (Criteria) this;
         }

         public Criteria andBidEndTimeNotEqualTo(Date value)
         {
              addCriterion("bid_end_time <> ", value, "bid_end_time");
              return (Criteria) this;
         }

         public Criteria andBidEndTimeGreaterThan(Date value)
         {
              addCriterion("bid_end_time > ", value, "bid_end_time");
              return (Criteria) this;
         }

         public Criteria andBidEndTimeGreaterThanOrEqualTo(Date value)
         {
              addCriterion("bid_end_time >= ", value, "bid_end_time");
              return (Criteria) this;
         }

         public Criteria andBidEndTimeLessThan(Date value)
         {
              addCriterion("bid_end_time < ", value, "bid_end_time");
              return (Criteria) this;
         }

         public Criteria andBidEndTimeLessThanOrEqualTo(Date value)
         {
              addCriterion("bid_end_time <= ", value, "bid_end_time");
              return (Criteria) this;
         }

         public Criteria andBidEndTimeIn(List<Date> values)
         {
              addCriterion("bid_end_time in ", values, "bid_end_time");
              return (Criteria) this;
         }

         public Criteria andBidEndTimeNotIn(List<Date> values)
         {
              addCriterion("bid_end_time not in ", values, "bid_end_time");
              return (Criteria) this;
         }

         public Criteria andBidEndTimeBetween(Date value1, Date value2)
         {
              addCriterion("bid_end_time between ", value1,value2, "bid_end_time");
              return (Criteria) this;
         }

         public Criteria andBidEndTimeNotBetween(Date value1, Date value2)
         {
              addCriterion("bid_end_time not between ", value1,value2, "bid_end_time");
              return (Criteria) this;
         }

         public Criteria andEffectStartDateIsNull()
         {
              addCriterion("effect_start_date is null");
              return (Criteria) this;
         }

         public Criteria andEffectStartDateIsNotNull()
         {
              addCriterion("effect_start_date is not null");
              return (Criteria) this;
         }

         public Criteria andEffectStartDateEqualTo(Date value)
         {
              addCriterion("effect_start_date = ", value, "effect_start_date");
              return (Criteria) this;
         }

         public Criteria andEffectStartDateNotEqualTo(Date value)
         {
              addCriterion("effect_start_date <> ", value, "effect_start_date");
              return (Criteria) this;
         }

         public Criteria andEffectStartDateGreaterThan(Date value)
         {
              addCriterion("effect_start_date > ", value, "effect_start_date");
              return (Criteria) this;
         }

         public Criteria andEffectStartDateGreaterThanOrEqualTo(Date value)
         {
              addCriterion("effect_start_date >= ", value, "effect_start_date");
              return (Criteria) this;
         }

         public Criteria andEffectStartDateLessThan(Date value)
         {
              addCriterion("effect_start_date < ", value, "effect_start_date");
              return (Criteria) this;
         }

         public Criteria andEffectStartDateLessThanOrEqualTo(Date value)
         {
              addCriterion("effect_start_date <= ", value, "effect_start_date");
              return (Criteria) this;
         }

         public Criteria andEffectStartDateIn(List<Date> values)
         {
              addCriterion("effect_start_date in ", values, "effect_start_date");
              return (Criteria) this;
         }

         public Criteria andEffectStartDateNotIn(List<Date> values)
         {
              addCriterion("effect_start_date not in ", values, "effect_start_date");
              return (Criteria) this;
         }

         public Criteria andEffectStartDateBetween(Date value1, Date value2)
         {
              addCriterion("effect_start_date between ", value1,value2, "effect_start_date");
              return (Criteria) this;
         }

         public Criteria andEffectStartDateNotBetween(Date value1, Date value2)
         {
              addCriterion("effect_start_date not between ", value1,value2, "effect_start_date");
              return (Criteria) this;
         }

         public Criteria andEffectEndDateIsNull()
         {
              addCriterion("effect_end_date is null");
              return (Criteria) this;
         }

         public Criteria andEffectEndDateIsNotNull()
         {
              addCriterion("effect_end_date is not null");
              return (Criteria) this;
         }

         public Criteria andEffectEndDateEqualTo(Date value)
         {
              addCriterion("effect_end_date = ", value, "effect_end_date");
              return (Criteria) this;
         }

         public Criteria andEffectEndDateNotEqualTo(Date value)
         {
              addCriterion("effect_end_date <> ", value, "effect_end_date");
              return (Criteria) this;
         }

         public Criteria andEffectEndDateGreaterThan(Date value)
         {
              addCriterion("effect_end_date > ", value, "effect_end_date");
              return (Criteria) this;
         }

         public Criteria andEffectEndDateGreaterThanOrEqualTo(Date value)
         {
              addCriterion("effect_end_date >= ", value, "effect_end_date");
              return (Criteria) this;
         }

         public Criteria andEffectEndDateLessThan(Date value)
         {
              addCriterion("effect_end_date < ", value, "effect_end_date");
              return (Criteria) this;
         }

         public Criteria andEffectEndDateLessThanOrEqualTo(Date value)
         {
              addCriterion("effect_end_date <= ", value, "effect_end_date");
              return (Criteria) this;
         }

         public Criteria andEffectEndDateIn(List<Date> values)
         {
              addCriterion("effect_end_date in ", values, "effect_end_date");
              return (Criteria) this;
         }

         public Criteria andEffectEndDateNotIn(List<Date> values)
         {
              addCriterion("effect_end_date not in ", values, "effect_end_date");
              return (Criteria) this;
         }

         public Criteria andEffectEndDateBetween(Date value1, Date value2)
         {
              addCriterion("effect_end_date between ", value1,value2, "effect_end_date");
              return (Criteria) this;
         }

         public Criteria andEffectEndDateNotBetween(Date value1, Date value2)
         {
              addCriterion("effect_end_date not between ", value1,value2, "effect_end_date");
              return (Criteria) this;
         }

         public Criteria andEffectStartTimeIsNull()
         {
              addCriterion("effect_start_time is null");
              return (Criteria) this;
         }

         public Criteria andEffectStartTimeIsNotNull()
         {
              addCriterion("effect_start_time is not null");
              return (Criteria) this;
         }

         public Criteria andEffectStartTimeEqualTo(String value)
         {
              addCriterion("effect_start_time = ", value, "effect_start_time");
              return (Criteria) this;
         }

         public Criteria andEffectStartTimeNotEqualTo(String value)
         {
              addCriterion("effect_start_time <> ", value, "effect_start_time");
              return (Criteria) this;
         }

         public Criteria andEffectStartTimeGreaterThan(String value)
         {
              addCriterion("effect_start_time > ", value, "effect_start_time");
              return (Criteria) this;
         }

         public Criteria andEffectStartTimeGreaterThanOrEqualTo(String value)
         {
              addCriterion("effect_start_time >= ", value, "effect_start_time");
              return (Criteria) this;
         }

         public Criteria andEffectStartTimeLessThan(String value)
         {
              addCriterion("effect_start_time < ", value, "effect_start_time");
              return (Criteria) this;
         }

         public Criteria andEffectStartTimeLessThanOrEqualTo(String value)
         {
              addCriterion("effect_start_time <= ", value, "effect_start_time");
              return (Criteria) this;
         }

         public Criteria andEffectStartTimeLike(String value)
         {
              addCriterion("effect_start_time like ", value, "effect_start_time");
              return (Criteria) this;
         }

         public Criteria andEffectStartTimeNotLike(String value)
         {
              addCriterion("effect_start_time not like ", value, "effect_start_time");
              return (Criteria) this;
         }

         public Criteria andEffectStartTimeIn(List<String> values)
         {
              addCriterion("effect_start_time in ", values, "effect_start_time");
              return (Criteria) this;
         }

         public Criteria andEffectStartTimeNotIn(List<String> values)
         {
              addCriterion("effect_start_time not in ", values, "effect_start_time");
              return (Criteria) this;
         }

         public Criteria andEffectStartTimeBetween(String value1, String value2)
         {
              addCriterion("effect_start_time between ", value1,value2, "effect_start_time");
              return (Criteria) this;
         }

         public Criteria andEffectStartTimeNotBetween(String value1, String value2)
         {
              addCriterion("effect_start_time not between ", value1,value2, "effect_start_time");
              return (Criteria) this;
         }

         public Criteria andEffectEndTimeIsNull()
         {
              addCriterion("effect_end_time is null");
              return (Criteria) this;
         }

         public Criteria andEffectEndTimeIsNotNull()
         {
              addCriterion("effect_end_time is not null");
              return (Criteria) this;
         }

         public Criteria andEffectEndTimeEqualTo(String value)
         {
              addCriterion("effect_end_time = ", value, "effect_end_time");
              return (Criteria) this;
         }

         public Criteria andEffectEndTimeNotEqualTo(String value)
         {
              addCriterion("effect_end_time <> ", value, "effect_end_time");
              return (Criteria) this;
         }

         public Criteria andEffectEndTimeGreaterThan(String value)
         {
              addCriterion("effect_end_time > ", value, "effect_end_time");
              return (Criteria) this;
         }

         public Criteria andEffectEndTimeGreaterThanOrEqualTo(String value)
         {
              addCriterion("effect_end_time >= ", value, "effect_end_time");
              return (Criteria) this;
         }

         public Criteria andEffectEndTimeLessThan(String value)
         {
              addCriterion("effect_end_time < ", value, "effect_end_time");
              return (Criteria) this;
         }

         public Criteria andEffectEndTimeLessThanOrEqualTo(String value)
         {
              addCriterion("effect_end_time <= ", value, "effect_end_time");
              return (Criteria) this;
         }

         public Criteria andEffectEndTimeLike(String value)
         {
              addCriterion("effect_end_time like ", value, "effect_end_time");
              return (Criteria) this;
         }

         public Criteria andEffectEndTimeNotLike(String value)
         {
              addCriterion("effect_end_time not like ", value, "effect_end_time");
              return (Criteria) this;
         }

         public Criteria andEffectEndTimeIn(List<String> values)
         {
              addCriterion("effect_end_time in ", values, "effect_end_time");
              return (Criteria) this;
         }

         public Criteria andEffectEndTimeNotIn(List<String> values)
         {
              addCriterion("effect_end_time not in ", values, "effect_end_time");
              return (Criteria) this;
         }

         public Criteria andEffectEndTimeBetween(String value1, String value2)
         {
              addCriterion("effect_end_time between ", value1,value2, "effect_end_time");
              return (Criteria) this;
         }

         public Criteria andEffectEndTimeNotBetween(String value1, String value2)
         {
              addCriterion("effect_end_time not between ", value1,value2, "effect_end_time");
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
