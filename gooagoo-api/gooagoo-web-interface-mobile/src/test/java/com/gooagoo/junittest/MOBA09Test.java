package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.moba09.transform.ShopCardInfoRoot;

public class MOBA09Test extends TestCase
{

    String interfaceCode = "moba09";//接口编码

    private static GetLoginInfo getLoginInfo = new GetLoginInfo();

    /**
     * 商家编号不能为空
     */
    public void testShopidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("shopid", ""));
        ShopCardInfoRoot root = new ShopCardInfoRoot();
        root = (ShopCardInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 商家编号不能为空
     */
    public void testGetNoData()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("shopid", "121"));
        ShopCardInfoRoot root = new ShopCardInfoRoot();
        root = (ShopCardInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 获取店铺的会员卡信息列表成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        ShopCardInfoRoot root = new ShopCardInfoRoot();
        root = (ShopCardInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取店铺的会员卡信息列表成功", root.getMsg().trim());
    }
}
