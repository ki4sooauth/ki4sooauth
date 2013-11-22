package com.gooagoo.position.task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.gooagoo.entity.position.Behavior;
import com.gooagoo.position.constants.BehaviorConstants;
import com.gooagoo.position.constants.ConfigConstants;
import com.gooagoo.position.constants.RedisConstants;
import com.gooagoo.position.entity.PositionCache;
import com.gooagoo.position.log.PositionEngineLog;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisObjectDao;
import com.google.gson.Gson;

public class BehaviorRule implements Runnable
{
    private ConcurrentLinkedQueue<Behavior> behaviorQueue = null;
    private PositionCache position;
    //用户之前行为列表，用于分析行为
    private ArrayList<PositionCache> list;
    private PositionCache lastBehavior;
    private String behavior;

    private static long lastCheckTime = 0;

    public BehaviorRule(ConcurrentLinkedQueue<Behavior> queue, PositionCache positionCache)
    {
        this.behaviorQueue = queue;
        this.position = positionCache;

        //从缓存中取
        this.list = this.getListByMac(this.position == null ? null : this.position.getMac());
        this.lastBehavior = this.getLastBehaviorByMac(this.position == null ? null : this.position.getMac());
    }

    @Override
    public void run()
    {
        boolean flag = this.ruleOne();
        if (!flag)
        {
            flag = this.ruleTwo();
            if (!flag)
            {
                flag = this.ruleThree();
                if (!flag)
                {
                    flag = this.ruleFour();
                    if (!flag)
                    {
                        flag = this.ruleFive();
                        if (!flag)
                        {
                            flag = this.ruleSix();
                        }
                    }
                }
            }
        }

        this.putPositionCache();

        if (flag)
        {
            this.putLastBehavior();
            Behavior obj = new Behavior();
            obj.setMacAddress(this.position.getMac());
            obj.setPositionId(this.position.getPositionId());
            obj.setEntityId(this.position.getEntityId());
            obj.setBehaviour(this.behavior);
            this.behaviorQueue.add(obj);
        }
    }

    /**
     * 规则一：如果当天用户没有跟商店发生任何行为，同时用户有连续5条有效的位置信息（不包含店门外），则识别为到店行为
     */
    private boolean ruleOne()
    {
        boolean flag = false;
        if (BehaviorConstants.BEHAVIOR_NULL == this.lastBehavior.getBehavior() || BehaviorConstants.BEHAVIOR_NULL.equals(this.lastBehavior.getBehavior()))
        {
            if (this.isValidPositionID(this.position.getPositionId(), this.position.getGridAttribute()))
            {
                if (this.list != null && this.list.size() >= 4)
                {
                    int p = 1;
                    for (int i = this.list.size() - 1; i >= this.list.size() - 4; i--)
                    {
                        PositionCache obj = this.list.get(i);
                        if (this.isValidPositionID(obj.getPositionId(), obj.getGridAttribute()))
                        {
                            p++;
                        }
                    }
                    if (p == 5)
                    {
                        flag = true;
                        this.behavior = BehaviorConstants.BEHAVIOR_ARR_SHOP;
                    }
                }
            }
        }

        return flag;
    }

    /**
     * 规则二：如果当天用户有跟商店发生行为，同时上一行为不是离店，用户位置区域有效，用户位置编号跟上次行为位置编号不同（不包含店门外），并且这个编号连续五次以内第三次出现，则识别为到达区域
     */
    private boolean ruleTwo()
    {
        boolean flag = false;
        if (this.lastBehavior.getBehavior() != BehaviorConstants.BEHAVIOR_NULL)
        {
            if (this.lastBehavior.getBehavior() != BehaviorConstants.BEHAVIOR_LEAVE_SHOP)
            {
                if (this.isValidPositionID(this.position.getPositionId(), this.position.getGridAttribute()))
                {
                    if (this.position.getPositionId() != this.lastBehavior.getPositionId())
                    {
                        if (this.list != null && this.list.size() >= 2)
                        {
                            int p = 1;
                            for (int i = this.list.size() - 1; i >= 0; i--)
                            {
                                PositionCache obj = this.list.get(i);

                                if (obj.getPositionId() == this.position.getPositionId())
                                {
                                    p++;
                                }
                                if (this.list.size() - i == 4)
                                {
                                    break;
                                }
                            }
                            if (p >= 3)
                            {
                                flag = true;
                                this.behavior = BehaviorConstants.BEHAVIOR_ARR_AREA;
                            }
                        }
                    }
                }
            }
        }

        return flag;
    }

