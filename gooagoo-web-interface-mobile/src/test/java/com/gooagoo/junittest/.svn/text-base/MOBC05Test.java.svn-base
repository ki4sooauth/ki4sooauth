package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobc05.transform.BoutiqueRecommendRoot;

public class MOBC05Test extends TestCase
{

    String interfaceCode = "mobc05";//接口编码

    /**
     * 页码不能为空
     */
    public void testPageIndexIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("pageIndex", ""));
        list.add(new BasicNameValuePair("pagesize", "5"));
        list.add(new BasicNameValuePair("shopid", "01822IAKR5SKU02085QBP2EIISWR0JGT"));
        list.add(new BasicNameValuePair("type", "G"));
        BoutiqueRecommendRoot root = new BoutiqueRecommendRoot();
        root = (BoutiqueRecommendRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PAGEINDEX_IS_NULL, root.getMsg().trim());
    }

    /**
     * 每页的条数不能为空
     */
    public void testPagesizeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("pageIndex", "10"));
        list.add(new BasicNameValuePair("pagesize", ""));
        list.add(new BasicNameValuePair("shopid", "01822IAKR5SKU02085QBP2EIISWR0JGT"));
        list.add(new BasicNameValuePair("type", "G"));
        BoutiqueRecommendRoot root = new BoutiqueRecommendRoot();
        root = (BoutiqueRecommendRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL, root.getMsg().trim());
    }

    /**
     * 店铺id不能为空
     */
    public void testShopidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("pageIndex", "10"));
        list.add(new BasicNameValuePair("pagesize", "5"));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("type", "G"));
        BoutiqueRecommendRoot root = new BoutiqueRecommendRoot();
        root = (BoutiqueRecommendRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 未查询到如何条件的数据
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", "5"));
        list.add(new BasicNameValuePair("shopid", "85QBP2EIISWR0JGT"));
        list.add(new BasicNameValuePair("type", "G"));
        BoutiqueRecommendRoot root = new BoutiqueRecommendRoot();
        root = (BoutiqueRecommendRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", "5"));
        list.add(new BasicNameValuePair("shopid", "01822IAKR5SKU02085QBP2EIISWR0JGT"));
        list.add(new BasicNameValuePair("type", "G"));
        BoutiqueRecommendRoot root = new BoutiqueRecommendRoot();
        root = (BoutiqueRecommendRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询吆喝广场下精品推荐信息成功", root.getMsg().trim());
    }
}
