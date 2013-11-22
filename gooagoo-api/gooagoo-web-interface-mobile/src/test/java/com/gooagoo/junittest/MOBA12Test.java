package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.moba12.transform.AgreeCardRoot;

public class MOBA12Test extends TestCase
{

    String interfaceCode = "moba12";//接口编码

    private static GetLoginInfo getLoginInfo = new GetLoginInfo();

    /**
     * 用户编号不能为空
     */
    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("cardid", "0182A8E3FD223I30I3TDLVEIISWR2GDJ"));
        list.add(new BasicNameValuePair("cardtype", "1"));
        list.add(new BasicNameValuePair("isagree", "Y"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AgreeCardRoot root = new AgreeCardRoot();
        root = (AgreeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 用户sessionId不能为空
     */
    public void testSessionidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("cardid", "0182A8E3FD223I30I3TDLVEIISWR2GDJ"));
        list.add(new BasicNameValuePair("cardtype", "1"));
        list.add(new BasicNameValuePair("isagree", "Y"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AgreeCardRoot root = new AgreeCardRoot();
        root = (AgreeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 商家编号不能为空
     */
    public void testShopidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("cardid", "0182A8E3FD223I30I3TDLVEIISWR2GDJ"));
        list.add(new BasicNameValuePair("cardtype", "1"));
        list.add(new BasicNameValuePair("isagree", "Y"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AgreeCardRoot root = new AgreeCardRoot();
        root = (AgreeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 商家会员卡id不能为空
     */
    public void testCardidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("cardid", ""));
        list.add(new BasicNameValuePair("cardtype", "1"));
        list.add(new BasicNameValuePair("isagree", "Y"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AgreeCardRoot root = new AgreeCardRoot();
        root = (AgreeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_CARDID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 卡类型不能为空
     */
    public void testCardtypeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("cardid", "0182A8E3FD223I30I3TDLVEIISWR2GDJ"));
        list.add(new BasicNameValuePair("cardtype", ""));
        list.add(new BasicNameValuePair("isagree", "Y"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AgreeCardRoot root = new AgreeCardRoot();
        root = (AgreeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_CARDTYPE_IS_NULL, root.getMsg().trim());
    }

    /**
     * 是否同意不能为空
     */
    public void testIagreeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("cardid", "0182A8E3FD223I30I3TDLVEIISWR2GDJ"));
        list.add(new BasicNameValuePair("cardtype", "1"));
        list.add(new BasicNameValuePair("isagree", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AgreeCardRoot root = new AgreeCardRoot();
        root = (AgreeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_IAGREE_IS_NULL, root.getMsg().trim());
    }

    /**
     * 请先登录
     */
    public void testNotLogin()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "1212"));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("cardid", "0182A8E3FD223I30I3TDLVEIISWR2GDJ"));
        list.add(new BasicNameValuePair("cardtype", "1"));
        list.add(new BasicNameValuePair("isagree", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AgreeCardRoot root = new AgreeCardRoot();
        root = (AgreeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_IAGREE_IS_NULL, root.getMsg().trim());
    }

    /**
     *  用户没有此卡
     */
    public void testUserNotHaveTheCard()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("cardid", "0ds82A8E3FD223I30I3TDLVEIISWR2GDJ"));
        list.add(new BasicNameValuePair("cardtype", "1"));
        list.add(new BasicNameValuePair("isagree", "Y"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AgreeCardRoot root = new AgreeCardRoot();
        root = (AgreeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_NOT_HAVE_THE_CARD, root.getMsg().trim());
    }

    /**
     *  用户已有此卡
     */
    public void testUserAlreadyHaveTheCard()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("cardid", "0182A8E3FD223I30I3TDLVEIISWR2GDJ"));
        list.add(new BasicNameValuePair("cardtype", "1"));
        list.add(new BasicNameValuePair("isagree", "Y"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AgreeCardRoot root = new AgreeCardRoot();
        root = (AgreeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_ALREADY_HAVE_THE_CARD, root.getMsg().trim());
    }

    /**
     * 发卡成功(同意)
     */
    public void testSuccessWithAgree()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("cardid", "0182A8ILH6A7KIE0I3TDM1EIISWR2GDJ"));
        list.add(new BasicNameValuePair("cardtype", "2"));
        list.add(new BasicNameValuePair("isagree", "Y"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AgreeCardRoot root = new AgreeCardRoot();
        root = (AgreeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_GIVE_CARD_SUCCESS, root.getMsg().trim());
    }

    /**
     * 发卡成功(不同意)
     */
    public void testSuccessWithNoAgree()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("cardid", "0182A8ILH6A7KIE0I3TDM1EIISWR2GDJ"));
        list.add(new BasicNameValuePair("cardtype", "2"));
        list.add(new BasicNameValuePair("isagree", "N"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AgreeCardRoot root = new AgreeCardRoot();
        root = (AgreeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_GIVE_CARD_SUCCESS, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("cardid", "0182A8E3FD223I30I3TDLVEIISWR2GDJ"));
        list.add(new BasicNameValuePair("cardtype", "3"));
        list.add(new BasicNameValuePair("isagree", "Y"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AgreeCardRoot root = new AgreeCardRoot();
        root = (AgreeCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_GIVE_CARD_FAIL, root.getMsg().trim());
    }

}
