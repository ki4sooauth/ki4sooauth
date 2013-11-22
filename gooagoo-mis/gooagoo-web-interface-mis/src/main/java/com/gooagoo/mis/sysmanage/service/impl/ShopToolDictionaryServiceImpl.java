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

import com.gooagoo.api.business.core.system.sys.dictionary.MerchantToolsDicCoreService;
import com.gooagoo.api.generator.query.base.ShopToolInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.base.ShopToolInfo;
import com.gooagoo.entity.generator.base.ShopToolInfoExample;
import com.gooagoo.entity.generator.base.ShopToolInfoExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.sysmanage.service.ShopToolDictionaryService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MShopToolInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service(value = "shopToolDictionaryService")
public class ShopToolDictionaryServiceImpl implements ShopToolDictionaryService
{
    @Autowired
    private MerchantToolsDicCoreService merchantToolsDicCoreService;
    @Autowired
    private ShopToolInfoGeneratorQueryService shopToolInfoGeneratorQueryService;

    /**
     * 商家服务工具字典添加
     */
    @Override
    public TransData<Object> addShopToolDic(HttpServletRequest request) throws Exception
    {
        MShopToolInfo mshop = ServletUtils.objectMethod(MShopToolInfo.class, request);
        ShopToolInfo shop = new ShopToolInfo();
        EntityTools.copyValue(mshop, shop);
        boolean flag = this.merchantToolsDicCoreService.addMerchantToolsDic(shop);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_ADD_SUCCESS, MisMessageConst.MIS_SYS_DIC_ADD_FAIL, shop.getToolId());
    }

    /**
     * 商家服务工具字典编辑
     */
    @Override
    public TransData<Object> editShopToolDic(HttpServletRequest request) throws Exception
    {
        MShopToolInfo mshop = ServletUtils.objectMethod(MShopToolInfo.class, request);
        ShopToolInfo shop = new ShopToolInfo();
        EntityTools.copyValue(mshop, shop);
        boolean flag = this.merchantToolsDicCoreService.updateMerchantToolsDic(shop);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_UPD_SUCCESS, MisMessageConst.MIS_SYS_DIC_UPD_FAIL, shop.getToolId());
    }

    /**
     * 商家服务工具字典删除
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delShopToolDic(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");//字典Id
        String[] ids = dicIds.split(",");
        boolean flag = false;
        for (int i = 0; i < ids.length; i++)
        {
            flag = this.merchantToolsDicCoreService.delMerchantToolsDic(ids[i]);
            if (!flag)
            {
                break;
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_DEL_SUCCESS, MisMessageConst.MIS_SYS_DIC_DEL_FAIL);
    }

    /**
     * 查询商家服务工具字典信息
     */
    @Override
    public TransData<PageModel<MShopToolInfo>> findShopToolDict(HttpServletRequest request) throws Exception
    {
        ShopToolInfoExample shopExample = new ShopToolInfoExample();
        MShopToolInfo shopDictionary = ServletUtils.objectMethod(MShopToolInfo.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        Criteria criteria = shopExample.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (StringUtils.hasText(shopDictionary.getToolName()))
        {
            criteria.andToolNameLike("%" + shopDictionary.getToolName() + "%");
        }
        if (StringUtils.hasText(shopDictionary.getToolUrl()))
        {
            criteria.andToolUrlLike("%" + shopDictionary.getToolUrl() + "%");
        }
        if (StringUtils.hasText(shopDictionary.getToolType()))
        {
            criteria.andToolTypeLike("%" + shopDictionary.getToolType() + "%");
        }
        if (StringUtils.hasText(shopDictionary.getLocalCmd()))
        {
            criteria.andLocalCmdLike("%" + shopDictionary.getLocalCmd() + "%");
        }
        if (StringUtils.hasText(shopDictionary.getVer()))
        {
            criteria.andVerLike("%" + shopDictionary.getVer() + "%");
        }
        if (StringUtils.hasText(shopDictionary.getRemark()))
        {
            criteria.andRemarkLike("%" + shopDictionary.getRemark() + "%");
        }
        PageModel<MShopToolInfo> pm = new PageModel<MShopToolInfo>();
        pm.setPageIndex(pageCondition.getPageIndex());
        pm.setPageSize(pageSize);
        Integer count = this.shopToolInfoGeneratorQueryService.countByExample(shopExample);
        pm.setCount(count);
        if (count > 0)
        {
            shopExample.setPage(pageCondition.getPageIndex(), pageSize);// 设置分页条件
            List<ShopToolInfo> list = this.shopToolInfoGeneratorQueryService.selectByExample(shopExample);
            for (ShopToolInfo shop : list)
            {
                MShopToolInfo mshop = new MShopToolInfo();
                EntityTools.copyValue(shop, mshop);
                pm.getResult().add(mshop);
            }
        }
        return new TransData<PageModel<MShopToolInfo>>(true, null, pm);
    }

    /**
     * 查询商家服务工具字典详细信息
     */
    @Override
    public TransData<MShopToolInfo> findShopToolDetail(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");// 字典Id
        ShopToolInfo shop = this.shopToolInfoGeneratorQueryService.selectUnDelByPrimaryKey(dicIds.split(",")[0]);
        if (shop != null && !"".equals(shop))
        {
            MShopToolInfo mshop = new MShopToolInfo();
            EntityTools.copyValue(shop, mshop);
            return new TransData<MShopToolInfo>(true, null, mshop);
        }
        else
        {
            return new TransData<MShopToolInfo>(false, MisMessageConst.MIS_SYS_DIC_GET_INFO_FAIL, null);
        }
    }

    /**
     * 批量新增商家服务工具字典
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addAllShopTool(HttpServletRequest request) throws Exception
    {
        String dictList = ServletRequestUtils.getStringParameter(request, "dictList");
        List<MShopToolInfo> sysList = new Gson().fromJson(dictList, new TypeToken<List<MShopToolInfo>>()
        {
        }.getType());
        if (sysList == null || sysList.size() <= 0)
        {
            return UtilsMis.getBooleanResult(false, null, MisMessageConst.MIS_DICTIARY_BATCH_EXCEL_FAIL);
        }
        List<ShopToolInfo> interList = new ArrayList<ShopToolInfo>();
        for (MShopToolInfo sys : sysList)
        {
            ShopToolInfo sysDict = new ShopToolInfo();
            EntityTools.copyValue(sys, sysDict);
            interList.add(sysDict);
        }
        boolean flag = this.merchantToolsDicCoreService.addAllMerchantToolsDic(interList);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_DICTIARY_BATCH_SYS_SUCCESS, MisMessageConst.MIS_DICTIARY_BATCH_SYS_FAIL);
    }

}
