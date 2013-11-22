package com.gooagoo.analysis.notice.impl;

import org.springframework.stereotype.Service;

import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.notice.service.NoticeControlService;
import com.gooagoo.analysis.notice.service.NoticeSendService;
import com.gooagoo.common.utils.SpringBeanUtils;

/**
 * 
 * @author YL
 *
 */
@Service
public class NoticeControlServiceImpl implements NoticeControlService
{

    @Override
    public void send(MarketingNotice<?> marketingNotice) throws Exception
    {
        if (!"http".equals(marketingNotice.getType()))
        {
            NoticeSendService noticeSendService = (NoticeSendService) SpringBeanUtils.getBean(marketingNotice.getType() + "SendService");
            noticeSendService.send(marketingNotice);
        }
    }
}
