package com.gooagoo.common.utils;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.exception.business.user.AddressFormatErrorException;
import com.gooagoo.exception.business.user.BirthdayFormatErrorException;
import com.gooagoo.exception.business.user.EmailFormatErrorException;
import com.gooagoo.exception.business.user.IdNoFormatErrorException;
import com.gooagoo.exception.business.user.NameFormatErrorException;
import com.gooagoo.exception.business.user.PhoneFormatErrorException;
import com.gooagoo.exception.business.user.PostCodeFormatErrorException;
import com.gooagoo.exception.business.user.SexFormatErrorException;
import com.gooagoo.exception.business.user.TelephoneFormatErrorException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;

public class CheckMemberUtils
{
    /**
     * 校验姓名
     * @param name
     * @return
     * @throws NullException 
     * @throws FormatErrorException 
     */
    public static boolean checkName(String name) throws NullException, FormatErrorException
    {
        if (StringUtils.isBlank(name))
        {
            GooagooLog.info("校验姓名：姓名（" + name + "）为空");
            throw new NullException("姓名（" + name + "）为空");
        }
        if (name.length() > 32)
        {
            GooagooLog.info("校验姓名：姓名（" + name + "）长度超过32个字符");
            throw new NameFormatErrorException("姓名（" + name + "）长度超过32个字符");
        }

        return true;
    }

    /**
     * 校验性别
     * @param sex
     * @param idType
     * @param idNo
     * @return
     * @throws FormatErrorException 
     */
    public static boolean checkSex(String sex, String idType, String idNo) throws FormatErrorException
    {
        if (StringUtils.isNotBlank(sex))
        {
            if (SysdictionaryCache.get("sex", sex) == null)
            {
                GooagooLog.info("校验性别：性别（" + sex + "）格式不正确");
                throw new SexFormatErrorException("性别（" + sex + "）格式不正确");
            }
            if ("00".equals(idType) && StringUtils.isNotBlank(idNo) && !DataPatternUtils.checkSexByIdNumber(sex, idNo))
            {
                GooagooLog.info("校验性别：性别（" + sex + "）与身份证号码（" + idNo + "）不对应");
                throw new SexFormatErrorException("性别（" + sex + "）与身份证号码（" + idNo + "）不对应");
            }
        }

        return true;
    }

    /**
     * 校验出生日期
     * @param birthday
     * @param idType
     * @param idNo
     * @param currentTime
     * @return
     * @throws FormatErrorException 
     */
    public static boolean checkBirthday(Date birthday, String idType, String idNo) throws FormatErrorException
    {
        if (birthday != null)
        {
            if (birthday.after(new Date()))
            {
                GooagooLog.info("校验出生日期：出生日期（" + TimeUtils.convertDateToString(birthday, "yyy-MM-dd") + "）有误");
                throw new BirthdayFormatErrorException("出生日期（" + TimeUtils.convertDateToString(birthday, "yyy-MM-dd") + "）有误");
            }
            if ("00".equals(idType) && StringUtils.isNotBlank(idNo) && !DataPatternUtils.checkBirthdayByIdNumber(TimeUtils.convertDateToString(birthday, "yyyy-MM-dd"), idNo))
            {
                GooagooLog.info("校验出生日期：出生日期（" + TimeUtils.convertDateToString(birthday, "yyy-MM-dd") + "）与身份证号码（" + idNo + "）不对应");
                throw new BirthdayFormatErrorException("出生日期（" + TimeUtils.convertDateToString(birthday, "yyy-MM-dd") + "）与身份证号码（" + idNo + "）不对应");
            }
        }

        return true;
    }

