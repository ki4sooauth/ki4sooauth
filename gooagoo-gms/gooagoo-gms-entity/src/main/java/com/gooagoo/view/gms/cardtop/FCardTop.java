package com.gooagoo.view.gms.cardtop;

import java.io.Serializable;
import java.util.Date;

/**
 * 卡包营销信息
 */
public class FCardTop implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String cardTopInfoId;//卡包营销编号（主键）
    private String cardId;//会员卡编号
    private String shopId;//商家编号
    private String line1Title;//第1行标题
    private String line1Size;//第1行尺寸
    private String line1Font;//第1行字体
    private String line1Color;//第1行颜色
    private String line1Url;//第1行url
    private String line2Title;//第2行标题
    private String line2Size;//第2行标题
    private String line2Font;//第2行标题
    private String line2Color;//第2行标题
    private String line2Url;//第2行标题
    private Date beginDate;//生效日期
    private Date endDate;//失效日期
    private String releaseId;//发布日志编号
    private Date createTime;//创建时间
    private Date lastModifyTime;//最后修改时间

    public String getCardTopInfoId()
    {
        return this.cardTopInfoId;
    }

    public void setCardTopInfoId(String cardTopInfoId)
    {
        this.cardTopInfoId = cardTopInfoId;
    }

    public String getCardId()
    {
        return this.cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getLine1Title()
    {
        return this.line1Title;
    }

    public void setLine1Title(String line1Title)
    {
        this.line1Title = line1Title;
    }

    public String getLine1Size()
    {
        return this.line1Size;
    }

    public void setLine1Size(String line1Size)
    {
        this.line1Size = line1Size;
    }

    public String getLine1Font()
    {
        return this.line1Font;
    }

    public void setLine1Font(String line1Font)
    {
        this.line1Font = line1Font;
    }

    public String getLine1Color()
    {
        return this.line1Color;
    }

    public void setLine1Color(String line1Color)
    {
        this.line1Color = line1Color;
    }

    public String getLine1Url()
    {
        return this.line1Url;
    }

    public void setLine1Url(String line1Url)
    {
        this.line1Url = line1Url;
    }

    public String getLine2Title()
    {
        return this.line2Title;
    }

    public void setLine2Title(String line2Title)
    {
        this.line2Title = line2Title;
    }

    public String getLine2Size()
    {
        return this.line2Size;
    }

    public void setLine2Size(String line2Size)
    {
        this.line2Size = line2Size;
    }

    public String getLine2Font()
    {
        return this.line2Font;
    }

    public void setLine2Font(String line2Font)
    {
        this.line2Font = line2Font;
    }

    public String getLine2Color()
    {
        return this.line2Color;
    }

    public void setLine2Color(String line2Color)
    {
        this.line2Color = line2Color;
    }

    public String getLine2Url()
    {
        return this.line2Url;
    }

    public void setLine2Url(String line2Url)
    {
        this.line2Url = line2Url;
    }

    public Date getBeginDate()
    {
        return this.beginDate;
    }

    public void setBeginDate(Date beginDate)
    {
        this.beginDate = beginDate;
    }

    public Date getEndDate()
    {
        return this.endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public String getReleaseId()
    {
        return this.releaseId;
    }

    public void setReleaseId(String releaseId)
    {
        this.releaseId = releaseId;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getLastModifyTime()
    {
        return this.lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime)
    {
        this.lastModifyTime = lastModifyTime;
    }

}
