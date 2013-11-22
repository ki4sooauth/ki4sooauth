package com.gooagoo.mis.rsrcmanage.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.hierarchy.PlatformRegionCoreService;
import com.gooagoo.api.generator.query.sys.PlatformRegionGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.sys.PlatformRegion;
import com.gooagoo.entity.generator.sys.PlatformRegionExample;
import com.gooagoo.entity.generator.sys.PlatformRegionExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.rsrcmanage.service.PlatformRegionService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.systemHierarchy.MPlatformRegion;

@Service(value = "platformRegionService")
public class PlatformRegionServiceImpl implements PlatformRegionService
{
    @Autowired
    private PlatformRegionGeneratorQueryService platformRegionGeneratorQueryService;
    @Autowired
    private PlatformRegionCoreService platformRegionCoreService;

    /**
     * 新增小平台信息
     */
    @Override
    public TransData<Object> addPlatformRegion(HttpServletRequest request) throws Exception
    {
        PlatformRegion platformRegion = ServletUtils.objectMethod(PlatformRegion.class, request);
        boolean flag = this.platformRegionCoreService.addPlatformRegion(platformRegion);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.SYS_ADD_SUCCESS, MisMessageConst.SYS_ADD_FAIL);
    }

    /**
     * 删除小平台信息
     */
    @Override
    public TransData<Object> deletePlatformRegion(HttpServletRequest request) throws Exception
    {
        PlatformRegion platformRegion = ServletUtils.objectMethod(PlatformRegion.class, request);
        boolean flag = this.platformRegionCoreService.batchDeletePlatformRegion(platformRegion.getPlatformId());
        return UtilsMis.getBooleanResult(flag, MisMessageConst.SYS_DEL_SUCCESS, MisMessageConst.SYS_DEL_FAIL);
    }

    /**
     * 查询小平台详细信息
     */
    @Override
    public TransData<MPlatformRegion> queryPlatformRegionInfo(HttpServletRequest request) throws Exception
    {
        PlatformRegion platformRegion = ServletUtils.objectMethod(PlatformRegion.class, request);
        PlatformRegion platform = this.platformRegionGeneratorQueryService.selectUnDelByPrimaryKey(platformRegion.getPlatformId().split(",")[0]);
        if (platform != null)
        {
            MPlatformRegion mplatform = new MPlatformRegion();
            EntityTools.copyValue(platform, mplatform);
            return new TransData<MPlatformRegion>(true, null, mplatform);
        }
        else
        {
            return new TransData<MPlatformRegion>(true, MisMessageConst.SYS_LOAD_DATA_ERROR, null);
        }
    }

    /**
     * 修改小平台信息
     */
    @Override
    public TransData<Object> updatePlatformRegion(HttpServletRequest request) throws Exception
    {
        PlatformRegion platformRegion = ServletUtils.objectMethod(PlatformRegion.class, request);
        boolean flag = this.platformRegionCoreService.updatePlatformRegion(platformRegion);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.SYS_UPD_SUCCESS, MisMessageConst.SYS_UPD_FAIL);
    }

    /**
     * 查询所有小平台信息
     */
    @Override
    public TransData<PageModel<MPlatformRegion>> queryPlatformRegionList(HttpServletRequest request) throws Exception
    {
        PlatformRegion platformRegion = ServletUtils.objectMethod(PlatformRegion.class, request);
        String platformNoPage = ServletRequestUtils.getStringParameter(request, "platformNoPage", null);//是否分页查询（null时分页查询）
        PlatformRegionExample example = new PlatformRegionExample();
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (StringUtils.hasText(platformRegion.getPlatformName()))
        {
            criteria.andPlatformNameLike("%" + platformRegion.getPlatformName() + "%");
        }
        PageModel<MPlatformRegion> pm = new PageModel<MPlatformRegion>();
        PageCondition conditon = ServletUtils.objectMethod(PageCondition.class, request);
        if (conditon != null && platformNoPage == null)
        {
            pm.setPageIndex(conditon.getPageIndex() <= 1 ? 1 : conditon.getPageIndex());
            pm.setPageSize(conditon.getPageSize() <= 10 ? 10 : conditon.getPageSize());
        }
        Integer count = this.platformRegionGeneratorQueryService.countByExample(example);
        if (count > 0)
        {
            if (conditon != null && platformNoPage == null)
            {
                example.setPage(pm.getPageIndex(), pm.getPageSize());
            }
            List<PlatformRegion> platformList = this.platformRegionGeneratorQueryService.selectByExample(example);
            for (PlatformRegion platform : platformList)
            {
                MPlatformRegion mplatform = new MPlatformRegion();
                EntityTools.copyValue(platform, mplatform);
                pm.getResult().add(mplatform);
            }
        }
        return new TransData<PageModel<MPlatformRegion>>(true, null, pm);
    }

}
