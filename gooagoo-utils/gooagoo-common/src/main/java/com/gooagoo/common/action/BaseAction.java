package com.gooagoo.common.action;

import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.gooagoo.common.editor.DateEditor;
import com.gooagoo.common.editor.StringEditor;

/**
 * 所有action的父类
 * @author frenn
 *
 */
public abstract class BaseAction
{

    @InitBinder
    public void InitBinder(WebDataBinder dataBinder)
    {
        dataBinder.registerCustomEditor(Date.class, new DateEditor());
        dataBinder.registerCustomEditor(String.class, new StringEditor(true, true, true));
    }
}
