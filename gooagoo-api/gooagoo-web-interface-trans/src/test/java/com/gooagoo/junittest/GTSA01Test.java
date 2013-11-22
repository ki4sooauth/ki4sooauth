package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.trans.entity.gtsa01.transform.SystemConfigurationRoot;

public class GTSA01Test extends TestCase
{

    String interfaceCode = "gtsa01";//接口编码

    /**
     * 转发器MAC地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        SystemConfigurationRoot root = new SystemConfigurationRoot();
        root = (SystemConfigurationRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 转发器MAC地址不存在或已删除
     */
    public void testDeviceNotExist()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:fe"));
        SystemConfigurationRoot root = new SystemConfigurationRoot();
        root = (SystemConfigurationRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_SYS_DEVICE_INFO_NOT_EXIST, root.getMsg().trim());
    }

    /**
     * 对应的转发器设备已停用，不能初始化
     */
    public void testDeviceIsStop()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:27:13:f7:c9:44"));
        SystemConfigurationRoot root = new SystemConfigurationRoot();
        root = (SystemConfigurationRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_SYS_DEVICE_IS_STOP, root.getMsg().trim());
    }

    /**
     * 该设备已损坏，不能初始化
     */
    public void testDeviceIsBroken()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        SystemConfigurationRoot root = new SystemConfigurationRoot();
        root = (SystemConfigurationRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_SYS_DEVICE_IS_BROKEN, root.getMsg().trim());
    }

    /**
     * 商家状态异常，设备不能初始化
     */
    public void testShopException()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        SystemConfigurationRoot root = new SystemConfigurationRoot();
        root = (SystemConfigurationRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_SYS_SHOP_EXCEPTION, root.getMsg().trim());
    }

    /**
     * 实体店状态异常，设备不能初始化
     */
    public void testShopEntityIdException()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:27:13:f7:c2:11"));
        SystemConfigurationRoot root = new SystemConfigurationRoot();
        root = (SystemConfigurationRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_SYS_SHOPENTITYID_EXCEPTION, root.getMsg().trim());
    }

    /**
     * 系统初始化配置成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:27:13:f7:bc:6e"));
        SystemConfigurationRoot root = new SystemConfigurationRoot();
        root = (SystemConfigurationRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("系统初始化配置成功", root.getMsg().trim());
    }

}
