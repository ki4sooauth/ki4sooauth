package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobi04.transform.NavigationBRoot;

public class MOBI04Test extends TestCase
{

    String interfaceCode = "mobi04";//接口编码

    public void testSmapidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("smapid", ""));
        list.add(new BasicNameValuePair("emapid", ""));
        list.add(new BasicNameValuePair("spx", ""));
        list.add(new BasicNameValuePair("spy", ""));
        list.add(new BasicNameValuePair("epx", ""));
        list.add(new BasicNameValuePair("epy", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("objid", ""));
        NavigationBRoot root = new NavigationBRoot();
        root = (NavigationBRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

    public void testEmapidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("smapid", ""));
        list.add(new BasicNameValuePair("emapid", ""));
        list.add(new BasicNameValuePair("spx", ""));
        list.add(new BasicNameValuePair("spy", ""));
        list.add(new BasicNameValuePair("epx", ""));
        list.add(new BasicNameValuePair("epy", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("objid", ""));
        NavigationBRoot root = new NavigationBRoot();
        root = (NavigationBRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

    public void testSpxIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("smapid", ""));
        list.add(new BasicNameValuePair("emapid", ""));
        list.add(new BasicNameValuePair("spx", ""));
        list.add(new BasicNameValuePair("spy", ""));
        list.add(new BasicNameValuePair("epx", ""));
        list.add(new BasicNameValuePair("epy", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("objid", ""));
        NavigationBRoot root = new NavigationBRoot();
        root = (NavigationBRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

    public void testSpyIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("smapid", ""));
        list.add(new BasicNameValuePair("emapid", ""));
        list.add(new BasicNameValuePair("spx", ""));
        list.add(new BasicNameValuePair("spy", ""));
        list.add(new BasicNameValuePair("epx", ""));
        list.add(new BasicNameValuePair("epy", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("objid", ""));
        NavigationBRoot root = new NavigationBRoot();
        root = (NavigationBRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

    public void testEpxIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("smapid", ""));
        list.add(new BasicNameValuePair("emapid", ""));
        list.add(new BasicNameValuePair("spx", ""));
        list.add(new BasicNameValuePair("spy", ""));
        list.add(new BasicNameValuePair("epx", ""));
        list.add(new BasicNameValuePair("epy", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("objid", ""));
        NavigationBRoot root = new NavigationBRoot();
        root = (NavigationBRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

    public void testEpyIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("smapid", ""));
        list.add(new BasicNameValuePair("emapid", ""));
        list.add(new BasicNameValuePair("spx", ""));
        list.add(new BasicNameValuePair("spy", ""));
        list.add(new BasicNameValuePair("epx", ""));
        list.add(new BasicNameValuePair("epy", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("objid", ""));
        NavigationBRoot root = new NavigationBRoot();
        root = (NavigationBRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

    public void testTypeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("smapid", ""));
        list.add(new BasicNameValuePair("emapid", ""));
        list.add(new BasicNameValuePair("spx", ""));
        list.add(new BasicNameValuePair("spy", ""));
        list.add(new BasicNameValuePair("epx", ""));
        list.add(new BasicNameValuePair("epy", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("objid", ""));
        NavigationBRoot root = new NavigationBRoot();
        root = (NavigationBRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

    public void testObjidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("smapid", ""));
        list.add(new BasicNameValuePair("emapid", ""));
        list.add(new BasicNameValuePair("spx", ""));
        list.add(new BasicNameValuePair("spy", ""));
        list.add(new BasicNameValuePair("epx", ""));
        list.add(new BasicNameValuePair("epy", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("objid", ""));
        NavigationBRoot root = new NavigationBRoot();
        root = (NavigationBRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

}
