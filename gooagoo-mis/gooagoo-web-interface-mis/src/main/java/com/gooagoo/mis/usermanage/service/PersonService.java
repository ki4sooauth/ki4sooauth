package com.gooagoo.mis.usermanage.service;

import java.util.List;

public interface PersonService
{

    /**
     * 用户冻结
     * @param user
     * @return
     */
    public boolean frozenUser(List<String> userId);

    /**
     * 用户解冻
     * @param user
     * @return
     */
    public boolean reFrozenUser(List<String> userId);

    /**
     * 查询用户留言
     * @param userId
     * @return
     */
    //public List<MessageResponse> searchUserMessageResponse(String userId);

    /**
     * 查询用户评论
     * @param userId
     * @return
     */
    //public List<CommentaryResponse> searchUserCommentary(String userId);
}
