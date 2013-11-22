package com.googoo.batch.dispatcher.analysis;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.googoo.batch.constants.BatchTimeCnstants;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Engine(BatchTimeCnstants.everyHour)
public class UserBehavior implements Tyre
{
    MongoDao mdao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_USER_BEHAVIOR);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 UserBehavior");
        /*0   消费
        1   到店
        2   到达区域
        3   关注
        4   申请会员卡
        5   申请物理卡转换
        6   评论
        7   留言
        8   收藏
        9   浏览
        A   使用服务
        B   分享
        C   兑换
        D   下订单
        E   申请结帐*/

        Date endDate = Calendar.getInstance().getTime();

        //到店形为
        this.arrivalShop(endDate);
        this.arrivalArea(endDate);
        this.comment(endDate);
        this.favorites(endDate);
        this.browse(endDate);
        this.useTools(endDate);

        this.updateLog(endDate);
    }

    private void arrivalShop(Date endDate)
    {
        MongoDao queryDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_ARRIVAL_SHOP);

        List<BasicDBObject> list = queryDao.findByCondition(this.getBasicQuery2(endDate), BasicDBObject.class);
        for (BasicDBObject record : list)
        {
            BasicDBObject obj = new BasicDBObject("type", "1").append("date", record.getString("end")).append("info_source", "").append("ip", "");
            DBObject behaviors = new BasicDBObject("behavior", obj);
            DBObject updateQuery = new BasicDBObject("$push", behaviors);

            BasicDBObject query = new BasicDBObject();
            query.append("_id", record.getString("shopId") + "_" + record.getString("userId"));
            query.append("user_id", record.getString("userId"));
            this.mdao.update(query, updateQuery);
        }
    }

    private void arrivalArea(Date endDate)
    {
        MongoDao queryDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_ARRIVAL_AREA);

        List<BasicDBObject> list = queryDao.findByCondition(this.getBasicQuery(endDate), BasicDBObject.class);
        for (BasicDBObject record : list)
        {
            BasicDBObject obj = new BasicDBObject("type", "2").append("date", record.getString("end")).append("info_source", "").append("ip", "");
            DBObject behaviors = new BasicDBObject("behavior", obj);
            DBObject updateQuery = new BasicDBObject("$push", behaviors);

            BasicDBObject query = new BasicDBObject();
            query.append("_id", record.getString("shopId") + "_" + record.getString("userId"));
            query.append("user_id", record.getString("userId"));
            this.mdao.update(query, updateQuery);
        }
    }

    private void comment(Date endDate)
    {
        MongoDao queryDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_COMMENT);

        List<BasicDBObject> list = queryDao.findByCondition(this.getBasicQuery(endDate), BasicDBObject.class);
        for (BasicDBObject record : list)
        {
            BasicDBObject obj = new BasicDBObject("type", "6").append("date", record.getString("timestamp")).append("info_source", record.getString("source")).append("ip", "");
            DBObject behaviors = new BasicDBObject("behavior", obj);
            DBObject updateQuery = new BasicDBObject("$push", behaviors);

            BasicDBObject query = new BasicDBObject();
            query.append("_id", record.getString("shopId") + "_" + record.getString("userId"));
            query.append("user_id", record.getString("userId"));
            this.mdao.update(query, updateQuery);
        }
    }

    private void favorites(Date endDate)
    {
        MongoDao queryDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_FAVORITES);

        List<BasicDBObject> list = queryDao.findByCondition(this.getBasicQuery(endDate), BasicDBObject.class);
        for (BasicDBObject record : list)
        {
            BasicDBObject obj = new BasicDBObject("type", "8").append("date", record.getString("timestamp")).append("info_source", record.getString("source")).append("ip", "");
            DBObject behaviors = new BasicDBObject("behavior", obj);
            DBObject updateQuery = new BasicDBObject("$push", behaviors);

            BasicDBObject query = new BasicDBObject();
            query.append("_id", record.getString("shopId") + "_" + record.getString("userId"));
            query.append("user_id", record.getString("userId"));
            this.mdao.update(query, updateQuery);
        }
    }

    private void browse(Date endDate)
    {
        MongoDao queryDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BROWSE);

        List<BasicDBObject> list = queryDao.findByCondition(this.getBasicQuery(endDate), BasicDBObject.class);
        for (BasicDBObject record : list)
        {
            BasicDBObject obj = new BasicDBObject("type", "9").append("date", record.getString("timestamp")).append("info_source", record.getString("source")).append("ip", record.getString("ip"));
            DBObject behaviors = new BasicDBObject("behavior", obj);
            DBObject updateQuery = new BasicDBObject("$push", behaviors);

            BasicDBObject query = new BasicDBObject();
            query.append("_id", record.getString("shopId") + "_" + record.getString("userId"));
            query.append("user_id", record.getString("userId"));
            this.mdao.update(query, updateQuery);
        }
    }

    private void useTools(Date endDate)
    {
        MongoDao queryDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_TOOLS);

        List<BasicDBObject> list = queryDao.findByCondition(this.getBasicQuery(endDate), BasicDBObject.class);
        for (BasicDBObject record : list)
        {
            BasicDBObject obj = new BasicDBObject("type", "A").append("date", record.getString("timestamp")).append("info_source", "").append("ip", "");
            DBObject behaviors = new BasicDBObject("behavior", obj);
            DBObject updateQuery = new BasicDBObject("$push", behaviors);

            BasicDBObject query = new BasicDBObject();
            query.append("_id", record.getString("shopId") + "_" + record.getString("userId"));
            query.append("user_id", record.getString("userId"));
            this.mdao.update(query, updateQuery);
        }
    }

    private BasicDBObject getBasicQuery(Date endDate)
    {
        BasicDBObject basicQuery = new BasicDBObject();
        if (this.getLastUpdate() != null)
        {
            basicQuery.append("timestamp", new BasicDBObject("$gte", this.getLastUpdate()));
        }
        basicQuery.append("timestamp", new BasicDBObject("$lt", endDate));
        return basicQuery;
    }

    private BasicDBObject getBasicQuery2(Date endDate)
    {
        BasicDBObject basicQuery = new BasicDBObject();
        if (this.getLastUpdate() != null)
        {
            basicQuery.append("end", new BasicDBObject("$gte", this.getLastUpdate()));
        }
        basicQuery.append("end", new BasicDBObject("$lt", endDate));
        return basicQuery;
    }

    private Date getLastUpdate()
    {
        MongoDao logDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_UPDATE_LOG);
        BasicDBObject obj = logDao.findOne(new BasicDBObject("tb_name", CollectionConstants.ANLS_USER_BEHAVIOR));
        if (obj != null)
        {
            return (Date) obj.get("last_update");
        }
        return null;
    }

    private void updateLog(Date date)
    {
        MongoDao logDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_UPDATE_LOG);
        logDao.update(new BasicDBObject("tb_name", CollectionConstants.ANLS_USER_BEHAVIOR), new BasicDBObject("tb_name", CollectionConstants.ANLS_USER_BEHAVIOR).append("last_update", date));
    }
}
