package com.gooagoo.entity.business.marketing.cryout;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.entity.business.marketing.IsdeletedInfo;

public class ShopCryoutInfoBusiness implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private IsdeletedInfo IsdeletedInfo;

    private List<ShopCryoutInfo> shopCryoutInfoList;

    public IsdeletedInfo getIsdeletedInfo()
    {
        return this.IsdeletedInfo;
    }

    public void setIsdeletedInfo(IsdeletedInfo isdeletedInfo)
    {
        this.IsdeletedInfo = isdeletedInfo;
    }

    public List<ShopCryoutInfo> getShopCryoutInfoList()
    {
        return this.shopCryoutInfoList;
    }

    public void setShopCryoutInfoList(List<ShopCryoutInfo> shopCryoutInfoList)
    {
        this.shopCryoutInfoList = shopCryoutInfoList;
    }

    @Override
    public String toString()
    {
        return "ShopCryoutInfoBusiness [IsdeletedInfo=" + this.IsdeletedInfo + ", shopCryoutInfoList=" + this.shopCryoutInfoList + "]";
    }

}
