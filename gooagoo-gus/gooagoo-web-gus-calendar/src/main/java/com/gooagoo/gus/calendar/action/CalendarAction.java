package com.gooagoo.gus.calendar.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/calendar")
public class CalendarAction extends BaseAction
{
    /*
     * 日历首页
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("week", new Date().getDay());
        Calendar calendar = Calendar.getInstance();
        request.setAttribute("year", calendar.get(Calendar.YEAR));
        request.setAttribute("month", calendar.get(Calendar.MONTH) + 1);
        return "/calendar/index";
    }

    /*
     * 查询营销日历
     */
    @RequestMapping(params = "method=show")
    public String show(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        Integer year = Integer.parseInt(request.getParameter("year"));
        Integer month = Integer.parseInt(request.getParameter("month"));
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DATE, 1);
        int week = c.get(Calendar.DAY_OF_WEEK) - 1;// 得到第一天的星期 
        Integer days = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        Date dt = new Date();
        int iDay = dt.getDate();
        request.setAttribute("date", iDay);//当前是多少号
        request.setAttribute("week", week);
        request.setAttribute("days", days);//当月有多少天
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        request.setAttribute("isMonth", df.format(new Date()).equals(df.format(df.parse(year + "-" + month))));

        return "/calendar/calendar";
    }

    /*
     * 查询购物清单
     */
    @RequestMapping(params = "method=shopList")
    public void shopList(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> shoppingListResult = GusClientUtils.transfer(request, InterGusConstants.CALENDAR_GETSHOPPINGLISTLIST);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String result = gson.toJson(shoppingListResult.getData());
        ServletUtils.writeHtml(result, response);
    }

    /*
     * 查询活动
     */
    @RequestMapping(params = "method=activeList")
    public void activeList(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> active = GusClientUtils.transfer(request, InterGusConstants.CALENDAR_GETACTIVELIST);
        String result = new Gson().toJson(active.getData());
        ServletUtils.writeHtml(result, response);
    }

    /*
     * 查询账单
     */
    @RequestMapping(params = "method=billList")
    public void billList(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> electricBill = GusClientUtils.transfer(request, InterGusConstants.CALENDAR_GETBILLLIST);
        String result = new Gson().toJson(electricBill.getData());
        ServletUtils.writeHtml(result, response);
    }
}
