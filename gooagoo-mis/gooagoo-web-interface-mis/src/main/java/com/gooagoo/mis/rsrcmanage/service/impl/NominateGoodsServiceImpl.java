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

import com.gooagoo.api.business.core.system.resource.recommend.RecommendProductsCoreService;
import com.gooagoo.api.business.query.system.nominate.NominateGoodsQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.NominateGoodsGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.system.nominate.NominateGoodsBusiness;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.sys.NominateGoods;
import com.gooagoo.entity.generator.sys.NominateGoodsExample;
import com.gooagoo.entity.generator.sys.NominateGoodsExample.Criteria;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.rsrcmanage.service.NominateGoodsService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.recommendManage.MGoodsMarketingInfo;
import com.gooagoo.view.mis.recommendManage.MNominateGoods;
import com.gooagoo.view.mis.recommendManage.MNominateGoodsBusiness;

@Service(value = "nominateGoodsService")
public class NominateGoodsServiceImpl implements NominateGoodsService
{
    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;
    @Autowired
    private NominateGoodsGeneratorQueryService nominateGoodsGeneratorQueryService;
    @Autowired
    private RecommendProductsCoreService recommendProductsCoreService;
    @Autowired
    private GoodsMarketingInfoGeneratorQueryService goodsMarketingInfoGeneratorQueryService;
    @Autowired
    private NominateGoodsQueryService NominateGoodsQueryService;

