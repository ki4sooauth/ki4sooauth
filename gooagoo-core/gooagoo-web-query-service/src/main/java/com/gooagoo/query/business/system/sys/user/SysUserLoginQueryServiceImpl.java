package com.gooagoo.query.business.system.sys.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.system.sys.user.SysUserLoginQueryService;
import com.gooagoo.api.generator.query.shop.ShopAuthorityGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.SysAuthorityGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.SysRoleAuthorityGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.SysUserInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.SysUserRoleGeneratorQueryService;
import com.gooagoo.common.cipher.Md5Utils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.entity.casclient.mis.MisZTreeNode;
import com.gooagoo.entity.generator.sys.SysAuthority;
import com.gooagoo.entity.generator.sys.SysAuthorityExample;
import com.gooagoo.entity.generator.sys.SysRoleAuthority;
import com.gooagoo.entity.generator.sys.SysRoleAuthorityExample;
import com.gooagoo.entity.generator.sys.SysUserInfo;
import com.gooagoo.entity.generator.sys.SysUserRole;
import com.gooagoo.entity.generator.sys.SysUserRoleExample;
import com.gooagoo.exception.common.AccountAlreadyDisabledException;
import com.gooagoo.exception.common.AccountNotExistException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.PasswordIncorrectException;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisObjectDao;

@Service
public class SysUserLoginQueryServiceImpl implements SysUserLoginQueryService
{

    @Autowired
    private SysUserInfoGeneratorQueryService sysUserInfoGeneratorQueryService;

    @Autowired
    private SysAuthorityGeneratorQueryService sysAuthorityGeneratorQueryService;

    @Autowired
    private SysUserRoleGeneratorQueryService sysUserRoleGeneratorQueryService;

    @Autowired
    private SysRoleAuthorityGeneratorQueryService sysRoleAuthorityGeneratorQueryService;

    @Autowired
    private ShopAuthorityGeneratorQueryService shopAuthorityGeneratorQueryService;

