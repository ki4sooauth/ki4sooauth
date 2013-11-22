package com.gooagoo.igms.shopinfo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.auth.ShopRoleCoreService;
import com.gooagoo.api.generator.query.shop.ShopRoleGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopUserRoleGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.entity.generator.shop.ShopRole;
import com.gooagoo.entity.generator.shop.ShopRoleExample;
import com.gooagoo.entity.generator.shop.ShopRoleExample.Criteria;
import com.gooagoo.entity.generator.shop.ShopUserRole;
import com.gooagoo.entity.generator.shop.ShopUserRoleExample;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.shopinfo.service.IShopRoleService;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.BindAuthority;
import com.gooagoo.view.gms.shopinfo.FShopRole;

@Service("ishopRoleService")
public class IShopRoleServiceImpl implements IShopRoleService
{
    @Autowired
    private ShopRoleGeneratorQueryService authQueryService;
    @Autowired
    private ShopRoleCoreService shopRoleCoreService;
    @Autowired
    private ShopUserRoleGeneratorQueryService userRoleQueryService;

    @Override
    public TransData<Object> addShopRole(HttpServletRequest request) throws Exception
    {
        String id = StringUtils.getUUID();
        ShopRole fShopRole = ServletUtils.objectMethod(ShopRole.class, request);
        fShopRole.setRoleId(id);
        fShopRole.setShopId(GmsInterfaceUtil.getShopIdByInterface(request));
        fShopRole.setIsDel("N");
        fShopRole.setCreateTime(new Date());
        boolean flag = this.shopRoleCoreService.addShopRole(fShopRole);
        TransData<Object> r = GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
        r.setData(id);
        return r;
    }

    @Override
    public TransData<Object> updateShopRole(HttpServletRequest request) throws Exception
    {
        ShopRole fShopRole = ServletUtils.objectMethod(ShopRole.class, request);
        boolean flag = this.shopRoleCoreService.updateShopRole(fShopRole);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, fShopRole.getRoleId());
    }

    @Override
    public TransData<Object> deleteShopRole(HttpServletRequest request) throws Exception
    {
        String roleId = ServletRequestUtils.getStringParameter(request, "roleId", "");
        boolean flag = this.shopRoleCoreService.deleteShopRole(roleId);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, roleId);
    }

    @Override
    public TransData<FShopRole> getShopRole(HttpServletRequest request) throws Exception
    {
        String roleId = ServletRequestUtils.getStringParameter(request, "roleId", "");
        ShopRole shopRole = this.authQueryService.selectByPrimaryKey(roleId);
        FShopRole fShopRole = new FShopRole();
        BeanUtils.copyProperties(shopRole, fShopRole);
        return GMSUtil.toTransData(true, null, fShopRole);
    }

    @Override
    public TransData<PageModel<FShopRole>> pageShopRole(HttpServletRequest request) throws Exception
    {
        ShopRoleExample example = new ShopRoleExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(GmsInterfaceUtil.getShopIdByInterface(request));
        criteria.andIsDelEqualTo(GMSConstant.NO);

        int count = this.authQueryService.countByExample(example);
        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        example.setPage(pageIndex, pageSize);
        example.setOrderByClause(" c_time_stamp desc ");

        List<ShopRole> shopRoles = this.authQueryService.selectByExample(example);
        List<FShopRole> list = new ArrayList<FShopRole>();
        for (ShopRole e : shopRoles)
        {
            FShopRole role = new FShopRole();
            BeanUtils.copyProperties(e, role);
            list.add(role);
        }
        PageModel<FShopRole> pm = new PageModel<FShopRole>();
        pm.setCount(count);
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);
        pm.setResult(list);

        return GMSUtil.toTransData(true, null, pm);
    }

    @Override
    public TransData<Object> bindAuthority(HttpServletRequest request) throws Exception
    {
        BindAuthority bindAuthority = ServletUtils.objectMethod(BindAuthority.class, request);
        boolean flag = this.shopRoleCoreService.bindAuths(bindAuthority.getRoleId(), bindAuthority.getAuthority());
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, bindAuthority.getRoleId());
    }

    @Override
    public TransData<List<FShopRole>> getAllShopRole(HttpServletRequest request) throws Exception
    {
        ShopRoleExample example = new ShopRoleExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(GmsInterfaceUtil.getShopIdByInterface(request)).andIsDelEqualTo("N");

        List<ShopRole> shopRoles = this.authQueryService.selectByExample(example);
        List<FShopRole> roles = new ArrayList<FShopRole>();
        for (ShopRole e : shopRoles)
        {
            FShopRole role = new FShopRole();
            BeanUtils.copyProperties(e, role);
            roles.add(role);
        }

        return GMSUtil.toTransData(true, null, roles);
    }

    @Override
    public TransData<List<String>> getUserOwnRole(HttpServletRequest request) throws Exception
    {
        String userId = ServletRequestUtils.getStringParameter(request, "userId", "");
        ShopUserRoleExample example = new ShopUserRoleExample();
        com.gooagoo.entity.generator.shop.ShopUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andIsDelEqualTo("N");

        List<ShopUserRole> userRoles = this.userRoleQueryService.selectByExample(example);
        List<String> rList = new ArrayList<String>();
        for (ShopUserRole r : userRoles)
        {
            ShopRole role = this.authQueryService.selectUnDelByPrimaryKey(r.getRoleId());
            if (role != null)
            {
                rList.add(role.getRoleId());
            }
        }

        return GMSUtil.toTransData(true, null, rList);
    }
}
