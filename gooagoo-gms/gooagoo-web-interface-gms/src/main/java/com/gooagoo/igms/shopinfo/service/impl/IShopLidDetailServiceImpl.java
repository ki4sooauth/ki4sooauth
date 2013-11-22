package com.gooagoo.igms.shopinfo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.lid.ShopLidCoreService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopLidDetailGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopLidDetail;
import com.gooagoo.entity.generator.shop.ShopLidDetailExample;
import com.gooagoo.entity.generator.shop.ShopLidDetailExample.Criteria;
import com.gooagoo.igms.shopinfo.service.IShopLidDetailService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopLidDetail;

@Service("ishopLidDetailService")
public class IShopLidDetailServiceImpl implements IShopLidDetailService
{
    @Autowired
    private ShopLidDetailGeneratorQueryService shopLidQueryService;
    @Autowired
    private ShopLidCoreService shopLidCoreService;
    @Autowired
    private ShopLoginService shopLoginService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;

    @Override
    public TransData<Object> updateLidDetail(HttpServletRequest request) throws Exception
    {
        ShopLidDetail lid = ServletUtils.objectMethod(ShopLidDetail.class, request);
        lid.setIsDel("N");
        lid.setCreateTime(new Date());
        boolean flag = false;
        try
        {
            flag = this.shopLidCoreService.updateShopLidDetail(lid);
        }
        catch (Exception e)
        {
            return GMSUtil.getBooleanResult(false, null, MessageConst.GMS_OPERATE_FAIL);
        }
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, lid.getLid());
    }

    @Override
    public TransData<FShopLidDetail> getLidDetail(HttpServletRequest request) throws Exception
    {
        String lid = ServletRequestUtils.getStringParameter(request, "lid", "");
        ShopLidDetail lidDetail = this.shopLidQueryService.selectByPrimaryKey(lid);
        FShopLidDetail detail = new FShopLidDetail();
        BeanUtils.copyProperties(lidDetail, detail);
        detail.setLid(lidDetail.getLid());
        return GMSUtil.toTransData(true, null, detail);
    }

    @Override
    public TransData<PageModel<FShopLidDetail>> pageLidDetail(HttpServletRequest request) throws Exception
    {
        String lidStr = ServletRequestUtils.getStringParameter(request, "lid", "");
        String positionName = ServletRequestUtils.getStringParameter(request, "positionName", "");
        String status = ServletRequestUtils.getStringParameter(request, "status", "");
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");

        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        ShopLidDetailExample example = new ShopLidDetailExample();
        Criteria criteria = example.createCriteria();

        if (!lidStr.isEmpty())
        {
            criteria.andLidEqualTo(lidStr);
        }
        if (!positionName.isEmpty())
        {
            criteria.andPositionNameEqualTo(positionName);
        }
        if (!status.isEmpty())
        {
            criteria.andStatusEqualTo(status);
        }
        if (!shopEntityId.isEmpty())
        {
            criteria.andShopEntityIdEqualTo(shopEntityId);
        }
        criteria.andShopIdEqualTo(shopInfo.getShopAndUserInfo().getShopId());
        if (shopInfo.getShopAndUserInfo().getUserIsShopAccount().equals("N"))
        {
            criteria.andShopEntityIdEqualTo(shopInfo.getShopAndUserInfo().getUserShopEntityId());
        }
        criteria.andIsDelEqualTo("N");

        int count = this.shopLidQueryService.countByExample(example);
        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        example.setPage(pageIndex, pageSize);
        example.setOrderByClause(" c_time_stamp desc ");

        List<ShopLidDetail> list = this.shopLidQueryService.selectByExample(example);
        List<FShopLidDetail> lids = new ArrayList<FShopLidDetail>();
        for (ShopLidDetail l : list)
        {
            ShopEntityInfo entityInfo = this.shopEntityInfoGeneratorQueryService.selectByPrimaryKey(l.getShopEntityId());
            FShopLidDetail lid = new FShopLidDetail();
            BeanUtils.copyProperties(l, lid);
            lid.setShopEntityName(entityInfo.getShopEntityName());
            lid.setLid(l.getLid());
            lids.add(lid);
        }
        PageModel<FShopLidDetail> pm = new PageModel<FShopLidDetail>();
        pm.setCount(count);
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);
        pm.setResult(lids);

        return GMSUtil.toTransData(true, null, pm);
    }

}
