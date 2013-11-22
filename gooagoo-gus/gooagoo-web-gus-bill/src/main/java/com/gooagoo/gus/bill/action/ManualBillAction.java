package com.gooagoo.gus.bill.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;
import com.gooagoo.view.gus.common.PageModel;
import com.gooagoo.view.gus.web.bill.UBillManualDetails;

@Controller
@RequestMapping("/manualBill")
public class ManualBillAction extends BaseAction
{

    @RequestMapping(params = "method=addManualBill")
    public void addManualBill(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.BILL_MANUALBILL_ADDMANUALBILL);
    }

    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        this.getTime(request, response);
        return "bill/manualbill/index";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(params = "method=manualBillList")
    public String manualBillList(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> pageModel = GusClientUtils.transfer(request, InterGusConstants.BILL_MANUALBILL_GETMANUALBILLLIST);
        if (pageModel.getHead().isSuccess())
        {
            PageModel<UBillManualDetails> pm = (PageModel<UBillManualDetails>) pageModel.getData();
            if (pm != null)
            {
                request.setAttribute("count", pm.getResult().size());
                request.setAttribute("data", pm.getResult());
            }
            request.setAttribute("pageModel", pm);
        }
        request.setAttribute("message", ExceptionCache.get(pageModel.getHead().getResultCode()));

        return "bill/manualbill/manualBill";
    }

    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.BILL_MANUALBILL_DELETEMANUALBILL);
    }

    @RequestMapping(params = "method=edit")
    public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.BILL_MANUALBILL_UPDATEMANUALBILL);
    }

    private void getTime(HttpServletRequest request, HttpServletResponse response)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        int currentYear = ca.get(Calendar.YEAR);//获取年份
        request.setAttribute("currentYear", currentYear);
        request.setAttribute("startYear", currentYear - 1);

        Calendar billDate = Calendar.getInstance();
        request.setAttribute("billEnd", sdf.format(billDate.getTime()));
        billDate.set(Calendar.MONTH, billDate.get(Calendar.MONTH) - 1);
        request.setAttribute("billStart", sdf.format(billDate.getTime()));
    }

}
