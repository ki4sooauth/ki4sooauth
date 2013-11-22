package com.gooagoo.trans.api;

import com.gooagoo.trans.entity.gtsc19.transform.OpenTableRoot;
import com.gooagoo.trans.entity.gtsc20.transform.ExchangeTableRoot;
import com.gooagoo.trans.entity.gtsc21.transform.MergerTableRoot;
import com.gooagoo.trans.entity.gtsc22.transform.CancelTableRoot;
import com.gooagoo.trans.entity.gtsc23.transform.UpdatePeopleNumsRoot;
import com.gooagoo.trans.entity.gtsc24.transform.BackDishRoot;

/**
 * 桌台管理
 */
public interface TableManagerTransService
{
    /**
     * 接口gtsc19:查询开台请求
     * @param mac 转发器mac地址
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public OpenTableRoot getopenTableInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception;

    /**
     * 接口gtsc20:商家查询换台请求
     * @param mac 转发器mac地址
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public ExchangeTableRoot getExchangeTableInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception;

    /**
     * 接口gtsc21:商家查询并台请求
     * @param mac 转发器mac地址
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public MergerTableRoot getMergerTableInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception;

    /**
     * 接口gtsc22:商家查询撤台请求
     * @param mac 转发器mac地址
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public CancelTableRoot getCancelTableInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception;

    /**
     * 接口gtsc23:商家查询修改台头（餐桌就餐信息）请求
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public UpdatePeopleNumsRoot getUpdatePeopleNumsInfo(String mac, String shopEntityId, String cTimeStamp) throws Exception;

    /**
     * 接口gtsc24:商家查询退菜请求
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public BackDishRoot getbackDishInfo(String shopEntityId, String cTimeStamp) throws Exception;

    /**
     * 接口gtsc25:平台查询博立协议的账单明细
     * @param mac 转发器mac地址
     * @param shopEntityId 实体店编号
     * @param dataDetail 账单明细信息
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public boolean getbillDetailInfo(String mac, String shopEntityId, String dataDetail, String cTimeStamp) throws Exception;

    /**
     * 接口gtsc28:平台查询博立协议的房台汇总信息（餐桌状态查询）
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @param tablesInfo 餐桌状态信息
     * @return
     * @throws Exception
     */
    public boolean saveTableState(String mac, String shopEntityId, String cTimeStamp, String tablesInfo) throws Exception;

}
