package com.gooagoo.gus.personal.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.AreaCache;
import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.casclient.constants.Constants;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;
import com.gooagoo.common.gus.utils.VerifyCodeUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;
import com.gooagoo.view.gus.common.Ajax;
import com.google.gson.Gson;

@Controller
@RequestMapping("/personal")
public class PersonalAction extends BaseAction
{

    /**
     * 个人信息首页
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return "/personal/personal";
    }

    /**
     * 显示个人信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=show")
    public String personalInformation(HttpServletRequest request, HttpServletResponse response)
    {
        PersonalLoginInfo obj = (PersonalLoginInfo) request.getAttribute(Constants.CAS_FILTER_USER_OBJ);
        request.setAttribute("pvalue", AreaCache.getSelf(obj.getPersonalProfile().getProvince()));
        request.setAttribute("cvalue", AreaCache.getSelf(obj.getPersonalProfile().getCity()));
        request.setAttribute("avalue", AreaCache.getSelf(obj.getPersonalProfile().getArea()));
        return "/personal/personalInfo/personalInfo";
    }

    /**
     * 查询省
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=getProvince")
    public String getProvince(HttpServletRequest request, HttpServletResponse response) throws IOException
    {

        TransData<Object> city = GusClientUtils.transfer(request, InterGusConstants.COMMON_PROVINCECOMMON_GETPROVINCELIST);
        if (city.getData() != null)
        {
            ServletUtils.writeHtml(new Gson().toJson(city.getData()), response);
        }
        return null;
    }

    /**
     * 完善(修改)个人信息
     * 
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=updatepersonalInformation")
    public void updatepersonalInformation(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        String code = ServletRequestUtils.getStringParameter(request, "verifyCode", UUID.getUUID());
        String resultCode = VerifyCodeUtils.checkVerifyCode(code, request);
        if (resultCode == null)
        {
            GusClientUtils.returnJson1(request, response, InterGusConstants.PERSONAL_PERSONALINFO_UPDATEPERSONALINFO);
        }
        else
        {
            Ajax ajax = new Ajax();
            String errMessage = ExceptionCache.get(resultCode);
            ajax.setMessage(errMessage);
            ServletUtils.writeHtml(new Gson().toJson(ajax), response);
        }

    }

    /**
     * 保存图片
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=savePictures")
    public void savePictures(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.PERSONAL_PERSONALINFO_UPDATEHEADPIC);
    }

}