package com.gooagoo.igms.relation.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.common.ZTreeNode;

public interface RelationService
{
    /**
     * 分页查询关联对象列表
     * @param request
     *  relateType RelationConstaints[A-活动,B-品牌,C-优惠凭证,D-会员等级,E-实体店,G-商品,H-事件]
     * @return
     */
    public TransData<PageModel<Object>> pageRelation(HttpServletRequest request) throws Exception;

    /**
     * 查询关联对象树
     * @param request
     * relateType RelationConstaints[F-服务工具,I-区域,J-品类]
     * 
     * @return
     */
    public TransData<List<ZTreeNode>> treeRelation(HttpServletRequest request) throws Exception;

}
