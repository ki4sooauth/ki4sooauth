package com.gooagoo.dao.generator.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.entity.generator.member.MemberOfCardKey;

public interface MemberOfCardMapper
{

    public Integer countByExample(MemberOfCardExample memberOfCardExample);

    public List<MemberOfCard> selectByExample(MemberOfCardExample memberOfCardExample);

    public MemberOfCard selectByPrimaryKey(MemberOfCardKey memberOfCardKey);

    public Integer deleteByExample(MemberOfCardExample memberOfCardExample);

    public Integer deleteByPrimaryKey(MemberOfCardKey memberOfCardKey);

    public Integer insertSelective(MemberOfCard memberOfCard);

    public Integer updateAllByExample(@Param("record") MemberOfCard memberOfCard, @Param("example") MemberOfCardExample memberOfCardExample);

    public Integer updateByExampleSelective(@Param("record") MemberOfCard memberOfCard, @Param("example") MemberOfCardExample memberOfCardExample);

    public Integer updateByPrimaryKeySelective(MemberOfCard memberOfCard);

}
