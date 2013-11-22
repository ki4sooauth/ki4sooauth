package com.gooagoo.mobile.api.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.user.app.AppFeedbackCoreService;
import com.gooagoo.api.business.core.user.app.AppSerialNumberCoreService;
import com.gooagoo.api.business.core.user.manage.UserActiveCodeCoreService;
import com.gooagoo.api.business.core.user.manage.UserCoreService;
import com.gooagoo.api.business.core.user.manage.UserLoginCoreService;
import com.gooagoo.api.business.core.user.manage.UserPasswordCoreService;
import com.gooagoo.api.business.core.user.manage.UserRegisterCoreService;
import com.gooagoo.api.business.query.user.query.UserQueryService;
import com.gooagoo.api.generator.query.sys.MobileVersionGeneratorQueryService;
import com.gooagoo.common.jms.JmsUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.user.UserDetailInfo;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;
import com.gooagoo.entity.generator.behave.UserFeedback;
import com.gooagoo.entity.generator.sys.MobileVersion;
import com.gooagoo.entity.generator.sys.MobileVersionExample;
import com.gooagoo.entity.generator.user.ProductSerialNumber;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserMobileInfo;
import com.gooagoo.entity.generator.user.UserProfile;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.entity.push.EmailVo;
import com.gooagoo.entity.push.Message;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CommonMobileService;
import com.gooagoo.mobile.api.InfoSetMobileService;
import com.gooagoo.mobile.common.EmailUtils;
import com.gooagoo.mobile.common.InterfaceUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.entity.mobf01.transform.Login;
import com.gooagoo.mobile.entity.mobf01.transform.MemberLoginRoot;
import com.gooagoo.mobile.entity.mobf06.transform.UserInfoRoot;
import com.gooagoo.mobile.entity.mobf06.transform.Userinfo;
import com.gooagoo.mobile.entity.mobf11.transform.UpdateAppInfoRoot;
import com.gooagoo.mobile.entity.mobf11.transform.Versionlist;
import com.google.gson.Gson;

@Service
public class InfoSetMobileServiceImpl implements InfoSetMobileService
{
    @Autowired
    private UserLoginCoreService userLoginCoreService;
    @Autowired
    private CommonMobileService commonMobileService;
    @Autowired
    private UserCoreService userCoreService;
    @Autowired
    private UserPasswordCoreService userPasswordCoreService;
    @Autowired
    private UserQueryService userQueryService;
    @Autowired
    private AppFeedbackCoreService appFeedbackCoreService;
    @Autowired
    private AppSerialNumberCoreService appSerialNumberCoreService;
    @Autowired
    private UserRegisterCoreService userRegisterCoreService;
    @Autowired
    private UserActiveCodeCoreService userActiveCodeCoreService;
    @Autowired
    private MobileVersionGeneratorQueryService mobileVersionGeneratorQueryService;
    @Autowired
    private JmsTemplate emailTemplate;
    @Autowired
    private ActiveMQQueue emailDestination;
    @Autowired
    private JmsTemplate messageTemplate;
    @Autowired
    private ActiveMQQueue messageDestination;

    @Override
    public MemberLoginRoot userLogin(String account, String password, String mac, String mver, String iphonetoken) throws Exception
    {
        GooagooLog.info("userLogin-->入参:account=" + account + ",password=" + password + ",mac" + mac + ",mver" + mver + ",iphonetoken" + iphonetoken);
        //1.根据参数，封装数据库层用户移动终端信息
        UserMobileInfo userMobileInfo = new UserMobileInfo();
        userMobileInfo.setMacAddress(mac);
        userMobileInfo.setIphoneToken(iphonetoken);
        userMobileInfo.setMVer(mver);
        //2.根据参数，查询数据库层个人用户详细信息表，组合个人用户信息，用户辅助信息，用户移动终端信息
        PersonalLoginInfo personalLoginInfo = this.userLoginCoreService.login(account, password, userMobileInfo, null);
        GooagooLog.debug("查询到返回的用户登录信息为：" + new Gson().toJson(personalLoginInfo));

        //3.封装业务层用户信息
        Login login = new Login();
        //无卡刷卡卡号规则：999999+8位唯一标识（userinfo表的usernum字段）+02，无卡刷卡只用于拿账单
        String scardno = "999999" + personalLoginInfo.getPersonalInfo().getUserNum() + "02";

        GooagooLog.info("无卡刷卡卡号：scardno=" + scardno);

        login.setScardno(scardno);

        login.setSessionid(personalLoginInfo.getPersonalMobileInfo().getSessionid());
        login.setUserid(personalLoginInfo.getPersonalInfo().getUserId());

        //4.将业务层用户信息，组合到业务层用户登录
        MemberLoginRoot memberLoginRoot = new MemberLoginRoot();
        memberLoginRoot.setLogin(login);
        return memberLoginRoot;
    }

