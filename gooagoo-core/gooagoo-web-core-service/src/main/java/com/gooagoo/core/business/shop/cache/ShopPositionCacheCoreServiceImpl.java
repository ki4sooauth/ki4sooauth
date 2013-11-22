package com.gooagoo.core.business.shop.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.shop.cache.ShopPositionCacheCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.shop.ShopPositionMapper;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.shop.ShopPositionKey;
import com.gooagoo.redis.data.RedisHashDao;

@Service
public class ShopPositionCacheCoreServiceImpl implements ShopPositionCacheCoreService
{

    @Autowired
    ShopPositionMapper shopPositionMapper;

    @Override
    public Map<String, String> findPosition(String positionId) throws Exception
    {
        RedisHashDao hashDao = new RedisHashDao(RedisServerConstants.business_position);
        Map<String, String> result = hashDao.get(positionId);
        if (result == null || result.size() == 0)
        {
            ShopPositionKey key = new ShopPositionKey();
            key.setPositionId(positionId);
            ShopPosition position = this.shopPositionMapper.selectByPrimaryKey(key);
            if (position != null)
            {
                result = new HashMap<String, String>();
                result.put("positionName", position.getPositionName());//位置名称
                result.put("shopId", position.getShopId());//商家编号
                result.put("shopEntityId", position.getShopEntityId());//实体店编号
                result.put("parentPositionId", position.getParentPositionId());//父位置编号
                result.put("description", position.getDescription());//位置描述
                result.put("lesseeShopId", position.getLesseeShopId());//承租商家编号
                hashDao.set(positionId, result);
            }
        }
        return result;
    }

}
