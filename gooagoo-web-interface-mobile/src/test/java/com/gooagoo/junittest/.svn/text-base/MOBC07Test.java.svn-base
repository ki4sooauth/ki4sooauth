package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobc07.transform.RecommendCryoutListRoot;

public class MOBC07Test extends TestCase
{

    String interfaceCode = "mobc07";//接口编码

    /**
     * 每页的条数不能为空
     */
    public void testPagesizeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("mver", ""));
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("entityposition", ""));
        list.add(new BasicNameValuePair("cryoutInfoId", ""));
        list.add(new BasicNameValuePair("pagetype", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        RecommendCryoutListRoot root = new RecommendCryoutListRoot();
        root = (RecommendCryoutListRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("用户id不能为空", root.getMsg().trim());
    }

    /**
     * 未查询到如何条件的数据
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("mver", ""));
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("entityposition", ""));
        list.add(new BasicNameValuePair("cryoutInfoId", ""));
        list.add(new BasicNameValuePair("pagetype", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        RecommendCryoutListRoot root = new RecommendCryoutListRoot();
        root = (RecommendCryoutListRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("mver", ""));
        list.add(new BasicNameValuePair("lid", ""));
        list.add(new BasicNameValuePair("entityposition", ""));
        list.add(new BasicNameValuePair("cryoutInfoId", ""));
        list.add(new BasicNameValuePair("pagetype", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        RecommendCryoutListRoot root = new RecommendCryoutListRoot();
        root = (RecommendCryoutListRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询商家吆喝信息成功", root.getMsg().trim());
    }
}
