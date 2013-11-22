package com.gooagoo.api.business.core.system.sys.dictionary;

import java.util.List;

import com.gooagoo.entity.generator.base.PromptingMessage;

/**
 *  提示信息字典表管理
 */
public interface TipsDicCoreService

{

    /**
     * 新增提示信息
     * @param promptingMessage
     * @return
     * @throws Exception
     */
    public boolean addTipsDic(PromptingMessage promptingMessage) throws Exception;

    /**
     * 编辑提示信息
     * @param promptingMessage
     * @return
     * @throws Exception
     */
    public boolean updateTipsDic(PromptingMessage promptingMessage) throws Exception;

    /**
     * 删除提示信息
     * @param messageId
     * @return
     * @throws Exception
     */
    public boolean delTipsDic(String messageId) throws Exception;

    /**
     * 批量新增提示信息（清空表数据，然后新增）
     * @param sysList
     * @return
     * @throws Exception
     */
    public boolean addAllTipsDic(List<PromptingMessage> sysList) throws Exception;

}
