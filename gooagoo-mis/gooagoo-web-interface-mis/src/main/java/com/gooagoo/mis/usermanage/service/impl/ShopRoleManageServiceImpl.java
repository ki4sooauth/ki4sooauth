package com.gooagoo.mis.usermanage.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.auth.ShopRole2CoreService;
import com.gooagoo.api.generator.query.shop.ShopAuthorityGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopRole2GeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopRoleAuthority2GeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.shop.ShopAuthority;
import com.gooagoo.entity.generator.shop.ShopAuthorityExample;
import com.gooagoo.entity.generator.shop.ShopRole2;
import com.gooagoo.entity.generator.shop.ShopRole2Example;
import com.gooagoo.entity.generator.shop.ShopRole2Example.Criteria;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority2Example;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.usermanage.service.ShopRoleManageService;
import com.gooagoo.mis.util.TreeNodeComparator;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.common.MZTreeNode;
import com.gooagoo.view.mis.enterprise.MShopRole2;

@Service(value = "shopRoleManageService")
public class ShopRoleManageServiceImpl implements ShopRoleManageService
{
    @Autowired
    private ShopRole2GeneratorQueryService shopRole2GeneratorQueryService;
    @Autowired
    private ShopRoleAuthority2GeneratorQueryService shopRoleAuthority2GeneratorQueryService;
    @Autowired
    private ShopAuthorityGeneratorQueryService shopAuthorityGeneratorQueryService;
    @Autowired
    private ShopRole2CoreService ShopRole2CoreService;

