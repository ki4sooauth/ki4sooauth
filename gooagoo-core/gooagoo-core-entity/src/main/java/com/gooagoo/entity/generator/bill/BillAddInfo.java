package com.gooagoo.entity.generator.bill;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户提交的加菜减菜申请（仅针对餐饮）
 */

public class BillAddInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String orderDetailId;//订单明细编号

    private String orderId;//订单编号

    private String goodsId;//商品编号

    private String goodsName;//商品名称

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String goodsCategoryRoot;//品类编号（根节点）

    private String goodsCategoryLeaf;//品类编号（叶节点）

    private String goodsBrand;//品牌编号

    private String goodsSerial;//商品序列号（商品的唯一识别编码）

    private String itemSerial;//自定义序列号（商品细分的唯一识别编码）

    private Double price;//商品价格

    private String goodsImg;//商品主图地址

    private Integer goodsNum;//商品数量

    private String userId;//提交者

    private String typeDeal;//类型，0-加菜，1-减菜

    private String isDeal;//商家是否处理，Y-已处理，N未处理

    private Date dealTime;//商家处理时间

    private String note;//备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getOrderDetailId()
    {
        return this.orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId)
    {
        this.orderDetailId = orderDetailId;
    }

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
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

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getGoodsCategoryRoot()
    {
        return this.goodsCategoryRoot;
    }

    public void setGoodsCategoryRoot(String goodsCategoryRoot)
    {
        this.goodsCategoryRoot = goodsCategoryRoot;
    }

    public String getGoodsCategoryLeaf()
    {
        return this.goodsCategoryLeaf;
    }

    public void setGoodsCategoryLeaf(String goodsCategoryLeaf)
    {
        this.goodsCategoryLeaf = goodsCategoryLeaf;
    }

    public String getGoodsBrand()
    {
        return this.goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand)
    {
        this.goodsBrand = goodsBrand;
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

    public Double getPrice()
    {
        return this.price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public String getGoodsImg()
    {
        return this.goodsImg;
    }

    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
    }

    public Integer getGoodsNum()
    {
        return this.goodsNum;
    }

    public void setGoodsNum(Integer goodsNum)
    {
        this.goodsNum = goodsNum;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getTypeDeal()
    {
        return this.typeDeal;
    }

    public void setTypeDeal(String typeDeal)
    {
        this.typeDeal = typeDeal;
    }

    public String getIsDeal()
    {
        return this.isDeal;
    }

    public void setIsDeal(String isDeal)
    {
        this.isDeal = isDeal;
    }

    public Date getDealTime()
    {
        return this.dealTime;
    }

    public void setDealTime(Date dealTime)
    {
        this.dealTime = dealTime;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.orderDetailId + "^" + this.orderId + "^" + this.goodsId + "^" + this.goodsName + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.goodsCategoryRoot + "^" + this.goodsCategoryLeaf + "^" + this.goodsBrand + "^" + this.goodsSerial + "^" + this.itemSerial + "^" + this.price + "^" + this.goodsImg + "^" + this.goodsNum + "^" + this.userId + "^" + this.typeDeal + "^" + this.isDeal + "^" + this.dealTime + "^" + this.note + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
