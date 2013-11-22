package com.gooagoo.view.mis.dictionaryManage;

import java.io.Serializable;
import java.util.Date;

/**
 * 购物清单商品类型字典
 * @author Administrator
 *
 */
public class MShoppingListGoodsType implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Integer goodsTypeId;// 商品类型编号
    private String goodsTypeName;// 商品类型名称
    private Integer parentGoodsTypeId;// 上级类型编号，-1表示无上级
    private String frontPic;// 点击前图片
    private String backPic;// 点击后图片
    private Integer sortOrder;// 排序号
    private String isDel;// 是否删除，Y-已删除，N-未删除
    private Date createTime;// 创建时间
    private Date cTimeStamp;// 最后一次修改时间

    public Integer getGoodsTypeId()
    {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId)
    {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsTypeName()
    {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName)
    {
        this.goodsTypeName = goodsTypeName;
    }

    public Integer getParentGoodsTypeId()
    {
        return parentGoodsTypeId;
    }

    public void setParentGoodsTypeId(Integer parentGoodsTypeId)
    {
        this.parentGoodsTypeId = parentGoodsTypeId;
    }

    public String getFrontPic()
    {
        return frontPic;
    }

    public void setFrontPic(String frontPic)
    {
        this.frontPic = frontPic;
    }

    public String getBackPic()
    {
        return backPic;
    }

    public void setBackPic(String backPic)
    {
        this.backPic = backPic;
    }

    public Integer getSortOrder()
    {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder)
    {
        this.sortOrder = sortOrder;
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

}