    @Override
    public MisLoginInfo login(String account, String password, Integer expireSecond) throws Exception
    {
        //1、基本验证
        if (StringUtils.isBlank(account))
        {
            GooagooLog.info("MIS用户登录：用户账号（" + account + "）为空");
            throw new NullException("MIS用户账号（" + account + "）为空");
        }
        if (StringUtils.isBlank(password))
        {
            GooagooLog.info("MIS用户登录：用户（" + account + "）输入的密码（" + password + "）为空");
            throw new NullException("MIS用户（" + account + "）输入的密码（" + password + "）为空");
        }
        //2、验证用户名,密码,状态
        SysUserInfo sysUserInfo = this.sysUserInfoGeneratorQueryService.selectUnDelByPrimaryKey(account);
        if (sysUserInfo == null)
        {
            GooagooLog.info("MIS用户登录：用户（" + account + "）不存在");
            throw new AccountNotExistException("MIS用户（" + account + "）不存在");
        }
        if ("0".equals(sysUserInfo.getStatus()))
        {
            GooagooLog.info("MIS用户登录：用户（" + account + "）已停用");
            throw new AccountAlreadyDisabledException("MIS用户登录：用户（" + account + "）已停用");
        }
        if (!sysUserInfo.getPassword().equals(new Md5Utils().encrypt(password)))
        {
            GooagooLog.info("MIS用户登录：用户（" + account + "）输入的密码（" + password + "）不正确");
            throw new PasswordIncorrectException("MIS用户（" + account + "）输入的密码（" + password + "）不正确");
        }
        //3、封装MisLoginInfo
        String token = UUID.getUUID();
        MisLoginInfo misLoginInfo = new MisLoginInfo();
        misLoginInfo.setToken(token);
        misLoginInfo.setLoginId(account);
        misLoginInfo.setPassword(sysUserInfo.getPassword());
        misLoginInfo.setStatus(sysUserInfo.getStatus());
        misLoginInfo.setIsAdmin(sysUserInfo.getIsAdmin());
        if ("Y".equals(sysUserInfo.getIsAdmin()))
        {
            misLoginInfo.setAuthorities(this.findMisZTreeNodeList4Admin());
        }
        else
        {
            misLoginInfo.setAuthorities(this.findMisZTreeNodeList4User(account));
        }
        //获取全部权限
        misLoginInfo.setAllShopAuthorities(this.findMisZTreeNodeList4Admin());
        RedisObjectDao redisObjectDao = new RedisObjectDao(RedisServerConstants.login_mis);
        redisObjectDao.set(token, misLoginInfo);
        if (expireSecond != null)
        {
            RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.login_mis);
            redisDatabase.setExpire(token, expireSecond);
        }
        return misLoginInfo;
    }

    @Override
    public MisLoginInfo getLoginInfoByToken(String token, Integer expireSecond) throws Exception
    {
        RedisObjectDao redisObjectDao = new RedisObjectDao(RedisServerConstants.login_mis);
        MisLoginInfo misLoginInfo = redisObjectDao.getGenerics(token, MisLoginInfo.class);
        if (expireSecond != null)
        {
            RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.login_mis);
            redisDatabase.setExpire(token, expireSecond);
        }
        return misLoginInfo;
    }

    @Override
    public boolean quitLogin(String token, String type) throws Exception
    {
        //验证参数是否为空
        if (StringUtils.isBlank(token) || StringUtils.isBlank(type))
        {
            return false;
        }
        String id = null;
        if ("0".equals(type))//GUS
        {
            id = RedisServerConstants.login_gus;
        }
        else if ("1".equals(type))//GMS
        {
            id = RedisServerConstants.login_gms;
        }
        else if ("2".equals(type))//MIS
        {
            id = RedisServerConstants.login_mis;
        }
        else
        {
            return false;
        }
        RedisDatabase redisObjectDao = new RedisDatabase(id);
        redisObjectDao.del(token);
        return true;
    }

    /**
     * 获取管理员权限列表(管理员获取所有权限)
     */
    private List<MisZTreeNode> findMisZTreeNodeList4Admin()
    {
        List<MisZTreeNode> misZTreeNodeList = null;
        SysAuthorityExample sysAuthorityExample = new SysAuthorityExample();
        sysAuthorityExample.createCriteria().andIsDelEqualTo("N");
        sysAuthorityExample.setOrderByClause("order_no ASC");
        List<SysAuthority> sysAuthorityList = this.sysAuthorityGeneratorQueryService.selectByExample(sysAuthorityExample);
        if (CollectionUtils.isNotEmpty(sysAuthorityList))
        {
            misZTreeNodeList = new ArrayList<MisZTreeNode>();
            for (SysAuthority sysAuthority : sysAuthorityList)
            {
                misZTreeNodeList.add(this.convertMisZTreeNode(sysAuthority));
            }
        }
        return misZTreeNodeList;
    }

    /**
     * 获取用户权限列表
     */
    private List<MisZTreeNode> findMisZTreeNodeList4User(String userId)
    {
        List<MisZTreeNode> misZTreeNodeList = null;
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        sysUserRoleExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N");
        List<SysUserRole> sysUserRoleList = this.sysUserRoleGeneratorQueryService.selectByExample(sysUserRoleExample);
        if (CollectionUtils.isNotEmpty(sysUserRoleList))
        {
            //获取用户所有权限ID(去重)
            Set<String> authorityIdSet = new HashSet<String>();
            for (SysUserRole sysUserRole : sysUserRoleList)
            {
                SysRoleAuthorityExample sysRoleAuthorityExample = new SysRoleAuthorityExample();
                sysRoleAuthorityExample.createCriteria().andRoleIdEqualTo(sysUserRole.getRoleId()).andIsDelEqualTo("N");
                List<SysRoleAuthority> sysRoleAuthorityList = this.sysRoleAuthorityGeneratorQueryService.selectByExample(sysRoleAuthorityExample);
                if (CollectionUtils.isNotEmpty(sysRoleAuthorityList))
                {
                    for (SysRoleAuthority sysRoleAuthority : sysRoleAuthorityList)
                    {
                        authorityIdSet.add(sysRoleAuthority.getAuthorityId());
                    }
                }
            }
            if (CollectionUtils.isNotEmpty(authorityIdSet))
            {
                misZTreeNodeList = new ArrayList<MisZTreeNode>();
                for (String authorityId : authorityIdSet)
                {
                    SysAuthority sysAuthority = this.sysAuthorityGeneratorQueryService.selectUnDelByPrimaryKey(authorityId);
                    misZTreeNodeList.add(this.convertMisZTreeNode(sysAuthority));
                }
            }
        }
        //根据节点编码正序排序
        return this.bubbleSortMisZTreeNode(misZTreeNodeList);
    }

    /**
     * sysAuthority转换为MisZTreeNode
     * @param sysAuthority
     * @return
     */
    private MisZTreeNode convertMisZTreeNode(SysAuthority sysAuthority)
    {
        MisZTreeNode misZTreeNode = new MisZTreeNode();
        misZTreeNode.setOpen(true);
        misZTreeNode.setChecked(true);
        misZTreeNode.setId(sysAuthority.getAuthorityId() + "");
        misZTreeNode.setName(sysAuthority.getAuthorityName());
        misZTreeNode.setpId(sysAuthority.getParentAuthorityId() + "");
        misZTreeNode.setUrl(sysAuthority.getLink());
        misZTreeNode.setNote(sysAuthority.getNote());
        return misZTreeNode;
    }

    /**节点编码正序排序
     * @param misZTreeNodeList
     * @return
     */
    private List<MisZTreeNode> bubbleSortMisZTreeNode(List<MisZTreeNode> misZTreeNodeList)
    {
        if (CollectionUtils.isNotEmpty(misZTreeNodeList))
        {
            for (int x = 0; x < misZTreeNodeList.size() - 1; x++)
            {
                for (int y = x + 1; y < misZTreeNodeList.size(); y++)
                {
                    MisZTreeNode frontNode = misZTreeNodeList.get(x);//前一个节点
                    MisZTreeNode behindNode = misZTreeNodeList.get(y);//后一个节点
                    if (frontNode.getId().compareTo(behindNode.getId()) > 0)
                    {
                        misZTreeNodeList.set(x, behindNode);
                        misZTreeNodeList.set(y, frontNode);
                    }
                }
            }
        }
        return misZTreeNodeList;
    }

}
