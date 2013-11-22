package com.gooagoo.common.gus.utils;

import java.util.ArrayList;
import java.util.List;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.gus.constants.MobileContentConst;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.push.Message;

/**
 * 短信内容工具类
 * @author GUS
 *
 */
public class MobileContentUtils
{

    /**
     * 用户身份验证短信（用于绑定邮箱）
     * @param mobile
     * @param mobileCode
     * @return
     */
    public static GooagooMessage<Message> userIdentityForBoundEmail(String mobile, String mobileCode)
    {
        return mobileMessage(mobile, ExceptionCache.get(MobileContentConst.MOBILE_CONTENT_IDENTITY_BOUNDEMAIL).replaceAll("\\$\\{mobileCode\\}", mobileCode));
    }

    /**
     * 用户绑定手机短信内容
     * @param telephone
     * @param mobileCode
     * @return
     */
    public static GooagooMessage<Message> userBoundMobileMessage(String mobile, String mobileCode)
    {
        return mobileMessage(mobile, ExceptionCache.get(MobileContentConst.MOBILE_CONTENT_BOUNDMOBILE).replaceAll("\\$\\{mobileCode\\}", mobileCode));
    }

    /**
     * 短信内容
     * @param sendTo
     * @param title
     * @param text
     * @return
     */
    private static GooagooMessage<Message> mobileMessage(String mobile, String content)
    {
        List<String> mobileList = new ArrayList<String>();
        mobileList.add(mobile);
        GooagooMessage<Message> gooagooMessage = new GooagooMessage<Message>();
        gooagooMessage.setUuid(UUID.getUUID());
        gooagooMessage.setSource("3");
        gooagooMessage.setFlag(true);
        Message message = new Message();
        message.setUuid(gooagooMessage.getUuid());
        message.setSource("3");
        message.setSmsMob(mobileList);
        message.setSmsText(content);
        gooagooMessage.setContent(message);

        return gooagooMessage;
    }

}
