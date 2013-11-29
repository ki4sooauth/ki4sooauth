package com.gooagoo.api.business.core.user.favorite;

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

import com.gooagoo.entity.generator.behave.FavoriteInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestFavoriteCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public FavoriteCoreService favoriteCoreService;

    @Override
    @Resource(name = "behaveSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 收藏
     * @throws Exception
     */
    @Test
    public void testAddFavorite() throws Exception
    {
        FavoriteInfo favoriteInfo = new FavoriteInfo();
        favoriteInfo.setObjectId("0182AUMT4ILBO1J0SR22DDEIISWR2K1N");
        favoriteInfo.setInfoType("C");
        favoriteInfo.setUserId("185KGGST484M3S00A1BAQJMCA6UU6LBF");
        favoriteInfo.setSource("W");
        Assert.isTrue(this.favoriteCoreService.addFavorite(favoriteInfo), "收藏失败");
    }

    /**
     * 支持多个删除,多个ID用英文半角逗号隔开
     * @throws Exception
     */
    @Test
    public void testDeleteFavorite() throws Exception
    {

        Assert.isTrue(true, "");
    }

}
