package com.gooagoo.gstatus.service;

import java.util.List;

import com.gooagoo.view.gms.crm.FhighChartVo;

public interface UserStatusService
{

    public FhighChartVo memberStatus(String statisticType, String tableName, String shopId, String serName);

    public List<Long[]> memberHistory(String statisticType, String shopId);

    public FhighChartVo unMemberStatus(String statisticType, String tableName, String shopId, String serName);

    public List<Long[]> unMemberHistory(String statisticType, String shopId);

    public void save(String tokon, String time, String name, String desc);
}
