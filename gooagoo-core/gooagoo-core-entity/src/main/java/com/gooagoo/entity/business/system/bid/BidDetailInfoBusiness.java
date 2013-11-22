package com.gooagoo.entity.business.system.bid;

import java.io.Serializable;
import java.util.List;

/**
 * 竞拍详细信息
 */
public class BidDetailInfoBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String count;//总条数
    private List<BidDetailInfo> bidDetailInfoList;//商家竞拍信息

    public String getCount()
    {
        return this.count;
    }

    public void setCount(String count)
    {
        this.count = count;
    }

    public List<BidDetailInfo> getBidDetailInfoList()
    {
        return this.bidDetailInfoList;
    }

    public void setBidDetailInfoList(List<BidDetailInfo> bidDetailInfoList)
    {
        this.bidDetailInfoList = bidDetailInfoList;
    }

    @Override
    public String toString()
    {
        return "BidDetailInfoBusiness [count=" + this.count + ", bidDetailInfoList=" + this.bidDetailInfoList.toString() + "]";
    }

}
