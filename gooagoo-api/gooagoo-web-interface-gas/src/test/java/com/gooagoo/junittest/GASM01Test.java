package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gasm01.transform.GetInvoiceTitlesRoot;

public class GASM01Test extends TestCase
{

    String interfaceCode = "gasm01";//接口编码

    /**
     *店员助理MAC地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        GetInvoiceTitlesRoot root = new GetInvoiceTitlesRoot();
        root = (GetInvoiceTitlesRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     *店员登录账号不能为空
     */
    public void testShopuseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        GetInvoiceTitlesRoot root = new GetInvoiceTitlesRoot();
        root = (GetInvoiceTitlesRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPUSERID_IS_NULL, root.getMsg().trim());
    }

    /**
     *用户编号不能为空
     */
    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        GetInvoiceTitlesRoot root = new GetInvoiceTitlesRoot();
        root = (GetInvoiceTitlesRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    /**
     *实体店编号不能为空
     */
    public void testShopentityidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        GetInvoiceTitlesRoot root = new GetInvoiceTitlesRoot();
        root = (GetInvoiceTitlesRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     *未查询到符合条件的数据
     */
    public void testGetNoData()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        GetInvoiceTitlesRoot root = new GetInvoiceTitlesRoot();
        root = (GetInvoiceTitlesRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     *查询会员发票抬头信息成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        GetInvoiceTitlesRoot root = new GetInvoiceTitlesRoot();
        root = (GetInvoiceTitlesRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询会员发票抬头信息成功", root.getMsg().trim());
    }

}
