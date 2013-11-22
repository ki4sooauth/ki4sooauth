package com.gooagoo.current.sub.tidy;

import com.gooagoo.api.generator.query.marketing.NoticeInfoGeneratorQueryService;
import com.gooagoo.bi.entity.analysisUser.AnalysisAccount;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.MongoAccountUtils;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.generator.marketing.NoticeInfo;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.intelligence.utils.StringUtils;
import com.mongodb.BasicDBObject;

@Message(DispatcherConstants.browse)
public class BrowseNoticeForAccount implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 BrowseNotice");
        BehaveLog behaveLog = (BehaveLog) message;
        String ids = behaveLog.getObjectValue();
        if ("N".equals(behaveLog.getObjectType()))
        {
            MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_ACCOUNT);

            NoticeInfoGeneratorQueryService noticeInfoService = SpringBeanUtils.getBean(NoticeInfoGeneratorQueryService.class);
            String[] arrIds = ids.split(",");
            for (String noticeId : arrIds)
            {
                NoticeInfo noticeInfo = noticeInfoService.selectByPrimaryKey(noticeId);
                String shopId = noticeInfo.getShopId();
                BasicDBObject dbObject = new BasicDBObject();
                dbObject.put("userId", behaveLog.getUserId());
                dbObject.put("ip", behaveLog.getIpAddress());
                dbObject.put("mac", behaveLog.getMacAddress());
                dbObject.put("shopId", shopId);

                if (StringUtils.hasText(behaveLog.getUserId()))
                {
                    String id = shopId + "_0_" + behaveLog.getUserId();
                    if (!mongoDao.isIdExist(id))
                    {
                        dbObject.put("_id", id);
                        mongoDao.insert(dbObject);
                    }
                }
                if (StringUtils.hasText(behaveLog.getIpAddress()))
                {
                    String id = shopId + "_2_" + behaveLog.getIpAddress();
                    if (!mongoDao.isIdExist(id))
                    {
                        dbObject.put("_id", id);
                        mongoDao.insert(dbObject);
                    }
                }
                if (StringUtils.hasText(behaveLog.getMacAddress()))
                {
                    MongoAccountUtils accountUtils = new MongoAccountUtils();
                    AnalysisAccount account = accountUtils.buildByMac(shopId, behaveLog.getMacAddress());
                    accountUtils.save(account);
                }

            }
        }
    }
}
