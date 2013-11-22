package com.gooagoo.gmember.action;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.member.FCardLvl;
import com.gooagoo.view.gms.member.FCardUpInfo;
import com.gooagoo.view.gms.member.FConvertApply;
import com.gooagoo.view.gms.member.FMemberApply;
import com.gooagoo.view.gms.member.FMemberBaseInfo;
import com.gooagoo.view.gms.member.FSAIntegralMember;
import com.gooagoo.view.gms.member.FUser;

@Controller
@RequestMapping("/memberOfCard")
public class MemberOfCardAction extends BaseAction
{
    /**
     * 会员审核首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=apply")
    public String apply(HttpServletRequest request, HttpServletResponse response)
    {
        return "/memApprove/index";
    }

    /**
     * 会员审核信息列表
     * @param request
     * @param response
     * @param memberOfCardApply
     * @return
     */
    @RequestMapping(params = "method=applyList")
    public String applyList(HttpServletRequest request, HttpServletResponse response)
    {
        Map<String, String> map = new TreeMap<String, String>();
        map.putAll(SysdictionaryCache.get("application_status"));
        request.setAttribute("applicationStatus", map);

        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBEROFCARD_ACPAGE, request, PageModel.class);
        PageModel<FMemberApply> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {   
        	for (FMemberApply result : pm.getResult()) {
				String idType = result.getIdType();
				idType = SysdictionaryCache.get("idtype", idType);
				result.setIdType(idType);
			}
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }

