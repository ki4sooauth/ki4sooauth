package com.gooagoo.core.business.transaction.order;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.transaction.order.BillManualCoreService;
import com.gooagoo.api.generator.core.bill.BillManualGeneratorCoreService;
import com.gooagoo.api.protecteds.core.user.UserProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataPatternUtils;
import com.gooagoo.common.utils.DataUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.bill.BillManual;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class BillManualCoreServiceImpl implements BillManualCoreService

{

    @Autowired
    private BillManualGeneratorCoreService billManualGeneratorCoreService;

    @Autowired
    private UserProtectedCoreService userProtectedCoreService;

    @Override
    public boolean addBillManual(BillManual billManual) throws Exception
    {
        //1、数据校验
        this.checkAddBillManualData(billManual);
        //2、补充数据
        billManual.setBillId(UUID.getUUID());
        billManual.setIsDel("N");
        //3、保存手工账单
        if (!this.billManualGeneratorCoreService.insertSelective(billManual))
        {
            GooagooLog.error("新增手工账单：保存手工账单（" + billManual.toString() + "）异常", null);
            throw new OperateFailException("保存手工账单（" + billManual.toString() + "）异常");
        }

        return true;
    }

    @Override
    public boolean updateBillManual(BillManual billManual) throws Exception
    {
        //1、数据校验
        this.checkUpdateBillManualData(billManual);
        //2、更新手工账单
        if (!this.billManualGeneratorCoreService.updateByPrimaryKeySelective(billManual))
        {
            GooagooLog.error("新增手工账单：更新手工账单（" + billManual.toString() + "）异常", null);
            throw new OperateFailException("更新手工账单（" + billManual.toString() + "）异常");
        }

        return true;
    }

    @Override
    public boolean deleteBillManual(String billId) throws Exception
    {
        //1、数据校验
        this.checkUpdateBillManualData(billId);
        //2、删除手工账单
        if (!this.billManualGeneratorCoreService.deleteByPrimaryKey(billId))
        {
            GooagooLog.error("删除购物清单商品：删除手工账单（" + billId + "）异常", null);
            throw new OperateFailException("删除手工账单（" + billId + "）异常");
        }

        return true;
    }

    /**
     * 校验新增手工账单数据
     * @param billManual
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws OperateFailException
     */
    private boolean checkAddBillManualData(BillManual billManual) throws NullException, FormatErrorException, OperateFailException
    {
        return this.checkBillManualData(billManual);
    }

    /**
     * 校验编辑手工账单数据
     * @param billManual
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws OperateFailException
     */
    private boolean checkUpdateBillManualData(BillManual billManual) throws NullException, FormatErrorException, OperateFailException
    {
        //1、校验手工账单编号
        if (StringUtils.isBlank(billManual.getBillId()))
        {
            GooagooLog.info("校验编辑手工账单数据：手工账单编号（" + billManual.getBillId() + "）为空");
            throw new NullException("手工账单编号（" + billManual.getBillId() + "）为空");
        }
        //2、校验手工账单数据
        this.checkBillManualData(billManual);

        return true;
    }

    /**
     * 校验删除手工账单数据
     * @param billManual
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws OperateFailException
     */
    private boolean checkUpdateBillManualData(String billId) throws NullException
    {
        //1、校验手工账单编号
        if (StringUtils.isBlank(billId))
        {
            GooagooLog.info("校验编辑手工账单数据：手工账单编号（" + billId + "）为空");
            throw new NullException("手工账单编号（" + billId + "）为空");
        }

        return true;
    }

    /**
     * 校验手工账单数据
     * @param billManual
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws OperateFailException 
     */
    private boolean checkBillManualData(BillManual billManual) throws NullException, FormatErrorException, OperateFailException
    {
        //1、校验用户状态
        if (!this.userProtectedCoreService.checkUserStatus(billManual.getUserId()))
        {
            GooagooLog.info("校验手工账单数据：用户（" + billManual.getUserId() + "）状态异常");
            throw new OperateFailException("用户（" + billManual.getUserId() + "）状态异常");
        }
        //2、校验单号
        if (StringUtils.isBlank(billManual.getBillNo()))
        {
            GooagooLog.info("校验手工账单数据：单号（" + billManual.getBillNo() + "）为空");
            throw new NullException("单号（" + billManual.getBillNo() + "）为空");
        }
        if (billManual.getBillNo().length() > 32)
        {
            GooagooLog.info("校验手工账单数据：单号（" + billManual.getBillNo() + "）长度超过32个字符");
            throw new FormatErrorException("单号（" + billManual.getBillNo() + "）长度超过32个字符");
        }
        //3、校验类别
        if (StringUtils.isNotBlank(billManual.getBillType()) && billManual.getBillType().length() > 32)
        {
            GooagooLog.info("校验手工账单数据：类别（" + billManual.getBillType() + "）长度超过32个字符");
            throw new FormatErrorException("类别（" + billManual.getBillType() + "）长度超过32个字符");
        }
        //4、校验消费金额
        if (billManual.getFee() == null)
        {
            GooagooLog.info("校验手工账单数据：消费金额（" + billManual.getFee() + "）为空");
            throw new NullException("消费金额（" + billManual.getFee() + "）为空");
        }
        if (!DataPatternUtils.checkPrice(DataUtils.format2Decimal(billManual.getFee())))
        {
            GooagooLog.info("校验手工账单数据：消费金额（" + billManual.getFee() + "）格式不正确");
            throw new FormatErrorException("消费金额（" + billManual.getFee() + "）格式不正确");
        }
        //5、校验消费时间
        if (billManual.getRequestTime() == null)
        {
            GooagooLog.info("校验手工账单数据：消费时间（" + billManual.getRequestTime() + "）为空");
            throw new NullException("消费时间（" + billManual.getRequestTime() + "）为空");
        }
        //6、校验所属商家
        if (StringUtils.isNotBlank(billManual.getShopName()) && billManual.getShopName().length() > 32)
        {
            GooagooLog.info("校验手工账单数据：所属商家（" + billManual.getShopName() + "）长度超过32个字符");
            throw new NullException("所属商家（" + billManual.getShopName() + "）长度超过32个字符");
        }
        //7、校验备注
        if (StringUtils.isNotBlank(billManual.getNote()) && billManual.getNote().length() > 50)
        {
            GooagooLog.info("校验手工账单数据：备注（" + billManual.getNote() + "）长度超过50个字符");
            throw new NullException("备注（" + billManual.getNote() + "）长度超过50个字符");
        }

        return true;
    }

}
