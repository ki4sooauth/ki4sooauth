package com.gooagoo.igms.marketing.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.marketing.coupon.CouponCoreService;
import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.CouponGrantInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.CouponExample;
import com.gooagoo.entity.generator.marketing.CouponExample.Criteria;
import com.gooagoo.entity.generator.marketing.CouponGrantInfo;
import com.gooagoo.entity.generator.marketing.CouponGrantInfoExample;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.marketing.service.CouponService;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FCoupon;
import com.gooagoo.view.gms.marketing.FCouponGrantInfo;
import com.gooagoo.view.gms.marketing.FCouponJson;
import com.google.gson.Gson;

@Service(value = "couponService")
public class CouponServiceImpl implements CouponService
{
    @Autowired
    private CouponGeneratorQueryService couponQueryService;
    @Autowired
    private CouponCoreService couponCoreService;
    @Autowired
    private CouponGrantInfoGeneratorQueryService couponGrantInfoGeneratorQueryService;

    @Override
    public TransData<Object> add(HttpServletRequest request) throws Exception
    {
        FCoupon fcoupon = ServletUtils.objectMethod(FCoupon.class, request);
        fcoupon.setCouponId(StringUtils.getUUID());
        FCouponJson couponJson = ServletUtils.objectMethod(FCouponJson.class, request);
        fcoupon.setCheckJson(new Gson().toJson(couponJson));
        fcoupon.setCouponSource("0");
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        fcoupon.setShopId(shopId);
        //将时间设置成午夜12点
        Date dps = GMSUtil.getEarlyMorning(fcoupon.getPublishStartTime());
        Date dpe = GMSUtil.getMidNight(fcoupon.getPublishEndTime());
        Date dus = GMSUtil.getEarlyMorning(fcoupon.getUseStartTime());
        Date due = GMSUtil.getMidNight(fcoupon.getUseEndTime());
        fcoupon.setPublishStartTime(dps);
        fcoupon.setPublishEndTime(dpe);
        fcoupon.setUseStartTime(dus);
        fcoupon.setUseEndTime(due);

        Coupon coupon = this.convertToCoupon(fcoupon);
        coupon.setCreateTime(new Date());

        List<String> couponNoList = new ArrayList<String>();
        if (!fcoupon.getCouponMode().equals("0"))
        {
            couponNoList.add(fcoupon.getCouponNo());
        }
        boolean r = this.checkCoupon(coupon);
        if (r)
        {
            r = this.couponCoreService.addCoupon(coupon, couponNoList);
        }

        return GMSUtil.getBooleanResult(r, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
    }

    @Override
    public TransData<Object> update(HttpServletRequest request) throws Exception
    {

        FCoupon fcoupon = ServletUtils.objectMethod(FCoupon.class, request);
        String couponId = request.getParameter("id");
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        fcoupon.setShopId(shopId);
        FCouponJson couponJson = ServletUtils.objectMethod(FCouponJson.class, request);
        fcoupon.setCheckJson(new Gson().toJson(couponJson));
        //将时间设置成午夜12点
        fcoupon.setPublishStartTime(GMSUtil.getEarlyMorning(fcoupon.getPublishStartTime()));
        fcoupon.setPublishEndTime(GMSUtil.getMidNight(fcoupon.getPublishEndTime()));
        fcoupon.setUseStartTime(GMSUtil.getEarlyMorning(fcoupon.getUseStartTime()));
        fcoupon.setUseEndTime(GMSUtil.getMidNight(fcoupon.getUseEndTime()));
        Coupon coupon = this.convertToCoupon(fcoupon);
        List<String> couponNoList = new ArrayList<String>();
        //开发模式

        if (fcoupon.getCouponMode() != null)
        {
            if (fcoupon.getCouponMode().equals("1"))
            {
                couponNoList.add(fcoupon.getCouponNo());
            }
        }
        //第三方整合模式导入excel时
        if (couponId != null)
        {
            coupon = this.couponQueryService.selectByPrimaryKey(couponId);
            if (coupon != null && coupon.getCouponMode().equals("2") && !coupon.getPublishStatus().equals("P"))
            {
                couponNoList.addAll(JsonUtils.json2List(request.getParameter("cnl")));

            }
        }

        boolean r = this.checkCoupon(coupon);
        if (r)
        {
            r = this.couponCoreService.updateCoupon(coupon, couponNoList);

        }

        return GMSUtil.getBooleanResult(r, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);

    }

    @Override
    public TransData<Object> delete(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");

        boolean r = this.couponCoreService.deleteCoupon(id);

        return GMSUtil.getBooleanResult(r, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
    }

    @Override
    public TransData<Object> check(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        String content = ServletRequestUtils.getStringParameter(request, "content", "");
        String status = ServletRequestUtils.getStringParameter(request, "status", "N");

        boolean r = this.couponCoreService.reviewedCoupon(id, status, content);

        return GMSUtil.getBooleanResult(r, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
    }

    @Override
    public TransData<Object> release(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");

        boolean r = this.couponCoreService.publishCoupon(id);

        return GMSUtil.getBooleanResult(r, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
    }

    @Override
    public TransData<FCoupon> getCoupon(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");

        Coupon coupon = this.couponQueryService.selectByPrimaryKey(id);
        FCoupon fc = this.convertToFCoupon(coupon);
        if (coupon.getCouponMode().equals("1"))
        {
            CouponGrantInfoExample example = new CouponGrantInfoExample();
            com.gooagoo.entity.generator.marketing.CouponGrantInfoExample.Criteria c = example.createCriteria();
            c.andCouponIdEqualTo(coupon.getCouponId());
            List<CouponGrantInfo> info = this.couponGrantInfoGeneratorQueryService.selectByExample(example);
            fc.setCouponNo(info.get(0).getCouponNo());

        }
        return new TransData<FCoupon>(true, MessageConst.GMS_OPERATE_SUCCESS, fc);
    }

    @Override
    public TransData<PageModel<FCoupon>> pageCoupon(HttpServletRequest request) throws Exception
    {
        FCoupon coupon = ServletUtils.objectMethod(FCoupon.class, request);
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        //以下是控制关联优惠券类型 积分商城渠道0 手机端1（收藏广场） 有关活动吆喝、通知等渠道2（精确投放）
        String relaCoupon = ServletRequestUtils.getStringParameter(request, "relaCoupon", "");

        if (relaCoupon.equals("integral"))
        {
            coupon.setCouponChannle("0");
        }
        else if (relaCoupon.equals("active"))
        {
            coupon.setCouponChannle("2");
        }
        //判断优惠凭证来源 0商家创建 其他123为系统生成
        String cType = ServletRequestUtils.getStringParameter(request, "cType", "0");
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);
        if (pc.getPageSize() == 0)
        {
            pc.setPageSize(10);
        }

        PageModel<FCoupon> pm = new PageModel<FCoupon>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());

        CouponExample example = new CouponExample();
        example.setPage(pc.getPageIndex(), pc.getPageSize());
        example.setOrderByClause("c_time_stamp desc ");

        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(cType))
        {
            if (cType.equals("0"))
            {
                criteria.andCouponSourceEqualTo(cType);
            }
            else
            {
                List<String> source = new ArrayList<String>();
                source.add(0, "1");
                source.add(1, "2");
                source.add(2, "3");
                criteria.andCouponSourceIn(source);
            }

        }
        if (org.springframework.util.StringUtils.hasText(coupon.getCouponChannle()))
        {
            criteria.andCouponChannleEqualTo(coupon.getCouponChannle());
        }
        if (org.springframework.util.StringUtils.hasText(coupon.getCouponName()))
        {
            criteria.andCouponNameLike("%" + coupon.getCouponName() + "%");
        }
        if (org.springframework.util.StringUtils.hasText(coupon.getStatus()))
        {
            criteria.andPublishStatusEqualTo(coupon.getStatus());
        }
        if (org.springframework.util.StringUtils.hasText(coupon.getCouponType()))
        {
            criteria.andCouponTypeEqualTo(coupon.getCouponType());
        }
        if (org.springframework.util.StringUtils.hasText(coupon.getCouponMode()))
        {
            criteria.andCouponModeEqualTo(coupon.getCouponMode());
        }

        int count = this.couponQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<Coupon> list = this.couponQueryService.selectByExample(example);
            for (Coupon c : list)
            {
                pm.getResult().add(this.convertToFCoupon(c));

            }
        }

        return new TransData<PageModel<FCoupon>>(true, MessageConst.GMS_OPERATE_SUCCESS, pm);
    }

