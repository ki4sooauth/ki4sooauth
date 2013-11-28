package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobf04.transform.ChangePasswordRoot;

public class MOBF04Test extends TestCase
{

    String interfaceCode = "mobf04";//接口编码

    /**
     * 用户编号不能为空
     */
    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("newpassword", "123123"));
        list.add(new BasicNameValuePair("password", "111111"));
        ChangePasswordRoot root = new ChangePasswordRoot();
        root = (ChangePasswordRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
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
        list.add(new BasicNameValuePair("newpassword", "123123"));
        list.add(new BasicNameValuePair("password", "111111"));
        ChangePasswordRoot root = new ChangePasswordRoot();
        root = (ChangePasswordRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 新密码不能为空
     */
    public void testNewpasswordIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "1831U2SQT7N6LK2G8PEQD0E3F92F0HS8"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("newpassword", ""));
        list.add(new BasicNameValuePair("password", "111111"));
        ChangePasswordRoot root = new ChangePasswordRoot();
        root = (ChangePasswordRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_NEWPASSWORD_IS_NULL, root.getMsg().trim());
    }

    /**
     * 密码不能为空
     */
    public void testPasswordIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("newpassword", "123123"));
        list.add(new BasicNameValuePair("password", ""));
        ChangePasswordRoot root = new ChangePasswordRoot();
        root = (ChangePasswordRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PASSWORD_IS_NULL, root.getMsg().trim());
    }

    /**
     * 请先登录
     */
    public void testNotLogin()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "1831U2SQT7N6LK"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("newpassword", "123123"));
        list.add(new BasicNameValuePair("password", "111111"));
        ChangePasswordRoot root = new ChangePasswordRoot();
        root = (ChangePasswordRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_PLEASE_LOGIN, root.getMsg().trim());
    }

    /**
     * 原密码不正确
     */
    public void testPasswordError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("newpassword", "148852"));
        list.add(new BasicNameValuePair("password", "154545"));
        ChangePasswordRoot root = new ChangePasswordRoot();
        root = (ChangePasswordRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_ORG_PASSWORD_ERROR, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("newpassword", "1231232222222222"));
        list.add(new BasicNameValuePair("password", "111111"));
        ChangePasswordRoot root = new ChangePasswordRoot();
        root = (ChangePasswordRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_UPD_PASSWORD_FAIL, root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("newpassword", "111111"));
        list.add(new BasicNameValuePair("password", "123456"));
        ChangePasswordRoot root = new ChangePasswordRoot();
        root = (ChangePasswordRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_UPD_PASSWORD_SUCCESS, root.getMsg().trim());
    }
}
