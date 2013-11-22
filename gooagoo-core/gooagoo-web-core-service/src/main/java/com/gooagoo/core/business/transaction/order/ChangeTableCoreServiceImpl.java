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

import com.gooagoo.api.business.core.shop.cache.TableCacheCoreService;
import com.gooagoo.api.business.core.transaction.order.ChangeTableCoreService;
import com.gooagoo.api.generator.core.bill.BillAddInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OrderCouponInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OrderDetailInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OrderInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.ShopOrderInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.UserOrderInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopTableInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.shop.ShopProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.generator.bill.BillAddInfo;
import com.gooagoo.entity.generator.bill.BillAddInfoExample;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderCouponInfoExample;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.bill.ShopOrderInfo;
import com.gooagoo.entity.generator.bill.ShopOrderInfoExample;
import com.gooagoo.entity.generator.bill.UserOrderInfo;
import com.gooagoo.entity.generator.bill.UserOrderInfoExample;
import com.gooagoo.entity.generator.shop.ShopTableInfo;
import com.gooagoo.entity.generator.shop.ShopTableInfoExample;
import com.gooagoo.exception.business.shop.TableStateNotFreeException;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisListDao;

@Service
public class ChangeTableCoreServiceImpl implements ChangeTableCoreService
{

