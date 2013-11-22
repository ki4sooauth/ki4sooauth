package com.gooagoo.mis.usermanage.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.user.enterprise.WifisensorManageCoreService;
import com.gooagoo.api.generator.query.shop.DeviceWifisensorGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.shop.DeviceWifisensor;
import com.gooagoo.entity.generator.shop.DeviceWifisensorExample;
import com.gooagoo.entity.generator.shop.DeviceWifisensorExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.usermanage.service.ShopWifisensorService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MDeviceWifisensor;

@Service(value = "shopWifisensorService")
public class ShopWifisensorServiceImpl implements ShopWifisensorService
{
    @Autowired
    private WifisensorManageCoreService wifisensorManageCoreService;
    @Autowired
    private DeviceWifisensorGeneratorQueryService deviceWifisensorGeneratorQueryService;

    /**
     * 查询Wifisensor
     */
    @Override
    public TransData<PageModel<MDeviceWifisensor>> searchShopWifisensor(HttpServletRequest request) throws Exception
    {
        DeviceWifisensorExample wifiExample = new DeviceWifisensorExample();
        MDeviceWifisensor mw = ServletUtils.objectMethod(MDeviceWifisensor.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        Criteria criteria = wifiExample.createCriteria();
        if (StringUtils.hasText(mw.getShopId()))
        {
            criteria.andShopIdEqualTo(mw.getShopId());
        }
        if (StringUtils.hasText(mw.getShopEntityId()))
        {
            criteria.andShopEntityIdEqualTo(mw.getShopEntityId());
        }
        if (StringUtils.hasText(mw.getIsDel()))
        {
            criteria.andIsDelEqualTo(mw.getIsDel());
        }
        PageModel<MDeviceWifisensor> pm = new PageModel<MDeviceWifisensor>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.deviceWifisensorGeneratorQueryService.countByExample(wifiExample);
        pm.setCount(count);
        if (count > 0)
        {
            wifiExample.setPage(pm.getPageIndex(), pageSize);// 设置分页条件
            List<DeviceWifisensor> list = this.deviceWifisensorGeneratorQueryService.selectByExample(wifiExample);
            for (DeviceWifisensor wifi : list)
            {
                MDeviceWifisensor mwifi = new MDeviceWifisensor();
                EntityTools.copyValue(wifi, mwifi);
                pm.getResult().add(mwifi);
            }
        }
        return new TransData<PageModel<MDeviceWifisensor>>(true, null, pm);
    }

    /**
     * 配置Wifisensor
     */
    @Override
    public TransData<Object> addShopWifisensor(HttpServletRequest request) throws Exception
    {
        MDeviceWifisensor ma = ServletUtils.objectMethod(MDeviceWifisensor.class, request);
        DeviceWifisensorExample wifiExample = new DeviceWifisensorExample();
        Criteria criteria = wifiExample.createCriteria();
        if (StringUtils.hasText(ma.getDeviceMac()))
        {
            criteria.andDeviceMacEqualTo(ma.getDeviceMac());
        }
        List<DeviceWifisensor> deviceWifisensorList = this.deviceWifisensorGeneratorQueryService.selectByExample(wifiExample);
        DeviceWifisensor device = new DeviceWifisensor();
        EntityTools.copyValue(ma, device);
        boolean flag = false;
        if (deviceWifisensorList.size() > 0)
        {
            if ("Y".equals(deviceWifisensorList.get(0).getIsDel()))
            {
                device.setIsDel("N");
                flag = this.wifisensorManageCoreService.updateWifisensor(device);
            }
            else
            {
                return new TransData<Object>(true, MisMessageConst.MIS_USERMANA_WIFISENSOR_IS_EXIST, null);
            }
        }
        else
        {
            device.setDeviceWifisensorId(UUID.getUUID());
            device.setStatus("0");
            flag = this.wifisensorManageCoreService.addWifisensor(device);
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_USERMANA_WIFISENSOR_SET_SUCCESS, MisMessageConst.MIS_USERMANA_WIFISENSOR_SET_FAIL, device.getDeviceWifisensorId());
    }

    /**
     * 删除Wifisensor
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delShopWifisensor(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        boolean flag = this.wifisensorManageCoreService.delWifisensor(ids);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_USERMANA_WIFISENSOR_DEL_SUCCESS, MisMessageConst.MIS_USERMANA_WIFISENSOR_DEL_FAIL);
    }

    /**
     * 查询Wifisensor详细
     */
    @Override
    public TransData<MDeviceWifisensor> searchShopWifisensorInfo(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        DeviceWifisensor deviceWifisensor = this.deviceWifisensorGeneratorQueryService.selectByPrimaryKey(ids.split(",")[0]);
        if (deviceWifisensor != null)
        {
            MDeviceWifisensor mdeviceWifisensor = new MDeviceWifisensor();
            EntityTools.copyValue(deviceWifisensor, mdeviceWifisensor);
            return new TransData<MDeviceWifisensor>(true, null, mdeviceWifisensor);
        }
        else
        {
            return new TransData<MDeviceWifisensor>(false, MisMessageConst.SYS_LOAD_DATA_ERROR, null);
        }
    }

    /**
     * 编辑Wifisensor
     */
    @Override
    public TransData<Object> updateShopWifisensor(HttpServletRequest request) throws Exception
    {
        DeviceWifisensor deviceWifisensor = ServletUtils.objectMethod(DeviceWifisensor.class, request);
        boolean flag = this.wifisensorManageCoreService.updateWifisensor(deviceWifisensor);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.SYS_UPD_SUCCESS, MisMessageConst.SYS_UPD_FAIL);
    }

}
