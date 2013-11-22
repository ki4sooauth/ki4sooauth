package com.gooagoo.query.business.user.cache.subTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.statistics.CrowdOperationQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.marketing.rule.ActionAttribute;
import com.gooagoo.entity.business.marketing.rule.HistoryCondition;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.utils.ApplicationContextUtils;

public class UserQueryCentreTask
{
    CrowdOperationQueryService service = ApplicationContextUtils.getBean(CrowdOperationQueryService.class);

    public Set<Account> query(String shopId, HistoryCondition historyCondition)
    {
        Set<Account> accounts = nature(shopId, historyCondition);
        List<String> userIds = new ArrayList<String>();
        if (accounts != null && accounts.size() > 0 && accounts.size() < 10)
        {
            for (Account account : accounts)
            {
                if (StringUtils.hasText(account.getUserId()))
                {
                    userIds.add(account.getUserId());
                }
            }
        }
        List<Future<Set<Account>>> futures = subTask(shopId, historyCondition, userIds.toArray(new String[0]));
        Set<Account> history = null;
        if (StringUtils.hasText(historyCondition.getCrowdId()))
        {
            history = service.getAccountsByGroupID(historyCondition.getCrowdId());
            accounts.addAll(history);
        }
        Set<Account> intersectionAccounts = intersection(futures, accounts, history);
        return intersectionAccounts;
    }

    private Set<Account> intersection(List<Future<Set<Account>>> futures, Set<Account> accounts, Set<Account> history)
    {
        Set<Account> theSmail = accounts;
        try
        {
            List<Set<Account>> accountList = new ArrayList<Set<Account>>();
            for (Future<Set<Account>> future : futures)
            {
                Set<Account> account = future.get();
                if (theSmail == null)
                {
                    theSmail = account;
                }
                else if (theSmail.size() > account.size())
                {
                    accountList.add(theSmail);
                    theSmail = account;
                }
                else
                {
                    accountList.add(account);
                }
            }
            //开始取交集

            for (Set<Account> otherAccount : accountList)
            {
                theSmail.retainAll(otherAccount);
            }
            if (history != null)
            {
                theSmail.retainAll(history);
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("交集运算", e);
        }
        return theSmail;
    }

    private Set<Account> nature(String shopId, HistoryCondition historyCondition)
    {
        Set<Account> accounts = null;
        if (historyCondition.getNaturalAttribute() != null)
        {
            NaturalTask naturalTask = new NaturalTask();
            accounts = naturalTask.query(shopId, historyCondition.getNaturalAttribute());
        }
        return accounts;
    }

    private List<Future<Set<Account>>> subTask(String shopId, HistoryCondition historyCondition, String[] userIds)
    {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future<Set<Account>>> taskList = new ArrayList<Future<Set<Account>>>();
        for (ActionAttribute attribute : historyCondition.getList())
        {
            char type = attribute.getActionType().charAt(0);
            switch (type)
            {
                case '0':
                    taskList.add(pool.submit(new BillTask(shopId, attribute, userIds)));//消费
                    break;
                case '1':
                    taskList.add(pool.submit(new StoreTask(shopId, attribute, userIds)));//到店
                    break;
                case '2':
                    taskList.add(pool.submit(new AreaTask(shopId, attribute, userIds)));//到区域
                    break;
                case '3':
                    taskList.add(pool.submit(new AttentionTask(shopId, attribute)));//关注
                    break;
                case '4':
                    taskList.add(pool.submit(new ApplyMemberTask(shopId, attribute, userIds)));//申请会员卡
                    break;
                case '5':
                    taskList.add(pool.submit(new ApplyPhysicsTask(shopId, attribute, userIds)));//申请物理卡转换
                    break;
                case '6':
                    taskList.add(pool.submit(new CommentTask(shopId, attribute, userIds)));//评论
                    break;
                case '7':
                    //留言
                    break;
                case '8':
                    taskList.add(pool.submit(new FavoritesTask(shopId, attribute, userIds)));//收藏
                    break;
                case '9':
                    taskList.add(pool.submit(new BrowseTask(shopId, attribute, userIds)));//浏览
                    break;
                case 'A':
                    taskList.add(pool.submit(new UserTools(shopId, attribute, userIds)));//使用服务工具
                    break;
                default:
                    break;
            }
        }
        pool.shutdown();
        return taskList;
    }
}
