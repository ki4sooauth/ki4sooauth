package com.gooagoo.common.gms.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.constants.TemplateConstant;
import com.gooagoo.common.gms.freemarker.FreemarkerUtil;
import com.gooagoo.common.gms.freemarker.GMSFtlUtil;
import com.gooagoo.common.gms.freemarker.RelationFtlUtil;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.common.ZTreeNode;
import com.google.gson.Gson;

@Controller
@RequestMapping("/relation")
public class RelationAction extends BaseAction
{

    /**
     * 获取关联标签信息
     * @param request
     *  relateType（非空） 关联类型 RelationConstaints[A-活动,B-品牌,C-优惠凭证,D-会员等级,E-实体店,G-商品,H-事件，K-活动内容，M-吆喝,N-通知,CG-优惠凭证和商品（多标签）,O-CMS栏目与文章]1个以上表示
     *  selectType（默认S） 列表数据选中类型[S-单选,M-多选]
     *  tabType 当前选中关联类型[A-活动,B-品牌,C-优惠凭证,D-会员等级,E-实体店,G-商品,H-事件,K-活动内容,O-CMS栏目与文章]
     *  dataType 数据类型（见RelationConstaints）
     *  callback 回调函数名称
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=listRelation")
    public void listRelation(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Map<String, Object> root = RelationFtlUtil.getRelationTabParaMap(request);

        GMSFtlUtil.writeStringContent(request, response, root, TemplateConstant.FTL_FILE_RELATION_TAB);
    }

    /**
     * 获取关联数据列表
     * @param request
     *  relateType（非空） RelationConstaints[A-活动,B-品牌,C-优惠凭证,D-会员等级,E-实体店,G-商品,H-事件，J-品类,K-活动内容,O-CMS栏目与文章]
     *  selectType（默认S） 列表数据选中类型[S-单选,M-多选]
     *  dataType 数据类型（见RelationConstaints）
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=pageTabData")
    public void pageTabData(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String relateType = ServletRequestUtils.getStringParameter(request, "relateType", "");
        Map<String, Object> root = RelationFtlUtil.getRelationTabDataParaMap(request);

        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_RELATION_PAGE, request, PageModel.class);
        PageModel pm = respObj.getData();
        GMSFtlUtil.putPageRequestParasToMap(request, pm, root);

        response.setCharacterEncoding("UTF-8");
        String ftlName = RelationFtlUtil.getRelationTabDataFtlName(relateType);
        if (ftlName == null)
        {
            response.getWriter().write("RelateType Error!");
        }
        else
        {
            GMSFtlUtil.writeStringContent(request, response, root, ftlName);
        }
    }

    /**
     * 获取关联树形数据
     * @param request
     *  relateType（非空） RelationConstaints[F-服务工具,I-区域,J-品类]
     *  selectType（默认S）列表数据选中类型[S-单选,M-多选]
     *  dataType 数据类型（预留）
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=treeRelation")
    public void treeRelation(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String relateType = ServletRequestUtils.getStringParameter(request, "relateType", "");
        Map<String, Object> root = new HashMap<String, Object>();

        GMSFtlUtil.putDefaultRequestParasToMap(request, root);
        RelationFtlUtil.putRequestParas(request, RelationFtlUtil.getRelationTreeParaNames(), root);

        //目前传的是实体店数据
        RelationFtlUtil.putRelationTreeDataParas(request, relateType, root);

        TransData<List> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_RELATION_TREE, request, List.class);
        List<ZTreeNode> nodeList = respObj.getData();
        if (nodeList == null)
        {
            nodeList = new ArrayList<ZTreeNode>();
        }
        String content = new Gson().toJson(nodeList);
        root.put("relateName", RelationFtlUtil.getRelateTypeName(relateType, request));
        root.put("dataJson", content);
        response.setCharacterEncoding("UTF-8");
        FreemarkerUtil.print(TemplateConstant.FTL_FILE_RELATION_TREE, root, response.getWriter());
    }
}
