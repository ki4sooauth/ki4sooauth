package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.trans.entity.gtsc11.transform.SwipeCardRoot;

public class GTSC11Test extends TestCase
{

    String interfaceCode = "gtsc11";//接口编码

    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        SwipeCardRoot root = new SwipeCardRoot();
        root = (SwipeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     *商家编号不能为空
     */
    public void testShopidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        SwipeCardRoot root = new SwipeCardRoot();
        root = (SwipeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 会员卡号不能为空
     */
    public void testScardnoIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        SwipeCardRoot root = new SwipeCardRoot();
        root = (SwipeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_SCARDNO_IS_NULL, root.getMsg().trim());
    }

    /**
     * 该卡不存在
     */
    public void testCardNotExist()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        SwipeCardRoot root = new SwipeCardRoot();
        root = (SwipeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("3", root.getCode().trim());
    }

    /**
     * 该卡已经过期
     */
    public void testCardAlreadyOverdue()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        SwipeCardRoot root = new SwipeCardRoot();
        root = (SwipeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("2", root.getCode().trim());
    }

    /**
     * 请使用本店会员卡
     */
    public void testCardNotBelongShop()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        SwipeCardRoot root = new SwipeCardRoot();
        root = (SwipeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("1", root.getCode().trim());
    }

    /**
     * 平台API接口异常
     */
    public void testException()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        SwipeCardRoot root = new SwipeCardRoot();
        root = (SwipeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("0", root.getCode().trim());
    }

    /**
     * 刷卡成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        SwipeCardRoot root = new SwipeCardRoot();
        root = (SwipeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("刷卡成功", root.getMsg().trim());
    }

}
