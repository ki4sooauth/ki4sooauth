package com.gooagoo.view.mis.enterprise;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家信息
 */

public class MShopInfo implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String shopId;//商家编号，唯一，通过UUID产生
    private String email;//电子邮箱，唯一，字母、数字、下划线、@组成
    private String nickName;//昵称，默认为电子邮箱@之前的部分
    private String password;//登录口令，md5加密
    private String shopStatus;//商家状态，参考通用字典表的shop_status    L-锁定，P-待营业，U-正常营业，默认为锁定，审批通过之后为待营业，商家确认之后为正常营业。锁定和待营业期间商家可以使用部分功能，正常营业之后需要删除所有的测试信息
    private String shopStatusch;//营业状态中文名
    private String isChain;//是否连锁，Y-连锁，N-非连锁
    private String serviceStyle;//部署模式，参考通用字典表的service_style
    private String serviceStyleCh;//部署模式，0-gooagoo代理，1-商家独享
    private String shopName;//商家名称
    private Integer shopTypeRoot;//商家类型（根节点）
    private Integer shopTypeLeaf;//商家类型（叶节点）
    private String shopTypeLeafCh;//商家类型（叶节点）
    private String logo;//商家logo，多个以逗号分隔
    private String scope;//营业范围
    private String note;//审核备注
    private String isDel;//是否删除，Y-已删除，N-未删除
    private Date createTime;//创建时间
    private Date cTimeStamp;//最后一次修改时间
    private Date createTime_F;//创建时间，用于按时间查询，如果此字段有值，可查询出>此字段值的记录
    private Date createTime_T;//创建时间，用于按时间查询，如果此字段有值，可查询出<此字段值的记录
    private Date createTime_FE;//创建时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录
    private Date createTime_TE;//创建时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录
    private Date cTimeStamp_F;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出>此字段值的记录
    private Date cTimeStamp_T;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出<此字段值的记录
    private Date cTimeStamp_FE;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录
    private Date cTimeStamp_TE;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getShopStatus()
    {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus)
    {
        this.shopStatus = shopStatus;
    }

    public String getShopStatusch()
    {
        return shopStatusch;
    }

    public void setShopStatusch(String shopStatusch)
    {
        this.shopStatusch = shopStatusch;
    }

    public String getIsChain()
    {
        return isChain;
    }

    public void setIsChain(String isChain)
    {
        this.isChain = isChain;
    }

    public String getServiceStyle()
    {
        return serviceStyle;
    }

    public void setServiceStyle(String serviceStyle)
    {
        this.serviceStyle = serviceStyle;
    }

    public String getServiceStyleCh()
    {
        return serviceStyleCh;
    }

    public void setServiceStyleCh(String serviceStyleCh)
    {
        this.serviceStyleCh = serviceStyleCh;
    }

    public String getShopName()
    {
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public Integer getShopTypeRoot()
    {
        return shopTypeRoot;
    }

    public void setShopTypeRoot(Integer shopTypeRoot)
    {
        this.shopTypeRoot = shopTypeRoot;
    }

    public Integer getShopTypeLeaf()
    {
        return shopTypeLeaf;
    }

    public void setShopTypeLeaf(Integer shopTypeLeaf)
    {
        this.shopTypeLeaf = shopTypeLeaf;
    }

    public String getShopTypeLeafCh()
    {
        return shopTypeLeafCh;
    }

    public void setShopTypeLeafCh(String shopTypeLeafCh)
    {
        this.shopTypeLeafCh = shopTypeLeafCh;
    }

    public String getLogo()
    {
        return logo;
    }

    public void setLogo(String logo)
    {
        this.logo = logo;
    }

    public String getScope()
    {
        return scope;
    }

    public void setScope(String scope)
    {
        this.scope = scope;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getcTimeStamp()
    {
        return cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    public Date getCreateTime_F()
    {
        return createTime_F;
    }

    public void setCreateTime_F(Date createTime_F)
    {
        this.createTime_F = createTime_F;
    }

    public Date getCreateTime_T()
    {
        return createTime_T;
    }

    public void setCreateTime_T(Date createTime_T)
    {
        this.createTime_T = createTime_T;
    }

    public Date getCreateTime_FE()
    {
        return createTime_FE;
    }

    public void setCreateTime_FE(Date createTime_FE)
    {
        this.createTime_FE = createTime_FE;
    }

    public Date getCreateTime_TE()
    {
        return createTime_TE;
    }

    public void setCreateTime_TE(Date createTime_TE)
    {
        this.createTime_TE = createTime_TE;
    }

    public Date getcTimeStamp_F()
    {
        return cTimeStamp_F;
    }

    public void setcTimeStamp_F(Date cTimeStamp_F)
    {
        this.cTimeStamp_F = cTimeStamp_F;
    }

    public Date getcTimeStamp_T()
    {
        return cTimeStamp_T;
    }

    public void setcTimeStamp_T(Date cTimeStamp_T)
    {
        this.cTimeStamp_T = cTimeStamp_T;
    }

    public Date getcTimeStamp_FE()
    {
        return cTimeStamp_FE;
    }

    public void setcTimeStamp_FE(Date cTimeStamp_FE)
    {
        this.cTimeStamp_FE = cTimeStamp_FE;
    }

    public Date getcTimeStamp_TE()
    {
        return cTimeStamp_TE;
    }

    public void setcTimeStamp_TE(Date cTimeStamp_TE)
    {
        this.cTimeStamp_TE = cTimeStamp_TE;
    }

    public String toString()
    {
        return this.shopId + "^" + this.email + "^" + this.nickName + "^" + this.password + "^" + this.shopStatus + "^" + this.isChain + "^" + this.serviceStyle + "^" + this.shopName + "^" + this.shopTypeRoot + "^" + this.shopTypeLeaf + "^" + this.logo + "^" + this.scope + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
