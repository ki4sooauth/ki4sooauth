package com.gooagoo.entity.push;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class EmailVo implements Serializable
{
    private static final long serialVersionUID = 3986773031736410557L;
    /**消息流水号*/
    private String uuid;
    /**消息来源*/
    private String source;
    /**邮件类型*/
    private String type;
    /**优先级*/
    private String pri;
    /**收件人*/
    private List<String> to;
    /** 抄送人*/
    private List<String> cc;
    /** 密件抄送人*/
    private List<String> bcc;
    /** 邮件主题*/
    private String subject;
    /**邮件正文（仅在简单文本邮件发送时使用，稍微复杂格式的邮件内容，建议使用velocity模板配置）*/
    private String text;
    /**附件信息Map，包含附件文件名称和附件文件组成的key-value对*/
    private List<File> attachment;
    /**内嵌文件信息Map，包含由内嵌文件名称和内嵌文件组成的key-value对*/
    private List<File> inlineFile;

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

    public List<String> getTo()
    {
        return this.to;
    }

    public void setTo(List<String> to)
    {
        this.to = to;
    }

    public List<String> getCc()
    {
        return this.cc;
    }

    public void setCc(List<String> cc)
    {
        this.cc = cc;
    }

    public List<String> getBcc()
    {
        return this.bcc;
    }

    public void setBcc(List<String> bcc)
    {
        this.bcc = bcc;
    }

    public String getSubject()
    {
        return this.subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getText()
    {
        return this.text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public List<File> getAttachment()
    {
        return this.attachment;
    }

    public void setAttachment(List<File> attachment)
    {
        this.attachment = attachment;
    }

    public List<File> getInlineFile()
    {
        return this.inlineFile;
    }

    public void setInlineFile(List<File> inlineFile)
    {
        this.inlineFile = inlineFile;
    }

}
