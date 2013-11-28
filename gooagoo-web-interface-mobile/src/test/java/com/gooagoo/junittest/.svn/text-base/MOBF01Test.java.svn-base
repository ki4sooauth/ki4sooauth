package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobf01.transform.MemberLoginRoot;
import com.gooagoo.mobile.entity.mobf03.transform.MemberRegisterRoot;

public class MOBF01Test extends TestCase
{

    String interfaceCode = "mobf01";//接口编码

    /**
     *  用户登录账户不能为空
     */
    public void testAccountIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("iphonetoken", "0182CTKHOP432V700EEAJUSXUXJ1T7P0"));
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("entityposition", ""));
        list.add(new BasicNameValuePair("account", ""));
        list.add(new BasicNameValuePair("password", "4297F44B13955235245B2497399D7A93"));
        MemberLoginRoot root = new MemberLoginRoot();
        root = (MemberLoginRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_ACCOUNT_IS_NULL, root.getMsg().trim());
    }

    /**
     * 密码不能为空
     */
    public void testPasswordIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("mver", ""));
        list.add(new BasicNameValuePair("iphonetoken", ""));
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("entityposition", ""));
        list.add(new BasicNameValuePair("account", "xiaolewangyi@163.com"));
        list.add(new BasicNameValuePair("password", ""));
        MemberLoginRoot root = new MemberLoginRoot();
        root = (MemberLoginRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PASSWORD_IS_NULL, root.getMsg().trim());
    }

    /**用户状态：L-锁定，U-正常
     *用户帐号尚未激活
     *Y-已激活，N-未激活
     */
    public void testAccountError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("iphonetoken", "0182CTKHOP432V700EEAJUSXUXJ1T7P0"));
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("entityposition", ""));
        list.add(new BasicNameValuePair("account", "123123@qq.com"));
        list.add(new BasicNameValuePair("password", "4297F44B13955235245B2497399D7A93"));
        MemberLoginRoot root = new MemberLoginRoot();
        root = (MemberLoginRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_ACCOUNT_NOT_ACTIVE, root.getMsg().trim());
    }

    /**
     *用户帐号状态已锁定
     */
    public void test1AccountError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("iphonetoken", "0182CTKHOP432V700EEAJUSXUXJ1T7P0"));
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("entityposition", ""));
        list.add(new BasicNameValuePair("account", "xiaolewangyi@163.com"));
        list.add(new BasicNameValuePair("password", "4297F44B13955235245B2497399D7A93"));
        MemberLoginRoot root = new MemberLoginRoot();
        root = (MemberLoginRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_ACCOUNT_IS_LOCKED, root.getMsg().trim());
    }

    /**
     *用户账号不存在
     */
    public void test2AccountError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("iphonetoken", "0182CTKHOP432V700EEAJUSXUXJ1T7P0"));
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("entityposition", ""));
        list.add(new BasicNameValuePair("account", "2312321321"));
        list.add(new BasicNameValuePair("password", "4297F44B13955235245B2497399D7A93"));
        MemberLoginRoot root = new MemberLoginRoot();
        root = (MemberLoginRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_ACCOUNT_NOT_EXIST, root.getMsg().trim());
    }

    /**
     *用户账号密码不正确
     */
    public void testPasswordError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("iphonetoken", "0182CTKHOP432V700EEAJUSXUXJ1T7P0"));
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("entityposition", ""));
        list.add(new BasicNameValuePair("account", "xiaolewangyi@163.com"));
        list.add(new BasicNameValuePair("password", "weqewq2123"));
        MemberRegisterRoot root = new MemberRegisterRoot();
        root = (MemberRegisterRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_ACCOUNT_PASSWORD_ERROR, root.getMsg().trim());
    }

    /**
     *登录失败
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("iphonetoken", "0182CTKHOP432V700EEAJUSXUXJ1T7P0"));
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("entityposition", ""));
        list.add(new BasicNameValuePair("account", "xiaolewangyi@163.com"));
        list.add(new BasicNameValuePair("password", "4297F44B13955235245B2497399D7A93"));
        MemberRegisterRoot root = new MemberRegisterRoot();
        root = (MemberRegisterRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_LOGIN_FAIL, root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("iphonetoken", "0182CTKHOP432V700EEAJUSXUXJ1T7P0"));
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("entityposition", ""));
        list.add(new BasicNameValuePair("account", "xiaolewangyi@163.com"));
        list.add(new BasicNameValuePair("password", "4297F44B13955235245B2497399D7A93"));
        MemberLoginRoot root = new MemberLoginRoot();
        root = (MemberLoginRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_LOGIN_SUCCESS, root.getMsg().trim());
    }
}
