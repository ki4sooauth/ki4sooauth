<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${shopVo.wordNames['gmsj32']}</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
	request.setAttribute("topMenuCode", "18");
    request.setAttribute("top2MenuCode", "1802");
	request.setAttribute("leftMenuCode", "");
%>
<script type="text/javascript" src="${imgPath}/gms/resource/js/hisBidRecord.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	pageAllBidR(1);
})
</script>
</head>
<body>
	<!--以下是头部-->
	<%@ include file="/WEB-INF/jsp/common/head.jsp"%>
		<div class="col_1">
			<div class="tit">
				<h4>${shopVo.wordNames['gmsj32']}</h4>
			</div>
			<div class="recordTable">
				<div id="table_allHisBid" class="A">
					<%--所有竞拍记录--%>
				</div>
			</div>
		</div>
</body>
</html>