package com.gooagoo.mobile.api;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.mobile.entity.mobe09.transform.GoodsInfoFromOnecodevalueRoot;
import com.gooagoo.mobile.entity.mobe12.transform.DeskStatusRoot;
import com.gooagoo.mobile.entity.mobe13.transform.QueueRoot;
import com.gooagoo.mobile.entity.mobe14.transform.GoodsSequenceRoot;
import com.gooagoo.mobile.entity.mobe16.transform.BillListoRoot;
import com.gooagoo.mobile.entity.mobe17.transform.RefreshQueueRoot;

/**
 * 消费账单关联信息接口
 * 如果接口接口入参同时存在userId,sessionId,则需要先校验是否登录
 */
public interface ConsumeBillLinkInfoMobileService
{

    /**
     * 接口 mobe09 : 通过扫码获取商品信息 
     * @param shopEntityId 实体店编号
     * @param itemserial 商品自定义序列号
     * @return
     * @throws Exception
     */
    public GoodsInfoFromOnecodevalueRoot getGoodsInfoByItemserial(String shopEntityId, String itemserial) throws Exception;

    /**
     * 接口 mobe11 : 用户评论商品 
     * @param request 接口入参对象
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param orderId 订单编号
     * @param goodsId 商品编号
     * @param commentlevel 评分，范围1-5
     * @param content 评论内容
     * @return
     * @throws Exception
     */
    public boolean userCommentGoods(HttpServletRequest request, String mac, String userId, String sessionId, String orderId, String goodsId, String commentlevel, String content) throws Exception;

    /**
     * 接口 mobe12 : 餐桌状态查询 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopEntityId 实体店编号
     * @return
     * @throws Exception
     */
    public DeskStatusRoot getDeskStatus(String userId, String sessionId, String shopEntityId) throws Exception;

    /**
     * 接口 mobe13 : 用餐排号 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopId 商家编号
     * @param shopEntityId 实体店编号
     * @param nums 就餐人数
     * @return
     * @throws Exception
     */
    public QueueRoot userQueue(String userId, String sessionId, String shopId, String shopEntityId, String nums) throws Exception;

    /**
     * 接口 mobe14 : 品类销售排行 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopId 商家编号
     * @param keyWord  查询关键字,用于对产品名称的模糊查询
     * @param goodsCategoryLeaf 品类编号（叶节点）
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public GoodsSequenceRoot getGoodsSequenceInfo(String userId, String sessionId, String shopId, String keyWord, String goodsCategoryLeaf, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口 mobe15 : 绑定桌号、订单号、用户id 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param orderId 订单编号
     * @param tableNo2d 桌号二维码，格式["gooagoo","00","实体店编号","桌号","房间号"]
     * @return
     * @throws Exception
     */
    public boolean orderidBind(String userId, String sessionId, String orderId, String tableNo2d) throws Exception;

    /**
     * 接口 mobe16 : 通过“账单/订单编号”查询“账单/订单”信息 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param orderId 订单编号
     * @return
     * @throws Exception
     */
    public BillListoRoot getOrderListById(String userId, String sessionId, String orderId) throws Exception;

    /**
     * 接口 mobe17 : 刷新排号状态 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopEntityId 实体店编号
     * @return
     * @throws Exception
     */
    public RefreshQueueRoot refreshQueue(String userId, String sessionId, String shopEntityId) throws Exception;

}
