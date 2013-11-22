package com.gooagoo.query.business.user.cache.subTask;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

import org.springframework.util.StringUtils;

import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.business.marketing.rule.ActionAttribute;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.redis.data.RedisSortedSetDao;

public class AttentionTask implements Callable<Set<Account>>
{
    private String shopId;
    private ActionAttribute actionAttribute;

    public AttentionTask(String shopId, ActionAttribute actionAttribute)
    {
        super();
        this.shopId = shopId;
        this.actionAttribute = actionAttribute;
    }

    @Override
    public Set<Account> call() throws Exception
    {
        return query();
    }

    public Set<Account> query()
    {
        Set<Account> accounts = new HashSet<Account>();
        String source = actionAttribute.getActionSource();
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_attention);
        String key = shopId;
        if (StringUtils.hasText(source))
        {
            key = key + "_" + source;
        }
        Set<String> members = sortedSetDao.zrangeByScore(key, timestamp(actionAttribute.getDateStart()), timestamp(actionAttribute.getDateEnd()) + 86399999);
        for (String string : members)
        {
            accounts.add(new Account(string));
        }
        return accounts;
    }

    private long timestamp(String date)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(date).getTime();
        }
        catch (Exception e)
        {
            return 0;
        }
    }
}
