package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gash01.transform.IntercomRoot;

public class GASH01Test
{
    String interfaceCode = "gash01";//接口编码

    /**
     * 店员助理mac地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        IntercomRoot root = new IntercomRoot();
        root = (IntercomRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 店员id不能为空
     */
    public void testShopuseridNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "343"));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        IntercomRoot root = new IntercomRoot();
        root = (IntercomRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("店员id不能为空", root.getMsg().trim());
    }

    /**
    * 实体店编号不能为空
    */
    public void testShopentityidNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "33"));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", ""));
        IntercomRoot root = new IntercomRoot();
        root = (IntercomRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     *未查询到符合条件的数据
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "343"));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        IntercomRoot root = new IntercomRoot();
        root = (IntercomRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     *  获取店员列表信息成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "343"));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        IntercomRoot root = new IntercomRoot();
        root = (IntercomRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取店员助理列表成功", root.getMsg().trim());
    }
}
