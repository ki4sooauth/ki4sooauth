package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.trans.entity.gtsc12.transform.UploadOrderRoot;

public class GTSC12Test extends TestCase
{

    String interfaceCode = "gtsc12";//接口编码

    /**
     * 转发器MAC地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("data", ""));
        UploadOrderRoot root = new UploadOrderRoot();
        root = (UploadOrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
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
        list.add(new BasicNameValuePair("data", ""));
        UploadOrderRoot root = new UploadOrderRoot();
        root = (UploadOrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
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
        list.add(new BasicNameValuePair("data", ""));
        UploadOrderRoot root = new UploadOrderRoot();
        root = (UploadOrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 订单信息不能为空
     */
    public void testDataIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("data", ""));
        UploadOrderRoot root = new UploadOrderRoot();
        root = (UploadOrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_ORDER_IS_NULL, root.getMsg().trim());
    }

    /**
     * 商家订单数据上传失败
     */
    public void testUploadFail()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("data", ""));
        UploadOrderRoot root = new UploadOrderRoot();
        root = (UploadOrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_BILL_UPLOAD_SHOP_ORDER_DATA_FAIL, root.getMsg().trim());
    }

    /**
     * 商家订单数据上传成功
     */
    public void testUploadSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("data", ""));
        UploadOrderRoot root = new UploadOrderRoot();
        root = (UploadOrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("商家订单数据上传成功", root.getMsg().trim());
    }

}
