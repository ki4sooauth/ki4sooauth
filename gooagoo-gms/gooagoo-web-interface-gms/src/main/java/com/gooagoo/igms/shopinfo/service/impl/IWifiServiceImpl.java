package com.gooagoo.igms.shopinfo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.wifi.ShopWifiCoreService;
import com.gooagoo.api.business.core.shop.wifisensor.WifisensorCoreService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopWifiinfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopWifiinfo;
import com.gooagoo.entity.generator.shop.ShopWifiinfoExample;
import com.gooagoo.entity.generator.shop.ShopWifiinfoExample.Criteria;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.shopinfo.service.IWifiService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FWifiInfo;

@Service("iwifiService")
public class IWifiServiceImpl implements IWifiService
{
    @Autowired
    private WifisensorCoreService wifiCoreService;
    @Autowired
    private ShopWifiCoreService shopWifiCoreService;
    @Autowired
    private ShopWifiinfoGeneratorQueryService wifiQueryService;
    @Autowired
    private ShopLoginService shopLoginService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;

    @Override
    public TransData<Object> addWifiInfo(HttpServletRequest request) throws Exception
    {
        ShopWifiinfo wifiinfo = ServletUtils.objectMethod(ShopWifiinfo.class, request);

        String id = StringUtils.getUUID();
        wifiinfo.setWifiInfoId(id);
        wifiinfo.setIsDel("N");
        wifiinfo.setCreateTime(new Date());
        wifiinfo.setShopId(GmsInterfaceUtil.getShopIdByInterface(request));
        ShopWifiinfoExample shopWifiinfoExample = new ShopWifiinfoExample();
        shopWifiinfoExample.createCriteria().andWifiMacEqualTo(wifiinfo.getWifiMac());
        List<ShopWifiinfo> list = this.wifiQueryService.selectByExample(shopWifiinfoExample);
        TransData<Object> r = new TransData<Object>();
        if (list != null && list.size() != 0)
        {
            r = GMSUtil.getBooleanResult(false, null, MessageConst.GMS_OPERATE_FAIL);
            return r;
        }
        boolean flag = this.shopWifiCoreService.addShopWifiinfo(wifiinfo);
        r = GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
        r.setData(id);
        r.setOperateId(id);
        return r;
    }

    @Override
    public TransData<Object> deleteWifiInfo(HttpServletRequest request) throws Exception
    {
        String wifiId = ServletRequestUtils.getStringParameter(request, "wifiInfoId", "");
        boolean flag = this.wifiCoreService.deleteWifisensor(wifiId);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, wifiId);
    }

    @Override
    public TransData<FWifiInfo> getWifiInfo(HttpServletRequest request) throws Exception
    {
        String wifiId = ServletRequestUtils.getStringParameter(request, "wifiInfoId", "");
        ShopWifiinfo wifiinfo = this.wifiQueryService.selectByPrimaryKey(wifiId);
        FWifiInfo fWifiInfo = this.convertToFWifiInfo(wifiinfo);
        return GMSUtil.toTransData(true, null, fWifiInfo);
    }

    @Override
    public TransData<PageModel<FWifiInfo>> pageWifiInfo(HttpServletRequest request) throws Exception
    {
        ShopLoginInfo gmsLoginInfo = this.shopLoginService.getShopLoginInfo(request);
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        String wifiSsid = ServletRequestUtils.getStringParameter(request, "wifiSsid", "");
        ShopWifiinfoExample example = new ShopWifiinfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(gmsLoginInfo.getShopAndUserInfo().getShopId());
        if (org.springframework.util.StringUtils.hasText(shopEntityId))
        {
            criteria.andShopEntityIdEqualTo(shopEntityId);
        }
        if (org.springframework.util.StringUtils.hasText(wifiSsid))
        {
            criteria.andWifiSsidLike("%" + wifiSsid + "%");
        }
        if (org.springframework.util.StringUtils.hasText(gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId()))
        {
            criteria.andShopEntityIdEqualTo(gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId());
        }
        criteria.andIsDelEqualTo("N");

        int count = this.wifiQueryService.countByExample(example);

        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);

        example.setPage(pageIndex, pageSize);
        example.setOrderByClause(" c_time_stamp desc ");

        List<ShopWifiinfo> list = this.wifiQueryService.selectByExample(example);
        List<FWifiInfo> wifiInfos = new ArrayList<FWifiInfo>();
        for (ShopWifiinfo e : list)
        {
            ShopEntityInfo entityInfo = this.shopEntityInfoGeneratorQueryService.selectByPrimaryKey(e.getShopEntityId());
            FWifiInfo info = this.convertToFWifiInfo(e);
            info.setShopEntityName(entityInfo.getShopEntityName());
            wifiInfos.add(info);
        }
        PageModel<FWifiInfo> pm = new PageModel<FWifiInfo>();
        pm.setCount(count);
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);
        pm.setResult(wifiInfos);

        return GMSUtil.toTransData(true, null, pm);
    }

    @Override
    public TransData<Object> updateWifiInfo(HttpServletRequest request) throws Exception
    {
        ShopWifiinfo wifiinfo = ServletUtils.objectMethod(ShopWifiinfo.class, request);
        boolean flag = this.shopWifiCoreService.updateShopWifiinfo(wifiinfo);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, wifiinfo.getWifiInfoId());
    }

    private FWifiInfo convertToFWifiInfo(ShopWifiinfo info)
    {
        FWifiInfo wifi = null;
        if (info != null)
        {
            wifi = new FWifiInfo();
            wifi.setShopEntityId(info.getShopEntityId());
            wifi.setShopId(info.getShopId());
            wifi.setWifiInfoId(info.getWifiInfoId());
            wifi.setWifiMac(info.getWifiMac());
            wifi.setWifiPassword(info.getWifiPassword());
            wifi.setWifiSsid(info.getWifiSsid());
        }
        return wifi;
    }
}
