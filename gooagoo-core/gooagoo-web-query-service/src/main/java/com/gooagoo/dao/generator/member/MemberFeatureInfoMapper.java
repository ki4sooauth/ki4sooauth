package com.gooagoo.dao.generator.member;

import java.util.List;

import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfoExample;
import com.gooagoo.entity.generator.member.MemberFeatureInfoKey;

public interface MemberFeatureInfoMapper
{

    public Integer countByExample(MemberFeatureInfoExample memberFeatureInfoExample);

    public List<MemberFeatureInfo> selectByExample(MemberFeatureInfoExample memberFeatureInfoExample);

    public MemberFeatureInfo selectByPrimaryKey(MemberFeatureInfoKey memberFeatureInfoKey);

}
