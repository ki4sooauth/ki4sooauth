package com.gooagoo.entity.business.log;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class MessageLogQuery implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String uuid;
    private List<LogInfo> logInfos;

    public String getUuid()
    {
        return this.uuid;
    }

    @Override
    public String toString()
    {
        return "MessageLogQuery [uuid=" + this.uuid + ", logInfos=" + this.logInfos + "]";
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public List<LogInfo> getLogInfos()
    {
        return this.logInfos;
    }

    public static class LogInfo implements Serializable, Comparator<LogInfo>
    {
        private static final long serialVersionUID = 1L;

        private String server;//消息到达服务名称
        private String source;//消息来源
        private String behaveCode;//记录接口编码
        private String behaveType;//记录行为类型
        private String logType;//商家日志1，个人日志2，后台日志3
        private Date recetime;//接收时间(消息到达时间)
        private Date sendtime;//发送时间(消息进入消息日志队列的时间)
        private String puuid;//父消息流水号
        private String exception;//异常信息(发送失败记录异常信息)

        public String getServer()
        {
            return this.server;
        }

        public void setServer(String server)
        {
            this.server = server;
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

        public Date getRecetime()
        {
            return this.recetime;
        }

        public void setRecetime(Date recetime)
        {
            this.recetime = recetime;
        }

        public Date getSendtime()
        {
            return this.sendtime;
        }

        public void setSendtime(Date sendtime)
        {
            this.sendtime = sendtime;
        }

        public String getPuuid()
        {
            return this.puuid;
        }

        public void setPuuid(String puuid)
        {
            this.puuid = puuid;
        }

        public String getException()
        {
            return this.exception;
        }

        public void setException(String exception)
        {
            this.exception = exception;
        }

        public String getLogType()
        {
            return this.logType;
        }

        public void setLogType(String logType)
        {
            this.logType = logType;
        }

        private static String sourceSort = "1,2,3,4,5,6,7,8,15,9,10,11,16,12,13,14";

        @Override
        public int compare(LogInfo o1, LogInfo o2)
        {

            int result = o1.getRecetime().compareTo(o2.getRecetime());
            if (result != 0)
            {
                return result;
            }
            else
            {
                if (o1.getSource() != null && o2.getSource() != null)
                {
                    return sourceSort.indexOf(o1.getSource()) - sourceSort.indexOf(o2.getSource());
                }
            }

            return 0;
        }
    }

    public void setLogInfos(List<LogInfo> logInfos)
    {
        this.logInfos = logInfos;
    }

}
