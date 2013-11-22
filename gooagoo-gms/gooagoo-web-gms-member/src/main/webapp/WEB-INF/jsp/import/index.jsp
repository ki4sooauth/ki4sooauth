<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript">
		var imgPath="${imgPath}";
		var basePath="${basePath}";
	</script>
	<%@include file="/WEB-INF/jsp/common/top.jsp"%>
	<link rel="stylesheet" type="text/css" href="${imgPath}/gms/member/css/member.css" charset="UTF-8" />
	<script type="text/javascript" src="${imgPath}/gms/member/js/import.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
	<div class="navigation">
		<a class="first" href="/shopinfo/index">首页</a>
		<a href="index">会员管理</a>
		<a class="end">物理卡转换审批</a>
	</div>
	<div class="Tab">
		<div class="Tab_content" id="content">
		<div class="Tab_buttom">
			<div class="Tab_buttom_n">
				<a href="${imgPath}/gms/member/file/importMemberInfo.xlsx">下载模板</a>
				<button type="button" class="Tab_buttom_n_2" onclick="chooseFile();">导入数据</button>
				<form id="importExcelForm" enctype="multipart/form-data" style="display: none;">
					<input type="file" name="importExcel" onchange="uploadExcel();">
				</form>
			</div>
			<p>注：模板格式为EXCEL文件格式，导入数据支持文件格式为EXCEL</p>
		</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>
</body>
</html>