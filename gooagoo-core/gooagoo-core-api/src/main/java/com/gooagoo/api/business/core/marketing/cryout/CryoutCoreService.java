package com.gooagoo.api.business.core.marketing.cryout;

import java.util.List;

import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.exception.GooagooException;

/**
 * 吆喝管理
 */
public interface CryoutCoreService
{

    /**
     *     6.4.1. 创建吆喝
     * @param cryoutInfo
     * @return
     * @throws GooagooException
     */
    public boolean addCryoutInfo(CryoutInfo cryoutInfo) throws Exception;

    /**
     *     6.4.2. 编辑吆喝
     * @param cryoutInfo
     * @return
     * @throws GooagooException
     */
    public boolean updateCryoutInfo(CryoutInfo cryoutInfo) throws Exception;

    /**
     *     6.4.3. 审核吆喝
     * @param id
     * @param status 审核状态(Y-通过，N-不通过)
     * @param note 审核备注
     * @return
     * @throws GooagooException
     */
    public boolean reviewedCryoutInfo(String id, String status, String note) throws Exception;

    /**
     *     6.4.4. 发布吆喝
     * @param id
     * @param userList
     * @param ruleInfo
     * @return
     * @throws GooagooException
     */
    public boolean publishCryoutInfo(String id, List<Account> userList, RuleInfo ruleInfo) throws Exception;

    /**
     *     6.4.7. 删除吆喝
     * @param id
     * @return
     * @throws GooagooException
     */
    public boolean deleteCryoutInfo(String id) throws Exception;

}
