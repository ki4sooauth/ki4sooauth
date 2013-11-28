package com.gooagoo.mobile.api.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.transaction.order.UserOrderCoreService;
import com.gooagoo.api.business.core.user.comment.CommentGoodsCoreService;
import com.gooagoo.api.business.core.user.queue.QueueCoreService;
import com.gooagoo.api.business.query.goods.query.GoodsQueryService;
import com.gooagoo.api.business.query.goods.statistical.StatisticalQueryService;
import com.gooagoo.api.business.query.shop.cache.ShopCacheQueryService;
import com.gooagoo.api.business.query.shop.table.TableStatusQueryService;
import com.gooagoo.api.business.query.transaction.order.OrderQueryService;
import com.gooagoo.api.business.query.user.cache.UserCacheQueryService;
import com.gooagoo.api.generator.query.bill.OrderDetailInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.PubUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.goods.GoodsContainComment;
import com.gooagoo.entity.business.goods.GoodsSalesRanking;
import com.gooagoo.entity.business.shop.table.TableTypeStatus;
import com.gooagoo.entity.business.transaction.OrderDetailInfoBusiness;
import com.gooagoo.entity.business.transaction.OrderLinkDetailInfoBusiness;
import com.gooagoo.entity.business.user.MobilePushInfoBusiness;
import com.gooagoo.entity.business.user.QueueBusiness;
import com.gooagoo.entity.business.user.UserCommentDetail;
import com.gooagoo.entity.generator.behave.UserComment;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CommonMobileService;
import com.gooagoo.mobile.api.ConsumeBillLinkInfoMobileService;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.common.ToolsUtils;
import com.gooagoo.mobile.entity.mobe09.transform.GoodsInfoFromOnecodevalueRoot;
import com.gooagoo.mobile.entity.mobe09.transform.Goodscontaincomment;
import com.gooagoo.mobile.entity.mobe09.transform.Onedimensioncode;
import com.gooagoo.mobile.entity.mobe09.transform.Usercomment;
import com.gooagoo.mobile.entity.mobe12.transform.DeskStatusRoot;
import com.gooagoo.mobile.entity.mobe12.transform.Deskstatuslist;
import com.gooagoo.mobile.entity.mobe13.transform.QueueRoot;
import com.gooagoo.mobile.entity.mobe14.transform.GoodsSequenceRoot;
import com.gooagoo.mobile.entity.mobe14.transform.Goodssequencelist;
import com.gooagoo.mobile.entity.mobe16.transform.BillListoRoot;
import com.gooagoo.mobile.entity.mobe16.transform.Billlisto;
import com.gooagoo.mobile.entity.mobe16.transform.Goodslist;
import com.gooagoo.mobile.entity.mobe17.transform.RefreshQueueRoot;
import com.gooagoo.mobile.entity.mobe17.transform.Refreshqueue;
import com.google.gson.Gson;

@Service
public class ConsumeBillLinkInfoMobileServiceImpl implements ConsumeBillLinkInfoMobileService
{
    @Autowired
    private QueueCoreService queueCoreService;
    @Autowired
    private OrderQueryService orderQueryService;
    @Autowired
    private UserOrderCoreService userOrderCoreService;
    @Autowired
    private TableStatusQueryService tableStatusQueryService;
    @Autowired
    private CommentGoodsCoreService commentGoodsCoreService;
    @Autowired
    private GoodsQueryService goodsQueryService;
    @Autowired
    private StatisticalQueryService statisticalQueryService;
    @Autowired
    private CommonMobileService commonMobileService;
    @Autowired
    private UserCacheQueryService userCacheQueryService;
    @Autowired
    private OrderDetailInfoGeneratorQueryService orderDetailInfoGeneratorQueryService;
    @Autowired
    private ShopCacheQueryService shopCacheQueryService;

