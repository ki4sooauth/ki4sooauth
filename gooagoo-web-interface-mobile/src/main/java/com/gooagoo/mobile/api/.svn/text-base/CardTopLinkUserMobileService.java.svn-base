package com.gooagoo.mobile.api;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.mobile.entity.moba04.transform.MembernoticeRoot;
import com.gooagoo.mobile.entity.moba12.transform.AgreeCardRoot;
import com.gooagoo.mobile.entity.moba13.transform.GetMemberBaseInfoRoot;

/**
 * 卡包有关商家的相关接口
 * 如果接口入参同时存在userId,sessionId,则需要先校验是否登录
 */
public interface CardTopLinkUserMobileService
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
     * 接口 moba04 : 用户得到"通知" 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param cTimeStamp 最大时间戳
     * @param shopId 商家编号
     * @param noticeId 通知编号
     * @param pageType 翻页类型
     * @param pageSize 每页显示信息条数
     * @return
     * @throws Exception
     */
    public MembernoticeRoot getUserReceiveNotice(String userId, String sessionId, String cTimeStamp, String shopId, String noticeId, String pageType, String pageSize) throws Exception;

    /**
     * 接口 moba06 : 用户积分查询接口  
     * 如果查询出来用户的积分为null,需设置成“0”
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopId 商家编号
     * @return
     * @throws Exception
     */
    public String getUserIntegral(String userId, String sessionId, String shopId) throws Exception;

    /**
     * 接口 moba10 : 用户申请电子会员卡 
     * 其中reqeust入参中包含：（sex 性别、birthday 生日、postcode 邮编、address 地址）
     * @param request 接口请求参数集合
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopId 商家编号
     * @param realName 真实姓名
     * @return
     * @throws Exception
     */
    public boolean userApplyCard(HttpServletRequest request, String userId, String sessionId, String shopId, String realName) throws Exception;

    /**
     * 接口 moba11 : 用户申请实体卡电子化 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopId 商家编号
     * @param mobile 手机号
     * @param idNo  身份证号
     * @param phyNo 物理卡号
     * @return
     * @throws Exception
     */
    public boolean physicToElecCard(String userId, String sessionId, String shopId, String mobile, String idNo, String phyNo) throws Exception;

    /**
     * 接口 moba12 : 用户是否同意发卡 
     * @param request 接口请求参数集合
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopId 店铺id
     * @param cardId 卡号
     * @param cardType 卡类型
     * @param isAgree 是否同意
     * @return
     * @throws Exception
     */

    public AgreeCardRoot agreeGiveCard(String userId, String sessionId, String shopId, String cardId, String cardType, String isAgree) throws Exception;

    /**
     * 接口 moba13 : 查询会员信息 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopId 商家编号
     * @return
     * @throws Exception
     */
    public GetMemberBaseInfoRoot getMemberBaseInfo(String userId, String sessionId, String shopId) throws Exception;

    /**
     * 接口 moba14 : 修改会员信息 
     * 其中reqeust入参中包含：（sex 性别、birthday 生日、telephone 联系电话、 email 电子邮箱、postcode 邮编、address 地址、memberspecialinfo 特征值）
     * @param request 接口请求参数集合包含（）
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopId  商家编号
     * @param idtype  证件类型
     * @param idno    证件号码
     * @param mobile  手机号
     * @return
     * @throws Exception
     */

    public boolean updateMemberBaseInfo(HttpServletRequest request, String userId, String sessionId, String shopId, String idType, String idNo, String mobile) throws Exception;

    /**
     * 接口 moba15 : 手机端用户通知接口 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param noticeinfoid 信息编号(通知编号)，如有多个以逗号分隔，如：1,2,3
     * @return
     * @throws Exception
     */
    public void DelUserReceiveNotice(String userId, String sessionId, String noticeinfoid) throws Exception;

}
