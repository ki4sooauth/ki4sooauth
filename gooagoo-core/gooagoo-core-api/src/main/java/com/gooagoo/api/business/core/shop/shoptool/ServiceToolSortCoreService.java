package com.gooagoo.api.business.core.shop.shoptool;

import java.util.List;

import com.gooagoo.entity.generator.shop.ServiceToolSort;

/**
 * 服务工具排序
 */
public interface ServiceToolSortCoreService
{

    /**
     * 批量新增服务工具排序信息(注:硬删该商家服务工具排序信息后批量新增)
     * @param shopToolList
     * @param ServiceToolSort
     * @return
     * @throws Exception
     */
    public boolean addServiceToolSortList(String shopId, List<ServiceToolSort> serviceToolSortList) throws Exception;

}
