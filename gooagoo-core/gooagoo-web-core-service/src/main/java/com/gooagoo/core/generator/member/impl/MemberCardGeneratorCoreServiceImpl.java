package com.gooagoo.core.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.member.MemberCardGeneratorCoreService;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.member.MemberCardKey;
import com.gooagoo.dao.generator.member.MemberCardMapper;

@Service
public class MemberCardGeneratorCoreServiceImpl implements MemberCardGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(MemberCardExample memberCardExample) 
    {
        return this.memberCardMapper.deleteByExample(memberCardExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        MemberCardKey memberCardKey = new MemberCardKey();
        memberCardKey.setCardId(primaryKey);
        return this.memberCardMapper.deleteByPrimaryKey(memberCardKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(MemberCardExample memberCardExample) 
    {
        MemberCard memberCard = new MemberCard();
        memberCard.setIsDel("Y");
        return this.memberCardMapper.updateByExampleSelective(memberCard,memberCardExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        MemberCard memberCard = new MemberCard();
        memberCard.setCardId(primaryKey);
        memberCard.setIsDel("Y");
        return this.memberCardMapper.updateByPrimaryKeySelective(memberCard) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(MemberCard memberCard) 
    {
        return this.memberCardMapper.insertSelective(memberCard) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(MemberCard memberCard,MemberCardExample memberCardExample) 
    {
        return this.memberCardMapper.updateByExampleSelective(memberCard,memberCardExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(MemberCard memberCard) 
    {
        return this.memberCardMapper.updateByPrimaryKeySelective(memberCard) > 0 ? true : false;
    }

}
