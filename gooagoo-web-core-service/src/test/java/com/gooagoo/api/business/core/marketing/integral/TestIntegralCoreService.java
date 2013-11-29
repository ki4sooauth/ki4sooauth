package com.gooagoo.api.business.core.marketing.integral;

import java.util.Date;

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

import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.generator.marketing.ShopIntegral;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvert;
import com.gooagoo.entity.generator.member.IntegralDetailInfo;
import com.gooagoo.redis.data.RedisSortedSetDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class TestIntegralCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public IntegralCoreService integralCoreService;

    @Override
    @Resource(name = "marketingSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 6.3.2. 物品兑换
     * @throws Exception
     */
    @Test
    public void testIntegralExchangeGoods() throws Exception
    {
        ShopIntegralConvert shopIntegralConvert = new ShopIntegralConvert();
        shopIntegralConvert.setUserId("01822RBQ22JSDMA085QBV8EIISWR0JGT");
        shopIntegralConvert.setShopIntegralId("187UPKP2M52BAN00A1BAQJME7CHS6E7Q");
        shopIntegralConvert.setIntegralTradeType("C");
        shopIntegralConvert.setInfoSource("W");
        Assert.isTrue(this.integralCoreService.integralExchangeGoods(shopIntegralConvert), "用户获得积分失败");
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_integral);
        Double score = sortedSetDao.getScore("187UPKP2M52BAN00A1BAQJME7CHS6E7Q", "score");
        System.out.print(score.intValue());
        //System.out.print(this.exchangeStatisticQueryService.marketingTimes("187UPKP2M52BAN00A1BAQJME7CHS6E7Q"));
    }

    /**
     * 6.3.4. 添加积分兑换
     * @throws Exception
     */
    @Test
    public void testAddIntegralExchange() throws Exception
    {
        ShopIntegral shopIntegral = new ShopIntegral();
        shopIntegral.setShopIntegralId("3");
        shopIntegral.setConvertNums(1);
        shopIntegral.setIntegralTradeId("1");
        shopIntegral.setIntegralTradeType("C");
        shopIntegral.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        shopIntegral.setTradeStartTime(new Date());
        shopIntegral.setTradeEndTime(new Date());
        shopIntegral.setTradeIntegralValue(100);
        boolean isSucceed = this.integralCoreService.addIntegralExchange(shopIntegral);
        Assert.isTrue(isSucceed, "添加积分兑换");
    }

    /**
     * 6.3.5. 编辑积分兑换信息
     * @throws Exception
     */
    @Test
    public void testUpdateIntegralExchange() throws Exception
    {
        ShopIntegral shopIntegral = new ShopIntegral();
        shopIntegral.setShopIntegralId("2");
        shopIntegral.setTradeIntegralValue(80);
        boolean isSucceed = this.integralCoreService.updateIntegralExchange(shopIntegral);
        Assert.isTrue(isSucceed, "编辑积分兑换信息");
    }

    /**
     * 6.3.6. 删除积分兑换信息
     * @throws Exception
     */
    @Test
    public void testDeleteIntegralExchange() throws Exception
    {
        boolean isSucceed = this.integralCoreService.deleteIntegralExchange("1");
        Assert.isTrue(isSucceed, "删除积分兑换信息");
    }

    /**
     * 6.3.8. 积分特批操作
     * @throws Exception
     */
    @Test
    public void testIntegralSpecialApproval() throws Exception
    {
        String shopId = "01822R97QK2FRDT085QBV2EIISWR0JGT";
        String userId = "0182COB2TOJ41SG10ME47DEIISWR0HMP";
        String integralNumber = "-500";
        String note = "测试特批减积分";
        Assert.isTrue(this.integralCoreService.integralSpecialApproval(shopId, userId, integralNumber, note), "积分特批操作失败");
    }

    /**
     * 发货状态更新到用户已收取货物
     * @throws Exception
     */
    @Test
    public void testUpdateDeliveryStatusToConfirm() throws Exception
    {
        String shopIntegralId = "1";
        boolean isSucceed = this.integralCoreService.deleteIntegralExchange(shopIntegralId);
        Assert.isTrue(isSucceed, "发货状态更新到用户已收取货物");
    }

    /**
     * 用户获得积分
     * @throws Exception
     */
    @Test
    public void testReceiveIntegral() throws Exception
    {
        IntegralDetailInfo integralDetailInfo = new IntegralDetailInfo();
        integralDetailInfo.setShopId("01822MAPVKNP054085QBQVEIISWR0JGT");
        integralDetailInfo.setUserId("1883FRM0MEJE5800A1BAQJMC3CLLDULQ");
        integralDetailInfo.setIntegralNumber(11000);
        integralDetailInfo.setIntegralSource("0");//消费
        integralDetailInfo.setNote("王宇买了奥迪A4L、加11000积分");
        Assert.isTrue(this.integralCoreService.receiveIntegral(integralDetailInfo), "用户获得积分失败");
    }

}
