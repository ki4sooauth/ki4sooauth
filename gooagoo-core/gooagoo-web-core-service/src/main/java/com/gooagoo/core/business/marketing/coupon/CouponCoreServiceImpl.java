package com.gooagoo.core.business.marketing.coupon;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.marketing.coupon.CouponCoreService;
import com.gooagoo.api.generator.core.behave.FavoriteInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OrderCouponInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.CouponGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.CouponGrantInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.publish.PublishProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderCouponInfoExample;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.CouponGrantInfo;
import com.gooagoo.entity.generator.marketing.CouponGrantInfoExample;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.common.NullException;

@Service
public class CouponCoreServiceImpl implements CouponCoreService
{
    @Autowired
    private CouponGeneratorCoreService couponGeneratorCoreService;
    @Autowired
    private OrderCouponInfoGeneratorCoreService orderCouponInfoGeneratorCoreService;
    @Autowired
    private PublishProtectedCoreService publishProtectedCoreService;
    @Autowired
    private CouponGrantInfoGeneratorCoreService couponGrantInfoGeneratorCoreService;
    @Autowired
    private FavoriteInfoGeneratorCoreService favoriteInfoGeneratorCoreService;

    @Override
    public boolean deleteCoupon(String couponId) throws Exception
    {
        if (!StringUtils.hasText(couponId))
        {
            GooagooLog.warn("删除优惠凭证：优惠凭证Id为空");
            return false;
        }
        return this.couponGeneratorCoreService.deleteByPrimaryKey(couponId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addCoupon(Coupon coupon, List<String> couponNoList) throws Exception
    {
        if (coupon == null)
        {
            throw new NullException("添加优惠凭证,coupon为空");
        }
        if (!StringUtils.hasText(coupon.getCouponMode()))
        {
            throw new NullException("添加优惠凭证,couponMode为空");
        }
        coupon.setIsDel("N");
        coupon.setPublishStatus("W");
        this.batchCreateCouponGrantInfo(coupon, couponNoList, "add");
        return this.couponGeneratorCoreService.insertSelective(coupon);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateCoupon(Coupon coupon, List<String> couponNoList) throws Exception
    {
        if (coupon == null)
        {
            throw new NullException("添加优惠凭证,coupon为空");
        }
        if (!StringUtils.hasText(coupon.getCouponMode()))
        {
            throw new NullException("添加优惠凭证,couponMode为空");
        }
        //只有未发布状态才允许更新操作
        if (StringUtils.hasText(coupon.getPublishStatus()) && "P".equals(coupon.getPublishStatus()))
        {
            throw new GooagooException("该优惠凭证已发布不能做更新操作 [couponId=" + coupon.getCouponId() + "]");
        }
        coupon.setPublishStatus("W");
        this.batchCreateCouponGrantInfo(coupon, couponNoList, "update");
        return this.couponGeneratorCoreService.updateByPrimaryKeySelective(coupon);
    }

    @Override
    public boolean reviewedCoupon(String couponId, String status, String note) throws Exception
    {
        Coupon coupon = this.couponGeneratorCoreService.selectByPrimaryKey(couponId);
        if (coupon == null)
        {
            GooagooLog.warn("审核优惠凭证：优惠凭证不存在，couponId=" + couponId);
            return false;
        }
        if (!"W".equals(coupon.getPublishStatus()))
        {
            GooagooLog.warn("审核优惠凭证：优惠凭证状态不是待审核，couponId=" + couponId + ",publishStatus=" + coupon.getPublishStatus());
            return false;
        }
        if ("1".equals(coupon.getCouponMode()) || "2".equals(coupon.getCouponMode()))
        {
            CouponGrantInfoExample couponGrantInfoExample = new CouponGrantInfoExample();
            couponGrantInfoExample.createCriteria().andCouponIdEqualTo(couponId).andCouponNoIsNotNull().andIsDelEqualTo("N");
            List<CouponGrantInfo> couponGrantInfoList = this.couponGrantInfoGeneratorCoreService.selectByExample(couponGrantInfoExample);
            if (CollectionUtils.isEmpty(couponGrantInfoList))
            {
                throw new NullException("添加优惠凭证,开放模式下号段为空");
            }
        }
        Coupon reviewed = new Coupon();
        reviewed.setCouponId(couponId);
        reviewed.setAuditNote(note);
        reviewed.setPublishStatus("Y".equals(status) ? "A" : "B");
        return this.couponGeneratorCoreService.updateByPrimaryKeySelective(reviewed);
    }

    @Override
    public boolean publishCoupon(String couponId) throws Exception
    {
        Coupon coupon = this.couponGeneratorCoreService.selectByPrimaryKey(couponId);
        if (coupon == null)
        {
            GooagooLog.warn("发布优惠凭证：优惠凭证不存在，couponId=" + couponId);
            return false;
        }
        if (!"A".equals(coupon.getPublishStatus()))
        {
            GooagooLog.warn("发布优惠凭证：优惠凭证状态不是待发布，couponId=" + couponId + ",publishStatus=" + coupon.getPublishStatus());
            return false;
        }
        coupon.setPublishStatus("P");
        //生成静态页面
        if (!this.publishProtectedCoreService.generateHtml(coupon))
        {
            GooagooLog.info("生成优惠券静态页面失败[couponId=" + couponId + "]");
            return false;
        }
        return this.couponGeneratorCoreService.updateByPrimaryKeySelective(coupon);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean confirmCoupon(String orderid, List<Map<String, String>> agreeyList) throws Exception
    {
        if (CollectionUtils.isNotEmpty(agreeyList))
        {
            for (Map<String, String> agreeyMap : agreeyList)
            {
                FavoriteInfo favoriteInfo = new FavoriteInfo();
                OrderCouponInfo orderCouponInfo = new OrderCouponInfo();
                if ("N".equals(agreeyMap.get("agreetype")))//商家确认不可用
                {
                    favoriteInfo.setCouponStatus("0");//未使用
                    orderCouponInfo.setStatus("3");//3-商家确认不可使用

                }
                else if ("Y".equals(agreeyMap.get("agreetype")))//商家确认可用
                {
                    favoriteInfo.setCouponStatus("2");//已使用
                    favoriteInfo.setUseTime(new Date());//使用时间
                    orderCouponInfo.setStatus("2");//2-商家确认可使用
                }
                orderCouponInfo.setIsDeal("Y");//商家已处理
                orderCouponInfo.setDealTime(new Date());//商家处理时间
                FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
                favoriteInfoExample.createCriteria().andFavoriteIdEqualTo(agreeyMap.get("favoriteid")).andIsDelEqualTo("N");
                this.favoriteInfoGeneratorCoreService.updateByExampleSelective(favoriteInfo, favoriteInfoExample);//更新收藏优惠券信息
                OrderCouponInfoExample orderCouponInfoExample = new OrderCouponInfoExample();
                orderCouponInfoExample.createCriteria().andOrderIdEqualTo(orderid).andCouponUserIdEqualTo(agreeyMap.get("favoriteid")).andIsDelEqualTo("N");
                this.orderCouponInfoGeneratorCoreService.updateByExampleSelective(orderCouponInfo, orderCouponInfoExample);//更新订单优惠凭证详情
            }
        }
        else
        {
            return false;
        }
        return true;
    }

    /**
     * 批量生成优惠凭证发放号段对应信息
     * @param coupon
     * @param couponNoList
     * @param methodType 方法类型[add、update]
     * @throws Exception
     */
    private void batchCreateCouponGrantInfo(Coupon coupon, List<String> couponNoList, String methodType) throws Exception
    {
        //更新优惠券时清空[优惠凭证发放号段对应信息]后重新生成 
        if ("update".equals(methodType))
        {
            CouponGrantInfoExample couponGrantInfoExample = new CouponGrantInfoExample();
            couponGrantInfoExample.createCriteria().andCouponIdEqualTo(coupon.getCouponId());
            this.couponGrantInfoGeneratorCoreService.physicalDeleteByExample(couponGrantInfoExample);
        }
        //1-开放模式，2-第三方整合模式时、批量生成优惠凭证发放号段对应信息
        if ("1".equals(coupon.getCouponMode()) || "2".equals(coupon.getCouponMode()))//0-平台默认模式，1-开放模式，2-第三方整合模式
        {
            for (String couponNo : couponNoList)
            {
                CouponGrantInfo couponGrantInfo = new CouponGrantInfo();
                couponGrantInfo.setId(UUID.getUUID());//自动编号，UUID
                couponGrantInfo.setCouponId(coupon.getCouponId());//优惠凭证编号
                couponGrantInfo.setCouponNo(couponNo);//号段号码
                couponGrantInfo.setIsDel("N");//是否删除，Y-已删除，N-未删除
                this.couponGrantInfoGeneratorCoreService.insertSelective(couponGrantInfo);
            }
        }
    }

}