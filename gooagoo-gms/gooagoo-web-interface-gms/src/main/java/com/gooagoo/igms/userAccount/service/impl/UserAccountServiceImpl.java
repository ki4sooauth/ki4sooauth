package com.gooagoo.igms.userAccount.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.user.cache.UserCacheQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.business.marketing.rule.ActionAttribute;
import com.gooagoo.entity.business.marketing.rule.HistoryCondition;
import com.gooagoo.entity.business.marketing.rule.NaturalAttribute;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.business.user.account.property.PropertyRecord;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.igms.cache.GMSCache;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.common.utils.ReleaseUtil;
import com.gooagoo.igms.member.service.impl.StatisticsUtil;
import com.gooagoo.igms.userAccount.service.UserAccountService;
import com.gooagoo.view.gms.account.UserView;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.rule.FActionAttribute;
import com.gooagoo.view.gms.rule.FHistoryCondition;
import com.gooagoo.view.gms.rule.FNaturalAttribute;
import com.gooagoo.view.gms.rule.FRuleCondition;
import com.gooagoo.view.gms.rule.FRuleInfo;
import com.google.gson.Gson;

@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService
{

    @Autowired
    private UserCacheQueryService userCacheQueryService;

    /**
     * 根据历史条件查询用户账号详细信息列表(分页)
     */
    @Override
    public TransData<PageModel<UserView>> pageUserAccount(HttpServletRequest request) throws Exception
    {
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");

        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);
        FRuleInfo fRuleInfo = ReleaseUtil.getRuleInfo(request);
        RuleInfo ruleInfo = this.covertToRuleInfo(fRuleInfo);
        String ruleJson = ruleInfo.getRuleContent();
        FRuleCondition ruleCondition = new Gson().fromJson(ruleJson, FRuleCondition.class);

        FHistoryCondition hCondition = ruleCondition.getHistoryCondition();
        HistoryCondition historyCondition = this.covertToHistoryCondition(hCondition);
        String key = new StringBuffer(shopId).append(new Gson().toJson(historyCondition)).toString();
        @SuppressWarnings("unchecked")
        List<Account> userAccountsList = (List<Account>) GMSCache.getCache(key);
        if (CollectionUtils.isEmpty(userAccountsList))
        {
            userAccountsList = this.userCacheQueryService.getUserAccountsList(shopId, historyCondition);
            GMSCache.putCache(key, userAccountsList);
        }
        userAccountsList = this.filterUserAccountsList(userAccountsList, channelCode);
        // 设置分页信息
        PageModel<UserView> pageModel = new PageModel<UserView>();
        boolean isEmpty = CollectionUtils.isEmpty(userAccountsList);
        pageModel.setCount(isEmpty ? 0 : userAccountsList.size());
        pageModel.setPageIndex(pc.getPageIndex());
        pageModel.setPageSize(pc.getPageSize());
        if (!isEmpty)
        {
            UserView userView = null;
            for (Account account : userAccountsList.subList(StatisticsUtil.getFromIndex(pageModel.getIndex(), pageModel.getPageIndex(), userAccountsList.size()), StatisticsUtil.getToIndex(pageModel.getIndex(), pageModel.getPageSize(), userAccountsList.size())))
            {
                userView = new UserView();
                PropertyRecord userPropertyRecord = null;
                try
                {
                    userPropertyRecord = this.userCacheQueryService.getUserPropertyRecord(shopId, account.getAccountType(), account.getAccountNo());
                }
                catch (Exception e)
                {
                    GooagooLog.error("查询用户属性信息出错，shopId=" + shopId + ",accountType=" + account.getAccountType() + ",accountNo=" + account.getAccountNo(), e);
                }
                if (userPropertyRecord != null && userPropertyRecord.getAccountBaseInfo() != null)
                {
                    userView.setName(userPropertyRecord.getAccountBaseInfo().getName());
                    userView.setTelephone(userPropertyRecord.getAccountBaseInfo().getTelephone());
                }
                userView.setAccountType(account.getAccountType());
                userView.setAccount(account.getAccountNo());
                pageModel.getResult().add(userView);
            }
        }

        return new TransData<PageModel<UserView>>(true, null, pageModel);
    }

    /**
     * 根据历史查询用户账户总数
     */
    @Override
    public TransData<Object> getUserAccountCount(HttpServletRequest request) throws Exception
    {
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");

        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        FRuleInfo fRuleInfo = ReleaseUtil.getRuleInfo(request);
        RuleInfo ruleInfo = this.covertToRuleInfo(fRuleInfo);
        String ruleJson = ruleInfo.getRuleContent();
        FRuleCondition ruleCondition = new Gson().fromJson(ruleJson, FRuleCondition.class);

        FHistoryCondition hCondition = ruleCondition.getHistoryCondition();
        HistoryCondition historyCondition = this.covertToHistoryCondition(hCondition);
        String key = new StringBuffer(shopId).append(new Gson().toJson(historyCondition)).toString();
        @SuppressWarnings("unchecked")
        List<Account> userAccountsList = (List<Account>) GMSCache.getCache(key);
        if (!CollectionUtils.isEmpty(userAccountsList))
        {
            userAccountsList = this.userCacheQueryService.getUserAccountsList(shopId, historyCondition);
            GMSCache.putCache(key, userAccountsList);
        }
        userAccountsList = this.filterUserAccountsList(userAccountsList, channelCode);

        int count = 0;
        if (!CollectionUtils.isEmpty(userAccountsList))
        {
            count = userAccountsList.size();
        }
        return new TransData<Object>(true, null, count);
    }

    /**
     * 根据历史条件查询用户账号列表
     */
    @Override
    public List<Account> getUserAccountList(FRuleInfo ruleInfo, String shopId, String channelCode) throws Exception
    {

        String ruleJson = ruleInfo.getRuleContent();

        FRuleCondition ruleCondition = new Gson().fromJson(ruleJson, FRuleCondition.class);

        FHistoryCondition hCondition = ruleCondition.getHistoryCondition();
        HistoryCondition historyCondition = this.covertToHistoryCondition(hCondition);

        List<Account> userAccountsList = this.userCacheQueryService.getUserAccountsList(shopId, historyCondition);

        userAccountsList = this.filterUserAccountsList(userAccountsList, channelCode);

        return userAccountsList;
    }

    private HistoryCondition covertToHistoryCondition(FHistoryCondition hCondition) throws IllegalArgumentException, IllegalAccessException
    {
        HistoryCondition historyCondition = new HistoryCondition();
        NaturalAttribute naturalAttribute = new NaturalAttribute();
        List<ActionAttribute> list = new ArrayList<ActionAttribute>();

        FNaturalAttribute fNaturalAttribute = hCondition.getNaturalAttribute();
        List<FActionAttribute> fList = hCondition.getList();

        for (FActionAttribute fActionAttribute : fList)
        {
            list.add(this.covertToActionAttribute(fActionAttribute));
        }

        if (fNaturalAttribute != null)
        {
            EntityTools.copyValue(fNaturalAttribute, naturalAttribute);
        }

        historyCondition.setCrowdId(hCondition.getCrowdId());
        historyCondition.setCrowdName(hCondition.getCrowdName());
        historyCondition.setNaturalAttribute(naturalAttribute);
        historyCondition.setList(list);

        return historyCondition;
    }

    private ActionAttribute covertToActionAttribute(FActionAttribute fActionAttribute) throws IllegalArgumentException, IllegalAccessException
    {
        ActionAttribute actionAttribute = new ActionAttribute();

        if (fActionAttribute != null)
        {
            EntityTools.copyValue(fActionAttribute, actionAttribute);
        }

        return actionAttribute;
    }

    @Override
    public RuleInfo covertToRuleInfo(FRuleInfo fRuleInfo) throws IllegalArgumentException, IllegalAccessException
    {
        RuleInfo ruleInfo = new RuleInfo();
        if (fRuleInfo != null)
        {
            EntityTools.copyValue(fRuleInfo, ruleInfo);
        }
        return ruleInfo;
    }

    /**
     * 过虑掉账号类型为物理卡的用户账号数据
     * @param userAccountsList
     * @return
     */
    private List<Account> filterUserAccountsList(List<Account> userAccountsList, String channelCode)
    {
        List<Account> resultList = new ArrayList<Account>();
        if (!CollectionUtils.isEmpty(userAccountsList))
        {
            resultList = userAccountsList;
            for (int i = 0; i < resultList.size(); i++)
            {
                if ("7".equals(resultList.get(i).getAccountType()) && ("1".equals(channelCode) || "2".equals(channelCode)))
                {
                    resultList.remove(i);
                }
            }
        }
        return resultList;
    }
}
