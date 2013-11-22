package com.gooagoo.entity.push;

import java.io.Serializable;
import java.util.List;

public class Message implements Serializable
{
    private static final long serialVersionUID = -366310776170994425L;
    /**消息流水号*/
    private String uuid;
    /**消息来源*/
    private String source;
    /**短信类型**/
    private String type;
    /**优先级**/
    private String pri;
    /**手机号码**/
    private List<String> smsMob;//目的手机号码
    /**短信内容**/
    private String smsText;//短信内容，最多支持300个字，普通短信70个字/条，长短信64个字/条

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

    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getPri()
    {
        return this.pri;
    }

    public void setPri(String pri)
    {
        this.pri = pri;
    }

    public List<String> getSmsMob()
    {
        return this.smsMob;
    }

    public void setSmsMob(List<String> smsMob)
    {
        this.smsMob = smsMob;
    }

    public String getSmsText()
    {
        return this.smsText;
    }

    public void setSmsText(String smsText)
    {
        this.smsText = smsText;
    }

}
