package com.gooagoo.view.gms.statistic;

import java.io.Serializable;

public class FUserStoreRecord implements Serializable
{
    private static final long serialVersionUID = 1L;

    //    private UserStoreRecord storeRecord;
    //
    //    public UserStoreRecord getStoreRecord()
    //    {
    //        return this.storeRecord;
    //    }
    //
    //    public void setStoreRecord(UserStoreRecord storeRecord)
    //    {
    //        this.storeRecord = storeRecord;
    //    }
    //
    //    @Override
    //    public String toString()
    //    {
    //        return "FUserStoreRecord [storeRecord=" + this.storeRecord + "]";
    //    }

    @Override
    public int hashCode()
    {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return this.toString().equals(obj.toString());
    }

}
