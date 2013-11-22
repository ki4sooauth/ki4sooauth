package com.gooagoo.mis.rsrcmanage.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.generator.query.sys.ShopAdGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.sys.ShopAd;
import com.gooagoo.entity.generator.sys.ShopAdExample;
import com.gooagoo.entity.generator.sys.ShopAdExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.rsrcmanage.service.ShopAdService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.recommendManage.MShopAd;

@Service(value = "shopAdService")
public class ShopAdServiceImpl implements ShopAdService
{
    @Autowired
    private ShopAdGeneratorQueryService shopAdGeneratorQueryService;

    /**
     * 查询所有广告位信息
     */
    @Override
    public TransData<PageModel<MShopAd>> queryAllShopAd(HttpServletRequest request) throws Exception
    {
        MShopAd mad = ServletUtils.objectMethod(MShopAd.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        ShopAdExample example = new ShopAdExample();
        Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(mad.getAdCode()))
        {
            criteria.andAdCodeLike("%" + mad.getAdCode() + "%");
        }
        if (StringUtils.hasText(mad.getAdType()))
        {
            criteria.andAdTypeEqualTo(mad.getAdType());
        }
        if (StringUtils.hasText(mad.getAdName()))
        {
            criteria.andAdNameLike("%" + mad.getAdName() + "%");
        }
        PageModel<MShopAd> pm = new PageModel<MShopAd>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageCondition.getPageSize() <= 0 ? 10 : pageCondition.getPageSize());
        }
        Integer count = this.shopAdGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            example.setPage(pm.getPageIndex(), pm.getPageSize());
            List<ShopAd> adList = this.shopAdGeneratorQueryService.selectByExample(example);
            for (ShopAd ad : adList)
            {
                MShopAd ma = new MShopAd();
                EntityTools.copyValue(ad, ma);
                pm.getResult().add(ma);
            }
        }
        return new TransData<PageModel<MShopAd>>(true, null, pm);
    }

    /**
     * 查询广告位信息详细
     * @throws Exception 
     */
    @Override
    public TransData<MShopAd> queryShopAd(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        ShopAd ad = this.shopAdGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (ad != null)
        {
            MShopAd mad = new MShopAd();
            EntityTools.copyValue(ad, mad);
            return new TransData<MShopAd>(true, null, mad);
        }
        else
        {
            return new TransData<MShopAd>(false, MisMessageConst.MIS_RESOURCE_SHOPAD_QUERY_FAIL, null);
        }
    }

    /**
     * 新增广告位信息
     */
    @SuppressWarnings("unused")
    @Override
    public TransData<Object> addShopAd(HttpServletRequest request) throws Exception
    {
        MShopAd mad = ServletUtils.objectMethod(MShopAd.class, request);
        ShopAd ad = new ShopAd();
        EntityTools.copyValue(mad, ad);
        boolean flag = false;//TODO
        return UtilsMis.getBooleanResult(false, MisMessageConst.MIS_RESOURCE_SHOPAD_ADD_SUCCESS, MisMessageConst.MIS_RESOURCE_SHOPAD_ADD_FAIL, ad.getAdCode());
    }

    /**
     * 编辑广告位信息
     */
    @SuppressWarnings("unused")
    @Override
    public TransData<Object> updateShopAd(HttpServletRequest request) throws Exception
    {
        MShopAd mad = ServletUtils.objectMethod(MShopAd.class, request);
        ShopAd ad = new ShopAd();
        EntityTools.copyValue(mad, ad);
        boolean flag = false;//TODO
        return UtilsMis.getBooleanResult(false, MisMessageConst.MIS_RESOURCE_SHOPAD_UPDATE_SUCCESS, MisMessageConst.MIS_RESOURCE_SHOPAD_UPDATE_FAIL, ad.getAdCode());
    }

    /**
     * 删除广告位信息
     */
    @Override
    public TransData<Object> deleteShopAd(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
