package com.gooagoo.query.business.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.UserPositionStatisticQueryService;
import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.shop.ShopPositionExample;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Service
public class UserPositionStatisticQueryServiceImpl implements UserPositionStatisticQueryService
{
    @Autowired
    private ShopPositionGeneratorQueryService shopPositionGeneratorQueryService;

    @Override
    public Map<String, String> findUserPositionInfo(String mac) throws Exception
    {
        Map<String, String> result = new HashMap<String, String>();
        RedisSortedSetDao userPosition = new RedisSortedSetDao(RedisServerConstants.statistics_user_position);
        Set<String> position = userPosition.get(mac, 0, -1);
        if (CollectionUtils.isNotEmpty(position))
        {
            List<String> positionList = new ArrayList<String>();
            positionList.addAll(position);
            ShopPositionExample shopPositionExample = new ShopPositionExample();
            shopPositionExample.createCriteria().andPositionIdIn(positionList);
            shopPositionExample.setOrderByClause("position_id asc");
            List<ShopPosition> shopPositionList = this.shopPositionGeneratorQueryService.selectByExample(shopPositionExample);
            if (CollectionUtils.isNotEmpty(shopPositionList))
            {
                result.put("positionId", shopPositionList.get(0).getPositionId());
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        RedisSortedSetDao userPosition = new RedisSortedSetDao(RedisServerConstants.statistics_user_position);
        userPosition.delElement("3c:07:54:10:8b:4a", "018231R3CGJ9QUV02VLL2CEIISWR2TKG");
        userPosition.put("3c:07:54:10:8b:4a", 1.00, "018231S8B6FQB9102VLL2EEIISWR2TKG");
        System.out.println(userPosition.get("3c:07:54:10:8b:4a", 0, -1));

    }
}
