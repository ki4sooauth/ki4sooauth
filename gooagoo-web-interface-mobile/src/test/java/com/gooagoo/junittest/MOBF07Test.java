package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobf07.transform.FeedbackRoot;

public class MOBF07Test extends TestCase
{

    String interfaceCode = "mobf07";//接口编码

    /**
     * 用户编号不能为空
     */
    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("content", "55"));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        FeedbackRoot root = new FeedbackRoot();
        root = (FeedbackRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * sessionid值不能为空
     */
    public void testSessionidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("content", "55"));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        FeedbackRoot root = new FeedbackRoot();
        root = (FeedbackRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 评论的具体内容不能为空
     */
    public void testContentIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("content", ""));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        FeedbackRoot root = new FeedbackRoot();
        root = (FeedbackRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_CONTENT_IS_NULL, root.getMsg().trim());
    }

    /**
     * 请先登录
     */
    public void testNotLogin()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "4161231"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("content", "55"));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        FeedbackRoot root = new FeedbackRoot();
        root = (FeedbackRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_PLEASE_LOGIN, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("content", "55"));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        FeedbackRoot root = new FeedbackRoot();
        root = (FeedbackRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("意见反馈失败", root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("content", "55"));
        list.add(new BasicNameValuePair("mac", "00:00:00:00:00:ff"));
        list.add(new BasicNameValuePair("mver", "iphone4s"));
        FeedbackRoot root = new FeedbackRoot();
        root = (FeedbackRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("意见反馈成功", root.getMsg().trim());
    }
}
