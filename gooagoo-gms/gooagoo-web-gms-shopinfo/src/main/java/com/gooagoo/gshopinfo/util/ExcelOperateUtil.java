package com.gooagoo.gshopinfo.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.gms.shopinfo.FShopPosition;

public class ExcelOperateUtil {

	/**
	 * 导入Excel
	 * 
	 * @param request
	 *            http请求
	 * @param filename上传文件属性名称
	 *            (type[name=filename])必填
	 * @return
	 * @throws Exception
	 */
	public static List<FShopPosition> reportImport(HttpServletRequest request, String filename) throws Exception {
		DefaultMultipartHttpServletRequest defaultRequest = (DefaultMultipartHttpServletRequest) request;
		MultiValueMap<String, MultipartFile> fileMap = defaultRequest.getMultiFileMap();
		List<MultipartFile> fileList = fileMap.get(filename);
		if (fileList.size() <= 0) {
			new GooagooException("未获取到请求信息");
		}
		MultipartFile file = fileList.get(0);
		InputStream inputStream = file.getInputStream();
		List<FShopPosition> excelInfo = getExcelInfo(inputStream, request);
		return excelInfo;
	}

	private static List<FShopPosition> getExcelInfo(InputStream inputStream, HttpServletRequest request) throws Exception {
		String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
		String shopId = GMSUtil.getShopIdByWeb(request);
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		List<String> parentList = new ArrayList<String>(0); // 用于记录父级节点
		List<FShopPosition> fShopPositions = new ArrayList<FShopPosition>(0); // 用于存放位置信息
		int numberOfSheets = workbook.getNumberOfSheets();
		FShopPosition fShopPosition = null;
		for (int i = 0; i < numberOfSheets; i++) {
			HSSFSheet sheet = workbook.getSheetAt(i);
			int lastRowNum = sheet.getLastRowNum();
			for (int j = 2; j < lastRowNum; j++) {
				HSSFRow row = sheet.getRow(j);
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String stringCellValue="";
					if(cell.getCellType()==Cell.CELL_TYPE_STRING || cell.getCellType()== Cell.CELL_TYPE_BLANK){
						stringCellValue = cell.getStringCellValue();
					}else{
						throw new Exception("数据类型错误！");
					}
					if(cell.getRowIndex() == 2 && cell.getColumnIndex()==0 && StringUtils.isBlank(stringCellValue) ){
						throw new Exception("文件格式错误！");
					}
					if (StringUtils.isNotEmpty(stringCellValue)) {
					  fShopPosition = new FShopPosition();
					  int columnIndex = cell.getColumnIndex();
					  String uuid = UUID.getUUID();
					  if(columnIndex==0){
						  parentList.clear();
						  parentList.add("-1");
						  parentList.add(uuid);
					  }else{
					     if(parentList.size()==(columnIndex+1)){
					       parentList.add(uuid);  
					     }
					  }
					  if(parentList.size()<(columnIndex+1)){
						  break;
					  }
					  fShopPosition.setPositionId(uuid);
					  fShopPosition.setPositionName(stringCellValue);
					  fShopPosition.setShopId(shopId);
					  fShopPosition.setShopEntityId(shopEntityId);
					  fShopPosition.setDescription("");
					  fShopPosition.setParentPositionId(parentList.get(columnIndex));
					  fShopPositions.add(fShopPosition);
					  break;
					}
				}
			}

		}
		
		return fShopPositions;
	}

}