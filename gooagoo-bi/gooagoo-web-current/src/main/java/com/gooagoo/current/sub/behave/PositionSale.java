package com.gooagoo.current.sub.behave;

import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.bi.entity.bill.Bill;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.redis.data.RedisSortedSetDao;

/**
 * 区域销量排行
 * @author 王宇
 *
 */
@Message(DispatcherConstants.bill)
public class PositionSale implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 PositionSale");
        Bill bill = (Bill) message;
        String goodsId;
        String positionId;
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_positionSale);
        for (OrderDetailInfo detail : bill.getOrderDetailInfos())
        {
            goodsId = detail.getGoodsId();
            GoodsMarketingInfo goodsMarketingInfo = this.goodsInfo(goodsId);
            positionId = goodsMarketingInfo.getPositionId();
            sortedSetDao.edit(positionId, 1, goodsId);
        }
    }

    private GoodsMarketingInfo goodsInfo(String goodsId)
    {
        GoodsMarketingInfoGeneratorQueryService queryService = SpringBeanUtils.getBean(GoodsMarketingInfoGeneratorQueryService.class);
        return queryService.selectByPrimaryKey(goodsId);
    }
}
