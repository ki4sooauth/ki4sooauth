package com.gooagoo.core.business.transaction.order;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.transaction.order.ServeFoodCoreService;
import com.gooagoo.api.generator.core.bill.OrderDetailInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.shop.ShopProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisListDao;

@Service
public class ServeFoodCoreServiceImpl implements ServeFoodCoreService
{

    @Autowired
    private OrderDetailInfoGeneratorCoreService orderDetailInfoGeneratorCoreService;
    @Autowired
    private ShopProtectedCoreService shopProtectedCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean serve(String orderId, String shopEntityId, String tableName, List<Map<String, String>> goodsInfo)
    {
        if (CollectionUtils.isEmpty(goodsInfo))
        {
            return false;
        }
        StringBuffer sb = new StringBuffer();
        for (Map<String, String> map : goodsInfo)
        {
            sb.append(map.get("itemserial") + ",");
            OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
            orderDetailInfoExample.createCriteria().andOrderIdEqualTo(orderId).andItemSerialEqualTo(map.get("itemserial"));
            List<OrderDetailInfo> orderDetailInfoList = this.orderDetailInfoGeneratorCoreService.selectByExample(orderDetailInfoExample);
            if (CollectionUtils.isEmpty(orderDetailInfoList))
            {
                return false;
            }
            OrderDetailInfo orderDetailInfo = orderDetailInfoList.get(0);
            orderDetailInfo.setServeNum(StringUtils.isNotBlank(map.get("goodsnum")) ? Integer.parseInt(map.get("goodsnum")) : 0);
            if (!this.orderDetailInfoGeneratorCoreService.updateByPrimaryKeySelective(orderDetailInfo))
            {
                return false;
            }
        }
        String mac = this.shopProtectedCoreService.getTransponderMac(shopEntityId, tableName);
        if (StringUtils.isBlank(mac))
        {
            GooagooLog.info("MAC地址为空");
            return false;
        }
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_servefood);
        Map<String, String> goodsMap = new HashMap<String, String>();
        goodsMap.put("ctimestamp", TimeUtils.convertDateToString(new Date(), TimeUtils.FORMAT6));
        goodsMap.put("tablename", tableName);
        goodsMap.put("orderid", orderId);
        goodsMap.put("itemseriallis", sb.toString().substring(0, sb.toString().length() - 1));
        String key = mac + "_11";
        redisListDao.put(key, JsonUtils.toJson(goodsMap));
        return true;
    }

    @Override
    public boolean orderDish(String orderId, String shopEntityId, String tableName, String itemSerial, String goodsNum) throws Exception
    {
        String mac = this.shopProtectedCoreService.getTransponderMac(shopEntityId, tableName);
        if (StringUtils.isBlank(mac))
        {
            GooagooLog.info("MAC地址为空");
            return false;
        }
        String key = mac + "_0";//起菜类型为0
        Map<String, String> map = new HashMap<String, String>();
        map.put("ctimestamp", TimeUtils.convertDateToString(new Date(), TimeUtils.FORMAT6));
        map.put("orderid", orderId);
        map.put("shopentityid", shopEntityId);
        map.put("tablename", tableName);
        if (StringUtils.isNotBlank(itemSerial))
        {
            map.put("itemserial", itemSerial);
        }
        if (StringUtils.isNotBlank(goodsNum))
        {
            map.put("goodsnum", goodsNum);
        }
        String json = JsonUtils.toJson(map);
        RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.catering_servefood);
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_servefood);
        redisDatabase.del(key);
        redisListDao.put(key, json);
        return true;
    }

    @Override
    public boolean hurryDish(String orderId, String shopEntityId, String tableName, String itemSerial, String goodsKind) throws Exception
    {
        String mac = this.shopProtectedCoreService.getTransponderMac(shopEntityId, tableName);
        if (StringUtils.isBlank(mac))
        {
            GooagooLog.info("MAC地址为空");
            return false;
        }
        String key = mac + "_1";//催菜类型为1
        Map<String, String> map = new HashMap<String, String>();
        map.put("ctimestamp", TimeUtils.convertDateToString(new Date(), TimeUtils.FORMAT6));
        map.put("shopentityid", shopEntityId);
        map.put("orderid", orderId);
        if (StringUtils.isNotBlank(itemSerial))
        {
            map.put("type", "2");
        }
        else if (StringUtils.isNotBlank(goodsKind))
        {
            map.put("type", "1");
        }
        else
        {
            map.put("type", "0");
        }
        map.put("tablename", tableName);
        map.put("itemserial", itemSerial);
        String json = JsonUtils.toJson(map);
        RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.catering_servefood);
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_servefood);
        redisDatabase.del(key);
        redisListDao.put(key, json);
        return true;
    }

    @Override
    public boolean slowDish(String orderId, String shopEntityId, String tableName, String itemSerial, String goodsNum) throws Exception
    {
        String mac = this.shopProtectedCoreService.getTransponderMac(shopEntityId, tableName);
        if (StringUtils.isBlank(mac))
        {
            GooagooLog.info("MAC地址为空");
            return false;
        }
        String key = mac + "_2";//缓菜类型为2
        Map<String, String> map = new HashMap<String, String>();
        map.put("ctimestamp", TimeUtils.convertDateToString(new Date(), TimeUtils.FORMAT6));
        map.put("orderid", orderId);
        map.put("tablename", tableName);
        map.put("shopentityid", shopEntityId);
        map.put("itemserial", itemSerial);
        map.put("goodsnum", goodsNum);
        if (StringUtils.isNotBlank(itemSerial))
        {
            map.put("itemserial", itemSerial);
        }
        if (StringUtils.isNotBlank(goodsNum))
        {
            map.put("goodsnum", goodsNum);
        }
        String json = JsonUtils.toJson(map);
        RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.catering_servefood);
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_servefood);
        redisDatabase.del(key);
        redisListDao.put(key, json);
        return true;
    }

}
