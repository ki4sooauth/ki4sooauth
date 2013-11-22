package com.gooagoo.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/**
 * 数据模式校验工具类
 * @author GOOAGOO
 *
 */
public class DataPatternUtils
{

    private final static DateFormat BIRTHDAY_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final static String MOBILEPHONE_PATTERN = "^((13[0-9])|(14[5,7])|(15[^4,\\D])|(18[^1 ^4,\\D]))\\d{8}$";

    private final static String TELEPHONE_PATTERN = "^(((0\\d{3}[\\-])?\\d{7}|(0\\d{2}[\\-])?\\d{8}))([\\-]\\d{2,4})?$";

    private final static String EMAIL_PATTERN = "^((([a-zA-Z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+(\\.([a-zA-Z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+)*)|((\\x22)((((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(([\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x7f]|\\x21|[\\x23-\\x5b]|[\\x5d-\\x7e]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(\\\\([\\x01-\\x09\\x0b\\x0c\\x0d-\\x7f]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF]))))*(((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(\\x22)))@((([a-zA-Z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-zA-Z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-zA-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-zA-Z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-zA-Z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-zA-Z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-zA-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-zA-Z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?$";

    private final static String ZIPCODE_PATTERN = "^\\d{6}$";

    private final static String IDNUMBER_PATTERN = "^\\d{15}(\\d{2}(x|X|\\d))?$";

    private final static String PRICE_PATTERN = "^([1-9][0-9]{0,7}|[0-9])((\\.[0-9]{0,2}){0,1})$";

    private final static String IP_PATTERN = "^((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))$";

    static
    {
        BIRTHDAY_FORMAT.setLenient(false);
    }

    /**
     * 手机号码格式校验
     * @param mobilePhone
     * @return
     */
    public static boolean checkMobilePhone(String mobilePhone)
    {
        if (mobilePhone == null)
        {
            return false;
        }
        return Pattern.compile(MOBILEPHONE_PATTERN).matcher(mobilePhone).find();
    }

    /**
     * 电话号码格式校验（支持分机号）
     * @param telePhone
     * @return
     */
    public static boolean checkTelePhone(String telePhone)
    {
        if (telePhone == null)
        {
            return false;
        }
        return Pattern.compile(TELEPHONE_PATTERN).matcher(telePhone).find();
    }

    /**
     * 电子邮箱格式校验
     * @param email
     * @return
     */
    public static boolean chechEmail(String email)
    {
        if (email == null)
        {
            return false;
        }
        return Pattern.compile(EMAIL_PATTERN).matcher(email).find();
    }

    /**
     * 邮政编码格式校验
     * @param zipCode
     * @return
     */
    public static boolean checkZipCode(String zipCode)
    {
        if (zipCode == null)
        {
            return false;
        }
        return Pattern.compile(ZIPCODE_PATTERN).matcher(zipCode).find();
    }

    /**
     * 身份证号码格式校验（15位或者18位）
     * @param idNumber
     * @return
     */
    public static boolean checkIdNumber(String idNumber)
    {
        if (idNumber == null)
        {
            return false;
        }
        if (!(idNumber.length() == 15 || idNumber.length() == 18))
        {
            return false;
        }
        if (idNumber.length() == 15)
        {
            String birthday = "19" + idNumber.substring(6, 8) + "-" + idNumber.substring(8, 10) + "-" + idNumber.substring(10, 12);
            try
            {
                BIRTHDAY_FORMAT.parse(birthday);
            }
            catch (ParseException e)
            {
                return false;
            }
            return true;
        }
        if (!Pattern.compile(IDNUMBER_PATTERN).matcher(idNumber).find())
        {
            return false;
        }
        int[] a = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
        String[] b = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
        int sum = 0;
        for (int i = 0; i < 17; i++)
        {
            sum = sum + a[i] * Integer.parseInt(idNumber.substring(i, i + 1));
        }
        String verityNumber = sum % 11 == 2 ? "X" : b[sum % 11];
        if (!idNumber.substring(17, 18).equals(verityNumber))
        {
            return false;
        }
        String birthday = idNumber.substring(6, 10) + "-" + idNumber.substring(10, 12) + "-" + idNumber.substring(12, 14);
        try
        {
            BIRTHDAY_FORMAT.parse(birthday);
        }
        catch (ParseException e)
        {
            return false;
        }

        return idNumber.substring(17).equals(verityNumber);
    }

    /**
     * 性别正确性校验（通过身份证号码）
     * @param sex M-男，F-女
     * @param idNumber
     * @return
     */
    public static boolean checkSexByIdNumber(String sex, String idNumber)
    {
        if (sex == null || idNumber == null)
        {
            return true;
        }
        if (!(idNumber.length() == 15 || idNumber.length() == 18))
        {
            return false;
        }
        if (!("M".equals(sex) || "F".equals(sex)))
        {
            return false;
        }
        if (idNumber.length() == 15)
        {
            if (Integer.parseInt(idNumber.substring(14)) % 2 == 1)
            {
                return "M".equals(sex);
            }
            else
            {
                return "F".equals(sex);
            }
        }
        if (Integer.parseInt(idNumber.substring(16, 17)) % 2 == 1)
        {
            return "M".equals(sex);
        }
        else
        {
            return "F".equals(sex);
        }
    }

    /**
     * 出生日期正确性校验（通过身份证号码）
     * @param birthday 格式：yyyy-MM-dd
     * @param idNumber
     * @return
     */
    public static boolean checkBirthdayByIdNumber(String birthday, String idNumber)
    {
        if (birthday == null || idNumber == null)
        {
            return true;
        }
        if (!(idNumber.length() == 15 || idNumber.length() == 18))
        {
            return false;
        }
        if (idNumber.length() == 15)
        {
            if (!("19" + idNumber.substring(6, 8) + "-" + idNumber.substring(8, 10) + "-" + idNumber.substring(10, 12)).equals(birthday))
            {
                return false;
            }
        }
        if (idNumber.length() == 18)
        {
            if (!(idNumber.substring(6, 10) + "-" + idNumber.substring(10, 12) + "-" + idNumber.substring(12, 14)).equals(birthday))
            {
                return false;
            }
        }
        try
        {
            BIRTHDAY_FORMAT.parse(birthday);
        }
        catch (ParseException e)
        {
            return false;
        }
        return true;
    }

    /**
     * 价格格式校验（小数点前最多8位，后最多两位）
     * @param price
     * @return
     */
    public static boolean checkPrice(String price)
    {
        if (price == null)
        {
            return false;
        }
        return Pattern.compile(PRICE_PATTERN).matcher(price).find();
    }

    /**
     * IP地址校验
     * @param ip
     * @return
     */
    public static boolean checkIpAddress(String ip)
    {
        if (ip == null)
        {
            return false;
        }
        return Pattern.compile(IP_PATTERN).matcher(ip).find();
    }

}
