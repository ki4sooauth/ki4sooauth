package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.NominateActivity;
import com.gooagoo.entity.generator.sys.NominateActivityExample;
import com.gooagoo.entity.generator.sys.NominateActivityKey;

public interface NominateActivityMapper
{

    public Integer countByExample(NominateActivityExample nominateActivityExample);

    public List<NominateActivity> selectByExample(NominateActivityExample nominateActivityExample);

    public NominateActivity selectByPrimaryKey(NominateActivityKey nominateActivityKey);

    public Integer deleteByExample(NominateActivityExample nominateActivityExample);

    public Integer deleteByPrimaryKey(NominateActivityKey nominateActivityKey);

    public Integer insertSelective(NominateActivity nominateActivity);

    public Integer updateAllByExample(@Param("record") NominateActivity nominateActivity, @Param("example") NominateActivityExample nominateActivityExample);

    public Integer updateByExampleSelective(@Param("record") NominateActivity nominateActivity, @Param("example") NominateActivityExample nominateActivityExample);

    public Integer updateByPrimaryKeySelective(NominateActivity nominateActivity);

}
