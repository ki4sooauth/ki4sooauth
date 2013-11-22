<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
	request.setAttribute("topMenuCode", "13");
	request.setAttribute("leftMenuCode", "1304");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${shopVo.wordNames['gmsi024']}</title><!-- 地图管理 -->
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<script type="text/javascript">
	var imgPath="${imgPath}";
	var basePath = "${basePath}" ;
	var pIndex = "${page_cur}";
	$(function(){
		page(1);
	});
	//分页
	function page(index){
	 	if(isEmpty(index) || parseInt(index)<1){
			index = 1;
		}
		pIndex = index;
		var data = "&pageIndex="+index;
		ajaxToPageByData(basePath + "map.do?method=page","fileCont",data);
	}
	//编辑页面
	function formAreaMap(mapId){
		var methodName = "formU";
		if(isEmpty(mapId)){
			mapId = "";
			methodName = "formA";
		}
		var data = "&mapId=" + mapId;
		window.location.href = basePath + "map.do?method=" + methodName+data;
	}
</script>
</head>
<body>
	<!--头部-->
	<%@include file="/WEB-INF/jsp/common/head.jsp"%>
	<!--内容-->
	<div class="container">
		<div class="article">
			<%@include file="/WEB-INF/jsp/common/left.jsp"%>
			<div class="section">
				<div class="rightTitle_add">
					<check:hasAuthority authorityID="130401">
						<a href="javascript:void(0);" onclick="formAreaMap();">${shopVo.wordNames['gmsi002']}</a>
					</check:hasAuthority>
					<span>${ shopVo.wordNames['gmsi001']}</span>
				</div>
				<!-- 列表内容 -->
				<div id="fileCont">
				
				</div>
			</div>
		</div>
	</div>
</body>
</html>
