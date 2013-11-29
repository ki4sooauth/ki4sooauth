package com.gooagoo.core.business.shop.auth;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.shop.auth.ShopRoleCoreService;
import com.gooagoo.api.generator.core.shop.ShopRoleAuthorityGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopRoleGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.ShopRole;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority;
import com.gooagoo.entity.generator.shop.ShopRoleAuthorityExample;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class ShopRoleCoreServiceImpl implements ShopRoleCoreService
{
    @Autowired
    private ShopRoleGeneratorCoreService shopRoleGeneratorCoreService;
    @Autowired
    private ShopRoleAuthorityGeneratorCoreService shopRoleAuthorityGeneratorCoreService;

    @Override
    public boolean addShopRole(ShopRole shopRole) throws Exception
    {
        shopRole.setIsDel("N");
        return this.shopRoleGeneratorCoreService.insertSelective(shopRole);
    }

    @Override
    public boolean updateShopRole(ShopRole shopRole) throws Exception
    {
        return this.shopRoleGeneratorCoreService.updateByPrimaryKeySelective(shopRole);
    }

    @Override
    public boolean deleteShopRole(String id) throws Exception
    {
        if (!StringUtils.hasText(id))
        {
            GooagooLog.warn("删除商家角色：Id为空");
            return false;
        }
        return this.shopRoleGeneratorCoreService.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean bindAuths(String roleId, List<String> authIdList) throws Exception
    {
        if (!StringUtils.hasText(roleId))
        {
            GooagooLog.warn("角色绑定权限：roleId为空");
            return false;
        }

        Map<String, String> roleAuthMap = new HashMap<String, String>();//key:authorityId,value:A-添加，N+ID-修改，Y+ID-删除
        //查询角色权限关联的历史数据
        ShopRoleAuthorityExample shopRoleAuthorityExample = new ShopRoleAuthorityExample();
        shopRoleAuthorityExample.createCriteria().andRoleIdEqualTo(roleId);
        List<ShopRoleAuthority> roleAuths = this.shopRoleAuthorityGeneratorCoreService.selectByExample(shopRoleAuthorityExample);
        //历史数据处理：添加的权限若存在于历史数据使用历史数据
        for (Iterator<ShopRoleAuthority> iterator = roleAuths.iterator(); iterator.hasNext();)
        {
            ShopRoleAuthority ra = iterator.next();
            String authId = ra.getAuthorityId();
            if (!authIdList.contains(authId))
            {
                roleAuthMap.put(authId, "Y" + ra.getSysRoleAuthorityId());
            }
            else if ("Y".equals(ra.getIsDel()))
            {
                roleAuthMap.put(authId, "N" + ra.getSysRoleAuthorityId());
                authIdList.remove(authId);
            }
            else
            {
                authIdList.remove(authId);
            }
        }
        //添加历史数据中没有的权限，重复的不处理
        for (Iterator<String> iterator = authIdList.iterator(); iterator.hasNext();)
        {
            String authId = iterator.next();
            if (!roleAuthMap.containsKey(authId))
            {
                roleAuthMap.put(authId, "A");
            }
        }
        //根据权限数据类型进行数据保存操作
        for (Iterator<String> iterator = roleAuthMap.keySet().iterator(); iterator.hasNext();)
        {
            String key = iterator.next();
            String value = roleAuthMap.get(key);
            ShopRoleAuthority shopRoleAuthority = new ShopRoleAuthority();
            shopRoleAuthority.setAuthorityId(key);
            shopRoleAuthority.setRoleId(roleId);
            boolean isOk = false;
            if ("A".equals(value))
            {
                shopRoleAuthority.setSysRoleAuthorityId(com.gooagoo.common.utils.StringUtils.getUUID());
                shopRoleAuthority.setIsDel("N");
                isOk = this.shopRoleAuthorityGeneratorCoreService.insertSelective(shopRoleAuthority);
            }
            else
            {
                shopRoleAuthority.setSysRoleAuthorityId(value.substring(1));
                shopRoleAuthority.setIsDel(value.substring(0, 1));
                isOk = this.shopRoleAuthorityGeneratorCoreService.updateByPrimaryKeySelective(shopRoleAuthority);
            }
            if (!isOk)
            {
                GooagooLog.warn("角色绑定权限保存数据失败:mapValue=" + value + ",obj=" + new Gson().toJson(shopRoleAuthority));
                throw new OperateFailException("角色绑定权限保存数据失败");
            }
        }
        return true;
    }
}
