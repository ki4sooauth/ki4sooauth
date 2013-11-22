package com.gooagoo.cms.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Page
{

    /**
     * 分页内容
     * @param request
     * @param response
     * @return
     */
    public static String getPageContent(HttpServletRequest request, HttpServletResponse response)
    {
        StringBuffer pageContent = new StringBuffer();
        Integer page_cur = (Integer) request.getAttribute("page_cur");
        Integer page_start = (Integer) request.getAttribute("page_start");
        Integer page_end = (Integer) request.getAttribute("page_end");
        if (page_cur == null)
        {
            page_cur = 1;
        }
        if (page_start == null)
        {
            page_start = 1;
        }
        if (page_end == null)
        {
            page_end = 1;
        }
        pageContent.append("<div class='pageBox'>");
        if (page_cur > 1)
        {
            pageContent.append("<a href='javascript:void(0);' class='prev' onclick='page(" + (page_cur - 1) + ",this);'></a>");
        }
        int count = 0;
        for (int i = page_start; i <= page_end; i++)
        {
            count++;
            String css = "";
            int p = page_start + count - 1;
            if (page_cur == p)
            {
                css = " class='curr' ";
            }
            pageContent.append("<a href='javascript:void(0);' " + css + " onclick='page(" + p + ",this);'>" + p + "</a>");
        }
        if (page_cur < page_end)
        {
            pageContent.append("<a href='javascript:void(0);' class='next' onclick='page(" + (page_cur + 1) + ",this);'></a>");
        }
        pageContent.append("</div>");

        return pageContent.toString();
    }
}
