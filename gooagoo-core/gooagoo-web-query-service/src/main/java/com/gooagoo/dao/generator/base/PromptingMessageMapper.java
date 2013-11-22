package com.gooagoo.dao.generator.base;

import java.util.List;

import com.gooagoo.entity.generator.base.PromptingMessage;
import com.gooagoo.entity.generator.base.PromptingMessageExample;
import com.gooagoo.entity.generator.base.PromptingMessageKey;

public interface PromptingMessageMapper
{

    public Integer countByExample(PromptingMessageExample promptingMessageExample);

    public List<PromptingMessage> selectByExample(PromptingMessageExample promptingMessageExample);

    public PromptingMessage selectByPrimaryKey(PromptingMessageKey promptingMessageKey);

}
