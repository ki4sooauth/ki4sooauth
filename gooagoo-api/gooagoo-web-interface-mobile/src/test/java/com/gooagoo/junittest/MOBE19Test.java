package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.moba02.transform.DelUserMemberCardRoot;

public class MOBE19Test extends TestCase
{

    String interfaceCode = "moba16";//接口编码

    private static GetLoginInfo getLoginInfo = new GetLoginInfo();

    /**
     * 用户编号不能为空
     */
    public void testUseridIsNull()
    {

        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("orderinfo", "02017Q3Ee198TUUV50000HFYOBYE123F"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        DelUserMemberCardRoot root = new DelUserMemberCardRoot();
        root = (DelUserMemberCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
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
        list.add(new BasicNameValuePair("orderinfo", "02017Q3Ee198TUUV50000HFYOBYE123F"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        DelUserMemberCardRoot root = new DelUserMemberCardRoot();
        root = (DelUserMemberCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 用户账单编号不能为空
     */
    public void testOrderinfoIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("orderinfo", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        DelUserMemberCardRoot root = new DelUserMemberCardRoot();
        root = (DelUserMemberCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_BILLID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 未登录
     */
    public void testNotLogin()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "4545"));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("orderinfo", "error02017Q3Ee198000HFYOBYE123F"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        DelUserMemberCardRoot root = new DelUserMemberCardRoot();
        root = (DelUserMemberCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_PLEASE_LOGIN, root.getMsg().trim());
    }

    /**
     * 删除账单信息失败
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("orderinfo", "error02017Q3Ee198000HFYOBYE123F"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        DelUserMemberCardRoot root = new DelUserMemberCardRoot();
        root = (DelUserMemberCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_DEL_BILL_FAIL, root.getMsg().trim());
    }

    /**
     * 删除账单信息成功（单个）
     */
    public void testSingleSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("orderinfo", "02017Q3Ee198TUUV50000HFYOBYE123F"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        DelUserMemberCardRoot root = new DelUserMemberCardRoot();
        root = (DelUserMemberCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_DEL_BILL_SUCCESS, root.getMsg().trim());
    }

    /**
     * 删除账单信息成功（多个）
     */
    public void testMultiSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("orderinfo", "02017Q3Ee198TUUV50000HFYOBYE123F,02517Q3Ee198TUUV33334HFYOBYE123F"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        DelUserMemberCardRoot root = new DelUserMemberCardRoot();
        root = (DelUserMemberCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_DEL_BILL_SUCCESS, root.getMsg().trim());
    }
}
