package com.gooagoo.igus.shoppinglist.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.user.shoppingplan.ShoppingPlanCoreService;
import com.gooagoo.api.generator.query.base.ShoppingListGoodsTypeGeneratorQueryService;
import com.gooagoo.api.generator.query.behave.ShoppingPlanGoodsGeneratorQueryService;
import com.gooagoo.api.generator.query.behave.UserShoppingPlanGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.base.ShoppingListGoodsType;
import com.gooagoo.entity.generator.base.ShoppingListGoodsTypeExample;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoodsExample;
import com.gooagoo.entity.generator.behave.UserShoppingPlan;
import com.gooagoo.entity.generator.behave.UserShoppingPlanExample;
import com.gooagoo.exception.business.user.NoShoppingPlanException;
import com.gooagoo.igus.shoppinglist.service.IShoppinglistService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.shoppinglist.UShoppingGoodsType;
import com.gooagoo.view.gus.web.shoppinglist.UShoppingPlanGoods;
import com.gooagoo.view.gus.web.shoppinglist.UShoppinglist;
import com.google.gson.Gson;

@Service("iShoppinglistService")
public class IShoppinglistServiceImpl implements IShoppinglistService
{

    @Autowired
    private ShoppingPlanCoreService shoppingPlanCoreService;

    @Autowired
    private UserShoppingPlanGeneratorQueryService uGeneratorQueryService;

    @Autowired
    private ShoppingPlanGoodsGeneratorQueryService sGeneratorQueryService;

