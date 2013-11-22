package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.NominateActivityGeneratorQueryService;
import com.gooagoo.entity.generator.sys.NominateActivity;
import com.gooagoo.entity.generator.sys.NominateActivityExample;
import com.gooagoo.entity.generator.sys.NominateActivityKey;
import com.gooagoo.dao.generator.sys.NominateActivityMapper;

@Service
public class NominateActivityGeneratorQueryServiceImpl implements NominateActivityGeneratorQueryService
{

    @Autowired
    private NominateActivityMapper nominateActivityMapper;

    @Override
    public Integer countByExample(NominateActivityExample nominateActivityExample) 
    {
        return this.nominateActivityMapper.countByExample(nominateActivityExample);
    }

    @Override
    public List<NominateActivity> selectByExample(NominateActivityExample nominateActivityExample) 
    {
        return this.nominateActivityMapper.selectByExample(nominateActivityExample);
    }

    @Override
    public NominateActivity selectUnDelByPrimaryKey(String primaryKey) 
    {
        NominateActivityKey nominateActivityKey = new NominateActivityKey();
        nominateActivityKey.setIsDel("N");
        nominateActivityKey.setId(primaryKey);
        return this.nominateActivityMapper.selectByPrimaryKey(nominateActivityKey);
    }

    @Override
    public NominateActivity selectByPrimaryKey(String primaryKey) 
    {
        NominateActivityKey nominateActivityKey = new NominateActivityKey();
        nominateActivityKey.setId(primaryKey);
        return this.nominateActivityMapper.selectByPrimaryKey(nominateActivityKey);
    }

}
