package com.gooagoo.entity.generator.behave;

import java.io.Serializable;

/**
 * 用户评论
 */

public class UserCommentKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String commentId;//评论编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getCommentId()
    {
        return commentId;
    }

    public void setCommentId(String commentId)
    {
        this.commentId = commentId;
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
