package com.gooagoo.api.business.core.system.user.enterprise;

/**
 *  商家服务工具状态管理
 */
public interface ToolsManageCoreService

{

    /**
     * 编辑商家服务工具状态（审核、发布）
     * @param id
     * @param status
     * @return
     * @throws Exception
     */
    public boolean updateTools(String id, String status) throws Exception;

    /**
     * 删除商家服务工具
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delTools(String id) throws Exception;

}
