package com.gooagoo.mis.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;

/**
 * poi导入导出
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/reportOperate")
public class ReportOperateAction extends BaseAction
{
    /**
     * 导入Excel页面
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=importExcelPage")
    public String importExcelPage(HttpServletRequest request, HttpServletResponse response)
    {
        String url = ServletRequestUtils.getStringParameter(request, "url", "");
        request.setAttribute("url", url);
        return "/common/reportOperate";
    }

    /**
     * 导出Excel
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=exportExcel")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response)
    {

    }
}
