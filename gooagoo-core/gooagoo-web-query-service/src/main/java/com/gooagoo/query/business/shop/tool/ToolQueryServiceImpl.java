package com.gooagoo.query.business.shop.tool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.shop.tool.ToolQueryService;
import com.gooagoo.api.generator.query.shop.ServiceToolSortGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopToolListGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.CmsContentGeneratorQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.shop.tool.ShopToolListBusiness;
import com.gooagoo.entity.generator.shop.ServiceToolSort;
import com.gooagoo.entity.generator.shop.ServiceToolSortExample;
import com.gooagoo.entity.generator.shop.ShopToolList;
import com.gooagoo.entity.generator.shop.ShopToolListExample;
import com.gooagoo.entity.generator.shop.ShopToolListExample.Criteria;
import com.gooagoo.entity.generator.sys.CmsContent;
import com.gooagoo.entity.generator.sys.CmsContentExample;

@Service
public class ToolQueryServiceImpl implements ToolQueryService
{
    @Autowired
    private CmsContentGeneratorQueryService cmsContentGeneratorQueryService;
    @Autowired
    private ShopToolListGeneratorQueryService shopToolListGeneratorQueryService;
    @Autowired
    private ServiceToolSortGeneratorQueryService serviceToolSortGeneratorQueryService;

    @Override
    public void findPublishTool(String shopId) throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void findNoReviewedTool(String shopId) throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void findToolDetail(String shopId) throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public List<ShopToolListBusiness> findSortServiceTool(String shopId, Date cTimeStamp, String isDel)
    {
        //1.查询系统定义的服务工具（shop_tool_list）

        List<ShopToolList> shopToolList = this.getShopToolList(shopId, cTimeStamp, isDel);

        //2.查询自定义的服务工具（cms_content）
        //1)查询父节点
        List<CmsContent> rootCmsContentList = this.getCmsContentList(shopId, "-1", null, null, isDel);
        List<CmsContent> resultCmsContentList = null;//系统自定义服务工具信息
        List<String> parentCmsContentIds = null;
        if (CollectionUtils.isNotEmpty(rootCmsContentList))
        {
            parentCmsContentIds = new ArrayList<String>();
            for (CmsContent tempRootCmsContent : rootCmsContentList)
            {
                parentCmsContentIds.add(tempRootCmsContent.getCmsContentId());
            }

            //2)根据自定义服务工具根节点查询对应子节点服务工具信息
            resultCmsContentList = this.getCmsContentList(shopId, null, parentCmsContentIds, cTimeStamp, isDel);
        }

        //3.封装查询到的服务工具信息
        List<ShopToolListBusiness> infoList = this.packageShopToolList(shopToolList, resultCmsContentList);

        if (CollectionUtils.isEmpty(infoList))
        {
            return null;
        }
        //4.查询服务工具排序信息（service_tool_sort按排序号升序）
        ServiceToolSortExample serviceToolSortExample = new ServiceToolSortExample();
        serviceToolSortExample.createCriteria().andShopIdEqualTo(shopId);
        serviceToolSortExample.setOrderByClause("order_no ASC");//升序
        List<ServiceToolSort> serviceToolSortList = this.serviceToolSortGeneratorQueryService.selectByExample(serviceToolSortExample);

        //5.对服务工具排序
        List<ShopToolListBusiness> resultInfoList = this.getSortShopToolList(infoList, serviceToolSortList);
        return resultInfoList;
    }

    /**
     * 封装服务工具信息
     * @param shopToolList 系统定义服务工具
     * @param resultCmsContentList 自定义服务工具
     * @return
     */
    public List<ShopToolListBusiness> packageShopToolList(List<ShopToolList> shopToolList, List<CmsContent> resultCmsContentList)
    {
        List<ShopToolListBusiness> infoList = null;
        //1)封装自定义服务工具信息
        if (CollectionUtils.isNotEmpty(resultCmsContentList))
        {
            infoList = new ArrayList<ShopToolListBusiness>();
            for (CmsContent tempCmsContent : resultCmsContentList)
            {
                ShopToolListBusiness shoptoollist = new ShopToolListBusiness();
                shoptoollist.setShopid(tempCmsContent.getShopId());
                shoptoollist.setId(null);
                shoptoollist.setToolicofocus(tempCmsContent.getCmsContentImg());
                shoptoollist.setToolid(tempCmsContent.getCmsContentId());
                shoptoollist.setToolname(tempCmsContent.getCmsContentName());
                shoptoollist.setToolurl(tempCmsContent.getCmsContentUrl());
                shoptoollist.setToolicounfocus(tempCmsContent.getCmsContentImg());
                shoptoollist.setOrderno("9999");
                shoptoollist.setTooltype(tempCmsContent.getCmsContentType());//A-文章，C-栏目
                shoptoollist.setStatus(tempCmsContent.getPublishStatus());
                shoptoollist.setLocalcmd(null);
                shoptoollist.setVer(null);
                shoptoollist.setRemark(tempCmsContent.getAuditNote());
                shoptoollist.setAuthority(null);
                shoptoollist.setIsdel(tempCmsContent.getIsDel());
                shoptoollist.setCtimestamp(TimeUtils.convertDateToString(tempCmsContent.getCTimeStamp(), TimeUtils.FORMAT1));
                infoList.add(shoptoollist);
            }
        }
        //2)封装系统定义服务工具信息
        if (CollectionUtils.isNotEmpty(shopToolList))
        {
            if (CollectionUtils.isEmpty(infoList))
            {
                infoList = new ArrayList<ShopToolListBusiness>();
            }
            for (ShopToolList temp : shopToolList)
            {
                ShopToolListBusiness shoptoollist = new ShopToolListBusiness();
                shoptoollist.setShopid(temp.getShopId());
                shoptoollist.setId(temp.getId());
                shoptoollist.setOrderno("9999");
                shoptoollist.setToolicofocus(temp.getToolIcoFocus());
                shoptoollist.setToolid(temp.getToolId());
                shoptoollist.setToolname(temp.getToolName());
                shoptoollist.setToolurl(temp.getToolUrl());
                shoptoollist.setToolicounfocus(temp.getToolIcoUnfocus());
                shoptoollist.setTooltype(temp.getToolType());
                shoptoollist.setStatus(temp.getStatus());
                shoptoollist.setLocalcmd(temp.getLocalCmd());
                shoptoollist.setVer(temp.getVer());
                shoptoollist.setRemark(temp.getRemark());
                shoptoollist.setAuthority(temp.getAuthority());
                shoptoollist.setIsdel(temp.getIsDel());
                shoptoollist.setCtimestamp(TimeUtils.convertDateToString(temp.getCTimeStamp(), TimeUtils.FORMAT1));
                infoList.add(shoptoollist);
            }
        }
        if (CollectionUtils.isEmpty(infoList))
        {//未查询到服务工具信息
            infoList = null;
        }
        return infoList;
    }

