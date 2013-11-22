package com.gooagoo.common.gus.utils;

import com.gooagoo.common.utils.DataUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.view.gus.common.Image;

/**
 * 数据格式化工具类
 * <br>
 * 定制化数据格式
 * @author GUS
 *
 */
public class FormatDataUtils
{

    /**
     * 格式化商品价格
     * <br>
     * 统一保留两位有效小数
     * @param goodsPrice
     * @return
     */
    public static String formatGoodsPrice(Double goodsPrice)
    {
        return DataUtils.format2Decimal(goodsPrice);
    }

    /**
     * 格式化优惠凭证额度
     * <br>
     * 代金券代金额度保留两位有效小数，并附带有"￥"前缀
     * <br>
     * 折扣券折扣额度标准化，并附带有"折"后缀
     * @param couponType
     * @param couponValue
     * @return
     */
    public static String formatCouponValue(String couponType, Double couponValue)
    {
        if ("C".equals(couponType))
        {
            return "￥" + DataUtils.format2Decimal(couponValue);
        }
        else if ("D".equals(couponType))
        {
            String value = String.valueOf(couponValue * 10);
            while (value.indexOf(".") != -1 && (value.endsWith("0") || value.endsWith(".")))
            {
                value = value.substring(0, value.length() - 1);
            }
            return value + "折";
        }

        return null;
    }

    /**
     * 格式化图片信息
     * <br>
     * 返回图片的四个URL（原图、大图、中图、小图）
     * @param imageUrl
     * @return
     */
    public static Image formatImageInfo(String imageUrl)
    {
        Image image = new Image();
        image.setImgUrl(imageUrl);
        image.setBigImgUrl(UrlUtils.getAttachUrlByImg("b", imageUrl));
        image.setMiddleImgUrl(UrlUtils.getAttachUrlByImg("m", imageUrl));
        image.setSmallImgUrl(UrlUtils.getAttachUrlByImg("s", imageUrl));

        return image;
    }

    /**
     * 格式化会员卡图片信息
     * <br>
     * 返回图片的四个URL（原卡、卡头、卡身、整张卡）
     * @param imageUrl
     * @return
     */
    public static Image formatCardImageInfo(String imageUrl)
    {
        Image image = new Image();
        image.setImgUrl(imageUrl);
        image.setBigImgUrl(UrlUtils.getAttachUrlByImg("dh_top", imageUrl));
        image.setMiddleImgUrl(UrlUtils.getAttachUrlByImg("dh_bottom", imageUrl));
        image.setSmallImgUrl(UrlUtils.getAttachUrlByImg("s", imageUrl));

        return image;
    }

    /**
     * 格式化邮箱
     * <br>
     * 只显示部分信息，隐藏信息用"*****"代替
     * @param value
     * @return
     */
    public static String formatAccount(String value)
    {
        String prefix = "";
        String suffix = "";
        prefix = value.substring(0, 1);
        if (value.length() > 1)
        {
            suffix = value.substring(value.length() - 1, value.length());
        }

        return prefix + "*****" + suffix;
    }

    /**
     * 格式化邮箱
     * <br>
     * 只显示部分信息，隐藏信息用"*****"代替
     * @param value
     * @return
     */
    public static String formatEmail(String value)
    {
        String[] values = value.split("@");
        String prefix = values[0];
        String suffix = values[1];
        if (prefix.length() < 2)
        {
            prefix = prefix + "*****";
        }
        else
        {
            prefix = prefix.substring(0, 1) + "*****" + prefix.substring(prefix.length() - 1, prefix.length());
        }

        return prefix + "@" + suffix;
    }

    /**
     * 格式化手机号码
     * <br>
     * 只显示部分信息，隐藏信息用"*****"代替
     * @param value
     * @return
     */
    public static String formatMobile(String value)
    {
        String prefix = value.substring(0, 3);
        String suffix = value.substring(value.length() - 3, value.length());

        return prefix + "*****" + suffix;
    }

}