    @Override
    public GoodsInfoFromOnecodevalueRoot getGoodsInfoByItemserial(String shopEntityId, String itemserial) throws Exception
    {
        GooagooLog.info("getGoodsInfoByItemserial-->入参:shopEntityId=" + shopEntityId + ",itemserial=" + itemserial);
        //1.通过扫码获取商品信息 
        List<GoodsContainComment> goodsContainCommentList = this.goodsQueryService.findGoodsContainComment(shopEntityId, itemserial);
        GooagooLog.debug("通扫码获取商品信息(目前只用于收藏广场mobe09)" + new Gson().toJson(goodsContainCommentList));
        List<Goodscontaincomment> goodscontaincommentList = null;

        if (CollectionUtils.isNotEmpty(goodsContainCommentList))
        {
            goodscontaincommentList = new ArrayList<Goodscontaincomment>();
            for (GoodsContainComment resultGoodsContainComment : goodsContainCommentList)
            {
                //2.1通过扫码获取商品信息 
                GoodsBaseInfo tempGoodsBaseInfo = resultGoodsContainComment.getGoodsDetail().getGoodsBaseInfo();
                Onedimensioncode tempOnedimensioncode = new Onedimensioncode();
                tempOnedimensioncode.setGoodsid(tempGoodsBaseInfo.getGoodsId());
                tempOnedimensioncode.setGoodsserial(tempGoodsBaseInfo.getGoodsSerial());
                tempOnedimensioncode.setItemserial(tempGoodsBaseInfo.getItemSerial());
                tempOnedimensioncode.setShopid(tempGoodsBaseInfo.getShopId());
                tempOnedimensioncode.setGoodsname(tempGoodsBaseInfo.getGoodsName());
                tempOnedimensioncode.setPrice(tempGoodsBaseInfo.getPrice().toString());
                tempOnedimensioncode.setGoodscontent(resultGoodsContainComment.getGoodsDetail().getGoodsContent());//商品信息描述
                String goodsImg = resultGoodsContainComment.getGoodsDetail().getGoodsImg();
                tempOnedimensioncode.setGoodsimg(StringUtils.hasText(goodsImg) ? UrlUtils.getAttachUrlByImg("s", JsonUtils.json2List(goodsImg).get(0)) : null);//设置图片（小图） 
                tempOnedimensioncode.setCommentnums(resultGoodsContainComment.getGoodsDetail().getCommentNums());//设置评论次数
                tempOnedimensioncode.setGoodsscore(resultGoodsContainComment.getGoodsDetail().getCommentLevel());//设置商品评分
                tempOnedimensioncode.setIntroduceurl(UrlUtils.getGoodsMobileUrl(tempGoodsBaseInfo.getGoodsId()));
                //2.2商品评论 
                List<Usercomment> usercommentList = null;
                if (CollectionUtils.isNotEmpty(resultGoodsContainComment.getUserCommentDetailList()))
                {
                    usercommentList = new ArrayList<Usercomment>();
                    for (UserCommentDetail resultUserCommentDetail : resultGoodsContainComment.getUserCommentDetailList())
                    {
                        Usercomment tempUsercomment = new Usercomment();
                        tempUsercomment.setCommentlevel(resultUserCommentDetail.getCommentLevel().toString());//设置评分
                        tempUsercomment.setContent(resultUserCommentDetail.getContent());//设置评论的具体内容
                        tempUsercomment.setCreatetime(TimeUtils.convertDateToString(resultUserCommentDetail.getCommentTime(), TimeUtils.FORMAT1));
                        tempUsercomment.setNickname(resultUserCommentDetail.getUserAccount());//设置昵称
                        usercommentList.add(tempUsercomment);
                    }
                }

                //封装商品信息及评论信息
                Goodscontaincomment tempGoodscontaincomment = new Goodscontaincomment();
                tempGoodscontaincomment.setOnedimensioncode(tempOnedimensioncode);
                tempGoodscontaincomment.setUsercomment(usercommentList);
                goodscontaincommentList.add(tempGoodscontaincomment);
            }

        }
        //2.组装返回商品信息及评论
        GoodsInfoFromOnecodevalueRoot root = new GoodsInfoFromOnecodevalueRoot();
        root.setGoodscontaincomment(goodscontaincommentList);
        return root;
    }

