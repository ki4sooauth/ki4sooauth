package com.gooagoo.igus.bill.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.transaction.order.OrderCoreService;
import com.gooagoo.api.business.core.user.comment.CommentGoodsCoreService;
import com.gooagoo.api.business.core.user.favorite.FavoriteCoreService;
import com.gooagoo.api.business.core.user.shoppingplan.ShoppingPlanCoreService;
import com.gooagoo.api.business.query.transaction.order.OrderQueryService;
import com.gooagoo.api.business.query.user.query.UserAccountQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.transaction.OrderGoodsBusiness;
import com.gooagoo.entity.business.transaction.OrderInfoBusiness;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.entity.generator.behave.UserComment;
import com.gooagoo.entity.log.GusClientInfo;
import com.gooagoo.exception.business.user.AlreadyCollectException;
import com.gooagoo.exception.business.user.NoShoppingPlanException;
import com.gooagoo.igus.bill.service.IElectricBillService;
import com.gooagoo.igus.utils.BehaveAnnotation;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.common.Image;
import com.gooagoo.view.gus.common.PageModel;
import com.gooagoo.view.gus.web.bill.UOrderGoods;
import com.gooagoo.view.gus.web.bill.UOrderInfo;
import com.google.gson.Gson;

@Service("iElectricBillService")
public class IElectricBillServiceImpl implements IElectricBillService
{

    @Autowired
    private FavoriteCoreService favoriteCoreService;

    @Autowired
    private ShoppingPlanCoreService shoppingPlanCoreService;

    @Autowired
    private CommentGoodsCoreService commentGoodsCoreService;

    @Autowired
    private OrderQueryService orderQueryService;

    @Autowired
    private UserAccountQueryService userAccountQueryService;

    @Autowired
    private OrderCoreService orderCoreService;

