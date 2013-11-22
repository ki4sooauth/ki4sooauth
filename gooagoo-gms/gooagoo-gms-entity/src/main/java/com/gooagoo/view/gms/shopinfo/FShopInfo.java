package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class FShopInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String email;//电子邮箱，唯一，字母、数字、下划线、@组成

    private String nickName;//昵称，默认为电子邮箱@之前的部分

    private String password;//登录口令，md5加密

    private String serviceStyle;//部署模式，0-gooagoo代理，1-商家独享

    private String serviceStyleCh;//部署模式，0-gooagoo代理，1-商家独享

    private String shopId;//商家编号，唯一，通过UUID产生

    private String shopStatus;//商家状态：L-锁定，P-待营业，U-正常营业，默认为锁定，审批通过之后为待营业，商家确认之后为正常营业。锁定和待营业期间商家可以使用部分功能，正常营业之后需要删除所有的测试信息

    private Integer shopTypeRoot;//商家类型（根节点）

    private Integer shopTypeLeaf;//商家类型（叶节点）
    private String shopTypeLeafCh;//商家类型（叶节点）

    private String logo;//店铺的logo，多个以逗号分隔

    private String scope;//营业范围

    private String shopName;//商家名称

    private String isChain;//是否连锁
    private String note;//审核备注
    private String shopStatusch;//营业状态中文名

    public String getShopStatusch()
    {
        return this.shopStatusch;
    }

    public void setShopStatusch(String shopStatusch)
    {
        this.shopStatusch = shopStatusch;
    }

    public String getIsChain()
    {
        return this.isChain;
    }

    public void setIsChain(String isChain)
    {
        this.isChain = isChain;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public Integer getShopTypeRoot()
    {
        return this.shopTypeRoot;
    }

    public void setShopTypeRoot(Integer shopTypeRoot)
    {
        this.shopTypeRoot = shopTypeRoot;
    }

    public Integer getShopTypeLeaf()
    {
        return this.shopTypeLeaf;
    }

    public void setShopTypeLeaf(Integer shopTypeLeaf)
    {
        this.shopTypeLeaf = shopTypeLeaf;
    }

    public String getLogo()
    {
        return this.logo;
    }

    public void setLogo(String logo)
    {
        this.logo = logo;
    }

    public String getScope()
    {
        return this.scope;
    }

    public void setScope(String scope)
    {
        this.scope = scope;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getNickName()
    {
        return this.nickName;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getServiceStyle()
    {
        return this.serviceStyle;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public String getServiceStyleCh()
    {
        return this.serviceStyleCh;
    }

    public void setServiceStyleCh(String serviceStyleCh)
    {
        this.serviceStyleCh = serviceStyleCh;
    }

    public String getShopStatus()
    {
        return this.shopStatus;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getShopTypeLeafCh()
    {
        return this.shopTypeLeafCh;
    }

    public void setShopTypeLeafCh(String shopTypeLeafCh)
    {
        this.shopTypeLeafCh = shopTypeLeafCh;
    }

    public void setServiceStyle(String serviceStyle)
    {
        this.serviceStyle = serviceStyle;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public void setShopStatus(String shopStatus)
    {
        this.shopStatus = shopStatus;
    }

    @Override
    public String toString()
    {
        return "FShopInfo [email=" + this.email + ", nickName=" + this.nickName + ", password=" + this.password + ", serviceStyle=" + this.serviceStyle + ", serviceStyleCh=" + this.serviceStyleCh + ", shopId=" + this.shopId + ", shopStatus=" + this.shopStatus + ", shopTypeRoot=" + this.shopTypeRoot + ", shopTypeLeaf=" + this.shopTypeLeaf + ", shopTypeLeafCh=" + this.shopTypeLeafCh + ", logo=" + this.logo + ", scope=" + this.scope + ", shopName=" + this.shopName + ", isChain=" + this.isChain + ", note=" + this.note + "]";
    }

}
