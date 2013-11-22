package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobf06.transform.UserInfoRoot;

public class MOBF06Test extends TestCase
{

    String interfaceCode = "mobf06";//接口编码

    /**
     * 用户编号不能为空
     */
    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        UserInfoRoot root = new UserInfoRoot();
        root = (UserInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * sessionid值不能为空
     */
    public void testSessionidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        UserInfoRoot root = new UserInfoRoot();
        root = (UserInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 请先登录
     */
    public void testNotLogin()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "0C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        UserInfoRoot root = new UserInfoRoot();
        root = (UserInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_PLEASE_LOGIN, root.getMsg().trim());
    }

    /**
     * 错误
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        UserInfoRoot root = new UserInfoRoot();
        root = (UserInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询用户基本信息失败", root.getMsg().trim());
    }

    /**
     * 成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        UserInfoRoot root = new UserInfoRoot();
        root = (UserInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询用户基本信息成功", root.getMsg().trim());
    }
}
