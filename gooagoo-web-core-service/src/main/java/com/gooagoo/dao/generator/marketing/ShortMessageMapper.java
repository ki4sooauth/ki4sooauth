package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.ShortMessage;
import com.gooagoo.entity.generator.marketing.ShortMessageExample;
import com.gooagoo.entity.generator.marketing.ShortMessageKey;

public interface ShortMessageMapper
{

    public Integer countByExample(ShortMessageExample shortMessageExample);

    public List<ShortMessage> selectByExample(ShortMessageExample shortMessageExample);

    public ShortMessage selectByPrimaryKey(ShortMessageKey shortMessageKey);

    public Integer deleteByExample(ShortMessageExample shortMessageExample);

    public Integer deleteByPrimaryKey(ShortMessageKey shortMessageKey);

    public Integer insertSelective(ShortMessage shortMessage);

    public Integer updateAllByExample(@Param("record") ShortMessage shortMessage, @Param("example") ShortMessageExample shortMessageExample);

    public Integer updateByExampleSelective(@Param("record") ShortMessage shortMessage, @Param("example") ShortMessageExample shortMessageExample);

    public Integer updateByPrimaryKeySelective(ShortMessage shortMessage);

}
