package com.gooagoo.dao.generator.member;

import java.util.List;

import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.entity.generator.member.MemberOfCardKey;

public interface MemberOfCardMapper
{

    public Integer countByExample(MemberOfCardExample memberOfCardExample);

    public List<MemberOfCard> selectByExample(MemberOfCardExample memberOfCardExample);

    public MemberOfCard selectByPrimaryKey(MemberOfCardKey memberOfCardKey);

}
