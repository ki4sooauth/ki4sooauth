package com.gooagoo.igms.shopinfo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface MenuDataService {
	
	/**
	 * 获取左则菜单统计数据
	 * @param request
	 * @return  0-总消费人数,1-总会员人数,2-总非会员消费次数,3-总会员消费次数,4-总潜在会员人数
	 * @throws Exception 
	 */
	public abstract TransData<List<Long>> getLeftMenuData(HttpServletRequest request) throws Exception;
	
	/**
	 * 获取右则菜单统计数据
	 * @param request
	 * @return  0-店内用户,1-店内会员,2-手机潜在会员,3-web潜在会员,4-新增会员信息,5-店内潜在会员数,6-店内潜在会员数,7-web互动会员,8-手机互动会员
	 * @throws Exception 
	 */
	public abstract TransData<List<Long>> getRightMenuData(HttpServletRequest request) throws Exception;
	
}
