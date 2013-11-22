package com.gooagoo.api.business.core.system.sys.dictionary;

import java.util.List;

import com.gooagoo.entity.generator.sys.InterfaceBaseInfo;

/**
 *  接口基础信息表管理
 */
public interface InterfaceBaseInfoDicCoreService

{

    /**
     * 新增接口基础信息
     * @param interfaceBaseInfo
     * @return
     * @throws Exception
     */
    public boolean addInterfaceBaseInfoDic(InterfaceBaseInfo interfaceBaseInfo) throws Exception;

    /**
     * 编辑接口基础信息
     * @param interfaceBaseInfo
     * @return
     * @throws Exception
     */
    public boolean updateInterfaceBaseInfoDic(InterfaceBaseInfo interfaceBaseInfo) throws Exception;

    /**
     * 删除接口基础信息
     * @param iCode
     * @return
     * @throws Exception
     */
    public boolean delInterfaceBaseInfoDic(String iCode) throws Exception;

    /**
     * 批量新增接口基础信息（清空表数据，然后新增）
     * @param sysList
     * @return
     * @throws Exception
     */
    public boolean addAllInterfaceBaseInfoDic(List<InterfaceBaseInfo> sysList) throws Exception;
}
