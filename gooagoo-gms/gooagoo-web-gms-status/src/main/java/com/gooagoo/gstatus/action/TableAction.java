package com.gooagoo.gstatus.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.business.shop.table.TableStatusByType;
import com.gooagoo.entity.business.shop.table.TableTypeStatus;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.crm.FhighChartVo;
import com.gooagoo.view.gms.crm.YDataVo;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/table")
public class TableAction
{
    /**
     * 餐桌状态（按类型统计）
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=index")
    public String sumMarketingTable(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("relateType", "E");
        request.setAttribute("dataType", "");
        request.setAttribute("pageIndex", "1");
        request.setAttribute("pageSize", "10");
        String entityId = "";
        String entityName = "";
        String entityNum = "";
        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_RELATION_PAGE, request, PageModel.class);
        if (respObj != null && respObj.getData() != null && respObj.getData().getResult().size() > 0)
        {
            PageModel<FShopEntityInfo> pm = respObj.getData();
            entityId = pm.getResult().get(0).getShopEntityId();
            entityName = pm.getResult().get(0).getShopEntityName();
            entityNum = pm.getResult().size() + "";
        }
        GMSUtil.getWebUrlByAuthorityId(request,"12");
        request.setAttribute("shopEntityId", entityId);
        request.setAttribute("entityName", entityName);
        request.setAttribute("entityNum", entityNum);
        return "status/table/index";
    }

    /**
     * 餐桌状态（按类型统计）
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=sumMarketingTableByType")
    public void sumMarketingTableByType(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_MARKETING_STATE_SUM_MARKETING_TABLE_TYPE, request, List.class);
        List<TableTypeStatus> list = transData.getData();

        FhighChartVo chart = new FhighChartVo();
        chart.setTableName("餐桌状态");
        chart.setyName("餐桌使用空闲比率");
        chart.setUnit("");
        List<String> xData = chart.getxData(); //轴数据
        List<String> xCode = chart.getxCode(); //轴数据
        List<YDataVo> yDataVos = chart.getyDataVos();//y轴数据

        YDataVo yFree = new YDataVo();
        yFree.setName("空余");
        List<Integer> xFree = new ArrayList<Integer>();

        YDataVo yCurrent = new YDataVo();
        yCurrent.setName("正在用餐");
        List<Integer> xCurrent = new ArrayList<Integer>();

        YDataVo yBill = new YDataVo();
        yBill.setName("正在结账");
        List<Integer> xBill = new ArrayList<Integer>();

        if (list != null)
        {
            for (Iterator<TableTypeStatus> iterator = list.iterator(); iterator.hasNext();)
            {
                TableTypeStatus deskstatuslist = iterator.next();
                xData.add(deskstatuslist.getTableTypeName());
                xCode.add(deskstatuslist.getTableTypeCode());

                int f = 0;
                int c = 0;
                int b = 0;

                try
                {
                    f = Integer.parseInt(deskstatuslist.getVacancynum());
                    c = Integer.parseInt(deskstatuslist.getUsenum());
                    b = Integer.parseInt(deskstatuslist.getCheckoutnum());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    GooagooLog.warn("餐桌转换格式有问题，" + e.getMessage());
                }

                xFree.add(f);
                xCurrent.add(c);
                xBill.add(b);
            }
        }
        yFree.setData(xFree);
        yCurrent.setData(xCurrent);
        yBill.setData(xBill);
        yDataVos.add(yFree);
        yDataVos.add(yBill);
        yDataVos.add(yCurrent);
        String result = new Gson().toJson(chart);
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 餐桌状态详细
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=tableDetail")
    public String tableDetail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_MARKETING_STATE_SUM_MARKETING_TABLE_DETAIL, request, List.class);
        List<TableStatusByType> list = transData.getData();
        request.setAttribute("list", list);
        return "status/table/table_list_detail";
    }
}
