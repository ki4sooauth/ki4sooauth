package com.gooagoo.dao.generator.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.base.PromptingMessage;
import com.gooagoo.entity.generator.base.PromptingMessageExample;
import com.gooagoo.entity.generator.base.PromptingMessageKey;

public interface PromptingMessageMapper
{

    public Integer countByExample(PromptingMessageExample promptingMessageExample);

    public List<PromptingMessage> selectByExample(PromptingMessageExample promptingMessageExample);

    public PromptingMessage selectByPrimaryKey(PromptingMessageKey promptingMessageKey);

    public Integer deleteByExample(PromptingMessageExample promptingMessageExample);

    public Integer deleteByPrimaryKey(PromptingMessageKey promptingMessageKey);

    public Integer insertSelective(PromptingMessage promptingMessage);

    public Integer updateAllByExample(@Param("record") PromptingMessage promptingMessage, @Param("example") PromptingMessageExample promptingMessageExample);

    public Integer updateByExampleSelective(@Param("record") PromptingMessage promptingMessage, @Param("example") PromptingMessageExample promptingMessageExample);

    public Integer updateByPrimaryKeySelective(PromptingMessage promptingMessage);

}
