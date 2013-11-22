package com.gooagoo.entity.business.member;

import java.io.Serializable;

/**
 * 会员信息
 */
public class MemberInfoBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 姓名  */
    private String name = "";
    /** userId  */
    private String userId = "";

    /** 性别，M-男，F-女  */
    private String sex = "";

    /** 出生日期  */
    private String birthday = "";

    /** 证件类型，  */
    private String idtype = "";

    /** 证件号码  */
    private String idno = "";

    /** 手机号码  */
    private String mobile = "";

    /** 联系电话  */
    private String telephone = "";

    /** 电子邮箱  */
    private String email = "";

    /** 邮政编码  */
    private String postcode = "";

    /** 通讯地址  */
    private String address = "";

    private String cardName = "";//会员卡名称

    private String useableIntegralNumber = "0";//可用积分
    private String headPic = "";//用户头像图片URL

    public String getHeadPic()
    {
        return this.headPic;
    }

    public void setHeadPic(String headPic)
    {
        this.headPic = headPic;
    }

    public void setUseableIntegralNumber(String useableIntegralNumber)
    {
        this.useableIntegralNumber = useableIntegralNumber;
    }

    /** 类型编号，例如color，同一商家唯一，由商家录入 */
    private java.util.List<MemberFeatureBusiness> memberspecialinfo = new java.util.ArrayList<MemberFeatureBusiness>();

    /**
     * 设置姓名 
     * @param name	姓名 
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * 获取姓名 
     * @return	姓名 
     */
    public String getName()
    {
        return this.name;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    /**
     * 设置性别，M-男，F-女 
     * @param sex	性别，M-男，F-女 
     */
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    /**
     * 获取性别，M-男，F-女 
     * @return	性别，M-男，F-女 
     */
    public String getSex()
    {
        return this.sex;
    }

    /**
     * 设置出生日期 
     * @param birthday	出生日期 
     */
    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    /**
     * 获取出生日期 
     * @return	出生日期 
     */
    public String getBirthday()
    {
        return this.birthday;
    }

    /**
     * 设置证件类型， 
     * @param idtype	证件类型， 
     */
    public void setIdtype(String idtype)
    {
        this.idtype = idtype;
    }

    /**
     * 获取证件类型， 
     * @return	证件类型， 
     */
    public String getIdtype()
    {
        return this.idtype;
    }

    /**
     * 设置证件号码 
     * @param idno	证件号码 
     */
    public void setIdno(String idno)
    {
        this.idno = idno;
    }

    /**
     * 获取证件号码 
     * @return	证件号码 
     */
    public String getIdno()
    {
        return this.idno;
    }

    /**
     * 设置手机号码 
     * @param mobile	手机号码 
     */
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    /**
     * 获取手机号码 
     * @return	手机号码 
     */
    public String getMobile()
    {
        return this.mobile;
    }

    /**
     * 设置联系电话 
     * @param telephone	联系电话 
     */
    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    /**
     * 获取联系电话 
     * @return	联系电话 
     */
    public String getTelephone()
    {
        return this.telephone;
    }

    /**
     * 设置电子邮箱 
     * @param email	电子邮箱 
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * 获取电子邮箱 
     * @return	电子邮箱 
     */
    public String getEmail()
    {
        return this.email;
    }

    /**
     * 设置邮政编码 
     * @param postcode	邮政编码 
     */
    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    /**
     * 获取邮政编码 
     * @return	邮政编码 
     */
    public String getPostcode()
    {
        return this.postcode;
    }

    /**
     * 设置通讯地址 
     * @param address	通讯地址 
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * 获取通讯地址 
     * @return	通讯地址 
     */
    public String getAddress()
    {
        return this.address;
    }

    public String getCardName()
    {
        return this.cardName;
    }

    public void setCardName(String cardName)
    {
        this.cardName = cardName;
    }

    /**
     * 设置类型编号，例如color，同一商家唯一，由商家录入
     * @param memberspecialinfo	类型编号，例如color，同一商家唯一，由商家录入
     */
    public void setMemberspecialinfo(java.util.List<MemberFeatureBusiness> memberspecialinfo)
    {
        this.memberspecialinfo = memberspecialinfo;
    }

    /**
     * 获取类型编号，例如color，同一商家唯一，由商家录入
     * @return	类型编号，例如color，同一商家唯一，由商家录入
     */
    public java.util.List<MemberFeatureBusiness> getMemberspecialinfo()
    {
        return this.memberspecialinfo;
    }

    /**
     * 添加类型编号，例如color，同一商家唯一，由商家录入
     * @return memberspecialinfo	类型编号，例如color，同一商家唯一，由商家录入
     */
    public MemberFeatureBusiness addMoreMemberspecialinfo()
    {
        MemberFeatureBusiness memberspecialinfo = new MemberFeatureBusiness();
        this.memberspecialinfo.add(memberspecialinfo);
        return memberspecialinfo;
    }

    public String getUseableIntegralNumber()
    {
        return this.useableIntegralNumber;
    }
}