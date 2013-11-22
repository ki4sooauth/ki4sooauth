package com.gooagoo.igms.good.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.good.FGoodsBrand;

public interface IGoodsBrandService
{

    /**
     * 添加品牌
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<String> addGoodsBrand(HttpServletRequest request) throws Exception;

    /**
     * 删除品牌
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> delGoodsBrand(HttpServletRequest request) throws Exception;

    /**
     * 修改品牌
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateGoodsBrand(HttpServletRequest request) throws Exception;

    /**
     * 获取品牌
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<FGoodsBrand> getGoodsBrand(HttpServletRequest request) throws Exception;

    /**
     * 获取品牌列
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<List<FGoodsBrand>> getGoodsBrandList(HttpServletRequest request) throws Exception;
}
