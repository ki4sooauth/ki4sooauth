package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobb10.transform.FavoriteRecommendRoot;

public class MOBB10Test extends TestCase
{

    String interfaceCode = "mobb10";//接口编码

    private static GetLoginInfo getLoginInfo = new GetLoginInfo();

    /**
     * 页码不能为空
     */
    public void testPageIndexIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", "10"));
        list.add(new BasicNameValuePair("type", "A"));
        FavoriteRecommendRoot root = new FavoriteRecommendRoot();
        root = (FavoriteRecommendRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PAGEINDEX_IS_NULL, root.getMsg().trim());
    }

    /**
     * 每页信息显示条数不能为空
     */
    public void testPageSizeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", ""));
        list.add(new BasicNameValuePair("type", "A"));
        FavoriteRecommendRoot root = new FavoriteRecommendRoot();
        root = (FavoriteRecommendRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL, root.getMsg().trim());
    }

    /**
     * 每页信息显示条数不能为空
     */
    public void testTypeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        list.add(new BasicNameValuePair("type", ""));
        FavoriteRecommendRoot root = new FavoriteRecommendRoot();
        root = (FavoriteRecommendRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_TYPE_IS_NULL, root.getMsg().trim());
    }

    /**
     * 未查询到符合条件的数据
     */
    public void testGetNoData()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        list.add(new BasicNameValuePair("type", "T"));
        FavoriteRecommendRoot root = new FavoriteRecommendRoot();
        root = (FavoriteRecommendRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("未查询到符合条件的数据", root.getMsg().trim());
    }

    /**
     * 查询推荐商品收藏
     */
    public void testFavoriateGoodsSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        list.add(new BasicNameValuePair("type", "G"));
        FavoriteRecommendRoot root = new FavoriteRecommendRoot();
        root = (FavoriteRecommendRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("搜索收藏推荐成功", root.getMsg().trim());
    }

    /**
     * 查询推荐优惠券收藏
     */
    public void testFavoriateCouponSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        list.add(new BasicNameValuePair("type", "C"));
        FavoriteRecommendRoot root = new FavoriteRecommendRoot();
        root = (FavoriteRecommendRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("搜索收藏推荐成功", root.getMsg().trim());
    }

    /**
     * 查询推荐活动收藏
     */
    public void testFavoriateActivitySuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("keyword", ""));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        list.add(new BasicNameValuePair("type", "A"));
        FavoriteRecommendRoot root = new FavoriteRecommendRoot();
        root = (FavoriteRecommendRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("搜索收藏推荐成功", root.getMsg().trim());
    }
}
