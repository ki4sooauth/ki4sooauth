package com.gooagoo.core.business.behave.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import com.gooagoo.api.business.core.behave.mobile.ProcessUserbehave;
import com.gooagoo.api.generator.core.marketing.MarketingUserLinkGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.marketing.MarketingUserLink;

@Service
public class ProcessUserbehaveImpl implements ProcessUserbehave
{

    @Autowired
    private MarketingUserLinkGeneratorCoreService marketingUserLinkGeneratorCoreService;

    @Override
    public boolean processUserMobileBehave(String behavior) throws Exception
    {
        if (StringUtils.isBlank(behavior))
        {
            return false;
        }
        String[] behaviorArr = behavior.split("\\|");
        String behaveId = behaviorArr[1];
        //商品和优惠券直接返回true
        if ("01".equals(behavior) || "02".equals(behavior))
        {
            return true;
        }
        MarketingUserLink marketingUserLink = new MarketingUserLink();
        marketingUserLink.setId(behaveId);
        marketingUserLink.setIsRead("Y");
        if (this.marketingUserLinkGeneratorCoreService.updateByPrimaryKeySelective(marketingUserLink))
        {
            GooagooLog.error("营销内容与用户关联表为空[id=" + behaveId + "]", null);
            return false;
        }
        return true;
    }

}
