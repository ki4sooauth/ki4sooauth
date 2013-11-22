package com.gooagoo.igus.bill.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.transaction.order.BillManualCoreService;
import com.gooagoo.api.generator.query.bill.BillManualGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.bill.BillManual;
import com.gooagoo.entity.generator.bill.BillManualExample;
import com.gooagoo.igus.bill.service.IManualBillService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.common.PageModel;
import com.gooagoo.view.gus.web.bill.UBillManualDetails;

@Service("iManualBillService")
public class IManualBillServiceImpl implements IManualBillService
{

    @Autowired
    private BillManualCoreService billManualCoreService;

    @Autowired
    private BillManualGeneratorQueryService billManualGeneratorQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.BILL_MANUALBILL_GETMANUALBILLLIST)
    public TransData<Object> getManualBillList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            PageModel<UBillManualDetails> pageModel = new PageModel<UBillManualDetails>();
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Date startDate = TimeUtils.convertStringToDate(ServletRequestUtils.getStringParameter(request, "startDate"));
            Date endDate = TimeUtils.convertStringToDate(ServletRequestUtils.getStringParameter(request, "endDate"));
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 6);
            BillManualExample billManualExample = new BillManualExample();
            billManualExample.createCriteria().andIsDelEqualTo("N").andUserIdEqualTo(userId).andRequestTimeBetween(startDate, endDate);
            Integer count = this.billManualGeneratorQueryService.countByExample(billManualExample);
            billManualExample.setOrderByClause("request_time desc");
            billManualExample.setPage(pageIndex, pageSize);
            List<BillManual> billManualList = this.billManualGeneratorQueryService.selectByExample(billManualExample);
            if (CollectionUtils.isEmpty(billManualList))
            {
                GooagooLog.info("查询手工账单列表：手工账单为空");
                return new TransData<Object>(true, MessageConst.BILL_IMANUALBILL_GETMANUALBILLLIST_NOTEXIST, null);
            }
            List<UBillManualDetails> ubillManualDetailsList = new ArrayList<UBillManualDetails>();
            for (BillManual billManual : billManualList)
            {
                UBillManualDetails ubillManual = new UBillManualDetails();
                ubillManual.setFee(FormatDataUtils.formatGoodsPrice(billManual.getFee()));
                ubillManual.setRequestTime(TimeUtils.convertDateToString(billManual.getRequestTime(), "yyyy-MM-dd"));
                ubillManual.setNote(billManual.getNote());
                ubillManual.setBillType(billManual.getBillType());
                ubillManual.setShopName(billManual.getShopName());
                ubillManual.setBillId(billManual.getBillId());
                ubillManual.setBillNo(billManual.getBillNo());
                ubillManualDetailsList.add(ubillManual);
            }
            pageModel.setPageIndex(pageIndex);
            pageModel.setPageSize(pageSize);
            pageModel.setResult(ubillManualDetailsList);
            pageModel.setCount(count);
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, pageModel);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询手工账单列表：查询手工账单失败", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.BILL_MANUALBILL_ADDMANUALBILL)
    public TransData<Object> addManualBill(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            BillManual billManual = ServletUtils.objectMethod(BillManual.class, request);
            billManual.setUserId(userId);
            if (!this.billManualCoreService.addBillManual(billManual))
            {
                GooagooLog.info("添加手工账单：添加手工账单失败（" + billManual.toString() + "）");
                return new TransData<Object>(false, MessageConst.BILL_IMANUALBILL_ADDMANUALBILL_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.BILL_IMANUALBILL_ADDMANUALBILL_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("添加手工账单：添加手工账单异常", e);
            transData = new TransData<Object>(false, MessageConst.BILL_IMANUALBILL_ADDMANUALBILL_FAIL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.BILL_MANUALBILL_UPDATEMANUALBILL)
    public TransData<Object> updateManualBill(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            BillManual billManual = ServletUtils.objectMethod(BillManual.class, request);
            if (billManual.getBillType() == null)
            {
                billManual.setBillType("");
            }
            if (billManual.getNote() == null)
            {
                billManual.setNote("");
            }
            if (billManual.getShopName() == null)
            {
                billManual.setShopName("");
            }
            billManual.setUserId(userId);
            if (!this.billManualCoreService.updateBillManual(billManual))
            {
                GooagooLog.info("编辑手工账单：编辑手工账单失败（" + billManual.toString() + "）");
                return new TransData<Object>(false, MessageConst.BILL_IMANUALBILL_UPDATEMANUALBILL_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.BILL_IMANUALBILL_UPDATEMANUALBILL_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("编辑手工账单：编辑手工账单异常", e);
            transData = new TransData<Object>(false, MessageConst.BILL_IMANUALBILL_UPDATEMANUALBILL_FAIL, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.BILL_MANUALBILL_DELETEMANUALBILL)
    public TransData<Object> deleteManualBill(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String manualBillId = ServletRequestUtils.getStringParameter(request, "manualBillId");
            if (!this.billManualCoreService.deleteBillManual(manualBillId))
            {
                GooagooLog.info("删除手工帐单：删除手工账单失败（" + manualBillId + "）");
                return new TransData<Object>(false, MessageConst.BILL_IMANUALBILL_DELETEMANUALBILL_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.BILL_IMANUALBILL_DELETEMANUALBILL_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("删除手工帐单：删除手工账单异常", e);
            transData = new TransData<Object>(false, MessageConst.BILL_IMANUALBILL_DELETEMANUALBILL_FAIL, null);
        }
        return transData;
    }

}
