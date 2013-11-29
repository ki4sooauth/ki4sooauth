package com.gooagoo.core.business.user.favorite;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.user.favorite.FavoriteCoreService;
import com.gooagoo.api.generator.core.behave.FavoriteInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.goods.GoodsBaseInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.CouponGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.CouponGrantInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.CryoutInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.MarketingActivityGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.MarketingItemLinkGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.MarketingUserLinkGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.NoticeInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.shop.ShopProtectedCoreService;
import com.gooagoo.api.protecteds.core.user.UserProtectedCoreService;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.SerialUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample.Criteria;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.CouponGrantInfo;
import com.gooagoo.entity.generator.marketing.CouponGrantInfoExample;
import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample;
import com.gooagoo.entity.generator.marketing.NoticeInfo;
import com.gooagoo.exception.business.shop.CouponExhaustiveException;
import com.gooagoo.exception.business.user.AlreadyCollectException;
import com.gooagoo.exception.business.user.AlreadyExceedUserOwnCouponNumException;
import com.gooagoo.exception.business.user.CouponAlreadyPastPublishEndTimeException;
import com.gooagoo.exception.business.user.FavoriteNotExistOrDeletedException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class FavoriteCoreServiceImpl implements FavoriteCoreService
{

    @Autowired
    private CouponGeneratorCoreService couponGeneratorCoreService;
    @Autowired
    private GoodsBaseInfoGeneratorCoreService goodsBaseInfoGeneratorCoreService;
    @Autowired
    private MarketingActivityGeneratorCoreService marketingActivityGeneratorCoreService;
    @Autowired
    private MarketingItemLinkGeneratorCoreService marketingItemLinkGeneratorCoreService;
    @Autowired
    private MarketingUserLinkGeneratorCoreService marketingUserLinkGeneratorCoreService;
    @Autowired
    private FavoriteInfoGeneratorCoreService favoriteInfoGeneratorCoreService;
    @Autowired
    private UserProtectedCoreService userProtectedCoreService;
    @Autowired
    private ShopProtectedCoreService shopProtectedCoreService;
    @Autowired
    private CouponGrantInfoGeneratorCoreService couponGrantInfoGeneratorCoreService;
    @Autowired
    private CryoutInfoGeneratorCoreService cryoutInfoGeneratorCoreService;
    @Autowired
    private NoticeInfoGeneratorCoreService noticeInfoGeneratorCoreService;

    private final static Object synObject1 = new Object();//收藏广场 ，收藏优惠凭证同步锁

    private final static Object synObject2 = new Object();//精准投放， 收藏优惠凭证同步锁

    private final static Object synObject3 = new Object();//收藏活动同步锁

    private final static Object synObject4 = new Object();//收藏商品同步锁

    @Override
    public boolean addFavorite(FavoriteInfo favoriteInfo) throws Exception
    {
        Date currentTime = new Date();
        String[] paras = new String[3];
        //1、校验收藏数据
        this.checkAddFavoriteData(favoriteInfo);
        //2、如果信息URL为空生成信息URL
        if (StringUtils.isBlank(favoriteInfo.getInfoUrl()))
        {
            String infoUrl = null;
            if ("A".equals(favoriteInfo.getInfoType()) && StringUtils.isNotBlank(favoriteInfo.getObjectId()))//活动
            {
                infoUrl = UrlUtils.getActiveUrl(favoriteInfo.getObjectId());
                paras[0] = "active";
            }
            else if ("C".equals(favoriteInfo.getInfoType()) && StringUtils.isNotBlank(favoriteInfo.getObjectId()))//优惠券
            {
                infoUrl = UrlUtils.getCouponUrl(favoriteInfo.getObjectId());
                paras[0] = "coupon";
            }
            else if ("G".equals(favoriteInfo.getInfoType()) && StringUtils.isNotBlank(favoriteInfo.getObjectId()))//商品
            {
                infoUrl = UrlUtils.getGoodsUrl(favoriteInfo.getObjectId());
                paras[0] = "goods";
            }
            else
            {
                GooagooLog.info("收藏类型有误[InfoType=" + favoriteInfo.getInfoType() + "]");
                return false;
            }
            favoriteInfo.setInfoUrl(infoUrl);
            paras[1] = favoriteInfo.getObjectId();
        }
        else
        {
            //3、解析收藏地址
            paras = this.analysisFavoriteUrl(favoriteInfo.getInfoUrl());
        }
        //4、处理收藏
        if ("coupon".equals(paras[0]))
        {
            //3.1、处理优惠凭证收藏
            this.addCouponFavorite(favoriteInfo, paras, currentTime);
        }
        else if ("goods".equals(paras[0]))
        {
            //3.2、处理商品收藏
            this.addGoodsFavorite(favoriteInfo, paras);
        }
        else if ("active".equals(paras[0]))
        {
            //3.3、处理活动收藏
            this.addActiveFavorite(favoriteInfo, paras);
        }
        else
        {
            GooagooLog.info("收藏：收藏地址（" + favoriteInfo.getInfoUrl() + "）有误");
            throw new OperateFailException("收藏地址（" + favoriteInfo.getInfoUrl() + "）有误");
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean deleteFavorite(String favoriteIds) throws Exception
    {
        //1、数据校验
        this.checkDeleteFavoriteData(favoriteIds);
        List<String> favoriteIdList = Arrays.asList(favoriteIds.split(","));
        FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
        favoriteInfoExample.createCriteria().andFavoriteIdIn(favoriteIdList);
        //2、处理删除收藏
        if (!this.favoriteInfoGeneratorCoreService.deleteByExample(favoriteInfoExample))
        {
            GooagooLog.error("删除收藏：删除收藏（" + favoriteIdList.toString() + "）异常", null);
            throw new OperateFailException("删除收藏（" + favoriteIdList.toString() + "）异常");
        }
        return true;
    }

    /**
     * 校验收藏数据
     * @param favoriteInfo
     * @return
     * @throws OperateFailException
     * @throws FormatErrorException
     * @throws NullException
     */
    private boolean checkAddFavoriteData(FavoriteInfo favoriteInfo) throws OperateFailException, FormatErrorException, NullException
    {
        //1、校验用户状态
        if (!this.userProtectedCoreService.checkUserStatus(favoriteInfo.getUserId()))
        {
            GooagooLog.info("校验收藏数据：用户（" + favoriteInfo.getUserId() + "）状态异常");
            throw new OperateFailException("用户（" + favoriteInfo.getUserId() + "）状态异常");
        }
        //2、校验收藏来源
        if (SysdictionaryCache.get("info_source", favoriteInfo.getSource()) == null)
        {
            GooagooLog.info("校验收藏数据：收藏来源（" + favoriteInfo.getSource() + "）有误");
            throw new FormatErrorException("收藏来源（" + favoriteInfo.getSource() + "）有误");
        }
        return true;

    }

    /**
     * 解析收藏地址
     * @param favoriteUrl
     * @return
     * @throws OperateFailException 
     */
    private String[] analysisFavoriteUrl(String favoriteUrl) throws OperateFailException
    {
        String[] result = new String[3];
        if (favoriteUrl.contains("coupon"))
        {
            result[0] = "coupon";
        }
        if (favoriteUrl.contains("active"))
        {
            result[0] = "active";
        }
        if (favoriteUrl.contains("goods"))
        {
            result[0] = "goods";
        }
        if (favoriteUrl.contains(".html?m="))
        {//网站端
            result[1] = favoriteUrl.substring(favoriteUrl.indexOf(".com/") + 5, favoriteUrl.indexOf(".html?m="));
            result[2] = favoriteUrl.substring(favoriteUrl.indexOf("html?m=") + 7);
        }
        else
        {//手机端
            result[1] = favoriteUrl.substring(favoriteUrl.indexOf(".com/") + 5, favoriteUrl.indexOf(".html"));
            result[2] = null;
        }

        return result;
    }

    /**
     * 收藏优惠凭证
     * @param favoriteInfo
     * @param paras
     * @param currentTime
     * @return
     * @throws FavoriteNotExistOrDeletedException
     * @throws AlreadyCollectException
     * @throws CouponAlreadyPastPublishEndTimeException
     * @throws AlreadyExceedUserOwnCouponNumException
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private boolean addCouponFavorite(FavoriteInfo favoriteInfo, String[] paras, Date currentTime) throws Exception
    {
        //1、获取优惠凭证信息
        Coupon coupon = this.couponGeneratorCoreService.selectByPrimaryKey(paras[1]);
        if (coupon == null || "Y".equals(coupon.getIsDel()))
        {
            GooagooLog.info("收藏优惠凭证：优惠凭证（" + paras[1] + "）不存在或已被删除");
            throw new FavoriteNotExistOrDeletedException("优惠凭证（" + paras[1] + "）不存在或已被删除");
        }
        if (!("1".equals(coupon.getCouponChannle()) || "2".equals(coupon.getCouponChannle())))
        {
            GooagooLog.info("收藏优惠凭证：优惠凭证（" + paras[1] + "）发布渠道有误，不允许被收藏");
            throw new OperateFailException("优惠凭证（" + paras[1] + "）发布渠道有误，不允许被收藏");
        }
        if (currentTime.before(coupon.getPublishStartTime()))
        {
            GooagooLog.info("校验收藏优惠凭证数据：优惠凭证（" + coupon.getCouponId() + "）未到发行期（" + TimeUtils.convertDateToString(coupon.getPublishStartTime(), "yyyy-MM-dd HH:mm:ss") + "）");
            throw new OperateFailException("优惠凭证（" + coupon.getCouponId() + "）未到发行期（" + TimeUtils.convertDateToString(coupon.getPublishStartTime(), "yyyy-MM-dd HH:mm:ss") + "）");
        }
        if (currentTime.after(coupon.getPublishEndTime()))
        {
            GooagooLog.info("校验收藏优惠凭证数据：优惠凭证（" + coupon.getCouponId() + "）已过发行期（" + TimeUtils.convertDateToString(coupon.getPublishEndTime(), "yyyy-MM-dd HH:mm:ss") + "）");
            throw new CouponAlreadyPastPublishEndTimeException("优惠凭证（" + coupon.getCouponId() + "）已过发行期（" + TimeUtils.convertDateToString(coupon.getPublishEndTime(), "yyyy-MM-dd HH:mm:ss") + "）");
        }
        if (!"P".equals(coupon.getPublishStatus()))
        {
            GooagooLog.info("校验收藏优惠凭证数据：优惠凭证（" + coupon.getCouponId() + "）未发布");
            throw new OperateFailException("优惠凭证（" + coupon.getCouponId() + "）未发布");
        }
        //2、检查商家状态
        if (!this.shopProtectedCoreService.checkShopStatus(coupon.getShopId()))
        {
            GooagooLog.info("收藏优惠凭证：商家（" + coupon.getShopId() + "）状态异常");
            throw new OperateFailException("商家（" + coupon.getShopId() + "）状态异常");
        }
        //3、组装收藏信息
        favoriteInfo.setFavoriteId(SerialUtils.createCouponSerial());
        favoriteInfo.setShopId(coupon.getShopId());
        favoriteInfo.setInfoTitle(coupon.getCouponName());
        favoriteInfo.setInfoType("C");
        favoriteInfo.setObjectId(coupon.getCouponId());
        favoriteInfo.setCouponStatus("0");
        favoriteInfo.setIsDel("N");
        //4、执行收藏操作
        if ("1".equals(coupon.getCouponChannle()))
        {//收藏广场
            this.addCouponFavoriteByChannel1(favoriteInfo, coupon);
        }
        else if ("2".equals(coupon.getCouponChannle()))
        {//精准投放
            this.addCouponFavoriteByChannel2(favoriteInfo, coupon, paras);
        }
        //收藏后同步[优惠凭证发放号段对应表]信息
        this.synCouponGrantInfo(coupon, favoriteInfo.getFavoriteId());
        return true;
    }

    /**
     * 收藏商品
     * @param favoriteInfo
     * @param paras
     * @return
     * @throws AlreadyCollectException
     * @throws OperateFailException
     */
    private boolean addGoodsFavorite(FavoriteInfo favoriteInfo, String[] paras) throws Exception
    {
        //1、获取商品信息
        GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorCoreService.selectByPrimaryKey(paras[1]);
        if (goodsBaseInfo == null || "Y".equals(goodsBaseInfo.getIsDel()))
        {
            GooagooLog.info("收藏商品：商品（" + paras[1] + "）不存在或被删除");
            throw new FavoriteNotExistOrDeletedException("商品（" + paras[1] + "）不存在或被删除");
        }
        //2、校验商家状态
        if (!this.shopProtectedCoreService.checkShopStatus(goodsBaseInfo.getShopId()))
        {
            GooagooLog.info("收藏商品：商家（" + goodsBaseInfo.getShopId() + "）状态异常");
            throw new OperateFailException("商家（" + goodsBaseInfo.getShopId() + "）状态异常");
        }
        if (!"P".equals(goodsBaseInfo.getPublishStatus()))
        {
            GooagooLog.info("校验商品数据：商品（" + goodsBaseInfo.getGoodsId() + "）未发布");
            throw new OperateFailException("商品（" + goodsBaseInfo.getGoodsId() + "）未发布");
        }
        //3、组装收藏信息
        favoriteInfo.setFavoriteId(UUID.getUUID());
        favoriteInfo.setShopId(goodsBaseInfo.getShopId());
        favoriteInfo.setInfoTitle(goodsBaseInfo.getGoodsName());
        favoriteInfo.setInfoType("G");
        favoriteInfo.setObjectId(goodsBaseInfo.getGoodsId());
        favoriteInfo.setIsDel("N");
        //4、判断商品是否已被收藏
        FavoriteInfoExample queryCondition = new FavoriteInfoExample();
        queryCondition.createCriteria().andUserIdEqualTo(favoriteInfo.getUserId()).andShopIdEqualTo(goodsBaseInfo.getShopId()).andInfoTypeEqualTo("G").andObjectIdEqualTo(goodsBaseInfo.getGoodsId()).andIsDelEqualTo("N");
        synchronized (synObject4)
        {
            Integer count = this.favoriteInfoGeneratorCoreService.countByExample(queryCondition);
            if (count == null || count != 0)
            {
                GooagooLog.info("收藏商品：用户（" + favoriteInfo.getUserId() + "）已收藏过商品（" + goodsBaseInfo.getGoodsId() + "）");
                throw new AlreadyCollectException("收藏商品：用户（" + favoriteInfo.getUserId() + "）已收藏过商品（" + goodsBaseInfo.getGoodsId() + "）");
            }
            //5、执行收藏操作
            if (!this.favoriteInfoGeneratorCoreService.insertSelective(favoriteInfo))
            {
                GooagooLog.error("收藏商品：保存收藏信息（" + favoriteInfo.toString() + "）异常", null);
                throw new OperateFailException("保存收藏信息（" + favoriteInfo.toString() + "）异常");
            }
        }

        return true;
    }

    /**
     * 收藏活动
     * @param favoriteInfo
     * @param paras
     * @return
     * @throws AlreadyCollectException
     * @throws OperateFailException
     */
    private boolean addActiveFavorite(FavoriteInfo favoriteInfo, String[] paras) throws Exception
    {
        //1、获取活动信息
        MarketingActivity marketingActivity = this.marketingActivityGeneratorCoreService.selectByPrimaryKey(paras[1]);
        if (marketingActivity == null || "Y".equals(marketingActivity.getIsDel()))
        {
            GooagooLog.info("收藏活动：活动（" + paras[1] + "）不存在或被删除");
            throw new FavoriteNotExistOrDeletedException("活动（" + paras[1] + "）不存在或被删除");
        }
        if (!"P".equals(marketingActivity.getPublishStatus()))
        {
            GooagooLog.info("收藏活动：活动（" + paras[1] + "）未发布");
            throw new OperateFailException("活动（" + paras[1] + "）未发布");
        }
        //2、检查商家状态
        if (!this.shopProtectedCoreService.checkShopStatus(marketingActivity.getShopId()))
        {
            GooagooLog.info("收藏活动：商家（" + marketingActivity.getShopId() + "）状态异常");
            throw new OperateFailException("商家（" + marketingActivity.getShopId() + "）状态异常");
        }
        //3、组装收藏信息
        favoriteInfo.setFavoriteId(UUID.getUUID());
        favoriteInfo.setShopId(marketingActivity.getShopId());
        favoriteInfo.setInfoTitle(marketingActivity.getActivityName());
        favoriteInfo.setInfoType("A");
        favoriteInfo.setObjectId(marketingActivity.getActivityId());
        favoriteInfo.setIsDel("N");
        //4、判断活动是否已被收藏
        FavoriteInfoExample queryCondition = new FavoriteInfoExample();
        queryCondition.createCriteria().andUserIdEqualTo(favoriteInfo.getUserId()).andShopIdEqualTo(marketingActivity.getShopId()).andInfoTypeEqualTo("A").andObjectIdEqualTo(marketingActivity.getActivityId()).andIsDelEqualTo("N");
        synchronized (synObject3)
        {
            Integer count = this.favoriteInfoGeneratorCoreService.countByExample(queryCondition);
            if (count == null || count != 0)
            {
                GooagooLog.info("收藏活动：用户（" + favoriteInfo.getUserId() + "）已收藏过活动（" + marketingActivity.getActivityId() + "）");
                throw new AlreadyCollectException("用户（" + favoriteInfo.getUserId() + "）已收藏过活动（" + marketingActivity.getActivityId() + "）");
            }
            //5、执行收藏操作
            if (!this.favoriteInfoGeneratorCoreService.insertSelective(favoriteInfo))
            {
                GooagooLog.error("收藏活动：保存收藏信息（" + favoriteInfo.toString() + "）异常", null);
                throw new OperateFailException("保存收藏信息（" + favoriteInfo.toString() + "）异常");
            }
        }

        return true;
    }

    /**
     * 校验删除收藏数据
     * @param favoriteId
     * @return
     * @throws OperateFailException
     */
    private boolean checkDeleteFavoriteData(String favoriteId) throws Exception
    {
        //1、校验收藏编号
        if (StringUtils.isBlank(favoriteId))
        {
            GooagooLog.info("校验删除收藏数据：收藏编号（" + favoriteId + "）为空");
            throw new OperateFailException("收藏编号（" + favoriteId + "）为空");
        }

        return true;
    }

    /**
     * 收藏收藏广场渠道发布的优惠凭证
     * @param favoriteInfo
     * @param coupon
     * @return
     * @throws AlreadyCollectException
     * @throws OperateFailException
     */
    private boolean addCouponFavoriteByChannel1(FavoriteInfo favoriteInfo, Coupon coupon) throws Exception
    {
        //1、个人最大拥有数量
        int maxOwnNum = coupon.getMaxNumOwner();
        //2、发放数量
        int issueAmount = coupon.getAmount();
        //3、个人已经拥有数量（已用的+未用（未用和锁定）且未删除的）
        int personalOwnNum = 0;
        synchronized (synObject1)
        {
            FavoriteInfoExample queryCondition = new FavoriteInfoExample();
            //coupon_status 优惠券状态  0-未使用，1-锁定，2-已使用

            //已用收藏优惠券
            queryCondition.createCriteria().andUserIdEqualTo(favoriteInfo.getUserId()).andShopIdEqualTo(coupon.getShopId()).andInfoTypeEqualTo("C").andObjectIdEqualTo(coupon.getCouponId()).andCouponStatusEqualTo("2");
            personalOwnNum = this.favoriteInfoGeneratorCoreService.countByExample(queryCondition);

            //未用收藏优惠券（包括锁定和未使用）
            queryCondition = new FavoriteInfoExample();
            queryCondition.createCriteria().andUserIdEqualTo(favoriteInfo.getUserId()).andShopIdEqualTo(coupon.getShopId()).andInfoTypeEqualTo("C").andObjectIdEqualTo(coupon.getCouponId()).andCouponStatusNotEqualTo("2").andIsDelEqualTo("N");

            //个人已经拥有数量
            personalOwnNum = personalOwnNum + this.favoriteInfoGeneratorCoreService.countByExample(queryCondition);

            if (maxOwnNum <= personalOwnNum)
            {
                GooagooLog.info("收藏收藏广场渠道发布的优惠凭证：优惠凭证（" + coupon.getCouponId() + "）个人（" + favoriteInfo.getUserId() + "）已经拥有数量（" + personalOwnNum + "）已超过或等于最大拥有数量（" + maxOwnNum + "）");
                throw new AlreadyExceedUserOwnCouponNumException("优惠凭证（" + coupon.getCouponId() + "）个人（" + favoriteInfo.getUserId() + "）已经拥有数量（" + personalOwnNum + "）已超过或等于最大拥有数量（" + maxOwnNum + "）");
            }
            //4、所有用户已经拥有数量（已用的+未用且未删除的）
            int userOwnNum = 0;

            //已用收藏优惠券
            queryCondition = new FavoriteInfoExample();
            queryCondition.createCriteria().andShopIdEqualTo(coupon.getShopId()).andInfoTypeEqualTo("C").andObjectIdEqualTo(coupon.getCouponId()).andCouponStatusEqualTo("2");
            userOwnNum = this.favoriteInfoGeneratorCoreService.countByExample(queryCondition);

            //未用收藏优惠券（包括锁定和未使用）
            queryCondition = new FavoriteInfoExample();
            queryCondition.createCriteria().andShopIdEqualTo(coupon.getShopId()).andInfoTypeEqualTo("C").andObjectIdEqualTo(coupon.getCouponId()).andCouponStatusNotEqualTo("2").andIsDelEqualTo("N");

            //所有用户已经拥有数量
            userOwnNum = userOwnNum + this.favoriteInfoGeneratorCoreService.countByExample(queryCondition);

            if (issueAmount <= userOwnNum)
            {
                GooagooLog.info("收藏收藏广场渠道发布的优惠凭证：优惠凭证（" + coupon.getCouponId() + "）用户已经拥有数量（" + userOwnNum + "）已超过或等于发放数量（" + issueAmount + "）");
                throw new CouponExhaustiveException("优惠凭证（" + coupon.getCouponId() + "）用户已经拥有数量（" + userOwnNum + "）已超过或等于发放数量（" + issueAmount + "）");
            }
            //5、保存收藏信息
            if (!this.favoriteInfoGeneratorCoreService.insertSelective(favoriteInfo))
            {
                GooagooLog.error("收藏收藏广场渠道发布的优惠凭证：保存收藏信息（" + favoriteInfo.toString() + "）异常", null);
                throw new OperateFailException("保存收藏信息（" + favoriteInfo.toString() + "）异常");
            }
        }

        return true;
    }

    /**
     * 收藏精准投放渠道发布的优惠凭证
     * @param favoriteInfo
     * @param coupon
     * @param paras
     * @return
     * @throws AlreadyCollectException
     * @throws OperateFailException
     */
    private boolean addCouponFavoriteByChannel2(FavoriteInfo favoriteInfo, Coupon coupon, String[] paras) throws Exception
    {
        //1、校验推送内容对应的对象编号
        if (StringUtils.isBlank(paras[1]))
        {
            GooagooLog.info("校验收藏精准投放渠道发布的优惠凭证数据：推送内容对象编号（" + paras[1] + "）为空");
            throw new OperateFailException("推送内容对象编号（" + paras[1] + "）为空");
        }
        //2、校验优惠凭证是否给用户推送过
        MarketingUserLinkExample queryCondition2 = new MarketingUserLinkExample();
        queryCondition2.createCriteria().andMarketingIdEqualTo(paras[1]).andShopIdEqualTo(coupon.getShopId()).andAccountTypeEqualTo("0").andAccountEqualTo(favoriteInfo.getUserId()).andIsPushedEqualTo("Y").andIsDelEqualTo("N");
        List<MarketingUserLink> marketingUserLinkList = this.marketingUserLinkGeneratorCoreService.selectByExample(queryCondition2);
        if (CollectionUtils.isEmpty(marketingUserLinkList) || marketingUserLinkList.size() != 1)
        {
            GooagooLog.info("收藏精准投放渠道发布的优惠凭证：优惠凭证（" + paras[1] + "）未推送给用户（" + favoriteInfo.getUserId() + "）");
            throw new OperateFailException("优惠凭证（" + paras[1] + "）未推送给用户（" + favoriteInfo.getUserId() + "）");
        }
        //3营销内容(吆喝、通知)是否包含优惠券
        MarketingUserLink marketingUserLink = marketingUserLinkList.get(0);
        if ("1".equals(marketingUserLink.getMarketingType()))//吆喝
        {
            CryoutInfo cryoutInfo = this.cryoutInfoGeneratorCoreService.selectUnDelByPrimaryKey(marketingUserLink.getMarketingId());
            if (cryoutInfo == null || !coupon.getCouponId().equals(cryoutInfo.getMarketingLinkId()))
            {
                throw new OperateFailException("营销内容(吆喝)不包含优惠券[marketingId=" + marketingUserLink.getMarketingId() + "]");
            }
        }
        else if ("2".equals(marketingUserLink.getMarketingType()))//通知
        {
            NoticeInfo noticeInfo = this.noticeInfoGeneratorCoreService.selectUnDelByPrimaryKey(marketingUserLink.getMarketingId());
            if (noticeInfo == null || !coupon.getCouponId().equals(noticeInfo.getMarketingLinkId()))
            {
                throw new OperateFailException("营销内容(通知)不包含优惠券[marketingId=" + marketingUserLink.getMarketingId() + "]");
            }
        }
        //4、个人最大拥有数量
        int maxOwnNum = coupon.getMaxNumOwner();
        //5、发放数量
        int issueAmount = coupon.getAmount();
        //6、个人收藏次数
        FavoriteInfoExample queryCondition3 = new FavoriteInfoExample();
        Criteria criteria = queryCondition3.createCriteria();
        criteria.andUserIdEqualTo(favoriteInfo.getUserId()).andShopIdEqualTo(coupon.getShopId()).andInfoTypeEqualTo("C").andObjectIdEqualTo(coupon.getCouponId());
        synchronized (synObject2)
        {
            List<FavoriteInfo> favoriteInfoList = this.favoriteInfoGeneratorCoreService.selectByExample(queryCondition3);
            for (FavoriteInfo item : favoriteInfoList)
            {
                String[] result = this.analysisFavoriteUrl(item.getInfoUrl());
                if (StringUtils.isNotBlank(paras[2]) && result[2].equals(paras[2]))
                {
                    GooagooLog.info("收藏精准投放渠道发布的优惠凭证：用户（" + favoriteInfo.getUserId() + "）已收藏过优惠凭证（" + coupon.getCouponId() + "）");
                    throw new AlreadyCollectException("用户（" + favoriteInfo.getUserId() + "）已收藏过优惠凭证（" + coupon.getCouponId() + "）");
                }
            }
            //7、个人已经拥有数量（已用的+未用且未删除的）
            int personalOwnNum = 0;
            criteria.andInfoUrlIsNull().andCouponStatusEqualTo("Y");
            personalOwnNum = this.favoriteInfoGeneratorCoreService.countByExample(queryCondition3);
            criteria.andCouponStatusEqualTo("N").andIsDelEqualTo("N");
            personalOwnNum = personalOwnNum + this.favoriteInfoGeneratorCoreService.countByExample(queryCondition3);
            if (maxOwnNum <= personalOwnNum)
            {
                GooagooLog.info("收藏精准投放渠道发布的优惠凭证：优惠凭证（" + coupon.getCouponId() + "）个人（" + favoriteInfo.getUserId() + "）已经拥有数量（" + personalOwnNum + "）已超过或等于最大拥有数量（" + maxOwnNum + "）");
                throw new AlreadyExceedUserOwnCouponNumException("优惠凭证（" + coupon.getCouponId() + "）个人（" + favoriteInfo.getUserId() + "）已经拥有数量（" + personalOwnNum + "）已超过或等于最大拥有数量（" + maxOwnNum + "）");
            }
            //8、用户已经拥有数量（已用的+未用且未删除的）
            int userOwnNum = 0;
            criteria.andUserIdIsNotNull().andCouponStatusEqualTo("2").andIsDelIsNull();
            userOwnNum = this.favoriteInfoGeneratorCoreService.countByExample(queryCondition3);
            criteria.andCouponStatusNotEqualTo("2").andIsDelEqualTo("N");
            userOwnNum = userOwnNum + this.favoriteInfoGeneratorCoreService.countByExample(queryCondition3);
            if (issueAmount <= userOwnNum)
            {
                GooagooLog.info("收藏精准投放渠道发布的优惠凭证：优惠凭证（" + coupon.getCouponId() + "）用户已经拥有数量（" + userOwnNum + "）已超过或等于发放数量（" + issueAmount + "）");
                throw new CouponExhaustiveException("优惠凭证（" + coupon.getCouponId() + "）用户已经拥有数量（" + userOwnNum + "）已超过或等于发放数量（" + issueAmount + "）");
            }
            //9、保存收藏信息
            if (!this.favoriteInfoGeneratorCoreService.insertSelective(favoriteInfo))
            {
                GooagooLog.error("收藏精准投放渠道发布的优惠凭证：保存收藏信息（" + favoriteInfo.toString() + "）异常", null);
                throw new OperateFailException("保存收藏信息（" + favoriteInfo.toString() + "）异常");
            }
        }

        return true;
    }

    private void synCouponGrantInfo(Coupon coupon, String favoriteId) throws Exception
    {
        if ("2".equals(coupon.getCouponMode()))
        {//优惠凭证模式，2-第三方整合模式
            CouponGrantInfoExample couponGrantInfoExample = new CouponGrantInfoExample();
            couponGrantInfoExample.createCriteria().andCouponIdEqualTo(coupon.getCouponId()).andIsDelEqualTo("N");
            List<CouponGrantInfo> couponGrantInfoList = this.couponGrantInfoGeneratorCoreService.selectByExample(couponGrantInfoExample);
            if (CollectionUtils.isEmpty(couponGrantInfoList))
            {
                GooagooLog.info("收藏收藏广场渠道发布的优惠凭证：优惠凭证（" + coupon.getCouponId() + "）用户已经拥有数量已超过或等于发放数量");
                throw new CouponExhaustiveException("收藏收藏广场渠道发布的优惠凭证：优惠凭证（" + coupon.getCouponId() + "）用户已经拥有数量已超过或等于发放数量");
            }
            for (CouponGrantInfo couponGrantInfo : couponGrantInfoList)
            {
                couponGrantInfo.setCouponAudioId(favoriteId);
                this.couponGrantInfoGeneratorCoreService.updateByPrimaryKeySelective(couponGrantInfo);
            }
        }
    }

}
