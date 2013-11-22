package com.gooagoo.mis.sysmanage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.log.LogQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.log.BehaveLogExample;
import com.gooagoo.entity.business.log.MessageLogExample;
import com.gooagoo.entity.business.log.MessageLogQuery;
import com.gooagoo.entity.business.log.MessageLogQuery.LogInfo;
import com.gooagoo.entity.business.log.ShopLog;
import com.gooagoo.entity.business.log.ShopLogExample;
import com.gooagoo.entity.business.log.SysLog;
import com.gooagoo.entity.business.log.SysLogExample;
import com.gooagoo.mis.sysmanage.service.LogService;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.common.MBehaveLog;
import com.gooagoo.view.mis.common.MMessageLog;
import com.gooagoo.view.mis.common.MMessageLogQuery;
import com.gooagoo.view.mis.common.MShopLog;
import com.gooagoo.view.mis.common.MSysLog;

@Service(value = "logService")
public class LogServiceImpl implements LogService
{

    @Autowired
    private LogQueryService logQueryService;

    //    @Autowired
    //    private InterfaceBaseInfoGeneratorQueryService interfaceBaseInfoGeneratorQueryService;

    /**
     * 查询所有消息日志
     */
    @Override
    public TransData<PageModel<MMessageLogQuery>> searchLogInfo(HttpServletRequest request) throws Exception
    {
        MMessageLog mmessage = ServletUtils.objectMethod(MMessageLog.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = pageCondition != null && pageCondition.getPageSize() >= 10 ? pageCondition.getPageSize() : 10;
        int pageIndex = pageCondition != null ? pageCondition.getPageIndex() : 1;
        MessageLogExample example = new MessageLogExample();
        //消息流水号
        if (StringUtils.hasText(mmessage.getUuid()))
        {
            example.setUuid(mmessage.getUuid());
        }
        //父流水号
        if (StringUtils.hasText(mmessage.getPuuid()))
        {
            example.setPuuid(mmessage.getPuuid());
        }
        //接口编码
        if (StringUtils.hasText(mmessage.getBehaveCode()))
        {
            example.setBehaveCode(mmessage.getBehaveCode());
        }
        //消息来源
        if (StringUtils.hasText(mmessage.getSource()))
        {
            example.setSource(mmessage.getSource());
        }
        //到达服务器
        if (StringUtils.hasText(mmessage.getServer()))
        {
            example.setServer(mmessage.getServer());
        }
        //行为类型
        if (StringUtils.hasText(mmessage.getBehaveType()))
        {
            example.setBehaveType(mmessage.getBehaveType());
        }
        //接收起始时间
        if (mmessage.getRecetimeBefore() != null && !"".equals(mmessage.getRecetimeBefore()))
        {
            example.setRecetime_before(mmessage.getRecetimeBefore());
        }
        //接收结束时间
        if (mmessage.getRecetimeAfter() != null && !"".equals(mmessage.getRecetimeAfter()))
        {
            example.setRecetime_after(mmessage.getRecetimeAfter());
        }
        //发送起始时间
        if (mmessage.getSendtimeBefore() != null && !"".equals(mmessage.getSendtimeBefore()))
        {
            example.setSendtime_before(mmessage.getSendtimeBefore());
        }
        //发送结束时间
        if (mmessage.getSendtimeAfter() != null && !"".equals(mmessage.getSendtimeAfter()))
        {
            example.setSendtime_after(mmessage.getSendtimeAfter());
        }
        com.gooagoo.entity.common.PageModel<MessageLogQuery> pmLog = this.logQueryService.selectMessageLogQuery(example, pageIndex, pageSize);
        PageModel<MMessageLogQuery> pm = new PageModel<MMessageLogQuery>();
        if (pmLog != null)
        {
            pm.setPageIndex(pmLog.getPageIndex());
            pm.setPageSize(pmLog.getPageSize());
            pm.setCount(pmLog.getCount());
            if (pmLog.getCount() > 0)
            {
                List<MessageLogQuery> messageList = pmLog.getResult();
                for (MessageLogQuery message : messageList)
                {
                    MMessageLogQuery mmes = new MMessageLogQuery();
                    mmes.setUuid(message.getUuid());
                    if (message.getLogInfos() != null && message.getLogInfos().size() > 1)
                    {
                        mmes.setPuuid(message.getLogInfos().get(0).getPuuid());
                    }
                    List<MMessageLog> log = new ArrayList<MMessageLog>();
                    for (LogInfo info : message.getLogInfos())
                    {
                        MMessageLog mmessageLog = new MMessageLog();
                        EntityTools.copyValue(info, mmessageLog);
                        log.add(mmessageLog);
                    }
                    mmes.setMmessageLog(log);
                    pm.getResult().add(mmes);
                }
            }
        }
        return new TransData<PageModel<MMessageLogQuery>>(true, null, pm);
    }

    /**
     * 查询消息日志详细
     */
    @Override
    public TransData<Object> queryMessageLogInfo(HttpServletRequest request) throws Exception
    {
        String uuid = ServletRequestUtils.getStringParameter(request, "uuid", "");
        String logType = ServletRequestUtils.getStringParameter(request, "logType", "");
        if ("1".equals(logType))//商家日志1，个人日志2，后台日志3
        {
            ShopLogExample example = new ShopLogExample();
            example.setLogId(uuid);
            com.gooagoo.entity.common.PageModel<ShopLog> shop = this.logQueryService.selectShopLog(example, 0, 0);
            if (shop.getResult() != null && shop.getResult().size() > 0)
            {
                MShopLog mshop = new MShopLog();
                EntityTools.copyValue(shop.getResult().get(0), mshop);
                return new TransData<Object>(true, null, mshop);
            }
        }
        else if ("2".equals(logType))
        {
            BehaveLogExample example = new BehaveLogExample();
            example.setBehaveId(uuid);
            List<BehaveLog> behave = this.logQueryService.selectBehaveLog(example, 0, 0);
            if (behave != null && behave.size() > 0)
            {
                MBehaveLog mbehave = new MBehaveLog();
                EntityTools.copyValue(behave.get(0), mbehave);
                return new TransData<Object>(true, null, mbehave);
            }
        }
        else if ("3".equals(logType))
        {
            SysLogExample example = new SysLogExample();
            example.setSysLogId(uuid);
            List<SysLog> sys = this.logQueryService.selectSysLog(example, 0, 0);
            if (sys != null && sys.size() > 0)
            {
                MSysLog msys = new MSysLog();
                EntityTools.copyValue(sys.get(0), msys);
                return new TransData<Object>(true, null, msys);
            }
        }
        return null;
    }

    /**
     * 保存日志
     */
    @Override
    public TransData<Object> saveLog(HttpServletRequest request) throws Exception
    {
        return new TransData<Object>(true, null, null);
    }

}
