package com.gooagoo.gas.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.para.Parameter;
import com.gooagoo.exception.MessageException;
import com.gooagoo.exception.common.AccountIsLockedException;
import com.gooagoo.exception.common.AccountNotExistException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.PasswordIncorrectException;
import com.gooagoo.gas.api.service.LoginGasService;
import com.gooagoo.gas.common.InterfaceUtils;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasa01.transform.LoginRoot;
import com.gooagoo.gas.entity.transdata.GasTransData;
import com.gooagoo.gas.service.IgasService;

/**
 * 接口gasa01:店员登录
 * */

@Service("gasa01")
public class GASA01ServiceImpl implements IgasService
{
    @Autowired
    private LoginGasService loginGasService;

    @Override
    public String doIgas(HttpServletRequest request) throws Exception
    {
        LoginRoot root = new LoginRoot();
        root.setResult("false");

        try
        {
            Parameter parameter = InterfaceUtils.collectParameter(request);
            String mac = parameter.getString("mac");//店员助理MAC地址
            String shopuserid = parameter.getString("shopuserid");//店员登录账号
            String password = parameter.getString("password");//店员登录账号
            GooagooLog.info(InterfaceUtils.getLogMsg(request, "gasa01"));
            if (!StringUtils.hasText(mac))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_MAC_IS_NULL);
            }
            if (!StringUtils.hasText(shopuserid))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_SHOPUSERID_IS_NULL);
            }
            if (!StringUtils.hasText(password))
            {
                throw new MessageException(MessageConst.GAS_PARAMETER_PASSWORD_IS_NULL);
            }

            root = this.loginGasService.Login(mac, shopuserid, password);

            root.setResult("true");
            root.setMsg("登录成功");
        }
        catch (MessageException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = ExceptionCache.get(e.getMessage());
            root.setMsg(err);
            root.setMsgcode(e.getMessage());
        }
        catch (NullException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.GAS_LOGIN_ACCOUNT_OR_PASSWORD_IS_NULL;
            root.setMsgcode(err);
            root.setMsg(ExceptionCache.get(err));

        }
        catch (AccountNotExistException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.GAS_LOGIN_ACCOUNT_IS_NOT_EXIST;
            root.setMsgcode(err);
            root.setMsg(ExceptionCache.get(err));
        }
        catch (PasswordIncorrectException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.GAS_LOGIN_ACCOUNT_ERROR;
            root.setMsgcode(err);
            root.setMsg(ExceptionCache.get(err));
        }
        catch (AccountIsLockedException e)
        {
            GooagooLog.error(e.getMessage(), e);
            String err = MessageConst.GAS_LOGIN_ACCOUNT_LOCKED;
            root.setMsgcode(err);
            root.setMsg(ExceptionCache.get(err));
        }

        GasTransData gasTransData = new GasTransData();
        gasTransData.setResultJson(root.toJson());
        return gasTransData.toJson();
    }
}
