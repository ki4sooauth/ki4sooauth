package com.gooagoo.view.gms.member;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员基本信息
 * @author Administrator
 *
 */
public class FMemberBaseInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String shopId;//商家ID

    private String phyNo;//物理卡号

    private String phyName;//物理卡名称

    private String name;//姓名
    
    private String account; //账号

	private String userId;//用户id
    
    private String scardNo; //电子卡号

    private String sex;//性别，参考通用字典表的sex

    private Date birthday;//出生日期

    private String idType;//证件类型，参考通用字典表的idtype

    private String idNo;//证件号码

    private String mobile;//手机号码

    private String telephone;//联系电话

    private String email;//电子邮箱

    private String postcode;//邮政编码

    private String address;//通讯地址

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    private String gradeId;//卡ID
    
    private String integralId;//积分编号，UUID

    private Integer historyTotalIntegral;//历史总积分，用于会员卡的升级

    private Integer useableIntegralNumber;//可用积分，用于兑换商品或优惠凭证
    
    

    private Date birthday_F;//出生日期，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date birthday_T;//出生日期，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date birthday_FE;//出生日期，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date birthday_TE;//出生日期，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    private Date createTime_F;//创建时间，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date createTime_T;//创建时间，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date createTime_FE;//创建时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date createTime_TE;//创建时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    private Date cTimeStamp_F;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date cTimeStamp_T;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date cTimeStamp_FE;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date cTimeStamp_TE;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录
    
    
    
    
    
    
    public String getIntegralId() {
		return integralId;
	}

	public void setIntegralId(String integralId) {
		this.integralId = integralId;
	}

	public Integer getHistoryTotalIntegral() {
		return historyTotalIntegral;
	}

	public void setHistoryTotalIntegral(Integer historyTotalIntegral) {
		this.historyTotalIntegral = historyTotalIntegral;
	}

	public Integer getUseableIntegralNumber() {
		return useableIntegralNumber;
	}

	public void setUseableIntegralNumber(Integer useableIntegralNumber) {
		this.useableIntegralNumber = useableIntegralNumber;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
    
    public String getScardNo() {
		return scardNo;
	}

	public void setScardNo(String scardNo) {
		this.scardNo = scardNo;
	}

	public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getPhyNo()
    {
        return this.phyNo;
    }

    public void setPhyNo(String phyNo)
    {
        this.phyNo = phyNo;
    }

    public String getPhyName()
    {
        return this.phyName;
    }

    public void setPhyName(String phyName)
    {
        this.phyName = phyName;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSex()
    {
        return this.sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public Date getBirthday()
    {
        return this.birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public String getIdType()
    {
        return this.idType;
    }

    public void setIdType(String idType)
    {
        this.idType = idType;
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

    public String getTelephone()
    {
        return this.telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPostcode()
    {
        return this.postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
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

    public Date getcTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    public Date getBirthday_F()
    {
        return this.birthday_F;
    }

    public void setBirthday_F(Date birthday_F)
    {
        this.birthday_F = birthday_F;
    }

    public Date getBirthday_T()
    {
        return this.birthday_T;
    }

    public void setBirthday_T(Date birthday_T)
    {
        this.birthday_T = birthday_T;
    }

    public Date getBirthday_FE()
    {
        return this.birthday_FE;
    }

    public void setBirthday_FE(Date birthday_FE)
    {
        this.birthday_FE = birthday_FE;
    }

    public Date getBirthday_TE()
    {
        return this.birthday_TE;
    }

    public void setBirthday_TE(Date birthday_TE)
    {
        this.birthday_TE = birthday_TE;
    }

    public Date getCreateTime_F()
    {
        return this.createTime_F;
    }

    public void setCreateTime_F(Date createTime_F)
    {
        this.createTime_F = createTime_F;
    }

    public Date getCreateTime_T()
    {
        return this.createTime_T;
    }

    public void setCreateTime_T(Date createTime_T)
    {
        this.createTime_T = createTime_T;
    }

    public Date getCreateTime_FE()
    {
        return this.createTime_FE;
    }

    public void setCreateTime_FE(Date createTime_FE)
    {
        this.createTime_FE = createTime_FE;
    }

    public Date getCreateTime_TE()
    {
        return this.createTime_TE;
    }

    public void setCreateTime_TE(Date createTime_TE)
    {
        this.createTime_TE = createTime_TE;
    }

    public Date getcTimeStamp_F()
    {
        return this.cTimeStamp_F;
    }

    public void setcTimeStamp_F(Date cTimeStamp_F)
    {
        this.cTimeStamp_F = cTimeStamp_F;
    }

    public Date getcTimeStamp_T()
    {
        return this.cTimeStamp_T;
    }

    public void setcTimeStamp_T(Date cTimeStamp_T)
    {
        this.cTimeStamp_T = cTimeStamp_T;
    }

    public Date getcTimeStamp_FE()
    {
        return this.cTimeStamp_FE;
    }

    public void setcTimeStamp_FE(Date cTimeStamp_FE)
    {
        this.cTimeStamp_FE = cTimeStamp_FE;
    }

    public Date getcTimeStamp_TE()
    {
        return this.cTimeStamp_TE;
    }

    public void setcTimeStamp_TE(Date cTimeStamp_TE)
    {
        this.cTimeStamp_TE = cTimeStamp_TE;
    }

    public String getGradeId()
    {
        return this.gradeId;
    }

    public void setGradeId(String gradeId)
    {
        this.gradeId = gradeId;
    }

}
