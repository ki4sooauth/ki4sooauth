package com.gooagoo.analysis.common.utils;

/**
 * 手机推送信息
 * @author Administrator
 *
 */
public class UserSendConstants
{
    /**
     * 收藏
     */
    public final static String FAVORITE = "{\"title\":\"${content}\",\"msgtype\":\"fav\"}";

    /**
     * 位置(定位)
     */
    public final static String POSITION = "{\"title\":\"${title}\",\"msgtype\":\"posopen\",\"Mid\":\"${Mid}\",\"x\":\"${x}\",\"y\":\"${y}\"}";

    /**
     * 位置(行为 到店和离店)
     */
    public final static String BEHAVIOR = "{\"title\":\"${title}\",\"msgtype\":\"${msgtype}\",\"Sid\":\"${Sid}\",\"Eid\":\"${Eid}\"}";

    /**
     * 会员申请、物理卡转换审批  
     */
    public final static String APPLICATIONCARD = "{\"title\":\"您在${shopName}申请的卡已经通过审核，请刷新卡列表 \",\"msgtype\":\"card\"}";

    /**
     * 到店发卡 
     */
    public final static String NEWCARD = "{\"title\":\"欢迎光临${shopName}，为了更好的获取服务，请接受${cardName}\",\"msgtype\":\"newcard\",\"shopid\":\"${shopid}\",\"cardid\":\"${cardid}\",\"cardtype\":\"${cardtype}\"}";

    /**
     * 发放积分 
     */
    public final static String INTEGRAL = "{\"title\":\"您获得了${integral}积分\",\"msgtype\":\"score\"}";

    /**
     * 刷卡成功
     */
    public final static String SWIPE = "{\"title\":\"\",\"msgtype\":\"swipecard\",\"type\":\"${type}\",\"scardno\":\"${cardNo}\"}";

    /**
     * 账单消费信息
     */
    public final static String ACCOUNT = "{\"title\": \"您在${shopName}消费${price}元，账单已生成\",\"msgtype\": \"bill\",\"billid\": \"${billId}\"}";

    /**
     * 远程排号
     */
    public final static String REMOTEQUEUE = "{\"title\":\"您排在${selfNo}号，目前入位到${curNO}号，还有${redisNo}号到您，当前有${payNo}桌正在结账，请耐心等候\",\"msgtype\":\"direct\"}";

    /**
     * 商家通知内容
     */
    public final static String SHOPNOTICE = "{\"title\":\"${shopName}给您发送了新的通知\",\"msgtype\":\"notice\",\"shopid\":\"${shopid}\"}";

    /**
     * 商家吆喝内容
     */
    public final static String SHOPCRYOUT = "{\"title\":\"\",\"msgtype\":\"weibo\"}";

    /**
     * 购好奇
     */
    public final static String BUYINTRE = "{\"title\":\"${shopName}给您发送了新的购好奇\",\"msgtype\":\"info\",\"url\":\"${url}\"}";

    /**
     * 结账扫描一维码
     */
    public final static String SCANCODESUC = "{\"title\":\"\",\"msgtype\":\"scan\",\"name\":\"${goodName}\",\"price\":\"${goodPrice}\",\"code\":\"${goodOneCode}\",\"goodsid\":\"${goodId}\",\"shopid\":\"${shopId}\",\"description\":\"${goodDes}\"}";

    /**
     * 零售店员助理提交订单
     */
    public final static String SUBMITORDER = "{\"title\":\"\",\"msgtype\":\"finishscan\",\"price\":\"${totalGoodsPrice}\",\"total\":\"${totalGoodsNum}\"}";

}
