package com.gooagoo.query.business.shop.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.shop.auth.ShopAuthorityQueryService;
import com.gooagoo.api.generator.query.shop.ShopAuthorityGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopRoleAuthority2GeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopRoleAuthorityGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopUserRole2GeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopUserRoleGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.casclient.shop.ShopAuth;
import com.gooagoo.entity.generator.shop.ShopAuthority;
import com.gooagoo.entity.generator.shop.ShopAuthorityExample;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2Example;
import com.gooagoo.entity.generator.shop.ShopRoleAuthorityExample;
import com.gooagoo.entity.generator.shop.ShopUserRole;
import com.gooagoo.entity.generator.shop.ShopUserRole2;
import com.gooagoo.entity.generator.shop.ShopUserRoleExample;

@Service
public class ShopAuthorityQueryServiceImpl implements ShopAuthorityQueryService
{
    @Autowired
    private ShopAuthorityGeneratorQueryService shopAuthorityGeneratorQueryService;
    @Autowired
    private ShopUserRoleGeneratorQueryService shopUserRoleGeneratorQueryService;
    @Autowired
    private ShopRoleAuthorityGeneratorQueryService shopRoleAuthorityGeneratorQueryService;
    @Autowired
    private ShopUserRole2GeneratorQueryService shopUserRole2GeneratorQueryService;
    @Autowired
    private ShopRoleAuthority2GeneratorQueryService shopRoleAuthority2GeneratorQueryService;

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    /**
     * 获取商家权限
     * @param shopId 商家编号
     * @return
     */
    @Override
    public List<ShopAuthority> getShopAuthorities(String shopId)
    {
        List<ShopAuthority> shopAuthorityList = null;
        ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(shopId);
        if (shopInfo == null)
        {
            return null;
        }
        //根据商家id获取商家拥有的角色
        ShopUserRole2 shopUserRole2 = this.shopUserRole2GeneratorQueryService.selectUnDelByPrimaryKey(shopId);
        if (shopUserRole2 != null)
        {
            //通过角色查询出所有的权限
            ShopRoleAuthority2Example shopRoleAuthority2Example = new ShopRoleAuthority2Example();
            shopRoleAuthority2Example.createCriteria().andRoleIdEqualTo(shopUserRole2.getRoleId()).andIsDelEqualTo("N");
            List<ShopRoleAuthority2> ShopRoleAuthority2List = this.shopRoleAuthority2GeneratorQueryService.selectByExample(shopRoleAuthority2Example);
            if (CollectionUtils.isNotEmpty(ShopRoleAuthority2List))
            {
                //去掉重复权限
                Set<String> authorityIdSet = new HashSet<String>();
                for (ShopRoleAuthority2 shopRoleAuthority2 : ShopRoleAuthority2List)
                {
                    if ("U".equals(shopInfo.getShopStatus()))
                    {//商家正常营业
                        authorityIdSet.add(shopRoleAuthority2.getAuthorityId());
                    }
                    else
                    {//商家锁定或待营业
                        String authId = shopRoleAuthority2.getAuthorityId();
                        if (authId.startsWith("1401") || authId.startsWith("140201") || authId.equals("1") || authId.equals("14") || authId.equals("1402"))
                        {
                            authorityIdSet.add(shopRoleAuthority2.getAuthorityId());
                        }
                    }
                }
                List<String> authorityIdList = new ArrayList<String>(authorityIdSet);
                ShopAuthorityExample shopAuthorityExample = new ShopAuthorityExample();
                shopAuthorityExample.createCriteria().andAuthorityIdIn(authorityIdList).andIsDelEqualTo("N");
                shopAuthorityExample.setOrderByClause("order_no");
                shopAuthorityList = this.shopAuthorityGeneratorQueryService.selectByExample(shopAuthorityExample);
            }
        }
        else
        {
            //查询商家默认角色的权限ruleId:186GJ9ESSHFQAC00A1BAQJMCB5GCGLCE
            ShopRoleAuthority2Example shopRoleAuthority2Example = new ShopRoleAuthority2Example();
            shopRoleAuthority2Example.createCriteria().andRoleIdEqualTo("186GJ9ESSHFQAC00A1BAQJMCB5GCGLCE").andIsDelEqualTo("N");
            List<ShopRoleAuthority2> ShopRoleAuthority2List = this.shopRoleAuthority2GeneratorQueryService.selectByExample(shopRoleAuthority2Example);
            if (CollectionUtils.isNotEmpty(ShopRoleAuthority2List))
            {
                //去掉重复权限
                Set<String> authorityIdSet = new HashSet<String>();
                for (ShopRoleAuthority2 shopRoleAuthority2 : ShopRoleAuthority2List)
                {
                    authorityIdSet.add(shopRoleAuthority2.getAuthorityId());
                }
                List<String> authorityIdList = new ArrayList<String>(authorityIdSet);
                ShopAuthorityExample shopAuthorityExample = new ShopAuthorityExample();
                shopAuthorityExample.createCriteria().andAuthorityIdIn(authorityIdList).andIsDelEqualTo("N");
                shopAuthorityExample.setOrderByClause("order_no");
                shopAuthorityList = this.shopAuthorityGeneratorQueryService.selectByExample(shopAuthorityExample);
            }
        }
        return shopAuthorityList;
    }

