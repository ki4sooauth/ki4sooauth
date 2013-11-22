package com.gooagoo.mis.sysmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MShoppingListGoodsType;

public interface ShoppingDictionaryService
{

    /**
     * 添加购物清单商品类型字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> addShoppingDic(HttpServletRequest request) throws Exception;

    /**
     * 修改购物清单商品类型字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> editShoppingDic(HttpServletRequest request) throws Exception;

    /**
     * 删除购物清单商品类型字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> delShoppingDic(HttpServletRequest request) throws Exception;

    /**
     * 查询购物清单商品类型字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<PageModel<MShoppingListGoodsType>> findShoppingListDict(HttpServletRequest request) throws Exception;

    /**
     * 查询购物清单商品类型字典详细信息
     * @return
     * @throws GooagooException
     */
    public TransData<MShoppingListGoodsType> findShoppingListDetail(HttpServletRequest request) throws Exception;

    /**
     * 批量新增购物清单商品类型字典
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addAllShoppingList(HttpServletRequest request) throws Exception;
    
}
