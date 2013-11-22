package com.gooagoo.common.gus.utils;

import org.apache.commons.lang.StringUtils;

import com.gooagoo.entity.casclient.personal.PersonalProfile;

/**
 *  计算个人信息安全等级
 * @author GUS
 *
 */
public class SecurityLevelUtils
{

    /**
     * 是否完善个人基本信息
     * @param personalInfo
     * @return
     */
    public static boolean isCompletePersonalProfile(PersonalProfile personalProfile)
    {
        if (personalProfile == null)
        {
            return false;
        }
        if (StringUtils.isBlank(personalProfile.getRealName()))
        {
            return false;
        }
        if (StringUtils.isBlank(personalProfile.getSex()))
        {
            return false;
        }
        if (personalProfile.getBirthday() == null)
        {
            return false;
        }
        if (StringUtils.isBlank(personalProfile.getIdType()))
        {
            return false;
        }
        if (StringUtils.isBlank(personalProfile.getIdNo()))
        {
            return false;
        }
        if (StringUtils.isBlank(personalProfile.getTelephone()))
        {
            return false;
        }

        return true;
    }

    /**
     *  设置账号安全等级
     * @param account
     * @param serialNum1
     * @param info
     * @param email
     * @param mobile
     * @param question
     * @return
     */
    public static Integer accountSecurityLevels(String account, String serialNum1, String info, String email, String mobile, String question)
    {
        Integer num = 0;
        if (StringUtils.isNotBlank(account))
        {
            num = num + Integer.parseInt(account);
        }
        if (StringUtils.isNotBlank(serialNum1))
        {
            num = num + Integer.parseInt(serialNum1);
        }
        if (StringUtils.isNotBlank(info))
        {
            num = num + Integer.parseInt(info);
        }
        if (StringUtils.isNotBlank(email))
        {
            num = num + Integer.parseInt(email);
        }
        if (StringUtils.isNotBlank(mobile))
        {
            num = num + Integer.parseInt(mobile);
        }
        if (StringUtils.isNotBlank(question))
        {
            num = num + Integer.parseInt(question);
        }
        return num;
    }

}
