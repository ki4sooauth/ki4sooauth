package com.gooagoo.mis.rsrcmanage.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.hierarchy.TradeAreaCoreService;
import com.gooagoo.api.generator.query.sys.PlatformRegionGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.TradeAreaGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.sys.PlatformRegion;
import com.gooagoo.entity.generator.sys.TradeArea;
import com.gooagoo.entity.generator.sys.TradeAreaExample;
import com.gooagoo.entity.generator.sys.TradeAreaExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.rsrcmanage.service.TradeAreaService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.systemHierarchy.MTradeArea;

@Service(value = "tradeAreaService")
public class TradeAreaServiceImpl implements TradeAreaService
{
    @Autowired
    private TradeAreaGeneratorQueryService tradeAreaGeneratorQueryService;
    @Autowired
    private PlatformRegionGeneratorQueryService platformRegionGeneratorQueryService;
    @Autowired
    private TradeAreaCoreService tradeAreaCoreService;

    /**
     * 新增商圈信息
     */
    @Override
    public TransData<Object> addTradeArea(HttpServletRequest request) throws Exception
    {
        TradeArea tradeArea = ServletUtils.objectMethod(TradeArea.class, request);
        boolean flag = this.tradeAreaCoreService.addTradeArea(tradeArea);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.SYS_ADD_SUCCESS, MisMessageConst.SYS_ADD_FAIL);
    }

    /**
     * 删除商圈信息
     */
    @Override
    public TransData<Object> deleteTradeArea(HttpServletRequest request) throws Exception
    {
        TradeArea tradeArea = ServletUtils.objectMethod(TradeArea.class, request);
        boolean flag = this.tradeAreaCoreService.deleteTradeArea(tradeArea.getTradeAreaId());
        return UtilsMis.getBooleanResult(flag, MisMessageConst.SYS_DEL_SUCCESS, MisMessageConst.SYS_DEL_FAIL);
    }

    /**
     * 查询商圈详细信息
     */
    @Override
    public TransData<MTradeArea> queryTradeAreaInfo(HttpServletRequest request) throws Exception
    {
        TradeArea tradeArea = ServletUtils.objectMethod(TradeArea.class, request);
        TradeArea trade = this.tradeAreaGeneratorQueryService.selectUnDelByPrimaryKey(tradeArea.getTradeAreaId().split(",")[0]);
        if (trade != null)
        {
            MTradeArea mtrade = new MTradeArea();
            EntityTools.copyValue(trade, mtrade);
            return new TransData<MTradeArea>(true, null, mtrade);
        }
        else
        {
            return new TransData<MTradeArea>(true, MisMessageConst.SYS_LOAD_DATA_ERROR, null);
        }
    }

    /**
     * 修改商圈信息
     */
    @Override
    public TransData<Object> updateTradeArea(HttpServletRequest request) throws Exception
    {
        TradeArea tradeArea = ServletUtils.objectMethod(TradeArea.class, request);
        boolean flag = this.tradeAreaCoreService.updateTradeArea(tradeArea);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.SYS_UPD_SUCCESS, MisMessageConst.SYS_UPD_FAIL);
    }

    /**
     * 查询所有商圈信息
     */
    @Override
    public TransData<PageModel<MTradeArea>> queryTradeAreaList(HttpServletRequest request) throws Exception
    {
        TradeArea tradeArea = ServletUtils.objectMethod(TradeArea.class, request);
        String tradeAreaNoPage = ServletRequestUtils.getStringParameter(request, "tradeAreaNoPage", null);//是否分页查询（null时分页查询）
        TradeAreaExample example = new TradeAreaExample();
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo("N");
        if (StringUtils.hasText(tradeArea.getPlatformId()))
        {
            criteria.andPlatformIdEqualTo(tradeArea.getPlatformId());
        }
        if (StringUtils.hasText(tradeArea.getTradeAreaName()))
        {
            criteria.andTradeAreaNameLike("%" + tradeArea.getTradeAreaName() + "%");
        }
        PageModel<MTradeArea> pm = new PageModel<MTradeArea>();
        PageCondition condition = ServletUtils.objectMethod(PageCondition.class, request);
        if (condition != null && tradeAreaNoPage == null)
        {
            pm.setPageIndex(condition.getPageIndex() <= 1 ? 1 : condition.getPageIndex());
            pm.setPageSize(condition.getPageSize() <= 10 ? 10 : condition.getPageSize());
        }
        Integer count = this.tradeAreaGeneratorQueryService.countByExample(example);
        if (count > 0)
        {
            if (condition != null && tradeAreaNoPage == null)
            {
                example.setPage(pm.getPageIndex(), pm.getPageSize());
            }
            List<TradeArea> tradeAreaList = this.tradeAreaGeneratorQueryService.selectByExample(example);
            for (TradeArea trade : tradeAreaList)
            {
                MTradeArea mtrade = new MTradeArea();
                EntityTools.copyValue(trade, mtrade);
                if (StringUtils.hasText(trade.getPlatformId()))
                {
                    PlatformRegion platformRegion = this.platformRegionGeneratorQueryService.selectUnDelByPrimaryKey(trade.getPlatformId());
                    if (platformRegion != null)
                    {
                        mtrade.setPlatformName(platformRegion.getPlatformName());
                    }
                }
                pm.getResult().add(mtrade);
            }
        }
        return new TransData<PageModel<MTradeArea>>(true, null, pm);
    }

}
