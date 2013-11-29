package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.OrderPic;
import com.gooagoo.entity.generator.bill.OrderPicExample;
import com.gooagoo.entity.generator.bill.OrderPicKey;

public interface OrderPicMapper
{

    public Integer countByExample(OrderPicExample orderPicExample);

    public List<OrderPic> selectByExample(OrderPicExample orderPicExample);

    public OrderPic selectByPrimaryKey(OrderPicKey orderPicKey);

    public Integer deleteByExample(OrderPicExample orderPicExample);

    public Integer deleteByPrimaryKey(OrderPicKey orderPicKey);

    public Integer insertSelective(OrderPic orderPic);

    public Integer updateAllByExample(@Param("record") OrderPic orderPic, @Param("example") OrderPicExample orderPicExample);

    public Integer updateByExampleSelective(@Param("record") OrderPic orderPic, @Param("example") OrderPicExample orderPicExample);

    public Integer updateByPrimaryKeySelective(OrderPic orderPic);

}
