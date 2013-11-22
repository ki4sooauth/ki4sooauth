package com.gooagoo.core.business.shop.shoptool;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.shop.shoptool.ShopToolCoreService;
import com.gooagoo.api.generator.core.base.ShopToolInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopToolListGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.ShopToolInfo;
import com.gooagoo.entity.generator.shop.ShopToolList;
import com.gooagoo.entity.generator.shop.ShopToolListExample;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class ShopToolCoreServiceImpl implements ShopToolCoreService
{
    @Autowired
    private ShopToolListGeneratorCoreService shopToolListGeneratorCoreService;
    @Autowired
    private ShopToolInfoGeneratorCoreService shopToolInfoGeneratorCoreService;

    @Override
    public boolean updateShopToolAuthority(String id, String authority) throws Exception
    {
        ShopToolList shopToolList = new ShopToolList();
        shopToolList.setId(id);
        shopToolList.setAuthority(authority);
        return this.shopToolListGeneratorCoreService.updateByPrimaryKeySelective(shopToolList);
    }

    @Override
    public boolean addSysTool(String shopId, String toolId, String shopToolListId) throws Exception
    {
        ShopToolListExample shopToolListExample = new ShopToolListExample();
        shopToolListExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId);
        List<ShopToolList> tools = this.shopToolListGeneratorCoreService.selectByExample(shopToolListExample);

        ShopToolInfo shopTool = this.shopToolInfoGeneratorCoreService.selectByPrimaryKey(toolId);

        ShopToolList shopToolList = new ShopToolList();
        shopToolList.setId(shopToolListId);
        shopToolList.setToolId(toolId);
        shopToolList.setShopId(shopId);
        shopToolList.setIsDel("N");
        shopToolList.setStatus("W");
        shopToolList.setAuthority("");
        shopToolList.setToolIcoFocus(shopTool.getToolIcoFocus());
        shopToolList.setToolIcoUnfocus(shopTool.getToolIcoUnfocus());
        shopToolList.setToolName(shopTool.getToolName());
        shopToolList.setToolType(shopTool.getToolType());
        shopToolList.setToolUrl(shopTool.getToolUrl());
        shopToolList.setVer(shopTool.getVer());
        shopToolList.setRemark(shopTool.getRemark());
        shopToolList.setLocalCmd(shopTool.getLocalCmd());
        shopToolList.setOrderNo(tools.size() + 1);
        return this.shopToolListGeneratorCoreService.insertSelective(shopToolList);
    }

    @Override
    public boolean deleteShopTool(String id) throws Exception
    {
        if (!StringUtils.hasText(id))
        {
            GooagooLog.warn("删除商家服务工具：主键为空");
            return false;
        }
        return this.shopToolListGeneratorCoreService.deleteByPrimaryKey(id);
    }

    @Override
    public boolean addCustomTool(ShopToolList shopToolList) throws Exception
    {
        shopToolList.setIsDel("N");
        return this.shopToolListGeneratorCoreService.insertSelective(shopToolList);
    }

    @Override
    public boolean updateCustomTool(ShopToolList shopToolList) throws Exception
    {
        return this.shopToolListGeneratorCoreService.updateByPrimaryKeySelective(shopToolList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateToolSort(List<ShopToolList> shopToolList) throws Exception
    {
        for (int i = 0; i < shopToolList.size(); i++)
        {
            ShopToolList shopTool = shopToolList.get(i);
            shopTool.setOrderNo(i);
            boolean res = this.shopToolListGeneratorCoreService.updateByPrimaryKeySelective(shopTool);
            if (!res)
            {
                GooagooLog.warn("服务工具排序时更新数据失败：obj=" + new Gson().toJson(shopTool));
                throw new OperateFailException("服务工具排序失败");
            }
        }
        return true;
    }

}
