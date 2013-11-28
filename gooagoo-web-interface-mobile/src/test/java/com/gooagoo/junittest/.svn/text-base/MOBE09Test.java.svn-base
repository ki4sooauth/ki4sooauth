package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobe09.transform.GoodsInfoFromOnecodevalueRoot;

public class MOBE09Test extends TestCase
{

    String interfaceCode = "mobe09";//接口编码

    public void testShopentityidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("shopentityid", ""));

        list.add(new BasicNameValuePair("codevalue", ""));
        list.add(new BasicNameValuePair("itemserial", ""));
        GoodsInfoFromOnecodevalueRoot root = new GoodsInfoFromOnecodevalueRoot();
        root = (GoodsInfoFromOnecodevalueRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    public void testItemserialIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("shopentityid", ""));

        list.add(new BasicNameValuePair("codevalue", ""));
        list.add(new BasicNameValuePair("itemserial", ""));
        GoodsInfoFromOnecodevalueRoot root = new GoodsInfoFromOnecodevalueRoot();
        root = (GoodsInfoFromOnecodevalueRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_ITEMSERIAL_IS_NULL, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "343"));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        GoodsInfoFromOnecodevalueRoot root = new GoodsInfoFromOnecodevalueRoot();
        root = (GoodsInfoFromOnecodevalueRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("未查询到符合条件的数据", root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "343"));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        GoodsInfoFromOnecodevalueRoot root = new GoodsInfoFromOnecodevalueRoot();
        root = (GoodsInfoFromOnecodevalueRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("通过扫码获取商品信息成功", root.getMsg().trim());
    }
}
