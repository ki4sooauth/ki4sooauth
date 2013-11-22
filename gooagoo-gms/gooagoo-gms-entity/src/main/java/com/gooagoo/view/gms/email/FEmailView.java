package com.gooagoo.view.gms.email;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gooagoo.view.gms.common.FNode;
import com.gooagoo.view.gms.marketing.FActivity;
import com.gooagoo.view.gms.marketing.FEvent;

/**
 * 邮件营销相关内容信息
 */
public class FEmailView implements Serializable
{
    private static final long serialVersionUID = 1L;
    private FEvent event;
    private List<FNode> rootChannelList = new ArrayList<FNode>();
    private List<FActivity> activityList = new ArrayList<FActivity>();

    public FEvent getEvent()
    {
        return this.event;
    }

    public void setEvent(FEvent event)
    {
        this.event = event;
    }

    public List<FNode> getRootChannelList()
    {
        return this.rootChannelList;
    }

    public void setRootChannelList(List<FNode> rootChannelList)
    {
        this.rootChannelList = rootChannelList;
    }

    public List<FActivity> getActivityList()
    {
        return this.activityList;
    }

    public void setActivityList(List<FActivity> activityList)
    {
        this.activityList = activityList;
    }

}
