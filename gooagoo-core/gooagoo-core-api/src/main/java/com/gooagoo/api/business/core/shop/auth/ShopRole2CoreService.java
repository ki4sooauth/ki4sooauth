package com.gooagoo.api.business.core.shop.auth;

import com.gooagoo.entity.generator.shop.ShopRole2;
import com.gooagoo.entity.generator.shop.ShopUserRole2;

public interface ShopRole2CoreService
{

    /**
     * 添加商家角色
     * @param shopRole2
     * @return true/false
     * @throws Exception
     */
    public boolean addShopRole2(ShopRole2 shopRole2) throws Exception;

    /**
     * 修改商家角色
     * @param shopRole2
     * @return true/false
     * @throws Exception
     */
    public boolean updateShopRole2(ShopRole2 shopRole2) throws Exception;

    /**
     * 删除商家角色
     * @param roleIds 角色编号(多个用逗号分隔)
     * @return true/false
     * @throws Exception
     */
    public boolean deleteShopRole2(String roleIds) throws Exception;

    /**
     * 分配商家角色
     * @param shopUserRole2 用户-角色关联2实体类对象
     * @return true/false
     * @throws Exception
     */
    public boolean allotShopRole(ShopUserRole2 shopUserRole2) throws Exception;

    /**
     * 分配商家角色权限
     * @param roleId 角色编号
     * @param authorityIdArr 权限编号数组
     * @return true/false
     * @throws Exception
     */
    public boolean allotShopRoleAuth(String roleId, String[] authorityIdArr) throws Exception;

}
