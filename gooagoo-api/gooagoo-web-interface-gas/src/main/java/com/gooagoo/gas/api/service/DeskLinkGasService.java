package com.gooagoo.gas.api.service;

import com.gooagoo.gas.entity.gasj01.transform.DeskStatusRoot;
import com.gooagoo.gas.entity.gasj02.transform.QueueRoot;
import com.gooagoo.gas.entity.gasj03.transform.DeskStatusDetailRoot;
import com.gooagoo.gas.entity.gasj04.transform.GetMenuByDeskNoRoot;
import com.gooagoo.gas.entity.gasj06.transform.DeskQueueTrackRoot;

public interface DeskLinkGasService
{
    /**
     * 接口gasj01:店员查询本实体店各类型餐桌状态
     * @param shopentityid 实体店编号
     * @return
     * @throws Exception
     */
    public DeskStatusRoot queryDeskStatus(String shopentityid) throws Exception;

    /**
     * 接口gasj02:店员帮用户排号
     * @param shopId 商家编号
     * @param shopentityid 实体店编号
     * @param scardno 会员卡号
     * @param tableTypeCode 餐桌类型
     * @param queueNums 此次排号对应人数
     * @return
     * @throws Exception
     */
    public QueueRoot userQueue(String shopId, String shopentityid, String scardno, String tableTypeCode, String queueNums) throws Exception;

    /**
     * 接口gasj03:店员按本实体店的餐桌类型查询餐桌状态详情
     * @param shopentityid 实体店编号
     * @param tableTypeCode 餐桌类型
     * @param tableName 餐桌号
     * @param pageIndex 页码
     * @param pageSize  每页显示信息条数
     * @return
     * @throws Exception
     */
    public DeskStatusDetailRoot queryDeskStatusDetails(String shopentityid, String tableTypeCode, String tableName, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口gasj04:店员扫桌号获取用户点菜单信息
     * @param shopentityid 实体店编号
     * @param tableName 餐桌号
     * @param pageIndex 页码
     * @param pageSize  每页显示信息条数
     * @return
     * @throws Exception
     */
    public GetMenuByDeskNoRoot queryMenuByDeskNo(String shopentityid, String tableName, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口gasj05:店员现场销号
     * @param shopEntityId 实体店编号
     * @param queueno 排队号码
     * @return
     * @throws Exception
     */
    public boolean queueCancel(String shopEntityId, String queueno) throws Exception;

    /**
     * 接口gasj06:店员查询各类型餐桌排号信息
     * @param shopEntityId 实体店编号
     * @param tableTypeCode 餐桌类型编码
     * @return
     * @throws Exception
     */
    public DeskQueueTrackRoot queryDeskQueueTracks(String shopEntityId, String tableTypeCode) throws Exception;

    /**
     * 接口gasj07:餐桌开台管理
     * @param shopEntityId 实体店编号
     * @param tableName 桌号
     * @param peopleNums 就餐人数
     * @return
     * @throws Exception
     */
    public boolean openTableManage(String shopEntityId, String tableName, String peopleNums) throws Exception;

    /**
     * 接口gasj08:餐桌清台管理
     * @param shopEntityId 实体店编号
     * @param tableName 桌号
     * @return
     * @throws Exception
     */
    public boolean clearTableManage(String shopEntityId, String tableName) throws Exception;

    /**
     * 接口gasj09:餐桌并台管理
     * @param shopEntityId 实体店编号
     * @param tableNameTo （换到 、并到）桌号
     * @param tableNameFrom （换台 、并台）桌号
     * @return
     * @throws Exception
     */
    public boolean mergeTableManage(String shopEntityId, String tableNameTo, String tableNameFrom) throws Exception;

    /**
     * 接口gasj10:餐桌换台管
     * @param shopEntityId 实体店编号
     * @param tableNameTo （换到 、并到）桌号
     * @param tableNameFrom （换台 、并台）桌号
     * @return
     * @throws Exception
     */
    public boolean exchangeTableManage(String shopEntityId, String tableNameTo, String tableNameFrom) throws Exception;

}
