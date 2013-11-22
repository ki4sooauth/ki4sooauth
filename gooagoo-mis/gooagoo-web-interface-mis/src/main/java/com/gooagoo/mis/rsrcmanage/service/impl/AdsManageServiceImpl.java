package com.gooagoo.mis.rsrcmanage.service.impl;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.bid.SysShopBidCoreService;
import com.gooagoo.api.business.query.system.bid.SysShopBidQueryService;
import com.gooagoo.api.generator.query.sys.AdsManageGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.ShopAdGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.business.system.bid.BidDetailInfo;
import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.entity.generator.sys.AdsManageExample;
import com.gooagoo.entity.generator.sys.AdsManageExample.Criteria;
import com.gooagoo.entity.generator.sys.ShopAd;
import com.gooagoo.entity.generator.sys.ShopAdExample;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.rsrcmanage.service.AdsManageService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.recommendManage.MAdsManage;
import com.gooagoo.view.mis.recommendManage.MBidDetailInfo;
import com.gooagoo.view.mis.recommendManage.MShopAd;
import com.gooagoo.view.mis.recommendManage.MShopBid;

@Service(value = "adsManageService")
public class AdsManageServiceImpl implements AdsManageService
{
    @Autowired
    private AdsManageGeneratorQueryService adsManageGeneratorQueryService;
    @Autowired
    private ShopAdGeneratorQueryService shopAdGeneratorQueryService;
    @Autowired
    private SysShopBidCoreService sysShopBidCoreService;
    @Autowired
    private SysShopBidQueryService sysShopBidQueryService;

