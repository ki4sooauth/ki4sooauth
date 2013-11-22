package com.gooagoo.gmember.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.crm.FhighChartVo;
import com.gooagoo.view.gms.crm.YDataVo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/userDeptDivi")
public class UserDeptDivistionAction extends BaseAction
{

    @RequestMapping(params = "method=familyRole")
    public void overAllStatus(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        FhighChartVo fhighChartVo = new FhighChartVo();
        fhighChartVo.setTableName("家庭角色分析");
        fhighChartVo.setUnit("人");
        fhighChartVo.getxData().add("为人父母");
        fhighChartVo.getxData().add("单身男女");
        fhighChartVo.getxData().add("怡养天年");
        fhighChartVo.setyName("人数");

        List<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++)
        {
            data.add(new Random().nextInt(500));
        }
        YDataVo chartVo = new YDataVo();
        chartVo.setData(data);
        fhighChartVo.getyDataVos().add(chartVo);
        ServletUtils.writeHtml(new Gson().toJson(fhighChartVo), response);
    }
}
