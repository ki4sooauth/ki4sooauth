package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.moba08.transform.ShopListRoot;

public class MOBA08Test extends TestCase
{

    String interfaceCode = "moba08";//接口编码

    /**
     * 页码不能为空
     */
    public void testPageIndexIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("pageIndex", ""));
        list.add(new BasicNameValuePair("pagesize", "10"));
        list.add(new BasicNameValuePair("ctimestamp", "2013-07-28"));
        ShopListRoot root = new ShopListRoot();
        root = (ShopListRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PAGEINDEX_IS_NULL, root.getMsg().trim());
    }

    /**
     *每页信息显示条数不能为空
     */
    public void testPagesizeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", ""));
        list.add(new BasicNameValuePair("ctimestamp", "2013-07-28"));
        ShopListRoot root = new ShopListRoot();
        root = (ShopListRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL, root.getMsg().trim());
    }

    /**
     * 未查询到如何条件的数据
     */
    public void testGetNoData()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        list.add(new BasicNameValuePair("ctimestamp", "2013-12-28"));
        ShopListRoot root = new ShopListRoot();
        root = (ShopListRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 查询到商家列表信息，按时间戳查询不分页
     */
    public void testSuccessByTimeStamp()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        list.add(new BasicNameValuePair("ctimestamp", "2013-07-28"));
        ShopListRoot root = new ShopListRoot();
        root = (ShopListRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询商家列表信息成功", root.getMsg().trim());
    }

    /**
     * 查询到商家列表信息，不按时间戳查询分页
     */
    public void testSuccessNotByTimeStamp()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", "5"));
        list.add(new BasicNameValuePair("ctimestamp", ""));
        ShopListRoot root = new ShopListRoot();
        root = (ShopListRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询商家列表信息成功", root.getMsg().trim());
    }
}
