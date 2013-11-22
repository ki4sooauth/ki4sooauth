package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gasl02.transform.GetAllBillRoot;

public class GASL02Test extends TestCase
{

    String interfaceCode = "gasl02";//接口编码

    /**
     *店员助理MAC地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        GetAllBillRoot root = new GetAllBillRoot();
        root = (GetAllBillRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     *店员登录账号不能为空
     */
    public void testShopuseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        GetAllBillRoot root = new GetAllBillRoot();
        root = (GetAllBillRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPUSERID_IS_NULL, root.getMsg().trim());
    }

    /**
     *桌号不能为空
     */
    public void testTablenameNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        GetAllBillRoot root = new GetAllBillRoot();
        root = (GetAllBillRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_TABLENAME_IS_NULL, root.getMsg().trim());
    }

    /**
     *实体店编号不能为空
     */
    public void testShopentityidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        GetAllBillRoot root = new GetAllBillRoot();
        root = (GetAllBillRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     *页码不能为空
     */
    public void testPageindexIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        GetAllBillRoot root = new GetAllBillRoot();
        root = (GetAllBillRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_PAGEINDEX_IS_NULL, root.getMsg().trim());
    }

    /**
     *每页信息显示条数不能为空
     */
    public void testPagesizeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        GetAllBillRoot root = new GetAllBillRoot();
        root = (GetAllBillRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
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
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        GetAllBillRoot root = new GetAllBillRoot();
        root = (GetAllBillRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 查询已开台餐桌的用餐状态信息成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        GetAllBillRoot root = new GetAllBillRoot();
        root = (GetAllBillRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询已开台餐桌的用餐状态信息成功", root.getMsg().trim());
    }

}
