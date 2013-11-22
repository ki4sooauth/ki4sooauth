package com.gooagoo.gus.personal.action;

import java.io.IOException;

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

@Controller
@RequestMapping("/cityAction")
public class CityAction extends BaseAction
{
    /**
     * 根据省获取市
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(params = "method=city")
    public String city(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> city = GusClientUtils.transfer(request, InterGusConstants.COMMON_CITYCOMMON_GETCITYLIST);
        if (city.getData() != null)
        {
            ServletUtils.writeHtml(new Gson().toJson(city.getData()), response);
        }
        return null;

    }

    /**
     * 根据市获取区县
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(params = "method=area")
    public String area(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> area = GusClientUtils.transfer(request, InterGusConstants.COMMON_AREACOMMON_GETAREALIST);
        if (area.getData() != null)
        {
            ServletUtils.writeHtml(new Gson().toJson(area.getData()), response);
        }
        return null;
    }

}
