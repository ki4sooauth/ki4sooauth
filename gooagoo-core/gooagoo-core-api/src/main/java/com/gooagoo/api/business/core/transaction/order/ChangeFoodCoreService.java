package com.gooagoo.api.business.core.transaction.order;

import java.util.List;

import com.gooagoo.entity.generator.bill.BillAddInfo;

/***
 * 加菜减菜
 * @author Administrator
 *
 */
public interface ChangeFoodCoreService
{
    /***
     * 申请加菜
     * @param List<BillAddInfo>
     * @return true/false
     * @throws Exception
     */
    public boolean applyAddFood(String tableName, List<BillAddInfo> billAddInfoList) throws Exception;

    /***
     * 申请退菜
     * @param List<BillAddInfo>
     * @return true/false
     * @throws Exception
     */
    public boolean applyMinusFood(String tableName, List<BillAddInfo> billAddInfoList) throws Exception;

}
