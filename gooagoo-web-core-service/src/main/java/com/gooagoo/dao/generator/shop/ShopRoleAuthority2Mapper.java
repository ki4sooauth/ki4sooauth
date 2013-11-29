package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopRoleAuthority2;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2Example;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2Key;

public interface ShopRoleAuthority2Mapper
{

    public Integer countByExample(ShopRoleAuthority2Example shopRoleAuthority2Example);

    public List<ShopRoleAuthority2> selectByExample(ShopRoleAuthority2Example shopRoleAuthority2Example);

    public ShopRoleAuthority2 selectByPrimaryKey(ShopRoleAuthority2Key shopRoleAuthority2Key);

    public Integer deleteByExample(ShopRoleAuthority2Example shopRoleAuthority2Example);

    public Integer deleteByPrimaryKey(ShopRoleAuthority2Key shopRoleAuthority2Key);

    public Integer insertSelective(ShopRoleAuthority2 shopRoleAuthority2);

    public Integer updateAllByExample(@Param("record") ShopRoleAuthority2 shopRoleAuthority2, @Param("example") ShopRoleAuthority2Example shopRoleAuthority2Example);

    public Integer updateByExampleSelective(@Param("record") ShopRoleAuthority2 shopRoleAuthority2, @Param("example") ShopRoleAuthority2Example shopRoleAuthority2Example);

    public Integer updateByPrimaryKeySelective(ShopRoleAuthority2 shopRoleAuthority2);

}
