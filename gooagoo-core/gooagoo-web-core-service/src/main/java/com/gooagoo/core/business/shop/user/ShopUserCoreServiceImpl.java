package com.gooagoo.core.business.shop.user;

import java.util.ArrayList;
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

import com.gooagoo.api.business.core.shop.user.ShopUserCoreService;
import com.gooagoo.api.generator.core.shop.ShopUserInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopUserRoleGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.ShopUserInfo;
import com.gooagoo.entity.generator.shop.ShopUserRole;
import com.gooagoo.entity.generator.shop.ShopUserRoleExample;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class ShopUserCoreServiceImpl implements ShopUserCoreService
{

    @Autowired
    private ShopUserInfoGeneratorCoreService shopUserInfoGeneratorCoreService;
    @Autowired
    private ShopUserRoleGeneratorCoreService shopUserRoleGeneratorCoreService;

    @Override
    public boolean addShopUserInfo(ShopUserInfo shopUserInfo) throws Exception
    {
        shopUserInfo.setIsDel("N");
        return this.shopUserInfoGeneratorCoreService.insertSelective(shopUserInfo);
    }

    @Override
    public boolean updateShopUserInfo(ShopUserInfo shopUserInfo) throws Exception
    {
        return this.shopUserInfoGeneratorCoreService.updateByPrimaryKeySelective(shopUserInfo);
    }

    @Override
    public boolean deleteShopUserInfo(String id) throws Exception
    {
        if (!StringUtils.hasText(id))
        {
            GooagooLog.warn("删除店员：Id为空");
            return false;
        }
        return this.shopUserInfoGeneratorCoreService.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean bindRoles(String userId, List<String> roleIdList) throws Exception
    {
        if (!StringUtils.hasText(userId))
        {
            GooagooLog.warn("店员绑定角色：userId为空");
            return false;
        }

        Map<String, String> roleAuthMap = new HashMap<String, String>();//key:roleId,value:A-添加，N+ID-修改，Y+ID-删除
        //查询店员关联角色的历史数据
        ShopUserRoleExample shopUserRoleExample = new ShopUserRoleExample();
        shopUserRoleExample.createCriteria().andRoleIdEqualTo(userId);
        List<ShopUserRole> userRoles = this.shopUserRoleGeneratorCoreService.selectByExample(shopUserRoleExample);
        if (userRoles != null)
        {
            userRoles = new ArrayList<ShopUserRole>();
        }
        //历史数据处理：添加的角色若存在于历史数据使用历史数据
        for (Iterator<ShopUserRole> iterator = userRoles.iterator(); iterator.hasNext();)
        {
            ShopUserRole ra = iterator.next();
            String roleId = ra.getRoleId();
            if (!roleIdList.contains(roleId))
            {
                roleAuthMap.put(roleId, "Y" + ra.getSysUserRoleId());
            }
            else if ("Y".equals(ra.getIsDel()))
            {
                roleAuthMap.put(roleId, "N" + ra.getSysUserRoleId());
                roleIdList.remove(roleId);
            }
            else
            {
                roleIdList.remove(roleId);
            }
        }
        //添加历史数据中没有的角色，重复的不处理
        for (Iterator<String> iterator = roleIdList.iterator(); iterator.hasNext();)
        {
            String roleId = iterator.next();
            if (!roleAuthMap.containsKey(roleId))
            {
                roleAuthMap.put(roleId, "A");
            }
        }
        //根据角色数据类型进行数据保存操作
        for (Iterator<String> iterator = roleAuthMap.keySet().iterator(); iterator.hasNext();)
        {
            String key = iterator.next();
            String value = roleAuthMap.get(key);
            ShopUserRole shopUserRole = new ShopUserRole();
            shopUserRole.setRoleId(key);
            shopUserRole.setUserId(userId);
            boolean isOk = false;
            if ("A".equals(value))
            {
                shopUserRole.setSysUserRoleId(com.gooagoo.common.utils.StringUtils.getUUID());
                shopUserRole.setIsDel("N");
                isOk = this.shopUserRoleGeneratorCoreService.insertSelective(shopUserRole);
            }
            else
            {
                shopUserRole.setSysUserRoleId(value.substring(1));
                shopUserRole.setIsDel(value.substring(0, 1));
                isOk = this.shopUserRoleGeneratorCoreService.updateByPrimaryKeySelective(shopUserRole);
            }
            if (!isOk)
            {
                GooagooLog.warn("店员绑定角色保存数据失败:mapValue=" + value + ",obj=" + new Gson().toJson(shopUserRole));
                throw new OperateFailException("店员绑定角色保存数据失败");
            }
        }
        return true;
    }

}
