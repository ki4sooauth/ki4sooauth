package com.gooagoo.mis.rsrcmanage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.mis.channelManage.MChannel;
import com.gooagoo.view.mis.common.MZTreeNode;

public interface ChannelService
{

    /**
     * 添加渠道
     * @param channelReq
     * @return
     * @throws GooagooException
     */
    public TransData<Object> addChannel(HttpServletRequest request) throws Exception;

    /**
     * 查询所有渠道
     * @param channelReq
     * @return
     * @throws GooagooException
     * @throws Exception 
     */
    public TransData<List<MZTreeNode>> searchAllChannel(HttpServletRequest request) throws Exception;

    /**
     * 编辑渠道信息
     * @param channelReq
     * @return
     * @throws GooagooException
     */
    public TransData<Object> editChannel(HttpServletRequest request) throws Exception;

    /**
     * 删除渠道信息
     * @param channelId
     * @return
     * @throws Exception 
     */
    public TransData<Object> delChannel(HttpServletRequest request) throws Exception;

    /**
     * 查询顶级渠道list
     * @param request
     * @return
     * @throws Exception 
     */
    public TransData<List<MChannel>> searchAllTopChannel(HttpServletRequest request) throws Exception;

    /**
     * 渠道排序
     * @param channelId
     * @return
     * @throws Exception 
     */
    public TransData<Object> sortChannel(HttpServletRequest request) throws Exception;

}
