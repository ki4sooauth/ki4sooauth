package com.gooagoo.view.mis.recommendManage;

import java.io.Serializable;
import java.util.Date;

public class MGoodsMarketingInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String goodsId;//商品编号

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String vendor;//供应商

    private String positionId;//位置编号，描述商品在实体店中所处的位置

    private String goodsContent;//商品推荐描述

    private String goodsSolution;//商品解决方案描述

    private String crossGoods;//交叉销售商品，json串

    private String relationGoods;//关联销售商品，json串

    private String replaceGoods;//可替换商品，json串

    private String lifeIdea;//环保型，健康型，实惠型，品质型

    private String useType;//自用型，送礼型

    private String feature;//功能

    private String address;//产地

    private String crowd;//人群

    private String useMessage;//使用方法

    private String goodsImg;//商品图片URL，json串

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    private String goodsName;//goods_base_info表的商品名称

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
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

    public String getVendor()
    {
        return vendor;
    }

    public void setVendor(String vendor)
    {
        this.vendor = vendor;
    }

    public String getPositionId()
    {
        return positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public String getGoodsContent()
    {
        return goodsContent;
    }

    public void setGoodsContent(String goodsContent)
    {
        this.goodsContent = goodsContent;
    }

    public String getGoodsSolution()
    {
        return goodsSolution;
    }

    public void setGoodsSolution(String goodsSolution)
    {
        this.goodsSolution = goodsSolution;
    }

    public String getCrossGoods()
    {
        return crossGoods;
    }

    public void setCrossGoods(String crossGoods)
    {
        this.crossGoods = crossGoods;
    }

    public String getRelationGoods()
    {
        return relationGoods;
    }

    public void setRelationGoods(String relationGoods)
    {
        this.relationGoods = relationGoods;
    }

    public String getReplaceGoods()
    {
        return replaceGoods;
    }

    public void setReplaceGoods(String replaceGoods)
    {
        this.replaceGoods = replaceGoods;
    }

    public String getLifeIdea()
    {
        return lifeIdea;
    }

    public void setLifeIdea(String lifeIdea)
    {
        this.lifeIdea = lifeIdea;
    }

    public String getUseType()
    {
        return useType;
    }

    public void setUseType(String useType)
    {
        this.useType = useType;
    }

    public String getFeature()
    {
        return feature;
    }

    public void setFeature(String feature)
    {
        this.feature = feature;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCrowd()
    {
        return crowd;
    }

    public void setCrowd(String crowd)
    {
        this.crowd = crowd;
    }

    public String getUseMessage()
    {
        return useMessage;
    }

    public void setUseMessage(String useMessage)
    {
        this.useMessage = useMessage;
    }

    public String getGoodsImg()
    {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
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

    public String toString()
    {
        return this.goodsId + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.vendor + "^" + this.positionId + "^" + this.goodsContent + "^" + this.goodsSolution + "^" + this.crossGoods + "^" + this.relationGoods + "^" + this.replaceGoods + "^" + this.lifeIdea + "^" + this.useType + "^" + this.feature + "^" + this.address + "^" + this.crowd + "^" + this.useMessage + "^" + this.goodsImg + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
