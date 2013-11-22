package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gasj05.transform.QueueCancelRoot;
import com.gooagoo.gas.entity.gasl04.transform.CheckDishFlagRoot;

public class GASL04Test extends TestCase
{

    String interfaceCode = "gasl04";//接口编码

    /**
     * 店员助理mac地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        CheckDishFlagRoot root = new CheckDishFlagRoot();
        root = (CheckDishFlagRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 店员登录账号不能为空
     */
    public void testShopuseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        CheckDishFlagRoot root = new CheckDishFlagRoot();
        root = (CheckDishFlagRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPUSERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 已上菜品信息不能为空
     */
    public void testGoodsinfoIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        CheckDishFlagRoot root = new CheckDishFlagRoot();
        root = (CheckDishFlagRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("已上菜品信息不能为空", root.getMsg().trim());
    }

    /**
     *订单编号不能为空
     */
    public void testOrderidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        CheckDishFlagRoot root = new CheckDishFlagRoot();
        root = (CheckDishFlagRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_ORDERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 已上菜品订单标记失败
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        QueueCancelRoot root = new QueueCancelRoot();
        root = (QueueCancelRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("已上菜品订单标记失败", root.getMsg().trim());
    }

    /**
     * 已上菜品订单标记成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        QueueCancelRoot root = new QueueCancelRoot();
        root = (QueueCancelRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("已上菜品订单标记成功", root.getMsg().trim());
    }

}
