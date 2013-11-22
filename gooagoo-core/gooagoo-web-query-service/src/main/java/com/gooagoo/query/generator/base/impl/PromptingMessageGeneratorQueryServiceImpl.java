package com.gooagoo.query.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.PromptingMessageGeneratorQueryService;
import com.gooagoo.entity.generator.base.PromptingMessage;
import com.gooagoo.entity.generator.base.PromptingMessageExample;
import com.gooagoo.entity.generator.base.PromptingMessageKey;
import com.gooagoo.dao.generator.base.PromptingMessageMapper;

@Service
public class PromptingMessageGeneratorQueryServiceImpl implements PromptingMessageGeneratorQueryService
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

}
