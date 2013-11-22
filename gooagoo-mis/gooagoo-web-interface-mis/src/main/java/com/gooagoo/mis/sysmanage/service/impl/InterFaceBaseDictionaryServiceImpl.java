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

import com.gooagoo.api.business.core.system.sys.dictionary.InterfaceBaseInfoDicCoreService;
import com.gooagoo.api.generator.query.sys.InterfaceBaseInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfo;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfoExample;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfoExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.sysmanage.service.InterfaceBaseDictionaryService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MInterfaceBaseInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service(value = "interFaceBaseDictionaryService")
public class InterFaceBaseDictionaryServiceImpl implements InterfaceBaseDictionaryService
{
    @Autowired
    private InterfaceBaseInfoGeneratorQueryService interfaceBaseInfoGeneratorQueryService;
    @Autowired
    private InterfaceBaseInfoDicCoreService interfaceBaseInfoDicCoreService;

    /**
     * 添加接口基础信息表数据
     */
    @Override
    public TransData<Object> addInterfactBase(HttpServletRequest request) throws Exception
    {
        MInterfaceBaseInfo mbase = ServletUtils.objectMethod(MInterfaceBaseInfo.class, request);
        if (mbase != null)
        {
            InterfaceBaseInfo base = this.interfaceBaseInfoGeneratorQueryService.selectUnDelByPrimaryKey(mbase.getiCode());
            if (base != null)
            {
                return new TransData<Object>(false, MisMessageConst.MIS_DICTIARY_PARAMETER_INTERBASE_FAIL, null);
            }
        }
        InterfaceBaseInfo base = new InterfaceBaseInfo();
        EntityTools.copyValue(mbase, base);
        if (base.getBehaveType() == null)
        {
            base.setBehaveType("");
            base.setDataXml("");
            base.setDataJson("");
            base.setNote("");
        }
        boolean flag = this.interfaceBaseInfoDicCoreService.addInterfaceBaseInfoDic(base);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_ADD_SUCCESS, MisMessageConst.MIS_SYS_DIC_ADD_FAIL, base.getICode());
    }

    /**
     * 修改接口基础信息表数据
     */
    @Override
    public TransData<Object> editInterfactBase(HttpServletRequest request) throws Exception
    {
        MInterfaceBaseInfo mbase = ServletUtils.objectMethod(MInterfaceBaseInfo.class, request);
        InterfaceBaseInfo base = new InterfaceBaseInfo();
        EntityTools.copyValue(mbase, base);
        boolean flag = this.interfaceBaseInfoDicCoreService.updateInterfaceBaseInfoDic(base);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_UPD_SUCCESS, MisMessageConst.MIS_SYS_DIC_UPD_FAIL, base.getICode());
    }

    /**
     * 删除接口基础信息表数据
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delInterfactBase(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");
        String[] ids = dicIds.split(",");
        boolean flag = false;
        for (int i = 0; i < ids.length; i++)
        {
            flag = this.interfaceBaseInfoDicCoreService.delInterfaceBaseInfoDic(ids[i]);
            if (!flag)
            {
                break;
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_DEL_SUCCESS, MisMessageConst.MIS_SYS_DIC_DEL_FAIL);
    }

    /**
     * 查询接口基础信息表详细信息
     */
    @Override
    public TransData<MInterfaceBaseInfo> findInterfactBaseDetail(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");// 字典Id
        InterfaceBaseInfo base = this.interfaceBaseInfoGeneratorQueryService.selectUnDelByPrimaryKey(dicIds.split(",")[0]);
        if (base != null)
        {
            MInterfaceBaseInfo mbase = new MInterfaceBaseInfo();
            EntityTools.copyValue(base, mbase);
            return new TransData<MInterfaceBaseInfo>(true, null, mbase);
        }
        else
        {
            return new TransData<MInterfaceBaseInfo>(false, MisMessageConst.MIS_SYS_DIC_GET_INFO_FAIL, null);
        }
    }

    /**
     * 查询接口基础信息表数据
     */
    @Override
    public TransData<PageModel<MInterfaceBaseInfo>> findInterfactBaseAllDict(HttpServletRequest request) throws Exception
    {
        InterfaceBaseInfoExample baseExample = new InterfaceBaseInfoExample();
        MInterfaceBaseInfo baseDictionary = ServletUtils.objectMethod(MInterfaceBaseInfo.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        Criteria criteria = baseExample.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (StringUtils.hasText(baseDictionary.getiCode()))
        {
            criteria.andICodeLike("%" + baseDictionary.getiCode() + "%");
        }
        if (StringUtils.hasText(baseDictionary.getiName()))
        {
            criteria.andINameLike("%" + baseDictionary.getiName() + "%");
        }
        if (StringUtils.hasText(baseDictionary.getiType()))
        {
            criteria.andITypeLike("%" + baseDictionary.getiType() + "%");
        }
        if (StringUtils.hasText(baseDictionary.getiFunction()))
        {
            criteria.andIFunctionLike("%" + baseDictionary.getiFunction() + "%");
        }
        if (StringUtils.hasText(baseDictionary.getiUrl()))
        {
            criteria.andIUrlLike("%" + baseDictionary.getiUrl() + "%");
        }
        if (StringUtils.hasText(baseDictionary.getBehaveType()))
        {
            criteria.andBehaveTypeEqualTo(baseDictionary.getBehaveType());
        }
        if (StringUtils.hasText(baseDictionary.getCanAllocate()))
        {
            criteria.andCanAllocateEqualTo(baseDictionary.getCanAllocate());
        }
        if (StringUtils.hasText(baseDictionary.getNote()))
        {
            criteria.andNoteLike("%" + baseDictionary.getNote() + "%");
        }
        PageModel<MInterfaceBaseInfo> pm = new PageModel<MInterfaceBaseInfo>();
        pm.setPageIndex(pageCondition.getPageIndex());
        pm.setPageSize(pageSize);
        Integer count = this.interfaceBaseInfoGeneratorQueryService.countByExample(baseExample);
        pm.setCount(count);
        if (count > 0)
        {
            baseExample.setPage(pageCondition.getPageIndex(), pageSize);// 设置分页条件
            List<InterfaceBaseInfo> list = this.interfaceBaseInfoGeneratorQueryService.selectByExample(baseExample);
            for (InterfaceBaseInfo inter : list)
            {
                MInterfaceBaseInfo base = new MInterfaceBaseInfo();
                EntityTools.copyValue(inter, base);
                pm.getResult().add(base);
            }
        }
        return new TransData<PageModel<MInterfaceBaseInfo>>(true, null, pm);
    }

    /**
     * 批量新增接口基础信息表数据
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addAllInterfactBaseDetail(HttpServletRequest request) throws Exception
    {
        String dictList = ServletRequestUtils.getStringParameter(request, "dictList");
        List<MInterfaceBaseInfo> sysList = new Gson().fromJson(dictList, new TypeToken<List<MInterfaceBaseInfo>>()
        {
        }.getType());
        if (sysList == null || sysList.size() <= 0)
        {
            return UtilsMis.getBooleanResult(false, null, MisMessageConst.MIS_DICTIARY_BATCH_EXCEL_FAIL);
        }
        List<InterfaceBaseInfo> interList = new ArrayList<InterfaceBaseInfo>();
        for (MInterfaceBaseInfo sys : sysList)
        {
            InterfaceBaseInfo sysDict = new InterfaceBaseInfo();
            EntityTools.copyValue(sys, sysDict);
            if (sysDict.getDataXml() == null)
            {
                sysDict.setDataXml("");
            }
            if (sysDict.getDataJson() == null)
            {
                sysDict.setDataJson("");
            }
            if (sysDict.getNote() == null)
            {
                sysDict.setNote("");
            }
            interList.add(sysDict);
        }
        boolean flag = this.interfaceBaseInfoDicCoreService.addAllInterfaceBaseInfoDic(interList);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_DICTIARY_BATCH_SYS_SUCCESS, MisMessageConst.MIS_DICTIARY_BATCH_SYS_FAIL);
    }

}
