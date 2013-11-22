package com.gooagoo.mis.rsrcmanage.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.system.sys.version.SysVersionManageCoreService;
import com.gooagoo.api.generator.query.sys.MobileVersionGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.sys.MobileVersion;
import com.gooagoo.entity.generator.sys.MobileVersionExample;
import com.gooagoo.entity.generator.sys.MobileVersionExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.rsrcmanage.service.MobileVersionService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.mobileDevices.MMobileVersion;

@Service(value = "mobileVersionService")
public class MobileVersionImpl implements MobileVersionService
{
    @Autowired
    private SysVersionManageCoreService sysVersionManageCoreService;
    @Autowired
    private MobileVersionGeneratorQueryService mobileVersionGeneratorQueryService;

    /**
     * 查询设备类型信息
     */
    @Override
    public TransData<PageModel<MMobileVersion>> queryMobileVersion(HttpServletRequest request) throws Exception
    {
        MMobileVersion mmob = ServletUtils.objectMethod(MMobileVersion.class, request);
        MobileVersionExample example = new MobileVersionExample();
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(mmob.getVersionName()))
        {
            criteria.andVersionNameLike("%" + mmob.getVersionName() + "%");
        }
        if (StringUtils.hasText(mmob.getVersion()))
        {
            criteria.andVersionLike("%" + mmob.getVersion() + "%");
        }
        if (StringUtils.hasText(mmob.getMobileType()))
        {
            criteria.andMobileTypeEqualTo(mmob.getMobileType());
        }
        if (StringUtils.hasText(mmob.getPlatform()))
        {
            criteria.andPlatformEqualTo(mmob.getPlatform());
        }
        if (StringUtils.hasText(mmob.getIsDel()))
        {
            criteria.andIsDelEqualTo(mmob.getIsDel());
        }
        PageModel<MMobileVersion> pm = new PageModel<MMobileVersion>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageCondition.getPageSize() <= 10 ? 10 : pageCondition.getPageSize());
        }
        Integer count = this.mobileVersionGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            example.setPage(pm.getPageIndex(), pm.getPageSize());// 设置分页条件
            List<MobileVersion> mmobList = this.mobileVersionGeneratorQueryService.selectByExample(example);
            for (MobileVersion mobile : mmobList)
            {
                MMobileVersion mmoblie = new MMobileVersion();
                EntityTools.copyValue(mobile, mmoblie);
                pm.getResult().add(mmoblie);
            }
        }
        return new TransData<PageModel<MMobileVersion>>(true, null, pm);
    }

    /**
     * 新增设备类型
     */
    @Override
    public TransData<Object> addMobileVersion(HttpServletRequest request) throws Exception
    {
        MMobileVersion mmob = ServletUtils.objectMethod(MMobileVersion.class, request);
        MobileVersion mobile = new MobileVersion();
        EntityTools.copyValue(mmob, mobile);
        boolean flag = this.sysVersionManageCoreService.addSysMobileVersion(mobile);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.SYS_ADD_SUCCESS, MisMessageConst.SYS_ADD_FAIL);
    }

}
