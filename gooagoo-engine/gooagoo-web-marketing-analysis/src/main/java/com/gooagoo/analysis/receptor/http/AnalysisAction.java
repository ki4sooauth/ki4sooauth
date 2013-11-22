package com.gooagoo.analysis.receptor.http;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.analysis.converter.service.ConverterControlService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.marketingEngine.MarketingEngineService;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.push.MobPushMsg;
import com.gooagoo.exception.GooagooException;

@Controller
@RequestMapping("/marketing")
public class AnalysisAction extends BaseAction
{
    @Autowired
    private ConverterControlService converterControlService;
    @Autowired
    private MarketingEngineService marketingEngineService;

    /**
     * 接口服务入口
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping
    public void doService(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            Object obj = ServletRequestUtils.getStringParameter(request, "behave", null);//接口编码
            //1.转换用户行为
            List<Behave> behaveList = this.converterControlService.getBehave(obj);
            //2.调用营销引擎
            MarketingNotice marketingNotice = this.marketingEngineService.doAnalysis(behaveList.get(0));
            //3.处理营销结果
            if (marketingNotice == null)
            {
                GooagooLog.debug("规则匹配：无匹配结果");
                throw new GooagooException("规则匹配：无匹配结果");
            }
            if ("http".equals(marketingNotice.getType()))
            {
                ServletUtils.writeHtml(((GooagooMessage<MobPushMsg>) marketingNotice.getGooagooMessage()).getContent().getContent(), response);
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("营销引擎接口服务入口异常", e);
        }
    }
}
