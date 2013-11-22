package com.gooagoo.dao.business.marketing.integral;

import org.apache.ibatis.annotations.Param;

/**
 * 积分
*/
public interface IntegralBusinessMapper
{
    public Integer updateIntegralExchangeNum(@Param("shopIntegralId") String shopIntegralId);

}
