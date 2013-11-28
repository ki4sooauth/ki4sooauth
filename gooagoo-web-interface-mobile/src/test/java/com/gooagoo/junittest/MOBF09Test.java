package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobf09.transform.GetVerifycodeRoot;

public class MOBF09Test extends TestCase
{

    String interfaceCode = "mobf09";//接口编码

    public void testPhoneIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("phone", ""));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        GetVerifycodeRoot root = new GetVerifycodeRoot();
        root = (GetVerifycodeRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PHONE_IS_NULL, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("phone", "15001058355"));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        GetVerifycodeRoot root = new GetVerifycodeRoot();
        root = (GetVerifycodeRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取短信验证码失败", root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("phone", "15001058377"));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        GetVerifycodeRoot root = new GetVerifycodeRoot();
        root = (GetVerifycodeRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取短信验证码成功", root.getMsg().trim());
    }
}
