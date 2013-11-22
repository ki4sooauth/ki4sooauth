package com.gooagoo.api.business.core.shop.shoptool;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopToolList;

public interface ShopToolCoreService
{

    /**
     * 服务工具权限分配
     * @param authority 权限设置，对应会员卡类别，以逗号分隔，如为空，则表示所有会员都可使用
     * @return
     * @throws Exception
     */
    public boolean updateShopToolAuthority(String id, String authority) throws Exception;

    /**
     * 添加系统服务工具 
     * @param toolId 服务工具编号
     * @param shopToolListId 商家申请的服务工具编号
     * @return
     * @throws Exception
     */
    public boolean addSysTool(String shopId, String toolId, String shopToolListId) throws Exception;

    /**
     * 删除商家服务工具
     * @param id 服务工具主键
     * @return
     * @throws Exception
     */
    public boolean deleteShopTool(String id) throws Exception;

    /**
     * 添加自定义服务工具
     * @param ShopToolList 
     * @return
     * @throws Exception
     */
    public boolean addCustomTool(ShopToolList shopToolList) throws Exception;

    /**
     * 编辑自定义服务工具
     * @param ShopToolList 
     * @return
     * @throws Exception
     */
    public boolean updateCustomTool(ShopToolList shopToolList) throws Exception;

    /**
     * 修改服务工具排序
     * @param shopToolList
     * @return
     * @throws Exception
     */
    public boolean updateToolSort(List<ShopToolList> shopToolList) throws Exception;

}
