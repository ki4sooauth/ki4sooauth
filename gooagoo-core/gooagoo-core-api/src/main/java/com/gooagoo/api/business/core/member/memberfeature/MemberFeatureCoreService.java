package com.gooagoo.api.business.core.member.memberfeature;

import java.util.List;

import com.gooagoo.entity.generator.member.MemberFeature;

/***
 * 会员特征管理
 * @author Administrator
 *
 */
public interface MemberFeatureCoreService
{
    /****
     * 5.6.1.2. 新增会员特征
     * @param memberFeature
     * @return true/false
     * @throws Exception
     */
    public boolean addMemberFeature(MemberFeature memberFeature) throws Exception;

    /****
     * 5.6.1.3. 编辑会员特征
     * @param memberFeature
     * @return true/false
     * @throws Exception
     */
    public boolean updateMemberFeature(MemberFeature memberFeature) throws Exception;

    /*****
     * 5.6.1.4. 删除会员特征
     * @param Id
     * @return true/false
     * @throws Exception
     */
    public boolean deleteMemberFeature(String Id) throws Exception;

    /****
     * 编辑会员特征值
     * @param shopId
     * @param userId
     * @param phyNo
     * @param scardNo
     * @param featureCodes
     * @param featureValues
     * @return true/false
     * @throws Exception
     */
    public boolean updateMemberFeatureInfos(String shopId, String userId, String phyNo, String scardNo, List<String> featureCodes, List<String> featureValues) throws Exception;

}
