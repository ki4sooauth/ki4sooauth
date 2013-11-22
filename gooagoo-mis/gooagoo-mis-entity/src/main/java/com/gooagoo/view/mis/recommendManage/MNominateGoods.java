package com.gooagoo.view.mis.recommendManage;

import java.io.Serializable;
import java.util.Date;

/**
 * 推荐商品
 * @author Administrator
 *
 */
public class MNominateGoods implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String id;// 自动编号，UUID
    private String shopId;// 商家编号
    private String shopEntityId;// 实体店编号
    private String goodsId;// 商品编号，UUID
    private String goodsName;// 商品名称
    private String goodsImg;// 商品图片URL
    private Date startTime;// 起始时间
    private Date endTime;// 结束时间
    private String isDel;// 是否删除，Y-已删除，N-未删除
    private Date createTime;// 创建时间
    private Date cTimeStamp;// 最后一次修改时间
    
    private String shopName;// 商家名称
    private String shopEntityName;// 实体店名称

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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

    public String getGoodsImg()
    {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
    }

    public Date getStartTime()
    {
        return startTime;
    }

    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
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

    public String getShopEntityName()
    {
        return shopEntityName;
    }

    public void setShopEntityName(String shopEntityName)
    {
        this.shopEntityName = shopEntityName;
    }

}
