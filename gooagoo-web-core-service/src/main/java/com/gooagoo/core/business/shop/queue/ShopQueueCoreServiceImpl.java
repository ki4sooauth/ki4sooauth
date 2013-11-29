package com.gooagoo.core.business.shop.queue;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.shop.queue.ShopQueueCoreService;
import com.gooagoo.api.generator.core.behave.UserStoreQueueGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.behave.UserStoreQueue;
import com.gooagoo.entity.generator.behave.UserStoreQueueExample;

@Service
public class ShopQueueCoreServiceImpl implements ShopQueueCoreService
{

    @Autowired
    UserStoreQueueGeneratorCoreService userStoreQueueGeneratorCoreService;

    @Override
    public boolean deleteQueueNo(String shopEntityId, String queueNo) throws Exception
    {
        UserStoreQueueExample userStoreQueueExample = new UserStoreQueueExample();
        userStoreQueueExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andQueueNoEqualTo(queueNo).andIsDelEqualTo("N").andIsEliminationEqualTo("N");
        userStoreQueueExample.setOrderByClause("c_time_stamp desc");
        List<UserStoreQueue> userStoreQueueList = this.userStoreQueueGeneratorCoreService.selectByExample(userStoreQueueExample);
        if (CollectionUtils.isEmpty(userStoreQueueList))//用户不存在
        {
            GooagooLog.warn("实体店编号:" + shopEntityId + "排号:" + queueNo + "对应的排队信息不存在");
            return false;
        }
        UserStoreQueue userStoreQueue = userStoreQueueList.get(0);
        userStoreQueue.setIsElimination("Y");
        return this.userStoreQueueGeneratorCoreService.updateByPrimaryKeySelective(userStoreQueue);
    }

}
