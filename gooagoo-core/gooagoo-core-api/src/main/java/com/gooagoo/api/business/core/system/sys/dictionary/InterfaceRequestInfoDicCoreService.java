package com.gooagoo.api.business.core.system.sys.dictionary;

import java.util.List;

import com.gooagoo.entity.generator.sys.InterfaceRequestInfo;

/**
 *  接口请求参数信息表管理
 */
public interface InterfaceRequestInfoDicCoreService

{

    /**
     * 新增接口请求参数信息
     * @param interfaceRequestInfo
     * @return
     * @throws Exception
     */
    public boolean addInterfaceRequestInfoDic(InterfaceRequestInfo interfaceRequestInfo) throws Exception;

    /**
     * 编辑接口请求参数信息
     * @param interfaceRequestInfo
     * @return
     * @throws Exception
     */
    public boolean updateInterfaceRequestInfoDic(InterfaceRequestInfo interfaceRequestInfo) throws Exception;

    /**
     * 删除接口请求参数信息
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delInterfaceRequestInfoDic(String id) throws Exception;

    /**
     * 批量新增接口请求参数信息（清空表数据，然后新增）
     * @param sysList
     * @return
     * @throws Exception
     */
    public boolean addAllInterfaceRequestInfoDic(List<InterfaceRequestInfo> sysList) throws Exception;

}
