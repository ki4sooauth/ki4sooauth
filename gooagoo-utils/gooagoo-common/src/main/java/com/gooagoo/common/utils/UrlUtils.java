package com.gooagoo.common.utils;

import java.util.Random;

import org.apache.zookeeper.WatchedEvent;

import com.gooagoo.common.cipher.DesUtils;
import com.gooagoo.common.constants.ZookeeperConstants;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.zookeeper.AbstractZooKeeper;

/**
 * 访问地址工具类
 * 提供图片、网站的访问地址
 * @author frenn
 *
 */
public class UrlUtils
{
    private static String BASE_HOST = "aaaa";//基础域名
    private static String BASE_URL = null;//地址分析
    private static String AUDIO_URL = null;//音频
    private static String BAR_URL = null;//二维码

    static
    {
        AbstractZooKeeper keeper = null;
        try
        {
            keeper = new AbstractZooKeeper()
            {
                @Override
                public void processWatcher(WatchedEvent arg0)
                {
                }
            };
            byte[] aa = keeper.zooKeeper.getData(ZookeeperConstants.DOMAIN_PATH, false, null);
            BASE_HOST = new String(aa, AbstractZooKeeper.CHARACTER_SET_ENCODING);
            BASE_URL = "http://3g." + BASE_HOST + "/info?para=";//地址分析
            AUDIO_URL = "http://audio." + BASE_HOST + "/audio/info?para=";//音频
            BAR_URL = "http://code." + BASE_HOST + "/two";//二维码
            GooagooLog.info("基础域名=" + BASE_HOST);
        }
        catch (Exception e)
        {
            BASE_HOST = "aaaa";
            GooagooLog.error("读取基础域名异常", e);
        }
        finally
        {
            if (keeper != null)
            {
                keeper.close();
            }
        }
    }

    public static String getBASE_HOST()
    {
        return BASE_HOST;
    }

    /**
     * 根据音频编码获取音频文件地址
     * @param code
     * @return
     */
    public static String getAudioUrl(String code)
    {
        return AUDIO_URL + code;
    }

    /**
     * 根据二维码编码获取二维码图片地址
     * @param code
     * @param size
     * @return
     */
    public static String getBarUrl(String code, int size)
    {
        return BAR_URL + "?c=" + code + "&s=" + size;
    }

    /**
     * 根据二维码编码获取二维码图片地址
     * @param code
     * @return
     */
    public static String getBarUrl(String code)
    {
        return getBarUrl(code, 20);
    }

    /**
     * 对字符串进行加密
     * @param url
     * @return
     * @throws Exception
     */
    public static String encodeUrl(String url) throws Exception
    {
        DesUtils desUtil = new DesUtils("fetchurl");
        return desUtil.encrypt(url);
    }

    /**
     * 通过原图url获取其他裁剪大小的图片url
     * 如原图url为http://img.gooagoo.com/dfjhuweiuwriuewhf.jpg
     * 指定的附加名为small
     * 则返回的图片url为http://img.gooagoo.com/dfjhuweiuwriuewhf-small.jpg
     * @param attach        指定的附加名
     * @param imgPath       原图url
     * @return              添加了附加名之后的图片url
     */
    public static String getAttachUrlByImg(String attach, String imgPath)
    {
        String url = imgPath;
        if (imgPath == null || imgPath.lastIndexOf(".") < 1)
        {
            return imgPath;
        }
        String fileSuffix = imgPath.substring(imgPath.lastIndexOf("."));
        url = imgPath.substring(0, imgPath.lastIndexOf(".")) + "_" + attach + fileSuffix;
        return url;
    }

    /**
     * 获取商品介绍地址
     * @param goodsId   商品编号
     * @return  访问地址
     * @throws Exception 
     */
    public static String getGoodsUrl(String goodsId) throws Exception
    {
        return "http://goods." + BASE_HOST + "/" + goodsId + ".html";
    }

    /**
     * 获取商品介绍地址（手机端）
     * @param goodsId   商品编号
     * @return  访问地址
     * @throws Exception 
     */
    public static String getGoodsMobileUrl(String goodsId) throws Exception
    {
        return "http://m.goods." + BASE_HOST + "/" + goodsId + ".html";
    }

    /**
     * 获取商品介绍地址
     * @param goodsId   商品编号
     * @param marketingId   营销编号
     * @return  访问地址
     * @throws Exception
     */
    public static String getGoodsUrl(String goodsId, String marketingId) throws Exception
    {
        return "http://goods." + BASE_HOST + "/" + goodsId + ".html?m=" + marketingId;
    }

