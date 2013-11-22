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

import com.gooagoo.api.business.core.system.sys.dictionary.ShopAuthorityDicCoreService;
import com.gooagoo.api.generator.query.shop.ShopAuthorityGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.shop.ShopAuthority;
import com.gooagoo.entity.generator.shop.ShopAuthorityExample;
import com.gooagoo.entity.generator.shop.ShopAuthorityExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.sysmanage.service.ShopAuthorityDictionaryService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MShopAuthority;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service(value = "shopAuthorityDictionaryService")
public class ShopAuthorityDictionaryServiceImpl implements ShopAuthorityDictionaryService
{
    @Autowired
    private ShopAuthorityGeneratorQueryService shopAuthorityGeneratorQueryService;
    @Autowired
    private ShopAuthorityDicCoreService shopAuthorityDicCoreService;

    /**
     * 添加商家管理权限表数据
     */
    @Override
    public TransData<Object> addShopAuthority(HttpServletRequest request) throws Exception
    {
        MShopAuthority mbase = ServletUtils.objectMethod(MShopAuthority.class, request);
        if (mbase != null)
        {
            ShopAuthority base = this.shopAuthorityGeneratorQueryService.selectUnDelByPrimaryKey(mbase.getAuthorityId());
            if (base != null)
            {
                return new TransData<Object>(false, MisMessageConst.MIS_DICTIARY_PARAMETER_SHOPAUTH_FAIL, null);
            }
        }
        ShopAuthority base = new ShopAuthority();
        EntityTools.copyValue(mbase, base);
        boolean flag = this.shopAuthorityDicCoreService.addShopAuthorityDic(base);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_ADD_SUCCESS, MisMessageConst.MIS_SYS_DIC_ADD_FAIL, base.getAuthorityId());
    }

    /**
     * 修改商家管理权限表数据
     */
    @Override
    public TransData<Object> editShopAuthority(HttpServletRequest request) throws Exception
    {
        MShopAuthority mbase = ServletUtils.objectMethod(MShopAuthority.class, request);
        ShopAuthority base = new ShopAuthority();
        EntityTools.copyValue(mbase, base);
        boolean flag = this.shopAuthorityDicCoreService.updateShopAuthorityDic(base);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_UPD_SUCCESS, MisMessageConst.MIS_SYS_DIC_UPD_FAIL, base.getAuthorityId());
    }

    /**
     * 删除商家管理权限表数据
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delShopAuthority(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");
        String[] ids = dicIds.split(",");
        boolean flag = false;
        for (int i = 0; i < ids.length; i++)
        {
            flag = this.shopAuthorityDicCoreService.delShopAuthorityDic(ids[i]);
            if (!flag)
            {
                break;
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_DEL_SUCCESS, MisMessageConst.MIS_SYS_DIC_DEL_FAIL);
    }

    /**
     * 查询商家管理权限表详细信息
     */
    @Override
    public TransData<MShopAuthority> findShopAuthorityDetail(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");// 字典Id
        ShopAuthority base = this.shopAuthorityGeneratorQueryService.selectUnDelByPrimaryKey(dicIds.split(",")[0]);
        if (base != null)
        {
            MShopAuthority mbase = new MShopAuthority();
            EntityTools.copyValue(base, mbase);
            return new TransData<MShopAuthority>(true, null, mbase);
        }
        else
        {
            return new TransData<MShopAuthority>(false, MisMessageConst.MIS_SYS_DIC_GET_INFO_FAIL, null);
        }
    }

    /**
     * 查询商家管理权限表数据
     */
    @Override
    public TransData<PageModel<MShopAuthority>> findShopAuthorityAllDict(HttpServletRequest request) throws Exception
    {
        ShopAuthorityExample baseExample = new ShopAuthorityExample();
        MShopAuthority baseDictionary = ServletUtils.objectMethod(MShopAuthority.class, request);
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
        PageModel<MShopAuthority> pm = new PageModel<MShopAuthority>();
        pm.setPageIndex(pageCondition.getPageIndex());
        pm.setPageSize(pageSize);
        Integer count = this.shopAuthorityGeneratorQueryService.countByExample(baseExample);
        pm.setCount(count);
        if (count > 0)
        {
            baseExample.setPage(pageCondition.getPageIndex(), pageSize);// 设置分页条件
            List<ShopAuthority> list = this.shopAuthorityGeneratorQueryService.selectByExample(baseExample);
            for (ShopAuthority inter : list)
            {
                MShopAuthority base = new MShopAuthority();
                EntityTools.copyValue(inter, base);
                pm.getResult().add(base);
            }
        }
        return new TransData<PageModel<MShopAuthority>>(true, null, pm);
    }

    /**
     * 批量新增商家管理权限表
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addAllShopAuthority(HttpServletRequest request) throws Exception
    {
        String dictList = ServletRequestUtils.getStringParameter(request, "dictList");
        List<MShopAuthority> sysList = new Gson().fromJson(dictList, new TypeToken<List<MShopAuthority>>()
        {
        }.getType());
        if (sysList == null || sysList.size() <= 0)
        {
            return UtilsMis.getBooleanResult(false, null, MisMessageConst.MIS_DICTIARY_BATCH_EXCEL_FAIL);
        }
        List<ShopAuthority> interList = new ArrayList<ShopAuthority>();
        for (MShopAuthority sys : sysList)
        {
            ShopAuthority sysDict = new ShopAuthority();
            EntityTools.copyValue(sys, sysDict);
            interList.add(sysDict);
        }
        boolean flag = this.shopAuthorityDicCoreService.addAllShopAuthorityDic(interList);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_DICTIARY_BATCH_SYS_SUCCESS, MisMessageConst.MIS_DICTIARY_BATCH_SYS_FAIL);
    }

}
