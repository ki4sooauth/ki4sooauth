package com.gooagoo.api.business.core.user.comment;

import com.gooagoo.entity.generator.behave.UserComment;
import com.gooagoo.exception.business.behave.UserAlreadyCommentGoodsException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

public interface CommentGoodsCoreService

{
    /**
     * 评论商品
     * @param userComment
     * @param billDetailId
     * @return true/false
     * @throws NullException
     * @throws OperateFailException
     * @throws FormatErrorException
     * @throws UserAlreadyCommentGoodsException 用户已评论商品异常
     */
    public boolean commentGoods(UserComment userComment, String billDetailId) throws Exception;

}
