package com.gooagoo.core.business.system.sys.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.sys.user.SysUserManageCoreService;
import com.gooagoo.api.generator.core.sys.SysUserInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.sys.SysUserRoleGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.entity.generator.sys.SysUserInfo;
import com.gooagoo.entity.generator.sys.SysUserRole;
import com.gooagoo.entity.generator.sys.SysUserRoleExample;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class SysUserManageCoreServiceImpl implements SysUserManageCoreService
{

    @Autowired
    private SysUserInfoGeneratorCoreService sysUserInfoGeneratorCoreService;

    @Autowired
    private SysUserRoleGeneratorCoreService sysUserRoleGeneratorCoreService;

    @Override
    public boolean addSysUser(SysUserInfo sysUserInfo) throws Exception
    {
        sysUserInfo.setIsDel("N");
        return this.sysUserInfoGeneratorCoreService.insertSelective(sysUserInfo);
    }

    @Override
    public boolean updateSysUser(SysUserInfo sysUserInfo) throws Exception
    {
        return this.sysUserInfoGeneratorCoreService.updateByPrimaryKeySelective(sysUserInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean delSysUser(String userId) throws Exception
    {
        SysUserInfo sysUserInfo = new SysUserInfo();
        sysUserInfo.setUserId(userId);
        sysUserInfo.setIsDel("Y");
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        sysUserRoleExample.createCriteria().andUserIdEqualTo(userId);
        if (!this.sysUserInfoGeneratorCoreService.updateByPrimaryKeySelective(sysUserInfo))
        {
            GooagooLog.info("删除管理员用户表出错:" + new Gson().toJson(sysUserInfo));
            return false;
        }
        List<SysUserRole> sysUserRoles = this.sysUserRoleGeneratorCoreService.selectByExample(sysUserRoleExample);
        if (null == sysUserRoles || sysUserRoles.size() == 0)
        {
            return true;
        }
        else if (this.sysUserRoleGeneratorCoreService.deleteByExample(sysUserRoleExample))
        {
            return true;
        }
        else
        {
            GooagooLog.info("删除管理员的同时删除用户-角色关联表出错:" + JsonUtils.toJson(sysUserRoleExample));
            throw new OperateFailException("删除管理员的同时删除用户-角色关联表出错");
        }
    }
}
