package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.moba05.transform.RecommendShopRoot;

public class MOBA05Test extends TestCase
{

    String interfaceCode = "moba05";//接口编码

    private static GetLoginInfo getLoginInfo = new GetLoginInfo();

    /**
     * 页码不能为空
     */
    public void testPageIndexIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("pageIndex", ""));
        list.add(new BasicNameValuePair("pagesize", "10"));
        RecommendShopRoot root = new RecommendShopRoot();
        root = (RecommendShopRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PAGEINDEX_IS_NULL, root.getMsg().trim());
    }

    /**
     * 每页信息显示条数不能为空
     */
    public void testPagesizeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", ""));
        RecommendShopRoot root = new RecommendShopRoot();
        root = (RecommendShopRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL, root.getMsg().trim());
    }

    /**
     * 查询到推荐商家信息数据（带userId）
     */
    public void testSuccessWithUserId()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        RecommendShopRoot root = new RecommendShopRoot();
        root = (RecommendShopRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询推荐商家信息成功", root.getMsg().trim());
    }

    /**
     * 查询到推荐商家信息数据（不带userId）
     */
    public void testSuccessWithOutUserId()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        RecommendShopRoot root = new RecommendShopRoot();
        root = (RecommendShopRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询推荐商家信息成功", root.getMsg().trim());
    }

    /**
     * 未查询到符合条件的数据
     */
    public void testGetNoData()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "454"));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", "0"));
        RecommendShopRoot root = new RecommendShopRoot();
        root = (RecommendShopRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }
}
