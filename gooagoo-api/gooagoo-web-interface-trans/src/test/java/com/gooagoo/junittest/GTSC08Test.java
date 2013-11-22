package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.trans.entity.gtsc08.transform.CouponCheckRoot;

public class GTSC08Test extends TestCase
{

    String interfaceCode = "gtsc08";//接口编码

    /**
     * 转发器MAC地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("agreeyinfo", ""));
        CouponCheckRoot root = new CouponCheckRoot();
        root = (CouponCheckRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 转发器MAC地址不能为空
     */
    public void testOrderidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("agreeyinfo", ""));
        CouponCheckRoot root = new CouponCheckRoot();
        root = (CouponCheckRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 优惠凭证是否可用确认失败
     */
    public void testConfirmFail()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("agreeyinfo", ""));
        CouponCheckRoot root = new CouponCheckRoot();
        root = (CouponCheckRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("优惠凭证是否可用确认失败", root.getMsg().trim());
    }

    /**
     * 优惠凭证是否可用确认完毕
     */
    public void testConfirmSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("agreeyinfo", ""));
        CouponCheckRoot root = new CouponCheckRoot();
        root = (CouponCheckRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("优惠凭证是否可用确认完毕", root.getMsg().trim());
    }

    /**
     * 是否同意信息不能为空
     */
    public void testAgreeyInfoIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("agreeyinfo", ""));
        CouponCheckRoot root = new CouponCheckRoot();
        root = (CouponCheckRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("优惠凭证是否可用确认完毕", root.getMsg().trim());
    }

}
