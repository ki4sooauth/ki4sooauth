package com.gooagoo.api.business.query.transaction.apply;

import java.util.List;

import com.gooagoo.entity.business.transaction.BillPayApplicationBusiness;
import com.gooagoo.entity.business.transaction.OrderBusiness;

public interface ApplyQueryService
{

    /**
     * 查询结账申请
     * gtsc01
     * @param shopId
     * @param cTimeStamp
     * @return List<OrderInfo>
     * @throws Exception
     */
    public List<BillPayApplicationBusiness> findApplyBill(String shopEntityId, String cTimeStamp) throws Exception;

    /**
     * 商家查询用户加菜减菜申请
     * gtsc14、gtsc24
     * @param shopEntityId 实体店编号
     * @param ctimestamp 最大时间戳
     * @param typeDeal 加减菜类型，0-加菜，1-减菜
     * @return
     * @throws Exception
     */
    public List<OrderBusiness> findAddApplyInfo(String shopEntityId, String ctimestamp, String typeDeal) throws Exception;

    /**
     * 商家查询用户提交的开发票申请信息
     * gtsc03
     * @param mac
     * @param shopid
     * @param ctimestamp
     * @return List<BillInvoiceLog>
     * @throws Exception
     */
    public List<OrderBusiness> findApplyInvoiceList(String shopEntityId, String ctimestamp) throws Exception;

}
