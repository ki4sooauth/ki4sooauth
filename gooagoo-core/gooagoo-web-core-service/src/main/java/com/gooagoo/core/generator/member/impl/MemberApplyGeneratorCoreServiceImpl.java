package com.gooagoo.core.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.member.MemberApplyGeneratorCoreService;
import com.gooagoo.entity.generator.member.MemberApply;
import com.gooagoo.entity.generator.member.MemberApplyExample;
import com.gooagoo.entity.generator.member.MemberApplyKey;
import com.gooagoo.dao.generator.member.MemberApplyMapper;

@Service
public class MemberApplyGeneratorCoreServiceImpl implements MemberApplyGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(MemberApplyExample memberApplyExample) 
    {
        return this.memberApplyMapper.deleteByExample(memberApplyExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        MemberApplyKey memberApplyKey = new MemberApplyKey();
        memberApplyKey.setApplicationId(primaryKey);
        return this.memberApplyMapper.deleteByPrimaryKey(memberApplyKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(MemberApplyExample memberApplyExample) 
    {
        MemberApply memberApply = new MemberApply();
        memberApply.setIsDel("Y");
        return this.memberApplyMapper.updateByExampleSelective(memberApply,memberApplyExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        MemberApply memberApply = new MemberApply();
        memberApply.setApplicationId(primaryKey);
        memberApply.setIsDel("Y");
        return this.memberApplyMapper.updateByPrimaryKeySelective(memberApply) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(MemberApply memberApply) 
    {
        return this.memberApplyMapper.insertSelective(memberApply) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(MemberApply memberApply,MemberApplyExample memberApplyExample) 
    {
        return this.memberApplyMapper.updateByExampleSelective(memberApply,memberApplyExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(MemberApply memberApply) 
    {
        return this.memberApplyMapper.updateByPrimaryKeySelective(memberApply) > 0 ? true : false;
    }

}
