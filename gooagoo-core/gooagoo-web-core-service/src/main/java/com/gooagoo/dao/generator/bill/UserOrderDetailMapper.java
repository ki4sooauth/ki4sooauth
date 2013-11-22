package com.gooagoo.dao.generator.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.bill.UserOrderDetail;
import com.gooagoo.entity.generator.bill.UserOrderDetailExample;
import com.gooagoo.entity.generator.bill.UserOrderDetailKey;

public interface UserOrderDetailMapper
{

    public Integer countByExample(UserOrderDetailExample userOrderDetailExample);

    public List<UserOrderDetail> selectByExample(UserOrderDetailExample userOrderDetailExample);

    public UserOrderDetail selectByPrimaryKey(UserOrderDetailKey userOrderDetailKey);

    public Integer deleteByExample(UserOrderDetailExample userOrderDetailExample);

    public Integer deleteByPrimaryKey(UserOrderDetailKey userOrderDetailKey);

    public Integer insertSelective(UserOrderDetail userOrderDetail);

    public Integer updateAllByExample(@Param("record") UserOrderDetail userOrderDetail, @Param("example") UserOrderDetailExample userOrderDetailExample);

    public Integer updateByExampleSelective(@Param("record") UserOrderDetail userOrderDetail, @Param("example") UserOrderDetailExample userOrderDetailExample);

    public Integer updateByPrimaryKeySelective(UserOrderDetail userOrderDetail);

}
