package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gasj02.transform.QueueRoot;

/**
 * 店员查询本实体店各类型餐桌状态
 * @author Administrator
 *
 */
public class GASJ02Test extends TestCase
{
    String interfaceCode = "gasj02";//接口编码

    /**
     * 店员助理mac地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("queuenums", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        QueueRoot root = new QueueRoot();
        root = (QueueRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 餐桌类型不能为空
     */
    public void testDeskkindIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("queuenums", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        QueueRoot root = new QueueRoot();
        root = (QueueRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("餐桌类型不能为空", root.getMsg().trim());
    }

    /**
     * 店员登录账号不能为空
     */
    public void testShopuseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("queuenums", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        QueueRoot root = new QueueRoot();
        root = (QueueRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPUSERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 此次排队对应的人数不能为空
     */
    public void testQueuenumsIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("queuenums", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        QueueRoot root = new QueueRoot();
        root = (QueueRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("此次排队对应的人数不能为空", root.getMsg().trim());
    }

    /**
     * 实体店编号不能为空
     */
    public void testShopentityidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("queuenums", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        QueueRoot root = new QueueRoot();
        root = (QueueRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 店员帮用户排号失败
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("queuenums", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        QueueRoot root = new QueueRoot();
        root = (QueueRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("排号失败", root.getMsg().trim());
    }

    /**
     * 店员帮用户排号成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("tabletypecode", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("queuenums", ""));
        list.add(new BasicNameValuePair("shopentityid", ""));
        QueueRoot root = new QueueRoot();
        root = (QueueRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("排号成功", root.getMsg().trim());
    }
}
