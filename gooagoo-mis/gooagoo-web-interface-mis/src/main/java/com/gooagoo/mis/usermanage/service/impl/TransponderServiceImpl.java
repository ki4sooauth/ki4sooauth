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

import com.gooagoo.api.business.core.system.user.enterprise.TransponderManageCoreService;
import com.gooagoo.api.generator.query.shop.DeviceTransponderGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.shop.DeviceTransponder;
import com.gooagoo.entity.generator.shop.DeviceTransponderExample;
import com.gooagoo.entity.generator.shop.DeviceTransponderExample.Criteria;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.usermanage.service.TransponderService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MDeviceTransponder;

@Service(value = "transponderService")
public class TransponderServiceImpl implements TransponderService
{

    @Autowired
    private TransponderManageCoreService transponderManageCoreService;
    @Autowired
    private DeviceTransponderGeneratorQueryService deviceTransponderGeneratorQueryService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;

    /**
     * 查询商家转发器
     */
    @Override
    public TransData<PageModel<MDeviceTransponder>> searchShopTranspc(HttpServletRequest request) throws Exception
    {
        DeviceTransponderExample tranExample = new DeviceTransponderExample();
        MDeviceTransponder vo = ServletUtils.objectMethod(MDeviceTransponder.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        // 设置查询条件
        String isDel = ServletRequestUtils.getStringParameter(request, "isDel", "");
        Criteria criteria = tranExample.createCriteria();
        if (!"".equals(isDel))
        {
            criteria.andIsDelEqualTo(isDel);
        }
        if (StringUtils.hasText(vo.getShopId()))
        {
            criteria.andShopIdEqualTo(vo.getShopId());
        }
        if (StringUtils.hasText(vo.getShopEntityId()))
        {
            criteria.andShopEntityIdEqualTo(vo.getShopEntityId());
        }
        if (StringUtils.hasText(vo.getDeviceMac()))
        {
            criteria.andDeviceMacLike("%" + vo.getDeviceMac() + "%");
        }
        if (StringUtils.hasText(vo.getDeviceType()))
        {
            criteria.andDeviceTypeEqualTo(vo.getDeviceType());
        }
        if (StringUtils.hasText(vo.getDeviceSn()))
        {
            criteria.andDeviceSnLike("%" + vo.getDeviceSn() + "%");
        }
        if (vo.getInstallDate() != null)
        {
            criteria.andInstallDateEqualTo(vo.getInstallDate());
        }
        if (StringUtils.hasText(vo.getStatus()))
        {
            criteria.andStatusEqualTo(vo.getStatus());
        }
        if (StringUtils.hasText(vo.getNote()))
        {
            criteria.andNoteLike("%" + vo.getNote() + "%");
        }
        if (StringUtils.hasText(vo.getSystemType()))
        {
            criteria.andSystemTypeEqualTo(vo.getSystemType());
        }
        if (StringUtils.hasText(vo.getBillParse()))
        {
            criteria.andBillParseLike("%" + vo.getBillParse() + "%");
        }
        if (StringUtils.hasText(vo.getStService()))
        {
            criteria.andStServiceLike("%" + vo.getStService() + "%");
        }
        PageModel<MDeviceTransponder> pm = new PageModel<MDeviceTransponder>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.deviceTransponderGeneratorQueryService.countByExample(tranExample);
        pm.setCount(count);
        if (count > 0)
        {
            tranExample.setPage(pm.getPageIndex(), pageSize);// 设置分页条件
            List<DeviceTransponder> list = this.deviceTransponderGeneratorQueryService.selectByExample(tranExample);
            for (DeviceTransponder tran : list)
            {
                MDeviceTransponder mtran = new MDeviceTransponder();
                EntityTools.copyValue(tran, mtran);
                pm.getResult().add(mtran);
            }
        }
        return new TransData<PageModel<MDeviceTransponder>>(true, null, pm);
    }

    /**
     * 配置商家转发器
     */
    @Override
    public TransData<Object> addShopTranspc(HttpServletRequest request) throws Exception
    {
        MDeviceTransponder mdt = ServletUtils.objectMethod(MDeviceTransponder.class, request);
        ShopEntityInfo shopEntityInfo = this.shopEntityInfoGeneratorQueryService.selectUnDelByPrimaryKey(mdt.getShopEntityId());
        DeviceTransponderExample dtExample = new DeviceTransponderExample();
        Criteria criteria = dtExample.createCriteria();
        if (StringUtils.hasText(mdt.getDeviceMac()))
        {
            criteria.andDeviceMacEqualTo(mdt.getDeviceMac());
        }
        List<DeviceTransponder> transpcInfoList = this.deviceTransponderGeneratorQueryService.selectByExample(dtExample);
        DeviceTransponder tran = new DeviceTransponder();
        EntityTools.copyValue(mdt, tran);
        boolean flag = false;
        if (transpcInfoList.size() > 0)
        {
            if ("Y".equals(transpcInfoList.get(0).getIsDel()))
            {
                tran.setDeviceTransponderId(transpcInfoList.get(0).getDeviceTransponderId());
                tran.setIsDel("N");
                flag = this.transponderManageCoreService.updateTransponder(tran);
            }
            else
            {
                return new TransData<Object>(true, MisMessageConst.MIS_USERMANA_ENTERPRISE_IS_EXIST, null);
            }
        }
        else
        {
            tran.setDeviceTransponderId(UUID.getUUID());
            tran.setStatus("0");
            tran.setShopId(shopEntityInfo.getShopId());
            flag = this.transponderManageCoreService.addTransponder(tran);
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_USERMANA_ENTERPRISE_SET_TRANS_SUCCESS, MisMessageConst.MIS_USERMANA_ENTERPRISE_SET_TRANS_FAIL, tran.getDeviceTransponderId());
    }

    /**
     * 删除商家转发器
     * @param shopId
     * @param thransId
     * @return
     * @throws Exception 
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> delShopTranspc(HttpServletRequest request) throws Exception
    {
        String transpcInfoIds = ServletRequestUtils.getStringParameter(request, "transpcInfoIds", "");
        boolean flag = this.transponderManageCoreService.delTransponder(transpcInfoIds);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_USERMANA_ENTERPRISE_DEL_TRANS_SUCCESS, MisMessageConst.MIS_USERMANA_ENTERPRISE_DEL_TRANS_FAIL);
    }

    /**
     * 查询商家转发器详细
     */
    @Override
    public TransData<MDeviceTransponder> searchShopTranspcInfo(HttpServletRequest request) throws Exception
    {
        String transpcInfoId = ServletRequestUtils.getStringParameter(request, "transpcInfoId", "");
        DeviceTransponder trans = this.deviceTransponderGeneratorQueryService.selectByPrimaryKey(transpcInfoId.split(",")[0]);
        if (trans != null && !"".equals(trans))
        {
            MDeviceTransponder mtrans = new MDeviceTransponder();
            EntityTools.copyValue(trans, mtrans);
            return new TransData<MDeviceTransponder>(true, null, mtrans);
        }
        else
        {
            return new TransData<MDeviceTransponder>(false, MisMessageConst.SYS_LOAD_DATA_ERROR, null);
        }
    }

    /**
     * 编辑商家转发器
     */
    @Override
    public TransData<Object> updateShopTranspc(HttpServletRequest request) throws Exception
    {
        DeviceTransponder tran = ServletUtils.objectMethod(DeviceTransponder.class, request);
        boolean flag = this.transponderManageCoreService.updateTransponder(tran);
        return UtilsMis.getBooleanResult(flag, MisMessageConst.SYS_UPD_SUCCESS, MisMessageConst.SYS_UPD_FAIL);
    }

}
