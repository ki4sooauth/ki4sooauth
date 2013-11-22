package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gooagoo.view.gms.common.FNode;

/**
 * 营销事件相关内容信息
 */
public class FEventView implements Serializable
{
    private static final long serialVersionUID = 1L;
    private FEvent event;
    private String channelCode;
    private List<FNode> templateList = new ArrayList<FNode>();

    public FEvent getEvent()
    {
        return this.event;
    }

    public void setEvent(FEvent event)
    {
        this.event = event;
    }

    public String getChannelCode()
    {
        return this.channelCode;
    }

    public void setChannelCode(String channelCode)
    {
        this.channelCode = channelCode;
    }

    public List<FNode> getTemplateList()
    {
        return this.templateList;
    }

    public void setTemplateList(List<FNode> templateList)
    {
        this.templateList = templateList;
    }

}