    /**
     * 获取商家用户（店员）权限
     * @param shopId 商家编号
     * @param shopUserId 店员编号
     * @param isShopAccount 是否为商家帐号，Y-是，N-否
     * @return
     */
    @Override
    public List<ShopAuth> getShopUserAuthorities(String shopId, String shopUserId, String isShopAccount)
    {
        List<ShopAuth> authList = new ArrayList<ShopAuth>();

        //获取商家权限
        boolean isUserOwn = "Y".equals(isShopAccount) ? true : false;
        List<ShopAuthority> shopAuthorities = this.getShopAuthorities(shopId);
        for (Iterator<ShopAuthority> iterator = shopAuthorities.iterator(); iterator.hasNext();)
        {
            ShopAuthority shopAuthority = iterator.next();
            ShopAuth shopAuth = new ShopAuth();
            shopAuth.setAuthorityId(shopAuthority.getAuthorityId());
            shopAuth.setAuthorityName(shopAuthority.getAuthorityName());
            shopAuth.setLink(shopAuthority.getLink());
            shopAuth.setNote(shopAuthority.getNote());
            shopAuth.setOrderNo(shopAuthority.getOrderNo());
            shopAuth.setParentAuthorityId(shopAuthority.getParentAuthorityId());
            shopAuth.setUserOwn(isUserOwn);
            authList.add(shopAuth);
        }
        //商家用户
        if ("Y".equals(isShopAccount))
        {
            return authList;
        }
        //店员用户
        if (!StringUtils.hasText(shopUserId))
        {
            GooagooLog.warn("查询商家用户权限，用户Id为空");
            return null;
        }
        //获取店员权限
        ShopUserRoleExample shopUserRoleExample = new ShopUserRoleExample();
        shopUserRoleExample.createCriteria().andIsDelEqualTo("N").andUserIdEqualTo(shopUserId);
        List<ShopUserRole> userRoles = this.shopUserRoleGeneratorQueryService.selectByExample(shopUserRoleExample);
        if (userRoles == null)
        {
            return authList;
        }
        Map<String, String> userAuthMap = new HashMap<String, String>();
        for (Iterator<ShopUserRole> iterator = userRoles.iterator(); iterator.hasNext();)
        {
            ShopUserRole shopUserRole = iterator.next();
            ShopRoleAuthorityExample shopRoleAuthorityExample = new ShopRoleAuthorityExample();
            shopRoleAuthorityExample.createCriteria().andIsDelEqualTo("N").andRoleIdEqualTo(shopUserRole.getRoleId());
            List<ShopRoleAuthority> roleAuths = this.shopRoleAuthorityGeneratorQueryService.selectByExample(shopRoleAuthorityExample);
            for (Iterator<ShopRoleAuthority> iterator2 = roleAuths.iterator(); iterator2.hasNext();)
            {
                ShopRoleAuthority shopRoleAuthority = iterator2.next();
                String authId = shopRoleAuthority.getAuthorityId();
                userAuthMap.put(authId, authId);
            }
        }
        //更新商家用户权限中是否是用户拥有状态
        for (Iterator<ShopAuth> iterator = authList.iterator(); iterator.hasNext();)
        {
            ShopAuth shopUserAuthority = iterator.next();
            String authId = shopUserAuthority.getAuthorityId();
            if (StringUtils.hasText(userAuthMap.get(authId)))
            {
                shopUserAuthority.setUserOwn(true);
            }
        }
        return authList;
    }