    /**
     * 新增商家角色
     */
    @Override
    public TransData<Object> addShopRoleManage(HttpServletRequest request) throws Exception
    {
        MShopRole2 mrole = ServletUtils.objectMethod(MShopRole2.class, request);
        ShopRole2 role = new ShopRole2();
        EntityTools.copyValue(mrole, role);
        boolean flag = this.ShopRole2CoreService.addShopRole2(role);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_USER_SHOPROLE2_ADD_SUCCESS, MisMessageConst.MIS_USER_SHOPROLE2_ADD_FAIL, role.getRoleId());
    }

    /**
     * 修改商家角色
     */
    @Override
    public TransData<Object> updateShopRoleManage(HttpServletRequest request) throws Exception
    {
        MShopRole2 mrole = ServletUtils.objectMethod(MShopRole2.class, request);
        ShopRole2 role = new ShopRole2();
        EntityTools.copyValue(mrole, role);
        boolean flag = this.ShopRole2CoreService.updateShopRole2(role);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_USER_SHOPROLE2_UPDATE_SUCCESS, MisMessageConst.MIS_USER_SHOPROLE2_UPDATE_FAIL, role.getRoleId());
    }

    /**
     * 删除商家角色
     */
    @Override
    public TransData<Object> deleteShopRoleManage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        boolean flag = this.ShopRole2CoreService.deleteShopRole2(ids);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_USER_SHOPROLE2_DELETE_SUCCESS, MisMessageConst.MIS_USER_SHOPROLE2_DELETE_FAIL);
    }

    /**
     * 查询所有商家角色
     */
    @Override
    public TransData<PageModel<MShopRole2>> queryAllShopRoleManage(HttpServletRequest request) throws Exception
    {
        MShopRole2 mrole = ServletUtils.objectMethod(MShopRole2.class, request);
        PageCondition pageCondtition = ServletUtils.objectMethod(PageCondition.class, request);
        ShopRole2Example example = new ShopRole2Example();
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (StringUtils.hasText(mrole.getRoleName()))
        {
            criteria.andRoleNameLike("%" + mrole.getRoleName() + "%");
        }
        PageModel<MShopRole2> pm = new PageModel<MShopRole2>();
        if (pageCondtition != null)
        {
            pm.setPageIndex(pageCondtition.getPageIndex());
            pm.setPageSize(pageCondtition.getPageSize() <= 0 ? 10 : pageCondtition.getPageSize());
        }
        Integer count = this.shopRole2GeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            example.setPage(pm.getIndex(), pm.getPageSize());
            List<ShopRole2> role = this.shopRole2GeneratorQueryService.selectByExample(example);
            for (ShopRole2 shop : role)
            {
                MShopRole2 mrole2 = new MShopRole2();
                EntityTools.copyValue(shop, mrole2);
                pm.getResult().add(mrole2);
            }
        }
        return new TransData<PageModel<MShopRole2>>(true, null, pm);
    }

    /**
     * 查询商家角色详细
     */
    @Override
    public TransData<MShopRole2> queryShopRoleManage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        ShopRole2 role = this.shopRole2GeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (role != null)
        {
            MShopRole2 mrole = new MShopRole2();
            EntityTools.copyValue(role, mrole);
            return new TransData<MShopRole2>(true, null, mrole);
        }
        else
        {
            return new TransData<MShopRole2>(false, MisMessageConst.MIS_USER_SHOPROLE2_QUERY_FAIL, null);
        }
    }

    /**
     * 分配商家角色页面
     */
    @Override
    public TransData<List<MZTreeNode>> queryShopRoleAuthority2(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        ShopRoleAuthority2Example roleExample = new ShopRoleAuthority2Example();
        roleExample.createCriteria().andIsDelEqualTo("N").andRoleIdEqualTo(ids.split(",")[0]);
        // 根据角色ID查询角色-权限关联2表[有权限-修改页面，无权限-新增页面]
        List<ShopRoleAuthority2> roleAuthority = this.shopRoleAuthority2GeneratorQueryService.selectByExample(roleExample);
        List<MZTreeNode> treeList = this.serarchShopAuthority(new ArrayList<MZTreeNode>(), "-1", roleAuthority);// 查询商家权限树
        if (treeList.size() > 0)
        {
            Collections.sort(treeList, new TreeNodeComparator());
            return new TransData<List<MZTreeNode>>(true, null, treeList);
        }
        else
        {
            return new TransData<List<MZTreeNode>>(false, MisMessageConst.MIS_USER_SHOPAUTHORITY_QUERY_FAIL, null);
        }
    }

    /**
     * 查询商家权限树
     * @param treeList
     * @param parentId 父类ID
     * @param roleAuthority 商家已拥有的权限
     * @return
     */
    private List<MZTreeNode> serarchShopAuthority(List<MZTreeNode> treeList, String parentId, List<ShopRoleAuthority2> roleAuthority)
    {
        ShopAuthorityExample example = new ShopAuthorityExample();
        example.createCriteria().andIsDelEqualTo("N").andParentAuthorityIdEqualTo(parentId);
        // 查询所有商家权限
        List<ShopAuthority> authority = this.shopAuthorityGeneratorQueryService.selectByExample(example);
        for (ShopAuthority auth : authority)
        {
            boolean flag = false;
            if (roleAuthority.size() > 0)
            {
                flag = this.checkAuthorityExists(auth.getAuthorityId(), roleAuthority);
            }
            treeList.add(this.convertZtreeNode(auth, flag));
            this.serarchShopAuthority(treeList, auth.getAuthorityId(), roleAuthority);
        }
        return treeList;
    }

    /**
     * 验证权限是否存在
     * @param id 权限ID
     * @param roleAuthority 商家角色-权限关联2表商家角色ID
     * @return
     */
    private boolean checkAuthorityExists(String id, List<ShopRoleAuthority2> roleAuthority)
    {
        for (ShopRoleAuthority2 auth : roleAuthority)
        {
            if (id.equals(auth.getAuthorityId()))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 将商家权限转换为ZTreeNode
     * @param authority 商家权限
     * @param isChecked 是否被选中
     * @return
     */
    private MZTreeNode convertZtreeNode(ShopAuthority authority, Boolean isChecked)
    {
        MZTreeNode treeNode = null;
        if (authority != null)
        {
            treeNode = new MZTreeNode();
            treeNode.setOpen(false);// 是否展开
            treeNode.setChecked(isChecked);// 是否被选中
            treeNode.setId(authority.getAuthorityId());// 节点编码
            treeNode.setName(authority.getAuthorityName());// 节点名称
            treeNode.setpId(authority.getParentAuthorityId());// 父节点编码
            treeNode.setNote(authority.getNote());// 备注
        }
        return treeNode;
    }

    /**
     * 分配商家角色权限
     */
    @Override
    public TransData<Object> assignShopRoleManage(HttpServletRequest request) throws Exception
    {
        String authoritys = ServletRequestUtils.getStringParameter(request, "authoritys", "");
        String roleId = ServletRequestUtils.getStringParameter(request, "roleId", "");
        boolean flag = this.ShopRole2CoreService.allotShopRoleAuth(roleId.split(",")[0], authoritys.split(","));
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_USER_SHOPROLE2_ASSIGN_SUCCESS, MisMessageConst.MIS_USER_SHOPROLE2_ASSIGN_FAIL);
    }

}
