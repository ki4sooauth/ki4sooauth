package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gasc06.transform.SwipeCardRoot;

public class GASC06Test
{
    String interfaceCode = "gasc06";//接口编码

    /**
     * 店员助理mac地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        SwipeCardRoot root = new SwipeCardRoot();
        root = (SwipeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 会员卡音频编号不能为空
     */
    public void testScardnoIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        SwipeCardRoot root = new SwipeCardRoot();
        root = (SwipeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("会员卡音频编号不能为空", root.getMsg().trim());
    }

    /**
     * 商家编号不能为空
     */
    public void testShopidNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        SwipeCardRoot root = new SwipeCardRoot();
        root = (SwipeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 该会员卡过期
     */
    public void testCardAlreadyOverdue()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "343"));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        SwipeCardRoot root = new SwipeCardRoot();
        root = (SwipeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("该会员卡过期", root.getMsg().trim());
    }

    /**
     * 请使用本店会员卡
     */
    public void testCardNotBelongShop()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "343"));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        SwipeCardRoot root = new SwipeCardRoot();
        root = (SwipeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("请使用本店会员卡", root.getMsg().trim());
    }

    /**
     * 该会员卡不存在
     */
    public void testCardNotExists()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "343"));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        SwipeCardRoot root = new SwipeCardRoot();
        root = (SwipeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("该会员卡不存在", root.getMsg().trim());
    }

    /**
     * 刷卡成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "343"));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        SwipeCardRoot root = new SwipeCardRoot();
        root = (SwipeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("刷卡成功", root.getMsg().trim());
    }
}
