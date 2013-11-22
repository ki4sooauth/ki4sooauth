package com.gooagoo.dao.generator.member;

import java.util.List;

import com.gooagoo.entity.generator.member.MemberFeature;
import com.gooagoo.entity.generator.member.MemberFeatureExample;
import com.gooagoo.entity.generator.member.MemberFeatureKey;

public interface MemberFeatureMapper
{

    public Integer countByExample(MemberFeatureExample memberFeatureExample);

    public List<MemberFeature> selectByExample(MemberFeatureExample memberFeatureExample);

    public MemberFeature selectByPrimaryKey(MemberFeatureKey memberFeatureKey);

}
