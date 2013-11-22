package com.gooagoo.mis.usermanage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.auth.ShopRole2CoreService;
import com.gooagoo.api.generator.query.shop.ShopRole2GeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopUserRole2GeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.entity.generator.shop.ShopRole2;
import com.gooagoo.entity.generator.shop.ShopRole2Example;
import com.gooagoo.entity.generator.shop.ShopUserRole2;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.usermanage.service.ShopUserManageService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.mis.enterprise.MShopRole2;
import com.gooagoo.view.mis.enterprise.MShopUserRole2;

@Service(value = "shopUserManageService")
public class ShopUserManageServiceImpl implements ShopUserManageService
{
    @Autowired
    private ShopUserRole2GeneratorQueryService shopUserRole2GeneratorQueryService;
    @Autowired
    private ShopRole2GeneratorQueryService shopRole2GeneratorQueryService;
    @Autowired
    private ShopRole2CoreService shopRole2CoreService;

    /**
     * 查询商家用户详细
     * @throws Exception 
     */
    @Override
    public TransData<MShopUserRole2> queryShopUserManage(HttpServletRequest request) throws Exception
    {
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        ShopUserRole2 user = this.shopUserRole2GeneratorQueryService.selectUnDelByPrimaryKey(shopId.split(",")[0]);
        if (user != null)
        {
            MShopUserRole2 muser = new MShopUserRole2();
            EntityTools.copyValue(user, muser);
            return new TransData<MShopUserRole2>(true, null, muser);
        }
        return new TransData<MShopUserRole2>(false, MisMessageConst.MIS_USER_SHOPUSER_QUERY_FAIL, null);
    }

    /**
     * 查询所有商家角色
     */
    @Override
    public TransData<List<MShopRole2>> queryAssignShopUserManange(HttpServletRequest request) throws Exception
    {
        ShopRole2Example roleExample = new ShopRole2Example();
        roleExample.createCriteria().andIsDelEqualTo("N");
        List<ShopRole2> roleList = this.shopRole2GeneratorQueryService.selectByExample(roleExample);
        List<MShopRole2> mroleList = new ArrayList<MShopRole2>();
        for (ShopRole2 role : roleList)
        {
            MShopRole2 mrole = new MShopRole2();
            EntityTools.copyValue(role, mrole);
            mroleList.add(mrole);
        }
        if (mroleList.size() > 0)
        {
            return new TransData<List<MShopRole2>>(true, null, mroleList);
        }
        return new TransData<List<MShopRole2>>(true, MisMessageConst.MIS_USER_SHOPUSER_QUERYALL_FAIL, null);
    }

    /**
     * 分配商家用户角色
     */
    @Override
    public TransData<Object> sssignShopUserManange(HttpServletRequest request) throws Exception
    {
        String roleId = ServletRequestUtils.getStringParameter(request, "roleId", "");
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        ShopUserRole2 user = new ShopUserRole2();
        if ("clear".equals(roleId))
        {
            user.setIsDel("Y");
        }
        else
        {
            user.setIsDel("N");
            user.setRoleId(roleId);
        }
        user.setShopId(shopId);
        boolean flag = this.shopRole2CoreService.allotShopRole(user);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_USER_SHOPUSER_ASSIGN_SUCCESS, MisMessageConst.MIS_USER_SHOPUSER_ASSIGN_FAIL, user.getShopId());
    }

}
