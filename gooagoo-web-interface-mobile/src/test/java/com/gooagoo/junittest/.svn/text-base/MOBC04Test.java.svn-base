package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobc04.transform.CryoutPlazaShopRoot;

public class MOBC04Test extends TestCase
{

    String interfaceCode = "mobc04";//接口编码

    /**
     * 店铺id不能为空
     */
    public void testShopidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("shopid", ""));
        CryoutPlazaShopRoot root = new CryoutPlazaShopRoot();
        root = (CryoutPlazaShopRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 未查询到如何条件的数据
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("shopid", "01822IAKRWR0JGT"));
        CryoutPlazaShopRoot root = new CryoutPlazaShopRoot();
        root = (CryoutPlazaShopRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("shopid", "01822IAKR5SKU02085QBP2EIISWR0JGT"));
        CryoutPlazaShopRoot root = new CryoutPlazaShopRoot();
        root = (CryoutPlazaShopRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("吆喝广场商家详情查询成功", root.getMsg().trim());
    }
}
