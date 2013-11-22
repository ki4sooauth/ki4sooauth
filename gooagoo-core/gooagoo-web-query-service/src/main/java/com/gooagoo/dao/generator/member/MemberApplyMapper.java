package com.gooagoo.dao.generator.member;

import java.util.List;

import com.gooagoo.entity.generator.member.MemberApply;
import com.gooagoo.entity.generator.member.MemberApplyExample;
import com.gooagoo.entity.generator.member.MemberApplyKey;

public interface MemberApplyMapper
{

    public Integer countByExample(MemberApplyExample memberApplyExample);

    public List<MemberApply> selectByExample(MemberApplyExample memberApplyExample);

    public MemberApply selectByPrimaryKey(MemberApplyKey memberApplyKey);

}
