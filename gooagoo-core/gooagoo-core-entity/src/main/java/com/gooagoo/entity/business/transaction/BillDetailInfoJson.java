package com.gooagoo.entity.business.transaction;

import java.io.Serializable;
import java.util.List;

public class BillDetailInfoJson implements Serializable
{

    /**
     * 账单明细信息
     */
    private static final long serialVersionUID = 1L;

    public String tablename;//餐桌号

    public String tablestate;//餐桌状态

    public String tabletypename;//餐桌类型名称

    public Integer diningnumbers;//就餐人数

    public String thirdorderid;//第三方订单编号

    public Integer totalnum;//菜品总数量

    public Double totalprice = 0.00;//菜品总价格

    List<GoodsInfoJson> goodsinfolist;//账单明细中的商品信息

    public String getTablename()
    {
        return this.tablename;
    }

    public void setTablename(String tablename)
    {
        this.tablename = tablename;
    }

    public String getTablestate()
    {
        return this.tablestate;
    }

    public void setTablestate(String tablestate)
    {
        this.tablestate = tablestate;
    }

    public String getTabletypename()
    {
        return this.tabletypename;
    }

    public void setTabletypename(String tabletypename)
    {
        this.tabletypename = tabletypename;
    }

    public Integer getDiningnumbers()
    {
        return this.diningnumbers;
    }

    public void setDiningnumbers(Integer diningnumbers)
    {
        this.diningnumbers = diningnumbers;
    }

    public String getThirdorderid()
    {
        return this.thirdorderid;
    }

    public void setThirdorderid(String thirdorderid)
    {
        this.thirdorderid = thirdorderid;
    }

    public Integer getTotalnum()
    {
        return this.totalnum;
    }

    public void setTotalnum(Integer totalnum)
    {
        this.totalnum = totalnum;
    }

    public Double getTotalprice()
    {
        return this.totalprice;
    }

    public void setTotalprice(Double totalprice)
    {
        this.totalprice = totalprice;
    }

    public List<GoodsInfoJson> getGoodsinfolist()
    {
        return this.goodsinfolist;
    }

    public void setGoodsinfolist(List<GoodsInfoJson> goodsinfolist)
    {
        this.goodsinfolist = goodsinfolist;
    }

    @Override
    public String toString()
    {
        return "BillDetailInfoJson [tablename=" + this.tablename + ", tablestate=" + this.tablestate + ", tabletypename=" + this.tabletypename + ", diningnumbers=" + this.diningnumbers + ", thirdorderid=" + this.thirdorderid + ", totalnum=" + this.totalnum + ", totalprice=" + this.totalprice + ", goodsinfolist=" + this.goodsinfolist + "]";
    }

}
