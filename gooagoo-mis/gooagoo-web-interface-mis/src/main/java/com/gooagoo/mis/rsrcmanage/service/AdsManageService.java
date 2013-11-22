package com.gooagoo.mis.rsrcmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.recommendManage.MAdsManage;
import com.gooagoo.view.mis.recommendManage.MBidDetailInfo;

public interface AdsManageService
{

    /**
     * 关联查询广告位信息、广告位管理，以广告位管理为主
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MBidDetailInfo>> queryAllAdsManage(HttpServletRequest request) throws Exception;

    /**
     * 查询广告位管理详细
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<MAdsManage> queryAdsManage(HttpServletRequest request) throws Exception;

    /**
     * 新增广告位管理
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addAdsManage(HttpServletRequest request) throws Exception;

    /**
     * 编辑广告位管理
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateAdsManageOperation(HttpServletRequest request) throws Exception;

    /**
     * 删除广告位管理
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> deleteAdsManage(HttpServletRequest request) throws Exception;

    /**
     * 发布
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> releaseAdsManage(HttpServletRequest request) throws Exception;

    /**
     * 查询提交资料
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<MAdsManage> submitAdsManagePage(HttpServletRequest request) throws Exception;

    /**
     * 提交资料
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> submitAdsManage(HttpServletRequest request) throws Exception;

    /**
     * 审核
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> checkedAdsManage(HttpServletRequest request) throws Exception;

    /**
     * 收款
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> moneyReceiptAdManage(HttpServletRequest request) throws Exception;

    /**
     * 卖出
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> bearPositionAdManage(HttpServletRequest request) throws Exception;

}
