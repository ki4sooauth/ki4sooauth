package com.gooagoo.entity.business.user.account;

public class MongoAccount
{
    private String _id; //商家id_帐户类型_帐户
    private String phyNo;
    private String phone;
    private String ip;
    private String mac;
    private String UserId;
    private String sex;
    private int yearBirth;
    private int monthBirth;
    private String scardno;
    private String hight;//身高
    private int width;//体重

    public String get_id()
    {
        return _id;
    }

    public void set_id(String _id)
    {
        this._id = _id;
    }

    public String getPhyNo()
    {
        return phyNo;
    }

    public void setPhyNo(String phyNo)
    {
        this.phyNo = phyNo;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getMac()
    {
        return mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

    public String getUserId()
    {
        return UserId;
    }

    public void setUserId(String userId)
    {
        UserId = userId;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public int getYearBirth()
    {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth)
    {
        this.yearBirth = yearBirth;
    }

    public int getMonthBirth()
    {
        return monthBirth;
    }

    public void setMonthBirth(int monthBirth)
    {
        this.monthBirth = monthBirth;
    }

    public String getScardno()
    {
        return scardno;
    }

    public void setScardno(String scardno)
    {
        this.scardno = scardno;
    }

    public String getHight()
    {
        return hight;
    }

    public void setHight(String hight)
    {
        this.hight = hight;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

}
