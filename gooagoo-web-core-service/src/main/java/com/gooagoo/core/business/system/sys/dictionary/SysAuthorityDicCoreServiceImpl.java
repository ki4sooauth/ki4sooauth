package com.gooagoo.core.business.system.sys.dictionary;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.sys.dictionary.SysAuthorityDicCoreService;
import com.gooagoo.api.generator.core.sys.SysAuthorityGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.sys.SysAuthority;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class SysAuthorityDicCoreServiceImpl implements SysAuthorityDicCoreService

{

    @Autowired
    private SysAuthorityGeneratorCoreService sysAuthorityGeneratorCoreService;

    @Override
    public boolean addSysAuthorityDic(SysAuthority sysAuthority) throws Exception
    {
        sysAuthority.setIsDel("N");
        return this.sysAuthorityGeneratorCoreService.insertSelective(sysAuthority);
    }

    @Override
    public boolean updateSysAuthorityDic(SysAuthority sysAuthority) throws Exception
    {
        return this.sysAuthorityGeneratorCoreService.updateByPrimaryKeySelective(sysAuthority);
    }

    @Override
    public boolean delSysAuthorityDic(String authorityId) throws Exception
    {
        SysAuthority sysAuthority = new SysAuthority();
        sysAuthority.setAuthorityId(authorityId);
        sysAuthority.setIsDel("Y");
        return this.sysAuthorityGeneratorCoreService.updateByPrimaryKeySelective(sysAuthority);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addAllSysAuthorityDic(List<SysAuthority> sysList) throws Exception
    {
        if (!CollectionUtils.isNotEmpty(sysList))
        {
            GooagooLog.info("对象内容为空");
            return false;
        }
        if (!this.sysAuthorityGeneratorCoreService.deleteByExample(null))
        {
            GooagooLog.info("清空后台管理权限表失败");
            throw new OperateFailException("清空后台管理权限表失败");
        }
        for (SysAuthority inter : sysList)
        {
            if (!this.sysAuthorityGeneratorCoreService.insertSelective(inter))
            {
                throw new OperateFailException("新增后台管理权限失败" + new Gson().toJson(inter));
            }
        }
        return true;
    }

}
