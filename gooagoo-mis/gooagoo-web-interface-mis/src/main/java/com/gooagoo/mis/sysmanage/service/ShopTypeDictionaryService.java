package com.gooagoo.mis.sysmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MShopType;

public interface ShopTypeDictionaryService
{

    /**
     * 添加商家类型字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> addShopTypeDic(HttpServletRequest request) throws Exception;

    /**
     * 修改商家类型字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> editShopTypeDic(HttpServletRequest request) throws Exception;

    /**
     * 删除商家类型字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> delShopTypeDic(HttpServletRequest request) throws Exception;

    /**
     * 查询商家类型字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<PageModel<MShopType>> findShopTypeDict(HttpServletRequest request) throws Exception;

    /**
     * 查询商家类型字典详细信息
     * @return
     * @throws GooagooException
     */
    public TransData<MShopType> findShopTypeDetail(HttpServletRequest request) throws Exception;

    /**
     * 批量新增商家类型字典
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addAllShopType(HttpServletRequest request) throws Exception;
    
}
