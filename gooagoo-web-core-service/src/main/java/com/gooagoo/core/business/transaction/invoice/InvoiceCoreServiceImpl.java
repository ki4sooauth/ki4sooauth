package com.gooagoo.core.business.transaction.invoice;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.transaction.invoice.InvoiceCoreService;
import com.gooagoo.api.generator.core.bill.BillInvoiceLogGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OrderInfoGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.bill.BillInvoiceLog;
import com.gooagoo.entity.generator.bill.BillInvoiceLogExample;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.exception.business.bill.InvoiceAlreadyExistsException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class InvoiceCoreServiceImpl implements InvoiceCoreService
{

    @Autowired
    private OrderInfoGeneratorCoreService orderInfoGeneratorCoreService;

    @Autowired
    private BillInvoiceLogGeneratorCoreService billInvoiceLogGeneratorCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean AddInvoice(BillInvoiceLog billInvoiceLog) throws Exception
    {
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        orderInfoExample.createCriteria().andOrderIdEqualTo(billInvoiceLog.getOrderId()).andBillTypeEqualTo("3").andIsDelEqualTo("N");
        List<OrderInfo> orderInfoList = this.orderInfoGeneratorCoreService.selectByExample(orderInfoExample);
        if (CollectionUtils.isEmpty(orderInfoList))
        {
            GooagooLog.debug("orderid=" + billInvoiceLog.getOrderId() + "对应的订单信息为空");
            return false;
        }
        OrderInfo orderInfo = orderInfoList.get(0);
        //提交开发票申请，不能重复提交
        if (orderInfo.getInvoiceApplicationTime() != null)
        {
            GooagooLog.warn("orderId=" + orderInfo.getOrderId() + "订单已开发票");
            throw new InvoiceAlreadyExistsException("orderId=" + orderInfo.getOrderId() + "订单已开发票");
        }
        //新增发票申请信息
        billInvoiceLog.setOrderId(orderInfo.getOrderId());
        billInvoiceLog.setShopId(orderInfo.getShopId());
        billInvoiceLog.setShopEntityId(orderInfo.getShopEntityId());
        billInvoiceLog.setInvoicedPrice(orderInfo.getPayPrice() != null ? orderInfo.getPayPrice() : 0.00);//发票金额
        billInvoiceLog.setInvoicedRequestTime(new Date());
        billInvoiceLog.setIsDel("N");
        this.billInvoiceLogGeneratorCoreService.insertSelective(billInvoiceLog);
        //更新订单申请开发票时间
        orderInfo.setInvoiceApplicationTime(new Date());
        return this.orderInfoGeneratorCoreService.updateByPrimaryKeySelective(orderInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean confirmOpenInvoice(String shopEntityId, String orderId) throws Exception
    {
        //1.修改开发票申请表中的开发票时间
        Date date = new Date();
        BillInvoiceLog billInvoiceLog = new BillInvoiceLog();
        billInvoiceLog.setInvoicedTime(date);
        BillInvoiceLogExample billInvoiceLogExample = new BillInvoiceLogExample();
        billInvoiceLogExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andOrderIdEqualTo(orderId);
        if (!this.billInvoiceLogGeneratorCoreService.updateByExampleSelective(billInvoiceLog, billInvoiceLogExample))
        {
            throw new OperateFailException("修改开发票申请表中开发票信息失败");
        }
        //2.修改订单表的开发票状态及开发票时间
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setIsInvoice("Y");//开发票状态
        orderInfo.setInvoiceTime(date);
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        orderInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andOrderIdEqualTo(orderId);
        if (!this.orderInfoGeneratorCoreService.updateByExampleSelective(orderInfo, orderInfoExample))
        {
            throw new OperateFailException("修改订单信息表中开发票时间及状态标识失败");
        }
        return true;
    }
}
