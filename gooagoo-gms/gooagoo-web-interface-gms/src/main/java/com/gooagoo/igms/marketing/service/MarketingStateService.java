package com.gooagoo.igms.marketing.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.member.UserStatusView;

/**
 * 
 * 营销状态统计
 *
 */
public interface MarketingStateService
{
    /**
     * 查询营销状态的用户详细信息列
     * @param request
     * @return
     */
    public TransData<PageModel<UserStatusView>> findUserList(HttpServletRequest request) throws Exception;

    /**
     * 查询用户状态用户详细信息
     * @param request
     * @return
     */
    public TransData<String> findCurrentStatus(HttpServletRequest request) throws Exception;

    /**
     * 保存人群数据
     * @param request
     * @return
     * @throws Exception 
     */
    public TransData<Object> saveCowds(HttpServletRequest request) throws Exception;
    
    /**
     * 获取营销状态指定时间最后一个动点数据
     * @param request
     * @return
     * @throws Exception 
     */
    public TransData<List<List<Integer>>> getDynamicPointData(HttpServletRequest request) throws Exception;
}
