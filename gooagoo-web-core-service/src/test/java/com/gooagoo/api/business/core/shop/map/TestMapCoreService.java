package com.gooagoo.api.business.core.shop.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.gooagoo.entity.business.user.AreaParaDetail;
import com.gooagoo.entity.generator.shop.AreaPara;
import com.gooagoo.entity.generator.shop.GeneratrixInfo;
import com.gooagoo.entity.generator.shop.SectionLineInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestMapCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public MapCoreService mapCoreService;

    @Override
    @Resource(name = "shopSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 添加地图信息
     * @throws Exception
     */
    @Test
    public void testAddMap() throws Exception
    {
        AreaPara areaPara = new AreaPara();
        areaPara.setIsPark("1");
        areaPara.setMapId("1");
        areaPara.setMapName("1");
        //        areaPara.setOffsetX("1");
        //        areaPara.setOffsetY("1");
        //        areaPara.setRatio("1");
        areaPara.setShopEntityId("1");
        areaPara.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        areaPara.setUrlHtml("1");
        areaPara.setUrlSvg("1");
        boolean isSucceed = this.mapCoreService.addMap(areaPara);
        Assert.isTrue(isSucceed, "添加地图信息");
    }

    /**
     * 添加地图详细信息
     * @throws Exception
     */
    @Test
    public void testAddMapDetail() throws Exception
    {
        AreaParaDetail areaParaDetail = new AreaParaDetail();
        List<GeneratrixInfo> generatrixInfos = new ArrayList<GeneratrixInfo>();
        List<SectionLineInfo> sectionLineInfos = new ArrayList<SectionLineInfo>();

        GeneratrixInfo generatrixInfo = new GeneratrixInfo();
        generatrixInfo.setGeneratrixId("1");
        generatrixInfo.setGeneratrixType("1");
        generatrixInfo.setMapId("0181VTSQ0C9FRK0000M9KCBJ11W370TO");
        generatrixInfo.setSvgTagCode("1");
        generatrixInfo.setSvgTagId("area_3");
        generatrixInfos.add(generatrixInfo);

        SectionLineInfo sectionLineInfo = new SectionLineInfo();
        sectionLineInfo.setFirstPointX(1.0);
        sectionLineInfo.setFirstPointY(1.0);
        sectionLineInfo.setLength(10.0);
        sectionLineInfo.setLineId("1");
        sectionLineInfo.setMapId("0181VTSQ0C9FRK0000M9KCBJ11W370TO");
        sectionLineInfo.setSecondPointY(1.0);
        sectionLineInfo.setSecondPointX(1.0);
        sectionLineInfo.setSvgTagCode("1");
        sectionLineInfo.setWeight(10);
        sectionLineInfos.add(sectionLineInfo);

        areaParaDetail.setGeneratrixInfos(generatrixInfos);
        areaParaDetail.setSectionLineInfos(sectionLineInfos);
        boolean isSucceed = this.mapCoreService.addMapDetail(areaParaDetail);
        Assert.isTrue(isSucceed, "添加地图详细信息");
    }

    /**
     * 编辑地图信息
     * @throws Exception
     */
    @Test
    public void testUpdateMap() throws Exception
    {
        AreaPara areaPara = new AreaPara();
        areaPara.setMapId("0181VTSQ0C9FRK0000M9KCBJ11W370TO");
        areaPara.setMapName("2");
        boolean isSucceed = this.mapCoreService.updateMap(areaPara);
        Assert.isTrue(isSucceed, "编辑地图信息");
    }

    /**
     * 编辑地图详细信息
     * @throws Exception
     */
    @Test
    public void testUpdateMapDetail() throws Exception
    {
        //        AreaParaDetail areaParaDetail = new AreaParaDetail();
        //        List<AreaInfo> areaInfos = new ArrayList<AreaInfo>();
        //        List<MapElementInfo> elementInfos = new ArrayList<MapElementInfo>();
        //        List<GeneratrixInfo> generatrixInfos = new ArrayList<GeneratrixInfo>();
        //        List<SectionLineInfo> sectionLineInfos = new ArrayList<SectionLineInfo>();
        //
        //        AreaInfo areaInfo = new AreaInfo();
        //        areaInfo.setAreaId("1");
        //        areaInfo.setMapId("0181VTSQ0C9FRK0000M9KCBJ11W370TO");
        //        areaInfo.setPositionId("1");
        //        areaInfo.setPx(1.0);
        //        areaInfo.setPy(1.0);
        //        areaInfo.setSvgTagCode("");
        //        areaInfo.setSvgTagId("area_3");
        //        areaInfos.add(areaInfo);
        //
        //        MapElementInfo mapElementInfo = new MapElementInfo();
        //        mapElementInfo.setAreaId("0181VTTMV10FCRG000M9KDBJ11W370TO");
        //        mapElementInfo.setElementId("1");
        //        mapElementInfo.setElementType("1");
        //        mapElementInfo.setMapId("0181VTSQ0C9FRK0000M9KCBJ11W370TO");
        //        mapElementInfo.setPx(1.0);
        //        mapElementInfo.setPy(1.0);
        //        mapElementInfo.setSvgTagCode("1");
        //        mapElementInfo.setSvgTagId("area_3");
        //        elementInfos.add(mapElementInfo);
        //
        //        GeneratrixInfo generatrixInfo = new GeneratrixInfo();
        //        generatrixInfo.setGeneratrixId("1");
        //        generatrixInfo.setGeneratrixType("1");
        //        generatrixInfo.setMapId("0181VTSQ0C9FRK0000M9KCBJ11W370TO");
        //        generatrixInfo.setSvgTagCode("1");
        //        generatrixInfo.setSvgTagId("area_3");
        //        generatrixInfos.add(generatrixInfo);
        //
        //        SectionLineInfo sectionLineInfo = new SectionLineInfo();
        //        sectionLineInfo.setFirstPointX(1.0);
        //        sectionLineInfo.setFirstPointY(1.0);
        //        sectionLineInfo.setLength(10.0);
        //        sectionLineInfo.setLineId("1");
        //        sectionLineInfo.setMapId("0181VTSQ0C9FRK0000M9KCBJ11W370TO");
        //        sectionLineInfo.setSecondPointY(1.0);
        //        sectionLineInfo.setSecondPointX(1.0);
        //        sectionLineInfo.setSvgTagCode("1");
        //        sectionLineInfo.setWeight(10);
        //        sectionLineInfos.add(sectionLineInfo);
        //
        //        areaParaDetail.setGeneratrixInfos(generatrixInfos);
        //        areaParaDetail.setSectionLineInfos(sectionLineInfos);
        //        boolean isSucceed = this.mapCoreService.updateMapDetail(areaParaDetail);
        //        Assert.isTrue(isSucceed, "编辑地图详细信息");
    }

    /**
     * 添加地图网格信息（缓存）
     * @throws Exception
     */
    @Test
    public void testAddMapCache() throws Exception
    {
        String mapId = "189N5J38PACL9J2G8PEQCP2DVG49OLCC";
        int xGridNum = 1;
        Map<String, List<String>> positionMap = new HashMap<String, List<String>>();
        List<String> gridList = new ArrayList<String>();
        gridList.add("1");
        gridList.add("2");
        gridList.add("3");
        gridList.add("4");
        gridList.add("5");
        gridList.add("6");
        positionMap.put("1836U9BS5AOM0U2G8PEQDK10LO6LSIEQ", gridList);
        gridList = new ArrayList<String>();
        gridList.add("11");
        gridList.add("22");
        gridList.add("33");
        gridList.add("44");
        gridList.add("55");
        gridList.add("66");
        positionMap.put("1836U9BS5AOM0U2G8PEQDK10LO6LSIEL", gridList);
        List<String> outsideGridList = new ArrayList<String>();
        outsideGridList.add("1");
        outsideGridList.add("5");
        outsideGridList.add("33");
        outsideGridList.add("44");
        try
        {
            this.mapCoreService.addMapCache(mapId, xGridNum, positionMap, outsideGridList);
            Assert.isTrue(true);
        }
        catch (Exception e)
        {
            Assert.isTrue(false, e.getMessage());
        }
    }

    /**
     * 删除地图信息
     * @throws Exception
     */
    @Test
    public void testDeleteMap() throws Exception
    {
        boolean isSucceed = this.mapCoreService.deleteMap("000180PS5VI26FPNGFCBL8BJ11W374T8");
        Assert.isTrue(isSucceed, "添加地图区域详细信息");
    }

}
