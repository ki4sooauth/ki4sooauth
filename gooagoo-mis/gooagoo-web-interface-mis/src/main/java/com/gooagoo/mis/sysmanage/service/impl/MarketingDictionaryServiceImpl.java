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

import com.gooagoo.api.business.core.system.sys.dictionary.MarketingChannelsDicCoreService;
import com.gooagoo.api.generator.query.base.MarketingChannelGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.base.MarketingChannel;
import com.gooagoo.entity.generator.base.MarketingChannelExample;
import com.gooagoo.entity.generator.base.MarketingChannelExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.sysmanage.service.MarketingDictionaryService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MMarketingChannel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service(value = "marketingDictionaryService")
public class MarketingDictionaryServiceImpl implements MarketingDictionaryService
{
    @Autowired
    private MarketingChannelsDicCoreService marketingChannelsDicCoreService;
    @Autowired
    private MarketingChannelGeneratorQueryService marketingChannelGeneratorQueryService;

    /**
     * 营销渠道字典添加
     */
    @Override
    public TransData<Object> addMarketingDic(HttpServletRequest request) throws Exception
    {
        MMarketingChannel mmark = ServletUtils.objectMethod(MMarketingChannel.class, request);
        if (mmark != null)
        {
            MarketingChannel mark = this.marketingChannelGeneratorQueryService.selectUnDelByPrimaryKey(mmark.getChannelCode());
            if (mark != null)
            {
                return new TransData<Object>(false, MisMessageConst.MIS_DICTIARY_PARAMETER_MARK_FAIL, null);
            }
        }
        MarketingChannel mark = new MarketingChannel();
        EntityTools.copyValue(mmark, mark);
        boolean flag = this.marketingChannelsDicCoreService.addMarketingChannelsDic(mark);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_ADD_SUCCESS, MisMessageConst.MIS_SYS_DIC_ADD_FAIL, mark.getChannelCode().toString());
    }

    /**
     * 营销渠道字典编辑
     */
    @Override
    public TransData<Object> editMarketingDic(HttpServletRequest request) throws Exception
    {
        MMarketingChannel mmark = ServletUtils.objectMethod(MMarketingChannel.class, request);
        MarketingChannel mark = new MarketingChannel();
        EntityTools.copyValue(mmark, mark);
        boolean flag = this.marketingChannelsDicCoreService.updateMarketingChannelsDic(mark);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_UPD_SUCCESS, MisMessageConst.MIS_SYS_DIC_UPD_FAIL, mark.getChannelCode().toString());
    }

    /**
     * 营销渠道字典删除
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delMarketingDic(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");//字典Id
        String[] ids = dicIds.split(",");
        boolean flag = false;
        for (int i = 0; i < ids.length; i++)
        {
            flag = this.marketingChannelsDicCoreService.delMarketingChannelsDic(ids[i]);
            if (!flag)
            {
                break;
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_DEL_SUCCESS, MisMessageConst.MIS_SYS_DIC_DEL_FAIL);
    }

    /**
     * 查询营销渠道字典信息
     */
    @Override
    public TransData<PageModel<MMarketingChannel>> findMarketingChannelDict(HttpServletRequest request) throws Exception
    {
        MarketingChannelExample marketExample = new MarketingChannelExample();
        MMarketingChannel marketingDictionary = ServletUtils.objectMethod(MMarketingChannel.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        Criteria criteria = marketExample.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (marketingDictionary.getChannelCode() != null)
        {
            criteria.andChannelCodeLike("%" + marketingDictionary.getChannelCode().toString() + "%");
        }
        if (StringUtils.hasText(marketingDictionary.getChannelName()))
        {
            criteria.andChannelNameLike("%" + marketingDictionary.getChannelName() + "%");
        }
        if (marketingDictionary.getParentChannelCode() != null)
        {
            criteria.andParentChannelCodeLike("%" + marketingDictionary.getParentChannelCode().toString() + "%");
        }
        if (marketingDictionary.getSortOrder() != null)
        {
            criteria.andSortOrderLike("%" + marketingDictionary.getSortOrder().toString() + "%");
        }
        PageModel<MMarketingChannel> pm = new PageModel<MMarketingChannel>();
        pm.setPageIndex(pageCondition.getPageIndex());
        pm.setPageSize(pageSize);
        Integer count = this.marketingChannelGeneratorQueryService.countByExample(marketExample);
        pm.setCount(count);
        if (count > 0)
        {
            marketExample.setPage(pageCondition.getPageIndex(), pageSize);// 设置分页条件
            List<MarketingChannel> list = this.marketingChannelGeneratorQueryService.selectByExample(marketExample);
            for (MarketingChannel mark : list)
            {
                MMarketingChannel mmark = new MMarketingChannel();
                EntityTools.copyValue(mark, mmark);
                pm.getResult().add(mmark);
            }
        }
        return new TransData<PageModel<MMarketingChannel>>(true, null, pm);
    }

    /**
     * 查询营销渠道字典详细信息
     */
    @Override
    public TransData<MMarketingChannel> findMarketingDetail(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");// 字典Id
        MarketingChannel marketing = this.marketingChannelGeneratorQueryService.selectUnDelByPrimaryKey("".equals(dicIds.split(",")[0]) ? null : Integer.parseInt(dicIds.split(",")[0]));
        if (marketing != null && !"".equals(marketing))
        {
            MMarketingChannel mmark = new MMarketingChannel();
            EntityTools.copyValue(marketing, mmark);
            return new TransData<MMarketingChannel>(true, null, mmark);
        }
        else
        {
            return new TransData<MMarketingChannel>(false, MisMessageConst.MIS_SYS_DIC_GET_INFO_FAIL, null);
        }
    }

    /**
     * 批量新增营销渠道字典
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addAllMarketingChannelDict(HttpServletRequest request) throws Exception
    {
        String dictList = ServletRequestUtils.getStringParameter(request, "dictList");
        List<MMarketingChannel> sysList = new Gson().fromJson(dictList, new TypeToken<List<MMarketingChannel>>()
        {
        }.getType());
        if (sysList == null || sysList.size() <= 0)
        {
            return UtilsMis.getBooleanResult(false, null, MisMessageConst.MIS_DICTIARY_BATCH_EXCEL_FAIL);
        }
        List<MarketingChannel> interList = new ArrayList<MarketingChannel>();
        for (MMarketingChannel sys : sysList)
        {
            MarketingChannel sysDict = new MarketingChannel();
            EntityTools.copyValue(sys, sysDict);
            interList.add(sysDict);
        }
        boolean flag = this.marketingChannelsDicCoreService.addAllMarketingChannelsDic(interList);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_DICTIARY_BATCH_SYS_SUCCESS, MisMessageConst.MIS_DICTIARY_BATCH_SYS_FAIL);
    }
}