        return "/memApprove/applyList";
    }

    /**
     * 审核会员申请弹出页
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=approvalAppCardForm")
    public String approvalAppCardForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        String indexNum = ServletRequestUtils.getStringParameter(request, "indexNum", "");

        request.setAttribute("id", id);
        request.setAttribute("indexNum", indexNum);

        return "/memApprove/approve_Pupop";
    }

    /**
     * 审核会员申请
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=approvalAppCard")
    public void approvalAppCard(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //给推送系统发送商家日志，需要指定对象编码 
        String objectCode = ServletRequestUtils.getStringParameter(request, "applicationId", "");
        request.setAttribute("objectCode", objectCode);

        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MEMBEROFCARD_APPROVALAPPCARD, request, response);
    }

    /**
     * 物理卡转换主页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=convert")
    public String convert(HttpServletRequest request, HttpServletResponse response)
    {
        return "/ecardApprove/index";
    }

    /**
     * 物理卡转换申请信息列表
     * @param request
     * @param response
     * @param memberApply
     * @return
     */
    @RequestMapping(params = "method=convertList")
    public String convertList(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBEROFCARD_PCPAGE, request, PageModel.class);
        PageModel<FConvertApply> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }

        return "/ecardApprove/convertList";
    }

    /**
     * 审核会员申请弹出页
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=approvalPsyConvertForm")
    public String approvalPsyConvertForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        String indexNum = ServletRequestUtils.getStringParameter(request, "indexNum", "");

        request.setAttribute("id", id);
        request.setAttribute("indexNum", indexNum);

        return "/ecardApprove/approve_Pupop";
    }

    /**
     * 审核物理卡转换申请
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=approvalPsyConvert")
    public void approvalPsyConvert(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //给推送系统发送商家日志，需要指定对象编码 
        String objectCode = ServletRequestUtils.getStringParameter(request, "applicationId", "");
        request.setAttribute("objectCode", objectCode);

        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MEMBEROFCARD_APPROVALPSYCONVERT, request, response);
    }

    /**
     * 卡积分升级主页
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=upgrade")
    public String upgrade(HttpServletRequest request, HttpServletResponse response)
    {
        return "/uplApprove/index";
    }

    /**
     * 卡积分升级列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=upgradeList")
    public String upgradeList(HttpServletRequest request, HttpServletResponse response)
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBEROFCARD_ICPAGE, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FCardUpInfo> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }

        return "/uplApprove/upgradeList";
    }

    /**
     * 积分特批弹出页
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=integralUpgradeForm")
    public String integralUpgradeForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String userId = ServletRequestUtils.getStringParameter(request, "userId", "");
        String integralId = ServletRequestUtils.getStringParameter(request, "integralId", "");
        String indexNum = ServletRequestUtils.getStringParameter(request, "indexNum", "");

        request.setAttribute("userId", userId);
        request.setAttribute("integralId", integralId);
        request.setAttribute("indexNum", indexNum);

        return "/uplApprove/approve_Pupop";
    }

    /**
     * 卡积分升级
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=integralUpgrade")
    public void integralUpgrade(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //给推送系统发送商家日志，需要指定对象编码 
        String objectCode = ServletRequestUtils.getStringParameter(request, "cardId", "");
        request.setAttribute("objectCode", objectCode);

        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MEMBEROFCARD_APPROVALINTEGRALUPGRADE, request, response);
    }

    /**
     * 特批会员首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=special")
    public String special(HttpServletRequest request, HttpServletResponse response)
    {
        return "/cardSApprove/index";
    }

    /**
     * 特批商家会员信息列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=memSpecialList")
    public String memSpecialList(HttpServletRequest request, HttpServletResponse response)
    {
        String name = ServletRequestUtils.getStringParameter(request, "name", "");
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBEROFCARD_MEMSPECIALPAGE, request, PageModel.class);
        PageModel<FMemberBaseInfo> pm = respObj.getData();

        request.setAttribute("name", name);
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }

        return "/cardSApprove/memList";
    }

    /**
     * 特批平台会员信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=specialUserInfo")
    public String specialUserInfo(HttpServletRequest request, HttpServletResponse response)
    {   
    	
    	String mobile = ServletRequestUtils.getStringParameter(request, "mobile", "");
    	String email = ServletRequestUtils.getStringParameter(request, "email", "");
    	FUser temp = null;
    	if(StringUtils.isNotBlank(mobile) || StringUtils.isNotBlank(email)){
    		TransData<FUser> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBEROFCARD_SPEICIALUSER, request, FUser.class);
    	    temp = respObj.getData();
    	}
    	request.setAttribute("isFirst",StringUtils.isNotBlank(mobile) || StringUtils.isNotBlank(email));
        request.setAttribute("temp", temp);
        return "cardSApprove/gooagooInfo";
    }

    /**
     * 会员卡特批时或取会员卡列表
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=getCardList")
    public String getCardList(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String userId = ServletRequestUtils.getStringParameter(request, "userId", "");
        String indexNum = ServletRequestUtils.getStringParameter(request, "indexNum", "");
        String gradeId = ServletRequestUtils.getStringParameter(request, "gradeId", "");
        String sType = ServletRequestUtils.getStringParameter(request, "sType", "");

        @SuppressWarnings("rawtypes")
        TransData<List> respObj;
        respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMEBER_PAGE, request, List.class);
        @SuppressWarnings("unchecked")
        List<FCardLvl> cardList = respObj.getData();

        request.setAttribute("userId", userId);
        request.setAttribute("gradeId", gradeId);
        request.setAttribute("cardList", cardList);
        request.setAttribute("indexNum", indexNum);
        request.setAttribute("sType", sType);

        return "cardSApprove/approve_Pupop";
    }

    /**
     * 特批会员
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=memSpecialApproval")
    public void memSpecialApproval(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //给推送系统发送商家日志，需要指定对象编码 
        String objectCode = ServletRequestUtils.getStringParameter(request, "cardId", "");
        request.setAttribute("objectCode", objectCode);

        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MEMBEROFCARD_SAPPROVALMEM, request, response);
    }

    /**
     * 积分特批首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=integralSApprove")
    public String integralSApprove(HttpServletRequest request, HttpServletResponse response)
    {
        return "/iSApprove/index";
    }

    /**
     * 积分特批列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=integralSAList")
    public String integralSAList(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_MEMBEROFCARD_SINTEGRALPAGE, request, PageModel.class);
        PageModel<FSAIntegralMember> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "/iSApprove/list";
    }

    /**
     * 积分特批弹出页
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=iSApproveForm")
    public String iSApproveForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String userId = ServletRequestUtils.getStringParameter(request, "userId", "");
        String integralId = ServletRequestUtils.getStringParameter(request, "integralId", "");
        String indexNum = ServletRequestUtils.getStringParameter(request, "indexNum", "");

        request.setAttribute("userId", userId);
        request.setAttribute("integralId", integralId);
        request.setAttribute("indexNum", indexNum);

        return "/iSApprove/approve_Pupop";
    }

    /**
     * 积分特批
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=iSApprove")
    public void iSApprove(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_MEMBEROFCARD_SIAPPROVALMEM, request, response);
    }

    
    /**
     * 会员卡审批详细页
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=approvalAppCardDetail")
    public String approvalAppCardDetail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        String indexNum = ServletRequestUtils.getStringParameter(request, "indexNum", "");

        request.setAttribute("id", id);
        request.setAttribute("indexNum", indexNum);

        return "memApprove/approve_detail";
    }
    
    
    /**
     * 物理卡转换详细信息
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=approvalPsyConvertDetail")
    public String approvalPsyConvertDetail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        String indexNum = ServletRequestUtils.getStringParameter(request, "indexNum", "");

        request.setAttribute("id", id);
        request.setAttribute("indexNum", indexNum);

        return "ecardApprove/approve_detail";
    }
    
    
}
