package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobh12.transform.LidTriggerMarketingRoot;

public class MOBH12Test extends TestCase
{

    String interfaceCode = "mobh12";//接口编码

    public void testLidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        LidTriggerMarketingRoot root = new LidTriggerMarketingRoot();
        root = (LidTriggerMarketingRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("userid", ""));
        LidTriggerMarketingRoot root = new LidTriggerMarketingRoot();
        root = (LidTriggerMarketingRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("", root.getMsg().trim());
    }

}
