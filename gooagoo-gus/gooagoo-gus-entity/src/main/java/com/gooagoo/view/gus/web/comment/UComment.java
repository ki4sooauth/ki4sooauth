package com.gooagoo.view.gus.web.comment;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

/**
 * 用户评论商品响应数据
 * @author 
 *
 */
public class UComment implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userId;//用户ID

    private String userNickName;//昵称

    private String userAccount;//用户名

    private String userMobile;//手机号码

    private String userEmail;//电子邮箱

    private Image userHeadPic;//用户头像

    private String shopId;//商家ID

    private String shopName;//商家名称

    private String goodsId;//商品ID

    private String goodsName;//商品名称

    private String commentType;//评论类型

    private Integer commentLevel;//评分

    private String content;//评论内容

    private String source;//评论来源

    private String commentTime;//评论时间

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserNickName()
    {
        return userNickName;
    }

    public void setUserNickName(String userNickName)
    {
        this.userNickName = userNickName;
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

    public Image getUserHeadPic()
    {
        return this.userHeadPic;
    }

    public void setUserHeadPic(Image userHeadPic)
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

    public String getCommentTime()
    {
        return this.commentTime;
    }

    public void setCommentTime(String commentTime)
    {
        this.commentTime = commentTime;
    }

}
