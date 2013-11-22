package com.gooagoo.mis.sysmanage.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.sys.role.RoleManageCoreService;
import com.gooagoo.api.business.core.system.sys.user.SysUserManageCoreService;
import com.gooagoo.api.generator.query.sys.SysAuthorityGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.SysUserInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.SysUserRoleGeneratorQueryService;
import com.gooagoo.common.cipher.Md5Utils;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.entity.TransHeadData;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.sys.SysAuthority;
import com.gooagoo.entity.generator.sys.SysAuthorityExample;
import com.gooagoo.entity.generator.sys.SysUserInfo;
import com.gooagoo.entity.generator.sys.SysUserInfoExample;
import com.gooagoo.entity.generator.sys.SysUserInfoExample.Criteria;
import com.gooagoo.entity.generator.sys.SysUserRole;
import com.gooagoo.entity.generator.sys.SysUserRoleExample;
import com.gooagoo.mis.constants.ConstantsMis;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.constants.RedisServerConstantsMis;
import com.gooagoo.mis.sysmanage.service.SysUserService;
import com.gooagoo.mis.util.TreeNodeComparator;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisObjectDao;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.common.MMisLoginInfo;
import com.gooagoo.view.mis.common.MZTreeNode;
import com.gooagoo.view.mis.sysUserManage.MSysUserInfo;
import com.gooagoo.view.mis.sysUserManage.MSysUserRole;

@Service(value = "sysUserService")
public class SysUserServiceImpl implements SysUserService
{

    @Autowired
    private SysUserManageCoreService sysUserManageCoreService;
    @Autowired
    private RoleManageCoreService roleManageCoreService;
    @Autowired
    private SysUserInfoGeneratorQueryService sysUserInfoGeneratorQueryService;
    @Autowired
    private SysAuthorityGeneratorQueryService sysAuthorityGeneratorQueryService;
    @Autowired
    private SysUserRoleGeneratorQueryService sysUserRoleGeneratorQueryService;

    /**
     * 登录验证
     */
    @Override
    public TransData<MMisLoginInfo> checkLogin(HttpServletRequest request) throws Exception
    {
        TransHeadData head = new TransHeadData(false, MisMessageConst.SYS_SYSTEM_EXCEPTION);
        TransData<MMisLoginInfo> dat = new TransData<MMisLoginInfo>(head);
        String userId = ServletRequestUtils.getStringParameter(request, "userid");//用户名
        String password = ServletRequestUtils.getStringParameter(request, "password");//密码
        SysUserInfo sysUserInfo = this.sysUserInfoGeneratorQueryService.selectUnDelByPrimaryKey(userId);
        if (sysUserInfo != null)
        {
            if (password.equals(sysUserInfo.getPassword()))
            {
                if ("0".equals(sysUserInfo.getStatus()))
                {
                    head.setResultCode(MisMessageConst.MIS_LOGIN_ACCOUNT_IS_FREEZE);
                    return dat;
                }
            }
            else
            {
                head.setResultCode(MisMessageConst.MIS_LOGIN_PASSWORD_ERROR);
                return dat;
            }
        }
        else
        {
            head.setResultCode(MisMessageConst.MIS_LOGIN_USERNAME_ERROR);
            return dat;
        }
        MMisLoginInfo info = new MMisLoginInfo();
        info.setLoginId(userId);
        info.setPassword(sysUserInfo.getPassword());
        info.setStatus(sysUserInfo.getStatus());
        info.setIsAdmin(sysUserInfo.getIsAdmin());
        if ("Y".equals(sysUserInfo.getIsAdmin()))
        {
            List<MZTreeNode> trees = this.searAdminAuthorities(new ArrayList<MZTreeNode>(), "-1");
            Collections.sort(trees, new TreeNodeComparator());
            info.setAuthorities(trees);
        }
        else
        {
            // 查询用户拥有的角色
            SysUserRoleExample roleExample = new SysUserRoleExample();
            roleExample.createCriteria().andUserIdEqualTo(userId);
            List<SysUserRole> sysUserRoles = this.sysUserRoleGeneratorQueryService.selectByExample(roleExample);
            if (sysUserRoles == null)
            {
                head.setResultCode(MisMessageConst.MIS_SYS_ROLE_USER_GET_OWN_ROLE_FAIL);
                return dat;
            }
            List<MZTreeNode> newTreeNodes = new ArrayList<MZTreeNode>();
            //查询角色拥有权限
            for (SysUserRole sysUserRole2 : sysUserRoles)
            {
                RoleServiceImpl roleService = new RoleServiceImpl();// 调用角色接口实现类-查询权限树方法
                List<MZTreeNode> treeNodes = roleService.searAuthorities(new ArrayList<MZTreeNode>(), "-1", sysUserRole2.getRoleId());
                for (MZTreeNode treeNode : treeNodes)
                {
                    if (treeNode.getChecked())
                    {
                        newTreeNodes.add(treeNode);
                    }
                }
            }
            List<MZTreeNode> treeNodes = removeDuplicateWithOrder(newTreeNodes);// 删除重复数据
            Collections.sort(treeNodes, new TreeNodeComparator());
            info.setAuthorities(treeNodes);
        }
        dat.setData(info);
        head.setSuccess(true);
        return dat;
    }

