package com.gooagoo.igms.shopinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.shop.table.TableCoreService;
import com.gooagoo.api.business.query.shop.table.TableStatusQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopTableInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.entity.business.shop.table.TableStatusByType;
import com.gooagoo.entity.business.shop.table.TableTypeStatus;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample;
import com.gooagoo.entity.generator.shop.ShopTableInfo;
import com.gooagoo.entity.generator.shop.ShopTableInfoExample;
import com.gooagoo.entity.generator.shop.ShopTableInfoExample.Criteria;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.shopinfo.service.IShopInfoCacheService;
import com.gooagoo.igms.shopinfo.service.ITableInfoService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FTableInfo;

@Service("itableInfoService")
public class ITableInfoServiceImpl implements ITableInfoService
{
    @Autowired
    private ShopTableInfoGeneratorQueryService queryDeskService;
    @Autowired
    private ShopLoginService shopLoginService;
    @Autowired
    private TableCoreService coreDeskService;

    @Autowired
    private IShopInfoCacheService iShopInfoCacheService;
    @Autowired
    private TableStatusQueryService statusQueryService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;

    @Override
    public TransData<Object> addTableInfo(HttpServletRequest request) throws Exception
    {
        String id = StringUtils.getUUID();
        ShopTableInfo shopTableInfo = ServletUtils.objectMethod(ShopTableInfo.class, request);
        shopTableInfo.setId(id);
        shopTableInfo.setShopId(GmsInterfaceUtil.getShopIdByInterface(request));
        shopTableInfo.setStatus("1");
        boolean flag = this.coreDeskService.addTable(shopTableInfo);
        TransData<Object> r = GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
        r.setData(id);
        r.setOperateId(id);
        return r;
    }

    @Override
    public TransData<Object> deleteTableInfo(HttpServletRequest request) throws Exception
    {
        String tableId = ServletRequestUtils.getStringParameter(request, "tableId", "");
        boolean flag = this.coreDeskService.deleteTable(tableId);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, tableId);
    }

    @Override
    public TransData<FTableInfo> getTableInfo(HttpServletRequest request) throws Exception
    {
        String tableId = ServletRequestUtils.getStringParameter(request, "tableId", "");
        FTableInfo tableInfo = this.iShopInfoCacheService.getFTableInfo(tableId);
        return GMSUtil.toTransData(true, null, tableInfo);
    }

    @Override
    public TransData<PageModel<FTableInfo>> pageTableInfo(HttpServletRequest request) throws Exception
    {
        FTableInfo tableInfo = ServletUtils.objectMethod(FTableInfo.class, request);
        ShopLoginInfo loginInfo = this.shopLoginService.getShopLoginInfo(request);
        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 99910);
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        String orderBy = ServletRequestUtils.getStringParameter(request, "orderBy", " c_time_stamp desc  ");
        String tableTypeCode = ServletRequestUtils.getStringParameter(request, "tableTypeCode", "");

        ShopTableInfoExample example = new ShopTableInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(loginInfo.getShopAndUserInfo().getShopId()).andIsDelEqualTo("N");
        if (org.springframework.util.StringUtils.hasText(loginInfo.getShopAndUserInfo().getUserShopEntityId()))
        {
            criteria.andShopEntityIdEqualTo(loginInfo.getShopAndUserInfo().getUserShopEntityId());
        }
        if (org.springframework.util.StringUtils.hasText(shopEntityId))
        {
            criteria.andShopEntityIdEqualTo(shopEntityId);
        }
        if (org.springframework.util.StringUtils.hasText(tableInfo.getId()))
        {
            criteria.andIdEqualTo(tableInfo.getId());
        }
        if (org.springframework.util.StringUtils.hasText(tableTypeCode))
        {
            criteria.andTableTypeCodeEqualTo(tableTypeCode);
        }
        int count = this.queryDeskService.countByExample(example);

        example.setPage(pageIndex, pageSize);
        if (!orderBy.isEmpty())
        {
            example.setOrderByClause(orderBy);
        }

        List<ShopTableInfo> shopTableInfos = this.queryDeskService.selectByExample(example);

        if (!shopTableInfos.isEmpty())
        {
            List<FTableInfo> fTableInfos = new ArrayList<FTableInfo>();
            PageModel<FTableInfo> pageModel = new PageModel<FTableInfo>();
            for (ShopTableInfo shopTableInfo : shopTableInfos)
            {
                ShopEntityInfoExample shopEntityInfoExample = new ShopEntityInfoExample();

                shopEntityInfoExample.createCriteria().andShopIdEqualTo(shopTableInfo.getShopId()).andShopEntityIdEqualTo(shopTableInfo.getShopEntityId()).andIsDelEqualTo("N");

                List<ShopEntityInfo> shopEntityInfoList = this.shopEntityInfoGeneratorQueryService.selectByExample(shopEntityInfoExample);
                FTableInfo fTableInfo = new FTableInfo();
                BeanUtils.copyProperties(shopTableInfo, fTableInfo);
                fTableInfo.setTableNo(shopTableInfo.getTableName());
                if (null != shopEntityInfoList && shopEntityInfoList.size() > 0)
                {
                    fTableInfo.setShopEntityName(shopEntityInfoList.get(0).getShopEntityName());
                }
                fTableInfos.add(fTableInfo);

            }
            pageModel.setCount(count);
            pageModel.setPageIndex(pageIndex);
            pageModel.setPageSize(pageSize);
            pageModel.setResult(fTableInfos);
            return GMSUtil.toTransData(true, MessageConst.GMS_OPERATE_SUCCESS, pageModel);
        }
        else
        {
            return new TransData<PageModel<FTableInfo>>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }

    }

    @Override
    public TransData<Object> updateTableInfo(HttpServletRequest request) throws Exception
    {
        ShopTableInfo shopTableInfo = ServletUtils.objectMethod(ShopTableInfo.class, request);
        boolean flag = this.coreDeskService.updateTable(shopTableInfo);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, shopTableInfo.getId());
    }

    @Override
    public TransData<Object> getDeskStatus(HttpServletRequest request) throws Exception
    {
        ShopLoginInfo gmsLoginInfo = this.shopLoginService.getShopLoginInfo(request);
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        if (gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId() != null && !gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId().isEmpty())
        {
            shopEntityId = gmsLoginInfo.getShopAndUserInfo().getUserShopEntityId();
        }
        List<TableTypeStatus> tableType = this.statusQueryService.findTableTypeStatus(null, shopEntityId, null, null);

        return new TransData<Object>(true, MessageConst.GMS_OPERATE_SUCCESS, tableType);
    }

    @Override
    public TransData<Object> getDeskStatusDetail(HttpServletRequest request) throws Exception
    {
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        String tableTypeCode = ServletRequestUtils.getStringParameter(request, "tableTypeCode", "");
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        List<TableStatusByType> tableStatus = this.statusQueryService.findTableStatusByType(shopEntityId, tableTypeCode, null, pageIndex, pageSize);

        return new TransData<Object>(true, MessageConst.GMS_OPERATE_SUCCESS, tableStatus);
    }

}
