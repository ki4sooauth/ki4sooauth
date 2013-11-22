package com.gooagoo.entity.business.user.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gooagoo.entity.business.user.account.action.ActionRecord;
import com.gooagoo.entity.business.user.account.consume.ConsumeRecord;
import com.gooagoo.entity.business.user.account.integral.IntegralRecord;
import com.gooagoo.entity.business.user.account.property.PropertyRecord;

/**
 * 用户账号详细信息表
 */
public class UserAccountDetail implements Serializable
{

    private static final long serialVersionUID = 1L;

    private PropertyRecord propertyRecord;//账号属性信息
    private List<ActionRecord> actionRecordList = new ArrayList<ActionRecord>();//账号历史行为信息
    private List<ConsumeRecord> consumeRecordList = new ArrayList<ConsumeRecord>();//账号历史消费信息
    private List<IntegralRecord> integralRecordList = new ArrayList<IntegralRecord>();//账号历史积分明细信息

    public PropertyRecord getPropertyRecord()
    {
        return this.propertyRecord;
    }

    public void setPropertyRecord(PropertyRecord propertyRecord)
    {
        this.propertyRecord = propertyRecord;
    }

    public List<ActionRecord> getActionRecordList()
    {
        return this.actionRecordList;
    }

    public void setActionRecordList(List<ActionRecord> actionRecordList)
    {
        this.actionRecordList = actionRecordList;
    }

    public List<ConsumeRecord> getConsumeRecordList()
    {
        return this.consumeRecordList;
    }

    public void setConsumeRecordList(List<ConsumeRecord> consumeRecordList)
    {
        this.consumeRecordList = consumeRecordList;
    }

    public List<IntegralRecord> getIntegralRecordList()
    {
        return this.integralRecordList;
    }

    public void setIntegralRecordList(List<IntegralRecord> integralRecordList)
    {
        this.integralRecordList = integralRecordList;
    }

}
