package com.gooagoo.common.editor;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.gooagoo.common.utils.TimeUtils;

public class DateEditor extends PropertyEditorSupport
{
    @Override
    public void setAsText(String value)
    {
        try
        {
            Date date = TimeUtils.convertStringToDate(value);
            this.setValue(date);
        }
        catch (Exception e)
        {
            this.setValue(null);
        }
    }

    @Override
    public String getAsText()
    {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) this.getValue());
    }
}
