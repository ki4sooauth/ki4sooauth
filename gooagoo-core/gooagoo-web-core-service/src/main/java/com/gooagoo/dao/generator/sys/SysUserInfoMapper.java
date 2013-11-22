package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.SysUserInfo;
import com.gooagoo.entity.generator.sys.SysUserInfoExample;
import com.gooagoo.entity.generator.sys.SysUserInfoKey;

public interface SysUserInfoMapper
{

    public Integer countByExample(SysUserInfoExample sysUserInfoExample);

    public List<SysUserInfo> selectByExample(SysUserInfoExample sysUserInfoExample);

    public SysUserInfo selectByPrimaryKey(SysUserInfoKey sysUserInfoKey);

    public Integer deleteByExample(SysUserInfoExample sysUserInfoExample);

    public Integer deleteByPrimaryKey(SysUserInfoKey sysUserInfoKey);

    public Integer insertSelective(SysUserInfo sysUserInfo);

    public Integer updateAllByExample(@Param("record") SysUserInfo sysUserInfo, @Param("example") SysUserInfoExample sysUserInfoExample);

    public Integer updateByExampleSelective(@Param("record") SysUserInfo sysUserInfo, @Param("example") SysUserInfoExample sysUserInfoExample);

    public Integer updateByPrimaryKeySelective(SysUserInfo sysUserInfo);

}
