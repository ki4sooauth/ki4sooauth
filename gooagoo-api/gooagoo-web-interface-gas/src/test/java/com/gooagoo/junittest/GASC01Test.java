package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gasc01.transform.QueryGoodsInfoRoot;

public class GASC01Test
{
    String interfaceCode = "gasc01";//接口编码

    /**
     * 店员助理mac地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("itemserial", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root = (QueryGoodsInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 店员登录账号不能为空
     */
    public void testShopUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("itemserial", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root = (QueryGoodsInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPUSERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 实体店编号不能为空
     */
    public void testShopentityidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("itemserial", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root = (QueryGoodsInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 自定义序列号不能为空
     */
    public void testItemserialNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("itemserial", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root = (QueryGoodsInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("自定义序列号不能为空", root.getMsg().trim());
    }

    /**
     * 未查询到符合条件的数据
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("itemserial", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root = (QueryGoodsInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 店员根据自定义序列号查询商品信息成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("itemserial", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root = (QueryGoodsInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("店员根据自定义序列号查询商品信息成功", root.getMsg().trim());
    }
}
