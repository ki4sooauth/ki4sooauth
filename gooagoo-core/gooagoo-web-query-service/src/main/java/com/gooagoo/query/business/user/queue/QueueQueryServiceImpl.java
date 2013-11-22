package com.gooagoo.query.business.user.queue;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.user.queue.QueueQueryService;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.log.ShopLog;

/**
 * 排号
 */
@Service
public class QueueQueryServiceImpl implements QueueQueryService
{

    @Override
    public void RefreshQueueNo() throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void findQueueRecord() throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public String removeQueueNo(ShopLog shopLog) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getQueueNo(BehaveLog behaveLog) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
