package com.gooagoo.mis.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;

import com.gooagoo.common.log.GooagooLog;

/**
 * 后台管理系统工具类
 * @author Administrator
 *
 */
public class MisReportUpload
{
    @SuppressWarnings("rawtypes")
    @Autowired
    private static List fileItem = new ArrayList(); /* FileItem */
    @Autowired
    private static ServletContext m_application;

    /**
     * 将文件临时存放
     * @param request
     * @param response
     */
    @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
    public static List uploadfile(HttpServletRequest request)
    {
        m_application = request.getSession().getServletContext();
        //HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
        //m_application = pageContext.getServletContext();
        //HashMap proMap = new HashMap();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        List fileName = new ArrayList(); //文件名称
        if (isMultipart)
        {
            File temPath = new File("D:/operateExcel");// 临时文件目录
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setRepository(temPath);
            factory.setSizeThreshold(1024 * 1024);//设置缓冲区大小，上传文件大于1MB的话会被存至指定目录下的临时文件
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            //String charset = request.getCharacterEncoding();
            //if (charset != null) {
            //    upload.setHeaderEncoding(charset);
            //}else{
            //    upload.setHeaderEncoding("UTF-8");
            //}
            List inputItems = null; /* inputItems */
            try
            {
                inputItems = upload.parseRequest(request);
            }
            catch (Exception e)
            {
                //log.info("com.apache.fileupload.Request "+e);
                GooagooLog.info("字典表导入异常：com.apache.fileupload.Request " + e);
            }
            // Process the uploaded items
            Iterator iter = inputItems.iterator();
            while (iter.hasNext())
            {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField())
                {
                    String reqname = item.getFieldName();
                    String reqvalue = item.getString();
                    try
                    {
                        //reqvalue = new String(reqvalue.getBytes("ISO8859_1"),"GBK");
                        reqvalue = new String(reqvalue.getBytes("ISO8859_1"), "UTF-8");
                        //                      System.out.println("=========="+reqvalue);
                        //                      String reqvalue1 = new String(reqvalue.getBytes("ISO8859_1"),"utf-8");
                    }
                    catch (UnsupportedEncodingException e)
                    {
                        //log.info("com.apache.fileupload.reqvalue,getBytes(ISO8859_1)GBK "+e);
                        GooagooLog.info("字典表导入异常：com.apache.fileupload.reqvalue,getBytes(ISO8859_1)UTF-8" + e);
                    }
                    //proMap.put(reqname, reqvalue);
                }
                else
                {
                    fileItem.add(item);
                }
            }
            //fileCountsize=0; //文本大小
            inputItems.clear();
            for (int i = 0; i < fileItem.size(); i++)
            {
                FileItem file = null;
                file = (FileItem) fileItem.get(i);
                if (file != null)
                {
                    String filePath = file.getName(); //全路径文件名
                    String Name = filePath.replaceAll("\\\\", "/");
                    fileName.add(Name.substring(Name.lastIndexOf("/") + 1));
                    //contentType.add(file.getContentType()); //文本类型
                    String sizeInBytes = String.valueOf(file.getSize() / 1024);
                    //filesize.add(sizeInBytes);//文件大小
                    //fileCountsize+=file.getSize()/1024;
                    //if (filePath != null &&!filePath.equals(""))
                    //    Count++; // 记录文件个数
                }
            }
        }
        return fileName;
    }

    /**
     * 将导入文件存入指定目录
     * @param filepath 指定的目录
     * @return
     * @throws Exception
     */
    public static File saveAs(String filepath, String fileName) throws Exception
    {
        String path = new String();
        path = getPhysicalPath(filepath);
        if (path == null)
        {
            throw new IllegalArgumentException("没有指定的目标文件  (1140).");
        }
        File uploadedFile = new File(path + "/" + fileName);
        try
        {
            FileItem file = null;
            file = (FileItem) fileItem.get(0);
            file.write(uploadedFile);
            return uploadedFile;
        }
        catch (Exception e)
        {
            GooagooLog.info("字典表导入异常：com.apache.upload.saveAs " + e);
        }
        return null;
    }

    /**
     * 获取文件路径
     * @param filePathName
     * @return
     * @throws Exception
     */
    private static String getPhysicalPath(String filePathName) throws Exception
    {
        String path = new String();
        String fileName = new String();
        String fileSeparator = new String();
        boolean isPhysical = false;
        fileSeparator = System.getProperty("file.separator");
        if (filePathName == null || filePathName.equals(""))
        {
            throw new IllegalArgumentException("没有指定的目标文件 (1140).");
        }
        if (filePathName.lastIndexOf("\\") >= 0)
        {
            path = filePathName.substring(0, filePathName.lastIndexOf("\\"));
            fileName = filePathName.substring(filePathName.lastIndexOf("\\") + 1);
        }
        if (filePathName.lastIndexOf("/") >= 0)
        {
            path = filePathName.substring(0, filePathName.lastIndexOf("/"));
            fileName = filePathName.substring(filePathName.lastIndexOf("/") + 1);
        }
        path = path.length() != 0 ? path : "/";
        File physicalPath = new File(path);
        if (physicalPath.exists())
        {
            isPhysical = true;
        }
        if (isVirtual(path))
        {
            path = m_application.getRealPath(path);
            if (path.endsWith(fileSeparator))
            {
                path = path + fileName;
            }
            else
            {
                path = String.valueOf((new StringBuffer(String.valueOf(path))).append(fileSeparator).append(fileName));
            }
            return path;
        }
        if (isPhysical)
        {
            return filePathName;
        }
        else
        {
            throw new IllegalArgumentException("路径下的文件不存在 (1135).");
        }
    }

    /**
     * 判断路径是否有效
     * @param pathName
     * @return
     */
    private static boolean isVirtual(String pathName)
    {
        if (m_application.getRealPath(pathName) != null)
        {
            java.io.File virtualFile = new java.io.File(m_application.getRealPath(pathName));
            return virtualFile.exists();
        }
        else
        {
            return false;
        }
    }
}
