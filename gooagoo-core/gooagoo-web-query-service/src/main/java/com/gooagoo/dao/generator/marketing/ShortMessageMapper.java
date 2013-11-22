package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.ShortMessage;
import com.gooagoo.entity.generator.marketing.ShortMessageExample;
import com.gooagoo.entity.generator.marketing.ShortMessageKey;

public interface ShortMessageMapper
{

    public Integer countByExample(ShortMessageExample shortMessageExample);

    public List<ShortMessage> selectByExample(ShortMessageExample shortMessageExample);

    public ShortMessage selectByPrimaryKey(ShortMessageKey shortMessageKey);

}
