package com.gooagoo.intelligence.internalBus;

public class Drive extends Thread
{
    private Customer customer;
    private Object message;

    public Drive(Customer customer)
    {
        this.customer = customer;
    }

    public void setMessage(Object message)
    {
        this.message = message;
    }

    @Override
    public void run()
    {
        customer.message(message);
    }
}
