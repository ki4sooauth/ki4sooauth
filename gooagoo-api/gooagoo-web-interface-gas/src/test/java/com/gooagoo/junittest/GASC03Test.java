package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.gas.entity.gasc03.transform.UserBaseInfoRoot;

public class GASC03Test
{
    String interfaceCode = "gasc03";//接口编码

    /**
     * 店员助理mac地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        UserBaseInfoRoot root = new UserBaseInfoRoot();
        root = (UserBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 店员登录账号不能为空
     */
    public void testShopUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        UserBaseInfoRoot root = new UserBaseInfoRoot();
        root = (UserBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_PARAMETER_SHOPUSERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 会员卡音频编号不能为空
     */
    public void testScardnoNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        UserBaseInfoRoot root = new UserBaseInfoRoot();
        root = (UserBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("会员卡音频编号不能为空", root.getMsg().trim());
    }

    /**
     * 未查询到符合条件的数据
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        UserBaseInfoRoot root = new UserBaseInfoRoot();
        root = (UserBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.GAS_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 通过会员卡音频卡号查询会员信息成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopuserid", ""));
        list.add(new BasicNameValuePair("scardno", ""));
        UserBaseInfoRoot root = new UserBaseInfoRoot();
        root = (UserBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询会员信息成功", root.getMsg().trim());
    }
}