    /**
     * 获取商家用户（登陆）权限
     * @param shopId 商家编号
     * @param shopUserId 店员编号
     * @param isShopAccount 是否为商家帐号，Y-是，N-否
     * @return
     */
    @Override
    public List<ShopAuth> getShopUserLoginAuthorities(String shopId, String shopUserId, String isShopAccount)
    {
        ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(shopId);
        if (shopInfo == null)
        {
            return null;
        }

        List<ShopAuth> authList = new ArrayList<ShopAuth>();
        //获取商家权限
        boolean isUserOwn = false;
        ShopAuthorityExample shopAuthorityExample = new ShopAuthorityExample();
        shopAuthorityExample.setOrderByClause(" order_no ");
        shopAuthorityExample.createCriteria().andIsDelEqualTo("N");
        List<ShopAuthority> shopAuthorities = this.shopAuthorityGeneratorQueryService.selectByExample(shopAuthorityExample);
        for (Iterator<ShopAuthority> iterator = shopAuthorities.iterator(); iterator.hasNext();)
        {
            ShopAuthority shopAuthority = iterator.next();
            ShopAuth shopAuth = new ShopAuth();
            shopAuth.setAuthorityId(shopAuthority.getAuthorityId());
            shopAuth.setAuthorityName(shopAuthority.getAuthorityName());
            shopAuth.setLink(shopAuthority.getLink());
            shopAuth.setNote(shopAuthority.getNote());
            shopAuth.setOrderNo(shopAuthority.getOrderNo());
            shopAuth.setParentAuthorityId(shopAuthority.getParentAuthorityId());
            shopAuth.setUserOwn(isUserOwn);
            authList.add(shopAuth);
        }
        //商家用户
        if ("Y".equals(isShopAccount))
        {
            Map<String, String> userAuthMap = new HashMap<String, String>();
            //获取店员权限
            List<ShopAuthority> roleAuths = this.getShopAuthorities(shopId);
            if (CollectionUtils.isNotEmpty(roleAuths))
            {
                for (Iterator<ShopAuthority> iterator2 = roleAuths.iterator(); iterator2.hasNext();)
                {
                    ShopAuthority shopAuthority = iterator2.next();
                    String authId = shopAuthority.getAuthorityId();
                    userAuthMap.put(authId, authId);
                    if ("U".equals(shopInfo.getShopStatus()))
                    {//商家正常营业
                        userAuthMap.put(authId, authId);
                    }
                    else
                    {//商家锁定或待营业
                        if (authId.startsWith("1401") || authId.startsWith("140201") || authId.equals("1") || authId.equals("14") || authId.equals("1402"))
                        {
                            userAuthMap.put(authId, authId);
                        }
                    }
                }
            }
            //更新商家用户权限中是否是用户拥有状态
            for (Iterator<ShopAuth> iterator = authList.iterator(); iterator.hasNext();)
            {
                ShopAuth shopUserAuthority = iterator.next();
                String authId = shopUserAuthority.getAuthorityId();
                if (StringUtils.hasText(userAuthMap.get(authId)))
                {
                    shopUserAuthority.setUserOwn(true);
                }
            }
            return authList;
        }
        //店员用户
        if (!StringUtils.hasText(shopUserId))
        {
            GooagooLog.warn("查询商家用户权限，用户Id为空");
            return null;
        }
        //获取店员权限
        ShopUserRoleExample shopUserRoleExample = new ShopUserRoleExample();
        shopUserRoleExample.createCriteria().andIsDelEqualTo("N").andUserIdEqualTo(shopUserId);
        List<ShopUserRole> userRoles = this.shopUserRoleGeneratorQueryService.selectByExample(shopUserRoleExample);
        if (userRoles == null)
        {
            return authList;
        }
        Map<String, String> userAuthMap = new HashMap<String, String>();
        for (Iterator<ShopUserRole> iterator = userRoles.iterator(); iterator.hasNext();)
        {
            ShopUserRole shopUserRole = iterator.next();
            ShopRoleAuthorityExample shopRoleAuthorityExample = new ShopRoleAuthorityExample();
            shopRoleAuthorityExample.createCriteria().andIsDelEqualTo("N").andRoleIdEqualTo(shopUserRole.getRoleId());
            List<ShopRoleAuthority> roleAuths = this.shopRoleAuthorityGeneratorQueryService.selectByExample(shopRoleAuthorityExample);
            for (Iterator<ShopRoleAuthority> iterator2 = roleAuths.iterator(); iterator2.hasNext();)
            {
                ShopRoleAuthority shopRoleAuthority = iterator2.next();
                String authId = shopRoleAuthority.getAuthorityId();
                userAuthMap.put(authId, authId);
            }
        }
        //更新商家用户权限中是否是用户拥有状态
        for (Iterator<ShopAuth> iterator = authList.iterator(); iterator.hasNext();)
        {
            ShopAuth shopUserAuthority = iterator.next();
            String authId = shopUserAuthority.getAuthorityId();
            if (StringUtils.hasText(userAuthMap.get(authId)))
            {
                shopUserAuthority.setUserOwn(true);
            }
        }
        return authList;
    }

}
