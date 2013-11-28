package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.mobf05.transform.MemberChangeBaseInfoRoot;

public class MOBF05Test extends TestCase
{

    String interfaceCode = "mobf05";//接口编码

    /**
     * 用户编号不能为空
     */
    public void testUseridIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("nickname", "俞德馨"));
        list.add(new BasicNameValuePair("sex", "M"));
        list.add(new BasicNameValuePair("birthday", "2013-08-26"));
        list.add(new BasicNameValuePair("idtype", ""));
        list.add(new BasicNameValuePair("idno", ""));
        list.add(new BasicNameValuePair("phone", ""));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", ""));
        MemberChangeBaseInfoRoot root = new MemberChangeBaseInfoRoot();
        root = (MemberChangeBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    /**
     *sessionid值不能为空
     */
    public void testSessionidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("nickname", "俞德馨"));
        list.add(new BasicNameValuePair("sex", "M"));
        list.add(new BasicNameValuePair("birthday", "2013-08-26"));
        list.add(new BasicNameValuePair("idtype", ""));
        list.add(new BasicNameValuePair("idno", ""));
        list.add(new BasicNameValuePair("phone", ""));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", ""));
        MemberChangeBaseInfoRoot root = new MemberChangeBaseInfoRoot();
        root = (MemberChangeBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 请先登录
     */
    public void testNotLogin()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "415545"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("nickname", "俞德馨"));
        list.add(new BasicNameValuePair("sex", "M"));
        list.add(new BasicNameValuePair("birthday", "2013-08-26"));
        list.add(new BasicNameValuePair("idtype", ""));
        list.add(new BasicNameValuePair("idno", ""));
        list.add(new BasicNameValuePair("phone", ""));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", ""));
        MemberChangeBaseInfoRoot root = new MemberChangeBaseInfoRoot();
        root = (MemberChangeBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_PLEASE_LOGIN, root.getMsg().trim());
    }

    /**
     * 姓名格式不正确
     */
    public void testNameError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("nickname", "一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一阿克江打飞机啊；减肥"));
        list.add(new BasicNameValuePair("sex", "M"));
        list.add(new BasicNameValuePair("birthday", "2013-08-26"));
        list.add(new BasicNameValuePair("idtype", ""));
        list.add(new BasicNameValuePair("idno", ""));
        list.add(new BasicNameValuePair("phone", ""));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", ""));
        MemberChangeBaseInfoRoot root = new MemberChangeBaseInfoRoot();
        root = (MemberChangeBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_UPD_NAME_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 性别格式不正确
     */
    public void testSexError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("nickname", "俞德馨"));
        list.add(new BasicNameValuePair("sex", "H"));
        list.add(new BasicNameValuePair("birthday", "2013-08-26"));
        list.add(new BasicNameValuePair("idtype", ""));
        list.add(new BasicNameValuePair("idno", ""));
        list.add(new BasicNameValuePair("phone", ""));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", ""));
        MemberChangeBaseInfoRoot root = new MemberChangeBaseInfoRoot();
        root = (MemberChangeBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_UPD_SEX_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 该证件类型不存在
     */
    public void testIdtypeError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("nickname", "俞德馨"));
        list.add(new BasicNameValuePair("sex", "M"));
        list.add(new BasicNameValuePair("birthday", "2013-08-26"));
        list.add(new BasicNameValuePair("idtype", "mm"));
        list.add(new BasicNameValuePair("idno", ""));
        list.add(new BasicNameValuePair("phone", ""));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", ""));
        MemberChangeBaseInfoRoot root = new MemberChangeBaseInfoRoot();
        root = (MemberChangeBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_UPD_IDTYPE_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 证件号码格式不正确
     */
    public void testIdnoError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("nickname", "俞德馨"));
        list.add(new BasicNameValuePair("sex", "M"));
        list.add(new BasicNameValuePair("birthday", "2013-08-26"));
        list.add(new BasicNameValuePair("idtype", "03"));
        list.add(new BasicNameValuePair("idno", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO01822FUO9AQTK6Q00C5V3IBJ43P1R5JO01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("phone", ""));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", ""));
        MemberChangeBaseInfoRoot root = new MemberChangeBaseInfoRoot();
        root = (MemberChangeBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_UPD_IDNO_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 出生日期格式不正确
     */
    public void testBirthdayError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("nickname", "俞德馨"));
        list.add(new BasicNameValuePair("sex", "M"));
        list.add(new BasicNameValuePair("birthday", "1988-05-06"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "230205198805050016"));
        list.add(new BasicNameValuePair("phone", ""));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", ""));
        MemberChangeBaseInfoRoot root = new MemberChangeBaseInfoRoot();
        root = (MemberChangeBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_UPD_BIRTHDAY_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 联系电话格式不正确
     */
    public void testPhoneError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("nickname", "俞德馨"));
        list.add(new BasicNameValuePair("sex", "M"));
        list.add(new BasicNameValuePair("birthday", "2013-08-26"));
        list.add(new BasicNameValuePair("idtype", ""));
        list.add(new BasicNameValuePair("idno", ""));
        list.add(new BasicNameValuePair("phone", "7777777777777777777770182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", ""));
        MemberChangeBaseInfoRoot root = new MemberChangeBaseInfoRoot();
        root = (MemberChangeBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_UPD_PHONE_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 邮政编码格式不正确
     */
    public void testPostCodeError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("nickname", "俞德馨"));
        list.add(new BasicNameValuePair("sex", "M"));
        list.add(new BasicNameValuePair("birthday", "2013-08-26"));
        list.add(new BasicNameValuePair("idtype", ""));
        list.add(new BasicNameValuePair("idno", ""));
        list.add(new BasicNameValuePair("phone", ""));
        list.add(new BasicNameValuePair("postcode", "10ll00"));
        list.add(new BasicNameValuePair("address", ""));
        MemberChangeBaseInfoRoot root = new MemberChangeBaseInfoRoot();
        root = (MemberChangeBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_UPD_POSTCODE_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 详细地址格式不正确
     */
    public void testAddresError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("nickname", "俞德馨"));
        list.add(new BasicNameValuePair("sex", "M"));
        list.add(new BasicNameValuePair("birthday", "2013-08-26"));
        list.add(new BasicNameValuePair("idtype", ""));
        list.add(new BasicNameValuePair("idno", ""));
        list.add(new BasicNameValuePair("phone", ""));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "【如何利用HTML5与MongoDB创建位置感知Web应用程序】在日常生活中，我们都离不开位置识别类应用程序。Foursquare、Facebook等应用程序帮助我们和我们的家人朋友分享当前位置。而像Google Local这样的应用则帮助我们找到当前位置附近有哪些自己需要的服务设施或业务场所。【如何利用HTML5与MongoDB创建位置感知Web应用程序】在日常生活中，我们都离不开位置识别类应用程序。Foursquare、Facebook等应用程序帮助我们和我们的家人朋友分享当前位置。而像Google Local这样的应用则帮助我们找到当前位置附近有哪些自己需要的服务设施或业务场所。【如何利用HTML5与MongoDB创建位置感知Web应用程序】在日常生活中，我们都离不开位置识别类应用程序。Foursquare、Facebook等应用程序帮助我们和我们的家人朋友分享当前位置。而像Google Local这样的应用则帮助我们找到当前位置附近有哪些自己需要的服务设施或业务场所。【如何利用HTML5与MongoDB创建位置感知Web应用程序】在日常生活中，我们都离不开位置识别类应用程序。Foursquare、Facebook等应用程序帮助我们和我们的家人朋友分享当前位置。而像Google Local这样的应用则帮助我们找到当前位置附近有哪些自己需要的服务设施或业务场所。【如何利用HTML5与MongoDB创建位置感知Web应用程序】在日常生活中，我们都离不开位置识别类应用程序。Foursquare、Facebook等应用程序帮助我们和我们的家人朋友分享当前位置。而像Google Local这样的应用则帮助我们找到当前位置附近有哪些自己需要的服务设施或业务场所。【如何利用HTML5与MongoDB创建位置感知Web应用程序】在日常生活中，我们都离不开位置识别类应用程序。Foursquare、Facebook等应用程序帮助我们和我们的家人朋友分享当前位置。而像Google Local这样的应用则帮助我们找到当前位置附近有哪些自己需要的服务设施或业务场所。"));
        MemberChangeBaseInfoRoot root = new MemberChangeBaseInfoRoot();
        root = (MemberChangeBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_UPD_ADDRESS_FORMATTER_ERROR, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("nickname", "俞德馨"));
        list.add(new BasicNameValuePair("sex", "M"));
        list.add(new BasicNameValuePair("birthday", "2013-08-26"));
        list.add(new BasicNameValuePair("idtype", ""));
        list.add(new BasicNameValuePair("idno", ""));
        list.add(new BasicNameValuePair("phone", ""));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", ""));
        MemberChangeBaseInfoRoot root = new MemberChangeBaseInfoRoot();
        root = (MemberChangeBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("修改基本信息失败", root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "01822FUO9AQTK6Q00C5V3IBJ43P1R5JO"));
        list.add(new BasicNameValuePair("sessionid", "0182CTKI7NC9M1K0038K1OSXUXJ1T6J4"));
        list.add(new BasicNameValuePair("nickname", "俞德馨1"));
        list.add(new BasicNameValuePair("sex", "M"));
        list.add(new BasicNameValuePair("birthday", "1988-05-05"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "230205198805050016"));
        list.add(new BasicNameValuePair("phone", ""));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", ""));
        MemberChangeBaseInfoRoot root = new MemberChangeBaseInfoRoot();
        root = (MemberChangeBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("用户更改基本信息成功", root.getMsg().trim());
    }

}
