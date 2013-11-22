package com.gooagoo.entity.casclient.personal;

import java.io.Serializable;

public class PersonalLoginInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String token;//token值

    private PersonalInfo personalInfo;

    private PersonalProfile personalProfile;

    private PersonalMobileInfo personalMobileInfo;

    private String clientInfoJson;//客户端信息JSON串

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public PersonalInfo getPersonalInfo()
    {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo)
    {
        this.personalInfo = personalInfo;
    }

    public PersonalProfile getPersonalProfile()
    {
        return personalProfile;
    }

    public void setPersonalProfile(PersonalProfile personalProfile)
    {
        this.personalProfile = personalProfile;
    }

    public PersonalMobileInfo getPersonalMobileInfo()
    {
        return personalMobileInfo;
    }

    public void setPersonalMobileInfo(PersonalMobileInfo personalMobileInfo)
    {
        this.personalMobileInfo = personalMobileInfo;
    }

    public String getClientInfoJson()
    {
        return clientInfoJson;
    }

    public void setClientInfoJson(String clientInfoJson)
    {
        this.clientInfoJson = clientInfoJson;
    }

}
