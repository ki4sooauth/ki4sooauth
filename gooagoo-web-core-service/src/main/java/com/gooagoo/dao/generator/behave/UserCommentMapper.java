package com.gooagoo.dao.generator.behave;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.behave.UserComment;
import com.gooagoo.entity.generator.behave.UserCommentExample;
import com.gooagoo.entity.generator.behave.UserCommentKey;

public interface UserCommentMapper
{

    public Integer countByExample(UserCommentExample userCommentExample);

    public List<UserComment> selectByExample(UserCommentExample userCommentExample);

    public UserComment selectByPrimaryKey(UserCommentKey userCommentKey);

    public Integer deleteByExample(UserCommentExample userCommentExample);

    public Integer deleteByPrimaryKey(UserCommentKey userCommentKey);

    public Integer insertSelective(UserComment userComment);

    public Integer updateAllByExample(@Param("record") UserComment userComment, @Param("example") UserCommentExample userCommentExample);

    public Integer updateByExampleSelective(@Param("record") UserComment userComment, @Param("example") UserCommentExample userCommentExample);

    public Integer updateByPrimaryKeySelective(UserComment userComment);

}
