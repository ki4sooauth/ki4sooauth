package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobh01.transform.ServiceTriggerMarketingRoot;

public class MOBH06Test extends TestCase
{

    String interfaceCode = "mobh06";//接口编码

    public void testShopidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        ServiceTriggerMarketingRoot root = new ServiceTriggerMarketingRoot();
        root = (ServiceTriggerMarketingRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        ServiceTriggerMarketingRoot root = new ServiceTriggerMarketingRoot();
        root = (ServiceTriggerMarketingRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

}
