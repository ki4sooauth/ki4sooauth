package com.gooagoo.igms.shopinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.shop.auth.ShopAuthorityQueryService;
import com.gooagoo.api.generator.query.shop.ShopAuthorityGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopRoleAuthorityGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.entity.casclient.shop.ShopAuth;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.ShopAuthority;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority;
import com.gooagoo.entity.generator.shop.ShopRoleAuthorityExample;
import com.gooagoo.entity.generator.shop.ShopRoleAuthorityExample.Criteria;
import com.gooagoo.igms.shopinfo.service.IShopAuthorityService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.ZTreeNode;
import com.gooagoo.view.gms.shopinfo.FShopAuthority;

@Service("ishopAuthorityService")
public class IShopAuthorityServiceImpl implements IShopAuthorityService
{

    @Autowired
    private ShopAuthorityGeneratorQueryService authQueryService;
    @Autowired
    private ShopAuthorityQueryService shopAuthorityQueryService;
    @Autowired
    private ShopRoleAuthorityGeneratorQueryService shopRoleAuthorityGeneratorQueryService;
    @Autowired
    private ShopLoginService shopLoginService;

    @Override
    public TransData<List<ZTreeNode>> getAuthority(HttpServletRequest request) throws Exception
    {
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        String shopId = shopInfo.getShopAndUserInfo().getShopId();
        String shopUserId = shopInfo.getShopAndUserInfo().getUserId();
        String isShopAccount = shopInfo.getShopAndUserInfo().getUserIsShopAccount();
        List<ShopAuth> shopAuths = this.shopAuthorityQueryService.getShopUserAuthorities(shopId, shopUserId, isShopAccount);

        List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>();
        for (ShopAuth a : shopAuths)
        {
            ZTreeNode node = new ZTreeNode(a.getAuthorityId(), a.getParentAuthorityId(), a.getAuthorityName(), false);
            nodeList.add(node);
        }
        return GMSUtil.toTransData(true, null, nodeList);
    }

    @Override
    public TransData<List<String>> getRoleOwnerAuth(HttpServletRequest request) throws Exception
    {
        String roleId = ServletRequestUtils.getStringParameter(request, "roleId", "");
        ShopRoleAuthorityExample example = new ShopRoleAuthorityExample();
        Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        criteria.andIsDelEqualTo("N");

        List<ShopRoleAuthority> roleAuthorities = this.shopRoleAuthorityGeneratorQueryService.selectByExample(example);
        List<String> authList = new ArrayList<String>();
        for (ShopRoleAuthority a : roleAuthorities)
        {
            ShopAuthority authority = this.authQueryService.selectByPrimaryKey(a.getAuthorityId());
            authList.add(authority.getAuthorityId());
        }
        return GMSUtil.toTransData(true, null, authList);
    }

    @Override
    public TransData<Object> checkAuthID(HttpServletRequest request) throws Exception
    {
        boolean ret = false;
        String authorityID = ServletRequestUtils.getStringParameter(request, "authorityID", "");
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);

        List<ShopAuth> authList = shopInfo.getShopAuthList();
        if (authList != null)
        {
            for (ShopAuth fShopAuthority : authList)
            {
                if (authorityID.equals(fShopAuthority.getAuthorityId()))
                {
                    ret = true;
                    break;
                }
            }
        }
        return GMSUtil.toTransData(ret, null, null);
    }

    @Override
    public TransData<List<FShopAuthority>> getUserAuthories(HttpServletRequest request) throws Exception
    {
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        String userId = ServletRequestUtils.getStringParameter(request, "userId", "");
        List<ShopAuth> userAuthorities = this.shopAuthorityQueryService.getShopUserAuthorities(shopInfo.getShopAndUserInfo().getShopId(), userId, "Y");

        List<FShopAuthority> list = new ArrayList<FShopAuthority>();
        for (ShopAuth e : userAuthorities)
        {
            FShopAuthority authority = new FShopAuthority();
            authority.setAuthorityId(e.getAuthorityId());
            authority.setAuthorityName(e.getAuthorityName());
            authority.setLink(e.getLink());
            authority.setNote(e.getNote());
            authority.setParentAuthorityId(e.getParentAuthorityId());
            list.add(authority);
        }
        return GMSUtil.toTransData(true, null, list);
    }

}
