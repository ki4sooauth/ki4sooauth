package com.gooagoo.gmember.action;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.view.gms.member.FMemberCard;
import com.google.gson.Gson;

@Controller
@RequestMapping("/memberCard")
public class MemberCardAction extends BaseAction
{

    /**
     * 会员卡首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        GooagooLog.debug("进入会员卡列表………………，跳转至 memberCard/index ");
        return "/memberCard/index";
    }

    /**
     * 会员卡列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=list")
    public String list(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMEBER_PAGE, request, List.class);
        List<FMemberCard> list = respObj.getData();
        if (list != null)
        {
            request.setAttribute("list", list);
            GooagooLog.debug("获取会员卡列表为：！" + new Gson().toJson(list));
        }
        else
        {
            GooagooLog.debug("获取会员卡列表为空！");
        }
        return "/memberCard/list";
    }

    /**
     * 会员卡创建首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=create")
    public String create(HttpServletRequest request, HttpServletResponse response)
    {
        String cardId = ServletRequestUtils.getStringParameter(request, "cardId", "");
        String cardType2 = ServletRequestUtils.getStringParameter(request, "cardType2", "");
        request.setAttribute("cardId", cardId);
        request.setAttribute("cardType2", cardType2);
        return "/memberCard/create_index";
    }

    /**
     * 判断会员卡是否已发放
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=cardHasGive")
    public void cardHasGive(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MEMBER_CARDHASGIVE, request, response);
    }

    /**
     * 添加关注卡页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=formAttentionA")
    public String formAttentionA(HttpServletRequest request, HttpServletResponse response)
    {
        GooagooLog.debug("添加关注卡：　 页面跳转至——memberCard/attention_edit");
        return "/memberCard/attention_edit";
    }

    /**
     * 修改关注卡页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=formAttentionU")
    public String formAttentionU(HttpServletRequest request, HttpServletResponse response)
    {
        String cardId = ServletRequestUtils.getStringParameter(request, "cardId", "");
        GooagooLog.debug("修改关注卡：　卡ID　cardId＝" + cardId);

        FMemberCard memberCard = new FMemberCard();
        if (StringUtils.hasText(cardId))
        {
            TransData<FMemberCard> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBER_FORM, request, FMemberCard.class);
            memberCard = respObj.getData();
        }
        request.setAttribute("memberCard", memberCard);
        GooagooLog.debug("修改关注卡：　 页面跳转至——memberCard/attention_edit");
        return "/memberCard/attention_edit";
    }

    /**
     * 添加基本卡页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=formBaseA")
    public String formBaseA(HttpServletRequest request, HttpServletResponse response)
    {
        GooagooLog.debug("添加基础卡：　 页面跳转至——memberCard/base_edit");
        return "/memberCard/base_edit";
    }

    /**
     * 修改基本卡页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=formBaseU")
    public String formBaseU(HttpServletRequest request, HttpServletResponse response)
    {
        String cardId = ServletRequestUtils.getStringParameter(request, "cardId", "");
        GooagooLog.debug("修改基本卡：　卡ID　cardId＝" + cardId);

        FMemberCard memberCard = new FMemberCard();
        if (StringUtils.hasText(cardId))
        {
            TransData<FMemberCard> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBER_FORM, request, FMemberCard.class);
            memberCard = respObj.getData();
        }

        request.setAttribute("memberCard", memberCard);
        GooagooLog.debug("修改基础卡：　 页面跳转至——memberCard/base_edit");
        return "/memberCard/base_edit";
    }

    /**
     * 添加高级会员卡页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=formAdvanceA")
    public String formAdvanceA(HttpServletRequest request, HttpServletResponse response)
    {
        GooagooLog.debug("修改高级卡：　 页面跳转至——memberCard/advance_edit");
        return "/memberCard/advance_edit";
    }

    /**
     * 修改高级卡页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=formAdvanceU")
    public String formAdvanceU(HttpServletRequest request, HttpServletResponse response)
    {
        String cardId = ServletRequestUtils.getStringParameter(request, "cardId", "");
        GooagooLog.debug("修改高级卡：　卡ID　cardId＝" + cardId);

        FMemberCard memberCard = new FMemberCard();
        if (StringUtils.hasText(cardId))
        {
            TransData<FMemberCard> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBER_FORM, request, FMemberCard.class);
            memberCard = respObj.getData();
        }

        request.setAttribute("memberCard", memberCard);

        GooagooLog.debug("修改高级卡：　 页面跳转至——memberCard/advance_edit");
        return "/memberCard/advance_edit";
    }

    /**
     * 添加会员卡
     * @param request
     * @param response
     * @param memberCard
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=save")
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MEMBER_SAVE, request, response);
    }

    /**
     * 会员卡详细信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=getMemberCard")
    public String getMemberCard(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<FMemberCard> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBER_FORM, request, FMemberCard.class);
        FMemberCard memberCard = respObj.getData();
        //获取字典表数据
        Map<String, String> map = new TreeMap<String, String>();
        map.putAll(SysdictionaryCache.get("publish_status"));
        request.setAttribute("publish_status", map);

        if (memberCard != null)
        {
            request.setAttribute("memberCard", memberCard);
            GooagooLog.debug("会员卡详细信息：　" + new Gson().toJson(memberCard));
        }
        else
        {
            GooagooLog.debug("会员卡详细信息为空！");
        }
        GooagooLog.debug("获取会员详细信息，页面转至——memberCard/detail");

        return "/memberCard/detail";
    }

    /**
     * 修改会员卡
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //给推送系统发送商家日志，需要指定对象编码 
        String objectCode = ServletRequestUtils.getStringParameter(request, "cardId", "");
        request.setAttribute("objectCode", objectCode);

        GooagooLog.debug("修改会员卡：卡ID　cardId＝" + objectCode);

        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MEMBER_UPDATE, request, response);
    }

    /**
     * 删除会员卡
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //给推送系统发送商家日志，需要指定对象编码 
        String objectCode = ServletRequestUtils.getStringParameter(request, "cardId", "");
        request.setAttribute("objectCode", objectCode);

        GooagooLog.debug("删除会员卡：卡ID　cardId＝" + objectCode);

        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MEMBER_DELETE, request, response);
    }

    /**
     * 审核会员卡页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=checkForm")
    public String checkForm(HttpServletRequest request, HttpServletResponse response)
    {
        String cardId = ServletRequestUtils.getStringParameter(request, "cardId", "");
        request.setAttribute("cardId", cardId);

        return "/memberCard/memberCard_approve";

    }

    /**
     * 审核会员卡
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=check")
    public void check(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MEMBER_CHECK, request, response);
    }

    /**
     * 发布会员卡
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=publish")
    public void publish(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MEMBER_PUBLISH, request, response);
    }
}
