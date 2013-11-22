package com.gooagoo.gmap.action;

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
import com.gooagoo.view.gms.common.ZTreeNode;
import com.google.gson.Gson;

/**
 * 商家位置信息
 *
 */
@Controller
@RequestMapping("/position")
public class PositionAction extends BaseAction
{
    /**
     * 获取位置列表
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=list")
    public void listPosition(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHOP_POSITION_ZTREE, request, List.class);
        List<ZTreeNode> positionList = respObj.getData();
        for (ZTreeNode e : positionList)
        {
            e.setOpen(true);
            e.setClick("");
        }
        ZTreeNode eNode = new ZTreeNode();
        eNode.setClick("");
        eNode.setId("0");
        eNode.setName("清除选择");
        eNode.setOpen(true);
        eNode.setpId("-1");
        positionList.add(0, eNode);

        Gson gson = new Gson();
        String json = gson.toJson(positionList);

        ServletUtils.writeHtml(json, response);
    }
}
