package com.gooagoo.query.business.user.password;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gooagoo.api.business.query.user.password.UserSecurityQueryService;
import com.gooagoo.api.generator.query.user.SysSecurityQuestionGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserSecurityCardGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserSecurityQuestionGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataPatternUtils;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.generator.user.SysSecurityQuestion;
import com.gooagoo.entity.generator.user.SysSecurityQuestionExample;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserInfoExample;
import com.gooagoo.entity.generator.user.UserSecurityCard;
import com.gooagoo.entity.generator.user.UserSecurityCardExample;
import com.gooagoo.entity.generator.user.UserSecurityQuestion;
import com.gooagoo.entity.generator.user.UserSecurityQuestionExample;
import com.gooagoo.exception.common.AccountNotExistException;
import com.gooagoo.exception.common.SecurityCardNotExistException;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisStringDao;

public class UserSecurityQueryServiceImpl implements UserSecurityQueryService
{

    @Autowired
    private SysSecurityQuestionGeneratorQueryService sysSecurityQuestionGeneratorQueryService;
    @Autowired
    private UserSecurityQuestionGeneratorQueryService userSecurityQuestionGeneratorQueryService;
    @Autowired
    private UserSecurityCardGeneratorQueryService userSecurityCardGeneratorQueryService;
    @Autowired
    private UserInfoGeneratorQueryService userInfoGeneratorQueryService;

    @Override
    public List<SysSecurityQuestion> findSysSecurityQuestion() throws Exception
    {
        SysSecurityQuestionExample sysSecurityQuestionExample = new SysSecurityQuestionExample();
        sysSecurityQuestionExample.createCriteria().andIsDelEqualTo("N");
        return this.sysSecurityQuestionGeneratorQueryService.selectByExample(sysSecurityQuestionExample);
    }

    @Override
    public List<UserSecurityQuestion> findUserSecurityQuestion(String userId) throws Exception
    {
        UserSecurityQuestionExample userSecurityQuestionExample = new UserSecurityQuestionExample();
        userSecurityQuestionExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N");
        return this.userSecurityQuestionGeneratorQueryService.selectByExample(userSecurityQuestionExample);
    }

    @Override
    public String findUserBindedSecurityCard(String userId) throws Exception
    {
        UserSecurityCardExample userSecurityCardExample = new UserSecurityCardExample();
        userSecurityCardExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N").andIsBindEqualTo("Y");
        List<UserSecurityCard> userSecurityCardList = this.userSecurityCardGeneratorQueryService.selectByExample(userSecurityCardExample);
        if (CollectionUtils.isEmpty(userSecurityCardList))
        {
            GooagooLog.info("查询用户密保卡表为空[userId=" + userId + "]");
            return null;
        }
        return userSecurityCardList.get(0).getSerialNum();
    }

    @Override
    public String setLoginSecurityCardCoordinate(String coordinate, Integer expireSecond) throws Exception
    {
        RedisStringDao redisStringDao = new RedisStringDao(RedisServerConstants.securitycard_coordinate);
        String token = UUID.getUUID();
        redisStringDao.set(token, coordinate);
        if (expireSecond != null)
        {
            RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.securitycard_coordinate);
            redisDatabase.setExpire(token, expireSecond);
        }
        return token;
    }

    @Override
    public boolean checkLoginSecurityCardCoordinateDate(String token, String account, String coordinatedate) throws Exception
    {
        UserInfoExample userInfoExample = new UserInfoExample();
        if (DataPatternUtils.checkMobilePhone(account))
        {
            userInfoExample.createCriteria().andMobileEqualTo(account).andIsDelEqualTo("N");//手机号
        }
        else if (DataPatternUtils.chechEmail(account))
        {
            userInfoExample.createCriteria().andEmailEqualTo(account).andIsDelEqualTo("N");//邮箱
        }
        else
        {
            userInfoExample.createCriteria().andAccountEqualTo(account).andIsDelEqualTo("N");//用户名
        }
        List<UserInfo> userInfoList = this.userInfoGeneratorQueryService.selectByExample(userInfoExample);
        if (CollectionUtils.isEmpty(userInfoList))
        {
            GooagooLog.info("个人用户登录：用户（" + account + "）不存在");
            throw new AccountNotExistException("用户（" + account + "）不存在");
        }
        String userId = userInfoList.get(0).getUserId();
        RedisStringDao redisStringDao = new RedisStringDao(RedisServerConstants.securitycard_coordinate);
        String coordinate = redisStringDao.get(token);
        if (StringUtils.isBlank(coordinate))
        {
            GooagooLog.info("redis获取坐标失败[token=" + token + "]");
            return false;
        }
        String[] coordinateArr = coordinate.split(",");//密保卡坐标
        UserSecurityCardExample userSecurityCardExample = new UserSecurityCardExample();
        userSecurityCardExample.createCriteria().andUserIdEqualTo(userId).andIsBindEqualTo("Y").andIsDelEqualTo("N");
        userSecurityCardExample.setOrderByClause("c_time_stamp DESC");
        List<UserSecurityCard> userSecurityCardList = this.userSecurityCardGeneratorQueryService.selectByExample(userSecurityCardExample);
        if (CollectionUtils.isEmpty(userSecurityCardList) || StringUtils.isBlank(userSecurityCardList.get(0).getCoordData()))
        {
            GooagooLog.info("用户密保卡不存在[userId=" + userId + "]");
            throw new SecurityCardNotExistException("查询用户密保卡不存在[userId=" + userId + "]");
        }
        String[][] coordData = JsonUtils.toObj(userSecurityCardList.get(0).getCoordData(), String[][].class);
        String[] coordinateDateArr = coordinatedate.split(",");
        return this.checkCoordinateDate(coordinateDateArr, coordinateArr, coordData);
    }

    /**
     * 判断密保输入是否正确
     * @param coordinatedate 用户选择密保数据
     * @param coordinateList 用户设置密保坐标
     * @param coordData 密保卡数据
     * @return
     */
    private boolean checkCoordinateDate(String[] coordinateDateArr, String[] coordinateArr, String[][] coordData)
    {
        if (coordinateDateArr.length != coordinateArr.length)
        {
            return false;
        }
        for (int i = 0; i < coordinateArr.length; i++)
        {
            String coordinate = coordinateArr[i];//获取坐标
            //获取对应的二维数组索引
            int x = coordinate.substring(0, 1).hashCode() - 65;
            int y = Integer.parseInt(coordinate.substring(1)) - 1;
            if (!coordinateDateArr[i].equals(coordData[x][y]))
            {
                return false;
            }
        }
        return true;
    }

}
