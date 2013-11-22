package com.gooagoo.api.business.core.goods.cache;

import java.util.Map;

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
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class TestGoodsCacheCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public GoodsCacheCoreService goodsCacheCoreService;

    @Override
    @Resource(name = "goodsSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 查询商品信息
     * @throws Exception
     */
    @Test
    public void testFindGoodsInfo() throws Exception
    {
        String goodsId = "0182AMK595EU58100B5M1KBJ11W37380";
        Map<String, String> cache = this.goodsCacheCoreService.findGoodsInfo(goodsId);
        Assert.isTrue(cache != null && cache.size() > 0, "redis获取商品信息失败");
    }

    /**
     * 查询商品品类
     * @throws Exception
     */
    @Test
    public void testFindGoodsCategory() throws Exception
    {

        Assert.isTrue(true, "");
    }

}
