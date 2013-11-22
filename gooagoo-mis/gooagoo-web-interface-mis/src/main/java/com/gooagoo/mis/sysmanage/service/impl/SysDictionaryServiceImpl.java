package com.gooagoo.mis.sysmanage.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.sys.dictionary.UniversalDicCoreService;
import com.gooagoo.api.generator.query.base.SysDictionaryGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.base.SysDictionary;
import com.gooagoo.entity.generator.base.SysDictionaryExample;
import com.gooagoo.entity.generator.base.SysDictionaryExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.sysmanage.service.SysDictionaryService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MSysDictionary;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service(value = "sysDictionaryService")
public class SysDictionaryServiceImpl implements SysDictionaryService
{

    @Autowired
    private UniversalDicCoreService universalDicCoreService;
    @Autowired
    private SysDictionaryGeneratorQueryService sysDictionaryGeneratorQueryService;

    /**
     * 通用字典添加
     */
    @Override
    public TransData<Object> addDic(HttpServletRequest request) throws Exception
    {
        MSysDictionary msysDictionary = ServletUtils.objectMethod(MSysDictionary.class, request);
        SysDictionary sys = new SysDictionary();
        EntityTools.copyValue(msysDictionary, sys);
        boolean flag = this.universalDicCoreService.addUniversalDic(sys);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_ADD_SUCCESS, MisMessageConst.MIS_SYS_DIC_ADD_FAIL, sys.getSysDictionaryId().toString());
    }

    /**
     * 通用字典编辑
     */
    @Override
    public TransData<Object> editDic(HttpServletRequest request) throws Exception
    {
        MSysDictionary msysDictionary = ServletUtils.objectMethod(MSysDictionary.class, request);
        SysDictionary sys = new SysDictionary();
        EntityTools.copyValue(msysDictionary, sys);
        boolean flag = this.universalDicCoreService.updateUniversalDic(sys);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_UPD_SUCCESS, MisMessageConst.MIS_SYS_DIC_UPD_FAIL, sys.getSysDictionaryId().toString());
    }

    /**
     * 通用字典删除
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delDic(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");//字典Id
        String[] ids = dicIds.split(",");
        boolean flag = false;
        for (int i = 0; i < ids.length; i++)
        {
            flag = this.universalDicCoreService.delUniversalDic(ids[i]);
            if (!flag)
            {
                break;
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_DEL_SUCCESS, MisMessageConst.MIS_SYS_DIC_DEL_FAIL);
    }

    /**
     * 查询通用字典详情
     */
    @Override
    public TransData<MSysDictionary> findSysDictDetail(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");// 字典Id
        SysDictionary sysDictionary = this.sysDictionaryGeneratorQueryService.selectUnDelByPrimaryKey("".equals(dicIds.split(",")[0]) ? null : Integer.parseInt(dicIds.split(",")[0]));
        if (sysDictionary != null && !"".equals(sysDictionary))
        {
            MSysDictionary msys = new MSysDictionary();
            EntityTools.copyValue(sysDictionary, msys);
            return new TransData<MSysDictionary>(true, null, msys);
        }
        else
        {
            return new TransData<MSysDictionary>(false, MisMessageConst.MIS_SYS_DIC_GET_INFO_FAIL, null);
        }
    }

    /**
     * 查询通用字典信息
     */
    @Override
    public TransData<PageModel<MSysDictionary>> findAllDict(HttpServletRequest request) throws Exception
    {
        SysDictionaryExample sysDicExample = new SysDictionaryExample();
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        MSysDictionary sysDictionary = ServletUtils.objectMethod(MSysDictionary.class, request);
        Criteria criteria = sysDicExample.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (StringUtils.hasText(sysDictionary.getDictionaryType()))
        {
            criteria.andDictionaryTypeLike("%" + sysDictionary.getDictionaryType() + "%");
        }
        if (StringUtils.hasText(sysDictionary.getDictionaryName()))
        {
            criteria.andDictionaryNameLike("%" + sysDictionary.getDictionaryName() + "%");
        }
        if (StringUtils.hasText(sysDictionary.getChineseName()))
        {
            criteria.andChineseNameLike("%" + sysDictionary.getChineseName() + "%");
        }
        if (StringUtils.hasText(sysDictionary.getEnglishName()))
        {
            criteria.andEnglishNameLike("%" + sysDictionary.getEnglishName() + "%");
        }
        if (StringUtils.hasText(sysDictionary.getNote()))
        {
            criteria.andNoteLike("%" + sysDictionary.getNote() + "%");
        }
        PageModel<MSysDictionary> pm = new PageModel<MSysDictionary>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.sysDictionaryGeneratorQueryService.countByExample(sysDicExample);
        pm.setCount(count);
        if (count > 0)
        {
            sysDicExample.setPage(pm.getPageIndex(), pageSize);// 设置分页条件
            List<SysDictionary> list = this.sysDictionaryGeneratorQueryService.selectByExample(sysDicExample);
            for (SysDictionary dictionary : list)
            {
                MSysDictionary msys = new MSysDictionary();
                EntityTools.copyValue(dictionary, msys);
                pm.getResult().add(msys);
            }
        }
        return new TransData<PageModel<MSysDictionary>>(true, null, pm);
    }

    /**
     * 批量新增通用字典数据
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addAllDicList(HttpServletRequest request) throws Exception
    {
        String dictList = ServletRequestUtils.getStringParameter(request, "dictList");
        List<MSysDictionary> sysList = new Gson().fromJson(dictList, new TypeToken<List<MSysDictionary>>()
        {
        }.getType());
        if (sysList == null || sysList.size() <= 0)
        {
            return UtilsMis.getBooleanResult(false, null, MisMessageConst.MIS_DICTIARY_BATCH_EXCEL_FAIL);
        }
        List<SysDictionary> interList = new ArrayList<SysDictionary>();
        for (MSysDictionary sys : sysList)
        {
            SysDictionary sysDict = new SysDictionary();
            EntityTools.copyValue(sys, sysDict);
            interList.add(sysDict);
        }
        boolean flag = this.universalDicCoreService.addAllUniversalDic(interList);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_DICTIARY_BATCH_SYS_SUCCESS, MisMessageConst.MIS_DICTIARY_BATCH_SYS_FAIL);
    }

    /**
     * 查询通用字典数据（无分页）
     */
    @Override
    public TransData<List<MSysDictionary>> findAllDictInfo(HttpServletRequest request) throws Exception
    {
        SysDictionaryExample sysDicExample = new SysDictionaryExample();
        // 设置查询条件
        MSysDictionary sysDictionary = ServletUtils.objectMethod(MSysDictionary.class, request);
        Criteria criteria = sysDicExample.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (sysDictionary.getSysDictionaryId() != null && sysDictionary.getSysDictionaryId() > 0)
        {
            criteria.andSysDictionaryIdEqualTo(sysDictionary.getSysDictionaryId().toString());
        }
        if (StringUtils.hasText(sysDictionary.getDictionaryType()))
        {
            criteria.andDictionaryTypeEqualTo(sysDictionary.getDictionaryType());
        }
        if (StringUtils.hasText(sysDictionary.getDictionaryName()))
        {
            criteria.andDictionaryNameEqualTo(sysDictionary.getDictionaryName());
        }
        if (StringUtils.hasText(sysDictionary.getChineseName()))
        {
            criteria.andChineseNameEqualTo(sysDictionary.getChineseName());
        }
        if (StringUtils.hasText(sysDictionary.getEnglishName()))
        {
            if (sysDictionary.getEnglishName().indexOf(",") > 0)
            {
                List<String> strList = Arrays.asList(sysDictionary.getEnglishName().split(","));
                criteria.andEnglishNameIn(strList);
            }
            else
            {
                criteria.andEnglishNameEqualTo(sysDictionary.getEnglishName());
            }
        }
        if (StringUtils.hasText(sysDictionary.getNote()))
        {
            criteria.andNoteEqualTo(sysDictionary.getNote());
        }
        List<MSysDictionary> sysList = new ArrayList<MSysDictionary>();
        List<SysDictionary> list = this.sysDictionaryGeneratorQueryService.selectByExample(sysDicExample);
        if (list != null && list.size() > 0)
        {
            for (SysDictionary dictionary : list)
            {
                MSysDictionary msys = new MSysDictionary();
                EntityTools.copyValue(dictionary, msys);
                sysList.add(msys);
            }
        }
        return new TransData<List<MSysDictionary>>(true, null, sysList);
    }

}
