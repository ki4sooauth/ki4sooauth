package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobc01.transform.CryoutListgRoot;

public class MOBC01Test extends TestCase
{

    String interfaceCode = "mobc01";//接口编码

    private static GetLoginInfo getLoginInfo = new GetLoginInfo();

    /**
     * 查询吆喝类型不能为空
     */
    public void testTypeIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("pagetype", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("cryoutinfoid", ""));
        list.add(new BasicNameValuePair("gpsx", ""));
        list.add(new BasicNameValuePair("gpsy", ""));
        list.add(new BasicNameValuePair("pageSize", ""));
        list.add(new BasicNameValuePair("recommendtype", ""));
        list.add(new BasicNameValuePair("infotype", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        CryoutListgRoot root = new CryoutListgRoot();
        root = (CryoutListgRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_TYPE_IS_NULL, root.getMsg().trim());
    }

    /**
     * 纬度不能为空
     */
    public void testGpsxIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("pagetype", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("cryoutinfoid", ""));
        list.add(new BasicNameValuePair("gpsx", ""));
        list.add(new BasicNameValuePair("gpsy", ""));
        list.add(new BasicNameValuePair("pageSize", ""));
        list.add(new BasicNameValuePair("recommendtype", ""));
        list.add(new BasicNameValuePair("infotype", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        CryoutListgRoot root = new CryoutListgRoot();
        root = (CryoutListgRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_CRYOUTTYPE_IS_D_GASX_IS_NULL, root.getMsg().trim());
    }

    /**
     * 经度不能为空
     */
    public void testGpsyIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("pagetype", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("cryoutinfoid", ""));
        list.add(new BasicNameValuePair("gpsx", ""));
        list.add(new BasicNameValuePair("gpsy", ""));
        list.add(new BasicNameValuePair("pageSize", ""));
        list.add(new BasicNameValuePair("recommendtype", ""));
        list.add(new BasicNameValuePair("infotype", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        CryoutListgRoot root = new CryoutListgRoot();
        root = (CryoutListgRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_CRYOUTTYPE_IS_D_GASY_IS_NULL, root.getMsg().trim());
    }

    /**
     * 未查询到如何条件的数据
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("pagetype", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("cryoutinfoid", ""));
        list.add(new BasicNameValuePair("gpsx", ""));
        list.add(new BasicNameValuePair("gpsy", ""));
        list.add(new BasicNameValuePair("pageSize", ""));
        list.add(new BasicNameValuePair("recommendtype", ""));
        list.add(new BasicNameValuePair("infotype", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        CryoutListgRoot root = new CryoutListgRoot();
        root = (CryoutListgRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_COMMON_NOT_GET_WANT_DATA, root.getMsg().trim());
    }

    /**
     * 查询吆喝
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("pagetype", ""));
        list.add(new BasicNameValuePair("type", ""));
        list.add(new BasicNameValuePair("cryoutinfoid", ""));
        list.add(new BasicNameValuePair("gpsx", ""));
        list.add(new BasicNameValuePair("gpsy", ""));
        list.add(new BasicNameValuePair("pageSize", ""));
        list.add(new BasicNameValuePair("recommendtype", ""));
        list.add(new BasicNameValuePair("infotype", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        CryoutListgRoot root = new CryoutListgRoot();
        root = (CryoutListgRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("商家吆喝", root.getMsg().trim());
    }
}
