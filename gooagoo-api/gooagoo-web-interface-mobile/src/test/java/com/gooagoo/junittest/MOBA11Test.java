package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.mobile.entity.moba11.transform.PhysicToElecCardRoot;

public class MOBA11Test extends TestCase
{

    String interfaceCode = "moba11";//接口编码

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
        list.add(new BasicNameValuePair("phyno", "1000000000000212"));
        list.add(new BasicNameValuePair("mobile", "18201143326"));
        list.add(new BasicNameValuePair("idno", "440901199006249711"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        PhysicToElecCardRoot root = new PhysicToElecCardRoot();
        root = (PhysicToElecCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 用户sessionid不能为空
     */
    public void testSessionidIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("phyno", "1000000000000212"));
        list.add(new BasicNameValuePair("mobile", "18201143326"));
        list.add(new BasicNameValuePair("idno", "440901199006249711"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        PhysicToElecCardRoot root = new PhysicToElecCardRoot();
        root = (PhysicToElecCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
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
        list.add(new BasicNameValuePair("phyno", "1000000000000212"));
        list.add(new BasicNameValuePair("mobile", "13667452201"));
        list.add(new BasicNameValuePair("idno", "430381197204233436"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        PhysicToElecCardRoot root = new PhysicToElecCardRoot();
        root = (PhysicToElecCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SHOPID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 物理卡号不能为空
     */
    public void testPhynoIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("phyno", ""));
        list.add(new BasicNameValuePair("mobile", "18201143326"));
        list.add(new BasicNameValuePair("idno", "440901199006249711"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        PhysicToElecCardRoot root = new PhysicToElecCardRoot();
        root = (PhysicToElecCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PHYNO_IS_NULL, root.getMsg().trim());
    }

    /**
     * 手机号和证件号不能同时为空不能为空
     */
    public void testMobileIsAndIdnoNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("phyno", "1000000000000212"));
        list.add(new BasicNameValuePair("mobile", ""));
        list.add(new BasicNameValuePair("idno", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        PhysicToElecCardRoot root = new PhysicToElecCardRoot();
        root = (PhysicToElecCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_PHONE_AND_IDNO_IS_NULL, root.getMsg().trim());
    }

    /**
     * 物理卡转换电子卡成功
     */
    public void testSuccess()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("phyno", "1000000000000212"));
        list.add(new BasicNameValuePair("mobile", "13667452201"));
        list.add(new BasicNameValuePair("idno", "430381197204233436"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        PhysicToElecCardRoot root = new PhysicToElecCardRoot();
        root = (PhysicToElecCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_PHYCARD_CHANGE_ELEC_CARD_SUCCESS, root.getMsg().trim());
    }

    /**
     * 已经提交过物理卡转换电子卡申请
     */
    public void testAlreadySubmitApply()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("phyno", "1000000000000212"));
        list.add(new BasicNameValuePair("mobile", "13667452201"));
        list.add(new BasicNameValuePair("idno", "430381197204233436"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        PhysicToElecCardRoot root = new PhysicToElecCardRoot();
        root = (PhysicToElecCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_ALREADY_SUBMIT_APPLY, root.getMsg().trim());
    }

    /**
     * 物理卡转换电子卡失败
     */
    public void testError()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("shopid", "01822IE57DH111M085QBPFEIISWR0JGT"));
        list.add(new BasicNameValuePair("phyno", "1000000000000212"));
        list.add(new BasicNameValuePair("mobile", "18201143326"));
        list.add(new BasicNameValuePair("idno", "440901199006249711"));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        PhysicToElecCardRoot root = new PhysicToElecCardRoot();
        root = (PhysicToElecCardRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_CARDTOP_PHYCARD_CHANGE_ELEC_CARD_FAIL, root.getMsg().trim());
    }
}
