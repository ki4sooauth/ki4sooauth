/**
 * ResultRoot.java
 * 
 * 功  能：返回结果
 * 类  名：ResultRoot
 * 
 * ver    变更日      公司      变更人     变更内容
 * ------------------------------------------------------------
 * V1.00  2013-03-21  sinosoft  Administrator    新建
 * 
 * Copyright@2013 Sinosoft Co.,Ltd. All Rights Reserved.
 * 采用工具 xml2obj(sinosoft version)自动生成，请勿手工修改。
 */
package com.gooagoo.trans.entity.resultbase.transform;

import com.google.gson.Gson;

/**
 * 操作结果
 * 
 * @author Administrator
 * @date 2013-03-21
 * Copyright@2013 Sinosoft Co.,Ltd. All Rights Reserved.
 */
public class ResultRoot
{

    /** 查询结果编码，true-成功，false-失败 */
    private String result = "";

    /** 查询失败描述 */
    private String msg = "";

    /**
     * 设置查询结果编码，true-成功，false-失败
     * @param result	查询结果编码，true-成功，false-失败
     */
    public void setResult(String result)
    {
        this.result = result;
    }

    /**
     * 获取查询结果编码，true-成功，false-失败
     * @return	查询结果编码，true-成功，false-失败
     */
    public String getResult()
    {
        return this.result;
    }

    /**
     * 设置查询失败描述
     * @param msg	查询失败描述
     */
    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    /**
     * 获取查询失败描述
     * @return	查询失败描述
     */
    public String getMsg()
    {
        return this.msg;
    }

    /**
     * 转换成json
     */
    public String toJson()
    {
        Gson json = new Gson();
        return json.toJson(this);
    }
}