    @Override
    public boolean userForgetPassword(String email) throws Exception
    {
        GooagooLog.info("userForgetPassword-->入参:email=" + email);
        return false;
    }

    @Override
    public boolean userRegister(String email, String password, String mac, String mver, String regIp) throws Exception
    {
        GooagooLog.info("userRegister-->入参:email=" + email + " ,password=" + password + " ,mac=" + mac + " ,mver=" + mver + " ,regIp=" + regIp);
        //1.根据参数，封装数据库层个人用户表

        //用户基本信息
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(email);
        userInfo.setPassword(password);
        userInfo.setUserType("M");

        //用户明细信息
        UserProfile userProfile = new UserProfile();
        userProfile.setRegIp(regIp);

        //2.封装数据库层用户移动终端信息
        UserMobileInfo userMobileInfo = new UserMobileInfo();
        userMobileInfo.setMVer(mver);
        userMobileInfo.setMacAddress(mac);

        //3.注册信息入库
        String activeCode = UUID.getUUID();//激活码
        boolean bool = this.userRegisterCoreService.register(activeCode, userInfo, userProfile, userMobileInfo);
        if (!bool)
        {
            GooagooLog.warn("用户注册失败");
            throw new MessageException(MessageConst.MOBILE_SET_REGIST_FAIL);

        }
        //4.发激活邮件
        GooagooMessage<EmailVo> gooagooMessage = EmailUtils.sendActiveEmail(email, activeCode);
        JmsUtils.send(this.emailTemplate, this.emailDestination, gooagooMessage);
        return true;
    }

    @Override
    public boolean changePassword(String userId, String sessionId, String oldPassword, String newPassword) throws Exception
    {
        GooagooLog.info("changePassword-->入参:userId=" + userId + ",sessionId=" + sessionId + ",oldPassword" + oldPassword + ",newPassword" + newPassword);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.根据参数修改密码
        boolean bool = this.userPasswordCoreService.updatePassword(null, userId, oldPassword, newPassword);
        if (!bool)
        {
            GooagooLog.warn("修改密码失败");
            throw new MessageException(MessageConst.MOBILE_SET_UPD_PASSWORD_FAIL);
        }
        return true;
    }

    @Override
    public boolean userChangeBaseInfo(String userId, String sessionId, HttpServletRequest request) throws Exception
    {
        //获取传入参数
        Parameter parameter = InterfaceUtils.collectParameter(request);
        GooagooLog.info("userChangeBaseInfo-->入参:userId=" + userId + ",sessionId=" + sessionId + ",request=【" + new Gson().toJson(parameter) + "】");
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);

        //2.封装用户辅助信息
        UserProfile userProfile = new UserProfile();
        if (StringUtils.hasText(parameter.getString("birthday")))
        {
            userProfile.setBirthday(TimeUtils.convertStringToDate(parameter.getString("birthday")));
        }

