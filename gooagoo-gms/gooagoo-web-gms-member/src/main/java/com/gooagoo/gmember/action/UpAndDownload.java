package com.gooagoo.gmember.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/upAndDown")
public class UpAndDownload
{
    /**
     * 批量导入首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=import")
    public String imports(HttpServletRequest request, HttpServletResponse response)
    {
        return "/import/index";
    }

    @RequestMapping(params = "method=importMemberInfo")
    public String importUserInfo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //        String shop_id = ((UserInfo) WebUtils.getSessionAttribute(request, Constants.CAS_FILTER_USER)).getUserId();
        //
        //
        //        response.setContentType("text/json;charset=UTF-8");
        //        PrintWriter pw;
        //        pw = response.getWriter();
        //        Gson gs = new Gson();
        //
        //        HashMap<String, String> hashMap = new HashMap<String, String>();
        //        hashMap.put("module", "importExcelFile");
        //        String str = httpUpload.upload(request, hashMap);
        //
        //        List<TempMemberInfo> tempList = new ArrayList<TempMemberInfo>();
        //        if (!"false".equals(str))
        //        {
        //            URL url = new URL(str);
        //            URLConnection urlconn = url.openConnection();
        //            urlconn.connect();
        //            HttpURLConnection httpconn = (HttpURLConnection) urlconn;
        //            if (httpconn.getResponseCode() == HttpURLConnection.HTTP_OK)
        //            {
        //                String[] strArr = str.split("\\.");
        //                InputStream inputStream = urlconn.getInputStream();
        //                try
        //                {
        //                    tempList = this.readXls(shop_id, inputStream, strArr[strArr.length - 1]);
        //                }
        //                catch (Exception e)
        //                {
        //                    ServiceLog.ERROR(e.getLocalizedMessage(), e);
        //                }
        //                if (tempList != null && tempList.size() != 0)
        //                {
        //                    pw.write(gs.toJson(tempList.size()));
        //                }
        //                else
        //                {
        //                    pw.write(gs.toJson("3"));
        //                }
        //            }
        //            else
        //            {
        //                pw.write(gs.toJson("2"));
        //            }
        //        }
        //        else
        //        {
        //            pw.write(gs.toJson("1"));
        //        }
        //        pw.flush();

        return null;
    }

    //    private List<TempMemberInfo> readXls(String shop_id, InputStream inputStream, String fileExtensionName) throws Exception
    //    {
    //        HRImportExeclUtil importExeclUtil = new HRImportExeclUtil();
    //        List<List<String>> list = importExeclUtil.read(inputStream, fileExtensionName);
    //        list = list.subList(1, list.size());
    //        List<TempMemberInfo> listTempMemberInfos = new ArrayList<TempMemberInfo>();
    //        List<String> listString = tempMemberInfoService.findByid(shop_id);
    //        for (List<String> temp : list)
    //        {
    //            if (temp == null)
    //            {
    //                continue;
    //            }
    //            if (listString == null)
    //            {
    //                this.doAdd(shop_id, listTempMemberInfos, temp);
    //            }
    //            else if (listString.indexOf(temp.get(0)) < 0)
    //            {
    //                this.doAdd(shop_id, listTempMemberInfos, temp);
    //            }
    //        }
    //        return listTempMemberInfos;
    //    }
    //
    //    private void doAdd(String shop_id, List<TempMemberInfo> listTempMemberInfos, List<String> temp)
    //    {
    //        TempMemberInfo tempMemberInfo = new TempMemberInfo();
    //        tempMemberInfo.setShopId(shop_id);
    //        tempMemberInfo.setPhyNum(temp.get(0));
    //        tempMemberInfo.setName(temp.get(1));
    //        tempMemberInfo.setSex("男".equals(temp.get(2)) ? "F" : ("女".equals(temp.get(2)) ? "M" : "P"));
    //        tempMemberInfo.setPhone(temp.get(3));
    //        tempMemberInfo.setEmail(temp.get(5));
    //        tempMemberInfo.setWork(temp.get(6));
    //        tempMemberInfo.setWorkplace(temp.get(7));
    //        tempMemberInfo.setPlace(temp.get(8));
    //        tempMemberInfo.setPostcode(temp.get(9));
    //        tempMemberInfo.setAddress(temp.get(10));
    //        tempMemberInfo.setUserClass(temp.get(11));
    //        try
    //        {
    //            tempMemberInfo.setBirthday(TimeUtils.convertStringToDate(temp.get(4)));
    //            tempMemberInfo.setApplyDate(TimeUtils.convertStringToDate(temp.get(12)));
    //        }
    //        catch (Exception e)
    //        {
    //            ServiceLog.ERROR(e.getLocalizedMessage(), e);
    //        }
    //        tempMemberInfo.setIsConvert(0);
    //        tempMemberInfo.setImportTime(new Date());
    //        tempMemberInfo.setIsDel(0);
    //        listTempMemberInfos.add(tempMemberInfo);
    //        tempMemberInfoService.add(tempMemberInfo);
    //    }
}
