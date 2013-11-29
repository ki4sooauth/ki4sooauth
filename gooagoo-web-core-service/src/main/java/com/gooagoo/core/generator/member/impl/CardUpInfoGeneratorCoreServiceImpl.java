package com.gooagoo.core.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.member.CardUpInfoGeneratorCoreService;
import com.gooagoo.entity.generator.member.CardUpInfo;
import com.gooagoo.entity.generator.member.CardUpInfoExample;
import com.gooagoo.entity.generator.member.CardUpInfoKey;
import com.gooagoo.dao.generator.member.CardUpInfoMapper;

@Service
public class CardUpInfoGeneratorCoreServiceImpl implements CardUpInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(CardUpInfoExample cardUpInfoExample) 
    {
        return this.cardUpInfoMapper.deleteByExample(cardUpInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        CardUpInfoKey cardUpInfoKey = new CardUpInfoKey();
        cardUpInfoKey.setId(primaryKey);
        return this.cardUpInfoMapper.deleteByPrimaryKey(cardUpInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(CardUpInfoExample cardUpInfoExample) 
    {
        CardUpInfo cardUpInfo = new CardUpInfo();
        cardUpInfo.setIsDel("Y");
        return this.cardUpInfoMapper.updateByExampleSelective(cardUpInfo,cardUpInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        CardUpInfo cardUpInfo = new CardUpInfo();
        cardUpInfo.setId(primaryKey);
        cardUpInfo.setIsDel("Y");
        return this.cardUpInfoMapper.updateByPrimaryKeySelective(cardUpInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(CardUpInfo cardUpInfo) 
    {
        return this.cardUpInfoMapper.insertSelective(cardUpInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(CardUpInfo cardUpInfo,CardUpInfoExample cardUpInfoExample) 
    {
        return this.cardUpInfoMapper.updateByExampleSelective(cardUpInfo,cardUpInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(CardUpInfo cardUpInfo) 
    {
        return this.cardUpInfoMapper.updateByPrimaryKeySelective(cardUpInfo) > 0 ? true : false;
    }

}
