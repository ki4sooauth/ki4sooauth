package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobf10.transform.CheckVerifycodeRoot;

public class MOBF10Test extends TestCase
{

    String interfaceCode = "mobf10";//接口编码

    public void testPhoneIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("phone", ""));
        list.add(new BasicNameValuePair("password", "111111"));
        list.add(new BasicNameValuePair("verifycode", "042917"));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        CheckVerifycodeRoot root = new CheckVerifycodeRoot();
        root = (CheckVerifycodeRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PHONE_IS_NULL, root.getMsg().trim());
    }

    public void testPasswordIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("phone", "13902451907"));
        list.add(new BasicNameValuePair("password", ""));
        list.add(new BasicNameValuePair("verifycode", "042917"));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        CheckVerifycodeRoot root = new CheckVerifycodeRoot();
        root = (CheckVerifycodeRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PASSWORD_IS_NULL, root.getMsg().trim());
    }

    public void testVerifycodeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("phone", "13902451907"));
        list.add(new BasicNameValuePair("password", "111111"));
        list.add(new BasicNameValuePair("verifycode", ""));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        CheckVerifycodeRoot root = new CheckVerifycodeRoot();
        root = (CheckVerifycodeRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_VERIFYCODE_IS_NULL, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("phone", "13902451888"));
        list.add(new BasicNameValuePair("password", "111111"));
        list.add(new BasicNameValuePair("verifycode", "042917"));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        CheckVerifycodeRoot root = new CheckVerifycodeRoot();
        root = (CheckVerifycodeRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("添加用户注册信息成失败", root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("phone", "15001058377"));
        list.add(new BasicNameValuePair("password", "111111"));
        list.add(new BasicNameValuePair("verifycode", "600691"));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        CheckVerifycodeRoot root = new CheckVerifycodeRoot();
        root = (CheckVerifycodeRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("注册成功", root.getMsg().trim());
    }
}
