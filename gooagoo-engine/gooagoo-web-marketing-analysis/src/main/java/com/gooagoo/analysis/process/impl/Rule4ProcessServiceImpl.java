package com.gooagoo.analysis.process.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.analysis.common.utils.MarketingUtils;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.process.service.ProcessCommonService;
import com.gooagoo.analysis.process.service.ProcessService;
import com.gooagoo.api.business.query.user.query.UserAccountQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingUserLinkGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.ShortMessageGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.ShortMessage;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.push.Message;

/**
 *短信
 */
@Service("rule4ProcessService")
public class Rule4ProcessServiceImpl implements ProcessService
{
    @Autowired
    ProcessCommonService processCommonService;
    @Autowired
    private ShortMessageGeneratorQueryService shortMessageGeneratorQueryService;
    @Autowired
    private MarketingUserLinkGeneratorQueryService marketingUserLinkGeneratorQueryService;
    @Autowired
    private UserAccountQueryService userAccountQueryService;
    @Autowired
    private UserInfoGeneratorQueryService userInfoGeneratorQueryService;

    @SuppressWarnings("unchecked")
    @Override
    public MarketingNotice<GooagooMessage<Message>> doProcess(RuleInfo ruleInfo, Behave behave) throws Exception
    {
        GooagooMessage<Message> gooagooMessage = MarketingUtils.getGooagooMessageMessage(behave);
        if (this.processCommonService.processMarketingUserLink(behave, ruleInfo))
        {
            //查询短信内容
            ShortMessage shortMessage = this.shortMessageGeneratorQueryService.selectByPrimaryKey(behave.getObjectValue());
            //查询用户群
            List<MarketingUserLink> marketingUserLinks = this.getUserListByCode(behave.getObjectValue());
            List<String> mob = new ArrayList<String>();
            for (MarketingUserLink marketingUserLink : marketingUserLinks)
            {
                //查询用户手机号码
                String userId = this.userAccountQueryService.queryUserIdFromUserAccount(marketingUserLink.getAccountType(), marketingUserLink.getAccount());
                UserInfo userInfo = this.userInfoGeneratorQueryService.selectByPrimaryKey(userId);
                if (userInfo == null)
                {
                    continue;
                }
                String mobile = userInfo.getMobile();
                if (!StringUtils.hasText(mobile))
                {
                    GooagooLog.warn("短信（rule4ProcessService）方法中，mobile为null，accountType=" + marketingUserLink.getAccountType() + ";account=" + marketingUserLink.getAccount());
                    continue;
                }
                mob.add(mobile);
            }
            Message msg = MarketingUtils.getMessage(behave);
            msg.setSmsMob(mob);//手机号码
            msg.setSmsText(shortMessage.getContent());//短信内容
            gooagooMessage.setContent(msg);
            return (MarketingNotice<GooagooMessage<Message>>) MarketingUtils.getMarketingNotice("message", gooagooMessage);
        }
        return null;
    }

    private List<MarketingUserLink> getUserListByCode(String code)
    {
        MarketingUserLinkExample marketingUserLinkExample = new MarketingUserLinkExample();
        marketingUserLinkExample.createCriteria().andMarketingIdEqualTo(code).andIsPushedEqualTo("Y").andIsDelEqualTo("N");
        List<MarketingUserLink> marketingUserLinkList = this.marketingUserLinkGeneratorQueryService.selectByExample(marketingUserLinkExample);
        return marketingUserLinkList;
    }
}
