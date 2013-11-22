package com.gooagoo.igms.shopinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.wifisensor.WifisensorCoreService;
import com.gooagoo.api.generator.query.shop.DeviceWifisensorGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.DeviceWifisensor;
import com.gooagoo.entity.generator.shop.DeviceWifisensorExample;
import com.gooagoo.entity.generator.shop.DeviceWifisensorExample.Criteria;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.igms.shopinfo.service.IWifisensorService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FDeviceWifisensor;

@Service("iwifiSensorService")
public class IWifisensorServiceImpl implements IWifisensorService
{
    @Autowired
    private WifisensorCoreService wifiCoreService;
    @Autowired
    private DeviceWifisensorGeneratorQueryService wifiQueryService;
    @Autowired
    private ShopLoginService shopLoginService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;

    @Override
    public TransData<PageModel<FDeviceWifisensor>> pageWifiSensor(HttpServletRequest request) throws Exception
    {
        DeviceWifisensor deviceWifisensor = ServletUtils.objectMethod(DeviceWifisensor.class, request);
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        ShopLoginInfo gmsLoginInfo = this.shopLoginService.getShopLoginInfo(request);
        DeviceWifisensorExample example = new DeviceWifisensorExample();
        Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(shopEntityId))
        {
            criteria.andShopEntityIdEqualTo(shopEntityId);
        }
        if (gmsLoginInfo.getShopAndUserInfo().getUserIsShopAccount().equals("N"))
        {
            criteria.andShopEntityIdEqualTo(gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId());
        }
        criteria.andShopIdEqualTo(gmsLoginInfo.getShopAndUserInfo().getShopId());
        //查询
        if (StringUtils.hasText(deviceWifisensor.getStatus()))
        {
            criteria.andStatusEqualTo(deviceWifisensor.getStatus());
        }
        if (StringUtils.hasText(deviceWifisensor.getPositionName()))
        {
            criteria.andPositionNameLike("%" + deviceWifisensor.getPositionName() + "%");
        }
        if (StringUtils.hasText(deviceWifisensor.getDeviceSn()))
        {
            criteria.andDeviceSnLike("%" + deviceWifisensor.getDeviceSn() + "%");
        }
        criteria.andIsDelEqualTo("N");

        int count = this.wifiQueryService.countByExample(example);

        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        example.setPage(pageIndex, pageSize);
        example.setOrderByClause(" c_time_stamp desc ");
        List<DeviceWifisensor> list = this.wifiQueryService.selectByExample(example);
        List<FDeviceWifisensor> wifis = new ArrayList<FDeviceWifisensor>();
        for (DeviceWifisensor e : list)
        {
            ShopEntityInfo entityInfo = this.shopEntityInfoGeneratorQueryService.selectByPrimaryKey(e.getShopEntityId());
            FDeviceWifisensor sensor = new FDeviceWifisensor();
            BeanUtils.copyProperties(e, sensor);
            sensor.setShopEntityName(entityInfo.getShopEntityName());
            sensor.setId(e.getDeviceWifisensorId());
            wifis.add(sensor);
        }

        PageModel<FDeviceWifisensor> pm = new PageModel<FDeviceWifisensor>();
        pm.setCount(count);
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);
        pm.setResult(wifis);
        return GMSUtil.toTransData(true, null, pm);
    }

    @Override
    public TransData<FDeviceWifisensor> detailWifiSensor(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        DeviceWifisensor deviceWifisensor = this.wifiQueryService.selectByPrimaryKey(id);
        FDeviceWifisensor fdw = new FDeviceWifisensor();
        BeanUtils.copyProperties(deviceWifisensor, fdw);
        fdw.setId(deviceWifisensor.getDeviceWifisensorId());
        return GMSUtil.toTransData(true, null, fdw);
    }

    @Override
    public TransData<Object> updateWifiSensor(HttpServletRequest request) throws Exception
    {
        DeviceWifisensor deviceWifisensor = ServletUtils.objectMethod(DeviceWifisensor.class, request);
        boolean flag = this.wifiCoreService.updateWifisensor(deviceWifisensor);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, deviceWifisensor.getDeviceWifisensorId());
    }
}
