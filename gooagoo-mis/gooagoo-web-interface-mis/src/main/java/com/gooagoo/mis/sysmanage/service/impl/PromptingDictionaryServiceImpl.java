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

import com.gooagoo.api.business.core.system.sys.dictionary.TipsDicCoreService;
import com.gooagoo.api.generator.query.base.PromptingMessageGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.base.PromptingMessage;
import com.gooagoo.entity.generator.base.PromptingMessageExample;
import com.gooagoo.entity.generator.base.PromptingMessageExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.sysmanage.service.PromptingDictionaryService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MPromptingMessage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service(value = "promptingDictionaryService")
public class PromptingDictionaryServiceImpl implements PromptingDictionaryService
{
    @Autowired
    private TipsDicCoreService tipsDicCoreService;
    @Autowired
    private PromptingMessageGeneratorQueryService promptingMessageGeneratorQueryService;

    /**
     * 提示信息字典添加
     */
    @Override
    public TransData<Object> addPromptingDic(HttpServletRequest request) throws Exception
    {
        MPromptingMessage mprompting = ServletUtils.objectMethod(MPromptingMessage.class, request);
        if (mprompting != null && !"".equals(mprompting))
        {
            PromptingMessage prom = this.promptingMessageGeneratorQueryService.selectUnDelByPrimaryKey(mprompting.getMessageId());
            if (prom != null)
            {
                return new TransData<Object>(false, MisMessageConst.MIS_DICTIARY_PARAMETER_PROM_FAIL, null);
            }
        }
        PromptingMessage pro = new PromptingMessage();
        EntityTools.copyValue(mprompting, pro);
        boolean flag = this.tipsDicCoreService.addTipsDic(pro);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_ADD_SUCCESS, MisMessageConst.MIS_SYS_DIC_ADD_FAIL, pro.getMessageId());
    }

    /**
     * 提示信息字典编辑
     */
    @Override
    public TransData<Object> editPromptingDic(HttpServletRequest request) throws Exception
    {
        MPromptingMessage mprompting = ServletUtils.objectMethod(MPromptingMessage.class, request);
        PromptingMessage pro = new PromptingMessage();
        EntityTools.copyValue(mprompting, pro);
        boolean flag = this.tipsDicCoreService.updateTipsDic(pro);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_UPD_SUCCESS, MisMessageConst.MIS_SYS_DIC_UPD_FAIL, pro.getMessageId());
    }

    /**
     * 提示信息字典删除
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delPromptingDic(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");//字典Id
        String[] ids = dicIds.split(",");
        boolean flag = false;
        for (int i = 0; i < ids.length; i++)
        {
            flag = this.tipsDicCoreService.delTipsDic(ids[i]);
            if (!flag)
            {
                break;
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_DEL_SUCCESS, MisMessageConst.MIS_SYS_DIC_DEL_FAIL);
    }

    /**
     * 查询提示信息字典信息
     */
    @Override
    public TransData<PageModel<MPromptingMessage>> findPromptingMessageDict(HttpServletRequest request) throws Exception
    {
        PromptingMessageExample promExample = new PromptingMessageExample();
        MPromptingMessage promptingDictionary = ServletUtils.objectMethod(MPromptingMessage.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        Criteria criteria = promExample.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (StringUtils.hasText(promptingDictionary.getMessageId()))
        {
            criteria.andMessageIdLike("%" + promptingDictionary.getMessageId() + "%");
        }
        if (StringUtils.hasText(promptingDictionary.getContent()))
        {
            criteria.andContentLike("%" + promptingDictionary.getContent() + "%");
        }
        if (StringUtils.hasText(promptingDictionary.getSys()))
        {
            criteria.andSysLike("%" + promptingDictionary.getSys() + "%");
        }
        if (StringUtils.hasText(promptingDictionary.getFunc()))
        {
            criteria.andFuncLike("%" + promptingDictionary.getFunc() + "%");
        }
        if (StringUtils.hasText(promptingDictionary.getNote()))
        {
            criteria.andNoteLike("%" + promptingDictionary.getNote() + "%");
        }
        PageModel<MPromptingMessage> pm = new PageModel<MPromptingMessage>();
        pm.setPageIndex(pageCondition.getPageIndex());
        pm.setPageSize(pageSize);
        Integer count = this.promptingMessageGeneratorQueryService.countByExample(promExample);
        pm.setCount(count);
        if (count > 0)
        {
            promExample.setPage(pageCondition.getPageIndex(), pageSize);// 设置查询条件
            List<PromptingMessage> list = this.promptingMessageGeneratorQueryService.selectByExample(promExample);
            for (PromptingMessage prompting : list)
            {
                MPromptingMessage mpro = new MPromptingMessage();
                EntityTools.copyValue(prompting, mpro);
                pm.getResult().add(mpro);
            }
        }
        return new TransData<PageModel<MPromptingMessage>>(true, null, pm);
    }

    /**
     * 查询提示信息字典详细信息
     */
    @Override
    public TransData<MPromptingMessage> findPromptingMessageDetail(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");// 字典Id
        PromptingMessage prompting = this.promptingMessageGeneratorQueryService.selectUnDelByPrimaryKey(dicIds.split(",")[0]);
        if (prompting != null && !"".equals(prompting))
        {
            MPromptingMessage mpro = new MPromptingMessage();
            EntityTools.copyValue(prompting, mpro);
            return new TransData<MPromptingMessage>(true, null, mpro);
        }
        else
        {
            return new TransData<MPromptingMessage>(false, MisMessageConst.MIS_SYS_DIC_GET_INFO_FAIL, null);
        }
    }

    /**
     * 批量新增提示信息字典
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addAllPromptingMessage(HttpServletRequest request) throws Exception
    {
        String dictList = ServletRequestUtils.getStringParameter(request, "dictList");
        List<MPromptingMessage> sysList = new Gson().fromJson(dictList, new TypeToken<List<MPromptingMessage>>()
        {
        }.getType());
        if (sysList == null || sysList.size() <= 0)
        {
            return UtilsMis.getBooleanResult(false, null, MisMessageConst.MIS_DICTIARY_BATCH_EXCEL_FAIL);
        }
        List<PromptingMessage> interList = new ArrayList<PromptingMessage>();
        for (MPromptingMessage sys : sysList)
        {
            PromptingMessage sysDict = new PromptingMessage();
            EntityTools.copyValue(sys, sysDict);
            interList.add(sysDict);
        }
        boolean flag = this.tipsDicCoreService.addAllTipsDic(interList);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_DICTIARY_BATCH_SYS_SUCCESS, MisMessageConst.MIS_DICTIARY_BATCH_SYS_FAIL);
    }

}