    @Override
    public boolean userCommentGoods(HttpServletRequest request, String mac, String userId, String sessionId, String orderId, String goodsId, String commentlevel, String content) throws Exception
    {
        GooagooLog.info("userCommentGoods-->入参:userId=" + userId + ",sessionId=" + sessionId + ",orderId=" + orderId + ",goodsId=" + goodsId + ",commentlevel=" + commentlevel + ",commentlevel=" + commentlevel);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        UserComment userComment = new UserComment();
        userComment.setUserId(userId);
        userComment.setSource("M");
        userComment.setCommentLevel(Integer.valueOf(commentlevel));
        userComment.setContent(content);
        MobilePushInfoBusiness mobilePushInfo = this.userCacheQueryService.findUserMobileInfoByMacAddress(mac);
        if (mobilePushInfo != null)
        {
            userComment.setComeIp(mobilePushInfo.getIp());
        }
        else
        {
            userComment.setComeIp(PubUtils.getIpAddr(request));
        }
        OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
        orderDetailInfoExample.createCriteria().andOrderIdEqualTo(orderId).andGoodsIdEqualTo(goodsId);
        List<OrderDetailInfo> orderDetailInfoList = this.orderDetailInfoGeneratorQueryService.selectByExample(orderDetailInfoExample);
        if (CollectionUtils.isEmpty(orderDetailInfoList))
        {
            GooagooLog.warn("所评论商品为在订单信息中不存在【orderId=" + orderId + ",goodsId=" + goodsId + "】");
            throw new MessageException(MessageConst.MOBILE_BILL_COMMENT_GOODS_FAIL);
        }
        OrderDetailInfo orderDetailInfo = orderDetailInfoList.get(0);
        //评论商品
        return this.commentGoodsCoreService.commentGoods(userComment, orderDetailInfo.getOrderDetailId());
    }

    @Override
    public DeskStatusRoot getDeskStatus(String userId, String sessionId, String shopEntityId) throws Exception
    {
        GooagooLog.info("getDeskStatus-->入参:【userId=" + userId + ",sessionId=" + sessionId + ",shopEntityId=" + shopEntityId + "】");
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //查询实体店餐桌状态
        List<TableTypeStatus> tableTypeStatusList = this.tableStatusQueryService.findTableTypeStatus(null, shopEntityId, null, null);
        GooagooLog.debug("查询实体店各类型餐桌状态" + new Gson().toJson(tableTypeStatusList));
        List<Deskstatuslist> deskstatuslist = null;
        if (CollectionUtils.isNotEmpty(tableTypeStatusList))
        {
            deskstatuslist = new ArrayList<Deskstatuslist>();
            for (TableTypeStatus temp : tableTypeStatusList)
            {
                Deskstatuslist deskstatus = new Deskstatuslist();
                deskstatus.setDesktype(temp.getTableTypeName());
                deskstatus.setMinnums(temp.getMinNums());
                deskstatus.setTotalnum(temp.getTableTypeSum());
                deskstatus.setMaxnums(temp.getMaxNums());
                deskstatus.setVacancynum(temp.getVacancynum());
                deskstatus.setCheckoutnum(temp.getCheckoutnum());
                deskstatus.setQueuenum(temp.getQueuenum());
                deskstatuslist.add(deskstatus);
            }
        }
        //组装返回参数
        DeskStatusRoot root = new DeskStatusRoot();
        root.setDeskstatuslist(deskstatuslist);
        return root;
    }

    @Override
    public QueueRoot userQueue(String userId, String sessionId, String shopId, String shopEntityId, String nums) throws Exception
    {
        GooagooLog.info("userQueue-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shopEntityId=" + shopEntityId + ",nums=" + nums);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //查询用餐排号
        QueueBusiness queueBusiness = this.queueCoreService.arranging(shopId, shopEntityId, null, userId, null, nums);
        GooagooLog.debug("用餐排号" + new Gson().toJson(queueBusiness));
        if (null == queueBusiness)
        {
            throw new MessageException(MessageConst.MOBILE_BILL_QUEUE_FAIL);
        }
        //组装返回参数
        QueueRoot root = new QueueRoot();
        root.setQueueno(queueBusiness.getQueueNo());
        root.setCurrentqueueno(queueBusiness.getCurrentqueueno());
        root.setWaitnum(queueBusiness.getWaitnum());
        root.setCheckoutnum(queueBusiness.getCheckoutnum());
        root.setCreatetime(queueBusiness.getCreatetime());
        return root;
    }

