package com.gooagoo.mis.usermanage.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.user.enterprise.AssistantManageCoreService;
import com.gooagoo.api.generator.query.shop.DeviceAssistantGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.shop.DeviceAssistant;
import com.gooagoo.entity.generator.shop.DeviceAssistantExample;
import com.gooagoo.entity.generator.shop.DeviceAssistantExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.usermanage.service.ShopAssistantService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MDeviceAssistant;

@Service(value = "shopAssistantService")
public class ShopAssistantServiceImpl implements ShopAssistantService
{
    @Autowired
    private AssistantManageCoreService assistantManageCoreService;
    @Autowired
    private DeviceAssistantGeneratorQueryService deviceAssistantGeneratorQueryService;

    /**
     * 查询商家店员助理
     */
    @Override
    public TransData<PageModel<MDeviceAssistant>> searchShopAssistant(HttpServletRequest request) throws Exception
    {
        DeviceAssistantExample deviceExample = new DeviceAssistantExample();
        MDeviceAssistant md = ServletUtils.objectMethod(MDeviceAssistant.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        Criteria criteria = deviceExample.createCriteria();
        if (StringUtils.hasText(md.getShopEntityId()))
        {
            criteria.andShopEntityIdEqualTo(md.getShopEntityId());
        }
        if (StringUtils.hasText(md.getShopId()))
        {
            criteria.andShopIdEqualTo(md.getShopId());
        }
        if (StringUtils.hasText(md.getIsDel()))
        {
            criteria.andIsDelEqualTo(md.getIsDel());
        }
        PageModel<MDeviceAssistant> pm = new PageModel<MDeviceAssistant>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.deviceAssistantGeneratorQueryService.countByExample(deviceExample);
        if (count > 0)
        {
            deviceExample.setPage(pageCondition.getPageIndex(), pageSize);// 设置分页条件
            List<DeviceAssistant> list = this.deviceAssistantGeneratorQueryService.selectByExample(deviceExample);
            for (DeviceAssistant s : list)
            {
                MDeviceAssistant mass = new MDeviceAssistant();
                EntityTools.copyValue(s, mass);
                pm.getResult().add(mass);
            }
        }
        return new TransData<PageModel<MDeviceAssistant>>(true, null, pm);
    }

    /**
     * 配置商家店员助理
     */
    @Override
    public TransData<Object> addShopAssistant(HttpServletRequest request) throws Exception
    {
        DeviceAssistantExample assistantExample = new DeviceAssistantExample();
        MDeviceAssistant ma = ServletUtils.objectMethod(MDeviceAssistant.class, request);
        Criteria criteria = assistantExample.createCriteria();
        if (StringUtils.hasText(ma.getDeviceMac()))
        {
            criteria.andDeviceMacEqualTo(ma.getDeviceMac());
        }
        List<DeviceAssistant> deviceAssistantList = this.deviceAssistantGeneratorQueryService.selectByExample(assistantExample);
        DeviceAssistant assistant = new DeviceAssistant();
        EntityTools.copyValue(ma, assistant);
        boolean flag = false;
        if (deviceAssistantList.size() > 0)
        {
            if ("Y".equals(deviceAssistantList.get(0).getIsDel()))
            {
                assistant.setIsDel("N");
                flag = this.assistantManageCoreService.updateAssistant(assistant);
            }
            else
            {
                return new TransData<Object>(true, MisMessageConst.MIS_USERMANA_ASSSISTANT_IS_EXIST, null);
            }
        }
        else
        {
            assistant.setDeviceAssistantId(UUID.getUUID());
            assistant.setStatus("0");
            flag = this.assistantManageCoreService.addAssistant(assistant);
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_USERMANA_ASSSISTANT_SET_SUCCESS, MisMessageConst.MIS_USERMANA_ASSSISTANT_SET_FAIL, assistant.getDeviceAssistantId());
    }

    /**
     * 删除商家店员助理
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delShopAssistant(HttpServletRequest request) throws Exception
    {
        String userId = ServletRequestUtils.getStringParameter(request, "ids", "");
        boolean flag = this.assistantManageCoreService.delAssistant(userId);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_USERMANA_ASSSISTANT_DEL_SUCCESS, MisMessageConst.MIS_USERMANA_ASSSISTANT_DEL_FAIL);
    }

    /**
     * 查询商家店员助理详细
     */
    @Override
    public TransData<MDeviceAssistant> searchShopAssistantInfo(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        DeviceAssistant deviceAssistant = this.deviceAssistantGeneratorQueryService.selectByPrimaryKey(ids.split(",")[0]);
        if (deviceAssistant != null)
        {
            MDeviceAssistant mdeviceAssistant = new MDeviceAssistant();
            EntityTools.copyValue(deviceAssistant, mdeviceAssistant);
            return new TransData<MDeviceAssistant>(true, null, mdeviceAssistant);
        }
        else
        {
            return new TransData<MDeviceAssistant>(false, MisMessageConst.SYS_LOAD_DATA_ERROR, null);
        }
    }

    /**
     * 编辑商家店员助理
     */
    @Override
    public TransData<Object> updateShopAssistant(HttpServletRequest request) throws Exception
    {
        DeviceAssistant deviceAssistant = ServletUtils.objectMethod(DeviceAssistant.class, request);
        boolean flag = this.assistantManageCoreService.updateAssistant(deviceAssistant);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.SYS_UPD_SUCCESS, MisMessageConst.SYS_UPD_FAIL);
    }

}
