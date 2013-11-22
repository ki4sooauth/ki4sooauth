package com.gooagoo.view.gms.crm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户属性档案信息
 *
 */
public class FPropertyRecord implements Serializable
{

    private static final long serialVersionUID = 1L;

    private FAccountTypeInfo accountTypeInfo;//用户账号类型信息（用户标识）
    private FAccountBaseInfo accountBaseInfo;//用户账号基本信息
    private List<FMemberFeatureInfo> memberFeatureInfoList = new ArrayList<FMemberFeatureInfo>();//会员特征

    public FAccountTypeInfo getAccountTypeInfo()
    {
        return this.accountTypeInfo;
    }

    public void setAccountTypeInfo(FAccountTypeInfo accountTypeInfo)
    {
        this.accountTypeInfo = accountTypeInfo;
    }

    public FAccountBaseInfo getAccountBaseInfo()
    {
        return this.accountBaseInfo;
    }

    public void setAccountBaseInfo(FAccountBaseInfo accountBaseInfo)
    {
        this.accountBaseInfo = accountBaseInfo;
    }

    public List<FMemberFeatureInfo> getMemberFeatureInfoList()
    {
        return this.memberFeatureInfoList;
    }

    public void setMemberFeatureInfoList(List<FMemberFeatureInfo> memberFeatureInfoList)
    {
        this.memberFeatureInfoList = memberFeatureInfoList;
    }

}
