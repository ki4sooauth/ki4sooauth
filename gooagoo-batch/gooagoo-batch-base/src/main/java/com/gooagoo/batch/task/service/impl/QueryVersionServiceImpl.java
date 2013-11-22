package com.gooagoo.batch.task.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.marketing.rule.RuleResultQueryService;
import com.gooagoo.api.generator.query.base.EmailConfigGeneratorQueryService;
import com.gooagoo.api.generator.query.base.PromptingMessageGeneratorQueryService;
import com.gooagoo.api.generator.query.base.QualitySquareGoodsTypeGeneratorQueryService;
import com.gooagoo.api.generator.query.base.ShopTypeGeneratorQueryService;
import com.gooagoo.api.generator.query.base.ShoppingListGoodsTypeGeneratorQueryService;
import com.gooagoo.api.generator.query.base.SysConfigGeneratorQueryService;
import com.gooagoo.api.generator.query.base.SysDictionaryGeneratorQueryService;
import com.gooagoo.api.generator.query.base.UserCityareaGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.RuleInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.InterfaceBaseInfoGeneratorQueryService;
import com.gooagoo.batch.task.service.QueryVersionService;
import com.gooagoo.common.cipher.Md5Utils;
import com.gooagoo.common.utils.DataUtils;
import com.gooagoo.entity.generator.base.EmailConfig;
import com.gooagoo.entity.generator.base.EmailConfigExample;
import com.gooagoo.entity.generator.base.PromptingMessage;
import com.gooagoo.entity.generator.base.PromptingMessageExample;
import com.gooagoo.entity.generator.base.QualitySquareGoodsType;
import com.gooagoo.entity.generator.base.QualitySquareGoodsTypeExample;
import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.entity.generator.base.ShopTypeExample;
import com.gooagoo.entity.generator.base.ShoppingListGoodsType;
import com.gooagoo.entity.generator.base.ShoppingListGoodsTypeExample;
import com.gooagoo.entity.generator.base.SysConfig;
import com.gooagoo.entity.generator.base.SysConfigExample;
import com.gooagoo.entity.generator.base.SysDictionary;
import com.gooagoo.entity.generator.base.SysDictionaryExample;
import com.gooagoo.entity.generator.base.UserCityarea;
import com.gooagoo.entity.generator.base.UserCityareaExample;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleInfoExample;
import com.gooagoo.entity.generator.marketing.RuleResult;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfo;
import com.gooagoo.entity.generator.sys.InterfaceBaseInfoExample;

@Service
public class QueryVersionServiceImpl implements QueryVersionService
{

    @Autowired
    UserCityareaGeneratorQueryService userCityareaGeneratorQueryService;
    @Autowired
    EmailConfigGeneratorQueryService emailConfigGeneratorQueryService;
    @Autowired
    PromptingMessageGeneratorQueryService promptingMessageGeneratorQueryService;
    @Autowired
    InterfaceBaseInfoGeneratorQueryService interfaceBaseInfoGeneratorQueryService;
    @Autowired
    QualitySquareGoodsTypeGeneratorQueryService qualitySquareGoodsTypeGeneratorQueryService;
    @Autowired
    ShoppingListGoodsTypeGeneratorQueryService shoppingListGoodsTypeGeneratorQueryService;
    @Autowired
    ShopTypeGeneratorQueryService shopTypeGeneratorQueryService;
    @Autowired
    SysDictionaryGeneratorQueryService sysDictionaryGeneratorQueryService;
    @Autowired
    RuleInfoGeneratorQueryService ruleInfoGeneratorQueryService;
    @Autowired
    SysConfigGeneratorQueryService sysConfigGeneratorQueryService;

    @Autowired
    RuleResultQueryService ruleResultQueryService;

    Md5Utils md5Utils = new Md5Utils();

    @Override
    public Map<String, String> getLatestVersion() throws Exception
    {
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("areaCache", this.queryUserCityareaVersion());
        map.put("emailCache", this.queryEmailVersion());
        map.put("exceptionCache", this.queryExceptionVersion());
        map.put("interfaceCache", this.queryInterfaceVersion());
        map.put("qualitySquareGoodsTypeCache", this.queryQualitySquareGoodsTypeVersion());
        map.put("shoppingListCache", this.queryShoppingListVersion());
        map.put("shopTypeCache", this.queryShopTypeVersion());
        map.put("sysdictionaryCache", this.querySysdictionaryVersion());
        map.put("ruleInfoCache", this.queryRuleInfoVersion());
        map.put("ruleResultCache", map.get("ruleInfoCache"));
        map.put("gusConfigCache", this.queryConfigVersion("gus"));
        map.put("misConfigCache", this.queryConfigVersion("mis"));
        map.put("mobileConfigCache", this.queryConfigVersion("mobile"));
        map.put("passportConfigCache", this.queryConfigVersion("passport"));
        map.put("gmsConfigCache", this.queryConfigVersion("gms"));
        map.put("uploadConfigCache", this.queryConfigVersion("upload"));
        return map;
    }

