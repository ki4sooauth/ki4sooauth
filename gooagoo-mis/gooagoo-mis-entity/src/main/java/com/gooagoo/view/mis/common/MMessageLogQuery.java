package com.gooagoo.view.mis.common;

import java.io.Serializable;
import java.util.List;

public class MMessageLogQuery implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String uuid;
    private String puuid;//父消息流水号
    private List<MMessageLog> mmessageLog;

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public List<MMessageLog> getMmessageLog()
    {
        return mmessageLog;
    }

    public void setMmessageLog(List<MMessageLog> mmessageLog)
    {
        this.mmessageLog = mmessageLog;
    }

    public String getPuuid()
    {
        return puuid;
    }

    public void setPuuid(String puuid)
    {
        this.puuid = puuid;
    }

}
