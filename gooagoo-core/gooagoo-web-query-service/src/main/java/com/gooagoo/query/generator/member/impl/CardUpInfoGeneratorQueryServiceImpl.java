package com.gooagoo.query.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.member.CardUpInfoGeneratorQueryService;
import com.gooagoo.entity.generator.member.CardUpInfo;
import com.gooagoo.entity.generator.member.CardUpInfoExample;
import com.gooagoo.entity.generator.member.CardUpInfoKey;
import com.gooagoo.dao.generator.member.CardUpInfoMapper;

@Service
public class CardUpInfoGeneratorQueryServiceImpl implements CardUpInfoGeneratorQueryService
{

    @Autowired
    private CardUpInfoMapper cardUpInfoMapper;

    @Override
    public Integer countByExample(CardUpInfoExample cardUpInfoExample) 
    {
        return this.cardUpInfoMapper.countByExample(cardUpInfoExample);
    }

    @Override
    public List<CardUpInfo> selectByExample(CardUpInfoExample cardUpInfoExample) 
    {
        return this.cardUpInfoMapper.selectByExample(cardUpInfoExample);
    }

    @Override
    public CardUpInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        CardUpInfoKey cardUpInfoKey = new CardUpInfoKey();
        cardUpInfoKey.setIsDel("N");
        cardUpInfoKey.setId(primaryKey);
        return this.cardUpInfoMapper.selectByPrimaryKey(cardUpInfoKey);
    }

    @Override
    public CardUpInfo selectByPrimaryKey(String primaryKey) 
    {
        CardUpInfoKey cardUpInfoKey = new CardUpInfoKey();
        cardUpInfoKey.setId(primaryKey);
        return this.cardUpInfoMapper.selectByPrimaryKey(cardUpInfoKey);
    }

}
