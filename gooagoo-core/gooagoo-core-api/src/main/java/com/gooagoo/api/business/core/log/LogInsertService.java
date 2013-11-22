package com.gooagoo.api.business.core.log;

import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.log.MessageLog;
import com.gooagoo.entity.business.log.ShopLog;
import com.gooagoo.entity.business.log.SysLog;

public interface LogInsertService
{
    public void insertBehaveLog(BehaveLog behaveLog);

    public void insertShopLog(ShopLog shopLog);

    public void insertSysLog(SysLog sysLog);

    public boolean insertMessageLog(MessageLog log);
}
