package com.gooagoo.igms.marketing.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FJingpin;
import com.gooagoo.view.gms.marketing.FJingpinType;

public interface JingpinService
{
    /**
     * 创建精品推荐
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> add(HttpServletRequest request) throws Exception;

    /**
     * 修改精品推荐
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> update(HttpServletRequest request) throws Exception;

    /**
     * 删除精品推荐
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> delete(HttpServletRequest request) throws Exception;

    /**
     * 获取精品推荐信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<FJingpin> getJingpin(HttpServletRequest request) throws Exception;

    /**
     * 获得精品类型列表
     * 
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<List<FJingpinType>> getJingpinTypes(HttpServletRequest request) throws Exception;

    /**
     * 分页查询精品推荐信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FJingpin>> pageJingpin(HttpServletRequest request) throws Exception;
}
