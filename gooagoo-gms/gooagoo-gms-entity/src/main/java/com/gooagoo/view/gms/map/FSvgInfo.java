package com.gooagoo.view.gms.map;

import java.io.Serializable;

/**
 * svg地图信息
 *
 */
public class FSvgInfo implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String htmlurl;
    private String svgurl;
    private String mapid;
    private String ispark;
    private String mapname;
    private String isdel;

    public String getSvgurl()
    {
        return this.svgurl;
    }

    public void setSvgurl(String svgurl)
    {
        this.svgurl = svgurl;
    }

    public String getMapid()
    {
        return this.mapid;
    }

    public void setMapid(String mapid)
    {
        this.mapid = mapid;
    }

    public String getIspark()
    {
        return this.ispark;
    }

    public void setIspark(String ispark)
    {
        this.ispark = ispark;
    }

    public String getMapname()
    {
        return this.mapname;
    }

    public void setMapname(String mapname)
    {
        this.mapname = mapname;
    }

    public String getHtmlurl()
    {
        return this.htmlurl;
    }

    public void setHtmlurl(String htmlurl)
    {
        this.htmlurl = htmlurl;
    }

    public String getIsdel()
    {
        return this.isdel;
    }

    public void setIsdel(String isdel)
    {
        this.isdel = isdel;
    }
}