    private String queryConfigVersion(String string)
    {
        SysConfigExample sysConfigExample = new SysConfigExample();
        sysConfigExample.setOrderByClause("c_time_stamp desc");
        sysConfigExample.createCriteria().andSysTypeEqualTo(string);
        sysConfigExample.setPage(1, 1);
        List<SysConfig> list = this.sysConfigGeneratorQueryService.selectByExample(sysConfigExample);
        if (list != null && list.size() != 0)
        {
            SysConfig sysConfig = list.get(0);
            return this.getVersionByObject(sysConfig);
        }
        else
        {
            return "000000";
        }
    }

    private String queryRuleInfoVersion()
    {
        RuleInfoExample ruleInfoExample = new RuleInfoExample();
        ruleInfoExample.setOrderByClause("c_time_stamp desc");
        ruleInfoExample.setPage(1, 1);
        List<RuleInfo> list = this.ruleInfoGeneratorQueryService.selectByExample(ruleInfoExample);
        if (list != null && list.size() != 0)
        {
            RuleInfo ruleInfo = list.get(0);
            return this.getVersionByObject(ruleInfo);
        }
        else
        {
            return "000000";
        }
    }

    private String getVersionByObject(Object object)
    {
        return this.md5Utils.encrypt(DataUtils.serialize(object));
    }

    private String querySysdictionaryVersion()
    {
        SysDictionaryExample sysDictionaryExample = new SysDictionaryExample();
        sysDictionaryExample.setOrderByClause("c_time_stamp desc");
        sysDictionaryExample.setPage(1, 1);
        SysDictionary sysDictionary = this.sysDictionaryGeneratorQueryService.selectByExample(sysDictionaryExample).get(0);
        return this.getVersionByObject(sysDictionary);
    }

    private String queryShopTypeVersion()
    {
        ShopTypeExample shopTypeExample = new ShopTypeExample();
        shopTypeExample.setOrderByClause("c_time_stamp desc");
        shopTypeExample.setPage(1, 1);
        ShopType shopType = this.shopTypeGeneratorQueryService.selectByExample(shopTypeExample).get(0);
        return this.getVersionByObject(shopType);
    }

    private String queryShoppingListVersion()
    {
        ShoppingListGoodsTypeExample shoppingListGoodsTypeExample = new ShoppingListGoodsTypeExample();
        shoppingListGoodsTypeExample.setOrderByClause("c_time_stamp desc");
        shoppingListGoodsTypeExample.setPage(1, 1);
        ShoppingListGoodsType shoppingListGoodsType = this.shoppingListGoodsTypeGeneratorQueryService.selectByExample(shoppingListGoodsTypeExample).get(0);
        return this.getVersionByObject(shoppingListGoodsType);
    }

    private String queryQualitySquareGoodsTypeVersion()
    {
        QualitySquareGoodsTypeExample qualitySquareGoodsTypeExample = new QualitySquareGoodsTypeExample();
        qualitySquareGoodsTypeExample.setOrderByClause("c_time_stamp desc");
        qualitySquareGoodsTypeExample.setPage(1, 1);
        QualitySquareGoodsType qualitySquareGoodsType = this.qualitySquareGoodsTypeGeneratorQueryService.selectByExample(qualitySquareGoodsTypeExample).get(0);
        return this.getVersionByObject(qualitySquareGoodsType);
    }

    private String queryInterfaceVersion()
    {
        InterfaceBaseInfoExample interfaceBaseInfoExample = new InterfaceBaseInfoExample();
        interfaceBaseInfoExample.setOrderByClause("c_time_stamp desc");
        interfaceBaseInfoExample.setPage(1, 1);
        InterfaceBaseInfo interfaceBaseInfo = this.interfaceBaseInfoGeneratorQueryService.selectByExample(interfaceBaseInfoExample).get(0);
        return this.getVersionByObject(interfaceBaseInfo);
    }

