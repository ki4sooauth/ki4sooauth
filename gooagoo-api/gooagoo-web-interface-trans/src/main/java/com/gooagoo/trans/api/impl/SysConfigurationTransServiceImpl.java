package com.gooagoo.trans.api.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.shop.cache.ShopCacheQueryService;
import com.gooagoo.api.business.query.shop.cache.ShopEntityCacheQueryService;
import com.gooagoo.api.business.query.shop.query.ShopQueryService;
import com.gooagoo.api.generator.query.shop.DeviceTransponderGeneratorQueryService;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.DeviceTransponder;
import com.gooagoo.entity.generator.shop.DeviceTransponderExample;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.api.SysConfigurationTransService;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.entity.gtsa01.transform.Shopinfo;
import com.gooagoo.trans.entity.gtsa01.transform.SystemConfigurationRoot;
import com.google.gson.Gson;

@Service
public class SysConfigurationTransServiceImpl implements SysConfigurationTransService
{

    @Autowired
    private DeviceTransponderGeneratorQueryService deviceTransponderGeneratorQueryService;
    @Autowired
    private ShopCacheQueryService shopCacheQueryService;
    @Autowired
    private ShopEntityCacheQueryService shopEntityCacheQueryService;
    @Autowired
    private ShopQueryService shopQueryService;

    @Override
    public SystemConfigurationRoot getSysConfigurationInfo(String mac) throws Exception
    {
        GooagooLog.info("getSysConfigurationInfo-->入参:mac=" + mac);
        //1.根据转发器mac地址查询转发器信息
        DeviceTransponderExample deviceTransponderExample = new DeviceTransponderExample();
        deviceTransponderExample.createCriteria().andDeviceMacEqualTo(mac).andIsDelEqualTo("N");
        List<DeviceTransponder> deviceTransponderList = this.deviceTransponderGeneratorQueryService.selectByExample(deviceTransponderExample);

        GooagooLog.debug("根据mac=" + mac + "查询到的未删除的转发器设备信息为: " + new Gson().toJson(deviceTransponderList));

        //2.校验mac地址是否存在
        if (deviceTransponderList == null || deviceTransponderList.size() == 0)
        {
            GooagooLog.warn("转发器mac地址:" + mac + "不存在或已删除");
            throw new MessageException(MessageConst.TRANS_SYS_DEVICE_INFO_NOT_EXIST);
        }
        DeviceTransponder deviceTransponder = deviceTransponderList.get(0);
        String status = deviceTransponder.getStatus();//设备状态:0-在用，1-停用，2-损坏
        //3.对应的转发器设备已停用，不能初始化
        if ("1".equals(status))
        {
            GooagooLog.warn("转发器mac地址:" + mac + "对应的转发器设备已停用");
            throw new MessageException(MessageConst.TRANS_SYS_DEVICE_IS_STOP);
        }
        //4.对应的转发器设备已损坏，不能初始化
        if ("2".equals(status))
        {
            GooagooLog.warn("转发器mac地址:" + mac + "对应的转发器设备已损坏");
            throw new MessageException(MessageConst.TRANS_SYS_DEVICE_IS_BROKEN);
        }

        //5.查询商家名称

        //校验商家状态是否异常（是否存在、未删除、状态是否正常营业）
        if (!this.shopQueryService.checkShopStatus(deviceTransponder.getShopId(), null))
        {
            GooagooLog.warn("转发器mac地址:" + mac + "对应的shopId=" + deviceTransponder.getShopId() + "商家状态异常(不存在、已经删除、未正常营业)");
            throw new MessageException(MessageConst.TRANS_SYS_SHOP_EXCEPTION);
        }

        //6.查询实体店名称

        //校验实体店状态是否异常（是否存在、未删除）
        if (!this.shopQueryService.checkShopStatus(null, deviceTransponder.getShopEntityId()))
        {
            GooagooLog.warn("转发器mac地址:" + mac + "对应的shopId=" + deviceTransponder.getShopId() + "实体店状态异常(不存在或已经删除)");
            throw new MessageException(MessageConst.TRANS_SYS_SHOPENTITYID_EXCEPTION);
        }

        //获取商家信息
        Map<String, String> shopInfoMap = this.shopCacheQueryService.findShopInfo(deviceTransponder.getShopId());

        GooagooLog.debug("根据shop=" + mac + "查询到的商家信息为: " + new Gson().toJson(shopInfoMap));

        //获取实体店信息
        Map<String, String> shopEntityInfoMap = this.shopEntityCacheQueryService.findShopEntityInfo(deviceTransponder.getShopEntityId());

        GooagooLog.debug("根据shop=" + mac + "查询到的商家实体店信息为: " + new Gson().toJson(shopEntityInfoMap));

        //7.封装返回数据
        SystemConfigurationRoot root = new SystemConfigurationRoot();
        Shopinfo shopinfo = new Shopinfo();
        shopinfo.setBillparse(SysdictionaryCache.get("bill_parse", deviceTransponder.getBillParse()));//解析格式
        shopinfo.setDevicetype(deviceTransponder.getDeviceType());//设备类型
        shopinfo.setShopentityid(deviceTransponder.getShopEntityId());
        shopinfo.setShopentityname(shopEntityInfoMap != null && shopEntityInfoMap.size() > 0 ? shopEntityInfoMap.get("shopEntityName") : "");
        shopinfo.setShopid(deviceTransponder.getShopId());
        shopinfo.setShopname(shopInfoMap != null && shopInfoMap.size() > 0 ? shopInfoMap.get("shopName") : "");
        shopinfo.setStservice(deviceTransponder.getStService());
        shopinfo.setSystemtype(deviceTransponder.getSystemType());
        root.setShopinfo(shopinfo);

        return root;
    }
}
