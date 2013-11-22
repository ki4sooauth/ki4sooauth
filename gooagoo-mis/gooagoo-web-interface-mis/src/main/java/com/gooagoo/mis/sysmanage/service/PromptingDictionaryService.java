package com.gooagoo.mis.sysmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MPromptingMessage;

public interface PromptingDictionaryService
{

    /**
     * 添加提示信息字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> addPromptingDic(HttpServletRequest request) throws Exception;

    /**
     * 修改提示信息字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> editPromptingDic(HttpServletRequest request) throws Exception;

    /**
     * 删除提示信息字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> delPromptingDic(HttpServletRequest request) throws Exception;

    /**
     * 查询提示信息字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<PageModel<MPromptingMessage>> findPromptingMessageDict(HttpServletRequest request) throws Exception;

    /**
     * 查询提示信息字典详细信息
     * @return
     * @throws GooagooException
     */
    public TransData<MPromptingMessage> findPromptingMessageDetail(HttpServletRequest request) throws Exception;

    /**
     * 批量新增提示信息字典
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addAllPromptingMessage(HttpServletRequest request) throws Exception;

}
