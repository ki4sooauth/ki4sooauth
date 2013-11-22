package com.gooagoo.view.gms.apply;

import java.io.Serializable;

public class FOrderDetailAndPicInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private FOrderDetailInfo detailInfo;

    private FOrderPic pic;

    public FOrderDetailInfo getDetailInfo()
    {
        return this.detailInfo;
    }

    public void setDetailInfo(FOrderDetailInfo detailInfo)
    {
        this.detailInfo = detailInfo;
    }

    public FOrderPic getPic()
    {
        return this.pic;
    }

    public void setPic(FOrderPic pic)
    {
        this.pic = pic;
    }
}
