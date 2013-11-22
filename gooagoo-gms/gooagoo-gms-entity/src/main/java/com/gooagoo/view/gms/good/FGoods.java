package com.gooagoo.view.gms.good;

import java.io.Serializable;

public class FGoods implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String goodsId; //商品编号
    private String goodsName;//商品名称
    private String shopId; //商家Id
    private String entityId;//实体店Id
    private String entityName;//实体店名称
    private String brandId;//商品品牌Id
    private String categoryRootId;// 品类根节点
    private String categoryLeafId;// 品类页节点
    private String goodsSerial;//商品序列号
    private String itemSerial;//单品序列号
    private String price;//商品价格
    private String mobileVisitUrl;//手机端访问地址
    private String webVisitUrl;//网站端访问地址
    private String brandName;//品牌名称
    private String categoryLeafName;// 页品类名称
    private String goodsImg;//商品主图URL
    private String status;// 审核发布状态
    private String auditNote;// 审核描述

    public String getEntityName()
    {
        return entityName;
    }

    public void setEntityName(String entityName)
    {
        this.entityName = entityName;
    }

    public String getGoodsImg()
    {
        return this.goodsImg;
    }

    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
    }

    public String getMobileVisitUrl()
    {
        return this.mobileVisitUrl;
    }

    public void setMobileVisitUrl(String mobileVisitUrl)
    {
        this.mobileVisitUrl = mobileVisitUrl;
    }

    public String getWebVisitUrl()
    {
        return this.webVisitUrl;
    }

    public void setWebVisitUrl(String webVisitUrl)
    {
        this.webVisitUrl = webVisitUrl;
    }

    public String getPrice()
    {
        return this.price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getBrandName()
    {
        return this.brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }

    public String getCategoryLeafName()
    {
        return this.categoryLeafName;
    }

    public void setCategoryLeafName(String categoryLeafName)
    {
        this.categoryLeafName = categoryLeafName;
    }

    public String getCategoryRootId()
    {
        return this.categoryRootId;
    }

    public void setCategoryRootId(String categoryRootId)
    {
        this.categoryRootId = categoryRootId;
    }

    public String getCategoryLeafId()
    {
        return this.categoryLeafId;
    }

    public void setCategoryLeafId(String categoryLeafId)
    {
        this.categoryLeafId = categoryLeafId;
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

    public String getBrandId()
    {
        return this.brandId;
    }

    public void setBrandId(String brandId)
    {
        this.brandId = brandId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getGoodsSerial()
    {
        return this.goodsSerial;
    }

    public void setGoodsSerial(String goodsSerial)
    {
        this.goodsSerial = goodsSerial;
    }

    public String getItemSerial()
    {
        return this.itemSerial;
    }

    public void setItemSerial(String itemSerial)
    {
        this.itemSerial = itemSerial;
    }

    public String getEntityId()
    {
        return this.entityId;
    }

    public void setEntityId(String entityId)
    {
        this.entityId = entityId;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getAuditNote()
    {
        return this.auditNote;
    }

    public void setAuditNote(String auditNote)
    {
        this.auditNote = auditNote;
    }
}
