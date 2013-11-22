package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobe01.transform.BillListgRoot;

public class MOBE01Test extends TestCase
{

    String interfaceCode = "mobe01";//接口编码

    private static GetLoginInfo getLoginInfo = new GetLoginInfo();

    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("ctimestamp", ""));
        BillListgRoot root = new BillListgRoot();
        root = (BillListgRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    public void testSessionidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("ctimestamp", ""));
        BillListgRoot root = new BillListgRoot();
        root = (BillListgRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    public void testCtimestampIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("ctimestamp", ""));
        BillListgRoot root = new BillListgRoot();
        root = (BillListgRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_CTIMESTAMP_IS_NULL, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("ctimestamp", ""));
        BillListgRoot root = new BillListgRoot();
        root = (BillListgRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("未查询到符合条件的数据", root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("ctimestamp", ""));
        BillListgRoot root = new BillListgRoot();
        root = (BillListgRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("用户获取账单信息成功", root.getMsg().trim());
    }
}
