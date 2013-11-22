package com.gooagoo.entity.business.statistics;

import java.io.Serializable;

public class UserGroup implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String groupId;
    private String groupName;
    private String groupDesc;

    public String getGroupId()
    {
        return this.groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }

    public String getGroupName()
    {
        return this.groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public String getGroupDesc()
    {
        return this.groupDesc;
    }

    public void setGroupDesc(String groupDesc)
    {
        this.groupDesc = groupDesc;
    }
}
