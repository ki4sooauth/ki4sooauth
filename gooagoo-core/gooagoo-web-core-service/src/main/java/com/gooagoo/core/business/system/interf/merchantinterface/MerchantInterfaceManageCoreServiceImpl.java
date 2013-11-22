package com.gooagoo.core.business.system.interf.merchantinterface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.interf.merchantinterface.MerchantInterfaceManageCoreService;
import com.gooagoo.api.generator.core.sys.InterfaceBaseInfoGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.dao.generator.sys.ShopInterfaceInfoMapper;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfo;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfoExample;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfo;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfoExample;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class MerchantInterfaceManageCoreServiceImpl implements MerchantInterfaceManageCoreService

{

    @Autowired
    private InterfaceBaseInfoGeneratorCoreService interfaceBaseInfoGeneratorCoreService;

    @Autowired
    private ShopInterfaceInfoMapper shopInterfaceInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean allotInterface(String url, String shopId) throws Exception
    {
        //url判空
        if (url.isEmpty())
        {
            GooagooLog.warn("分配商家接口地址时url为空");
            return false;
        }

        InterfaceBaseInfoExample interfaceBaseInfoExample = new InterfaceBaseInfoExample();
        interfaceBaseInfoExample.createCriteria().andCanAllocateEqualTo("Y");
        //获取所有可分配接口
        List<InterfaceBaseInfo> interfaceBaseInfos = this.interfaceBaseInfoGeneratorCoreService.selectByExample(interfaceBaseInfoExample);
        ShopInterfaceInfo shopInterfaceInfo;
        ShopInterfaceInfoExample shopInterfaceInfoExample;
        for (InterfaceBaseInfo ib : interfaceBaseInfos)
        {
            shopInterfaceInfoExample = new ShopInterfaceInfoExample();
            shopInterfaceInfoExample.createCriteria().andShopIdEqualTo(shopId).andICodeEqualTo(ib.getICode());
            shopInterfaceInfo = new ShopInterfaceInfo();
            //如果商家接口地址分配表中不存在当前商家的接口地址信息则新增数据
            if (this.shopInterfaceInfoMapper.countByExample(shopInterfaceInfoExample) == 0)
            {
                shopInterfaceInfo.setShopId(shopId);
                shopInterfaceInfo.setICode(ib.getICode());
                shopInterfaceInfo.setId(StringUtils.getUUID());
                shopInterfaceInfo.setIUrl(url + ib.getIUrl().substring((ib.getIUrl().indexOf(".com") + 4)));
                shopInterfaceInfo.setIsDel("N");
                if (this.shopInterfaceInfoMapper.insertSelective(shopInterfaceInfo) < 0)
                {
                    throw new OperateFailException("新增商家接口地址（输入域名）失败" + new Gson().toJson(shopInterfaceInfo));
                }
            }
            //如果商家接口地址分配表中存在当前商家的接口地址信息则更新数据
            else
            {
                //获取已存在的信息主键
                shopInterfaceInfo.setId(this.shopInterfaceInfoMapper.selectByExample(shopInterfaceInfoExample).get(0).getId());
                shopInterfaceInfo.setIUrl(url + ib.getIUrl().substring((ib.getIUrl().indexOf(".com") + 4)));
                if (this.shopInterfaceInfoMapper.updateByPrimaryKeySelective(shopInterfaceInfo) < 0)
                {
                    throw new OperateFailException("更新商家接口地址（输入域名）失败" + new Gson().toJson(shopInterfaceInfo));
                }
            }
        }
        return true;
    }

    @Override
    public boolean updateInterface(ShopInterfaceInfo shopInterfaceInfo) throws Exception
    {
        return this.shopInterfaceInfoMapper.updateByPrimaryKeySelective(shopInterfaceInfo) > 0 ? true : false;
    }

}
