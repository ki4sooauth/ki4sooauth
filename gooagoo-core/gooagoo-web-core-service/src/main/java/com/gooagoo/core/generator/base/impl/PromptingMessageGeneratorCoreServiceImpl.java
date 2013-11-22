package com.gooagoo.core.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.base.PromptingMessageGeneratorCoreService;
import com.gooagoo.entity.generator.base.PromptingMessage;
import com.gooagoo.entity.generator.base.PromptingMessageExample;
import com.gooagoo.entity.generator.base.PromptingMessageKey;
import com.gooagoo.dao.generator.base.PromptingMessageMapper;

@Service
public class PromptingMessageGeneratorCoreServiceImpl implements PromptingMessageGeneratorCoreService
{

    @Autowired
    private PromptingMessageMapper promptingMessageMapper;

    @Override
    public Integer countByExample(PromptingMessageExample promptingMessageExample) 
    {
        return this.promptingMessageMapper.countByExample(promptingMessageExample);
    }

    @Override
    public List<PromptingMessage> selectByExample(PromptingMessageExample promptingMessageExample) 
    {
        return this.promptingMessageMapper.selectByExample(promptingMessageExample);
    }

    @Override
    public PromptingMessage selectUnDelByPrimaryKey(String primaryKey) 
    {
        PromptingMessageKey promptingMessageKey = new PromptingMessageKey();
        promptingMessageKey.setIsDel("N");
        promptingMessageKey.setMessageId(primaryKey);
        return this.promptingMessageMapper.selectByPrimaryKey(promptingMessageKey);
    }

    @Override
    public PromptingMessage selectByPrimaryKey(String primaryKey) 
    {
        PromptingMessageKey promptingMessageKey = new PromptingMessageKey();
        promptingMessageKey.setMessageId(primaryKey);
        return this.promptingMessageMapper.selectByPrimaryKey(promptingMessageKey);
    }

    @Override
    public boolean physicalDeleteByExample(PromptingMessageExample promptingMessageExample) 
    {
        return this.promptingMessageMapper.deleteByExample(promptingMessageExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        PromptingMessageKey promptingMessageKey = new PromptingMessageKey();
        promptingMessageKey.setMessageId(primaryKey);
        return this.promptingMessageMapper.deleteByPrimaryKey(promptingMessageKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(PromptingMessageExample promptingMessageExample) 
    {
        PromptingMessage promptingMessage = new PromptingMessage();
        promptingMessage.setIsDel("Y");
        return this.promptingMessageMapper.updateByExampleSelective(promptingMessage,promptingMessageExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        PromptingMessage promptingMessage = new PromptingMessage();
        promptingMessage.setMessageId(primaryKey);
        promptingMessage.setIsDel("Y");
        return this.promptingMessageMapper.updateByPrimaryKeySelective(promptingMessage) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(PromptingMessage promptingMessage) 
    {
        return this.promptingMessageMapper.insertSelective(promptingMessage) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(PromptingMessage promptingMessage,PromptingMessageExample promptingMessageExample) 
    {
        return this.promptingMessageMapper.updateByExampleSelective(promptingMessage,promptingMessageExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(PromptingMessage promptingMessage) 
    {
        return this.promptingMessageMapper.updateByPrimaryKeySelective(promptingMessage) > 0 ? true : false;
    }

}
