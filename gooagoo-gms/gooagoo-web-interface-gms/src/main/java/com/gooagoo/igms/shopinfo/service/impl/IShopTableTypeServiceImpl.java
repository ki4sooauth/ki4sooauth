package com.gooagoo.igms.shopinfo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.table.TableTypeCoreService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopTableTypeManageGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopTableTypeManage;
import com.gooagoo.entity.generator.shop.ShopTableTypeManageExample;
import com.gooagoo.entity.generator.shop.ShopTableTypeManageExample.Criteria;
import com.gooagoo.igms.shopinfo.service.IShopTableTypeService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopTableType;

@Service("shopTableTypeService")
public class IShopTableTypeServiceImpl implements IShopTableTypeService
{

    @Autowired
    private ShopTableTypeManageGeneratorQueryService tableTypeQueryService;
    @Autowired
    private TableTypeCoreService tableTypeCoreService;
    @Autowired
    private ShopLoginService shopLoginService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;

    @Override
    public TransData<FShopTableType> getTableType(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id");
        FShopTableType t = new FShopTableType();
        ShopTableTypeManage manage = this.tableTypeQueryService.selectByPrimaryKey(id);
        BeanUtils.copyProperties(manage, t);
        t.setId(manage.getTableTypeCode());
        t.setName(manage.getTableTypeName());
        return GMSUtil.toTransData(true, null, t);
    }

    @Override
    public TransData<Object> addTableType(HttpServletRequest request) throws Exception
    {
        String id = com.gooagoo.common.utils.StringUtils.getUUID();
        ShopTableTypeManage fShopTableType = ServletUtils.objectMethod(ShopTableTypeManage.class, request);
        ShopLoginInfo gmsLoginInfo = this.shopLoginService.getShopLoginInfo(request);
        fShopTableType.setShopId(gmsLoginInfo.getShopAndUserInfo().getShopId());
        fShopTableType.setIsDel("N");
        fShopTableType.setCreateTime(new Date());
        fShopTableType.setTableTypeCode(id);
        if (StringUtils.hasText(gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId()))
        {
            fShopTableType.setShopEntityId(gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId());
        }
        boolean flag = this.tableTypeCoreService.addShopTableTypeManage(fShopTableType);
        TransData<Object> r = GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
        r.setData(id);
        return r;
    }

    @Override
    public TransData<Object> delTableType(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        boolean flag = this.tableTypeCoreService.deleteShopTableTypeManage(id);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, id);
    }

    @Override
    public TransData<Object> updateTableType(HttpServletRequest request) throws Exception
    {
        ShopTableTypeManage fShopUserInfo = ServletUtils.objectMethod(ShopTableTypeManage.class, request);
        boolean flag = this.tableTypeCoreService.updateShopTableTypeManage(fShopUserInfo);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, fShopUserInfo.getTableTypeCode());
    }

    @Override
    public TransData<PageModel<FShopTableType>> listTableType(HttpServletRequest request) throws Exception
    {
        ShopTableTypeManageExample example = new ShopTableTypeManageExample();
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        String name = ServletRequestUtils.getStringParameter(request, "name", "");
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo("N");
        ShopLoginInfo gmsLoginInfo = this.shopLoginService.getShopLoginInfo(request);
        criteria.andShopIdEqualTo(gmsLoginInfo.getShopAndUserInfo().getShopId());
        if (StringUtils.hasText(gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId()))
        {
            criteria.andShopEntityIdEqualTo(gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId());
        }
        if (StringUtils.hasText(shopEntityId))
        {
            criteria.andShopEntityIdEqualTo(shopEntityId);
        }
        if (StringUtils.hasText(name))
        {
            criteria.andTableTypeNameLike("%" + name + "%");
        }
        int count = this.tableTypeQueryService.countByExample(example);

        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        example.setPage(pageIndex, pageSize);

        List<ShopTableTypeManage> list = this.tableTypeQueryService.selectByExample(example);
        List<FShopTableType> tableTypes = new ArrayList<FShopTableType>();
        for (ShopTableTypeManage m : list)
        {
            ShopEntityInfo entityInfo = this.shopEntityInfoGeneratorQueryService.selectByPrimaryKey(m.getShopEntityId());
            FShopTableType t = new FShopTableType();
            BeanUtils.copyProperties(m, t);
            t.setShopEntityName(entityInfo.getShopEntityName());
            t.setName(m.getTableTypeName());
            t.setId(m.getTableTypeCode());
            tableTypes.add(t);
        }
        PageModel<FShopTableType> pm = new PageModel<FShopTableType>();
        pm.setCount(count);
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);
        pm.setResult(tableTypes);
        return GMSUtil.toTransData(true, null, pm);
    }
}
