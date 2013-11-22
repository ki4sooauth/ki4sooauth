package com.gooagoo.query.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.member.MemberFeatureGeneratorQueryService;
import com.gooagoo.entity.generator.member.MemberFeature;
import com.gooagoo.entity.generator.member.MemberFeatureExample;
import com.gooagoo.entity.generator.member.MemberFeatureKey;
import com.gooagoo.dao.generator.member.MemberFeatureMapper;

@Service
public class MemberFeatureGeneratorQueryServiceImpl implements MemberFeatureGeneratorQueryService
{

    @Autowired
    private MemberFeatureMapper memberFeatureMapper;

    @Override
    public Integer countByExample(MemberFeatureExample memberFeatureExample) 
    {
        return this.memberFeatureMapper.countByExample(memberFeatureExample);
    }

    @Override
    public List<MemberFeature> selectByExample(MemberFeatureExample memberFeatureExample) 
    {
        return this.memberFeatureMapper.selectByExample(memberFeatureExample);
    }

    @Override
    public MemberFeature selectUnDelByPrimaryKey(String primaryKey) 
    {
        MemberFeatureKey memberFeatureKey = new MemberFeatureKey();
        memberFeatureKey.setIsDel("N");
        memberFeatureKey.setId(primaryKey);
        return this.memberFeatureMapper.selectByPrimaryKey(memberFeatureKey);
    }

    @Override
    public MemberFeature selectByPrimaryKey(String primaryKey) 
    {
        MemberFeatureKey memberFeatureKey = new MemberFeatureKey();
        memberFeatureKey.setId(primaryKey);
        return this.memberFeatureMapper.selectByPrimaryKey(memberFeatureKey);
    }

}
