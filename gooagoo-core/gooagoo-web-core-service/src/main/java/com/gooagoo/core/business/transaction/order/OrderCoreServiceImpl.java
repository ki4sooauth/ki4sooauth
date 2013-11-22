package com.gooagoo.core.business.transaction.order;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.transaction.order.OrderCoreService;
import com.gooagoo.api.generator.core.bill.OrderInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.shop.ShopProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisListDao;

@Service
public class OrderCoreServiceImpl implements OrderCoreService
{

    @Autowired
    private OrderInfoGeneratorCoreService orderInfoGeneratorCoreService;

    @Autowired
    private ShopProtectedCoreService shopProtectedCoreService;

    @Override
    public boolean deleteOrder(String orderIds) throws Exception
    {
        //1、校验电子账单编号
        if (StringUtils.isBlank(orderIds))
        {
            GooagooLog.info("删除电子账单：电子账单编号为空");
            return false;
        }
        List<String> orderIdList = Arrays.asList(orderIds.split(","));
        //2、删除电子账单
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setIsDel("Y");
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        orderInfoExample.createCriteria().andOrderIdIn(orderIdList);
        if (!this.orderInfoGeneratorCoreService.updateByExampleSelective(orderInfo, orderInfoExample))
        {
            GooagooLog.error("删除电子账单：删除电子账单（" + orderIds + "）异常", null);
            return false;
        }

        return true;
    }

    @Override
    public boolean confirmWeight(String orderId, String shopEntityId, String tableName, String itemSerial, String weightNum) throws Exception
    {
        String mac = this.shopProtectedCoreService.getTransponderMac(shopEntityId, tableName);
        if (StringUtils.isBlank(mac))
        {
            GooagooLog.info("MAC地址为空");
            return false;
        }
        String key = mac + "_3";//重量确认为3
        Map<String, String> map = new HashMap<String, String>();
        map.put("ctimestamp", TimeUtils.convertDateToString(new Date(), TimeUtils.FORMAT6));
        map.put("orderid", orderId);
        map.put("tablename", tableName);
        if (StringUtils.isNotBlank(itemSerial))
        {
            map.put("itemserial", itemSerial);
        }
        if (StringUtils.isNotBlank(weightNum))
        {
            map.put("weightnum", weightNum);
        }
        String json = JsonUtils.toJson(map);
        RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.catering_servefood);
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_servefood);
        redisDatabase.del(key);
        redisListDao.put(key, json);
        return true;
    }

    @Override
    public boolean changeDiningNumbers(String shopEntityId, String tableName, String peopleNums) throws Exception
    {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setDiningNumbers(Integer.valueOf(peopleNums));
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        orderInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andDeskNameEqualTo(tableName).andBillTypeNotEqualTo("3").andIsDelEqualTo("N");
        if (!this.orderInfoGeneratorCoreService.updateByExampleSelective(orderInfo, orderInfoExample))
        {
            throw new OperateFailException("修改orderInfo中【shopEntityId=" + shopEntityId + " ,tableName=" + tableName + ",peopleNums=" + peopleNums + "】的就餐人数信息失败");
        }
        //用餐人数存入redis中
        String mac = this.shopProtectedCoreService.getTransponderMac(shopEntityId, tableName);
        if (StringUtils.isBlank(mac))
        {
            GooagooLog.info("MAC地址为空");
            throw new NullException("通过实体店编号和桌号获取转发器mac为空[shopentityid=" + shopEntityId + "、tablename=" + tableName + "]");
        }
        String key = mac + "_10";
        Map<String, String> map = new HashMap<String, String>();
        map.put("ctimestamp", TimeUtils.convertDateToString(new Date(), TimeUtils.FORMAT6));
        map.put("tablename", tableName);
        map.put("updateheaderid", UUID.getUUID());
        map.put("guestsnumber", peopleNums);
        String json = JsonUtils.toJson(map);
        RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.catering_servefood);
        redisDatabase.del(key);
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_servefood);
        redisListDao.put(key, json);
        return true;
    }

    @Override
    public boolean PlfNsynOrderPay(String orderId) throws Exception
    {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(orderId);
        orderInfo.setBillType("3");
        orderInfo.setPaymentTime(new Date());
        if (!this.orderInfoGeneratorCoreService.updateByPrimaryKeySelective(orderInfo))
        {
            throw new OperateFailException("订单不存在或者修改订单状态机支付时间失败【orderid=" + orderId + "】");
        }
        return true;
    }
}
