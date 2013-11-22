package com.gooagoo.api.business.query.transaction.order;

import java.util.List;
import java.util.Map;

/**
 * 上菜管理
 */
public interface ServeFoodQueryService
{

    /**
     * gtsc15:商家查询用户起菜请求
     * @param mac 所属转发器mac地址
     * @param shopEntityId 实体店编号
     * @param ctimestamp 订单编号
     * @return
     * @throws Exception
     */
    public List<Map<String, String>> findOrderDish(String mac, String shopEntityId, String ctimestamp) throws Exception;

    /**
     * gtsc16:商家查询用户催菜请求
     * @param mac 所属转发器mac地址
     * @param shopEntityId 实体店编号
     * @param ctimestamp 订单编号
     * @return
     * @throws Exception
     */
    public List<Map<String, String>> findHurryDish(String mac, String shopEntityId, String ctimestamp) throws Exception;

    /**
     * gtsc17:商家查询用户缓菜请求
     * @param mac 所属转发器mac地址
     * @param shopEntityId 实体店编号
     * @param ctimestamp 订单编号
     * @return
     * @throws Exception
     */
    public List<Map<String, String>> findSlowDish(String mac, String shopEntityId, String ctimestamp) throws Exception;

    /**
     * gtsc27:商家查询勾挑请求
     * @param mac 所属转发器mac地址
     * @param shopEntityId 实体店编号
     * @param ctimestamp 订单编号
     * @return
     * @throws Exception
     */
    public List<Map<String, String>> findServe(String mac, String shopEntityId, String ctimestamp) throws Exception;
}
