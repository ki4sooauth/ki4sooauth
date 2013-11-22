package com.gooagoo.api.business.core.shop.user;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopUserInfo;

public interface ShopUserCoreService
{
    /**
     * 添加店员
     * @param shopUserInfo
     * @return true/false
     * @throws Exception
     */
    public boolean addShopUserInfo(ShopUserInfo shopUserInfo) throws Exception;

    /**
     * 修改店员
     * @param shopUserInfo
     * @return true/false
     * @throws Exception
     */
    public boolean updateShopUserInfo(ShopUserInfo shopUserInfo) throws Exception;

    /**
     * 删除店员
     * @param Id
     * @return true/false
     * @throws Exception
     */
    public boolean deleteShopUserInfo(String Id) throws Exception;

    /**
     * 店员绑定角色
     * @param userId
     * @param roleIdList
     * @return true/false
     * @throws Exception
     */
    public boolean bindRoles(String userId, List<String> roleIdList) throws Exception;

}
