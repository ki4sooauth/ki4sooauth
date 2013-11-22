package com.gooagoo.core.business.shop.auth;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.shop.auth.ShopRole2CoreService;
import com.gooagoo.api.generator.core.shop.ShopRole2GeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopRoleAuthority2GeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopUserRole2GeneratorCoreService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.shop.ShopRole2;
import com.gooagoo.entity.generator.shop.ShopRole2Example;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2Example;
import com.gooagoo.entity.generator.shop.ShopUserRole2;

public class ShopRole2CoreServiceImpl implements ShopRole2CoreService
{

    @Autowired
    private ShopRole2GeneratorCoreService shopRole2GeneratorCoreService;

    @Autowired
    private ShopUserRole2GeneratorCoreService shopUserRole2GeneratorCoreService;

    @Autowired
    private ShopRoleAuthority2GeneratorCoreService shopRoleAuthority2GeneratorCoreService;

    @Override
    public boolean addShopRole2(ShopRole2 shopRole2) throws Exception
    {
        shopRole2.setRoleId(UUID.getUUID());
        shopRole2.setIsDel("N");
        return this.shopRole2GeneratorCoreService.insertSelective(shopRole2);
    }

    @Override
    public boolean updateShopRole2(ShopRole2 shopRole2) throws Exception
    {
        return this.shopRole2GeneratorCoreService.updateByPrimaryKeySelective(shopRole2);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean deleteShopRole2(String roleIds) throws Exception
    {
        List<String> idList = Arrays.asList(roleIds.split(","));
        //删除该角色关联权限
        ShopRoleAuthority2 shopRoleAuthority2 = new ShopRoleAuthority2();
        shopRoleAuthority2.setIsDel("N");
        ShopRoleAuthority2Example shopRoleAuthority2Example = new ShopRoleAuthority2Example();
        shopRoleAuthority2Example.createCriteria().andRoleIdIn(idList).andIsDelEqualTo("N");
        this.shopRoleAuthority2GeneratorCoreService.updateByExampleSelective(shopRoleAuthority2, shopRoleAuthority2Example);
        //删除角色
        ShopRole2Example shopRole2Example = new ShopRole2Example();
        shopRole2Example.createCriteria().andRoleIdIn(idList);
        ShopRole2 shopRole2 = new ShopRole2();
        shopRole2.setIsDel("Y");
        return this.shopRole2GeneratorCoreService.updateByExampleSelective(shopRole2, shopRole2Example);
    }

    @Override
    public boolean allotShopRole(ShopUserRole2 shopUserRole2) throws Exception
    {
        ShopUserRole2 oldShopUserRole2 = this.shopUserRole2GeneratorCoreService.selectByPrimaryKey(shopUserRole2.getShopId());
        if (oldShopUserRole2 != null)
        {
            oldShopUserRole2.setRoleId(shopUserRole2.getRoleId());
            oldShopUserRole2.setIsDel(shopUserRole2.getIsDel());
            this.shopUserRole2GeneratorCoreService.updateByPrimaryKeySelective(oldShopUserRole2);
        }
        else
        {
            shopUserRole2.setIsDel("N");
            this.shopUserRole2GeneratorCoreService.insertSelective(shopUserRole2);
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean allotShopRoleAuth(String roleId, String[] authorityIdArr) throws Exception
    {
        ShopRoleAuthority2Example shopRoleAuthority2Example = new ShopRoleAuthority2Example();
        shopRoleAuthority2Example.createCriteria().andRoleIdEqualTo(roleId);
        this.shopRoleAuthority2GeneratorCoreService.deleteByExample(shopRoleAuthority2Example);
        for (int i = 0; i < authorityIdArr.length; i++)
        {
            ShopRoleAuthority2 shopRoleAuthority2 = new ShopRoleAuthority2();
            shopRoleAuthority2.setId(UUID.getUUID());
            shopRoleAuthority2.setRoleId(roleId);
            shopRoleAuthority2.setAuthorityId(authorityIdArr[i]);
            shopRoleAuthority2.setIsDel("N");
            this.shopRoleAuthority2GeneratorCoreService.insertSelective(shopRoleAuthority2);
        }
        return true;
    }
}
