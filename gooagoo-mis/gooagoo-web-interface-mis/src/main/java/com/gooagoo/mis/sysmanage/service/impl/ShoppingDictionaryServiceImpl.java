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

import com.gooagoo.api.business.core.system.sys.dictionary.ShoppingListDicCoreService;
import com.gooagoo.api.generator.query.base.ShoppingListGoodsTypeGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.base.ShoppingListGoodsType;
import com.gooagoo.entity.generator.base.ShoppingListGoodsTypeExample;
import com.gooagoo.entity.generator.base.ShoppingListGoodsTypeExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.sysmanage.service.ShoppingDictionaryService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MShoppingListGoodsType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service(value = "shoppingDictionaryService")
public class ShoppingDictionaryServiceImpl implements ShoppingDictionaryService
{
    @Autowired
    private ShoppingListDicCoreService shoppingListDicCoreService;
    @Autowired
    private ShoppingListGoodsTypeGeneratorQueryService shoppingListGoodsTypeGeneratorQueryService;

    /**
     * 购物订单商品类型字典添加
     */
    @Override
    public TransData<Object> addShoppingDic(HttpServletRequest request) throws Exception
    {
        MShoppingListGoodsType mshopp = ServletUtils.objectMethod(MShoppingListGoodsType.class, request);
        ShoppingListGoodsType shopp = new ShoppingListGoodsType();
        EntityTools.copyValue(mshopp, shopp);
        boolean flag = this.shoppingListDicCoreService.addShoppingListDic(shopp);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_ADD_SUCCESS, MisMessageConst.MIS_SYS_DIC_ADD_FAIL, shopp.getGoodsTypeId().toString());
    }

    /**
     * 购物订单商品类型字典编辑
     */
    @Override
    public TransData<Object> editShoppingDic(HttpServletRequest request) throws Exception
    {
        MShoppingListGoodsType mshopp = ServletUtils.objectMethod(MShoppingListGoodsType.class, request);
        ShoppingListGoodsType shopp = new ShoppingListGoodsType();
        EntityTools.copyValue(mshopp, shopp);
        boolean flag = this.shoppingListDicCoreService.updateShoppingListDic(shopp);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_UPD_SUCCESS, MisMessageConst.MIS_SYS_DIC_UPD_FAIL, shopp.getGoodsTypeId().toString());
    }

    /**
     * 购物订单商品类型字典删除
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delShoppingDic(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");//字典Id
        String[] ids = dicIds.split(",");
        boolean flag = false;
        for (int i = 0; i < ids.length; i++)
        {
            flag = this.shoppingListDicCoreService.delShoppingListDic(ids[i]);
            if (!flag)
            {
                break;
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_DIC_DEL_SUCCESS, MisMessageConst.MIS_SYS_DIC_DEL_FAIL);
    }

    /**
     * 查询购物清单商品类型字典信息
     */
    @Override
    public TransData<PageModel<MShoppingListGoodsType>> findShoppingListDict(HttpServletRequest request) throws Exception
    {
        ShoppingListGoodsTypeExample shoppingExample = new ShoppingListGoodsTypeExample();
        MShoppingListGoodsType shoppingListDictionary = ServletUtils.objectMethod(MShoppingListGoodsType.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        Criteria criteria = shoppingExample.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (shoppingListDictionary.getGoodsTypeId() != null)
        {
            criteria.andGoodsTypeIdLike("%" + shoppingListDictionary.getGoodsTypeId().toString() + "%");
        }
        if (StringUtils.hasText(shoppingListDictionary.getGoodsTypeName()))
        {
            criteria.andGoodsTypeNameLike("%" + shoppingListDictionary.getGoodsTypeName() + "%");
        }
        if (shoppingListDictionary.getParentGoodsTypeId() != null)
        {
            criteria.andParentGoodsTypeIdLike("%" + shoppingListDictionary.getParentGoodsTypeId().toString() + "%");
        }
        if (shoppingListDictionary.getSortOrder() != null)
        {
            criteria.andSortOrderLike("%" + shoppingListDictionary.getSortOrder().toString() + "%");
        }
        PageModel<MShoppingListGoodsType> pm = new PageModel<MShoppingListGoodsType>();
        pm.setPageIndex(pageCondition.getPageIndex());
        pm.setPageSize(pageSize);
        Integer count = this.shoppingListGoodsTypeGeneratorQueryService.countByExample(shoppingExample);
        pm.setCount(count);
        if (count > 0)
        {
            shoppingExample.setPage(pageCondition.getPageIndex(), pageSize);// 设置分页条件
            List<ShoppingListGoodsType> list = this.shoppingListGoodsTypeGeneratorQueryService.selectByExample(shoppingExample);
            for (ShoppingListGoodsType shopp : list)
            {
                MShoppingListGoodsType mshopp = new MShoppingListGoodsType();
                EntityTools.copyValue(shopp, mshopp);
                pm.getResult().add(mshopp);
            }
        }
        return new TransData<PageModel<MShoppingListGoodsType>>(true, null, pm);
    }

    /**
     * 查询购物清单商品类型字典详细信息
     */
    @Override
    public TransData<MShoppingListGoodsType> findShoppingListDetail(HttpServletRequest request) throws Exception
    {
        String dicIds = ServletRequestUtils.getStringParameter(request, "id", "");// 字典Id
        ShoppingListGoodsType shopping = this.shoppingListGoodsTypeGeneratorQueryService.selectUnDelByPrimaryKey("".equals(dicIds.split(",")[0]) ? null : Integer.parseInt(dicIds.split(",")[0]));
        if (shopping != null && !"".equals(shopping))
        {
            MShoppingListGoodsType mshopp = new MShoppingListGoodsType();
            EntityTools.copyValue(shopping, mshopp);
            return new TransData<MShoppingListGoodsType>(true, null, mshopp);
        }
        else
        {
            return new TransData<MShoppingListGoodsType>(false, MisMessageConst.MIS_SYS_DIC_GET_INFO_FAIL, null);
        }
    }

    /**
     * 批量新增购物清单商品类型字典
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addAllShoppingList(HttpServletRequest request) throws Exception
    {
        String dictList = ServletRequestUtils.getStringParameter(request, "dictList");
        List<MShoppingListGoodsType> sysList = new Gson().fromJson(dictList, new TypeToken<List<MShoppingListGoodsType>>()
        {
        }.getType());
        if (sysList == null || sysList.size() <= 0)
        {
            return UtilsMis.getBooleanResult(false, null, MisMessageConst.MIS_DICTIARY_BATCH_EXCEL_FAIL);
        }
        List<ShoppingListGoodsType> interList = new ArrayList<ShoppingListGoodsType>();
        for (MShoppingListGoodsType sys : sysList)
        {
            ShoppingListGoodsType sysDict = new ShoppingListGoodsType();
            EntityTools.copyValue(sys, sysDict);
            interList.add(sysDict);
        }
        boolean flag = this.shoppingListDicCoreService.addAllShoppingListDic(interList);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_DICTIARY_BATCH_SYS_SUCCESS, MisMessageConst.MIS_DICTIARY_BATCH_SYS_FAIL);
    }

}
