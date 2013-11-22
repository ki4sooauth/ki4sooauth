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
import com.gooagoo.api.business.query.transaction.order.OrderQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.transaction.PurchasedGoodsBusiness;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.exception.business.user.NoShoppingPlanException;
import com.gooagoo.igus.shoppinglist.service.IPurchasedGoodsService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.shoppinglist.UPurchasedGoods;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service("iPurchasedGoodsService")
public class IPurchasedGoodsServiceImpl implements IPurchasedGoodsService
{

    @Autowired
    private ShoppingPlanCoreService shoppingPlanCoreService;

    @Autowired
    private OrderQueryService orderQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.SHOPPINGLIST_PURCHASEDGOODS_GETPURCHASEDGOODSLIST)
    public TransData<Object> getPurchasedGoodsList(HttpServletRequest request)
    {

        TransData<Object> transData = null;
        try
        {
            //            PageModel<UPurchasedGoods> pageModel = new PageModel<UPurchasedGoods>();
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            if (StringUtils.isBlank(shopId))
            {
                shopId = null;
            }
            String goodsName = ServletRequestUtils.getStringParameter(request, "goodsName");
            if (StringUtils.isBlank(goodsName))
            {
                goodsName = null;
            }
            String begin = ServletRequestUtils.getStringParameter(request, "startDate");
            String end = ServletRequestUtils.getStringParameter(request, "endDate");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
            List<PurchasedGoodsBusiness> purchasedGoodsBusinessList = this.orderQueryService.findBoughtGoods(userId, shopId, null, null, goodsName, begin, end, pageIndex, pageSize);
            if (CollectionUtils.isEmpty(purchasedGoodsBusinessList))
            {
                GooagooLog.info("查询已购商品列表:没有查到已购商品信息");
                return new TransData<Object>(true, MessageConst.SHOPPINGLIST_IPURCHASEDGOODS_GETPURCHASEDGOODSLIST_NOTEXIST, null);
            }
            List<UPurchasedGoods> upurchasedGoodsList = new ArrayList<UPurchasedGoods>();
            for (PurchasedGoodsBusiness purchasedGoodsBusiness : purchasedGoodsBusinessList)
            {
                try
                {
                    UPurchasedGoods upurchasedGoods = new UPurchasedGoods();
                    upurchasedGoods.setGoodsName(purchasedGoodsBusiness.getGoodsName());
                    upurchasedGoods.setPayPice(FormatDataUtils.formatGoodsPrice(Double.valueOf(purchasedGoodsBusiness.getPayPrice())));
                    upurchasedGoods.setShopName(purchasedGoodsBusiness.getShopName());
                    upurchasedGoods.setTime(TimeUtils.convertDateToString(TimeUtils.convertStringToDate(purchasedGoodsBusiness.getRequestTime()), "yyyy-MM-dd"));
                    upurchasedGoods.setGoodsId(purchasedGoodsBusiness.getGoodsId());
                    upurchasedGoods.setGoodsUrl(UrlUtils.getGoodsUrl(purchasedGoodsBusiness.getGoodsId()));
                    upurchasedGoods.setGoodsNum(purchasedGoodsBusiness.getGoodsNum());
                    if (StringUtils.isNotBlank(purchasedGoodsBusiness.getGoodsImg()))
                    {
                        List<String> imgs = new Gson().fromJson(purchasedGoodsBusiness.getGoodsImg(), new TypeToken<List<String>>()
                        {
                        }.getType());
                        upurchasedGoods.setGoodsImg(FormatDataUtils.formatImageInfo(imgs.get(0)));
                    }
                    upurchasedGoodsList.add(upurchasedGoods);
                }
                catch (Exception e)
                {
                    GooagooLog.error("查询已购商品列表：组装单个已购商品信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, upurchasedGoodsList);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询已购商品列表：查询已购商品的购物清单异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;

    }

    @Override
    @MessageAnnotation(InterGusConstants.SHOPPINGLIST_PURCHASEDGOODS_ADDTOSHOPPINGLIST)
    public TransData<Object> addToShoppinglist(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {

            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            List<ShoppingPlanGoods> shoppingPlanGoodsList = new ArrayList<ShoppingPlanGoods>();
            ShoppingPlanGoods goodlist = new ShoppingPlanGoods();
            String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId");
            String goodsName = ServletRequestUtils.getStringParameter(request, "goodsName");
            goodlist.setGoodsId(goodsId);
            goodlist.setGoodsName(goodsName);
            shoppingPlanGoodsList.add(goodlist);
            if (!this.shoppingPlanCoreService.addShoppingPlanGoods(userId, shoppingPlanGoodsList))
            {
                GooagooLog.info("商品加入购物清单：加入购物清单失败（" + new Gson().toJson(shoppingPlanGoodsList) + "）");
                return new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_ADDTOSHOPPINGLIST_SUCCESS, null);
        }
        catch (NoShoppingPlanException e)
        {
            GooagooLog.error("商品加入购物清单：没有数据", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_NOTEXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("商品加入购物清单：加入购物清单失败", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_FAIL, null);
        }

        return transData;
    }

}
