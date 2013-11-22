package com.gooagoo.entity.business.user.account.property;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gooagoo.entity.generator.member.MemberFeatureInfo;

/**
 * 用户属性档案信息
 *
 */
public class PropertyRecord implements Serializable
{

    private static final long serialVersionUID = 1L;

    private AccountTypeInfo accountTypeInfo;//用户账号类型信息（用户标识）
    private AccountBaseInfo accountBaseInfo;//用户账号基本信息
    private List<MemberFeatureInfo> memberFeatureInfoList = new ArrayList<MemberFeatureInfo>();//会员特征

    public AccountTypeInfo getAccountTypeInfo()
    {
        return this.accountTypeInfo;
    }

    public void setAccountTypeInfo(AccountTypeInfo accountTypeInfo)
    {
        this.accountTypeInfo = accountTypeInfo;
    }

    public AccountBaseInfo getAccountBaseInfo()
    {
        return this.accountBaseInfo;
    }

    public void setAccountBaseInfo(AccountBaseInfo accountBaseInfo)
    {
        this.accountBaseInfo = accountBaseInfo;
    }

    public List<MemberFeatureInfo> getMemberFeatureInfoList()
    {
        return this.memberFeatureInfoList;
    }

    public void setMemberFeatureInfoList(List<MemberFeatureInfo> memberFeatureInfoList)
    {
        this.memberFeatureInfoList = memberFeatureInfoList;
    }

}
