package com.gooagoo.core.business.marketing.cryout;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.marketing.cryout.CryoutCoreService;
import com.gooagoo.api.generator.core.marketing.CryoutInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.marketing.ActivityContentProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.entity.generator.marketing.RuleInfo;

@Service
public class CryoutCoreServiceImpl implements CryoutCoreService
{
    @Autowired
    private CryoutInfoGeneratorCoreService cryoutInfoGeneratorCoreService;
    @Autowired
    private ActivityContentProtectedCoreService activityContentProtectedCoreService;

    @Override
    public boolean deleteCryoutInfo(String cryoutInfoId) throws Exception
    {
        if (!StringUtils.hasText(cryoutInfoId))
        {
            GooagooLog.warn("删除吆喝：吆喝Id为空");
            return false;
        }
        return this.cryoutInfoGeneratorCoreService.deleteByPrimaryKey(cryoutInfoId);
    }

    @Override
    public boolean addCryoutInfo(CryoutInfo cryoutInfo) throws Exception
    {
        cryoutInfo.setIsDel("N");
        cryoutInfo.setPublishStatus("W");
        return this.cryoutInfoGeneratorCoreService.insertSelective(cryoutInfo);
    }

    @Override
    public boolean updateCryoutInfo(CryoutInfo cryoutInfo) throws Exception
    {
        cryoutInfo.setPublishStatus("W");
        return this.cryoutInfoGeneratorCoreService.updateByPrimaryKeySelective(cryoutInfo);
    }

    @Override
    public boolean reviewedCryoutInfo(String cryoutInfoId, String status, String note) throws Exception
    {
        CryoutInfo cryoutInfo = this.cryoutInfoGeneratorCoreService.selectByPrimaryKey(cryoutInfoId);
        if (cryoutInfo == null)
        {
            GooagooLog.warn("审核吆喝：吆喝不存在，cryoutInfoId=" + cryoutInfoId);
            return false;
        }
        if (!"W".equals(cryoutInfo.getPublishStatus()))
        {
            GooagooLog.warn("审核吆喝：吆喝状态不是待审核，cryoutInfoId=" + cryoutInfoId + ",publishStatus=" + cryoutInfo.getPublishStatus());
            return false;
        }
        CryoutInfo reviewed = new CryoutInfo();
        reviewed.setCryoutInfoId(cryoutInfoId);
        reviewed.setAuditNote(note);
        if ("Y".equals(status))
        {
            reviewed.setPublishStatus("A");
        }
        else
        {
            reviewed.setPublishStatus("B");
        }
        return this.cryoutInfoGeneratorCoreService.updateByPrimaryKeySelective(reviewed);
    }

    @Override
    public boolean publishCryoutInfo(String cryoutInfoId, List<Account> userList, RuleInfo ruleInfo) throws Exception
    {
        return this.activityContentProtectedCoreService.release(cryoutInfoId, "1", userList, ruleInfo);
    }

}
