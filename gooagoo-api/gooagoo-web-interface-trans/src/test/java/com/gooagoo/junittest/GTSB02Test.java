package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.trans.entity.gtsb02.transform.ShopMemberCardsRoot;

public class GTSB02Test extends TestCase
{

    String interfaceCode = "gtsb02";//接口编码

    /**
     * 转发器MAC地址不能为空
     */
    public void testMacIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", ""));
        list.add(new BasicNameValuePair("shopid", "00017QB336KQEMJCR00006SXUXJ1T001"));
        list.add(new BasicNameValuePair("ctimestamp", "2013-06-12 14:57:54"));
        ShopMemberCardsRoot root = new ShopMemberCardsRoot();
        root = (ShopMemberCardsRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
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
        list.add(new BasicNameValuePair("ctimestamp", "2013-06-12 14:57:54"));
        ShopMemberCardsRoot root = new ShopMemberCardsRoot();
        root = (ShopMemberCardsRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 最大时间戳不能为空
     */
    public void testCtimestampIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:fe"));
        list.add(new BasicNameValuePair("shopid", "00017QB336KQEMJCR00006SXUXJ1T001"));
        list.add(new BasicNameValuePair("ctimestamp", ""));
        ShopMemberCardsRoot root = new ShopMemberCardsRoot();
        root = (ShopMemberCardsRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_PARAMETER_CTIMESTAMP_IS_NULL, root.getMsg().trim());
    }

    /**
     * 未查询到符合条件的数据
     */
    public void testGetNoData()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:fe"));
        list.add(new BasicNameValuePair("shopid", "00017QB336KQEMJCR00006SXUXJ1T002"));
        list.add(new BasicNameValuePair("ctimestamp", "2013-06-12 14:57:54"));
        ShopMemberCardsRoot root = new ShopMemberCardsRoot();
        root = (ShopMemberCardsRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.TRANS_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 同步商家会员卡基本信息成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("mac", "00:27:13:f7:bc:6e"));
        list.add(new BasicNameValuePair("shopid", "01822IAKR5SKU02085QBP2EIISWR0JGT"));
        list.add(new BasicNameValuePair("ctimestamp", "2013-06-12 14:57:54"));
        ShopMemberCardsRoot root = new ShopMemberCardsRoot();
        root = (ShopMemberCardsRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("同步商家会员卡基本信息成功", root.getMsg().trim());
    }
}