    @Override
    @MessageAnnotation(InterGusConstants.BILL_ELECTRICBILL_GETELECTRICBILLLIST)
    public TransData<Object> getElectricBillList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            PageModel<UOrderInfo> pageModel = new PageModel<UOrderInfo>();
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
            String orderBy = ServletRequestUtils.getStringParameter(request, "orderBy", "request_time desc");
            Date begin = TimeUtils.convertStringToDate(ServletRequestUtils.getStringParameter(request, "start"));
            Date end = TimeUtils.convertStringToDate(ServletRequestUtils.getStringParameter(request, "end"));
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 8);
            List<OrderInfoBusiness> orderInfoBusinesslist = this.orderQueryService.findOrderList(userId, shopId, begin, end, goodsName, pageIndex, pageSize, orderBy);
            if (CollectionUtils.isEmpty(orderInfoBusinesslist))
            {
                GooagooLog.info("获取电子账单列表：电子账单信息为空");
                return new TransData<Object>(true, MessageConst.BILL_IELECTRICBILL_GETELECTRICBILLLIST_NOTEXIST, null);
            }
            List<UOrderInfo> uorderInfolist = new ArrayList<UOrderInfo>();
            for (OrderInfoBusiness orderInfoBusiness : orderInfoBusinesslist)
            {
                UOrderInfo uorderInfo = new UOrderInfo();
                uorderInfo.setOrderId(orderInfoBusiness.getOrderId());
                uorderInfo.setLogo1(FormatDataUtils.formatImageInfo(orderInfoBusiness.getLogo1()));
                List<Image> imglist = new ArrayList<Image>();
                if (CollectionUtils.isNotEmpty(orderInfoBusiness.getCouponImgList()))
                {
                    for (int i = 0; i < orderInfoBusiness.getCouponImgList().size(); i++)
                    {
                        imglist.add(FormatDataUtils.formatImageInfo(orderInfoBusiness.getCouponImgList().get(i)));
                    }
                    uorderInfo.setCouponImgList(imglist);
                }
                if (StringUtils.isNotBlank(orderInfoBusiness.getPayPrice()))
                {
                    uorderInfo.setPayPrice(FormatDataUtils.formatGoodsPrice(Double.valueOf(orderInfoBusiness.getPayPrice())));
                }
                uorderInfo.setRequestTime(TimeUtils.convertDateToString(TimeUtils.convertStringToDate(orderInfoBusiness.getRequestTime()), "yyyy-MM-dd"));
                uorderInfo.setPicUrl(orderInfoBusiness.getPicUrl());
                uorderInfo.setShopName(orderInfoBusiness.getShopName());
                uorderInfolist.add(uorderInfo);
            }
            pageModel.setPageIndex(pageIndex);
            pageModel.setPageSize(pageSize);
            pageModel.setResult(uorderInfolist);
            pageModel.setCount(this.orderQueryService.countOrderList(userId, shopId, begin, end, goodsName));
            transData = new TransData<Object>(true, MessageConst.BILL_IELECTRICBILL_GETELECTRICBILLLIST_SUCCESS, pageModel);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取电子账单列表：获取电子账单列表异常", e);
            transData = new TransData<Object>(false, MessageConst.BILL_IELECTRICBILL_GETELECTRICBILLLIST_FAIL, null);
        }
        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.BILL_ELECTRICBILL_FAVORITEGOODS)
    public TransData<Object> favoriteGoods(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId");
            FavoriteInfo favoriteInfo = new FavoriteInfo();
            favoriteInfo.setObjectId(goodsId);
            favoriteInfo.setInfoType("G");
            favoriteInfo.setUserId(userId);
            favoriteInfo.setSource("W");
            if (!this.favoriteCoreService.addFavorite(favoriteInfo))
            {
                GooagooLog.info("收藏商品：收藏商品失败（" + favoriteInfo.toString() + "）");
                return new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_FAVORITEGOODS_SUCCESS, null);
        }
        catch (AlreadyCollectException e)
        {
            GooagooLog.error("收藏商品：已收藏异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_EXIST, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("收藏商品：收藏失败", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_FAVORITEGOODS_FAIL, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.BILL_ELECTRICBILL_ADDTOSHOPPINGLIST)
    public TransData<Object> addToShoppinglist(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId");
            String shopId = ServletRequestUtils.getStringParameter(request, "shopId");
            String goodsName = ServletRequestUtils.getStringParameter(request, "goodsName");
            List<ShoppingPlanGoods> shoppingPlanGoodsList = new ArrayList<ShoppingPlanGoods>();
            ShoppingPlanGoods goodlist = new ShoppingPlanGoods();
            goodlist.setGoodsId(goodsId);
            goodlist.setShopId(shopId);
            goodlist.setGoodsName(goodsName);
            shoppingPlanGoodsList.add(goodlist);
            if (!this.shoppingPlanCoreService.addShoppingPlanGoods(userId, shoppingPlanGoodsList))
            {
                GooagooLog.info("加入购物清单：加入购物清单失败（" + new Gson().toJson(shoppingPlanGoodsList) + "）");
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
            GooagooLog.error("加入购物清单：加入购物清单失败", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_ADDTOSHOPPINGLIST_FAIL, null);
        }
        return transData;
    }

    @Override
    @BehaveAnnotation(InterGusConstants.BILL_ELECTRICBILL_COMMENTGOODS)
    public TransData<Object> commentGoods(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String token = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_TOKEN);
            String billDetailId = ServletRequestUtils.getStringParameter(request, "billDetailId");
            PersonalLoginInfo userDetailInfo = this.userAccountQueryService.queryPersonalLoginInfo(token, "W", null);
            GusClientInfo gusClientInfo = new Gson().fromJson(userDetailInfo.getClientInfoJson(), GusClientInfo.class);
            UserComment userComment = ServletUtils.objectMethod(UserComment.class, request);//这个里面要传shopId,goodsId
            userComment.setComeIp(gusClientInfo.getIpAddress());
            userComment.setUserId(userId);
            userComment.setSource("W");
            if (!this.commentGoodsCoreService.commentGoods(userComment, billDetailId))
            {
                GooagooLog.info("评论商品：评论商品失败（" + userComment.toString() + "," + billDetailId + "）");
                return new TransData<Object>(false, MessageConst.BILL_IELECTRICBILL_COMMENTGOODS_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.BILL_IELECTRICBILL_COMMENTGOODS_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("评论商品：评论商品异常", e);
            transData = new TransData<Object>(false, MessageConst.BILL_IELECTRICBILL_COMMENTGOODS_FAIL, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.BILL_ELECTRICBILL_DELETEELECTRICBILL)
    public TransData<Object> deleteElectricBill(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String billId = ServletRequestUtils.getStringParameter(request, "billId");
            if (!this.orderCoreService.deleteOrder(billId))
            {
                GooagooLog.info("删除电子账单：删除电子账单失败（" + billId + "）");
                return new TransData<Object>(false, MessageConst.BILL_IELECTRICBILL_DELETEELECTRICBILL_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.BILL_IELECTRICBILL_DELETEELECTRICBILL_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("删除电子账单：删除电子账单异常", e);
            transData = new TransData<Object>(false, MessageConst.BILL_IELECTRICBILL_DELETEELECTRICBILL_FAIL, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.BILL_ELECTRICBILL_GETELECTRICBILLDETAIL)
    public TransData<Object> getElectricBillDetail(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String orderId = ServletRequestUtils.getStringParameter(request, "billId");
            List<OrderGoodsBusiness> OrderGoodslist = this.orderQueryService.findOrderDetail(orderId);
            if (CollectionUtils.isEmpty(OrderGoodslist))
            {
                GooagooLog.info("获取电子账单详细：电子账单详细为空");
                return new TransData<Object>(true, MessageConst.BILL_IELECTRICBILL_GETELECTRICBILLDETAIL_NOTEXIST, null);
            }
            List<UOrderGoods> uorderGoodsList = new ArrayList<UOrderGoods>();
            for (OrderGoodsBusiness orderGoodsBusiness : OrderGoodslist)
            {
                try
                {
                    UOrderGoods uorderGoods = new UOrderGoods();
                    uorderGoods.setBillDetailId(orderGoodsBusiness.getBillDetailId());
                    uorderGoods.setCommentId(orderGoodsBusiness.getCommentId());
                    uorderGoods.setCommentLevel(orderGoodsBusiness.getCommentLevel());
                    uorderGoods.setContent(orderGoodsBusiness.getContent());
                    uorderGoods.setGoodsId(orderGoodsBusiness.getGoodsId());
                    uorderGoods.setGoodsName(orderGoodsBusiness.getGoodsName());
                    uorderGoods.setShopId(orderGoodsBusiness.getShopId());
                    uorderGoods.setSave(FormatDataUtils.formatGoodsPrice(orderGoodsBusiness.getSave()));
                    uorderGoods.setPicUrl(UrlUtils.getGoodsUrl(orderGoodsBusiness.getGoodsId()));
                    //                    if (StringUtils.isNotBlank(orderGoodsBusiness.getGoodsImg()))
                    //                    {
                    //                        List<String> imgs = new Gson().fromJson(orderGoodsBusiness.getGoodsImg(), new TypeToken<List<String>>()
                    //                        {
                    //                        }.getType());
                    //                        uorderGoods.setGoodsImg(FormatDataUtils.formatImageInfo(imgs.get(0)));
                    //                    }
                    uorderGoods.setGoodsImg(FormatDataUtils.formatImageInfo(orderGoodsBusiness.getGoodsImg()));
                    uorderGoods.setGoodsNum(orderGoodsBusiness.getGoodsNum());
                    uorderGoods.setPayPrice(FormatDataUtils.formatGoodsPrice(orderGoodsBusiness.getPayPrice()));
                    if (orderGoodsBusiness.getPriceChange() > 0)
                    {
                        uorderGoods.setPriceChange(FormatDataUtils.formatGoodsPrice(orderGoodsBusiness.getPriceChange()));
                        uorderGoods.setPriceChangeName("涨价");
                    }
                    else if (orderGoodsBusiness.getPriceChange() < 0)
                    {
                        uorderGoods.setPriceChange(FormatDataUtils.formatGoodsPrice(orderGoodsBusiness.getPriceChange()));
                        uorderGoods.setPriceChangeName("降价");
                    }
                    uorderGoodsList.add(uorderGoods);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取电子账单详细：组装单个电子账单详细信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uorderGoodsList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取电子账单详细：获取电子账单详细异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }
        return transData;
    }

}
