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

import com.gooagoo.api.business.core.system.sys.dictionary.ShopInterfaceNameDicCoreService;
import com.gooagoo.api.generator.query.base.ShopInterfaceNameGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.base.ShopInterfaceName;
import com.gooagoo.entity.generator.base.ShopInterfaceNameExample;
import com.gooagoo.entity.generator.base.ShopInterfaceNameExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.sysmanage.service.ShopInterfaceDictionaryService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MShopInterfaceName;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service(value = "shopInterfaceDictionaryService")
public class ShopInterfaceDictionaryServiceImpl implements ShopInterfaceDictionaryService
{
    @Autowired
    private ShopInterfaceNameDicCoreService shopInterfaceNameDicCoreService;
    @Autowired
    private ShopInterfaceNameGeneratorQueryService shopInterfaceNameGeneratorQueryService;

    /**
     * 商家平台界面名称管理字典添加
     */
    @Override
    public TransData<Object> addShopInterfaceDic(HttpServletRequest request) throws Exception
    {
        MShopInterfaceName mshopIn = ServletUtils.objectMethod(MShopInterfaceName.class, request);
        ShopInterfaceName shopIn = new ShopInterfaceName();
        EntityTools.copyValue(mshopIn, shopIn);
        shopIn.setId(UUID.getUUID());
        boolean flag = this.shopInterfaceNameDicCoreService.addShopInterfaceNameDic(shopIn);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_ADD_SUCCESS, MisMessageConst.MIS_SYS_DIC_ADD_FAIL, shopIn.getId());
    }

    /**
     * 商家平台界面名称管理字典编辑
     */
    @Override
    public TransData<Object> editShopInterfaceDic(HttpServletRequest request) throws Exception
    {
        MShopInterfaceName mshopIn = ServletUtils.objectMethod(MShopInterfaceName.class, request);
        ShopInterfaceName shopIn = new ShopInterfaceName();
        EntityTools.copyValue(mshopIn, shopIn);
        boolean flag = this.shopInterfaceNameDicCoreService.updateShopInterfaceNameDic(shopIn);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_UPD_SUCCESS, MisMessageConst.MIS_SYS_DIC_UPD_FAIL, shopIn.getId());
    }

    /**
     * 商家平台界面名称管理字典删除
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delShopInterfaceDic(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");//字典Id
        String[] ids = dicIds.split(",");
        boolean flag = false;
        for (int i = 0; i < ids.length; i++)
        {
            flag = this.shopInterfaceNameDicCoreService.delShopInterfaceNameDic(ids[i]);
            if (!flag)
            {
                break;
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_DEL_SUCCESS, MisMessageConst.MIS_SYS_DIC_DEL_FAIL);
    }

    /**
     * 查询商家平台界面名称管理字典信息
     */
    @Override
    public TransData<PageModel<MShopInterfaceName>> findShopInterfaceDict(HttpServletRequest request) throws Exception
    {
        ShopInterfaceNameExample shopExample = new ShopInterfaceNameExample();
        MShopInterfaceName shopDictionary = ServletUtils.objectMethod(MShopInterfaceName.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        Criteria criteria = shopExample.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (StringUtils.hasText(shopDictionary.getNameCode()))
        {
            criteria.andNameCodeLike("%" + shopDictionary.getNameCode() + "%");
        }
        if (StringUtils.hasText(shopDictionary.getNameValue()))
        {
            criteria.andNameValueLike("%" + shopDictionary.getNameValue() + "%");
        }
        if (StringUtils.hasText(shopDictionary.getSys()))
        {
            criteria.andSysLike("%" + shopDictionary.getSys() + "%");
        }
        if (StringUtils.hasText(shopDictionary.getModule()))
        {
            criteria.andModuleLike("%" + shopDictionary.getModule() + "%");
        }
        if (StringUtils.hasText(shopDictionary.getNote()))
        {
            criteria.andNoteLike("%" + shopDictionary.getNote() + "%");
        }
        if (StringUtils.hasText(shopDictionary.getVersion()))
        {
            criteria.andVersionLike("%" + shopDictionary.getVersion() + "%");
        }
        if (StringUtils.hasText(shopDictionary.getVersionNote()))
        {
            criteria.andVersionNoteLike("%" + shopDictionary.getVersionNote() + "%");
        }
        PageModel<MShopInterfaceName> pm = new PageModel<MShopInterfaceName>();
        pm.setPageIndex(pageCondition.getPageIndex());
        pm.setPageSize(pageSize);
        Integer count = this.shopInterfaceNameGeneratorQueryService.countByExample(shopExample);
        pm.setCount(count);
        if (count > 0)
        {
            shopExample.setPage(pageCondition.getPageIndex(), pageSize);// 设置查询条件
            List<ShopInterfaceName> list = this.shopInterfaceNameGeneratorQueryService.selectByExample(shopExample);
            for (ShopInterfaceName name : list)
            {
                MShopInterfaceName mshopIn = new MShopInterfaceName();
                EntityTools.copyValue(name, mshopIn);
                pm.getResult().add(mshopIn);
            }
        }
        return new TransData<PageModel<MShopInterfaceName>>(true, null, pm);
    }

    /**
     * 查询商家平台界面名称管理字典详细信息
     */
    @Override
    public TransData<MShopInterfaceName> findShopInterfaceDetail(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");// 字典Id
        ShopInterfaceName shopIn = this.shopInterfaceNameGeneratorQueryService.selectUnDelByPrimaryKey(dicIds.split(",")[0]);
        if (shopIn != null && !"".equals(shopIn))
        {
            MShopInterfaceName mshopIn = new MShopInterfaceName();
            EntityTools.copyValue(shopIn, mshopIn);
            return new TransData<MShopInterfaceName>(true, null, mshopIn);
        }
        else
        {
            return new TransData<MShopInterfaceName>(false, MisMessageConst.MIS_SYS_DIC_GET_INFO_FAIL, null);
        }
    }

    /**
     * 批量新增商家平台界面名称管理字典
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addAllShopInterface(HttpServletRequest request) throws Exception
    {
        String dictList = ServletRequestUtils.getStringParameter(request, "dictList");
        List<MShopInterfaceName> sysList = new Gson().fromJson(dictList, new TypeToken<List<MShopInterfaceName>>()
        {
        }.getType());
        if (sysList == null || sysList.size() <= 0)
        {
            return UtilsMis.getBooleanResult(false, null, MisMessageConst.MIS_DICTIARY_BATCH_EXCEL_FAIL);
        }
        List<ShopInterfaceName> interList = new ArrayList<ShopInterfaceName>();
        for (MShopInterfaceName sys : sysList)
        {
            ShopInterfaceName sysDict = new ShopInterfaceName();
            EntityTools.copyValue(sys, sysDict);
            interList.add(sysDict);
        }
        boolean flag = this.shopInterfaceNameDicCoreService.addAllShopInterfaceNameDic(interList);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_DICTIARY_BATCH_SYS_SUCCESS, MisMessageConst.MIS_DICTIARY_BATCH_SYS_FAIL);
    }
}
