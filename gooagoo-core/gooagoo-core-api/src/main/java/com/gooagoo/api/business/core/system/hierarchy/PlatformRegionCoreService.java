package com.gooagoo.api.business.core.system.hierarchy;

import com.gooagoo.entity.generator.sys.PlatformRegion;

/**
 *  系统层级管理:区域性小平台
 */
public interface PlatformRegionCoreService
{

    /**
     * 新增区域性小平台
     * @param platformRegion
     * @return
     * @throws Exception
     */
    public boolean addPlatformRegion(PlatformRegion platformRegion) throws Exception;

    /**
     * 更新区域性小平台
     * @param platformRegion
     * @return
     * @throws Exception
     */
    public boolean updatePlatformRegion(PlatformRegion platformRegion) throws Exception;

    /**
     * 批量软删除区域性小平台(包含关联商圈信息)
     * @param platformIds 小平台编号(多个用逗号分隔)
     * @return True/False
     * @throws Exception
     */
    public boolean batchDeletePlatformRegion(String platformIds) throws Exception;

}
