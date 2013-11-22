package com.gooagoo.view.gms.shopinfo;

import com.gooagoo.view.gms.common.PageModel;

public class PositionInfo
{

    private FShopPosition fShopPosition;

    public FShopPosition getfShopPosition()
    {
        return this.fShopPosition;
    }

    public void setfShopPosition(FShopPosition fShopPosition)
    {
        this.fShopPosition = fShopPosition;
    }

    public PageModel<FShopEntityInfo> getPageFShopEntityInfo()
    {
        return this.pageFShopEntityInfo;
    }

    public void setPageFShopEntityInfo(PageModel<FShopEntityInfo> pageFShopEntityInfo)
    {
        this.pageFShopEntityInfo = pageFShopEntityInfo;
    }

    private PageModel<FShopEntityInfo> pageFShopEntityInfo;
}
