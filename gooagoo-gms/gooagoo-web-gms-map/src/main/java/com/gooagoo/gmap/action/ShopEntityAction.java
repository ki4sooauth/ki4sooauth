package com.gooagoo.gmap.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FZtreeNode;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.google.gson.Gson;

/**
 * 商家实体店信息
 *
 */
@Controller
@RequestMapping("/entity")
public class ShopEntityAction extends BaseAction
{

    /**
     * 获得全部的实体店信息
     * @param request
     * @param response 
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=getShopEntityList")
    public void getShopEntityList(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        List<FShopEntityInfo> list = respObj.getData().getResult();
        List<FZtreeNode> reList = this.convertToFZtreeNodes(list);
        String result = new Gson().toJson(reList);
        ServletUtils.writeHtml(result, response);
    }

    /**
     * 实体店列表转为  ztreeNode 列
     * @param list
     * @return
     */
    private List<FZtreeNode> convertToFZtreeNodes(List<FShopEntityInfo> list)
    {
        List<FZtreeNode> reList = new ArrayList<FZtreeNode>();
        for (FShopEntityInfo e : list)
        {
            FZtreeNode z = new FZtreeNode();
            z.setId(e.getShopEntityId());
            z.setName(e.getShopEntityName());
            reList.add(z);
        }
        return reList;
    }

}