    /**
     * 规则三：如果当天用户有跟商店发生行为，同时上一行为不是离店，用户位置编号变为店门外区域编号，并且这个编号连续五次内第三次出现，则识别为离店
     */
    private boolean ruleThree()
    {
        boolean flag = false;
        if (this.lastBehavior.getBehavior() != BehaviorConstants.BEHAVIOR_NULL)
        {
            if (this.lastBehavior.getBehavior() != BehaviorConstants.BEHAVIOR_LEAVE_SHOP)
            {
                if (this.isOutsideShop(this.position.getGridAttribute()))
                {
                    if (this.position.getPositionId() != this.lastBehavior.getPositionId())
                    {
                        if (this.list != null && this.list.size() >= 2)
                        {
                            int p = 1;
                            for (int i = this.list.size() - 1; i >= 0; i--)
                            {
                                PositionCache obj = this.list.get(i);
                                if (this.isOutsideShop(obj.getGridAttribute()))
                                {
                                    p++;
                                }
                                if (this.list.size() - i == 4)
                                {
                                    break;
                                }
                            }
                            if (p >= 3)
                            {
                                flag = true;
                                this.behavior = BehaviorConstants.BEHAVIOR_LEAVE_SHOP;
                            }
                        }
                    }
                }
            }
        }

        return flag;
    }

    /**
     * 规则四：如果当天用户有跟商店发生行为，同时上一行为是离店，用户有5条有效的位置信息（不包含店门外），则识别为到店
     */
    private boolean ruleFour()
    {
        boolean flag = false;
        if (this.lastBehavior.getBehavior() == BehaviorConstants.BEHAVIOR_LEAVE_SHOP)
        {
            if (this.isValidPositionID(this.position.getPositionId(), this.position.getGridAttribute()))
            {
                if (this.list.size() >= 4)
                {
                    int p = 1;
                    for (int i = this.list.size() - 1; i >= this.list.size() - 4; i--)
                    {
                        PositionCache obj = this.list.get(i);
                        if (this.isValidPositionID(obj.getPositionId(), obj.getGridAttribute()))
                        {
                            p++;
                        }
                    }
                    if (p == 5)
                    {
                        flag = true;
                        this.behavior = BehaviorConstants.BEHAVIOR_ARR_SHOP;
                    }
                }
            }
        }

        return flag;
    }

    /**
     * 规则五：如果当天用户没有跟商店发生任何行为或者上一行为是离店，同时用户有5条无效的位置信息（不在区域编号内的），则识别为路过行为
     */
    private boolean ruleFive()
    {
        boolean flag = false;
        if (this.lastBehavior.getBehavior() == BehaviorConstants.BEHAVIOR_LEAVE_SHOP || this.lastBehavior.getBehavior() == BehaviorConstants.BEHAVIOR_NULL)
        {
            if (this.isInValidPositionID(this.position.getPositionId()))
            {
                if (this.list != null && this.list.size() >= 4)
                {
                    int p = 1;
                    for (int i = this.list.size() - 1; i >= this.list.size() - 4; i--)
                    {
                        PositionCache obj = this.list.get(i);
                        if (this.isInValidPositionID(obj.getPositionId()))
                        {
                            p++;
                        }
                    }
                    if (p == 5)
                    {
                        flag = true;
                        this.behavior = BehaviorConstants.BEHAVIOR_GO_PAST_SHOP;
                    }
                }
            }
        }
        return flag;
    }

