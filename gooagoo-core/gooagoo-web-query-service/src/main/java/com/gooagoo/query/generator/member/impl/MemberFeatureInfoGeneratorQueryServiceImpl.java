package com.gooagoo.query.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.member.MemberFeatureInfoGeneratorQueryService;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfoExample;
import com.gooagoo.entity.generator.member.MemberFeatureInfoKey;
import com.gooagoo.dao.generator.member.MemberFeatureInfoMapper;

@Service
public class MemberFeatureInfoGeneratorQueryServiceImpl implements MemberFeatureInfoGeneratorQueryService
{

    @Autowired
    private MemberFeatureInfoMapper memberFeatureInfoMapper;

    @Override
    public Integer countByExample(MemberFeatureInfoExample memberFeatureInfoExample) 
    {
        return this.memberFeatureInfoMapper.countByExample(memberFeatureInfoExample);
    }

    @Override
    public List<MemberFeatureInfo> selectByExample(MemberFeatureInfoExample memberFeatureInfoExample) 
    {
        return this.memberFeatureInfoMapper.selectByExample(memberFeatureInfoExample);
    }

    @Override
    public MemberFeatureInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        MemberFeatureInfoKey memberFeatureInfoKey = new MemberFeatureInfoKey();
        memberFeatureInfoKey.setIsDel("N");
        memberFeatureInfoKey.setId(primaryKey);
        return this.memberFeatureInfoMapper.selectByPrimaryKey(memberFeatureInfoKey);
    }

    @Override
    public MemberFeatureInfo selectByPrimaryKey(String primaryKey) 
    {
        MemberFeatureInfoKey memberFeatureInfoKey = new MemberFeatureInfoKey();
        memberFeatureInfoKey.setId(primaryKey);
        return this.memberFeatureInfoMapper.selectByPrimaryKey(memberFeatureInfoKey);
    }

}
