package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.NominateActivity;
import com.gooagoo.entity.generator.sys.NominateActivityExample;
import com.gooagoo.entity.generator.sys.NominateActivityKey;

public interface NominateActivityMapper
{

    public Integer countByExample(NominateActivityExample nominateActivityExample);

    public List<NominateActivity> selectByExample(NominateActivityExample nominateActivityExample);

    public NominateActivity selectByPrimaryKey(NominateActivityKey nominateActivityKey);

}
