package com.gooagoo.mis.rsrcmanage.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.resource.recommend.RecommendCouponCoreService;
import com.gooagoo.api.business.query.system.nominate.NominateCouponQueryService;
import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.NominateCouponGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.system.nominate.NominateCouponBusiness;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.sys.NominateCoupon;
import com.gooagoo.entity.generator.sys.NominateCouponExample;
import com.gooagoo.entity.generator.sys.NominateCouponExample.Criteria;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.rsrcmanage.service.NominateCouponService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.recommendManage.MCoupon;
import com.gooagoo.view.mis.recommendManage.MNominateCoupon;
import com.gooagoo.view.mis.recommendManage.MNominateCouponBusiness;

@Service(value = "nominateCouponService")
public class NominateCouponServiceImpl implements NominateCouponService
{
    @Autowired
    private NominateCouponGeneratorQueryService nominateCouponGeneratorQueryService;
    @Autowired
    private RecommendCouponCoreService recommendCouponCoreService;
    @Autowired
    private CouponGeneratorQueryService couponGeneratorQueryService;
    @Autowired
    private NominateCouponQueryService nominateCouponQueryService;

    /**
     * 查询所有优惠凭证列表
     */
    @Override
    public TransData<PageModel<MNominateCouponBusiness>> queryCouponList(HttpServletRequest request) throws Exception
    {
        NominateCouponBusiness coupon = ServletUtils.objectMethod(NominateCouponBusiness.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        PageModel<MNominateCouponBusiness> pm = new PageModel<MNominateCouponBusiness>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.nominateCouponQueryService.countNominateCouponBusiness(coupon);
        pm.setCount(count);
        if (count > 0)
        {
            List<NominateCouponBusiness> couponList = this.nominateCouponQueryService.findNominateCouponBusiness(coupon, pm.getPageIndex(), pageSize);
            for (NominateCouponBusiness base : couponList)
            {
                MNominateCouponBusiness mbase = new MNominateCouponBusiness();
                EntityTools.copyValue(base, mbase);
                pm.getResult().add(mbase);
            }
        }
        return new TransData<PageModel<MNominateCouponBusiness>>(true, null, pm);
    }

    /**
     * 推荐优惠凭证操作
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addNominateCoupon(HttpServletRequest request) throws Exception
    {
        String nominateIds = ServletRequestUtils.getStringParameter(request, "ids", "");
        MNominateCoupon nom = ServletUtils.objectMethod(MNominateCoupon.class, request);
        nom.setCouponId(nominateIds);
        // 参数验证
        String check = this.checkNominateCoupon(nom);
        if (check != null)
        {
            return new TransData<Object>(false, check, null);
        }
        boolean flag = false;
        String id = nominateIds.split(",")[0];
        Coupon cou = this.couponGeneratorQueryService.selectUnDelByPrimaryKey(id);
        NominateCoupon nominate = new NominateCoupon();
        if (cou != null)
        {
            nominate.setId(UUID.getUUID());
            nominate.setShopId(cou.getShopId());
            nominate.setCouponId(cou.getCouponId());
            nominate.setStartTime(nom.getStartTime());
            nominate.setEndTime(nom.getEndTime());
            flag = this.recommendCouponCoreService.addRecommendCoupon(nominate);
            if (!flag)
            {
                new GooagooException("推荐优惠凭证失败");
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_NOMINATE_COUPON_SUCCESS, MisMessageConst.MIS_NOMINATE_COUPON_FAIL, nominateIds.split(",")[0]);
    }

    /**
     * 查询推荐优惠凭证列表
     */
    @Override
    public TransData<PageModel<MNominateCouponBusiness>> queryNominateCoupon(HttpServletRequest request) throws Exception
    {
        NominateCouponBusiness coupon = ServletUtils.objectMethod(NominateCouponBusiness.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        PageModel<MNominateCouponBusiness> pm = new PageModel<MNominateCouponBusiness>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.nominateCouponQueryService.countNominateCoupon(coupon);
        pm.setCount(count);
        if (count > 0)
        {
            List<NominateCouponBusiness> couponList = this.nominateCouponQueryService.findNominateCoupon(coupon, pm.getPageIndex(), pageSize);
            for (NominateCouponBusiness base : couponList)
            {
                MNominateCouponBusiness mbase = new MNominateCouponBusiness();
                EntityTools.copyValue(base, mbase);
                pm.getResult().add(mbase);
            }
        }
        return new TransData<PageModel<MNominateCouponBusiness>>(true, null, pm);
    }

    /**
     * 取消推荐优惠凭证操作
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> updateNominateCoupon(HttpServletRequest request) throws Exception
    {
        String nominateIds = ServletRequestUtils.getStringParameter(request, "id", "");
        boolean flag = false;
        for (int i = 0; i < nominateIds.split(",").length; i++)
        {
            String id = nominateIds.split(",")[i];
            flag = this.recommendCouponCoreService.delRecommendCoupon(id);
            if (!flag)
            {
                new GooagooException("取消推荐优惠凭证失败");
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_CANCEL_COUPON_SUCCESS, MisMessageConst.MIS_CANCEL_COUPON_FAIL);
    }

    /**
     * 修改推荐优惠凭证操作
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> updateNominateCouponT(HttpServletRequest request) throws Exception
    {
        MNominateCoupon nom = ServletUtils.objectMethod(MNominateCoupon.class, request);
        // 参数验证
        String check = this.checkNominateCoupon(nom);
        if (check != null)
        {
            return new TransData<Object>(false, check, null);
        }
        boolean flag = false;
        NominateCoupon cou = new NominateCoupon();
        EntityTools.copyValue(nom, cou);
        flag = this.recommendCouponCoreService.updateRecommendCoupon(cou);
        if (!flag)
        {
            new GooagooException("修改推荐优惠凭证失败");
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_UPDATE_COUPON_SUCCESS, MisMessageConst.MIS_UPDATE_COUPON_FAIL, cou.getId());
    }

    /**
     * 推荐优惠凭证操作页面
     */
    @Override
    public TransData<Object> addNominateCouponPage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        Coupon coupon = this.couponGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (coupon != null)
        {
            MCoupon mcoupon = new MCoupon();
            EntityTools.copyValue(coupon, mcoupon);
            return new TransData<Object>(true, null, mcoupon);
        }
        else
        {
            return new TransData<Object>(false, MisMessageConst.SYS_LOAD_DATA_ERROR, null);
        }
    }

    /**
     * 修改推荐优惠凭证页面
     */
    @Override
    public TransData<Object> updateNominateCouponTPage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "id", "");
        NominateCoupon coupon = this.nominateCouponGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (coupon != null)
        {
            MNominateCoupon mcoupon = new MNominateCoupon();
            EntityTools.copyValue(coupon, mcoupon);
            Coupon cou = this.couponGeneratorQueryService.selectUnDelByPrimaryKey(mcoupon.getCouponId());
            if (cou != null)
            {
                mcoupon.setCouponName(cou.getCouponName());
                mcoupon.setCouponUrl(cou.getCouponUrl());
            }
            return new TransData<Object>(true, null, mcoupon);
        }
        else
        {
            return new TransData<Object>(false, MisMessageConst.SYS_LOAD_DATA_ERROR, null);
        }
    }

    /**
     * 验证优惠凭证是否已推荐
     */
    @Override
    public TransData<Object> checkNominateCouponT(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        Coupon coupon = this.couponGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (coupon != null)
        {
            NominateCouponExample exam = new NominateCouponExample();
            exam.createCriteria().andCouponIdEqualTo(coupon.getCouponId()).andShopIdEqualTo(coupon.getShopId()).andIsDelEqualTo("N");
            List<NominateCoupon> acti = this.nominateCouponGeneratorQueryService.selectByExample(exam);
            if (acti.size() > 0)
            {
                return new TransData<Object>(false, MisMessageConst.MIS_DICTIARY_PARAMETER_CHECKCOUPON_FAIL, null);
            }
        }
        return new TransData<Object>(true, null, null);
    }

    /**
     * 入参校验
     * @param nom
     * @return
     */
    private String checkNominateCoupon(MNominateCoupon nom)
    {
        //结束时间必须大于起始时间
        if (nom.getStartTime().compareTo(nom.getEndTime()) >= 0)
        {
            return MisMessageConst.MIS_NOMINATE_START_END;
        }
        //起始时间不允许重复存在
        NominateCouponExample example = new NominateCouponExample();
        Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(nom.getId()))
        {
            criteria.andIdNotEqualTo(nom.getId());
        }
        criteria.andIsDelEqualTo("N").andCouponIdEqualTo(nom.getCouponId()).andStartTimeLessThanOrEqualTo(nom.getStartTime()).andEndTimeGreaterThanOrEqualTo(nom.getStartTime());
        List<NominateCoupon> shopList = this.nominateCouponGeneratorQueryService.selectByExample(example);
        if (shopList != null && shopList.size() > 0)
        {
            return MisMessageConst.MIS_NOMINATE_START_EXITS;
        }
        //结束时间不允许重复存在
        NominateCouponExample example2 = new NominateCouponExample();
        Criteria criteria2 = example2.createCriteria();
        if (StringUtils.hasText(nom.getId()))
        {
            criteria2.andIdNotEqualTo(nom.getId());
        }
        criteria2.andIsDelEqualTo("N").andCouponIdEqualTo(nom.getCouponId()).andStartTimeLessThanOrEqualTo(nom.getEndTime()).andEndTimeGreaterThanOrEqualTo(nom.getEndTime());
        List<NominateCoupon> shopList2 = this.nominateCouponGeneratorQueryService.selectByExample(example2);
        if (shopList2 != null && shopList2.size() > 0)
        {
            return MisMessageConst.MIS_NOMINATE_END_EXITS;
        }
        //不允许包含已存在的推荐时间段
        NominateCouponExample example3 = new NominateCouponExample();
        Criteria criteria3 = example3.createCriteria();
        if (StringUtils.hasText(nom.getId()))
        {
            criteria3.andIdNotEqualTo(nom.getId());
        }
        criteria3.andIsDelEqualTo("N").andCouponIdEqualTo(nom.getCouponId()).andStartTimeGreaterThan(nom.getStartTime()).andEndTimeLessThan(nom.getEndTime());
        List<NominateCoupon> shopList3 = this.nominateCouponGeneratorQueryService.selectByExample(example3);
        if (shopList3 != null && shopList3.size() > 0)
        {
            return MisMessageConst.MIS_NOMINATE_TIME_EXITS;
        }
        return null;
    }
}
