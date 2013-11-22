package com.gooagoo.igms.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.UserException;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.member.FConvertApply;
import com.gooagoo.view.gms.member.FMemberApply;
import com.gooagoo.view.gms.member.FMemberBaseInfo;
import com.gooagoo.view.gms.member.FMemberFeature;
import com.gooagoo.view.gms.member.FMemberSpecial;
import com.gooagoo.view.gms.member.FSAIntegralMember;
import com.gooagoo.view.gms.member.FCardUpInfo;
import com.gooagoo.view.gms.member.FUser;

public interface MemberService
{
    /**
     * 会员申请信息列表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FMemberApply>> pageMemberApply(HttpServletRequest request) throws Exception;

    /**
     * 物理卡转换申请信息列表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FConvertApply>> pageConvertApply(HttpServletRequest request) throws Exception;

    /**
     * 积分升级会员信息列表
     * @param request
     * @return
     * @throws Exception
     */
    TransData<PageModel<FCardUpInfo>> pageIntegralUpgrade(HttpServletRequest request) throws Exception;

    /**
     * 积分特批列表 
     * @param request
     * @return
     * @throws UserException
     * @throws MemberException 
     */
    TransData<PageModel<FMemberBaseInfo>> pageSAIntegralMember(HttpServletRequest request) throws Exception;

    /**
     * 审核会员申请
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> approvalAppCard(HttpServletRequest request) throws Exception;

    /**
     * 审核物理卡转换申请
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> approvalPsyConvert(HttpServletRequest request) throws Exception;

    /**
     * 审核积分升级
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> approvalUpgrade(HttpServletRequest request) throws Exception;

    /**
     * 会员卡特批
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> approveSpecial(HttpServletRequest request) throws Exception;

    /**
     * 查询商家会员信息列表
     * @param request
     * @return
     * @throws Exception
     */
    TransData<PageModel<FMemberBaseInfo>> pageMemberBaseInfo(HttpServletRequest request) throws Exception;

    /**
     * 根据电话号码、电子邮件查询用户
     * @param request
     * @return
     * @throws UserException
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    TransData<FUser> getSpecialUser(HttpServletRequest request) throws UserException, IllegalArgumentException, IllegalAccessException;

    /**
     * 积分特批
     * @param request
     * @return
     * @throws Exception
     */
    TransData<Object> iApproveSpecial(HttpServletRequest request) throws Exception;

    /**
     * 总会员人数
     */
    public TransData<Integer> memberCount(HttpServletRequest request) throws Exception;

    /**
     * 添加会员特征
     * @param request
     * @return
     * @throws Exception
     */
    TransData<Object> addSpecial(HttpServletRequest request) throws Exception;

    /**
     * 删除会员特征
     * @param request
     * @return
     * @throws Exception
     */
    TransData<Object> delSpecial(HttpServletRequest request) throws Exception;

    /**
     * 修改会员特征
     * @param request
     * @return
     * @throws Exception
     */
    TransData<Object> updateSpecial(HttpServletRequest request) throws Exception;

    /**
     * 获得会员特征列
     * @param request
     * @return
     * @throws Exception
     */
    TransData<List<FMemberFeature>>  getSpecials(HttpServletRequest request) throws Exception;

    /**
     * 获得会员特征值列
     * @param request
     * @return
     * @throws Exception
     */
    TransData<List<FMemberSpecial>> getSpecialValues(HttpServletRequest request) throws Exception;

    /**
     * 修改会员特征值
     * @param request
     * @return
     * @throws Exception
     */
    TransData<Object> updateSpecialValue(HttpServletRequest request) throws Exception;

}
