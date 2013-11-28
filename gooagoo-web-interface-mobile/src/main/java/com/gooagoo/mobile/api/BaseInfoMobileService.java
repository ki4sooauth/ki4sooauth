package com.gooagoo.mobile.api;

import com.gooagoo.mobile.entity.mobg01.transform.BaseInfoRoot;

/**
 * 基本信息接口
 * 如果接口接口入参同时存在userId,sessionId,则需要先校验是否登录
 */
public interface BaseInfoMobileService
{

    /**
     * 接口 mobg01 : 基本信息 
     * @param type 同步方式,1-根据syninfo获得同步信息，2-根据shopentityId获得同步信息
     * @param shopentityId 商家实体店编号
     * @param syninfo 店铺信息 ,格式：{"shopinfo":[{"shopid":"123", "cTimeStamp":"2012-01-01 01:01:01"}],"shoppinglistgoodstype":[{"cTimeStamp":"2012-01-01 01:01:01"}]}
     *                为空时查询所有数据 
     * @param containcode 同步范围,如多个，以逗号分隔，"a01,a02,a03",则只同步a01,a02,a03对应的信息
     * @return
     * @throws Exception
     */
    public BaseInfoRoot getShopBaseInfo(String type, String shopEntityId, String syninfo, String containcode) throws Exception;
}
