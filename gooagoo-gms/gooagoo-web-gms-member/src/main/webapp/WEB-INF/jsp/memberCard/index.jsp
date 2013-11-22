<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
	request.setAttribute("topMenuCode", "24");
	request.setAttribute("leftMenuCode", "2401");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['cpme001']}</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%> 
<script type="text/javascript">
	var imgPath = "${imgPath}";
	var basePath = "${basePath}";

	$(function(){
		var data = "";
		ajaxToPageByData(basePath + "memberCard.do?method=list", "page_content",data);
	});
	function closeCheckFancyBox(){
		closeFancyBox();
		window.location.href = basePath + "memberCard.do?method=index";
	}
</script>
</head>
<body>
	<!--头部-->
	<%@ include file="/WEB-INF/jsp/common/head.jsp"%>
	<!--内容-->
    <div class="container">
      	<div class="article">
			<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
       	 	<div class="section">
          		<div class="rightTitle_add">
            		<a href="memberCard.do?method=create">${shopVo.wordNames['cpme008']}</a>
            		<span>${shopVo.wordNames['cpme007']}</span>
          		</div>
          		<div class="memberList" id="page_content">
				</div>
			</div>
		</div>
	</div>
	<!--用户状态-->
 	<%@ include file="/WEB-INF/jsp/common/right.jsp"%>
</body>
</html>

