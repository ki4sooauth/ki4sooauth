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

import com.gooagoo.api.business.core.system.sys.dictionary.ProvinceCityDicCoreService;
import com.gooagoo.api.generator.query.base.UserCityareaGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.base.UserCityarea;
import com.gooagoo.entity.generator.base.UserCityareaExample;
import com.gooagoo.entity.generator.base.UserCityareaExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.sysmanage.service.UserCityDictionaryService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MUserCityarea;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service(value = "userCityDictionaryService")
public class UserCityDictionaryServiceImpl implements UserCityDictionaryService
{
    @Autowired
    private ProvinceCityDicCoreService provinceCityDicCoreService;
    @Autowired
    private UserCityareaGeneratorQueryService userCityareaGeneratorQueryService;

    /**
     * 省份城市字典添加
     */
    @Override
    public TransData<Object> addUserDic(HttpServletRequest request) throws Exception
    {
        MUserCityarea muser = ServletUtils.objectMethod(MUserCityarea.class, request);
        UserCityarea user = new UserCityarea();
        EntityTools.copyValue(muser, user);
        boolean flag = this.provinceCityDicCoreService.addProvinceCityDic(user);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_ADD_SUCCESS, MisMessageConst.MIS_SYS_DIC_ADD_FAIL, user.getId().toString());
    }

    /**
     * 省份城市字典编辑
     */
    @Override
    public TransData<Object> editUserDic(HttpServletRequest request) throws Exception
    {
        MUserCityarea muser = ServletUtils.objectMethod(MUserCityarea.class, request);
        UserCityarea user = new UserCityarea();
        EntityTools.copyValue(muser, user);
        boolean flag = this.provinceCityDicCoreService.updateProvinceCityDic(user);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_UPD_SUCCESS, MisMessageConst.MIS_SYS_DIC_UPD_FAIL, user.getId().toString());
    }

    /**
     * 省份城市字典删除
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delUserDic(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");//字典Id
        String[] ids = dicIds.split(",");
        boolean flag = false;
        for (int i = 0; i < ids.length; i++)
        {
            flag = this.provinceCityDicCoreService.delProvinceCityDic(ids[i]);
            if (!flag)
            {
                break;
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_DEL_SUCCESS, MisMessageConst.MIS_SYS_DIC_DEL_FAIL);
    }

    /**
     * 查询省份城市字典信息
     */
    @Override
    public TransData<PageModel<MUserCityarea>> findUserCityareaDict(HttpServletRequest request) throws Exception
    {
        UserCityareaExample userExample = new UserCityareaExample();
        MUserCityarea userCityDictionary = ServletUtils.objectMethod(MUserCityarea.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        Criteria criteria = userExample.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (StringUtils.hasText(userCityDictionary.getCityId()))
        {
            criteria.andCityIdLike("%" + userCityDictionary.getCityId() + "%");
        }
        if (StringUtils.hasText(userCityDictionary.getCityName()))
        {
            criteria.andCityNameLike("%" + userCityDictionary.getCityName() + "%");
        }
        if (StringUtils.hasText(userCityDictionary.getParentCityId()))
        {
            criteria.andParentCityIdLike("%" + userCityDictionary.getParentCityId() + "%");
        }
        if (StringUtils.hasText(userCityDictionary.getPatentCityName()))
        {
            criteria.andParentCityNameLike("%" + userCityDictionary.getPatentCityName() + "%");
        }
        if (StringUtils.hasText(userCityDictionary.getLevelCode()))
        {
            criteria.andLevelCodeLike("%" + userCityDictionary.getLevelCode() + "%");
        }
        PageModel<MUserCityarea> pm = new PageModel<MUserCityarea>();
        pm.setPageIndex(pageCondition.getPageIndex());
        pm.setPageSize(pageSize);
        Integer count = this.userCityareaGeneratorQueryService.countByExample(userExample);
        pm.setCount(count);
        if (count > 0)
        {
            userExample.setPage(pageCondition.getPageIndex(), pageSize);// 设置分页条件
            List<UserCityarea> list = this.userCityareaGeneratorQueryService.selectByExample(userExample);
            for (UserCityarea user : list)
            {
                MUserCityarea muser = new MUserCityarea();
                EntityTools.copyValue(user, muser);
                pm.getResult().add(muser);
            }
        }
        return new TransData<PageModel<MUserCityarea>>(true, null, pm);
    }

    /**
     * 查询省份城市字典详细信息
     */
    @Override
    public TransData<MUserCityarea> findUserCityDetail(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");// 字典Id
        UserCityarea user = this.userCityareaGeneratorQueryService.selectUnDelByPrimaryKey("".equals(dicIds.split(",")[0]) ? null : Integer.parseInt(dicIds.split(",")[0]));
        if (user != null && !"".equals(user))
        {
            MUserCityarea muser = new MUserCityarea();
            EntityTools.copyValue(user, muser);
            return new TransData<MUserCityarea>(true, null, muser);
        }
        else
        {
            return new TransData<MUserCityarea>(false, MisMessageConst.MIS_SYS_DIC_GET_INFO_FAIL, null);
        }
    }

    /**
     * 批量新增省份城市字典
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addAllUserCity(HttpServletRequest request) throws Exception
    {
        String dictList = ServletRequestUtils.getStringParameter(request, "dictList");
        List<MUserCityarea> sysList = new Gson().fromJson(dictList, new TypeToken<List<MUserCityarea>>()
        {
        }.getType());
        if (sysList == null || sysList.size() <= 0)
        {
            return UtilsMis.getBooleanResult(false, null, MisMessageConst.MIS_DICTIARY_BATCH_EXCEL_FAIL);
        }
        List<UserCityarea> interList = new ArrayList<UserCityarea>();
        for (MUserCityarea sys : sysList)
        {
            UserCityarea sysDict = new UserCityarea();
            EntityTools.copyValue(sys, sysDict);
            if (sysDict.getParentCityName() == null)
            {
                sysDict.setParentCityName("");
            }
            interList.add(sysDict);
        }
        boolean flag = this.provinceCityDicCoreService.addAllProvinceCityDic(interList);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_DICTIARY_BATCH_SYS_SUCCESS, MisMessageConst.MIS_DICTIARY_BATCH_SYS_FAIL);
    }

}
