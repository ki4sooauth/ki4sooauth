package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gasb01.transform.StoreMainAreaRoot;

public class GASB01Test extends TestCase
{
    String interfaceCode = "gasb01";//接口编码

    /**
     * 店员助理mac地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", "wangyu@gooagoo.com"));
        list.add(new BasicNameValuePair("positionid", ""));
        list.add(new BasicNameValuePair("shopentityid", "00017R07MTBFPI81N0000NBJ43J9P00K"));
        StoreMainAreaRoot root = new StoreMainAreaRoot();
        root = (StoreMainAreaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 店员登录账号不能为空
     */
    public void testShopUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "20:64:32:52:81:8c"));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("positionid", ""));
        list.add(new BasicNameValuePair("shopentityid", "00017R07MTBFPI81N0000NBJ43J9P00K"));
        StoreMainAreaRoot root = new StoreMainAreaRoot();
        root = (StoreMainAreaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPUSERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 实体店编号不能为空
     */
    public void testShopentityidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "20:64:32:52:81:8c"));
        list.add(new BasicNameValuePair("shopuserid", "wangyu@gooagoo.com"));
        list.add(new BasicNameValuePair("positionid", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        StoreMainAreaRoot root = new StoreMainAreaRoot();
        root = (StoreMainAreaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 位置编号不能为空
     */
    public void testPositionidNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "20:64:32:52:81:8c"));
        list.add(new BasicNameValuePair("shopuserid", "wangyu@gooagoo.com"));
        list.add(new BasicNameValuePair("positionid", ""));
        list.add(new BasicNameValuePair("shopentityid", "00017R07MTBFPI81N0000NBJ43J9P00K"));
        StoreMainAreaRoot root = new StoreMainAreaRoot();
        root = (StoreMainAreaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("位置编号不能为空", root.getMsg().trim());
    }

    /**
     * 查询商家区域人数不存在或已被删除
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "20:64:32:52:81:8c"));
        list.add(new BasicNameValuePair("shopuserid", "wangyu@gooagoo.com"));
        list.add(new BasicNameValuePair("positionid", ""));
        list.add(new BasicNameValuePair("shopentityid", "00017R07MTBFPI81N0000NBJ43J9P00K"));
        StoreMainAreaRoot root = new StoreMainAreaRoot();
        root = (StoreMainAreaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询商家区域人数不存在或已被删除", root.getMsg().trim());
    }

    /**
     * 查询商家区域人数成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "20:64:32:52:81:8c"));
        list.add(new BasicNameValuePair("shopuserid", "20:64:32:52:81:8c"));
        list.add(new BasicNameValuePair("positionid", ""));
        list.add(new BasicNameValuePair("shopentityid", "00017R07MTBFPI81N0000NBJ43J9P00K"));
        StoreMainAreaRoot root = new StoreMainAreaRoot();
        root = (StoreMainAreaRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询商家区域人数信息成功", root.getMsg().trim());
    }
}
