package com.gooagoo.api.business.core.system.sys.dictionary;

import java.util.List;

import com.gooagoo.entity.generator.base.SysDictionary;

/**
 *  通用字典表管理
 */
public interface UniversalDicCoreService

{
    /**
     * 新增通用字典
     * @param sysDictionary
     * @return
     * @throws Exception
     */
    public boolean addUniversalDic(SysDictionary sysDictionary) throws Exception;

    /**
     * 编辑通用字典
     * @param sysDictionary
     * @return
     * @throws Exception
     */
    public boolean updateUniversalDic(SysDictionary sysDictionary) throws Exception;

    /**
     * 删除通用字典
     * @param sysDictionaryId
     * @return
     * @throws Exception
     */
    public boolean delUniversalDic(String sysDictionaryId) throws Exception;

    /**
     * 批量新增通用字典（清空表数据，然后新增）
     * @param sysList
     * @return
     * @throws Exception
     */
    public boolean addAllUniversalDic(List<SysDictionary> sysList) throws Exception;

}
