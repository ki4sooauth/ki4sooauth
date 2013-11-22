package com.gooagoo.api.business.query.transaction.order;

import java.util.Date;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.transaction.OrderDetailInfo4TableBusiness;
import com.gooagoo.entity.business.transaction.OrderInfoBusiness;
import com.gooagoo.entity.business.transaction.PurchasedGoodsBusiness;

public class TestOrderQueryService
{

    public OrderQueryService orderQueryService;

    @Before
    public void testBefore()
    {
        this.orderQueryService = ApplicationContextUtils.getBean(OrderQueryService.class);
    }

    /**
     * mobe07,gasj04
     * @throws Exception
     */
    @Test
    public void testFindOrderListByTable() throws Exception
    {
        String shopEntityId = "01822RQE55T0DTK00BTACIBJ444KG9GO";
        String deskName = "1";
        String roomName = "二号";
        Integer pageIndex = null;
        Integer pageSize = null;
        OrderDetailInfo4TableBusiness orderDetailInfo4TableBusiness = this.orderQueryService.findOrderListByTable(shopEntityId, deskName, roomName, pageIndex, pageSize);
        Assert.assertTrue("通过桌号获取点菜单信息 失败", CollectionUtils.isNotEmpty(orderDetailInfo4TableBusiness.getOrderDetailInfoList()));
    }

    /**
     * gtsc02,mobe01,mobe16
     * @throws Exception
     */
    @Test
    public void testFindOrderListForAll() throws Exception
    {
        String orderId = null;
        String scardno = null;
        String userId = "01822RBQ22JSDMA085QBV8EIISWR0JGT";
        String shopId = null;
        String shopEntityId = null;
        String cTimeStamp = null;
        String billType = "O";
        String date = null;
        String pageId = "2013100000002003";
        String pageType = "P";
        Integer pageSize = 3;
        //        OrderLinkDetailInfoBusiness orderLinkDetailInfoBusiness = this.orderQueryService.findOrderListForAll(userId, shopId, orderId, scardno, shopEntityId, cTimeStamp, billType, date, pageId, pageType, pageSize);
        //        Assert.assertTrue("用户获取账单信息失败", CollectionUtils.isNotEmpty(orderLinkDetailInfoBusiness.getOrderDetailInfoBusiness()));
    }

    /**
     * 4.3.5. 统计用户电子账单数量
     * @throws Exception
     */
    @Test
    public void testCountOrderList() throws Exception
    {
        String userId = "01822RBQ22JSDMA085QBV8EIISWR0JGT";
        String shopId = null;
        Date begin = TimeUtils.convertStringToDate("2013-10-12 11:29:00");
        Date end = TimeUtils.convertStringToDate("2013-10-12 11:40:00");
        String goodsName = null;
        Integer count = this.orderQueryService.countOrderList(userId, shopId, begin, end, goodsName);
        Assert.assertTrue("统计用户电子账单数量失败", count != null && count > 0);
    }

    /**
     * 4.3.5. 用户查询电子账单列表（分页）
     * @throws Exception
     */
    @Test
    public void testFindOrderList() throws Exception
    {
        String userId = "01822RBQ22JSDMA085QBV8EIISWR0JGT";
        String shopId = null;
        Date begin = null;
        Date end = null;
        String goodsName = null;
        Integer pageIndex = 2;
        Integer pageSize = 8;
        String orderBy = "request_time desc";
        List<OrderInfoBusiness> orderInfoBusinessList = this.orderQueryService.findOrderList(userId, shopId, begin, end, goodsName, pageIndex, pageSize, orderBy);
        Assert.assertTrue("用户查询电子账单列表失败", CollectionUtils.isNotEmpty(orderInfoBusinessList));
    }

    /**
     * 根据用户账单ID查询
     * @throws Exception
     */
    @Test
    public void testFindOrderDetail() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * gase03
     * @throws Exception
     */
    @Test
    public void testFindOrderListInShopEntity() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * gase04
     * @throws Exception
     */
    @Test
    public void testFindOrderDetailInShopEntity() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * gtsc18:商家查询重量确认
     * @throws Exception
     */
    @Test
    public void testFindConfirmWeight() throws Exception
    {
        String mac = "00:00:00:00:00:fe";
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String ctimestamp = null;
        List<Map<String, String>> list = this.orderQueryService.findConfirmWeight(mac, shopEntityId, ctimestamp);
        Assert.assertTrue("商家查询重量确认失败", CollectionUtils.isNotEmpty(list));
    }

    /**
     * gtsc23:商家查询修改台头请求
     * @throws Exception
     */
    @Test
    public void testFindDiningNumbers() throws Exception
    {
        String mac = "00:00:00:00:00:fe";
        String shopentityid = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String cTimeStamp = null;
        List<Map<String, String>> list = this.orderQueryService.findDiningNumbers(mac, shopentityid, cTimeStamp);
        Assert.assertTrue("商家查询修改台头请求失败", CollectionUtils.isNotEmpty(list));
    }

    /**
     * mobk03:已购买过的商品 
     */
    @Test
    public void testFindBoughtGoods() throws Exception
    {
        String userId = "01822RBQ22JSDMA085QBV8EIISWR0JGT";
        String shopId = null;
        String shopType = null;
        String shopEntityId = null;
        String goodsName = null;
        String begin = null;
        String end = null;
        Integer pageIndex = 1;
        Integer pageSize = 20;
        List<PurchasedGoodsBusiness> list = this.orderQueryService.findBoughtGoods(userId, shopId, shopType, shopEntityId, goodsName, begin, end, pageIndex, pageSize);
        Assert.assertTrue("查询已购买过的商品失败", CollectionUtils.isNotEmpty(list));
    }
}
