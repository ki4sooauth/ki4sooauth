package com.gooagoo.api.business.query.user.comment;

import java.util.List;

import com.gooagoo.entity.business.user.UserCommentDetail;
import com.gooagoo.entity.generator.behave.UserCommentExample;

/**
 * 评论
 */
public interface CommentQueryService
{

    /**
     * 查询商品评论列表（分页）
     * @param userCommentExample
     * @return
     * @throws Exception
     */
    public List<UserCommentDetail> findUserCommentList(UserCommentExample userCommentExample) throws Exception;
}
