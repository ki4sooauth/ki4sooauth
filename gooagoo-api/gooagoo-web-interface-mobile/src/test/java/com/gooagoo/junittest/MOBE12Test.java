package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobe12.transform.DeskStatusRoot;

public class MOBE12Test extends TestCase
{

    String interfaceCode = "mobe12";//接口编码

    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageIndex", ""));
        list.add(new BasicNameValuePair("pageSize", ""));
        DeskStatusRoot root = new DeskStatusRoot();
        root = (DeskStatusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    public void testSessionidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageIndex", ""));
        list.add(new BasicNameValuePair("pageSize", ""));
        DeskStatusRoot root = new DeskStatusRoot();
        root = (DeskStatusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    public void testShopentityidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageIndex", ""));
        list.add(new BasicNameValuePair("pageSize", ""));
        DeskStatusRoot root = new DeskStatusRoot();
        root = (DeskStatusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageIndex", ""));
        list.add(new BasicNameValuePair("pageSize", ""));
        DeskStatusRoot root = new DeskStatusRoot();
        root = (DeskStatusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("未查询到符合条件的数据", root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageIndex", ""));
        list.add(new BasicNameValuePair("pageSize", ""));
        DeskStatusRoot root = new DeskStatusRoot();
        root = (DeskStatusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("餐桌状态查询成功", root.getMsg().trim());
    }
}
