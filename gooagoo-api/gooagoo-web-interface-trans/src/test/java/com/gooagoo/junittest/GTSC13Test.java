package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.trans.entity.gtsc13.transform.QueryGoodsInfoRoot;

public class GTSC13Test extends TestCase
{

    String interfaceCode = "gtsc13";//接口编码

    /**
     *转发器MAC地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("itemserial", ""));
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root = (QueryGoodsInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     *实体店编号不能为空
     */
    public void testShopentityidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("itemserial", ""));
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root = (QueryGoodsInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     *商家编号不能为空
     */
    public void testShopidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("itemserial", ""));
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root = (QueryGoodsInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     *会员卡号不能为空
     */
    public void testScardnoIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("itemserial", ""));
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root = (QueryGoodsInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_SCARDNO_IS_NULL, root.getMsg().trim());
    }

    /**
     *商品自定义序列号
     */
    public void testItemserialIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("itemserial", ""));
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root = (QueryGoodsInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_ITEMSERIAL_IS_NULL, root.getMsg().trim());
    }

    /**
     *未查询到符合条件的数据
     */
    public void testGetNoData()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("itemserial", ""));
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root = (QueryGoodsInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     *查询商品信息成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("itemserial", ""));
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root = (QueryGoodsInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询商品信息成功", root.getMsg().trim());
    }

}
