package com.gooagoo.igms.message.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.message.FShortMessage;

public interface IShortMessage
{
    /**
     * 短信列表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FShortMessage>> messageList(HttpServletRequest request) throws Exception;

    /**
     * 创建短信信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> add(HttpServletRequest request) throws Exception;

    /**
     * 修改短信信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> update(HttpServletRequest request) throws Exception;

    /**
     * 获取短信详细内容
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<FShortMessage> getMessage(HttpServletRequest request) throws Exception;

    /**
     * 删除短信信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> delete(HttpServletRequest request) throws Exception;

    /**
     * 审核短信
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> check(HttpServletRequest request) throws Exception;

    /**
     * 发布短信
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> release(HttpServletRequest request) throws Exception;

}
