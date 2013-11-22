package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gasd01.transform.CategoryRoot;

public class GASD01Test
{
    String interfaceCode = "gasd01";//接口编码

    /**
     * 店员助理mac地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        CategoryRoot root = new CategoryRoot();
        root = (CategoryRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 店员id不能为空
     */
    public void testShopuseridNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        CategoryRoot root = new CategoryRoot();
        root = (CategoryRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPUSERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 实体店编号不能为空
     */
    public void testShopentityidNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        CategoryRoot root = new CategoryRoot();
        root = (CategoryRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 页码不能为空
     */
    public void testPageindexNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        CategoryRoot root = new CategoryRoot();
        root = (CategoryRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_PAGEINDEX_IS_NULL, root.getMsg().trim());
    }

    /**
     * 每页信息显示条数不能为空
     */
    public void testPagesizeNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        CategoryRoot root = new CategoryRoot();
        root = (CategoryRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_PAGESIZE_IS_NULL, root.getMsg().trim());
    }

    /**
     * 未查询到符合条件的数据
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        CategoryRoot root = new CategoryRoot();
        root = (CategoryRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 商家的商品品类查询成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        CategoryRoot root = new CategoryRoot();
        root = (CategoryRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("商家的商品品类查询成功", root.getMsg().trim());
    }
}
