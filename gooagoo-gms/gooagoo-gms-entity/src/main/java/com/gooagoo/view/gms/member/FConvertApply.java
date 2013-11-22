package com.gooagoo.view.gms.member;

import java.io.Serializable;
import java.util.Date;

/**
 * 物理卡转换申请信息
 * @author Administrator
 *
 */
public class FConvertApply implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String applicationId;//申请编号，UUID

    private String shopId;//商家编号

    private String userId;//用户编号

    private Date applyTime;//申请日期

    private String phyNo;//物理卡号

    private String idNo;//身份证号码

    private String mobile;//手机号码

    private String status;//申请状态，参考通用字典表的application_status

    private String auditNote;//审核备注

    private String source;//信息来源，参考通用字典表的source

    private String isDel;//是否删除，Y-已删除，N-未删除

    private String realName;//用户名称

    private String cardId;//当前会员卡编码

    private String cardName;//当前会员卡名称

    private String convertCardId;//转换申请审批后的会员卡编码

    private String convertCardName;//转换申请审批后的会员卡名称

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getApplicationId()
    {
        return this.applicationId;
    }

    public void setApplicationId(String applicationId)
    {
        this.applicationId = applicationId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public Date getApplyTime()
    {
        return this.applyTime;
    }

    public void setApplyTime(Date applyTime)
    {
        this.applyTime = applyTime;
    }

    public String getPhyNo()
    {
        return this.phyNo;
    }

    public void setPhyNo(String phyNo)
    {
        this.phyNo = phyNo;
    }

    public String getIdNo()
    {
        return this.idNo;
    }

    public void setIdNo(String idNo)
    {
        this.idNo = idNo;
    }

    public String getMobile()
    {
        return this.mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getAuditNote()
    {
        return this.auditNote;
    }

    public void setAuditNote(String auditNote)
    {
        this.auditNote = auditNote;
    }

    public String getSource()
    {
        return this.source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public String getRealName()
    {
        return this.realName;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public String getCardId()
    {
        return this.cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }

    public String getCardName()
    {
        return this.cardName;
    }

    public void setCardName(String cardName)
    {
        this.cardName = cardName;
    }

    public String getConvertCardId()
    {
        return this.convertCardId;
    }

    public void setConvertCardId(String convertCardId)
    {
        this.convertCardId = convertCardId;
    }

    public String getConvertCardName()
    {
        return this.convertCardName;
    }

    public void setConvertCardName(String convertCardName)
    {
        this.convertCardName = convertCardName;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getcTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

}