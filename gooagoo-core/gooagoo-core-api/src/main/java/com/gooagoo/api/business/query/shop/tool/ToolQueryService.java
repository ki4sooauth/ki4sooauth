package com.gooagoo.api.business.query.shop.tool;

import java.util.Date;
import java.util.List;

import com.gooagoo.entity.business.shop.tool.ShopToolListBusiness;

public interface ToolQueryService
{
    /**
     *  已发布服务工具列表查询
     * @param shopId
     * @throws Exception
     */
    public void findPublishTool(String shopId) throws Exception;

    /**
     * 待审核服务工具列表查询
     * @param shopId
     * @throws Exception
     */
    public void findNoReviewedTool(String shopId) throws Exception;

    /**
     * 服务工具详细
     * @param shopId
     * @throws Exception
     */
    public void findToolDetail(String shopId) throws Exception;

    /**
     * 查询排序的服务工具信息
     * @param shopId 商家编号，必填
     * @param cTimeStamp 时间戳，选填
     * @param isDel 是否删除，选填，Y-删除 ，N-为删除，为null,查所有包括删除和未删除
     * @return
     * @throws Exception
     */
    public List<ShopToolListBusiness> findSortServiceTool(String shopId, Date cTimeStamp, String isDel);
}
