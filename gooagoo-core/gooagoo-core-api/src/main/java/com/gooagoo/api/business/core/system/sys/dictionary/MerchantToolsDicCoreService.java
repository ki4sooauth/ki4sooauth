package com.gooagoo.api.business.core.system.sys.dictionary;

import java.util.List;

import com.gooagoo.entity.generator.base.ShopToolInfo;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

/**
 *  商家服务工具字典表管理
 */
public interface MerchantToolsDicCoreService

{

    /**
     * 新增商家服务工具
     * @param shopToolInfo
     * @return
     * @throws Exception
     */
    public boolean addMerchantToolsDic(ShopToolInfo shopToolInfo) throws Exception;

    /**
     * 编辑商家服务工具
     * @param shopToolInfo
     * @return
     * @throws Exception
     */
    public boolean updateMerchantToolsDic(ShopToolInfo shopToolInfo) throws Exception;

    /**
     * 删除商家服务工具
     * @param toolId
     * @return
     * @throws Exception
     */
    public boolean delMerchantToolsDic(String toolId) throws NullException, OperateFailException;

    /**
     * 批量新增商家服务工具（清空表数据，然后新增）
     * @param sysList
     * @return
     * @throws NullException
     * @throws OperateFailException
     */
    public boolean addAllMerchantToolsDic(List<ShopToolInfo> sysList) throws NullException, OperateFailException;

}
