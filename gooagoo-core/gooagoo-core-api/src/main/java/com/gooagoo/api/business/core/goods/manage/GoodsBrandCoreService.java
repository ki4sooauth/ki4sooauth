package com.gooagoo.api.business.core.goods.manage;

import com.gooagoo.entity.generator.goods.GoodsBrand;

/**
 * 品牌管理
 */
public interface GoodsBrandCoreService
{
    /**
     * 通过主键删除品牌信息
     * @param id 主键
     * @return true/false
     * @throws Exception
     */
    public boolean deleteGoodsBrand(String id) throws Exception;

    /**
     * 添加品牌信息
     * @param goodsBrand 品牌信息
     * @return true/false
     * @throws Exception
     */
    public boolean addGoodsBrand(GoodsBrand goodsBrand) throws Exception;

    /**
     * 通过主键修改品牌信息
     * @param goodsBrand 品牌信息
     * @return true/false
     * @throws Exception
     */
    public boolean updateGoodsBrand(GoodsBrand goodsBrand) throws Exception;

}
