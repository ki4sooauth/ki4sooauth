package com.gooagoo.analysis.receptor.queue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.gooagoo.analysis.common.utils.LogUtil;
import com.gooagoo.analysis.converter.service.ConverterControlService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.marketingEngine.MarketingEngineService;
import com.gooagoo.analysis.notice.service.NoticeControlService;
import com.gooagoo.common.jms.AbstractMQMessageListener;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.log.MessageLog;
import com.gooagoo.entity.message.GooagooMessage;

public class AnalysisQueueListener extends AbstractMQMessageListener<GooagooMessage<?>>
{
    @Autowired
    private ConverterControlService converterControlService;
    @Autowired
    private MarketingEngineService marketingEngineService;
    @Autowired
    private LogUtil logUtil;
    @Autowired
    private NoticeControlService noticeControlService;

    /**
     * 行为处理
     */
    @SuppressWarnings("rawtypes")
    @Override
    public void process(GooagooMessage<?> gooagooMessage)
    {
        //营销引擎过滤掉直接调用接口的行为
        if (!StringUtils.startsWithIgnoreCase(gooagooMessage.getBehaveCode(), "mobh"))
        {
            MessageLog messageLog = this.logUtil.setLog(gooagooMessage);
            boolean isSend = false;
            try
            {
                //1.转换用户行为
                List<Behave> behaveList = this.converterControlService.getBehave(gooagooMessage);
                if (behaveList.size() == 1)
                {
                    //2.调用营销引擎
                    MarketingNotice marketingNotice = this.marketingEngineService.doAnalysis(behaveList.get(0));
                    //3.处理营销结果
                    if (marketingNotice == null)
                    {
                        messageLog.setException("规则匹配：无匹配结果");
                    }
                    else
                    {
                        this.noticeControlService.send(marketingNotice);
                    }
                }
                else
                {
                    for (Behave behave : behaveList)
                    {
                        this.logUtil.changeUUID(messageLog, behave, gooagooMessage);
                        //2.调用营销引擎
                        MarketingNotice marketingNotice = this.marketingEngineService.doAnalysis(behave);
                        if (marketingNotice == null)
                        {
                            messageLog.setException("规则匹配：无匹配结果");
                            //发送消息路由日志
                            this.logUtil.sendLog(messageLog);
                            continue;
                        }
                        //3.处理营销结果
                        this.noticeControlService.send(marketingNotice);
                        //发送消息路由日志
                        this.logUtil.sendLog(messageLog);
                    }
                    isSend = true;
                }
            }
            catch (Exception e)
            {
                GooagooLog.warn("营销引擎：" + e.getMessage());
                messageLog.setException("营销引擎：" + e.getMessage());
            }
            //发送消息路由日志
            if (!isSend)
            {
                this.logUtil.sendLog(messageLog);
            }

        }
    }

}
