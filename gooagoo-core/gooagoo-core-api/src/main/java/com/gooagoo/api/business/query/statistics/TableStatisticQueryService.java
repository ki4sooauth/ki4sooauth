package com.gooagoo.api.business.query.statistics;

public interface TableStatisticQueryService
{
    /**
     * 查询实体店餐桌上座率
     * @param shopEntityId
     * @return
     * @throws Exception
     */
    public String findTableAttendance(String shopEntityId) throws Exception;

}
