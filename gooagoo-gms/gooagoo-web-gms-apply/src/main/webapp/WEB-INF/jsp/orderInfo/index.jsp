<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
	request.setAttribute("topMenuCode", "17");
	request.setAttribute("leftMenuCode", "1701");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>订单管理</title>
<script type="text/javascript" src="${imgPath}/gms/apply/js/applyOrder.js"></script>
<link href="${imgPath}/gms/apply/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<%-- <link href="${imgPath}/gms/apply/css/BTopBottom.css" rel="stylesheet" type="text/css" /> --%>
<script type="text/javascript">
	var basePath="${basePath}";
	$(document).ready(function(){
		initFancyBox("fancybox_em",600,550,true);
		page("1");
	})
</script>
<style type="text/css">
	.desk-num-poup li .text {height:20px;line-height:20px;}
	.desk-num-poup li .select {height: 20px; line-height: 20px; width: 110px;}
</style>
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
	            	<span>订单</span>
	          	</div>
	          	<div>
		          	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="background-color: #CCCCCC; color: #666666;">
			          	<tr>
				          	<td style="background-color: #F8F7F7;">
							    <ul class="desk-num-poup" style="width:100%; padding: 20px;">
									<li style="padding: 0px;">
										<div ${not empty gmsLoginInfo.shopEntityId?'style="display: none"':'style="display: block"'}>
											<span>实体店</span>
										   	<select class="borderStyle select" id="shopEntityId" name="shopEntityId" style="margin-right:20px;">
										   		<option value="">${shopVo.wordNames['gmsg134']}</option>
										   		<c:forEach items="${entityList}" var="entity">
									   				<option value="${entity.shopEntityId}">${entity.shopEntityName}</option>
										   		</c:forEach>
										 	</select>
										</div>
										<span style="margin-left: 10px">会员卡号</span>
										<input type="text" name="scardNo" id="scardNo" class="borderStyle text" id="lid" value=""/>
										<a href="javascript:void(0);" onclick="page(1)" class="inputBtn blueBtn" style="width: 80px; height: 20px; line-height:20px; margin-left:20px;">${shopVo.wordNames['gmsg230']}</a>
									</li>
								</ul>
				          	</td>
			          	</tr>
		          	</table>
	          	</div>
          		<div id="userList"></div>
			</div>
			<div style="display: none;">
			  	<a class="fancybox_em" id="emFancybox"></a>
			</div>
		</div>
	</div>
</body>
</html>
