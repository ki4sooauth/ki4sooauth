package com.gooagoo.api.business.query.user.comment;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.user.UserCommentDetail;
import com.gooagoo.entity.generator.behave.UserCommentExample;

public class TestCommentQueryService
{

    public CommentQueryService commentQueryService;

    @Before
    public void testBefore()
    {
        this.commentQueryService = ApplicationContextUtils.getBean(CommentQueryService.class);
    }

    /**
     * 查询商品评论列表（分页）
     * @throws Exception
     */
    @Test
    public void testFindUserCommentList() throws Exception
    {
        UserCommentExample userCommentExample = new UserCommentExample();
        List<UserCommentDetail> userCommentDetailList = this.commentQueryService.findUserCommentList(userCommentExample);
        Assert.assertTrue("查询商品评论列表失败", CollectionUtils.isNotEmpty(userCommentDetailList));
    }

}
