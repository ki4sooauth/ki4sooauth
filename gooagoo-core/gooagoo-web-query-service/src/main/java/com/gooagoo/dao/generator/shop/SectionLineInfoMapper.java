package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.SectionLineInfo;
import com.gooagoo.entity.generator.shop.SectionLineInfoExample;
import com.gooagoo.entity.generator.shop.SectionLineInfoKey;

public interface SectionLineInfoMapper
{

    public Integer countByExample(SectionLineInfoExample sectionLineInfoExample);

    public List<SectionLineInfo> selectByExample(SectionLineInfoExample sectionLineInfoExample);

    public SectionLineInfo selectByPrimaryKey(SectionLineInfoKey sectionLineInfoKey);

}
