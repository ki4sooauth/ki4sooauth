package com.gooagoo.core.business.marketing.integral;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.marketing.integral.IntegralCoreService;
import com.gooagoo.api.generator.core.behave.FavoriteInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.goods.GoodsBaseInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.CouponGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.ShopIntegralConvertGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.ShopIntegralGeneratorCoreService;
import com.gooagoo.api.generator.core.member.IntegralInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.user.ConsigneeInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.member.IntegralProtectedCoreService;
import com.gooagoo.api.protecteds.core.shop.ShopProtectedCoreService;
import com.gooagoo.api.protecteds.core.user.UserProtectedCoreService;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.dao.business.marketing.integral.IntegralBusinessMapper;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.ShopIntegral;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvert;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvertExample;
import com.gooagoo.entity.generator.member.IntegralDetailInfo;
import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.IntegralInfoExample;
import com.gooagoo.exception.business.integral.ExceedConvertNumsException;
import com.gooagoo.exception.business.integral.IntegralNotEnoughException;
import com.gooagoo.exception.business.user.AlreadyCollectException;
import com.gooagoo.exception.common.NoDataException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class IntegralCoreServiceImpl implements IntegralCoreService
{

    @Autowired
    private IntegralBusinessMapper integralBusinessMapper;
    @Autowired
    private ShopIntegralGeneratorCoreService shopIntegralGeneratorCoreService;
    @Autowired
    private ShopIntegralConvertGeneratorCoreService shopIntegralConvertGeneratorCoreService;
    @Autowired
    private ConsigneeInfoGeneratorCoreService consigneeInfoGeneratorCoreService;
    @Autowired
    private IntegralInfoGeneratorCoreService integralInfoGeneratorCoreService;
    @Autowired
    private GoodsBaseInfoGeneratorCoreService goodsBaseInfoGeneratorCoreService;
    @Autowired
    private CouponGeneratorCoreService couponGeneratorCoreService;
    @Autowired
    private FavoriteInfoGeneratorCoreService favoriteInfoGeneratorCoreService;
    @Autowired
    private UserProtectedCoreService userProtectedCoreService;
    @Autowired
    private ShopProtectedCoreService shopProtectedCoreService;
    @Autowired
    private IntegralProtectedCoreService integralProtectedCoreService;

    private final static Object synObject = new Object();//积分兑换优惠凭证同步锁

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean integralExchangeGoods(ShopIntegralConvert shopIntegralConvert) throws Exception
    {
        Date currentTime = new Date();
        //1、校验信息来源
        if (SysdictionaryCache.get("info_source", shopIntegralConvert.getInfoSource()) == null)
        {
            GooagooLog.info("物品兑换：信息来源（" + shopIntegralConvert.getInfoSource() + "）有误");
            throw new OperateFailException("信息来源（" + shopIntegralConvert.getInfoSource() + "）有误");
        }
        //2、校验用户状态
        if (!this.userProtectedCoreService.checkUserStatus(shopIntegralConvert.getUserId()))
        {
            GooagooLog.info("物品兑换：用户（" + shopIntegralConvert.getUserId() + "）状态异常");
            throw new OperateFailException("用户（" + shopIntegralConvert.getUserId() + "）状态异常");
        }
        //3、获取积分营销信息
        ShopIntegral shopIntegral = this.getShopIntegral(shopIntegralConvert.getShopIntegralId(), currentTime);
        //4、校验商家状态
        if (!this.shopProtectedCoreService.checkShopStatus(shopIntegral.getShopId()))
        {
            GooagooLog.info("物品兑换：商家（" + shopIntegral.getShopId() + "）状态异常");
            throw new OperateFailException("商家（" + shopIntegral.getShopId() + "）状态异常");
        }
        //5、校验用户积分是否充足
        this.checkIntegralInfo(shopIntegralConvert.getUserId(), shopIntegral.getShopId(), shopIntegral.getTradeIntegralValue());
        synchronized (synObject)
        {
            //6、校验是否超过兑换次数
            ShopIntegralConvertExample shopIntegralConvertExample = new ShopIntegralConvertExample();
            shopIntegralConvertExample.createCriteria().andShopIntegralIdEqualTo(shopIntegralConvert.getShopIntegralId());
            Integer alreadyConvertNums = this.shopIntegralConvertGeneratorCoreService.countByExample(shopIntegralConvertExample);
            if (shopIntegral.getConvertNums() <= alreadyConvertNums)
            {
                throw new ExceedConvertNumsException("物品兑换:已超过兑换次数[shopIntegralId=" + shopIntegralConvert.getShopIntegralId() + "、已兑换" + alreadyConvertNums + "次、可兑换" + shopIntegral.getConvertNums() + "次]");
            }
            //7、处理兑换
            if ("C".equals(shopIntegral.getIntegralTradeType()))
            {
                //6.1、兑换优惠凭证
                this.dealConvertCoupon(shopIntegral, shopIntegralConvert, currentTime);
            }
            else if ("G".equals(shopIntegral.getIntegralTradeType()))
            {
                //6.2、兑换商品
                this.dealConvertGoods(shopIntegral, shopIntegralConvert, currentTime);
            }
        }
        return true;
    }

    @Override
    public boolean addIntegralExchange(ShopIntegral shopIntegral) throws Exception
    {
        shopIntegral.setIsDel("N");
        return this.shopIntegralGeneratorCoreService.insertSelective(shopIntegral);
    }

    @Override
    public boolean updateIntegralExchange(ShopIntegral shopIntegral) throws Exception
    {
        return this.shopIntegralGeneratorCoreService.updateByPrimaryKeySelective(shopIntegral);
    }

    @Override
    public boolean deleteIntegralExchange(String shopIntegralId) throws Exception
    {
        if (!org.springframework.util.StringUtils.hasText(shopIntegralId))
        {
            GooagooLog.warn("删除积分兑换信息：积分兑换信息Id为空");
            return false;
        }
        return this.shopIntegralGeneratorCoreService.deleteByPrimaryKey(shopIntegralId);
    }

    @Override
    public boolean integralSpecialApproval(String shopId, String userId, String integralNumber, String note) throws Exception
    {
        IntegralDetailInfo integralDetailInfo = new IntegralDetailInfo();
        integralDetailInfo.setShopId(shopId);
        integralDetailInfo.setUserId(userId);
        integralDetailInfo.setIntegralNumber(Integer.parseInt(integralNumber));
        integralDetailInfo.setIntegralSource("X");//特批
        integralDetailInfo.setNote(note);
        //调用统一服务接口平台方法
        if (Integer.parseInt(integralNumber) > 0)
        {//特批增加积分
            return this.integralProtectedCoreService.increaseIntegralAndUpgradeCard(integralDetailInfo);
        }
        else
        {//特批减少积分
            return this.integralProtectedCoreService.dealUserIntegralInfo(integralDetailInfo, false);
        }
    }

    /**
     * 获取积分兑换信息
     * @param shopIntegralId 积分营销ID
     * @param currentTime 当前时间
     * @return
     * @throws NoDataException 
     * @throws OperateFailException 
     */
    private ShopIntegral getShopIntegral(String shopIntegralId, Date currentTime) throws Exception
    {
        ShopIntegral shopIntegral = this.shopIntegralGeneratorCoreService.selectByPrimaryKey(shopIntegralId);
        if (shopIntegral == null || "Y".equals(shopIntegral.getIsDel()))
        {
            GooagooLog.info("获取积分兑换信息：兑换信息（" + shopIntegralId + "）不存在或已被删除");
            throw new NoDataException("兑换信息（" + shopIntegralId + "）不存在或已被删除");
        }
        if (currentTime.before(shopIntegral.getTradeStartTime()))
        {
            GooagooLog.info("获取积分兑换信息：积分兑换（" + shopIntegral.getShopIntegralId() + "）信息未生效");
            throw new NoDataException("积分兑换（" + shopIntegral.getShopIntegralId() + "）信息未生效");
        }
        if (currentTime.after(shopIntegral.getTradeEndTime()))
        {
            GooagooLog.info("获取积分兑换信息：积分兑换（" + shopIntegral.getShopIntegralId() + "）信息已过期");
            throw new NoDataException("积分兑换（" + shopIntegral.getShopIntegralId() + "）信息已过期");
        }
        if (!("C".equals(shopIntegral.getIntegralTradeType()) || "G".equals(shopIntegral.getIntegralTradeType())))
        {
            GooagooLog.info("获取积分兑换信息：暂不支持兑换积分商城（" + shopIntegralId + "）中的兑换物类型（" + shopIntegral.getIntegralTradeType() + "）");
            throw new OperateFailException("暂不支持兑换积分商城（" + shopIntegralId + "）中的兑换物类型（" + shopIntegral.getIntegralTradeType() + "）");
        }

        return shopIntegral;
    }

    /**
     * 校验用户积分是否充足
     * @param userId
     * @param shopId
     * @param needIntegralValue
     * @return
     * @throws IntegralNotEnoughException 
     */
    private boolean checkIntegralInfo(String userId, String shopId, Integer needIntegralValue) throws Exception
    {
        IntegralInfoExample queryCondition = new IntegralInfoExample();
        queryCondition.createCriteria().andShopIdEqualTo(shopId).andUserIdEqualTo(userId).andIsDelEqualTo("N");
        List<IntegralInfo> integralInfoList = this.integralInfoGeneratorCoreService.selectByExample(queryCondition);
        if (CollectionUtils.isEmpty(integralInfoList))
        {
            if (needIntegralValue != 0)
            {
                GooagooLog.info("积分兑换：所需积分不为0时用户（" + userId + "）未持有商家（" + shopId + "）积分异常");
                throw new IntegralNotEnoughException("积分兑换：所需积分不为0时用户（" + userId + "）未持有商家（" + shopId + "）积分异常");
            }
        }
        else if (integralInfoList.size() != 1)
        {
            GooagooLog.info("积分兑换：用户（" + userId + "）持有商家（" + shopId + "）积分异常");
            throw new IntegralNotEnoughException("积分兑换：用户（" + userId + "）持有商家（" + shopId + "）积分异常");
        }
        else
        {
            IntegralInfo integralInfo = integralInfoList.get(0);
            if (integralInfo.getUseableIntegralNumber() < needIntegralValue)
            {
                GooagooLog.info("积分兑换：用户（" + integralInfo.getUserId() + "）持有的商家（" + integralInfo.getShopId() + "）积分（" + integralInfo.getUseableIntegralNumber() + "）不足（" + needIntegralValue + "）");
                throw new IntegralNotEnoughException("用户（" + integralInfo.getUserId() + "）持有的商家（" + integralInfo.getShopId() + "）积分（" + integralInfo.getUseableIntegralNumber() + "）不足（" + needIntegralValue + "）");
            }
        }
        return true;
    }

    /**
     * 积分兑换优惠凭证
     * @param shopIntegral
     * @param shopIntegralConvert
     * @param currentTime
     * @return
     * @throws AlreadyCollectException
     * @throws OperateFailException
     */
    private boolean dealConvertCoupon(ShopIntegral shopIntegral, ShopIntegralConvert shopIntegralConvert, Date currentTime) throws Exception
    {
        //1、获取优惠凭证信息
        Coupon coupon = this.couponGeneratorCoreService.selectByPrimaryKey(shopIntegral.getIntegralTradeId());
        if (coupon == null || "Y".equals(coupon.getIsDel()))
        {
            GooagooLog.info("积分兑换优惠凭证：优惠凭证（" + coupon.getCouponId() + "）不存在或已被删除");
            throw new OperateFailException("优惠凭证（" + coupon.getCouponId() + "）不存在或已被删除");
        }
        if (!"0".equals(coupon.getCouponChannle()))
        {
            GooagooLog.info("积分兑换优惠凭证：优惠凭证（" + coupon.getCouponId() + "）发布渠道（" + coupon.getCouponChannle() + "）有误，不允许兑换");
            throw new OperateFailException("优惠凭证（" + coupon.getCouponId() + "）发布渠道（" + coupon.getCouponChannle() + "）有误，不允许兑换");
        }
        //2、组装兑换日志信息
        shopIntegralConvert.setShopIntegralConvertId(UUID.getUUID());
        shopIntegralConvert.setShopId(shopIntegral.getShopId());
        shopIntegralConvert.setIntegralTradeType(shopIntegral.getIntegralTradeType());
        shopIntegralConvert.setIntegralTradeId(shopIntegral.getIntegralTradeId());
        shopIntegralConvert.setTradeIntegralValue(shopIntegral.getTradeIntegralValue());
        shopIntegralConvert.setConvertTime(currentTime);
        shopIntegralConvert.setIsDel("N");//是否删除
        //3、组装积分明细信息
        IntegralDetailInfo integralDetailInfo = new IntegralDetailInfo();
        integralDetailInfo.setIntegralId(UUID.getUUID());//积分明细编号，UUID
        integralDetailInfo.setUserId(shopIntegralConvert.getUserId());//用户编号
        integralDetailInfo.setShopId(shopIntegralConvert.getShopId());//商家编号
        integralDetailInfo.setIntegralNumber(-shopIntegralConvert.getTradeIntegralValue());//积分数量
        integralDetailInfo.setIntegralSource("C");//积分来源：兑换
        integralDetailInfo.setIntegralCreateTime(currentTime);//积分产生时间
        integralDetailInfo.setNote(shopIntegralConvert.getShopIntegralConvertId());//积分兑换日志ID
        integralDetailInfo.setIsFreez("N");//是否冻结，N-未冻结，Y-已冻结
        integralDetailInfo.setIsDel("N");//是否删除，Y-已删除，N-未删除
        //4、组装收藏信息
        FavoriteInfo favoriteInfo = new FavoriteInfo();
        favoriteInfo.setFavoriteId(UUID.getUUID());
        favoriteInfo.setUserId(shopIntegralConvert.getUserId());
        favoriteInfo.setShopId(coupon.getShopId());
        favoriteInfo.setInfoTitle(coupon.getCouponName());
        favoriteInfo.setInfoType("C");
        try
        {
            favoriteInfo.setInfoUrl(UrlUtils.getCouponUrl(coupon.getCouponId()));
        }
        catch (Exception e)
        {
            GooagooLog.error("积分兑换优惠凭证：生成优惠凭证（" + coupon.getCouponId() + "）访问地址异常", e);
            throw new OperateFailException("生成优惠凭证（" + coupon.getCouponId() + "）访问地址异常");
        }
        favoriteInfo.setObjectId(coupon.getCouponId());
        favoriteInfo.setSource(shopIntegralConvert.getInfoSource());
        favoriteInfo.setCouponStatus("0");
        favoriteInfo.setIsDel("N");
        //5、个人最大拥有数量
        int maxOwnNum = coupon.getMaxNumOwner();
        //6、个人已经拥有数量（已用的+未用且未删除的）
        int personalOwnNum = 0;
        //7、发放数量
        int issueAmount = coupon.getAmount();
        FavoriteInfoExample queryCondition1 = new FavoriteInfoExample();
        queryCondition1.createCriteria().andUserIdEqualTo(favoriteInfo.getUserId()).andShopIdEqualTo(coupon.getShopId()).andInfoTypeEqualTo("C").andObjectIdEqualTo(coupon.getCouponId()).andCouponStatusEqualTo("2");
        personalOwnNum = this.favoriteInfoGeneratorCoreService.countByExample(queryCondition1);
        FavoriteInfoExample queryCondition2 = new FavoriteInfoExample();
        queryCondition2.createCriteria().andUserIdEqualTo(favoriteInfo.getUserId()).andShopIdEqualTo(coupon.getShopId()).andInfoTypeEqualTo("C").andObjectIdEqualTo(coupon.getCouponId()).andCouponStatusNotEqualTo("2").andIsDelEqualTo("N");
        personalOwnNum = personalOwnNum + this.favoriteInfoGeneratorCoreService.countByExample(queryCondition2);
        if (maxOwnNum <= personalOwnNum)
        {
            GooagooLog.info("积分兑换优惠凭证：优惠凭证（" + coupon.getCouponId() + "）个人（" + favoriteInfo.getUserId() + "）已经拥有数量（" + personalOwnNum + "）已超过或等于最大拥有数量（" + maxOwnNum + "）");
            throw new AlreadyCollectException("优惠凭证（" + coupon.getCouponId() + "）个人（" + favoriteInfo.getUserId() + "）已经拥有数量（" + personalOwnNum + "）已超过或等于最大拥有数量（" + maxOwnNum + "）");
        }
        //8、用户已经拥有数量（已用的+未用且未删除的）
        int userOwnNum = 0;
        FavoriteInfoExample queryCondition3 = new FavoriteInfoExample();
        queryCondition3.createCriteria().andShopIdEqualTo(coupon.getShopId()).andInfoTypeEqualTo("C").andObjectIdEqualTo(coupon.getCouponId()).andUserIdIsNotNull().andCouponStatusEqualTo("2").andIsDelIsNotNull();
        userOwnNum = this.favoriteInfoGeneratorCoreService.countByExample(queryCondition3);
        FavoriteInfoExample queryCondition4 = new FavoriteInfoExample();
        queryCondition4.createCriteria().andUserIdEqualTo(favoriteInfo.getUserId()).andShopIdEqualTo(coupon.getShopId()).andInfoTypeEqualTo("C").andObjectIdEqualTo(coupon.getCouponId()).andCouponStatusNotEqualTo("2").andIsDelEqualTo("N");
        userOwnNum = userOwnNum + this.favoriteInfoGeneratorCoreService.countByExample(queryCondition4);
        if (issueAmount <= userOwnNum)
        {
            GooagooLog.info("积分兑换优惠凭证：优惠凭证（" + coupon.getCouponId() + "）用户已经拥有数量（" + userOwnNum + "）已超过或等于发放数量（" + issueAmount + "）");
            throw new OperateFailException("优惠凭证（" + coupon.getCouponId() + "）用户已经拥有数量（" + userOwnNum + "）已超过或等于发放数量（" + issueAmount + "）");
        }
        //9、保存信息
        if (!this.shopIntegralConvertGeneratorCoreService.insertSelective(shopIntegralConvert))
        {
            GooagooLog.error("积分兑换优惠凭证：保存兑换信息（" + shopIntegralConvert.toString() + "）异常", null);
            throw new OperateFailException("保存兑换信息（" + shopIntegralConvert.toString() + "）异常");
        }
        if (!this.integralProtectedCoreService.dealUserIntegralInfo(integralDetailInfo, false))
        {
            GooagooLog.error("积分兑换优惠凭证：保存积分信息（" + integralDetailInfo.toString() + "）异常", null);
            throw new OperateFailException("保存积分信息（" + integralDetailInfo.toString() + "）异常");
        }
        if (!this.favoriteInfoGeneratorCoreService.insertSelective(favoriteInfo))
        {
            GooagooLog.error("积分兑换优惠凭证：保存收藏信息（" + favoriteInfo.toString() + "）异常", null);
            throw new OperateFailException("保存收藏信息（" + favoriteInfo.toString() + "）异常");
        }
        return true;
    }

    /**
     * 积分兑换商品
     * @param shopIntegral
     * @param shopIntegralConvert
     * @param currentTime
     * @throws NullException
     * @throws OperateFailException
     */
    private boolean dealConvertGoods(ShopIntegral shopIntegral, ShopIntegralConvert shopIntegralConvert, Date currentTime) throws Exception
    {
        //1、校验收货地址
        if (StringUtils.isBlank(shopIntegralConvert.getConsigneeId()))
        {
            GooagooLog.info("物品兑换：收货地址（" + shopIntegralConvert.getConsigneeId() + "）为空");
            throw new NullException("收货地址（" + shopIntegralConvert.getConsigneeId() + "）为空");
        }
        if (this.consigneeInfoGeneratorCoreService.selectByPrimaryKey(shopIntegralConvert.getConsigneeId()) == null)
        {
            GooagooLog.info("物品兑换：收货地址（" + shopIntegralConvert.getConsigneeId() + "）不存在或已被删除");
            throw new OperateFailException("收货地址（" + shopIntegralConvert.getConsigneeId() + "）不存在或已被删除");
        }
        //2、获取商品信息
        GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorCoreService.selectByPrimaryKey(shopIntegral.getIntegralTradeId());
        if (goodsBaseInfo == null || "Y".equals(goodsBaseInfo.getIsDel()))
        {
            GooagooLog.info("积分兑换商品：商品（" + goodsBaseInfo.getGoodsId() + "）不存在或已被删除");
            throw new OperateFailException("商品（" + goodsBaseInfo.getGoodsId() + "）不存在或已被删除");
        }
        //3、组装兑换日志信息
        shopIntegralConvert.setShopIntegralConvertId(UUID.getUUID());
        shopIntegralConvert.setShopId(shopIntegral.getShopId());
        shopIntegralConvert.setIntegralTradeType(shopIntegral.getIntegralTradeType());
        shopIntegralConvert.setIntegralTradeId(shopIntegral.getIntegralTradeId());
        shopIntegralConvert.setTradeIntegralValue(shopIntegral.getTradeIntegralValue());
        shopIntegralConvert.setConvertTime(currentTime);
        shopIntegralConvert.setDeliveryStatus("0");
        shopIntegralConvert.setIsDel("N");
        //4、组装积分明细信息
        IntegralDetailInfo integralDetailInfo = new IntegralDetailInfo();
        integralDetailInfo.setIntegralId(UUID.getUUID());
        integralDetailInfo.setUserId(shopIntegralConvert.getUserId());
        integralDetailInfo.setShopId(shopIntegralConvert.getShopId());
        integralDetailInfo.setIntegralNumber(-shopIntegralConvert.getTradeIntegralValue());
        integralDetailInfo.setIntegralSource("C");
        integralDetailInfo.setIntegralCreateTime(currentTime);
        integralDetailInfo.setNote(shopIntegralConvert.getShopIntegralConvertId());
        integralDetailInfo.setIsFreez("N");
        integralDetailInfo.setIsDel("N");
        //5、保存信息
        if (!this.shopIntegralConvertGeneratorCoreService.insertSelective(shopIntegralConvert))
        {
            GooagooLog.error("积分兑换商品：保存兑换信息（" + shopIntegralConvert.toString() + "）异常", null);
            throw new OperateFailException("保存兑换信息（" + shopIntegralConvert.toString() + "）异常");
        }
        if (!this.integralProtectedCoreService.dealUserIntegralInfo(integralDetailInfo, false))
        {
            GooagooLog.error("积分兑换商品：保存积分信息（" + integralDetailInfo.toString() + "）异常", null);
            throw new OperateFailException("保存积分信息（" + integralDetailInfo.toString() + "）异常");
        }

        return true;
    }

    @Override
    public boolean updateDeliveryStatusToConfirm(String shopIntegralConvertId) throws Exception
    {
        if (!org.springframework.util.StringUtils.hasText(shopIntegralConvertId))
        {
            GooagooLog.warn("发货状态更新到用户已收取货物:主键为空");
            return false;
        }
        ShopIntegralConvert shopIntegralConvert = new ShopIntegralConvert();
        shopIntegralConvert.setShopIntegralConvertId(shopIntegralConvertId);
        shopIntegralConvert.setDeliveryStatus("2");
        shopIntegralConvert.setCTimeStamp(new Date());
        return this.shopIntegralConvertGeneratorCoreService.updateByPrimaryKeySelective(shopIntegralConvert);
    }

    @Override
    public boolean receiveIntegral(IntegralDetailInfo integralDetailInfo) throws Exception
    {
        return this.integralProtectedCoreService.increaseIntegralAndUpgradeCard(integralDetailInfo);
    }

}
