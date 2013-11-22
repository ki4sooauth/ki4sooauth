package com.gooagoo.trans.api;

import com.gooagoo.trans.entity.gtsc15.transform.OrderGoodsRoot;
import com.gooagoo.trans.entity.gtsc16.transform.HurryOrderRoot;
import com.gooagoo.trans.entity.gtsc17.transform.SlowOrderRoot;
import com.gooagoo.trans.entity.gtsc18.transform.WeightConfirmRoot;
import com.gooagoo.trans.entity.gtsc27.transform.HookupRoot;
import com.gooagoo.trans.entity.gtsc29.transform.FindCouponInfoRoot;

/**
 * 上菜操作相关接口
 */
public interface ServeDishOperateTransService
{
    /**
     * 接口gtsc15:商家查询用户起菜请求
     * @param mac 转发器mac地址
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public OrderGoodsRoot getOrderDishInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception;

    /**
     * 接口gtsc16:商家查询用户催菜请求
     * @param mac 转发器mac地址
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public HurryOrderRoot getHurryDishInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception;

    /**
     * 接口gtsc17:商家查询用户缓菜请求
     * @param mac 转发器mac地址
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public SlowOrderRoot getSlowDishInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception;

    /**
     * 接口gtsc18:商家查询重量确认信息
     * @param mac 转发器mac地址
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public WeightConfirmRoot getDishWeightConfirmInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception;

    /**
     * 接口gtsc26: 平台查询博立协议的沽清列表
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public boolean getEstimateListInfo(String shopEntityId, String itemSerialList) throws Exception;

    /**
     * 接口gtsc27:商家查询勾挑请求
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public HookupRoot getHookupInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception;

    /**
     * 接口gtsc29:转发器查询优惠凭证信息
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public FindCouponInfoRoot findCouponInfo(String shopEntityId, String cTimeStamp) throws Exception;

}
