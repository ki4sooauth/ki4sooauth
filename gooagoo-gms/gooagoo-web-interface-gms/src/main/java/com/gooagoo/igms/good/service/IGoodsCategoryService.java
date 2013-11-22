package com.gooagoo.igms.good.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FGoodsCategory;

public interface IGoodsCategoryService
{
    /**
     * 添加品类信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<String> addCategory(HttpServletRequest request) throws Exception;

    /**
     * 删除品类信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> delCategory(HttpServletRequest request) throws Exception;

    /**
     * 修改品类信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateCategory(HttpServletRequest request) throws Exception;

    /**
     * 查询品类详细信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<FGoodsCategory> getCategory(HttpServletRequest request) throws Exception;

    /**
     * 查询品类列表 
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<List<FGoodsCategory>> getCategoryList(HttpServletRequest request) throws Exception;

    /**
     * 分页查询品类 
     * @param request
     * @return
     * @throws Exception
     */

    public TransData<PageModel<FGoodsCategory>> getCategoryPage(HttpServletRequest request) throws Exception;

}
