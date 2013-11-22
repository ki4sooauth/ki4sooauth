package com.gooagoo.api.business.query.log;

import java.util.List;

import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.log.BehaveLogExample;
import com.gooagoo.entity.business.log.MessageLogExample;
import com.gooagoo.entity.business.log.MessageLogQuery;
import com.gooagoo.entity.business.log.ShopLog;
import com.gooagoo.entity.business.log.ShopLogExample;
import com.gooagoo.entity.business.log.SysLog;
import com.gooagoo.entity.business.log.SysLogExample;
import com.gooagoo.entity.common.PageModel;

public interface LogQueryService
{
    public List<BehaveLog> selectBehaveLog(BehaveLogExample behaveLogExample, Integer pageIndex, Integer pageSize);

    public PageModel<ShopLog> selectShopLog(ShopLogExample shopLogExample, Integer pageIndex, Integer pageSize);

    public List<SysLog> selectSysLog(SysLogExample sysLogExample, Integer pageIndex, Integer pageSize);

    /**
     * 分页查询消息日志信息
     * @param messageLogExample 不能为空
     * @param pageIndex 当前是第几页 从1开始   此属性和pageSize只要有一个为null(同时为0也可)即查全部   以后若要统一 再调整
     * @param pageSize 每页多少条
     * @return PageModel<MessageLogQuery>
     */
    public PageModel<MessageLogQuery> selectMessageLogQuery(MessageLogExample messageLogExample, Integer pageIndex, Integer pageSize);

}
