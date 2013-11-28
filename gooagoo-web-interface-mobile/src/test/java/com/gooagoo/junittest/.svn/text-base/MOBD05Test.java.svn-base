package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobd05.transform.ShoppingMatchRoot;

public class MOBD05Test extends TestCase
{

    String interfaceCode = "mobd05";//接口编码

    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        ShoppingMatchRoot root = new ShoppingMatchRoot();
        root = (ShoppingMatchRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

    public void testSessionidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        ShoppingMatchRoot root = new ShoppingMatchRoot();
        root = (ShoppingMatchRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

}
