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

import com.gooagoo.api.business.core.system.user.enterprise.RecommendMerchantCoreService;
import com.gooagoo.api.business.query.system.nominate.NominateShopQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.NominateShopGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.system.nominate.NominateShopBusiness;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.sys.NominateShop;
import com.gooagoo.entity.generator.sys.NominateShopExample;
import com.gooagoo.entity.generator.sys.NominateShopExample.Criteria;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.rsrcmanage.service.NominateShopService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MShopInfo;
import com.gooagoo.view.mis.recommendManage.MNominateShop;
import com.gooagoo.view.mis.recommendManage.MNominateShopBusiness;

@Service(value = "nominateShopService")
public class NominateShopServiceImpl implements NominateShopService
{
    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;
    @Autowired
    private NominateShopGeneratorQueryService nominateShopGeneratorQueryService;
    @Autowired
    private RecommendMerchantCoreService recommendMerchantCoreService;
    @Autowired
    private NominateShopQueryService nominateShopQueryService;

    /**
     * 查询所有商家列表
     */
    @Override
    public TransData<PageModel<MNominateShopBusiness>> queryShopList(HttpServletRequest request) throws Exception
    {
        NominateShopBusiness shop = ServletUtils.objectMethod(NominateShopBusiness.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        PageModel<MNominateShopBusiness> pm = new PageModel<MNominateShopBusiness>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.nominateShopQueryService.CountNominateShopBusiness(shop);
        pm.setCount(count);
        if (count > 0)
        {
            List<NominateShopBusiness> shopList = this.nominateShopQueryService.findNominateShopBusinessList(shop, pm.getPageIndex(), pageSize);
            for (NominateShopBusiness base : shopList)
            {
                MNominateShopBusiness mbase = new MNominateShopBusiness();
                EntityTools.copyValue(base, mbase);
                pm.getResult().add(mbase);
            }
        }
        return new TransData<PageModel<MNominateShopBusiness>>(true, null, pm);
    }

    /**
     * 推荐商家操作
     */
    @Override
    public TransData<Object> addNominateShop(HttpServletRequest request) throws Exception
    {
        String nominateIds = ServletRequestUtils.getStringParameter(request, "ids", "");
        MNominateShop nom = ServletUtils.objectMethod(MNominateShop.class, request);
        nom.setShopId(nominateIds);
        // 参数验证
        String check = this.checkNominateShop(nom);
        if (check != null)
        {
            return new TransData<Object>(false, check, null);
        }
        NominateShop nominate = new NominateShop();
        nominate.setId(UUID.getUUID());
        nominate.setShopId(nominateIds);
        nominate.setStartTime(nom.getStartTime());
        nominate.setEndTime(nom.getEndTime());
        nominate.setColor(nom.getColor());
        boolean flag = this.recommendMerchantCoreService.addRecommendMerchant(nominate);
        if (!flag)
        {
            new GooagooException("推荐商家失败");
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_NOMINATE_SHOP_SUCCESS, MisMessageConst.MIS_NOMINATE_SHOP_FAIL, nominate.getId());
    }

    /**
     * 查询推荐商家列表
     */
    @Override
    public TransData<PageModel<MNominateShopBusiness>> queryNominateShop(HttpServletRequest request) throws Exception
    {
        NominateShopBusiness shop = ServletUtils.objectMethod(NominateShopBusiness.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        PageModel<MNominateShopBusiness> pm = new PageModel<MNominateShopBusiness>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.nominateShopQueryService.CountNominateShop(shop);
        pm.setCount(count);
        if (count > 0)
        {
            List<NominateShopBusiness> shopList = this.nominateShopQueryService.findNominateShopList(shop, pm.getPageIndex(), pageSize);
            for (NominateShopBusiness base : shopList)
            {
                MNominateShopBusiness mbase = new MNominateShopBusiness();
                EntityTools.copyValue(base, mbase);
                pm.getResult().add(mbase);
            }
        }
        return new TransData<PageModel<MNominateShopBusiness>>(true, null, pm);
    }

    /**
     * 取消推荐商家操作
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> updateNominateShop(HttpServletRequest request) throws Exception
    {
        String nominateIds = ServletRequestUtils.getStringParameter(request, "id", "");
        boolean flag = false;
        for (int i = 0; i < nominateIds.split(",").length; i++)
        {
            String id = nominateIds.split(",")[i];
            NominateShop shop = new NominateShop();
            shop.setId(id);
            shop.setIsDel("Y");
            flag = this.recommendMerchantCoreService.updateRecommendMerchant(shop);
            if (!flag)
            {
                new GooagooException("取消推荐商家失败");
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_CANCEL_SHOP_SUCCESS, MisMessageConst.MIS_CANCEL_SHOP_FAIL);
    }

    /**
     * 修改推荐商家操作
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> updateNominateShopT(HttpServletRequest request) throws Exception
    {
        MNominateShop nom = ServletUtils.objectMethod(MNominateShop.class, request);
        // 参数验证
        String check = this.checkNominateShop(nom);
        if (check != null)
        {
            return new TransData<Object>(false, check, null);
        }
        NominateShop shop = new NominateShop();
        EntityTools.copyValue(nom, shop);
        boolean flag = this.recommendMerchantCoreService.updateRecommendMerchant(shop);
        if (!flag)
        {
            new GooagooException("修改推荐商家失败");
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_UPDATE_SHOP_SUCCESS, MisMessageConst.MIS_UPDATE_SHOP_FAIL, shop.getId());
    }

    /**
     * 推荐商家操作页面
     */
    @Override
    public TransData<Object> addNominateShopPage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        ShopInfo shop = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (shop != null)
        {
            MShopInfo mshop = new MShopInfo();
            EntityTools.copyValue(shop, mshop);
            return new TransData<Object>(true, null, mshop);
        }
        else
        {
            return new TransData<Object>(false, MisMessageConst.SYS_LOAD_DATA_ERROR, null);
        }
    }

    /**
     * 修改推荐商家页面
     */
    @Override
    public TransData<Object> updateNominateShopTPage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "id", "");
        NominateShop shop = this.nominateShopGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (shop != null)
        {
            MNominateShop mshop = new MNominateShop();
            EntityTools.copyValue(shop, mshop);
            ShopInfo sho = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(mshop.getShopId());
            if (sho != null)
            {
                mshop.setShopName(sho.getShopName());
                mshop.setLogo(sho.getLogo1());
            }
            return new TransData<Object>(true, null, mshop);
        }
        else
        {
            return new TransData<Object>(false, MisMessageConst.SYS_LOAD_DATA_ERROR, null);
        }
    }

    /**
     * 验证商家是否已推荐
     */
    @Override
    public TransData<Object> checkNominateShopT(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        ShopInfo shop = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (shop != null)
        {
            NominateShopExample exam = new NominateShopExample();
            exam.createCriteria().andShopIdEqualTo(shop.getShopId()).andIsDelEqualTo("N");
            List<NominateShop> acti = this.nominateShopGeneratorQueryService.selectByExample(exam);
            if (acti.size() > 0)
            {
                return new TransData<Object>(false, MisMessageConst.MIS_DICTIARY_PARAMETER_CHECKSHOP_FAIL, null);
            }
        }
        return new TransData<Object>(true, null, null);
    }

    /**
     * 入参校验
     * @param nom
     * @return
     */
    private String checkNominateShop(MNominateShop nom)
    {
        //结束时间必须大于起始时间
        if (nom.getStartTime().compareTo(nom.getEndTime()) >= 0)
        {
            return MisMessageConst.MIS_NOMINATE_START_END;
        }
        //起始时间不允许重复存在
        NominateShopExample example = new NominateShopExample();
        Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(nom.getId()))
        {
            criteria.andIdNotEqualTo(nom.getId());
        }
        criteria.andIsDelEqualTo("N").andShopIdEqualTo(nom.getShopId()).andStartTimeLessThanOrEqualTo(nom.getStartTime()).andEndTimeGreaterThanOrEqualTo(nom.getStartTime());
        List<NominateShop> shopList = this.nominateShopGeneratorQueryService.selectByExample(example);
        if (shopList != null && shopList.size() > 0)
        {
            return MisMessageConst.MIS_NOMINATE_START_EXITS;
        }
        //结束时间不允许重复存在
        NominateShopExample example2 = new NominateShopExample();
        Criteria criteria2 = example2.createCriteria();
        if (StringUtils.hasText(nom.getId()))
        {
            criteria2.andIdNotEqualTo(nom.getId());
        }
        criteria2.andIsDelEqualTo("N").andShopIdEqualTo(nom.getShopId()).andStartTimeLessThanOrEqualTo(nom.getEndTime()).andEndTimeGreaterThanOrEqualTo(nom.getEndTime());
        List<NominateShop> shopList2 = this.nominateShopGeneratorQueryService.selectByExample(example2);
        if (shopList2 != null && shopList2.size() > 0)
        {
            return MisMessageConst.MIS_NOMINATE_END_EXITS;
        }
        //不允许包含已存在的推荐时间段
        NominateShopExample example3 = new NominateShopExample();
        Criteria criteria3 = example3.createCriteria();
        if (StringUtils.hasText(nom.getId()))
        {
            criteria3.andIdNotEqualTo(nom.getId());
        }
        criteria3.andIsDelEqualTo("N").andShopIdEqualTo(nom.getShopId()).andStartTimeGreaterThan(nom.getStartTime()).andEndTimeLessThan(nom.getEndTime());
        List<NominateShop> shopList3 = this.nominateShopGeneratorQueryService.selectByExample(example3);
        if (shopList3 != null && shopList3.size() > 0)
        {
            return MisMessageConst.MIS_NOMINATE_TIME_EXITS;
        }
        return null;
    }
}
