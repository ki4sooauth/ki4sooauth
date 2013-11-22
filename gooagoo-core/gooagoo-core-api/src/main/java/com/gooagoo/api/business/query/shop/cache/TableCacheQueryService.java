package com.gooagoo.api.business.query.shop.cache;

import java.util.List;
import java.util.Map;

/**
 * 从缓存中查询商家餐桌信息
 */
/**
 * @author Administrator
 *
 */
public interface TableCacheQueryService
{
    /**查询餐桌信息
     * @param shopEntityId 实体店编号
     * @return
     * @throws Exception
     */
    public List<Map<String, String>> findTableInfo(String shopEntityId) throws Exception;

    /**通过餐桌名称查询餐桌信息
     * @param shopEntityId 实体店编号
     * @param tableName 餐桌名称
     * @return
     * @throws Exception
     */
    public Map<String, String> findTableInfoByTableName(String shopEntityId, String tableName) throws Exception;

    /**通过餐桌类型查询餐桌信息
     * @param shopEntityId 实体店编号
     * @param tableTypeCode 餐桌类型编码
     * @return
     * @throws Exception
     */
    public List<Map<String, String>> findTableInfoByTableType(String shopEntityId, String tableTypeCode) throws Exception;

    /**通过餐桌状态查询餐桌信息
     * @param shopEntityId 实体店编号
     * @param tableStateName 餐桌状态名称
     * @return
     * @throws Exception
     */
    public List<Map<String, String>> findTableInfoByTable(String shopEntityId, String tableStateName) throws Exception;

    /**通过餐桌类型和餐桌状态查询餐桌信息
     * @param shopEntityId 实体店编号
     * @param tableTypeCode 餐桌类型编码
     * @param tableStateName 餐桌状态名称
     * @return
     * @throws Exception
     */
    public List<Map<String, String>> findTableInfoByTypeAndState(String shopEntityId, String tableTypeCode, String tableStateName) throws Exception;
}
