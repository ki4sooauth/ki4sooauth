package com.gooagoo.query.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.member.MemberApplyGeneratorQueryService;
import com.gooagoo.entity.generator.member.MemberApply;
import com.gooagoo.entity.generator.member.MemberApplyExample;
import com.gooagoo.entity.generator.member.MemberApplyKey;
import com.gooagoo.dao.generator.member.MemberApplyMapper;

@Service
public class MemberApplyGeneratorQueryServiceImpl implements MemberApplyGeneratorQueryService
{

    @Autowired
    private MemberApplyMapper memberApplyMapper;

    @Override
    public Integer countByExample(MemberApplyExample memberApplyExample) 
    {
        return this.memberApplyMapper.countByExample(memberApplyExample);
    }

    @Override
    public List<MemberApply> selectByExample(MemberApplyExample memberApplyExample) 
    {
        return this.memberApplyMapper.selectByExample(memberApplyExample);
    }

    @Override
    public MemberApply selectUnDelByPrimaryKey(String primaryKey) 
    {
        MemberApplyKey memberApplyKey = new MemberApplyKey();
        memberApplyKey.setIsDel("N");
        memberApplyKey.setApplicationId(primaryKey);
        return this.memberApplyMapper.selectByPrimaryKey(memberApplyKey);
    }

    @Override
    public MemberApply selectByPrimaryKey(String primaryKey) 
    {
        MemberApplyKey memberApplyKey = new MemberApplyKey();
        memberApplyKey.setApplicationId(primaryKey);
        return this.memberApplyMapper.selectByPrimaryKey(memberApplyKey);
    }

}
