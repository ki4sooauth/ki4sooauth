package com.gooagoo.entity.business.marketing;

import java.io.Serializable;
import java.util.List;

public class NoticeLinkInfoBussiness implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<NoticeInfoBusiness> noticeInfoBusinessList;//通知 

    private IsdeletedInfo isdeletedInfo;//已删除信息

    public List<NoticeInfoBusiness> getNoticeInfoBusinessList()
    {
        return this.noticeInfoBusinessList;
    }

    public void setNoticeInfoBusinessList(List<NoticeInfoBusiness> noticeInfoBusinessList)
    {
        this.noticeInfoBusinessList = noticeInfoBusinessList;
    }

    public IsdeletedInfo getIsdeletedInfo()
    {
        return this.isdeletedInfo;
    }

    public void setIsdeletedInfo(IsdeletedInfo isdeletedInfo)
    {
        this.isdeletedInfo = isdeletedInfo;
    }

}
