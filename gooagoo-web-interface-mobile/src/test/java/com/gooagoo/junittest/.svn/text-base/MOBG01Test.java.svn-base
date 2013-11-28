package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobg01.transform.BaseInfoRoot;

public class MOBG01Test extends TestCase
{

    String interfaceCode = "mobg01";//接口编码

    public void testLidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("shopinfo", ""));
        BaseInfoRoot root = new BaseInfoRoot();
        root = (BaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_GET_SHOPINFO_LID_IS_NULL, root.getMsg().trim());
    }

    public void testTypeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("shopinfo", ""));
        BaseInfoRoot root = new BaseInfoRoot();
        root = (BaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_TYPE_IS_NULL, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("shopinfo", ""));
        BaseInfoRoot root = new BaseInfoRoot();
        root = (BaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询基本信息失败", root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("shopinfo", ""));
        BaseInfoRoot root = new BaseInfoRoot();
        root = (BaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询基本信息成功", root.getMsg().trim());
    }
}
