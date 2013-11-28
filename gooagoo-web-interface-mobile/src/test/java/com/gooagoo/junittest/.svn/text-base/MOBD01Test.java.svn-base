package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobd01.transform.UserShoppingPlanSRoot;

public class MOBD01Test extends TestCase
{

    String interfaceCode = "mobd01";//接口编码

    private static GetLoginInfo getLoginInfo = new GetLoginInfo();

    /**
     * 用户编号不能为空
     */
    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("usershoppingplan", "{'createtime':'2013-06-08 17:42:06','infosource':'M','shoppinglistid':'00017SHIKD3V9DO390000LZ5O9YBD00V','title':'ddff','preshoppingtime':'2013-06-13 00:00:00','shoppingplangoodsmob':[{'createtime':'2013-06-13 09:53:31','goodsname':'兰特伯爵秘制鹅肝批','shopid':'00017QB336KQEMJCR00006SXUXJ1T001','goodstypename':'','shoppinggoodsid':'00017STJPN0U2IHUB006NKEIISQNK014','goodsid':'00017R7ETK4LMT812000F1EIISX8Q023','ctimestamp':'2013-08-27 10:12:56','isdel':'N','shopname':'兰特伯爵西餐厅','goodstypeid':''}],'ctimestamp':'2013-06-08 17:42:06','isdel':'N'}"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        UserShoppingPlanSRoot root = new UserShoppingPlanSRoot();
        root = (UserShoppingPlanSRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
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
        list.add(new BasicNameValuePair("usershoppingplan", "{'createtime':'2013-06-08 17:42:06','infosource':'M','shoppinglistid':'00017SHIKD3V9DO390000LZ5O9YBD00V','title':'ddff','preshoppingtime':'2013-06-13 00:00:00','shoppingplangoodsmob':[{'createtime':'2013-06-13 09:53:31','goodsname':'兰特伯爵秘制鹅肝批','shopid':'00017QB336KQEMJCR00006SXUXJ1T001','goodstypename':'','shoppinggoodsid':'00017STJPN0U2IHUB006NKEIISQNK014','goodsid':'00017R7ETK4LMT812000F1EIISX8Q023','ctimestamp':'2013-08-27 10:12:56','isdel':'N','shopname':'兰特伯爵西餐厅','goodstypeid':''}],'ctimestamp':'2013-06-08 17:42:06','isdel':'N'}"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        UserShoppingPlanSRoot root = new UserShoppingPlanSRoot();
        root = (UserShoppingPlanSRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 商品信息不能为空
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
        UserShoppingPlanSRoot root = new UserShoppingPlanSRoot();
        root = (UserShoppingPlanSRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_USERSHOPPINGPLAN_IS_NULL, root.getMsg().trim());
    }

    /**
     * 请先登录
     */
    public void testNotLogin()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "544654"));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("usershoppingplan", "{'createtime':'2013-06-08 17:42:06','infosource':'M','shoppinglistid':'00017SHIKD3V9DO390000LZ5O9YBD00V','title':'ddff','preshoppingtime':'2013-06-13 00:00:00','shoppingplangoodsmob':[{'createtime':'2013-06-13 09:53:31','goodsname':'兰特伯爵秘制鹅肝批','shopid':'00017QB336KQEMJCR00006SXUXJ1T001','goodstypename':'','shoppinggoodsid':'00017STJPN0U2IHUB006NKEIISQNK014','goodsid':'00017R7ETK4LMT812000F1EIISX8Q023','ctimestamp':'2013-08-27 10:12:56','isdel':'N','shopname':'兰特伯爵西餐厅','goodstypeid':''}],'ctimestamp':'2013-06-08 17:42:06','isdel':'N'}"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        UserShoppingPlanSRoot root = new UserShoppingPlanSRoot();
        root = (UserShoppingPlanSRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_PLEASE_LOGIN, root.getMsg().trim());
    }

    /**
     * 未查询到符合条件的数据
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("usershoppingplan", "{'createtime':'2013-06-08 17:42:06','infosource':'M','shoppinglistid':'00017SHIKD3V9DO390000LZ5O9YBD00V','title':'ddff','preshoppingtime':'2013-06-13 00:00:00','shoppingplangoodsmob':[{'createtime':'2013-06-13 09:53:31','goodsname':'兰特伯爵秘制鹅肝批','shopid':'00017QB336KQEMJCR00006SXUXJ1T001','goodstypename':'','shoppinggoodsid':'00017STJPN0U2IHUB006NKEIISQNK014','goodsid':'00017R7ETK4LMT812000F1EIISX8Q023','ctimestamp':'2013-08-27 10:12:56','isdel':'N','shopname':'兰特伯爵西餐厅','goodstypeid':''}],'ctimestamp':'2013-06-08 17:42:06','isdel':'N'}"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        UserShoppingPlanSRoot root = new UserShoppingPlanSRoot();
        root = (UserShoppingPlanSRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("usershoppingplan", "{'createtime':'2013-06-08 17:42:06','infosource':'M','shoppinglistid':'00017SHIKD3V9DO390000LZ5O9YBD00V','title':'ddff','preshoppingtime':'2013-06-13 00:00:00','shoppingplangoodsmob':[{'createtime':'2013-06-13 09:53:31','goodsname':'兰特伯爵秘制鹅肝批','shopid':'00017QB336KQEMJCR00006SXUXJ1T001','goodstypename':'','shoppinggoodsid':'00017STJPN0U2IHUB006NKEIISQNK014','goodsid':'00017R7ETK4LMT812000F1EIISX8Q023','ctimestamp':'2013-08-27 10:12:56','isdel':'N','shopname':'兰特伯爵西餐厅','goodstypeid':''}],'ctimestamp':'2013-06-08 17:42:06','isdel':'N'}"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        UserShoppingPlanSRoot root = new UserShoppingPlanSRoot();
        root = (UserShoppingPlanSRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("计划列表与服务器同步成功", root.getMsg().trim());
    }
}
