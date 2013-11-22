package com.gooagoo.api.business.core.statistics;

public interface TableStatisticCoreService
{
    /**
     * 查询实体店餐桌上座率
     * @param shopEntityId
     * @return
     * @throws Exception
     */
    public String findTableAttendance(String shopEntityId) throws Exception;

}
