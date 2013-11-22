package com.googoo.batch.dispatcher.cache;

import java.util.List;

import com.gooagoo.api.generator.query.member.MemberBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberFeatureInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfoExample;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.googoo.batch.constants.BatchTimeCnstants;
import com.googoo.batch.utils.Timestamp;
import com.mongodb.BasicDBObject;

@Engine(BatchTimeCnstants.everyMinutes)
public class AccountFeature implements Tyre
{
    MemberFeatureInfoGeneratorQueryService featureService = SpringBeanUtils.getBean(MemberFeatureInfoGeneratorQueryService.class);
    MemberOfCardGeneratorQueryService memberOfCardService = SpringBeanUtils.getBean(MemberOfCardGeneratorQueryService.class);
    MemberBaseInfoGeneratorQueryService memberBaseService = SpringBeanUtils.getBean(MemberBaseInfoGeneratorQueryService.class);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 AccountFeature");
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_ACCOUNT);
        int page = 1;
        int pageSize = 1000;
        MemberFeatureInfoExample example = new MemberFeatureInfoExample();
        example.createCriteria().andCTimeStampGreaterThanOrEqualTo(Timestamp.lastTime(Timestamp.MEMBERFEATURE));
        while (true)
        {
            example.setPage(page, pageSize);
            List<MemberFeatureInfo> members = this.featureService.selectByExample(example);
            GooagooLog.debug("AccountFeature 查出的数据条目:" + members.size());
            for (MemberFeatureInfo feature : members)
            {

                BasicDBObject attribute = new BasicDBObject("feature." + feature.getFeatureCode(), feature.getFeatureValue());
                BasicDBObject basicDBObject = new BasicDBObject().append("$set", attribute);

                String key = feature.getShopId() + "_0_" + feature.getUserId();
                BasicDBObject query = new BasicDBObject();
                query.put("_id", key);
                mongoDao.update(query, basicDBObject);

                MemberOfCard moc = this.getMemberOfCard(feature.getUserId(), feature.getShopId());
                if (moc != null)
                {
                    key = moc.getShopId() + "_6_" + moc.getScardno();
                    query.put("_id", key);
                    mongoDao.update(query, basicDBObject);

                    key = moc.getShopId() + "_7_" + moc.getPhyCardNo();
                    query.put("_id", key);
                    mongoDao.update(query, basicDBObject);

                    MemberBaseInfo baseInfo = this.getMemberBaseInfo(moc.getPhyCardNo());
                    if (baseInfo != null)
                    {
                        key = moc.getShopId() + "_5_" + baseInfo.getMobile();
                        query.put("_id", key);
                        mongoDao.update(query, basicDBObject);
                    }
                }
            }
            page++;
            if (pageSize > members.size())
            {
                break;
            }
        }
    }

    private MemberOfCard getMemberOfCard(String userId, String shopId)
    {
        MemberOfCardExample example = new MemberOfCardExample();
        example.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        List<MemberOfCard> memberOfCards = this.memberOfCardService.selectByExample(example);
        if (memberOfCards != null && memberOfCards.size() > 0)
        {
            return memberOfCards.get(0);
        }
        return null;
    }

    private MemberBaseInfo getMemberBaseInfo(String phyCardNo)
    {
        MemberBaseInfoExample example = new MemberBaseInfoExample();
        example.createCriteria().andPhyNoEqualTo(phyCardNo).andIsDelEqualTo("N");
        List<MemberBaseInfo> memberBaseInfos = this.memberBaseService.selectByExample(example);
        if (memberBaseInfos != null && memberBaseInfos.size() > 0)
        {
            return memberBaseInfos.get(0);
        }
        return null;
    }
}
