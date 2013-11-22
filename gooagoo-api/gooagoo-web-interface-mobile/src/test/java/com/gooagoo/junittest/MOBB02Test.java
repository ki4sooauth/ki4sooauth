package com.gooagoo.junittest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.mobile.entity.mobb02.transform.AddFavoriteRoot;

public class MOBB02Test extends TestCase
{

    String interfaceCode = "mobb02";//接口编码

    private static GetLoginInfo getLoginInfo = new GetLoginInfo();

    /**
     * 用户编号不能为空
     * @throws Exception 
     */
    public void testUseridIsNull() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", ""));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "G"));
        list.add(new BasicNameValuePair("shopadid", "454"));
        list.add(new BasicNameValuePair("adurl", UrlUtils.getGoodsUrl("01822TIHISRNTBT07GRNHGEIISWR2K8D")));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_USERID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 用户sessionid不能为空
     * @throws Exception 
     */
    public void testSessionidIsNull() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", ""));
        list.add(new BasicNameValuePair("adtype", "G"));
        list.add(new BasicNameValuePair("shopadid", "454"));
        list.add(new BasicNameValuePair("adurl", UrlUtils.getGoodsUrl("01822TIHISRNTBT07GRNHGEIISWR2K8D")));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SESSIONID_IS_NULL, root.getMsg().trim());
    }

    /**
     * 收藏信息id和收藏信息url两者必填其一
     */
    public void testAdurlAndshopadIdIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "G"));
        list.add(new BasicNameValuePair("shopadid", ""));
        list.add(new BasicNameValuePair("adurl", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SHOPADID_AND_ADURL_IS_NULL, root.getMsg().trim());
    }

    /**
     * 收藏信息id不为空时，收藏信息类型必填
     */
    public void testAdtypeAndshopadIdIsNull()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", ""));
        list.add(new BasicNameValuePair("shopadid", "45"));
        list.add(new BasicNameValuePair("adurl", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SHOPADID_HAVE_VALUE_ADTYPE_IS_NULL, root.getMsg().trim());
    }

    /**
     * 未登陆
     */
    public void testNotLogin()
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", "121"));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", ""));
        list.add(new BasicNameValuePair("shopadid", "45"));
        list.add(new BasicNameValuePair("adurl", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_PARAMETER_SHOPADID_HAVE_VALUE_ADTYPE_IS_NULL, root.getMsg().trim());
    }

    /**
     * 收藏商品信息不存在或已删除异常
     * @throws Exception 
     */
    public void testGoodsInfoNotExist() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "G"));
        list.add(new BasicNameValuePair("shopadid", "44"));
        list.add(new BasicNameValuePair("adurl", UrlUtils.getGoodsUrl("01822TIHIerrSRNTBT07GRNHGEIISWR2K8D")));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_STORE_INFO_DEL_OR_NOT_EXIST, root.getMsg().trim());
    }

    /**
     * 通过商品url收藏商品成功
     * @throws Exception 
     */
    public void testSuccessByGoodsUrl() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "G"));
        list.add(new BasicNameValuePair("shopadid", "01822ULKU4QEI5607GRNHNEIISWR2K8D"));
        list.add(new BasicNameValuePair("adurl", UrlUtils.getGoodsUrl("01822TIHISRNTBT07GRNHGEIISWR2K8D")));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals("收藏成功", root.getMsg().trim());
    }

    /**
     * 通过商品id收藏商品成功
     * @throws Exception 
     */
    public void testSuccessByGoodsId() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "G"));
        list.add(new BasicNameValuePair("shopadid", "01822ULKU4QEI5607GRNHNEIISWR2K8D"));
        list.add(new BasicNameValuePair("adurl", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_STORE_SUCCESS, root.getMsg().trim());
    }

    /**
     * 通过商品id收藏商品失败
     * @throws Exception 
     */
    public void testErrorByGoodsId() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "GX"));
        list.add(new BasicNameValuePair("shopadid", "01822ULKU4QEI5607GRNHNEIISWR2K8D"));
        list.add(new BasicNameValuePair("adurl", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_STORE_FAIL, root.getMsg().trim());
    }

    /**
     * 已经收藏过此商品
     * @throws Exception 
     */
    public void testAlreadyStoreGoods() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "G"));
        list.add(new BasicNameValuePair("shopadid", "44"));
        list.add(new BasicNameValuePair("adurl", UrlUtils.getGoodsUrl("01822TIHISRNTBT07GRNHGEIISWR2K8D")));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_ALREADY_STORE, root.getMsg().trim());
    }

    /**
     * 通过活动编号收藏活动成功
     * @throws Exception 
     */
    public void testSuccessByActiveId() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "A"));
        list.add(new BasicNameValuePair("shopadid", "0182HV9A8PHM2LH0U2LBV5EIISWR2647"));
        list.add(new BasicNameValuePair("adurl", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_STORE_SUCCESS, root.getMsg().trim());
    }

    /**
     * 通过活动url收藏活动成功
     * @throws Exception 
     */
    public void testSuccessByActiveUrl() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", ""));
        list.add(new BasicNameValuePair("shopadid", ""));
        list.add(new BasicNameValuePair("adurl", UrlUtils.getActiveUrl("0182AIEG0LNI34H0NCQU1KEIISWR2HCH")));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_STORE_SUCCESS, root.getMsg().trim());
    }

    /**
     * 已经收藏过此活动
     * @throws Exception 
     */
    public void testAlreadyStoreActive() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "A"));
        list.add(new BasicNameValuePair("shopadid", "0182HV9A8PHM2LH0U2LBV5EIISWR2647"));
        list.add(new BasicNameValuePair("adurl", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_ALREADY_STORE, root.getMsg().trim());
    }

    /**
     * 收藏活动信息不存在或已删除异常
     * @throws Exception 
     */
    public void testActivityInfoNotExist() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "A"));
        list.add(new BasicNameValuePair("shopadid", "44"));
        list.add(new BasicNameValuePair("adurl", UrlUtils.getGoodsUrl("01822TIHIerrSRNTBT07GRNHGEIISWR2K8D")));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_STORE_INFO_DEL_OR_NOT_EXIST, root.getMsg().trim());
    }

    /**
     * 通过活动id收藏活动失败
     * @throws Exception 
     */
    public void testErrorByActivityId() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "AX"));
        list.add(new BasicNameValuePair("shopadid", "0182HV9A8PHM2LH0U2LBV5yEIISWR2647"));
        list.add(new BasicNameValuePair("adurl", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_STORE_FAIL, root.getMsg().trim());
    }

    /**
     * 通过活动id收藏活动失败(未发布)
     * @throws Exception 
     */
    public void testErrorByActivityUrl() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", ""));
        list.add(new BasicNameValuePair("shopadid", ""));
        list.add(new BasicNameValuePair("adurl", UrlUtils.getActiveUrl("01822T37IKVM1B2005FH43J4VOR9U4BO")));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_STORE_FAIL, root.getMsg().trim());
    }

    /**
     * 通过优惠券编号收藏优惠券成功(精确投放)
     * @throws Exception 
     */
    public void testSuccessByCouponId() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "C"));
        list.add(new BasicNameValuePair("shopadid", "0182AUMT4ILBO1J0SR22DDEIISWR2K1N"));
        list.add(new BasicNameValuePair("adurl", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_STORE_SUCCESS, root.getMsg().trim());
    }

    /**
     * 通过优惠券url收藏优惠券成功
     * @throws Exception 
     */
    public void testSuccessByCouponUrl() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", ""));
        list.add(new BasicNameValuePair("shopadid", ""));
        list.add(new BasicNameValuePair("adurl", UrlUtils.getCouponUrl("0182AUMT4ILBO1J0SR22DDEIISWR2K1N")));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_STORE_SUCCESS, root.getMsg().trim());
    }

    /**
     * 用户收藏优惠券个数已达到最大拥有个数(收藏广场)
     * @throws Exception 
     */
    public void testAlreadyOverOwnStoreCouponNums() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "C"));
        list.add(new BasicNameValuePair("shopadid", "0182AUMT4ILBO1J0SR22DDEIISWR2K1N"));
        list.add(new BasicNameValuePair("adurl", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_STORE_NUM_EXCEED_MAX_OWN_NUMS, root.getMsg().trim());
    }

    /**
     * 用户收藏优惠券个数已达到商家发放数量上限（优惠券已发放完毕）
     * @throws Exception 
     */
    public void testAlreadyArriveShopGiveCouponNums() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "C"));
        list.add(new BasicNameValuePair("shopadid", "0182AUMT4ILBO1J0SR22DDEIISWR2K1N"));
        list.add(new BasicNameValuePair("adurl", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_STORE_COUPON_FINISH_GIVING, root.getMsg().trim());
    }

    /**
     * 用户收藏优惠券个数已达到商家发放数量上限（优惠券已发放完毕）
     * @throws Exception 
     */
    public void testCouponAlreadyOverPublishEndTime() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "C"));
        list.add(new BasicNameValuePair("shopadid", "0182A35AA0ET00O02VLL3VEIISWR2TKG"));
        list.add(new BasicNameValuePair("adurl", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_EXCEED_PUBLISH_END_TIME, root.getMsg().trim());
    }

    /**
     * 收藏优惠券信息不存在或已删除异常
     * @throws Exception 
     */
    public void testCouponInfoNotExist() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", ""));
        list.add(new BasicNameValuePair("shopadid", ""));
        list.add(new BasicNameValuePair("adurl", UrlUtils.getGoodsUrl("01822TIHIerrSRNTBT07GRNHGEIISWR2K8D")));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_STORE_INFO_DEL_OR_NOT_EXIST, root.getMsg().trim());
    }

    /**
     * 通过优惠券id收藏优惠券失败
     * @throws Exception 
     */
    public void testErrorByCouponId() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", "CX"));
        list.add(new BasicNameValuePair("shopadid", "0182ABHRCUQ1CLI0NCQU19EIISWR2HCH"));
        list.add(new BasicNameValuePair("adurl", ""));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_STORE_FAIL, root.getMsg().trim());
    }

    /**
     * 通过优惠券id收藏优惠券失败(未发布)
     * @throws Exception 
     */
    public void testErrorByCouponUrl() throws Exception
    {
        List<NameValuePair> list = new ArrayList<NameValuePair>();//传入参数
        list.add(new BasicNameValuePair("userid", getLoginInfo.getUserId()));
        list.add(new BasicNameValuePair("sessionid", getLoginInfo.getSessionId()));
        list.add(new BasicNameValuePair("adtype", ""));
        list.add(new BasicNameValuePair("shopadid", ""));
        list.add(new BasicNameValuePair("adurl", UrlUtils.getCouponUrl("0182ABHRCUQ1CLI0NCQU19EIISWR2HCH")));
        list.add(new BasicNameValuePair("mac", getLoginInfo.getMacAddress()));
        list.add(new BasicNameValuePair("mver", getLoginInfo.getmVer()));
        list.add(new BasicNameValuePair("lid", getLoginInfo.getLid()));
        list.add(new BasicNameValuePair("entityposition", getLoginInfo.getEntityposition()));
        AddFavoriteRoot root = new AddFavoriteRoot();
        root = (AddFavoriteRoot) HttpClientUtils.HttpPost(list, root, this.interfaceCode);
        Assert.assertEquals(MessageTestConst.MOBILE_FAVORIATE_STORE_FAIL, root.getMsg().trim());
    }

    //SELECT * from favorite_info where object_id in('01822TIHISRNTBT07GRNHGEIISWR2K8D','01822ULKU4QEI5607GRNHNEIISWR2K8D','0182HV9A8PHM2LH0U2LBV5EIISWR2647','0182AIEG0LNI34H0NCQU1KEIISWR2HCH','0182AUMT4ILBO1J0SR22DDEIISWR2K1N') and info_type='C'

    /*
     * SELECT * from favorite_info where object_id in('01822TIHISRNTBT07GRNHGEIISWR2K8D','01822ULKU4QEI5607GRNHNEIISWR2K8D','0182HV9A8PHM2LH0U2LBV5EIISWR2647','0182AIEG0LNI34H0NCQU1KEIISWR2HCH','0182AUMT4ILBO1J0SR22DDEIISWR2K1N') 


    SELECT * from gooagoo_marketing.marketing_activity;


    SELECT * from gooagoo_marketing.coupon where publish_status='P' and coupon_id='0182AUMT4ILBO1J0SR22DDEIISWR2K1N'

    SELECT * from gooagoo_marketing.coupon where publish_status!='P'

    SELECT * from favorite_info where user_id='01822N0IJLPA8N700C5V4PBJ43P1R5JO' and info_type='C' AND favorite_id in('0182URETBV5EIL200100Q1SXUXJ1T7H8','0182URQHCL68KDS00100QBSXUXJ1T7H8')

     */
}
