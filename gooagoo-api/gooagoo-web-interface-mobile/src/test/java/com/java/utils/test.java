package com.java.utils;

import java.util.Map;

import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.mobile.entity.mobe05.transform.SubmitOrderForm;
import com.gooagoo.mobile.entity.mobe05.transform.SubmitOrderFormRoot;
import com.google.gson.Gson;

public class test
{
    public static void main(String[] args)
    {
        SubmitOrderFormRoot root = new SubmitOrderFormRoot();
        SubmitOrderForm submitOrderForm = new SubmitOrderForm();
        submitOrderForm.setOrderid(UUID.getUUID());
        root.setResult("true");
        root.setMsg("true1");
        root.setSubmitOrderForm(submitOrderForm);
        String json = JsonUtils.toJson(root);
        Map<?, ?> detailsMap = new Gson().fromJson(json, Map.class);
        System.out.print(JsonUtils.json2Map(detailsMap.get("submitOrderForm").toString()).get("orderid"));
    }
}