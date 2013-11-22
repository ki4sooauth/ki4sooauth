package com.gooagoo.igus.personal.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.user.manage.UserCoreService;
import com.gooagoo.api.generator.query.user.UserProfileGeneratorQueryService;
import com.gooagoo.cache.AreaCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.user.UserProfile;
import com.gooagoo.igus.personal.service.IPersonalInfoService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.personal.UPersonal;

@Service("iPersonalInfoService")
public class IPersonalInfoServiceImpl implements IPersonalInfoService
{

    @Autowired
    private UserCoreService userCoreService;

    @Autowired
    private UserProfileGeneratorQueryService uerprofile;

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_PERSONALINFO_GETPERSONALINFO)
    public TransData<Object> getPersonalInfo(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            UserProfile userProfile = this.uerprofile.selectByPrimaryKey(userId);
            UPersonal upersoanl = new UPersonal();
            upersoanl.setUserId(userId);
            upersoanl.setSex(userProfile.getSex());
            upersoanl.setBirthday(userProfile.getBirthday());
            upersoanl.setAddress(userProfile.getAddress());
            upersoanl.setHeadPic(FormatDataUtils.formatImageInfo(userProfile.getHeadPic()));
            upersoanl.setIdNo(userProfile.getIdNo());
            upersoanl.setIsAllowFriend(userProfile.getIsAllowFriend());
            upersoanl.setPhone(userProfile.getTelephone());
            upersoanl.setPostCode(userProfile.getPostCode());
            upersoanl.setRealName(userProfile.getRealName());
            upersoanl.setIdType(userProfile.getIdType());
            upersoanl.setProvince(userProfile.getProvince());
            upersoanl.setCity(userProfile.getCity());
            upersoanl.setArea(userProfile.getArea());
            upersoanl.setProincevalue(AreaCache.getSelf(userProfile.getProvince()));
            upersoanl.setCityvalue(AreaCache.getSelf(userProfile.getCity()));
            upersoanl.setAreavalue(AreaCache.getSelf(userProfile.getArea()));
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, upersoanl);

        }
        catch (Exception e)
        {
            GooagooLog.error("查询个人信息：查询个人信息失败", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);//TODO 数据加载成功
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_PERSONALINFO_UPDATEPERSONALINFO)
    public TransData<Object> updatePersonalInfo(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            UserProfile userProfile = ServletUtils.objectMethod(UserProfile.class, request);
            if (StringUtils.isBlank(userProfile.getRealName()))
            {
                userProfile.setRealName("");
            }
            if (StringUtils.isBlank(userProfile.getIdType()))
            {
                userProfile.setIdType("");
            }
            if (StringUtils.isBlank(userProfile.getIdNo()))
            {
                userProfile.setIdNo("");
            }
            if (StringUtils.isBlank(userProfile.getTelephone()))
            {
                userProfile.setTelephone("");
            }
            if (StringUtils.isBlank(userProfile.getProvince()))
            {
                userProfile.setProvince("");
            }
            if (StringUtils.isBlank(userProfile.getCity()))
            {
                userProfile.setCity("");
            }
            if (StringUtils.isBlank(userProfile.getArea()))
            {
                userProfile.setArea("");
            }
            if (StringUtils.isBlank(userProfile.getAddress()))
            {
                userProfile.setAddress("");
            }
            if (StringUtils.isBlank(userProfile.getPostCode()))
            {
                userProfile.setPostCode("");
            }
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String key = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_TOKEN);
            userProfile.setUserId(userId);
            if (!this.userCoreService.updateUserProfile(key, userProfile))
            {
                GooagooLog.info("修改个人信息：修改个人信息失败");
                return new TransData<Object>(false, MessageConst.PERSONAL_IPERSONALINFO_UPDATEPERSONALINFO_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_IPERSONALINFO_UPDATEPERSONALINFO_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("修改个人信息：修改失败", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IPERSONALINFO_UPDATEPERSONALINFO_FAIL, null);
        }
        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.PERSONAL_PERSONALINFO_UPDATEHEADPIC)
    public TransData<Object> updateHeadPic(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String headPic = ServletRequestUtils.getStringParameter(request, "headPic");
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            String key = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_TOKEN);
            if (!this.userCoreService.updateUserHead(key, userId, headPic))
            {
                GooagooLog.info("修改头像：修改头像失败");
                return new TransData<Object>(false, MessageConst.PERSONAL_IPERSONALINFO_UPDATEUEADPIC_FAIL, null);
            }
            transData = new TransData<Object>(true, MessageConst.PERSONAL_IPERSONALINFO_UPDATEUEADPIC_SUCCESS, null);
        }
        catch (Exception e)
        {
            GooagooLog.error("修改头像：修改失败", e);
            transData = new TransData<Object>(false, MessageConst.PERSONAL_IPERSONALINFO_UPDATEUEADPIC_FAIL, null);
        }
        return transData;
    }

}
