package com.gooagoo.dao.generator.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.member.MemberCardKey;

public interface MemberCardMapper
{

    public Integer countByExample(MemberCardExample memberCardExample);

    public List<MemberCard> selectByExample(MemberCardExample memberCardExample);

    public MemberCard selectByPrimaryKey(MemberCardKey memberCardKey);

    public Integer deleteByExample(MemberCardExample memberCardExample);

    public Integer deleteByPrimaryKey(MemberCardKey memberCardKey);

    public Integer insertSelective(MemberCard memberCard);

    public Integer updateAllByExample(@Param("record") MemberCard memberCard, @Param("example") MemberCardExample memberCardExample);

    public Integer updateByExampleSelective(@Param("record") MemberCard memberCard, @Param("example") MemberCardExample memberCardExample);

    public Integer updateByPrimaryKeySelective(MemberCard memberCard);

}
