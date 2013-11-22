package com.gooagoo.core.generator.behave.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.behave.UserCommentGeneratorCoreService;
import com.gooagoo.entity.generator.behave.UserComment;
import com.gooagoo.entity.generator.behave.UserCommentExample;
import com.gooagoo.entity.generator.behave.UserCommentKey;
import com.gooagoo.dao.generator.behave.UserCommentMapper;

@Service
public class UserCommentGeneratorCoreServiceImpl implements UserCommentGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(UserCommentExample userCommentExample) 
    {
        return this.userCommentMapper.deleteByExample(userCommentExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        UserCommentKey userCommentKey = new UserCommentKey();
        userCommentKey.setCommentId(primaryKey);
        return this.userCommentMapper.deleteByPrimaryKey(userCommentKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(UserCommentExample userCommentExample) 
    {
        UserComment userComment = new UserComment();
        userComment.setIsDel("Y");
        return this.userCommentMapper.updateByExampleSelective(userComment,userCommentExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        UserComment userComment = new UserComment();
        userComment.setCommentId(primaryKey);
        userComment.setIsDel("Y");
        return this.userCommentMapper.updateByPrimaryKeySelective(userComment) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(UserComment userComment) 
    {
        return this.userCommentMapper.insertSelective(userComment) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserComment userComment,UserCommentExample userCommentExample) 
    {
        return this.userCommentMapper.updateByExampleSelective(userComment,userCommentExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserComment userComment) 
    {
        return this.userCommentMapper.updateByPrimaryKeySelective(userComment) > 0 ? true : false;
    }

}
