package com.gooagoo.api.business.core.shop.cache;

import java.util.List;
import java.util.Map;

/**
 * 从缓存中查询商家餐桌信息
 */
/**
 * @author Administrator
 *
 */
public interface TableCacheCoreService
{

    /**接口gtsc28:平台查询博立协议的房台汇总信息（餐桌状态查询）
     * @param mac 转发器mac地址
     * @param shopEntityId 实体店编号
     * @param tablesinfo 餐桌状态信息[{tableno:””,tablename:””,payment:””, tablestate:””,tabletype:””,tablearea:””},{}...]
     * @return
     * @throws Exception
     */
    public boolean updateTableStatus(String mac, String shopentityid, List<Map<String, String>> tablesinfo) throws Exception;

    /**更新实体店餐桌信息
     * @param shopEntityId 实体店编号
     * @param Map<String, String> tableInfo 餐桌信息
     * @return
     * @throws Exception
     */
    public boolean updateTableInfo(String shopentityid, Map<String, String> tableinfo) throws Exception;

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

    /**
     * 通过餐桌类型查询餐桌信息
     * @param shopEntityId 实体店编号
     * @param tableTypeCode 餐桌类型编码
     * @return
     * @throws Exception
     */
    public List<Map<String, String>> findTableInfoByTableType(String shopEntityId, String tableTypeCode) throws Exception;

    /**
     * 通过餐桌状态查询餐桌信息
     * @param shopEntityId 实体店编号
     * @param tableState 餐桌状态
     * @return
     * @throws Exception
     */
    public List<Map<String, String>> findTableInfoByTable(String shopEntityId, String tableState) throws Exception;

    /**
     * 通过餐桌类型和餐桌状态查询餐桌信息
     * @param shopEntityId 实体店编号
     * @param tableTypeCode 餐桌类型编码
     * @param tableState 餐桌状态
     * @return
     * @throws Exception
     */
    public List<Map<String, String>> findTableInfoByTypeAndState(String shopEntityId, String tableTypeCode, String tableState) throws Exception;

}