    /**
     * 校验证件类型、证件号码
     * @param idType
     * @param idNo
     * @return
     * @throws NullException 
     * @throws FormatErrorException 
     */
    public static boolean checkIdTypeAndIdNo(String idType, String idNo) throws NullException, FormatErrorException
    {
        if (StringUtils.isBlank(idType) && StringUtils.isBlank(idNo))
        {
            return true;
        }
        if (StringUtils.isNotBlank(idType) && StringUtils.isNotBlank(idNo))
        {
            if (SysdictionaryCache.get("idtype", idType) == null)
            {
                GooagooLog.info("校验证件类型、证件号码：证件类型（" + idType + "）格式不正确");
                throw new NullException("证件类型（" + idType + "）格式不正确");
            }
            if (idNo.length() > 30)
            {
                GooagooLog.info("校验姓名：身份证号（" + idNo + "）长度超过30个字符");
                throw new IdNoFormatErrorException("身份证号（" + idNo + "）长度超过30个字符");
            }
            if ("00".equals(idType) && !DataPatternUtils.checkIdNumber(idNo))
            {
                GooagooLog.info("校验证件类型、证件号码：身份证号（" + idNo + "）格式不正确");
                throw new IdNoFormatErrorException("身份证号（" + idNo + "）格式不正确");
            }
        }
        else
        {
            GooagooLog.info("校验证件类型、证件号码：证件类型（" + idType + "）、证件号码（" + idNo + "）需全部填写");
            throw new NullException("证件类型（" + idType + "）、证件号码（" + idNo + "）需全部填写");
        }

        return true;
    }

    /**
     * 校验手机号码、证件号码
     * @param mobile
     * @param idType
     * @param idNo
     * @return
     * @throws NullException 
     * @throws FormatErrorException 
     */
    public static boolean checkMobileAndIdNo(String mobile, String idType, String idNo) throws NullException, FormatErrorException
    {
        if (StringUtils.isBlank(mobile) && StringUtils.isBlank(idNo))
        {
            GooagooLog.info("校验手机号码、证件号码：身份证号（" + idNo + "）与手机号码（" + mobile + "）同时为空");
            throw new NullException("身份证号（" + idNo + "）与手机号码（" + mobile + "）同时为空");
        }
        if (StringUtils.isNotBlank(mobile) && !DataPatternUtils.checkMobilePhone(mobile))
        {
            GooagooLog.info("校验手机号码、证件号码：手机号码（" + mobile + "）格式不正确");
            throw new PhoneFormatErrorException("手机号码（" + mobile + "）格式不正确");
        }

        return true;
    }

    /**
     * 校验联系电话
     * @param telephone
     * @return
     * @throws FormatErrorException 
     */
    public static boolean checkTelephone(String telephone) throws FormatErrorException
    {
        if (StringUtils.isNotBlank(telephone) && !DataPatternUtils.checkTelePhone(telephone))
        {
            GooagooLog.info("校验联系电话：联系电话（" + telephone + "）格式不正确");
            throw new TelephoneFormatErrorException("联系电话（" + telephone + "）格式不正确");
        }

        return true;
    }

    /**
     * 校验电子邮箱
     * @param email
     * @return
     * @throws FormatErrorException 
     */
    public static boolean checkEmail(String email) throws FormatErrorException
    {
        if (StringUtils.isNotBlank(email) && !DataPatternUtils.chechEmail(email))
        {
            GooagooLog.info("校验电子邮箱：电子邮箱（" + email + "）格式不正确");
            throw new EmailFormatErrorException("电子邮箱（" + email + "）格式不正确");
        }

        return true;
    }

    /**
     * 校验邮政编码
     * @param postcode
     * @return
     * @throws FormatErrorException 
     */
    public static boolean checkPostcode(String postcode) throws FormatErrorException
    {
        if (StringUtils.isNotBlank(postcode) && !DataPatternUtils.checkZipCode(postcode))
        {
            GooagooLog.info("校验邮政编码：邮政编码（" + postcode + "）格式不正确");
            throw new PostCodeFormatErrorException("邮政编码（" + postcode + "）格式不正确");
        }

        return true;
    }

    /**
     * 校验通讯地址
     * @param address
     * @return
     * @throws FormatErrorException 
     */
    public static boolean checkAddress(String address) throws FormatErrorException
    {
        if (StringUtils.isNotBlank(address) && address.length() > 250)
        {
            GooagooLog.info("校验通讯地址：通讯地址（" + address + "）长度超过250个字符");
            throw new AddressFormatErrorException("通讯地址（" + address + "）长度超过250个字符");
        }

        return true;
    }
}
