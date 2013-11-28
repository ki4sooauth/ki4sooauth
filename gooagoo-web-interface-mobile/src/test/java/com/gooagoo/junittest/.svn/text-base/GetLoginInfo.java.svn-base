package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.common.utils.UUID;
import com.gooagoo.mobile.entity.mobf01.transform.MemberLoginRoot;

public class GetLoginInfo
{
    private String userId = "";//用户编号

    private String macAddress = "";//手机mac地址

    private String mId = "";//手机硬件id

    private String mVer = "";//手机程序版本

    private String mType = "";//手机系统类型

    private String sessionId = "";//手机登录后的SessionId值

    private String iphoneToken = "";//Iphone的token值

    private String lid = "";//lid

    private String entityposition = "";//实体店编号

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getMacAddress()
    {
        return this.macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public String getmId()
    {
        return this.mId;
    }

    public void setmId(String mId)
    {
        this.mId = mId;
    }

    public String getmVer()
    {
        return this.mVer;
    }

    public void setmVer(String mVer)
    {
        this.mVer = mVer;
    }

    public String getmType()
    {
        return this.mType;
    }

    public void setmType(String mType)
    {
        this.mType = mType;
    }

    public String getSessionId()
    {
        return this.sessionId;
    }

    public void setSessionId(String sessionId)
    {
        this.sessionId = sessionId;
    }

    public String getIphoneToken()
    {
        return this.iphoneToken;
    }

    public void setIphoneToken(String iphoneToken)
    {
        this.iphoneToken = iphoneToken;
    }

    public String getLid()
    {
        return this.lid;
    }

    public void setLid(String lid)
    {
        this.lid = lid;
    }

    public String getEntityposition()
    {
        return this.entityposition;
    }

    public void setEntityposition(String entityposition)
    {
        this.entityposition = entityposition;
    }

    GetLoginInfo()
    {
        String mac = "00:00:00:00:00:ff";
        String iphonetoken = UUID.getUUID();
        String mver = "iphone4s";
        String mid = UUID.getUUID();
        String mtype = "android";
        String lId = "123123";
        String entityPosition = UUID.getUUID();
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", mac));
        list.add(new BasicNameValuePair("mver", mver));
        list.add(new BasicNameValuePair("iphonetoken", iphonetoken));
        list.add(new BasicNameValuePair("account", "18610871242"));
        list.add(new BasicNameValuePair("password", "123123"));
        MemberLoginRoot root = new MemberLoginRoot();
        root = (MemberLoginRoot) HttpClientUtils.HttpPost(list, root, "mobf01");
        System.out.println("GetLoginInfo获取到的信息为：" + root.toJson() + "\n");
        this.userId = root.getLogin().getUserid();
        this.sessionId = root.getLogin().getSessionid();
        this.macAddress = mac;
        this.mId = mid;
        this.mVer = mver;
        this.mType = mtype;
        this.iphoneToken = iphonetoken;
        this.lid = lId;
        this.entityposition = entityPosition;
    }
}
