package com.gooagoo.dao.generator.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.member.CardUpInfo;
import com.gooagoo.entity.generator.member.CardUpInfoExample;
import com.gooagoo.entity.generator.member.CardUpInfoKey;

public interface CardUpInfoMapper
{

    public Integer countByExample(CardUpInfoExample cardUpInfoExample);

    public List<CardUpInfo> selectByExample(CardUpInfoExample cardUpInfoExample);

    public CardUpInfo selectByPrimaryKey(CardUpInfoKey cardUpInfoKey);

    public Integer deleteByExample(CardUpInfoExample cardUpInfoExample);

    public Integer deleteByPrimaryKey(CardUpInfoKey cardUpInfoKey);

    public Integer insertSelective(CardUpInfo cardUpInfo);

    public Integer updateAllByExample(@Param("record") CardUpInfo cardUpInfo, @Param("example") CardUpInfoExample cardUpInfoExample);

    public Integer updateByExampleSelective(@Param("record") CardUpInfo cardUpInfo, @Param("example") CardUpInfoExample cardUpInfoExample);

    public Integer updateByPrimaryKeySelective(CardUpInfo cardUpInfo);

}
