package com.gooagoo.dao.generator.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.member.MemberApply;
import com.gooagoo.entity.generator.member.MemberApplyExample;
import com.gooagoo.entity.generator.member.MemberApplyKey;

public interface MemberApplyMapper
{

    public Integer countByExample(MemberApplyExample memberApplyExample);

    public List<MemberApply> selectByExample(MemberApplyExample memberApplyExample);

    public MemberApply selectByPrimaryKey(MemberApplyKey memberApplyKey);

    public Integer deleteByExample(MemberApplyExample memberApplyExample);

    public Integer deleteByPrimaryKey(MemberApplyKey memberApplyKey);

    public Integer insertSelective(MemberApply memberApply);

    public Integer updateAllByExample(@Param("record") MemberApply memberApply, @Param("example") MemberApplyExample memberApplyExample);

    public Integer updateByExampleSelective(@Param("record") MemberApply memberApply, @Param("example") MemberApplyExample memberApplyExample);

    public Integer updateByPrimaryKeySelective(MemberApply memberApply);

}
