package com.gooagoo.view.gms.common;

import java.io.Serializable;

public class ResultVo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private boolean rs = false;//结果是否处理成功
    private String rc = "";//结果编码
    private String ri = "";//结果名称

    public ResultVo(boolean rs)
    {
        this.rs = rs;
    }

    public ResultVo(String rc, String ri)
    {
        this.rc = rc;
        this.ri = ri;
    }

    public boolean isRs()
    {
        return this.rs;
    }

    public void setRs(boolean rs)
    {
        this.rs = rs;
    }

    public String getRc()
    {
        return this.rc;
    }

    public void setRc(String rc)
    {
        this.rc = rc;
    }

    public String getRi()
    {
        return this.ri;
    }

    public void setRi(String ri)
    {
        this.ri = ri;
    }

    public String toJson()
    {
        String json = "{\"rs\":" + this.rs + ",\"rc\":\"" + this.rc + "\",\"ri\":\"" + this.ri + "\"}";
        return json;
    }

}
