package com.gooagoo.core.business.log;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.log.LogInsertService;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.log.MessageLog;
import com.gooagoo.entity.business.log.ShopLog;
import com.gooagoo.entity.business.log.SysLog;
import com.gooagoo.gmongo.MongoDao;
import com.mongodb.BasicDBObject;

@Service
public class LogInsertServiceImpl implements LogInsertService
{

    @Override
    public void insertBehaveLog(BehaveLog behaveLog)
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.logDB, CollectionConstants.logDB_BehaveLog);

        dao.insertEntity(behaveLog);
    }

    @Override
    public void insertShopLog(ShopLog shopLog)
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.logDB, CollectionConstants.logDB_ShopLog);

        dao.insertEntity(shopLog);
    }

    @Override
    public void insertSysLog(SysLog sysLog)
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.logDB, CollectionConstants.logDB_SysLog);

        dao.insertEntity(sysLog);
    }

    @Override
    public boolean insertMessageLog(MessageLog log)
    {
        try
        {
            MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.logDB, CollectionConstants.logDB_MessageLog);
            BasicDBObject query = new BasicDBObject("_id", log.getUuid());
            BasicDBObject obj = new BasicDBObject("server", log.getServer());
            obj.append("recetime", log.getRecetime());
            obj.append("sendtime", log.getSendtime());
            if (StringUtils.hasText(log.getException()))
            {
                obj.append("exception", log.getException());
            }
            if (StringUtils.hasText(log.getPuuid()))
            {
                obj.append("puuid", log.getPuuid());
            }
            dao.update(query, new BasicDBObject("$push", new BasicDBObject("log_info", obj)));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
