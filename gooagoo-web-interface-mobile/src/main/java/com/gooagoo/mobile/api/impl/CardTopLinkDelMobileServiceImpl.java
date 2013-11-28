package com.gooagoo.mobile.api.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.member.usermember.UserMemberCoreService;
import com.gooagoo.api.business.core.transaction.order.OrderCoreService;
import com.gooagoo.api.business.core.user.favorite.FavoriteCoreService;
import com.gooagoo.api.business.core.user.notice.UserNoticeCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CardTopLinkDelMobileService;
import com.gooagoo.mobile.api.CommonMobileService;
import com.gooagoo.mobile.common.MessageConst;

@Service
public class CardTopLinkDelMobileServiceImpl implements CardTopLinkDelMobileService
{
    @Autowired
    private UserMemberCoreService userMemberCoreService;
    @Autowired
    private CommonMobileService commonMobileService;
    @Autowired
    private FavoriteCoreService favoriteCoreService;
    @Autowired
    private OrderCoreService orderCoreService;
    @Autowired
    private UserNoticeCoreService userNoticeCoreService;

    @Override
    public void DelUserMemberCard(String userId, String sessionId, String scardno) throws Exception
    {
        GooagooLog.info("DelUseMemberCard-->入参:userId=" + userId + ",sessionId=" + sessionId + ",scardno=" + scardno);

        //1.判断用户是否登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        //2.封装要批量删除的会员名卡卡号信息
        List<String> scardNoList = Arrays.asList(scardno.split(","));
        //3.删除用户会员卡
        this.userMemberCoreService.deleteMemberForMobile(scardNoList, userId);
    }

    @Override
    public void DelUserFavoriate(String userId, String sessionId, String favoriteId) throws Exception
    {
        GooagooLog.info("DelUseMemberCard-->入参:userId=" + userId + ",sessionId=" + sessionId + ",favoriteId=" + favoriteId);

        //1.判断用户是否登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.删除用户收藏
        if (!this.favoriteCoreService.deleteFavorite(favoriteId))
        {
            throw new MessageException(MessageConst.MOBILE_CARDTOP_DEL_FAVORIATE_FAIL);
        }
    }

    @Override
    public void DelUserBill(String userId, String sessionId, String orderinfo) throws Exception
    {
        //1.判断用户是否登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.删除用户账单
        if (!this.orderCoreService.deleteOrder(orderinfo))
        {
            throw new MessageException(MessageConst.MOBILE_CARDTOP_DEL_BILL_FAIL);
        }
    }

    @Override
    public void DelUserReceiveNotice(String userId, String sessionId, String infoid) throws Exception
    {
        //1.判断用户是否登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.删除用户接收到的通知
        if (!this.userNoticeCoreService.deleteNotice(infoid))
        {
            throw new MessageException(MessageConst.MOBILE_CARDTOP_DEL_RECEIVE_NOTICE_FAIL);
        }
    }

}