        userProfile.setAddress(parameter.getString("address"));
        userProfile.setIdNo(parameter.getString("idno"));
        userProfile.setIdType(parameter.getString("idtype"));
        userProfile.setIsAllowFriend(parameter.getString("isallowfriend"));
        userProfile.setPostCode(parameter.getString("postcode"));
        userProfile.setSex(parameter.getString("sex"));
        userProfile.setTelephone(parameter.getString("phone"));
        userProfile.setRealName(parameter.getString("nickname"));
        userProfile.setUserId(userId);
        //3.根据数据库层用户辅助信息，修改用户辅助信息
        boolean bool = this.userCoreService.updateUserProfile(null, userProfile);//基本信息==辅助信息吗
        if (!bool)
        {
            GooagooLog.warn("修改用户基本信息失败");
            throw new MessageException(MessageConst.MOBILE_SET_UPD_BASEINFO_FAIL);
        }
        return true;
    }

    @Override
    public UserInfoRoot getUserInfo(String userId, String sessionId) throws Exception
    {
        GooagooLog.info("getUserInfo-->入参:userId=" + userId + ",sessionId=" + sessionId);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.查询数据库层的个人信息
        UserDetailInfo userDetailInfo = this.userQueryService.findUserInfo(userId);
        Userinfo userinfo = null;
        if (userDetailInfo != null)
        {
            UserProfile userProfile = userDetailInfo.getUserProfile();
            //3.封装业务层用户基本信息
            userinfo = new Userinfo();
            userinfo.setAddress(userProfile.getAddress());
            userinfo.setBirthday(userProfile.getBirthday() != null ? TimeUtils.convertDateToString(userProfile.getBirthday(), TimeUtils.FORMAT2) : null);
            userinfo.setIdno(userProfile.getIdNo());
            userinfo.setIdtype(userProfile.getIdType());
            userinfo.setIsallowfriend(userProfile.getIsAllowFriend());
            UserInfo userInfo = userDetailInfo.getUserInfo();
            userinfo.setNickname(userInfo != null ? userInfo.getAccount() : "");

            userinfo.setPhone(userProfile.getTelephone());
            userinfo.setPostcode(userProfile.getPostCode());
            userinfo.setRealname(userProfile.getRealName());
            userinfo.setSex(userProfile.getSex());
        }

        //4.将业务层用户基本信息 ，组合到业务层用户获取基本信息
        UserInfoRoot userInfoRoot = new UserInfoRoot();
        userInfoRoot.setUserinfo(userinfo);

        return userInfoRoot;
    }

    @Override
    public boolean feedback(String userId, String sessionId, String content, String mac, String mVer, String mType, String ip, String hostName) throws Exception
    {
        GooagooLog.info("feedback-->入参:userId=" + userId + ",sessionId=" + sessionId + ",content=" + content + ",mac=" + mac + ",mVer=" + mVer + ",mType=" + mType + ",ip=" + ip + ",hostName=" + hostName);
        //1.用户登录校验
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.封装数据库层 用户反馈，收集用户对gooagooAPP的使用反馈
        UserFeedback userFeedback = new UserFeedback();
        userFeedback.setUserId(userId);
        userFeedback.setIpAddress(ip);
        userFeedback.setHostName(hostName);
        userFeedback.setMacAddress(mac);
        userFeedback.setPhoneType(mType);
        userFeedback.setVersion(mVer);
        userFeedback.setContent(content);
        userFeedback.setIsDel("N");
        //3.将封装数据，手机APP产品意见反馈入库
        boolean bool = this.appFeedbackCoreService.appFeedback(userFeedback);
        if (!bool)
        {
            GooagooLog.warn("意见反馈失败");
            throw new MessageException(MessageConst.MOBILE_SET_FEEDBACK_FAIL);
        }
        return true;

    }

    @Override
    public String getGooagooId(String mac, String mId, String mVer, String mType) throws Exception
    {
        GooagooLog.info("getGooagooId-->入参:mac=" + mac);
        //1.封装数据库层产品序列号信息
        ProductSerialNumber productSerialNumber = new ProductSerialNumber();
        productSerialNumber.setMacAddress(mac);
        productSerialNumber.setMId(mId);
        productSerialNumber.setMType(mType);
        productSerialNumber.setMVer(mVer);

        //2.根据产品序列号信息，在数据库层获得手机APP序列号分配
        String goooagooId = this.appSerialNumberCoreService.appSerialNumber(productSerialNumber);
        if (!StringUtils.hasText(goooagooId))
        {
            GooagooLog.warn("手机APP序列号分配失败");
            throw new MessageException(MessageConst.MOBILE_SET_GET_GOOAGOOID_FAIL);
        }
        return goooagooId;
    }

    @Override
    public String getPhoneVerifycode(String phone) throws Exception
    {
        GooagooLog.info("getPhoneVerifycode-->入参:phone=" + phone);
        //1.根据手机号，获取短信验证码
        String mActiveCode = this.userActiveCodeCoreService.getMobileActiveCode(phone);
        GooagooLog.warn("获取到的短信验证码为：【mActiveCode= " + mActiveCode + "】");
        if (!StringUtils.hasText(mActiveCode))
        {

            throw new MessageException(MessageConst.MOBILE_SET_GET_SHORTMESSAGE_VERIFYCODE_FAIL);
        }
        //2.发送短信验证码
        GooagooMessage<Message> gooagooMessage = EmailUtils.sendRisterCodeMessage(phone, mActiveCode);
        JmsUtils.send(this.messageTemplate, this.messageDestination, gooagooMessage);
        return mActiveCode;
    }

    @Override
    public boolean checkVerifycode(String phone, String password, String verifycode, String mac, String mver, String regIp) throws Exception
    {
        GooagooLog.info("checkVerifycode-->入参:phone=" + phone + "password=" + password + "verifycode=" + verifycode);

        //1.根据参数，封装数据库层个人用户表
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword(password);
        userInfo.setMobile(phone);
        userInfo.setUserType("M");

        UserProfile userProfile = new UserProfile();
        userProfile.setTelephone(phone);
        userProfile.setRegIp(regIp);//注册ip地址

        //2.封装数据库层用户移动终端信息
        UserMobileInfo userMobileInfo = new UserMobileInfo();
        userMobileInfo.setMVer(mver);
        userMobileInfo.setMacAddress(mac);
        //3.封装数据入库
        boolean bool = this.userRegisterCoreService.register(verifycode, userInfo, userProfile, userMobileInfo);
        if (!bool)
        {
            GooagooLog.warn("手机号注册失败");
            throw new MessageException(MessageConst.MOBILE_SET_REGIST_FAIL);
        }
        return true;
    }

    @Override
    public UpdateAppInfoRoot getUpdateAppInfo(String appCode, String version, String mobileType) throws Exception
    {
        GooagooLog.info("getUpdateAppInfo-->入参:【appCode=" + appCode + "version=" + version + "mobileType=" + mobileType + "】");

        MobileVersionExample mobileVersionExample = new MobileVersionExample();
        mobileVersionExample.setPage(1, 1);
        mobileVersionExample.setOrderByClause("version DESC");
        mobileVersionExample.createCriteria().andAppCodeEqualTo(appCode).andMobileTypeEqualTo(mobileType).andIsDelEqualTo("N");
        List<MobileVersion> mobileVersionList = this.mobileVersionGeneratorQueryService.selectByExample(mobileVersionExample);
        Versionlist versionlist = null;
        if (CollectionUtils.isNotEmpty(mobileVersionList))
        {

            MobileVersion mobileVersion = mobileVersionList.get(0);
            if (Double.valueOf(mobileVersion.getVersion()) > Double.valueOf(version))
            {
                versionlist = new Versionlist();
                versionlist.setAppcode(mobileVersion.getAppCode());
                versionlist.setMobiletype(mobileVersion.getMobileType());
                versionlist.setVersioncode(mobileVersion.getVersion());
                versionlist.setVersionname(mobileVersion.getVersionName());
                versionlist.setPlatform(mobileVersion.getPlatform());
                versionlist.setNote(mobileVersion.getNote());
                versionlist.setDownloadurl(mobileVersion.getLink());
                versionlist.setCreatetime(TimeUtils.convertDateToString(mobileVersion.getCreateTime(), TimeUtils.FORMAT1));
            }
            else
            {
                GooagooLog.warn("Gooagoo App已经最新版本,无需更新【无appCode=" + appCode + ",mobileType=" + mobileType + ",version > " + version + " Gooagoo App 版本信息】");
                throw new MessageException(MessageConst.MOBILE_SET_APP_IS_THE_LAST_VERSION);
            }

        }
        else
        {
            GooagooLog.warn("Gooagoo App已经最新版本,无需更新【无appCode=" + appCode + ",mobileType=" + mobileType + ",version > " + version + " Gooagoo App 版本信息】");
            throw new MessageException(MessageConst.MOBILE_SET_APP_IS_THE_LAST_VERSION);
        }
        UpdateAppInfoRoot root = new UpdateAppInfoRoot();
        root.setVersionlist(versionlist);
        return root;
    }
}
