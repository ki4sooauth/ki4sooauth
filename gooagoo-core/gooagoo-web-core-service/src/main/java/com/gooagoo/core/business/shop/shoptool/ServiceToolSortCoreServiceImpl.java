package com.gooagoo.core.business.shop.shoptool;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.shop.shoptool.ServiceToolSortCoreService;
import com.gooagoo.api.generator.core.shop.ServiceToolSortGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.shop.ServiceToolSort;
import com.gooagoo.entity.generator.shop.ServiceToolSortExample;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class ServiceToolSortCoreServiceImpl implements ServiceToolSortCoreService
{

    @Autowired
    private ServiceToolSortGeneratorCoreService serviceToolSortGeneratorCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addServiceToolSortList(String shopId, List<ServiceToolSort> serviceToolSortList) throws Exception
    {
        //1、验证参数是否为空
        if (StringUtils.isBlank(shopId))
        {
            GooagooLog.info("批量新增服务工具排序信息参数验证:商家为空");
            return false;
        }
        if (CollectionUtils.isEmpty(serviceToolSortList))
        {
            GooagooLog.info("批量新增服务工具排序信息参数验证:新增服务工具排序列表为空");
            return false;
        }
        //2、硬删该商家服务工具排序信息
        ServiceToolSortExample serviceToolSortExample = new ServiceToolSortExample();
        serviceToolSortExample.createCriteria().andShopIdEqualTo(shopId);
        this.serviceToolSortGeneratorCoreService.physicalDeleteByExample(serviceToolSortExample);
        //3、批量新增服务工具排序信息
        for (ServiceToolSort item : serviceToolSortList)
        {
            item.setId(UUID.getUUID());
            if (!this.serviceToolSortGeneratorCoreService.insertSelective(item))
            {
                GooagooLog.error("新增服务工具排序信息失败[ServiceToolSort=" + item.toString() + "]", null);
                throw new OperateFailException("新增服务工具排序信息失败[ServiceToolSort=" + item.toString() + "]");
            }
        }
        return true;
    }
}