    @Autowired
    private ShoppingListGoodsTypeGeneratorQueryService typeGeneratorQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_ADDSHOPPINGLIST)
    public TransData<Object> addShoppinglist(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            UserShoppingPlan addShoppingListRequest = ServletUtils.objectMethod(UserShoppingPlan.class, request);
            addShoppingListRequest.setUserId(userId);
            addShoppingListRequest.setInfoSource("W");
            if (!this.shoppingPlanCoreService.addShoppingPlan(addShoppingListRequest))
            {
                GooagooLog.info("商品加入购物清单：加入购物清单失败（" + new Gson().toJson(addShoppingListRequest) + "）");
                return new TransData<Object>(false, MessageConst.SHOPPINGLIST_ISHOPPINGLIST_ADDSHOPPINGLIST_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.SHOPPINGLIST_ISHOPPINGLIST_ADDSHOPPINGLIST_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("添加购物清单：添加购物清单异常", e);
            transData = new TransData<Object>(false, MessageConst.SHOPPINGLIST_ISHOPPINGLIST_ADDSHOPPINGLIST_FAIL, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_GETSHOPPINGLISTLIST)
    public TransData<Object> getShoppinglistList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex");
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");
            UserShoppingPlanExample shoppingListRequest = new UserShoppingPlanExample();
            shoppingListRequest.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N");
            shoppingListRequest.setPage(pageIndex, pageSize);
            shoppingListRequest.setOrderByClause("pre_shopping_time desc");
            List<UserShoppingPlan> userShoppingPlanList = this.uGeneratorQueryService.selectByExample(shoppingListRequest);
            if (CollectionUtils.isEmpty(userShoppingPlanList))
            {
                GooagooLog.info("获取购物清单列表:没有查到购物清单信息");
                return new TransData<Object>(true, MessageConst.SHOPPINGLIST_ISHOPPINGLIST_GETSHOPPINGLISTINFO_NOTEXIST, null);
            }
            List<UShoppinglist> ushoppinglistList = new ArrayList<UShoppinglist>();
            for (UserShoppingPlan userShoppingPlan : userShoppingPlanList)
            {
                UShoppinglist ushoppinglist = new UShoppinglist();
                ushoppinglist.setTitle(userShoppingPlan.getTitle());
                ushoppinglist.setPreShoppingTime(userShoppingPlan.getPreShoppingTime());
                ushoppinglist.setShoppingListId(userShoppingPlan.getShoppingListId());
                ushoppinglist.setUserId(userShoppingPlan.getUserId());
                ushoppinglistList.add(ushoppinglist);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ushoppinglistList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取购物清单列表：查询用户购物清单异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_GETSHOPPINGLISTGOODS)
    public TransData<Object> getShoppinglistGoods(HttpServletRequest request)
    {

        TransData<Object> transData = null;
        try
        {
            String shoppingListId = ServletRequestUtils.getStringParameter(request, "shoppingListId");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex");
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");
            ShoppingPlanGoodsExample shoppingPlanGoodsExample = new ShoppingPlanGoodsExample();
            if (StringUtils.isBlank(shoppingListId))
            {
                shoppingPlanGoodsExample.createCriteria().andIsDelEqualTo("N");
            }
            else
            {
                shoppingPlanGoodsExample.createCriteria().andShoppingListIdEqualTo(shoppingListId).andIsDelEqualTo("N");
            }
            if (pageIndex != null && pageSize != null)
            {
                shoppingPlanGoodsExample.setPage(pageIndex, pageSize);
            }
            shoppingPlanGoodsExample.setOrderByClause("create_time desc");
            List<ShoppingPlanGoods> shoppingPlanGoodsList = this.sGeneratorQueryService.selectByExample(shoppingPlanGoodsExample);
            if (CollectionUtils.isEmpty(shoppingPlanGoodsList))
            {
                GooagooLog.info("查询购物清单商品:没有查到购物清单商品");
                return new TransData<Object>(true, MessageConst.COMMON_ADDTOSHOPPINGLIST_NOTEXIST, null);
            }
            List<UShoppingPlanGoods> ushoppingPlanGoodsList = new ArrayList<UShoppingPlanGoods>();
            for (ShoppingPlanGoods shoppingPlanGoods : shoppingPlanGoodsList)
            {
                UShoppingPlanGoods ushoppingPlanGoods = new UShoppingPlanGoods();
                ushoppingPlanGoods.setGoodsId(shoppingPlanGoods.getGoodsId());
                ushoppingPlanGoods.setGoodsName(shoppingPlanGoods.getGoodsName());
                ushoppingPlanGoods.setGoodsTypeId(shoppingPlanGoods.getGoodsTypeId());
                ushoppingPlanGoods.setGoodsTypeName(shoppingPlanGoods.getGoodsTypeName());
                ushoppingPlanGoods.setShopId(shoppingPlanGoods.getShopId());
                ushoppingPlanGoods.setShopName(shoppingPlanGoods.getShopName());
                ushoppingPlanGoods.setShoppingGoodsId(shoppingPlanGoods.getShoppingGoodsId());
                ushoppingPlanGoods.setShoppingListId(shoppingPlanGoods.getShoppingListId());
                ushoppingPlanGoods.setCreateTime(shoppingPlanGoods.getCreateTime());
                ushoppingPlanGoodsList.add(ushoppingPlanGoods);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ushoppingPlanGoodsList);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询购物清单商品：查询购物清单中商品异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_GETSHOPPINGLISTGOODSTYPELIST)
    public TransData<Object> getShoppinglistGoodsTypeList(HttpServletRequest request)
    {

        TransData<Object> transData = null;
        try
        {
            String parentId = ServletRequestUtils.getStringParameter(request, "parentId", "-1");
            ShoppingListGoodsTypeExample shopTypeExample = new ShoppingListGoodsTypeExample();
            shopTypeExample.createCriteria().andParentGoodsTypeIdEqualTo(parentId).andIsDelEqualTo("N");
            List<ShoppingListGoodsType> shoppingListGoodsTypeList = this.typeGeneratorQueryService.selectByExample(shopTypeExample);
            if (CollectionUtils.isEmpty(shoppingListGoodsTypeList))
            {
                GooagooLog.info("获取购物清单商品类型列表:没有查到购物清单商品类型列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            List<UShoppingGoodsType> ushoppingGoodsTypeList = new ArrayList<UShoppingGoodsType>();
            for (ShoppingListGoodsType shoppingListGoodsType : shoppingListGoodsTypeList)
            {
                UShoppingGoodsType ushoppingGoodsType = new UShoppingGoodsType();
                ushoppingGoodsType.setGoodsTypeId(shoppingListGoodsType.getGoodsTypeId());
                ushoppingGoodsType.setGoodsTypeName(shoppingListGoodsType.getGoodsTypeName());
                ushoppingGoodsType.setParentGoodsTypeId(shoppingListGoodsType.getParentGoodsTypeId());
                ushoppingGoodsTypeList.add(ushoppingGoodsType);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, ushoppingGoodsTypeList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取购物清单商品类型列表：查询商品类异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;

    }

    @Override
    @MessageAnnotation(InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_ADDTOSHOPPINGLIST)
    public TransData<Object> addToShoppinglist(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String shoppingListId = ServletRequestUtils.getStringParameter(request, "shoppingListId");
            String goodsName = ServletRequestUtils.getStringParameter(request, "goodsName");
            String goodsTypeName = ServletRequestUtils.getStringParameter(request, "goodsTypeName");
            String[] gName = goodsName.split(",");
            String[] gTypeName = null;
            if (StringUtils.isNotBlank(goodsTypeName))
            {
                gTypeName = goodsTypeName.split(",");
            }
            List<ShoppingPlanGoods> shoppingPlanGoodsList = new ArrayList<ShoppingPlanGoods>();
            for (int i = 0; i < gName.length; i++)
            {
                ShoppingPlanGoods goodlist = new ShoppingPlanGoods();
                goodlist.setShoppingListId(shoppingListId);
                goodlist.setGoodsName(gName[i]);
                if (gTypeName == null)
                {
                    goodlist.setGoodsTypeName(null);
                }
                else
                {
                    goodlist.setGoodsTypeName(gTypeName[i]);
                }
                shoppingPlanGoodsList.add(goodlist);
            }
            if (!this.shoppingPlanCoreService.addShoppingPlanGoods(userId, shoppingPlanGoodsList))
            {
                GooagooLog.info("商品加入购物清单：加入购物清单失败（" + new Gson().toJson(shoppingPlanGoodsList) + "）");
                return new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_ADDTOSHOPPINGLIST_SUCCESS, null);
        }
        catch (NoShoppingPlanException e)
        {
            GooagooLog.error("加入购物清单：没有数据", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_NOTEXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("加入购物清单：购物清单中添加商品异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_FAIL, null);
        }
        return transData;

    }

    @Override
    @MessageAnnotation(InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_DELETESHOPPINGLISTGOODS)
    public TransData<Object> deleteShoppinglistGoods(HttpServletRequest request)
    {

        TransData<Object> transData = null;
        try
        {
            String shoppingGoodsId = ServletRequestUtils.getStringParameter(request, "shoppingGoodsId");
            if (!this.shoppingPlanCoreService.deleteShoppingPlanGoods(shoppingGoodsId))
            {
                GooagooLog.info("删除购物清单商品：删除购物清单商品失败（" + shoppingGoodsId + "）");
                return new TransData<Object>(false, MessageConst.SHOPPINGLIST_ISHOPPINGLIST_DELETESHOPPINGLISTGOODS_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.SHOPPINGLIST_ISHOPPINGLIST_DELETESHOPPINGLISTGOODS_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("删除购物清单商品：购物清单中删除商品异常", e);
            transData = new TransData<Object>(false, MessageConst.SHOPPINGLIST_ISHOPPINGLIST_DELETESHOPPINGLISTGOODS_FAIL, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_UPDATESHOPPINGLIST)
    public TransData<Object> updateShoppinglist(HttpServletRequest request)
    {

        TransData<Object> transData = null;
        try
        {
            UserShoppingPlan userShoppingPlan = ServletUtils.objectMethod(UserShoppingPlan.class, request);
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            userShoppingPlan.setUserId(userId);
            userShoppingPlan.setInfoSource("W");
            if (!this.shoppingPlanCoreService.updateShoppingPlan(userShoppingPlan))
            {
                GooagooLog.info("编辑购物清单：编辑购物清单失败（" + userShoppingPlan.toString() + "）");
                return new TransData<Object>(false, MessageConst.SHOPPINGLIST_ISHOPPINGLIST_UPDATESHOPPINGLIST_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.SHOPPINGLIST_ISHOPPINGLIST_UPDATESHOPPINGLIST_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("编辑购物清单：编辑购物清单异常", e);
            transData = new TransData<Object>(false, MessageConst.SHOPPINGLIST_ISHOPPINGLIST_UPDATESHOPPINGLIST_FAIL, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_DELETESHOPPINGLIST)
    public TransData<Object> deleteShoppinglist(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String shoppingListId = ServletRequestUtils.getStringParameter(request, "shoppingListId");
            if (!this.shoppingPlanCoreService.deleteShoppingPlan(shoppingListId))
            {
                GooagooLog.info("删除物清单：删除物清单失败（" + shoppingListId + "）");
                return new TransData<Object>(false, MessageConst.SHOPPINGLIST_ISHOPPINGLIST_DELETESHOPPINGLIST_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.SHOPPINGLIST_ISHOPPINGLIST_DELETESHOPPINGLIST_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("删除物清单：删除物清单异常", e);
            transData = new TransData<Object>(false, MessageConst.SHOPPINGLIST_ISHOPPINGLIST_DELETESHOPPINGLIST_FAIL, null);
        }
        return transData;

    }

    @Override
    @MessageAnnotation(InterGusConstants.SHOPPINGLIST_SHOPPINGLIST_GETSHOPPINGLISTINFO)
    public TransData<Object> getShoppinglistInfo(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String shoppingListId = ServletRequestUtils.getStringParameter(request, "shoppingListId");
            UserShoppingPlan userShoppingPlan = this.uGeneratorQueryService.selectByPrimaryKey(shoppingListId);
            if ("Y".equals(userShoppingPlan.getIsDel()))
            {
                return new TransData<Object>(true, MessageConst.SHOPPINGLIST_ISHOPPINGLIST_GETSHOPPINGLISTINFO_NOTEXIST, null);
            }
            UShoppinglist uShoppinglist = new UShoppinglist();
            uShoppinglist.setTitle(userShoppingPlan.getTitle());
            uShoppinglist.setPreShoppingTime(userShoppingPlan.getPreShoppingTime());
            uShoppinglist.setShoppingListId(userShoppingPlan.getShoppingListId());
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uShoppinglist);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取购物清单详情：根据购物清单ID查询购物清单详情异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;
    }

}
