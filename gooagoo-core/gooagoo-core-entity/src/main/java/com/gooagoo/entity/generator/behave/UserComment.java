package com.gooagoo.entity.generator.behave;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户评论
 */

public class UserComment implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String commentId;//评论编号，UUID

    private String userId;//评论的用户编号

    private String shopId;//评论的商家编号

    private String goodsId;//评论的商品编号

    private String commentType;//评论类型，参考通用字典表的comment_type

    private Integer commentLevel;//评分

    private String content;//评论的具体内容

    private String source;//信息来源，参考通用字典表的info_source

    private String comeIp;//记录发表评论人的ip地址

    private String isAuditing;//状态（审核与发布），参考通用字典表的publish_status

    private String auditNote;//审核备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getCommentId()
    {
        return this.commentId;
    }

    public void setCommentId(String commentId)
    {
        this.commentId = commentId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getCommentType()
    {
        return this.commentType;
    }

    public void setCommentType(String commentType)
    {
        this.commentType = commentType;
    }

    public Integer getCommentLevel()
    {
        return this.commentLevel;
    }

    public void setCommentLevel(Integer commentLevel)
    {
        this.commentLevel = commentLevel;
    }

    public String getContent()
    {
        return this.content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getSource()
    {
        return this.source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getComeIp()
    {
        return this.comeIp;
    }

    public void setComeIp(String comeIp)
    {
        this.comeIp = comeIp;
    }

    public String getIsAuditing()
    {
        return this.isAuditing;
    }

    public void setIsAuditing(String isAuditing)
    {
        this.isAuditing = isAuditing;
    }

    public String getAuditNote()
    {
        return this.auditNote;
    }

    public void setAuditNote(String auditNote)
    {
        this.auditNote = auditNote;
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
        return this.commentId + "^" + this.userId + "^" + this.shopId + "^" + this.goodsId + "^" + this.commentType + "^" + this.commentLevel + "^" + this.content + "^" + this.source + "^" + this.comeIp + "^" + this.isAuditing + "^" + this.auditNote + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
