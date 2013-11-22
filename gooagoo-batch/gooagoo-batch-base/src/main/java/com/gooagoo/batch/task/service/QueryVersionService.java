package com.gooagoo.batch.task.service;

import java.util.List;
import java.util.Map;

import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleResult;

public interface QueryVersionService
{

    /**
     * 查询最新版本信息
     * 读取所有监控的数据库表的最后一次修改数据，再用md5加密
     * @return
     * @throws FetchviewException
     */
    public Map<String, String> getLatestVersion() throws Exception;

    /**
     * 查询省市县信息
     * @return
     */
    public Map<String, List<String>> queryAreaCache();

    /**
     * 查询提示信息
     * @return
     */
    public Map<String, String> queryExceptionCache();

    /**
     * 查询接口信息
     * @return
     */
    public Map<String, List<String>> queryInterfaceCache();

    /**
     * 查询精品广场商品类别信息
     * @return
     */
    public Map<String, List<String>> queryQualitySquareGoodsTypeCache();

    /**
     * 查询购物清单商品类别信息
     * @return
     */
    public Map<String, List<String>> queryShoppingListCache();

    /**
     * 查询商家类型信息
     * @return
     */
    public Map<String, List<String>> queryShopTypeCache();

    /**
     * 查询通用字典表信息
     * @return
     */
    public Map<String, List<String>> querySysdictionaryCache();

    /**
     * 查询邮件配置信息
     * @return
     */
    public Map<String, String> queryEmailCache();

    /**
     * 查询当前生效的、未删除的、已发布的、人群类型为1和2的规则
     * @return
     */
    public List<RuleInfo> queryRuleInfoCache();

    /**
     * 查询规则结果（当前生效的、未删除的、已发布的、人群类型为1和2的规则对应的规则结果）
     * @return
     * @throws Exception 
     */
    public List<RuleResult> queryRuleResultCache() throws Exception;

    /**
     * 查询个人消费管理中心配置信息
     * @return
     */
    public Map<String, String> queryGusConfigCache();

    /**
     * 查询商家管理配置信息
     * @return
     */
    public Map<String, String> queryGmsConfigCache();

    /**
     * 查询后台管理配置信息
     * @return
     */
    public Map<String, String> queryMisConfigCache();

    /**
     * 查询登录注册配置信息
     * @return
     */
    public Map<String, String> queryPassportConfigCache();

    /**
     * 查询文件上传配置信息
     * @return
     */
    public Map<String, String> queryUploadConfigCache();

    /**
     * 查询手机接口配置信息
     * @return
     */
    public Map<String, String> queryMobileConfigCache();
}
