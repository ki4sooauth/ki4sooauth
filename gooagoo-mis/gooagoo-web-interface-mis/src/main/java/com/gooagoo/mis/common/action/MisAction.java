package com.gooagoo.mis.common.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.jms.JmsUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.HttpServerUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.log.SysLog;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.mis.util.UtilsMis;
import com.google.gson.Gson;

@Controller
@RequestMapping("/mis")
public class MisAction extends BaseAction
{
    @Autowired
    private JmsTemplate template;
    @Autowired
    private ActiveMQQueue destination;

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
        boolean r = false;
        TransData<Object> respObj = null;
        try
        {
            respObj = HttpServerUtils.doService(request, response);
            r = respObj.getHead().isSuccess();
        }
        catch (Exception e)
        {
            throw new Exception(e);
        }
        finally
        {
            try
            {
                String uuid = UUID.getUUID();
                GooagooMessage<SysLog> Glog = new GooagooMessage<SysLog>();
                SysLog log = new SysLog();
                String userid = request.getParameter("userid");
                log.setSysLogId(uuid);
                log.setUserId(userid);
                log.setRemoteCode(respObj.getHead().getTradeCode());
                Map<String, Object> m = new HashMap<String, Object>();
                m.put("input", request.getParameterMap());
                m.put("output", respObj.getData());
                String content = new Gson().toJson(m);

                log.setDetail(content);
                if (r)
                {
                    log.setOperateResult("Y");
                }
                else
                {
                    log.setOperateResult("N");
                }
                log.setOperateIp(UtilsMis.getIpAddr(request));
                log.setCreateTime(new Date());
                log.setObjectCode(respObj.getOperateId());
                Glog.setUuid(uuid);
                Glog.setSource("8");
                Glog.setBehaveCode(log.getRemoteCode());
                Glog.setContent(log);
                JmsUtils.send(this.template, this.destination, Glog);
            }
            catch (Exception e)
            {
                GooagooLog.error("写日志失败", e);
            }
        }
    }
}
