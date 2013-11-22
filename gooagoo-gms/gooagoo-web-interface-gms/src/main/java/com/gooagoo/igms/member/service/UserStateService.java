package com.gooagoo.igms.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.crm.FCRMMemberBaseInfo;
import com.gooagoo.view.gms.crm.FhighChartVo;

public interface UserStateService
{

    /**
     * 查询用户状态用户详细信息
     * @param request
     * @return
     */
    public TransData<PageModel<FCRMMemberBaseInfo>> getUserStatusDetailList(HttpServletRequest request) throws Exception;
    
    /**
     * 保存用户状态人群信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> saveCrowdForUserState(HttpServletRequest request) throws Exception;
    
    
    
    /**
     * 查询用户状态当前时刻图表数据（cpm用户状态）
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Integer> getCurrentDataForChart(HttpServletRequest request) throws Exception;
    
    
    
    public TransData<List<FhighChartVo>> getCurrentHourAndDayDataForChart(HttpServletRequest request) throws Exception;
    
    
    
    /**
     * 获取cmp用状态指定时间最后一个动点数据
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<List<List<Integer>>> getDynamicPointData(HttpServletRequest request) throws Exception;
    
    

}
