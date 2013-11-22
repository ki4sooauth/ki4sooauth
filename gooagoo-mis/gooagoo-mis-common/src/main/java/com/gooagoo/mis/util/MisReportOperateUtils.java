package com.gooagoo.mis.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.exception.GooagooException;
/**
 * 后台管理系统工具类
 * @author Administrator
 *
 */
public class MisReportOperateUtils
{

    /**
     * 导出Excel
     * @param request
     * @param response
     * @param lists 导出的数据集合
     * @param head Excel标题（必须与数据库以一一对应）
     * @param fileName 导出的文件名
     * @param tableName 导出文件的Sheet名
     * @throws Exception
     */
    public static <T> void reportExport(HttpServletRequest request, HttpServletResponse response, List<T> lists, String[] head, String fileName, String tableName) throws Exception
    {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(tableName);
        HSSFRow row = sheet.createRow((short) 0);
        int[] wordlength = new int[head.length];
        // 添加标题
        for (int i = 0; i < head.length; i++)
        {
            wordlength[i] = head[i].length();
            HSSFCell cel = row.createCell((short) i);
            cel.setCellType(HSSFCell.CELL_TYPE_STRING);
            cel.setCellValue(new HSSFRichTextString(head[i]));

        }
        for (int i = 0; i < lists.size(); i++)
        {
            HSSFRow rowi = sheet.createRow((short) i + 1);
            T t = lists.get(i);
            Class<?> objClass = t.getClass();
            Field[] fields = objClass.getDeclaredFields();
            int k = 0;
            for (int j = 0; j < fields.length; j++)
            {
                String name = fields[j].getName();
                if (!"serialVersionUID".equals(name))
                {
                    Field field = objClass.getDeclaredField(name);
                    field.setAccessible(true);
                    Object value = field.get(t);
                    Object type = fields[j].getType();
                    if (value != null && !"".equals(value) && ("class java.util.Date".equals(type.toString()) || "Date".equals(type.toString())))
                    {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String date = sdf.format((Date) value);
                        value = date;
                    }
                    HSSFCell cel = rowi.createCell((short) (j - k));
                    cel.setCellType(HSSFCell.CELL_TYPE_STRING);
                    String values = value == null ? "" : value.toString();
                    cel.setCellValue(new HSSFRichTextString(values));
                    if (wordlength[j - k] < (values.length()))
                    {
                        wordlength[j - k] = (values.length());
                    }
                    field.setAccessible(false);
                }
                else
                {
                    k++;
                }
            }
        }
        //根据字数设置列宽
        for (int i = 0; i < wordlength.length; i++)
        {
            sheet.setColumnWidth((short) i, (short) ((short) wordlength[i] * 2 * 256));
        }
        response.reset();// 清空输出流
        response.setContentType("application/octet-stream;charset=UTF-8");// 定义输出类型
        //火狐
        if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0)
        {
            fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
        }
        //IE
        else if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0)
        {
            fileName = URLEncoder.encode(fileName, "UTF-8");
        }
        response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");// 设定输出文件头
        OutputStream os;
        try
        {
            os = response.getOutputStream();
            workbook.write(os);
            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 导入Excel
     * @param request http请求
     * @param filename 上传文件属性名称(type[name=filename])必填
     * @param attributeName 实体类成员变量名称（必须与实体类属性名称大小写一致、必须与标题一一对应，只支持String、Date、Integer、Double）
     * @return
     * @throws Exception
     */
    public static List<Map<String, String>> reportImport(HttpServletRequest request, String filename, String[] attributeName) throws Exception
    {
        //        List fileList = MisReportUpload.uploadfile(request);
        //        if (fileList == null)
        //        {
        //            new GooagooException("字典导入-文件名不存在");
        //        }
        //        String fileName = (String) fileList.get(0);
        //
        //        File excelFile = MisReportUpload.saveAs("d:/global/EXCEL/", fileName);
        //        List<Map<String, String>> excelInfo = new ArrayList<Map<String,String>>();
        //        if (excelFile != null)
        //        {
        ////            String filePath = request.getSession().getServletContext().getRealPath("/") + "/global/EXCEL/" + fileName;
        //            excelInfo = getExcelInfo(excelFile, attributeName);
        //        }
        //        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //        MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
        DefaultMultipartHttpServletRequest defaultRequest = (DefaultMultipartHttpServletRequest) request;
        MultiValueMap<String, MultipartFile> fileMap = defaultRequest.getMultiFileMap();
        List<MultipartFile> fileList = fileMap.get(filename);
        if (fileList.size() <= 0)
        {
            new GooagooException("未获取到请求信息");
        }
        MultipartFile file = fileList.get(0);
        InputStream inputStream = file.getInputStream();
        List<Map<String, String>> excelInfo = getExcelInfo(inputStream, file.getOriginalFilename(), attributeName);
        return excelInfo;
    }

    /**
     * 获取批导的excel信息
     * @param inputStream 导入的文件流
     * @param excelName 文件名（包含扩展名）
     * @param attributeName 实体类成员变量名称（必须与实体类属性名称大小写一致、必须与标题一一对应，只支持String、Date、Integer、Double）
     * @return
     */
    @SuppressWarnings("static-access")
    private static List<Map<String, String>> getExcelInfo(InputStream inputStream, String excelName, String[] attributeName)
    //    private static List<Map<String, String>> getExcelInfo(File excelFile, String[] attributeName)
    {
        List<Map<String, String>> excelInfo = new ArrayList<Map<String, String>>();
        InputStream in = null;
        //DecimalFormat df = new DecimalFormat("#0.00");
        String[] excelFileType = excelName.split("\\.");
        //        String[] excelFileType = excelFile.getName().split("\\.");
        String excelType = excelFileType[excelFileType.length - 1];// 获取文件的扩展名
        int sheetNumLog = 0;
        int rowNumLog = 0;
        int colNumLog = 0;

        try
        {
            in = inputStream;
            //            in = new FileInputStream(excelFile);
            if (excelType.equalsIgnoreCase("xls"))
            {
                HSSFWorkbook workbook = new HSSFWorkbook(in);
                int sheetNum = workbook.getNumberOfSheets(); //得到sheet的数量
                for (int i = 0; i < sheetNum; i++)
                {
                    sheetNumLog = i + 1; //记录该次循环读取的sheet数
                    int cellNum = 0; //每行列总数
                    rowNumLog = 0;
                    int index = 0; //行循环下标
                    HSSFSheet sheet = workbook.getSheetAt(i);

                    //第一个循环获得每行需要读取的列数
                    for (int j = 0; j <= sheet.getLastRowNum(); j++)
                    {
                        HSSFRow firstRow = sheet.getRow(j);
                        if (firstRow != null)
                        {
                            cellNum = firstRow.getPhysicalNumberOfCells();
                            index = j + 1;
                            break;
                        }
                        else
                        {
                            continue;
                        }
                    }

                    //开始读取每行每列的信息
                    for (int j = index; j <= sheet.getLastRowNum(); j++)
                    {
                        rowNumLog = j + 1; //记录该次循环读取的sheet页的第几行
                        colNumLog = 0;
                        HSSFRow row = sheet.getRow(j);
                        Map<String, String> rowValuesMap = new HashMap<String, String>(); //存储每一行的所有值
                        boolean hasError = false; //判断获取列值时是否发生错误
                        String errorMessage = ""; //错误信息
                        if (row != null)
                        {
                            for (int k = 0; k < cellNum; k++)
                            {
                                colNumLog = k + 1; //记录该次循环读取的sheet页第几行的第几列
                                HSSFCell cell = row.getCell((short) k);
                                String cellValue = "";
                                //String colStr = (k + 1) < 10 ? "0" + (k + 1) : (k + 1) + "";//获取行号
                                if (cell != null)
                                {
                                    try
                                    {
                                        int cellType = cell.getCellType();
                                        if (cellType == cell.CELL_TYPE_NUMERIC)
                                        {
                                            if (HSSFDateUtil.isCellDateFormatted(cell))
                                            {// 处理日期格式、时间格式  
                                                SimpleDateFormat sdf = null;
                                                short fromat = cell.getCellStyle().getDataFormat();
                                                if (fromat == 20 || fromat == 32)
                                                {
                                                    sdf = new SimpleDateFormat("HH:mm");
                                                }
                                                else if (fromat == 14 || fromat == 31 || fromat == 57 || fromat == 58)
                                                {// 日期  
                                                    sdf = new SimpleDateFormat("yyyy-MM-dd");
                                                }
                                                else
                                                {
                                                    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                                }
                                                Date date = cell.getDateCellValue();
                                                cellValue = sdf.format(date);
                                            }
                                            else
                                            {
                                                double value = cell.getNumericCellValue();
                                                HSSFCellStyle style = cell.getCellStyle();
                                                DecimalFormat format = new DecimalFormat();
                                                String temp = style.getDataFormatString();
                                                // 单元格设置成常规  
                                                if (temp.equals("General"))
                                                {
                                                    format.applyPattern("#");
                                                }
                                                cellValue = format.format(value);
                                            }
                                        }
                                        else if (cellType == cell.CELL_TYPE_STRING)
                                        {
                                            cellValue = cell.toString();
                                        }
                                    }
                                    catch (Exception e)
                                    {
                                        hasError = true;
                                        errorMessage = e.getMessage();
                                        break;
                                    }

                                }
                                rowValuesMap.put(attributeName[k], cellValue.trim());
                            }
                        }
                        if (hasError)
                        {
                            GooagooLog.info("读取EXCEL中,第" + sheetNumLog + "工作区第" + rowNumLog + "行第" + colNumLog + "列数据发生格式错误(" + errorMessage + ")");
                        }
                        else
                        {
                            rowValuesMap.put("sheetNum", String.valueOf(sheetNumLog));
                            rowValuesMap.put("rowNum", String.valueOf(rowNumLog));
                            excelInfo.add(rowValuesMap);
                            GooagooLog.info("正常读取EXCEL中第" + sheetNumLog + "工作区第" + rowNumLog + "行数据");
                        }
                    }
                }
            }
            /*
             * 目前maven官方poi-3.1版本不支持xlsx
            else if(excelType.equalsIgnoreCase("xlsx")) {
                XSSFWorkbook workbook = new XSSFWorkbook(in);
                int sheetNum = workbook.getNumberOfSheets(); //得到sheet的数量
                for(int i=0; i<sheetNum; i++) {
                    sheetNumLog = i+1; //记录该次循环读取的sheet数
                    int cellNum = 0; //每行列总数
                    rowNumLog = 0;
                    //colNumLog = 0;
                    int index = 0; //行循环下标
                    XSSFSheet sheet = workbook.getSheetAt(i);
                    
                    //第一个循环获得每行需要读取的列数
                    for(int j=0; j<=sheet.getLastRowNum(); j++) {
                        XSSFRow firstRow = sheet.getRow(j);
                        if(firstRow != null) {
                            cellNum = firstRow.getPhysicalNumberOfCells();
                            index = j+1;
                            break;
                        }else {
                            continue;
                        }
                    }
                    
                    //开始读取每行每列的信息
                    for(int j=index; j<=sheet.getLastRowNum(); j++) {
                        rowNumLog = j+1; //记录该次循环读取的sheet页的第几行
                        colNumLog = 0;
                        XSSFRow row = sheet.getRow(j);
                        Map<String, String> rowValuesMap = new HashMap<String, String>(); //存储每一行的所有值
                        boolean hasError = false; //判断获取列值时是否发生错误
                        String errorMessage = ""; //错误信息
                        if(row != null) {
                            for(int k=0; k<cellNum; k++) {
                                colNumLog = k+1; //记录该次循环读取的sheet页第几行的第几列
                                XSSFCell cell = row.getCell(k);
                                String cellValue = "";
                                String colStr = (k+1)<10?"0"+(k+1):(k+1)+"";
                                if(cell != null) {
                                    try {
                                        int cellType = cell.getCellType();
                                        if(numType.contains(colStr)) {
                                            if(cellType != cell.CELL_TYPE_BLANK) {
                                                cellValue = df.format(NumberHelper.string2Double(cell.getNumericCellValue(), 0.00));
                                            }else {
                                                cellValue = "0.00";
                                            }
                                        }else if(dateType.contains(colStr)) {
                                            if(cellType == cell.CELL_TYPE_STRING) {
                                                cellValue = cell.toString();
                                            }else if(cellType != cell.CELL_TYPE_BLANK) {
                                                Date cellDate = cell.getDateCellValue();
                                                cellValue = (cellDate.getYear()+1900)+"-"+(cellDate.getMonth()+1)+"-"+cellDate.getDate();
                                            }
                                        }else {
                                            if(cellType == cell.CELL_TYPE_NUMERIC) {
                                                long cellv = (long)cell.getNumericCellValue();
                                                cellValue = String.valueOf(cellv);
                                            }else if(cellType == cell.CELL_TYPE_STRING) {
                                                cellValue = cell.toString();
                                            }
                                        }
                                    }catch (Exception e) {
                                        hasError = true;
                                        errorMessage = e.getMessage();
                                        break;
                                    }
                                }else {
                                    if(numType.contains(colStr)) {
                                        cellValue = "0.00";
                                    }
                                }
                                rowValuesMap.put("col"+(k+1), cellValue.trim());
                            }
                        }
                        if(hasError) {
                            this.readingError = true;
                            this.readExcelLog.add("<font color=\"red\">读取EXCEL中,第"+sheetNumLog+"工作区第"+rowNumLog+"行第"+colNumLog+"列数据发生格式错误("+errorMessage+")</font>");
                        }else {
                            rowValuesMap.put("sheetNum", String.valueOf(sheetNumLog));
                            rowValuesMap.put("rowNum", String.valueOf(rowNumLog));
                            excelInfo.add(rowValuesMap);
                            this.readExcelLog.add("<font color=\"green\">正常读取EXCEL中第"+sheetNumLog+"工作区第"+rowNumLog+"行数据</font>");
                        }
                    }
                }
                this.readEnding = true;
            }*/

        }
        catch (Exception ex)
        {
            GooagooLog.info("获取EXCEL文件实体时发生异常");
            ex.printStackTrace();
        }
        finally
        {
            if (in != null)
            {
                try
                {
                    in.close();
                }
                catch (Exception e)
                {
                    GooagooLog.info("关闭流发生异常");
                }
            }
        }
        return excelInfo;
    }
}
