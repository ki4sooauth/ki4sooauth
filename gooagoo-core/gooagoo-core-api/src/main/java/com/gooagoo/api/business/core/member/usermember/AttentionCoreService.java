package com.gooagoo.api.business.core.member.usermember;

import com.gooagoo.exception.business.user.ShopNotExistAttentionCardException;
import com.gooagoo.exception.business.user.UserAlreadyAttentionShopException;
import com.gooagoo.exception.business.user.UserAlreadyShopMemberException;

public interface AttentionCoreService
{
    /**
     * 关注
     * @param userId
     * @param shopId
     * @return
     * @throws ShopNotExistAttentionCardException 商家无关注卡异常
     * @throws UserAlreadyAttentionShopException 用户已关注商家异常
     * @throws UserAlreadyShopMemberException 用户已是商家会员异常
     */
    public boolean addAttention(String userId, String shopId) throws Exception;

    /**
     * 取消关注
     * @param userId
     * @param shopId
     * @return
     * @throws Exception
     */
    public boolean deleteAttention(String userId, String shopId) throws Exception;

}
