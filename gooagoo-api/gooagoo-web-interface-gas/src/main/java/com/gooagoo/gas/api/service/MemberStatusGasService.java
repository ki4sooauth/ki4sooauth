package com.gooagoo.gas.api.service;

import com.gooagoo.gas.entity.gase01.transform.UserListRoot;
import com.gooagoo.gas.entity.gase03.transform.UserBillRoot;
import com.gooagoo.gas.entity.gase04.transform.UserBillDetailRoot;
import com.gooagoo.gas.entity.gase06.transform.FavoriteListRoot;

/**
 * 会员状态接口
 */
public interface MemberStatusGasService
{
    /**
     * 接口gase01:店员查询店内区域会员列表
     * @param shopId 商家编号
     * @param positionId 位置编号
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public UserListRoot queryShopInsideMemberInfo(String shopId, String positionId, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口gase03:店员查询用户在本实体店的消费记录
     * @param shopEntityId 实体店编号
     * @param userId 用户编号
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public UserBillRoot queryConsumeTracks(String shopEntityId, String userId, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口gase04:店员查询根据账单编号查账单明细详情
     * @param orderid 订单编号
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public UserBillDetailRoot queryConsumeTrackDetails(String orderid, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口gase06:店员查询会员的收藏信息
     * @param userId 用户编号
     * @param shopId 商家编号
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public FavoriteListRoot queryUserFavoriates(String userId, String shopId, String pageIndex, String pageSize) throws Exception;

}