    @Override
    public GoodsSequenceRoot getGoodsSequenceInfo(String userId, String sessionId, String shopId, String keyWord, String goodsCategoryLeaf, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("getGoodsSequenceInfo-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shopId=" + shopId + ",pageIndex=" + pageIndex + ",pageSize=" + pageSize);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.查询销售排行信息
        List<GoodsSalesRanking> goodsSalesRankingList = this.statisticalQueryService.salesRanking(shopId, goodsCategoryLeaf, keyWord, null, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));

        GooagooLog.debug("查询到的销售排行信息为：" + new Gson().toJson(goodsSalesRankingList));
        List<Goodssequencelist> goodssequencelist = null;
        if (CollectionUtils.isNotEmpty(goodsSalesRankingList))
        {
            //3.封装销售排行信息
            goodssequencelist = new ArrayList<Goodssequencelist>();
            for (GoodsSalesRanking tempGoodsSalesRanking : goodsSalesRankingList)
            {
                Goodssequencelist tempGoodssequencelist = new Goodssequencelist();
                tempGoodssequencelist.setGoodsid(tempGoodsSalesRanking.getGoodsId());
                tempGoodssequencelist.setGoodsimg(tempGoodsSalesRanking.getGoodsImg());
                tempGoodssequencelist.setGoodsname(tempGoodsSalesRanking.getGoodsName());
                tempGoodssequencelist.setPrice(tempGoodsSalesRanking.getGoodsPrice());
                tempGoodssequencelist.setSellnum(tempGoodsSalesRanking.getSales());
                tempGoodssequencelist.setGoodscategoryleaf(tempGoodsSalesRanking.getCategoryLeafId());
                tempGoodssequencelist.setCategoryname(tempGoodsSalesRanking.getCategoryLeafName());
                tempGoodssequencelist.setIntroduceurl(UrlUtils.getGoodsMobileUrl(tempGoodsSalesRanking.getGoodsId()));
                goodssequencelist.add(tempGoodssequencelist);
            }
        }

