package com.gooagoo.dao.generator.behave;

import java.util.List;

import com.gooagoo.entity.generator.behave.UserComment;
import com.gooagoo.entity.generator.behave.UserCommentExample;
import com.gooagoo.entity.generator.behave.UserCommentKey;

public interface UserCommentMapper
{

    public Integer countByExample(UserCommentExample userCommentExample);

    public List<UserComment> selectByExample(UserCommentExample userCommentExample);

    public UserComment selectByPrimaryKey(UserCommentKey userCommentKey);

}
