package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobf08.transform.GetGooagooIdRoot;

public class MOBF08Test extends TestCase
{

    String interfaceCode = "mobf08";//接口编码

    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("mid", ""));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("mtype", ""));
        GetGooagooIdRoot root = new GetGooagooIdRoot();
        root = (GetGooagooIdRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mid", ""));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("mtype", ""));
        GetGooagooIdRoot root = new GetGooagooIdRoot();
        root = (GetGooagooIdRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取gooagooid成功", root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mid", ""));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        list.add(new BasicNameValuePair("mtype", ""));
        GetGooagooIdRoot root = new GetGooagooIdRoot();
        root = (GetGooagooIdRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取gooagooid成功", root.getMsg().trim());
    }
}
