package com.gooagoo.entity.generator.sys;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台管理系统用户信息表
 */

public class SysUserInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userId;//用户电子邮箱，由数字、字母、下划线、@组成

    private String password;//密码，MD5加密

    private String status;//状态0-停用 1-启用

    private String name;//姓名

    private String sex;//性别，参考通用字典表的sex

    private Date birthday;//出生日期

    private String idType;//证件类型

    private String idNo;//证件号码

    private String department;//所属部门

    private String isAdmin;//是否为管理员 Y-是 N-否

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
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

    public String getDepartment()
    {
        return this.department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getIsAdmin()
    {
        return this.isAdmin;
    }

    public void setIsAdmin(String isAdmin)
    {
        this.isAdmin = isAdmin;
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
        return this.userId + "^" + this.password + "^" + this.status + "^" + this.name + "^" + this.sex + "^" + this.birthday + "^" + this.idType + "^" + this.idNo + "^" + this.department + "^" + this.isAdmin + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
