package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobe11.transform.GoodsCommentRoot;

public class MOBE11Test extends TestCase
{

    String interfaceCode = "mobe11";//接口编码

    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("goodsid", ""));
        list.add(new BasicNameValuePair("commentlevel", ""));
        list.add(new BasicNameValuePair("content", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        GoodsCommentRoot root = new GoodsCommentRoot();
        root = (GoodsCommentRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    public void testSessionidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("goodsid", ""));
        list.add(new BasicNameValuePair("commentlevel", ""));
        list.add(new BasicNameValuePair("content", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        GoodsCommentRoot root = new GoodsCommentRoot();
        root = (GoodsCommentRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    public void testShopidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("goodsid", ""));
        list.add(new BasicNameValuePair("commentlevel", ""));
        list.add(new BasicNameValuePair("content", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        GoodsCommentRoot root = new GoodsCommentRoot();
        root = (GoodsCommentRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    public void testGoodsidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("goodsid", ""));
        list.add(new BasicNameValuePair("commentlevel", ""));
        list.add(new BasicNameValuePair("content", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        GoodsCommentRoot root = new GoodsCommentRoot();
        root = (GoodsCommentRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_GOODSID_IS_NULL, root.getMsg().trim());
    }

    public void testCommentlevelIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("goodsid", ""));
        list.add(new BasicNameValuePair("commentlevel", ""));
        list.add(new BasicNameValuePair("content", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        GoodsCommentRoot root = new GoodsCommentRoot();
        root = (GoodsCommentRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_COMMENTLEVEL_IS_NULL, root.getMsg().trim());
    }

    public void testContentIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("goodsid", ""));
        list.add(new BasicNameValuePair("commentlevel", ""));
        list.add(new BasicNameValuePair("content", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        GoodsCommentRoot root = new GoodsCommentRoot();
        root = (GoodsCommentRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_CONTENT_IS_NULL, root.getMsg().trim());
    }

    public void testOrderidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("goodsid", ""));
        list.add(new BasicNameValuePair("commentlevel", ""));
        list.add(new BasicNameValuePair("content", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        GoodsCommentRoot root = new GoodsCommentRoot();
        root = (GoodsCommentRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_ORDERID_IS_NULL, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("goodsid", ""));
        list.add(new BasicNameValuePair("commentlevel", ""));
        list.add(new BasicNameValuePair("content", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        GoodsCommentRoot root = new GoodsCommentRoot();
        root = (GoodsCommentRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("添加用户评论信息失败", root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("goodsid", ""));
        list.add(new BasicNameValuePair("commentlevel", ""));
        list.add(new BasicNameValuePair("content", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        GoodsCommentRoot root = new GoodsCommentRoot();
        root = (GoodsCommentRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("添加用户评论信息成功", root.getMsg().trim());
    }
}