    /**
     * 修改密码
     */
    @Override
    public TransData<Object> modifyPassword(HttpServletRequest request) throws Exception
    {
        String userid = ServletRequestUtils.getStringParameter(request, "mis_login_id");
        String oldPwd = ServletRequestUtils.getStringParameter(request, "oldPassword");
        String newPwd = ServletRequestUtils.getStringParameter(request, "newPassword");
        SysUserInfo sys = this.sysUserInfoGeneratorQueryService.selectUnDelByPrimaryKey(userid);
        Md5Utils md5Utils = new Md5Utils();
        boolean flag = false;
        if (md5Utils.encrypt(oldPwd).equals(sys.getPassword()))
        {
            SysUserInfo sysUserInfo = new SysUserInfo();
            sysUserInfo.setUserId(userid);
            sysUserInfo.setPassword(md5Utils.encrypt(newPwd));
            flag = this.sysUserManageCoreService.updateSysUser(sysUserInfo);
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_PWD_UPD_SUCCESS, MisMessageConst.MIS_SYS_PWD_UPD_FAIL, userid);
    }

    /**
     * 查询登录用户信息
     * @param userId 用户ID
     * @throws Exception
     */
    @Override
    public TransData<String> searchUserAuthority(HttpServletRequest request) throws Exception
    {
        TransHeadData head = new TransHeadData(false, MisMessageConst.SYS_SYSTEM_EXCEPTION);
        TransData<String> dat = new TransData<String>(head);
        MMisLoginInfo mmisLoginInfo = new MMisLoginInfo();
        String userid = request.getParameter(ConstantsMis.MIS_LOGIN_ID);
        SysUserInfo sysUserInfo = this.sysUserInfoGeneratorQueryService.selectUnDelByPrimaryKey(userid);
        if (sysUserInfo == null)
        {
            head.setResultCode(MisMessageConst.MIS_SYS_USER_GET_INFO_FAIL);
            return dat;
        }
        mmisLoginInfo.setLoginId(userid);
        mmisLoginInfo.setStatus(sysUserInfo.getStatus());
        mmisLoginInfo.setIsAdmin(sysUserInfo.getIsAdmin());
        if ("Y".equals(sysUserInfo.getIsAdmin()))
        {
            List<MZTreeNode> trees = this.searAdminAuthorities(new ArrayList<MZTreeNode>(), "-1");
            Collections.sort(trees, new TreeNodeComparator());
            mmisLoginInfo.setAuthorities(trees);
        }
        else
        {
            // 查询用户拥有的角色
            SysUserRoleExample roleExample = new SysUserRoleExample();
            roleExample.createCriteria().andUserIdEqualTo(userid);
            List<SysUserRole> sysUserRoles = this.sysUserRoleGeneratorQueryService.selectByExample(roleExample);
            if (sysUserRoles == null)
            {
                head.setResultCode(MisMessageConst.MIS_SYS_ROLE_USER_GET_OWN_ROLE_FAIL);
                return dat;
            }
            List<MZTreeNode> newTreeNodes = new ArrayList<MZTreeNode>();
            //查询角色拥有权限
            for (SysUserRole sysUserRole2 : sysUserRoles)
            {
                RoleServiceImpl roleService = new RoleServiceImpl();// 调用角色接口实现类-查询权限树方法
                List<MZTreeNode> treeNodes = roleService.searAuthorities(new ArrayList<MZTreeNode>(), "-1", sysUserRole2.getRoleId());
                for (MZTreeNode treeNode : treeNodes)
                {
                    if (treeNode.getChecked())
                    {
                        newTreeNodes.add(treeNode);
                    }
                }
            }
            List<MZTreeNode> treeNodes = removeDuplicateWithOrder(newTreeNodes);// 删除重复数据
            Collections.sort(treeNodes, new TreeNodeComparator());
            mmisLoginInfo.setAuthorities(treeNodes);
        }
        String key = UUID.getUUID();
        RedisObjectDao redis = new RedisObjectDao(RedisServerConstantsMis.login_mis);
        redis.set(key, mmisLoginInfo);
        RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstantsMis.login_mis);
        redisDatabase.setExpire(key, 1800);
        dat.setData(key);
        head.setSuccess(true);
        return dat;
    }

    /**
     * 删除重复数据
     * @param list
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List<MZTreeNode> removeDuplicateWithOrder(List<MZTreeNode> list)
    {
        Set set = new HashSet();
        List<MZTreeNode> newList = new ArrayList<MZTreeNode>();
        for (Iterator iter = list.iterator(); iter.hasNext();)
        {
            MZTreeNode element = (MZTreeNode) iter.next();
            if (set.add(element.getId()))
            {
                newList.add(element);
            }
        }
        return newList;
    }

    /**
     * 添加系统管理员
     */
    @Override
    public TransData<Object> addSysUser(HttpServletRequest request) throws Exception
    {
        SysUserInfo sysUserInfo = ServletUtils.objectMethod(SysUserInfo.class, request);
        Md5Utils md5Utils = new Md5Utils();
        sysUserInfo.setPassword(md5Utils.encrypt(sysUserInfo.getPassword()));
        sysUserInfo.setStatus("1");//状态0-停用 1-启用
        sysUserInfo.setIsAdmin("N");
        boolean flag = this.sysUserManageCoreService.addSysUser(sysUserInfo);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_USER_ADD_MANAGE_SUCCESS, MisMessageConst.MIS_SYS_USER_ADD_MANAGE_FAIL, sysUserInfo.getUserId());
    }

    /**
     * 查询用户详情
     */
    @Override
    public TransData<MSysUserInfo> searchSysUserDetail(HttpServletRequest request) throws Exception
    {
        String userId = ServletRequestUtils.getStringParameter(request, "id", "");//用户Id
        String[] arrids = userId.split(",");
        SysUserInfo sysUserInfo = this.sysUserInfoGeneratorQueryService.selectUnDelByPrimaryKey(arrids[0]);
        if (sysUserInfo != null)
        {
            return new TransData<MSysUserInfo>(true, null, this.converToMSysUserInfo(sysUserInfo));
        }
        else
        {
            return new TransData<MSysUserInfo>(true, MisMessageConst.MIS_SYS_USER_GET_INFO_FAIL, null);
        }
    }

    /**
     * 修改系统管理员
     */
    @Override
    public TransData<Object> updateSysUser(HttpServletRequest request) throws Exception
    {
        SysUserInfo sysUserInfo = ServletUtils.objectMethod(SysUserInfo.class, request);
        boolean flag = this.sysUserManageCoreService.updateSysUser(sysUserInfo);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_USER_UPD_MANAGE_SUCCESS, MisMessageConst.MIS_SYS_USER_UPD_MANAGE_FAIL, sysUserInfo.getUserId());
    }

    /**
     * 删除管理员
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delSysUser(HttpServletRequest request) throws Exception
    {
        String userIds = ServletRequestUtils.getStringParameter(request, "id", "");//用户Id
        String[] arrId = userIds.split(",");
        boolean flag = false;
        for (String string : arrId)
        {
            flag = this.sysUserManageCoreService.delSysUser(string);
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_SYS_USER_DEL_MANAGE_SUCCESS, MisMessageConst.MIS_SYS_USER_DEL_MANAGE_FAIL);
    }

    /**
     * 查询所有管理员
     */
    @Override
    public TransData<PageModel<MSysUserInfo>> searchAllSysUser(HttpServletRequest request) throws Exception
    {
        MSysUserInfo msysUserInfo = ServletUtils.objectMethod(MSysUserInfo.class, request);
        String useId = request.getParameter("misUserId");
        SysUserInfo sysUserDetail = this.sysUserInfoGeneratorQueryService.selectUnDelByPrimaryKey(useId);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        SysUserInfoExample userExample = new SysUserInfoExample();
        Criteria userExampleC = userExample.createCriteria();
        userExampleC.andIsDelEqualTo("N");
        //管理员用户只可查询与其相同部门的管理员信息
        if (StringUtils.hasText(sysUserDetail.getDepartment()))
        {
            userExampleC.andDepartmentEqualTo(sysUserDetail.getDepartment());
        }
        if (StringUtils.hasText(msysUserInfo.getName()))
        {
            userExampleC.andNameLike("%" + msysUserInfo.getName() + "%");
        }
        if (StringUtils.hasText(msysUserInfo.getUserId()))
        {
            userExampleC.andUserIdLike("%" + msysUserInfo.getUserId() + "%");
        }
        if (StringUtils.hasText(msysUserInfo.getSex()))
        {
            userExampleC.andSexEqualTo(msysUserInfo.getSex());
        }
        if (StringUtils.hasText(msysUserInfo.getIdType()))
        {
            userExampleC.andIdTypeEqualTo(msysUserInfo.getIdType());
        }
        if (StringUtils.hasText(msysUserInfo.getIdNo()))
        {
            userExampleC.andIdNoLike("%" + msysUserInfo.getIdNo() + "%");
        }
        if (StringUtils.hasText(msysUserInfo.getStatus()))
        {
            userExampleC.andStatusEqualTo(msysUserInfo.getStatus());
        }
        PageModel<MSysUserInfo> pm = new PageModel<MSysUserInfo>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.sysUserInfoGeneratorQueryService.countByExample(userExample);
        pm.setCount(count);
        if (count > 0)
        {
            userExample.setPage(pm.getPageIndex(), pageSize);// 设置分页条件
            List<SysUserInfo> list = this.sysUserInfoGeneratorQueryService.selectByExample(userExample);
            for (SysUserInfo userInfo : list)
            {
                pm.getResult().add(this.converToMSysUserInfo(userInfo));
            }
        }
        return new TransData<PageModel<MSysUserInfo>>(true, null, pm);
    }

    /**
     * 用户分配角色
     */
    @Override
    public TransData<Object> allotRole(HttpServletRequest request) throws Exception
    {
        String userId = ServletRequestUtils.getStringParameter(request, "userId", "");//勾选的用户ID
        String roleIds = ServletRequestUtils.getStringParameter(request, "roleIds", "");//角色Ids
        String[] arrRoldId = roleIds.split(",");
        boolean flag = this.roleManageCoreService.assignRoles(userId, arrRoldId);
        return new TransData<Object>(flag, MisMessageConst.MIS_SYS_USER_GIVE_ROLE_SUCCESS, null);
    }

    /**
     * 查询用户拥有角色
     */
    @Override
    public TransData<List<MSysUserRole>> searchUserRoles(HttpServletRequest request) throws Exception
    {
        SysUserRoleExample roleExample = new SysUserRoleExample();
        String userId = ServletRequestUtils.getStringParameter(request, "id", "");//勾选的用户ID
        roleExample.createCriteria().andUserIdEqualTo(userId.split(",")[0]);
        List<SysUserRole> sysUserRoles = this.sysUserRoleGeneratorQueryService.selectByExample(roleExample);
        if (sysUserRoles.size() > 0)
        {
            List<MSysUserRole> roleList = new ArrayList<MSysUserRole>();
            for (SysUserRole sys : sysUserRoles)
            {
                roleList.add(this.converToMSysUserRole(sys));
            }
            return new TransData<List<MSysUserRole>>(true, null, roleList);
        }
        else
        {
            return new TransData<List<MSysUserRole>>(true, MisMessageConst.MIS_SYS_ROLE_USER_GET_OWN_ROLE_FAIL, null);
        }
    }

    /**
     * 递归查询角色所有权限
     * @param treeNodes
     * @param parentId
     * @return
     * @throws Exception
     */
    private List<MZTreeNode> searAdminAuthorities(List<MZTreeNode> treeNodes, String parentId) throws Exception
    {
        //查询所有权限
        SysAuthorityExample authorityExample = new SysAuthorityExample();
        authorityExample.createCriteria().andParentAuthorityIdEqualTo(parentId).andIsDelEqualTo("N");
        List<SysAuthority> sysAuthorities = this.sysAuthorityGeneratorQueryService.selectByExample(authorityExample);
        for (SysAuthority sysAuthority2 : sysAuthorities)
        {
            treeNodes.add(this.convertAdminMZTreeNode(sysAuthority2));
            this.searAdminAuthorities(treeNodes, sysAuthority2.getAuthorityId());
        }
        return treeNodes;
    }

    /**
     * sysAuthority转换为MZTreeNode
     * @param sysAuthority
     * @return
     */
    private MZTreeNode convertAdminMZTreeNode(SysAuthority sysAuthority)
    {
        MZTreeNode treeNode = null;
        if (sysAuthority != null)
        {
            treeNode = new MZTreeNode();
            treeNode.setOpen(true);
            treeNode.setChecked(true);
            treeNode.setId(sysAuthority.getAuthorityId() + "");
            treeNode.setName(sysAuthority.getAuthorityName());
            treeNode.setpId(sysAuthority.getParentAuthorityId() + "");
            treeNode.setUrl(sysAuthority.getLink());
            treeNode.setNote(sysAuthority.getNote());
        }
        return treeNode;
    }

    /**
     * SysUserInfo转换为MSysUserInfo
     * @param user
     * @return
     */
    private MSysUserInfo converToMSysUserInfo(SysUserInfo user)
    {
        MSysUserInfo sys = new MSysUserInfo();
        if (user != null)
        {
            sys.setUserId(user.getUserId());
            sys.setPassword(user.getPassword());
            sys.setStatus(user.getStatus());
            sys.setName(user.getName());
            sys.setSex(user.getSex());
            sys.setBirthday(user.getBirthday());
            sys.setIdType(user.getIdType());
            sys.setIdNo(user.getIdNo());
            sys.setDepartment(user.getDepartment());
            sys.setIsAdmin(user.getIsAdmin());
            sys.setIsDel(user.getIsDel());
            sys.setCreateTime(user.getCreateTime());
            sys.setCTimeStamp(user.getCTimeStamp());
        }
        return sys;
    }

    /**
     * SysUserRole转换为MSysUserRole
     * @param role
     * @return
     */
    private MSysUserRole converToMSysUserRole(SysUserRole role)
    {
        MSysUserRole sys = new MSysUserRole();
        if (role != null)
        {
            sys.setSysUserRoleId(role.getSysUserRoleId());
            sys.setUserId(role.getUserId());
            sys.setRoleId(role.getRoleId());
            sys.setIsDel(role.getIsDel());
            sys.setCreateTime(role.getCTimeStamp());
            sys.setCTimeStamp(role.getCTimeStamp());
        }
        return sys;
    }
}
