package com.gooagoo.analysis.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.analysis.converter.service.ConverterService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.entity.position.Duration;

@Service("durationConverterService")
public class DurationConverterServiceImpl<T> implements ConverterService
{

    @Override
    public List<Behave> getBehave(Object object) throws Exception
    {
        List<Behave> behaveList = new ArrayList<Behave>();
        Duration duration = (Duration) object;
        Behave behave = new Behave();
        behave.setMacAddress(duration.getMacAddress());//MAC地址
        behave.setPositionId(duration.getPositionId());//行为发生地区的区域编号
        behave.setBehaveType("2");//到达区域
        behave.setShopId(duration.getShopId());//行为对象所属商家编号
        behave.setDuration(duration.getDuration());//当前时长（以秒为单位）
        behaveList.add(behave);
        return behaveList;
    }

}
