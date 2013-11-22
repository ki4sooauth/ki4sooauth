package com.gooagoo.core.business.user.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.user.notice.UserNoticeCoreService;
import com.gooagoo.api.generator.core.marketing.MarketingUserLinkGeneratorCoreService;

@Service
public class UserNoticeCoreServiceImpl implements UserNoticeCoreService
{

    @Autowired
    MarketingUserLinkGeneratorCoreService marketingUserLinkGeneratorCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean deleteNotice(String ids) throws Exception
    {
        String[] idArr = ids.split(",");
        for (int i = 0; i < idArr.length; i++)
        {
            if (!this.marketingUserLinkGeneratorCoreService.deleteByPrimaryKey(idArr[i]))
            {
                return false;
            }
        }
        return true;
    }
}
