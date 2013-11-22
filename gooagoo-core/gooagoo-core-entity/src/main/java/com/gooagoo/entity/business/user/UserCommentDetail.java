package com.gooagoo.entity.business.user;

import java.io.Serializable;
import java.util.Date;

public class UserCommentDetail implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userId;//用户ID

    private String userAccount;//用户名

    private String userMobile;//手机号码

    private String userEmail;//电子邮箱

    private String userHeadPic;//用户头像

    private String shopId;//商家ID

    private String shopName;//商家名称

    private String goodsId;//商品ID

    private String goodsName;//商品名称

    private String commentType;//评论类型

    private Integer commentLevel;//评分

    private String content;//评论内容

    private String commentId;//评论编号

    private String source;//评论来源

    private Date commentTime;//评论时间

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserAccount()
    {
        return this.userAccount;
    }

    public void setUserAccount(String userAccount)
    {
        this.userAccount = userAccount;
    }

    public String getUserMobile()
    {
        return this.userMobile;
    }

    public void setUserMobile(String userMobile)
    {
        this.userMobile = userMobile;
    }

    public String getUserEmail()
    {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }

    public String getUserHeadPic()
    {
        return this.userHeadPic;
    }

    public void setUserHeadPic(String userHeadPic)
    {
        this.userHeadPic = userHeadPic;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getGoodsName()
    {
        return this.goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getCommentType()
    {
        return this.commentType;
    }

    public void setCommentType(String commentType)
    {
        this.commentType = commentType;
    }

    public Integer getCommentLevel()
    {
        return this.commentLevel;
    }

    public void setCommentLevel(Integer commentLevel)
    {
        this.commentLevel = commentLevel;
    }

    public String getContent()
    {
        return this.content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getSource()
    {
        return this.source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public Date getCommentTime()
    {
        return this.commentTime;
    }

    public void setCommentTime(Date commentTime)
    {
        this.commentTime = commentTime;
    }

    public String getCommentId()
    {
        return this.commentId;
    }

    public void setCommentId(String commentId)
    {
        this.commentId = commentId;
    }

}
