package com.gooagoo.template.entity;

import java.io.Serializable;
import java.util.Date;

public class FGoods implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String goodsId;//商品编号，UUID
    private String goodsName;//商品名称
    private String shopId;//商家编号
    private String shopEntityId;//实体店编号
    private String goodsCategoryRoot;//品类编号（根节点）
    private String goodsCategoryLeaf;//品类编号（叶节点）
    private String goodsBrand;//品牌编号
    private String goodsSerial;//商品序列号（商品的唯一识别编码）
    private String itemSerial;//自定义序列号（商品细分的唯一识别编码）
    private String price;//商品价格
    private String templateId;//'模板编号'
    private String templateData;//'模板数据，保存的是html代码'
    private String publishStatus;//'状态（审核与发布），参考通用字典表的publish_status',
    private String auditNote;//'审核备注'
    private String isDel;//是否删除，Y-已删除，N-未删除
    private Date createTime;//创建时间
    private Date cTimeStamp;//最后一次修改时间

    private String shopName;//商家名称
    private String shopEntityName;//实体店名称
    private String brandId;//商品品牌Id
    private String mobileVisitUrl;//商品手机端访问地址
    private String webVisitUrl;//商品网站端访问地址
    private String brandName;//品牌名称
    private String categoryLeafName;// 页品类名称
    private String goodsImg;//商品主图URL
    private String shopMobileVisitUrl;//商家手机端访问地址
    private String shopWebVisitUrl;//商品网站端访问地址

    public String getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getGoodsCategoryRoot()
    {
        return goodsCategoryRoot;
    }

    public void setGoodsCategoryRoot(String goodsCategoryRoot)
    {
        this.goodsCategoryRoot = goodsCategoryRoot;
    }

    public String getGoodsCategoryLeaf()
    {
        return goodsCategoryLeaf;
    }

    public void setGoodsCategoryLeaf(String goodsCategoryLeaf)
    {
        this.goodsCategoryLeaf = goodsCategoryLeaf;
    }

    public String getGoodsBrand()
    {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand)
    {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsSerial()
    {
        return goodsSerial;
    }

    public void setGoodsSerial(String goodsSerial)
    {
        this.goodsSerial = goodsSerial;
    }

    public String getItemSerial()
    {
        return itemSerial;
    }

    public void setItemSerial(String itemSerial)
    {
        this.itemSerial = itemSerial;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getTemplateId()
    {
        return templateId;
    }

    public void setTemplateId(String templateId)
    {
        this.templateId = templateId;
    }

    public String getTemplateData()
    {
        return templateData;
    }

    public void setTemplateData(String templateData)
    {
        this.templateData = templateData;
    }

    public String getPublishStatus()
    {
        return publishStatus;
    }

    public void setPublishStatus(String publishStatus)
    {
        this.publishStatus = publishStatus;
    }

    public String getAuditNote()
    {
        return auditNote;
    }

    public void setAuditNote(String auditNote)
    {
        this.auditNote = auditNote;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getcTimeStamp()
    {
        return cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    public String getShopName()
    {
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getBrandId()
    {
        return brandId;
    }

    public void setBrandId(String brandId)
    {
        this.brandId = brandId;
    }

    public String getMobileVisitUrl()
    {
        return mobileVisitUrl;
    }

    public void setMobileVisitUrl(String mobileVisitUrl)
    {
        this.mobileVisitUrl = mobileVisitUrl;
    }

    public String getWebVisitUrl()
    {
        return webVisitUrl;
    }

    public void setWebVisitUrl(String webVisitUrl)
    {
        this.webVisitUrl = webVisitUrl;
    }

    public String getBrandName()
    {
        return brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }

    public String getCategoryLeafName()
    {
        return categoryLeafName;
    }

    public void setCategoryLeafName(String categoryLeafName)
    {
        this.categoryLeafName = categoryLeafName;
    }

    public String getGoodsImg()
    {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
    }

    public String getShopEntityName()
    {
        return shopEntityName;
    }

    public void setShopEntityName(String shopEntityName)
    {
        this.shopEntityName = shopEntityName;
    }

    public String getShopMobileVisitUrl()
    {
        return shopMobileVisitUrl;
    }

    public void setShopMobileVisitUrl(String shopMobileVisitUrl)
    {
        this.shopMobileVisitUrl = shopMobileVisitUrl;
    }

    public String getShopWebVisitUrl()
    {
        return shopWebVisitUrl;
    }

    public void setShopWebVisitUrl(String shopWebVisitUrl)
    {
        this.shopWebVisitUrl = shopWebVisitUrl;
    }

}
