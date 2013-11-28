package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.moba01.transform.UserMemberCardRoot;
import com.gooagoo.mobile.entity.moba10.transform.ApplyCardRoot;

public class MOBA10Test extends TestCase
{

    String interfaceCode = "moba10";//接口编码

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
        list.add(new BasicNameValuePair("realname", "Rose"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        ApplyCardRoot root = new ApplyCardRoot();
        root = (ApplyCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
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
        list.add(new BasicNameValuePair("realname", "伍凝云"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        ApplyCardRoot root = new ApplyCardRoot();
        root = (ApplyCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 店铺id不能为空
     */
    public void testShopidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", ""));
        list.add(new BasicNameValuePair("realname", "伍凝云"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        ApplyCardRoot root = new ApplyCardRoot();
        root = (ApplyCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 用户姓名不能为空
     */
    public void testRealnameIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("realname", ""));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        ApplyCardRoot root = new ApplyCardRoot();
        root = (ApplyCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_REALNAME_IS_NULL, root.getMsg().trim());
    }

    /**
     * 手机号、身份证号二选一
     */
    public void testMobileAndIdnoIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("realname", "伍凝云"));
        list.add(new BasicNameValuePair("mobile", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", ""));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        ApplyCardRoot root = new ApplyCardRoot();
        root = (ApplyCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PHONE_AND_IDNO_IS_NULL, root.getMsg().trim());
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
        list.add(new BasicNameValuePair("realname", "伍凝云is a clever chinese country girl"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        ApplyCardRoot root = new ApplyCardRoot();
        root = (ApplyCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
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
        list.add(new BasicNameValuePair("realname", "伍凝云"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("sex", "FF"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        ApplyCardRoot root = new ApplyCardRoot();
        root = (ApplyCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_SEX_FORMATTER_ERROR, root.getMsg().trim());
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
        list.add(new BasicNameValuePair("realname", "伍凝云"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", "6590031980072841010"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        ApplyCardRoot root = new ApplyCardRoot();
        root = (ApplyCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
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
        list.add(new BasicNameValuePair("realname", "伍凝云"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-08-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        ApplyCardRoot root = new ApplyCardRoot();
        root = (ApplyCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
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
        list.add(new BasicNameValuePair("realname", "伍凝云"));
        list.add(new BasicNameValuePair("mobile", "132110125330"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        ApplyCardRoot root = new ApplyCardRoot();
        root = (ApplyCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_PHONE_FORMATTER_ERROR, root.getMsg().trim());
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
        list.add(new BasicNameValuePair("realname", "伍凝云"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "1000000000"));
        ApplyCardRoot root = new ApplyCardRoot();
        root = (ApplyCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_POSTCODE_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 邮政编码格式不正确
     */
    public void testAddressFormatterError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("realname", "伍凝云"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        ApplyCardRoot root = new ApplyCardRoot();
        root = (ApplyCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_ADDRESS_FORMATTER_ERROR, root.getMsg().trim());
    }

    /**
     * 请先登录
     */
    public void testNotLogin()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", "11212"));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("realname", "伍凝云"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        UserMemberCardRoot root = new UserMemberCardRoot();
        root = (UserMemberCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_SET_PLEASE_LOGIN, root.getMsg().trim());
    }

    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("realname", "Rose"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        ApplyCardRoot root = new ApplyCardRoot();
        root = (ApplyCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_SUCCESS, root.getMsg().trim());
    }

    /**
     * 已是商家会员卡
     */
    public void testUserAlreadyShopMember()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("realname", "Rose"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        ApplyCardRoot root = new ApplyCardRoot();
        root = (ApplyCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_ALREADY_IS_SHOP_MEMBER, root.getMsg().trim());
    }

    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0J"));
        list.add(new BasicNameValuePair("realname", "Rose"));
        list.add(new BasicNameValuePair("mobile", "13211012533"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        list.add(new BasicNameValuePair("idno", "659003198007284101"));
        list.add(new BasicNameValuePair("sex", "F"));
        list.add(new BasicNameValuePair("birthday", "1980-07-28"));
        list.add(new BasicNameValuePair("address", "北京市朝阳区"));
        list.add(new BasicNameValuePair("postcode", "100000"));
        ApplyCardRoot root = new ApplyCardRoot();
        root = (ApplyCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_APPLY_ELEC_CARD_FAIL, root.getMsg().trim());
    }

}
