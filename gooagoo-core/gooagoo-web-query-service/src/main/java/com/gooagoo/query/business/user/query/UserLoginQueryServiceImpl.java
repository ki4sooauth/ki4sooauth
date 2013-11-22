package com.gooagoo.query.business.user.query;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.user.query.UserLoginQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.redis.data.RedisObjectDao;

@Service
public class UserLoginQueryServiceImpl implements UserLoginQueryService
{

    @Override
    public boolean checkLoginStatus(String userId, String sessionId) throws Exception
    {
        RedisObjectDao objectDao = new RedisObjectDao("login_mobile");
        //手机登录将更新redis中userId和sessionId
        String newSessionId = objectDao.getGenerics(userId, String.class);
        if (StringUtils.hasText(newSessionId) && sessionId.equals(newSessionId))
        {
            return true;
        }
        GooagooLog.warn("用户没有登陆或sessionid失效[UserId=" + userId + "oldSessionId=" + sessionId + "newSessionId=" + newSessionId + "]");
        return false;
    }
}
