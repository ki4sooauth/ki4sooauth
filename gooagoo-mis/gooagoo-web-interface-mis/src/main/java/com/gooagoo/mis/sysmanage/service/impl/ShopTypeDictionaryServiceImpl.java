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

import com.gooagoo.api.business.core.system.sys.dictionary.MerchantTypeDicCoreService;
import com.gooagoo.api.generator.query.base.ShopTypeGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.entity.generator.base.ShopTypeExample;
import com.gooagoo.entity.generator.base.ShopTypeExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.sysmanage.service.ShopTypeDictionaryService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MShopType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service(value = "shopTypeDictionaryService")
public class ShopTypeDictionaryServiceImpl implements ShopTypeDictionaryService
{
    @Autowired
    private MerchantTypeDicCoreService merchantTypeDicCoreService;
    @Autowired
    private ShopTypeGeneratorQueryService shopTypeGeneratorQueryService;

    /**
     * 商家类型字典添加
     */
    @Override
    public TransData<Object> addShopTypeDic(HttpServletRequest request) throws Exception
    {
        MShopType mshop = ServletUtils.objectMethod(MShopType.class, request);
        ShopType shop = new ShopType();
        EntityTools.copyValue(mshop, shop);
        boolean flag = this.merchantTypeDicCoreService.addMerchantTypeDic(shop);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_ADD_SUCCESS, MisMessageConst.MIS_SYS_DIC_ADD_FAIL, shop.getShopTypeId().toString());
    }

    /**
     * 商家类型字典编辑
     */
    @Override
    public TransData<Object> editShopTypeDic(HttpServletRequest request) throws Exception
    {
        MShopType mshop = ServletUtils.objectMethod(MShopType.class, request);
        ShopType shop = new ShopType();
        EntityTools.copyValue(mshop, shop);
        boolean flag = this.merchantTypeDicCoreService.updateMerchantTypeDic(shop);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_UPD_SUCCESS, MisMessageConst.MIS_SYS_DIC_UPD_FAIL, shop.getShopTypeId().toString());
    }

    /**
     * 商家类型字典删除
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delShopTypeDic(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");//字典Id
        String[] ids = dicIds.split(",");
        boolean flag = false;
        for (int i = 0; i < ids.length; i++)
        {
            flag = this.merchantTypeDicCoreService.delMerchantTypeDic(ids[i]);
            if (!flag)
            {
                break;
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_DEL_SUCCESS, MisMessageConst.MIS_SYS_DIC_DEL_FAIL);
    }

    /**
     * 查询商家类型字典信息
     */
    @Override
    public TransData<PageModel<MShopType>> findShopTypeDict(HttpServletRequest request) throws Exception
    {
        ShopTypeExample shopExample = new ShopTypeExample();
        MShopType shopTypeDictionary = ServletUtils.objectMethod(MShopType.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        Criteria criteria = shopExample.createCriteria();
        shopExample.createCriteria().andIsDelEqualTo("N");
        if (StringUtils.hasText(shopTypeDictionary.getShopTypeName()))
        {
            criteria.andShopTypeNameLike("%" + shopTypeDictionary.getShopTypeName() + "%");
        }
        if (shopTypeDictionary.getParentShopTypeId() != null)
        {
            criteria.andParentShopTypeIdLike("%" + shopTypeDictionary.getParentShopTypeId().toString() + "%");
        }
        if (shopTypeDictionary.getSortOrder() != null)
        {
            criteria.andSortOrderLike("%" + shopTypeDictionary.getSortOrder().toString() + "%");
        }
        PageModel<MShopType> pm = new PageModel<MShopType>();
        pm.setPageIndex(pageCondition.getPageIndex());
        pm.setPageSize(pageSize);
        Integer count = this.shopTypeGeneratorQueryService.countByExample(shopExample);
        pm.setCount(count);
        if (count > 0)
        {
            shopExample.setPage(pageCondition.getPageIndex(), pageSize);// 设置分页条件
            List<ShopType> list = this.shopTypeGeneratorQueryService.selectByExample(shopExample);
            for (ShopType shop : list)
            {
                MShopType mshop = new MShopType();
                EntityTools.copyValue(shop, mshop);
                pm.getResult().add(mshop);
            }
        }
        return new TransData<PageModel<MShopType>>(true, null, pm);
    }

    /**
     * 查询商家类型字典详细信息
     */
    @Override
    public TransData<MShopType> findShopTypeDetail(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");// 字典Id
        ShopType shopType = this.shopTypeGeneratorQueryService.selectUnDelByPrimaryKey("".equals(dicIds.split(",")[0]) ? null : Integer.parseInt(dicIds.split(",")[0]));
        if (shopType != null && !"".equals(shopType))
        {
            MShopType mshop = new MShopType();
            EntityTools.copyValue(shopType, mshop);
            return new TransData<MShopType>(true, null, mshop);
        }
        else
        {
            return new TransData<MShopType>(false, MisMessageConst.MIS_SYS_DIC_GET_INFO_FAIL, null);
        }
    }

    /**
     * 批量新增商家类型字典
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addAllShopType(HttpServletRequest request) throws Exception
    {
        String dictList = ServletRequestUtils.getStringParameter(request, "dictList");
        List<MShopType> sysList = new Gson().fromJson(dictList, new TypeToken<List<MShopType>>()
        {
        }.getType());
        if (sysList == null || sysList.size() <= 0)
        {
            return UtilsMis.getBooleanResult(false, null, MisMessageConst.MIS_DICTIARY_BATCH_EXCEL_FAIL);
        }
        List<ShopType> interList = new ArrayList<ShopType>();
        for (MShopType sys : sysList)
        {
            ShopType sysDict = new ShopType();
            EntityTools.copyValue(sys, sysDict);
            interList.add(sysDict);
        }
        boolean flag = this.merchantTypeDicCoreService.addAllMerchantTypeDic(interList);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_DICTIARY_BATCH_SYS_SUCCESS, MisMessageConst.MIS_DICTIARY_BATCH_SYS_FAIL);
    }
}
