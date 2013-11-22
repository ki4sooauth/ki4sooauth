package com.gooagoo.mis.usermanage.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.user.enterprise.ToolsManageCoreService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopToolListGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopToolList;
import com.gooagoo.entity.generator.shop.ShopToolListExample;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.usermanage.service.ShopToolService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MShopInfo;
import com.gooagoo.view.mis.enterprise.MShopToolList;

@Service(value = "shopToolService")
public class ShopToolServiceImpl implements ShopToolService
{
    @Autowired
    private ShopToolListGeneratorQueryService shopToolListGeneratorQueryService;
    @Autowired
    private ToolsManageCoreService toolsManageCoreService;
    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    /**
     * 查询服务工具列表(分页)
     */
    @Override
    public TransData<PageModel<MShopToolList>> searchShopToolList(HttpServletRequest request) throws Exception
    {
        ShopToolListExample toolExample = new ShopToolListExample();
        MShopToolList vo = ServletUtils.objectMethod(MShopToolList.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        toolExample.createCriteria().andShopIdEqualTo(vo.getShopId()).andIsDelEqualTo("N");
        PageModel<MShopToolList> pm = new PageModel<MShopToolList>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.shopToolListGeneratorQueryService.countByExample(toolExample);
        pm.setCount(count);
        if (count > 0)
        {
            toolExample.setPage(pm.getPageIndex(), pageSize);// 设置分页条件
            List<ShopToolList> list = this.shopToolListGeneratorQueryService.selectByExample(toolExample);
            for (ShopToolList s : list)
            {
                MShopToolList ms = new MShopToolList();
                EntityTools.copyValue(s, ms);
                pm.getResult().add(ms);
            }
        }
        return new TransData<PageModel<MShopToolList>>(true, null, pm);
    }

    /**
     * 查询服务工具信息(详细)
     * **用户管理-服务工具没用到，待定**
     */
    @Override
    public TransData<MShopToolList> getShopToolDetail(HttpServletRequest request) throws Exception
    {
        // TODO 用户管理-服务工具没用到，待定
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        ShopToolList vo = this.shopToolListGeneratorQueryService.selectUnDelByPrimaryKey(id);
        if (vo != null && !"".equals(vo))
        {
            MShopToolList mtool = new MShopToolList();
            EntityTools.copyValue(vo, mtool);
            return new TransData<MShopToolList>(true, MisMessageConst.SYS_LOAD_DATA_SUCCESS, mtool);
        }
        else
        {
            return new TransData<MShopToolList>(true, MisMessageConst.SYS_LOAD_DATA_ERROR, null);
        }
    }

    /**
     * 修改、删除服务工具
     */
    @Override
    public TransData<Object> update(HttpServletRequest request) throws Exception
    {
        MShopToolList vo = ServletUtils.objectMethod(MShopToolList.class, request);
        boolean flag = false;
        if ("Y".equals(vo.getIsDel()))
        {
            flag = this.toolsManageCoreService.delTools(vo.getId());
        }
        else
        {
            flag = this.toolsManageCoreService.updateTools(vo.getId(), vo.getStatus());
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_USERMANA_ENTOOL_UPD_SUCCESS, MisMessageConst.MIS_USERMANA_ENTOOL_UPD_FAIL, vo.getId());
    }

    /**
     * 查询商家详情
     */
    @Override
    public TransData<MShopInfo> searchServerToolShopDetail(HttpServletRequest request) throws Exception
    {
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(shopId);
        if (shopInfo != null && !"".equals(shopInfo))
        {
            MShopInfo mshop = new MShopInfo();
            EntityTools.copyValue(shopInfo, mshop);
            return new TransData<MShopInfo>(true, MisMessageConst.SYS_LOAD_DATA_SUCCESS, mshop);
        }
        else
        {
            return new TransData<MShopInfo>(false, MisMessageConst.GMS_SHOPINFO_BASE_QUERY_FAIL, null);
        }
    }

}
