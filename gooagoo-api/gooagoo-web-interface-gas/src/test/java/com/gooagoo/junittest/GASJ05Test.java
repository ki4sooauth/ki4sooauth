package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gasj05.transform.QueueCancelRoot;

/**
 * 店员查询本实体店各类型餐桌状态
 * @author Administrator
 *
 */
public class GASJ05Test extends TestCase
{
    String interfaceCode = "gasj05";//接口编码

    /**
     * 店员助理mac地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        list.add(new BasicNameValuePair("queueno", "1213"));
        QueueCancelRoot root = new QueueCancelRoot();
        root = (QueueCancelRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 店员登录账号不能为空
     */
    public void testShopUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        list.add(new BasicNameValuePair("queueno", "1213"));
        QueueCancelRoot root = new QueueCancelRoot();
        root = (QueueCancelRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPUSERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 实体店编号不能为空
     */
    public void testShopentityidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        list.add(new BasicNameValuePair("queueno", "1213"));
        QueueCancelRoot root = new QueueCancelRoot();
        root = (QueueCancelRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPENTITYID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 排队号码不能为空
     */
    public void testQueuenoIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        list.add(new BasicNameValuePair("queueno", "1213"));
        QueueCancelRoot root = new QueueCancelRoot();
        root = (QueueCancelRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("排队号码不能为空", root.getMsg().trim());
    }

    /**
     *销号失败
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        list.add(new BasicNameValuePair("queueno", "1213"));
        QueueCancelRoot root = new QueueCancelRoot();
        root = (QueueCancelRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("销号失败", root.getMsg().trim());
    }

    /**
     *销号失败
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("shopentityid", "1213"));
        list.add(new BasicNameValuePair("queueno", "1213"));
        QueueCancelRoot root = new QueueCancelRoot();
        root = (QueueCancelRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("销号成功", root.getMsg().trim());
    }
}
