package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobe02.transform.InvoiceRoot;

public class MOBE02Test extends TestCase
{

    String interfaceCode = "mobe02";//接口编码

    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("invoicedtile", ""));
        list.add(new BasicNameValuePair("invoiceditem", ""));
        list.add(new BasicNameValuePair("invoicetype", ""));
        InvoiceRoot root = new InvoiceRoot();
        root = (InvoiceRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    public void testSessionidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("invoicedtile", ""));
        list.add(new BasicNameValuePair("invoiceditem", ""));
        list.add(new BasicNameValuePair("invoicetype", ""));
        InvoiceRoot root = new InvoiceRoot();
        root = (InvoiceRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    public void testOrderidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("invoicedtile", ""));
        list.add(new BasicNameValuePair("invoiceditem", ""));
        list.add(new BasicNameValuePair("invoicetype", ""));
        InvoiceRoot root = new InvoiceRoot();
        root = (InvoiceRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_ORDERID_IS_NULL, root.getMsg().trim());
    }

    public void testInvoicedtileIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("invoicedtile", ""));
        list.add(new BasicNameValuePair("invoiceditem", ""));
        list.add(new BasicNameValuePair("invoicetype", ""));
        InvoiceRoot root = new InvoiceRoot();
        root = (InvoiceRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_INVOICEDTITLE_IS_NULL, root.getMsg().trim());
    }

    public void testInvoiceditemIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("invoicedtile", ""));
        list.add(new BasicNameValuePair("invoiceditem", ""));
        list.add(new BasicNameValuePair("invoicetype", ""));
        InvoiceRoot root = new InvoiceRoot();
        root = (InvoiceRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_INVOICEDITEM_IS_NULL, root.getMsg().trim());
    }

    public void testInvoicetypeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("invoicedtile", ""));
        list.add(new BasicNameValuePair("invoiceditem", ""));
        list.add(new BasicNameValuePair("invoicetype", ""));
        InvoiceRoot root = new InvoiceRoot();
        root = (InvoiceRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_INVOICE_TYPE_IS_NULL, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("invoicedtile", ""));
        list.add(new BasicNameValuePair("invoiceditem", ""));
        list.add(new BasicNameValuePair("invoicetype", ""));
        InvoiceRoot root = new InvoiceRoot();
        root = (InvoiceRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("用户根据账单信息申请开发票失败", root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("invoicedtile", ""));
        list.add(new BasicNameValuePair("invoiceditem", ""));
        list.add(new BasicNameValuePair("invoicetype", ""));
        InvoiceRoot root = new InvoiceRoot();
        root = (InvoiceRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("用户根据账单信息申请开发票", root.getMsg().trim());
    }
}
