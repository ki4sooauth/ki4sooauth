package com.gooagoo.analysis.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.analysis.common.utils.PositionZip;
import com.gooagoo.analysis.converter.service.ConverterService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.entity.position.Behavior;

@Service("behaviorConverterService")
public class BehaviorConverterServiceImpl implements ConverterService
{

    @Override
    public List<Behave> getBehave(Object object) throws Exception
    {
        List<Behave> behaveList = new ArrayList<Behave>();
        String behaviorStr = (String) object;
        List<Behavior> behaviorList = PositionZip.toBehavior(behaviorStr);
        for (Behavior behavior : behaviorList)
        {
            Behave behave = new Behave();
            behave.setMacAddress(behavior.getMacAddress());//MAC地址
            behave.setPositionId(behavior.getPositionId());//行为发生地区的区域编号
            behave.setBehaveType(behavior.getBehaviour());//行为类型（到店、离店、到区域、路过）
            behave.setShopEntityId(behavior.getEntityId());//行为对象所属实体店编号
            behave.setShopId(behavior.getShopId());//行为对象所属商家编号
            behaveList.add(behave);
        }
        return behaveList;
    }

}
