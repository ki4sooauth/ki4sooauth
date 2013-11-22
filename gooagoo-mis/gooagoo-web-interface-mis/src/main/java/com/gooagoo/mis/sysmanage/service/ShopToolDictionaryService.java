package com.gooagoo.mis.sysmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MShopToolInfo;

public interface ShopToolDictionaryService
{
    /**
     * 添加商家服务工具字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> addShopToolDic(HttpServletRequest request) throws Exception;

    /**
     * 修改商家服务工具字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> editShopToolDic(HttpServletRequest request) throws Exception;

    /**
     * 删除商家服务工具字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> delShopToolDic(HttpServletRequest request) throws Exception;

    /**
     * 查询商家服务工具字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<PageModel<MShopToolInfo>> findShopToolDict(HttpServletRequest request) throws Exception;

    /**
     * 查询商家服务工具字典详细信息
     * @return
     * @throws GooagooException
     */
    public TransData<MShopToolInfo> findShopToolDetail(HttpServletRequest request) throws Exception;

    /**
     * 批量新增商家服务工具字典
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addAllShopTool(HttpServletRequest request) throws Exception;
    
}
