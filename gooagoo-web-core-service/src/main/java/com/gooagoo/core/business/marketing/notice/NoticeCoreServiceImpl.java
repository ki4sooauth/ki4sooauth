package com.gooagoo.core.business.marketing.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.marketing.notice.NoticeCoreService;
import com.gooagoo.api.generator.core.marketing.NoticeInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.marketing.ActivityContentProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.NoticeInfo;
import com.gooagoo.entity.generator.marketing.RuleInfo;

@Service
public class NoticeCoreServiceImpl implements NoticeCoreService
{
    @Autowired
    private NoticeInfoGeneratorCoreService noticeInfoGeneratorCoreService;
    @Autowired
    private ActivityContentProtectedCoreService activityContentProtectedCoreService;

    @Override
    public boolean deleteNotice(String noticeInfoId) throws Exception
    {
        if (!StringUtils.hasText(noticeInfoId))
        {
            GooagooLog.warn("删除通知：通知Id为空");
            return false;
        }
        return this.noticeInfoGeneratorCoreService.deleteByPrimaryKey(noticeInfoId);
    }

    @Override
    public boolean addNotice(NoticeInfo noticeInfo) throws Exception
    {
        noticeInfo.setIsDel("N");
        noticeInfo.setPublishStatus("W");
        return this.noticeInfoGeneratorCoreService.insertSelective(noticeInfo);
    }

    @Override
    public boolean updateNotice(NoticeInfo noticeInfo) throws Exception
    {
        noticeInfo.setPublishStatus("W");
        return this.noticeInfoGeneratorCoreService.updateByPrimaryKeySelective(noticeInfo);
    }

    @Override
    public boolean reviewedNotice(String noticeInfoId, String status, String note) throws Exception
    {
        NoticeInfo noticeInfo = this.noticeInfoGeneratorCoreService.selectByPrimaryKey(noticeInfoId);
        if (noticeInfo == null)
        {
            GooagooLog.warn("审核通知：通知不存在，noticeInfoId=" + noticeInfoId);
            return false;
        }
        if (!"W".equals(noticeInfo.getPublishStatus()))
        {
            GooagooLog.warn("审核通知：通知状态不是待审核，noticeInfoId=" + noticeInfoId + ",publishStatus=" + noticeInfo.getPublishStatus());
            return false;
        }
        NoticeInfo reviewed = new NoticeInfo();
        reviewed.setNoticeInfoId(noticeInfoId);
        reviewed.setAuditNote(note);
        if ("Y".equals(status))
        {
            reviewed.setPublishStatus("A");
        }
        else
        {
            reviewed.setPublishStatus("B");
        }
        return this.noticeInfoGeneratorCoreService.updateByPrimaryKeySelective(reviewed);
    }

    @Override
    public boolean publishNotice(String noticeInfoId, List<Account> userList, RuleInfo ruleInfo) throws Exception
    {
        return this.activityContentProtectedCoreService.release(noticeInfoId, "2", userList, ruleInfo);
    }

}
