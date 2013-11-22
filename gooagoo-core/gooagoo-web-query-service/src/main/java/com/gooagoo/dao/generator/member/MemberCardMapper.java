package com.gooagoo.dao.generator.member;

import java.util.List;

import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.entity.generator.member.MemberCardKey;

public interface MemberCardMapper
{

    public Integer countByExample(MemberCardExample memberCardExample);

    public List<MemberCard> selectByExample(MemberCardExample memberCardExample);

    public MemberCard selectByPrimaryKey(MemberCardKey memberCardKey);

}
