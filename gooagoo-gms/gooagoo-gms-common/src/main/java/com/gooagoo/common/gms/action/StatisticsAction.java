package com.gooagoo.common.gms.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.gms.utils.StatisticsUtil;
import com.gooagoo.common.utils.HttpClientUtils;
import com.gooagoo.common.utils.ServletUtils;

@Controller
@RequestMapping("/statistics")
public class StatisticsAction
{
    /**
     * 获取统计图形数据
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=graph")
    public void graph(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String type = ServletRequestUtils.getStringParameter(request, "type", "");
        String content = ServletRequestUtils.getStringParameter(request, "content", "");
        String url = StatisticsUtil.createGraphUrl(type, content);
        if (url.isEmpty())
        {
            ServletUtils.writeHtml("false", response);
        }
        String result = HttpClientUtils.loadFileStringByUrl(url);
        if (result == null)
        {
            result = "";
        }
        ServletUtils.writeHtml(result, response);
    }
}
