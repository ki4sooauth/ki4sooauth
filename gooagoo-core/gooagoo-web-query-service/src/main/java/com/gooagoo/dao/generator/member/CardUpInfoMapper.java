package com.gooagoo.dao.generator.member;

import java.util.List;

import com.gooagoo.entity.generator.member.CardUpInfo;
import com.gooagoo.entity.generator.member.CardUpInfoExample;
import com.gooagoo.entity.generator.member.CardUpInfoKey;

public interface CardUpInfoMapper
{

    public Integer countByExample(CardUpInfoExample cardUpInfoExample);

    public List<CardUpInfo> selectByExample(CardUpInfoExample cardUpInfoExample);

    public CardUpInfo selectByPrimaryKey(CardUpInfoKey cardUpInfoKey);

}
