package com.gooagoo.igms.member.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.crm.FActionRecord;
import com.gooagoo.view.gms.crm.FConsumeRecord;
import com.gooagoo.view.gms.crm.FIntegralRecord;
import com.gooagoo.view.gms.crm.FPropertyRecord;
import com.gooagoo.view.gms.crm.UserRecordLeftMenuVo;

public interface IUserRecordService
{

    /**
     * 获取用户属性档案信息列
     * 
     * @param request
     * @return
     */
    public TransData<FPropertyRecord> getPropertyRecord(HttpServletRequest request) throws Exception;

    /**
     * 获取用户行为档案信息列
     * 
     * @param request
     * @return
     */
    public TransData<PageModel<FActionRecord>> getActionRecord(HttpServletRequest request) throws Exception;

    /**
     * 获取用户消费档案信息列
     * 
     * @param request
     * @return
     */
    public TransData<PageModel<FConsumeRecord>> getConsumeRecord(HttpServletRequest request) throws Exception;

    /**
     * 获取用户积分档案详细信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FIntegralRecord>> getIntegralRecord(HttpServletRequest request) throws Exception;

    
    /**
     * 跟据帐号和帐号类型获取用户档中用户详细页左侧菜单数据
     * @param request
     * @return
     * @throws Exception
     */
	public TransData<UserRecordLeftMenuVo> getUserInfoForUserRecordDetailPageLeftMenu(HttpServletRequest request) throws Exception;
    
    
    
    
}
