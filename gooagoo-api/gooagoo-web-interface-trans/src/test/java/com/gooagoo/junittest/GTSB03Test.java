package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.trans.entity.gtsb03.transform.GetUserIntegralRoot;

public class GTSB03Test extends TestCase
{

    String interfaceCode = "gtsb03";//接口编码

    /**
     * 转发器MAC地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", "00017QB336KQEMJCR00006SXUXJ1T001"));
        list.add(new BasicNameValuePair("userid", "00017QDVT76FDE9C400007EIISX8Q0T6"));
        GetUserIntegralRoot root = new GetUserIntegralRoot();
        root = (GetUserIntegralRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_MAC_IS_NULL, root.getMsg().trim());
    }

    /**
     * 商家编号不能为空
     */
    public void testShopidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:fe"));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("userid", "00017QDVT76FDE9C400007EIISX8Q0T6"));
        GetUserIntegralRoot root = new GetUserIntegralRoot();
        root = (GetUserIntegralRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 用户编号不能为空
     */
    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:fe"));
        list.add(new BasicNameValuePair("shopid", "00017QB336KQEMJCR00006SXUXJ1T001"));
        list.add(new BasicNameValuePair("userid", ""));
        GetUserIntegralRoot root = new GetUserIntegralRoot();
        root = (GetUserIntegralRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 查询会员积分成功(无积分)
     */
    public void testUserHavaNoJIFENSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:fe"));
        list.add(new BasicNameValuePair("shopid", "00017QB336KQEMJCR00006SXUXJ1T001"));
        list.add(new BasicNameValuePair("userid", "000180S81072PD5Q0GLLESBJ0ZROA6IK"));
        GetUserIntegralRoot root = new GetUserIntegralRoot();
        root = (GetUserIntegralRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询会员积分成功", root.getMsg().trim());
    }

    /**
     * 查询会员积分成功(有积分)
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:fe"));
        list.add(new BasicNameValuePair("shopid", "00017QB336KQEMJCR00006SXUXJ1T001"));
        list.add(new BasicNameValuePair("userid", "00017QDVT76FDE9C400007EIISX8Q0T6"));
        GetUserIntegralRoot root = new GetUserIntegralRoot();
        root = (GetUserIntegralRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("查询会员积分成功", root.getMsg().trim());
    }

}
