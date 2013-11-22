package com.gooagoo.igms.active.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FEvent;

public interface EventService
{
    /**
     * 获取事件详细
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<FEvent> getEvent(HttpServletRequest request) throws Exception;

    /**
     * 创建事件
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> add(HttpServletRequest request) throws Exception;

    /**
     * 修改事件
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> update(HttpServletRequest request) throws Exception;

    /**
     * 删除事件
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> delete(HttpServletRequest request) throws Exception;

    /**
     * 审核事件
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> check(HttpServletRequest request) throws Exception;

    /**
     * 发布事件
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> release(HttpServletRequest request) throws Exception;

    /**
     * 分页查询事件信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FEvent>> pageEvent(HttpServletRequest request) throws Exception;

    public TransData<FEvent> form(HttpServletRequest request) throws Exception;
}
