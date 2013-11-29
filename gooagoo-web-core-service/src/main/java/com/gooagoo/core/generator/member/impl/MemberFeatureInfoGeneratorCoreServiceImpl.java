package com.gooagoo.core.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.member.MemberFeatureInfoGeneratorCoreService;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfoExample;
import com.gooagoo.entity.generator.member.MemberFeatureInfoKey;
import com.gooagoo.dao.generator.member.MemberFeatureInfoMapper;

@Service
public class MemberFeatureInfoGeneratorCoreServiceImpl implements MemberFeatureInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(MemberFeatureInfoExample memberFeatureInfoExample) 
    {
        return this.memberFeatureInfoMapper.deleteByExample(memberFeatureInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        MemberFeatureInfoKey memberFeatureInfoKey = new MemberFeatureInfoKey();
        memberFeatureInfoKey.setId(primaryKey);
        return this.memberFeatureInfoMapper.deleteByPrimaryKey(memberFeatureInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(MemberFeatureInfoExample memberFeatureInfoExample) 
    {
        MemberFeatureInfo memberFeatureInfo = new MemberFeatureInfo();
        memberFeatureInfo.setIsDel("Y");
        return this.memberFeatureInfoMapper.updateByExampleSelective(memberFeatureInfo,memberFeatureInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        MemberFeatureInfo memberFeatureInfo = new MemberFeatureInfo();
        memberFeatureInfo.setId(primaryKey);
        memberFeatureInfo.setIsDel("Y");
        return this.memberFeatureInfoMapper.updateByPrimaryKeySelective(memberFeatureInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(MemberFeatureInfo memberFeatureInfo) 
    {
        return this.memberFeatureInfoMapper.insertSelective(memberFeatureInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(MemberFeatureInfo memberFeatureInfo,MemberFeatureInfoExample memberFeatureInfoExample) 
    {
        return this.memberFeatureInfoMapper.updateByExampleSelective(memberFeatureInfo,memberFeatureInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(MemberFeatureInfo memberFeatureInfo) 
    {
        return this.memberFeatureInfoMapper.updateByPrimaryKeySelective(memberFeatureInfo) > 0 ? true : false;
    }

}
