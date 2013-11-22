package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gooagoo.batch.task.service.QueryVersionService;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleResult;

public class Test2
{

    public static void main(String[] args)
    {
        try
        {
            ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml", "hessian-query-generator-client.xml");
            QueryVersionService service = (QueryVersionService) ctx.getBean("queryVersionServiceImpl");
            List<RuleResult> list = service.queryRuleResultCache();
            System.out.println("规则结果");
            for (RuleResult ruleResult : list)
            {
                System.out.println(ruleResult);
            }
            System.out.println("规则");
            List<RuleInfo> list2 = service.queryRuleInfoCache();
            for (RuleInfo ruleInfo : list2)
            {
                System.out.println(ruleInfo);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
