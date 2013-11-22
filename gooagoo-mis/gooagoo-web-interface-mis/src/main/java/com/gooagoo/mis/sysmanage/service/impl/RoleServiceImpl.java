package com.gooagoo.mis.sysmanage.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.sys.role.RoleManageCoreService;
import com.gooagoo.api.generator.query.sys.SysAuthorityGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.SysRoleAuthorityGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.SysRoleGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.sys.SysAuthority;
import com.gooagoo.entity.generator.sys.SysAuthorityExample;
import com.gooagoo.entity.generator.sys.SysRole;
import com.gooagoo.entity.generator.sys.SysRoleAuthority;
import com.gooagoo.entity.generator.sys.SysRoleAuthorityExample;
import com.gooagoo.entity.generator.sys.SysRoleExample;
import com.gooagoo.entity.generator.sys.SysRoleExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.sysmanage.service.RoleService;
import com.gooagoo.mis.util.TreeNodeComparator;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.common.MZTreeNode;
import com.gooagoo.view.mis.roleManage.MSysRole;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService
{
    @Autowired
    private RoleManageCoreService roleManageCoreService;
    @Autowired
    private SysRoleGeneratorQueryService sysRoleGeneratorQueryService;
    @Autowired
    private SysRoleAuthorityGeneratorQueryService sysRoleAuthorityGeneratorQueryService;
    @Autowired
    private SysAuthorityGeneratorQueryService sysAuthorityGeneratorQueryService;

    /**
     * 添加角色
     */
    @Override
    public TransData<Object> addRole(HttpServletRequest request) throws Exception
    {
        MSysRole msysRole = ServletUtils.objectMethod(MSysRole.class, request);
        String roleName = request.getParameter("roleName");
        SysRoleExample roleExample = new SysRoleExample();
        // 设置查询条件
        roleExample.createCriteria().andRoleNameEqualTo(roleName);
        List<SysRole> roleList = this.sysRoleGeneratorQueryService.selectByExample(roleExample);
        if (roleList.size() == 0)
        {
            msysRole.setRoleId(UUID.getUUID());
            boolean flag = this.roleManageCoreService.addRole(this.converToSysRole(msysRole));
            return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_ROLE_ADD_ROLE_SUCCESS, MisMessageConst.MIS_SYS_ROLE_ADD_ROLE_FAIL, msysRole.getRoleId());
        }
        else
        {
            return new TransData<Object>(false, MisMessageConst.MIS_SYS_ROLE_NAME_ALREADY_EXIST, null, msysRole.getRoleId());
        }
    }

    /**
     * 编辑角色
     */
    @Override
    public TransData<Object> editRole(HttpServletRequest request) throws Exception
    {
        MSysRole msysRole = ServletUtils.objectMethod(MSysRole.class, request);
        boolean flag = this.roleManageCoreService.updateRole(this.converToSysRole(msysRole));
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_ROLE_UPD_ROLE_SUCCESS, MisMessageConst.MIS_SYS_ROLE_UPD_ROLE_FAIL, msysRole.getRoleId());
    }

    /**
     * 删除角色
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delRole(HttpServletRequest request) throws Exception
    {
        String roleId = ServletRequestUtils.getStringParameter(request, "id", "");//角色Id
        String[] arrId = roleId.split(",");
        boolean flag = false;
        for (int i = 0; i < arrId.length; i++)
        {
            flag = this.roleManageCoreService.delRole(arrId[i]);
            if (!flag)
            {
                break;
            }
        }
        return UtilsMis.getBooleanResult(true, MisMessageConst.MIS_SYS_ROLE_DEL_ROLE_SUCCESS, MisMessageConst.MIS_SYS_ROLE_DEL_ROLE_FAIL);
    }

    /**
     * 查看角色详情
     */
    @Override
    public TransData<MSysRole> searchRoleDetail(HttpServletRequest request) throws Exception
    {
        String roleId = ServletRequestUtils.getStringParameter(request, "id", "");// 角色Id
        SysRole sysRole = this.sysRoleGeneratorQueryService.selectUnDelByPrimaryKey(roleId.split(",")[0]);
        if (sysRole != null && !"".equals(sysRole))
        {
            return new TransData<MSysRole>(true, null, this.converToMSysRole(sysRole));
        }
        else
        {
            return new TransData<MSysRole>(false, MisMessageConst.MIS_SYS_ROLE_GET_ROLE_FAIL, null);
        }
    }

    /**
     * 查询所有角色
     */
    @Override
    public TransData<PageModel<MSysRole>> searchAllRoles(HttpServletRequest request) throws Exception
    {

        MSysRole msysRole = ServletUtils.objectMethod(MSysRole.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        SysRoleExample roleExample = new SysRoleExample();
        Criteria roleExampleC = roleExample.createCriteria();
        roleExampleC.andIsDelEqualTo("N");
        if (StringUtils.hasText(msysRole.getRoleName()))
        {
            roleExampleC.andRoleNameLike("%" + msysRole.getRoleName() + "%");
        }
        if (!"".equals(msysRole.getCreateTime_FE()) && null != msysRole.getCreateTime_FE())
        {
            roleExampleC.andCreateTimeGreaterThanOrEqualTo(msysRole.getCreateTime_FE());
        }
        if (!"".equals(msysRole.getCreateTime_TE()) && null != msysRole.getCreateTime_TE())
        {
            roleExampleC.andCreateTimeLessThanOrEqualTo(UtilsMis.getMidNight(msysRole.getCreateTime_TE()));
        }
        PageModel<MSysRole> pm = new PageModel<MSysRole>();
        pm.setPageIndex(pageCondition.getPageIndex());
        pm.setPageSize(pageSize);
        Integer count = this.sysRoleGeneratorQueryService.countByExample(roleExample);
        pm.setCount(count);
        if (count > 0)
        {
            roleExample.setPage(pm.getPageIndex(), pageSize);// 设置分页条件
            List<SysRole> list = this.sysRoleGeneratorQueryService.selectByExample(roleExample);
            for (SysRole role : list)
            {
                pm.getResult().add(this.converToMSysRole(role));
            }
        }
        return new TransData<PageModel<MSysRole>>(true, null, pm);
    }

    /**
     * 为角色设置权限
     */
    @Override
    public TransData<Object> setRoleAuthority(HttpServletRequest request) throws Exception
    {
        String roleId = ServletRequestUtils.getStringParameter(request, "roleId", "");//角色Id
        String authoritys = ServletRequestUtils.getStringParameter(request, "authoritys", "");//已选中权限
        String[] arrAuthority = authoritys.split(",");
        List<String> authorities = new ArrayList<String>();
        for (String string : arrAuthority)
        {
            authorities.add(string);
        }
        boolean flag = this.roleManageCoreService.assignPermissions(roleId, authorities);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_ROLE_SET_AUTHORITY_SUCCESS, MisMessageConst.MIS_SYS_ROLE_SET_AUTHORITY_SUCCESS, roleId);
    }

    /**
     * 查询所有权限
     */
    @Override
    public TransData<List<MZTreeNode>> searchAllAuthorities(HttpServletRequest request) throws Exception
    {
        String roleId = ServletRequestUtils.getStringParameter(request, "roleId", "");//角色Id
        List<MZTreeNode> zTreeNodes = new ArrayList<MZTreeNode>();
        List<MZTreeNode> treeNodes = this.searAuthorities(zTreeNodes, "-1", roleId);
        if (treeNodes.size() > 0)
        {
            Collections.sort(treeNodes, new TreeNodeComparator());
            return new TransData<List<MZTreeNode>>(true, null, treeNodes);
        }
        else
        {
            return new TransData<List<MZTreeNode>>(true, MisMessageConst.MIS_SYS_ROLE_GET_ALL_AUTHORITY_FAIL, null);
        }
    }

    /**
     * 查询所有角色（返回List）
     */
    @Override
    public TransData<List<MSysRole>> searchAllListRole(HttpServletRequest request) throws Exception
    {
        SysRoleExample roleExample = new SysRoleExample();
        roleExample.createCriteria().andIsDelEqualTo("N");
        List<SysRole> sysRoles = this.sysRoleGeneratorQueryService.selectByExample(roleExample);
        if (sysRoles.size() > 0)
        {
            List<MSysRole> roleList = new ArrayList<MSysRole>();
            for (SysRole sys : sysRoles)
            {
                roleList.add(this.converToMSysRole(sys));
            }
            return new TransData<List<MSysRole>>(true, null, roleList);
        }
        else
        {
            return new TransData<List<MSysRole>>(false, MisMessageConst.MIS_SYS_ROLE_GET_ALLROLE_FAIL, null);
        }
    }

    /**
     * MSysRole转换为SysRole
     * @param role
     * @return
     */
    private SysRole converToSysRole(MSysRole role)
    {
        SysRole sys = new SysRole();
        if (role != null)
        {
            sys.setRoleId(role.getRoleId());
            sys.setRoleName(role.getRoleName());
            sys.setNote(role.getNote());
            sys.setIsDel(role.getIsDel());
            sys.setCreateTime(role.getCreateTime());
            sys.setCTimeStamp(role.getcTimeStamp());
        }
        return sys;
    }

    /**
     * SysRole转换为MSysRole
     * @param role
     * @return
     */
    private MSysRole converToMSysRole(SysRole role)
    {
        MSysRole sys = new MSysRole();
        if (role != null)
        {
            sys.setRoleId(role.getRoleId());
            sys.setRoleName(role.getRoleName());
            sys.setNote(role.getNote());
            sys.setIsDel(role.getIsDel());
            sys.setCreateTime(role.getCreateTime());
            sys.setcTimeStamp(role.getCTimeStamp());
        }
        return sys;
    }

    /**
     * 查询权限树
     * @param treeNodes
     * @param parentId
     * @return
     */
    public List<MZTreeNode> searAuthorities(List<MZTreeNode> treeNodes, String parentId, String roleId) throws Exception
    {
        // 查询角色拥有的权限
        List<SysRoleAuthority> sysRoleAuthorities = this.getExistRoles(roleId);
        // 查询所有权限
        SysAuthorityExample authorityExample = new SysAuthorityExample();
        authorityExample.createCriteria().andIsDelEqualTo("N").andParentAuthorityIdEqualTo(parentId);
        List<SysAuthority> sysAuthorities = this.sysAuthorityGeneratorQueryService.selectByExample(authorityExample);
        for (SysAuthority sysAuthority2 : sysAuthorities)
        {
            treeNodes.add(this.convertZtreeNode(sysAuthority2, sysRoleAuthorities));
            this.searAuthorities(treeNodes, sysAuthority2.getAuthorityId(), roleId);
        }
        return treeNodes;
    }

    /**
     * 查询角色拥有权限
     */
    private List<SysRoleAuthority> getExistRoles(String roleId) throws Exception
    {
        if (roleId != null && !"".equals(roleId))
        {
            SysRoleAuthorityExample roleExample = new SysRoleAuthorityExample();
            roleExample.createCriteria().andIsDelEqualTo("N").andRoleIdEqualTo(roleId);
            List<SysRoleAuthority> sysRoleAuthorities = this.sysRoleAuthorityGeneratorQueryService.selectByExample(roleExample);
            return sysRoleAuthorities;
        }
        else
        {
            throw new Exception(MisMessageConst.MIS_SYS_ROLE_EXIST_AUTHORITY_FAIL);
        }
    }

    /**
     * 将权限转换为ZTreeNode
     * @param sysAuthority 权限
     * @param sysRoleAuthorities 角色权限集合
     * @return
     */
    private MZTreeNode convertZtreeNode(SysAuthority sysAuthority, List<SysRoleAuthority> sysRoleAuthorities)
    {
        MZTreeNode treeNode = null;
        if (sysAuthority != null)
        {
            treeNode = new MZTreeNode();
            treeNode.setOpen(false);
            if (sysRoleAuthorities != null && sysRoleAuthorities.size() > 0)
            {
                treeNode.setChecked(this.searchHasAuthority(sysRoleAuthorities, sysAuthority));
            }
            else
            {
                treeNode.setChecked(false);
            }
            treeNode.setId(sysAuthority.getAuthorityId() + "");
            treeNode.setName(sysAuthority.getAuthorityName());
            treeNode.setpId(sysAuthority.getParentAuthorityId() + "");
            treeNode.setNote(sysAuthority.getNote());
        }
        return treeNode;
    }

    /**
     * 验证角色是否拥有此权限
     * @param sysRoleAuthorities
     * @param sysAuthority
     * @return
     */
    private boolean searchHasAuthority(List<SysRoleAuthority> sysRoleAuthorities, SysAuthority sysAuthority)
    {
        String authorityIds = "";//权限ID
        for (SysRoleAuthority sysRoleAuthority : sysRoleAuthorities)
        {
            authorityIds += sysRoleAuthority.getAuthorityId() + ",";
        }
        authorityIds = "," + authorityIds + ",";
        int count = authorityIds.indexOf("," + sysAuthority.getAuthorityId() + ",");
        if (count != -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
