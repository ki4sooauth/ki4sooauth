package com.gooagoo.cms.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import com.gooagoo.cms.utils.AuthUtil;

public class CMSAuthorityTag extends TagSupport
{
    private static final long serialVersionUID = 3123131321313L;

    private String authorityID = "";
    public PageContext pageContext;

    @Override
    public void setPageContext(PageContext pc)
    {
        this.pageContext = pc;
    }

    public String getAuthorityID()
    {
        return this.authorityID;
    }

    public void setAuthorityID(String authorityID)
    {
        this.authorityID = authorityID;
    }

    @Override
    public int doStartTag() throws JspException
    {
        HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
        try
        {
            if (this.authorityID == null)
            {
                return EVAL_BODY_INCLUDE;
            }
            if (this.authorityID != null && this.authorityID.equals(""))
            {
                return EVAL_BODY_INCLUDE;
            }
            if (AuthUtil.checkAuthID(request, this.authorityID))
            {
                return EVAL_BODY_INCLUDE;
            }
            else
            {
                return SKIP_BODY;
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return SKIP_BODY;
        }

    }

    @Override
    public int doEndTag()
    {
        return EVAL_PAGE;
    }
}
