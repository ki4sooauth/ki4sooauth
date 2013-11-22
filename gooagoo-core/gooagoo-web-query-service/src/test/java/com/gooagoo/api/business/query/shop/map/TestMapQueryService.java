package com.gooagoo.api.business.query.shop.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.shop.map.SvgAreaTip;
import com.google.gson.Gson;

public class TestMapQueryService
{

    public MapQueryService mapQueryService;

    @Before
    public void testBefore()
    {
        this.mapQueryService = ApplicationContextUtils.getBean(MapQueryService.class);
    }

    /**
     * 添加或更新 网格坐标信息 缓存数据
     * @throws Exception
     */
    @Test
    public void testAddOrUpdateGridCoordinateInfoCacheData() throws Exception
    {
        Map<String, Map<String, String>> gridMap = new HashMap<String, Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "a");
        map.put("2", "b");
        gridMap.put("test", map);
        Assert.assertTrue("添加或更新 网格坐标信息 缓存数据失败", this.mapQueryService.addOrUpdateGridCoordinateInfoCacheData(gridMap));
    }

    /**
     * 地图列表查询
     * @throws Exception
     */
    @Test
    public void testFindMapList() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 查看地图
     * @throws Exception
     */
    @Test
    public void testFindMap() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 测试地图
     * @throws Exception
     */
    @Test
    public void testTestMap() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 通过地图编码查询地图区域上的提示信息列表
     * @throws Exception
     */
    @Test
    public void testMapAreaTips() throws Exception
    {
        List<SvgAreaTip> list = this.mapQueryService.findMapAreaTips("000180UDVFOA5S548BNB1TBJ11W374F0");
        if (list != null)
        {
            System.out.println(new Gson().toJson(list));
        }
        Assert.assertNotNull("通过地图编码查询地图区域上的提示信息列表", list);
    }

}
