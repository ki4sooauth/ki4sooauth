package com.gooagoo.view.gms.map;

import java.io.Serializable;

/**
 * 商家的svg地图
 *
 */
public class FShopSvgInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String shopEntityId;//实体店编号

    private String svgUrl;//svg图信息，多个，json串保存，

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getSvgUrl()
    {
        return this.svgUrl;
    }

    public void setSvgUrl(String svgUrl)
    {
        this.svgUrl = svgUrl;
    }
}
