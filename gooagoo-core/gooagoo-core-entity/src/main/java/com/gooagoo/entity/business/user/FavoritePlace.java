package com.gooagoo.entity.business.user;

import java.io.Serializable;

/**
 * 用户收藏详细信息
 */

public class FavoritePlace implements Serializable
{

    private static final long serialVersionUID = 1L;

    /**  类型，A-活动，G-商品，C-优惠券  */
    private String objType = "";

    /**  id  */
    private String objId = "";

    /**  图片  */
    private String objImg = "";

    /**  名称  */
    private String objName = "";

    /**  链接  */
    private String linkUrl = "";

    /**  商家id  */
    private String shopId = "";

    /**  商家名称  */
    private String shopName = "";

    /**  收藏人数  */
    private String favNums = "";

    /**  评论数量  */
    private String commentNums = "";

    /**  是否收藏，Y-已收藏，N-未收藏  */
    private String isFav = "";

    public String getObjType()
    {
        return this.objType;
    }

    public void setObjType(String objType)
    {
        this.objType = objType;
    }

    public String getObjId()
    {
        return this.objId;
    }

    public void setObjId(String objId)
    {
        this.objId = objId;
    }

    public String getObjImg()
    {
        return this.objImg;
    }

    public void setObjImg(String objImg)
    {
        this.objImg = objImg;
    }

    public String getObjName()
    {
        return this.objName;
    }

    public void setObjName(String objName)
    {
        this.objName = objName;
    }

    public String getLinkUrl()
    {
        return this.linkUrl;
    }

    public void setLinkUrl(String linkUrl)
    {
        this.linkUrl = linkUrl;
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

    public String getFavNums()
    {
        return this.favNums;
    }

    public void setFavNums(String favNums)
    {
        this.favNums = favNums;
    }

    public String getCommentNums()
    {
        return this.commentNums;
    }

    public void setCommentNums(String commentNums)
    {
        this.commentNums = commentNums;
    }

    public String getIsFav()
    {
        return this.isFav;
    }

    public void setIsFav(String isFav)
    {
        this.isFav = isFav;
    }

    @Override
    public String toString()
    {
        return "FavoritePlace [objType=" + this.objType + ", objId=" + this.objId + ", objImg=" + this.objImg + ", objName=" + this.objName + ", linkUrl=" + this.linkUrl + ", shopId=" + this.shopId + ", shopName=" + this.shopName + ", favNums=" + this.favNums + ", commentNums=" + this.commentNums + ", isFav=" + this.isFav + "]";
    }

}
