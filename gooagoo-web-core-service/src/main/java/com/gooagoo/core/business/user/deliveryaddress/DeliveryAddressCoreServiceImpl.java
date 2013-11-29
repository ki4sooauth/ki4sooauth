package com.gooagoo.core.business.user.deliveryaddress;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.user.deliveryaddress.DeliveryAddressCoreService;
import com.gooagoo.api.generator.core.user.ConsigneeInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.user.UserProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataPatternUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.user.ConsigneeInfo;
import com.gooagoo.entity.generator.user.ConsigneeInfoExample;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class DeliveryAddressCoreServiceImpl implements DeliveryAddressCoreService

{

    @Autowired
    private ConsigneeInfoGeneratorCoreService consigneeInfoGeneratorCoreService;

    @Autowired
    private UserProtectedCoreService userProtectedCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addDeliveryAddress(ConsigneeInfo consigneeInfo) throws Exception
    {
        //1、数据校验
        this.checkAddDeliveryAddressData(consigneeInfo);
        //2、若默认选项为默认时添加收货人信息前将该用户所有默认选择重置为N
        if ("Y".equals(consigneeInfo.getIsDefault()))
        {
            this.updateIsNotDefault4User(consigneeInfo.getUserId());
        }
        //3、数据补充
        if (StringUtils.isBlank(consigneeInfo.getConsigneeId()))
        {
            consigneeInfo.setConsigneeId(UUID.getUUID());
        }
        consigneeInfo.setIsDel("N");
        //4、处理创建收货地址
        if (!this.consigneeInfoGeneratorCoreService.insertSelective(consigneeInfo))
        {
            GooagooLog.error("创建收货地址：保存收货地址（" + consigneeInfo.toString() + "）异常", null);
            throw new OperateFailException("保存收货地址（" + consigneeInfo.toString() + "）异常");
        }
        return true;
    }

    @Override
    public boolean deleteDeliveryAddress(String consigneeId) throws Exception
    {
        //1、数据校验
        this.checkDelateDeliveryAddressData(consigneeId);
        ConsigneeInfo consigneeInfo = this.consigneeInfoGeneratorCoreService.selectUnDelByPrimaryKey(consigneeId);
        if (consigneeInfo == null)
        {
            GooagooLog.debug("收货地址不存在[consigneeId=" + consigneeId + "]");
            throw new NullException("收货地址不存在[consigneeId=" + consigneeId + "]");
        }
        //2、处理删除收货地址
        if (!this.consigneeInfoGeneratorCoreService.deleteByPrimaryKey(consigneeId))
        {
            GooagooLog.error("删除收货地址：删除收货地址（" + consigneeId + "）异常", null);
            throw new OperateFailException("删除收货地址（" + consigneeId + "）异常");
        }
        /*
        //3、如果是默认收货地址，将获取最新的其他地址设置成默认收货地址
        if ("Y".equals(consigneeInfo.getIsDefault()))
        {
            ConsigneeInfoExample consigneeInfoExample = new ConsigneeInfoExample();
            consigneeInfoExample.createCriteria().andConsigneeIdNotEqualTo(consigneeId).andUserIdEqualTo(consigneeInfo.getUserId()).andIsDefaultEqualTo("N").andIsDelEqualTo("N");
            consigneeInfoExample.setOrderByClause("c_time_stamp DESC");
            List<ConsigneeInfo> consigneeInfoList = this.consigneeInfoGeneratorCoreService.selectByExample(consigneeInfoExample);
            if (CollectionUtils.isNotEmpty(consigneeInfoList))
            {
                ConsigneeInfo newConsigneeInfo = consigneeInfoList.get(0);
                newConsigneeInfo.setIsDefault("Y");
                if (!this.consigneeInfoGeneratorCoreService.updateByPrimaryKeySelective(newConsigneeInfo))
                {
                    GooagooLog.error("最新收货地址设置成默认收货地址失败[consigneeId=" + newConsigneeInfo.getConsigneeId() + "]", null);
                    throw new OperateFailException("最新收货地址设置成默认收货地址失败[consigneeId=" + newConsigneeInfo.getConsigneeId() + "]");
                }
            }
        }
        */
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public ConsigneeInfo updateDeliveryAddress(ConsigneeInfo consigneeInfo) throws Exception
    {
        //1、数据校验
        this.checkUpdateDeliveryAddressData(consigneeInfo);
        //2、处理编辑收货地址
        if (!this.consigneeInfoGeneratorCoreService.deleteByPrimaryKey(consigneeInfo.getConsigneeId()))
        {
            GooagooLog.error("编辑收货地址：删除旧收货地址（" + consigneeInfo.getConsigneeId() + "）异常", null);
            throw new OperateFailException("编辑收货地址（" + consigneeInfo.getConsigneeId() + "）异常");
        }
        consigneeInfo.setConsigneeId(UUID.getUUID());
        consigneeInfo.setIsDel("N");
        if (!this.consigneeInfoGeneratorCoreService.insertSelective(consigneeInfo))
        {
            GooagooLog.error("编辑收货地址：添加新收货地址（" + consigneeInfo.toString() + "）异常", null);
            throw new OperateFailException("添加新收货地址（" + consigneeInfo.toString() + "）异常");
        }

        return consigneeInfo;
    }

    /**
     * 校验新增收货地址数据
     * @param consigneeInfo
     * @return
     * @throws OperateFailException
     * @throws NullException
     * @throws FormatErrorException
     */
    private boolean checkAddDeliveryAddressData(ConsigneeInfo consigneeInfo) throws OperateFailException, NullException, FormatErrorException
    {
        return this.checkDeliveryAddressData(consigneeInfo);
    }

    /**
     * 校验编辑收货地址数据
     * @param consigneeInfo
     * @return
     * @throws OperateFailException
     * @throws NullException
     * @throws FormatErrorException
     */
    private boolean checkUpdateDeliveryAddressData(ConsigneeInfo consigneeInfo) throws OperateFailException, NullException, FormatErrorException
    {
        //1、校验收货地址编号
        if (StringUtils.isBlank(consigneeInfo.getConsigneeId()))
        {
            GooagooLog.info("校验编辑收货地址数据：收货地址编号（" + consigneeInfo.getConsigneeId() + "）为空");
            throw new NullException(consigneeInfo.getConsigneeId());
        }
        //2、校验收货地址数据
        this.checkDeliveryAddressData(consigneeInfo);

        return true;
    }

    /**
     * 校验删除收货地址数据
     * @param consigneeId
     * @return
     * @throws NullException
     */
    private boolean checkDelateDeliveryAddressData(String consigneeId) throws NullException
    {
        //1、校验收货地址编号
        if (StringUtils.isBlank(consigneeId))
        {
            GooagooLog.info("校验删除收货地址数据：收货地址编号（" + consigneeId + "）为空");
            throw new NullException(consigneeId);
        }

        return true;
    }

    /**
     * 校验收货地址数据
     * @param consigneeInfo
     * @return
     * @throws OperateFailException 
     * @throws NullException 
     * @throws FormatErrorException 
     */
    private boolean checkDeliveryAddressData(ConsigneeInfo consigneeInfo) throws OperateFailException, NullException, FormatErrorException
    {
        //1、校验用户
        if (!this.userProtectedCoreService.checkUserStatus(consigneeInfo.getUserId()))
        {
            GooagooLog.info("校验收货地址数据：用户（" + consigneeInfo.getUserId() + "）状态异常");
            throw new OperateFailException("用户（" + consigneeInfo.getUserId() + "）状态异常");
        }
        //2、校验收货人姓名
        if (StringUtils.isBlank(consigneeInfo.getConsigneeName()))
        {
            GooagooLog.info("校验收货地址数据：收货人姓名（" + consigneeInfo.getConsigneeName() + "）为空");
            throw new NullException("收货人姓名（" + consigneeInfo.getConsigneeName() + "）为空");
        }
        if (consigneeInfo.getConsigneeName().length() > 32)
        {
            GooagooLog.info("校验收货地址数据：收货人姓名（" + consigneeInfo.getConsigneeName() + "）长度超过32个字符");
            throw new FormatErrorException("收货人姓名（" + consigneeInfo.getConsigneeName() + "）长度超过32个字符");
        }
        //3、校验省
        if (StringUtils.isBlank(consigneeInfo.getProvince()))
        {
            GooagooLog.info("校验收货地址数据：省（" + consigneeInfo.getProvince() + "）为空");
            throw new NullException("省（" + consigneeInfo.getProvince() + "）为空");
        }
        //4、校验市
        if (StringUtils.isBlank(consigneeInfo.getCity()))
        {
            GooagooLog.info("校验收货地址数据：市（" + consigneeInfo.getCity() + "）为空");
            throw new NullException("市（" + consigneeInfo.getCity() + "）为空");
        }
        //5、校验县
        if (StringUtils.isBlank(consigneeInfo.getArea()))
        {
            GooagooLog.info("校验收货地址数据：县（" + consigneeInfo.getArea() + "）为空");
            throw new NullException("县（" + consigneeInfo.getArea() + "）为空");
        }
        //6、校验详细地址
        if (StringUtils.isBlank(consigneeInfo.getAddress()))
        {
            GooagooLog.info("校验收货地址数据：详细地址（" + consigneeInfo.getAddress() + "）为空");
            throw new NullException("详细地址（" + consigneeInfo.getAddress() + "）为空");
        }
        if (consigneeInfo.getAddress().length() > 255)
        {
            GooagooLog.info("校验收货地址数据：详细地址（" + consigneeInfo.getAddress() + "）长度超过255个字符");
            throw new FormatErrorException("详细地址（" + consigneeInfo.getAddress() + "）长度超过255个字符");
        }
        //7、校验手机号码、联系电话
        if (StringUtils.isBlank(consigneeInfo.getPhone()) && StringUtils.isBlank(consigneeInfo.getTelephone()))
        {
            GooagooLog.info("校验收货地址数据：手机号码（" + consigneeInfo.getPhone() + "）、联系电话（" + consigneeInfo.getTelephone() + "）全部为空");
            throw new NullException("手机号码（" + consigneeInfo.getPhone() + "）、联系电话（" + consigneeInfo.getTelephone() + "）全部为空");
        }
        if (StringUtils.isNotBlank(consigneeInfo.getPhone()) && !DataPatternUtils.checkMobilePhone(consigneeInfo.getPhone()))
        {
            GooagooLog.info("校验收货地址数据：手机号码（" + consigneeInfo.getPhone() + "）格式不正确");
            throw new FormatErrorException("手机号码（" + consigneeInfo.getPhone() + "）格式不正确");
        }
        if (StringUtils.isNotBlank(consigneeInfo.getTelephone()) && !DataPatternUtils.checkTelePhone(consigneeInfo.getTelephone()))
        {
            GooagooLog.info("校验收货地址数据：联系电话（" + consigneeInfo.getTelephone() + "）格式不正确");
            throw new FormatErrorException("联系电话（" + consigneeInfo.getTelephone() + "）格式不正确");
        }
        //8、校验邮政编码
        if (StringUtils.isBlank(consigneeInfo.getPostCode()))
        {
            GooagooLog.info("校验收货地址数据：邮政编码（" + consigneeInfo.getPostCode() + "）为空");
            throw new NullException("邮政编码（" + consigneeInfo.getPostCode() + "）为空");
        }
        if (!DataPatternUtils.checkZipCode(consigneeInfo.getPostCode()))
        {
            GooagooLog.info("校验收货地址数据：邮政编码（" + consigneeInfo.getPostCode() + "）格式不正确");
            throw new FormatErrorException("邮政编码（" + consigneeInfo.getPostCode() + "）格式不正确");
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean setDeliveryAddress(String userId, String consigneeId) throws Exception
    {
        //更新收货人信息默认选项前将之前的默认选项重置为N
        this.updateIsNotDefault4User(userId);
        ConsigneeInfo consigneeInfo = this.consigneeInfoGeneratorCoreService.selectByPrimaryKey(consigneeId);
        if (consigneeInfo == null)
        {
            GooagooLog.info("查询收货人信息为空[consigneeId=" + consigneeId + "]");
            return false;
        }
        consigneeInfo.setIsDefault("Y");
        return this.consigneeInfoGeneratorCoreService.updateByPrimaryKeySelective(consigneeInfo);
    }

    /**
     * 将指定用户收货人信息默认选项重置为N
     * @param userId
     */
    private void updateIsNotDefault4User(String userId)
    {
        ConsigneeInfoExample consigneeInfoExample = new ConsigneeInfoExample();
        consigneeInfoExample.createCriteria().andUserIdEqualTo(userId).andIsDefaultEqualTo("Y").andIsDelEqualTo("N");
        List<ConsigneeInfo> consigneeInfoList = this.consigneeInfoGeneratorCoreService.selectByExample(consigneeInfoExample);
        if (CollectionUtils.isNotEmpty(consigneeInfoList))
        {
            for (ConsigneeInfo item : consigneeInfoList)
            {
                item.setIsDefault("N");
                this.consigneeInfoGeneratorCoreService.updateByPrimaryKeySelective(item);
            }
        }
    }
}
