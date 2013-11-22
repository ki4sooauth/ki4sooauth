package com.gooagoo.query.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.member.MemberCardKey;
import com.gooagoo.dao.generator.member.MemberCardMapper;

@Service
public class MemberCardGeneratorQueryServiceImpl implements MemberCardGeneratorQueryService
{

    @Autowired
    private MemberCardMapper memberCardMapper;

    @Override
    public Integer countByExample(MemberCardExample memberCardExample) 
    {
        return this.memberCardMapper.countByExample(memberCardExample);
    }

    @Override
    public List<MemberCard> selectByExample(MemberCardExample memberCardExample) 
    {
        return this.memberCardMapper.selectByExample(memberCardExample);
    }

    @Override
    public MemberCard selectUnDelByPrimaryKey(String primaryKey) 
    {
        MemberCardKey memberCardKey = new MemberCardKey();
        memberCardKey.setIsDel("N");
        memberCardKey.setCardId(primaryKey);
        return this.memberCardMapper.selectByPrimaryKey(memberCardKey);
    }

    @Override
    public MemberCard selectByPrimaryKey(String primaryKey) 
    {
        MemberCardKey memberCardKey = new MemberCardKey();
        memberCardKey.setCardId(primaryKey);
        return this.memberCardMapper.selectByPrimaryKey(memberCardKey);
    }

}
