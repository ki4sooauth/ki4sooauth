package com.gooagoo.igms.map.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.map.MapCoreService;
import com.gooagoo.api.generator.query.shop.AreaParaGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSFile;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.gms.utils.GmapUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.entity.business.user.AreaParaDetail;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.AreaPara;
import com.gooagoo.entity.generator.shop.AreaParaExample;
import com.gooagoo.entity.generator.shop.GeneratrixInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.exception.MessageException;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.map.service.AreaMapService;
import com.gooagoo.igms.map.util.SvgParseGeneratrixUtil;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.map.FAreaMapInfo;

@Service("areaMapService")
public class AreaMapServiceImpl implements AreaMapService
{
    @Autowired
    private ShopLoginService shopLoginService;
    @Autowired
    private MapCoreService mapCoreService;
    @Autowired
    private AreaParaGeneratorQueryService areaParaGeneratorQueryService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;
    @Autowired
    private ShopPositionGeneratorQueryService shopPositionGeneratorQueryService;

    /**
     * 保存区域地图信息
     */
    @Override
    public TransData<String> addAreaMap(HttpServletRequest request) throws Exception
    {
        FAreaMapInfo areaMapInfo = ServletUtils.objectMethod(FAreaMapInfo.class, request);
        String urlSvg = request.getParameter("urlSvg");

        AreaPara areaPara = this.convertToAreaPara(areaMapInfo);
        String id = StringUtils.getUUID();
        areaPara.setUrlSvg(urlSvg);
        areaPara.setMapId(id);
        areaPara.setUrlHtml("");
        areaPara.setNote("");
        areaPara.setIsDel("N");
        areaPara.setCreateTime(new Date());

        Document document = GMSFile.getDocumentByUrl(areaPara.getUrlSvg());
        this.perfectInfo(areaPara, document.getRootElement());

        areaPara.setShopId(GmsInterfaceUtil.getShopIdByInterface(request));

        //获取“动线信息”及“分段线路信息”
        AreaParaDetail areaParaDetail = this.getAreaParaDetailInfo(document, id);

        boolean result = false;
        //生成html文件
        String svgHtml = this.generateSvgHtml(areaPara.getMapId(), document.asXML(), areaPara.getUrlHtml());
        if (org.springframework.util.StringUtils.hasText(svgHtml))
        {
            result = true;
            areaPara.setUrlHtml(svgHtml);
        }
        else
        {
            GooagooLog.warn("上传svg静态文件失败，mapId=" + areaPara.getMapId() + ",svgUrl=" + areaPara.getUrlSvg());
        }
        if (result && this.checkAreaPara(areaPara))
        {
            result = this.mapCoreService.addMap(areaPara);
            if (result)
            {
                if (areaParaDetail.getGeneratrixInfos().size() > 0)
                {
                    result = this.mapCoreService.addMapDetail(areaParaDetail);
                }
            }
        }
        return GMSUtil.getBooleanAndExtendResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, id, id);
    }

    /**
     * 修改区域地图信息
     */
    @Override
    public TransData<String> updateAreaMap(HttpServletRequest request) throws Exception
    {
        FAreaMapInfo areaMapInfo = ServletUtils.objectMethod(FAreaMapInfo.class, request);
        String mapId = ServletRequestUtils.getStringParameter(request, "mapId", "");
        String urlSvg = request.getParameter("urlSvg");

        AreaPara areaPara = this.convertToAreaPara(areaMapInfo);
        areaPara.setUrlSvg(urlSvg);
        Document document = GMSFile.getDocumentByUrl(areaPara.getUrlSvg());

        this.perfectInfo(areaPara, document.getRootElement());

        //获取“动线信息”及“分段线路信息”
        AreaParaDetail areaParaDetail = this.getAreaParaDetailInfo(document, mapId);

        boolean result = false;
        //生成html文件
        String svgHtml = this.generateSvgHtml(areaPara.getMapId(), document.asXML(), areaPara.getUrlHtml());
        if (org.springframework.util.StringUtils.hasText(svgHtml))
        {
            result = true;
            areaPara.setUrlHtml(svgHtml);
        }
        else
        {
            GooagooLog.warn("上传svg静态文件失败，mapId=" + areaPara.getMapId() + ",svgUrl=" + areaPara.getUrlSvg());
        }
        if (result && this.checkAreaPara(areaPara))
        {
            result = this.mapCoreService.updateMap(areaPara);
            if (result)
            {
                if (areaParaDetail.getGeneratrixInfos().size() > 0)
                {
                    result = this.mapCoreService.updateMapDetail(areaParaDetail);
                }
            }
        }

        return GMSUtil.getBooleanAndExtendResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, areaMapInfo.getMapId(), areaMapInfo.getMapId());
    }

    /**
     * 删除区域地图信息
     */
    @Override
    public TransData<Object> delAreaMap(HttpServletRequest request) throws Exception
    {
        String mapId = request.getParameter("mapId");
        boolean flag = this.mapCoreService.deleteMap(mapId);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, mapId);
    }

    /**
     * 区域地图信息列表
     */
    @Override
    public TransData<PageModel<FAreaMapInfo>> pageAreaMap(HttpServletRequest request) throws Exception
    {
        ShopLoginInfo gmsLoginInfo = this.shopLoginService.getShopLoginInfo(request);

        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);

        PageModel<FAreaMapInfo> pm = new PageModel<FAreaMapInfo>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());
        if (pc.getPageSize() == 0)
        {
            pm.setPageSize(10);
        }
        AreaParaExample example = new AreaParaExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        com.gooagoo.entity.generator.shop.AreaParaExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo("N");
        criteria.andShopIdEqualTo(gmsLoginInfo.getShopAndUserInfo().getShopId());
        if (gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId() != null && !gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId().isEmpty())
        {
            criteria.andShopEntityIdEqualTo(gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId());
        }
        int count = this.areaParaGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<AreaPara> areaParas = this.areaParaGeneratorQueryService.selectByExample(example);
            for (AreaPara areaPara : areaParas)
            {
                pm.getResult().add(this.convertToFAreaMapInfo(areaPara));
            }
        }

        return new TransData<PageModel<FAreaMapInfo>>(true, MessageConst.GMS_OPERATE_SUCCESS, pm);
    }

    /**
     * 获取区域地图信息
     */
    @Override
    public TransData<Object> getAreaMapInfo(HttpServletRequest request) throws Exception
    {
        String mapId = ServletRequestUtils.getStringParameter(request, "mapId", "");

        AreaPara areaPara = this.areaParaGeneratorQueryService.selectByPrimaryKey(mapId);
        FAreaMapInfo areaMapInfo = this.convertToFAreaMapInfo(areaPara);

        ShopEntityInfo shopEntityInfo = this.shopEntityInfoGeneratorQueryService.selectByPrimaryKey(areaPara.getShopEntityId());
        ShopPosition shopPosition = this.shopPositionGeneratorQueryService.selectByPrimaryKey(areaPara.getPositionId());

        areaMapInfo.setShopEntityName(shopEntityInfo.getShopEntityName());
        areaMapInfo.setPositionName(shopPosition.getPositionName());

        return new TransData<Object>(true, MessageConst.GMS_OPERATE_SUCCESS, areaMapInfo, mapId);
    }

    /**
     * 获取“动线信息”及“分段线路信息”
     * @param document svg对应的Document对象
     * @param id
     * @return
     */
    private AreaParaDetail getAreaParaDetailInfo(Document document, String id)
    {
        AreaParaDetail areaParaDetail = new AreaParaDetail();
        SvgParseGeneratrixUtil svgUtil = new SvgParseGeneratrixUtil();
        List<GeneratrixInfo> generatrixInfos = svgUtil.getAllGeneratrixInfos(document, id, GmapUtil.getGeneratrixIdentityProperty());
        areaParaDetail.setGeneratrixInfos(generatrixInfos);
        areaParaDetail.setSectionLineInfos(svgUtil.getAllSectionLineInfos(generatrixInfos, id));

        return areaParaDetail;
    }

    /**
     * 完善区域地图信息
     * @param areaMapInfo
     * @param root 根节点
     * @return
     * @throws DocumentException
     */
    private AreaPara perfectInfo(AreaPara areaPara, Element root) throws Exception
    {
        // svg的宽度
        int width = 0;
        // svg的高度
        int height = 0;

        Attribute attribute = root.attribute("width");
        if (attribute != null)
        {
            String wString = attribute.getText().toLowerCase();
            wString = wString.replace("px", "").trim();
            double w = Double.parseDouble(wString);
            width = (int) w;
        }
        attribute = root.attribute("height");
        if (attribute != null)
        {
            String hString = attribute.getText().toLowerCase();
            hString = hString.replace("px", "").trim();
            double h = Double.parseDouble(hString);
            height = (int) h;
        }
        //地图真实长度与SVG图高度比例系数
        double hRatio = (areaPara.getMapRealHeight()) / ((double) height);
        //地图真实宽度与SVG图宽度比例系数
        double WRatio = (areaPara.getMapRealWidth()) / ((double) width);

        if ((hRatio / WRatio) >= 0.95 && (hRatio / WRatio) <= 1.05)
        {
            areaPara.setRatioSvg(((double) areaPara.getMapRealHeight()) / height);
        }
        else
        {
            GooagooLog.warn("误差过大,hr:" + areaPara.getMapRealHeight() + "/" + height + "=" + hRatio + ",wr=" + areaPara.getMapRealWidth() + "/" + width + "=" + WRatio);
            throw new MessageException(MessageConst.GMS_AREAPARA_ACTUALMAP_AND_SVG_PER_ERROR_IS_TOO_LARGE);
        }
        return areaPara;
    }

    /**
     * 校验
     * @param areaPara
     * @return
     */
    private boolean checkAreaPara(AreaPara areaPara)
    {
        //TODO

        return true;
    }

    private String generateSvgHtml(String mapId, String svgContent, String filePath)
    {
        //        String svg = HttpClientUtils.loadFileStringByUrl(ap.getUrlSvg());
        //        List<SvgAreaTip> reList = this.mapQueryService.findMapAreaTips(mapId);
        //        String str = GmapUtil.getDivContent(reList);
        if (!org.springframework.util.StringUtils.hasText(filePath))
        {
            filePath = "";
        }
        String svgHtml = GmapUtil.getSvgHtml(svgContent, "");

        // 上传地址html 到服务器
        String htmlUrl = GMSHttpUtils.uploadFileByString("map", filePath, svgHtml, mapId + ".html");

        return htmlUrl;
    }

    private FAreaMapInfo convertToFAreaMapInfo(AreaPara areaPara) throws IllegalArgumentException, IllegalAccessException
    {
        FAreaMapInfo fAreaMapInfo = new FAreaMapInfo();
        if (areaPara != null)
        {
            EntityTools.copyValue(areaPara, fAreaMapInfo);
        }
        return fAreaMapInfo;
    }

    private AreaPara convertToAreaPara(FAreaMapInfo areaMapInfo) throws IllegalArgumentException, IllegalAccessException
    {
        AreaPara areaPara = new AreaPara();
        if (areaMapInfo != null)
        {
            EntityTools.copyValue(areaMapInfo, areaPara);
        }
        return areaPara;
    }
}
