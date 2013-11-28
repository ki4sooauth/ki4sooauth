package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobe15.transform.OrderidBindRoot;

public class MOBE15Test extends TestCase
{

    String interfaceCode = "mobe15";//接口编码

    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("tableno2d", ""));
        OrderidBindRoot root = new OrderidBindRoot();
        root = (OrderidBindRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    public void testSessionidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("tableno2d", ""));
        OrderidBindRoot root = new OrderidBindRoot();
        root = (OrderidBindRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    public void testOrderidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("tableno2d", ""));
        OrderidBindRoot root = new OrderidBindRoot();
        root = (OrderidBindRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_ORDERID_IS_NULL, root.getMsg().trim());
    }

    public void testTableno2dIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("tableno2d", ""));
        OrderidBindRoot root = new OrderidBindRoot();
        root = (OrderidBindRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_TABLENO2D_IS_NULL, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("tableno2d", ""));
        OrderidBindRoot root = new OrderidBindRoot();
        root = (OrderidBindRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("远程订餐到店后将桌号与订单绑定失败", root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("tableno2d", ""));
        OrderidBindRoot root = new OrderidBindRoot();
        root = (OrderidBindRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("远程订餐到店后将桌号与订单绑定成功", root.getMsg().trim());
    }
}
