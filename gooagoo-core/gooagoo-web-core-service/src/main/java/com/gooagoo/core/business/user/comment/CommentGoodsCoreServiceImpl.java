package com.gooagoo.core.business.user.comment;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.user.comment.CommentGoodsCoreService;
import com.gooagoo.api.generator.core.behave.UserCommentGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OrderDetailInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OrderInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.user.UserProtectedCoreService;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataPatternUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.behave.UserComment;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.exception.business.behave.UserAlreadyCommentGoodsException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class CommentGoodsCoreServiceImpl implements CommentGoodsCoreService

{

    @Autowired
    private OrderInfoGeneratorCoreService orderInfoGeneratorCoreService;

    @Autowired
    private OrderDetailInfoGeneratorCoreService orderDetailInfoGeneratorCoreService;

    @Autowired
    private UserCommentGeneratorCoreService userCommentGeneratorCoreService;

    @Autowired
    private UserProtectedCoreService userProtectedCoreService;

    private final static Object synObject = new Object();//用户评论账单商品同步锁

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean commentGoods(UserComment userComment, String billDetailId) throws Exception
    {
        //1、评论数据校验
        this.checkCommentGoodsData(userComment, billDetailId);
        //2、计算评论类型
        userComment.setCommentType(this.getCommentType(userComment.getCommentLevel()));
        //3、处理评论商品
        synchronized (synObject)
        {
            //3.1、获取订单详细信息，校验是否已评论
            OrderDetailInfo orderDetailInfo = this.getOrderDetailInfo(billDetailId);
            //3.2、获取订单信息，校验账单是否允许被评论
            OrderInfo orderInfo = this.getOrderInfo(orderDetailInfo);
            //3.3、补充数据
            userComment.setCommentId(UUID.getUUID());
            userComment.setShopId(orderInfo.getShopId());
            userComment.setGoodsId(orderDetailInfo.getGoodsId());
            userComment.setIsAuditing("P");
            userComment.setIsDel("N");
            //3.4、保存评论相关数据
            if (!this.userCommentGeneratorCoreService.insertSelective(userComment))
            {
                GooagooLog.error("评论商品：保存评论数据（" + userComment.toString() + "）异常", null);
                throw new OperateFailException("保存评论数据（" + userComment.toString() + "）异常");
            }
            orderDetailInfo.setCommentId(userComment.getCommentId());
            if (!this.orderDetailInfoGeneratorCoreService.updateByPrimaryKeySelective(orderDetailInfo))
            {
                GooagooLog.error("评论商品：更新订单详细信息（" + orderDetailInfo.toString() + "）异常", null);
                throw new OperateFailException("更新订单详细信息（" + orderDetailInfo.toString() + "）异常");
            }
        }

        return true;
    }

    /**
     * 校验评论商品数据
     * @param userComment
     * @param billDetailId
     * @return
     * @throws NullException 
     * @throws OperateFailException 
     * @throws FormatErrorException 
     */
    private boolean checkCommentGoodsData(UserComment userComment, String billDetailId) throws NullException, OperateFailException, FormatErrorException
    {
        //1、校验用户
        if (!this.userProtectedCoreService.checkUserStatus(userComment.getUserId()))
        {
            GooagooLog.info("校验评论商品数据：用户（" + userComment.getUserId() + "）状态异常");
            throw new OperateFailException("用户（" + userComment.getUserId() + "）状态异常");
        }
        //2、校验评分
        if (userComment.getCommentLevel() == null)
        {
            GooagooLog.info("校验评论商品数据：评分（" + userComment.getCommentLevel() + "）为空");
            throw new NullException("评分（" + userComment.getCommentLevel() + "）为空");
        }
        if (userComment.getCommentLevel() < 1 || userComment.getCommentLevel() > 5)
        {
            GooagooLog.info("校验评论商品数据：评分（" + userComment.getCommentLevel() + "）有误");
            throw new FormatErrorException("评分（" + userComment.getCommentLevel() + "）有误");
        }
        //3、校验评论内容
        if (StringUtils.isBlank(userComment.getContent()))
        {
            GooagooLog.info("校验评论商品数据：评论内容（" + userComment.getContent() + "）为空");
            throw new NullException("评论内容（" + userComment.getContent() + "）为空");
        }
        if (userComment.getContent().length() > 200)
        {
            GooagooLog.info("校验评论商品数据：评论内容（" + userComment.getContent() + "）长度超过200个字符");
            throw new FormatErrorException("评论内容（" + userComment.getContent() + "）长度超过200个字符");
        }
        //4、校验评论来源
        if (SysdictionaryCache.get("info_source", userComment.getSource()) == null)
        {
            GooagooLog.info("校验评论商品数据：评论来源（" + userComment.getSource() + "）有误");
            throw new NullException("评论来源（" + userComment.getSource() + "）有误");
        }
        //5、校验评论IP
        if (!DataPatternUtils.checkIpAddress(userComment.getComeIp()))
        {
            GooagooLog.info("校验评论商品数据：评论IP（" + userComment.getComeIp() + "）有误");
            throw new NullException("评论IP（" + userComment.getComeIp() + "）有误");
        }
        //6、校验订单详细编号
        if (StringUtils.isBlank(billDetailId))
        {
            GooagooLog.info("校验评论商品数据：订单详细编号（" + billDetailId + "）有误");
            throw new NullException("订单详细编号（" + billDetailId + "）有误");
        }

        return true;
    }

    /**
     * 根据评分计算评论类型
     * @param commentLevel
     * @return
     */
    private String getCommentType(int commentLevel)
    {
        String commentType = null;
        if (commentLevel == 5)
        {
            commentType = "3";//好评
        }
        else if (commentLevel > 2)
        {
            commentType = "2";//中评
        }
        else
        {
            commentType = "1";//差评
        }

        return commentType;
    }

    /**
     * 获取订单详细信息
     * @param orderDetailInfoId
     * @return
     * @throws OperateFailException
     */
    private OrderDetailInfo getOrderDetailInfo(String orderDetailInfoId) throws Exception
    {
        OrderDetailInfo orderDetailInfo = this.orderDetailInfoGeneratorCoreService.selectByPrimaryKey(orderDetailInfoId);
        if (orderDetailInfo == null)
        {
            GooagooLog.info("获取订单详细信息：订单详细信息（" + orderDetailInfoId + "）不存在");
            throw new OperateFailException("订单详细信息（" + orderDetailInfoId + "）不存在");
        }
        if (StringUtils.isNotBlank(orderDetailInfo.getCommentId()))
        {
            GooagooLog.info("获取订单详细信息：订单（" + orderDetailInfoId + "已评论（" + orderDetailInfo.getCommentId() + "）");
            throw new UserAlreadyCommentGoodsException("订单（" + orderDetailInfoId + "已评论（" + orderDetailInfo.getCommentId() + "）");
        }

        return orderDetailInfo;
    }

    /**
     * 获取订单信息
     * @param orderDetailInfo
     * @return
     * @throws OperateFailException
     */
    private OrderInfo getOrderInfo(OrderDetailInfo orderDetailInfo) throws OperateFailException
    {
        OrderInfo orderInfo = this.orderInfoGeneratorCoreService.selectByPrimaryKey(orderDetailInfo.getOrderId());
        if (orderInfo == null || "Y".equals(orderInfo.getIsDel()))
        {
            GooagooLog.info("获取订单信息：订单（" + orderDetailInfo.getOrderId() + "）不存在或已被删除");
            throw new OperateFailException("订单（" + orderDetailInfo.getOrderId() + "）不存在或已被删除");
        }
        if (!"3".equals(orderInfo.getBillType()))
        {
            GooagooLog.info("获取订单信息：订单（" + orderInfo.getOrderId() + "|" + orderInfo.getBillType() + "）不允许被评论");
            throw new OperateFailException("订单（" + orderInfo.getOrderId() + "|" + orderInfo.getBillType() + "）不允许被评论");
        }

        return orderInfo;
    }

}
