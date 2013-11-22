package com.gooagoo.entity.generator.behave;

import java.io.Serializable;

/**
 * 用户反馈，收集用户对gooagooAPP的使用反馈
 */

public class UserFeedbackKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String feedbackId;//反馈编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getFeedbackId()
    {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId)
    {
        this.feedbackId = feedbackId;
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
