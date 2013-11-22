package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 区域地图参数
 */

public class AreaPara implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String mapId;//地图编号

    private String mapName;//地图名称

    private String shopId;//商家编号

    private String positionId;//位置编号，描述该地图对应哪个区域

    private String shopEntityId;//实体店编号

    private String urlHtml;//地图URL（html）（压缩文件）（给用户展示）

    private String urlSvg;//地图URL（svg）（用于修改）

    private String gridInfo;//网格信息URL（压缩文件）（用于定位)

    private String isPark;//是否可停车，Y-可停车，N-不能停车

    private Integer mapRealWidth;//地图真实宽度，单位：毫米

    private Integer mapRealHeight;//地图真实高度，单位：毫米

    private Double ratioLocation;//定位坐标系比例，每单位表示的真实距离，单位：毫米

    private Double ratioGrid;//网格坐标系比例，每单位表示的真实距离，单位：毫米

    private Double ratioSvg;//SVG坐标系比例，每单位表示的真实距离，单位：毫米

    private String note;//备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getMapId()
    {
        return this.mapId;
    }

    public void setMapId(String mapId)
    {
        this.mapId = mapId;
    }

    public String getMapName()
    {
        return this.mapName;
    }

    public void setMapName(String mapName)
    {
        this.mapName = mapName;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getPositionId()
    {
        return this.positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getUrlHtml()
    {
        return this.urlHtml;
    }

    public void setUrlHtml(String urlHtml)
    {
        this.urlHtml = urlHtml;
    }

    public String getUrlSvg()
    {
        return this.urlSvg;
    }

    public void setUrlSvg(String urlSvg)
    {
        this.urlSvg = urlSvg;
    }

    public String getGridInfo()
    {
        return this.gridInfo;
    }

    public void setGridInfo(String gridInfo)
    {
        this.gridInfo = gridInfo;
    }

    public String getIsPark()
    {
        return this.isPark;
    }

    public void setIsPark(String isPark)
    {
        this.isPark = isPark;
    }

    public Integer getMapRealWidth()
    {
        return this.mapRealWidth;
    }

    public void setMapRealWidth(Integer mapRealWidth)
    {
        this.mapRealWidth = mapRealWidth;
    }

    public Integer getMapRealHeight()
    {
        return this.mapRealHeight;
    }

    public void setMapRealHeight(Integer mapRealHeight)
    {
        this.mapRealHeight = mapRealHeight;
    }

    public Double getRatioLocation()
    {
        return this.ratioLocation;
    }

    public void setRatioLocation(Double ratioLocation)
    {
        this.ratioLocation = ratioLocation;
    }

    public Double getRatioGrid()
    {
        return this.ratioGrid;
    }

    public void setRatioGrid(Double ratioGrid)
    {
        this.ratioGrid = ratioGrid;
    }

    public Double getRatioSvg()
    {
        return this.ratioSvg;
    }

    public void setRatioSvg(Double ratioSvg)
    {
        this.ratioSvg = ratioSvg;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.mapId + "^" + this.mapName + "^" + this.shopId + "^" + this.positionId + "^" + this.shopEntityId + "^" + this.urlHtml + "^" + this.urlSvg + "^" + this.gridInfo + "^" + this.isPark + "^" + this.mapRealWidth + "^" + this.mapRealHeight + "^" + this.ratioLocation + "^" + this.ratioGrid + "^" + this.ratioSvg + "^" + this.note + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
