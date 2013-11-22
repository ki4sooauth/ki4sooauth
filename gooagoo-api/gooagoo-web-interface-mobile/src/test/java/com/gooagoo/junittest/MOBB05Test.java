package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobb05.transform.UserCommentRoot;

public class MOBB05Test extends TestCase
{

    String interfaceCode = "mobb05";//接口编码

    /**
     * 商品编号为空
     */
    public void testGoodsidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("goodsid", ""));
        list.add(new BasicNameValuePair("pagesize", "1"));
        list.add(new BasicNameValuePair("pagenum", "10"));
        UserCommentRoot root = new UserCommentRoot();
        root = (UserCommentRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_GOODSID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 每页信息显示条数为空
     */
    public void testPagesizeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("goodsid", "01822TP9V9G73ML07GRNHHEIISWR2K8D"));
        list.add(new BasicNameValuePair("pagesize", ""));
        list.add(new BasicNameValuePair("pageindex", "1"));
        UserCommentRoot root = new UserCommentRoot();
        root = (UserCommentRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL, root.getMsg().trim());
    }

    /**
     * 页码为空
     */
    public void testPageindexIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("goodsid", "01822TP9V9G73ML07GRNHHEIISWR2K8D"));
        list.add(new BasicNameValuePair("pagesize", "1"));
        list.add(new BasicNameValuePair("pageindex", ""));
        UserCommentRoot root = new UserCommentRoot();
        root = (UserCommentRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PAGEINDEX_IS_NULL, root.getMsg().trim());
    }

    /**
     * 未查询到数据
     */
    public void testGetNoData()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("goodsid", "01822TP9V9G73errorML07GRNHHEIISWR2K8D"));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        UserCommentRoot root = new UserCommentRoot();
        root = (UserCommentRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 查询成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("goodsid", "01822TP9V9G73ML07GRNHHEIISWR2K8D"));
        list.add(new BasicNameValuePair("pageindex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        UserCommentRoot root = new UserCommentRoot();
        root = (UserCommentRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取商品所有评论成功", root.getMsg().trim());
    }
}
