package com.gooagoo.entity.message;

import java.io.Serializable;

/**
 * 业务系统消息
 * 消息来源
 * 1-手机APP
 * 2-手机网站
 * 3-个人消费中心
 * 4-定位引擎
 * 5-转发器
 * 6-店员助理
 * 7-商家管理中心
 * 8-购阿购管理系统
 * 9-推送分析
 * 10-实时统计
 * 11-营销引擎
 */
public class GooagooMessage<T> implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String uuid;//消息流水号(与消息内容流水号一致)
    private String source;//消息来源
    private String behaveCode;//调用的接口编码（位置引擎中表示定位（001）与行为（002）与时长(003)的识别标志）
    private String behaveType;//行为类型（特指用户行为类型，商家及管理员暂无）
    private boolean flag;//操作结果，true-成功，false-失败
    private T content;//消息内容(BehaveLog,ShopLog,SysLog,位置引擎消息,EmailVo,Message,MobPushMsg)

    public String getUuid()
    {
        return this.uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getSource()
    {
        return this.source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getBehaveCode()
    {
        return this.behaveCode;
    }

    public void setBehaveCode(String behaveCode)
    {
        this.behaveCode = behaveCode;
    }

    public String getBehaveType()
    {
        return this.behaveType;
    }

    public void setBehaveType(String behaveType)
    {
        this.behaveType = behaveType;
    }

    public boolean isFlag()
    {
        return this.flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    public T getContent()
    {
        return this.content;
    }

    public void setContent(T content)
    {
        this.content = content;
    }
}
