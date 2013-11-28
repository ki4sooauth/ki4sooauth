package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.moba14.transform.UpdateMemberBaseInfoRoot;

public class MOBA14Test extends TestCase
{

    String interfaceCode = "moba14";//接口编码

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
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "Rose"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", ""));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", ""));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
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
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "Rose"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", ""));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", ""));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
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
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "Rose"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", ""));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", ""));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 未登录
     */
    public void testNotLogin()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "121"));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "Rose"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", ""));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", ""));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_PLEASE_LOGIN, root.getMsg().trim());
    }

    /**
     * 姓名格式不正确
     */
    public void testNameFormatterError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "伍凝云is a clever chinese country girl"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", ""));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", ""));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_NAME_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 性别信息不正确
     */
    public void testSexFormatterError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "伍凝云"));
        list.add(new BasicNameValuePair("sex", "FF"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", ""));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", ""));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_SEX_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 证件类型信息不正确
     */
    public void testIdTypeFormatterError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "伍凝云"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "yty"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", ""));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", ""));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_IDTYPE_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 证件号码信息不正确
     */
    public void testIdNoFormatterError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "伍凝云"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101343"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", ""));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", ""));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_IDNO_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 出生日期信息不正确
     */
    public void testBirthdayFormatterError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "伍凝云"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-09-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", ""));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", ""));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_BIRTHDAY_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 手机号码格式不正确
     */
    public void testPhoneFormatterError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "伍凝云"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "132110125333434"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", ""));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", ""));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_PHONE_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 联系电话格式不正确
     */
    public void testTelPhoneFormatterError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "伍凝云"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311xds"));
        list.add(new BasicNameValuePair("email", ""));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", ""));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_TELPHONE_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 邮政编码格式不正确
     */
    public void testPostCodeFormatterError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "伍凝云"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", ""));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("postcode", "1000008787io"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", ""));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_POSTCODE_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 地址格式不正确
     */
    public void testAddressFormatterError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "伍凝云"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", ""));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", ""));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_ADDRESS_FORMATTER_ERROR, root.getMsg().trim());

    }

    /**
     * 邮箱格式不正确
     */
    public void testEmailFormatterError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "伍凝云"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", "343"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", ""));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_EMAIL_FORMATTER_ERROR, root.getMsg().trim());

    }

    /**
     * 邮箱格式不正确
     */
    public void testMemberSpecialInfoError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "Tonny"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", "tonny@126.com"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", "[{\"featurecode\":\"\",\"featurename\":\"职业\",\"featurevalue\":\"知识分子\"},{\"featurecode\":\"XB\",\"featurename\":\"性别\",\"featurevalue\":\"女\"}]"));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_MEMBER_FEATURE_INFO_FORMATTER_ERROR, root.getMsg().trim());

    }

    /**
     * 修改会员信息成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "Tonny"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", "tonny@126.com"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", "[{\"featurecode\":\"ZY\",\"featurename\":\"职业\",\"featurevalue\":\"工人\"},{\"featurecode\":\"XB\",\"featurename\":\"性别\",\"featurevalue\":\"女\"},{\"featurecode\":\"XL\",\"featurename\":\"学历\",\"featurevalue\":\"本科\"}]"));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_UPD_MEMBER_INFO_SUCCESS, root.getMsg().trim());
    }

    /**
     * 修改会员信息失败
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISW4540JGT"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("name", "Rose"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("idtype", "00"));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("telephone", "010-62442311"));
        list.add(new BasicNameValuePair("email", ""));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("memberspecialinfo", ""));
        UpdateMemberBaseInfoRoot root = new UpdateMemberBaseInfoRoot();
        root = (UpdateMemberBaseInfoRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_UPD_MEMBER_INFO_FAIL, root.getMsg().trim());
    }
}