        GoodsSequenceRoot root = new GoodsSequenceRoot();
        root.setGoodssequencelist(goodssequencelist);
        return root;
    }

    @Override
    public boolean orderidBind(String userId, String sessionId, String orderId, String tableNo2d) throws Exception
    {
        GooagooLog.info("orderidBind-->入参:userId=" + userId + ",sessionId=" + sessionId + ",orderId=" + orderId + ",tableNo2d=" + tableNo2d);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.根据餐桌二维码获取餐桌信息
        List<String> tableInfo = ToolsUtils.getTableInfo(tableNo2d);
        GooagooLog.debug("餐桌信息为:" + new Gson().toJson(tableInfo));
        //3.绑定桌号、订单号、用户id
        boolean result = this.userOrderCoreService.bindTable(orderId, tableInfo.get(3), tableInfo.get(4));
        if (!result)
        {
            throw new MessageException(MessageConst.MOBILE_BILL_TABLENO_BIND_ORDER_FAIL);
        }
        return result;
    }

    @Override
    public BillListoRoot getOrderListById(String userId, String sessionId, String orderId) throws Exception
    {
        GooagooLog.info("getOrderListById-->入参:userId=" + userId + ",sessionId=" + sessionId + ",orderId=" + orderId);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.查询订单信息
        OrderLinkDetailInfoBusiness orderLinkDetailInfoBusiness = this.orderQueryService.findOrderListForAll(userId, null, null, orderId, null, null, null, null, null, null, null, null, null);

        GooagooLog.debug("查询到的订单信息为:" + new Gson().toJson(orderLinkDetailInfoBusiness));

        Billlisto billlisto = null;
        //3.封装查询到的订单信息
        if (CollectionUtils.isNotEmpty(orderLinkDetailInfoBusiness.getOrderDetailInfoBusiness()))
        {
            OrderDetailInfoBusiness temp = orderLinkDetailInfoBusiness.getOrderDetailInfoBusiness().get(0);
            billlisto = new Billlisto();
            billlisto.setBillid(temp.getOrderid());
            billlisto.setOrderid(temp.getOrderid());
            billlisto.setBilltype("3".equals(temp.getBilltype()) ? "3" : "0");//订单状态，0-订单，3-账单
            Map<String, String> shopInfoMap = this.shopCacheQueryService.findShopInfo(temp.getShopid());
            if (shopInfoMap != null && shopInfoMap.size() > 0)
            {
                if ("餐饮".equals(shopInfoMap.get("shopTypeRootName")))
                {//订单所属行业类型
                    billlisto.setIndustrytype("0");
                }
                else
                {
                    billlisto.setIndustrytype("1");
                }
            }
            billlisto.setShopid(temp.getShopid());
            billlisto.setShopentityid(temp.getShopentityid());
            billlisto.setUserid(temp.getUserid());
            billlisto.setRequesttime(temp.getRequesttime());
            billlisto.setScardno(temp.getScardno());
            billlisto.setDiscountrate(temp.getDiscountrate());
            billlisto.setGoodstotalnum(temp.getGoodstotalnum());
            billlisto.setOriginalprice(temp.getOriginalprice());
            billlisto.setPayprice(temp.getPayprice());
            billlisto.setIntegralnumber(temp.getIntegralnumber());
            billlisto.setIsinvoiced(temp.getIsinvoice());
            billlisto.setInvoicedtime(temp.getInvoicetime());
            billlisto.setIsdel(temp.getIsdel());
            billlisto.setCtimestamp(temp.getCtimestamp());
            billlisto.setBillimg(temp.getBillimg());
            billlisto.setLatestinvoicetime(temp.getInvoicelatesttime());
            List<Goodslist> goodslists = null;
            //账单中商品列表
            if (CollectionUtils.isNotEmpty(temp.getOrderDetailInfoList()))
            {
                goodslists = new ArrayList<Goodslist>();
                for (OrderDetailInfo orderDetailInfo : temp.getOrderDetailInfoList())
                {
                    Goodslist goodslist = new Goodslist();
                    goodslist.setGoodsid(orderDetailInfo.getGoodsId());
                    goodslist.setGoodsimg(orderDetailInfo.getGoodsImg());
                    goodslist.setGoodsname(orderDetailInfo.getGoodsName());
                    goodslist.setGoodsprice(orderDetailInfo.getPrice() != null ? String.valueOf(orderDetailInfo.getPrice()) : "0.00");
                    goodslist.setPromotionprice(orderDetailInfo.getPayPrice() != null ? String.valueOf(orderDetailInfo.getPayPrice()) : "0.00");
                    goodslist.setGoodsnum(orderDetailInfo.getGoodsNum() != null ? String.valueOf(orderDetailInfo.getGoodsNum()) : "0");
                    goodslist.setIntroduceurl(UrlUtils.getGoodsMobileUrl(orderDetailInfo.getGoodsId()));
                    goodslists.add(goodslist);
                }
            }
            billlisto.setGoodslist(goodslists);
        }

        BillListoRoot root = new BillListoRoot();
        root.setBilllisto(billlisto);
        return root;
    }

    @Override
    public RefreshQueueRoot refreshQueue(String userId, String sessionId, String shopEntityId) throws Exception
    {
        GooagooLog.info("refreshQueue-->入参:userId=" + userId + ",sessionId=" + sessionId + ",shopEntityId=" + shopEntityId);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.刷新排号

        List<QueueBusiness> queueBusinessList = this.queueCoreService.refreshArranging(userId, shopEntityId);
        GooagooLog.debug("获取到的刷新排号信息为:" + new Gson().toJson(queueBusinessList));
        //3.组装返回数据
        List<Refreshqueue> refreshqueueList = null;
        if (CollectionUtils.isNotEmpty(queueBusinessList))
        {
            refreshqueueList = new ArrayList<Refreshqueue>();
            for (QueueBusiness queueBusiness : queueBusinessList)
            {
                Refreshqueue refreshqueue = new Refreshqueue();
                refreshqueue.setShopid(queueBusiness.getShopId());
                refreshqueue.setShopentityid(queueBusiness.getShopEntityId());
                refreshqueue.setQueueno(queueBusiness.getQueueNo());
                refreshqueue.setCurrentqueueno(queueBusiness.getCurrentqueueno());
                refreshqueue.setWaitnum(queueBusiness.getWaitnum());
                refreshqueue.setCheckoutnum(queueBusiness.getCheckoutnum());
                refreshqueue.setCreatetime(queueBusiness.getCreatetime());
                refreshqueueList.add(refreshqueue);
            }

        }

        RefreshQueueRoot root = new RefreshQueueRoot();
        root.setRefreshqueue(refreshqueueList);
        return root;
    }

}