    private String queryExceptionVersion()
    {
        PromptingMessageExample promptingMessageExample = new PromptingMessageExample();
        promptingMessageExample.setOrderByClause("c_time_stamp desc");
        promptingMessageExample.setPage(1, 1);
        PromptingMessage promptingMessage = this.promptingMessageGeneratorQueryService.selectByExample(promptingMessageExample).get(0);
        return this.getVersionByObject(promptingMessage);
    }

    private String queryEmailVersion()
    {
        EmailConfigExample emailConfigExample = new EmailConfigExample();
        emailConfigExample.setOrderByClause("c_time_stamp desc");
        emailConfigExample.setPage(1, 1);
        EmailConfig emailConfig = this.emailConfigGeneratorQueryService.selectByExample(emailConfigExample).get(0);
        return this.getVersionByObject(emailConfig);
    }

    private String queryUserCityareaVersion()
    {
        UserCityareaExample userCityareaExample = new UserCityareaExample();
        userCityareaExample.setOrderByClause("c_time_stamp desc");
        userCityareaExample.setPage(1, 1);
        UserCityarea userCityarea = this.userCityareaGeneratorQueryService.selectByExample(userCityareaExample).get(0);
        return this.getVersionByObject(userCityarea);
    }

    @Override
    public Map<String, List<String>> queryAreaCache()
    {
        Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
        UserCityareaExample userCityareaExample = new UserCityareaExample();
        userCityareaExample.createCriteria().andIsDelEqualTo("N");
        List<UserCityarea> list = this.userCityareaGeneratorQueryService.selectByExample(userCityareaExample);
        List<String> value = null;
        for (UserCityarea userCityarea : list)
        {
            value = new ArrayList<String>();
            value.add(userCityarea.getCityName());//城市名称
            value.add(userCityarea.getParentCityId());//上级编码
            map.put(userCityarea.getCityId(), value);
        }
        return map;
    }

    @Override
    public Map<String, String> queryEmailCache()
    {
        Map<String, String> map = new LinkedHashMap<String, String>();
        EmailConfigExample emailConfigExample = new EmailConfigExample();
        emailConfigExample.createCriteria().andIsDelEqualTo("N");
        List<EmailConfig> list = this.emailConfigGeneratorQueryService.selectByExample(emailConfigExample);
        for (EmailConfig x : list)
        {
            map.put(x.getEmailId(), x.getContent());
        }
        return map;
    }

    @Override
    public Map<String, String> queryExceptionCache()
    {
        Map<String, String> map = new LinkedHashMap<String, String>();
        PromptingMessageExample promptingMessageExample = new PromptingMessageExample();
        promptingMessageExample.createCriteria().andIsDelEqualTo("N");
        List<PromptingMessage> list = this.promptingMessageGeneratorQueryService.selectByExample(promptingMessageExample);
        for (PromptingMessage x : list)
        {
            map.put(x.getMessageId(), x.getContent());
        }
        return map;
    }

    @Override
    public Map<String, List<String>> queryInterfaceCache()
    {
        Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
        InterfaceBaseInfoExample interfaceBaseInfoExample = new InterfaceBaseInfoExample();
        interfaceBaseInfoExample.createCriteria().andIsDelEqualTo("N");
        List<InterfaceBaseInfo> list = this.interfaceBaseInfoGeneratorQueryService.selectByExample(interfaceBaseInfoExample);
        List<String> value = null;
        for (InterfaceBaseInfo x : list)
        {
            value = new ArrayList<String>();
            value.add(x.getIName());
            value.add(x.getIUrl());
            value.add(x.getBehaveType());
            map.put(x.getICode(), value);
        }
        return map;
    }

    @Override
    public Map<String, List<String>> queryQualitySquareGoodsTypeCache()
    {
        Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
        QualitySquareGoodsTypeExample qualitySquareGoodsTypeExample = new QualitySquareGoodsTypeExample();
        qualitySquareGoodsTypeExample.createCriteria().andIsDelEqualTo("N");
        List<QualitySquareGoodsType> list = this.qualitySquareGoodsTypeGeneratorQueryService.selectByExample(qualitySquareGoodsTypeExample);
        List<String> value = null;
        for (QualitySquareGoodsType x : list)
        {
            value = new ArrayList<String>();
            value.add(String.valueOf(x.getParentGoodsTypeId()));
            value.add(x.getGoodsTypeName());
            value.add(x.getFrontPic());
            value.add(x.getBackPic());
            map.put(String.valueOf(x.getGoodsTypeId()), value);
        }
        return map;
    }

