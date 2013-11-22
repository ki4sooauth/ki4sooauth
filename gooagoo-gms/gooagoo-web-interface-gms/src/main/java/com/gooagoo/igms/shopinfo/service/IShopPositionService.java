package com.gooagoo.igms.shopinfo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.ZTreeNode;
import com.gooagoo.view.gms.shopinfo.FShopPosition;

public interface IShopPositionService
{
    /**
     * 查询位详细信息
     * @param request
     */
    public TransData<FShopPosition> getShopPosition(HttpServletRequest request) throws Exception;

    /**
     * 获取位置信息
     * @param request
     */
    public TransData<List<ZTreeNode>> getShopPositionZtree(HttpServletRequest request) throws Exception;

    /**
     * 获取位置信息，不对外开放接口，
     *      与此共用
     *      com.gooagoo.igms.relation.service.impl.RelationServiceImpl.treeRelation(HttpServletRequest)
     * @param request
     */
    public List<ZTreeNode> getShopPositionZtree0(String shopId, String shopEntityId, String parentPositionId) throws Exception;

    /**
     * 修改位置标签详细信息
     * @param request
     */
    public TransData<Object> updateShopPosition(HttpServletRequest request) throws Exception;

    /**
     * 添加位置信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addShopPosition(HttpServletRequest request) throws Exception;

    /**
     * 删除位置
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> delShopPosition(HttpServletRequest request) throws Exception;
    /**
     * 批量导入位置信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> importPositions(HttpServletRequest request) throws Exception;

}
