package com.gooagoo.core.business.system.sys.dictionary;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.sys.dictionary.TipsDicCoreService;
import com.gooagoo.api.generator.core.base.PromptingMessageGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.PromptingMessage;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class TipsDicCoreServiceImpl implements TipsDicCoreService

{

    @Autowired
    private PromptingMessageGeneratorCoreService promptingMessageGeneratorCoreService;

    @Override
    public boolean addTipsDic(PromptingMessage promptingMessage) throws Exception
    {
        promptingMessage.setIsDel("N");
        return this.promptingMessageGeneratorCoreService.insertSelective(promptingMessage);
    }

    @Override
    public boolean updateTipsDic(PromptingMessage promptingMessage) throws Exception
    {
        return this.promptingMessageGeneratorCoreService.updateByPrimaryKeySelective(promptingMessage);
    }

    @Override
    public boolean delTipsDic(String messageId) throws Exception
    {
        PromptingMessage promptingMessage = new PromptingMessage();
        promptingMessage.setMessageId(messageId);
        promptingMessage.setIsDel("Y");
        return this.promptingMessageGeneratorCoreService.updateByPrimaryKeySelective(promptingMessage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addAllTipsDic(List<PromptingMessage> sysList) throws Exception
    {
        if (!CollectionUtils.isNotEmpty(sysList))
        {
            GooagooLog.info("对象内容为空");
            return false;
        }
        if (!this.promptingMessageGeneratorCoreService.deleteByExample(null))
        {
            GooagooLog.info("清空后提示信息表失败");
            throw new OperateFailException("清空后提示信息表失败");
        }
        for (PromptingMessage inter : sysList)
        {
            if (!this.promptingMessageGeneratorCoreService.insertSelective(inter))
            {
                throw new OperateFailException("新增后提示信息失败" + new Gson().toJson(inter));
            }
        }
        return true;
    }

}
