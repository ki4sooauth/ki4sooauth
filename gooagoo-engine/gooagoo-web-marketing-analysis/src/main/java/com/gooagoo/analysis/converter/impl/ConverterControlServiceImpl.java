package com.gooagoo.analysis.converter.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.analysis.converter.service.ConverterControlService;
import com.gooagoo.analysis.converter.service.ConverterService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.BehaveObject;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.SpringBeanUtils;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.log.ShopLog;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.exception.GooagooException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 将不同的行为对象转换成统一的营销引擎处理对象
 * @author YL
 *
 */
@Service
public class ConverterControlServiceImpl implements ConverterControlService
{
    @Override
    public List<Behave> getBehave(Object obj) throws Exception
    {
        BehaveObject behaveObject = this.checkObj(obj);
        String logType = behaveObject.getBehaveType();
        obj = behaveObject.getObject();
        ConverterService converterService = (ConverterService) SpringBeanUtils.getBean(logType + "ConverterService");
        return converterService.getBehave(obj);
    }

    private BehaveObject checkObj(Object obj) throws GooagooException
    {
        BehaveObject behaveObject = new BehaveObject();
        //从消息队列接收到数据
        if (obj instanceof GooagooMessage)
        {
            GooagooMessage<?> gooagooMessage = (GooagooMessage<?>) obj;
            Object gooMsg = gooagooMessage.getContent();
            if (gooMsg instanceof BehaveLog)
            {
                behaveObject.setBehaveType("behaveLog");
                behaveObject.setObject(gooMsg);

            }
            if (gooMsg instanceof ShopLog)
            {
                behaveObject.setBehaveType("shopLog");
                behaveObject.setObject(gooMsg);
            }
            if (gooMsg instanceof String)
            {
                //位置引擎,行为002
                if ("002".equals(gooagooMessage.getBehaveCode()))
                {
                    behaveObject.setBehaveType("behavior");
                    behaveObject.setObject(gooMsg);
                }
                //位置引擎,时长003
                if ("003".equals(gooagooMessage.getBehaveCode()))
                {
                    behaveObject.setBehaveType("duration");
                    behaveObject.setObject(gooMsg);
                }
            }
        }
        //从接口参数接收到数据
        if (obj instanceof String)
        {
            GooagooLog.debug("营销引擎接口入参：【" + obj + "】");
            Gson gson = new Gson();
            GooagooMessage<?> gooagooMessage = gson.fromJson((String) obj, new TypeToken<GooagooMessage<?>>()
            {
            }.getType());
            String source = gooagooMessage.getSource();
            //BehaveLog
            if ("1".equals(source) || "2".equals(source) || "3".equals(source))
            {
                GooagooMessage<BehaveLog> gooMsgbehaveLog = gson.fromJson((String) obj, new TypeToken<GooagooMessage<BehaveLog>>()
                {
                }.getType());
                behaveObject.setBehaveType("behaveLog");
                behaveObject.setObject(gooMsgbehaveLog.getContent());
            }
            //ShopLog
            if ("5".equals(source) || "6".equals(source))
            {
                GooagooMessage<ShopLog> gooMsgshopLog = gson.fromJson((String) obj, new TypeToken<GooagooMessage<ShopLog>>()
                {
                }.getType());
                behaveObject.setBehaveType("shopLog");
                behaveObject.setObject(gooMsgshopLog.getContent());
            }
        }
        return behaveObject;
    }
}
