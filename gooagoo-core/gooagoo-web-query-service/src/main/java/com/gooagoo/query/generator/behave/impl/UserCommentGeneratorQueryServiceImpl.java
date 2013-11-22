package com.gooagoo.query.generator.behave.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.behave.UserCommentGeneratorQueryService;
import com.gooagoo.entity.generator.behave.UserComment;
import com.gooagoo.entity.generator.behave.UserCommentExample;
import com.gooagoo.entity.generator.behave.UserCommentKey;
import com.gooagoo.dao.generator.behave.UserCommentMapper;

@Service
public class UserCommentGeneratorQueryServiceImpl implements UserCommentGeneratorQueryService
{

    @Autowired
    private UserCommentMapper userCommentMapper;

    @Override
    public Integer countByExample(UserCommentExample userCommentExample) 
    {
        return this.userCommentMapper.countByExample(userCommentExample);
    }

    @Override
    public List<UserComment> selectByExample(UserCommentExample userCommentExample) 
    {
        return this.userCommentMapper.selectByExample(userCommentExample);
    }

    @Override
    public UserComment selectUnDelByPrimaryKey(String primaryKey) 
    {
        UserCommentKey userCommentKey = new UserCommentKey();
        userCommentKey.setIsDel("N");
        userCommentKey.setCommentId(primaryKey);
        return this.userCommentMapper.selectByPrimaryKey(userCommentKey);
    }

    @Override
    public UserComment selectByPrimaryKey(String primaryKey) 
    {
        UserCommentKey userCommentKey = new UserCommentKey();
        userCommentKey.setCommentId(primaryKey);
        return this.userCommentMapper.selectByPrimaryKey(userCommentKey);
    }

}
