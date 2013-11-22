package com.gooagoo.api.business.core.member.usermember;

import java.util.List;

import com.gooagoo.entity.generator.member.ConvertApply;
import com.gooagoo.entity.generator.member.MemberApply;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberFeatureInfo;
import com.gooagoo.exception.business.card.CardAlreadyConvertedException;
import com.gooagoo.exception.business.member.MemberFeatureCodeIsNullException;
import com.gooagoo.exception.business.member.MemberFeatureCodeTooLongException;
import com.gooagoo.exception.business.member.MemberFeatureValueIsNullException;
import com.gooagoo.exception.business.member.MemberFeatureValueTooLongException;
import com.gooagoo.exception.business.user.UserAlreadyApplyException;
import com.gooagoo.exception.business.user.UserCanNotRepetitionApplyMemberException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

public interface UserMemberCoreService
{
    /**
     * 申请会员
     * @param memberApply
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws OperateFailException
     * @throws UserCanNotRepetitionApplyMemberException 用户不可重复提交申请会员
     */
    public boolean applyMember(MemberApply memberApply) throws Exception;

    /**
     * 删除会员卡
     * @param scardNo
     * @param userId
     * @param shopId
     * @return
     * @throws OperateFailException 操作异常
     */
    public boolean deleteMember(String scardNo, String userId, String shopId) throws Exception;

    /**
     * 手机端删除会员卡
     * moba02
     * @param scardNoList
     * @param userId
     * @throws OperateFailException 操作异常
     */
    public void deleteMemberForMobile(List<String> scardNoList, String userId) throws Exception;

    /**
     * 物理卡转换申请
     * @param convertApply
     * @return
     * @throws NullException
     * @throws FormatErrorException
     * @throws UserAlreadyApplyException 已提交申请异常
     * @throws CardAlreadyConvertedException 物理卡已转换异常
     * @throws OperateFailException
     */
    public boolean applyConvertPhysicalCard(ConvertApply convertApply) throws Exception;

    /**
     * 会员修改会员信息
     * @param userId
     * @param memberBaseInfo
     * @param memberFeatureInfoList
     * @return
     * @throws MemberFeatureCodeIsNullException 会员特征编码为空异常
     * @throws MemberFeatureCodeTooLongException 会员特征编码长度超过32个字符异常
     * @throws MemberFeatureValueIsNullException 会员特征值为空异常
     * @throws MemberFeatureValueTooLongException 会员特征值长度超过32个字符异常
     */
    public boolean updateMemberInfo(String userId, MemberBaseInfo memberBaseInfo, List<MemberFeatureInfo> memberFeatureInfoList) throws Exception;

}
