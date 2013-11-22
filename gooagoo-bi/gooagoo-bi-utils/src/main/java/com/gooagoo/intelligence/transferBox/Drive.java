package com.gooagoo.intelligence.transferBox;

public class Drive implements Runnable
{
    private Tyre tyre;

    public Drive(Tyre tyre)
    {
        this.tyre = tyre;
    }

    @Override
    public void run()
    {
        tyre.run();
    }
}
