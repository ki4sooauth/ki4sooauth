package com.gooagoo.common.editor;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringEscapeUtils;

public class StringEditor extends PropertyEditorSupport
{
    private boolean escapeHTML;
    private boolean escapeJavaScript;
    private boolean escapeSQL;

    public StringEditor()
    {
        super();
    }

    public StringEditor(boolean escapeHTML, boolean escapeJavaScript, boolean escapeSQL)
    {
        super();
        this.escapeHTML = escapeHTML;
        this.escapeJavaScript = escapeJavaScript;
        this.escapeSQL = escapeSQL;
    }

    @Override
    public void setAsText(String text)
    {
        if (text == null)
        {
            this.setValue(null);
        }
        else
        {
            String value = text;
            if (this.escapeHTML)
            {
                value = StringEscapeUtils.escapeHtml(value);
            }
            if (this.escapeJavaScript)
            {
                value = StringEscapeUtils.escapeJavaScript(value);
            }
            if (this.escapeSQL)
            {
                value = StringEscapeUtils.escapeSql(value);
            }
            this.setValue(value);
        }
    }

    @Override
    public String getAsText()
    {
        Object value = this.getValue();
        return value != null ? value.toString() : "";
    }
}