    @Autowired
    private ShopProtectedCoreService shopProtectedCoreService;
    @Autowired
    private OrderInfoGeneratorCoreService orderInfoGeneratorCoreService;
    @Autowired
    private ShopTableInfoGeneratorCoreService shopTableInfoGeneratorCoreService;
    @Autowired
    private OrderDetailInfoGeneratorCoreService orderDetailInfoGeneratorCoreService;
    @Autowired
    private BillAddInfoGeneratorCoreService billAddInfoGeneratorCoreService;
    @Autowired
    private OrderCouponInfoGeneratorCoreService orderCouponInfoGeneratorCoreService;
    @Autowired
    private TableCacheCoreService tableCacheCoreService;
    @Autowired
    private UserOrderInfoGeneratorCoreService userOrderInfoGeneratorCoreService;
    @Autowired
    private ShopOrderInfoGeneratorCoreService shopOrderInfoGeneratorCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean exchangeTable(String shopEntityId, String tableNameFrom, String tableNameTo) throws Exception
    {
        //换台时，换到的餐桌已占用，不允许换台
        Map<String, String> tableCache = this.tableCacheCoreService.findTableInfoByTableName(shopEntityId, tableNameTo);
        if (tableCache == null || tableCache.size() == 0)
        {
            GooagooLog.warn("redis缓存中该餐桌状态信息为空[shopEntityId=" + shopEntityId + "、tableNameTo=" + tableNameTo + "]");
            return false;
        }
        if (!"空闲".equals(tableCache.get("tablestate")))
        {
            throw new TableStateNotFreeException("换到的餐桌已占用，不允许换台[shopEntityId=" + shopEntityId + "、tableName=" + tableNameTo + "、tableState=" + tableCache.get("tablestate") + "]");
        }
        String mac = this.shopProtectedCoreService.getTransponderMac(shopEntityId, tableNameFrom);
        if (StringUtils.isBlank(mac))
        {
            GooagooLog.info("MAC地址为空");
            return false;
        }
        //换台-更新订单相关信息
        if (!this.exchangeCorrelationInfo(shopEntityId, tableNameFrom, tableNameTo))
        {
            return false;
        }
        //并台将redis中的换台桌子状态改为1-空闲、换到桌子状态改为2-已点餐
        this.updateTableStatus4Redis(shopEntityId, tableNameFrom, tableNameTo);
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_servefood);
        String key = mac + "_5";//换台类型为5
        Map<String, String> map = new HashMap<String, String>();
        map.put("oldtablename", tableNameFrom);
        map.put("newtablename", tableNameTo);
        map.put("ctimestamp", TimeUtils.convertDateToString(new Date(), TimeUtils.FORMAT6));
        String json = JsonUtils.toJson(map);
        redisListDao.put(key, json);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean mergeTable(String shopEntityId, String tableNameFrom, String tableNameTo) throws Exception
    {
        String mac = this.shopProtectedCoreService.getTransponderMac(shopEntityId, tableNameFrom);
        if (StringUtils.isBlank(mac))
        {
            GooagooLog.info("MAC地址为空");
            return false;
        }
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_servefood);
        String key = mac + "_6";//并台类型为6
        Map<String, String> map = new HashMap<String, String>();
        map.put("tablename", tableNameTo);//目标餐桌桌号 
        map.put("othertablename", tableNameFrom);//被合并餐桌桌号
        map.put("ctimestamp", TimeUtils.convertDateToString(new Date(), TimeUtils.FORMAT6));
        String json = JsonUtils.toJson(map);
        redisListDao.put(key, json);
        //合并-更新订单相关信息
        if (!this.mergeCorrelationInfo(shopEntityId, tableNameFrom, tableNameTo))
        {
            return false;
        }
        //并台将redis中的并台桌子状态改为1-空闲
        this.updateTableStatus4Redis(shopEntityId, tableNameFrom, tableNameTo);
        return true;
    }

    /**
     * 换台相关数据更新
     * @param shopEntityId
     * @param tableNameTo
     * @param tableNameFrom
     * @return
     * @throws Exception 
     */
    private boolean exchangeCorrelationInfo(String shopEntityId, String tableNameFrom, String tableNameTo) throws Exception
    {
        ShopTableInfoExample shopTableInfoExample = new ShopTableInfoExample();
        shopTableInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andTableNameEqualTo(tableNameTo).andIsDelEqualTo("N");
        List<ShopTableInfo> shopTableInfoList = this.shopTableInfoGeneratorCoreService.selectByExample(shopTableInfoExample);
        if (CollectionUtils.isEmpty(shopTableInfoList))
        {
            GooagooLog.warn("餐桌不存在[shopEntityId=" + shopEntityId + "、tableName=" + tableNameTo + "]");
            return false;
        }
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        orderInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andDeskNameEqualTo(tableNameFrom).andIsDelEqualTo("N");
        List<OrderInfo> orderInfoList = this.orderInfoGeneratorCoreService.selectByExample(orderInfoExample);
        if (CollectionUtils.isEmpty(orderInfoList))
        {
            //当没订单时更改餐桌状态
            Map<String, String> tableFromMap = this.tableCacheCoreService.findTableInfoByTableName(shopEntityId, tableNameFrom);
            Map<String, String> tableToMap = this.tableCacheCoreService.findTableInfoByTableName(shopEntityId, tableNameTo);
            if (tableFromMap == null)
            {
                GooagooLog.warn("该实体店餐桌不存在[shopEntityId=" + shopEntityId + "、tableNameFrom=" + tableNameFrom + "]");
                return false;
            }
            if (tableToMap == null)
            {
                GooagooLog.warn("该实体店餐桌不存在[shopEntityId=" + shopEntityId + "、tableNameTo=" + tableNameTo + "]");
                return false;
            }
            tableFromMap.put("tablestate", "1");//换台餐桌状态改为空闲
            tableToMap.put("tablestate", "0");//换到餐桌状态改为开台
            if (!this.tableCacheCoreService.updateTableInfo(shopEntityId, tableFromMap))
            {
                return false;
            }
            if (!this.tableCacheCoreService.updateTableInfo(shopEntityId, tableToMap))
            {
                return false;
            }
            return true;
        }
        else
        {
            OrderInfo orderInfo = orderInfoList.get(0);
            orderInfo.setDeskName(tableNameTo);
            orderInfo.setRoomName(shopTableInfoList.get(0).getRoomName());
            if (!this.orderInfoGeneratorCoreService.updateByPrimaryKeySelective(orderInfo))
            {
                GooagooLog.error("换台操作:更改订单桌号失败[shopEntityId=" + shopEntityId + "、tableNameFrom=" + tableNameFrom + "、tableNameTo=" + tableNameTo + "]", null);
                return false;
            }
        }
        ShopTableInfo shopTableInfo = new ShopTableInfo();
        shopTableInfo.setStatus("1");
        this.shopTableInfoGeneratorCoreService.updateByExampleSelective(shopTableInfo, shopTableInfoExample);
        shopTableInfo = new ShopTableInfo();
        shopTableInfo.setStatus("2");
        shopTableInfoExample = new ShopTableInfoExample();
        shopTableInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andTableNameEqualTo(tableNameTo).andIsDelEqualTo("N");
        this.shopTableInfoGeneratorCoreService.updateByExampleSelective(shopTableInfo, shopTableInfoExample);
        return true;
    }

    /**
     * 并台相关数据更新
     * @param shopEntityId
     * @param tableNameFrom
     * @param tableNameTo
     * @return
     */
    private boolean mergeCorrelationInfo(String shopEntityId, String tableNameFrom, String tableNameTo)
    {
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        orderInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andDeskNameEqualTo(tableNameFrom).andBillTypeNotEqualTo("3").andIsDelEqualTo("N");
        List<OrderInfo> oldOrderInfoList = this.orderInfoGeneratorCoreService.selectByExample(orderInfoExample);
        if (CollectionUtils.isEmpty(oldOrderInfoList))
        {
            GooagooLog.info("并台操作:查询被并台订单信息失败[shopEntityId=" + shopEntityId + "、tableNameFrom=" + tableNameFrom + "]");
            return false;
        }
        orderInfoExample = new OrderInfoExample();
        orderInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andDeskNameEqualTo(tableNameTo).andBillTypeNotEqualTo("3").andIsDelEqualTo("N");
        List<OrderInfo> newOrderInfoList = this.orderInfoGeneratorCoreService.selectByExample(orderInfoExample);
        if (CollectionUtils.isEmpty(newOrderInfoList))
        {
            GooagooLog.info("并台操作:查询并台订单信息失败[shopEntityId=" + shopEntityId + "、tableNameTo=" + tableNameTo + "]");
            return false;
        }
        OrderInfo oldOrderInfo = oldOrderInfoList.get(0);
        OrderInfo newOrderInfo = newOrderInfoList.get(0);
        if (oldOrderInfo.getGoodsTotalNum() == null)
        {
            oldOrderInfo.setGoodsTotalNum(0);
        }
        if (newOrderInfo.getGoodsTotalNum() == null)
        {
            newOrderInfo.setGoodsTotalNum(0);
        }
        newOrderInfo.setGoodsTotalNum(newOrderInfo.getGoodsTotalNum() + oldOrderInfo.getGoodsTotalNum());//合并商品总数
        if (oldOrderInfo.getDiningNumbers() == null)
        {
            oldOrderInfo.setDiningNumbers(0);
        }
        if (newOrderInfo.getDiningNumbers() == null)
        {
            newOrderInfo.setDiningNumbers(0);
        }
        newOrderInfo.setDiningNumbers(newOrderInfo.getDiningNumbers() + oldOrderInfo.getDiningNumbers());//合并就餐人数
        if (oldOrderInfo.getOriginalPrice() == null)
        {
            oldOrderInfo.setOriginalPrice(0.00);
        }
        if (newOrderInfo.getOriginalPrice() == null)
        {
            newOrderInfo.setOriginalPrice(0.00);
        }
        newOrderInfo.setOriginalPrice(oldOrderInfo.getOriginalPrice() + newOrderInfo.getOriginalPrice());//合并原价格
        if (oldOrderInfo.getPayPrice() == null)
        {
            oldOrderInfo.setPayPrice(0.00);
        }
        if (newOrderInfo.getPayPrice() == null)
        {
            newOrderInfo.setPayPrice(0.00);
        }
        newOrderInfo.setPayPrice(oldOrderInfo.getPayPrice() + newOrderInfo.getPayPrice());//合并实际支付价格
        oldOrderInfo.setIsDel("Y");
        if (!this.orderInfoGeneratorCoreService.updateByPrimaryKeySelective(oldOrderInfo))
        {
            GooagooLog.info("并台操作:删除被合并订单信息失败[orderId=" + oldOrderInfo.getOrderId() + "]");
            return false;
        }
        if (!this.orderInfoGeneratorCoreService.updateByPrimaryKeySelective(newOrderInfo))
        {
            GooagooLog.info("并台操作:更新合并订单信息失败[orderId=" + newOrderInfo.getOrderId() + "]");
            return false;
        }
        //修改订单商品详细信息订单编号
        OrderDetailInfo orderDetailInfo = new OrderDetailInfo();
        orderDetailInfo.setOrderId(newOrderInfo.getOrderId());
        OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
        orderDetailInfoExample.createCriteria().andOrderIdEqualTo(oldOrderInfo.getOrderId());
        this.orderDetailInfoGeneratorCoreService.updateByExampleSelective(orderDetailInfo, orderDetailInfoExample);
        //修改用户提交的加菜减菜申请信息订单编号
        BillAddInfo billAddInfo = new BillAddInfo();
        billAddInfo.setOrderId(newOrderInfo.getOrderId());
        BillAddInfoExample billAddInfoExample = new BillAddInfoExample();
        billAddInfoExample.createCriteria().andOrderIdEqualTo(oldOrderInfo.getOrderId()).andIsDelEqualTo("N");
        this.billAddInfoGeneratorCoreService.updateByExampleSelective(billAddInfo, billAddInfoExample);
        //修改订单优惠凭证详情订单编号
        OrderCouponInfo orderCouponInfo = new OrderCouponInfo();
        orderCouponInfo.setOrderId(newOrderInfo.getOrderId());
        OrderCouponInfoExample orderCouponInfoExample = new OrderCouponInfoExample();
        orderCouponInfoExample.createCriteria().andOrderIdEqualTo(oldOrderInfo.getOrderId()).andIsDelEqualTo("N");
        this.orderCouponInfoGeneratorCoreService.updateByExampleSelective(orderCouponInfo, orderCouponInfoExample);
        //更新用户订单原始信息中的统一订单编号
        UserOrderInfo userOrderInfo = new UserOrderInfo();
        userOrderInfo.setOrderId(newOrderInfo.getOrderId());
        UserOrderInfoExample userOrderInfoExample = new UserOrderInfoExample();
        userOrderInfoExample.createCriteria().andOrderIdEqualTo(oldOrderInfo.getOrderId());
        this.userOrderInfoGeneratorCoreService.updateByExampleSelective(userOrderInfo, userOrderInfoExample);
        //更新商家订单原始信息中的统一订单编号
        ShopOrderInfo shopOrderInfo = new ShopOrderInfo();
        shopOrderInfo.setOrderId(newOrderInfo.getOrderId());
        ShopOrderInfoExample shopOrderInfoExample = new ShopOrderInfoExample();
        shopOrderInfoExample.createCriteria().andOrderIdEqualTo(oldOrderInfo.getOrderId());
        this.shopOrderInfoGeneratorCoreService.updateByExampleSelective(shopOrderInfo, shopOrderInfoExample);
        return true;
    }

    /**
     * 
     * @param list
     * @param tablestatus 餐桌状态 1-空闲、2-已点餐
     */
    /**
     * //更新redis中的餐桌状态
     * @param shopEntityId
     * @param tableNameFrom 时:餐桌状态 1-空闲
     * @param tableNameTo 时:餐桌状态 2-已点餐
     */
    private void updateTableStatus4Redis(String shopEntityId, String tableNameFrom, String tableNameTo)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        RedisListDao listDao = new RedisListDao(RedisServerConstants.catering_table);
        List<String> list = listDao.get(shopEntityId);
        if (CollectionUtils.isNotEmpty(list))
        {
            for (int i = 0; i < list.size(); i++)
            {
                if (flag1 && flag2)
                {
                    break;
                }
                Map<String, String> tableMap = JsonUtils.json2Map(list.get(i));
                if (tableNameFrom.equals(tableMap.get("tablename")))
                {
                    tableMap.put("tablestate", "空闲");
                    list.set(i, JsonUtils.toJson(tableMap));
                    flag1 = true;
                }
                else if (tableNameTo.equals(tableMap.get("tablename")))
                {
                    tableMap.put("tablestate", "已点餐");
                    list.set(i, JsonUtils.toJson(tableMap));
                    flag2 = true;
                }
            }
        }
        if (flag1 && flag2)
        {
            RedisDatabase baseDao = new RedisDatabase(RedisServerConstants.catering_table);
            baseDao.del(shopEntityId);
            listDao.set(shopEntityId, list);
        }
    }
}
