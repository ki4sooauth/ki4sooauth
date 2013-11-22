package com.gooagoo.common.gus.utils;

import java.util.ArrayList;
import java.util.List;

import com.gooagoo.cache.EmailCache;
import com.gooagoo.common.cipher.DesUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.push.EmailVo;

/**
 * 邮件内容工具类
 * @author GUS
 *
 */
public class EmailContentUtils
{

    private static DesUtils desUtil = null;

    /**
     * 用户身份验证邮件（用于绑定手机）
     * @param email
     * @param emailCode
     * @return
     * @throws Exception 
     */
    public static GooagooMessage<EmailVo> userIdentityForBoundMobile(String email, String emailCode, String mobile) throws Exception
    {
        DesUtils desUtil = getDesUtil();
        String url = DomainUtils.getUserCenterDomain() + "/upersonal/userIdentityForBoundMobile?m=" + desUtil.encrypt(mobile) + "&code=" + emailCode;
        return emailMessage(email, "购阿购用户身份验证", EmailCache.get("A").replaceAll("\\$\\{link\\}", url));
    }

    /**
     * 用户绑定邮箱邮件
     * @param email
     * @param emailCode
     * @return
     * @throws Exception 
     */
    public static GooagooMessage<EmailVo> userBoundEmail(String email, String emailCode) throws Exception
    {
        DesUtils desUtil = getDesUtil();
        String url = DomainUtils.getUserCenterDomain() + "/upersonal/userBoundEmail?e=" + desUtil.encrypt(email) + "&code=" + emailCode;
        return emailMessage(email, "购阿购用户绑定邮箱", EmailCache.get("B").replaceAll("\\$\\{link\\}", url));
    }

    /**
     * 邮件内容
     * @param sendTo
     * @param title
     * @param text
     * @return
     */
    private static GooagooMessage<EmailVo> emailMessage(String sendTo, String title, String text)
    {

        List<String> toList = new ArrayList<String>();
        toList.add(sendTo);
        GooagooMessage<EmailVo> gooagooMessage = new GooagooMessage<EmailVo>();
        gooagooMessage.setUuid(UUID.getUUID());
        gooagooMessage.setSource("3");
        gooagooMessage.setFlag(true);
        EmailVo email = new EmailVo();
        email.setUuid(gooagooMessage.getUuid());
        email.setSource("3");
        email.setTo(toList);
        email.setSubject(title);
        email.setText(text);
        gooagooMessage.setContent(email);

        return gooagooMessage;
    }

    /**
     * 获取加密对象
     * @return
     * @throws Exception 
     */
    private static DesUtils getDesUtil() throws Exception
    {
        if (desUtil == null)
        {
            desUtil = new DesUtils("fetchurl");
        }

        return desUtil;
    }

}
