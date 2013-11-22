package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;

/**
 * 商家通知信息表
 */

public class NoticeInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String noticeInfoId;//通知编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getNoticeInfoId()
    {
        return noticeInfoId;
    }

    public void setNoticeInfoId(String noticeInfoId)
    {
        this.noticeInfoId = noticeInfoId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
