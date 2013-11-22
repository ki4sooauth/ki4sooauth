package com.gooagoo.entity.business.user.shoppingmatch;

import java.io.Serializable;

/**
 * 位置 
 */
public class PositionInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 位置id  */
    private String positionid = "";

    /** 位置名称  */
    private String positionname = "";

    /**  购物匹配列表  */
    private java.util.List<MatchInfoList> matchlist = new java.util.ArrayList<MatchInfoList>();

    /**
     * 设置位置id 
     * @param positionid	位置id 
     */
    public void setPositionid(String positionid)
    {
        this.positionid = positionid;
    }

    /**
     * 获取位置id 
     * @return	位置id 
     */
    public String getPositionid()
    {
        return this.positionid;
    }

    /**
     * 设置位置名称 
     * @param positionname	位置名称 
     */
    public void setPositionname(String positionname)
    {
        this.positionname = positionname;
    }

    /**
     * 获取位置名称 
     * @return	位置名称 
     */
    public String getPositionname()
    {
        return this.positionname;
    }

    /**
     * 设置 购物匹配列表 
     * @param matchlist	 购物匹配列表 
     */
    public void setMatchlist(java.util.List<MatchInfoList> matchlist)
    {
        this.matchlist = matchlist;
    }

    /**
     * 获取 购物匹配列表 
     * @return	 购物匹配列表 
     */
    public java.util.List<MatchInfoList> getMatchlist()
    {
        return this.matchlist;
    }

    /**
     * 添加 购物匹配列表 
     * @return matchlist	 购物匹配列表 
     */
    public MatchInfoList addMoreMatchlist()
    {
        MatchInfoList matchlist = new MatchInfoList();
        this.matchlist.add(matchlist);
        return matchlist;
    }
}