package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobd07.transform.UserShoppingPlanBTBRoot;

public class MOBD07Test extends TestCase
{

    String interfaceCode = "mobd07";//接口编码

    private static GetLoginInfo getLoginInfo = new GetLoginInfo();

    /**
     * 用户编号不能为空
     */
    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("usershoppingplan", "{\"usershoppingplanS\":[{\"shoppinglistid\":\"00017OBBKJJVQQ3M400006ak1vaz4027\",\"title\":\"周二购物\",\"preshoppingtime\":\"2013-04-17 00:00:00\",\"infosource\": \"1\",\"isdel\":\"N\",\"createtime\":\"2013-04-17 14:41:48\",\"ctimestamp\":\"2013-05-20 16:45:26\",\"shoppinggoodslistS\":[{\"shoppinggoodsid\":\"00017OFUM8DTJN1JP00007ak1vaz4027\",\"goodsid\":\"\",\"goodsname\":\"袜子\",\"goodstypeid\":\"\",\"goodstypename\":\"\",\"shopid\":\"\",\"shopname\":\"\",\"isdel\":\"N\",\"createtime\":\"2013-04-19 09:31:43\",\"ctimestamp\":\"2013-08-29 17:05:50\"}]}]}"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        UserShoppingPlanBTBRoot root = new UserShoppingPlanBTBRoot();
        root = (UserShoppingPlanBTBRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * sessionid值不能为空
     */
    public void testSessionidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("usershoppingplan", "{\"usershoppingplanS\":[{\"shoppinglistid\":\"00017OBBKJJVQQ3M400006ak1vaz4027\",\"title\":\"周二购物\",\"preshoppingtime\":\"2013-04-17 00:00:00\",\"infosource\": \"1\",\"isdel\":\"N\",\"createtime\":\"2013-04-17 14:41:48\",\"ctimestamp\":\"2013-05-20 16:45:26\",\"shoppinggoodslistS\":[{\"shoppinggoodsid\":\"00017OFUM8DTJN1JP00007ak1vaz4027\",\"goodsid\":\"\",\"goodsname\":\"袜子\",\"goodstypeid\":\"\",\"goodstypename\":\"\",\"shopid\":\"\",\"shopname\":\"\",\"isdel\":\"N\",\"createtime\":\"2013-04-19 09:31:43\",\"ctimestamp\":\"2013-08-29 17:05:50\"}]}]}"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        UserShoppingPlanBTBRoot root = new UserShoppingPlanBTBRoot();
        root = (UserShoppingPlanBTBRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    /**
     *  商品信息不能为空
     */
    public void testUsershoppingplanIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("usershoppingplan", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        UserShoppingPlanBTBRoot root = new UserShoppingPlanBTBRoot();
        root = (UserShoppingPlanBTBRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_USERSHOPPINGPLAN_IS_NULL, root.getMsg().trim());
    }

    /**
     * 请先登录
     */
    public void testNotLogin()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "232"));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("usershoppingplan", "{\"usershoppingplanS\":[{\"shoppinglistid\":\"00017OBBKJJVQQ3M400006ak1vaz4027\",\"title\":\"周二购物\",\"preshoppingtime\":\"2013-04-17 00:00:00\",\"infosource\": \"1\",\"isdel\":\"N\",\"createtime\":\"2013-04-17 14:41:48\",\"ctimestamp\":\"2013-05-20 16:45:26\",\"shoppinggoodslistS\":[{\"shoppinggoodsid\":\"00017OFUM8DTJN1JP00007ak1vaz4027\",\"goodsid\":\"\",\"goodsname\":\"袜子\",\"goodstypeid\":\"\",\"goodstypename\":\"\",\"shopid\":\"\",\"shopname\":\"\",\"isdel\":\"N\",\"createtime\":\"2013-04-19 09:31:43\",\"ctimestamp\":\"2013-08-29 17:05:50\"}]}]}"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        UserShoppingPlanBTBRoot root = new UserShoppingPlanBTBRoot();
        root = (UserShoppingPlanBTBRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_PLEASE_LOGIN, root.getMsg().trim());
    }

    /**
     *  未查询到符合条件的数据
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("usershoppingplan", "{\"usershoppingplanS\":[{\"shoppinglistid\":\"00017OBBKJJVQQ3M400006ak1vaz4027\",\"title\":\"周二购物\",\"preshoppingtime\":\"2013-04-17 00:00:00\",\"infosource\": \"1\",\"isdel\":\"N\",\"createtime\":\"2013-04-17 14:41:48\",\"ctimestamp\":\"2013-05-20 16:45:26\",\"shoppinggoodslistS\":[{\"shoppinggoodsid\":\"00017OFUM8DTJN1JP00007ak1vaz4027\",\"goodsid\":\"\",\"goodsname\":\"袜子\",\"goodstypeid\":\"\",\"goodstypename\":\"\",\"shopid\":\"\",\"shopname\":\"\",\"isdel\":\"N\",\"createtime\":\"2013-04-19 09:31:43\",\"ctimestamp\":\"2013-08-29 17:05:50\"}]}]}"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        UserShoppingPlanBTBRoot root = new UserShoppingPlanBTBRoot();
        root = (UserShoppingPlanBTBRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("usershoppingplan", "{\"usershoppingplanS\":[{\"shoppinglistid\":\"00017OBBKJJVQQ3M400006ak1vaz4027\",\"title\":\"周二购物\",\"preshoppingtime\":\"2013-04-17 00:00:00\",\"infosource\": \"1\",\"isdel\":\"N\",\"createtime\":\"2013-04-17 14:41:48\",\"ctimestamp\":\"2013-05-20 16:45:26\",\"shoppinggoodslistS\":[{\"shoppinggoodsid\":\"00017OFUM8DTJN1JP00007ak1vaz4027\",\"goodsid\":\"\",\"goodsname\":\"袜子\",\"goodstypeid\":\"\",\"goodstypename\":\"\",\"shopid\":\"\",\"shopname\":\"\",\"isdel\":\"N\",\"createtime\":\"2013-04-19 09:31:43\",\"ctimestamp\":\"2013-08-29 17:05:50\"}]}]}"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        UserShoppingPlanBTBRoot root = new UserShoppingPlanBTBRoot();
        root = (UserShoppingPlanBTBRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("计划列表与服务器同步", root.getMsg().trim());
    }
}
