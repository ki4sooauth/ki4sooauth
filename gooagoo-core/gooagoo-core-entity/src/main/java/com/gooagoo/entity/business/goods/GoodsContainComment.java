package com.gooagoo.entity.business.goods;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.entity.business.user.UserCommentDetail;

/**
 * 商品信息包含评论
 */

public class GoodsContainComment implements Serializable
{
    private static final long serialVersionUID = 1L;

    private GoodsDetail goodsDetail;

    private List<UserCommentDetail> userCommentDetailList;

    public GoodsDetail getGoodsDetail()
    {
        return this.goodsDetail;
    }

    public void setGoodsDetail(GoodsDetail goodsDetail)
    {
        this.goodsDetail = goodsDetail;
    }

    public List<UserCommentDetail> getUserCommentDetailList()
    {
        return this.userCommentDetailList;
    }

    public void setUserCommentDetailList(List<UserCommentDetail> userCommentDetailList)
    {
        this.userCommentDetailList = userCommentDetailList;
    }

}
