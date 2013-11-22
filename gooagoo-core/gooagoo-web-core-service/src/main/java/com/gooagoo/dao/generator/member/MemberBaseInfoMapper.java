package com.gooagoo.dao.generator.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.entity.generator.member.MemberBaseInfoKey;

public interface MemberBaseInfoMapper
{

    public Integer countByExample(MemberBaseInfoExample memberBaseInfoExample);

    public List<MemberBaseInfo> selectByExample(MemberBaseInfoExample memberBaseInfoExample);

    public MemberBaseInfo selectByPrimaryKey(MemberBaseInfoKey memberBaseInfoKey);

    public Integer deleteByExample(MemberBaseInfoExample memberBaseInfoExample);

    public Integer deleteByPrimaryKey(MemberBaseInfoKey memberBaseInfoKey);

    public Integer insertSelective(MemberBaseInfo memberBaseInfo);

    public Integer updateAllByExample(@Param("record") MemberBaseInfo memberBaseInfo, @Param("example") MemberBaseInfoExample memberBaseInfoExample);

    public Integer updateByExampleSelective(@Param("record") MemberBaseInfo memberBaseInfo, @Param("example") MemberBaseInfoExample memberBaseInfoExample);

    public Integer updateByPrimaryKeySelective(MemberBaseInfo memberBaseInfo);

}