    @Override
    public Map<String, List<String>> queryShoppingListCache()
    {
        Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
        ShoppingListGoodsTypeExample shoppingListGoodsTypeExample = new ShoppingListGoodsTypeExample();
        shoppingListGoodsTypeExample.createCriteria().andIsDelEqualTo("N");
        List<ShoppingListGoodsType> list = this.shoppingListGoodsTypeGeneratorQueryService.selectByExample(shoppingListGoodsTypeExample);
        List<String> value = null;
        for (ShoppingListGoodsType x : list)
        {
            value = new ArrayList<String>();
            value.add(String.valueOf(x.getParentGoodsTypeId()));
            value.add(x.getGoodsTypeName());
            value.add(x.getFrontPic());
            value.add(x.getBackPic());
            map.put(String.valueOf(x.getGoodsTypeId()), value);
        }
        return map;
    }

    @Override
    public Map<String, List<String>> queryShopTypeCache()
    {
        Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
        ShopTypeExample shopTypeExample = new ShopTypeExample();
        shopTypeExample.createCriteria().andIsDelEqualTo("N");
        List<ShopType> list = this.shopTypeGeneratorQueryService.selectByExample(shopTypeExample);
        List<String> value = null;
        for (ShopType x : list)
        {
            value = new ArrayList<String>();
            value.add(String.valueOf(x.getParentShopTypeId()));
            value.add(x.getShopTypeName());
            value.add(x.getFrontPic());
            value.add(x.getBackPic());
            map.put(String.valueOf(x.getShopTypeId()), value);
        }
        return map;
    }

    @Override
    public Map<String, List<String>> querySysdictionaryCache()
    {
        Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
        SysDictionaryExample sysDictionaryExample = new SysDictionaryExample();
        sysDictionaryExample.createCriteria().andIsDelEqualTo("N");
        List<SysDictionary> list = this.sysDictionaryGeneratorQueryService.selectByExample(sysDictionaryExample);
        List<String> value = null;
        for (SysDictionary x : list)
        {
            value = new ArrayList<String>();
            value.add(x.getDictionaryType());
            value.add(x.getEnglishName());
            value.add(x.getChineseName());
            map.put(String.valueOf(x.getSysDictionaryId()), value);
        }
        return map;
    }

    @Override
    public List<RuleInfo> queryRuleInfoCache()
    {
        RuleInfoExample ruleInfoExample = new RuleInfoExample();
        ruleInfoExample.createCriteria().andIsDelEqualTo("N");//未删除的
        ruleInfoExample.createCriteria().andPublishStatusEqualTo("P");//已发布的
        ruleInfoExample.createCriteria().andStartTimeLessThan(new Date());//生效时间小于当前时间
        ruleInfoExample.createCriteria().andEndTimeGreaterThan(new Date());//失效时间大于当前时间
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        ruleInfoExample.createCriteria().andCrowdTypeIn(list);//人群类型为1和2
        ruleInfoExample.setOrderByClause("c_time_stamp desc");
        return this.ruleInfoGeneratorQueryService.selectByExample(ruleInfoExample);
    }

    @Override
    public List<RuleResult> queryRuleResultCache() throws Exception
    {
        return this.ruleResultQueryService.findRuleResultForCache();
    }

    @Override
    public Map<String, String> queryGusConfigCache()
    {
        return this.querySysConfigCache("gus");
    }

    private Map<String, String> querySysConfigCache(String string)
    {
        Map<String, String> map = new LinkedHashMap<String, String>();
        SysConfigExample sysConfigExample = new SysConfigExample();
        sysConfigExample.createCriteria().andSysTypeEqualTo(string);
        List<SysConfig> list = this.sysConfigGeneratorQueryService.selectByExample(sysConfigExample);
        for (SysConfig x : list)
        {
            map.put(x.getConfigKey(), x.getConfigValue());
        }
        return map;
    }

    @Override
    public Map<String, String> queryGmsConfigCache()
    {
        return this.querySysConfigCache("gms");
    }

    @Override
    public Map<String, String> queryMisConfigCache()
    {
        return this.querySysConfigCache("mis");
    }

    @Override
    public Map<String, String> queryPassportConfigCache()
    {
        return this.querySysConfigCache("passport");
    }

    @Override
    public Map<String, String> queryUploadConfigCache()
    {
        return this.querySysConfigCache("upload");
    }

    @Override
    public Map<String, String> queryMobileConfigCache()
    {
        return this.querySysConfigCache("mobile");
    }

}
