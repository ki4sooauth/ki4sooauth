package com.gooagoo.authzserver.dao;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.authzserver.entity.business.OpenUserTokenRelBusiness;

/**
 * 用户和授权关系
 */
public interface OpenUserTokenRelMapper
{

    /**
     * 添加token
     * @param openUserTokenRelBusiness
     */
    public void addOpenUserTokenRel(@Param("openUserTokenRelBusiness") OpenUserTokenRelBusiness openUserTokenRelBusiness);

    /**
     * 判断token是否过期
     * @param openUserTokenRelBusiness
     * @return
     */
    public OpenUserTokenRelBusiness getOpenUserTokenRel(@Param("openUserTokenRelBusiness") OpenUserTokenRelBusiness openUserTokenRelBusiness);
}
