package com.gooagoo.mis.sysmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MQualitySquareGoodsType;

public interface QualityDictionaryService
{

    /**
     * 添加精品广场商品类型字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> addQualityDic(HttpServletRequest request) throws Exception;

    /**
     * 修改精品广场商品类型字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> editQualityDic(HttpServletRequest request) throws Exception;

    /**
     * 删除精品广场商品类型字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> delQualityDic(HttpServletRequest request) throws Exception;

    /**
     * 查询精品广场商品类型字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<PageModel<MQualitySquareGoodsType>> findQualitySquareDict(HttpServletRequest request) throws Exception;

    /**
     * 查询精品广场商品类型字典详细信息
     * @return
     * @throws GooagooException
     */
    public TransData<MQualitySquareGoodsType> findQualitySquareDetail(HttpServletRequest request) throws Exception;

    /**
     * 批量新增精品广场商品类型字典
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addAllQualitySquare(HttpServletRequest request) throws Exception;

}
