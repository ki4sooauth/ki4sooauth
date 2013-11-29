package com.gooagoo.core.business.system.sys.version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.sys.version.SysVersionManageCoreService;
import com.gooagoo.api.generator.core.sys.MobileVersionGeneratorCoreService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.sys.MobileVersion;
import com.gooagoo.entity.generator.sys.MobileVersionExample;

@Service
public class SysVersionManageCoreServiceImpl implements SysVersionManageCoreService
{

    @Autowired
    private MobileVersionGeneratorCoreService mobileVersionGeneratorCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addSysMobileVersion(MobileVersion mobileVersion) throws Exception
    {
        //新增版本前将对应类型的所有旧版软删除
        MobileVersion delMobileVersion = new MobileVersion();
        delMobileVersion.setIsDel("Y");
        MobileVersionExample mobileVersionExample = new MobileVersionExample();
        mobileVersionExample.createCriteria().andMobileTypeEqualTo(mobileVersion.getMobileType()).andIsDelEqualTo("N");
        this.mobileVersionGeneratorCoreService.updateByExampleSelective(delMobileVersion, mobileVersionExample);
        mobileVersion.setId(UUID.getUUID());
        mobileVersion.setIsDel("N");
        return this.mobileVersionGeneratorCoreService.insertSelective(mobileVersion);
    }
}
