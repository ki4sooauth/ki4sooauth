package com.gooagoo.query.business.user.comment;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.user.comment.CommentQueryService;
import com.gooagoo.api.generator.query.behave.UserCommentGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserProfileGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.user.UserCommentDetail;
import com.gooagoo.entity.generator.behave.UserComment;
import com.gooagoo.entity.generator.behave.UserCommentExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserProfile;

/**
 * 评论
 */
@Service
public class CommentQueryServiceImpl implements CommentQueryService
{

    @Autowired
    private UserCommentGeneratorQueryService userCommentGeneratorQueryService;

    @Autowired
    private UserInfoGeneratorQueryService userInfoGeneratorQueryService;

    @Autowired
    private UserProfileGeneratorQueryService userProfileGeneratorQueryService;

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;

    @Override
    public List<UserCommentDetail> findUserCommentList(UserCommentExample userCommentExample) throws Exception
    {
        //1、获取评论信息
        List<UserComment> userCommentList = this.userCommentGeneratorQueryService.selectByExample(userCommentExample);
        if (CollectionUtils.isEmpty(userCommentList))
        {
            return null;
        }
        //2、组装返回数据
        List<UserCommentDetail> userCommentDetailList = new ArrayList<UserCommentDetail>();
        for (UserComment userComment : userCommentList)
        {
            UserInfo userInfo = this.userInfoGeneratorQueryService.selectByPrimaryKey(userComment.getUserId());
            if (userInfo == null)
            {
                userInfo = new UserInfo();
                GooagooLog.debug("查询商品评论列表（分页）：用户（" + userComment.getUserId() + "）信息不存在");
            }
            UserProfile userProfile = this.userProfileGeneratorQueryService.selectByPrimaryKey(userComment.getUserId());
            if (userProfile == null)
            {
                userProfile = new UserProfile();
                GooagooLog.debug("查询商品评论列表（分页）：用户（" + userComment.getUserId() + "）辅助信息不存在");
            }
            ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(userComment.getShopId());
            if (shopInfo == null)
            {
                GooagooLog.debug("查询商品评论列表（分页）：商家（" + userComment.getShopId() + "）信息不存在");
                continue;
            }
            GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorQueryService.selectByPrimaryKey(userComment.getGoodsId());
            if (goodsBaseInfo == null)
            {
                GooagooLog.debug("查询商品评论列表（分页）：商品（" + userComment.getGoodsId() + "）基本信息不存在");
                continue;
            }
            UserCommentDetail userCommentDetail = new UserCommentDetail();
            userCommentDetail.setUserId(userProfile.getUserId());
            userCommentDetail.setUserAccount(userInfo.getAccount());
            userCommentDetail.setUserEmail(userInfo.getEmail());
            userCommentDetail.setUserMobile(userInfo.getMobile());
            userCommentDetail.setUserHeadPic(userProfile.getHeadPic());
            userCommentDetail.setShopId(shopInfo.getShopId());
            userCommentDetail.setShopName(shopInfo.getShopName());
            userCommentDetail.setGoodsId(goodsBaseInfo.getGoodsId());
            userCommentDetail.setGoodsName(goodsBaseInfo.getGoodsName());
            userCommentDetail.setCommentType(userComment.getCommentType());
            userCommentDetail.setCommentLevel(userComment.getCommentLevel());
            userCommentDetail.setContent(userComment.getContent());
            userCommentDetail.setSource(userComment.getSource());
            userCommentDetail.setCommentTime(userComment.getCreateTime());
            userCommentDetail.setCommentId(userComment.getCommentId());
            userCommentDetailList.add(userCommentDetail);
        }

        return userCommentDetailList;
    }
}
