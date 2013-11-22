package com.gooagoo.mis.sysmanage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.sys.dictionary.SysAuthorityDicCoreService;
import com.gooagoo.api.generator.query.sys.SysAuthorityGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.sys.SysAuthority;
import com.gooagoo.entity.generator.sys.SysAuthorityExample;
import com.gooagoo.entity.generator.sys.SysAuthorityExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.sysmanage.service.SysAuthorityDictionaryService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MSysAuthority;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service(value = "sysAuthorityDictionaryService")
public class SysAuthorityDictionaryServiceImpl implements SysAuthorityDictionaryService
{
    @Autowired
    private SysAuthorityGeneratorQueryService sysAuthorityGeneratorQueryService;
    @Autowired
    private SysAuthorityDicCoreService sysAuthorityDicCoreService;

    /**
     * 添加后台管理权限表数据
     */
    @Override
    public TransData<Object> addSysAuthority(HttpServletRequest request) throws Exception
    {
        MSysAuthority mbase = ServletUtils.objectMethod(MSysAuthority.class, request);
        if (mbase != null)
        {
            SysAuthority base = this.sysAuthorityGeneratorQueryService.selectUnDelByPrimaryKey(mbase.getAuthorityId());
            if (base != null)
            {
                return new TransData<Object>(false, MisMessageConst.MIS_DICTIARY_PARAMETER_SYSAUTH_FAIL, null);
            }
        }
        SysAuthority base = new SysAuthority();
        EntityTools.copyValue(mbase, base);
        boolean flag = this.sysAuthorityDicCoreService.addSysAuthorityDic(base);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_ADD_SUCCESS, MisMessageConst.MIS_SYS_DIC_ADD_FAIL, base.getAuthorityId());
    }

    /**
     * 修改后台管理权限表数据
     */
    @Override
    public TransData<Object> editSysAuthority(HttpServletRequest request) throws Exception
    {
        MSysAuthority mbase = ServletUtils.objectMethod(MSysAuthority.class, request);
        SysAuthority base = new SysAuthority();
        EntityTools.copyValue(mbase, base);
        boolean flag = this.sysAuthorityDicCoreService.updateSysAuthorityDic(base);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_UPD_SUCCESS, MisMessageConst.MIS_SYS_DIC_UPD_FAIL, base.getAuthorityId());
    }

    /**
     * 删除后台管理权限表数据
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delSysAuthority(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");
        String[] ids = dicIds.split(",");
        boolean flag = false;
        for (int i = 0; i < ids.length; i++)
        {
            flag = this.sysAuthorityDicCoreService.delSysAuthorityDic(ids[i]);
            if (!flag)
            {
                break;
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_DEL_SUCCESS, MisMessageConst.MIS_SYS_DIC_DEL_FAIL);
    }

    /**
     * 查询后台管理权限表详细信息
     */
    @Override
    public TransData<MSysAuthority> findSysAuthorityDetail(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");// 字典Id
        SysAuthority base = this.sysAuthorityGeneratorQueryService.selectUnDelByPrimaryKey(dicIds.split(",")[0]);
        if (base != null)
        {
            MSysAuthority mbase = new MSysAuthority();
            EntityTools.copyValue(base, mbase);
            return new TransData<MSysAuthority>(true, null, mbase);
        }
        else
        {
            return new TransData<MSysAuthority>(false, MisMessageConst.MIS_SYS_DIC_GET_INFO_FAIL, null);
        }
    }

    /**
     * 查询后台管理权限表数据
     */
    @Override
    public TransData<PageModel<MSysAuthority>> findSysAuthorityAllDict(HttpServletRequest request) throws Exception
    {
        SysAuthorityExample baseExample = new SysAuthorityExample();
        MSysAuthority baseDictionary = ServletUtils.objectMethod(MSysAuthority.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        Criteria criteria = baseExample.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (StringUtils.hasText(baseDictionary.getAuthorityId()))
        {
            criteria.andAuthorityIdLike("%" + baseDictionary.getAuthorityId() + "%");
        }
        if (StringUtils.hasText(baseDictionary.getAuthorityName()))
        {
            criteria.andAuthorityNameLike("%" + baseDictionary.getAuthorityName() + "%");
        }
        if (StringUtils.hasText(baseDictionary.getParentAuthorityId()))
        {
            criteria.andParentAuthorityIdLike("%" + baseDictionary.getParentAuthorityId() + "%");
        }
        if (StringUtils.hasText(baseDictionary.getLink()))
        {
            criteria.andLinkLike("%" + baseDictionary.getLink() + "%");
        }
        if (baseDictionary.getOrderNo() != null)
        {
            criteria.andOrderNoLike("%" + baseDictionary.getOrderNo().toString() + "%");
        }
        if (StringUtils.hasText(baseDictionary.getNote()))
        {
            criteria.andNoteLike("%" + baseDictionary.getNote() + "%");
        }
        PageModel<MSysAuthority> pm = new PageModel<MSysAuthority>();
        pm.setPageIndex(pageCondition.getPageIndex());
        pm.setPageSize(pageSize);
        Integer count = this.sysAuthorityGeneratorQueryService.countByExample(baseExample);
        pm.setCount(count);
        if (count > 0)
        {
            baseExample.setPage(pageCondition.getPageIndex(), pageSize);// 设置分页条件
            List<SysAuthority> list = this.sysAuthorityGeneratorQueryService.selectByExample(baseExample);
            for (SysAuthority inter : list)
            {
                MSysAuthority base = new MSysAuthority();
                EntityTools.copyValue(inter, base);
                pm.getResult().add(base);
            }
        }
        return new TransData<PageModel<MSysAuthority>>(true, null, pm);
    }

    /**
     * 批量新增后台管理权限表数据
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addAllSysAuthority(HttpServletRequest request) throws Exception
    {
        String dictList = ServletRequestUtils.getStringParameter(request, "dictList");
        List<MSysAuthority> sysList = new Gson().fromJson(dictList, new TypeToken<List<MSysAuthority>>()
        {
        }.getType());
        if (sysList == null || sysList.size() <= 0)
        {
            return UtilsMis.getBooleanResult(false, null, MisMessageConst.MIS_DICTIARY_BATCH_EXCEL_FAIL);
        }
        List<SysAuthority> interList = new ArrayList<SysAuthority>();
        for (MSysAuthority sys : sysList)
        {
            SysAuthority sysDict = new SysAuthority();
            EntityTools.copyValue(sys, sysDict);
            interList.add(sysDict);
        }
        boolean flag = this.sysAuthorityDicCoreService.addAllSysAuthorityDic(interList);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_DICTIARY_BATCH_SYS_SUCCESS, MisMessageConst.MIS_DICTIARY_BATCH_SYS_FAIL);
    }
}
