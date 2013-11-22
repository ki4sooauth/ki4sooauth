package com.gooagoo.igms.shopinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.transponder.TransponderCoreService;
import com.gooagoo.api.generator.query.shop.DeviceTransponderGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.DeviceTransponder;
import com.gooagoo.entity.generator.shop.DeviceTransponderExample;
import com.gooagoo.entity.generator.shop.DeviceTransponderExample.Criteria;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.igms.shopinfo.service.ITranspcInfoService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FTranspcInfo;

@Service("itranspcInfoService")
public class ITranspcInfoServiceImpl implements ITranspcInfoService
{
    @Autowired
    private TransponderCoreService transponderCoreService;
    @Autowired
    private DeviceTransponderGeneratorQueryService transponderQueryService;
    @Autowired
    private ShopLoginService shopLoginService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;

    @Override
    public TransData<FTranspcInfo> getTranspcInfo(HttpServletRequest request) throws Exception
    {
        String transpcInfoId = ServletRequestUtils.getStringParameter(request, "transpcInfoId", "");
        DeviceTransponder transponder = this.transponderQueryService.selectByPrimaryKey(transpcInfoId);
        FTranspcInfo fTranspcInfo = new FTranspcInfo();
        BeanUtils.copyProperties(transponder, fTranspcInfo);
        return GMSUtil.toTransData(true, null, fTranspcInfo);
    }

    @Override
    public TransData<PageModel<FTranspcInfo>> pageTranspcInfo(HttpServletRequest request) throws Exception
    {
        String deviceType = ServletRequestUtils.getStringParameter(request, "typeId", "");
        String status = ServletRequestUtils.getStringParameter(request, "state", "");
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        ShopLoginInfo gmsLoginInfo = this.shopLoginService.getShopLoginInfo(request);
        DeviceTransponderExample example = new DeviceTransponderExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(gmsLoginInfo.getShopAndUserInfo().getShopId());
        if (gmsLoginInfo.getShopAndUserInfo().getUserIsShopAccount().equals("N"))
        {
            criteria.andShopEntityIdEqualTo(gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId());
        }
        criteria.andIsDelEqualTo("N");
        if (!deviceType.isEmpty())
        {
            criteria.andDeviceTypeEqualTo(deviceType);
        }
        if (!status.isEmpty())
        {
            criteria.andStatusEqualTo(status);
        }
        if (!shopEntityId.isEmpty())
        {
            criteria.andShopEntityIdEqualTo(shopEntityId);
        }
        int count = this.transponderQueryService.countByExample(example);
        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);

        example.setPage(pageIndex, pageSize);
        example.setOrderByClause(" c_time_stamp desc ");

        List<DeviceTransponder> list = this.transponderQueryService.selectByExample(example);
        List<FTranspcInfo> infos = new ArrayList<FTranspcInfo>();
        for (DeviceTransponder e : list)
        {
            ShopEntityInfo entityInfo = this.shopEntityInfoGeneratorQueryService.selectByPrimaryKey(e.getShopEntityId());
            FTranspcInfo info = new FTranspcInfo();
            BeanUtils.copyProperties(e, info);
            info.setShopEntityName(entityInfo.getShopEntityName());
            infos.add(info);
        }

        PageModel<FTranspcInfo> pm = new PageModel<FTranspcInfo>();
        pm.setCount(count);
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);
        pm.setResult(infos);

        return GMSUtil.toTransData(true, null, pm);
    }

    @Override
    public TransData<Object> updateTranspcInfo(HttpServletRequest request) throws Exception
    {
        DeviceTransponder transponder = ServletUtils.objectMethod(DeviceTransponder.class, request);
        boolean flag = this.transponderCoreService.updateTransponder(transponder);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, transponder.getDeviceSn());
    }

}
