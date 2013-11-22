package com.gooagoo.mis.interfmanage.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.interf.merchantinterface.MerchantInterfaceManageCoreService;
import com.gooagoo.api.generator.query.sys.InterfaceBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.ShopInterfaceInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfo;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfo;
import com.gooagoo.entity.generator.sys.ShopInterfaceInfoExample;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.interfmanage.service.InterfShopService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.merchantInterface.MShopInterfaceInfo;

@Service(value = "interfShopService")
public class InterfShopServiceImpl implements InterfShopService
{
    @Autowired
    private MerchantInterfaceManageCoreService merchantInterfaceManageCoreService;
    @Autowired
    private ShopInterfaceInfoGeneratorQueryService shopInterfaceInfoGeneratorQueryService;
    @Autowired
    private InterfaceBaseInfoGeneratorQueryService interfaceBaseInfoGeneratorQueryService;

    /**
     * 商家接口信息新增
     */
    @Override
    public TransData<Object> add(HttpServletRequest request) throws GooagooException
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 商家接口信息修改
     */
    @Override
    public TransData<Object> update(HttpServletRequest request) throws Exception
    {
        MShopInterfaceInfo vo = ServletUtils.objectMethod(MShopInterfaceInfo.class, request);
        ShopInterfaceInfo shop = new ShopInterfaceInfo();
        EntityTools.copyValue(vo, shop);
        boolean flag = this.merchantInterfaceManageCoreService.updateInterface(shop);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_INTERFACE_EDIT_SUCCESS, MisMessageConst.MIS_INTERFACE_EDIT_FAIL, shop.getId());
    }

    /**
     * 商家接口信息删除
     */
    @Override
    public TransData<Object> delete(HttpServletRequest request) throws GooagooException
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 商家分配接口
     */
    @Override
    public TransData<Object> allotShopInterf(HttpServletRequest request) throws Exception
    {
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", null);
        String shopUrlAddress = ServletRequestUtils.getStringParameter(request, "shopUrlAddress", null);
        boolean flag = this.merchantInterfaceManageCoreService.allotInterface(shopUrlAddress, shopId);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_INTERFACE_ADD_SUCCESS, MisMessageConst.MIS_INTERFACE_ADD_FAIL);
    };

    /**
     * 查询商家接口信息列表(分页)
     */
    @Override
    public TransData<PageModel<MShopInterfaceInfo>> searchShopInterfList(HttpServletRequest request) throws Exception
    {
        ShopInterfaceInfoExample shopExample = new ShopInterfaceInfoExample();
        MShopInterfaceInfo shop = ServletUtils.objectMethod(MShopInterfaceInfo.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);

        // 设置查询条件
        shopExample.createCriteria().andShopIdEqualTo(shop.getShopId()).andIsDelEqualTo("N");
        PageModel<MShopInterfaceInfo> pm = new PageModel<MShopInterfaceInfo>();
        pm.setPageIndex(pageCondition.getPageIndex());
        pm.setPageSize(pageSize);
        Integer count = this.shopInterfaceInfoGeneratorQueryService.countByExample(shopExample);
        pm.setCount(count);
        if (count > 0)
        {
            shopExample.setPage(pageCondition.getPageIndex(), pageSize);
            List<ShopInterfaceInfo> list = this.shopInterfaceInfoGeneratorQueryService.selectByExample(shopExample);
            for (ShopInterfaceInfo s : list)
            {
                MShopInterfaceInfo mshop = this.converToMShopInterfaceInfo(s);
                InterfaceBaseInfo inter = interfaceBaseInfoGeneratorQueryService.selectUnDelByPrimaryKey(s.getICode());
                if (inter != null)
                {
                    mshop.setiName(inter.getIName());
                }
                pm.getResult().add(mshop);
            }
        }
        return new TransData<PageModel<MShopInterfaceInfo>>(true, null, pm);
    }

    /**
     * 查询商家接口信息(详细)
     */
    @Override
    public TransData<MShopInterfaceInfo> getShopInterfDetail(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        ShopInterfaceInfo shop = this.shopInterfaceInfoGeneratorQueryService.selectUnDelByPrimaryKey(id);
        if (shop != null && !"".equals(shop))
        {
            MShopInterfaceInfo mshop = this.converToMShopInterfaceInfo(shop);
            InterfaceBaseInfo inter = interfaceBaseInfoGeneratorQueryService.selectUnDelByPrimaryKey(shop.getICode());
            if (inter != null)
            {
                mshop.setiName(inter.getIName());
            }
            return new TransData<MShopInterfaceInfo>(true, MisMessageConst.SYS_LOAD_DATA_SUCCESS, mshop);
        }
        else
        {
            return new TransData<MShopInterfaceInfo>(true, MisMessageConst.SYS_LOAD_DATA_ERROR, null);
        }
    }

    /**
     * MShopInterfaceInfo转换为ShopInterfaceInfo
     * @param shop
     * @return
     */
    @SuppressWarnings("unused")
    private ShopInterfaceInfo converToShopInterfaceInfo(MShopInterfaceInfo shop)
    {
        ShopInterfaceInfo sho = new ShopInterfaceInfo();
        if (shop != null)
        {
            sho.setId(shop.getId());
            sho.setShopId(shop.getShopId());
            sho.setICode(shop.getiCode());
            sho.setIUrl(shop.getiUrl());
            sho.setIsDel(shop.getIsDel());
            sho.setCreateTime(shop.getCreateTime());
            sho.setCTimeStamp(shop.getCreateTime());
        }
        return sho;
    }

    /**
     * ShopInterfaceInfo转换为MShopInterfaceInfo
     * @param shop
     * @return
     */
    private MShopInterfaceInfo converToMShopInterfaceInfo(ShopInterfaceInfo shop)
    {
        MShopInterfaceInfo sho = new MShopInterfaceInfo();
        if (shop != null)
        {
            sho.setId(shop.getId());
            sho.setShopId(shop.getShopId());
            sho.setiCode(shop.getICode());
            sho.setiUrl(shop.getIUrl());
            sho.setIsDel(shop.getIsDel());
            sho.setCreateTime(shop.getCreateTime());
            sho.setcTimeStamp(shop.getCreateTime());
        }
        return sho;
    }

}
