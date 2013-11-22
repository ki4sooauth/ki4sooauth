package com.gooagoo.entity.business.shop.map;

import java.io.Serializable;

/**
 * svg区域图上  商家信息提示信息
 *
 */
public class SvgAreaTip implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String svgTagId;//svg图上的标签id值
    private Double areaPx;//区域x轴坐标
    private Double areaPy;//区域y轴坐标
    private String positionName;//位置名称
    private String positionDes;//位置描述
    private String shopEntityPhone;//实体店联系电话
    private String shopLogo;//商家logo1

    public String getSvgTagId()
    {
        return this.svgTagId;
    }

    public void setSvgTagId(String svgTagId)
    {
        this.svgTagId = svgTagId;
    }

    public Double getAreaPx()
    {
        return this.areaPx;
    }

    public void setAreaPx(Double areaPx)
    {
        this.areaPx = areaPx;
    }

    public Double getAreaPy()
    {
        return this.areaPy;
    }

    public void setAreaPy(Double areaPy)
    {
        this.areaPy = areaPy;
    }

    public String getPositionName()
    {
        return this.positionName;
    }

    public void setPositionName(String positionName)
    {
        this.positionName = positionName;
    }

    public String getPositionDes()
    {
        return this.positionDes;
    }

    public void setPositionDes(String positionDes)
    {
        this.positionDes = positionDes;
    }

    public String getShopEntityPhone()
    {
        return this.shopEntityPhone;
    }

    public void setShopEntityPhone(String shopEntityPhone)
    {
        this.shopEntityPhone = shopEntityPhone;
    }

    public String getShopLogo()
    {
        return this.shopLogo;
    }

    public void setShopLogo(String shopLogo)
    {
        this.shopLogo = shopLogo;
    }

}
