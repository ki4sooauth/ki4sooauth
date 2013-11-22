package com.gooagoo.current.sub.tidy;

import java.util.Date;
import java.util.List;

import com.gooagoo.api.generator.query.member.MemberBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.intelligence.utils.StringUtils;
import com.mongodb.BasicDBObject;

@Message(DispatcherConstants.applyMember)
public class AnalysisApplyPhysics implements Customer
{

    @Override
    public void message(Object message)
    {
        UUID.getUUID();
        BehaveLog behaveLog = (BehaveLog) message;
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_APPLYPHYSICS);

        BasicDBObject basicDBObject = new BasicDBObject();
        String shopId = behaveLog.getShopId();
        basicDBObject.put("_id", UUID.getUUID());
        basicDBObject.put("shopId", shopId);
        basicDBObject.put("userId", behaveLog.getUserId());
        basicDBObject.put("timestamp", new Date());
        basicDBObject.put("source", behaveLog.getSource());
        String phyNo = behaveLog.getObjectValue();
        if (StringUtils.hasText(shopId, phyNo))
        {
            String cardName = getCardName(shopId, phyNo);
            if (StringUtils.hasText(cardName))
            {
                String cardId = getCardId(shopId, cardName);
                basicDBObject.put("cardId", cardId);
                mongoDao.insert(basicDBObject);
            }
        }
    }

    private String getCardId(String shopId, String cardName)
    {
        MemberCardGeneratorQueryService memberCardService = SpringBeanUtils.getBean(MemberCardGeneratorQueryService.class);
        MemberCardExample example = new MemberCardExample();
        example.createCriteria().andShopIdEqualTo(shopId).andCardNameEqualTo(cardName);
        List<MemberCard> memberCards = memberCardService.selectByExample(example);
        if (memberCards != null && memberCards.size() > 0)
        {
            return memberCards.get(0).getCardId();
        }
        return null;
    }

    private String getCardName(String shopId, String phyNo)
    {
        MemberBaseInfoGeneratorQueryService memberBaseInfoService = SpringBeanUtils.getBean(MemberBaseInfoGeneratorQueryService.class);
        MemberBaseInfoExample example = new MemberBaseInfoExample();
        example.createCriteria().andShopIdEqualTo(shopId).andPhyNoEqualTo(phyNo).andIsDelEqualTo("N");
        List<MemberBaseInfo> memberBaseInfos = memberBaseInfoService.selectByExample(example);
        if (memberBaseInfos != null && memberBaseInfos.size() > 0)
        {
            return memberBaseInfos.get(0).getPhyName();
        }
        return null;
    }
}
