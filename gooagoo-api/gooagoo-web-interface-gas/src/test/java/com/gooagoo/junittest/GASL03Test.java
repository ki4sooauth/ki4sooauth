package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gasj03.transform.DeskStatusDetailRoot;
import com.gooagoo.gas.entity.gasl03.transform.SubmitOrderRoot;

public class GASL03Test extends TestCase
{

    String interfaceCode = "gasl03";//接口编码

    /**
     *店员助理MAC地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("dietlist", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        SubmitOrderRoot root = new SubmitOrderRoot();
        root = (SubmitOrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     *商家编号不能为空
     */
    public void testShopidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("dietlist", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        SubmitOrderRoot root = new SubmitOrderRoot();
        root = (SubmitOrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     *店员登录账号不能为空
     */
    public void testShopuseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("dietlist", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        SubmitOrderRoot root = new SubmitOrderRoot();
        root = (SubmitOrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPUSERID_IS_NULL, root.getMsg().trim());
    }

    /**
     *桌号不能为空
     */
    public void testTablenameIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("dietlist", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        SubmitOrderRoot root = new SubmitOrderRoot();
        root = (SubmitOrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_TABLENAME_IS_NULL, root.getMsg().trim());
    }

    /**
     *点餐信息json数组字符串不能为空
     */
    public void testGoodsinfoIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("dietlist", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        SubmitOrderRoot root = new SubmitOrderRoot();
        root = (SubmitOrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_DESKJSON_IS_NULL, root.getMsg().trim());
    }

    /**
     *实体店编号不能为空
     */
    public void testShopentityidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("dietlist", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        SubmitOrderRoot root = new SubmitOrderRoot();
        root = (SubmitOrderRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 点餐订单提交失败
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("deskkind", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        list.add(new BasicNameValuePair("pageindex", ""));
        list.add(new BasicNameValuePair("pagesize", ""));
        DeskStatusDetailRoot root = new DeskStatusDetailRoot();
        root = (DeskStatusDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("点餐订单提交失败", root.getMsg().trim());
    }

    /**
     * 点餐订单提交成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:11:e1:dc:ca:6e"));
        list.add(new BasicNameValuePair("shopuserid", "ltdy1@163.com"));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("tablename", "101台"));
        list.add(new BasicNameValuePair("shopentityid", "01822K7105HMGOM07GRNH4EIISWR2K8D"));
        list.add(new BasicNameValuePair("goodsinfo", "[{\"goodsid\":\"0182AK9G7EC8UOM0NCQU29EIISWR2HCH\",\"goodsnum\":1}]"));
        DeskStatusDetailRoot root = new DeskStatusDetailRoot();
        root = (DeskStatusDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("点餐订单提交成功", root.getMsg().trim());
    }

}
