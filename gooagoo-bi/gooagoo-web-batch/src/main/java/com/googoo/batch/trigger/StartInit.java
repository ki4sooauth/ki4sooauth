package com.googoo.batch.trigger;

import com.googoo.batch.dispatcher.analysis.InitTypeGenerator;

public class StartInit
{
    public void init()
    {
        InitTypeGenerator type = new InitTypeGenerator();
        type.init();
    }
}
