package com.gooagoo.igms.notice.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.notice.FNotice;

public interface NoticeService
{
    /**
     * 通知列表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FNotice>> pageNotice(HttpServletRequest request) throws Exception;

    /**
     * 创建通知信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> add(HttpServletRequest request) throws Exception;

    /**
     * 修改通知信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> update(HttpServletRequest request) throws Exception;

    /**
     * 通知详细信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<FNotice> getNoticeInfo(HttpServletRequest request) throws Exception;;

    /**
     * 删除通知信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> delete(HttpServletRequest request) throws Exception;

    /**
     * 审核通知
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> check(HttpServletRequest request) throws Exception;

    /**
     * 发布通知
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> release(HttpServletRequest request) throws Exception;

}
