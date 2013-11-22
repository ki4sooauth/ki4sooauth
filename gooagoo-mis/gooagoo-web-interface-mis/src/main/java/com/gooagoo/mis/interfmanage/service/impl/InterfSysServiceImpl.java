package com.gooagoo.mis.interfmanage.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.generator.query.sys.ShopInterfaceInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfo;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfoExample;
import com.gooagoo.mis.interfmanage.service.InterfSysService;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.merchantInterface.MShopInterfaceInfo;

@Service(value = "interfSysService")
public class InterfSysServiceImpl implements InterfSysService
{
    @Autowired
    private ShopInterfaceInfoGeneratorQueryService shopInterfaceInfoGeneratorQueryService;

    @Override
    public TransData<Object> add(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TransData<Object> update(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TransData<Object> delete(HttpServletRequest request) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean allotShopInterface(String shopId) throws Exception
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * 查询商家接口信息列表
     */
    @Override
    public TransData<PageModel<MShopInterfaceInfo>> searchShopInterfList(HttpServletRequest request) throws Exception
    {
        ShopInterfaceInfoExample interfaceExample = new ShopInterfaceInfoExample();
        MShopInterfaceInfo vo = ServletUtils.objectMethod(MShopInterfaceInfo.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        interfaceExample.createCriteria().andShopIdEqualTo(vo.getShopId());
        PageModel<MShopInterfaceInfo> pm = new PageModel<MShopInterfaceInfo>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.shopInterfaceInfoGeneratorQueryService.countByExample(interfaceExample);
        pm.setCount(count);
        if (count > 0)
        {
            interfaceExample.setPage(pm.getPageIndex(), pageSize);// 设置分页条件
            List<ShopInterfaceInfo> interList = this.shopInterfaceInfoGeneratorQueryService.selectByExample(interfaceExample);
            for (ShopInterfaceInfo inter : interList)
            {
                pm.getResult().add(this.converToMShopInterfaceInfo(inter));
            }
        }
        return new TransData<PageModel<MShopInterfaceInfo>>(true, null, pm);
    }

    /**
     * ShopInterfaceInfo转换为MShopInterfaceInfo
     * @param interfaceInfo
     * @return
     */
    private MShopInterfaceInfo converToMShopInterfaceInfo(ShopInterfaceInfo interfaceInfo)
    {
        MShopInterfaceInfo inter = new MShopInterfaceInfo();
        if (interfaceInfo != null)
        {
            inter.setId(interfaceInfo.getId());
            inter.setShopId(interfaceInfo.getShopId());
            inter.setiCode(interfaceInfo.getICode());
            inter.setiUrl(interfaceInfo.getIUrl());
            inter.setIsDel(interfaceInfo.getIsDel());
            inter.setCreateTime(interfaceInfo.getCreateTime());
            inter.setcTimeStamp(interfaceInfo.getCTimeStamp());
        }
        return inter;
    }
}
