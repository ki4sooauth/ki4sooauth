package com.gooagoo.current.sub.position;

import java.util.HashMap;
import java.util.Map;

import com.gooagoo.bi.entity.position.BehaviorAreaChange;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.redis.data.RedisSortedSetDao;

/**
 * 记录用户现在的所在区域
 * @author 王宇
 *
 */
@Message(DispatcherConstants.area)
public class MacArea implements Customer
{
    @Override
    public void message(Object message)
    {
        RedisSortedSetDao userPosition = new RedisSortedSetDao(RedisServerConstants.statistics_user_position);

        BehaviorAreaChange position = (BehaviorAreaChange) message;
        String mac = position.getMacAddress(); //mac地址
        if (position.getOldArea() != null)
        {
            String[] oldArea = new String[position.getOldArea().size()];
            for (int i = 0; i < oldArea.length; i++)
            {
                oldArea[i] = position.getOldArea().get(i).getId();
            }
            userPosition.delElement(mac, oldArea);
        }
        if (position.getNewArea() != null)
        {
            long nowTime = System.currentTimeMillis() - 500;
            Map<Double, String> scoreMembers = new HashMap<Double, String>();
            for (String area : position.getNewArea())
            {
                scoreMembers.put((double) nowTime++, area);
            }
            userPosition.put(mac, scoreMembers);
        }
    }
}