    /**
     * 获取商品介绍地址（手机端）
     * @param goodsId   商品编号
     * @param marketingId   营销编号
     * @return  访问地址
     * @throws Exception
     */
    public static String getGoodsMobileUrl(String goodsId, String marketingId) throws Exception
    {
        return "http://m.goods." + BASE_HOST + "/" + goodsId + ".html?m=" + marketingId;
    }

    /**
     * 获取优惠凭证介绍地址
     * @param couponId  优惠凭证编号
     * @return  访问地址
     * @throws Exception 
     */
    public static String getCouponUrl(String couponId) throws Exception
    {
        return "http://coupon." + BASE_HOST + "/" + couponId + ".html";
    }

    /**
     * 获取优惠凭证介绍地址（手机端）
     * @param couponId  优惠凭证编号
     * @return  访问地址
     * @throws Exception 
     */
    public static String getCouponMobileUrl(String couponId) throws Exception
    {
        return "http://m.coupon." + BASE_HOST + "/" + couponId + ".html";
    }

    /**
     * 获取优惠凭证介绍地址
     * @param couponId  优惠凭证编号
     * @param marketingId   营销编号
     * @return  访问地址
     * @throws Exception
     */
    public static String getCouponUrl(String couponId, String marketingId) throws Exception
    {
        return "http://coupon." + BASE_HOST + "/" + couponId + ".html?m=" + marketingId;
    }

    /**
     * 获取优惠凭证介绍地址（手机端）
     * @param couponId  优惠凭证编号
     * @param marketingId   营销编号
     * @return  访问地址
     * @throws Exception
     */
    public static String getCouponMobileUrl(String couponId, String marketingId) throws Exception
    {
        return "http://m.coupon." + BASE_HOST + "/" + couponId + ".html?m=" + marketingId;
    }

    /**
     * 获取活动介绍地址
     * @param activeId  活动编号
     * @return  访问地址
     * @throws Exception 
     */
    public static String getActiveUrl(String activeId) throws Exception
    {
        return "http://active." + BASE_HOST + "/" + activeId + ".html";
    }

    /**
     * 获取活动介绍地址（手机端）
     * @param activeId  活动编号
     * @return  访问地址
     * @throws Exception 
     */
    public static String getActiveMobileUrl(String activeId) throws Exception
    {
        return "http://m.active." + BASE_HOST + "/" + activeId + ".html";
    }

    /**
     * 获取活动介绍地址
     * @param activeId  活动编号
     * @param marketingId   营销编号
     * @return  访问地址
     * @throws Exception
     */
    public static String getActiveUrl(String activeId, String marketingId) throws Exception
    {
        return "http://active." + BASE_HOST + "/" + activeId + ".html?m=" + marketingId;
    }

    /**
     * 获取活动介绍地址（手机端）
     * @param activeId  活动编号
     * @param marketingId   营销编号
     * @return  访问地址
     * @throws Exception
     */
    public static String getActiveMobileUrl(String activeId, String marketingId) throws Exception
    {
        return "http://m.active." + BASE_HOST + "/" + activeId + ".html?m=" + marketingId;
    }

    /**
     * 获取积分商城地址，shopId可为空，为空时查询所有商家的信息
     * @param shopId    商家编号
     * @return  访问地址
     * @throws Exception
     */
    public static String getIntegralMallUrl(String shopId) throws Exception
    {
        String para = "integralMall^" + shopId + "^" + new Random().nextInt(1000);
        return BASE_URL + encodeUrl(para);
    }

    /**
     * 获取事件介绍地址
     * @param eventId   事件编号
     * @return          访问地址
     * @throws Exception 
     */
    public static String getEventUrl(String eventId) throws Exception
    {
        return "http://event." + BASE_HOST + "/" + eventId + ".html";
    }

    /**
     * 获取cms栏目或文章地址
     * @param cmsId     栏目或文章编号
     * @return          访问地址
     * @throws Exception 
     */
    public static String getCmsUrl(String cmsId) throws Exception
    {
        return "http://content." + BASE_HOST + "/" + cmsId + ".html";
    }

    /**
     * 获取区域商品销量排行的链接
     * @param positionId    区域编号
     * @return  访问地址
     * @throws Exception
     */
    public static String getPositionMarketingRank(String positionId) throws Exception
    {
        String para = "rank^" + positionId + "^" + new Random().nextInt(1000);
        return BASE_URL + encodeUrl(para);
    }
}
