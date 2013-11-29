package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.SectionLineInfo;
import com.gooagoo.entity.generator.shop.SectionLineInfoExample;
import com.gooagoo.entity.generator.shop.SectionLineInfoKey;

public interface SectionLineInfoMapper
{

    public Integer countByExample(SectionLineInfoExample sectionLineInfoExample);

    public List<SectionLineInfo> selectByExample(SectionLineInfoExample sectionLineInfoExample);

    public SectionLineInfo selectByPrimaryKey(SectionLineInfoKey sectionLineInfoKey);

    public Integer deleteByExample(SectionLineInfoExample sectionLineInfoExample);

    public Integer deleteByPrimaryKey(SectionLineInfoKey sectionLineInfoKey);

    public Integer insertSelective(SectionLineInfo sectionLineInfo);

    public Integer updateAllByExample(@Param("record") SectionLineInfo sectionLineInfo, @Param("example") SectionLineInfoExample sectionLineInfoExample);

    public Integer updateByExampleSelective(@Param("record") SectionLineInfo sectionLineInfo, @Param("example") SectionLineInfoExample sectionLineInfoExample);

    public Integer updateByPrimaryKeySelective(SectionLineInfo sectionLineInfo);

}
