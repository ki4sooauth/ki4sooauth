package com.gooagoo.api.business.core.transaction.order;

import java.util.List;

import com.gooagoo.entity.business.transaction.OrderResult;
import com.gooagoo.entity.generator.bill.BillPayApplication;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OriginalBillDetail;
import com.gooagoo.entity.generator.bill.OriginalBillInfo;
import com.gooagoo.entity.generator.bill.OriginalBillPic;
import com.gooagoo.exception.business.bill.AlreadyApplyBillException;

/***
 * 商家账单管理
 * @author Administrator
 *
 */
public interface ShopBillCoreService
{
    /***
     * 4.3.1. 结账申请
     * @param tableName 桌号
     * @param scardno 音频卡号
     * @param orderCouponInfo 优惠券列表
     * @param billPayApplication 结账申请信息
     * @return true/false
     * @throws AlreadyApplyBillException 已申请结账异常
     */
    public boolean applyBill(String tableName, String scardno, BillPayApplication billPayApplication, List<OrderCouponInfo> orderCouponInfoList) throws Exception;

    /***
     * 商家账单数据上传
     * gtsc05
     * @param originalBillDetail
     * @return true/false
     * @throws Exception
     */
    public OrderResult addShopBill(OriginalBillInfo originalBillInfo, List<OriginalBillDetail> originalBillDetailList, OriginalBillPic originalBillPic) throws Exception;

}
