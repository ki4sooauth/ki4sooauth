package com.gooagoo.igms.active.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FActivity;

public interface ActivityService
{
    /**
     * 创建活动
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> add(HttpServletRequest request) throws Exception;

    /**
     * 修改活动
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> update(HttpServletRequest request) throws Exception;

    /**
     * 删除活动
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> delete(HttpServletRequest request) throws Exception;

    /**
     * 审核活动信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> check(HttpServletRequest request) throws Exception;

    /**
     * 发布活动信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> publish(HttpServletRequest request) throws Exception;

    /**
     * 获取活动信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<FActivity> getActivity(HttpServletRequest request) throws Exception;

    /**
     * 分页查询活动信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FActivity>> pageActivity(HttpServletRequest request) throws Exception;

    /**
     * 分页查询活动信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<List<FActivity>> getActivityList(HttpServletRequest request) throws Exception;
}
