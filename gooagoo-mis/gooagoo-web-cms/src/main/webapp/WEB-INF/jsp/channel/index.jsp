<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>栏目管理</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath }/cms/css/edit.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(function(){
		var winWidth=window.screen.availWidth-100;
		initFancyBox("fancybox_template", winWidth, "95%", true); 
	});
</script>
</head>
<body>
	<div style="display:none;">
		<a href="#" id="fancybox_template" class="fancybox_template"></a>
	</div>
	<!-- 头部 -->
	<%@ include file="/WEB-INF/jsp/common/head.jsp"%>
	<!-- 主体 -->
	<div class="middle_box">
		<div class="M_right" id="content" style="float: right;">
			<!-- 内容 -->	
			<iframe id="rightFrame" width="745px" height="760px">
			
			</iframe>
		</div>
		<!-- 左菜单 -->
		<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
	</div>
</body>
</html>