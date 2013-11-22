package com.gooagoo.mis.rsrcmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.recommendManage.MNominateActivityBusiness;

public interface NominateActivityService
{
    /**
     * 查询所有活动列表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MNominateActivityBusiness>> queryActivityList(HttpServletRequest request) throws Exception;

    /**
     * 推荐活动操作页面
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addNominateActivityPage(HttpServletRequest request) throws Exception;
    
    /**
     * 推荐活动操作
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addNominateActivity(HttpServletRequest request) throws Exception;

    /**
     * 查询推荐活动列表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MNominateActivityBusiness>> queryNominateActivity(HttpServletRequest request) throws Exception;

    /**
     * 取消推荐活动操作
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateNominateActivity(HttpServletRequest request) throws Exception;

    /**
     * 修改推荐活动页面
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateNominateActivityTPage(HttpServletRequest request) throws Exception;
    
    /**
     * 修改推荐活动操作
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateNominateActivityT(HttpServletRequest request) throws Exception;
    
    /**
     * 验证活动是否已推荐
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> checkNominateActivityT(HttpServletRequest request) throws Exception;
    
}
