package com.gooagoo.mis.usermanage.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.lid.ShopLidCoreService;
import com.gooagoo.api.business.core.system.user.enterprise.AllotLidCoreService;
import com.gooagoo.api.generator.query.shop.ShopLidInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.shop.ShopLidInfo;
import com.gooagoo.entity.generator.shop.ShopLidInfoExample;
import com.gooagoo.entity.generator.shop.ShopLidInfoExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.usermanage.service.ShopLidService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MShopLidInfo;

@Service(value = "shopLidService")
public class ShopLidServiceImpl implements ShopLidService
{
    @Autowired
    private AllotLidCoreService allotLidCoreService;
    @Autowired
    private ShopLidInfoGeneratorQueryService shopLidInfoGeneratorQueryService;
    @Autowired
    private ShopLidCoreService shopLidCoreService;

    /**
     * 查询商家Lid信息
     */
    @Override
    public TransData<PageModel<MShopLidInfo>> searchLidInfo(HttpServletRequest request) throws Exception
    {
        ShopLidInfoExample shopExample = new ShopLidInfoExample();
        MShopLidInfo vo = ServletUtils.objectMethod(MShopLidInfo.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        Criteria criteria = shopExample.createCriteria();
        criteria.andShopEntityIdEqualTo(vo.getShopEntityId());
        if (StringUtils.hasText(vo.getIsDel()))
        {
            criteria.andIsDelEqualTo(vo.getIsDel());
        }
        PageModel<MShopLidInfo> pm = new PageModel<MShopLidInfo>();
        pm.setPageIndex(pageCondition.getPageIndex());
        pm.setPageSize(pageSize);
        Integer count = this.shopLidInfoGeneratorQueryService.countByExample(shopExample);
        if (count > 0)
        {
            shopExample.setPage(pageCondition.getPageIndex(), pageSize);// 设置分页条件
            List<ShopLidInfo> list = this.shopLidInfoGeneratorQueryService.selectByExample(shopExample);
            for (ShopLidInfo sho : list)
            {
                MShopLidInfo mshop = new MShopLidInfo();
                EntityTools.copyValue(sho, mshop);
                pm.getResult().add(mshop);
            }
        }
        return new TransData<PageModel<MShopLidInfo>>(true, null, pm);
    }

    /**
     * 删除商家Lid信息
     */
    @Override
    public TransData<Object> delShopLid(HttpServletRequest request) throws Exception
    {
        String lid = ServletRequestUtils.getStringParameter(request, "lids", "");
        boolean flag = this.shopLidCoreService.batchDeleteShopLidInfo(lid);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_USERMANA_ENTERPRISE_DEL_SHOPLID_SUCCESS, MisMessageConst.MIS_USERMANA_ENTERPRISE_DEL_SHOPLID_FAIL);
    }

    /**
     * Lid信息分配
     */
    @Override
    public TransData<Object> allotLid(HttpServletRequest request) throws Exception
    {
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        String lid = ServletRequestUtils.getStringParameter(request, "lid", "");
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        ShopLidInfo shopLid = this.shopLidInfoGeneratorQueryService.selectByPrimaryKey(lid);
        if (shopLid != null && !"".equals(shopLid))
        {
            return new TransData<Object>(true, MisMessageConst.MIS_USERMANA_ENTERPRISE_GIVE_SHOPLID_SAME_FAIL, null);
        }
        boolean flag = this.allotLidCoreService.allotjLid(lid, shopId, shopEntityId);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_USERMANA_ENTERPRISE_GIVE_SHOPLID_SUCCESS, MisMessageConst.MIS_USERMANA_ENTERPRISE_GIVE_SHOPLID_FAIL);
    }

}
