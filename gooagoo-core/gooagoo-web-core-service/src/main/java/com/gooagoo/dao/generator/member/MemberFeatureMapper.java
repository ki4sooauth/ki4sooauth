package com.gooagoo.dao.generator.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.member.MemberFeature;
import com.gooagoo.entity.generator.member.MemberFeatureExample;
import com.gooagoo.entity.generator.member.MemberFeatureKey;

public interface MemberFeatureMapper
{

    public Integer countByExample(MemberFeatureExample memberFeatureExample);

    public List<MemberFeature> selectByExample(MemberFeatureExample memberFeatureExample);

    public MemberFeature selectByPrimaryKey(MemberFeatureKey memberFeatureKey);

    public Integer deleteByExample(MemberFeatureExample memberFeatureExample);

    public Integer deleteByPrimaryKey(MemberFeatureKey memberFeatureKey);

    public Integer insertSelective(MemberFeature memberFeature);

    public Integer updateAllByExample(@Param("record") MemberFeature memberFeature, @Param("example") MemberFeatureExample memberFeatureExample);

    public Integer updateByExampleSelective(@Param("record") MemberFeature memberFeature, @Param("example") MemberFeatureExample memberFeatureExample);

    public Integer updateByPrimaryKeySelective(MemberFeature memberFeature);

}
