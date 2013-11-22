package com.gooagoo.api.business.core.marketing.coupon;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.dao.generator.marketing.CouponMapper;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.CouponExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestCouponCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public CouponCoreService couponCoreService;
    @Autowired
    public CouponMapper couponMapper;

    @Override
    @Resource(name = "marketingSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 6.1.5. 删除优惠凭证
     * @throws Exception
     */
    @Test
    public void testDeleteCoupon() throws Exception
    {
        String id = "1";
        boolean isSucceed = this.couponCoreService.deleteCoupon(id);
        Assert.isTrue(isSucceed, "删除优惠凭证");
    }

    /**
     * 6.1.6. 添加优惠凭证
     * @throws Exception
     */
    @Test
    public void testAddCoupon() throws Exception
    {
        Coupon coupon = new Coupon();
        coupon.setCouponId("3");
        coupon.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        coupon.setAmount(1);
        coupon.setAuditNote("");
        coupon.setCheckJson("");
        coupon.setCouponChannle("1");
        coupon.setCouponName("test");
        coupon.setCouponSource("1");
        coupon.setCouponType("1");
        coupon.setCouponUrl("");
        coupon.setCouponMode("0");
        coupon.setCouponValue(1.0);
        coupon.setMaxNumOwner(1);
        coupon.setPublishStartTime(new Date());
        coupon.setPublishEndTime(new Date());
        coupon.setUseStartTime(new Date());
        coupon.setUseEndTime(new Date());
        coupon.setCouponContent("");
        boolean isSucceed = this.couponCoreService.addCoupon(coupon, null);
        Assert.isTrue(isSucceed, "添加优惠凭证");
    }

    /**
     * 修改优惠凭证
     * @throws Exception
     */
    @Test
    public void testUpdateCoupon() throws Exception
    {
        String json = "{\"couponId\":\"186GIS87EH5AKO08C1N5G7OI474P43QA\",\"couponName\":\"32423\",\"shopId\":\"01822R97QK2FRDT085QBV2EIISWR0JGT\",\"publishStartTime\":\"Oct 25, 2013 12:00:00 AM\",\"publishEndTime\":\"Oct 26, 2013 11:59:59 PM\",\"useStartTime\":\"Oct 25, 2013 12:00:00 AM\",\"useEndTime\":\"Oct 26, 2013 11:59:59 PM\",\"couponMode\":\"2\",\"couponType\":\"D\",\"couponValue\":0.7,\"amount\":7,\"maxNumOwner\":1,\"couponUrl\":\"http://img.gooagoo.com/marketing/2013/10/10/E7E4E0CED698BEBB147B236CFC2E0ACD.jpg\",\"couponContent\":\"DSFSADFJHGHJGH\",\"couponChannle\":\"1\",\"couponSource\":\"0\",\"publishStatus\":\"W\",\"isDel\":\"N\",\"createTime\":\"Oct 10, 2013 3:04:19 PM\",\"cTimeStamp\":\"Oct 11, 2013 1:41:20 PM\"}";
        Coupon coupon = JsonUtils.toObj(json, Coupon.class);
        coupon.setCheckJson("{\"categoryData\":[],\"shopEntityData\":[],\"vipGradeData\":[],\"categoryNames\":[],\"shopEntityNames\":[],\"vipGradeNames\":[]}");
        List<String> couponNoList = JsonUtils.json2List("[12213, 123123, 123123, 123123, 777, 7777, 7777, 7777]");
        boolean isSucceed = this.couponCoreService.updateCoupon(coupon, couponNoList);
        Assert.isTrue(isSucceed, "修改优惠凭证");
    }

    /**
     * 6.4.3. 审核优惠凭证
     * @throws Exception
     */
    @Test
    public void testReviewedCoupon() throws Exception
    {
        String id = "00017Q9QHK01H1NCL00002SXUXJ1T002";
        boolean isSucceed = this.couponCoreService.reviewedCoupon(id, "Y", "");
        Assert.isTrue(isSucceed, "审核优惠凭证");
    }

    /**
     * 6.4.4. 发布优惠凭证
     * @throws Exception
     */
    @Test
    public void testPublishCoupon() throws Exception
    {
        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andPublishStatusEqualTo("P").andIsDelEqualTo("N");
        List<Coupon> couponList = this.couponMapper.selectByExample(couponExample);
        Assert.isTrue(CollectionUtils.isNotEmpty(couponList), "批量发布优惠券失败");
        List<String> couponIdList = new ArrayList<String>();
        for (Coupon coupon : couponList)
        {
            couponIdList.add(coupon.getCouponId());
        }
        Coupon coupon = new Coupon();
        coupon.setPublishStatus("A");
        couponExample = new CouponExample();
        couponExample.createCriteria().andCouponIdIn(couponIdList);
        Assert.isTrue(this.couponMapper.updateByExampleSelective(coupon, couponExample) == couponIdList.size(), "批量更新优惠券发布状态失败");
        for (String couponId : couponIdList)
        {
            Assert.isTrue(this.couponCoreService.publishCoupon(couponId), "生成优惠券静态页面失败[couponId=" + couponId + "]");
        }
    }

    /**
     * gtsc08:商家确认优惠凭证是否可用
     * @throws Exception
     */
    @Test
    public void testConfirmCoupon() throws Exception
    {

        Assert.isTrue(true, "");
    }

}
