package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobb04.transform.GoodsDetailRoot;

public class MOBB04Test extends TestCase
{

    String interfaceCode = "mobb04";//接口编码

    private static GetLoginInfo getLoginInfo = new GetLoginInfo();

    /**
     * 用户编号不能为空
     */
    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        list.add(new BasicNameValuePair("goodsinfo", "[{\"goodsid\":\"00017QB83S2F96DQ700008SXUXJ1T001\",\"shopentityid\":\"00017QBT1VJI365T100008FYOBYEH00U\"},{\"goodsid\":\"00017R7HN6Q0EGHJI001K8EIISX8Q023\",\"shopentityid\":\"00017QB336KQEMJCR00006SXUXJ1T001\"}]"));
        GoodsDetailRoot root = new GoodsDetailRoot();
        root = (GoodsDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 用户Sessionid不能为空
     */
    public void testSessionidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        list.add(new BasicNameValuePair("goodsinfo", "[{\"goodsid\":\"00017QB83S2F96DQ700008SXUXJ1T001\",\"shopentityid\":\"00017QBT1VJI365T100008FYOBYEH00U\"},{\"goodsid\":\"00017R7HN6Q0EGHJI001K8EIISX8Q023\",\"shopentityid\":\"00017QB336KQEMJCR00006SXUXJ1T001\"}]"));
        GoodsDetailRoot root = new GoodsDetailRoot();
        root = (GoodsDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 页码不能为空
     */
    public void testPageIndexIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("pageIndex", ""));
        list.add(new BasicNameValuePair("pagesize", "10"));
        list.add(new BasicNameValuePair("goodsinfo", "[{\"goodsid\":\"00017QB83S2F96DQ700008SXUXJ1T001\",\"shopentityid\":\"00017QBT1VJI365T100008FYOBYEH00U\"},{\"goodsid\":\"00017R7HN6Q0EGHJI001K8EIISX8Q023\",\"shopentityid\":\"00017QB336KQEMJCR00006SXUXJ1T001\"}]"));
        GoodsDetailRoot root = new GoodsDetailRoot();
        root = (GoodsDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PAGEINDEX_IS_NULL, root.getMsg().trim());
    }

    /**
     * 每页信息显示条数不能为空
     */
    public void testPagesizeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", ""));
        list.add(new BasicNameValuePair("goodsinfo", "[{\"goodsid\":\"00017QB83S2F96DQ700008SXUXJ1T001\",\"shopentityid\":\"00017QBT1VJI365T100008FYOBYEH00U\"},{\"goodsid\":\"00017R7HN6Q0EGHJI001K8EIISX8Q023\",\"shopentityid\":\"00017QB336KQEMJCR00006SXUXJ1T001\"}]"));
        GoodsDetailRoot root = new GoodsDetailRoot();
        root = (GoodsDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PAGESIZE_IS_NULL, root.getMsg().trim());
    }

    /**
     * 商品信息不能为空
     */
    public void testGoodsinfoIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", ""));
        list.add(new BasicNameValuePair("goodsinfo", ""));
        GoodsDetailRoot root = new GoodsDetailRoot();
        root = (GoodsDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_GOODSINFO_IS_NULL, root.getMsg().trim());
    }

    /**
     * 未登录
     */
    public void testNotLogin()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "32"));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        list.add(new BasicNameValuePair("goodsinfo", "[{\"goodsid\":\"00017QB83S2F96DQ700008SXUXJ1T001\",\"shopentityid\":\"00017QBT1VJI365T100008FYOBYEH00U\"},{\"goodsid\":\"00017R7HN6Q0EGHJI001K8EIISX8Q023\",\"shopentityid\":\"00017QB336KQEMJCR00006SXUXJ1T001\"}]"));
        GoodsDetailRoot root = new GoodsDetailRoot();
        root = (GoodsDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_PLEASE_LOGIN, root.getMsg().trim());
    }

    /**
     * 未查到符合条件的数据
     */
    public void testGetNoData()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        list.add(new BasicNameValuePair("goodsinfo", "[{\"goodsid\":\"00017errorQB83S2F96DQ700008SXUXJ1T001\",\"shopentityid\":\"0001error7QBT1VJI365T100008FYOBYEH00U\"},{\"goodsid\":\"00017R7HN6Q0EGHJI001K8EIISX8Q023\",\"shopentityid\":\"00017QB336KQEMJCR00006SXUXJ1T001\"}]"));
        GoodsDetailRoot root = new GoodsDetailRoot();
        root = (GoodsDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 查询商品评论详细成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("pageIndex", "1"));
        list.add(new BasicNameValuePair("pagesize", "10"));
        list.add(new BasicNameValuePair("goodsinfo", "[{\"goodsid\":\"01822TIHISRNTBT07GRNHGEIISWR2K8D\",\"shopentityid\":\"01822JF4R28QLJF07GRNH1EIISWR2K8D\"},{\"goodsid\":\"01822TP9V9G73ML07GRNHHEIISWR2K8D\",\"shopentityid\":\"01822JF4R28QLJF07GRNH1EIISWR2K8D\"}]"));
        GoodsDetailRoot root = new GoodsDetailRoot();
        root = (GoodsDetailRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("获取商品详细信息及评论成功", root.getMsg().trim());
    }
}
