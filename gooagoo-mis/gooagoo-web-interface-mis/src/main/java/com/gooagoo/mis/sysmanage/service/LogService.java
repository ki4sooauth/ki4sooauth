package com.gooagoo.mis.sysmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.common.MMessageLogQuery;

public interface LogService
{

    /**
     * 消息日志查询
     * @param sysLog
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MMessageLogQuery>> searchLogInfo(HttpServletRequest request) throws Exception;

    /**
     * 查询消息日志详细
     * @param sysLog
     * @return
     * @throws Exception
     */
    public TransData<Object> queryMessageLogInfo(HttpServletRequest request) throws Exception;

    /**
     * 保存系统日志
     * @param sysLog
     * @return
     * @throws Exception
     */
    public TransData<Object> saveLog(HttpServletRequest request) throws Exception;
}
