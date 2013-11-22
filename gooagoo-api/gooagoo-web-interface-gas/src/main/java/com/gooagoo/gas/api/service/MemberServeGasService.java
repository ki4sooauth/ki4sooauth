package com.gooagoo.gas.api.service;

import com.gooagoo.gas.entity.gasc01.transform.QueryGoodsInfoRoot;
import com.gooagoo.gas.entity.gasc03.transform.UserBaseInfoRoot;

/**
 * 会员服务接口
 */
public interface MemberServeGasService
{
    /**
     * 接口gasc01:店员根据自定义序列号查询商品信息
     * @param shopEntityid 实体店编号
     * @param itemserial 商品自定义序列号
     * @return
     * @throws Exception
     */
    public QueryGoodsInfoRoot queryGoodsInfo(String shopEntityid, String itemserial) throws Exception;

    /**
     * 接口gasc03:通过会员卡音频卡号查询会员信息
     * @param scardno 会员卡号
     * @param shopId 商家编号
     * @return
     * @throws Exception
     */
    public UserBaseInfoRoot queryMemberBaseInfo(String scardno) throws Exception;

    /**
     * 接口gasc05:店员帮助用户提交用户订单（零售业）
     * @param userId 用户编号
     * @param shopId 商家编号
     * @param shopEntityId 实体店编号
     * @param goodsInfo 商品信息
     * @param takemethod 提货方式
     * @return
     * @throws Exception
     */
    public String submitRetailOrder(String userId, String shopId, String shopEntityId, String goodsInfo, String takemethod) throws Exception;

    /**
     * 接口gasc06:用户通过店员助理刷卡
     * @param scardno 会员卡号
     * @param shopid 商家编号
     * @return
     * @throws Exception
     */
    public boolean swipeCardRoot(String scardno, String shopid) throws Exception;
}
