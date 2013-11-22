package com.gooagoo.common.enums;

public enum Audio
{
    Coupon("01"), NoCard("02"), Order("03"), PickUpGoods("04"), Invoice("05");
    private String value;

    private Audio(String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return this.value;
    }
}
