package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopRoleAuthority2;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2Example;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2Key;

public interface ShopRoleAuthority2Mapper
{

    public Integer countByExample(ShopRoleAuthority2Example shopRoleAuthority2Example);

    public List<ShopRoleAuthority2> selectByExample(ShopRoleAuthority2Example shopRoleAuthority2Example);

    public ShopRoleAuthority2 selectByPrimaryKey(ShopRoleAuthority2Key shopRoleAuthority2Key);

}
