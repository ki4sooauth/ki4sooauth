package com.gooagoo.api.business.core.shop.auth;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopRole;

public interface ShopRoleCoreService
{
    /**
     * 添加角色
     * @param shopRole
     * @return true/false
     * @throws Exception
     */
    public boolean addShopRole(ShopRole shopRole) throws Exception;

    /**
     * 修改角色
     * @param shopRole
     * @return true/false
     * @throws Exception
     */
    public boolean updateShopRole(ShopRole shopRole) throws Exception;

    /**
     * 删除角色
     * @param Id
     * @return true/false
     * @throws Exception
     */
    public boolean deleteShopRole(String Id) throws Exception;

    /**
     * 角色绑定权限
     * @param roleId
     * @param authIdList
     * @return true/false
     * @throws Exception
     */
    public boolean bindAuths(String roleId, List<String> authIdList) throws Exception;
}
