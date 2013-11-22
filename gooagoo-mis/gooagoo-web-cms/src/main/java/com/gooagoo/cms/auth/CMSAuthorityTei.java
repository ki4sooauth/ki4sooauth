package com.gooagoo.cms.auth;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;

public class CMSAuthorityTei extends TagExtraInfo
{
    @Override
    public boolean isValid(TagData data)
    {
        return true;
    }
}