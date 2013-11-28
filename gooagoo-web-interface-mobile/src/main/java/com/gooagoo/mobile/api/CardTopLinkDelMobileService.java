package com.gooagoo.mobile.api;

/**
 * 卡包删除相关接口
 * 如果接口接口入参同时存在userId,sessionId,则需要先校验是否登录
 */
public interface CardTopLinkDelMobileService
{
    /**
     * 接口 moba02 : 手机端删除用户会员卡接口 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param scardno 会员卡音频卡号，如有多个以逗号分隔，如：1,2,3
     * @return
     * @throws Exception
     */
    public void DelUserMemberCard(String userId, String sessionId, String scardno) throws Exception;

    /**
     * 接口 moba15 : 手机端删除用户收藏接口 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param favoriteId 收藏信息编号，如有多个以逗号分隔，如：1,2,3
     * @return
     * @throws Exception
     */
    public void DelUserFavoriate(String userId, String sessionId, String favoriteId) throws Exception;

    /**
     * 接口 moba16 : 手机端用户账单接口 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param orderinfo 账单编号，如有多个以逗号分隔，如：1,2,3
     * @return
     * @throws Exception
     */
    public void DelUserBill(String userId, String sessionId, String orderinfo) throws Exception;

    /**
     * 接口 moba17 : 手机端用户通知接口 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param noticeinfoid 信息编号(通知编号)，如有多个以逗号分隔，如：1,2,3
     * @return
     * @throws Exception
     */
    public void DelUserReceiveNotice(String userId, String sessionId, String noticeinfoid) throws Exception;
}
