package com.gooagoo.mis.rsrcmanage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.generator.query.base.MarketingChannelGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.base.MarketingChannel;
import com.gooagoo.entity.generator.base.MarketingChannelExample;
import com.gooagoo.entity.generator.base.MarketingChannelExample.Criteria;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.rsrcmanage.service.ChannelService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.mis.channelManage.MChannel;
import com.gooagoo.view.mis.common.MZTreeNode;

@Service(value = "channelService")
public class ChannelServiceImpl implements ChannelService
{
    @Autowired
    private MarketingChannelGeneratorQueryService marketingChannelGeneratorQueryService;

    //    @Autowired
    //    private CoreChannelService coreChannelService;

    @Override
    public TransData<Object> addChannel(HttpServletRequest request) throws Exception
    {
        //MChannel mc = ServletUtils.objectMethod(MChannel.class, request);
        //        boolean r = this.coreChannelService.add(mc);
        return UtilsMis.getBooleanResult(false, MisMessageConst.SYS_ADD_SUCCESS, MisMessageConst.SYS_ADD_FAIL);
    }

    /**
     * 查询所有渠道
     */
    @Override
    public TransData<List<MZTreeNode>> searchAllChannel(HttpServletRequest request) throws Exception
    {
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");//渠道Id
        String channelName = ServletRequestUtils.getStringParameter(request, "channelName", "");//渠道名称
        List<MZTreeNode> treeList = new ArrayList<MZTreeNode>();
        //        this.treeMisChannel(treeList, Integer.parseInt(channelCode));
        MarketingChannel marketingChannel = this.marketingChannelGeneratorQueryService.selectUnDelByPrimaryKey("".equals(channelCode) ? null : Integer.parseInt(channelCode));
        treeList.add(this.convertToZTreeNode(marketingChannel));
        if (channelName != null && !"".equals(channelName))
        {
            boolean isExist = false;
            for (int i = 0; i < treeList.size(); i++)
            {
                if (treeList.get(i).getName().equals(channelName))
                {
                    treeList.get(i).setChecked(true);
                    treeList.get(i).setNoCheck(true);
                    isExist = true;
                }
            }
            if (!isExist)
            {
                treeList = null;
            }
        }
        return new TransData<List<MZTreeNode>>(true, MisMessageConst.MIS_RESOURCE_CHANNEL_GET_ALLINFO_FAIL, treeList);
    }

    @Override
    public TransData<Object> editChannel(HttpServletRequest request) throws Exception
    {
        //        MChannel mChannel = ServletUtils.objectMethod(MChannel.class, request);
        //        boolean r = this.coreChannelService.update(mChannel);
        return UtilsMis.getBooleanResult(false, MisMessageConst.SYS_UPD_SUCCESS, MisMessageConst.SYS_UPD_FAIL);
    }

    @Override
    public TransData<Object> delChannel(HttpServletRequest request) throws Exception
    {
        //        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");
        //        boolean r = this.coreChannelService.delete(channelCode);
        return UtilsMis.getBooleanResult(false, MisMessageConst.SYS_DEL_SUCCESS, MisMessageConst.SYS_DEL_FAIL);
    }

    @Override
    public TransData<List<MChannel>> searchAllTopChannel(HttpServletRequest request) throws Exception
    {
        MChannel channel = ServletUtils.objectMethod(MChannel.class, request);
        List<MChannel> mChannelList = new ArrayList<MChannel>();
        // 设置查询条件
        MarketingChannelExample channelExample = new MarketingChannelExample();
        Criteria channelExampleC = channelExample.createCriteria();
        channelExampleC.andIsDelEqualTo("N");
        channelExampleC.andParentChannelCodeEqualTo("-1");
        if (StringUtils.hasText(channel.getChannelName()))
        {
            channelExampleC.andChannelNameEqualTo(channel.getChannelName());
        }
        // 设置排序字段
        channelExample.setOrderByClause("sort_order");
        List<MarketingChannel> marketingChannelList = this.marketingChannelGeneratorQueryService.selectByExample(channelExample);
        for (MarketingChannel marketingChannel1 : marketingChannelList)
        {
            MChannel mChannel = new MChannel();
            EntityTools.copyValue(marketingChannel1, mChannel);
            mChannelList.add(mChannel);
        }
        return new TransData<List<MChannel>>(true, MisMessageConst.MIS_RESOURCE_CHANNEL_GET_ALLINFO_FAIL, mChannelList);
    }

    @Override
    public TransData<Object> sortChannel(HttpServletRequest request) throws Exception
    {
        String nodeIds = ServletRequestUtils.getStringParameter(request, "nodeIds", "");
        String nodeNames = ServletRequestUtils.getStringParameter(request, "nodeNames", "");
        String[] ids = nodeIds.split(",");
        String[] names = nodeNames.split(",");
        MChannel mChannel = null;
        List<MChannel> mChannelList = new ArrayList<MChannel>();
        for (int i = 0; i < names.length; i++)
        {
            mChannel = new MChannel();
            mChannel.setChannelCode(Integer.parseInt(ids[i]));
            mChannel.setChannelName(names[i]);
            mChannel.setSortOrder(i + 1);
            mChannelList.add(mChannel);
        }
        //        boolean r = this.coreChannelService.updateAll(mChannelList);
        return UtilsMis.getBooleanResult(false, MisMessageConst.SYS_UPD_SUCCESS, MisMessageConst.SYS_UPD_FAIL,mChannel.getChannelCode().toString());
    }

    /**
     * 递归查询子菜单
     * @param treeList
     * @param parentChannelCode
     * @throws Exception
     */
    @SuppressWarnings("unused")
    private void treeMisChannel(List<MZTreeNode> treeList, int parentChannelCode) throws Exception
    {
        MarketingChannelExample channelExample = new MarketingChannelExample();
        // 设置查询条件
        channelExample.createCriteria().andParentChannelCodeEqualTo(parentChannelCode + "").andIsDelEqualTo("N");
        List<MarketingChannel> children = this.marketingChannelGeneratorQueryService.selectByExample(channelExample);
        for (MarketingChannel channel : children)
        {
            treeList.add(this.convertToZTreeNode(channel));
            this.treeMisChannel(treeList, channel.getChannelCode());
        }
    }

    /**
     * MarketingChannel转换为ZTreeNode
     * @param channel
     * @return
     */
    private MZTreeNode convertToZTreeNode(MarketingChannel channel)
    {
        MZTreeNode node = null;
        if (channel != null)
        {
            node = new MZTreeNode();
            node.setOpen(true);
            node.setId(channel.getChannelCode() + "");
            node.setName(channel.getChannelName());
            node.setpId(channel.getParentChannelCode() + "");
        }
        return node;
    }
}
