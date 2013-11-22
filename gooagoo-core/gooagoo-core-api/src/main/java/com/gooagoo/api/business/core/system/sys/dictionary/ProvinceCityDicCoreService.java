package com.gooagoo.api.business.core.system.sys.dictionary;

import java.util.List;

import com.gooagoo.entity.generator.base.UserCityarea;

/**
 *  省份城市字典表管理
 */
public interface ProvinceCityDicCoreService

{

    /**
     * 新增省份城市
     * @param userCityarea
     * @return
     * @throws Exception
     */
    public boolean addProvinceCityDic(UserCityarea userCityarea) throws Exception;

    /**
     * 编辑省份城市
     * @param userCityarea
     * @return
     * @throws Exception
     */
    public boolean updateProvinceCityDic(UserCityarea userCityarea) throws Exception;

    /**
     * 删除省份城市
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delProvinceCityDic(String id) throws Exception;

    /**
     * 批量新增省份城市（清空表数据，然后新增）
     * @param sysList
     * @return
     * @throws Exception
     */
    public boolean addAllProvinceCityDic(List<UserCityarea> sysList) throws Exception;

}
