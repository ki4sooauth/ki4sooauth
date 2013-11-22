package com.gooagoo.core.business.system.hierarchy;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.hierarchy.PlatformRegionCoreService;
import com.gooagoo.api.generator.core.sys.PlatformRegionGeneratorCoreService;
import com.gooagoo.api.generator.core.sys.TradeAreaGeneratorCoreService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.sys.PlatformRegion;
import com.gooagoo.entity.generator.sys.PlatformRegionExample;
import com.gooagoo.entity.generator.sys.TradeAreaExample;

@Service
public class PlatformRegionCoreServiceImpl implements PlatformRegionCoreService
{

    @Autowired
    private PlatformRegionGeneratorCoreService platformRegionGeneratorCoreService;
    @Autowired
    private TradeAreaGeneratorCoreService tradeAreaGeneratorCoreService;

    @Override
    public boolean addPlatformRegion(PlatformRegion platformRegion) throws Exception
    {
        platformRegion.setPlatformId(UUID.getUUID());
        platformRegion.setIsDel("N");
        return this.platformRegionGeneratorCoreService.insertSelective(platformRegion);
    }

    @Override
    public boolean updatePlatformRegion(PlatformRegion platformRegion) throws Exception
    {
        return this.platformRegionGeneratorCoreService.updateByPrimaryKeySelective(platformRegion);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean batchDeletePlatformRegion(String platformIds) throws Exception
    {
        List<String> idList = Arrays.asList(platformIds.split(","));
        //1、删除小平台关联商圈
        TradeAreaExample tradeAreaExample = new TradeAreaExample();
        tradeAreaExample.createCriteria().andPlatformIdIn(idList).andIsDelEqualTo("N");
        this.tradeAreaGeneratorCoreService.deleteByExample(tradeAreaExample);
        //2、删除区域性小平台
        PlatformRegionExample platformRegionExample = new PlatformRegionExample();
        platformRegionExample.createCriteria().andPlatformIdIn(idList).andIsDelEqualTo("N");
        return this.platformRegionGeneratorCoreService.deleteByExample(platformRegionExample);
    }

}
