package com.gooagoo.analysis.process.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.analysis.common.utils.FileUtil;
import com.gooagoo.analysis.common.utils.MarketingUtils;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.process.service.ProcessCommonService;
import com.gooagoo.analysis.process.service.ProcessService;
import com.gooagoo.api.business.query.user.query.UserAccountQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingEventGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingUserLinkGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.marketing.MarketingEvent;
import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.push.EmailVo;

/**
 * 邮件
 */
@Service("rule3ProcessService")
public class Rule3ProcessServiceImpl implements ProcessService
{
    @Autowired
    ProcessCommonService processCommonService;
    @Autowired
    private MarketingEventGeneratorQueryService marketingEventGeneratorQueryService;
    @Autowired
    private MarketingUserLinkGeneratorQueryService marketingUserLinkGeneratorQueryService;
    @Autowired
    private UserAccountQueryService userAccountQueryService;
    @Autowired
    private UserInfoGeneratorQueryService userInfoGeneratorQueryService;

    @SuppressWarnings("unchecked")
    @Override
    public MarketingNotice<GooagooMessage<EmailVo>> doProcess(RuleInfo ruleInfo, Behave behave) throws Exception
    {
        GooagooMessage<EmailVo> gooagooMessage = MarketingUtils.getGooagooMessageEmailVo(behave);
        if (this.processCommonService.processMarketingUserLink(behave, ruleInfo))
        {
            //根据事件编号查询事件信息
            MarketingEvent marketingEvent = this.marketingEventGeneratorQueryService.selectByPrimaryKey(behave.getObjectValue());
            //邮件内容
            String emailContent = FileUtil.readEmailHtml(behave.getObjectValue(), FileUtil.defaultCharset);
            List<MarketingUserLink> marketingUserLinks = this.getUserListByCode(behave.getObjectValue());
            List<String> to = new ArrayList<String>();
            for (MarketingUserLink marketingUserLink : marketingUserLinks)
            {
                String userId = this.userAccountQueryService.queryUserIdFromUserAccount(marketingUserLink.getAccountType(), marketingUserLink.getAccount());
                UserInfo userInfo = this.userInfoGeneratorQueryService.selectByPrimaryKey(userId);
                if (userInfo == null)
                {
                    continue;
                }
                String emailAddress = userInfo.getEmail();
                if (!StringUtils.hasText(emailAddress))
                {
                    GooagooLog.warn("邮件(rule3ProcessService)方法中，emailAddress为null，accountType=" + marketingUserLink.getAccountType() + ";account=" + marketingUserLink.getAccount());
                    continue;
                }
                to.add(emailAddress);
            }
            EmailVo email = MarketingUtils.getEmailVo(behave);
            email.setTo(to);//接收者邮件地址
            email.setSubject(marketingEvent.getEventName());//邮件主题
            email.setText(emailContent);//邮件内容
            gooagooMessage.setContent(email);
            return (MarketingNotice<GooagooMessage<EmailVo>>) MarketingUtils.getMarketingNotice("email", gooagooMessage);
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
