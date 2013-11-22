package com.gooagoo.query.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.entity.generator.member.MemberOfCardKey;
import com.gooagoo.dao.generator.member.MemberOfCardMapper;

@Service
public class MemberOfCardGeneratorQueryServiceImpl implements MemberOfCardGeneratorQueryService
{

    @Autowired
    private MemberOfCardMapper memberOfCardMapper;

    @Override
    public Integer countByExample(MemberOfCardExample memberOfCardExample) 
    {
        return this.memberOfCardMapper.countByExample(memberOfCardExample);
    }

    @Override
    public List<MemberOfCard> selectByExample(MemberOfCardExample memberOfCardExample) 
    {
        return this.memberOfCardMapper.selectByExample(memberOfCardExample);
    }

    @Override
    public MemberOfCard selectUnDelByPrimaryKey(String primaryKey) 
    {
        MemberOfCardKey memberOfCardKey = new MemberOfCardKey();
        memberOfCardKey.setIsDel("N");
        memberOfCardKey.setScardno(primaryKey);
        return this.memberOfCardMapper.selectByPrimaryKey(memberOfCardKey);
    }

    @Override
    public MemberOfCard selectByPrimaryKey(String primaryKey) 
    {
        MemberOfCardKey memberOfCardKey = new MemberOfCardKey();
        memberOfCardKey.setScardno(primaryKey);
        return this.memberOfCardMapper.selectByPrimaryKey(memberOfCardKey);
    }

}
