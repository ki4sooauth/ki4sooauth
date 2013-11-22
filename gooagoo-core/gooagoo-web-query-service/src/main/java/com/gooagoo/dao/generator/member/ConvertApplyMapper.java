package com.gooagoo.dao.generator.member;

import java.util.List;

import com.gooagoo.entity.generator.member.ConvertApply;
import com.gooagoo.entity.generator.member.ConvertApplyExample;
import com.gooagoo.entity.generator.member.ConvertApplyKey;

public interface ConvertApplyMapper
{

    public Integer countByExample(ConvertApplyExample convertApplyExample);

    public List<ConvertApply> selectByExample(ConvertApplyExample convertApplyExample);

    public ConvertApply selectByPrimaryKey(ConvertApplyKey convertApplyKey);

}
