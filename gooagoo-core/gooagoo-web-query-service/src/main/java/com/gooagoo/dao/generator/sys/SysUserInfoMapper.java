package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.SysUserInfo;
import com.gooagoo.entity.generator.sys.SysUserInfoExample;
import com.gooagoo.entity.generator.sys.SysUserInfoKey;

public interface SysUserInfoMapper
{

    public Integer countByExample(SysUserInfoExample sysUserInfoExample);

    public List<SysUserInfo> selectByExample(SysUserInfoExample sysUserInfoExample);

    public SysUserInfo selectByPrimaryKey(SysUserInfoKey sysUserInfoKey);

}
