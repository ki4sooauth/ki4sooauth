package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gasl07.transform.BillMinusRoot;

public class GASL07Test extends TestCase
{

    String interfaceCode = "gasl07";//接口编码

    /**
     *店员助理MAC地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        BillMinusRoot root = new BillMinusRoot();
        root = (BillMinusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
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
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        BillMinusRoot root = new BillMinusRoot();
        root = (BillMinusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPUSERID_IS_NULL, root.getMsg().trim());
    }

    /**
     *商家编号不能为空
     */
    public void testShopidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        BillMinusRoot root = new BillMinusRoot();
        root = (BillMinusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 桌号不能为空
     */
    public void testTablenameIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        BillMinusRoot root = new BillMinusRoot();
        root = (BillMinusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_TABLENAME_IS_NULL, root.getMsg().trim());
    }

    /**
     *点餐信息json数组字符串不能为空
     */
    public void testGoodsinfoIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        BillMinusRoot root = new BillMinusRoot();
        root = (BillMinusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_DESKJSON_IS_NULL, root.getMsg().trim());
    }

    /**
     *实体店编号不能为空
     */
    public void testShopentityidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        BillMinusRoot root = new BillMinusRoot();
        root = (BillMinusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     *提交减菜申请失败
     */
    public void testSubmitSubDishFail()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        BillMinusRoot root = new BillMinusRoot();
        root = (BillMinusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("提交减菜申请失败", root.getMsg().trim());
    }

    /**
     *提交减菜申请失败
     */
    public void testSubmitSubDishSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("tablename", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        BillMinusRoot root = new BillMinusRoot();
        root = (BillMinusRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("提交减菜申请成功", root.getMsg().trim());
    }

}
