package com.gooagoo.api.business.core.system.cms;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestSysCmsContentCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public SysCmsContentCoreService sysCmsContentCoreService;

    @Override
    @Resource(name = "sysSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 发布CMS内容信息
     * @throws Exception 
     */
    @Test
    public void testPublishCmsContent() throws Exception
    {
        String cmsContentId = "183LUM0UFFG0TN2G8PEQCP2DQU294DTO";
        Assert.isTrue(this.sysCmsContentCoreService.publishCmsContent(cmsContentId), "发布CMS内容信息失败");
    }

    /**
     * 删除CMS内容信息
     * @throws Exception 
     */
    @Test
    public void testDeleteCmsContent() throws Exception
    {
        String cmsContentId = "183JV8V7HKELI12K0IJBFOR5K94H0EU8";
        Assert.isTrue(this.sysCmsContentCoreService.deleteCmsContent(cmsContentId), "删除CMS内容信息失败");
    }

}
