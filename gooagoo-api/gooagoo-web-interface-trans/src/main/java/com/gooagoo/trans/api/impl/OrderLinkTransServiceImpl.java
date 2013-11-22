package com.gooagoo.trans.api.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.marketing.coupon.CouponCoreService;
import com.gooagoo.api.business.query.goods.query.GoodsQueryService;
import com.gooagoo.api.business.query.member.swipe.SwipeCardQueryService;
import com.gooagoo.api.business.query.shop.table.TableStatusQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.member.CardinfoBusiness;
import com.gooagoo.entity.business.shop.table.TableStatus;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.trans.api.OrderLinkTransService;
import com.gooagoo.trans.entity.gtsc09.transform.DeskStatusList;
import com.gooagoo.trans.entity.gtsc09.transform.GetAllDeskStatusRoot;
import com.gooagoo.trans.entity.gtsc11.transform.Cardinfo;
import com.gooagoo.trans.entity.gtsc11.transform.SwipeCardRoot;
import com.gooagoo.trans.entity.gtsc13.transform.Goodsinfo;
import com.gooagoo.trans.entity.gtsc13.transform.QueryGoodsInfoRoot;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class OrderLinkTransServiceImpl implements OrderLinkTransService
{
    @Autowired
    private CouponCoreService couponCoreService;
    @Autowired
    private TableStatusQueryService tableStatusQueryService;
    @Autowired
    private SwipeCardQueryService swipeCardQueryService;
    @Autowired
    private GoodsQueryService goodsQueryService;

    @Override
    public boolean couponCheck(String orderId, String agreeyInfo) throws Exception
    {
        GooagooLog.info("couponCheck-->入参:orderId=" + orderId + ",agreeyInfo" + agreeyInfo);

        //1.从是否同意信息json串中取出数据并转换成List<Map<String, String>>
        List<Map<String, String>> couponList = new Gson().fromJson(agreeyInfo, new TypeToken<List<Map<String, String>>>()
        {
        }.getType());

        //2.校验确认优惠券的使用
        return this.couponCoreService.confirmCoupon(orderId, couponList);
    }

    @Override
    public GetAllDeskStatusRoot getAllDeskStatus(String shopEntityId, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("getAllDeskStatus-->入参:orderId=" + shopEntityId);
        //1.实体店所有餐桌状态查询
        List<TableStatus> findTableStatus = this.tableStatusQueryService.findTableStatus(shopEntityId, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));
        GooagooLog.debug("查询到的实体店餐桌状态 " + new Gson().toJson(findTableStatus));
        List<DeskStatusList> deskStatusList = null;
        if (CollectionUtils.isNotEmpty(findTableStatus))
        {
            //2.组装返回对象
            deskStatusList = new ArrayList<DeskStatusList>();
            for (TableStatus temp : findTableStatus)
            {
                DeskStatusList statusList = new DeskStatusList();
                statusList.setDeskno(temp.getTableName());
                statusList.setMaxnums(temp.getMaxNums());
                statusList.setMinnums(temp.getMinNums());
                statusList.setDeskstate(temp.getDeskStatus());
                statusList.setMealtime(temp.getMealTime());
                deskStatusList.add(statusList);
            }
        }
        GetAllDeskStatusRoot root = new GetAllDeskStatusRoot();
        root.setDeskStatusList(deskStatusList);

        return root;
    }

    @Override
    public SwipeCardRoot swipeCard(String scardno, String shopId) throws Exception
    {
        GooagooLog.info("swipeCard-->入参:scardno=" + scardno + ",shopId" + shopId);
        CardinfoBusiness cardinfoBusiness = this.swipeCardQueryService.userSwipe(scardno, shopId);
        Cardinfo resultCardinfo = null;
        if (cardinfoBusiness != null)
        {
            resultCardinfo = new Cardinfo();
            resultCardinfo.setCardname(cardinfoBusiness.getCardname());
            resultCardinfo.setScardno(scardno);
            resultCardinfo.setJifen(StringUtils.hasText(cardinfoBusiness.getJifen()) ? cardinfoBusiness.getJifen() : "0");
        }
        SwipeCardRoot root = new SwipeCardRoot();
        root.setCardinfo(resultCardinfo);
        return root;
    }

    @Override
    public QueryGoodsInfoRoot getGoodsInfo(String shopentityid, String itemserial) throws Exception
    {
        GooagooLog.info("getGoodsInfo-->入参:shopentityid=" + shopentityid + ",itemserial" + itemserial);
        //1.根据自定义序列号查询商品信息
        GoodsBaseInfo goodsBaseInfo = this.goodsQueryService.findGoodsByItemSerial(shopentityid, itemserial);

        GooagooLog.debug("根据shopentityid=" + shopentityid + ",itemserial" + itemserial + "查询到的商品详情为：" + new Gson().toJson(goodsBaseInfo));
        Goodsinfo goodsinfo = null;
        if (null != goodsBaseInfo)
        {
            //2.组装返回对象
            goodsinfo = new Goodsinfo();
            goodsinfo.setGoodsid(goodsBaseInfo.getGoodsId());
            goodsinfo.setGoodsname(goodsBaseInfo.getGoodsName());
            goodsinfo.setPrice(goodsBaseInfo.getPrice().toString());
        }
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root.setGoodsinfo(goodsinfo);
        return root;
    }
}
