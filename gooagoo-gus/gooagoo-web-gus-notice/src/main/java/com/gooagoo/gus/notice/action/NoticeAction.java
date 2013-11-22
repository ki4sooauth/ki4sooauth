package com.gooagoo.gus.notice.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

/**
 * 商家通知
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/notice")
public class NoticeAction extends BaseAction
{
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        this.getTime(request, response);
        return "/notice/index";
    }

    @RequestMapping(params = "method=shopNotice")
    public String shopNotice(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException
    {
        this.getTime(request, response);
        request.setAttribute("shopId", ServletRequestUtils.getStringParameter(request, "shopId"));
        return "/notice/notice";
    }

    private void getTime(HttpServletRequest request, HttpServletResponse response)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        int currentYear = ca.get(Calendar.YEAR);//获取年份
        request.setAttribute("currentYear", currentYear);
        request.setAttribute("startYear", currentYear - 1);

        Calendar noticeDate = Calendar.getInstance();
        request.setAttribute("noticeEnd", sdf.format(noticeDate.getTime()));
        noticeDate.set(Calendar.MONTH, noticeDate.get(Calendar.MONTH) - 1);
        request.setAttribute("noticeStart", sdf.format(noticeDate.getTime()));
    }

    //首页收件箱信息显示
    @RequestMapping(params = "method=show")
    public String show(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<Object> pageModel = GusClientUtils.transfer(request, InterGusConstants.NOTICE_GETNOTICELIST);
        if (pageModel.getHead().isSuccess())
        {
            //            PageModel<UNoticeInfo> pm = (PageModel<UNoticeInfo>) pageModel.getData();
            //            if (pm != null)
            //            {
            request.setAttribute("count", pageModel.getData());
            request.setAttribute("MessageInfolist", pageModel.getData());
            //            }
            //            request.setAttribute("pageModel", pm);
        }
        request.setAttribute("message", ExceptionCache.get(pageModel.getHead().getResultCode()));
        return "/notice/noticeList";
    }

    //删除收件箱
    @RequestMapping(params = "method=deleteNotice")
    public void deleteNotice(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.NOTICE_DELETENOTICELIST);
    }

    //收藏活动
    @RequestMapping(params = "method=collectVoucherA")
    public void collectVoucherA(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.NOTICE_FAVORITEACTIVE);
    }

    //收藏商品
    @RequestMapping(params = "method=collectVoucherG")
    public void collectVoucherG(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.NOTICE_FAVORITEGOODS);
    }

    //收藏优惠凭证
    @RequestMapping(params = "method=collectVoucherC")
    public void collectVoucherC(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.NOTICE_FAVORITECOUPON);
    }

    //加入购物清单
    @RequestMapping(params = "method=shoppingList")
    public void shoppingList(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.NOTICE_ADDTOSHOPPINGLIST);

    }

    @RequestMapping(params = "method=shopType")
    //商品类型列表
    public String shopType(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPTYPECOMMON_GETSHOPTYPELIST);
        return "/notice/shoptypelist/shoptypelist";
    }

    @RequestMapping(params = "method=shopListRequest")
    //商家列表
    public String shopListRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPCOMMON_GETSHOPLIST);
        return "/notice/shoplist/shoplist";
    }
}