    /**
     * @param coupon
     * @return
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    private Coupon convertToCoupon(FCoupon coupon) throws IllegalArgumentException, IllegalAccessException
    {
        Coupon cp = null;
        if (coupon != null)
        {
            cp = new Coupon();
            EntityTools.copyValue(coupon, cp);
            cp.setPublishStatus(coupon.getStatus());
            cp.setAuditNote(coupon.getNote());
            cp.setIsDel("N");
            cp.setPublishStatus("W");
            cp.setCTimeStamp(new Date());
        }
        return cp;
    }

    private FCoupon convertToFCoupon(Coupon cp) throws Exception
    {
        FCoupon coupon = null;
        if (cp != null)
        {
            coupon = new FCoupon();
            EntityTools.copyValue(cp, coupon);
            String webVisitUrl = "";
            if ("P".equals(cp.getPublishStatus()))
            {
                webVisitUrl = UrlUtils.getCouponUrl(cp.getCouponId());
            }
            coupon.setWebVisitUrl(webVisitUrl);
            coupon.setStatus(cp.getPublishStatus());
            coupon.setNote(cp.getAuditNote());
            coupon.setfCouponJson(new Gson().fromJson(cp.getCheckJson(), FCouponJson.class));
        }
        return coupon;
    }

    private FCouponGrantInfo convertToFCouponGrantInfo(CouponGrantInfo cinfo) throws IllegalArgumentException, IllegalAccessException
    {
        FCouponGrantInfo info = null;
        if (cinfo != null)
        {
            info = new FCouponGrantInfo();
            EntityTools.copyValue(cinfo, info);
        }
        return info;
    }

    private boolean checkCoupon(Coupon coupon)
    {
        if (coupon == null)
        {

            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(coupon.getCouponId()) || coupon.getCouponId().length() != 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(coupon.getCouponSource()))
        {
            return false;
        }

        if (org.apache.commons.lang.StringUtils.isBlank(coupon.getCouponType()) || org.apache.commons.lang.StringUtils.isBlank(coupon.getCouponName()))
        {
            return false;
        }

        if (this.checkMatches(String.valueOf(coupon.getCouponValue())))
        {

            return false;
        }
        if (coupon.getCouponType().equals("D") && coupon.getCouponValue() >= 1)
        {
            return false;
        }
        if (!this.checkInt(String.valueOf(coupon.getAmount())))
        {
            return false;
        }
        if (!this.checkInt(String.valueOf(coupon.getMaxNumOwner())))
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(String.valueOf(coupon.getUseStartTime())))
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(String.valueOf(coupon.getUseEndTime())) || TimeUtils.dateDiff(3, coupon.getUseEndTime(), coupon.getUseStartTime()) > 0 || TimeUtils.dateDiff(3, coupon.getUseEndTime(), new Date()) > 0)
        {
            return false;
        }

        if (org.apache.commons.lang.StringUtils.isBlank(coupon.getCouponContent()))
        {
            return false;
        }

        if (org.apache.commons.lang.StringUtils.isBlank(coupon.getCouponUrl()))
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(coupon.getCouponChannle()))
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(coupon.getCouponMode()))
        {
            return false;
        }
        return true;

    }

    private boolean checkInt(String str)
    {
        if (org.springframework.util.StringUtils.hasText(str))
        {
            return str.matches("^[0-9]*$");
        }
        else
        {
            return false;
        }
    }

    //判断是否是数值型
    private boolean checkMatches(String str)
    {
        if (org.springframework.util.StringUtils.hasText(str))
        {
            if (str.matches("^[0-9]*$") || str.matches("/^[0-9]*\\.?[0-9]*$/"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    @Override
    public TransData<PageModel<FCouponGrantInfo>> pageCouponGrantInfo(HttpServletRequest request) throws Exception
    {
        String couponId = ServletRequestUtils.getStringParameter(request, "couponId", null);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);
        if (pc.getPageSize() == 0)
        {
            pc.setPageSize(10);
        }

        PageModel<FCouponGrantInfo> pm = new PageModel<FCouponGrantInfo>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());

        CouponGrantInfoExample example = new CouponGrantInfoExample();
        example.setPage(pc.getPageIndex(), pc.getPageSize());
        example.setOrderByClause("c_time_stamp desc ");

        com.gooagoo.entity.generator.marketing.CouponGrantInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        if (org.springframework.util.StringUtils.hasText(couponId))
        {
            criteria.andCouponIdEqualTo(couponId);
        }
        int count = this.couponGrantInfoGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<CouponGrantInfo> list = this.couponGrantInfoGeneratorQueryService.selectByExample(example);
            for (CouponGrantInfo info : list)
            {
                pm.getResult().add(this.convertToFCouponGrantInfo(info));

            }
        }

        return new TransData<PageModel<FCouponGrantInfo>>(true, MessageConst.GMS_OPERATE_SUCCESS, pm);
    }
}
