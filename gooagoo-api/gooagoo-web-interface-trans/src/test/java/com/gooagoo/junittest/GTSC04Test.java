package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.trans.entity.gtsc04.transform.GetBillRoot;

public class GTSC04Test extends TestCase
{

    String interfaceCode = "gtsc04";//接口编码

    /**
     * 转发器MAC地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        GetBillRoot root = new GetBillRoot();
        root = (GetBillRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 商家编号不能为空
     */
    public void testShopidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        GetBillRoot root = new GetBillRoot();
        root = (GetBillRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 实体店编号不能为空
     */
    public void testShopentityidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        GetBillRoot root = new GetBillRoot();
        root = (GetBillRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 未查询到符合条件的数据
     */
    public void testGetNoData()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        GetBillRoot root = new GetBillRoot();
        root = (GetBillRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 拿账单成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        GetBillRoot root = new GetBillRoot();
        root = (GetBillRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("拿账单成功", root.getMsg().trim());
    }

}
