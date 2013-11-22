package com.gooagoo.igms.tools.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.tools.FShopTool;

public interface IToolsService
{
    /**
     * 添加商家服务工具
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<String> add(HttpServletRequest request) throws Exception;

    /**
     * 删除商家服务工具
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> delete(HttpServletRequest request) throws Exception;

    /**
     * 获得商家和服务工具的关系信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<FShopTool> getShopTool(HttpServletRequest request) throws Exception;

    /**
     * 修改服务工具权限
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateAuth(HttpServletRequest request) throws Exception;

    /**
     * 获取商家添加的服务工具列
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<List<FShopTool>> getShopTools(HttpServletRequest request) throws Exception;

    /**
     * 获取商家添加的服务工具列和商家未添加的服务工具列
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Map<String, Object>> getTools(HttpServletRequest request) throws Exception;

    /**
     * 修改服务工具排序
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateToolsSort(HttpServletRequest request) throws Exception;

    /**
     * 商家自定义服务工具：添加工具
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addShopTool(HttpServletRequest request) throws Exception;

    /**
     * 商家自定义服务工具：删除工具
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> delShopTool(HttpServletRequest request) throws Exception;

    /**
     * 商家自定义服务工具：修改工具
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateShopTool(HttpServletRequest request) throws Exception;

    /**
     * 商家自定义服务工具：获取工具
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> getShopToolsOfShop(HttpServletRequest request) throws Exception;

    /**
     * 查询排序的服务工具信息
     * @param  request
     
     * @return
     * @throws Exception
     */
    public TransData<Map<String, Object>> getSortServiceTool(HttpServletRequest request) throws Exception;
}
