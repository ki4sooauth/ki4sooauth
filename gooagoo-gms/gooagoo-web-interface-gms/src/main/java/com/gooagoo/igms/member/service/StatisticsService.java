package com.gooagoo.igms.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.crm.CrowdInfoVo;
import com.gooagoo.view.gms.crm.FCRMMemberBaseInfo;
import com.gooagoo.view.gms.crm.FhighChartVo;
import com.gooagoo.view.gms.crm.QueryConditionVo;
import com.gooagoo.view.gms.crm.StatisticsTypeVo;

public interface StatisticsService {

	/**
	 * 获取用户自定义分类统计图表信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public TransData<FhighChartVo> getCustomStatisticsFigureData(HttpServletRequest request) throws Exception;

	/**
	 * 获取统计类型列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public TransData<List<StatisticsTypeVo>> getStatisticsType(HttpServletRequest request) throws Exception;

	/**
	 * 获取用户常用细分统计图数据
	 * 
	 * @param request
	 */
	public abstract TransData<FhighChartVo> getCommonlyUsedStatisticalData(HttpServletRequest request) throws Exception;

	/**
	 * 保存用户人群细分
	 * 
	 * @param request
	 */
	public abstract TransData<Object> saveCrowd(HttpServletRequest request) throws Exception;

	/**
	 * 获取己保存用户细分列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public abstract TransData<List<CrowdInfoVo>> getCrowdList(HttpServletRequest request) throws Exception;

	/**
	 * 保存用户自定义查询查询条件
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public abstract TransData<Object> saveCustomStatisticCondition(HttpServletRequest request) throws Exception;

	/**
	 * 查询用户自定义查询查询条件
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public abstract TransData<List<QueryConditionVo>> findCustomStatisticCondition(HttpServletRequest request) throws Exception;

	/**
	 * cpm获取用户详细信息列表（点击图）
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public abstract TransData<PageModel<FCRMMemberBaseInfo>> findUserDetailList(HttpServletRequest request) throws Exception;

	/**
	 * 获取己保存查询条件统计图
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public abstract TransData<FhighChartVo> getHasSavedQueryConditionChart(HttpServletRequest request) throws Exception;


}
