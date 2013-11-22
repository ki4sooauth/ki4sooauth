package com.googoo.batch.dispatcher.analysis;

import java.util.List;

import com.gooagoo.api.generator.query.member.MemberFeatureInfoGeneratorQueryService;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfoExample;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.googoo.batch.constants.BatchTimeCnstants;
import com.googoo.batch.utils.AnalysisUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

@Engine(BatchTimeCnstants.everyHour)
public class UserAnlsGroupByFeature implements Tyre
{
    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 UserAnlsGroupByFeature");
        MemberFeatureInfoGeneratorQueryService memberFeatureInfoService = SpringBeanUtils.getBean(MemberFeatureInfoGeneratorQueryService.class);
        MemberFeatureInfoExample example = new MemberFeatureInfoExample();
        example.createCriteria().andFeatureValueIsNotNull();
        List<MemberFeatureInfo> memberList = memberFeatureInfoService.selectByExample(example);

        GooagooLog.debug("memberList size:" + memberList.size());

        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_USER_BY_FEATURE);

        if (memberList != null)
        {
            BasicDBObject query = new BasicDBObject();
            for (MemberFeatureInfo member : memberList)
            {
                String _id = member.getShopId() + "_" + member.getUserId();
                query.append("_id", _id);

                BasicDBObject newObj = new BasicDBObject(query).append("corp_id", member.getShopId()).append("user_id", member.getUserId());
                newObj.append("feature", new BasicDBObject(AnalysisUtils.generateFeatureCode(member.getFeatureCode()), member.getFeatureValue()));

                GooagooLog.debug(newObj);
                coll.update(query, newObj, true, false);
            }
        }
    }
}