    /**
     * 查询系统定义的服务工具（shop_tool_list,已经发布的）
     * @param shopId
     * @param cTimeStamp
     * @param isDel
     * @return
     */
    public List<ShopToolList> getShopToolList(String shopId, Date cTimeStamp, String isDel)
    {
        //1)封装查询条件
        ShopToolListExample shopToolListExample = new ShopToolListExample();
        Criteria criteria = shopToolListExample.createCriteria();
        criteria.andShopIdEqualTo(shopId);
        criteria.andStatusEqualTo("P");
        if (cTimeStamp != null)
        {
            criteria.andCTimeStampGreaterThan(cTimeStamp);
        }
        if (StringUtils.hasText(isDel))
        {
            criteria.andIsDelEqualTo(isDel);
        }

        //2)查询系统定义的服务工具（shop_tool_list）
        List<ShopToolList> shopToolList = this.shopToolListGeneratorQueryService.selectByExample(shopToolListExample);

        return shopToolList;
    }

    /**
     * 对服务工具进行排序
     * @param infolist 混乱的服务工具信息
     * @param sortInfoList 服务工具排序信息
     * @return
     */
    private List<ShopToolListBusiness> getSortShopToolList(List<ShopToolListBusiness> infolist, List<ServiceToolSort> sortInfoList)
    {
        List<ShopToolListBusiness> resultToolList = null;
        if (CollectionUtils.isNotEmpty(sortInfoList))
        {
            resultToolList = new ArrayList<ShopToolListBusiness>();
            for (ServiceToolSort sort : sortInfoList)
            {
                for (int i = 0; i < infolist.size(); i++)
                {
                    ShopToolListBusiness shopTool = infolist.get(i);
                    if (sort.getShopId().equals(shopTool.getShopid()) && sort.getToolId().equals(shopTool.getToolid()))
                    {
                        shopTool.setOrderno(String.valueOf(sort.getOrderNo()));
                        resultToolList.add(shopTool);
                        infolist.remove(i);//清除infolist中已经排序的数据
                    }
                }
            }
            resultToolList.addAll(infolist);//把未进行排序服务工具信息加到排序后服务工具后面
        }
        else
        {//无需排序
            return infolist;
        }
        return resultToolList;
    }

    /**
     * 获取cms内容信息（自定义服务工具信息）
     * 当parentCmsContentId 为-1时查询根节点cms信息（自定义服务工具信息）
     * @param shopId  商家编号
     * @param parentCmsContentId 父级cms内容编号
     * @param cmsContentIds cms内容编号
     * @return
     */
    private List<CmsContent> getCmsContentList(String shopId, String parentCmsContentId, List<String> parentCmsContentIds, Date cTimeStamp, String isDel)
    {

        CmsContentExample cmsContentExample = new CmsContentExample();
        cmsContentExample.setOrderByClause("c_time_stamp ASC");
        com.gooagoo.entity.generator.sys.CmsContentExample.Criteria cmsCriteria = cmsContentExample.createCriteria();
        cmsCriteria.andShopIdEqualTo(shopId);
        if (StringUtils.hasText(isDel))
        {
            cmsCriteria.andIsDelEqualTo(isDel);
        }
        if (cTimeStamp != null)
        {
            cmsCriteria.andCTimeStampGreaterThan(cTimeStamp);
        }
        if (StringUtils.hasText(parentCmsContentId))
        {
            cmsCriteria.andParentCmsContentIdEqualTo(parentCmsContentId);
        }
        if (CollectionUtils.isNotEmpty(parentCmsContentIds))
        {
            cmsCriteria.andParentCmsContentIdIn(parentCmsContentIds);
        }
        cmsCriteria.andChannelTypeEqualTo("M").andPublishStatusEqualTo("P");
        cmsCriteria.andCmsContentTypeEqualTo("C");
        List<CmsContent> cmsContentList = this.cmsContentGeneratorQueryService.selectByExample(cmsContentExample);
        return cmsContentList;
    }
}
