package com.googoo.batch.dispatcher.analysis;

import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.mongodb.BasicDBObject;

public class InitTypeGenerator
{
    public void init()
    {
        GooagooLog.debug("初始化统计类型");
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_TYPE);
        BasicDBObject ob1 = new BasicDBObject();
        ob1.put("_id", "1");
        ob1.put("type_code", "sys001");
        ob1.put("type_name", "手机品牌");
        mongoDao.save(ob1);
        BasicDBObject ob2 = new BasicDBObject();
        ob2.put("_id", "2");
        ob2.put("type_code", "sys002");
        ob2.put("type_name", "年龄段");
        mongoDao.save(ob2);
        BasicDBObject ob3 = new BasicDBObject();
        ob3.put("_id", "3");
        ob3.put("type_code", "sys003");
        ob3.put("type_name", "购物周期");
        mongoDao.save(ob3);
        BasicDBObject ob4 = new BasicDBObject();
        ob4.put("_id", "4");
        ob4.put("type_code", "sys004");
        ob4.put("type_name", "购买转化率");
        mongoDao.save(ob4);
        BasicDBObject ob5 = new BasicDBObject();
        ob5.put("_id", "5");
        ob5.put("type_code", "sys005");
        ob5.put("type_name", "到店频率");
        mongoDao.save(ob5);
        BasicDBObject ob6 = new BasicDBObject();
        ob6.put("_id", "6");
        ob6.put("type_code", "sys006");
        ob6.put("type_name", "平均客单价");
        mongoDao.save(ob6);
        BasicDBObject ob7 = new BasicDBObject();
        ob7.put("_id", "7");
        ob7.put("type_code", "sys007");
        ob7.put("type_name", "优惠浏览频次");
        mongoDao.save(ob7);
        BasicDBObject ob8 = new BasicDBObject();
        ob8.put("_id", "8");
        ob8.put("type_code", "sys008");
        ob8.put("type_name", "手机互动频次");
        mongoDao.save(ob8);
        BasicDBObject ob9 = new BasicDBObject();
        ob9.put("_id", "9");
        ob9.put("type_code", "sys009");
        ob9.put("type_name", "吆喝打开频次");
        mongoDao.save(ob9);
        BasicDBObject ob10 = new BasicDBObject();
        ob10.put("_id", "10");
        ob10.put("type_code", "sys010");
        ob10.put("type_name", "优惠收藏频次");
        mongoDao.save(ob10);
        BasicDBObject ob11 = new BasicDBObject();
        ob11.put("_id", "11");
        ob11.put("type_code", "sys011");
        ob11.put("type_name", "吆喝响应时间");
        mongoDao.save(ob11);
        BasicDBObject ob12 = new BasicDBObject();
        ob12.put("_id", "12");
        ob12.put("type_code", "sys012");
        ob12.put("type_name", "通知响应时间");
        mongoDao.save(ob12);
        BasicDBObject ob13 = new BasicDBObject();
        ob13.put("_id", "13");
        ob13.put("type_code", "sys013");
        ob13.put("type_name", "收藏对象品类");
        mongoDao.save(ob13);
        BasicDBObject ob14 = new BasicDBObject();
        ob14.put("_id", "14");
        ob14.put("type_code", "sys014");
        ob14.put("type_name", "历史消费品类");
        mongoDao.save(ob14);
    }

    public static void main(String[] args)
    {
        InitTypeGenerator i = new InitTypeGenerator();
        i.init();
    }
    /*
     sys001,手机品牌
    sys002,年龄段
    sys003,购物周期
    sys004,购买转化率
    sys005,到店频率
    sys006,平均客单价
    sys007,优惠浏览频次
    sys008,手机互动频次
    sys009,吆喝打开频次
    sys010,优惠收藏频次
    sys011,吆喝响应时间
    sys012,通知响应时间
    sys013,收藏对象品类
    sys014,历史消费品类
     */
}
