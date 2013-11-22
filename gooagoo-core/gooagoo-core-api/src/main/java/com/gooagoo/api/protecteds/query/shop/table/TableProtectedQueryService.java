package com.gooagoo.api.protecteds.query.shop.table;

public interface TableProtectedQueryService
{

    /**
     * 查询某实体店当前类型餐桌数
     * @param shopEntityId 实体店编号
     * @param tableTypeCode 餐桌类型编码
     * @return 当前类型餐桌数
     */
    public String getTableTypeSum(String shopEntityId, String tableTypeCode);

    /**
     * 查询某实体店空闲数
     * @param shopEntityId 实体店编号
     * @param deskStatus 餐桌状态[1:空闲、2:已点餐、3:正在结账]
     * @return vacancynum空闲数、usenum正在用餐数量、checkoutnum正在结账数
     */
    public String getCountByDeskStatus(String shopEntityId, String deskStatus);

}
