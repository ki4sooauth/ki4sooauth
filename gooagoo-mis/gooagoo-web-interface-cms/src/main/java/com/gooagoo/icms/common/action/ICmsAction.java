package com.gooagoo.icms.common.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.HttpServerUtils;
import com.gooagoo.common.utils.LogUtils;

@Controller
@RequestMapping("/icms")
public class ICmsAction extends BaseAction
{
    /**
     * 接口服务入口
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=doService")
    public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<Object> data = HttpServerUtils.doService(request, response);
        //打印处理失败日志
        if (!data.getHead().isSuccess())
        {
            String operateContent = LogUtils.getOperateContent(request, data);
            GooagooLog.warn("******ICMS接口处理失败******");
            GooagooLog.warn(operateContent);
        }
    }
}
