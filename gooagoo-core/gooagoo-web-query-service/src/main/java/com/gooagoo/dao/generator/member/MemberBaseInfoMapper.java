package com.gooagoo.dao.generator.member;

import java.util.List;

import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.member.MemberBaseInfoKey;

public interface MemberBaseInfoMapper
{

    public Integer countByExample(MemberBaseInfoExample memberBaseInfoExample);

    public List<MemberBaseInfo> selectByExample(MemberBaseInfoExample memberBaseInfoExample);

    public MemberBaseInfo selectByPrimaryKey(MemberBaseInfoKey memberBaseInfoKey);

}
