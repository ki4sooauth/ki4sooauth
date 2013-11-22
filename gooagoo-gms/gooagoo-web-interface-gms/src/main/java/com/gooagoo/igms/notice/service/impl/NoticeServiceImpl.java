package com.gooagoo.igms.notice.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.marketing.notice.NoticeCoreService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.NoticeInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSServiceUtil;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.NoticeInfo;
import com.gooagoo.entity.generator.marketing.NoticeInfoExample;
import com.gooagoo.entity.generator.marketing.NoticeInfoExample.Criteria;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.common.utils.ReleaseUtil;
import com.gooagoo.igms.notice.service.NoticeService;
import com.gooagoo.igms.userAccount.service.UserAccountService;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.notice.FNotice;
import com.gooagoo.view.gms.rule.FRuleInfo;

@Service(value = "noticeService")
public class NoticeServiceImpl implements NoticeService
{
    @Autowired
    private NoticeInfoGeneratorQueryService noticeInfoGeneratorQueryService;
    @Autowired
    private NoticeCoreService noticeCoreService;
    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private MarketingActivityGeneratorQueryService marketingActivityGeneratorQueryService;

    /**
     * 添加通知
     */
    @Override
    public TransData<Object> add(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FNotice fNotice = ServletUtils.objectMethod(FNotice.class, request);
        String textWeb = ServletRequestUtils.getStringParameter(request, "textWeb", "");
        String marketingId = ServletRequestUtils.getStringParameter(request, "marketingId", "");

        fNotice.setNoticeInfoId(marketingId);
        fNotice.setShopId(shopId);
        fNotice.setNoticeTextWeb(textWeb);
        if (fNotice != null)
        {
            fNotice.setNoticeTextMobile(GMSServiceUtil.getMobileHtml(fNotice.getMarketingLinkType(), fNotice.getNoticeInfoId(), shopId, textWeb, fNotice.getMarketingLinkId()));
        }

        NoticeInfo noticeInfo = this.covertToNoticeInfo(fNotice);
        boolean result = this.checkNoticeInfo(noticeInfo);
        if (result)
        {
            result = this.noticeCoreService.addNotice(noticeInfo);
        }
        return GMSUtil.getBooleanAndExtendResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, (Object) noticeInfo.getNoticeInfoId(), noticeInfo.getNoticeInfoId());
    }

    /**
     * 删除通知
     */
    @Override
    public TransData<Object> delete(HttpServletRequest request) throws Exception
    {
        String noticeInfoId = ServletRequestUtils.getStringParameter(request, "id", "");

        boolean result = this.noticeCoreService.deleteNotice(noticeInfoId);

        return new TransData<Object>(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, noticeInfoId);
    }

    /**
     * 修改通知
     */
    @Override
    public TransData<Object> update(HttpServletRequest request) throws Exception
    {
        FNotice fNotice = ServletUtils.objectMethod(FNotice.class, request);
        String textWeb = ServletRequestUtils.getStringParameter(request, "textWeb", "");

        fNotice.setNoticeTextWeb(textWeb);
        if (fNotice != null)
        {
            fNotice.setNoticeTextMobile(GMSServiceUtil.getMobileHtml(fNotice.getMarketingLinkType(), fNotice.getNoticeInfoId(), fNotice.getShopId(), textWeb, fNotice.getMarketingLinkId()));
        }

        NoticeInfo noticeInfo = this.covertToNoticeInfo(fNotice);

        boolean result = this.checkNoticeInfo(noticeInfo);
        if (result)
        {
            result = this.noticeCoreService.updateNotice(noticeInfo);
        }

        return new TransData<Object>(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, fNotice.getNoticeInfoId());
    }

    /**
     * 通知列表
     */
    @Override
    public TransData<PageModel<FNotice>> pageNotice(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FNotice notice = ServletUtils.objectMethod(FNotice.class, request);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);
        PageModel<FNotice> pm = new PageModel<FNotice>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());
        if (pc.getPageSize() == 0)
        {
            pm.setPageSize(10);
        }
        NoticeInfoExample example = new NoticeInfoExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause("c_time_stamp desc");
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(notice.getActivityId()))
        {
            criteria.andActivityIdEqualTo(notice.getActivityId());
        }
        if (org.springframework.util.StringUtils.hasText(notice.getPublishStatus()))
        {
            criteria.andPublishStatusEqualTo(notice.getPublishStatus());
        }
        if (org.springframework.util.StringUtils.hasText(notice.getNoticeTitle()))
        {
            criteria.andNoticeTitleLike("%" + notice.getNoticeTitle() + "%");
        }
        Integer count = this.noticeInfoGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<NoticeInfo> list = this.noticeInfoGeneratorQueryService.selectByExample(example);
            for (NoticeInfo noticeInfo : list)
            {
                pm.getResult().add(this.covertToFNoticeInfo(noticeInfo));
            }
        }

        return new TransData<PageModel<FNotice>>(true, null, pm);
    }

    /**
     * 通知详细信息
     */
    @Override
    public TransData<FNotice> getNoticeInfo(HttpServletRequest request) throws Exception
    {
        String noticeInfoId = ServletRequestUtils.getStringParameter(request, "id", "");

        NoticeInfo noticeInfo = this.noticeInfoGeneratorQueryService.selectUnDelByPrimaryKey(noticeInfoId);
        FNotice notice = this.covertToFNoticeInfo(noticeInfo);

        return new TransData<FNotice>(true, null, notice, noticeInfoId);
    }

    /**
     * 审核通知
     */
    @Override
    public TransData<Object> check(HttpServletRequest request) throws Exception
    {
        String noticeInfoId = ServletRequestUtils.getStringParameter(request, "id", "");
        String publishStatus = ServletRequestUtils.getStringParameter(request, "status", "N");
        String note = ServletRequestUtils.getStringParameter(request, "note", "");

        boolean result = this.noticeCoreService.reviewedNotice(noticeInfoId, publishStatus, note);

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, noticeInfoId);
    }

    /**
     * 发布通知
     */
    @Override
    public TransData<Object> release(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        String noticeInfoId = ServletRequestUtils.getStringParameter(request, "id", "");

        FRuleInfo fRuleInfo = ReleaseUtil.getRuleInfo(request);

        RuleInfo ruleInfo = this.covertToRuleInfo(fRuleInfo);

        List<Account> userList = null;
        if (!"1".equals(ruleInfo.getCrowdType()))
        {
            userList = this.userAccountService.getUserAccountList(fRuleInfo, shopId, "2");
        }

        boolean result = this.noticeCoreService.publishNotice(noticeInfoId, userList, ruleInfo);

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, noticeInfoId);
    }

    private NoticeInfo covertToNoticeInfo(FNotice fNotice) throws IllegalArgumentException, IllegalAccessException
    {
        NoticeInfo noticeInfo = new NoticeInfo();
        if (fNotice != null)
        {
            EntityTools.copyValue(fNotice, noticeInfo);
        }
        return noticeInfo;
    }

    private FNotice covertToFNoticeInfo(NoticeInfo noticeInfo) throws IllegalArgumentException, IllegalAccessException
    {
        FNotice notice = new FNotice();
        if (noticeInfo != null)
        {
            EntityTools.copyValue(noticeInfo, notice);
            if (StringUtils.hasText(noticeInfo.getActivityId()))
            {
                MarketingActivity activityInfo = this.marketingActivityGeneratorQueryService.selectByPrimaryKey(noticeInfo.getActivityId());
                if (activityInfo != null)
                {

                    notice.setActivityName(activityInfo.getActivityName());
                    notice.setActiveStartTime(activityInfo.getStartTime());
                    notice.setActiveEndTime(activityInfo.getEndTime());
                }
            }
        }
        return notice;
    }

    private RuleInfo covertToRuleInfo(FRuleInfo fRuleInfo) throws IllegalArgumentException, IllegalAccessException
    {
        RuleInfo ruleInfo = new RuleInfo();
        if (fRuleInfo != null)
        {
            EntityTools.copyValue(fRuleInfo, ruleInfo);
        }
        return ruleInfo;
    }

    /**
     * 校验通知信息
     * @param noticeInfo
     * @return
     */
    private boolean checkNoticeInfo(NoticeInfo noticeInfo)
    {
        if (noticeInfo == null)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(noticeInfo.getNoticeInfoId()) || noticeInfo.getNoticeInfoId().length() != 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(noticeInfo.getNoticeTitle()) || noticeInfo.getNoticeTitle().length() > 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(noticeInfo.getNoticeTextWeb()) || noticeInfo.getNoticeTextWeb().length() > 1000)
        {
            return false;
        }
        if (!org.apache.commons.lang.StringUtils.isBlank(noticeInfo.getImg()))
        {
            if (noticeInfo.getImg().length() > 255)
            {
                return false;
            }
        }

        return true;
    }
}