    /**
     * 查询所有商家的商品列表
     */
    @Override
    public TransData<PageModel<MNominateGoodsBusiness>> queryGoodsList(HttpServletRequest request) throws Exception
    {
        NominateGoodsBusiness goods = ServletUtils.objectMethod(NominateGoodsBusiness.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        PageModel<MNominateGoodsBusiness> pm = new PageModel<MNominateGoodsBusiness>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.NominateGoodsQueryService.countNominateGoodsBusiness(goods);
        pm.setCount(count);
        if (count > 0)
        {
            List<NominateGoodsBusiness> goodList = this.NominateGoodsQueryService.findNominateGoodsBusiness(goods, pm.getPageIndex(), pageSize);
            for (NominateGoodsBusiness base : goodList)
            {
                MNominateGoodsBusiness mbase = new MNominateGoodsBusiness();
                EntityTools.copyValue(base, mbase);
                pm.getResult().add(mbase);
            }
        }
        return new TransData<PageModel<MNominateGoodsBusiness>>(true, null, pm);
    }

    /**
     * 推荐商品操作
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addNominateGoods(HttpServletRequest request) throws Exception
    {
        String nominateIds = ServletRequestUtils.getStringParameter(request, "ids", "");
        MNominateGoods nom = ServletUtils.objectMethod(MNominateGoods.class, request);
        nom.setGoodsId(nominateIds);
        // 参数验证
        String check = this.checkNominateGoods(nom);
        if (check != null)
        {
            return new TransData<Object>(false, check, null);
        }
        boolean flag = false;
        String id = nominateIds.split(",")[0];
        GoodsBaseInfo goods = this.goodsBaseInfoGeneratorQueryService.selectUnDelByPrimaryKey(id);
        NominateGoods nominate = new NominateGoods();
        if (goods != null)
        {
            nominate.setId(UUID.getUUID());
            nominate.setShopId(goods.getShopId());
            nominate.setShopEntityId(goods.getShopEntityId());
            nominate.setGoodsId(goods.getGoodsId());
            nominate.setStartTime(nom.getStartTime());
            nominate.setEndTime(nom.getEndTime());
            flag = this.recommendProductsCoreService.addRecommendProducts(nominate);
            if (!flag)
            {
                new GooagooException("推荐商品失败");
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_NOMINATE_GOODS_SUCCESS, MisMessageConst.MIS_NOMINATE_GOODS_FAIL, nominateIds.split(",")[0]);
    }

    /**
     * 查询推荐商品列表
     */
    @Override
    public TransData<PageModel<MNominateGoodsBusiness>> queryNominateGoods(HttpServletRequest request) throws Exception
    {
        NominateGoodsBusiness goods = ServletUtils.objectMethod(NominateGoodsBusiness.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        PageModel<MNominateGoodsBusiness> pm = new PageModel<MNominateGoodsBusiness>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.NominateGoodsQueryService.countNominateGoods(goods);
        pm.setCount(count);
        if (count > 0)
        {
            List<NominateGoodsBusiness> goodsList = this.NominateGoodsQueryService.findNominateGoods(goods, pm.getPageIndex(), pageSize);
            for (NominateGoodsBusiness nominate : goodsList)
            {
                MNominateGoodsBusiness mnoinate = new MNominateGoodsBusiness();
                EntityTools.copyValue(nominate, mnoinate);
                pm.getResult().add(mnoinate);
            }
        }
        return new TransData<PageModel<MNominateGoodsBusiness>>(true, null, pm);
    }

    /**
     * 取消推荐商品操作
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> updateNominateGoods(HttpServletRequest request) throws Exception
    {
        String nominateIds = ServletRequestUtils.getStringParameter(request, "id", "");
        boolean flag = false;
        for (int i = 0; i < nominateIds.split(",").length; i++)
        {
            String id = nominateIds.split(",")[i];
            flag = this.recommendProductsCoreService.delRecommendProducts(id);
            if (!flag)
            {
                new GooagooException("取消推荐商品失败");
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_CANCEL_GOODS_SUCCESS, MisMessageConst.MIS_CANCEL_GOODS_FAIL);
    }

    /**
     * 修改推荐商品操作
     */
    @Override
    @Transactional(noRollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> updateNominateGoodsT(HttpServletRequest request) throws Exception
    {
        MNominateGoods nom = ServletUtils.objectMethod(MNominateGoods.class, request);
        // 参数验证
        String check = this.checkNominateGoods(nom);
        if (check != null)
        {
            return new TransData<Object>(false, check, null);
        }
        boolean flag = false;
        NominateGoods goods = new NominateGoods();
        EntityTools.copyValue(nom, goods);
        flag = this.recommendProductsCoreService.updateRecommendProducts(goods);
        if (!flag)
        {
            new GooagooException("修改推荐商品失败");
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_UPDATE_GOODS_SUCCESS, MisMessageConst.MIS_UPDATE_GOODS_FAIL, goods.getId());
    }

    /**
     * 推荐商品页面
     */
    @Override
    public TransData<Object> addNominateGoodsPage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "id", "");
        GoodsBaseInfo good = this.goodsBaseInfoGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        GoodsMarketingInfo market = this.goodsMarketingInfoGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (market != null)
        {
            MGoodsMarketingInfo mgood = new MGoodsMarketingInfo();
            EntityTools.copyValue(market, mgood);
            mgood.setGoodsName(good.getGoodsName());
            return new TransData<Object>(true, null, mgood);
        }
        else
        {
            return new TransData<Object>(false, MisMessageConst.SYS_LOAD_DATA_ERROR, null);
        }
    }

    /**
     * 修改推荐商品页面
     */
    @Override
    public TransData<Object> updateNominateGoodsTPage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "id", "");
        NominateGoods goods = this.nominateGoodsGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (goods != null)
        {
            MNominateGoods mgoods = new MNominateGoods();
            EntityTools.copyValue(goods, mgoods);
            GoodsBaseInfo good = this.goodsBaseInfoGeneratorQueryService.selectUnDelByPrimaryKey(goods.getGoodsId());
            if (good != null)
            {
                mgoods.setGoodsName(good.getGoodsName());
                GoodsMarketingInfo market = this.goodsMarketingInfoGeneratorQueryService.selectUnDelByPrimaryKey(goods.getGoodsId());
                if (market != null)
                {
                    mgoods.setGoodsImg(market.getGoodsImg());
                }
                else
                {
                    GooagooLog.warn("goods_marketing_info表：" + goods.getGoodsId() + ",商品图片URL为空");
                }
            }
            else
            {
                GooagooLog.warn("goods_base_info表：" + goods.getGoodsId() + ",商品名称为空");
            }
            return new TransData<Object>(true, null, mgoods);
        }
        else
        {
            return new TransData<Object>(false, MisMessageConst.SYS_LOAD_DATA_ERROR, null);
        }
    }

    /**
     * 验证商品是否已推荐
     */
    @Override
    public TransData<Object> checkNominateGoodsT(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        GoodsBaseInfo good = this.goodsBaseInfoGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (good != null)
        {
            NominateGoodsExample exam = new NominateGoodsExample();
            exam.createCriteria().andGoodsIdEqualTo(good.getGoodsId()).andShopIdEqualTo(good.getShopId()).andIsDelEqualTo("N");
            List<NominateGoods> acti = this.nominateGoodsGeneratorQueryService.selectByExample(exam);
            if (acti.size() > 0)
            {
                return new TransData<Object>(false, MisMessageConst.MIS_DICTIARY_PARAMETER_CHECKGOODS_FAIL, null);
            }
        }
        return new TransData<Object>(true, null, null);
    }

    /**
     * 入参校验
     * @param nom
     * @return
     */
    private String checkNominateGoods(MNominateGoods nom)
    {
        //结束时间必须大于起始时间
        if (nom.getStartTime().compareTo(nom.getEndTime()) >= 0)
        {
            return MisMessageConst.MIS_NOMINATE_START_END;
        }
        //起始时间不允许重复存在
        NominateGoodsExample example = new NominateGoodsExample();
        Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(nom.getId()))
        {
            criteria.andIdNotEqualTo(nom.getId());
        }
        criteria.andIsDelEqualTo("N").andGoodsIdEqualTo(nom.getGoodsId()).andStartTimeLessThanOrEqualTo(nom.getStartTime()).andEndTimeGreaterThanOrEqualTo(nom.getStartTime());
        List<NominateGoods> shopList = this.nominateGoodsGeneratorQueryService.selectByExample(example);
        if (shopList != null && shopList.size() > 0)
        {
            return MisMessageConst.MIS_NOMINATE_START_EXITS;
        }
        //结束时间不允许重复存在
        NominateGoodsExample example2 = new NominateGoodsExample();
        Criteria criteria2 = example2.createCriteria();
        if (StringUtils.hasText(nom.getId()))
        {
            criteria2.andIdNotEqualTo(nom.getId());
        }
        criteria2.andIsDelEqualTo("N").andGoodsIdEqualTo(nom.getGoodsId()).andStartTimeLessThanOrEqualTo(nom.getEndTime()).andEndTimeGreaterThanOrEqualTo(nom.getEndTime());
        List<NominateGoods> shopList2 = this.nominateGoodsGeneratorQueryService.selectByExample(example2);
        if (shopList2 != null && shopList2.size() > 0)
        {
            return MisMessageConst.MIS_NOMINATE_END_EXITS;
        }
        //不允许包含已存在的推荐时间段
        NominateGoodsExample example3 = new NominateGoodsExample();
        Criteria criteria3 = example3.createCriteria();
        if (StringUtils.hasText(nom.getId()))
        {
            criteria3.andIdNotEqualTo(nom.getId());
        }
        criteria3.andIsDelEqualTo("N").andGoodsIdEqualTo(nom.getGoodsId()).andStartTimeGreaterThan(nom.getStartTime()).andEndTimeLessThan(nom.getEndTime());
        List<NominateGoods> shopList3 = this.nominateGoodsGeneratorQueryService.selectByExample(example3);
        if (shopList3 != null && shopList3.size() > 0)
        {
            return MisMessageConst.MIS_NOMINATE_TIME_EXITS;
        }
        return null;
    }
}
