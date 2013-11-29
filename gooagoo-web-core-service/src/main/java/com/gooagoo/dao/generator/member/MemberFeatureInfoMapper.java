package com.gooagoo.dao.generator.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfoExample;
import com.gooagoo.entity.generator.member.MemberFeatureInfoKey;

public interface MemberFeatureInfoMapper
{

    public Integer countByExample(MemberFeatureInfoExample memberFeatureInfoExample);

    public List<MemberFeatureInfo> selectByExample(MemberFeatureInfoExample memberFeatureInfoExample);

    public MemberFeatureInfo selectByPrimaryKey(MemberFeatureInfoKey memberFeatureInfoKey);

    public Integer deleteByExample(MemberFeatureInfoExample memberFeatureInfoExample);

    public Integer deleteByPrimaryKey(MemberFeatureInfoKey memberFeatureInfoKey);

    public Integer insertSelective(MemberFeatureInfo memberFeatureInfo);

    public Integer updateAllByExample(@Param("record") MemberFeatureInfo memberFeatureInfo, @Param("example") MemberFeatureInfoExample memberFeatureInfoExample);

    public Integer updateByExampleSelective(@Param("record") MemberFeatureInfo memberFeatureInfo, @Param("example") MemberFeatureInfoExample memberFeatureInfoExample);

    public Integer updateByPrimaryKeySelective(MemberFeatureInfo memberFeatureInfo);

}
