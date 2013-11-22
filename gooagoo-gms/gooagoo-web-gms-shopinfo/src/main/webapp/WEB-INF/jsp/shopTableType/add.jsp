<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${imgPath}/gms/shopinfo/js/shopTableType.js"></script>
<script type="text/javascript">
var basePath="${basePath}";
 $(document).ready(function(){
	 initValidate('addDo');
 })
</script>
</head>
<body>
	<form name="userForm" id="userForm">
		<div class="section">
			<div class="rightTitle_add title_d">
				<span>添加餐桌类型</span>
			</div>
		</div>
		<ul class="desk-num-poup">
				<div  ${not empty gmsLoginInfo.userShopEntityId?'style="display: none"':'style="display: block"'}>
				<li><span>${shopVo.wordNames['gmsg144']}</span>&nbsp;
				 <select class="borderStyle select"  id="shopEntityId" name="shopEntityId">
				   <option value="">${shopVo.wordNames['gmsg134']}</option>
				   <c:forEach items="${entityList}" var="entity">
				   <option  value="${entity.shopEntityId}">${entity.shopEntityName}</option>
				   </c:forEach>
				 </select>
				 </li>
				 </div>
			<li><span>类型名称</span>&nbsp;<input class="borderStyle text"
				type="text" name="tableTypeName"  maxlength="50" /></li>
			<li><span>最小人数</span>&nbsp;<input class="borderStyle text"
				type="text" name="minNums" 
				maxlength="50" /></li>
			<li><span>最大人数</span>&nbsp;<input class="borderStyle text"
				type="text" name="maxNums" 
				maxlength="50" /></li>
			<check:hasAuthority authorityID="150401">
				<li class="commitBtn"><input type="submit" id="idDisable"
					class="inputBtn blueBtn" value="${shopVo.wordNames['gmsg149']}"></li>
			</check:hasAuthority>
		</ul>
	</form>
</body>
</html>