    /**
     * 关联查询广告位信息、广告位管理，以广告位管理为主
     */
    @Override
    public TransData<PageModel<MBidDetailInfo>> queryAllAdsManage(HttpServletRequest request) throws Exception
    {
        // 生效结束日期大于当前时期，生效结束时间大于当前时间（页面默认条件）
        MAdsManage mads = ServletUtils.objectMethod(MAdsManage.class, request);
        PageCondition pageContidion = ServletUtils.objectMethod(PageCondition.class, request);
        ShopAdExample sexample = new ShopAdExample();
        com.gooagoo.entity.generator.sys.ShopAdExample.Criteria criteria = sexample.createCriteria();
        criteria.andIsDelEqualTo("N");
        // 广告位编码
        Boolean code = false;
        Boolean type = false;
        Boolean name = false;
        if (StringUtils.hasText(mads.getAdCode()))
        {
            criteria.andAdCodeEqualTo(mads.getAdCode());
            code = true;
        }
        // 广告位类型
        if (StringUtils.hasText(mads.getAdType()))
        {
            criteria.andAdTypeEqualTo(mads.getAdType());
            type = true;
        }
        // 广告位名称
        if (StringUtils.hasText(mads.getAdName()))
        {
            criteria.andAdNameLike("%" + mads.getAdName() + "%");
            name = true;
        }
        // 根据页面查询查询出广告位编码
        List<String> codeList = new ArrayList<String>();
        if (code || type || name)
        {
            List<ShopAd> adList = this.shopAdGeneratorQueryService.selectByExample(sexample);
            if (adList.size() > 0)
            {
                for (ShopAd sd : adList)
                {
                    codeList.add(sd.getAdCode());
                }
            }
        }
        AdsManageExample example = new AdsManageExample();
        Criteria criteriam = example.createCriteria();
        criteriam.andIsDelEqualTo("N");
        if (!CollectionUtils.isEmpty(codeList))
        {
            criteriam.andAdCodeIn(codeList);
        }
        // 起拍价
        if (mads.getStartingPrice() != null)
        {
            criteriam.andStartingPriceLike("%" + mads.getStartingPrice().toString() + "%");
        }
        // 涨幅
        if (mads.getIncrease() != null)
        {
            criteriam.andIncreaseLike("%" + mads.getIncrease().toString() + "%");
        }
        // 状态
        if (StringUtils.hasText(mads.getState()))
        {
            criteriam.andStateEqualTo(mads.getState());
        }
        // 得标商家编号
        if (StringUtils.hasText(mads.getWinnerShooId()))
        {
            criteriam.andWinnerShooIdLike("%" + mads.getWinnerShooId() + "%");
        }
        // 得标商家名称
        if (StringUtils.hasText(mads.getWinnerShooName()))
        {
            criteriam.andWinnerShooNameLike("%" + mads.getWinnerShooName() + "%");
        }
        // 得标金额
        if (mads.getBidAmount() != null)
        {
            criteriam.andBidAmountLike("%" + mads.getBidAmount().toString() + "%");
        }
        //商家竞价自动编号
        if (StringUtils.hasText(mads.getId()))
        {
            criteriam.andIdLike("%" + mads.getId() + "%");
        }
        // 竞价起始时间
        if (mads.getBidStartTime() != null)
        {
            criteriam.andBidStartTimeGreaterThanOrEqualTo(mads.getBidStartTime());
        }
        // 竞价结束时间
        if (mads.getBidEndTime() != null)
        {
            criteriam.andBidEndTimeLessThanOrEqualTo(mads.getBidEndTime());
        }
        // 生效起始日期
        if (mads.getEffectStartDate() != null)
        {
            criteriam.andEffectStartDateGreaterThanOrEqualTo(mads.getEffectStartDate());
        }
        // 生效结束日期
        if (mads.getEffectEndDate() != null)
        {
            criteriam.andEffectEndDateLessThanOrEqualTo(mads.getEffectEndDate());
        }
        // 生效起始时间
        if (mads.getEffectStartTime() != null)
        {
            criteriam.andEffectStartTimeGreaterThanOrEqualTo(mads.getEffectStartTime().toString());
        }
        // 生效结束时间
        if (mads.getEffectEndTime() != null)
        {
            criteriam.andEffectEndTimeLessThanOrEqualTo(mads.getEffectEndTime().toString());
        }
        PageModel<MBidDetailInfo> pm = new PageModel<MBidDetailInfo>();
        if (pageContidion != null)
        {
            pm.setPageIndex(pageContidion.getPageIndex());
            pm.setPageSize(pageContidion.getPageSize() <= 0 ? 10 : pageContidion.getPageSize());
        }
        Integer count = this.adsManageGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            example.setPage(pm.getPageIndex(), pm.getPageSize());
            List<BidDetailInfo> bidList = this.sysShopBidQueryService.findAllShopAd(example);
            for (BidDetailInfo bid : bidList)
            {
                MBidDetailInfo mbid = new MBidDetailInfo();
                if (bid.getShopBid() != null)
                {
                    MShopBid mshopBid = new MShopBid();
                    EntityTools.copyValue(bid.getShopBid(), mshopBid);
                    mbid.setShopBid(mshopBid);
                }
                MShopAd mshopAd = new MShopAd();
                EntityTools.copyValue(bid.getShopAd(), mshopAd);
                mbid.setShopAd(mshopAd);
                MAdsManage madsManage = new MAdsManage();
                EntityTools.copyValue(bid.getAdsManage(), madsManage);
                mbid.setAdsManage(madsManage);
                pm.getResult().add(mbid);
            }
        }
        return new TransData<PageModel<MBidDetailInfo>>(true, null, pm);
    }

    /**
     * 查询广告位管理详细
     */
    @Override
    public TransData<MAdsManage> queryAdsManage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        AdsManage ads = this.adsManageGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (ads != null)
        {
            MAdsManage mads = new MAdsManage();
            EntityTools.copyValue(ads, mads);
            return new TransData<MAdsManage>(true, null, mads);
        }
        else
        {
            return new TransData<MAdsManage>(false, MisMessageConst.MIS_RESOURCE_ADMANAGE_QUERY_FAIL, null);
        }
    }

    /**
     * 新增广告位管理
     */
    @Override
    public TransData<Object> addAdsManage(HttpServletRequest request) throws Exception
    {
        MAdsManage mads = ServletUtils.objectMethod(MAdsManage.class, request);
        String effectStartTime = ServletRequestUtils.getStringParameter(request, "effectStartTime");
        String effectEndTime = ServletRequestUtils.getStringParameter(request, "effectEndTime");
        mads.setEffectStartTime(Time.valueOf(effectStartTime));
        mads.setEffectEndTime(Time.valueOf(effectEndTime));
        // 参数校验
        String check = this.checkAdsManage(mads);
        if (check != null)
        {
            return new TransData<Object>(false, check, null);
        }
        AdsManageExample example = new AdsManageExample();
        example.createCriteria().andIsDelEqualTo("N").andAdCodeEqualTo(mads.getAdCode());
        List<AdsManage> adsList = this.adsManageGeneratorQueryService.selectByExample(example);
        if (adsList.size() > 0)
        {
            for (AdsManage adsm : adsList)
            {
                // 生效起始日期必须大于等于已存在的生效结束日期
                // 生效起始日期等于已存在的生效结束日期，生效起始时间必须大于已存在的生效结束时间
                if ((mads.getEffectStartDate().compareTo(adsm.getEffectEndDate()) < 0) || (mads.getEffectStartDate().compareTo(adsm.getEffectEndDate()) == 0) && (mads.getEffectStartTime().compareTo(adsm.getEffectEndTime()) <= 0))
                {
                    return new TransData<Object>(false, MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKADSMESE_FAIL, null);
                }
            }
        }
        AdsManage ads = new AdsManage();
        EntityTools.copyValue(mads, ads);
        ads.setState("0");// 空闲
        boolean flag = this.sysShopBidCoreService.addAdsManage(ads);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_RESOURCE_ADMANAGE_ADD_SUCCESS, MisMessageConst.MIS_RESOURCE_ADMANAGE_ADD_FAIL, ads.getBidId());
    }

    /**
     * 编辑广告位管理
     */
    @Override
    public TransData<Object> updateAdsManageOperation(HttpServletRequest request) throws Exception
    {
        MAdsManage mads = ServletUtils.objectMethod(MAdsManage.class, request);
        String effectStartTime = ServletRequestUtils.getStringParameter(request, "effectStartTime");
        String effectEndTime = ServletRequestUtils.getStringParameter(request, "effectEndTime");
        mads.setEffectStartTime(Time.valueOf(effectStartTime));
        mads.setEffectEndTime(Time.valueOf(effectEndTime));
        AdsManage adsManage = this.adsManageGeneratorQueryService.selectUnDelByPrimaryKey(mads.getBidId());
        // 只能修改状态为空闲的广告位
        if (!"0".equals(adsManage.getState()))
        {
            return new TransData<Object>(false, MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKADSMUPDATE_FAIL, null);
        }
        // 参数验证
        String check = this.checkAdsManage(mads);
        if (check != null)
        {
            return new TransData<Object>(false, check, null);
        }
        AdsManageExample example = new AdsManageExample();
        example.createCriteria().andIsDelEqualTo("N").andAdCodeEqualTo(mads.getAdCode());
        List<AdsManage> adsList = this.adsManageGeneratorQueryService.selectByExample(example);
        if (adsList.size() > 0)
        {
            for (AdsManage adsm : adsList)
            {
                // 不判断当前修改的广告位
                // 生效起始日期必须大于已存在的生效结束日期
                // 生效起始日期等于已存在的生效结束日期，生效起始时间必须大于已存在的生效结束时间
                if (!mads.getAdCode().equals(adsm.getAdCode()) && ((mads.getEffectStartDate().compareTo(adsm.getEffectEndDate()) < 0) || (mads.getEffectStartDate().compareTo(adsm.getEffectEndDate()) == 0) && (mads.getEffectStartTime().compareTo(adsm.getEffectEndTime()) <= 0)))
                {
                    return new TransData<Object>(false, MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKADSMESE_FAIL, null);
                }
            }
        }
        AdsManage ads = new AdsManage();
        EntityTools.copyValue(mads, ads);
        boolean flag = this.sysShopBidCoreService.updateAdsManage(ads);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_RESOURCE_ADMANAGE_UPDATE_SUCCESS, MisMessageConst.MIS_RESOURCE_ADMANAGE_UPDATE_FAIL, ads.getBidId());
    }

    /**
     * 参数校验
     * @param mads
     * @return
     * @throws Exception 
     */
    private String checkAdsManage(MAdsManage mads) throws Exception
    {
        // 起拍价、涨幅只能是数字且不能为负数
        if (mads.getStartingPrice() < 0.00 || mads.getIncrease() < 0.00)
        {
            return MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKSI_FAIL;
        }
        Date date = new Date();// 获取服务器当前时间
        // 竞价起始时间必须大于当前时间
        if (date.compareTo(mads.getBidStartTime()) >= 0)
        {
            return MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKBIDSTATR_FAIL;
        }
        // 竞价结束时间必须大于当前时间
        if (date.compareTo(mads.getBidEndTime()) >= 0)
        {
            return MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKBIDEND_FAIL;
        }
        // 竞价结束时间必须大于竞价起始时间
        if (mads.getBidStartTime().compareTo(mads.getBidEndTime()) >= 0)
        {
            return MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKBIDSE_FAIL;
        }
        // 生效起始日期必须大于当前日期
        if (UtilsMis.getEarlyMorning(date).compareTo(mads.getEffectStartDate()) > 0)
        {
            return MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKEFFECTSD_FAIL;
        }
        // 生效结束日期必须大于当前日期
        if (UtilsMis.getEarlyMorning(date).compareTo(mads.getEffectEndDate()) > 0)
        {
            return MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKEFFECTED_FAIL;
        }
        // 生效起始日期必须大于等于竞价结束日期
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        if (UtilsMis.getEarlyMorning(mads.getBidEndTime()).compareTo(UtilsMis.getEarlyMorning(mads.getEffectStartDate())) > 0)
        {
            return MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKSETIME_FAIL;
        }
        // 生效起始日期等于竞价结束日期，生效起始时间必须大于竞价结束时间
        if ((UtilsMis.getEarlyMorning(mads.getBidEndTime()).compareTo(UtilsMis.getEarlyMorning(mads.getEffectStartDate())) == 0) && (Time.valueOf(sdf.format(mads.getBidEndTime())).compareTo(mads.getEffectStartTime()) >= 0))
        {
            return MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKSETIMET_FAIL;
        }
        // 生效结束日期必须大于等于生效起始日期
        if (mads.getEffectStartDate().compareTo(mads.getEffectEndDate()) > 0)
        {
            return MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKEFFECTSE_FAIL;
        }
        Time dateTime = Time.valueOf(sdf.format(date));
        // 生效起始日期等于当前日期
        if (UtilsMis.getEarlyMorning(date).compareTo(mads.getEffectStartDate()) == 0)
        {
            // 生效起始时间必须大于当前时间
            if (dateTime.compareTo(mads.getEffectStartTime()) >= 0)
            {
                return MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKEFFECTST_FAIL;
            }
        }
        // 生效结束日期等于当前日期
        if (UtilsMis.getEarlyMorning(date).compareTo(mads.getEffectEndDate()) == 0)
        {
            // 生效结束时间必须大于当前时间
            if (dateTime.compareTo(mads.getEffectEndTime()) >= 0)
            {
                return MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKEFFECTET_FAIL;
            }
        }
        // 生效开始日期等于生效结束日期
        if (mads.getEffectEndDate().compareTo(mads.getEffectStartDate()) == 0)
        {
            // 生效结束时间必须大于生效起始时间
            if (mads.getEffectStartTime().compareTo(mads.getEffectEndTime()) >= 0)
            {
                return MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKEFFECTTSE_FAIL;
            }
        }
        return null;
    }

    /**
     * 删除广告位管理
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> deleteAdsManage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        for (int i = 0; i < ids.split(",").length; i++)
        {
            AdsManage ads = this.adsManageGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[i]);
            // 只能删除状态为空闲的广告位
            if (!"0".equals(ads.getState()))
            {
                return new TransData<Object>(false, MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKADSMDEL_FAIL, null);
            }
        }
        boolean flag = this.sysShopBidCoreService.deleteAdsManage(ids);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_RESOURCE_ADMANAGE_DELETE_SUCCESS, MisMessageConst.MIS_RESOURCE_ADMANAGE_DELETE_FAIL);
    }

    /**
     * 发布
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> releaseAdsManage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        String state = ServletRequestUtils.getStringParameter(request, "state", "0");
        for (int i = 0; i < ids.split(",").length; i++)
        {
            AdsManage ads = this.adsManageGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[i]);
            if (!"0".equals(ads.getState()))
            {
                return new TransData<Object>(false, MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKSF_FAIL, null);
            }
        }
        boolean flag = this.sysShopBidCoreService.updateAdsManageState(ids, state);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_RESOURCE_ADMANAGE_UPDATESTATE_SUCCESS, MisMessageConst.MIS_RESOURCE_ADMANAGE_UPDATESTATE_FAIL);
    }

    /**
     * 查询提交资料
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public TransData<MAdsManage> submitAdsManagePage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        AdsManage ads = this.adsManageGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (!"2".equals(ads.getState()) && !"3".equals(ads.getState()))
        {
            return new TransData<MAdsManage>(false, MisMessageConst.MIS_RESOURCE_ADMANAGE_ST_FAIL, null);
        }
        ShopAd ad = this.shopAdGeneratorQueryService.selectUnDelByPrimaryKey(ads.getAdCode());
        MAdsManage mads = new MAdsManage();
        EntityTools.copyValue(ads, mads);
        mads.setAdName(ad.getAdName());
        return new TransData<MAdsManage>(true, null, mads, mads.getBidId());
    }

    /**
     * 提交资料
     */
    @Override
    public TransData<Object> submitAdsManage(HttpServletRequest request) throws Exception
    {
        MAdsManage mads = ServletUtils.objectMethod(MAdsManage.class, request);
        AdsManage ads = this.adsManageGeneratorQueryService.selectUnDelByPrimaryKey(mads.getBidId());
        //        AdsManage ads = new AdsManage();
        //        EntityTools.copyValue(mads, ads);
        ads.setImgUrl(mads.getImgUrl());
        ads.setLinkUrl(mads.getLinkUrl());
        ads.setState(mads.getState());
        boolean flag = this.sysShopBidCoreService.updateAdsManage(ads);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_RESOURCE_ADMANAGE_STZ_SUCCESS, MisMessageConst.MIS_RESOURCE_ADMANAGE_STZ_FAIL, ads.getBidId());
    }

    /**
     * 审核
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> checkedAdsManage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        String state = ServletRequestUtils.getStringParameter(request, "state", "0");
        for (int i = 0; i < ids.split(",").length; i++)
        {
            AdsManage ads = this.adsManageGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[i]);
            if (!"3".equals(ads.getState()))
            {
                return new TransData<Object>(false, MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKSZ_FAIL, null);
            }
        }
        boolean flag = this.sysShopBidCoreService.updateAdsManageState(ids, state);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_RESOURCE_ADMANAGE_SZ_SUCCESS, MisMessageConst.MIS_RESOURCE_ADMANAGE_SZ_FAIL);
    }

    /**
     * 收款
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> moneyReceiptAdManage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        String state = ServletRequestUtils.getStringParameter(request, "state", "0");
        for (int i = 0; i < ids.split(",").length; i++)
        {
            AdsManage ads = this.adsManageGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[i]);
            if (!"4".equals(ads.getState()))
            {
                return new TransData<Object>(false, MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKSK_FAIL, null);
            }
        }
        boolean flag = this.sysShopBidCoreService.updateAdsManageState(ids, state);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_RESOURCE_ADMANAGE_SK_SUCCESS, MisMessageConst.MIS_RESOURCE_ADMANAGE_SK_FAIL);
    }

    /**
     * 卖出
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> bearPositionAdManage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        String state = ServletRequestUtils.getStringParameter(request, "state", "0");
        for (int i = 0; i < ids.split(",").length; i++)
        {
            AdsManage ads = this.adsManageGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[i]);
            if (!"5".equals(ads.getState()))
            {
                return new TransData<Object>(false, MisMessageConst.MIS_RESOURCE_ADMANAGE_CHECKSM_FAIL, null);
            }
        }
        boolean flag = this.sysShopBidCoreService.updateAdsManageState(ids, state);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_RESOURCE_ADMANAGE_SM_SUCCESS, MisMessageConst.MIS_RESOURCE_ADMANAGE_SM_FAIL);
    }

}
