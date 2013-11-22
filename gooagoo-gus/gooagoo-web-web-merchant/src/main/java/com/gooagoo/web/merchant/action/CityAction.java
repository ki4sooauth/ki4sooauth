package com.gooagoo.web.merchant.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;
import com.gooagoo.view.gus.web.common.UArea;
import com.gooagoo.view.gus.web.common.UCity;
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
    @SuppressWarnings("unchecked")
    @RequestMapping(params = "method=city")
    public String city(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        //        TransData<CityResponse> city = HttpClientUtils.transfer(InterGusConstants.C_GUS_PL_CITY, request, CityResponse.class);
        TransData<Object> city = GusClientUtils.transfer(request, InterGusConstants.COMMON_CITYCOMMON_GETCITYLIST);
        if (city.getData() != null)
        {
            List<UCity> citylist = (List<UCity>) city.getData();
            response.setContentType("text/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String json = new Gson().toJson(citylist);
            out.print(json);
            out.flush();
            out.close();
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
    @SuppressWarnings("unchecked")
    @RequestMapping(params = "method=area")
    public String area(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        //        TransData<CityResponse> area = HttpClientUtils.transfer(InterGusConstants.C_GUS_PL_AREA, request, CityResponse.class);
        TransData<Object> area = GusClientUtils.transfer(request, InterGusConstants.COMMON_AREACOMMON_GETAREALIST);

        if (area.getData() != null)
        {
            List<UArea> citylist = (List<UArea>) area.getData();
            response.setContentType("text/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String json = new Gson().toJson(citylist);
            out.print(json);
            out.flush();
            out.close();
        }
        return null;
    }

}
