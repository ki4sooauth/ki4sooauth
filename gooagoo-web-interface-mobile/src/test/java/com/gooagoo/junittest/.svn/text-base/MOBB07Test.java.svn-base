package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobb07.transform.FavoritePlazaRoot;

public class MOBB07Test extends TestCase
{

    String interfaceCode = "mobb07";//接口编码

    /**
     * 页码不能为空
     */
    public void testPageindexIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", "10"));
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root = (FavoritePlazaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PAGEINDEX_IS_NULL, root.getMsg().trim());
    }

    /**
     * 每页信息显示条数不能为空
     */
    public void testPagesizeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", ""));
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root = (FavoritePlazaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL, root.getMsg().trim());
    }

    /**
     * 不带条件的分页查询
     */
    public void testSuccesssWithAll()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root = (FavoritePlazaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取收藏广场列表成功", root.getMsg().trim());
    }

    /**
     * 按关键字模糊查询精品
     */
    public void testSuccesssFindGoodsByKeyword()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("type", "G22"));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root = (FavoritePlazaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取收藏广场列表成功", root.getMsg().trim());
    }

    /**
     * 按关键字模糊查询优惠券
     */
    public void testSuccesssFindCouponByKeyword()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("type", "C8"));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root = (FavoritePlazaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取收藏广场列表成功", root.getMsg().trim());
    }

    /**
     * 按关键字模糊查询活动
     */
    public void testSuccesssFindActivityByKeyword()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("type", "A"));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root = (FavoritePlazaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取收藏广场列表成功", root.getMsg().trim());
    }

    /**
     * 按分类编码模糊查询精品
     */
    public void testSuccesssFindGoodsByTypeCode()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("type", "G22"));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root = (FavoritePlazaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取收藏广场列表成功", root.getMsg().trim());
    }

    /**
     * 按分类编码模糊查询优惠券
     */
    public void testSuccesssFindCouponByTypeCode()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("type", "C8"));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root = (FavoritePlazaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取收藏广场列表成功", root.getMsg().trim());
    }

    /**
     * 按分类编码模糊查询活动
     */
    public void testSuccesssFindActivityByTypeCode()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("type", "A"));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root = (FavoritePlazaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取收藏广场列表成功", root.getMsg().trim());
    }

    /**
     * 按关键字和分类编码模糊查询精品(目前不支持组合条件查询只会按typecode查询)
     */
    public void testSuccesssFindGoodsByTypeCodeAndKeyWord()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("keyword", "奶酪酥条"));
        list.add(new BasicNameValuePair("type", "G22"));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root = (FavoritePlazaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取收藏广场列表成功", root.getMsg().trim());
    }

    /**
     * 按关键字和分类编码模糊查询优惠券(目前不支持组合条件查询只会按typecode查询)
     */
    public void testSuccesssFindCouponByTypeCodeAndKeyWord()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("keyword", "赠100"));
        list.add(new BasicNameValuePair("type", "C4"));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root = (FavoritePlazaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取收藏广场列表成功", root.getMsg().trim());
    }

    /**
     * 按关键字和分类编码模糊查询活动(目前不支持组合条件查询只会按typecode查询)
     */
    public void testSuccesssFindActivityByTypeCodeAndKeyWord()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("keyword", "满300"));
        list.add(new BasicNameValuePair("type", "A"));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root = (FavoritePlazaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取收藏广场列表成功", root.getMsg().trim());
    }

    /**
     * 未查询到精品信息
     */
    public void testGetNoGoodsData()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("type", "GX"));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root = (FavoritePlazaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 未查询到优惠券信息
     */
    public void testGetNoCouponData()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("type", "CX"));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root = (FavoritePlazaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 未查询到优惠券信息（在没有数据的前提下测试通过）
     */
    public void testGetNoActivityData()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("type", "A"));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        FavoritePlazaRoot root = new FavoritePlazaRoot();
        root = (FavoritePlazaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

}
