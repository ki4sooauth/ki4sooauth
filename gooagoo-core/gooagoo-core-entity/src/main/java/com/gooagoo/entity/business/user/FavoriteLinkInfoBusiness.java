package com.gooagoo.entity.business.user;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.entity.business.marketing.IsdeletedInfo;

public class FavoriteLinkInfoBusiness implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**用户收藏信息 */
    private List<FavoriteInfoBusiness> favoriteInfoBusinessList;

    /**用户收藏信息 */
    private IsdeletedInfo isdeletedInfo;

    public List<FavoriteInfoBusiness> getFavoriteInfoBusinessList()
    {
        return this.favoriteInfoBusinessList;
    }

    public void setFavoriteInfoBusinessList(List<FavoriteInfoBusiness> favoriteInfoBusinessList)
    {
        this.favoriteInfoBusinessList = favoriteInfoBusinessList;
    }

    public IsdeletedInfo getIsdeletedInfo()
    {
        return this.isdeletedInfo;
    }

    public void setIsdeletedInfo(IsdeletedInfo isdeletedInfo)
    {
        this.isdeletedInfo = isdeletedInfo;
    }

    @Override
    public String toString()
    {
        return "FavoriteLinkInfoBusiness [favoriteInfoBusinessList=" + this.favoriteInfoBusinessList + ", isdeletedInfo=" + this.isdeletedInfo + "]";
    }

}
