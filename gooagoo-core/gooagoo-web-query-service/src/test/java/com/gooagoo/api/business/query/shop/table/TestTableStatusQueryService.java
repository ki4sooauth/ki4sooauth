package com.gooagoo.api.business.query.shop.table;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.shop.table.TableDiningStatus;
import com.gooagoo.entity.business.shop.table.TableStatus;
import com.gooagoo.entity.business.shop.table.TableStatusByType;
import com.gooagoo.entity.business.shop.table.TableTypeStatus;

public class TestTableStatusQueryService
{

    public TableStatusQueryService tableStatusQueryService;

    @Before
    public void testBefore()
    {
        this.tableStatusQueryService = ApplicationContextUtils.getBean(TableStatusQueryService.class);
    }

    /**
     * gasj01、gasj06、mobe12
     * @throws Exception
     */
    @Test
    public void testFindTableTypeStatus() throws Exception
    {
        String tableTypeCode = "018235JJFJAKA3302VLL2QEIISWR2TKG";
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        int pageIndex = 1;
        int pageSize = 1;
        List<TableTypeStatus> list = this.tableStatusQueryService.findTableTypeStatus(tableTypeCode, shopEntityId, pageIndex, pageSize);
        Assert.assertTrue(CollectionUtils.isNotEmpty(list));
    }

    /**
     * 按餐桌类型查询实体店餐桌状态
     * @throws Exception
     */
    @Test
    public void testFindTableStatusByType() throws Exception
    {
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        String tableTypeCode = "018235KT8PIH5R802VLL2SEIISWR2TKG";
        Integer pageIndex = 1;
        Integer pageSize = 10;
        List<TableStatusByType> tableStatusByTypeList = this.tableStatusQueryService.findTableStatusByType(shopEntityId, tableTypeCode, null, pageIndex, pageSize);
        Assert.assertTrue("查询实体店餐桌状态失败", CollectionUtils.isNotEmpty(tableStatusByTypeList));
    }

    /**
     * gtsc09
     * @throws Exception
     */
    @Test
    public void testFindTableStatus() throws Exception
    {
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";
        Integer pageIndex = null;
        Integer pageSize = null;
        List<TableStatus> tableStatusList = this.tableStatusQueryService.findTableStatus(shopEntityId, pageIndex, pageSize);
        Assert.assertTrue("查询餐桌状态失败", CollectionUtils.isNotEmpty(tableStatusList));
    }

    /**
     * gasl02
     * @throws Exception
     */
    @Test
    public void testFindTableDiningStatus() throws Exception
    {
        String shopEntityId = "000180RS58HOBN1DU4OI4UBJ11W375KC";
        String tableName = null;
        Integer pageIndex = null;
        Integer pageSize = null;
        List<TableDiningStatus> list = this.tableStatusQueryService.findTableDiningStatus(shopEntityId, tableName, pageIndex, pageSize);
        Assert.assertNotNull("查询正在用餐餐桌的状态失败(人员用餐情况)", list);
    }
}
