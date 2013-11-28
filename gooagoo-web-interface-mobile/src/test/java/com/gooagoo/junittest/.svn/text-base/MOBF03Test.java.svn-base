package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobf03.transform.MemberRegisterRoot;

public class MOBF03Test extends TestCase
{

    String interfaceCode = "mobf03";//接口编码

    /**
     *  用户邮箱不能为空
     */
    public void testEmailIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("email", ""));
        list.add(new BasicNameValuePair("password", "4297F44B13955235245B2497399D7A93"));
        MemberRegisterRoot root = new MemberRegisterRoot();
        root = (MemberRegisterRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_EMAIL_IS_NULL, root.getMsg().trim());
    }

    /**
     * 密码不能为空
     */
    public void testPasswordIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("email", "xiaolewangyi@163.com"));
        list.add(new BasicNameValuePair("password", ""));
        MemberRegisterRoot root = new MemberRegisterRoot();
        root = (MemberRegisterRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PASSWORD_IS_NULL, root.getMsg().trim());
    }

    /**
     * 密码长度只能在6-20个字符之间
     */
    public void testPasswordError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("email", "xiaowang@163.com"));
        list.add(new BasicNameValuePair("password", "020"));
        MemberRegisterRoot root = new MemberRegisterRoot();
        root = (MemberRegisterRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_REGIST_PASSWORD_LENGTH_BETWEEN_6_AND_20, root.getMsg().trim());
    }

    /**
     * 邮箱格式不正确
     */
    public void testEmailError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("email", "xiaolewangyi163"));
        list.add(new BasicNameValuePair("password", "4297F44B13955235245B2497399D7A93"));
        MemberRegisterRoot root = new MemberRegisterRoot();
        root = (MemberRegisterRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_REGIST_EMAIL_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 该邮箱已被注册
     */
    public void testEmailsError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("email", "xiaolewang@163.com"));
        list.add(new BasicNameValuePair("password", "123123 "));
        MemberRegisterRoot root = new MemberRegisterRoot();
        root = (MemberRegisterRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_USEREMAIL_ALREADY_REGISTER, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("email", "xiaol@163.com"));
        list.add(new BasicNameValuePair("password", "123123"));
        MemberRegisterRoot root = new MemberRegisterRoot();
        root = (MemberRegisterRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_REGIST_FAIL, root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("email", "xiao@163.com"));
        list.add(new BasicNameValuePair("password", "123123"));
        MemberRegisterRoot root = new MemberRegisterRoot();
        root = (MemberRegisterRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_REGIST_SUCCESS, root.getMsg().trim());
    }
}
