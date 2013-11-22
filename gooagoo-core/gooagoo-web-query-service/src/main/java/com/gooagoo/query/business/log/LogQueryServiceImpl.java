package com.gooagoo.query.business.log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.log.LogQueryService;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.log.BehaveLogExample;
import com.gooagoo.entity.business.log.MessageLogExample;
import com.gooagoo.entity.business.log.MessageLogQuery;
import com.gooagoo.entity.business.log.MessageLogQuery.LogInfo;
import com.gooagoo.entity.business.log.ShopLog;
import com.gooagoo.entity.business.log.ShopLogExample;
import com.gooagoo.entity.business.log.SysLog;
import com.gooagoo.entity.business.log.SysLogExample;
import com.gooagoo.entity.common.PageModel;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.gmongo.MongoDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Service
public class LogQueryServiceImpl implements LogQueryService
{

    @Override
    public List<BehaveLog> selectBehaveLog(BehaveLogExample behaveLogExample, Integer pageIndex, Integer pageSize)
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.logDB, CollectionConstants.logDB_BehaveLog);

        return dao.findByConditionPage(behaveLogExample, BehaveLog.class, pageIndex, pageSize);
    }

    @Override
    public PageModel<ShopLog> selectShopLog(ShopLogExample shopLogExample, Integer pageIndex, Integer pageSize)
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.logDB, CollectionConstants.logDB_ShopLog);
        PageModel<ShopLog> result = new PageModel<ShopLog>();
        result.setPageIndex(pageIndex);
        result.setPageSize(pageSize);
        result.setResult(dao.findByConditionPage(shopLogExample, ShopLog.class, pageIndex, pageSize));
        result.setCount((int) dao.count(shopLogExample));

        return result;
    }

    @Override
    public List<SysLog> selectSysLog(SysLogExample sysLogExample, Integer pageIndex, Integer pageSize)
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.logDB, CollectionConstants.logDB_SysLog);

        return dao.findByConditionPage(sysLogExample, SysLog.class, pageIndex, pageSize);
    }

    @Override
    public PageModel<MessageLogQuery> selectMessageLogQuery(MessageLogExample example, Integer pageIndex, Integer pageSize)
    {

        DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.logDB, CollectionConstants.logDB_MessageLog);

        DBObject queryOBject = this.assemblyQueryObject(example);

        PageModel<MessageLogQuery> result = new PageModel<MessageLogQuery>();
        DBCursor cursor = null;
        if (pageIndex != null && pageSize != null)
        {
            result.setPageIndex(pageIndex);
            result.setPageSize(pageSize);
            cursor = collection.find(queryOBject).sort(new BasicDBObject("log_info.recetime", -1)).skip(result.getIndex()).limit(pageSize);
        }
        else
        {
            cursor = collection.find(queryOBject).sort(new BasicDBObject("log_info.recetime", -1));
        }
        result.setCount(cursor.count());

        List<DBObject> dbObjects = cursor.toArray();
        cursor.close();
        try
        {
            result.setResult(this.conversToMessageLogQuery(dbObjects));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 拼装查询信息
     * @param example
     * @return
     */
    private DBObject assemblyQueryObject(MessageLogExample example)
    {
        DBObject queryOBject = new BasicDBObject();

        if (StringUtils.hasText(example.getUuid()))
        {
            queryOBject.put("_id", example.getUuid());
        }

        if (StringUtils.hasText(example.getPuuid()))
        {
            queryOBject.put("log_info.puuid", example.getPuuid());
        }

        if (StringUtils.hasText(example.getServer()))
        {
            queryOBject.put("log_info.server", example.getServer());
        }

        if (StringUtils.hasText(example.getLogType()))
        {
            queryOBject.put("log_info.logType", example.getLogType());
        }

        if (StringUtils.hasText(example.getSource()))
        {
            queryOBject.put("log_info.source", example.getSource());
        }

        if (StringUtils.hasText(example.getBehaveCode()))
        {
            queryOBject.put("log_info.behaveCode", example.getBehaveCode());
        }

        if (StringUtils.hasText(example.getBehaveType()))
        {
            queryOBject.put("log_info.behaveType", example.getBehaveType());
        }

        if (example.getRecetime_after() != null && example.getRecetime_before() != null)
        {
            queryOBject.put("log_info.recetime", new BasicDBObject("$gte", example.getRecetime_after()).append("$lte", example.getRecetime_before()));
        }
        else if (example.getRecetime_before() != null)
        {
            queryOBject.put("log_info.recetime", new BasicDBObject("$lte", example.getRecetime_before()));
        }
        else if (example.getRecetime_after() != null)
        {
            queryOBject.put("log_info.recetime", new BasicDBObject("$gte", example.getRecetime_after()));
        }

        if (example.getSendtime_after() != null && example.getSendtime_before() != null)
        {
            queryOBject.put("log_info.sendtime", new BasicDBObject("$gte", example.getSendtime_after()).append("$lte", example.getSendtime_before()));
        }
        else if (example.getSendtime_before() != null)
        {
            queryOBject.put("log_info.sendtime", new BasicDBObject("$lte", example.getSendtime_before()));
        }
        else if (example.getSendtime_after() != null)
        {
            queryOBject.put("log_info.sendtime", new BasicDBObject("$gte", example.getSendtime_after()));
        }

        return queryOBject;
    }

    /**
     * 解析消息日志对象
     * @param cursor
     * @return
     */
    @SuppressWarnings("unchecked")
    private List<MessageLogQuery> conversToMessageLogQuery(List<DBObject> dbObjects) throws Exception
    {
        List<MessageLogQuery> queries = new ArrayList<MessageLogQuery>();
        MessageLogQuery messageLogQuery = null;
        List<LogInfo> LogInfoList = null;

        LogInfo forCompare = new LogInfo();

        for (DBObject dbObject : dbObjects)
        {
            messageLogQuery = new MessageLogQuery();
            LogInfoList = MongoDBUtils.toList((List<DBObject>) dbObject.get("log_info"), LogInfo.class);
            Collections.sort(LogInfoList, forCompare);
            messageLogQuery.setUuid((String) dbObject.get("_id"));
            messageLogQuery.setLogInfos(LogInfoList);
            queries.add(messageLogQuery);
        }
        return queries;
    }
}
