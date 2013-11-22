package com.gooagoo.igms.marketing.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.marketing.integral.IntegralCoreService;
import com.gooagoo.api.generator.query.marketing.ShopIntegralConvertGeneratorQueryService;
import com.gooagoo.api.generator.query.user.ConsigneeInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvert;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvertExample;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvertExample.Criteria;
import com.gooagoo.entity.generator.user.ConsigneeInfo;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.marketing.service.IntegralDeliverService;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FShopIntegralConvert;

@Service(value = "integralDeliverService")
public class IntegralDeliverServiceImpl implements IntegralDeliverService
{

    @Autowired
    private IntegralCoreService integralCoreService;
    @Autowired
    private ShopIntegralConvertGeneratorQueryService shopIntegralConvertGeneratorQueryService;
    @Autowired
    private ConsigneeInfoGeneratorQueryService consigneeInfoGeneratorQueryService;

    /**
     * 兑换积分（修改发货状态）
     */
    @Override
    public TransData<Object> deliver(HttpServletRequest request) throws Exception
    {

        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        FShopIntegralConvert shopIntegralConvert = ServletUtils.objectMethod(FShopIntegralConvert.class, request);
        shopIntegralConvert.setShopIntegralConvertId(id);
        shopIntegralConvert.setIsDelivery(GMSConstant.YES);

        boolean result = this.integralCoreService.updateDeliveryStatusToConfirm(shopIntegralConvert.getShopIntegralConvertId());

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);

    }

    /**
     * 分页查询积分发放列表
     */
    @Override
    public TransData<PageModel<FShopIntegralConvert>> pageIntegralDeliver(HttpServletRequest request) throws Exception
    {

        FShopIntegralConvert shopIntegralConvert = ServletUtils.objectMethod(FShopIntegralConvert.class, request);
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        shopIntegralConvert.setShopId(shopId);
        PageCondition condition = ServletUtils.objectMethod(PageCondition.class, request);
        PageModel<FShopIntegralConvert> pm = new PageModel<FShopIntegralConvert>();
        pm.setPageIndex(condition.getPageIndex());
        pm.setPageSize(condition.getPageSize());
        ShopIntegralConvertExample example = new ShopIntegralConvertExample();
        example.setPage(pm.getIndex(), pm.getPageSize());
        example.setOrderByClause("c_time_stamp desc");

        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(shopIntegralConvert.getShopIntegralId()))
        {
            criteria.andShopIntegralIdEqualTo(shopIntegralConvert.getShopIntegralId());
        }
        int count = this.shopIntegralConvertGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<ShopIntegralConvert> list = this.shopIntegralConvertGeneratorQueryService.selectByExample(example);
            for (ShopIntegralConvert s : list)
            {
                pm.getResult().add(this.convertToFShopIntegralConvert(s));
            }
        }

        return new TransData<PageModel<FShopIntegralConvert>>(true, MessageConst.GMS_OPERATE_SUCCESS, pm);
    }

    private FShopIntegralConvert convertToFShopIntegralConvert(ShopIntegralConvert sic) throws IllegalArgumentException, IllegalAccessException
    {
        FShopIntegralConvert fsic = null;
        if (sic != null)
        {
            fsic = new FShopIntegralConvert();
            EntityTools.copyValue(sic, fsic);
            fsic.setIsDelivery(sic.getDeliveryStatus());
            if (StringUtils.hasText(sic.getConsigneeId()))
            {
                ConsigneeInfo consigneeInfo = this.consigneeInfoGeneratorQueryService.selectByPrimaryKey(sic.getConsigneeId());
                if (consigneeInfo != null)
                {
                    fsic.setName(consigneeInfo.getConsigneeName());
                    fsic.setAddress(consigneeInfo.getAddress());
                    fsic.setTelephone(consigneeInfo.getTelephone());
                    fsic.setPostcode(consigneeInfo.getPostCode());
                }
            }
            else
            {
                fsic.setName("-");
                fsic.setAddress("-");
                fsic.setTelephone("-");
                fsic.setPostcode("-");
            }
        }
        return fsic;
    }
}
