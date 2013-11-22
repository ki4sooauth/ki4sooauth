package com.gooagoo.igms.cryout.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.marketing.cryout.CryoutCoreService;
import com.gooagoo.api.generator.query.marketing.CryoutInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSServiceUtil;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.entity.generator.marketing.CryoutInfoExample;
import com.gooagoo.entity.generator.marketing.CryoutInfoExample.Criteria;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.common.utils.ReleaseUtil;
import com.gooagoo.igms.cryout.service.CryoutService;
import com.gooagoo.igms.userAccount.service.UserAccountService;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.cryout.FCryout;
import com.gooagoo.view.gms.rule.FRuleInfo;

@Service(value = "cryoutService")
public class CryoutServiceImpl implements CryoutService
{
    @Autowired
    private CryoutInfoGeneratorQueryService cryoutInfoGeneratorQueryService;
    @Autowired
    private CryoutCoreService cryoutCoreService;
    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private MarketingActivityGeneratorQueryService marketingActivityGeneratorQueryService;

    /**
     * 添加吆喝
     */
    @Override
    public TransData<Object> add(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FCryout fCryout = ServletUtils.objectMethod(FCryout.class, request);
        String textWeb = ServletRequestUtils.getStringParameter(request, "textWeb", "");
        String marketingId = ServletRequestUtils.getStringParameter(request, "marketingId", "");

        fCryout.setCryoutInfoId(marketingId);
        fCryout.setShopId(shopId);
        fCryout.setCryoutTextWeb(textWeb);
        if (fCryout != null)
        {
            fCryout.setCryoutTextMobile(GMSServiceUtil.getMobileHtml(fCryout.getMarketingLinkType(), fCryout.getCryoutInfoId(), shopId, textWeb, fCryout.getMarketingLinkId()));
        }

        CryoutInfo cryoutInfo = this.covertToCryoutInfo(fCryout);
        boolean result = this.checkCryoutInfo(cryoutInfo);
        if (result)
        {
            result = this.cryoutCoreService.addCryoutInfo(cryoutInfo);
        }
        return GMSUtil.getBooleanAndExtendResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, (Object) cryoutInfo.getCryoutInfoId(), cryoutInfo.getCryoutInfoId());
    }

    /**
     * 删除吆喝
     */
    @Override
    public TransData<Object> delete(HttpServletRequest request) throws Exception
    {
        String cryoutInfoId = ServletRequestUtils.getStringParameter(request, "id", "");

        boolean result = this.cryoutCoreService.deleteCryoutInfo(cryoutInfoId);

        return new TransData<Object>(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, cryoutInfoId);
    }

    /**
     * 修改吆喝
     */
    @Override
    public TransData<Object> update(HttpServletRequest request) throws Exception
    {
        FCryout fCryout = ServletUtils.objectMethod(FCryout.class, request);
        String textWeb = ServletRequestUtils.getStringParameter(request, "textWeb", "");

        fCryout.setCryoutTextWeb(textWeb);
        if (fCryout != null)
        {
            fCryout.setCryoutTextMobile(GMSServiceUtil.getMobileHtml(fCryout.getMarketingLinkType(), fCryout.getCryoutInfoId(), fCryout.getShopId(), textWeb, fCryout.getMarketingLinkId()));
        }

        CryoutInfo cryoutInfo = this.covertToCryoutInfo(fCryout);
        boolean result = this.checkCryoutInfo(cryoutInfo);
        if (result)
        {
            result = this.cryoutCoreService.updateCryoutInfo(cryoutInfo);
        }

        return new TransData<Object>(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, fCryout.getCryoutInfoId());
    }

    /**
     * 吆喝列表信息
     */
    @Override
    public TransData<PageModel<FCryout>> pageCryout(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FCryout cryout = ServletUtils.objectMethod(FCryout.class, request);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);
        PageModel<FCryout> pm = new PageModel<FCryout>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());

        if (pc.getPageSize() == 0)
        {
            pm.setPageSize(10);
        }
        CryoutInfoExample example = new CryoutInfoExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause("c_time_stamp desc");
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(cryout.getActivityId()))
        {
            criteria.andActivityIdEqualTo(cryout.getActivityId());
        }
        if (org.springframework.util.StringUtils.hasText(cryout.getCryoutType()))
        {
            criteria.andCryoutTypeEqualTo(cryout.getCryoutType());
        }
        if (org.springframework.util.StringUtils.hasText(cryout.getPublishStatus()))
        {
            criteria.andPublishStatusEqualTo(cryout.getPublishStatus());
        }
        if (org.springframework.util.StringUtils.hasText(cryout.getCryoutTitle()))
        {
            criteria.andCryoutTitleLike("%" + cryout.getCryoutTitle() + "%");
        }
        Integer count = this.cryoutInfoGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<CryoutInfo> list = this.cryoutInfoGeneratorQueryService.selectByExample(example);
            for (CryoutInfo cryoutInfo : list)
            {
                pm.getResult().add(this.covertToFCryoutInfo(cryoutInfo));
            }
        }

        return new TransData<PageModel<FCryout>>(true, null, pm);
    }

    /**
     * 吆喝详细信息
     */
    @Override
    public TransData<FCryout> getCryout(HttpServletRequest request) throws Exception
    {
        String cryoutInfoId = ServletRequestUtils.getStringParameter(request, "id", "");

        com.gooagoo.entity.generator.marketing.CryoutInfo cryoutInfo = this.cryoutInfoGeneratorQueryService.selectByPrimaryKey(cryoutInfoId);
        FCryout cryout = this.covertToFCryoutInfo(cryoutInfo);

        return new TransData<FCryout>(true, null, cryout, cryoutInfoId);
    }

    /**
     * 审核吆喝
     */
    @Override
    public TransData<Object> check(HttpServletRequest request) throws Exception
    {
        String cryoutInfoId = ServletRequestUtils.getStringParameter(request, "id", "");
        String status = ServletRequestUtils.getStringParameter(request, "status", "");
        String note = ServletRequestUtils.getStringParameter(request, "note", "");

        boolean result = this.cryoutCoreService.reviewedCryoutInfo(cryoutInfoId, status, note);

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, cryoutInfoId);
    }

    /**
     * 发布吆喝
     */
    @Override
    public TransData<Object> release(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        String cryoutInfoId = ServletRequestUtils.getStringParameter(request, "id", "");

        FRuleInfo fRuleInfo = ReleaseUtil.getRuleInfo(request);

        RuleInfo ruleInfo = this.covertToRuleInfo(fRuleInfo);

        List<Account> userList = null;
        if (!"1".equals(ruleInfo.getCrowdType()))
        {
            userList = this.userAccountService.getUserAccountList(fRuleInfo, shopId, "1");
        }

        boolean result = this.cryoutCoreService.publishCryoutInfo(cryoutInfoId, userList, ruleInfo);

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, cryoutInfoId);
    }

    private CryoutInfo covertToCryoutInfo(FCryout fCryout) throws IllegalArgumentException, IllegalAccessException
    {
        CryoutInfo cryoutInfo = new CryoutInfo();
        if (fCryout != null)
        {
            EntityTools.copyValue(fCryout, cryoutInfo);
        }
        return cryoutInfo;
    }

    private FCryout covertToFCryoutInfo(CryoutInfo cryoutInfo) throws IllegalArgumentException, IllegalAccessException
    {
        FCryout fCryout = new FCryout();
        if (cryoutInfo != null)
        {
            EntityTools.copyValue(cryoutInfo, fCryout);
            if (StringUtils.hasText(cryoutInfo.getActivityId()))
            {
                MarketingActivity activityInfo = this.marketingActivityGeneratorQueryService.selectByPrimaryKey(cryoutInfo.getActivityId());
                if (activityInfo != null)
                {

                    fCryout.setActivityName(activityInfo.getActivityName());
                    fCryout.setActiveStartTime(activityInfo.getStartTime());
                    fCryout.setActiveEndTime(activityInfo.getEndTime());
                }
            }
        }
        return fCryout;
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
     * 吆喝信息校验
     * @param cryoutInfo
     * @return
     */
    private boolean checkCryoutInfo(CryoutInfo cryoutInfo)
    {
        if (cryoutInfo == null)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(cryoutInfo.getCryoutInfoId()) || cryoutInfo.getCryoutInfoId().length() != 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(cryoutInfo.getCryoutTitle()) || cryoutInfo.getCryoutTitle().length() > 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(cryoutInfo.getCryoutTextWeb()) || cryoutInfo.getCryoutTextWeb().length() > 1000)
        {
            return false;
        }
        if (!org.apache.commons.lang.StringUtils.isBlank(cryoutInfo.getImg()))
        {
            if (cryoutInfo.getImg().length() > 255)
            {
                return false;
            }
        }

        return true;
    }
}
