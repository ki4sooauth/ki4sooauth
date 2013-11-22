package com.googoo.batch.dispatcher.analysis;

import java.util.List;

import com.gooagoo.api.generator.query.user.UserMobileInfoGeneratorQueryService;
import com.gooagoo.entity.generator.user.UserMobileInfo;
import com.gooagoo.entity.generator.user.UserMobileInfoExample;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.googoo.batch.constants.BatchTimeCnstants;
import com.googoo.batch.utils.MobileMac;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

@Engine(BatchTimeCnstants.everyHour)
public class UserInfoGroupByPhoneBrand implements Tyre
{
    UserMobileInfoGeneratorQueryService userMobileInfoService = SpringBeanUtils.getBean(UserMobileInfoGeneratorQueryService.class);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 UserInfoGroupByPhoneBrand");
        UserMobileInfoExample example = new UserMobileInfoExample();
        example.createCriteria().andMacAddressIsNotNull().andUserIdIsNotNull();
        List<UserMobileInfo> umList = this.userMobileInfoService.selectByExample(example);

        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_USER_BY_BASIC);

        if (umList != null)
        {
            for (UserMobileInfo um : umList)
            {
                BasicDBObject query = new BasicDBObject();
                query.append("_id", um.getUserId());

                BasicDBObject bo = new BasicDBObject(query).append("_id", um.getUserId()).append("mac_address", um.getMacAddress());
                bo.append("brand", MobileMac.getBrand(um.getMacAddress()));

                coll.update(query, bo, true, false);
            }
        }
    }
}
