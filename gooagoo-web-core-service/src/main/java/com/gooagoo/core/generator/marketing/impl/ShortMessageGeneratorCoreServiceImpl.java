package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.ShortMessageGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.ShortMessage;
import com.gooagoo.entity.generator.marketing.ShortMessageExample;
import com.gooagoo.entity.generator.marketing.ShortMessageKey;
import com.gooagoo.dao.generator.marketing.ShortMessageMapper;

@Service
public class ShortMessageGeneratorCoreServiceImpl implements ShortMessageGeneratorCoreService
{

    @Autowired
    private ShortMessageMapper shortMessageMapper;

    @Override
    public Integer countByExample(ShortMessageExample shortMessageExample) 
    {
        return this.shortMessageMapper.countByExample(shortMessageExample);
    }

    @Override
    public List<ShortMessage> selectByExample(ShortMessageExample shortMessageExample) 
    {
        return this.shortMessageMapper.selectByExample(shortMessageExample);
    }

    @Override
    public ShortMessage selectUnDelByPrimaryKey(String primaryKey) 
    {
        ShortMessageKey shortMessageKey = new ShortMessageKey();
        shortMessageKey.setIsDel("N");
        shortMessageKey.setMessageId(primaryKey);
        return this.shortMessageMapper.selectByPrimaryKey(shortMessageKey);
    }

    @Override
    public ShortMessage selectByPrimaryKey(String primaryKey) 
    {
        ShortMessageKey shortMessageKey = new ShortMessageKey();
        shortMessageKey.setMessageId(primaryKey);
        return this.shortMessageMapper.selectByPrimaryKey(shortMessageKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShortMessageExample shortMessageExample) 
    {
        return this.shortMessageMapper.deleteByExample(shortMessageExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ShortMessageKey shortMessageKey = new ShortMessageKey();
        shortMessageKey.setMessageId(primaryKey);
        return this.shortMessageMapper.deleteByPrimaryKey(shortMessageKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ShortMessageExample shortMessageExample) 
    {
        ShortMessage shortMessage = new ShortMessage();
        shortMessage.setIsDel("Y");
        return this.shortMessageMapper.updateByExampleSelective(shortMessage,shortMessageExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ShortMessage shortMessage = new ShortMessage();
        shortMessage.setMessageId(primaryKey);
        shortMessage.setIsDel("Y");
        return this.shortMessageMapper.updateByPrimaryKeySelective(shortMessage) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ShortMessage shortMessage) 
    {
        return this.shortMessageMapper.insertSelective(shortMessage) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShortMessage shortMessage,ShortMessageExample shortMessageExample) 
    {
        return this.shortMessageMapper.updateByExampleSelective(shortMessage,shortMessageExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShortMessage shortMessage) 
    {
        return this.shortMessageMapper.updateByPrimaryKeySelective(shortMessage) > 0 ? true : false;
    }

}
