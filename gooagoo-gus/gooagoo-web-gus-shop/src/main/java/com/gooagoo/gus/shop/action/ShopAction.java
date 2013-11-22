package com.gooagoo.gus.shop.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

@Controller
@RequestMapping("/shop")
public class ShopAction extends BaseAction
{
    /**
     * 我的商家首页   展示推荐商家  会员商家
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("pageIndex", 1);
        request.setAttribute("pageSize", 3);
        TransData<Object> shopType = GusClientUtils.transfer(request, InterGusConstants.COMMON_SHOPTYPECOMMON_GETSHOPTYPELIST);
        //        TransData<Object> shop = GusClientUtils.transfer(request, InterGusConstants.COMMON_SHOPCOMMON_GETRECOMMENDATIONSHOPLIST);
        //        request.setAttribute("nominateShopResponseList", shop.getData());
        request.setAttribute("simpleShopTypeList", shopType.getData());
        return "shop/shop_index";
    }

    @RequestMapping(params = "method=recommend")
    public String recommend(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPCOMMON_GETRECOMMENDATIONSHOPLIST);
        return "shop/shop_recommend";
    }

    /**
     * 获取商家会员卡
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=getShopCard")
    public String getShopAttention(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.SHOP_GETSHOPLIST);
        return "shop/shop_cardList";
    }

    /**
     * 申请会员卡
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=memberApply")
    public String memberApply(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("shopId", request.getParameter("shopId"));
        request.setAttribute("shopName", request.getParameter("shopName"));

        return "shop/shop_memberApply";
    }

    /**
     * 完善会员信息
     * 
     */
    @RequestMapping(params = "method=updateMemberInfomation")
    public void updateMemberInfomation(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.SHOP_UPDATEMEMBERBASEINFO);
    }

    /**
     * 查询会员信息（做修改操作）
     * @param request
     * @param response
     * @return
     * @throws ServletRequestBindingException 
     */
    @RequestMapping(params = "method=selectMemberInfomation")
    public String selectMemberInfomation(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException
    {
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
        request.setAttribute("shopId", shopId);
        GusClientUtils.returnData(request, response, InterGusConstants.SHOP_GETMEMBERBASEINFO);
        return "shop/shop_memberInformation";
    }

    /**
     * 申请会员卡
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=memberApplyDo")
    public void cardApply(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.SHOP_MEMBERAPPLY);
    }

    /**
     * 删除会员
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=removeMember")
    public void removeMember(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setAttribute("shopId", request.getParameter("shopId"));
        GusClientUtils.returnJson1(request, response, InterGusConstants.SHOP_REMOVEMEMBER);
    }

    /**
     * 加关注
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=attentionDo")
    public void attentionDo(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setAttribute("shopId", request.getParameter("shopId"));
        GusClientUtils.returnJson1(request, response, InterGusConstants.SHOP_ATTENTION);
    }

    /**
     * 取消关注
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=removeAttention")
    public void removeAttention(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setAttribute("shopId", request.getParameter("shopId"));
        GusClientUtils.returnJson1(request, response, InterGusConstants.SHOP_REMOVEATTENTION);
    }

    /**
     * 物理卡转换页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=cardReturn")
    public String cardReturn(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("shopId", request.getParameter("shopId"));
        request.setAttribute("shopName", request.getParameter("shopName"));
        return "shop/shop_cardReturn";
    }

    /**
     * 物理卡转换
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=cardReturnDo")
    public void cardReturnDo(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setAttribute("cardId", request.getParameter("cardId"));
        request.setAttribute("mobile", request.getParameter("mobile"));
        request.setAttribute("idNo", request.getParameter("idNo"));
        request.setAttribute("shopId", request.getParameter("shopId"));
        GusClientUtils.returnJson1(request, response, InterGusConstants.SHOP_PHYCARDCONVERTAPPLY);

    }

    /**
     * 广告请求
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=adRequest")
    public void adRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.COMMON_ADCOMMON_GETADINFO);
    }

}
