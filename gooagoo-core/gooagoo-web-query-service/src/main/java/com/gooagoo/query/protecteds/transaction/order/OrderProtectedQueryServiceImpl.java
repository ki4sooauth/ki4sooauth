package com.gooagoo.query.protecteds.transaction.order;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.bill.OrderPicGeneratorQueryService;
import com.gooagoo.api.protecteds.query.transaction.order.OrderProtectedQueryService;
import com.gooagoo.entity.generator.bill.OrderPic;
import com.gooagoo.entity.generator.bill.OrderPicExample;
import com.gooagoo.entity.generator.bill.OrderPicExample.Criteria;

@Service
public class OrderProtectedQueryServiceImpl implements OrderProtectedQueryService
{

    @Autowired
    OrderPicGeneratorQueryService orderPicGeneratorQueryService;

    @Override
    public String getShopAuthorities(String orderId, String billType)
    {
        OrderPicExample orderPicExample = new OrderPicExample();
        Criteria criteria = orderPicExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        //账单
        if ("3".equals(billType))
        {
            criteria.andPicTypeEqualTo("1");
        }
        //订单 多个逗号分开
        else
        {
            criteria.andPicTypeEqualTo("0");
        }
        List<OrderPic> orderPicList = this.orderPicGeneratorQueryService.selectByExample(orderPicExample);
        if (CollectionUtils.isNotEmpty(orderPicList))
        {
            String billimg = "";
            for (OrderPic orderPic : orderPicList)
            {
                billimg += orderPic.getPicUrl() + ",";
            }
            return billimg.substring(0, billimg.length() - 1);
        }
        return null;
    }

}
