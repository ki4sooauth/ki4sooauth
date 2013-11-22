package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.ShortMessageGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.ShortMessage;
import com.gooagoo.entity.generator.marketing.ShortMessageExample;
import com.gooagoo.entity.generator.marketing.ShortMessageKey;
import com.gooagoo.dao.generator.marketing.ShortMessageMapper;

@Service
public class ShortMessageGeneratorQueryServiceImpl implements ShortMessageGeneratorQueryService
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

}
