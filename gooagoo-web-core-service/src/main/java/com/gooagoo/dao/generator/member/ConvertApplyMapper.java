package com.gooagoo.dao.generator.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.member.ConvertApply;
import com.gooagoo.entity.generator.member.ConvertApplyExample;
import com.gooagoo.entity.generator.member.ConvertApplyKey;

public interface ConvertApplyMapper
{

    public Integer countByExample(ConvertApplyExample convertApplyExample);

    public List<ConvertApply> selectByExample(ConvertApplyExample convertApplyExample);

    public ConvertApply selectByPrimaryKey(ConvertApplyKey convertApplyKey);

    public Integer deleteByExample(ConvertApplyExample convertApplyExample);

    public Integer deleteByPrimaryKey(ConvertApplyKey convertApplyKey);

    public Integer insertSelective(ConvertApply convertApply);

    public Integer updateAllByExample(@Param("record") ConvertApply convertApply, @Param("example") ConvertApplyExample convertApplyExample);

    public Integer updateByExampleSelective(@Param("record") ConvertApply convertApply, @Param("example") ConvertApplyExample convertApplyExample);

    public Integer updateByPrimaryKeySelective(ConvertApply convertApply);

}
