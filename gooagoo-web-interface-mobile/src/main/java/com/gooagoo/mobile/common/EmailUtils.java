package com.gooagoo.mobile.common;

import java.util.ArrayList;
import java.util.List;

import com.gooagoo.cache.EmailCache;
import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.push.EmailVo;
import com.gooagoo.entity.push.Message;

public class EmailUtils
{
    /**
     * 发送用户账户激活邮件
     * @param email
     * @param emailCode
     * @return
     */
    public static GooagooMessage<EmailVo> sendActiveEmail(String email, String emailCode)
    {
        return emailMessage(email, "购阿购用户账户激活", EmailCache.get("C").replaceAll("\\$\\{account\\}", email).replaceAll("\\$\\{link\\}", "http://passport."+UrlUtils.getBASE_HOST()+"/userActive?code=" + emailCode));
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
        gooagooMessage.setSource("1");
        gooagooMessage.setFlag(true);
        EmailVo email = new EmailVo();
        email.setUuid(gooagooMessage.getUuid());
        email.setSource("1");
        email.setTo(toList);
        email.setSubject(title);
        email.setText(text);
        gooagooMessage.setContent(email);
        return gooagooMessage;
    }

    /**
     * 发送手机用户注册验证码短信
     * @param mobile
     * @param mobileCode
     * @return
     */
    public static GooagooMessage<Message> sendRisterCodeMessage(String mobile, String mobileCode)
    {
        List<String> mobileList = new ArrayList<String>();
        mobileList.add(mobile);
        GooagooMessage<Message> gooagooMessage = new GooagooMessage<Message>();
        gooagooMessage.setUuid(UUID.getUUID());
        gooagooMessage.setSource("1");
        gooagooMessage.setFlag(true);
        Message message = new Message();
        message.setUuid(gooagooMessage.getUuid());
        message.setSource("1");
        message.setSmsMob(mobileList);
        message.setSmsText(ExceptionCache.get("SA01").replaceAll("\\$\\{mobileCode\\}", mobileCode));
        gooagooMessage.setContent(message);

        return gooagooMessage;
    }
}
