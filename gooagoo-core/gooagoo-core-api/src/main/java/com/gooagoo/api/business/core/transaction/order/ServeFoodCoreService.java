package com.gooagoo.api.business.core.transaction.order;

import java.util.List;
import java.util.Map;

/**
 * 上菜管理
 * @author Administrator
 *
 */
public interface ServeFoodCoreService
{
    /**
     * 店员标记订单已上情况
     * @param orderId
     * @param shopEntityId
     * @param tableName
     * @param goodsInfo {[itemserial:"",serveNum:""]}
     * @return
     */
    public boolean serve(String orderId, String shopEntityId, String tableName, List<Map<String, String>> goodsInfo);

    /**
     * 店员帮助用户起菜
     * @param orderId 订单编号
     * @param shopEntityId 实体店
     * @param tableName 桌号
     * @param itemSerial 自定义序列号
     * @param goodsNum 订单编号
     * @return
     * @throws Exception
     */
    public boolean orderDish(String orderId, String shopEntityId, String tableName, String itemSerial, String goodsNum) throws Exception;

    /**
     * 店员帮助用户催菜
     * @param orderId 订单编号
     * @param shopEntityId 实体店
     * @param tableName 桌号
     * @param itemSerial 自定义序列号
     * @param goodsKind 菜品类别
     * @return
     * @throws Exception
     */
    public boolean hurryDish(String orderId, String shopEntityId, String tableName, String itemSerial, String goodsKind) throws Exception;

    /**
     * 店员帮助用户缓菜
     * @param orderId 订单编号
     * @param shopEntityId 实体店
     * @param tableName 桌号
     * @param itemSerial 自定义序列号
     * @param goodsNum 订单编号
     * @return
     * @throws Exception
     */
    public boolean slowDish(String orderId, String shopEntityId, String tableName, String itemSerial, String goodsNum) throws Exception;

}
