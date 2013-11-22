package com.gooagoo.api.business.query.system.sys.user;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;

public class TestSysUserLoginQueryService
{

    public SysUserLoginQueryService sysUserLoginQueryService;

    @Before
    public void testBefore()
    {
        this.sysUserLoginQueryService = ApplicationContextUtils.getBean(SysUserLoginQueryService.class);
    }

    /**
     * MIS用户登录
     * @throws Exception
     */
    @Test
    public void testLogin()
    {
        String account = "1@1.com";
        String password = "aaa111";
        Integer expireSecond = 1800;
        MisLoginInfo misLoginInfo;
        try
        {
            misLoginInfo = this.sysUserLoginQueryService.login(account, password, expireSecond);
            System.out.println("token=" + misLoginInfo.getToken());
            Assert.assertNotNull("MIS用户登录失败", misLoginInfo);
        }
        catch (Exception e)
        {
            Assert.assertTrue(e.getMessage(), false);
        }
    }

    /**
     * 根据token值获取mis用户登录信息
     * @throws Exception
     */
    @Test
    public void testGetLoginInfoByToken() throws Exception
    {
        String token = "01820ENHBV4E4BC00DCHP9Z5O9YBD6IG";
        Integer expireSecond = 1800;
        MisLoginInfo misLoginInfo = this.sysUserLoginQueryService.getLoginInfoByToken(token, expireSecond);
        Assert.assertNotNull("根据token值获取mis用户登录信息失败", misLoginInfo);
    }
}
