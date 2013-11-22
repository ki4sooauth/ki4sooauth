package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gasc05.transform.OrderRoot;

public class GASC05Test
{
    String interfaceCode = "gasc05";//接口编码

    /**
     * 店员助理mac地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        OrderRoot root = new OrderRoot();
        root = (OrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 店员登录账号不能为空
     */
    public void testShopUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        OrderRoot root = new OrderRoot();
        root = (OrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPUSERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 商家编号不能为空
     */
    public void testShopidNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        OrderRoot root = new OrderRoot();
        root = (OrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 用户编号不能为空
     */
    public void testUseridNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        OrderRoot root = new OrderRoot();
        root = (OrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 商品信息不能为空
     */
    public void testGoodsinfoNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        OrderRoot root = new OrderRoot();
        root = (OrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("商品信息不能为空", root.getMsg().trim());
    }

    /**
     * 实体店编号不能为空
     */
    public void testShopentityidNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        OrderRoot root = new OrderRoot();
        root = (OrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 提交用户订单失败
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        OrderRoot root = new OrderRoot();
        root = (OrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("提交订单失败", root.getMsg().trim());
    }

    /**
     * 提交用户订单成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        OrderRoot root = new OrderRoot();
        root = (OrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("提交订单成功", root.getMsg().trim());
    }
}
