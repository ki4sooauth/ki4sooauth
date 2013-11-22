package com.googoo.batch.dispatcher.analysis;

import java.util.List;

import com.gooagoo.api.generator.query.member.MemberFeatureGeneratorQueryService;
import com.gooagoo.entity.generator.member.MemberFeature;
import com.gooagoo.entity.generator.member.MemberFeatureExample;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.googoo.batch.constants.BatchTimeCnstants;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

@Engine(BatchTimeCnstants.everyHalfhour)
public class AnalysisTypeBatch implements Tyre
{
    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 AnalysisTypeBatch");
        MemberFeatureGeneratorQueryService memberFeatureService = SpringBeanUtils.getBean(MemberFeatureGeneratorQueryService.class);
        MemberFeatureExample example = new MemberFeatureExample();
        example.createCriteria().andShopIdIsNotNull().andTypeCodeIsNotNull().andTypeNameIsNotNull();
        List<MemberFeature> result = memberFeatureService.selectByExample(example);

        GooagooLog.debug("resutl size:" + result.size());

        DBCollection coll = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_TYPE);

        if (result != null)
        {
            BasicDBObject query = null;
            BasicDBObject newObj = null;
            for (MemberFeature obj : result)
            {
                query = new BasicDBObject();
                query.append("corp_id", obj.getShopId());
                query.append("type_code", obj.getTypeCode());

                newObj = new BasicDBObject("_id", obj.getId()).append("corp_id", obj.getShopId());
                newObj.append("type_code", obj.getTypeCode()).append("type_name", obj.getTypeName()).append("is_del", obj.getIsDel());

                GooagooLog.debug(newObj);
                coll.update(query, newObj, true, false);
            }
        }
    }
}
