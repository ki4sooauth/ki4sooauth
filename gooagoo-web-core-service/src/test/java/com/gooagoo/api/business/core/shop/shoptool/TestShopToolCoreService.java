package com.gooagoo.api.business.core.shop.shoptool;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

import com.gooagoo.entity.generator.shop.ShopToolList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestShopToolCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public ShopToolCoreService shopToolCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 服务工具权限分配
     * @throws Exception
     */
    @Test
    public void testUpdateShopToolAuthority() throws Exception
    {
        boolean isSucceed = this.shopToolCoreService.updateShopToolAuthority("00017QDPQFKGRS0CN00007SXUXJ1T001", "");
        Assert.isTrue(isSucceed, "服务工具权限分配");
    }

    /**
     * 添加系统服务工具
     * @throws Exception
     */
    @Test
    public void testAddSysTool() throws Exception
    {
        boolean isSucceed = this.shopToolCoreService.addSysTool("00017Q3EG198TUUV50000HFYOBYEH00F", "4", "1");
        Assert.isTrue(isSucceed, "添加系统服务工具");
    }

    /**
     * 删除商家服务工具
     * @throws Exception
     */
    @Test
    public void testDeleteShopTool() throws Exception
    {
        boolean isSucceed = this.shopToolCoreService.deleteShopTool("00017QDPQFKGRS0CN00007SXUXJ1T001");
        Assert.isTrue(isSucceed, "删除商家服务工具");
    }

    /**
     * 添加自定义服务工具
     * @throws Exception
     */
    @Test
    public void testAddCustomTool() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 编辑自定义服务工具
     * @throws Exception
     */
    @Test
    public void testUpdateCustomTool() throws Exception
    {

        Assert.isTrue(true, "");
    }

    /**
     * 修改服务工具排序
     * @throws Exception
     */
    @Test
    public void testUpdateToolSort() throws Exception
    {
        List<ShopToolList> shopToolList = new ArrayList<ShopToolList>();
        ShopToolList tl = new ShopToolList();
        tl.setId("00017QDPQFKGRS0CN00007SXUXJ1T001");
        ShopToolList tl2 = new ShopToolList();
        tl2.setId("000180PKG7JIT6UR882AF8BJ11W376P8");
        shopToolList.add(tl);
        shopToolList.add(tl2);
        boolean isSucceed = this.shopToolCoreService.updateToolSort(shopToolList);
        Assert.isTrue(isSucceed, "修改服务工具排序");
    }

}
