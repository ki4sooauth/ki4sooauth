package com.gooagoo.common.thread;

import java.util.List;

import com.gooagoo.api.protecteds.core.publish.PublishProtectedCoreService;
import com.gooagoo.common.cache.PublishCache;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;

public class PublishGoodsThread implements Runnable
{

    private List<GoodsBaseInfo> list = null;
    private PublishProtectedCoreService publishProtectedCoreService = null;

    public PublishGoodsThread(List<GoodsBaseInfo> list, PublishProtectedCoreService publishProtectedCoreService)
    {
        this.list = list;
        this.publishProtectedCoreService = publishProtectedCoreService;
    }

    @Override
    public void run()
    {
        for (GoodsBaseInfo item : this.list)
        {
            try
            {
                if (!this.publishProtectedCoreService.generateHtml(item))
                {
                    PublishCache.addFailedGoodsList(item);//记录失败商品编号到缓存中号到缓存中
                }
                PublishCache.addSucceedGoodsList(item);//记录成功商品编号到缓存中号到缓存中
            }
            catch (Exception e)
            {
                PublishCache.addFailedGoodsList(item);//记录失败商品编号到缓存中
            }
        }
    }

}
