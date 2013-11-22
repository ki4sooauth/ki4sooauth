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

import com.gooagoo.api.business.core.system.sys.dictionary.InterfaceRequestInfoDicCoreService;
import com.gooagoo.api.generator.query.sys.InterfaceBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.InterfaceRequestInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfo;
import com.gooagoo.entity.generator.sys.InterfaceRequestInfo;
import com.gooagoo.entity.generator.sys.InterfaceRequestInfoExample;
import com.gooagoo.entity.generator.sys.InterfaceRequestInfoExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.sysmanage.service.InterfaceRequestDictionaryService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MInterfaceRequestInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service(value = "interfaceRequestDictionaryService")
public class InterFaceRequestDictionaryServiceImpl implements InterfaceRequestDictionaryService
{
    @Autowired
    private InterfaceRequestInfoGeneratorQueryService interfaceRequestInfoGeneratorQueryService;
    @Autowired
    private InterfaceRequestInfoDicCoreService interfaceRequestInfoDicCoreService;
    @Autowired
    private InterfaceBaseInfoGeneratorQueryService interfaceBaseInfoGeneratorQueryService;

    /**
     * 添加接口请求参数信息表数据
     */
    @Override
    public TransData<Object> addInterfactRequest(HttpServletRequest request) throws Exception
    {
        MInterfaceRequestInfo mbase = ServletUtils.objectMethod(MInterfaceRequestInfo.class, request);
        InterfaceRequestInfo base = new InterfaceRequestInfo();
        EntityTools.copyValue(mbase, base);
        boolean flag = this.interfaceRequestInfoDicCoreService.addInterfaceRequestInfoDic(base);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_ADD_SUCCESS, MisMessageConst.MIS_SYS_DIC_ADD_FAIL, base.getId().toString());
    }

    /**
     * 修改接口请求参数信息表数据
     */
    @Override
    public TransData<Object> editInterfactRequest(HttpServletRequest request) throws Exception
    {
        MInterfaceRequestInfo mbase = ServletUtils.objectMethod(MInterfaceRequestInfo.class, request);
        InterfaceRequestInfo base = new InterfaceRequestInfo();
        EntityTools.copyValue(mbase, base);
        boolean flag = this.interfaceRequestInfoDicCoreService.updateInterfaceRequestInfoDic(base);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_UPD_SUCCESS, MisMessageConst.MIS_SYS_DIC_UPD_FAIL, base.getId().toString());
    }

    /**
     * 删除接口请求参数信息表数据
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delInterfactRequest(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");
        String[] ids = dicIds.split(",");
        boolean flag = false;
        for (int i = 0; i < ids.length; i++)
        {
            flag = this.interfaceRequestInfoDicCoreService.delInterfaceRequestInfoDic(ids[i]);
            if (!flag)
            {
                break;
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_DEL_SUCCESS, MisMessageConst.MIS_SYS_DIC_DEL_FAIL);
    }

    /**
     * 查询接口请求参数信息表详细信息
     */
    @Override
    public TransData<MInterfaceRequestInfo> findInterfactRequestDetail(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");// 字典Id
        InterfaceRequestInfo base = this.interfaceRequestInfoGeneratorQueryService.selectByPrimaryKey("".equals(dicIds.split(",")[0]) ? null : Integer.parseInt(dicIds.split(",")[0]));
        if (base != null)
        {
            MInterfaceRequestInfo mbase = new MInterfaceRequestInfo();
            EntityTools.copyValue(base, mbase);
            return new TransData<MInterfaceRequestInfo>(true, null, mbase);
        }
        else
        {
            return new TransData<MInterfaceRequestInfo>(false, MisMessageConst.MIS_SYS_DIC_GET_INFO_FAIL, null);
        }
    }

    /**
     * 查询接口请求参数信息表数据
     */
    @Override
    public TransData<PageModel<MInterfaceRequestInfo>> findInterfactRequestAllDict(HttpServletRequest request) throws Exception
    {
        InterfaceRequestInfoExample baseExample = new InterfaceRequestInfoExample();
        MInterfaceRequestInfo baseDictionary = ServletUtils.objectMethod(MInterfaceRequestInfo.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        Criteria criteria = baseExample.createCriteria();
        if (StringUtils.hasText(baseDictionary.getiCode()))
        {
            criteria.andICodeLike("%" + baseDictionary.getiCode() + "%");
        }
        if (StringUtils.hasText(baseDictionary.getNameEn()))
        {
            criteria.andNameEnLike("%" + baseDictionary.getNameEn() + "%");
        }
        if (StringUtils.hasText(baseDictionary.getNameEn()))
        {
            criteria.andNameEnLike("%" + baseDictionary.getNameEn() + "%");
        }
        if (StringUtils.hasText(baseDictionary.getIsRequired()))
        {
            criteria.andIsRequiredEqualTo(baseDictionary.getIsRequired());
        }
        if (StringUtils.hasText(baseDictionary.getNote()))
        {
            criteria.andNoteLike("%" + baseDictionary.getNote() + "%");
        }
        PageModel<MInterfaceRequestInfo> pm = new PageModel<MInterfaceRequestInfo>();
        pm.setPageIndex(pageCondition.getPageIndex());
        pm.setPageSize(pageSize);
        Integer count = this.interfaceRequestInfoGeneratorQueryService.countByExample(baseExample);
        pm.setCount(count);
        if (count > 0)
        {
            baseExample.setPage(pageCondition.getPageIndex(), pageSize);// 设置分页条件
            List<InterfaceRequestInfo> list = this.interfaceRequestInfoGeneratorQueryService.selectByExample(baseExample);
            for (InterfaceRequestInfo inter : list)
            {
                MInterfaceRequestInfo base = new MInterfaceRequestInfo();
                EntityTools.copyValue(inter, base);
                pm.getResult().add(base);
            }
        }
        return new TransData<PageModel<MInterfaceRequestInfo>>(true, null, pm);
    }

    /**
     * 校验接口编码是否存在
     */
    @Override
    public TransData<Object> checkIcode(HttpServletRequest request) throws Exception
    {
        String icode = ServletRequestUtils.getStringParameter(request, "icode", "");
        InterfaceBaseInfo base = this.interfaceBaseInfoGeneratorQueryService.selectUnDelByPrimaryKey(icode);
        return new TransData<Object>(base == null ? true : false, null, null);
    }

    /**
     * 批量新增接口请求参数信息表数据
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addAllInterfactRequestDetail(HttpServletRequest request) throws Exception
    {
        String dictList = ServletRequestUtils.getStringParameter(request, "dictList");
        List<MInterfaceRequestInfo> sysList = new Gson().fromJson(dictList, new TypeToken<List<MInterfaceRequestInfo>>()
        {
        }.getType());
        if (sysList == null || sysList.size() <= 0)
        {
            return UtilsMis.getBooleanResult(false, null, MisMessageConst.MIS_DICTIARY_BATCH_EXCEL_FAIL);
        }
        List<InterfaceRequestInfo> interList = new ArrayList<InterfaceRequestInfo>();
        for (MInterfaceRequestInfo sys : sysList)
        {
            InterfaceRequestInfo sysDict = new InterfaceRequestInfo();
            EntityTools.copyValue(sys, sysDict);
            interList.add(sysDict);
        }
        boolean flag = this.interfaceRequestInfoDicCoreService.addAllInterfaceRequestInfoDic(interList);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_DICTIARY_BATCH_SYS_SUCCESS, MisMessageConst.MIS_DICTIARY_BATCH_SYS_FAIL);
    }

}
