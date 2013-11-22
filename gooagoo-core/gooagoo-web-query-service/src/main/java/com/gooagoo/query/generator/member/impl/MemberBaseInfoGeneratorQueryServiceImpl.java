package com.gooagoo.query.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.member.MemberBaseInfoGeneratorQueryService;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.member.MemberBaseInfoKey;
import com.gooagoo.dao.generator.member.MemberBaseInfoMapper;

@Service
public class MemberBaseInfoGeneratorQueryServiceImpl implements MemberBaseInfoGeneratorQueryService
{

    @Autowired
    private MemberBaseInfoMapper memberBaseInfoMapper;

    @Override
    public Integer countByExample(MemberBaseInfoExample memberBaseInfoExample) 
    {
        return this.memberBaseInfoMapper.countByExample(memberBaseInfoExample);
    }

    @Override
    public List<MemberBaseInfo> selectByExample(MemberBaseInfoExample memberBaseInfoExample) 
    {
        return this.memberBaseInfoMapper.selectByExample(memberBaseInfoExample);
    }

    @Override
    public MemberBaseInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        MemberBaseInfoKey memberBaseInfoKey = new MemberBaseInfoKey();
        memberBaseInfoKey.setIsDel("N");
        memberBaseInfoKey.setId(primaryKey);
        return this.memberBaseInfoMapper.selectByPrimaryKey(memberBaseInfoKey);
    }

    @Override
    public MemberBaseInfo selectByPrimaryKey(String primaryKey) 
    {
        MemberBaseInfoKey memberBaseInfoKey = new MemberBaseInfoKey();
        memberBaseInfoKey.setId(primaryKey);
        return this.memberBaseInfoMapper.selectByPrimaryKey(memberBaseInfoKey);
    }

}