    /**
     * 规则六：遍历缓存中的所有用户数据,该规则1分钟检查一次
     * 1、如果用户上一位置信息距现在1分钟以上，并且上一行为是到店或到区域正常行为，并且缓存中最新5条位置信息中有为室外的信息，并且没有正常区域的信息，则识别为离店
     * 2、如果用户上一位置信息距现在5分钟以上，并且之前跟店内没有任何行为，则识别为路过
     */
    private boolean ruleSix()
    {
        boolean flag = false;
        if (lastCheckTime == 0 || Calendar.getInstance().getTime().getTime() - lastCheckTime > 60000)
        {
            RedisDatabase redisDB = new RedisDatabase(RedisConstants.business_behavior_anls);
            RedisObjectDao objDao = new RedisObjectDao(RedisConstants.business_behavior_anls);
            String pattern = BehaviorConstants.CACHE_PREFIX_POSITION_LIST + "*";
            Set<String> keys = redisDB.keys(pattern);
            for (String key : keys)
            {
                ArrayList<PositionCache> cacheList = (ArrayList<PositionCache>) objDao.get(key);
                if (cacheList != null && cacheList.size() > 5)
                {
                    PositionCache pc = cacheList.get(cacheList.size() - 1);
                    PositionCache cacheObj = (PositionCache) objDao.get(BehaviorConstants.CACHE_PREFIX_BEHAVIOR + pc.getMac());

                    if (Calendar.getInstance().getTime().getTime() - pc.getTime() > 300000)
                    {
                        if (BehaviorConstants.BEHAVIOR_NULL == cacheObj.getBehavior() || BehaviorConstants.BEHAVIOR_NULL.equals(cacheObj.getBehavior()))
                        {
                            this.behavior = BehaviorConstants.BEHAVIOR_GO_PAST_SHOP;
                        }

                    }
                    else if (Calendar.getInstance().getTime().getTime() - pc.getTime() > 60000)
                    {
                        if (BehaviorConstants.BEHAVIOR_ARR_SHOP == cacheObj.getBehavior() || BehaviorConstants.BEHAVIOR_ARR_SHOP.equals(cacheObj.getBehavior()) || BehaviorConstants.BEHAVIOR_ARR_AREA == cacheObj.getBehavior() || BehaviorConstants.BEHAVIOR_ARR_AREA.equals(cacheObj.getBehavior()))
                        {
                            for (int i = 1; i < 5; i++)
                            {
                                PositionCache record = cacheList.get(cacheList.size() - i);
                                if (this.isInValidPositionID(record.getPositionId()) || this.isOutsideShop(record.getGridAttribute()))
                                {
                                    this.behavior = BehaviorConstants.BEHAVIOR_LEAVE_SHOP;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    /**
     * 判断位置编号是不是有效的区域，排除在店门外这样的特殊区域
     */
    private boolean isValidPositionID(String positionId, char isOutside)
    {
        if (positionId == null || "" == positionId || "".equals(positionId) || '1' != isOutside)
        {
            return false;
        }
        return true;
    }

    /**
     * 判断位置编号是不是无效的区域，排除在店门口外这样的特殊区域
     */
    private boolean isInValidPositionID(String positionId)
    {
        if (positionId == null || "" == positionId || "".equals(positionId))
        {
            return true;
        }
        return false;
    }

    /**
     * 判断是不是店门外特殊区域
     */
    private boolean isOutsideShop(char isOutside)
    {
        if ('1' == isOutside)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * 从缓存中取特定用户的位置轨迹
     */
    private ArrayList<PositionCache> getListByMac(String mac)
    {
        RedisObjectDao objDao = new RedisObjectDao(RedisConstants.business_behavior_anls);
        ArrayList<PositionCache> list = (ArrayList<PositionCache>) objDao.get(BehaviorConstants.CACHE_PREFIX_POSITION_LIST + mac);
        if (list == null)
        {
            list = new ArrayList<PositionCache>();
        }
        return list;
    }

    /**
     * 从缓存中取特定用户的行为
     */
    private PositionCache getLastBehaviorByMac(String mac)
    {
        RedisObjectDao objDao = new RedisObjectDao(RedisConstants.business_behavior_anls);
        PositionCache pc = (PositionCache) objDao.get(BehaviorConstants.CACHE_PREFIX_BEHAVIOR + mac);
        if (pc == null)
        {
            pc = new PositionCache();
            pc.setMac(this.position.getMac());
            pc.setPositionId(this.position.getPositionId());
            pc.setGridAttribute(this.position.getGridAttribute());
            pc.setTime(Calendar.getInstance().getTime().getTime());
            pc.setEntityId(this.position.getEntityId());
            pc.setBehavior(BehaviorConstants.BEHAVIOR_NULL);

            objDao.set(BehaviorConstants.CACHE_PREFIX_BEHAVIOR + this.position.getMac(), pc);
        }
        return pc;
    }

    /**
     * 更新缓存中的行为
     */
    private void putLastBehavior()
    {
        this.lastBehavior.setMac(this.position.getMac());
        this.lastBehavior.setPositionId(this.position.getPositionId());
        this.lastBehavior.setBehavior(this.behavior);
        this.lastBehavior.setGridAttribute(this.position.getGridAttribute());
        this.lastBehavior.setTime(Calendar.getInstance().getTime().getTime());
        this.lastBehavior.setEntityId(this.position.getEntityId());

        RedisObjectDao objDao = new RedisObjectDao(RedisConstants.business_behavior_anls);
        objDao.set(BehaviorConstants.CACHE_PREFIX_BEHAVIOR + this.lastBehavior.getMac(), this.lastBehavior);
    }

    /**
     * 更新缓存中的位置轨迹
     */
    private void putPositionCache()
    {
        ArrayList<PositionCache> newList = this.list;
        newList.add(this.lastBehavior);
        if (newList.size() >= ConfigConstants.USER_POSITION_CACHE_SIZE)
        {
            newList.remove(0);
        }

        RedisObjectDao objDao = new RedisObjectDao(RedisConstants.business_behavior_anls);

        PositionEngineLog.debug("[" + this.getClass().getSimpleName() + "]PositionCache:" + new Gson().toJson(newList));
        objDao.set(BehaviorConstants.CACHE_PREFIX_POSITION_LIST + this.position.getMac(), newList);
    }
}
