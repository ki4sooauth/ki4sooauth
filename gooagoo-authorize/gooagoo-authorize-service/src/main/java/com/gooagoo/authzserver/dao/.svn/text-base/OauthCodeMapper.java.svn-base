package com.gooagoo.authzserver.dao;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.authzserver.entity.business.OauthCodeBusiness;

/**
 *授权code
 */
public interface OauthCodeMapper
{
    /**
     * 添加授权临时token
     */
    public void addOauthCode(@Param("oauthCodeBusiness") OauthCodeBusiness oauthCodeBusiness);

    /**
     * 获取授权临时token
     */
    public OauthCodeBusiness getOauthCodeBusiness(@Param("oauthCodeBusiness") OauthCodeBusiness oauthCodeBusiness);
}
