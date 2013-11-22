package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gase03.transform.UserBillRoot;
import com.gooagoo.gas.entity.gase04.transform.UserBillDetailRoot;

public class GASE04Test
{
    String interfaceCode = "gase04";//接口编码

    /**
     * 店员助理mac地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        UserBillDetailRoot root = new UserBillDetailRoot();
        root = (UserBillDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 订单编号不能为空
     */
    public void testOrderidNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        UserBillDetailRoot root = new UserBillDetailRoot();
        root = (UserBillDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_ORDERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 页码不能为空
     */
    public void testPageindexNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        UserBillDetailRoot root = new UserBillDetailRoot();
        root = (UserBillDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_PAGEINDEX_IS_NULL, root.getMsg().trim());
    }

    /**
     * 每页信息显示条数不能为空
     */
    public void testPagesizeNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        UserBillDetailRoot root = new UserBillDetailRoot();
        root = (UserBillDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_PAGESIZE_IS_NULL, root.getMsg().trim());
    }

    /**
     *未查询到符合条件的数据
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        UserBillRoot root = new UserBillRoot();
        root = (UserBillRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     *  查询会员账单消费记录明细信息成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("orderid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        UserBillRoot root = new UserBillRoot();
        root = (UserBillRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询用户在本商家的消费记录明细成功", root.getMsg().trim());
    }
}
