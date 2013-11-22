package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobd03.transform.MarketingactivityRoot;

public class MOBD03Test extends TestCase
{

    String interfaceCode = "mobd03";//接口编码

    public void testTypeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("date", ""));
        MarketingactivityRoot root = new MarketingactivityRoot();
        root = (MarketingactivityRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_TYPE_IS_NULL, root.getMsg().trim());
    }

    public void testDateIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("date", ""));
        MarketingactivityRoot root = new MarketingactivityRoot();
        root = (MarketingactivityRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_DATE_IS_NULL, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("date", ""));
        MarketingactivityRoot root = new MarketingactivityRoot();
        root = (MarketingactivityRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("未查询到符合条件的数据", root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("date", ""));
        MarketingactivityRoot root = new MarketingactivityRoot();
        root = (MarketingactivityRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询用户会员卡所属商家活动信息成功", root.getMsg().trim());
    }
}
