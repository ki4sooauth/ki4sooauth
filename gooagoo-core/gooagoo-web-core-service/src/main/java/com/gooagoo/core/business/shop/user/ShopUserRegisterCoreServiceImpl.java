package com.gooagoo.core.business.shop.user;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.shop.user.ShopUserRegisterCoreService;
import com.gooagoo.api.generator.core.base.SysDictionaryGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopUserInfoGeneratorCoreService;
import com.gooagoo.common.cipher.Md5Utils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataPatternUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.generator.base.SysDictionary;
import com.gooagoo.entity.generator.base.SysDictionaryExample;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopUserInfo;
import com.gooagoo.exception.common.AccountAlreadyExistsException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class ShopUserRegisterCoreServiceImpl implements ShopUserRegisterCoreService

{

    @Autowired
    private ShopInfoGeneratorCoreService shopInfoGeneratorCoreService;

    @Autowired
    private ShopUserInfoGeneratorCoreService shopUserInfoGeneratorCoreService;

    @Autowired
    private SysDictionaryGeneratorCoreService SysDictionaryGeneratorCoreService;

    private final static Object synObject = new Object();//用户注册同步锁

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean register(ShopInfo shopInfo, ShopUserInfo shopUserInfo) throws Exception
    {
        Date currentTime = new Date();
        //1、校验注册数据
        this.checkRegisterData(shopInfo, shopUserInfo);
        //2、组装商家信息数据
        shopInfo.setShopId(UUID.getUUID());
        shopInfo.setServiceStyle("A");
        shopInfo.setNickName(shopInfo.getEmail().substring(0, shopInfo.getEmail().indexOf("@")));
        shopInfo.setShopStatus("L");
        shopInfo.setLogo1("http://html." + UrlUtils.getBASE_HOST() + "/passport/images/deflogo.png");
        shopInfo.setLogo2("http://html." + UrlUtils.getBASE_HOST() + "/passport/images/deflogow.jpg");
        shopInfo.setLogo3("http://html." + UrlUtils.getBASE_HOST() + "/passport/images/deflogo.png");
        shopInfo.setIsDel("N");
        //3、组装商家营销中心用户信息表数据
        shopUserInfo.setUserId(shopInfo.getEmail());
        shopUserInfo.setShopId(shopInfo.getShopId());
        shopUserInfo.setIsShopAccount("Y");
        shopUserInfo.setPassword(new Md5Utils().encrypt(shopUserInfo.getPassword()));
        shopUserInfo.setStatus("0");
        shopUserInfo.setName(shopInfo.getShopName());
        shopUserInfo.setSex("M");
        SysDictionaryExample sysDictionaryExample = new SysDictionaryExample();
        sysDictionaryExample.createCriteria().andDictionaryTypeEqualTo("shop_user_head_img").andIsDelEqualTo("N");
        sysDictionaryExample.setOrderByClause("english_name ASC");
        List<SysDictionary> sysDictionaryList = this.SysDictionaryGeneratorCoreService.selectByExample(sysDictionaryExample);
        if (CollectionUtils.isEmpty(sysDictionaryList))
        {
            return false;
        }
        shopUserInfo.setHeadImg(sysDictionaryList.get(0).getChineseName());//默认给个头像
        shopUserInfo.setBirthday(currentTime);
        shopUserInfo.setIdType("03");
        shopUserInfo.setIdNo(shopInfo.getShopId());
        shopUserInfo.setIsDel("N");
        synchronized (synObject)
        {
            //4、判断账户是否已存在
            if (this.shopUserInfoGeneratorCoreService.selectByPrimaryKey(shopUserInfo.getUserId()) != null)
            {
                GooagooLog.info("商家用户注册：商家用户（" + shopUserInfo.getUserId() + "）已存在");
                throw new AccountAlreadyExistsException("商家用户（" + shopUserInfo.getUserId() + "）已存在");
            }
            //5、保存注册信息
            if (!this.shopInfoGeneratorCoreService.insertSelective(shopInfo))
            {
                GooagooLog.error("商家用户注册：保存商家信息（" + shopInfo.toString() + "）异常", null);
                throw new OperateFailException("保存商家信息（" + shopInfo.toString() + "）异常");
            }
            if (!this.shopUserInfoGeneratorCoreService.insertSelective(shopUserInfo))
            {
                GooagooLog.error("商家用户注册：保存商家营销中心用户信息（" + shopUserInfo.toString() + "）异常", null);
                throw new OperateFailException("保存商家营销中心用户信息（" + shopUserInfo.toString() + "）异常");
            }
        }

        return true;
    }

    /**
     * 校验注册数据
     * @param shopInfo
     * @param shopUserInfo
     * @return
     * @throws NullException 
     * @throws FormatErrorException 
     */
    private boolean checkRegisterData(ShopInfo shopInfo, ShopUserInfo shopUserInfo) throws NullException, FormatErrorException
    {
        //1、校验邮箱
        if (StringUtils.isBlank(shopInfo.getEmail()))
        {
            GooagooLog.info("校验注册数据：邮箱（" + shopInfo.getEmail() + "为空");
            throw new NullException("邮箱（" + shopInfo.getEmail() + "为空");
        }
        if (shopInfo.getEmail().length() > 50)
        {
            GooagooLog.info("校验注册数据：邮箱（" + shopInfo.getEmail() + "长度超过50个字符");
            throw new FormatErrorException("邮箱（" + shopInfo.getEmail() + "长度超过50个字符");
        }
        if (!DataPatternUtils.chechEmail(shopInfo.getEmail()))
        {
            GooagooLog.info("校验注册数据：邮箱（" + shopInfo.getEmail() + "格式不正确");
            throw new FormatErrorException("邮箱（" + shopInfo.getEmail() + "格式不正确");
        }
        //2、校验密码
        if (StringUtils.isBlank(shopUserInfo.getPassword()))
        {
            GooagooLog.info("校验注册数据：密码（" + shopUserInfo.getPassword() + "为空");
            throw new NullException("密码（" + shopUserInfo.getPassword() + "为空");
        }
        if (shopUserInfo.getPassword().length() < 6 || shopUserInfo.getPassword().length() > 20)
        {
            GooagooLog.info("校验注册数据：密码（" + shopUserInfo.getPassword() + "长度只能在6-20位字符之间");
            throw new FormatErrorException("密码（" + shopUserInfo.getPassword() + "长度只能在6-20位字符之间");
        }
        //3、校验是否连锁
        if (!("N".equals(shopInfo.getIsChain()) || "Y".equals(shopInfo.getIsChain())))
        {
            GooagooLog.info("校验注册数据：是否连锁（" + shopInfo.getIsChain() + "格式不正确");
            throw new FormatErrorException("是否连锁（" + shopInfo.getIsChain() + "格式不正确");
        }
        //4、校验商家名称
        if (StringUtils.isBlank(shopInfo.getShopName()))
        {
            GooagooLog.info("校验注册数据：商家名称（" + shopInfo.getShopName() + "为空");
            throw new NullException("商家名称（" + shopInfo.getShopName() + "为空");
        }
        if (shopInfo.getShopName().length() > 50)
        {
            GooagooLog.info("校验注册数据：商家名称（" + shopInfo.getShopName() + "长度超过50个字符");
            throw new FormatErrorException("商家名称（" + shopInfo.getShopName() + "长度超过50个字符");
        }
        //5、校验商家类型（根节点）
        if (shopInfo.getShopTypeRoot() == null)
        {
            GooagooLog.info("校验注册数据：商家类型（根节点）（" + shopInfo.getShopTypeRoot() + "为空");
            throw new NullException("商家类型（根节点）（" + shopInfo.getShopTypeRoot() + "为空");
        }
        //6、校验商家类型（叶节点）
        if (shopInfo.getShopTypeLeaf() == null)
        {
            GooagooLog.info("校验注册数据：商家类型（叶节点）（" + shopInfo.getShopTypeLeaf() + "为空");
            throw new NullException("商家类型（叶节点）（" + shopInfo.getShopTypeLeaf() + "为空");
        }
        //7、校验营业范围
        if (StringUtils.isNotBlank(shopInfo.getScope()) && shopInfo.getScope().length() > 255)
        {
            GooagooLog.info("校验注册数据：营业范围（" + shopInfo.getScope() + "长度超过255个字符");
            throw new FormatErrorException("营业范围（" + shopInfo.getScope() + "长度超过255个字符");
        }

        return true;
    }
}
