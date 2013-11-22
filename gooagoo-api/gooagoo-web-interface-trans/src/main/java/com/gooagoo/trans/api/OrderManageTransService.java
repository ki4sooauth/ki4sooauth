package com.gooagoo.trans.api;

import com.gooagoo.trans.entity.gtsc01.transform.BillPayRoot;
import com.gooagoo.trans.entity.gtsc02.transform.OrderRoot;
import com.gooagoo.trans.entity.gtsc03.transform.OpenInvoiceRoot;
import com.gooagoo.trans.entity.gtsc14.transform.FindBillAddOrSubRoot;

/**
 * 订单管理相关接口
 */
public interface OrderManageTransService
{
    /**
     * 接口gtsc01:商家查询用户结账申请信息
     * @param shopentityid 实体店编号
     * @param ctimestamp 最大时间戳
     * @return
     * @throws Exception
     */
    public BillPayRoot getBillPayApplyInfo(String shopentityid, String ctimestamp) throws Exception;

    /**
     * 接口gtsc02:商家查询用户订单
     * @param shopentityid 实体店编号
     * @param scardno 会员卡号
     * @param ctimestamp 最大时间戳
     * @return
     * @throws Exception
     */
    public OrderRoot getUserOrderInfo(String shopentityid, String scardno, String ctimestamp) throws Exception;

    /**
     * 接口gtsc03:商家查询用户开发票申请信息
     * @param shopentityid 实体店编号
     * @param ctimestamp 最大时间戳
     * @return
     * @throws Exception
     */
    public OpenInvoiceRoot getOpenInvoiceApplyInfo(String shopentityid, String ctimestamp) throws Exception;

    /**
     * 接口gtsc04:用户通过NFC拿账单
     * @param shopentityid 实体店编号
     * @param mac 转发器mac地址
     * @return
     * @throws Exception
     */
    public String getBill(String shopentityid, String mac) throws Exception;

    /**
     * 接口gtsc05:商家账单数据上传
     * @param mac 转发器mac地址
     * @param data 账单数据
     * @param shopId 商家编号
     * @param shopEnityId 实体店编号
     * @return
     * @throws Exception
     */
    public String uploadShopBill(String mac, String data, String shopId, String shopEnityId) throws Exception;

    /**
     * 接口gtsc12:商家订单数据上传
     * @param mac 转发器mac地址
     * @param data 订单数据
     * @param shopId 商家编号
     * @param shopEnityId 实体店编号
     * @return
     * @throws Exception
     */
    public boolean uploadShopOrder(String mac, String data, String shopId, String shopEnityId) throws Exception;

    /**
     * 接口gtsc14:商家查询用户加菜减菜申请信息
     * @param shopId 商家编号
     * @param shopentityid 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public FindBillAddOrSubRoot getBillAddOrSub(String shopId, String shopentityid, String cTimeStamp) throws Exception;

    /**
     * 接口GTSC30:转发器上传打印发票确认
     * @param shopEntityId
     * @param orderId
     * @throws Exception
     */
    public boolean confirmOpenInvoice(String shopEntityId, String orderId) throws Exception;
}
