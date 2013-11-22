package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gasa01.transform.LoginRoot;

public class GASA01Test extends TestCase
{

    String interfaceCode = "gasa01";//接口编码

    /**
     * 店员助理mac地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数

        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", "1213"));
        list.add(new BasicNameValuePair("password", "1213"));
        LoginRoot root = new LoginRoot();
        root = (LoginRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 店员登录账号不能为空
     */
    public void testShopUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数

        list.add(new BasicNameValuePair("mac", "a0:f4:50:37:cf:a4"));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("password", "1213"));
        LoginRoot root = new LoginRoot();
        root = (LoginRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPUSERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 密码不能为空
     */
    public void testPasswordIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数

        list.add(new BasicNameValuePair("mac", "a0:f4:50:37:cf:a4"));
        list.add(new BasicNameValuePair("shopuserid", "ltdy1@163.com"));
        list.add(new BasicNameValuePair("password", ""));
        LoginRoot root = new LoginRoot();
        root = (LoginRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_PASSWORD_IS_NULL, root.getMsg().trim());
    }

    /**
     * 店员登录账号不存在或已被删除
     */
    public void testShopUseridIsNotExistOrDel()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数

        list.add(new BasicNameValuePair("mac", "a0:f4:50:37:cf:a4"));
        list.add(new BasicNameValuePair("shopuserid", "ltdy1@163.com"));
        list.add(new BasicNameValuePair("password", "1213"));
        LoginRoot root = new LoginRoot();
        root = (LoginRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("店员登录账号不存在", root.getMsg().trim());
    }

    /**
     * 店员助理mac地址不存在或已被删除
     */
    public void testMacIsNotExistOrDel()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数

        list.add(new BasicNameValuePair("mac", "121"));
        list.add(new BasicNameValuePair("shopuserid", "ltdy1@163.com"));
        list.add(new BasicNameValuePair("password", "1213"));
        LoginRoot root = new LoginRoot();
        root = (LoginRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("店员助理mac地址不存在或者不正确", root.getMsg().trim());
    }

    /**
     * 店员助理mac地址不存在或已被删除
     */
    public void testShopIdIsNotSame()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数

        list.add(new BasicNameValuePair("mac", "a0:f4:50:37:cf:a4"));
        list.add(new BasicNameValuePair("shopuserid", "ltdy1@163.com"));
        list.add(new BasicNameValuePair("password", "1213"));
        LoginRoot root = new LoginRoot();
        root = (LoginRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_SHOP_NOT_BELONG_THE_SAME_SHOPENTITY, root.getMsg().trim());
    }

    /**
     *     用户密码不正确
     */
    public void testPasswordError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数

        list.add(new BasicNameValuePair("mac", "f6:92:55:ba:4f:28"));
        list.add(new BasicNameValuePair("shopuserid", "ltdy1@163.com"));
        list.add(new BasicNameValuePair("password", "1213"));
        LoginRoot root = new LoginRoot();
        root = (LoginRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("店员登录账号密码不正确", root.getMsg().trim());
    }

    /**
     * 登录成功
     */
    public void testLoginSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数

        list.add(new BasicNameValuePair("mac", "f6:92:55:ba:4f:28"));
        list.add(new BasicNameValuePair("shopuserid", "ltdy1@163.com"));
        list.add(new BasicNameValuePair("password", "111111"));
        LoginRoot root = new LoginRoot();
        root = (LoginRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("登录成功", root.getMsg().trim());
    }
}
