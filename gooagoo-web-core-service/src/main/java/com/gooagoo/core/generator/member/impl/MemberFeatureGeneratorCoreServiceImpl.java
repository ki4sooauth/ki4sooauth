package com.gooagoo.core.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.member.MemberFeatureGeneratorCoreService;
import com.gooagoo.entity.generator.member.MemberFeature;
import com.gooagoo.entity.generator.member.MemberFeatureExample;
import com.gooagoo.entity.generator.member.MemberFeatureKey;
import com.gooagoo.dao.generator.member.MemberFeatureMapper;

@Service
public class MemberFeatureGeneratorCoreServiceImpl implements MemberFeatureGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(MemberFeatureExample memberFeatureExample) 
    {
        return this.memberFeatureMapper.deleteByExample(memberFeatureExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        MemberFeatureKey memberFeatureKey = new MemberFeatureKey();
        memberFeatureKey.setId(primaryKey);
        return this.memberFeatureMapper.deleteByPrimaryKey(memberFeatureKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(MemberFeatureExample memberFeatureExample) 
    {
        MemberFeature memberFeature = new MemberFeature();
        memberFeature.setIsDel("Y");
        return this.memberFeatureMapper.updateByExampleSelective(memberFeature,memberFeatureExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        MemberFeature memberFeature = new MemberFeature();
        memberFeature.setId(primaryKey);
        memberFeature.setIsDel("Y");
        return this.memberFeatureMapper.updateByPrimaryKeySelective(memberFeature) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(MemberFeature memberFeature) 
    {
        return this.memberFeatureMapper.insertSelective(memberFeature) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(MemberFeature memberFeature,MemberFeatureExample memberFeatureExample) 
    {
        return this.memberFeatureMapper.updateByExampleSelective(memberFeature,memberFeatureExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(MemberFeature memberFeature) 
    {
        return this.memberFeatureMapper.updateByPrimaryKeySelective(memberFeature) > 0 ? true : false;
    }

}
