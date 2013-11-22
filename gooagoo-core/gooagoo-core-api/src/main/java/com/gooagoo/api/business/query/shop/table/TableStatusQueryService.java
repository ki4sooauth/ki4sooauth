package com.gooagoo.api.business.query.shop.table;

import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.shop.table.TableDiningStatus;
import com.gooagoo.entity.business.shop.table.TableStatus;
import com.gooagoo.entity.business.shop.table.TableStatusByType;
import com.gooagoo.entity.business.shop.table.TableTypeStatus;

public interface TableStatusQueryService
{
    /**
     * 查询实体店各类型餐桌状态
     * gasj01、gasj06、mobe12
     * @param tableTypeCode 餐桌类型
     * @param shopEntityId
     * @param pageIndex
     * @param pageSize
     * @throws Exception
     */
    public List<TableTypeStatus> findTableTypeStatus(String tableTypeCode, String shopEntityId, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * gasj03按餐桌类型查询实体店餐桌状态
     * 当tableName不为空时，按tableName查询
     * 当tableName为空是，TableTypeCode不为空，按TableTypeCode查询
     * 当tableName和tableTypeCode都为空时，查询所有类型的餐桌状态
     * @param shopEntityId 实体店编号
     * @param TableTypeCode 餐桌类型 null时查所有类型的餐桌
     * @param tableName 餐桌号 null时查所有
     * @param pageIndex 页码
     * @param pageSize  每页信息显示条数
     * @throws Exception
     */
    public List<TableStatusByType> findTableStatusByType(String shopEntityId, String tableTypeCode, String tableName, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 查询实体店餐桌状态
     * gtsc09
     * @param shopEntityId
     * @throws Exception
     */
    public List<TableStatus> findTableStatus(String shopEntityId, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 查询正在用餐餐桌的状态（人员，用餐情况等）
     * gasl02
     * @param shopEntityId
     * @param tableName
     * @throws Exception
     */
    public List<TableDiningStatus> findTableDiningStatus(String shopEntityId, String tableName, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 查询开台请求
     * @param mac
     * @param shopEntityId
     * @param ctimestamp
     * @throws Exception
     */
    public List<Map<String, String>> findOpenTable(String mac, String shopEntityId, String ctimestamp) throws Exception;

    /**
     * 查询清台请求
     * @param mac
     * @param shopEntityId
     * @param ctimestamp
     * @throws Exception
     */
    public List<Map<String, String>> findClearTable(String mac, String shopEntityId, String ctimestamp) throws Exception;

}
